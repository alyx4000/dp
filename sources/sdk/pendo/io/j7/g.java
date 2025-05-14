package sdk.pendo.io.j7;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static b f1234a = null;
    private static boolean b = false;

    private static final class b extends SecurityManager {
        private b() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    private g() {
    }

    public static Class<?> a() {
        int i;
        b b2 = b();
        if (b2 == null) {
            return null;
        }
        Class<?>[] classContext = b2.getClassContext();
        String name = g.class.getName();
        int i2 = 0;
        while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
            i2++;
        }
        if (i2 >= classContext.length || (i = i2 + 2) >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i];
    }

    private static b b() {
        b bVar = f1234a;
        if (bVar != null) {
            return bVar;
        }
        if (b) {
            return null;
        }
        b c = c();
        f1234a = c;
        b = true;
        return c;
    }

    private static b c() {
        try {
            return new b();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final void a(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static boolean b(String str) {
        String c = c(str);
        if (c == null) {
            return false;
        }
        return c.equalsIgnoreCase("true");
    }

    public static String c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static final void a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }
}
