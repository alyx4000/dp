package sdk.pendo.io.h6;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public final class f<T> extends AtomicReference<sdk.pendo.io.b6.b> implements o<T>, sdk.pendo.io.b6.b {
    final sdk.pendo.io.d6.a A;
    final sdk.pendo.io.d6.e<? super T> f;
    final sdk.pendo.io.d6.e<? super sdk.pendo.io.b6.b> f0;
    final sdk.pendo.io.d6.e<? super Throwable> s;

    public f(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar, sdk.pendo.io.d6.e<? super sdk.pendo.io.b6.b> eVar3) {
        this.f = eVar;
        this.s = eVar2;
        this.A = aVar;
        this.f0 = eVar3;
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return get() == sdk.pendo.io.e6.b.DISPOSED;
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
    }

    @Override // sdk.pendo.io.x5.o
    public void onComplete() {
        if (a()) {
            return;
        }
        lazySet(sdk.pendo.io.e6.b.DISPOSED);
        try {
            this.A.run();
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            sdk.pendo.io.t6.a.b(th);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        if (a()) {
            sdk.pendo.io.t6.a.b(th);
            return;
        }
        lazySet(sdk.pendo.io.e6.b.DISPOSED);
        try {
            this.s.accept(th);
        } catch (Throwable th2) {
            sdk.pendo.io.c6.b.b(th2);
            sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(th, th2));
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onNext(T t) {
        if (a()) {
            return;
        }
        try {
            this.f.accept(t);
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        if (sdk.pendo.io.e6.b.c(this, bVar)) {
            try {
                this.f0.accept(this);
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
