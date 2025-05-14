package sdk.pendo.io.h6;

import sdk.pendo.io.q6.m;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public abstract class g<T, U, V> extends i implements o<T>, sdk.pendo.io.q6.j<U, V> {
    protected final sdk.pendo.io.g6.f<U> A;
    protected volatile boolean f0;
    protected final o<? super V> s;
    protected volatile boolean t0;
    protected Throwable u0;

    public g(o<? super V> oVar, sdk.pendo.io.g6.f<U> fVar) {
        this.s = oVar;
        this.A = fVar;
    }

    protected final void a(U u, boolean z, sdk.pendo.io.b6.b bVar) {
        o<? super V> oVar = this.s;
        sdk.pendo.io.g6.f<U> fVar = this.A;
        if (this.f.get() == 0 && this.f.compareAndSet(0, 1)) {
            a(oVar, u);
            if (a(-1) == 0) {
                return;
            }
        } else {
            fVar.offer(u);
            if (!e()) {
                return;
            }
        }
        m.a(fVar, oVar, z, bVar, this);
    }

    @Override // sdk.pendo.io.q6.j
    public abstract void a(o<? super V> oVar, U u);

    @Override // sdk.pendo.io.q6.j
    public final boolean b() {
        return this.t0;
    }

    @Override // sdk.pendo.io.q6.j
    public final boolean c() {
        return this.f0;
    }

    @Override // sdk.pendo.io.q6.j
    public final Throwable d() {
        return this.u0;
    }

    public final boolean e() {
        return this.f.getAndIncrement() == 0;
    }

    @Override // sdk.pendo.io.q6.j
    public final int a(int i) {
        return this.f.addAndGet(i);
    }
}
