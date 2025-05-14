package sdk.pendo.io.l6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class a0<T> extends sdk.pendo.io.x5.j<T> {
    final long A;
    final sdk.pendo.io.r6.a<T> f;
    final TimeUnit f0;
    final int s;
    final sdk.pendo.io.x5.p t0;
    a u0;

    static final class a extends AtomicReference<sdk.pendo.io.b6.b> implements Runnable, sdk.pendo.io.d6.e<sdk.pendo.io.b6.b> {
        long A;
        final a0<?> f;
        boolean f0;
        sdk.pendo.io.b6.b s;
        boolean t0;

        a(a0<?> a0Var) {
            this.f = a0Var;
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.a(this, bVar);
            synchronized (this.f) {
                if (this.t0) {
                    ((sdk.pendo.io.e6.e) this.f.f).a(bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.e(this);
        }
    }

    static final class b<T> extends AtomicBoolean implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        final a A;
        final sdk.pendo.io.x5.o<? super T> f;
        sdk.pendo.io.b6.b f0;
        final a0<T> s;

        b(sdk.pendo.io.x5.o<? super T> oVar, a0<T> a0Var, a aVar) {
            this.f = oVar;
            this.s = a0Var;
            this.A = aVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f0.a();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.f0.dispose();
            if (compareAndSet(false, true)) {
                this.s.a(this.A);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.s.d(this.A);
                this.f.onComplete();
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (!compareAndSet(false, true)) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.s.d(this.A);
                this.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            this.f.onNext(t);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.f0, bVar)) {
                this.f0 = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public a0(sdk.pendo.io.r6.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void a(a aVar) {
        synchronized (this) {
            a aVar2 = this.u0;
            if (aVar2 != null && aVar2 == aVar) {
                long j = aVar.A - 1;
                aVar.A = j;
                if (j == 0 && aVar.f0) {
                    if (this.A == 0) {
                        e(aVar);
                        return;
                    }
                    sdk.pendo.io.e6.f fVar = new sdk.pendo.io.e6.f();
                    aVar.s = fVar;
                    fVar.a(this.t0.a(aVar, this.A, this.f0));
                }
            }
        }
    }

    void b(a aVar) {
        sdk.pendo.io.b6.b bVar = aVar.s;
        if (bVar != null) {
            bVar.dispose();
            aVar.s = null;
        }
    }

    void c(a aVar) {
        sdk.pendo.io.r6.a<T> aVar2 = this.f;
        if (aVar2 instanceof sdk.pendo.io.b6.b) {
            ((sdk.pendo.io.b6.b) aVar2).dispose();
        } else if (aVar2 instanceof sdk.pendo.io.e6.e) {
            ((sdk.pendo.io.e6.e) aVar2).a(aVar.get());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
    
        if (r6 == 0) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void d(sdk.pendo.io.l6.a0.a r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            sdk.pendo.io.r6.a<T> r0 = r8.f     // Catch: java.lang.Throwable -> L3b
            boolean r0 = r0 instanceof sdk.pendo.io.l6.z     // Catch: java.lang.Throwable -> L3b
            r1 = 0
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L24
            sdk.pendo.io.l6.a0$a r0 = r8.u0     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L17
            if (r0 != r9) goto L17
            r8.u0 = r3     // Catch: java.lang.Throwable -> L3b
            r8.b(r9)     // Catch: java.lang.Throwable -> L3b
        L17:
            long r6 = r9.A     // Catch: java.lang.Throwable -> L3b
            long r6 = r6 - r4
            r9.A = r6     // Catch: java.lang.Throwable -> L3b
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 != 0) goto L39
        L20:
            r8.c(r9)     // Catch: java.lang.Throwable -> L3b
            goto L39
        L24:
            sdk.pendo.io.l6.a0$a r0 = r8.u0     // Catch: java.lang.Throwable -> L3b
            if (r0 == 0) goto L39
            if (r0 != r9) goto L39
            r8.b(r9)     // Catch: java.lang.Throwable -> L3b
            long r6 = r9.A     // Catch: java.lang.Throwable -> L3b
            long r6 = r6 - r4
            r9.A = r6     // Catch: java.lang.Throwable -> L3b
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 != 0) goto L39
            r8.u0 = r3     // Catch: java.lang.Throwable -> L3b
            goto L20
        L39:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L3b
            return
        L3b:
            r9 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L3b
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.l6.a0.d(sdk.pendo.io.l6.a0$a):void");
    }

    void e(a aVar) {
        synchronized (this) {
            if (aVar.A == 0 && aVar == this.u0) {
                this.u0 = null;
                sdk.pendo.io.b6.b bVar = aVar.get();
                sdk.pendo.io.e6.b.a(aVar);
                sdk.pendo.io.r6.a<T> aVar2 = this.f;
                if (aVar2 instanceof sdk.pendo.io.b6.b) {
                    ((sdk.pendo.io.b6.b) aVar2).dispose();
                } else if (aVar2 instanceof sdk.pendo.io.e6.e) {
                    if (bVar == null) {
                        aVar.t0 = true;
                    } else {
                        ((sdk.pendo.io.e6.e) aVar2).a(bVar);
                    }
                }
            }
        }
    }

    public a0(sdk.pendo.io.r6.a<T> aVar, int i, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar) {
        this.f = aVar;
        this.s = i;
        this.A = j;
        this.f0 = timeUnit;
        this.t0 = pVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        a aVar;
        boolean z;
        sdk.pendo.io.b6.b bVar;
        synchronized (this) {
            aVar = this.u0;
            if (aVar == null) {
                aVar = new a(this);
                this.u0 = aVar;
            }
            long j = aVar.A;
            if (j == 0 && (bVar = aVar.s) != null) {
                bVar.dispose();
            }
            long j2 = j + 1;
            aVar.A = j2;
            if (aVar.f0 || j2 != this.s) {
                z = false;
            } else {
                z = true;
                aVar.f0 = true;
            }
        }
        this.f.a((sdk.pendo.io.x5.o) new b(oVar, this, aVar));
        if (z) {
            this.f.b(aVar);
        }
    }
}
