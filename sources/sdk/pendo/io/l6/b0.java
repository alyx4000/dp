package sdk.pendo.io.l6;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public final class b0<T> extends sdk.pendo.io.l6.a<T, T> {
    final long A;
    final sdk.pendo.io.d6.j<? super Throwable> s;

    static final class a<T> extends AtomicInteger implements sdk.pendo.io.x5.o<T> {
        final sdk.pendo.io.x5.m<? extends T> A;
        final sdk.pendo.io.x5.o<? super T> f;
        final sdk.pendo.io.d6.j<? super Throwable> f0;
        final sdk.pendo.io.e6.f s;
        long t0;

        a(sdk.pendo.io.x5.o<? super T> oVar, long j, sdk.pendo.io.d6.j<? super Throwable> jVar, sdk.pendo.io.e6.f fVar, sdk.pendo.io.x5.m<? extends T> mVar) {
            this.f = oVar;
            this.s = fVar;
            this.A = mVar;
            this.f0 = jVar;
            this.t0 = j;
        }

        void a() {
            if (getAndIncrement() == 0) {
                int i = 1;
                while (!this.s.a()) {
                    this.A.a(this);
                    i = addAndGet(-i);
                    if (i == 0) {
                        return;
                    }
                }
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.f.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            long j = this.t0;
            if (j != Long.MAX_VALUE) {
                this.t0 = j - 1;
            }
            if (j == 0) {
                this.f.onError(th);
                return;
            }
            try {
                if (this.f0.test(th)) {
                    a();
                } else {
                    this.f.onError(th);
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
            this.s.a(bVar);
        }
    }

    public b0(sdk.pendo.io.x5.j<T> jVar, long j, sdk.pendo.io.d6.j<? super Throwable> jVar2) {
        super(jVar);
        this.s = jVar2;
        this.A = j;
    }

    @Override // sdk.pendo.io.x5.j
    public void b(sdk.pendo.io.x5.o<? super T> oVar) {
        sdk.pendo.io.e6.f fVar = new sdk.pendo.io.e6.f();
        oVar.onSubscribe(fVar);
        new a(oVar, this.A, this.s, fVar, this.f).a();
    }
}
