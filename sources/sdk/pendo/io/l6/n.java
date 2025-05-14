package sdk.pendo.io.l6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class n<T, U> extends sdk.pendo.io.l6.a<T, U> {
    final boolean A;
    final int f0;
    final sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends U>> s;
    final int t0;

    static final class a<T, U> extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.x5.o<U> {
        volatile boolean A;
        final long f;
        volatile sdk.pendo.io.g6.g<U> f0;
        final b<T, U> s;
        int t0;

        a(b<T, U> bVar, long j) {
            this.f = j;
            this.s = bVar;
        }

        public void a() {
            sdk.pendo.io.e6.b.a(this);
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.A = true;
            this.s.e();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (!this.s.w0.a(th)) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            b<T, U> bVar = this.s;
            if (!bVar.A) {
                bVar.c();
            }
            this.A = true;
            this.s.e();
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(U u) {
            if (this.t0 == 0) {
                this.s.a(u, this);
            } else {
                this.s.e();
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.c(this, bVar) && (bVar instanceof sdk.pendo.io.g6.b)) {
                sdk.pendo.io.g6.b bVar2 = (sdk.pendo.io.g6.b) bVar;
                int a2 = bVar2.a(7);
                if (a2 == 1) {
                    this.t0 = a2;
                    this.f0 = bVar2;
                    this.A = true;
                    this.s.e();
                    return;
                }
                if (a2 == 2) {
                    this.t0 = a2;
                    this.f0 = bVar2;
                }
            }
        }
    }

    static final class b<T, U> extends AtomicInteger implements sdk.pendo.io.b6.b, sdk.pendo.io.x5.o<T> {
        static final a<?, ?>[] F0 = new a[0];
        static final a<?, ?>[] G0 = new a[0];
        final boolean A;
        long A0;
        long B0;
        int C0;
        Queue<sdk.pendo.io.x5.m<? extends U>> D0;
        int E0;
        final sdk.pendo.io.x5.o<? super U> f;
        final int f0;
        final sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends U>> s;
        final int t0;
        volatile sdk.pendo.io.g6.f<U> u0;
        volatile boolean v0;
        final sdk.pendo.io.q6.c w0 = new sdk.pendo.io.q6.c();
        volatile boolean x0;
        final AtomicReference<a<?, ?>[]> y0;
        sdk.pendo.io.b6.b z0;

        b(sdk.pendo.io.x5.o<? super U> oVar, sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends U>> hVar, boolean z, int i, int i2) {
            this.f = oVar;
            this.s = hVar;
            this.A = z;
            this.f0 = i;
            this.t0 = i2;
            if (i != Integer.MAX_VALUE) {
                this.D0 = new ArrayDeque(i);
            }
            this.y0 = new AtomicReference<>(F0);
        }

        boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.y0.get();
                if (aVarArr == G0) {
                    aVar.a();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.y0, aVarArr, aVarArr2));
            return true;
        }

        boolean b() {
            if (this.x0) {
                return true;
            }
            Throwable th = this.w0.get();
            if (this.A || th == null) {
                return false;
            }
            c();
            Throwable a2 = this.w0.a();
            if (a2 != sdk.pendo.io.q6.g.f1515a) {
                this.f.onError(a2);
            }
            return true;
        }

        boolean c() {
            a<?, ?>[] andSet;
            this.z0.dispose();
            a<?, ?>[] aVarArr = this.y0.get();
            a<?, ?>[] aVarArr2 = G0;
            if (aVarArr == aVarArr2 || (andSet = this.y0.getAndSet(aVarArr2)) == aVarArr2) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.a();
            }
            return true;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            Throwable a2;
            if (this.x0) {
                return;
            }
            this.x0 = true;
            if (!c() || (a2 = this.w0.a()) == null || a2 == sdk.pendo.io.q6.g.f1515a) {
                return;
            }
            sdk.pendo.io.t6.a.b(a2);
        }

        void e() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g() {
            int i;
            int i2;
            sdk.pendo.io.x5.o<? super U> oVar = this.f;
            int i3 = 1;
            while (!b()) {
                sdk.pendo.io.g6.f<U> fVar = this.u0;
                int i4 = 0;
                if (fVar != null) {
                    while (!b()) {
                        U poll = fVar.poll();
                        if (poll != null) {
                            oVar.onNext(poll);
                            i4++;
                        }
                    }
                    return;
                }
                if (i4 == 0) {
                    boolean z = this.v0;
                    sdk.pendo.io.g6.f<U> fVar2 = this.u0;
                    a<?, ?>[] aVarArr = this.y0.get();
                    int length = aVarArr.length;
                    if (this.f0 != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i = this.D0.size();
                        }
                    } else {
                        i = 0;
                    }
                    if (z && ((fVar2 == null || fVar2.isEmpty()) && length == 0 && i == 0)) {
                        Throwable a2 = this.w0.a();
                        if (a2 != sdk.pendo.io.q6.g.f1515a) {
                            if (a2 == null) {
                                oVar.onComplete();
                                return;
                            } else {
                                oVar.onError(a2);
                                return;
                            }
                        }
                        return;
                    }
                    if (length != 0) {
                        long j = this.B0;
                        int i5 = this.C0;
                        if (length <= i5 || aVarArr[i5].f != j) {
                            if (length <= i5) {
                                i5 = 0;
                            }
                            for (int i6 = 0; i6 < length && aVarArr[i5].f != j; i6++) {
                                i5++;
                                if (i5 == length) {
                                    i5 = 0;
                                }
                            }
                            this.C0 = i5;
                            this.B0 = aVarArr[i5].f;
                        }
                        for (0; i2 < length; i2 + 1) {
                            if (b()) {
                                return;
                            }
                            a<T, U> aVar = aVarArr[i5];
                            sdk.pendo.io.g6.g<U> gVar = aVar.f0;
                            if (gVar != null) {
                                do {
                                    try {
                                        U poll2 = gVar.poll();
                                        if (poll2 != null) {
                                            oVar.onNext(poll2);
                                        }
                                    } catch (Throwable th) {
                                        sdk.pendo.io.c6.b.b(th);
                                        aVar.a();
                                        this.w0.a(th);
                                        if (b()) {
                                            return;
                                        }
                                        b(aVar);
                                        i4++;
                                        i5++;
                                        if (i5 != length) {
                                        }
                                    }
                                } while (!b());
                                return;
                            }
                            boolean z2 = aVar.A;
                            sdk.pendo.io.g6.g<U> gVar2 = aVar.f0;
                            if (z2 && (gVar2 == null || gVar2.isEmpty())) {
                                b(aVar);
                                if (b()) {
                                    return;
                                } else {
                                    i4++;
                                }
                            }
                            i5++;
                            i2 = i5 != length ? i2 + 1 : 0;
                            i5 = 0;
                        }
                        this.C0 = i5;
                        this.B0 = aVarArr[i5].f;
                    }
                    if (i4 == 0) {
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else if (this.f0 != Integer.MAX_VALUE) {
                        a(i4);
                    }
                } else if (this.f0 != Integer.MAX_VALUE) {
                    a(i4);
                }
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.v0) {
                return;
            }
            this.v0 = true;
            e();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.v0) {
                sdk.pendo.io.t6.a.b(th);
            } else if (!this.w0.a(th)) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.v0 = true;
                e();
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.v0) {
                return;
            }
            try {
                sdk.pendo.io.x5.m<? extends U> mVar = (sdk.pendo.io.x5.m) sdk.pendo.io.f6.b.a(this.s.apply(t), "The mapper returned a null ObservableSource");
                if (this.f0 != Integer.MAX_VALUE) {
                    synchronized (this) {
                        int i = this.E0;
                        if (i == this.f0) {
                            this.D0.offer(mVar);
                            return;
                        }
                        this.E0 = i + 1;
                    }
                }
                a(mVar);
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                this.z0.dispose();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.z0, bVar)) {
                this.z0 = bVar;
                this.f.onSubscribe(this);
            }
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.x0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.y0.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i] == aVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = F0;
                } else {
                    a<?, ?>[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.y0, aVarArr, aVarArr2));
        }

        void a(sdk.pendo.io.x5.m<? extends U> mVar) {
            boolean z;
            while (mVar instanceof Callable) {
                if (!a((Callable) mVar) || this.f0 == Integer.MAX_VALUE) {
                    return;
                }
                synchronized (this) {
                    mVar = this.D0.poll();
                    if (mVar == null) {
                        z = true;
                        this.E0--;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    e();
                    return;
                }
            }
            long j = this.A0;
            this.A0 = 1 + j;
            a<T, U> aVar = new a<>(this, j);
            if (a(aVar)) {
                mVar.a(aVar);
            }
        }

        void a(int i) {
            while (true) {
                int i2 = i - 1;
                if (i == 0) {
                    return;
                }
                synchronized (this) {
                    sdk.pendo.io.x5.m<? extends U> poll = this.D0.poll();
                    if (poll == null) {
                        this.E0--;
                    } else {
                        a(poll);
                    }
                }
                i = i2;
            }
        }

        void a(U u, a<T, U> aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                this.f.onNext(u);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                sdk.pendo.io.g6.g gVar = aVar.f0;
                if (gVar == null) {
                    gVar = new sdk.pendo.io.m6.c(this.t0);
                    aVar.f0 = gVar;
                }
                gVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            g();
        }

        boolean a(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                } else {
                    sdk.pendo.io.g6.f<U> fVar = this.u0;
                    if (fVar == null) {
                        fVar = this.f0 == Integer.MAX_VALUE ? new sdk.pendo.io.m6.c<>(this.t0) : new sdk.pendo.io.m6.b<>(this.f0);
                        this.u0 = fVar;
                    }
                    if (!fVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    }
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                }
                g();
                return true;
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                this.w0.a(th);
                e();
                return true;
            }
        }
    }

    public n(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.h<? super T, ? extends sdk.pendo.io.x5.m<? extends U>> hVar, boolean z, int i, int i2) {
        super(mVar);
        this.s = hVar;
        this.A = z;
        this.f0 = i;
        this.t0 = i2;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super U> oVar) {
        if (e0.a(this.f, oVar, this.s)) {
            return;
        }
        this.f.a(new b(oVar, this.s, this.A, this.f0, this.t0));
    }
}
