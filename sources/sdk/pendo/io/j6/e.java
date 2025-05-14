package sdk.pendo.io.j6;

/* loaded from: classes6.dex */
public final class e<T> extends sdk.pendo.io.j6.a<T, T> {
    final sdk.pendo.io.d6.j<? super T> A;

    static final class a<T> extends sdk.pendo.io.o6.a<T, T> {
        final sdk.pendo.io.d6.j<? super T> u0;

        a(sdk.pendo.io.g6.a<? super T> aVar, sdk.pendo.io.d6.j<? super T> jVar) {
            super(aVar);
            this.u0 = jVar;
        }

        @Override // sdk.pendo.io.g6.a
        public boolean a(T t) {
            if (this.f0) {
                return false;
            }
            if (this.t0 != 0) {
                return this.f.a((sdk.pendo.io.g6.a<? super R>) null);
            }
            try {
                return this.u0.test(t) && this.f.a((sdk.pendo.io.g6.a<? super R>) t);
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (a((a<T>) t)) {
                return;
            }
            this.s.a(1L);
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            sdk.pendo.io.g6.d<T> dVar = this.A;
            sdk.pendo.io.d6.j<? super T> jVar = this.u0;
            while (true) {
                T poll = dVar.poll();
                if (poll == null) {
                    return null;
                }
                if (jVar.test(poll)) {
                    return poll;
                }
                if (this.t0 == 2) {
                    dVar.a(1L);
                }
            }
        }
    }

    static final class b<T> extends sdk.pendo.io.o6.b<T, T> implements sdk.pendo.io.g6.a<T> {
        final sdk.pendo.io.d6.j<? super T> u0;

        b(sdk.pendo.io.w5.b<? super T> bVar, sdk.pendo.io.d6.j<? super T> jVar) {
            super(bVar);
            this.u0 = jVar;
        }

        @Override // sdk.pendo.io.g6.a
        public boolean a(T t) {
            if (this.f0) {
                return false;
            }
            if (this.t0 != 0) {
                this.f.onNext(null);
                return true;
            }
            try {
                boolean test = this.u0.test(t);
                if (test) {
                    this.f.onNext(t);
                }
                return test;
            } catch (Throwable th) {
                a(th);
                return true;
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            if (a((b<T>) t)) {
                return;
            }
            this.s.a(1L);
        }

        @Override // sdk.pendo.io.g6.g
        public T poll() {
            sdk.pendo.io.g6.d<T> dVar = this.A;
            sdk.pendo.io.d6.j<? super T> jVar = this.u0;
            while (true) {
                T poll = dVar.poll();
                if (poll == null) {
                    return null;
                }
                if (jVar.test(poll)) {
                    return poll;
                }
                if (this.t0 == 2) {
                    dVar.a(1L);
                }
            }
        }
    }

    public e(sdk.pendo.io.x5.d<T> dVar, sdk.pendo.io.d6.j<? super T> jVar) {
        super(dVar);
        this.A = jVar;
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        sdk.pendo.io.x5.d<T> dVar;
        sdk.pendo.io.x5.e<? super T> bVar2;
        if (bVar instanceof sdk.pendo.io.g6.a) {
            dVar = this.s;
            bVar2 = new a<>((sdk.pendo.io.g6.a) bVar, this.A);
        } else {
            dVar = this.s;
            bVar2 = new b<>(bVar, this.A);
        }
        dVar.a((sdk.pendo.io.x5.e) bVar2);
    }
}
