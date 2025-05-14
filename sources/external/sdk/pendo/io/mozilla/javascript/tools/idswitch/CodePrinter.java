package external.sdk.pendo.io.mozilla.javascript.tools.idswitch;

import kotlin.text.Typography;

/* loaded from: classes2.dex */
class CodePrinter {
    private static final int LITERAL_CHAR_MAX_SIZE = 6;
    private int offset;
    private String lineTerminator = System.lineSeparator();
    private int indentStep = 4;
    private int indentTabSize = 8;
    private char[] buffer = new char[4096];

    CodePrinter() {
    }

    private int add_area(int i) {
        int ensure_area = ensure_area(i);
        this.offset = i + ensure_area;
        return ensure_area;
    }

    private static char digit_to_hex_letter(int i) {
        return (char) (i < 10 ? i + 48 : i + 55);
    }

    private int ensure_area(int i) {
        int i2 = this.offset;
        int i3 = i + i2;
        char[] cArr = this.buffer;
        if (i3 > cArr.length) {
            int length = cArr.length * 2;
            if (i3 <= length) {
                i3 = length;
            }
            char[] cArr2 = new char[i3];
            System.arraycopy(cArr, 0, cArr2, 0, i2);
            this.buffer = cArr2;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int put_string_literal_char(int r3, int r4, boolean r5) {
        /*
            r2 = this;
            r0 = 12
            r1 = 1
            if (r4 == r0) goto L25
            r0 = 13
            if (r4 == r0) goto L22
            r0 = 34
            if (r4 == r0) goto L28
            r0 = 39
            if (r4 == r0) goto L1f
            switch(r4) {
                case 8: goto L1c;
                case 9: goto L19;
                case 10: goto L16;
                default: goto L14;
            }
        L14:
            r5 = 0
            goto L28
        L16:
            r4 = 110(0x6e, float:1.54E-43)
            goto L27
        L19:
            r4 = 116(0x74, float:1.63E-43)
            goto L27
        L1c:
            r4 = 98
            goto L27
        L1f:
            r5 = r5 ^ 1
            goto L28
        L22:
            r4 = 114(0x72, float:1.6E-43)
            goto L27
        L25:
            r4 = 102(0x66, float:1.43E-43)
        L27:
            r5 = r1
        L28:
            r0 = 92
            if (r5 == 0) goto L38
            char[] r5 = r2.buffer
            r5[r3] = r0
            int r0 = r3 + 1
            char r4 = (char) r4
            r5[r0] = r4
            int r3 = r3 + 2
            goto L87
        L38:
            r5 = 32
            if (r5 > r4) goto L47
            r5 = 126(0x7e, float:1.77E-43)
            if (r4 > r5) goto L47
            char[] r5 = r2.buffer
            char r4 = (char) r4
            r5[r3] = r4
            int r3 = r3 + r1
            goto L87
        L47:
            char[] r5 = r2.buffer
            r5[r3] = r0
            int r0 = r3 + 1
            r1 = 117(0x75, float:1.64E-43)
            r5[r0] = r1
            int r0 = r3 + 2
            int r1 = r4 >> 12
            r1 = r1 & 15
            char r1 = digit_to_hex_letter(r1)
            r5[r0] = r1
            char[] r5 = r2.buffer
            int r0 = r3 + 3
            int r1 = r4 >> 8
            r1 = r1 & 15
            char r1 = digit_to_hex_letter(r1)
            r5[r0] = r1
            char[] r5 = r2.buffer
            int r0 = r3 + 4
            int r1 = r4 >> 4
            r1 = r1 & 15
            char r1 = digit_to_hex_letter(r1)
            r5[r0] = r1
            char[] r5 = r2.buffer
            int r0 = r3 + 5
            r4 = r4 & 15
            char r4 = digit_to_hex_letter(r4)
            r5[r0] = r4
            int r3 = r3 + 6
        L87:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.tools.idswitch.CodePrinter.put_string_literal_char(int, int, boolean):int");
    }

    public void clear() {
        this.offset = 0;
    }

    public void erase(int i, int i2) {
        char[] cArr = this.buffer;
        System.arraycopy(cArr, i2, cArr, i, this.offset - i2);
        this.offset -= i2 - i;
    }

    public int getIndentStep() {
        return this.indentStep;
    }

    public int getIndentTabSize() {
        return this.indentTabSize;
    }

    public int getLastChar() {
        int i = this.offset;
        if (i == 0) {
            return -1;
        }
        return this.buffer[i - 1];
    }

    public String getLineTerminator() {
        return this.lineTerminator;
    }

    public int getOffset() {
        return this.offset;
    }

    public void indent(int i) {
        int i2;
        int i3 = this.indentStep * i;
        int i4 = this.indentTabSize;
        if (i4 <= 0) {
            i2 = 0;
        } else {
            int i5 = i3 / i4;
            i3 = (i3 % i4) + i5;
            i2 = i5;
        }
        int add_area = add_area(i3);
        int i6 = i2 + add_area;
        int i7 = i3 + add_area;
        while (add_area != i6) {
            this.buffer[add_area] = '\t';
            add_area++;
        }
        while (add_area != i7) {
            this.buffer[add_area] = ' ';
            add_area++;
        }
    }

    public void line(int i, String str) {
        indent(i);
        p(str);
        nl();
    }

    public void nl() {
        p(getLineTerminator());
    }

    public void p(char c) {
        this.buffer[add_area(1)] = c;
    }

    public void qchar(int i) {
        int ensure_area = ensure_area(8);
        this.buffer[ensure_area] = '\'';
        int put_string_literal_char = put_string_literal_char(ensure_area + 1, i, false);
        this.buffer[put_string_literal_char] = '\'';
        this.offset = put_string_literal_char + 1;
    }

    public void qstring(String str) {
        int length = str.length();
        int ensure_area = ensure_area((length * 6) + 2);
        this.buffer[ensure_area] = Typography.quote;
        int i = ensure_area + 1;
        for (int i2 = 0; i2 != length; i2++) {
            i = put_string_literal_char(i, str.charAt(i2), true);
        }
        this.buffer[i] = Typography.quote;
        this.offset = i + 1;
    }

    public void setIndentStep(int i) {
        this.indentStep = i;
    }

    public void setIndentTabSize(int i) {
        this.indentTabSize = i;
    }

    public void setLineTerminator(String str) {
        this.lineTerminator = str;
    }

    public String toString() {
        return new String(this.buffer, 0, this.offset);
    }

    public void p(int i) {
        p(Integer.toString(i));
    }

    public void p(String str) {
        int length = str.length();
        str.getChars(0, length, this.buffer, add_area(length));
    }

    public final void p(char[] cArr) {
        p(cArr, 0, cArr.length);
    }

    public void p(char[] cArr, int i, int i2) {
        int i3 = i2 - i;
        System.arraycopy(cArr, i, this.buffer, add_area(i3), i3);
    }
}
