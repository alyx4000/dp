package sdk.pendo.io.l6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class o0 extends sdk.pendo.io.x5.j<Long> {
    final TimeUnit A;
    final sdk.pendo.io.x5.p f;
    final long s;

    static final class a extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.b6.b, Runnable {
        final sdk.pendo.io.x5.o<? super Long> f;

        a(sdk.pendo.io.x5.o<? super Long> oVar) {
            this.f = oVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() == sdk.pendo.io.e6.b.DISPOSED;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a()) {
                return;
            }
            this.f.onNext(0L);
            lazySet(sdk.pendo.io.e6.c.INSTANCE);
            this.f.onComplete();
        }

        public void a(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.d(this, bVar);
        }
    }

    public o0(long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar) {
        this.s = j;
        this.A = timeUnit;
        this.f = pVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super Long> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        aVar.a(this.f.a(aVar, this.s, this.A));
    }
}
