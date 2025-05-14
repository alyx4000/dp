package sdk.pendo.io.j6;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes6.dex */
public final class j<T> extends sdk.pendo.io.j6.a<T, T> implements sdk.pendo.io.d6.e<T> {
    final sdk.pendo.io.d6.e<? super T> A;

    static final class a<T> extends AtomicLong implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c {
        sdk.pendo.io.w5.c A;
        final sdk.pendo.io.w5.b<? super T> f;
        boolean f0;
        final sdk.pendo.io.d6.e<? super T> s;

        a(sdk.pendo.io.w5.b<? super T> bVar, sdk.pendo.io.d6.e<? super T> eVar) {
            this.f = bVar;
            this.s = eVar;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.A, cVar)) {
                this.A = cVar;
                this.f.a(this);
                cVar.a(Long.MAX_VALUE);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            this.A.cancel();
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            if (this.f0) {
                return;
            }
            this.f0 = true;
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (this.f0) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.f0 = true;
                this.f.onError(th);
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (this.f0) {
                return;
            }
            if (get() != 0) {
                this.f.onNext(t);
                sdk.pendo.io.q6.d.c(this, 1L);
                return;
            }
            try {
                this.s.accept(t);
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            if (sdk.pendo.io.p6.c.c(j)) {
                sdk.pendo.io.q6.d.a(this, j);
            }
        }
    }

    public j(sdk.pendo.io.x5.d<T> dVar) {
        super(dVar);
        this.A = this;
    }

    @Override // sdk.pendo.io.d6.e
    public void accept(T t) {
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        this.s.a((sdk.pendo.io.x5.e) new a(bVar, this.A));
    }
}
