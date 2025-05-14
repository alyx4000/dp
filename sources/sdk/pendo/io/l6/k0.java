package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class k0<T> extends sdk.pendo.io.l6.a<T, T> {
    final long s;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        sdk.pendo.io.b6.b A;
        final sdk.pendo.io.x5.o<? super T> f;
        long f0;
        boolean s;

        a(sdk.pendo.io.x5.o<? super T> oVar, long j) {
            this.f = oVar;
            this.f0 = j;
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
            if (this.s) {
                return;
            }
            this.s = true;
            this.A.dispose();
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.s) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.s = true;
            this.A.dispose();
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.s) {
                return;
            }
            long j = this.f0;
            long j2 = j - 1;
            this.f0 = j2;
            if (j > 0) {
                boolean z = j2 == 0;
                this.f.onNext(t);
                if (z) {
                    onComplete();
                }
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.A, bVar)) {
                this.A = bVar;
                if (this.f0 != 0) {
                    this.f.onSubscribe(this);
                    return;
                }
                this.s = true;
                bVar.dispose();
                sdk.pendo.io.e6.c.a(this.f);
            }
        }
    }

    public k0(sdk.pendo.io.x5.m<T> mVar, long j) {
        super(mVar);
        this.s = j;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s));
    }
}
