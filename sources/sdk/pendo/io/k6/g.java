package sdk.pendo.io.k6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.d6.h;
import sdk.pendo.io.x5.i;

/* loaded from: classes6.dex */
public final class g<T, R> extends sdk.pendo.io.x5.g<R> {
    final i<? extends T>[] f;
    final h<? super Object[], ? extends R> s;

    final class a implements h<T, R> {
        a() {
        }

        @Override // sdk.pendo.io.d6.h
        public R apply(T t) {
            return (R) sdk.pendo.io.f6.b.a(g.this.s.apply(new Object[]{t}), "The zipper returned a null value");
        }
    }

    static final class b<T, R> extends AtomicInteger implements sdk.pendo.io.b6.b {
        final c<T>[] A;
        final sdk.pendo.io.x5.h<? super R> f;
        final Object[] f0;
        final h<? super Object[], ? extends R> s;

        b(sdk.pendo.io.x5.h<? super R> hVar, int i, h<? super Object[], ? extends R> hVar2) {
            super(i);
            this.f = hVar;
            this.s = hVar2;
            c<T>[] cVarArr = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                cVarArr[i2] = new c<>(this, i2);
            }
            this.A = cVarArr;
            this.f0 = new Object[i];
        }

        void a(int i) {
            c<T>[] cVarArr = this.A;
            int length = cVarArr.length;
            for (int i2 = 0; i2 < i; i2++) {
                cVarArr[i2].a();
            }
            while (true) {
                i++;
                if (i >= length) {
                    return;
                } else {
                    cVarArr[i].a();
                }
            }
        }

        void b(int i) {
            if (getAndSet(0) > 0) {
                a(i);
                this.f.onComplete();
            }
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c<T> cVar : this.A) {
                    cVar.a();
                }
            }
        }

        void a(Throwable th, int i) {
            if (getAndSet(0) <= 0) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                a(i);
                this.f.onError(th);
            }
        }

        void a(T t, int i) {
            this.f0[i] = t;
            if (decrementAndGet() == 0) {
                try {
                    this.f.onSuccess(sdk.pendo.io.f6.b.a(this.s.apply(this.f0), "The zipper returned a null value"));
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    this.f.onError(th);
                }
            }
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() <= 0;
        }
    }

    static final class c<T> extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.x5.h<T> {
        final b<T, ?> f;
        final int s;

        c(b<T, ?> bVar, int i) {
            this.f = bVar;
            this.s = i;
        }

        public void a() {
            sdk.pendo.io.e6.b.a(this);
        }

        @Override // sdk.pendo.io.x5.h
        public void onComplete() {
            this.f.b(this.s);
        }

        @Override // sdk.pendo.io.x5.h
        public void onError(Throwable th) {
            this.f.a(th, this.s);
        }

        @Override // sdk.pendo.io.x5.h
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this, bVar);
        }

        @Override // sdk.pendo.io.x5.h
        public void onSuccess(T t) {
            this.f.a((b<T, ?>) t, this.s);
        }
    }

    public g(i<? extends T>[] iVarArr, h<? super Object[], ? extends R> hVar) {
        this.f = iVarArr;
        this.s = hVar;
    }

    @Override // sdk.pendo.io.x5.g
    protected void b(sdk.pendo.io.x5.h<? super R> hVar) {
        i<? extends T>[] iVarArr = this.f;
        int length = iVarArr.length;
        if (length == 1) {
            iVarArr[0].a(new d(hVar, new a()));
            return;
        }
        b bVar = new b(hVar, length, this.s);
        hVar.onSubscribe(bVar);
        for (int i = 0; i < length && !bVar.a(); i++) {
            i<? extends T> iVar = iVarArr[i];
            if (iVar == null) {
                bVar.a((Throwable) new NullPointerException("One of the sources is null"), i);
                return;
            }
            iVar.a(bVar.A[i]);
        }
    }
}
