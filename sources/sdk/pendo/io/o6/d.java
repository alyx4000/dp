package sdk.pendo.io.o6;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.q6.h;
import sdk.pendo.io.x5.e;

/* loaded from: classes6.dex */
public class d<T> extends AtomicInteger implements e<T>, sdk.pendo.io.w5.c {
    final sdk.pendo.io.w5.b<? super T> f;
    volatile boolean u0;
    final sdk.pendo.io.q6.c s = new sdk.pendo.io.q6.c();
    final AtomicLong A = new AtomicLong();
    final AtomicReference<sdk.pendo.io.w5.c> f0 = new AtomicReference<>();
    final AtomicBoolean t0 = new AtomicBoolean();

    public d(sdk.pendo.io.w5.b<? super T> bVar) {
        this.f = bVar;
    }

    @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
    public void a(sdk.pendo.io.w5.c cVar) {
        if (this.t0.compareAndSet(false, true)) {
            this.f.a(this);
            sdk.pendo.io.p6.c.a(this.f0, this.A, cVar);
        } else {
            cVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // sdk.pendo.io.w5.c
    public void cancel() {
        if (this.u0) {
            return;
        }
        sdk.pendo.io.p6.c.a(this.f0);
    }

    @Override // sdk.pendo.io.w5.b
    public void onComplete() {
        this.u0 = true;
        h.a(this.f, this, this.s);
    }

    @Override // sdk.pendo.io.w5.b
    public void onError(Throwable th) {
        this.u0 = true;
        h.a((sdk.pendo.io.w5.b<?>) this.f, th, (AtomicInteger) this, this.s);
    }

    @Override // sdk.pendo.io.w5.b
    public void onNext(T t) {
        h.a(this.f, t, this, this.s);
    }

    @Override // sdk.pendo.io.w5.c
    public void a(long j) {
        if (j > 0) {
            sdk.pendo.io.p6.c.a(this.f0, this.A, j);
        } else {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j));
        }
    }
}
