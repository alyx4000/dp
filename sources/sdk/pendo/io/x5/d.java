package sdk.pendo.io.x5;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class d<T> implements sdk.pendo.io.w5.a<T> {
    static final int f = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public final d<List<T>> a(int i) {
        return a(i, i);
    }

    public final g<T> b() {
        return a(0L);
    }

    protected abstract void b(sdk.pendo.io.w5.b<? super T> bVar);

    public final d<T> c() {
        return a(a(), false, true);
    }

    public final d<T> d() {
        return sdk.pendo.io.t6.a.a((d) new sdk.pendo.io.j6.j(this));
    }

    public final d<T> e() {
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.l(this));
    }

    public final d<List<T>> a(int i, int i2) {
        return (d<List<T>>) a(i, i2, sdk.pendo.io.q6.b.a());
    }

    public final <U> d<T> b(sdk.pendo.io.w5.a<U> aVar) {
        sdk.pendo.io.f6.b.a(aVar, "other is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.m(this, aVar));
    }

    public final <U extends Collection<? super T>> d<U> a(int i, int i2, Callable<U> callable) {
        sdk.pendo.io.f6.b.a(i, "count");
        sdk.pendo.io.f6.b.a(i2, "skip");
        sdk.pendo.io.f6.b.a(callable, "bufferSupplier is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.b(this, i, i2, callable));
    }

    public final d<T> b(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, (sdk.pendo.io.w5.a) null, sdk.pendo.io.v6.a.a());
    }

    public static int a() {
        return f;
    }

    public final <R> d<R> a(f<? super T, ? extends R> fVar) {
        return a(((f) sdk.pendo.io.f6.b.a(fVar, "composer is null")).a(this));
    }

    public final d<T> a(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, sdk.pendo.io.v6.a.a(), false);
    }

    public final d<T> a(long j, TimeUnit timeUnit, p pVar, boolean z) {
        sdk.pendo.io.f6.b.a(timeUnit, "unit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.c(this, Math.max(0L, j), timeUnit, pVar, z));
    }

    public final g<T> a(long j) {
        if (j >= 0) {
            return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.d(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final d<T> a(sdk.pendo.io.d6.j<? super T> jVar) {
        sdk.pendo.io.f6.b.a(jVar, "predicate is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.e(this, jVar));
    }

    public static <T> d<T> a(sdk.pendo.io.w5.a<? extends T> aVar) {
        if (aVar instanceof d) {
            return sdk.pendo.io.t6.a.a((d) aVar);
        }
        sdk.pendo.io.f6.b.a(aVar, "source is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.g(aVar));
    }

    public final d<T> a(int i, boolean z, boolean z2) {
        sdk.pendo.io.f6.b.a(i, "capacity");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.i(this, i, z2, z, sdk.pendo.io.f6.a.c));
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2) {
        return a(eVar, eVar2, sdk.pendo.io.f6.a.c, sdk.pendo.io.j6.h.INSTANCE);
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar, sdk.pendo.io.d6.e<? super sdk.pendo.io.w5.c> eVar3) {
        sdk.pendo.io.f6.b.a(eVar, "onNext is null");
        sdk.pendo.io.f6.b.a(eVar2, "onError is null");
        sdk.pendo.io.f6.b.a(aVar, "onComplete is null");
        sdk.pendo.io.f6.b.a(eVar3, "onSubscribe is null");
        sdk.pendo.io.o6.c cVar = new sdk.pendo.io.o6.c(eVar, eVar2, aVar, eVar3);
        a((e) cVar);
        return cVar;
    }

    @Override // sdk.pendo.io.w5.a
    public final void a(sdk.pendo.io.w5.b<? super T> bVar) {
        if (bVar instanceof e) {
            a((e) bVar);
        } else {
            sdk.pendo.io.f6.b.a(bVar, "s is null");
            a((e) new sdk.pendo.io.o6.d(bVar));
        }
    }

    public final void a(e<? super T> eVar) {
        sdk.pendo.io.f6.b.a(eVar, "s is null");
        try {
            sdk.pendo.io.w5.b<? super T> a2 = sdk.pendo.io.t6.a.a(this, eVar);
            sdk.pendo.io.f6.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
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

    private d<T> a(long j, TimeUnit timeUnit, sdk.pendo.io.w5.a<? extends T> aVar, p pVar) {
        sdk.pendo.io.f6.b.a(timeUnit, "timeUnit is null");
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.j6.n(this, j, timeUnit, pVar, aVar));
    }
}
