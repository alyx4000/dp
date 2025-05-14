package sdk.pendo.io.l6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class s extends sdk.pendo.io.x5.j<Long> {
    final long A;
    final sdk.pendo.io.x5.p f;
    final TimeUnit f0;
    final long s;

    static final class a extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.b6.b, Runnable {
        final sdk.pendo.io.x5.o<? super Long> f;
        long s;

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
            if (get() != sdk.pendo.io.e6.b.DISPOSED) {
                sdk.pendo.io.x5.o<? super Long> oVar = this.f;
                long j = this.s;
                this.s = 1 + j;
                oVar.onNext(Long.valueOf(j));
            }
        }

        public void a(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this, bVar);
        }
    }

    public s(long j, long j2, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar) {
        this.s = j;
        this.A = j2;
        this.f0 = timeUnit;
        this.f = pVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super Long> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        sdk.pendo.io.x5.p pVar = this.f;
        if (!(pVar instanceof sdk.pendo.io.n6.p)) {
            aVar.a(pVar.a(aVar, this.s, this.A, this.f0));
            return;
        }
        p.c a2 = pVar.a();
        aVar.a(a2);
        a2.a(aVar, this.s, this.A, this.f0);
    }
}
