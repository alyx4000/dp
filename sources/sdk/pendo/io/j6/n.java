package sdk.pendo.io.j6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class n<T> extends sdk.pendo.io.j6.a<T, T> {
    final long A;
    final TimeUnit f0;
    final p t0;
    final sdk.pendo.io.w5.a<? extends T> u0;

    static final class a<T> implements sdk.pendo.io.x5.e<T> {
        final sdk.pendo.io.w5.b<? super T> f;
        final sdk.pendo.io.p6.b s;

        a(sdk.pendo.io.w5.b<? super T> bVar, sdk.pendo.io.p6.b bVar2) {
            this.f = bVar;
            this.s = bVar2;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            this.s.b(cVar);
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            this.f.onError(th);
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            this.f.onNext(t);
        }
    }

    static final class b<T> extends sdk.pendo.io.p6.b implements sdk.pendo.io.x5.e<T>, d {
        final p.c A0;
        final sdk.pendo.io.e6.f B0;
        final AtomicReference<sdk.pendo.io.w5.c> C0;
        final AtomicLong D0;
        long E0;
        sdk.pendo.io.w5.a<? extends T> F0;
        final sdk.pendo.io.w5.b<? super T> x0;
        final long y0;
        final TimeUnit z0;

        b(sdk.pendo.io.w5.b<? super T> bVar, long j, TimeUnit timeUnit, p.c cVar, sdk.pendo.io.w5.a<? extends T> aVar) {
            super(true);
            this.x0 = bVar;
            this.y0 = j;
            this.z0 = timeUnit;
            this.A0 = cVar;
            this.F0 = aVar;
            this.B0 = new sdk.pendo.io.e6.f();
            this.C0 = new AtomicReference<>();
            this.D0 = new AtomicLong();
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.C0, cVar)) {
                b(cVar);
            }
        }

        @Override // sdk.pendo.io.j6.n.d
        public void b(long j) {
            if (this.D0.compareAndSet(j, Long.MAX_VALUE)) {
                sdk.pendo.io.p6.c.a(this.C0);
                long j2 = this.E0;
                if (j2 != 0) {
                    c(j2);
                }
                sdk.pendo.io.w5.a<? extends T> aVar = this.F0;
                this.F0 = null;
                aVar.a(new a(this.x0, this));
                this.A0.dispose();
            }
        }

        @Override // sdk.pendo.io.p6.b, sdk.pendo.io.w5.c
        public void cancel() {
            super.cancel();
            this.A0.dispose();
        }

        void d(long j) {
            this.B0.a(this.A0.a(new e(j, this), this.y0, this.z0));
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            if (this.D0.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.B0.dispose();
                this.x0.onComplete();
                this.A0.dispose();
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (this.D0.getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.B0.dispose();
            this.x0.onError(th);
            this.A0.dispose();
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            long j = this.D0.get();
            if (j != Long.MAX_VALUE) {
                long j2 = j + 1;
                if (this.D0.compareAndSet(j, j2)) {
                    this.B0.get().dispose();
                    this.E0++;
                    this.x0.onNext(t);
                    d(j2);
                }
            }
        }
    }

    static final class c<T> extends AtomicLong implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c, d {
        final TimeUnit A;
        final sdk.pendo.io.w5.b<? super T> f;
        final p.c f0;
        final long s;
        final sdk.pendo.io.e6.f t0 = new sdk.pendo.io.e6.f();
        final AtomicReference<sdk.pendo.io.w5.c> u0 = new AtomicReference<>();
        final AtomicLong v0 = new AtomicLong();

        c(sdk.pendo.io.w5.b<? super T> bVar, long j, TimeUnit timeUnit, p.c cVar) {
            this.f = bVar;
            this.s = j;
            this.A = timeUnit;
            this.f0 = cVar;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            sdk.pendo.io.p6.c.a(this.u0, this.v0, cVar);
        }

        @Override // sdk.pendo.io.j6.n.d
        public void b(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                sdk.pendo.io.p6.c.a(this.u0);
                this.f.onError(new TimeoutException(sdk.pendo.io.q6.g.a(this.s, this.A)));
                this.f0.dispose();
            }
        }

        void c(long j) {
            this.t0.a(this.f0.a(new e(j, this), this.s, this.A));
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            sdk.pendo.io.p6.c.a(this.u0);
            this.f0.dispose();
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.t0.dispose();
                this.f.onComplete();
                this.f0.dispose();
            }
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) == Long.MAX_VALUE) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            this.t0.dispose();
            this.f.onError(th);
            this.f0.dispose();
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    this.t0.get().dispose();
                    this.f.onNext(t);
                    c(j2);
                }
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            sdk.pendo.io.p6.c.a(this.u0, this.v0, j);
        }
    }

    interface d {
        void b(long j);
    }

    static final class e implements Runnable {
        final d f;
        final long s;

        e(long j, d dVar) {
            this.s = j;
            this.f = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f.b(this.s);
        }
    }

    public n(sdk.pendo.io.x5.d<T> dVar, long j, TimeUnit timeUnit, p pVar, sdk.pendo.io.w5.a<? extends T> aVar) {
        super(dVar);
        this.A = j;
        this.f0 = timeUnit;
        this.t0 = pVar;
        this.u0 = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        b bVar2;
        if (this.u0 == null) {
            c cVar = new c(bVar, this.A, this.f0, this.t0.a());
            bVar.a(cVar);
            cVar.c(0L);
            bVar2 = cVar;
        } else {
            b bVar3 = new b(bVar, this.A, this.f0, this.t0.a(), this.u0);
            bVar.a(bVar3);
            bVar3.d(0L);
            bVar2 = bVar3;
        }
        this.s.a((sdk.pendo.io.x5.e) bVar2);
    }
}
