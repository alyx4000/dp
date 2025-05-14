package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class u<T, U> extends sdk.pendo.io.l6.a<T, U> {
    final sdk.pendo.io.d6.h<? super T, ? extends U> s;

    static final class a<T, U> extends sdk.pendo.io.h6.a<T, U> {
        final sdk.pendo.io.d6.h<? super T, ? extends U> u0;

        a(sdk.pendo.io.x5.o<? super U> oVar, sdk.pendo.io.d6.h<? super T, ? extends U> hVar) {
            super(oVar);
            this.u0 = hVar;
        }

        @Override // sdk.pendo.io.g6.c
        public int a(int i) {
            return b(i);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.f0) {
                return;
            }
            if (this.t0 != 0) {
                this.f.onNext(null);
                return;
            }
            try {
                this.f.onNext(sdk.pendo.io.f6.b.a(this.u0.apply(t), "The mapper function returned a null value."));
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // sdk.pendo.io.g6.g
        public U poll() {
            T poll = this.A.poll();
            if (poll != null) {
                return (U) sdk.pendo.io.f6.b.a(this.u0.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public u(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.h<? super T, ? extends U> hVar) {
        super(mVar);
        this.s = hVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super U> oVar) {
        this.f.a(new a(oVar, this.s));
    }
}
