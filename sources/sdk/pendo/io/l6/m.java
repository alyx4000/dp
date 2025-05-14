package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class m<T> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.d6.j<? super T> s;

    static final class a<T> extends sdk.pendo.io.h6.a<T, T> {
        final sdk.pendo.io.d6.j<? super T> u0;

        a(sdk.pendo.io.x5.o<? super T> oVar, sdk.pendo.io.d6.j<? super T> jVar) {
            super(oVar);
            this.u0 = jVar;
        }

        @Override // sdk.pendo.io.g6.c
        public int a(int i) {
            return b(i);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.t0 != 0) {
                this.f.onNext(null);
                return;
            }
            try {
                if (this.u0.test(t)) {
                    this.f.onNext(t);
                }
            } catch (Throwable th) {
                a(th);
            }
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            T poll;
            do {
                poll = this.A.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.u0.test(poll));
            return poll;
        }
    }

    public m(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.j<? super T> jVar) {
        super(mVar);
        this.s = jVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s));
    }
}
