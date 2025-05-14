package sdk.pendo.io.w6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.o;

/* loaded from: classes4.dex */
public final class b<T> extends d<T> {
    static final a[] A = new a[0];
    static final a[] f0 = new a[0];
    final AtomicReference<a<T>[]> f = new AtomicReference<>(f0);
    Throwable s;

    static final class a<T> extends AtomicBoolean implements sdk.pendo.io.b6.b {
        final o<? super T> f;
        final b<T> s;

        a(o<? super T> oVar, b<T> bVar) {
            this.f = oVar;
            this.s = bVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get();
        }

        public void b() {
            if (get()) {
                return;
            }
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (compareAndSet(false, true)) {
                this.s.b(this);
            }
        }

        public void a(Throwable th) {
            if (get()) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.f.onError(th);
            }
        }

        public void a(T t) {
            if (get()) {
                return;
            }
            this.f.onNext(t);
        }
    }

    b() {
    }

    public static <T> b<T> n() {
        return new b<>();
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f.get();
            if (aVarArr == A) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.f.get();
            if (aVarArr == A || aVarArr == f0) {
                return;
            }
            int length = aVarArr.length;
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
                aVarArr2 = f0;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.f, aVarArr, aVarArr2));
    }

    @Override // sdk.pendo.io.x5.o
    public void onComplete() {
        a<T>[] aVarArr = this.f.get();
        a<T>[] aVarArr2 = A;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.f.getAndSet(aVarArr2)) {
            aVar.b();
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        sdk.pendo.io.f6.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.f.get();
        a<T>[] aVarArr2 = A;
        if (aVarArr == aVarArr2) {
            sdk.pendo.io.t6.a.b(th);
            return;
        }
        this.s = th;
        for (a<T> aVar : this.f.getAndSet(aVarArr2)) {
            aVar.a(th);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onNext(T t) {
        sdk.pendo.io.f6.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a<T> aVar : this.f.get()) {
            aVar.a((a<T>) t);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        if (this.f.get() == A) {
            bVar.dispose();
        }
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super T> oVar) {
        a<T> aVar = new a<>(oVar, this);
        oVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.a()) {
                b(aVar);
            }
        } else {
            Throwable th = this.s;
            if (th != null) {
                oVar.onError(th);
            } else {
                oVar.onComplete();
            }
        }
    }
}
