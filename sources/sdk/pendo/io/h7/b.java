package sdk.pendo.io.h7;

import com.amplitude.reactnative.AndroidContextProvider;
import external.sdk.pendo.io.slf4j.impl.StaticLoggerBinder;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import sdk.pendo.io.i7.d;
import sdk.pendo.io.j7.e;
import sdk.pendo.io.j7.f;
import sdk.pendo.io.j7.g;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    static volatile int f1161a;
    static f b = new f();
    static sdk.pendo.io.j7.c c = new sdk.pendo.io.j7.c();
    static boolean d = g.b("slf4j.detectLoggerNameMismatch");
    private static final String[] e = {"1.6", "1.7"};
    private static String f = "external/sdk/pendo/io/slf4j/impl/StaticLoggerBinder.class";

    private b() {
    }

    private static final void a() {
        Set<URL> set;
        try {
            if (f()) {
                set = null;
            } else {
                set = c();
                c(set);
            }
            StaticLoggerBinder.getSingleton();
            f1161a = 3;
            b(set);
            d();
            h();
            b.a();
        } catch (Exception e2) {
            a(e2);
            throw new IllegalStateException("Unexpected initialization failure", e2);
        } catch (NoClassDefFoundError e3) {
            if (!b(e3.getMessage())) {
                a(e3);
                throw e3;
            }
            f1161a = 4;
            g.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            g.a("Defaulting to no-operation (NOP) logger implementation");
            g.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        } catch (NoSuchMethodError e4) {
            String message = e4.getMessage();
            if (message != null && message.contains("external.sdk.pendo.io.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f1161a = 2;
                g.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                g.a("Your binding is version 1.5.5 or earlier.");
                g.a("Upgrade your binding to version 1.6.x.");
            }
            throw e4;
        }
    }

    private static void b() {
        g.a("The following set of substitute loggers may have been accessed");
        g.a("during the initialization phase. Logging calls during this");
        g.a("phase were not honored. However, subsequent logging calls to these");
        g.a("loggers will work as normally expected.");
        g.a("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    static Set<URL> c() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = b.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f) : classLoader.getResources(f);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e2) {
            g.a("Error getting resources from path", e2);
        }
        return linkedHashSet;
    }

    private static void d() {
        synchronized (b) {
            b.d();
            for (e eVar : b.c()) {
                eVar.a(a(eVar.getName()));
            }
        }
    }

    public static ILoggerFactory e() {
        if (f1161a == 0) {
            synchronized (b.class) {
                if (f1161a == 0) {
                    f1161a = 1;
                    g();
                }
            }
        }
        int i = f1161a;
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
        }
        if (i == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i == 4) {
            return c;
        }
        throw new IllegalStateException("Unreachable code");
    }

    private static boolean f() {
        String c2 = g.c("java.vendor.url");
        if (c2 == null) {
            return false;
        }
        return c2.toLowerCase().contains(AndroidContextProvider.OS_NAME);
    }

    private static final void g() {
        a();
        if (f1161a == 3) {
            i();
        }
    }

    private static void h() {
        LinkedBlockingQueue<d> b2 = b.b();
        int size = b2.size();
        ArrayList<d> arrayList = new ArrayList(128);
        int i = 0;
        while (b2.drainTo(arrayList, 128) != 0) {
            for (d dVar : arrayList) {
                a(dVar);
                int i2 = i + 1;
                if (i == 0) {
                    a(dVar, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    private static final void i() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z = false;
            for (String str2 : e) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            g.a("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(e).toString());
            g.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            g.a("Unexpected problem occured during version sanity check", th);
        }
    }

    private static void a(d dVar, int i) {
        if (dVar.a().d()) {
            a(i);
        } else {
            if (dVar.a().e()) {
                return;
            }
            b();
        }
    }

    private static boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("external/sdk/pendo/io/slf4j/impl/StaticLoggerBinder") || str.contains("external.sdk.pendo.io.slf4j.impl.StaticLoggerBinder");
    }

    private static void c(Set<URL> set) {
        if (a(set)) {
            g.a("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                g.a("Found binding in [" + it.next() + "]");
            }
            g.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    private static void a(int i) {
        g.a("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        g.a("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        g.a("See also http://www.slf4j.org/codes.html#replay");
    }

    private static void b(Set<URL> set) {
        if (set == null || !a(set)) {
            return;
        }
        g.a("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    static void a(Throwable th) {
        f1161a = 2;
        g.a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    public static a a(Class<?> cls) {
        Class<?> a2;
        a a3 = a(cls.getName());
        if (d && (a2 = g.a()) != null && a(cls, a2)) {
            g.a(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", a3.getName(), a2.getName()));
            g.a("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return a3;
    }

    public static a a(String str) {
        return e().a(str);
    }

    private static boolean a(Set<URL> set) {
        return set.size() > 1;
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    private static void a(d dVar) {
        if (dVar == null) {
            return;
        }
        e a2 = dVar.a();
        String name = a2.getName();
        if (a2.f()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (a2.e()) {
            return;
        }
        if (a2.d()) {
            a2.a(dVar);
        } else {
            g.a(name);
        }
    }
}
