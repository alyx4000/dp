package sdk.pendo.io.j6;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public final class i<T> extends sdk.pendo.io.j6.a<T, T> {
    final int A;
    final boolean f0;
    final boolean t0;
    final sdk.pendo.io.d6.a u0;

    static final class a<T> extends sdk.pendo.io.p6.a<T> implements sdk.pendo.io.x5.e<T> {
        final boolean A;
        final sdk.pendo.io.w5.b<? super T> f;
        final sdk.pendo.io.d6.a f0;
        final sdk.pendo.io.g6.f<T> s;
        sdk.pendo.io.w5.c t0;
        volatile boolean u0;
        volatile boolean v0;
        Throwable w0;
        final AtomicLong x0 = new AtomicLong();
        boolean y0;

        a(sdk.pendo.io.w5.b<? super T> bVar, int i, boolean z, boolean z2, sdk.pendo.io.d6.a aVar) {
            this.f = bVar;
            this.f0 = aVar;
            this.A = z2;
            this.s = z ? new sdk.pendo.io.m6.c<>(i) : new sdk.pendo.io.m6.b<>(i);
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.w5.b<? super T> bVar) {
            if (this.u0) {
                this.s.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            if (this.A) {
                if (!z2) {
                    return false;
                }
                Throwable th = this.w0;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.w0;
            if (th2 != null) {
                this.s.clear();
                bVar.onError(th2);
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
            if (this.u0) {
                return;
            }
            this.u0 = true;
            this.t0.cancel();
            if (this.y0 || getAndIncrement() != 0) {
                return;
            }
            this.s.clear();
        }

        @Override // sdk.pendo.io.g6.g
        public void clear() {
            this.s.clear();
        }

        @Override // sdk.pendo.io.g6.g
        public boolean isEmpty() {
            return this.s.isEmpty();
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            this.v0 = true;
            if (this.y0) {
                this.f.onComplete();
            } else {
                a();
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            this.w0 = th;
            this.v0 = true;
            if (this.y0) {
                this.f.onError(th);
            } else {
                a();
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (this.s.offer(t)) {
                if (this.y0) {
                    this.f.onNext(null);
                    return;
                } else {
                    a();
                    return;
                }
            }
            this.t0.cancel();
            sdk.pendo.io.c6.c cVar = new sdk.pendo.io.c6.c("Buffer is full");
            try {
                this.f0.run();
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                cVar.initCause(th);
            }
            onError(cVar);
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            return this.s.poll();
        }

        void a() {
            if (getAndIncrement() == 0) {
                sdk.pendo.io.g6.f<T> fVar = this.s;
                sdk.pendo.io.w5.b<? super T> bVar = this.f;
                int i = 1;
                while (!a(this.v0, fVar.isEmpty(), bVar)) {
                    long j = this.x0.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z = this.v0;
                        T poll = fVar.poll();
                        boolean z2 = poll == null;
                        if (a(z, z2, bVar)) {
                            return;
                        }
                        if (z2) {
                            break;
                        }
                        bVar.onNext(poll);
                        j2++;
                    }
                    if (j2 == j && a(this.v0, fVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j2 != 0 && j != Long.MAX_VALUE) {
                        this.x0.addAndGet(-j2);
                    }
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.t0, cVar)) {
                this.t0 = cVar;
                this.f.a(this);
                cVar.a(Long.MAX_VALUE);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            if (this.y0 || !sdk.pendo.io.p6.c.c(j)) {
                return;
            }
            sdk.pendo.io.q6.d.a(this.x0, j);
            a();
        }
    }

    public i(sdk.pendo.io.x5.d<T> dVar, int i, boolean z, boolean z2, sdk.pendo.io.d6.a aVar) {
        super(dVar);
        this.A = i;
        this.f0 = z;
        this.t0 = z2;
        this.u0 = aVar;
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        this.s.a((sdk.pendo.io.x5.e) new a(bVar, this.A, this.f0, this.t0, this.u0));
    }
}
