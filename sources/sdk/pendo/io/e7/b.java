package sdk.pendo.io.e7;

import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;
import sdk.pendo.io.y6.r;

/* loaded from: classes6.dex */
final class b<T> extends j<r<T>> {
    private final sdk.pendo.io.y6.b<T> f;

    private static final class a<T> implements sdk.pendo.io.b6.b, sdk.pendo.io.y6.d<T> {
        boolean A = false;
        private final sdk.pendo.io.y6.b<?> f;
        private final o<? super r<T>> s;

        a(sdk.pendo.io.y6.b<?> bVar, o<? super r<T>> oVar) {
            this.f = bVar;
            this.s = oVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f.e();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.f.cancel();
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> bVar, Throwable th) {
            if (bVar.e()) {
                return;
            }
            try {
                this.s.onError(th);
            } catch (Throwable th2) {
                sdk.pendo.io.c6.b.b(th2);
                sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(th, th2));
            }
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> bVar, r<T> rVar) {
            if (bVar.e()) {
                return;
            }
            try {
                this.A = c.a(this.s, bVar, rVar);
            } catch (Throwable th) {
                if (this.A) {
                    sdk.pendo.io.t6.a.b(th);
                    return;
                }
                if (bVar.e()) {
                    return;
                }
                try {
                    this.s.onError(th);
                } catch (Throwable th2) {
                    sdk.pendo.io.c6.b.b(th2);
                    sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(th, th2));
                }
            }
        }
    }

    b(sdk.pendo.io.y6.b<T> bVar) {
        this.f = bVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super r<T>> oVar) {
        sdk.pendo.io.y6.b<T> clone = this.f.clone();
        a aVar = new a(clone, oVar);
        oVar.onSubscribe(aVar);
        clone.a(aVar);
    }
}
