package sdk.pendo.io.j6;

import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public final class f<T> extends sdk.pendo.io.x5.d<T> {
    private final sdk.pendo.io.x5.j<T> s;

    static final class a<T> implements o<T>, sdk.pendo.io.w5.c {
        final sdk.pendo.io.w5.b<? super T> f;
        sdk.pendo.io.b6.b s;

        a(sdk.pendo.io.w5.b<? super T> bVar) {
            this.f = bVar;
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            this.s.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            this.f.onNext(t);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            this.s = bVar;
            this.f.a(this);
        }
    }

    public f(sdk.pendo.io.x5.j<T> jVar) {
        this.s = jVar;
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        this.s.a((o) new a(bVar));
    }
}
