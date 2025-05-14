package sdk.pendo.io.e7;

import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;
import sdk.pendo.io.y6.r;

/* loaded from: classes6.dex */
final class e<T> extends j<d<T>> {
    private final j<r<T>> f;

    private static class a<R> implements o<r<R>> {
        private final o<? super d<R>> f;

        a(o<? super d<R>> oVar) {
            this.f = oVar;
        }

        @Override // sdk.pendo.io.x5.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(r<R> rVar) {
            this.f.onNext(d.a(rVar));
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            try {
                this.f.onNext(d.a(th));
                this.f.onComplete();
            } catch (Throwable th2) {
                try {
                    this.f.onError(th2);
                } catch (Throwable th3) {
                    sdk.pendo.io.c6.b.b(th3);
                    sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(th2, th3));
                }
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            this.f.onSubscribe(bVar);
        }
    }

    e(j<r<T>> jVar) {
        this.f = jVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super d<T>> oVar) {
        this.f.a(new a(oVar));
    }
}
