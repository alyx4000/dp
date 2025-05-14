package sdk.pendo.io.u6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.q6.d;
import sdk.pendo.io.w5.c;

/* loaded from: classes3.dex */
public final class b<T> extends sdk.pendo.io.u6.a<T> {
    static final a[] f0 = new a[0];
    static final a[] t0 = new a[0];
    Throwable A;
    final AtomicReference<a<T>[]> s = new AtomicReference<>(t0);

    static final class a<T> extends AtomicLong implements c {
        final sdk.pendo.io.w5.b<? super T> f;
        final b<T> s;

        a(sdk.pendo.io.w5.b<? super T> bVar, b<T> bVar2) {
            this.f = bVar;
            this.s = bVar2;
        }

        public boolean a() {
            return get() == Long.MIN_VALUE;
        }

        public void b() {
            if (get() != Long.MIN_VALUE) {
                this.f.onComplete();
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.s.b(this);
            }
        }

        public void a(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f.onError(th);
            } else {
                sdk.pendo.io.t6.a.b(th);
            }
        }

        public void a(T t) {
            long j = get();
            if (j == Long.MIN_VALUE) {
                return;
            }
            if (j != 0) {
                this.f.onNext(t);
                d.d(this, 1L);
            } else {
                cancel();
                this.f.onError(new sdk.pendo.io.c6.c("Could not emit value due to lack of requests"));
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            if (sdk.pendo.io.p6.c.c(j)) {
                d.b(this, j);
            }
        }
    }

    b() {
    }

    public static <T> b<T> f() {
        return new b<>();
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a[] aVarArr2;
        do {
            aVarArr = this.s.get();
            if (aVarArr == f0) {
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
            if (aVarArr == f0 || aVarArr == t0) {
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
                aVarArr2 = t0;
            } else {
                a[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, aVarArr, aVarArr2));
    }

    @Override // sdk.pendo.io.w5.b
    public void onComplete() {
        a<T>[] aVarArr = this.s.get();
        a<T>[] aVarArr2 = f0;
        if (aVarArr == aVarArr2) {
            return;
        }
        for (a<T> aVar : this.s.getAndSet(aVarArr2)) {
            aVar.b();
        }
    }

    @Override // sdk.pendo.io.w5.b
    public void onError(Throwable th) {
        sdk.pendo.io.f6.b.a(th, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a<T>[] aVarArr = this.s.get();
        a<T>[] aVarArr2 = f0;
        if (aVarArr == aVarArr2) {
            sdk.pendo.io.t6.a.b(th);
            return;
        }
        this.A = th;
        for (a<T> aVar : this.s.getAndSet(aVarArr2)) {
            aVar.a(th);
        }
    }

    @Override // sdk.pendo.io.w5.b
    public void onNext(T t) {
        sdk.pendo.io.f6.b.a((Object) t, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        for (a<T> aVar : this.s.get()) {
            aVar.a((a<T>) t);
        }
    }

    @Override // sdk.pendo.io.w5.b
    public void a(c cVar) {
        if (this.s.get() == f0) {
            cVar.cancel();
        } else {
            cVar.a(Long.MAX_VALUE);
        }
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        a<T> aVar = new a<>(bVar, this);
        bVar.a(aVar);
        if (a((a) aVar)) {
            if (aVar.a()) {
                b(aVar);
            }
        } else {
            Throwable th = this.A;
            if (th != null) {
                bVar.onError(th);
            } else {
                bVar.onComplete();
            }
        }
    }
}
