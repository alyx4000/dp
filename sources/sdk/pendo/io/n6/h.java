package sdk.pendo.io.n6;

import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public class h extends p.c {
    private final ScheduledExecutorService f;
    volatile boolean s;

    public h(ThreadFactory threadFactory) {
        this.f = n.a(threadFactory);
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this.s;
    }

    public sdk.pendo.io.b6.b b(Runnable runnable, long j, TimeUnit timeUnit) {
        l lVar = new l(sdk.pendo.io.t6.a.a(runnable));
        try {
            lVar.a(j <= 0 ? this.f.submit(lVar) : this.f.schedule(lVar, j, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e) {
            sdk.pendo.io.t6.a.b(e);
            return sdk.pendo.io.e6.c.INSTANCE;
        }
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        if (this.s) {
            return;
        }
        this.s = true;
        this.f.shutdownNow();
    }

    @Override // sdk.pendo.io.x5.p.c
    public sdk.pendo.io.b6.b a(Runnable runnable) {
        return a(runnable, 0L, null);
    }

    public sdk.pendo.io.b6.b b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Runnable a2 = sdk.pendo.io.t6.a.a(runnable);
        try {
            if (j2 <= 0) {
                e eVar = new e(a2, this.f);
                eVar.a(j <= 0 ? this.f.submit(eVar) : this.f.schedule(eVar, j, timeUnit));
                return eVar;
            }
            k kVar = new k(a2);
            kVar.a(this.f.scheduleAtFixedRate(kVar, j, j2, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e) {
            sdk.pendo.io.t6.a.b(e);
            return sdk.pendo.io.e6.c.INSTANCE;
        }
    }

    @Override // sdk.pendo.io.x5.p.c
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.s ? sdk.pendo.io.e6.c.INSTANCE : a(runnable, j, timeUnit, (sdk.pendo.io.e6.a) null);
    }

    public void b() {
        if (this.s) {
            return;
        }
        this.s = true;
        this.f.shutdown();
    }

    public m a(Runnable runnable, long j, TimeUnit timeUnit, sdk.pendo.io.e6.a aVar) {
        m mVar = new m(sdk.pendo.io.t6.a.a(runnable), aVar);
        if (aVar != null && !aVar.b(mVar)) {
            return mVar;
        }
        try {
            mVar.a(j <= 0 ? this.f.submit((Callable) mVar) : this.f.schedule((Callable) mVar, j, timeUnit));
        } catch (RejectedExecutionException e) {
            if (aVar != null) {
                aVar.a(mVar);
            }
            sdk.pendo.io.t6.a.b(e);
        }
        return mVar;
    }
}
