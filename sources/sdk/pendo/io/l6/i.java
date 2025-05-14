package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class i<T> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.d6.e<? super Throwable> A;
    final sdk.pendo.io.d6.a f0;
    final sdk.pendo.io.d6.e<? super T> s;
    final sdk.pendo.io.d6.a t0;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        final sdk.pendo.io.d6.e<? super Throwable> A;
        final sdk.pendo.io.x5.o<? super T> f;
        final sdk.pendo.io.d6.a f0;
        final sdk.pendo.io.d6.e<? super T> s;
        final sdk.pendo.io.d6.a t0;
        sdk.pendo.io.b6.b u0;
        boolean v0;

        a(sdk.pendo.io.x5.o<? super T> oVar, sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar, sdk.pendo.io.d6.a aVar2) {
            this.f = oVar;
            this.s = eVar;
            this.A = eVar2;
            this.f0 = aVar;
            this.t0 = aVar2;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.u0.a();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.u0.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.v0) {
                return;
            }
            try {
                this.f0.run();
                this.v0 = true;
                this.f.onComplete();
                try {
                    this.t0.run();
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    sdk.pendo.io.t6.a.b(th);
                }
            } catch (Throwable th2) {
                sdk.pendo.io.c6.b.b(th2);
                onError(th2);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.v0) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.v0 = true;
            try {
                this.A.accept(th);
            } catch (Throwable th2) {
                sdk.pendo.io.c6.b.b(th2);
                th = new sdk.pendo.io.c6.a(th, th2);
            }
            this.f.onError(th);
            try {
                this.t0.run();
            } catch (Throwable th3) {
                sdk.pendo.io.c6.b.b(th3);
                sdk.pendo.io.t6.a.b(th3);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.v0) {
                return;
            }
            try {
                this.s.accept(t);
                this.f.onNext(t);
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                this.u0.dispose();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.u0, bVar)) {
                this.u0 = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public i(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.e<? super T> eVar, sdk.pendo.io.d6.e<? super Throwable> eVar2, sdk.pendo.io.d6.a aVar, sdk.pendo.io.d6.a aVar2) {
        super(mVar);
        this.s = eVar;
        this.A = eVar2;
        this.f0 = aVar;
        this.t0 = aVar2;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s, this.A, this.f0, this.t0));
    }
}
