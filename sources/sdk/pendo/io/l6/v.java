package sdk.pendo.io.l6;

import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class v<T> extends sdk.pendo.io.l6.a<T, T> {
    final boolean A;
    final int f0;
    final sdk.pendo.io.x5.p s;

    static final class a<T> extends sdk.pendo.io.h6.b<T> implements sdk.pendo.io.x5.o<T>, Runnable {
        final boolean A;
        final sdk.pendo.io.x5.o<? super T> f;
        final int f0;
        final p.c s;
        sdk.pendo.io.g6.g<T> t0;
        sdk.pendo.io.b6.b u0;
        Throwable v0;
        volatile boolean w0;
        volatile boolean x0;
        int y0;
        boolean z0;

        a(sdk.pendo.io.x5.o<? super T> oVar, p.c cVar, boolean z, int i) {
            this.f = oVar;
            this.s = cVar;
            this.A = z;
            this.f0 = i;
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.x5.o<? super T> oVar) {
            if (this.x0) {
                this.t0.clear();
                return true;
            }
            if (!z) {
                return false;
            }
            Throwable th = this.v0;
            if (this.A) {
                if (!z2) {
                    return false;
                }
                this.x0 = true;
                if (th != null) {
                    oVar.onError(th);
                } else {
                    oVar.onComplete();
                }
                this.s.dispose();
                return true;
            }
            if (th != null) {
                this.x0 = true;
                this.t0.clear();
                oVar.onError(th);
                this.s.dispose();
                return true;
            }
            if (!z2) {
                return false;
            }
            this.x0 = true;
            oVar.onComplete();
            this.s.dispose();
            return true;
        }

        void b() {
            int i = 1;
            while (!this.x0) {
                boolean z = this.w0;
                Throwable th = this.v0;
                if (this.A || !z || th == null) {
                    this.f.onNext(null);
                    if (z) {
                        this.x0 = true;
                        Throwable th2 = this.v0;
                        if (th2 != null) {
                            this.f.onError(th2);
                        } else {
                            this.f.onComplete();
                        }
                    } else {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } else {
                    this.x0 = true;
                    this.f.onError(this.v0);
                }
                this.s.dispose();
                return;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0027, code lost:
        
            r3 = addAndGet(-r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        
            if (r3 != 0) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void c() {
            /*
                r7 = this;
                sdk.pendo.io.g6.g<T> r0 = r7.t0
                sdk.pendo.io.x5.o<? super T> r1 = r7.f
                r2 = 1
                r3 = r2
            L6:
                boolean r4 = r7.w0
                boolean r5 = r0.isEmpty()
                boolean r4 = r7.a(r4, r5, r1)
                if (r4 == 0) goto L13
                return
            L13:
                boolean r4 = r7.w0
                java.lang.Object r5 = r0.poll()     // Catch: java.lang.Throwable -> L33
                if (r5 != 0) goto L1d
                r6 = r2
                goto L1e
            L1d:
                r6 = 0
            L1e:
                boolean r4 = r7.a(r4, r6, r1)
                if (r4 == 0) goto L25
                return
            L25:
                if (r6 == 0) goto L2f
                int r3 = -r3
                int r3 = r7.addAndGet(r3)
                if (r3 != 0) goto L6
                return
            L2f:
                r1.onNext(r5)
                goto L13
            L33:
                r3 = move-exception
                sdk.pendo.io.c6.b.b(r3)
                r7.x0 = r2
                sdk.pendo.io.b6.b r2 = r7.u0
                r2.dispose()
                r0.clear()
                r1.onError(r3)
                sdk.pendo.io.x5.p$c r0 = r7.s
                r0.dispose()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.l6.v.a.c():void");
        }

        @Override // sdk.pendo.io.g6.g
        public void clear() {
            this.t0.clear();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.x0) {
                return;
            }
            this.x0 = true;
            this.u0.dispose();
            this.s.dispose();
            if (this.z0 || getAndIncrement() != 0) {
                return;
            }
            this.t0.clear();
        }

        void e() {
            if (getAndIncrement() == 0) {
                this.s.a(this);
            }
        }

        @Override // sdk.pendo.io.g6.g
        public boolean isEmpty() {
            return this.t0.isEmpty();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.w0) {
                return;
            }
            this.w0 = true;
            e();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.w0) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.v0 = th;
            this.w0 = true;
            e();
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.w0) {
                return;
            }
            if (this.y0 != 2) {
                this.t0.offer(t);
            }
            e();
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.u0, bVar)) {
                this.u0 = bVar;
                if (bVar instanceof sdk.pendo.io.g6.b) {
                    sdk.pendo.io.g6.b bVar2 = (sdk.pendo.io.g6.b) bVar;
                    int a2 = bVar2.a(7);
                    if (a2 == 1) {
                        this.y0 = a2;
                        this.t0 = bVar2;
                        this.w0 = true;
                        this.f.onSubscribe(this);
                        e();
                        return;
                    }
                    if (a2 == 2) {
                        this.y0 = a2;
                        this.t0 = bVar2;
                        this.f.onSubscribe(this);
                        return;
                    }
                }
                this.t0 = new sdk.pendo.io.m6.c(this.f0);
                this.f.onSubscribe(this);
            }
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            return this.t0.poll();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.z0) {
                b();
            } else {
                c();
            }
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.x0;
        }

        @Override // sdk.pendo.io.g6.c
        public int a(int i) {
            if ((i & 2) == 0) {
                return 0;
            }
            this.z0 = true;
            return 2;
        }
    }

    public v(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.x5.p pVar, boolean z, int i) {
        super(mVar);
        this.s = pVar;
        this.A = z;
        this.f0 = i;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        sdk.pendo.io.x5.p pVar = this.s;
        if (pVar instanceof sdk.pendo.io.n6.p) {
            this.f.a(oVar);
        } else {
            this.f.a(new a(oVar, pVar.a(), this.A, this.f0));
        }
    }
}
