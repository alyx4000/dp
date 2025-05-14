package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class g0<T> extends sdk.pendo.io.x5.g<T> {
    final sdk.pendo.io.x5.m<T> f;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        T A;
        final sdk.pendo.io.x5.h<? super T> f;
        boolean f0;
        sdk.pendo.io.b6.b s;

        a(sdk.pendo.io.x5.h<? super T> hVar) {
            this.f = hVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.s.a();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.s.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.f0) {
                return;
            }
            this.f0 = true;
            T t = this.A;
            this.A = null;
            if (t == null) {
                this.f.onComplete();
            } else {
                this.f.onSuccess(t);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.f0) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.f0 = true;
                this.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.f0) {
                return;
            }
            if (this.A == null) {
                this.A = t;
                return;
            }
            this.f0 = true;
            this.s.dispose();
            this.f.onError(new IllegalArgumentException("Sequence contains more than one element!"));
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.s, bVar)) {
                this.s = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public g0(sdk.pendo.io.x5.m<T> mVar) {
        this.f = mVar;
    }

    @Override // sdk.pendo.io.x5.g
    public void b(sdk.pendo.io.x5.h<? super T> hVar) {
        this.f.a(new a(hVar));
    }
}
