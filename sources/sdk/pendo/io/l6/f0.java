package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class f0<T> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.d6.b<T, T, T> s;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        sdk.pendo.io.b6.b A;
        final sdk.pendo.io.x5.o<? super T> f;
        T f0;
        final sdk.pendo.io.d6.b<T, T, T> s;
        boolean t0;

        a(sdk.pendo.io.x5.o<? super T> oVar, sdk.pendo.io.d6.b<T, T, T> bVar) {
            this.f = oVar;
            this.s = bVar;
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
            if (this.t0) {
                return;
            }
            this.t0 = true;
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.t0) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.t0 = true;
                this.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.t0) {
                return;
            }
            sdk.pendo.io.x5.o<? super T> oVar = this.f;
            T t2 = this.f0;
            if (t2 != null) {
                try {
                    t = (T) sdk.pendo.io.f6.b.a((Object) this.s.apply(t2, t), "The value returned by the accumulator is null");
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    this.A.dispose();
                    onError(th);
                    return;
                }
            }
            this.f0 = t;
            oVar.onNext(t);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.A, bVar)) {
                this.A = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public f0(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.b<T, T, T> bVar) {
        super(mVar);
        this.s = bVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s));
    }
}
