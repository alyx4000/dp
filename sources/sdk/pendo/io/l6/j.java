package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class j<T> extends sdk.pendo.io.x5.g<T> {
    final sdk.pendo.io.x5.m<T> f;
    final long s;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        sdk.pendo.io.b6.b A;
        final sdk.pendo.io.x5.h<? super T> f;
        long f0;
        final long s;
        boolean t0;

        a(sdk.pendo.io.x5.h<? super T> hVar, long j) {
            this.f = hVar;
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
            long j = this.f0;
            if (j != this.s) {
                this.f0 = j + 1;
                return;
            }
            this.t0 = true;
            this.A.dispose();
            this.f.onSuccess(t);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.A, bVar)) {
                this.A = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public j(sdk.pendo.io.x5.m<T> mVar, long j) {
        this.f = mVar;
        this.s = j;
    }

    @Override // sdk.pendo.io.x5.g
    public void b(sdk.pendo.io.x5.h<? super T> hVar) {
        this.f.a(new a(hVar, this.s));
    }
}
