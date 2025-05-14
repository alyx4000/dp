package sdk.pendo.io.j6;

import java.util.concurrent.TimeUnit;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class c<T> extends sdk.pendo.io.j6.a<T, T> {
    final long A;
    final TimeUnit f0;
    final p t0;
    final boolean u0;

    static final class a<T> implements sdk.pendo.io.x5.e<T>, sdk.pendo.io.w5.c {
        final TimeUnit A;
        final sdk.pendo.io.w5.b<? super T> f;
        final p.c f0;
        final long s;
        final boolean t0;
        sdk.pendo.io.w5.c u0;

        /* renamed from: sdk.pendo.io.j6.c$a$a, reason: collision with other inner class name */
        final class RunnableC0163a implements Runnable {
            RunnableC0163a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f.onComplete();
                } finally {
                    a.this.f0.dispose();
                }
            }
        }

        final class b implements Runnable {
            private final Throwable f;

            b(Throwable th) {
                this.f = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f.onError(this.f);
                } finally {
                    a.this.f0.dispose();
                }
            }
        }

        /* renamed from: sdk.pendo.io.j6.c$a$c, reason: collision with other inner class name */
        final class RunnableC0164c implements Runnable {
            private final T f;

            RunnableC0164c(T t) {
                this.f = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f.onNext(this.f);
            }
        }

        a(sdk.pendo.io.w5.b<? super T> bVar, long j, TimeUnit timeUnit, p.c cVar, boolean z) {
            this.f = bVar;
            this.s = j;
            this.A = timeUnit;
            this.f0 = cVar;
            this.t0 = z;
        }

        @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
        public void a(sdk.pendo.io.w5.c cVar) {
            if (sdk.pendo.io.p6.c.a(this.u0, cVar)) {
                this.u0 = cVar;
                this.f.a(this);
            }
        }

        @Override // sdk.pendo.io.w5.c
        public void cancel() {
            this.u0.cancel();
            this.f0.dispose();
        }

        @Override // sdk.pendo.io.w5.b
        public void onComplete() {
            this.f0.a(new RunnableC0163a(), this.s, this.A);
        }

        @Override // sdk.pendo.io.w5.b
        public void onError(Throwable th) {
            this.f0.a(new b(th), this.t0 ? this.s : 0L, this.A);
        }

        @Override // sdk.pendo.io.w5.b
        public void onNext(T t) {
            this.f0.a(new RunnableC0164c(t), this.s, this.A);
        }

        @Override // sdk.pendo.io.w5.c
        public void a(long j) {
            this.u0.a(j);
        }
    }

    public c(sdk.pendo.io.x5.d<T> dVar, long j, TimeUnit timeUnit, p pVar, boolean z) {
        super(dVar);
        this.A = j;
        this.f0 = timeUnit;
        this.t0 = pVar;
        this.u0 = z;
    }

    @Override // sdk.pendo.io.x5.d
    protected void b(sdk.pendo.io.w5.b<? super T> bVar) {
        this.s.a((sdk.pendo.io.x5.e) new a(this.u0 ? bVar : new sdk.pendo.io.x6.a(bVar), this.A, this.f0, this.t0.a(), this.u0));
    }
}
