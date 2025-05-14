package sdk.pendo.io.s6;

import sdk.pendo.io.q6.i;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public final class b<T> implements o<T>, sdk.pendo.io.b6.b {
    sdk.pendo.io.b6.b A;
    final o<? super T> f;
    boolean f0;
    final boolean s;
    sdk.pendo.io.q6.a<Object> t0;
    volatile boolean u0;

    public b(o<? super T> oVar) {
        this(oVar, false);
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this.A.a();
    }

    void b() {
        sdk.pendo.io.q6.a<Object> aVar;
        do {
            synchronized (this) {
                aVar = this.t0;
                if (aVar == null) {
                    this.f0 = false;
                    return;
                }
                this.t0 = null;
            }
        } while (!aVar.a((o) this.f));
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        this.A.dispose();
    }

    @Override // sdk.pendo.io.x5.o
    public void onComplete() {
        if (this.u0) {
            return;
        }
        synchronized (this) {
            if (this.u0) {
                return;
            }
            if (!this.f0) {
                this.u0 = true;
                this.f0 = true;
                this.f.onComplete();
            } else {
                sdk.pendo.io.q6.a<Object> aVar = this.t0;
                if (aVar == null) {
                    aVar = new sdk.pendo.io.q6.a<>(4);
                    this.t0 = aVar;
                }
                aVar.a((sdk.pendo.io.q6.a<Object>) i.a());
            }
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        if (this.u0) {
            sdk.pendo.io.t6.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.u0) {
                if (this.f0) {
                    this.u0 = true;
                    sdk.pendo.io.q6.a<Object> aVar = this.t0;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.q6.a<>(4);
                        this.t0 = aVar;
                    }
                    Object a2 = i.a(th);
                    if (this.s) {
                        aVar.a((sdk.pendo.io.q6.a<Object>) a2);
                    } else {
                        aVar.b(a2);
                    }
                    return;
                }
                this.u0 = true;
                this.f0 = true;
                z = false;
            }
            if (z) {
                sdk.pendo.io.t6.a.b(th);
            } else {
                this.f.onError(th);
            }
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onNext(T t) {
        if (this.u0) {
            return;
        }
        if (t == null) {
            this.A.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.u0) {
                return;
            }
            if (!this.f0) {
                this.f0 = true;
                this.f.onNext(t);
                b();
            } else {
                sdk.pendo.io.q6.a<Object> aVar = this.t0;
                if (aVar == null) {
                    aVar = new sdk.pendo.io.q6.a<>(4);
                    this.t0 = aVar;
                }
                aVar.a((sdk.pendo.io.q6.a<Object>) i.d(t));
            }
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        if (sdk.pendo.io.e6.b.a(this.A, bVar)) {
            this.A = bVar;
            this.f.onSubscribe(this);
        }
    }

    public b(o<? super T> oVar, boolean z) {
        this.f = oVar;
        this.s = z;
    }
}
