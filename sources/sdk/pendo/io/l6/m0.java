package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class m0<T> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.d6.j<? super T> s;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        sdk.pendo.io.b6.b A;
        final sdk.pendo.io.x5.o<? super T> f;
        boolean f0;
        final sdk.pendo.io.d6.j<? super T> s;

        a(sdk.pendo.io.x5.o<? super T> oVar, sdk.pendo.io.d6.j<? super T> jVar) {
            this.f = oVar;
            this.s = jVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.A.a();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.A.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.f0) {
                return;
            }
            this.f0 = true;
            this.f.onComplete();
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
            try {
                if (this.s.test(t)) {
                    this.f.onNext(t);
                    return;
                }
                this.f0 = true;
                this.A.dispose();
                this.f.onComplete();
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                this.A.dispose();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.A, bVar)) {
                this.A = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public m0(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.j<? super T> jVar) {
        super(mVar);
        this.s = jVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s));
    }
}
