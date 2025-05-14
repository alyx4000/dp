package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.Token;
import java.io.IOException;
import java.io.Reader;

/* loaded from: classes2.dex */
class TokenStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final char BYTE_ORDER_MARK = 65279;
    private static final int EOF_CHAR = -1;
    Token.CommentType commentType;
    int cursor;
    private boolean dirtyLine;
    private boolean isBinary;
    private boolean isHex;
    private boolean isOctal;
    private boolean isOldOctal;
    int lineno;
    private double number;
    private Parser parser;
    private int quoteChar;
    String regExpFlags;
    private char[] sourceBuffer;
    int sourceCursor;
    private int sourceEnd;
    private Reader sourceReader;
    private String sourceString;
    private int stringBufferTop;
    int tokenBeg;
    int tokenEnd;
    private int ungetCursor;
    private boolean xmlIsAttribute;
    private boolean xmlIsTagContent;
    private int xmlOpenTagsCount;
    private String string = "";
    private char[] stringBuffer = new char[128];
    private ObjToIntMap allStrings = new ObjToIntMap(50);
    private final int[] ungetBuffer = new int[3];
    private boolean hitEOF = false;
    private int lineStart = 0;
    private int lineEndChar = -1;
    private String commentPrefix = "";
    private int commentCursor = -1;

    TokenStream(Parser parser, Reader reader, String str, int i) {
        this.parser = parser;
        this.lineno = i;
        if (reader != null) {
            if (str != null) {
                Kit.codeBug();
            }
            this.sourceReader = reader;
            this.sourceBuffer = new char[512];
            this.sourceEnd = 0;
        } else {
            if (str == null) {
                Kit.codeBug();
            }
            this.sourceString = str;
            this.sourceEnd = str.length();
        }
        this.cursor = 0;
        this.sourceCursor = 0;
    }

    private void addToString(int i) {
        int i2 = this.stringBufferTop;
        char[] cArr = this.stringBuffer;
        if (i2 == cArr.length) {
            char[] cArr2 = new char[cArr.length * 2];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.stringBuffer = cArr2;
        }
        this.stringBuffer[i2] = (char) i;
        this.stringBufferTop = i2 + 1;
    }

    private boolean canUngetChar() {
        int i = this.ungetCursor;
        return i == 0 || this.ungetBuffer[i - 1] != 10;
    }

    private final int charAt(int i) {
        if (i < 0) {
            return -1;
        }
        String str = this.sourceString;
        if (str != null) {
            if (i >= this.sourceEnd) {
                return -1;
            }
            return str.charAt(i);
        }
        if (i >= this.sourceEnd) {
            int i2 = this.sourceCursor;
            try {
                if (!fillSourceBuffer()) {
                    return -1;
                }
                i -= i2 - this.sourceCursor;
            } catch (IOException unused) {
                return -1;
            }
        }
        return this.sourceBuffer[i];
    }

    private static String convertLastCharToHex(String str) {
        int length = str.length() - 1;
        StringBuilder sb = new StringBuilder(str.substring(0, length));
        sb.append("\\u");
        String hexString = Integer.toHexString(str.charAt(length));
        for (int i = 0; i < 4 - hexString.length(); i++) {
            sb.append('0');
        }
        sb.append(hexString);
        return sb.toString();
    }

    private boolean fillSourceBuffer() {
        if (this.sourceString != null) {
            Kit.codeBug();
        }
        if (this.sourceEnd == this.sourceBuffer.length) {
            if (this.lineStart == 0 || isMarkingComment()) {
                char[] cArr = this.sourceBuffer;
                char[] cArr2 = new char[cArr.length * 2];
                System.arraycopy(cArr, 0, cArr2, 0, this.sourceEnd);
                this.sourceBuffer = cArr2;
            } else {
                char[] cArr3 = this.sourceBuffer;
                int i = this.lineStart;
                System.arraycopy(cArr3, i, cArr3, 0, this.sourceEnd - i);
                int i2 = this.sourceEnd;
                int i3 = this.lineStart;
                this.sourceEnd = i2 - i3;
                this.sourceCursor -= i3;
                this.lineStart = 0;
            }
        }
        Reader reader = this.sourceReader;
        char[] cArr4 = this.sourceBuffer;
        int i4 = this.sourceEnd;
        int read = reader.read(cArr4, i4, cArr4.length - i4);
        if (read < 0) {
            return false;
        }
        this.sourceEnd += read;
        return true;
    }

    private int getChar() {
        return getChar(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
    
        r5.lineEndChar = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        return 10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int getCharIgnoreLineEnd() {
        /*
            r5 = this;
            int r0 = r5.ungetCursor
            r1 = 1
            if (r0 == 0) goto L12
            int r2 = r5.cursor
            int r2 = r2 + r1
            r5.cursor = r2
            int[] r2 = r5.ungetBuffer
            int r0 = r0 - r1
            r5.ungetCursor = r0
            r0 = r2[r0]
            return r0
        L12:
            java.lang.String r0 = r5.sourceString
            r2 = -1
            if (r0 == 0) goto L2e
            int r3 = r5.sourceCursor
            int r4 = r5.sourceEnd
            if (r3 != r4) goto L20
            r5.hitEOF = r1
            return r2
        L20:
            int r2 = r5.cursor
            int r2 = r2 + r1
            r5.cursor = r2
            int r2 = r3 + 1
            r5.sourceCursor = r2
            char r0 = r0.charAt(r3)
            goto L4c
        L2e:
            int r0 = r5.sourceCursor
            int r3 = r5.sourceEnd
            if (r0 != r3) goto L3d
            boolean r0 = r5.fillSourceBuffer()
            if (r0 != 0) goto L3d
            r5.hitEOF = r1
            return r2
        L3d:
            int r0 = r5.cursor
            int r0 = r0 + r1
            r5.cursor = r0
            char[] r0 = r5.sourceBuffer
            int r2 = r5.sourceCursor
            int r3 = r2 + 1
            r5.sourceCursor = r3
            char r0 = r0[r2]
        L4c:
            r2 = 127(0x7f, float:1.78E-43)
            r3 = 10
            if (r0 > r2) goto L59
            if (r0 == r3) goto L6c
            r1 = 13
            if (r0 != r1) goto L6f
            goto L6c
        L59:
            r2 = 65279(0xfeff, float:9.1475E-41)
            if (r0 != r2) goto L5f
            return r0
        L5f:
            boolean r2 = isJSFormatChar(r0)
            if (r2 == 0) goto L66
            goto L12
        L66:
            boolean r1 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.isJSLineTerminator(r0)
            if (r1 == 0) goto L6f
        L6c:
            r5.lineEndChar = r0
            r0 = r3
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.getCharIgnoreLineEnd():int");
    }

    private String getStringFromBuffer() {
        this.tokenEnd = this.cursor;
        return new String(this.stringBuffer, 0, this.stringBufferTop);
    }

    private static boolean isAlpha(int i) {
        return i <= 90 ? 65 <= i : 97 <= i && i <= 122;
    }

    static boolean isDigit(int i) {
        return 48 <= i && i <= 57;
    }

    private static boolean isJSFormatChar(int i) {
        return i > 127 && Character.getType((char) i) == 16;
    }

    static boolean isJSSpace(int i) {
        return i <= 127 ? i == 32 || i == 9 || i == 12 || i == 11 : i == 160 || i == 65279 || Character.getType((char) i) == 12;
    }

    static boolean isKeyword(String str, int i, boolean z) {
        return stringToKeyword(str, i, z) != 0;
    }

    private boolean isMarkingComment() {
        return this.commentCursor != -1;
    }

    private void markCommentStart() {
        markCommentStart("");
    }

    private boolean matchChar(int i) {
        int charIgnoreLineEnd = getCharIgnoreLineEnd();
        if (charIgnoreLineEnd == i) {
            this.tokenEnd = this.cursor;
            return true;
        }
        ungetCharIgnoreLineEnd(charIgnoreLineEnd);
        return false;
    }

    private int peekChar() {
        int i = getChar();
        ungetChar(i);
        return i;
    }

    private boolean readCDATA() {
        while (true) {
            int i = getChar();
            while (i != -1) {
                addToString(i);
                if (i == 93 && peekChar() == 93) {
                    i = getChar();
                    addToString(i);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        return true;
                    }
                }
            }
            this.stringBufferTop = 0;
            this.string = null;
            this.parser.addError("msg.XML.bad.form");
            return false;
        }
    }

    private boolean readEntity() {
        int i = getChar();
        int i2 = 1;
        while (i != -1) {
            addToString(i);
            if (i == 60) {
                i2++;
            } else if (i == 62 && i2 - 1 == 0) {
                return true;
            }
            i = getChar();
        }
        this.stringBufferTop = 0;
        this.string = null;
        this.parser.addError("msg.XML.bad.form");
        return false;
    }

    private boolean readPI() {
        while (true) {
            int i = getChar();
            if (i == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i);
            if (i == 63 && peekChar() == 62) {
                addToString(getChar());
                return true;
            }
        }
    }

    private boolean readQuotedString(int i) {
        int i2;
        do {
            i2 = getChar();
            if (i2 == -1) {
                this.stringBufferTop = 0;
                this.string = null;
                this.parser.addError("msg.XML.bad.form");
                return false;
            }
            addToString(i2);
        } while (i2 != i);
        return true;
    }

    private boolean readXmlComment() {
        while (true) {
            int i = getChar();
            while (i != -1) {
                addToString(i);
                if (i == 45 && peekChar() == 45) {
                    i = getChar();
                    addToString(i);
                    if (peekChar() == 62) {
                        addToString(getChar());
                        return true;
                    }
                }
            }
            this.stringBufferTop = 0;
            this.string = null;
            this.parser.addError("msg.XML.bad.form");
            return false;
        }
    }

    private void skipLine() {
        int i;
        do {
            i = getChar();
            if (i == -1) {
                break;
            }
        } while (i != 10);
        ungetChar(i);
        this.tokenEnd = this.cursor;
    }

    private static int stringToKeyword(String str, int i, boolean z) {
        return i < 200 ? stringToKeywordForJS(str) : stringToKeywordForES(str, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01a6, code lost:
    
        if (r16.charAt(1) == 'l') goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0078, code lost:
    
        if (r1 != 'x') goto L186;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x026c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int stringToKeywordForES(java.lang.String r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 668
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.stringToKeywordForES(java.lang.String, boolean):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0204, code lost:
    
        if (r16.charAt(1) == 'n') goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02a0, code lost:
    
        r6 = 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x021b, code lost:
    
        if (r16.charAt(1) == 'a') goto L219;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02d7, code lost:
    
        r6 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x022d, code lost:
    
        if (r16.charAt(1) == 'h') goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x029e, code lost:
    
        if (r16.charAt(1) == 'n') goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02d5, code lost:
    
        if (r16.charAt(0) == 'd') goto L219;
     */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x02dd A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int stringToKeywordForJS(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 794
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.stringToKeywordForJS(java.lang.String):int");
    }

    private final String substring(int i, int i2) {
        String str = this.sourceString;
        if (str != null) {
            return str.substring(i, i2);
        }
        return new String(this.sourceBuffer, i, i2 - i);
    }

    private void ungetChar(int i) {
        int i2 = this.ungetCursor;
        if (i2 != 0 && this.ungetBuffer[i2 - 1] == 10) {
            Kit.codeBug();
        }
        int[] iArr = this.ungetBuffer;
        int i3 = this.ungetCursor;
        this.ungetCursor = i3 + 1;
        iArr[i3] = i;
        this.cursor--;
    }

    private void ungetCharIgnoreLineEnd(int i) {
        int[] iArr = this.ungetBuffer;
        int i2 = this.ungetCursor;
        this.ungetCursor = i2 + 1;
        iArr[i2] = i;
        this.cursor--;
    }

    final boolean eof() {
        return this.hitEOF;
    }

    final String getAndResetCurrentComment() {
        if (this.sourceString != null) {
            if (isMarkingComment()) {
                Kit.codeBug();
            }
            return this.sourceString.substring(this.tokenBeg, this.tokenEnd);
        }
        if (!isMarkingComment()) {
            Kit.codeBug();
        }
        StringBuilder sb = new StringBuilder(this.commentPrefix);
        sb.append(this.sourceBuffer, this.commentCursor, getTokenLength() - this.commentPrefix.length());
        this.commentCursor = -1;
        return sb.toString();
    }

    public Token.CommentType getCommentType() {
        return this.commentType;
    }

    public int getCursor() {
        return this.cursor;
    }

    int getFirstXMLToken() {
        this.xmlOpenTagsCount = 0;
        this.xmlIsAttribute = false;
        this.xmlIsTagContent = false;
        if (!canUngetChar()) {
            return -1;
        }
        ungetChar(60);
        return getNextXMLToken();
    }

    final String getLine() {
        int i;
        int i2 = this.sourceCursor;
        int i3 = this.lineEndChar;
        if (i3 >= 0) {
            i = i2 - 1;
            if (i3 == 10 && charAt(i - 1) == 13) {
                i--;
            }
        } else {
            int i4 = i2 - this.lineStart;
            while (true) {
                int charAt = charAt(this.lineStart + i4);
                if (charAt == -1 || ScriptRuntime.isJSLineTerminator(charAt)) {
                    break;
                }
                i4++;
            }
            i = i4 + this.lineStart;
        }
        return substring(this.lineStart, i);
    }

    final int getLineno() {
        return this.lineno;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d0, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x004c, code lost:
    
        ungetChar(r1);
        r10.string = getStringFromBuffer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0055, code lost:
    
        return 146;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int getNextXMLToken() {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.getNextXMLToken():int");
    }

    final double getNumber() {
        return this.number;
    }

    final int getOffset() {
        int i = this.sourceCursor - this.lineStart;
        return this.lineEndChar >= 0 ? i - 1 : i;
    }

    final char getQuoteChar() {
        return (char) this.quoteChar;
    }

    final String getSourceString() {
        return this.sourceString;
    }

    final String getString() {
        return this.string;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bd, code lost:
    
        if (r1 != false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00bf, code lost:
    
        r1 = stringToKeyword(r2, r16.parser.compilerEnv.getLanguageVersion(), r16.parser.inUseStrictDirective());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d1, code lost:
    
        if (r1 == 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d5, code lost:
    
        if (r1 == 154) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d9, code lost:
    
        if (r1 != 73) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f3, code lost:
    
        r16.string = (java.lang.String) r16.allStrings.intern(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ff, code lost:
    
        if (r1 == 128) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0101, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010c, code lost:
    
        if (r16.parser.compilerEnv.getLanguageVersion() < 200) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x010e, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0117, code lost:
    
        if (r16.parser.compilerEnv.isReservedKeywordAsIdentifier() != false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0119, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e5, code lost:
    
        if (r16.parser.compilerEnv.getLanguageVersion() >= 170) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e9, code lost:
    
        if (r1 != 154) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00eb, code lost:
    
        r1 = "let";
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f0, code lost:
    
        r16.string = r1;
        r1 = 39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ee, code lost:
    
        r1 = "yield";
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0132, code lost:
    
        r16.string = (java.lang.String) r16.allStrings.intern(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x013c, code lost:
    
        return 39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x012c, code lost:
    
        if (isKeyword(r2, r16.parser.compilerEnv.getLanguageVersion(), r16.parser.inUseStrictDirective()) == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x012e, code lost:
    
        r2 = convertLastCharToHex(r2);
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:318:0x03a5. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:194:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x01d3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x04cc A[LOOP:7: B:385:0x04cc->B:387:0x04d2, LOOP_START, PHI: r1 r10
  0x04cc: PHI (r1v29 int) = (r1v5 int), (r1v30 int) binds: [B:384:0x04ca, B:387:0x04d2] A[DONT_GENERATE, DONT_INLINE]
  0x04cc: PHI (r10v16 boolean) = (r10v3 boolean), (r10v17 boolean) binds: [B:384:0x04ca, B:387:0x04d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:405:0x053a A[LOOP:8: B:405:0x053a->B:408:?, LOOP_START, PHI: r1
  0x053a: PHI (r1v26 int) = (r1v10 int), (r1v27 int) binds: [B:404:0x0538, B:408:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:419:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0571 A[LOOP:9: B:421:0x0571->B:424:?, LOOP_START, PHI: r1
  0x0571: PHI (r1v22 int) = (r1v21 int), (r1v23 int) binds: [B:418:0x0567, B:424:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:437:0x04db A[ADDED_TO_REGION, LOOP:10: B:437:0x04db->B:450:0x050f, LOOP_START, PHI: r1 r8 r10
  0x04db: PHI (r1v6 int) = (r1v5 int), (r1v8 int) binds: [B:384:0x04ca, B:450:0x050f] A[DONT_GENERATE, DONT_INLINE]
  0x04db: PHI (r8v9 int) = (r8v8 int), (r8v10 int) binds: [B:384:0x04ca, B:450:0x050f] A[DONT_GENERATE, DONT_INLINE]
  0x04db: PHI (r10v4 boolean) = (r10v3 boolean), (r10v6 boolean) binds: [B:384:0x04ca, B:450:0x050f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:206:0x01e2 -> B:200:0x01c6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int getToken() {
        /*
            Method dump skipped, instructions count: 1498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.getToken():int");
    }

    public int getTokenBeg() {
        return this.tokenBeg;
    }

    public int getTokenEnd() {
        return this.tokenEnd;
    }

    public int getTokenLength() {
        return this.tokenEnd - this.tokenBeg;
    }

    final boolean isNumberBinary() {
        return this.isBinary;
    }

    final boolean isNumberHex() {
        return this.isHex;
    }

    final boolean isNumberOctal() {
        return this.isOctal;
    }

    final boolean isNumberOldOctal() {
        return this.isOldOctal;
    }

    boolean isXMLAttribute() {
        return this.xmlIsAttribute;
    }

    String readAndClearRegExpFlags() {
        String str = this.regExpFlags;
        this.regExpFlags = null;
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b1, code lost:
    
        ungetChar(r2);
        r8.tokenEnd = r8.cursor - 1;
        r8.string = new java.lang.String(r8.stringBuffer, 0, r8.stringBufferTop);
        r8.parser.reportError("msg.unterminated.re.lit");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void readRegExp(int r9) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.TokenStream.readRegExp(int):void");
    }

    String tokenToString(int i) {
        return "";
    }

    private int getChar(boolean z) {
        char c;
        int i = this.ungetCursor;
        if (i != 0) {
            this.cursor++;
            int[] iArr = this.ungetBuffer;
            int i2 = i - 1;
            this.ungetCursor = i2;
            return iArr[i2];
        }
        while (true) {
            String str = this.sourceString;
            if (str != null) {
                int i3 = this.sourceCursor;
                if (i3 == this.sourceEnd) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                this.sourceCursor = i3 + 1;
                c = str.charAt(i3);
            } else {
                if (this.sourceCursor == this.sourceEnd && !fillSourceBuffer()) {
                    this.hitEOF = true;
                    return -1;
                }
                this.cursor++;
                char[] cArr = this.sourceBuffer;
                int i4 = this.sourceCursor;
                this.sourceCursor = i4 + 1;
                c = cArr[i4];
            }
            int i5 = this.lineEndChar;
            if (i5 >= 0) {
                if (i5 == 13 && c == '\n') {
                    this.lineEndChar = 10;
                } else {
                    this.lineEndChar = -1;
                    this.lineStart = this.sourceCursor - 1;
                    this.lineno++;
                }
            }
            if (c <= 127) {
                if (c != '\n' && c != '\r') {
                    return c;
                }
            } else {
                if (c == 65279) {
                    return c;
                }
                if (!z || !isJSFormatChar(c)) {
                    break;
                }
            }
        }
        if (!ScriptRuntime.isJSLineTerminator(c)) {
            return c;
        }
        this.lineEndChar = c;
        return 10;
    }

    private void markCommentStart(String str) {
        if (!this.parser.compilerEnv.isRecordingComments() || this.sourceReader == null) {
            return;
        }
        this.commentPrefix = str;
        this.commentCursor = this.sourceCursor - 1;
    }

    final String getLine(int i, int[] iArr) {
        int i2 = (this.cursor + this.ungetCursor) - i;
        int i3 = this.sourceCursor;
        if (i2 > i3) {
            return null;
        }
        int i4 = 0;
        int i5 = 0;
        while (i2 > 0) {
            int charAt = charAt(i3 - 1);
            if (ScriptRuntime.isJSLineTerminator(charAt)) {
                if (charAt == 10 && charAt(i3 - 2) == 13) {
                    i2--;
                    i3--;
                }
                i4++;
                i5 = i3 - 1;
            }
            i2--;
            i3--;
        }
        int i6 = 0;
        while (true) {
            if (i3 <= 0) {
                i3 = 0;
                break;
            }
            if (ScriptRuntime.isJSLineTerminator(charAt(i3 - 1))) {
                break;
            }
            i3--;
            i6++;
        }
        iArr[0] = (this.lineno - i4) + (this.lineEndChar >= 0 ? 1 : 0);
        iArr[1] = i6;
        return i4 == 0 ? getLine() : substring(i3, i5);
    }
}
