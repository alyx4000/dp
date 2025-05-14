package sdk.pendo.io.l6;

import java.util.Iterator;

/* loaded from: classes6.dex */
public final class p<T> extends sdk.pendo.io.x5.j<T> {
    final Iterable<? extends T> f;

    static final class a<T> extends sdk.pendo.io.h6.c<T> {
        volatile boolean A;
        final sdk.pendo.io.x5.o<? super T> f;
        boolean f0;
        final Iterator<? extends T> s;
        boolean t0;
        boolean u0;

        a(sdk.pendo.io.x5.o<? super T> oVar, Iterator<? extends T> it) {
            this.f = oVar;
            this.s = it;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.A;
        }

        void b() {
            while (!a()) {
                try {
                    this.f.onNext(sdk.pendo.io.f6.b.a((Object) this.s.next(), "The iterator returned a null value"));
                    if (a()) {
                        return;
                    }
                    if (!this.s.hasNext()) {
                        if (a()) {
                            return;
                        }
                        this.f.onComplete();
                        return;
                    }
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    this.f.onError(th);
                    return;
                }
            }
        }

        @Override // sdk.pendo.io.g6.g
        public void clear() {
            this.t0 = true;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.A = true;
        }

        @Override // sdk.pendo.io.g6.g
        public boolean isEmpty() {
            return this.t0;
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            if (this.t0) {
                return null;
            }
            if (!this.u0) {
                this.u0 = true;
            } else if (!this.s.hasNext()) {
                this.t0 = true;
                return null;
            }
            return (T) sdk.pendo.io.f6.b.a((Object) this.s.next(), "The iterator returned a null value");
        }

        @Override // sdk.pendo.io.g6.c
        public int a(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.f0 = true;
            return 1;
        }
    }

    public p(Iterable<? extends T> iterable) {
        this.f = iterable;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        try {
            Iterator<? extends T> it = this.f.iterator();
            if (!it.hasNext()) {
                sdk.pendo.io.e6.c.a(oVar);
                return;
            }
            a aVar = new a(oVar, it);
            oVar.onSubscribe(aVar);
            if (aVar.f0) {
                return;
            }
            aVar.b();
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            sdk.pendo.io.e6.c.a(th, oVar);
        }
    }
}
