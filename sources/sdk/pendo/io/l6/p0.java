package sdk.pendo.io.l6;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class p0<T, R> extends sdk.pendo.io.x5.j<R> {
    final sdk.pendo.io.d6.h<? super Object[], ? extends R> A;
    final sdk.pendo.io.x5.m<? extends T>[] f;
    final int f0;
    final Iterable<? extends sdk.pendo.io.x5.m<? extends T>> s;
    final boolean t0;

    static final class a<T, R> extends AtomicInteger implements sdk.pendo.io.b6.b {
        final b<T, R>[] A;
        final sdk.pendo.io.x5.o<? super R> f;
        final T[] f0;
        final sdk.pendo.io.d6.h<? super Object[], ? extends R> s;
        final boolean t0;
        volatile boolean u0;

        a(sdk.pendo.io.x5.o<? super R> oVar, sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, int i, boolean z) {
            this.f = oVar;
            this.s = hVar;
            this.A = new b[i];
            this.f0 = (T[]) new Object[i];
            this.t0 = z;
        }

        boolean a(boolean z, boolean z2, sdk.pendo.io.x5.o<? super R> oVar, boolean z3, b<?, ?> bVar) {
            if (this.u0) {
                b();
                return true;
            }
            if (!z) {
                return false;
            }
            if (z3) {
                if (!z2) {
                    return false;
                }
                Throwable th = bVar.f0;
                this.u0 = true;
                b();
                if (th != null) {
                    oVar.onError(th);
                } else {
                    oVar.onComplete();
                }
                return true;
            }
            Throwable th2 = bVar.f0;
            if (th2 != null) {
                this.u0 = true;
                b();
                oVar.onError(th2);
                return true;
            }
            if (!z2) {
                return false;
            }
            this.u0 = true;
            b();
            oVar.onComplete();
            return true;
        }

        void b() {
            e();
            c();
        }

        void c() {
            for (b<T, R> bVar : this.A) {
                bVar.a();
            }
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.u0) {
                return;
            }
            this.u0 = true;
            c();
            if (getAndIncrement() == 0) {
                e();
            }
        }

        void e() {
            for (b<T, R> bVar : this.A) {
                bVar.s.clear();
            }
        }

        public void g() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            b<T, R>[] bVarArr = this.A;
            sdk.pendo.io.x5.o<? super R> oVar = this.f;
            T[] tArr = this.f0;
            boolean z = this.t0;
            int i = 1;
            while (true) {
                int i2 = 0;
                int i3 = 0;
                for (b<T, R> bVar : bVarArr) {
                    if (tArr[i3] == null) {
                        boolean z2 = bVar.A;
                        T poll = bVar.s.poll();
                        boolean z3 = poll == null;
                        if (a(z2, z3, oVar, z, bVar)) {
                            return;
                        }
                        if (z3) {
                            i2++;
                        } else {
                            tArr[i3] = poll;
                        }
                    } else if (bVar.A && !z && (th = bVar.f0) != null) {
                        this.u0 = true;
                        b();
                        oVar.onError(th);
                        return;
                    }
                    i3++;
                }
                if (i2 != 0) {
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                } else {
                    try {
                        oVar.onNext((Object) sdk.pendo.io.f6.b.a(this.s.apply(tArr.clone()), "The zipper returned a null value"));
                        Arrays.fill(tArr, (Object) null);
                    } catch (Throwable th2) {
                        sdk.pendo.io.c6.b.b(th2);
                        b();
                        oVar.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.u0;
        }

        public void a(sdk.pendo.io.x5.m<? extends T>[] mVarArr, int i) {
            b<T, R>[] bVarArr = this.A;
            int length = bVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                bVarArr[i2] = new b<>(this, i);
            }
            lazySet(0);
            this.f.onSubscribe(this);
            for (int i3 = 0; i3 < length && !this.u0; i3++) {
                mVarArr[i3].a(bVarArr[i3]);
            }
        }
    }

    static final class b<T, R> implements sdk.pendo.io.x5.o<T> {
        volatile boolean A;
        final a<T, R> f;
        Throwable f0;
        final sdk.pendo.io.m6.c<T> s;
        final AtomicReference<sdk.pendo.io.b6.b> t0 = new AtomicReference<>();

        b(a<T, R> aVar, int i) {
            this.f = aVar;
            this.s = new sdk.pendo.io.m6.c<>(i);
        }

        public void a() {
            sdk.pendo.io.e6.b.a(this.t0);
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.A = true;
            this.f.g();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.f0 = th;
            this.A = true;
            this.f.g();
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            this.s.offer(t);
            this.f.g();
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this.t0, bVar);
        }
    }

    public p0(sdk.pendo.io.x5.m<? extends T>[] mVarArr, Iterable<? extends sdk.pendo.io.x5.m<? extends T>> iterable, sdk.pendo.io.d6.h<? super Object[], ? extends R> hVar, int i, boolean z) {
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
        if (length == 0) {
            sdk.pendo.io.e6.c.a(oVar);
        } else {
            new a(oVar, this.A, length, this.t0).a(mVarArr, this.f0);
        }
    }
}
