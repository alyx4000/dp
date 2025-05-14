package sdk.pendo.io.l6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class y<T> extends sdk.pendo.io.r6.a<T> implements sdk.pendo.io.e6.e {
    final sdk.pendo.io.x5.m<T> f;
    final AtomicReference<b<T>> s = new AtomicReference<>();

    static final class a<T> extends AtomicReference<b<T>> implements sdk.pendo.io.b6.b {
        final sdk.pendo.io.x5.o<? super T> f;

        a(sdk.pendo.io.x5.o<? super T> oVar, b<T> bVar) {
            this.f = oVar;
            lazySet(bVar);
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() == null;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            b<T> andSet = getAndSet(null);
            if (andSet != null) {
                andSet.b(this);
            }
        }
    }

    static final class b<T> extends AtomicReference<a<T>[]> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        static final a[] t0 = new a[0];
        static final a[] u0 = new a[0];
        Throwable f0;
        final AtomicReference<b<T>> s;
        final AtomicBoolean f = new AtomicBoolean();
        final AtomicReference<sdk.pendo.io.b6.b> A = new AtomicReference<>();

        b(AtomicReference<b<T>> atomicReference) {
            this.s = atomicReference;
            lazySet(t0);
        }

        public boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == u0) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, aVarArr, aVarArr2));
            return true;
        }

        public void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
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
                aVarArr2 = t0;
                if (length != 1) {
                    aVarArr2 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr2, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr2, i, (length - i) - 1);
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, aVarArr, aVarArr2));
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            getAndSet(u0);
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, this, null);
            sdk.pendo.io.e6.b.a(this.A);
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.A.lazySet(sdk.pendo.io.e6.b.DISPOSED);
            for (a<T> aVar : getAndSet(u0)) {
                aVar.f.onComplete();
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.f0 = th;
            this.A.lazySet(sdk.pendo.io.e6.b.DISPOSED);
            for (a<T> aVar : getAndSet(u0)) {
                aVar.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            for (a<T> aVar : get()) {
                aVar.f.onNext(t);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this.A, bVar);
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() == u0;
        }
    }

    public y(sdk.pendo.io.x5.m<T> mVar) {
        this.f = mVar;
    }

    @Override // sdk.pendo.io.e6.e
    public void a(sdk.pendo.io.b6.b bVar) {
        PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, (b) bVar, null);
    }

    @Override // sdk.pendo.io.r6.a
    public void b(sdk.pendo.io.d6.e<? super sdk.pendo.io.b6.b> eVar) {
        b<T> bVar;
        while (true) {
            bVar = this.s.get();
            if (bVar != null && !bVar.a()) {
                break;
            }
            b<T> bVar2 = new b<>(this.s);
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z = false;
        if (!bVar.f.get() && bVar.f.compareAndSet(false, true)) {
            z = true;
        }
        try {
            eVar.accept(bVar);
            if (z) {
                this.f.a(bVar);
            }
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            throw sdk.pendo.io.q6.g.a(th);
        }
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        b<T> bVar;
        while (true) {
            bVar = this.s.get();
            if (bVar != null) {
                break;
            }
            b<T> bVar2 = new b<>(this.s);
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        a<T> aVar = new a<>(oVar, bVar);
        oVar.onSubscribe(aVar);
        if (bVar.a(aVar)) {
            if (aVar.a()) {
                bVar.b(aVar);
            }
        } else {
            Throwable th = bVar.f0;
            if (th != null) {
                oVar.onError(th);
            } else {
                oVar.onComplete();
            }
        }
    }
}
