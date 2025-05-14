package sdk.pendo.io.l6;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class e<T> extends sdk.pendo.io.l6.a<T, T> {
    final TimeUnit A;
    final sdk.pendo.io.x5.p f0;
    final long s;

    static final class a<T> extends AtomicReference<sdk.pendo.io.b6.b> implements Runnable, sdk.pendo.io.b6.b {
        final b<T> A;
        final T f;
        final AtomicBoolean f0 = new AtomicBoolean();
        final long s;

        a(T t, long j, b<T> bVar) {
            this.f = t;
            this.s = j;
            this.A = bVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() == sdk.pendo.io.e6.b.DISPOSED;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f0.compareAndSet(false, true)) {
                this.A.a(this.s, this.f, this);
            }
        }

        public void a(sdk.pendo.io.b6.b bVar) {
            sdk.pendo.io.e6.b.a((AtomicReference<sdk.pendo.io.b6.b>) this, bVar);
        }
    }

    static final class b<T> implements sdk.pendo.io.x5.o<T>, sdk.pendo.io.b6.b {
        final TimeUnit A;
        final sdk.pendo.io.x5.o<? super T> f;
        final p.c f0;
        final long s;
        sdk.pendo.io.b6.b t0;
        sdk.pendo.io.b6.b u0;
        volatile long v0;
        boolean w0;

        b(sdk.pendo.io.x5.o<? super T> oVar, long j, TimeUnit timeUnit, p.c cVar) {
            this.f = oVar;
            this.s = j;
            this.A = timeUnit;
            this.f0 = cVar;
        }

        void a(long j, T t, a<T> aVar) {
            if (j == this.v0) {
                this.f.onNext(t);
                aVar.dispose();
            }
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.t0.dispose();
            this.f0.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            if (this.w0) {
                return;
            }
            this.w0 = true;
            sdk.pendo.io.b6.b bVar = this.u0;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = (a) bVar;
            if (aVar != null) {
                aVar.run();
            }
            this.f.onComplete();
            this.f0.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            if (this.w0) {
                sdk.pendo.io.t6.a.b(th);
                return;
            }
            sdk.pendo.io.b6.b bVar = this.u0;
            if (bVar != null) {
                bVar.dispose();
            }
            this.w0 = true;
            this.f.onError(th);
            this.f0.dispose();
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            if (this.w0) {
                return;
            }
            long j = this.v0 + 1;
            this.v0 = j;
            sdk.pendo.io.b6.b bVar = this.u0;
            if (bVar != null) {
                bVar.dispose();
            }
            a aVar = new a(t, j, this);
            this.u0 = aVar;
            aVar.a(this.f0.a(aVar, this.s, this.A));
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.t0, bVar)) {
                this.t0 = bVar;
                this.f.onSubscribe(this);
            }
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f0.a();
        }
    }

    public e(sdk.pendo.io.x5.m<T> mVar, long j, TimeUnit timeUnit, sdk.pendo.io.x5.p pVar) {
        super(mVar);
        this.s = j;
        this.A = timeUnit;
        this.f0 = pVar;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        this.f.a(new b(new sdk.pendo.io.s6.b(oVar), this.s, this.A, this.f0.a()));
    }
}
