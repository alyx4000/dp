package sdk.pendo.io.l6;

/* loaded from: classes6.dex */
public final class w<T> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.d6.h<? super Throwable, ? extends T> s;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        sdk.pendo.io.b6.b A;
        final sdk.pendo.io.x5.o<? super T> f;
        final sdk.pendo.io.d6.h<? super Throwable, ? extends T> s;

        a(sdk.pendo.io.x5.o<? super T> oVar, sdk.pendo.io.d6.h<? super Throwable, ? extends T> hVar) {
            this.f = oVar;
            this.s = hVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.A.a();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.A.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            try {
                T apply = this.s.apply(th);
                if (apply != null) {
                    this.f.onNext(apply);
                    this.f.onComplete();
                } else {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f.onError(nullPointerException);
                }
            } catch (Throwable th2) {
                sdk.pendo.io.c6.b.b(th2);
                this.f.onError(new sdk.pendo.io.c6.a(th, th2));
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            this.f.onNext(t);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.A, bVar)) {
                this.A = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public w(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.h<? super Throwable, ? extends T> hVar) {
        super(mVar);
        this.s = hVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(oVar, this.s));
    }
}
