package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class g<T, U> extends sdk.pendo.io.x5.j<T> {
    final sdk.pendo.io.x5.m<? extends T> f;
    final sdk.pendo.io.x5.m<U> s;

    final class a implements sdk.pendo.io.x5.o<U> {
        boolean A;
        final sdk.pendo.io.e6.f f;
        final sdk.pendo.io.x5.o<? super T> s;

        /* renamed from: sdk.pendo.io.l6.g$a$a, reason: collision with other inner class name */
        final class C0181a implements sdk.pendo.io.x5.o<T> {
            C0181a() {
            }

            @Override // sdk.pendo.io.x5.o
            public void onComplete() {
                a.this.s.onComplete();
            }

            @Override // sdk.pendo.io.x5.o
            public void onError(Throwable th) {
                a.this.s.onError(th);
            }

            @Override // sdk.pendo.io.x5.o
            public void onNext(T t) {
                a.this.s.onNext(t);
            }

            @Override // sdk.pendo.io.x5.o
            public void onSubscribe(sdk.pendo.io.b6.b bVar) {
                a.this.f.b(bVar);
            }
        }

        a(sdk.pendo.io.e6.f fVar, sdk.pendo.io.x5.o<? super T> oVar) {
            this.f = fVar;
            this.s = oVar;
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.A) {
                return;
            }
            this.A = true;
            g.this.f.a(new C0181a());
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.A) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.A = true;
                this.s.onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(U u) {
            onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            this.f.b(bVar);
        }
    }

    public g(sdk.pendo.io.x5.m<? extends T> mVar, sdk.pendo.io.x5.m<U> mVar2) {
        this.f = mVar;
        this.s = mVar2;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        sdk.pendo.io.e6.f fVar = new sdk.pendo.io.e6.f();
        oVar.onSubscribe(fVar);
        this.s.a(new a(fVar, oVar));
    }
}
