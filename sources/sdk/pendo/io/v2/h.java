package sdk.pendo.io.v2;

import com.facebook.react.uimanager.ViewProps;
import org.apache.commons.io.IOUtils;

/* loaded from: classes4.dex */
final class h {
    static final int a(int i) {
        return ((i & 65535) << 8) | 7;
    }

    static final int b(int i) {
        return ((i & 65535) << 8) | 8;
    }

    static final int c(int i) {
        return i >>> 8;
    }

    static final int d(int i) {
        return i & 255;
    }

    static boolean e(int i) {
        return i == 3 || i == 4;
    }

    static final int a(String str, d dVar) {
        return a(dVar.a(str));
    }

    static final int b(String str, d dVar) {
        if (str.length() != 1) {
            return a(str, dVar);
        }
        char charAt = str.charAt(0);
        if (charAt == 'F') {
            return 2;
        }
        if (charAt != 'S' && charAt != 'Z' && charAt != 'I') {
            if (charAt == 'J') {
                return 4;
            }
            switch (charAt) {
                case 'B':
                case 'C':
                    break;
                case 'D':
                    return 3;
                default:
                    throw new IllegalArgumentException("bad type");
            }
        }
        return 1;
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str.replace(IOUtils.DIR_SEPARATOR_UNIX, '.'));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static String b(int i, d dVar) {
        int d = d(i);
        switch (d) {
            case 0:
                return ViewProps.TOP;
            case 1:
                return "int";
            case 2:
                return "float";
            case 3:
                return "double";
            case 4:
                return "long";
            case 5:
                return "null";
            case 6:
                return "uninitialized_this";
            default:
                if (d == 7) {
                    return a(i, dVar);
                }
                if (d == 8) {
                    return "uninitialized";
                }
                throw new IllegalArgumentException("bad type");
        }
    }

    static final String a(int i, d dVar) {
        if (d(i) == 7) {
            return (String) dVar.c(c(i));
        }
        throw new IllegalArgumentException("expecting object type");
    }

    static int a(int i, int i2, d dVar) {
        String str;
        int d = d(i);
        int d2 = d(i2);
        boolean z = d == 7;
        boolean z2 = d2 == 7;
        if (i == i2 || (z && i2 == 5)) {
            return i;
        }
        if (d == 0 || d2 == 0) {
            return 0;
        }
        if (i == 5 && z2) {
            return i2;
        }
        if (z && z2) {
            String a2 = a(i, dVar);
            String a3 = a(i2, dVar);
            String str2 = (String) dVar.c(2);
            String str3 = (String) dVar.c(4);
            if (a2.equals(str2)) {
                a2 = str3;
            }
            if (a3.equals(str2)) {
                a3 = str3;
            }
            Class<?> a4 = a(a2);
            Class<?> a5 = a(a3);
            if (a4.isAssignableFrom(a5)) {
                return i;
            }
            if (a5.isAssignableFrom(a4)) {
                return i2;
            }
            if (a5.isInterface() || a4.isInterface()) {
                str = "java/lang/Object";
            } else {
                do {
                    a5 = a5.getSuperclass();
                    if (a5 != null) {
                    }
                } while (!a5.isAssignableFrom(a4));
                str = c.i(a5.getName());
            }
            return a(str, dVar);
        }
        throw new IllegalArgumentException("bad merge attempt between " + b(i, dVar) + " and " + b(i2, dVar));
    }
}
