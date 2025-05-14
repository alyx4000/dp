package sdk.pendo.io.e7;

import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.o;
import sdk.pendo.io.y6.h;
import sdk.pendo.io.y6.r;

/* loaded from: classes6.dex */
final class c<T> extends j<r<T>> {
    private final sdk.pendo.io.y6.b<T> f;

    private static final class a implements sdk.pendo.io.b6.b {
        private final sdk.pendo.io.y6.b<?> f;

        a(sdk.pendo.io.y6.b<?> bVar) {
            this.f = bVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f.e();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.f.cancel();
        }
    }

    c(sdk.pendo.io.y6.b<T> bVar) {
        this.f = bVar;
    }

    static <T> boolean a(o<? super r<T>> oVar, sdk.pendo.io.y6.b<T> bVar, r<T> rVar) {
        if (bVar.e()) {
            return false;
        }
        if (rVar == null || !(rVar.d() || sdk.pendo.io.g9.a.f1122a.a(rVar.b()))) {
            h hVar = new h(rVar);
            try {
                oVar.onError(hVar);
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(hVar, th));
            }
        } else {
            oVar.onNext(rVar);
            if (bVar.e()) {
                return false;
            }
            oVar.onComplete();
        }
        return true;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super r<T>> oVar) {
        sdk.pendo.io.y6.b<T> clone = this.f.clone();
        oVar.onSubscribe(new a(clone));
        try {
            a(oVar, clone, clone.b());
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            if (clone.e()) {
                return;
            }
            try {
                oVar.onError(th);
            } catch (Throwable th2) {
                sdk.pendo.io.c6.b.b(th2);
                sdk.pendo.io.t6.a.b(new sdk.pendo.io.c6.a(th, th2));
            }
        }
    }
}
