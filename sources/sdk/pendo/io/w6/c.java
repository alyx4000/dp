package sdk.pendo.io.w6;

import sdk.pendo.io.q6.a;
import sdk.pendo.io.q6.i;
import sdk.pendo.io.x5.o;

/* loaded from: classes4.dex */
final class c<T> extends d<T> implements a.InterfaceC0228a<Object> {
    sdk.pendo.io.q6.a<Object> A;
    final d<T> f;
    volatile boolean f0;
    boolean s;

    c(d<T> dVar) {
        this.f = dVar;
    }

    @Override // sdk.pendo.io.x5.j
    protected void b(o<? super T> oVar) {
        this.f.a((o) oVar);
    }

    void n() {
        sdk.pendo.io.q6.a<Object> aVar;
        while (true) {
            synchronized (this) {
                aVar = this.A;
                if (aVar == null) {
                    this.s = false;
                    return;
                }
                this.A = null;
            }
            aVar.a((a.InterfaceC0228a<? super Object>) this);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onComplete() {
        if (this.f0) {
            return;
        }
        synchronized (this) {
            if (this.f0) {
                return;
            }
            this.f0 = true;
            if (!this.s) {
                this.s = true;
                this.f.onComplete();
                return;
            }
            sdk.pendo.io.q6.a<Object> aVar = this.A;
            if (aVar == null) {
                aVar = new sdk.pendo.io.q6.a<>(4);
                this.A = aVar;
            }
            aVar.a((sdk.pendo.io.q6.a<Object>) i.a());
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        if (this.f0) {
            sdk.pendo.io.t6.a.b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f0) {
                this.f0 = true;
                if (this.s) {
                    sdk.pendo.io.q6.a<Object> aVar = this.A;
                    if (aVar == null) {
                        aVar = new sdk.pendo.io.q6.a<>(4);
                        this.A = aVar;
                    }
                    aVar.b(i.a(th));
                    return;
                }
                this.s = true;
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
        if (this.f0) {
            return;
        }
        synchronized (this) {
            if (this.f0) {
                return;
            }
            if (!this.s) {
                this.s = true;
                this.f.onNext(t);
                n();
            } else {
                sdk.pendo.io.q6.a<Object> aVar = this.A;
                if (aVar == null) {
                    aVar = new sdk.pendo.io.q6.a<>(4);
                    this.A = aVar;
                }
                aVar.a((sdk.pendo.io.q6.a<Object>) i.d(t));
            }
        }
    }

    @Override // sdk.pendo.io.x5.o
    public void onSubscribe(sdk.pendo.io.b6.b bVar) {
        boolean z = true;
        if (!this.f0) {
            synchronized (this) {
                if (!this.f0) {
                    if (this.s) {
                        sdk.pendo.io.q6.a<Object> aVar = this.A;
                        if (aVar == null) {
                            aVar = new sdk.pendo.io.q6.a<>(4);
                            this.A = aVar;
                        }
                        aVar.a((sdk.pendo.io.q6.a<Object>) i.a(bVar));
                        return;
                    }
                    this.s = true;
                    z = false;
                }
            }
        }
        if (z) {
            bVar.dispose();
        } else {
            this.f.onSubscribe(bVar);
            n();
        }
    }

    @Override // sdk.pendo.io.q6.a.InterfaceC0228a, sdk.pendo.io.d6.j
    public boolean test(Object obj) {
        return i.b(obj, this.f);
    }
}
