package sdk.pendo.io.o6;

/* loaded from: classes6.dex */
public abstract class a<T, R> implements sdk.pendo.io.g6.a<T>, sdk.pendo.io.g6.d<R> {
    protected sdk.pendo.io.g6.d<T> A;
    protected final sdk.pendo.io.g6.a<? super R> f;
    protected boolean f0;
    protected sdk.pendo.io.w5.c s;
    protected int t0;

    public a(sdk.pendo.io.g6.a<? super R> aVar) {
        this.f = aVar;
    }

    protected void a() {
    }

    protected boolean b() {
        return true;
    }

    @Override // sdk.pendo.io.w5.c
    public void cancel() {
        this.s.cancel();
    }

    @Override // sdk.pendo.io.g6.g
    public void clear() {
        this.A.clear();
    }

    @Override // sdk.pendo.io.g6.g
    public boolean isEmpty() {
        return this.A.isEmpty();
    }

    @Override // sdk.pendo.io.g6.g
    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // sdk.pendo.io.w5.b
    public void onComplete() {
        if (this.f0) {
            return;
        }
        this.f0 = true;
        this.f.onComplete();
    }

    @Override // sdk.pendo.io.w5.b
    public void onError(Throwable th) {
        if (this.f0) {
            sdk.pendo.io.t6.a.b(th);
        } else {
            this.f0 = true;
            this.f.onError(th);
        }
    }

    protected final void a(Throwable th) {
        sdk.pendo.io.c6.b.b(th);
        this.s.cancel();
        onError(th);
    }

    @Override // sdk.pendo.io.x5.e, sdk.pendo.io.w5.b
    public final void a(sdk.pendo.io.w5.c cVar) {
        if (sdk.pendo.io.p6.c.a(this.s, cVar)) {
            this.s = cVar;
            if (cVar instanceof sdk.pendo.io.g6.d) {
                this.A = (sdk.pendo.io.g6.d) cVar;
            }
            if (b()) {
                this.f.a((sdk.pendo.io.w5.c) this);
                a();
            }
        }
    }

    @Override // sdk.pendo.io.w5.c
    public void a(long j) {
        this.s.a(j);
    }
}
