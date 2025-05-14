package sdk.pendo.io.n6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class b extends sdk.pendo.io.x5.p {
    static final C0206b e;
    static final j f;
    static final int g = a(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());
    static final c h;
    final ThreadFactory c;
    final AtomicReference<C0206b> d;

    static final class a extends p.c {
        private final sdk.pendo.io.e6.d A;
        private final sdk.pendo.io.e6.d f;
        private final c f0;
        private final sdk.pendo.io.b6.a s;
        volatile boolean t0;

        a(c cVar) {
            this.f0 = cVar;
            sdk.pendo.io.e6.d dVar = new sdk.pendo.io.e6.d();
            this.f = dVar;
            sdk.pendo.io.b6.a aVar = new sdk.pendo.io.b6.a();
            this.s = aVar;
            sdk.pendo.io.e6.d dVar2 = new sdk.pendo.io.e6.d();
            this.A = dVar2;
            dVar2.b(dVar);
            dVar2.b(aVar);
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.t0;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.t0) {
                return;
            }
            this.t0 = true;
            this.A.dispose();
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable) {
            return this.t0 ? sdk.pendo.io.e6.c.INSTANCE : this.f0.a(runnable, 0L, TimeUnit.MILLISECONDS, this.f);
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.t0 ? sdk.pendo.io.e6.c.INSTANCE : this.f0.a(runnable, j, timeUnit, this.s);
        }
    }

    /* renamed from: sdk.pendo.io.n6.b$b, reason: collision with other inner class name */
    static final class C0206b {

        /* renamed from: a, reason: collision with root package name */
        final int f1421a;
        final c[] b;
        long c;

        C0206b(int i, ThreadFactory threadFactory) {
            this.f1421a = i;
            this.b = new c[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.b[i2] = new c(threadFactory);
            }
        }

        public c a() {
            int i = this.f1421a;
            if (i == 0) {
                return b.h;
            }
            c[] cVarArr = this.b;
            long j = this.c;
            this.c = 1 + j;
            return cVarArr[(int) (j % i)];
        }

        public void b() {
            for (c cVar : this.b) {
                cVar.dispose();
            }
        }
    }

    static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new j("RxComputationShutdown"));
        h = cVar;
        cVar.dispose();
        j jVar = new j("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f = jVar;
        C0206b c0206b = new C0206b(0, jVar);
        e = c0206b;
        c0206b.b();
    }

    public b() {
        this(f);
    }

    static int a(int i, int i2) {
        return (i2 <= 0 || i2 > i) ? i : i2;
    }

    public void b() {
        C0206b c0206b = new C0206b(g, this.c);
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.d, e, c0206b)) {
            return;
        }
        c0206b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.c = threadFactory;
        this.d = new AtomicReference<>(e);
        b();
    }

    @Override // sdk.pendo.io.x5.p
    public p.c a() {
        return new a(this.d.get().a());
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.d.get().a().b(runnable, j, timeUnit);
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.d.get().a().b(runnable, j, j2, timeUnit);
    }
}
