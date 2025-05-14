package sdk.pendo.io.x5;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.l6.b0;
import sdk.pendo.io.l6.c0;
import sdk.pendo.io.l6.d0;
import sdk.pendo.io.l6.e0;
import sdk.pendo.io.l6.f0;
import sdk.pendo.io.l6.g0;
import sdk.pendo.io.l6.h0;
import sdk.pendo.io.l6.i0;
import sdk.pendo.io.l6.j0;
import sdk.pendo.io.l6.k0;
import sdk.pendo.io.l6.l0;
import sdk.pendo.io.l6.m0;
import sdk.pendo.io.l6.n0;
import sdk.pendo.io.l6.o0;
import sdk.pendo.io.l6.p0;
import sdk.pendo.io.l6.r;
import sdk.pendo.io.l6.s;
import sdk.pendo.io.l6.t;
import sdk.pendo.io.l6.u;
import sdk.pendo.io.l6.v;
import sdk.pendo.io.l6.w;
import sdk.pendo.io.l6.x;

/* loaded from: classes4.dex */
public abstract class j<T> implements m<T> {

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1748a;

        static {
            int[] iArr = new int[sdk.pendo.io.x5.a.values().length];
            f1748a = iArr;
            try {
                iArr[sdk.pendo.io.x5.a.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1748a[sdk.pendo.io.x5.a.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1748a[sdk.pendo.io.x5.a.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1748a[sdk.pendo.io.x5.a.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static int c() {
        return d.a();
    }

    public static <T> j<T> e() {
        return sdk.pendo.io.t6.a.a(sdk.pendo.io.l6.k.f);
    }

    public final <B> j<List<T>> a(m<B> mVar) {
        return (j<List<T>>) a(mVar, sdk.pendo.io.q6.b.a());
    }

    public final T b() {
        sdk.pendo.io.h6.e eVar = new sdk.pendo.io.h6.e();
        a((o) eVar);
        T b = eVar.b();
        if (b != null) {
            return b;
        }
        throw new NoSuchElementException();
    }

    protected abstract void b(o<? super T> oVar);

    public final j<T> d() {
        return a((sdk.pendo.io.d6.h) sdk.pendo.io.f6.a.c());
    }

    public final g<T> f() {
        return a(0L);
    }

    public final b g() {
        return sdk.pendo.io.t6.a.a(new r(this));
    }

    public final sdk.pendo.io.r6.a<T> h() {
        return x.f(this);
    }

    public final j<T> i() {
        return a(Long.MAX_VALUE, sdk.pendo.io.f6.a.a());
    }

    public final j<T> j() {
        return h().n();
    }

    public final g<T> k() {
        return sdk.pendo.io.t6.a.a(new g0(this));
    }

    public final q<T> l() {
        return sdk.pendo.io.t6.a.a(new h0(this, null));
    }

    public static j<Long> d(long j, TimeUnit timeUnit) {
        return a(j, j, timeUnit, sdk.pendo.io.v6.a.a());
    }

    public static j<Long> h(long j, TimeUnit timeUnit) {
        return e(j, timeUnit, sdk.pendo.io.v6.a.a());
    }

    public final <B, U extends Collection<? super T>> j<U> a(m<B> mVar, Callable<U> callable) {
        sdk.pendo.io.f6.b.a(mVar, "boundary is null");
        sdk.pendo.io.f6.b.a(callable, "bufferSupplier is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.b(this, mVar, callable));
    }

    public final j<T> b(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, sdk.pendo.io.v6.a.a(), false);
    }

    public final j<T> c(long j, TimeUnit timeUnit) {
        return b(j, timeUnit, sdk.pendo.io.v6.a.a());
    }

    public final j<T> e(sdk.pendo.io.d6.h<? super j<Throwable>, ? extends m<?>> hVar) {
        sdk.pendo.io.f6.b.a(hVar, "handler is null");
        return sdk.pendo.io.t6.a.a(new c0(this, hVar));
    }

    public final j<T> f(long j, TimeUnit timeUnit) {
        return e(j, timeUnit);
    }

    public final j<T> g(long j, TimeUnit timeUnit) {
        return b(j, timeUnit, sdk.pendo.io.v6.a.a(), false);
    }

    public static <T, R> j<R> a(sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, int i, m<? extends T>... mVarArr) {
        return a(mVarArr, hVar, i);
    }

    public static j<Long> c(long j, TimeUnit timeUnit, p pVar) {
        return a(j, j, timeUnit, pVar);
    }

    public final j<T> b(long j, TimeUnit timeUnit, p pVar) {
        return b(e(j, timeUnit, pVar));
    }

    public final j<T> d(sdk.pendo.io.d6.h<? super Throwable, ? extends T> hVar) {
        sdk.pendo.io.f6.b.a(hVar, "valueSupplier is null");
        return sdk.pendo.io.t6.a.a(new w(this, hVar));
    }

    public final j<T> e(long j, TimeUnit timeUnit) {
        return d(j, timeUnit, sdk.pendo.io.v6.a.a());
    }

    public static <T1, T2, R> j<R> a(m<? extends T1> mVar, m<? extends T2> mVar2, sdk.pendo.io.d6.b<? super T1, ? super T2, ? extends R> bVar) {
        sdk.pendo.io.f6.b.a(mVar, "source1 is null");
        sdk.pendo.io.f6.b.a(mVar2, "source2 is null");
        return a(sdk.pendo.io.f6.a.a((sdk.pendo.io.d6.b) bVar), c(), mVar, mVar2);
    }

    public static j<Long> e(long j, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.f6.b.a(timeUnit, "unit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new o0(Math.max(j, 0L), timeUnit, pVar));
    }

    public final <U> j<T> b(m<U> mVar) {
        sdk.pendo.io.f6.b.a(mVar, "other is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.g(this, mVar));
    }

    public final <R> j<R> c(sdk.pendo.io.d6.h<? super T, ? extends R> hVar) {
        sdk.pendo.io.f6.b.a(hVar, "mapper is null");
        return sdk.pendo.io.t6.a.a(new u(this, hVar));
    }

    public final j<T> d(long j, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.f6.b.a(timeUnit, "unit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new d0(this, j, timeUnit, pVar, false));
    }

    public static <T1, T2, T3, T4, R> j<R> a(m<? extends T1> mVar, m<? extends T2> mVar2, m<? extends T3> mVar3, m<? extends T4> mVar4, sdk.pendo.io.d6.g<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> gVar) {
        sdk.pendo.io.f6.b.a(mVar, "source1 is null");
        sdk.pendo.io.f6.b.a(mVar2, "source2 is null");
        sdk.pendo.io.f6.b.a(mVar3, "source3 is null");
        sdk.pendo.io.f6.b.a(mVar4, "source4 is null");
        return a(sdk.pendo.io.f6.a.a((sdk.pendo.io.d6.g) gVar), c(), mVar, mVar2, mVar3, mVar4);
    }

    public static <T> j<T> e(m<T> mVar) {
        sdk.pendo.io.f6.b.a(mVar, "source is null");
        return mVar instanceof j ? sdk.pendo.io.t6.a.a((j) mVar) : sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.q(mVar));
    }

    public final <R> j<R> b(sdk.pendo.io.d6.h<? super T, ? extends m<? extends R>> hVar) {
        return a((sdk.pendo.io.d6.h) hVar, false);
    }

    public final j<T> c(m<? extends T> mVar) {
        sdk.pendo.io.f6.b.a(mVar, "other is null");
        return a(this, mVar);
    }

    public final <U> j<T> d(m<U> mVar) {
        sdk.pendo.io.f6.b.a(mVar, "other is null");
        return sdk.pendo.io.t6.a.a(new l0(this, mVar));
    }

    public static <T, R> j<R> a(m<? extends T>[] mVarArr, sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, int i) {
        sdk.pendo.io.f6.b.a(mVarArr, "sources is null");
        if (mVarArr.length == 0) {
            return e();
        }
        sdk.pendo.io.f6.b.a(hVar, "combiner is null");
        sdk.pendo.io.f6.b.a(i, "bufferSize");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.c(mVarArr, null, hVar, i << 1, false));
    }

    public final j<T> b(long j) {
        return j <= 0 ? sdk.pendo.io.t6.a.a(this) : sdk.pendo.io.t6.a.a(new i0(this, j));
    }

    public final <E extends o<? super T>> E c(E e) {
        a((o) e);
        return e;
    }

    public final <R> j<R> a(n<? super T, ? extends R> nVar) {
        return e(((n) sdk.pendo.io.f6.b.a(nVar, "composer is null")).a(this));
    }

    public final j<T> b(p pVar) {
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new j0(this, pVar));
    }

    public final j<T> c(long j) {
        if (j >= 0) {
            return sdk.pendo.io.t6.a.a(new k0(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public static <T> j<T> a(l<T> lVar) {
        sdk.pendo.io.f6.b.a(lVar, "source is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.d(lVar));
    }

    public final j<T> b(sdk.pendo.io.d6.j<? super T> jVar) {
        sdk.pendo.io.f6.b.a(jVar, "predicate is null");
        return sdk.pendo.io.t6.a.a(new m0(this, jVar));
    }

    public final j<T> a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, sdk.pendo.io.v6.a.a());
    }

    public final j<T> b(long j, TimeUnit timeUnit, p pVar, boolean z) {
        sdk.pendo.io.f6.b.a(timeUnit, "unit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new n0(this, j, timeUnit, pVar, z));
    }

    public final j<T> a(long j, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.f6.b.a(timeUnit, "unit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.e(this, j, timeUnit, pVar));
    }

    public final j<T> a(long j, TimeUnit timeUnit, p pVar, boolean z) {
        sdk.pendo.io.f6.b.a(timeUnit, "unit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.f(this, j, timeUnit, pVar, z));
    }

    public final <K> j<T> a(sdk.pendo.io.d6.h<? super T, K> hVar) {
        sdk.pendo.io.f6.b.a(hVar, "keySelector is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.h(this, hVar, sdk.pendo.io.f6.b.a()));
    }

    public final j<T> a(sdk.pendo.io.d6.a aVar) {
        return a(sdk.pendo.io.f6.a.b(), sdk.pendo.io.f6.a.b(), aVar, sdk.pendo.io.f6.a.c);
    }

    private j<T> a(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar, sdk.pendo.io.d6.a aVar2) {
        sdk.pendo.io.f6.b.a(eVar, "onNext is null");
        sdk.pendo.io.f6.b.a(eVar2, "onError is null");
        sdk.pendo.io.f6.b.a(aVar, "onComplete is null");
        sdk.pendo.io.f6.b.a(aVar2, "onAfterTerminate is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.i(this, eVar, eVar2, aVar, aVar2));
    }

    public final g<T> a(long j) {
        if (j >= 0) {
            return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.j(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public static <T> j<T> a(Throwable th) {
        sdk.pendo.io.f6.b.a(th, "exception is null");
        return a((Callable<? extends Throwable>) sdk.pendo.io.f6.a.a(th));
    }

    public static <T> j<T> a(Callable<? extends Throwable> callable) {
        sdk.pendo.io.f6.b.a(callable, "errorSupplier is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.l(callable));
    }

    public final j<T> a(sdk.pendo.io.d6.j<? super T> jVar) {
        sdk.pendo.io.f6.b.a(jVar, "predicate is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.m(this, jVar));
    }

    public final <R> j<R> a(sdk.pendo.io.d6.h<? super T, ? extends m<? extends R>> hVar, int i) {
        return a((sdk.pendo.io.d6.h) hVar, false, i, c());
    }

    public final <R> j<R> a(sdk.pendo.io.d6.h<? super T, ? extends m<? extends R>> hVar, boolean z) {
        return a(hVar, z, Integer.MAX_VALUE);
    }

    public final <R> j<R> a(sdk.pendo.io.d6.h<? super T, ? extends m<? extends R>> hVar, boolean z, int i) {
        return a(hVar, z, i, c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> j<R> a(sdk.pendo.io.d6.h<? super T, ? extends m<? extends R>> hVar, boolean z, int i, int i2) {
        sdk.pendo.io.f6.b.a(hVar, "mapper is null");
        sdk.pendo.io.f6.b.a(i, "maxConcurrency");
        sdk.pendo.io.f6.b.a(i2, "bufferSize");
        if (!(this instanceof sdk.pendo.io.g6.e)) {
            return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.n(this, hVar, z, i, i2));
        }
        Object call = ((sdk.pendo.io.g6.e) this).call();
        return call == null ? e() : e0.a(call, hVar);
    }

    public static <T> j<T> a(T... tArr) {
        sdk.pendo.io.f6.b.a(tArr, "items is null");
        return tArr.length == 0 ? e() : tArr.length == 1 ? a(tArr[0]) : sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.o(tArr));
    }

    public static <T> j<T> a(Iterable<? extends T> iterable) {
        sdk.pendo.io.f6.b.a(iterable, "source is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.l6.p(iterable));
    }

    public static j<Long> a(long j, long j2, TimeUnit timeUnit, p pVar) {
        sdk.pendo.io.f6.b.a(timeUnit, "unit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new s(Math.max(0L, j), Math.max(0L, j2), timeUnit, pVar));
    }

    public static <T> j<T> a(T t) {
        sdk.pendo.io.f6.b.a((Object) t, "item is null");
        return sdk.pendo.io.t6.a.a((j) new t(t));
    }

    public static <T> j<T> a(m<? extends T> mVar, m<? extends T> mVar2) {
        sdk.pendo.io.f6.b.a(mVar, "source1 is null");
        sdk.pendo.io.f6.b.a(mVar2, "source2 is null");
        return a((Object[]) new m[]{mVar, mVar2}).a(sdk.pendo.io.f6.a.c(), false, 2);
    }

    public static <T> j<T> a(m<? extends T> mVar, m<? extends T> mVar2, m<? extends T> mVar3, m<? extends T> mVar4) {
        sdk.pendo.io.f6.b.a(mVar, "source1 is null");
        sdk.pendo.io.f6.b.a(mVar2, "source2 is null");
        sdk.pendo.io.f6.b.a(mVar3, "source3 is null");
        sdk.pendo.io.f6.b.a(mVar4, "source4 is null");
        return a((Object[]) new m[]{mVar, mVar2, mVar3, mVar4}).a(sdk.pendo.io.f6.a.c(), false, 4);
    }

    public static <T> j<T> a(m<? extends T>... mVarArr) {
        return a((Object[]) mVarArr).a(sdk.pendo.io.f6.a.c(), mVarArr.length);
    }

    public final j<T> a(p pVar) {
        return a(pVar, false, c());
    }

    public final j<T> a(p pVar, boolean z, int i) {
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        sdk.pendo.io.f6.b.a(i, "bufferSize");
        return sdk.pendo.io.t6.a.a(new v(this, pVar, z, i));
    }

    public final j<T> a(long j, sdk.pendo.io.d6.j<? super Throwable> jVar) {
        if (j < 0) {
            throw new IllegalArgumentException("times >= 0 required but it was " + j);
        }
        sdk.pendo.io.f6.b.a(jVar, "predicate is null");
        return sdk.pendo.io.t6.a.a(new b0(this, j, jVar));
    }

    public final j<T> a(sdk.pendo.io.d6.b<T, T, T> bVar) {
        sdk.pendo.io.f6.b.a(bVar, "accumulator is null");
        return sdk.pendo.io.t6.a.a(new f0(this, bVar));
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar) {
        return a(eVar, sdk.pendo.io.f6.a.f, sdk.pendo.io.f6.a.c, sdk.pendo.io.f6.a.b());
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2) {
        return a(eVar, eVar2, sdk.pendo.io.f6.a.c, sdk.pendo.io.f6.a.b());
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar, sdk.pendo.io.d6.e<? super sdk.pendo.io.b6.b> eVar3) {
        sdk.pendo.io.f6.b.a(eVar, "onNext is null");
        sdk.pendo.io.f6.b.a(eVar2, "onError is null");
        sdk.pendo.io.f6.b.a(aVar, "onComplete is null");
        sdk.pendo.io.f6.b.a(eVar3, "onSubscribe is null");
        sdk.pendo.io.h6.f fVar = new sdk.pendo.io.h6.f(eVar, eVar2, aVar, eVar3);
        a((o) fVar);
        return fVar;
    }

    @Override // sdk.pendo.io.x5.m
    public final void a(o<? super T> oVar) {
        sdk.pendo.io.f6.b.a(oVar, "observer is null");
        try {
            o<? super T> a2 = sdk.pendo.io.t6.a.a(this, oVar);
            sdk.pendo.io.f6.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            b(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            sdk.pendo.io.t6.a.b(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final d<T> a(sdk.pendo.io.x5.a aVar) {
        sdk.pendo.io.j6.f fVar = new sdk.pendo.io.j6.f(this);
        int i = a.f1748a[aVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? fVar.c() : sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.k(fVar)) : fVar : fVar.e() : fVar.d();
    }

    public static <T1, T2, T3, R> j<R> a(m<? extends T1> mVar, m<? extends T2> mVar2, m<? extends T3> mVar3, sdk.pendo.io.d6.f<? super T1, ? super T2, ? super T3, ? extends R> fVar) {
        sdk.pendo.io.f6.b.a(mVar, "source1 is null");
        sdk.pendo.io.f6.b.a(mVar2, "source2 is null");
        sdk.pendo.io.f6.b.a(mVar3, "source3 is null");
        return a(sdk.pendo.io.f6.a.a((sdk.pendo.io.d6.f) fVar), false, c(), mVar, mVar2, mVar3);
    }

    public static <T, R> j<R> a(sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, boolean z, int i, m<? extends T>... mVarArr) {
        if (mVarArr.length == 0) {
            return e();
        }
        sdk.pendo.io.f6.b.a(hVar, "zipper is null");
        sdk.pendo.io.f6.b.a(i, "bufferSize");
        return sdk.pendo.io.t6.a.a(new p0(mVarArr, null, hVar, i, z));
    }
}
