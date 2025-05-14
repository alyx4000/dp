package sdk.pendo.io.l6;

import sdk.pendo.io.l6.e0;

/* loaded from: classes6.dex */
public final class t<T> extends sdk.pendo.io.x5.j<T> implements sdk.pendo.io.g6.e<T> {
    private final T f;

    public t(T t) {
        this.f = t;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        e0.a aVar = new e0.a(oVar, this.f);
        oVar.onSubscribe(aVar);
        aVar.run();
    }

    @Override // sdk.pendo.io.g6.e, java.util.concurrent.Callable
    public T call() {
        return this.f;
    }
}
