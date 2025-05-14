package sdk.pendo.io.o6;

import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.e;

/* loaded from: classes6.dex */
public final class c<T> extends AtomicReference<sdk.pendo.io.w5.c> implements e<T>, sdk.pendo.io.w5.c, sdk.pendo.io.b6.b {
    final sdk.pendo.io.d6.a A;
    final sdk.pendo.io.d6.e<? super T> f;
    final sdk.pendo.io.d6.e<? super sdk.pendo.io.w5.c> f0;
    final sdk.pendo.io.d6.e<? super Throwable> s;

    public c(sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar, sdk.pendo.io.d6.e<? super sdk.pendo.io.w5.c> eVar3) {
        this.f = eVar;
        this.s = eVar2;
        this.A = aVar;
        this.f0 = eVar3;
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return get() == sdk.pendo.io.p6.c.CANCELLED;
    }

    @Override // sdk.pendo.io.w5.c
    public void cancel() {
        sdk.pendo.io.p6.c.a(this);
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        cancel();
    }

    @Override // sdk.pendo.io.w5.b
    public void onComplete() {
        sdk.pendo.io.w5.c cVar = get();
        sdk.pendo.io.p6.c cVar2 = sdk.pendo.io.p6.c.CANCELLED;
        if (cVar != cVar2) {
            lazySet(cVar2);
            try {
                this.A.run();
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                sdk.pendo.io.t6.a.b(th);
            }
        }
    }

    @Override // sdk.pendo.io.w5.b
    public void onError(Throwable th) {
        sdk.pendo.io.w5.c cVar = get();
        sdk.pendo.io.p6.c cVar2 = sdk.pendo.io.p6.c.CANCELLED;
        if (cVar == cVar2) {
            sdk.pendo.io.t6.a.b(th);
            return;
        }
        lazySet(cVar2);
        try {
            this.s.accept(th);
        } catch (Throwable th2) {
            sdk.pendo.io.c6.b.b(th2);
            sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(th, th2));
        }
    }

    @Override // sdk.pendo.io.w5.b
    public void onNext(T t) {
        if (a()) {
            return;
        }
        try {
            this.f.accept(t);
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            get().cancel();
            onError(th);
        }
    }

    @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
    public void a(sdk.pendo.io.w5.c cVar) {
        if (sdk.pendo.io.p6.c.a((AtomicReference<sdk.pendo.io.w5.c>) this, cVar)) {
            try {
                this.f0.accept(this);
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                cVar.cancel();
                onError(th);
            }
        }
    }

    @Override // sdk.pendo.io.w5.c
    public void a(long j) {
        get().a(j);
    }
}
