package external.sdk.pendo.io.glide.load.engine;

/* loaded from: classes2.dex */
class m<Z> implements sdk.pendo.io.t.c<Z> {
    private final sdk.pendo.io.t.c<Z> A;
    private final boolean f;
    private final a f0;
    private final boolean s;
    private final sdk.pendo.io.q.f t0;
    private int u0;
    private boolean v0;

    interface a {
        void onResourceReleased(sdk.pendo.io.q.f fVar, m<?> mVar);
    }

    m(sdk.pendo.io.t.c<Z> cVar, boolean z, boolean z2, sdk.pendo.io.q.f fVar, a aVar) {
        this.A = (sdk.pendo.io.t.c) sdk.pendo.io.i0.j.a(cVar);
        this.f = z;
        this.s = z2;
        this.t0 = fVar;
        this.f0 = (a) sdk.pendo.io.i0.j.a(aVar);
    }

    synchronized void a() {
        if (this.v0) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.u0++;
    }

    sdk.pendo.io.t.c<Z> b() {
        return this.A;
    }

    boolean c() {
        return this.f;
    }

    void d() {
        boolean z;
        synchronized (this) {
            int i = this.u0;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.u0 = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.f0.onResourceReleased(this.t0, this);
        }
    }

    @Override // sdk.pendo.io.t.c
    public Z get() {
        return this.A.get();
    }

    @Override // sdk.pendo.io.t.c
    public Class<Z> getResourceClass() {
        return this.A.getResourceClass();
    }

    @Override // sdk.pendo.io.t.c
    public int getSize() {
        return this.A.getSize();
    }

    @Override // sdk.pendo.io.t.c
    public synchronized void recycle() {
        if (this.u0 > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.v0) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.v0 = true;
        if (this.s) {
            this.A.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f + ", listener=" + this.f0 + ", key=" + this.t0 + ", acquired=" + this.u0 + ", isRecycled=" + this.v0 + ", resource=" + this.A + '}';
    }
}
