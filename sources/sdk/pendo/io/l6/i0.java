package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class i0<T> extends sdk.pendo.io.l6.a<T, T> {
    final long s;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        sdk.pendo.io.b6.b A;
        final sdk.pendo.io.x5.o<? super T> f;
        long s;

        a(sdk.pendo.io.x5.o<? super T> oVar, long j) {
            this.f = oVar;
            this.s = j;
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
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            long j = this.s;
            if (j != 0) {
                this.s = j - 1;
            } else {
                this.f.onNext(t);
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

    public i0(sdk.pendo.io.x5.m<T> mVar, long j) {
        super(mVar);
        this.s = j;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s));
    }
}
