package sdk.pendo.io.l6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class l0<T, U> extends sdk.pendo.io.l6.a<T, T> {
    final sdk.pendo.io.x5.m<? extends U> s;

    static final class a<T, U> extends AtomicInteger implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        final sdk.pendo.io.x5.o<? super T> f;
        final AtomicReference<sdk.pendo.io.b6.b> s = new AtomicReference<>();
        final a<T, U>.C0182a A = new C0182a();
        final sdk.pendo.io.q6.c f0 = new sdk.pendo.io.q6.c();

        /* renamed from: sdk.pendo.io.l6.l0$a$a, reason: collision with other inner class name */
        final class C0182a extends AtomicReference<sdk.pendo.io.b6.b> implements sdk.pendo.io.x5.o<U> {
            C0182a() {
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
            public void onNext(U u) {
                sdk.pendo.io.e6.b.a(this);
                a.this.b();
            }

            @Override // sdk.pendo.io.x5.o
            public void onSubscribe(sdk.pendo.io.b6.b bVar) {
                sdk.pendo.io.e6.b.c(this, bVar);
            }
        }

        a(sdk.pendo.io.x5.o<? super T> oVar) {
            this.f = oVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return sdk.pendo.io.e6.b.a(this.s.get());
        }

        void b() {
            sdk.pendo.io.e6.b.a(this.s);
            sdk.pendo.io.q6.h.a(this.f, this, this.f0);
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a(this.s);
            sdk.pendo.io.e6.b.a(this.A);
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            sdk.pendo.io.e6.b.a(this.A);
            sdk.pendo.io.q6.h.a(this.f, this, this.f0);
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            sdk.pendo.io.e6.b.a(this.A);
            sdk.pendo.io.q6.h.a((sdk.pendo.io.x5.o<?>) this.f, th, (AtomicInteger) this, this.f0);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            sdk.pendo.io.q6.h.a(this.f, t, this, this.f0);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.c(this.s, bVar);
        }

        void a(Throwable th) {
            sdk.pendo.io.e6.b.a(this.s);
            sdk.pendo.io.q6.h.a((sdk.pendo.io.x5.o<?>) this.f, th, (AtomicInteger) this, this.f0);
        }
    }

    public l0(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.x5.m<? extends U> mVar2) {
        super(mVar);
        this.s = mVar2;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        a aVar = new a(oVar);
        oVar.onSubscribe(aVar);
        this.s.a(aVar.A);
        this.f.a(aVar);
    }
}
