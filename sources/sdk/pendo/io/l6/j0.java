package sdk.pendo.io.l6;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class j0<T> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.x5.p s;

    static final class a<T> extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        final sdk.pendo.io.x5.o<? super T> f;
        final AtomicReference<sdk.pendo.io.b6.b> s = new AtomicReference<>();

        a(sdk.pendo.io.x5.o<? super T> oVar) {
            this.f = oVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return sdk.pendo.io.e6.b.a(get());
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a(this.s);
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
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
            sdk.pendo.io.e6.b.c(this.s, bVar);
        }

        void a(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this, bVar);
        }
    }

    final class b implements Runnable {
        private final a<T> f;

        b(a<T> aVar) {
            this.f = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.f.a(this.f);
        }
    }

    public j0(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.x5.p pVar) {
        super(mVar);
        this.s = pVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        aVar.a(this.s.a(new b(aVar)));
    }
}
