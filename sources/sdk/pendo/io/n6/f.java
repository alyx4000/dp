package sdk.pendo.io.n6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class f extends sdk.pendo.io.x5.p {
    static final j e;
    static final j f;
    static final c i;
    static boolean j;
    static final a k;
    final ThreadFactory c;
    final AtomicReference<a> d;
    private static final TimeUnit h = TimeUnit.SECONDS;
    private static final long g = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    static final class a implements Runnable {
        final sdk.pendo.io.b6.a A;
        private final long f;
        private final ScheduledExecutorService f0;
        private final ConcurrentLinkedQueue<c> s;
        private final Future<?> t0;
        private final ThreadFactory u0;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledExecutorService scheduledExecutorService;
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f = nanos;
            this.s = new ConcurrentLinkedQueue<>();
            this.A = new sdk.pendo.io.b6.a();
            this.u0 = threadFactory;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, f.f);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledExecutorService = null;
                scheduledFuture = null;
            }
            this.f0 = scheduledExecutorService;
            this.t0 = scheduledFuture;
        }

        void a() {
            if (this.s.isEmpty()) {
                return;
            }
            long c = c();
            Iterator<c> it = this.s.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.c() > c) {
                    return;
                }
                if (this.s.remove(next)) {
                    this.A.a(next);
                }
            }
        }

        c b() {
            if (this.A.a()) {
                return f.i;
            }
            while (!this.s.isEmpty()) {
                c poll = this.s.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.u0);
            this.A.b(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d() {
            this.A.dispose();
            Future<?> future = this.t0;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f0;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        void a(c cVar) {
            cVar.a(c() + this.f);
            this.s.offer(cVar);
        }
    }

    static final class b extends p.c implements Runnable {
        private final c A;
        private final a s;
        final AtomicBoolean f0 = new AtomicBoolean();
        private final sdk.pendo.io.b6.a f = new sdk.pendo.io.b6.a();

        b(a aVar) {
            this.s = aVar;
            this.A = aVar.b();
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f0.get();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.f0.compareAndSet(false, true)) {
                this.f.dispose();
                if (f.j) {
                    this.A.a(this, 0L, TimeUnit.NANOSECONDS, (sdk.pendo.io.e6.a) null);
                } else {
                    this.s.a(this.A);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.s.a(this.A);
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            return this.f.a() ? sdk.pendo.io.e6.c.INSTANCE : this.A.a(runnable, j, timeUnit, this.f);
        }
    }

    static final class c extends h {
        private long A;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.A = 0L;
        }

        public void a(long j) {
            this.A = j;
        }

        public long c() {
            return this.A;
        }
    }

    static {
        c cVar = new c(new j("RxCachedThreadSchedulerShutdown"));
        i = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        j jVar = new j("RxCachedThreadScheduler", max);
        e = jVar;
        f = new j("RxCachedWorkerPoolEvictor", max);
        j = Boolean.getBoolean("rx2.io-scheduled-release");
        a aVar = new a(0L, null, jVar);
        k = aVar;
        aVar.d();
    }

    public f() {
        this(e);
    }

    @Override // sdk.pendo.io.x5.p
    public p.c a() {
        return new b(this.d.get());
    }

    public void b() {
        a aVar = new a(g, h, this.c);
        if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.d, k, aVar)) {
            return;
        }
        aVar.d();
    }

    public f(ThreadFactory threadFactory) {
        this.c = threadFactory;
        this.d = new AtomicReference<>(k);
        b();
    }
}
