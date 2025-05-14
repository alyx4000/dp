package sdk.pendo.io.l6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class n0<T> extends sdk.pendo.io.l6.a<T, T> {
    final TimeUnit A;
    final sdk.pendo.io.x5.p f0;
    final long s;
    final boolean t0;

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b, Runnable {
        final TimeUnit A;
        boolean A0;
        final sdk.pendo.io.x5.o<? super T> f;
        final p.c f0;
        final long s;
        final boolean t0;
        final AtomicReference<T> u0 = new AtomicReference<>();
        sdk.pendo.io.b6.b v0;
        volatile boolean w0;
        Throwable x0;
        volatile boolean y0;
        volatile boolean z0;

        a(sdk.pendo.io.x5.o<? super T> oVar, long j, TimeUnit timeUnit, p.c cVar, boolean z) {
            this.f = oVar;
            this.s = j;
            this.A = timeUnit;
            this.f0 = cVar;
            this.t0 = z;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.y0;
        }

        void b() {
            if (getAndIncrement() != 0) {
                return;
            }
            AtomicReference<T> atomicReference = this.u0;
            sdk.pendo.io.x5.o<? super T> oVar = this.f;
            int i = 1;
            while (!this.y0) {
                boolean z = this.w0;
                if (!z || this.x0 == null) {
                    boolean z2 = atomicReference.get() == null;
                    if (z) {
                        T andSet = atomicReference.getAndSet(null);
                        if (!z2 && this.t0) {
                            oVar.onNext(andSet);
                        }
                        oVar.onComplete();
                    } else {
                        if (z2) {
                            if (this.z0) {
                                this.A0 = false;
                                this.z0 = false;
                            }
                        } else if (!this.A0 || this.z0) {
                            oVar.onNext(atomicReference.getAndSet(null));
                            this.z0 = false;
                            this.A0 = true;
                            this.f0.a(this, this.s, this.A);
                        }
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    atomicReference.lazySet(null);
                    oVar.onError(this.x0);
                }
                this.f0.dispose();
                return;
            }
            atomicReference.lazySet(null);
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.y0 = true;
            this.v0.dispose();
            this.f0.dispose();
            if (getAndIncrement() == 0) {
                this.u0.lazySet(null);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.w0 = true;
            b();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.x0 = th;
            this.w0 = true;
            b();
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            this.u0.set(t);
            b();
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.v0, bVar)) {
                this.v0 = bVar;
                this.f.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.z0 = true;
            b();
        }
    }

    public n0(sdk.pendo.io.x5.j<T> jVar, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar, boolean z) {
        super(jVar);
        this.s = j;
        this.A = timeUnit;
        this.f0 = pVar;
        this.t0 = z;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s, this.A, this.f0.a(), this.t0));
    }
}
