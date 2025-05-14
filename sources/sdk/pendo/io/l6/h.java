package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class h<T, K> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.d6.c<? super K, ? super K> A;
    final sdk.pendo.io.d6.h<? super T, K> s;

    static final class a<T, K> extends sdk.pendo.io.h6.a<T, T> {
        final sdk.pendo.io.d6.h<? super T, K> u0;
        final sdk.pendo.io.d6.c<? super K, ? super K> v0;
        K w0;
        boolean x0;

        a(sdk.pendo.io.x5.o<? super T> oVar, sdk.pendo.io.d6.h<? super T, K> hVar, sdk.pendo.io.d6.c<? super K, ? super K> cVar) {
            super(oVar);
            this.u0 = hVar;
            this.v0 = cVar;
        }

        @Override // sdk.pendo.io.g6.c
        public int a(int i) {
            return b(i);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.f0) {
                return;
            }
            if (this.t0 == 0) {
                try {
                    K apply = this.u0.apply(t);
                    if (this.x0) {
                        boolean a2 = this.v0.a(this.w0, apply);
                        this.w0 = apply;
                        if (a2) {
                            return;
                        }
                    } else {
                        this.x0 = true;
                        this.w0 = apply;
                    }
                } catch (Throwable th) {
                    a(th);
                    return;
                }
            }
            this.f.onNext(t);
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            T poll;
            boolean a2;
            do {
                poll = this.A.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.u0.apply(poll);
                if (!this.x0) {
                    this.x0 = true;
                    this.w0 = apply;
                    return poll;
                }
                a2 = this.v0.a(this.w0, apply);
                this.w0 = apply;
            } while (a2);
            return poll;
        }
    }

    public h(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.h<? super T, K> hVar, sdk.pendo.io.d6.c<? super K, ? super K> cVar) {
        super(mVar);
        this.s = hVar;
        this.A = cVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s, this.A));
    }
}
