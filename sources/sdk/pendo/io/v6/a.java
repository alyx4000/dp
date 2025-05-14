package sdk.pendo.io.v6;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import sdk.pendo.io.n6.o;
import sdk.pendo.io.x5.p;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final p f1685a = sdk.pendo.io.t6.a.e(new h());
    static final p b = sdk.pendo.io.t6.a.b(new b());
    static final p c = sdk.pendo.io.t6.a.c(new c());
    static final p d = sdk.pendo.io.n6.p.b();
    static final p e = sdk.pendo.io.t6.a.d(new f());

    /* renamed from: sdk.pendo.io.v6.a$a, reason: collision with other inner class name */
    static final class C0251a {

        /* renamed from: a, reason: collision with root package name */
        static final p f1686a = new sdk.pendo.io.n6.b();
    }

    static final class b implements Callable<p> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return C0251a.f1686a;
        }
    }

    static final class c implements Callable<p> {
        c() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return d.f1687a;
        }
    }

    static final class d {

        /* renamed from: a, reason: collision with root package name */
        static final p f1687a = new sdk.pendo.io.n6.f();
    }

    static final class e {

        /* renamed from: a, reason: collision with root package name */
        static final p f1688a = new sdk.pendo.io.n6.g();
    }

    static final class f implements Callable<p> {
        f() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return e.f1688a;
        }
    }

    static final class g {

        /* renamed from: a, reason: collision with root package name */
        static final p f1689a = new o();
    }

    static final class h implements Callable<p> {
        h() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p call() {
            return g.f1689a;
        }
    }

    public static p a() {
        return sdk.pendo.io.t6.a.a(b);
    }

    public static p b() {
        return sdk.pendo.io.t6.a.b(c);
    }

    public static p c() {
        return sdk.pendo.io.t6.a.c(f1685a);
    }

    public static p d() {
        return d;
    }

    public static p a(Executor executor) {
        return new sdk.pendo.io.n6.d(executor, false);
    }
}
