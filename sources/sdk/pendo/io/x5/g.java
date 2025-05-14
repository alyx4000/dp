package sdk.pendo.io.x5;

/* loaded from: classes4.dex */
public abstract class g<T> implements i<T> {
    public static <T> g<T> a() {
        return sdk.pendo.io.t6.a.a((g) sdk.pendo.io.k6.c.f);
    }

    public final g<T> b(p pVar) {
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.k6.f(this, pVar));
    }

    protected abstract void b(h<? super T> hVar);

    public final <E extends h<? super T>> E c(E e) {
        a(e);
        return e;
    }

    public final g<T> a(p pVar) {
        sdk.pendo.io.f6.b.a(pVar, "scheduler is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.k6.e(this, pVar));
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar) {
        return a(eVar, sdk.pendo.io.f6.a.f, sdk.pendo.io.f6.a.c);
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2) {
        return a(eVar, eVar2, sdk.pendo.io.f6.a.c);
    }

    public final sdk.pendo.io.b6.b a(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar) {
        sdk.pendo.io.f6.b.a(eVar, "onSuccess is null");
        sdk.pendo.io.f6.b.a(eVar2, "onError is null");
        sdk.pendo.io.f6.b.a(aVar, "onComplete is null");
        return (sdk.pendo.io.b6.b) c(new sdk.pendo.io.k6.b(eVar, eVar2, aVar));
    }

    @Override // sdk.pendo.io.x5.i
    public final void a(h<? super T> hVar) {
        sdk.pendo.io.f6.b.a(hVar, "observer is null");
        h<? super T> a2 = sdk.pendo.io.t6.a.a(this, hVar);
        sdk.pendo.io.f6.b.a(a2, "The RxJavaPlugins.onSubscribe hook returned a null MaybeObserver. Please check the handler provided to RxJavaPlugins.setOnMaybeSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            b(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T1, T2, R> g<R> a(i<? extends T1> iVar, i<? extends T2> iVar2, sdk.pendo.io.d6.b<? super T1, ? super T2, ? extends R> bVar) {
        sdk.pendo.io.f6.b.a(iVar, "source1 is null");
        sdk.pendo.io.f6.b.a(iVar2, "source2 is null");
        return a(sdk.pendo.io.f6.a.a((sdk.pendo.io.d6.b) bVar), iVar, iVar2);
    }

    public static <T, R> g<R> a(sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, i<? extends T>... iVarArr) {
        sdk.pendo.io.f6.b.a(iVarArr, "sources is null");
        if (iVarArr.length == 0) {
            return a();
        }
        sdk.pendo.io.f6.b.a(hVar, "zipper is null");
        return sdk.pendo.io.t6.a.a(new sdk.pendo.io.k6.g(iVarArr, hVar));
    }
}
