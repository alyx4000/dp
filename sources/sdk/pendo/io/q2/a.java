package sdk.pendo.io.q2;

import sdk.pendo.io.o2.g;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Long f1511a = 0L;
    public static final Long b = 1L;
    public static final Long c = -1L;
    public static final Integer d = 0;
    public static final Integer e = 1;
    public static final Integer f = 2;
    public static final Integer g = -1;
    public static final Short h = 0;
    public static final Short i = 1;
    public static final Short j = -1;
    public static final Byte k = (byte) 0;
    public static final Byte l = (byte) 1;
    public static final Byte m = (byte) -1;
    public static final Double n = Double.valueOf(0.0d);
    public static final Double o = Double.valueOf(1.0d);
    public static final Double p = Double.valueOf(-1.0d);
    public static final Float q = Float.valueOf(0.0f);
    public static final Float r = Float.valueOf(1.0f);
    public static final Float s = Float.valueOf(-1.0f);
    public static final Long t = 2147483647L;
    public static final Long u = -2147483648L;

    public static boolean a(String str) {
        if (g.a(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) != '-') {
            return a(str, 0);
        }
        if (str.length() == 1) {
            return false;
        }
        return a(str, 1);
    }

    private static boolean a(String str, int i2) {
        int i3 = 0;
        while (i2 < str.length()) {
            boolean z = str.charAt(i2) == '.';
            if (z) {
                i3++;
            }
            if (i3 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(str.charAt(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }
}
