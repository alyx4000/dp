package sdk.pendo.io.l6;

import java.util.concurrent.TimeUnit;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class f<T> extends sdk.pendo.io.l6.a<T, T> {
    final TimeUnit A;
    final sdk.pendo.io.x5.p f0;
    final long s;
    final boolean t0;

    static final class a<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        final TimeUnit A;
        final sdk.pendo.io.x5.o<? super T> f;
        final p.c f0;
        final long s;
        final boolean t0;
        sdk.pendo.io.b6.b u0;

        /* renamed from: sdk.pendo.io.l6.f$a$a, reason: collision with other inner class name */
        final class RunnableC0180a implements Runnable {
            RunnableC0180a() {
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

        final class c implements Runnable {
            private final T f;

            c(T t) {
                this.f = t;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f.onNext(this.f);
            }
        }

        a(sdk.pendo.io.x5.o<? super T> oVar, long j, TimeUnit timeUnit, p.c cVar, boolean z) {
            this.f = oVar;
            this.s = j;
            this.A = timeUnit;
            this.f0 = cVar;
            this.t0 = z;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f0.a();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.u0.dispose();
            this.f0.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.f0.a(new RunnableC0180a(), this.s, this.A);
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.f0.a(new b(th), this.t0 ? this.s : 0L, this.A);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            this.f0.a(new c(t), this.s, this.A);
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.u0, bVar)) {
                this.u0 = bVar;
                this.f.onSubscribe(this);
            }
        }
    }

    public f(sdk.pendo.io.x5.m<T> mVar, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar, boolean z) {
        super(mVar);
        this.s = j;
        this.A = timeUnit;
        this.f0 = pVar;
        this.t0 = z;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new a(this.t0 ? oVar : new sdk.pendo.io.s6.b(oVar), this.s, this.A, this.f0.a(), this.t0));
    }
}
