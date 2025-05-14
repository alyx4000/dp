package sdk.pendo.io.e7;

import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;
import sdk.pendo.io.y6.h;
import sdk.pendo.io.y6.r;

/* loaded from: classes6.dex */
final class a<T> extends j<T> {
    private final j<r<T>> f;

    /* renamed from: sdk.pendo.io.e7.a$a, reason: collision with other inner class name */
    private static class C0121a<R> implements o<r<R>> {
        private final o<? super R> f;
        private boolean s;

        C0121a(o<? super R> oVar) {
            this.f = oVar;
        }

        @Override // sdk.pendo.io.x5.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(r<R> rVar) {
            if (rVar.d()) {
                this.f.onNext(rVar.a());
                return;
            }
            this.s = true;
            h hVar = new h(rVar);
            try {
                this.f.onError(hVar);
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(hVar, th));
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.s) {
                return;
            }
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (!this.s) {
                this.f.onError(th);
                return;
            }
            AssertionError assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
            assertionError.initCause(th);
            sdk.pendo.io.t6.a.b(assertionError);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            this.f.onSubscribe(bVar);
        }
    }

    a(j<r<T>> jVar) {
        this.f = jVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super T> oVar) {
        this.f.a(new C0121a(oVar));
    }
}
