package sdk.pendo.io.n6;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class o extends sdk.pendo.io.x5.p {
    static final j e;
    static final ScheduledExecutorService f;
    final ThreadFactory c;
    final AtomicReference<ScheduledExecutorService> d;

    static final class a extends p.c {
        volatile boolean A;
        final ScheduledExecutorService f;
        final sdk.pendo.io.b6.a s = new sdk.pendo.io.b6.a();

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f = scheduledExecutorService;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.A;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.A) {
                return;
            }
            this.A = true;
            this.s.dispose();
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.A) {
                return sdk.pendo.io.e6.c.INSTANCE;
            }
            m mVar = new m(sdk.pendo.io.t6.a.a(runnable), this.s);
            this.s.b(mVar);
            try {
                mVar.a(j <= 0 ? this.f.submit((Callable) mVar) : this.f.schedule((Callable) mVar, j, timeUnit));
                return mVar;
            } catch (RejectedExecutionException e) {
                dispose();
                sdk.pendo.io.t6.a.b(e);
                return sdk.pendo.io.e6.c.INSTANCE;
            }
        }
    }

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        e = new j("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.single-priority", 5).intValue())), true);
    }

    public o() {
        this(e);
    }

    static ScheduledExecutorService a(ThreadFactory threadFactory) {
        return n.a(threadFactory);
    }

    public o(ThreadFactory threadFactory) {
        AtomicReference<ScheduledExecutorService> atomicReference = new AtomicReference<>();
        this.d = atomicReference;
        this.c = threadFactory;
        atomicReference.lazySet(a(threadFactory));
    }

    @Override // sdk.pendo.io.x5.p
    public p.c a() {
        return new a(this.d.get());
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        l lVar = new l(sdk.pendo.io.t6.a.a(runnable));
        try {
            lVar.a(j <= 0 ? this.d.get().submit(lVar) : this.d.get().schedule(lVar, j, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e2) {
            sdk.pendo.io.t6.a.b(e2);
            return sdk.pendo.io.e6.c.INSTANCE;
        }
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable a2 = sdk.pendo.io.t6.a.a(runnable);
        try {
            if (j2 > 0) {
                k kVar = new k(a2);
                kVar.a(this.d.get().scheduleAtFixedRate(kVar, j, j2, timeUnit));
                return kVar;
            }
            ScheduledExecutorService scheduledExecutorService = this.d.get();
            e eVar = new e(a2, scheduledExecutorService);
            eVar.a(j <= 0 ? scheduledExecutorService.submit(eVar) : scheduledExecutorService.schedule(eVar, j, timeUnit));
            return eVar;
        } catch (RejectedExecutionException e2) {
            sdk.pendo.io.t6.a.b(e2);
            return sdk.pendo.io.e6.c.INSTANCE;
        }
    }
}
