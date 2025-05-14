package external.sdk.pendo.io.glide.load.engine;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.engine.g;
import external.sdk.pendo.io.glide.load.engine.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.j0.a;

/* loaded from: classes2.dex */
class i<R> implements g.b<R>, a.f {
    private static final c O0 = new c();
    private final m.a A;
    private sdk.pendo.io.q.f A0;
    private boolean B0;
    private boolean C0;
    private boolean D0;
    private boolean E0;
    private sdk.pendo.io.t.c<?> F0;
    sdk.pendo.io.q.a G0;
    private boolean H0;
    n I0;
    private boolean J0;
    m<?> K0;
    private g<R> L0;
    private volatile boolean M0;
    private boolean N0;
    final e f;
    private final Pools.Pool<i<?>> f0;
    private final sdk.pendo.io.j0.c s;
    private final c t0;
    private final j u0;
    private final sdk.pendo.io.w.a v0;
    private final sdk.pendo.io.w.a w0;
    private final sdk.pendo.io.w.a x0;
    private final sdk.pendo.io.w.a y0;
    private final AtomicInteger z0;

    private class a implements Runnable {
        private final sdk.pendo.io.e0.c f;

        a(sdk.pendo.io.e0.c cVar) {
            this.f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f.getLock()) {
                synchronized (i.this) {
                    if (i.this.f.a(this.f)) {
                        i.this.a(this.f);
                    }
                    i.this.c();
                }
            }
        }
    }

    private class b implements Runnable {
        private final sdk.pendo.io.e0.c f;

        b(sdk.pendo.io.e0.c cVar) {
            this.f = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f.getLock()) {
                synchronized (i.this) {
                    if (i.this.f.a(this.f)) {
                        i.this.K0.a();
                        i.this.b(this.f);
                        i.this.c(this.f);
                    }
                    i.this.c();
                }
            }
        }
    }

    static class c {
        c() {
        }

        public <R> m<R> a(sdk.pendo.io.t.c<R> cVar, boolean z, sdk.pendo.io.q.f fVar, m.a aVar) {
            return new m<>(cVar, z, true, fVar, aVar);
        }
    }

    static final class d {

        /* renamed from: a, reason: collision with root package name */
        final sdk.pendo.io.e0.c f673a;
        final Executor b;

        d(sdk.pendo.io.e0.c cVar, Executor executor) {
            this.f673a = cVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f673a.equals(((d) obj).f673a);
            }
            return false;
        }

        public int hashCode() {
            return this.f673a.hashCode();
        }
    }

    static final class e implements Iterable<d> {
        private final List<d> f;

        e() {
            this(new ArrayList(2));
        }

        private static d b(sdk.pendo.io.e0.c cVar) {
            return new d(cVar, sdk.pendo.io.i0.e.a());
        }

        void a(sdk.pendo.io.e0.c cVar, Executor executor) {
            this.f.add(new d(cVar, executor));
        }

        void c(sdk.pendo.io.e0.c cVar) {
            this.f.remove(b(cVar));
        }

        void clear() {
            this.f.clear();
        }

        boolean isEmpty() {
            return this.f.isEmpty();
        }

        @Override // java.lang.Iterable
        public Iterator<d> iterator() {
            return this.f.iterator();
        }

        int size() {
            return this.f.size();
        }

        e(List<d> list) {
            this.f = list;
        }

        boolean a(sdk.pendo.io.e0.c cVar) {
            return this.f.contains(b(cVar));
        }

        e a() {
            return new e(new ArrayList(this.f));
        }
    }

    i(sdk.pendo.io.w.a aVar, sdk.pendo.io.w.a aVar2, sdk.pendo.io.w.a aVar3, sdk.pendo.io.w.a aVar4, j jVar, m.a aVar5, Pools.Pool<i<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, jVar, aVar5, pool, O0);
    }

    private sdk.pendo.io.w.a d() {
        return this.C0 ? this.x0 : this.D0 ? this.y0 : this.w0;
    }

    private boolean e() {
        return this.J0 || this.H0 || this.M0;
    }

    private synchronized void i() {
        if (this.A0 == null) {
            throw new IllegalArgumentException();
        }
        this.f.clear();
        this.A0 = null;
        this.K0 = null;
        this.F0 = null;
        this.J0 = false;
        this.M0 = false;
        this.H0 = false;
        this.N0 = false;
        this.L0.a(false);
        this.L0 = null;
        this.I0 = null;
        this.G0 = null;
        this.f0.release(this);
    }

    synchronized void a(sdk.pendo.io.e0.c cVar, Executor executor) {
        Runnable aVar;
        this.s.b();
        this.f.a(cVar, executor);
        if (this.H0) {
            a(1);
            aVar = new b(cVar);
        } else if (this.J0) {
            a(1);
            aVar = new a(cVar);
        } else {
            sdk.pendo.io.i0.j.a(!this.M0, "Cannot add callbacks to a cancelled EngineJob");
        }
        executor.execute(aVar);
    }

    void b(sdk.pendo.io.e0.c cVar) {
        try {
            cVar.onResourceReady(this.K0, this.G0, this.N0);
        } catch (Throwable th) {
            throw new external.sdk.pendo.io.glide.load.engine.a(th);
        }
    }

    void c() {
        m<?> mVar;
        synchronized (this) {
            this.s.b();
            sdk.pendo.io.i0.j.a(e(), "Not yet complete!");
            int decrementAndGet = this.z0.decrementAndGet();
            sdk.pendo.io.i0.j.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                mVar = this.K0;
                i();
            } else {
                mVar = null;
            }
        }
        if (mVar != null) {
            mVar.d();
        }
    }

    void f() {
        synchronized (this) {
            this.s.b();
            if (this.M0) {
                i();
                return;
            }
            if (this.f.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.J0) {
                throw new IllegalStateException("Already failed once");
            }
            this.J0 = true;
            sdk.pendo.io.q.f fVar = this.A0;
            e a2 = this.f.a();
            a(a2.size() + 1);
            this.u0.onEngineJobComplete(this, fVar, null);
            Iterator<d> it = a2.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.b.execute(new a(next.f673a));
            }
            c();
        }
    }

    void g() {
        synchronized (this) {
            this.s.b();
            if (this.M0) {
                this.F0.recycle();
                i();
                return;
            }
            if (this.f.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.H0) {
                throw new IllegalStateException("Already have resource");
            }
            this.K0 = this.t0.a(this.F0, this.B0, this.A0, this.A);
            this.H0 = true;
            e a2 = this.f.a();
            a(a2.size() + 1);
            this.u0.onEngineJobComplete(this, this.A0, this.K0);
            Iterator<d> it = a2.iterator();
            while (it.hasNext()) {
                d next = it.next();
                next.b.execute(new b(next.f673a));
            }
            c();
        }
    }

    boolean h() {
        return this.E0;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.g.b
    public void onLoadFailed(n nVar) {
        synchronized (this) {
            this.I0 = nVar;
        }
        f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // external.sdk.pendo.io.glide.load.engine.g.b
    public void onResourceReady(sdk.pendo.io.t.c<R> cVar, sdk.pendo.io.q.a aVar, boolean z) {
        synchronized (this) {
            this.F0 = cVar;
            this.G0 = aVar;
            this.N0 = z;
        }
        g();
    }

    i(sdk.pendo.io.w.a aVar, sdk.pendo.io.w.a aVar2, sdk.pendo.io.w.a aVar3, sdk.pendo.io.w.a aVar4, j jVar, m.a aVar5, Pools.Pool<i<?>> pool, c cVar) {
        this.f = new e();
        this.s = sdk.pendo.io.j0.c.a();
        this.z0 = new AtomicInteger();
        this.v0 = aVar;
        this.w0 = aVar2;
        this.x0 = aVar3;
        this.y0 = aVar4;
        this.u0 = jVar;
        this.A = aVar5;
        this.f0 = pool;
        this.t0 = cVar;
    }

    void a(sdk.pendo.io.e0.c cVar) {
        try {
            cVar.onLoadFailed(this.I0);
        } catch (Throwable th) {
            throw new external.sdk.pendo.io.glide.load.engine.a(th);
        }
    }

    @Override // sdk.pendo.io.j0.a.f
    public sdk.pendo.io.j0.c b() {
        return this.s;
    }

    synchronized void c(sdk.pendo.io.e0.c cVar) {
        boolean z;
        this.s.b();
        this.f.c(cVar);
        if (this.f.isEmpty()) {
            a();
            if (!this.H0 && !this.J0) {
                z = false;
                if (z && this.z0.get() == 0) {
                    i();
                }
            }
            z = true;
            if (z) {
                i();
            }
        }
    }

    void a() {
        if (e()) {
            return;
        }
        this.M0 = true;
        this.L0.c();
        this.u0.onEngineJobCancelled(this, this.A0);
    }

    public synchronized void b(g<R> gVar) {
        this.L0 = gVar;
        (gVar.n() ? this.v0 : d()).execute(gVar);
    }

    synchronized void a(int i) {
        m<?> mVar;
        sdk.pendo.io.i0.j.a(e(), "Not yet complete!");
        if (this.z0.getAndAdd(i) == 0 && (mVar = this.K0) != null) {
            mVar.a();
        }
    }

    synchronized i<R> a(sdk.pendo.io.q.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.A0 = fVar;
        this.B0 = z;
        this.C0 = z2;
        this.D0 = z3;
        this.E0 = z4;
        return this;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.g.b
    public void a(g<?> gVar) {
        d().execute(gVar);
    }
}
