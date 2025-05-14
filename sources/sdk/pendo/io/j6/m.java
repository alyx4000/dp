package sdk.pendo.io.j6;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class m<T, U> extends sdk.pendo.io.j6.a<T, T> {
    final sdk.pendo.io.w5.a<? extends U> A;

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c {
        final sdk.pendo.io.w5.b<? super T> f;
        final AtomicLong s = new AtomicLong();
        final AtomicReference<sdk.pendo.io.w5.c> A = new AtomicReference<>();
        final a<T>.C0165a t0 = new C0165a();
        final sdk.pendo.io.q6.c f0 = new sdk.pendo.io.q6.c();

        /* renamed from: sdk.pendo.io.j6.m$a$a, reason: collision with other inner class name */
        final class C0165a extends AtomicReference<sdk.pendo.io.w5.c> implements sdk.pendo.io.x5.e<Object> {
            C0165a() {
            }

            @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
            public void a(sdk.pendo.io.w5.c cVar) {
                sdk.pendo.io.p6.c.a(this, cVar, Long.MAX_VALUE);
            }

            @Override // sdk.pendo.io.w5.b
            public void onComplete() {
                sdk.pendo.io.p6.c.a(a.this.A);
                a aVar = a.this;
                sdk.pendo.io.q6.h.a(aVar.f, aVar, aVar.f0);
            }

            @Override // sdk.pendo.io.w5.b
            public void onError(Throwable th) {
                sdk.pendo.io.p6.c.a(a.this.A);
                a aVar = a.this;
                sdk.pendo.io.q6.h.a((sdk.pendo.io.w5.b<?>) aVar.f, th, (AtomicInteger) aVar, aVar.f0);
            }

            @Override // sdk.pendo.io.w5.b
            public void onNext(Object obj) {
                sdk.pendo.io.p6.c.a(this);
                onComplete();
            }
        }

        a(sdk.pendo.io.w5.b<? super T> bVar) {
            this.f = bVar;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            sdk.pendo.io.p6.c.a(this.A, this.s, cVar);
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            sdk.pendo.io.p6.c.a(this.A);
            sdk.pendo.io.p6.c.a(this.t0);
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            sdk.pendo.io.p6.c.a(this.t0);
            sdk.pendo.io.q6.h.a(this.f, this, this.f0);
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            sdk.pendo.io.p6.c.a(this.t0);
            sdk.pendo.io.q6.h.a((sdk.pendo.io.w5.b<?>) this.f, th, (AtomicInteger) this, this.f0);
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            sdk.pendo.io.q6.h.a(this.f, t, this, this.f0);
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            sdk.pendo.io.p6.c.a(this.A, this.s, j);
        }
    }

    public m(sdk.pendo.io.x5.d<T> dVar, sdk.pendo.io.w5.a<? extends U> aVar) {
        super(dVar);
        this.A = aVar;
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        a aVar = new a(bVar);
        bVar.a(aVar);
        this.A.a(aVar.t0);
        this.s.a((sdk.pendo.io.x5.e) aVar);
    }
}
