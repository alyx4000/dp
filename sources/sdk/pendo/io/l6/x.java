package sdk.pendo.io.l6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class x<T> extends sdk.pendo.io.r6.a<T> implements z<T> {
    final sdk.pendo.io.x5.m<T> A;
    final sdk.pendo.io.x5.m<T> f;
    final AtomicReference<b<T>> s;

    static final class a<T> extends AtomicReference<Object> implements sdk.pendo.io.b6.b {
        final sdk.pendo.io.x5.o<? super T> f;

        a(sdk.pendo.io.x5.o<? super T> oVar) {
            this.f = oVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() == this;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            Object andSet = getAndSet(this);
            if (andSet == null || andSet == this) {
                return;
            }
            ((b) andSet).b(this);
        }

        void a(b<T> bVar) {
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, null, bVar)) {
                return;
            }
            bVar.b(this);
        }
    }

    static final class b<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        static final a[] t0 = new a[0];
        static final a[] u0 = new a[0];
        final AtomicReference<b<T>> f;
        final AtomicReference<sdk.pendo.io.b6.b> f0 = new AtomicReference<>();
        final AtomicReference<a<T>[]> s = new AtomicReference<>(t0);
        final AtomicBoolean A = new AtomicBoolean();

        b(AtomicReference<b<T>> atomicReference) {
            this.f = atomicReference;
        }

        boolean a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.s.get();
                if (aVarArr == u0) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, aVarArr, aVarArr2));
            return true;
        }

        void b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.s.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i].equals(aVar)) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = t0;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, aVarArr, aVarArr2));
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            AtomicReference<a<T>[]> atomicReference = this.s;
            a<T>[] aVarArr = u0;
            if (atomicReference.getAndSet(aVarArr) != aVarArr) {
                PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, this, null);
                sdk.pendo.io.e6.b.a(this.f0);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, this, null);
            for (a<T> aVar : this.s.getAndSet(u0)) {
                aVar.f.onComplete();
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, this, null);
            a<T>[] andSet = this.s.getAndSet(u0);
            if (andSet.length == 0) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            for (a<T> aVar : andSet) {
                aVar.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            for (a<T> aVar : this.s.get()) {
                aVar.f.onNext(t);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this.f0, bVar);
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.s.get() == u0;
        }
    }

    static final class c<T> implements sdk.pendo.io.x5.m<T> {
        private final AtomicReference<b<T>> f;

        c(AtomicReference<b<T>> atomicReference) {
            this.f = atomicReference;
        }

        @Override // sdk.pendo.io.x5.m
        public void a(sdk.pendo.io.x5.o<? super T> oVar) {
            a aVar = new a(oVar);
            oVar.onSubscribe(aVar);
            while (true) {
                b<T> bVar = this.f.get();
                if (bVar == null || bVar.a()) {
                    b<T> bVar2 = new b<>(this.f);
                    if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, bVar, bVar2)) {
                        bVar = bVar2;
                    } else {
                        continue;
                    }
                }
                if (bVar.a(aVar)) {
                    aVar.a(bVar);
                    return;
                }
            }
        }
    }

    private x(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.x5.m<T> mVar2, AtomicReference<b<T>> atomicReference) {
        this.A = mVar;
        this.f = mVar2;
        this.s = atomicReference;
    }

    public static <T> sdk.pendo.io.r6.a<T> f(sdk.pendo.io.x5.m<T> mVar) {
        AtomicReference atomicReference = new AtomicReference();
        return sdk.pendo.io.t6.a.a((sdk.pendo.io.r6.a) new x(new c(atomicReference), mVar, atomicReference));
    }

    @Override // sdk.pendo.io.l6.z
    public sdk.pendo.io.x5.m<T> a() {
        return this.f;
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
        if (!bVar.A.get() && bVar.A.compareAndSet(false, true)) {
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
        this.A.a(oVar);
    }
}
