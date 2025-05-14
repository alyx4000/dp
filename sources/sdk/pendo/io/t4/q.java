package sdk.pendo.io.t4;

import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    public static final int f1602a = r1.a("java.net.IDN", "ALLOW_UNASSIGNED", 1).intValue();
    public static final int b = r1.a("java.net.IDN", "USE_STD3_ASCII_RULES", 2).intValue();
    private static final Method c;
    private static final Method d;

    static {
        Class cls = Integer.TYPE;
        c = r1.a("java.net.IDN", "toASCII", (Class<?>[]) new Class[]{String.class, cls});
        d = r1.a("java.net.IDN", "toUnicode", (Class<?>[]) new Class[]{String.class, cls});
    }

    private static int a(String str, int i) {
        while (i < str.length() && !a(str.charAt(i))) {
            i++;
        }
        return i;
    }

    private static boolean a(char c2) {
        return c2 == '.' || c2 == 12290 || c2 == 65294 || c2 == 65377;
    }

    private static boolean b(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) >= 128) {
                return false;
            }
        }
        return true;
    }

    private static String c(String str, int i) {
        if (str.length() < 1) {
            throw new IllegalArgumentException("Domain name label cannot be empty");
        }
        if (!b(str)) {
            throw new UnsupportedOperationException("IDN support incomplete");
        }
        if ((i & b) != 0) {
            if (a((CharSequence) str)) {
                throw new IllegalArgumentException("Domain name label cannot contain non-LDH characters");
            }
            if ('-' == str.charAt(0) || '-' == str.charAt(str.length() - 1)) {
                throw new IllegalArgumentException("Domain name label cannot begin or end with a hyphen");
            }
        }
        if (63 >= str.length()) {
            return str;
        }
        throw new IllegalArgumentException("Domain name label length cannot be more than 63");
    }

    public static String d(String str, int i) {
        Method method = d;
        if (method != null) {
            return (String) r1.a((Object) null, method, str, Integer.valueOf(i));
        }
        if (a(str)) {
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int a2 = a(str, i2);
            sb.append(e(str.substring(i2, a2), i));
            if (a2 < str.length()) {
                sb.append('.');
            }
            i2 = a2 + 1;
        }
        return sb.toString();
    }

    private static String e(String str, int i) {
        return str;
    }

    private static boolean a(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt >= 0 && charAt <= ',') {
                return true;
            }
            if ('.' <= charAt && charAt <= '/') {
                return true;
            }
            if (':' <= charAt && charAt <= '@') {
                return true;
            }
            if ('[' <= charAt && charAt <= '`') {
                return true;
            }
            if ('{' <= charAt && charAt <= 127) {
                return true;
            }
        }
        return false;
    }

    public static String b(String str, int i) {
        Method method = c;
        if (method != null) {
            return (String) r1.a((Object) null, method, str, Integer.valueOf(i));
        }
        if (a(str)) {
            return ".";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int a2 = a(str, i2);
            sb.append(c(str.substring(i2, a2), i));
            if (a2 < str.length()) {
                sb.append('.');
            }
            i2 = a2 + 1;
        }
        return sb.toString();
    }

    private static boolean a(String str) {
        return str.length() == 1 && a(str.charAt(0));
    }
}
