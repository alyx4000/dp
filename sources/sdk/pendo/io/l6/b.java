package sdk.pendo.io.l6;

import java.util.Collection;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class b<T, U extends Collection<? super T>, B> extends sdk.pendo.io.l6.a<T, U> {
    final Callable<U> A;
    final sdk.pendo.io.x5.m<B> s;

    static final class a<T, U extends Collection<? super T>, B> extends sdk.pendo.io.s6.a<B> {
        final C0178b<T, U, B> s;

        a(C0178b<T, U, B> c0178b) {
            this.s = c0178b;
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            this.s.onComplete();
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            this.s.onError(th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(B b) {
            this.s.f();
        }
    }

    /* renamed from: sdk.pendo.io.l6.b$b, reason: collision with other inner class name */
    static final class C0178b<T, U extends Collection<? super T>, B> extends sdk.pendo.io.h6.g<T, U, U> implements sdk.pendo.io.b6.b {
        final Callable<U> v0;
        final sdk.pendo.io.x5.m<B> w0;
        sdk.pendo.io.b6.b x0;
        sdk.pendo.io.b6.b y0;
        U z0;

        C0178b(sdk.pendo.io.x5.o<? super U> oVar, Callable<U> callable, sdk.pendo.io.x5.m<B> mVar) {
            super(oVar, new sdk.pendo.io.m6.a());
            this.v0 = callable;
            this.w0 = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // sdk.pendo.io.h6.g, sdk.pendo.io.q6.j
        public /* bridge */ /* synthetic */ void a(sdk.pendo.io.x5.o oVar, Object obj) {
            a((sdk.pendo.io.x5.o<? super sdk.pendo.io.x5.o>) oVar, (sdk.pendo.io.x5.o) obj);
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.f0) {
                return;
            }
            this.f0 = true;
            this.y0.dispose();
            this.x0.dispose();
            if (e()) {
                this.A.clear();
            }
        }

        void f() {
            try {
                U u = (U) sdk.pendo.io.f6.b.a(this.v0.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.z0;
                    if (u2 == null) {
                        return;
                    }
                    this.z0 = u;
                    a(u2, false, this);
                }
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                dispose();
                this.s.onError(th);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onComplete() {
            synchronized (this) {
                U u = this.z0;
                if (u == null) {
                    return;
                }
                this.z0 = null;
                this.A.offer(u);
                this.t0 = true;
                if (e()) {
                    sdk.pendo.io.q6.m.a((sdk.pendo.io.g6.f) this.A, (sdk.pendo.io.x5.o) this.s, false, (sdk.pendo.io.b6.b) this, (sdk.pendo.io.q6.j) this);
                }
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onError(Throwable th) {
            dispose();
            this.s.onError(th);
        }

        @Override // sdk.pendo.io.x5.o
        public void onNext(T t) {
            synchronized (this) {
                U u = this.z0;
                if (u == null) {
                    return;
                }
                u.add(t);
            }
        }

        @Override // sdk.pendo.io.x5.o
        public void onSubscribe(sdk.pendo.io.b6.b bVar) {
            if (sdk.pendo.io.e6.b.a(this.x0, bVar)) {
                this.x0 = bVar;
                try {
                    this.z0 = (U) sdk.pendo.io.f6.b.a(this.v0.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.y0 = aVar;
                    this.s.onSubscribe(this);
                    if (this.f0) {
                        return;
                    }
                    this.w0.a(aVar);
                } catch (Throwable th) {
                    sdk.pendo.io.c6.b.b(th);
                    this.f0 = true;
                    bVar.dispose();
                    sdk.pendo.io.e6.c.a(th, this.s);
                }
            }
        }

        public void a(sdk.pendo.io.x5.o<? super U> oVar, U u) {
            this.s.onNext(u);
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f0;
        }
    }

    public b(sdk.pendo.io.x5.m<T> mVar, sdk.pendo.io.x5.m<B> mVar2, Callable<U> callable) {
        super(mVar);
        this.s = mVar2;
        this.A = callable;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(sdk.pendo.io.x5.o<? super U> oVar) {
        this.f.a(new C0178b(new sdk.pendo.io.s6.b(oVar), this.A, this.s));
    }
}
