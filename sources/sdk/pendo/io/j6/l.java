package sdk.pendo.io.j6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class l<T> extends sdk.pendo.io.j6.a<T, T> {

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c {
        volatile boolean A;
        final sdk.pendo.io.w5.b<? super T> f;
        Throwable f0;
        sdk.pendo.io.w5.c s;
        volatile boolean t0;
        final AtomicLong u0 = new AtomicLong();
        final AtomicReference<T> v0 = new AtomicReference<>();

        a(sdk.pendo.io.w5.b<? super T> bVar) {
            this.f = bVar;
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.w5.b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.t0) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.f0;
            if (th != null) {
                atomicReference.lazySet(null);
                bVar.onError(th);
                return true;
            }
            if (!z2) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            if (this.t0) {
                return;
            }
            this.t0 = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.v0.lazySet(null);
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            this.A = true;
            a();
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            this.f0 = th;
            this.A = true;
            a();
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            this.v0.lazySet(t);
            a();
        }

        void a() {
            if (getAndIncrement() != 0) {
                return;
            }
            sdk.pendo.io.w5.b<? super T> bVar = this.f;
            AtomicLong atomicLong = this.u0;
            AtomicReference<T> atomicReference = this.v0;
            int i = 1;
            do {
                long j = 0;
                while (true) {
                    if (j == atomicLong.get()) {
                        break;
                    }
                    boolean z = this.A;
                    T andSet = atomicReference.getAndSet(null);
                    boolean z2 = andSet == null;
                    if (a(z, z2, bVar, atomicReference)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    bVar.onNext(andSet);
                    j++;
                }
                if (j == atomicLong.get()) {
                    if (a(this.A, atomicReference.get() == null, bVar, atomicReference)) {
                        return;
                    }
                }
                if (j != 0) {
                    sdk.pendo.io.q6.d.c(atomicLong, j);
                }
                i = addAndGet(-i);
            } while (i != 0);
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.s, cVar)) {
                this.s = cVar;
                this.f.a(this);
                cVar.a(Long.MAX_VALUE);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            if (sdk.pendo.io.p6.c.c(j)) {
                sdk.pendo.io.q6.d.a(this.u0, j);
                a();
            }
        }
    }

    public l(sdk.pendo.io.x5.d<T> dVar) {
        super(dVar);
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        this.s.a((sdk.pendo.io.x5.e) new a(bVar));
    }
}
