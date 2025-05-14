package sdk.pendo.io.t6;

import java.util.concurrent.Callable;
import sdk.pendo.io.c6.c;
import sdk.pendo.io.c6.f;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d6.h;
import sdk.pendo.io.x5.b;
import sdk.pendo.io.x5.d;
import sdk.pendo.io.x5.g;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;
import sdk.pendo.io.x5.p;
import sdk.pendo.io.x5.q;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static volatile e<? super Throwable> f1630a;
    static volatile h<? super Runnable, ? extends Runnable> b;
    static volatile h<? super Callable<p>, ? extends p> c;
    static volatile h<? super Callable<p>, ? extends p> d;
    static volatile h<? super Callable<p>, ? extends p> e;
    static volatile h<? super Callable<p>, ? extends p> f;
    static volatile h<? super p, ? extends p> g;
    static volatile h<? super p, ? extends p> h;
    static volatile h<? super p, ? extends p> i;
    static volatile h<? super d, ? extends d> j;
    static volatile h<? super j, ? extends j> k;
    static volatile h<? super sdk.pendo.io.r6.a, ? extends sdk.pendo.io.r6.a> l;
    static volatile h<? super g, ? extends g> m;
    static volatile h<? super q, ? extends q> n;
    static volatile h<? super b, ? extends b> o;
    static volatile sdk.pendo.io.d6.b<? super d, ? super sdk.pendo.io.w5.b, ? extends sdk.pendo.io.w5.b> p;
    static volatile sdk.pendo.io.d6.b<? super g, ? super sdk.pendo.io.x5.h, ? extends sdk.pendo.io.x5.h> q;
    static volatile sdk.pendo.io.d6.b<? super j, ? super o, ? extends o> r;
    static volatile sdk.pendo.io.d6.d s;
    static volatile boolean t;
    static volatile boolean u;

    static <T, U, R> R a(sdk.pendo.io.d6.b<T, U, R> bVar, T t2, U u2) {
        try {
            return bVar.apply(t2, u2);
        } catch (Throwable th) {
            throw sdk.pendo.io.q6.g.a(th);
        }
    }

    public static p b(Callable<p> callable) {
        sdk.pendo.io.f6.b.a(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = c;
        return hVar == null ? a(callable) : a(hVar, callable);
    }

    public static p c(Callable<p> callable) {
        sdk.pendo.io.f6.b.a(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = e;
        return hVar == null ? a(callable) : a(hVar, callable);
    }

    public static p d(Callable<p> callable) {
        sdk.pendo.io.f6.b.a(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = f;
        return hVar == null ? a(callable) : a(hVar, callable);
    }

    public static p e(Callable<p> callable) {
        sdk.pendo.io.f6.b.a(callable, "Scheduler Callable can't be null");
        h<? super Callable<p>, ? extends p> hVar = d;
        return hVar == null ? a(callable) : a(hVar, callable);
    }

    static <T, R> R a(h<T, R> hVar, T t2) {
        try {
            return hVar.apply(t2);
        } catch (Throwable th) {
            throw sdk.pendo.io.q6.g.a(th);
        }
    }

    public static boolean b() {
        sdk.pendo.io.d6.d dVar = s;
        if (dVar == null) {
            return false;
        }
        try {
            return dVar.getAsBoolean();
        } catch (Throwable th) {
            throw sdk.pendo.io.q6.g.a(th);
        }
    }

    public static p c(p pVar) {
        h<? super p, ? extends p> hVar = h;
        return hVar == null ? pVar : (p) a((h<p, R>) hVar, pVar);
    }

    static p a(h<? super Callable<p>, ? extends p> hVar, Callable<p> callable) {
        return (p) sdk.pendo.io.f6.b.a(a((h<Callable<p>, R>) hVar, callable), "Scheduler Callable result can't be null");
    }

    public static void b(Throwable th) {
        e<? super Throwable> eVar = f1630a;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!a(th)) {
            th = new f(th);
        }
        if (eVar != null) {
            try {
                eVar.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                c(th2);
            }
        }
        th.printStackTrace();
        c(th);
    }

    static void c(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    static p a(Callable<p> callable) {
        try {
            return (p) sdk.pendo.io.f6.b.a(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th) {
            throw sdk.pendo.io.q6.g.a(th);
        }
    }

    public static p b(p pVar) {
        h<? super p, ? extends p> hVar = i;
        return hVar == null ? pVar : (p) a((h<p, R>) hVar, pVar);
    }

    static boolean a(Throwable th) {
        return (th instanceof sdk.pendo.io.c6.d) || (th instanceof c) || (th instanceof IllegalStateException) || (th instanceof NullPointerException) || (th instanceof IllegalArgumentException) || (th instanceof sdk.pendo.io.c6.a);
    }

    public static boolean a() {
        return u;
    }

    public static <T> sdk.pendo.io.r6.a<T> a(sdk.pendo.io.r6.a<T> aVar) {
        h<? super sdk.pendo.io.r6.a, ? extends sdk.pendo.io.r6.a> hVar = l;
        return hVar != null ? (sdk.pendo.io.r6.a) a((h<sdk.pendo.io.r6.a<T>, R>) hVar, aVar) : aVar;
    }

    public static b a(b bVar) {
        h<? super b, ? extends b> hVar = o;
        return hVar != null ? (b) a((h<b, R>) hVar, bVar) : bVar;
    }

    public static <T> d<T> a(d<T> dVar) {
        h<? super d, ? extends d> hVar = j;
        return hVar != null ? (d) a((h<d<T>, R>) hVar, dVar) : dVar;
    }

    public static <T> g<T> a(g<T> gVar) {
        h<? super g, ? extends g> hVar = m;
        return hVar != null ? (g) a((h<g<T>, R>) hVar, gVar) : gVar;
    }

    public static <T> j<T> a(j<T> jVar) {
        h<? super j, ? extends j> hVar = k;
        return hVar != null ? (j) a((h<j<T>, R>) hVar, jVar) : jVar;
    }

    public static <T> q<T> a(q<T> qVar) {
        h<? super q, ? extends q> hVar = n;
        return hVar != null ? (q) a((h<q<T>, R>) hVar, qVar) : qVar;
    }

    public static p a(p pVar) {
        h<? super p, ? extends p> hVar = g;
        return hVar == null ? pVar : (p) a((h<p, R>) hVar, pVar);
    }

    public static Runnable a(Runnable runnable) {
        sdk.pendo.io.f6.b.a(runnable, "run is null");
        h<? super Runnable, ? extends Runnable> hVar = b;
        return hVar == null ? runnable : (Runnable) a((h<Runnable, R>) hVar, runnable);
    }

    public static <T> sdk.pendo.io.w5.b<? super T> a(d<T> dVar, sdk.pendo.io.w5.b<? super T> bVar) {
        sdk.pendo.io.d6.b<? super d, ? super sdk.pendo.io.w5.b, ? extends sdk.pendo.io.w5.b> bVar2 = p;
        return bVar2 != null ? (sdk.pendo.io.w5.b) a(bVar2, dVar, bVar) : bVar;
    }

    public static <T> sdk.pendo.io.x5.h<? super T> a(g<T> gVar, sdk.pendo.io.x5.h<? super T> hVar) {
        sdk.pendo.io.d6.b<? super g, ? super sdk.pendo.io.x5.h, ? extends sdk.pendo.io.x5.h> bVar = q;
        return bVar != null ? (sdk.pendo.io.x5.h) a(bVar, gVar, hVar) : hVar;
    }

    public static <T> o<? super T> a(j<T> jVar, o<? super T> oVar) {
        sdk.pendo.io.d6.b<? super j, ? super o, ? extends o> bVar = r;
        return bVar != null ? (o) a(bVar, jVar, oVar) : oVar;
    }

    public static void a(e<? super Throwable> eVar) {
        if (t) {
            throw new IllegalStateException("Plugins can't be changed anymore");
        }
        f1630a = eVar;
    }
}
