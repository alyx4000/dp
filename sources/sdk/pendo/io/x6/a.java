package sdk.pendo.io.x6;

import sdk.pendo.io.q6.i;
import sdk.pendo.io.w5.b;
import sdk.pendo.io.w5.c;
import sdk.pendo.io.x5.e;

/* loaded from: classes4.dex */
public final class a<T> implements e<T>, c {
    c A;
    final b<? super T> f;
    boolean f0;
    final boolean s;
    sdk.pendo.io.q6.a<Object> t0;
    volatile boolean u0;

    public a(b<? super T> bVar) {
        this(bVar, false);
    }

    void a() {
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
        } while (!aVar.a((b) this.f));
    }

    @Override // sdk.pendo.io.w5.c
    public void cancel() {
        this.A.cancel();
    }

    @Override // sdk.pendo.io.w5.b
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

    @Override // sdk.pendo.io.w5.b
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

    @Override // sdk.pendo.io.w5.b
    public void onNext(T t) {
        if (this.u0) {
            return;
        }
        if (t == null) {
            this.A.cancel();
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
                a();
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

    public a(b<? super T> bVar, boolean z) {
        this.f = bVar;
        this.s = z;
    }

    @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
    public void a(c cVar) {
        if (sdk.pendo.io.p6.c.a(this.A, cVar)) {
            this.A = cVar;
            this.f.a(this);
        }
    }

    @Override // sdk.pendo.io.w5.c
    public void a(long j) {
        this.A.a(j);
    }
}
