package sdk.pendo.io.j6;

/* loaded from: classes6.dex */
public final class d<T> extends sdk.pendo.io.x5.g<T> {
    final sdk.pendo.io.x5.d<T> f;
    final long s;

    static final class a<T> implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.b6.b {
        sdk.pendo.io.w5.c A;
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
            return this.A == sdk.pendo.io.p6.c.CANCELLED;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.A.cancel();
            this.A = sdk.pendo.io.p6.c.CANCELLED;
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            this.A = sdk.pendo.io.p6.c.CANCELLED;
            if (this.t0) {
                return;
            }
            this.t0 = true;
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (this.t0) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.t0 = true;
            this.A = sdk.pendo.io.p6.c.CANCELLED;
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.w5.b
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
            this.A.cancel();
            this.A = sdk.pendo.io.p6.c.CANCELLED;
            this.f.onSuccess(t);
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.A, cVar)) {
                this.A = cVar;
                this.f.onSubscribe(this);
                cVar.a(Long.MAX_VALUE);
            }
        }
    }

    public d(sdk.pendo.io.x5.d<T> dVar, long j) {
        this.f = dVar;
        this.s = j;
    }

    @Override // sdk.pendo.io.x5.g
    protected void b(sdk.pendo.io.x5.h<? super T> hVar) {
        this.f.a((sdk.pendo.io.x5.e) new a(hVar, this.s));
    }
}
