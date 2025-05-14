package sdk.pendo.io.j6;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public final class k<T> extends sdk.pendo.io.j6.a<T, T> {

    static final class a<T> extends AtomicLong implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c {
        boolean A;
        final sdk.pendo.io.w5.b<? super T> f;
        sdk.pendo.io.w5.c s;

        a(sdk.pendo.io.w5.b<? super T> bVar) {
            this.f = bVar;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.s, cVar)) {
                this.s = cVar;
                this.f.a(this);
                cVar.a(Long.MAX_VALUE);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            this.s.cancel();
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            if (this.A) {
                return;
            }
            this.A = true;
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (this.A) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.A = true;
                this.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (this.A) {
                return;
            }
            if (get() != 0) {
                this.f.onNext(t);
                sdk.pendo.io.q6.d.c(this, 1L);
            } else {
                this.s.cancel();
                onError(new sdk.pendo.io.c6.c("could not emit value due to lack of requests"));
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            if (sdk.pendo.io.p6.c.c(j)) {
                sdk.pendo.io.q6.d.a(this, j);
            }
        }
    }

    public k(sdk.pendo.io.x5.d<T> dVar) {
        super(dVar);
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        this.s.a((sdk.pendo.io.x5.e) new a(bVar));
    }
}
