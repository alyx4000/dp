package sdk.pendo.io.p1;

import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes6.dex */
public enum g {
    UNIX_LINES(1, 'd'),
    CASE_INSENSITIVE(2, 'i'),
    COMMENTS(4, 'x'),
    MULTILINE(8, 'm'),
    DOTALL(32, 's'),
    UNICODE_CASE(64, 'u'),
    UNICODE_CHARACTER_CLASS(256, Matrix.MATRIX_TYPE_RANDOM_UT);

    private final int code;
    private final char flag;

    g(int i, char c) {
        this.code = i;
        this.flag = c;
    }

    private static int a(char c) {
        for (g gVar : values()) {
            if (gVar.flag == c) {
                return gVar.code;
            }
        }
        return 0;
    }

    public static int a(char[] cArr) {
        int i = 0;
        for (char c : cArr) {
            i |= a(c);
        }
        return i;
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder();
        for (g gVar : values()) {
            int i2 = gVar.code;
            if ((i2 & i) == i2) {
                sb.append(gVar.flag);
            }
        }
        return sb.toString();
    }
}
