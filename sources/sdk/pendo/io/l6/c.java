package sdk.pendo.io.l6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class c<T, R> extends sdk.pendo.io.x5.j<R> {
    final sdk.pendo.io.d6.h<? super Object[], ? extends R> A;
    final sdk.pendo.io.x5.m<? extends T>[] f;
    final int f0;
    final Iterable<? extends sdk.pendo.io.x5.m<? extends T>> s;
    final boolean t0;

    static final class a<T, R> extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.x5.o<T> {
        final b<T, R> f;
        final int s;

        a(b<T, R> bVar, int i) {
            this.f = bVar;
            this.s = i;
        }

        public void a() {
            sdk.pendo.io.e6.b.a(this);
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.f.a(this.s);
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.f.a(this.s, th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            this.f.a(this.s, (int) t);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this, bVar);
        }
    }

    static final class b<T, R> extends AtomicInteger implements sdk.pendo.io.b6.b {
        final a<T, R>[] A;
        final sdk.pendo.io.x5.o<? super R> f;
        Object[] f0;
        final sdk.pendo.io.d6.h<? super Object[], ? extends R> s;
        final sdk.pendo.io.m6.c<Object[]> t0;
        final boolean u0;
        volatile boolean v0;
        volatile boolean w0;
        final sdk.pendo.io.q6.c x0 = new sdk.pendo.io.q6.c();
        int y0;
        int z0;

        b(sdk.pendo.io.x5.o<? super R> oVar, sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, int i, int i2, boolean z) {
            this.f = oVar;
            this.s = hVar;
            this.u0 = z;
            this.f0 = new Object[i];
            a<T, R>[] aVarArr = new a[i];
            for (int i3 = 0; i3 < i; i3++) {
                aVarArr[i3] = new a<>(this, i3);
            }
            this.A = aVarArr;
            this.t0 = new sdk.pendo.io.m6.c<>(i2);
        }

        void a(sdk.pendo.io.m6.c<?> cVar) {
            synchronized (this) {
                this.f0 = null;
            }
            cVar.clear();
        }

        void b() {
            for (a<T, R> aVar : this.A) {
                aVar.a();
            }
        }

        void c() {
            if (getAndIncrement() != 0) {
                return;
            }
            sdk.pendo.io.m6.c<Object[]> cVar = this.t0;
            sdk.pendo.io.x5.o<? super R> oVar = this.f;
            boolean z = this.u0;
            int i = 1;
            while (!this.v0) {
                if (z || this.x0.get() == null) {
                    boolean z2 = this.w0;
                    Object[] poll = cVar.poll();
                    boolean z3 = poll == null;
                    if (z2 && z3) {
                        a((sdk.pendo.io.m6.c<?>) cVar);
                        Throwable a2 = this.x0.a();
                        if (a2 == null) {
                            oVar.onComplete();
                            return;
                        } else {
                            oVar.onError(a2);
                            return;
                        }
                    }
                    if (z3) {
                        i = addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    } else {
                        try {
                            oVar.onNext((Object) sdk.pendo.io.f6.b.a(this.s.apply(poll), "The combiner returned a null value"));
                        } catch (Throwable th) {
                            sdk.pendo.io.c6.b.b(th);
                            this.x0.a(th);
                        }
                    }
                }
                b();
                a((sdk.pendo.io.m6.c<?>) cVar);
                oVar.onError(this.x0.a());
                return;
            }
            a((sdk.pendo.io.m6.c<?>) cVar);
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.v0) {
                return;
            }
            this.v0 = true;
            b();
            if (getAndIncrement() == 0) {
                a((sdk.pendo.io.m6.c<?>) this.t0);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
        
            if (r2 == r0.length) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.f0     // Catch: java.lang.Throwable -> L25
                if (r0 != 0) goto L7
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                return
            L7:
                r4 = r0[r4]     // Catch: java.lang.Throwable -> L25
                r1 = 1
                if (r4 != 0) goto Le
                r4 = r1
                goto Lf
            Le:
                r4 = 0
            Lf:
                if (r4 != 0) goto L19
                int r2 = r3.z0     // Catch: java.lang.Throwable -> L25
                int r2 = r2 + r1
                r3.z0 = r2     // Catch: java.lang.Throwable -> L25
                int r0 = r0.length     // Catch: java.lang.Throwable -> L25
                if (r2 != r0) goto L1b
            L19:
                r3.w0 = r1     // Catch: java.lang.Throwable -> L25
            L1b:
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                if (r4 == 0) goto L21
                r3.b()
            L21:
                r3.c()
                return
            L25:
                r4 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> L25
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.l6.c.b.a(int):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
        
            if (r1 == r4.length) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void a(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                sdk.pendo.io.q6.c r0 = r2.x0
                boolean r0 = r0.a(r4)
                if (r0 == 0) goto L36
                boolean r4 = r2.u0
                r0 = 1
                if (r4 == 0) goto L2d
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.f0     // Catch: java.lang.Throwable -> L2a
                if (r4 != 0) goto L14
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                return
            L14:
                r3 = r4[r3]     // Catch: java.lang.Throwable -> L2a
                if (r3 != 0) goto L1a
                r3 = r0
                goto L1b
            L1a:
                r3 = 0
            L1b:
                if (r3 != 0) goto L25
                int r1 = r2.z0     // Catch: java.lang.Throwable -> L2a
                int r1 = r1 + r0
                r2.z0 = r1     // Catch: java.lang.Throwable -> L2a
                int r4 = r4.length     // Catch: java.lang.Throwable -> L2a
                if (r1 != r4) goto L27
            L25:
                r2.w0 = r0     // Catch: java.lang.Throwable -> L2a
            L27:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                r0 = r3
                goto L2d
            L2a:
                r3 = move-exception
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L2a
                throw r3
            L2d:
                if (r0 == 0) goto L32
                r2.b()
            L32:
                r2.c()
                goto L39
            L36:
                sdk.pendo.io.t6.a.b(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.l6.c.b.a(int, java.lang.Throwable):void");
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a(int i, T t) {
            boolean z;
            synchronized (this) {
                Object[] objArr = this.f0;
                if (objArr == null) {
                    return;
                }
                Object obj = objArr[i];
                int i2 = this.y0;
                if (obj == null) {
                    i2++;
                    this.y0 = i2;
                }
                objArr[i] = t;
                if (i2 == objArr.length) {
                    this.t0.offer(objArr.clone());
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c();
                }
            }
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.v0;
        }

        public void a(sdk.pendo.io.x5.m<? extends T>[] mVarArr) {
            a<T, R>[] aVarArr = this.A;
            int length = aVarArr.length;
            this.f.onSubscribe(this);
            for (int i = 0; i < length && !this.w0 && !this.v0; i++) {
                mVarArr[i].a(aVarArr[i]);
            }
        }
    }

    public c(sdk.pendo.io.x5.m<? extends T>[] mVarArr, Iterable<? extends sdk.pendo.io.x5.m<? extends T>> iterable, sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, int i, boolean z) {
        this.f = mVarArr;
        this.s = iterable;
        this.A = hVar;
        this.f0 = i;
        this.t0 = z;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super R> oVar) {
        int length;
        sdk.pendo.io.x5.m<? extends T>[] mVarArr = this.f;
        if (mVarArr == null) {
            mVarArr = new sdk.pendo.io.x5.m[8];
            length = 0;
            for (sdk.pendo.io.x5.m<? extends T> mVar : this.s) {
                if (length == mVarArr.length) {
                    sdk.pendo.io.x5.m<? extends T>[] mVarArr2 = new sdk.pendo.io.x5.m[(length >> 2) + length];
                    System.arraycopy(mVarArr, 0, mVarArr2, 0, length);
                    mVarArr = mVarArr2;
                }
                mVarArr[length] = mVar;
                length++;
            }
        } else {
            length = mVarArr.length;
        }
        int i = length;
        if (i == 0) {
            sdk.pendo.io.e6.c.a(oVar);
        } else {
            new b(oVar, this.A, i, this.f0, this.t0).a(mVarArr);
        }
    }
}
