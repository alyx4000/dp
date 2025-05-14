package sdk.pendo.io.l6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class c0<T> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.d6.h<? super sdk.pendo.io.x5.j<Throwable>, ? extends sdk.pendo.io.x5.m<?>> s;

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        final sdk.pendo.io.x5.o<? super T> f;
        final sdk.pendo.io.w6.d<Throwable> f0;
        final sdk.pendo.io.x5.m<T> v0;
        volatile boolean w0;
        final AtomicInteger s = new AtomicInteger();
        final sdk.pendo.io.q6.c A = new sdk.pendo.io.q6.c();
        final a<T>.C0179a t0 = new C0179a();
        final AtomicReference<sdk.pendo.io.b6.b> u0 = new AtomicReference<>();

        /* renamed from: sdk.pendo.io.l6.c0$a$a, reason: collision with other inner class name */
        final class C0179a extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.x5.o<Object> {
            C0179a() {
            }

            @Override // sdk.pendo.io.x5.o
            public void onComplete() {
                a.this.b();
            }

            @Override // sdk.pendo.io.x5.o
            public void onError(Throwable th) {
                a.this.a(th);
            }

            @Override // sdk.pendo.io.x5.o
            public void onNext(Object obj) {
                a.this.c();
            }

            @Override // sdk.pendo.io.x5.o
            public void onSubscribe(sdk.pendo.io.b6.b bVar) {
                sdk.pendo.io.e6.b.c(this, bVar);
            }
        }

        a(sdk.pendo.io.x5.o<? super T> oVar, sdk.pendo.io.w6.d<Throwable> dVar, sdk.pendo.io.x5.m<T> mVar) {
            this.f = oVar;
            this.f0 = dVar;
            this.v0 = mVar;
        }

        void a(Throwable th) {
            sdk.pendo.io.e6.b.a(this.u0);
            sdk.pendo.io.q6.h.a((sdk.pendo.io.x5.o<?>) this.f, th, (AtomicInteger) this, this.A);
        }

        void b() {
            sdk.pendo.io.e6.b.a(this.u0);
            sdk.pendo.io.q6.h.a(this.f, this, this.A);
        }

        void c() {
            e();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a(this.u0);
            sdk.pendo.io.e6.b.a(this.t0);
        }

        void e() {
            if (this.s.getAndIncrement() == 0) {
                while (!a()) {
                    if (!this.w0) {
                        this.w0 = true;
                        this.v0.a(this);
                    }
                    if (this.s.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            sdk.pendo.io.e6.b.a(this.t0);
            sdk.pendo.io.q6.h.a(this.f, this, this.A);
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            sdk.pendo.io.e6.b.a(this.u0, (sdk.pendo.io.b6.b) null);
            this.w0 = false;
            this.f0.onNext(th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            sdk.pendo.io.q6.h.a(this.f, t, this, this.A);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.a(this.u0, bVar);
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return sdk.pendo.io.e6.b.a(this.u0.get());
        }
    }

    public c0(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.d6.h<? super sdk.pendo.io.x5.j<Throwable>, ? extends sdk.pendo.io.x5.m<?>> hVar) {
        super(mVar);
        this.s = hVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super T> oVar) {
        sdk.pendo.io.w6.d<T> m = sdk.pendo.io.w6.b.n().m();
        try {
            sdk.pendo.io.x5.m mVar = (sdk.pendo.io.x5.m) sdk.pendo.io.f6.b.a(this.s.apply(m), "The handler returned a null ObservableSource");
            a aVar = new a(oVar, m, this.f);
            oVar.onSubscribe(aVar);
            mVar.a(aVar.t0);
            aVar.e();
        } catch (Throwable th) {
            sdk.pendo.io.c6.b.b(th);
            sdk.pendo.io.e6.c.a(th, oVar);
        }
    }
}
