package sdk.pendo.io.l6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
public final class d0<T> extends sdk.pendo.io.l6.a<T, T> {
    final TimeUnit A;
    final sdk.pendo.io.x5.p f0;
    final long s;
    final boolean t0;

    static final class a<T> extends c<T> {
        final AtomicInteger v0;

        a(sdk.pendo.io.x5.o<? super T> oVar, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar) {
            super(oVar, j, timeUnit, pVar);
            this.v0 = new AtomicInteger(1);
        }

        @Override // sdk.pendo.io.l6.d0.c
        void c() {
            e();
            if (this.v0.decrementAndGet() == 0) {
                this.f.onComplete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.v0.incrementAndGet() == 2) {
                e();
                if (this.v0.decrementAndGet() == 0) {
                    this.f.onComplete();
                }
            }
        }
    }

    static final class b<T> extends c<T> {
        b(sdk.pendo.io.x5.o<? super T> oVar, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar) {
            super(oVar, j, timeUnit, pVar);
        }

        @Override // sdk.pendo.io.l6.d0.c
        void c() {
            this.f.onComplete();
        }

        @Override // java.lang.Runnable
        public void run() {
            e();
        }
    }

    static abstract class c<T> extends AtomicReference<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b, Runnable {
        final TimeUnit A;
        final sdk.pendo.io.x5.o<? super T> f;
        final sdk.pendo.io.x5.p f0;
        final long s;
        final AtomicReference<sdk.pendo.io.b6.b> t0 = new AtomicReference<>();
        sdk.pendo.io.b6.b u0;

        c(sdk.pendo.io.x5.o<? super T> oVar, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar) {
            this.f = oVar;
            this.s = j;
            this.A = timeUnit;
            this.f0 = pVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.u0.a();
        }

        void b() {
            sdk.pendo.io.e6.b.a(this.t0);
        }

        abstract void c();

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            b();
            this.u0.dispose();
        }

        void e() {
            T andSet = getAndSet(null);
            if (andSet != null) {
                this.f.onNext(andSet);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            b();
            c();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            b();
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            lazySet(t);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.u0, bVar)) {
                this.u0 = bVar;
                this.f.onSubscribe(this);
                sdk.pendo.io.x5.p pVar = this.f0;
                long j = this.s;
                sdk.pendo.io.e6.b.a(this.t0, pVar.a(this, j, j, this.A));
            }
        }
    }

    public d0(sdk.pendo.io.x5.m<T> mVar, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar, boolean z) {
        super(mVar);
        this.s = j;
        this.A = timeUnit;
        this.f0 = pVar;
        this.t0 = z;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        sdk.pendo.io.x5.m<T> mVar;
        sdk.pendo.io.x5.o<? super T> bVar;
        sdk.pendo.io.s6.b bVar2 = new sdk.pendo.io.s6.b(oVar);
        if (this.t0) {
            mVar = this.f;
            bVar = new a<>(bVar2, this.s, this.A, this.f0);
        } else {
            mVar = this.f;
            bVar = new b<>(bVar2, this.s, this.A, this.f0);
        }
        mVar.a(bVar);
    }
}
