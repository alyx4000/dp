package sdk.pendo.io.f6;

import java.util.Comparator;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    static final sdk.pendo.io.d6.h<Object, Object> f1081a = new j();
    public static final Runnable b = new g();
    public static final sdk.pendo.io.d6.a c = new d();
    static final sdk.pendo.io.d6.e<Object> d = new e();
    public static final sdk.pendo.io.d6.e<Throwable> e = new h();
    public static final sdk.pendo.io.d6.e<Throwable> f = new o();
    public static final sdk.pendo.io.d6.i g = new f();
    static final sdk.pendo.io.d6.j<Object> h = new p();
    static final sdk.pendo.io.d6.j<Object> i = new i();
    static final Callable<Object> j = new n();
    static final Comparator<Object> k = new m();
    public static final sdk.pendo.io.d6.e<sdk.pendo.io.w5.c> l = new l();

    /* renamed from: sdk.pendo.io.f6.a$a, reason: collision with other inner class name */
    static final class C0136a<T1, T2, R> implements sdk.pendo.io.d6.h<Object[], R> {
        final sdk.pendo.io.d6.b<? super T1, ? super T2, ? extends R> f;

        C0136a(sdk.pendo.io.d6.b<? super T1, ? super T2, ? extends R> bVar) {
            this.f = bVar;
        }

        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 2) {
                return this.f.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    static final class b<T1, T2, T3, R> implements sdk.pendo.io.d6.h<Object[], R> {
        final sdk.pendo.io.d6.f<T1, T2, T3, R> f;

        b(sdk.pendo.io.d6.f<T1, T2, T3, R> fVar) {
            this.f = fVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 3) {
                return (R) this.f.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    static final class c<T1, T2, T3, T4, R> implements sdk.pendo.io.d6.h<Object[], R> {
        final sdk.pendo.io.d6.g<T1, T2, T3, T4, R> f;

        c(sdk.pendo.io.d6.g<T1, T2, T3, T4, R> gVar) {
            this.f = gVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sdk.pendo.io.d6.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) {
            if (objArr.length == 4) {
                return (R) this.f.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    static final class d implements sdk.pendo.io.d6.a {
        d() {
        }

        @Override // sdk.pendo.io.d6.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class e implements sdk.pendo.io.d6.e<Object> {
        e() {
        }

        @Override // sdk.pendo.io.d6.e
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class f implements sdk.pendo.io.d6.i {
        f() {
        }
    }

    static final class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class h implements sdk.pendo.io.d6.e<Throwable> {
        h() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            sdk.pendo.io.t6.a.b(th);
        }
    }

    static final class i implements sdk.pendo.io.d6.j<Object> {
        i() {
        }

        @Override // sdk.pendo.io.d6.j
        public boolean test(Object obj) {
            return false;
        }
    }

    static final class j implements sdk.pendo.io.d6.h<Object, Object> {
        j() {
        }

        @Override // sdk.pendo.io.d6.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class k<T, U> implements Callable<U>, sdk.pendo.io.d6.h<T, U> {
        final U f;

        k(U u) {
            this.f = u;
        }

        @Override // sdk.pendo.io.d6.h
        public U apply(T t) {
            return this.f;
        }

        @Override // java.util.concurrent.Callable
        public U call() {
            return this.f;
        }
    }

    static final class l implements sdk.pendo.io.d6.e<sdk.pendo.io.w5.c> {
        l() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(sdk.pendo.io.w5.c cVar) {
            cVar.a(Long.MAX_VALUE);
        }
    }

    static final class m implements Comparator<Object> {
        m() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class n implements Callable<Object> {
        n() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class o implements sdk.pendo.io.d6.e<Throwable> {
        o() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.d(th));
        }
    }

    static final class p implements sdk.pendo.io.d6.j<Object> {
        p() {
        }

        @Override // sdk.pendo.io.d6.j
        public boolean test(Object obj) {
            return true;
        }
    }

    public static <T> sdk.pendo.io.d6.j<T> a() {
        return (sdk.pendo.io.d6.j<T>) h;
    }

    public static <T> sdk.pendo.io.d6.e<T> b() {
        return (sdk.pendo.io.d6.e<T>) d;
    }

    public static <T> sdk.pendo.io.d6.h<T, T> c() {
        return (sdk.pendo.io.d6.h<T, T>) f1081a;
    }

    public static <T> Callable<T> a(T t) {
        return new k(t);
    }

    public static <T1, T2, R> sdk.pendo.io.d6.h<Object[], R> a(sdk.pendo.io.d6.b<? super T1, ? super T2, ? extends R> bVar) {
        sdk.pendo.io.f6.b.a(bVar, "f is null");
        return new C0136a(bVar);
    }

    public static <T1, T2, T3, R> sdk.pendo.io.d6.h<Object[], R> a(sdk.pendo.io.d6.f<T1, T2, T3, R> fVar) {
        sdk.pendo.io.f6.b.a(fVar, "f is null");
        return new b(fVar);
    }

    public static <T1, T2, T3, T4, R> sdk.pendo.io.d6.h<Object[], R> a(sdk.pendo.io.d6.g<T1, T2, T3, T4, R> gVar) {
        sdk.pendo.io.f6.b.a(gVar, "f is null");
        return new c(gVar);
    }
}
