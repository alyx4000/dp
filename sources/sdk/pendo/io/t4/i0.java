package sdk.pendo.io.t4;

import com.facebook.hermes.intl.Constants;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes6.dex */
class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f1586a = Logger.getLogger(i0.class.getName());

    static class a implements PrivilegedAction<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1587a;

        a(String str) {
            this.f1587a = str;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String run() {
            return Security.getProperty(this.f1587a);
        }
    }

    static class b implements PrivilegedAction<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f1588a;

        b(String str) {
            this.f1588a = str;
        }

        @Override // java.security.PrivilegedAction
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String run() {
            return System.getProperty(this.f1588a);
        }
    }

    i0() {
    }

    static boolean a(String str, boolean z) {
        String a2 = a(str);
        if (a2 != null) {
            if ("true".equalsIgnoreCase(a2)) {
                f1586a.log(Level.INFO, "Found boolean security property [" + str + "]: true");
                return true;
            }
            if (Constants.CASEFIRST_FALSE.equalsIgnoreCase(a2)) {
                f1586a.log(Level.INFO, "Found boolean security property [" + str + "]: false");
                return false;
            }
            f1586a.log(Level.WARNING, "Unrecognized value for boolean security property [" + str + "]: " + a2);
        }
        f1586a.log(Level.FINE, "Boolean security property [" + str + "] defaulted to: " + z);
        return z;
    }

    static boolean b(String str, boolean z) {
        String f = f(str);
        if (f != null) {
            if ("true".equalsIgnoreCase(f)) {
                f1586a.log(Level.INFO, "Found boolean system property [" + str + "]: true");
                return true;
            }
            if (Constants.CASEFIRST_FALSE.equalsIgnoreCase(f)) {
                f1586a.log(Level.INFO, "Found boolean system property [" + str + "]: false");
                return false;
            }
            f1586a.log(Level.WARNING, "Unrecognized value for boolean system property [" + str + "]: " + f);
        }
        f1586a.log(Level.FINE, "Boolean system property [" + str + "] defaulted to: " + z);
        return z;
    }

    static String[] c(String str) {
        return g(e(str));
    }

    static String d(String str) {
        String a2 = a(str);
        if (a2 == null) {
            return null;
        }
        f1586a.log(Level.INFO, "Found string security property [" + str + "]: " + a2);
        return a2;
    }

    static String e(String str) {
        String f = f(str);
        if (f == null) {
            return null;
        }
        f1586a.log(Level.INFO, "Found string system property [" + str + "]: " + f);
        return f;
    }

    static String f(String str) {
        try {
            return (String) AccessController.doPrivileged(new b(str));
        } catch (RuntimeException e) {
            f1586a.log(Level.WARNING, "Failed to get system property", (Throwable) e);
            return null;
        }
    }

    private static String[] g(String str) {
        if (str == null) {
            return null;
        }
        String[] split = a0.e(str.trim()).split(",");
        String[] strArr = new String[split.length];
        int i = 0;
        for (String str2 : split) {
            String trim = str2.trim();
            if (trim.length() >= 1) {
                strArr[i] = trim;
                i++;
            }
        }
        return a0.b(strArr, i);
    }

    static int a(String str, int i, int i2, int i3) {
        String f = f(str);
        if (f != null) {
            try {
                int parseInt = Integer.parseInt(f);
                if (parseInt >= i2 && parseInt <= i3) {
                    f1586a.log(Level.INFO, "Found integer system property [" + str + "]: " + parseInt);
                    return parseInt;
                }
                Logger logger = f1586a;
                Level level = Level.WARNING;
                if (logger.isLoggable(level)) {
                    logger.log(level, "Out-of-range (" + a(i2, i3) + ") integer system property [" + str + "]: " + f);
                }
            } catch (Exception unused) {
                f1586a.log(Level.WARNING, "Unrecognized value for integer system property [" + str + "]: " + f);
            }
        }
        f1586a.log(Level.FINE, "Integer system property [" + str + "] defaulted to: " + i);
        return i;
    }

    static String b(String str) {
        String f = f(str);
        if (f == null) {
            return null;
        }
        f1586a.info("Found sensitive string system property [" + str + "]");
        return f;
    }

    private static String a(int i, int i2) {
        StringBuilder sb = new StringBuilder(32);
        if (Integer.MIN_VALUE != i) {
            sb.append(i);
            sb.append(" <= ");
        }
        sb.append('x');
        if (Integer.MAX_VALUE != i2) {
            sb.append(" <= ");
            sb.append(i2);
        }
        return sb.toString();
    }

    static String b(String str, String str2) {
        String a2 = a(str);
        if (a2 != null) {
            f1586a.log(Level.INFO, "Found string security property [" + str + "]: " + a2);
            return a2;
        }
        f1586a.log(Level.WARNING, "String security property [" + str + "] defaulted to: " + str2);
        return str2;
    }

    static String a(String str) {
        return (String) AccessController.doPrivileged(new a(str));
    }

    static String[] a(String str, String str2) {
        return g(b(str, str2));
    }
}
