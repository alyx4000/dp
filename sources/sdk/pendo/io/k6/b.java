package sdk.pendo.io.k6;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.h;

/* loaded from: classes6.dex */
public final class b<T> extends AtomicReference<sdk.pendo.io.b6.b> implements h<T>, sdk.pendo.io.b6.b {
    final sdk.pendo.io.d6.a A;
    final sdk.pendo.io.d6.e<? super T> f;
    final sdk.pendo.io.d6.e<? super Throwable> s;

    public b(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar) {
        this.f = eVar;
        this.s = eVar2;
        this.A = aVar;
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return sdk.pendo.io.e6.b.a(get());
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
    }

    @Override // sdk.pendo.io.x5.h
    public void onComplete() {
        lazySet(sdk.pendo.io.e6.b.DISPOSED);
        try {
            this.A.run();
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            sdk.pendo.io.t6.a.b(th);
        }
    }

    @Override // sdk.pendo.io.x5.h
    public void onError(Throwable th) {
        lazySet(sdk.pendo.io.e6.b.DISPOSED);
        try {
            this.s.accept(th);
        } catch (Throwable th2) {
            sdk.pendo.io.c6.b.b(th2);
            sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(th, th2));
        }
    }

    @Override // sdk.pendo.io.x5.h
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        sdk.pendo.io.e6.b.c(this, bVar);
    }

    @Override // sdk.pendo.io.x5.h
    public void onSuccess(T t) {
        lazySet(sdk.pendo.io.e6.b.DISPOSED);
        try {
            this.f.accept(t);
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            sdk.pendo.io.t6.a.b(th);
        }
    }
}
