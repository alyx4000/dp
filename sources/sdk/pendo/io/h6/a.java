package sdk.pendo.io.h6;

import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public abstract class a<T, R> implements o<T>, sdk.pendo.io.g6.b<R> {
    protected sdk.pendo.io.g6.b<T> A;
    protected final o<? super R> f;
    protected boolean f0;
    protected sdk.pendo.io.b6.b s;
    protected int t0;

    public a(o<? super R> oVar) {
        this.f = oVar;
    }

    protected final void a(Throwable th) {
        sdk.pendo.io.c6.b.b(th);
        this.s.dispose();
        onError(th);
    }

    protected void b() {
    }

    protected boolean c() {
        return true;
    }

    @Override // sdk.pendo.io.g6.g
    public void clear() {
        this.A.clear();
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        this.s.dispose();
    }

    @Override // sdk.pendo.io.g6.g
    public boolean isEmpty() {
        return this.A.isEmpty();
    }

    @Override // sdk.pendo.io.g6.g
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sdk.pendo.io.x5.o
    public void onComplete() {
        if (this.f0) {
            return;
        }
        this.f0 = true;
        this.f.onComplete();
    }

    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        if (this.f0) {
            sdk.pendo.io.t6.a.b(th);
        } else {
            this.f0 = true;
            this.f.onError(th);
        }
    }

    @Override // sdk.pendo.io.x5.o
    public final void onSubscribe(sdk.pendo.io.b6.b bVar) {
        if (sdk.pendo.io.e6.b.a(this.s, bVar)) {
            this.s = bVar;
            if (bVar instanceof sdk.pendo.io.g6.b) {
                this.A = (sdk.pendo.io.g6.b) bVar;
            }
            if (c()) {
                this.f.onSubscribe(this);
                b();
            }
        }
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this.s.a();
    }

    protected final int b(int i) {
        sdk.pendo.io.g6.b<T> bVar = this.A;
        if (bVar == null || (i & 4) != 0) {
            return 0;
        }
        int a2 = bVar.a(i);
        if (a2 != 0) {
            this.t0 = a2;
        }
        return a2;
    }
}
