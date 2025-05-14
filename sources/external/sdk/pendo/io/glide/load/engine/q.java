package external.sdk.pendo.io.glide.load.engine;

import androidx.core.util.Pools;
import sdk.pendo.io.j0.a;

/* loaded from: classes2.dex */
final class q<Z> implements sdk.pendo.io.t.c<Z>, a.f {
    private static final Pools.Pool<q<?>> t0 = sdk.pendo.io.j0.a.a(20, new a());
    private boolean A;
    private final sdk.pendo.io.j0.c f = sdk.pendo.io.j0.c.a();
    private boolean f0;
    private sdk.pendo.io.t.c<Z> s;

    class a implements a.d<q<?>> {
        a() {
        }

        @Override // sdk.pendo.io.j0.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q<?> a() {
            return new q<>();
        }
    }

    q() {
    }

    private void a(sdk.pendo.io.t.c<Z> cVar) {
        this.f0 = false;
        this.A = true;
        this.s = cVar;
    }

    @Override // sdk.pendo.io.j0.a.f
    public sdk.pendo.io.j0.c b() {
        return this.f;
    }

    synchronized void c() {
        this.f.b();
        if (!this.A) {
            throw new IllegalStateException("Already unlocked");
        }
        this.A = false;
        if (this.f0) {
            recycle();
        }
    }

    @Override // sdk.pendo.io.t.c
    public Z get() {
        return this.s.get();
    }

    @Override // sdk.pendo.io.t.c
    public Class<Z> getResourceClass() {
        return this.s.getResourceClass();
    }

    @Override // sdk.pendo.io.t.c
    public int getSize() {
        return this.s.getSize();
    }

    @Override // sdk.pendo.io.t.c
    public synchronized void recycle() {
        this.f.b();
        this.f0 = true;
        if (!this.A) {
            this.s.recycle();
            a();
        }
    }

    private void a() {
        this.s = null;
        t0.release(this);
    }

    static <Z> q<Z> b(sdk.pendo.io.t.c<Z> cVar) {
        q<Z> qVar = (q) sdk.pendo.io.i0.j.a(t0.acquire());
        qVar.a(cVar);
        return qVar;
    }
}
