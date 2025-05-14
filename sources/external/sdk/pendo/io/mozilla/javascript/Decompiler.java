package external.sdk.pendo.io.mozilla.javascript;

import kotlin.text.Typography;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.commons.io.IOUtils;

/* loaded from: classes2.dex */
public class Decompiler {
    public static final int CASE_GAP_PROP = 3;
    private static final int FUNCTION_END = 168;
    public static final int INDENT_GAP_PROP = 2;
    public static final int INITIAL_INDENT_PROP = 1;
    public static final int ONLY_BODY_FLAG = 1;
    public static final int TO_SOURCE_FLAG = 2;
    private static final boolean printSource = false;
    private char[] sourceBuffer = new char[128];
    private int sourceTop;

    private void append(char c) {
        int i = this.sourceTop;
        if (i == this.sourceBuffer.length) {
            increaseSourceCapacity(i + 1);
        }
        char[] cArr = this.sourceBuffer;
        int i2 = this.sourceTop;
        cArr[i2] = c;
        this.sourceTop = i2 + 1;
    }

    private void appendString(String str) {
        int length = str.length();
        int i = this.sourceTop + (length >= 32768 ? 2 : 1) + length;
        if (i > this.sourceBuffer.length) {
            increaseSourceCapacity(i);
        }
        if (length >= 32768) {
            char[] cArr = this.sourceBuffer;
            int i2 = this.sourceTop;
            cArr[i2] = (char) (32768 | (length >>> 16));
            this.sourceTop = i2 + 1;
        }
        char[] cArr2 = this.sourceBuffer;
        int i3 = this.sourceTop;
        cArr2[i3] = (char) length;
        int i4 = i3 + 1;
        this.sourceTop = i4;
        str.getChars(0, length, cArr2, i4);
        this.sourceTop = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0233, code lost:
    
        if (39 == getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01c9, code lost:
    
        if (r4 != external.sdk.pendo.io.mozilla.javascript.Decompiler.FUNCTION_END) goto L206;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01fb, code lost:
    
        if (1 != getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x02cb, code lost:
    
        if (83 != getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0224, code lost:
    
        if (39 == getNext(r17, r2, r13)) goto L146;
     */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0264  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String decompile(java.lang.String r17, int r18, external.sdk.pendo.io.mozilla.javascript.UintMap r19) {
        /*
            Method dump skipped, instructions count: 1052
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Decompiler.decompile(java.lang.String, int, external.sdk.pendo.io.mozilla.javascript.UintMap):java.lang.String");
    }

    private static int getNext(String str, int i, int i2) {
        int i3 = i2 + 1;
        if (i3 < i) {
            return str.charAt(i3);
        }
        return 0;
    }

    private static int getSourceStringEnd(String str, int i) {
        return printSourceString(str, i, false, null);
    }

    private void increaseSourceCapacity(int i) {
        if (i <= this.sourceBuffer.length) {
            Kit.codeBug();
        }
        char[] cArr = this.sourceBuffer;
        int length = cArr.length * 2;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.sourceTop);
        this.sourceBuffer = cArr2;
    }

    private static int printSourceNumber(String str, int i, StringBuilder sb) {
        int i2;
        char charAt = str.charAt(i);
        int i3 = i + 1;
        if (charAt == 'S') {
            r2 = sb != null ? str.charAt(i3) : 0.0d;
            i2 = i3 + 1;
        } else {
            if (charAt != 'J' && charAt != 'D') {
                throw new RuntimeException();
            }
            if (sb != null) {
                long charAt2 = (str.charAt(i3) << 48) | (str.charAt(i3 + 1) << 32) | (str.charAt(i3 + 2) << 16) | str.charAt(i3 + 3);
                r2 = charAt == 'J' ? charAt2 : Double.longBitsToDouble(charAt2);
            }
            i2 = i3 + 4;
        }
        if (sb != null) {
            sb.append(ScriptRuntime.numberToString(r2, 10));
        }
        return i2;
    }

    private static int printSourceString(String str, int i, boolean z, StringBuilder sb) {
        int charAt = str.charAt(i);
        int i2 = i + 1;
        if ((32768 & charAt) != 0) {
            charAt = ((charAt & 32767) << 16) | str.charAt(i2);
            i2++;
        }
        if (sb != null) {
            String substring = str.substring(i2, i2 + charAt);
            if (z) {
                sb.append(Typography.quote);
                sb.append(ScriptRuntime.escapeString(substring));
                sb.append(Typography.quote);
            } else {
                sb.append(substring);
            }
        }
        return i2 + charAt;
    }

    private String sourceToString(int i) {
        if (i < 0 || this.sourceTop < i) {
            Kit.codeBug();
        }
        return new String(this.sourceBuffer, i, this.sourceTop - i);
    }

    void addEOL(int i) {
        if (i < 0 || i > 167) {
            throw new IllegalArgumentException();
        }
        append((char) i);
        append((char) 1);
    }

    void addName(String str) {
        addToken(39);
        appendString(str);
    }

    void addNumber(double d) {
        char c;
        int i;
        addToken(40);
        long j = (long) d;
        if (j != d) {
            long doubleToLongBits = Double.doubleToLongBits(d);
            append('D');
            append((char) (doubleToLongBits >> 48));
            append((char) (doubleToLongBits >> 32));
            append((char) (doubleToLongBits >> 16));
            i = (int) doubleToLongBits;
        } else {
            if (j < 0) {
                Kit.codeBug();
            }
            if (j <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                c = 'S';
            } else {
                append('J');
                append((char) (j >> 48));
                append((char) (j >> 32));
                c = (char) (j >> 16);
            }
            append(c);
            i = (int) j;
        }
        append((char) i);
    }

    void addRegexp(String str, String str2) {
        addToken(48);
        appendString("/" + str + IOUtils.DIR_SEPARATOR_UNIX + str2);
    }

    void addString(String str) {
        addToken(41);
        appendString(str);
    }

    void addToken(int i) {
        if (i < 0 || i > 167) {
            throw new IllegalArgumentException();
        }
        append((char) i);
    }

    int getCurrentOffset() {
        return this.sourceTop;
    }

    String getEncodedSource() {
        return sourceToString(0);
    }

    int markFunctionEnd(int i) {
        int currentOffset = getCurrentOffset();
        append((char) 168);
        return currentOffset;
    }

    int markFunctionStart(int i) {
        int currentOffset = getCurrentOffset();
        if (i != 4) {
            addToken(110);
            append((char) i);
        }
        return currentOffset;
    }
}
