package sdk.pendo.io.k6;

import sdk.pendo.io.x5.h;

/* loaded from: classes6.dex */
final class d<T, R> implements h<T>, sdk.pendo.io.b6.b {
    sdk.pendo.io.b6.b A;
    final h<? super R> f;
    final sdk.pendo.io.d6.h<? super T, ? extends R> s;

    d(h<? super R> hVar, sdk.pendo.io.d6.h<? super T, ? extends R> hVar2) {
        this.f = hVar;
        this.s = hVar2;
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this.A.a();
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        sdk.pendo.io.b6.b bVar = this.A;
        this.A = sdk.pendo.io.e6.b.DISPOSED;
        bVar.dispose();
    }

    @Override // sdk.pendo.io.x5.h
    public void onComplete() {
        this.f.onComplete();
    }

    @Override // sdk.pendo.io.x5.h
    public void onError(Throwable th) {
        this.f.onError(th);
    }

    @Override // sdk.pendo.io.x5.h
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        if (sdk.pendo.io.e6.b.a(this.A, bVar)) {
            this.A = bVar;
            this.f.onSubscribe(this);
        }
    }

    @Override // sdk.pendo.io.x5.h
    public void onSuccess(T t) {
        try {
            this.f.onSuccess(sdk.pendo.io.f6.b.a(this.s.apply(t), "The mapper returned a null item"));
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            this.f.onError(th);
        }
    }
}
