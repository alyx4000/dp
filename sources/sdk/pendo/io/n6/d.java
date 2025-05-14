package sdk.pendo.io.n6;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class d extends sdk.pendo.io.x5.p {
    static final sdk.pendo.io.x5.p e = sdk.pendo.io.v6.a.c();
    final boolean c;
    final Executor d;

    final class a implements Runnable {
        private final b f;

        a(b bVar) {
            this.f = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = this.f;
            bVar.s.a(d.this.a(bVar));
        }
    }

    static final class b extends AtomicReference<Runnable> implements Runnable, sdk.pendo.io.b6.b {
        final sdk.pendo.io.e6.f f;
        final sdk.pendo.io.e6.f s;

        b(Runnable runnable) {
            super(runnable);
            this.f = new sdk.pendo.io.e6.f();
            this.s = new sdk.pendo.io.e6.f();
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return get() == null;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (getAndSet(null) != null) {
                this.f.dispose();
                this.s.dispose();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet(null);
                    sdk.pendo.io.e6.f fVar = this.f;
                    sdk.pendo.io.e6.b bVar = sdk.pendo.io.e6.b.DISPOSED;
                    fVar.lazySet(bVar);
                    this.s.lazySet(bVar);
                } catch (Throwable th) {
                    lazySet(null);
                    this.f.lazySet(sdk.pendo.io.e6.b.DISPOSED);
                    this.s.lazySet(sdk.pendo.io.e6.b.DISPOSED);
                    throw th;
                }
            }
        }
    }

    public static final class c extends p.c implements Runnable {
        final boolean f;
        volatile boolean f0;
        final Executor s;
        final AtomicInteger t0 = new AtomicInteger();
        final sdk.pendo.io.b6.a u0 = new sdk.pendo.io.b6.a();
        final sdk.pendo.io.m6.a<Runnable> A = new sdk.pendo.io.m6.a<>();

        static final class a extends AtomicBoolean implements Runnable, sdk.pendo.io.b6.b {
            final Runnable f;

            a(Runnable runnable) {
                this.f = runnable;
            }

            @Override // sdk.pendo.io.b6.b
            public boolean a() {
                return get();
            }

            @Override // sdk.pendo.io.b6.b
            public void dispose() {
                lazySet(true);
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get()) {
                    return;
                }
                try {
                    this.f.run();
                } finally {
                    lazySet(true);
                }
            }
        }

        static final class b extends AtomicInteger implements Runnable, sdk.pendo.io.b6.b {
            volatile Thread A;
            final Runnable f;
            final sdk.pendo.io.e6.a s;

            b(Runnable runnable, sdk.pendo.io.e6.a aVar) {
                this.f = runnable;
                this.s = aVar;
            }

            @Override // sdk.pendo.io.b6.b
            public boolean a() {
                return get() >= 2;
            }

            void b() {
                sdk.pendo.io.e6.a aVar = this.s;
                if (aVar != null) {
                    aVar.c(this);
                }
            }

            @Override // sdk.pendo.io.b6.b
            public void dispose() {
                while (true) {
                    int i = get();
                    if (i >= 2) {
                        return;
                    }
                    if (i == 0) {
                        if (compareAndSet(0, 4)) {
                            break;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread = this.A;
                        if (thread != null) {
                            thread.interrupt();
                            this.A = null;
                        }
                        set(4);
                    }
                }
                b();
            }

            @Override // java.lang.Runnable
            public void run() {
                if (get() == 0) {
                    this.A = Thread.currentThread();
                    if (!compareAndSet(0, 1)) {
                        this.A = null;
                        return;
                    }
                    try {
                        this.f.run();
                        this.A = null;
                        if (compareAndSet(1, 2)) {
                            b();
                            return;
                        }
                        while (get() == 3) {
                            Thread.yield();
                        }
                        Thread.interrupted();
                    } catch (Throwable th) {
                        this.A = null;
                        if (compareAndSet(1, 2)) {
                            b();
                        } else {
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        }
                        throw th;
                    }
                }
            }
        }

        /* renamed from: sdk.pendo.io.n6.d$c$c, reason: collision with other inner class name */
        final class RunnableC0207c implements Runnable {
            private final sdk.pendo.io.e6.f f;
            private final Runnable s;

            RunnableC0207c(sdk.pendo.io.e6.f fVar, Runnable runnable) {
                this.f = fVar;
                this.s = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.a(c.this.a(this.s));
            }
        }

        public c(Executor executor, boolean z) {
            this.s = executor;
            this.f = z;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f0;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.f0) {
                return;
            }
            this.f0 = true;
            this.u0.dispose();
            if (this.t0.getAndIncrement() == 0) {
                this.A.clear();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            sdk.pendo.io.m6.a<Runnable> aVar = this.A;
            int i = 1;
            while (!this.f0) {
                do {
                    Runnable poll = aVar.poll();
                    if (poll != null) {
                        poll.run();
                    } else if (this.f0) {
                        aVar.clear();
                        return;
                    } else {
                        i = this.t0.addAndGet(-i);
                        if (i == 0) {
                            return;
                        }
                    }
                } while (!this.f0);
                aVar.clear();
                return;
            }
            aVar.clear();
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable) {
            sdk.pendo.io.b6.b aVar;
            if (this.f0) {
                return sdk.pendo.io.e6.c.INSTANCE;
            }
            Runnable a2 = sdk.pendo.io.t6.a.a(runnable);
            if (this.f) {
                aVar = new b(a2, this.u0);
                this.u0.b(aVar);
            } else {
                aVar = new a(a2);
            }
            this.A.offer(aVar);
            if (this.t0.getAndIncrement() == 0) {
                try {
                    this.s.execute(this);
                } catch (RejectedExecutionException e) {
                    this.f0 = true;
                    this.A.clear();
                    sdk.pendo.io.t6.a.b(e);
                    return sdk.pendo.io.e6.c.INSTANCE;
                }
            }
            return aVar;
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(runnable);
            }
            if (this.f0) {
                return sdk.pendo.io.e6.c.INSTANCE;
            }
            sdk.pendo.io.e6.f fVar = new sdk.pendo.io.e6.f();
            sdk.pendo.io.e6.f fVar2 = new sdk.pendo.io.e6.f(fVar);
            m mVar = new m(new RunnableC0207c(fVar2, sdk.pendo.io.t6.a.a(runnable)), this.u0);
            this.u0.b(mVar);
            Executor executor = this.s;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    mVar.a(((ScheduledExecutorService) executor).schedule((Callable) mVar, j, timeUnit));
                } catch (RejectedExecutionException e) {
                    this.f0 = true;
                    sdk.pendo.io.t6.a.b(e);
                    return sdk.pendo.io.e6.c.INSTANCE;
                }
            } else {
                mVar.a(new sdk.pendo.io.n6.c(d.e.a(mVar, j, timeUnit)));
            }
            fVar.a(mVar);
            return fVar2;
        }
    }

    public d(Executor executor, boolean z) {
        this.d = executor;
        this.c = z;
    }

    @Override // sdk.pendo.io.x5.p
    public p.c a() {
        return new c(this.d, this.c);
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable) {
        Runnable a2 = sdk.pendo.io.t6.a.a(runnable);
        try {
            if (this.d instanceof ExecutorService) {
                l lVar = new l(a2);
                lVar.a(((ExecutorService) this.d).submit(lVar));
                return lVar;
            }
            if (this.c) {
                c.b bVar = new c.b(a2, null);
                this.d.execute(bVar);
                return bVar;
            }
            c.a aVar = new c.a(a2);
            this.d.execute(aVar);
            return aVar;
        } catch (RejectedExecutionException e2) {
            sdk.pendo.io.t6.a.b(e2);
            return sdk.pendo.io.e6.c.INSTANCE;
        }
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable a2 = sdk.pendo.io.t6.a.a(runnable);
        if (!(this.d instanceof ScheduledExecutorService)) {
            b bVar = new b(a2);
            bVar.f.a(e.a(new a(bVar), j, timeUnit));
            return bVar;
        }
        try {
            l lVar = new l(a2);
            lVar.a(((ScheduledExecutorService) this.d).schedule(lVar, j, timeUnit));
            return lVar;
        } catch (RejectedExecutionException e2) {
            sdk.pendo.io.t6.a.b(e2);
            return sdk.pendo.io.e6.c.INSTANCE;
        }
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.d instanceof ScheduledExecutorService)) {
            return super.a(runnable, j, j2, timeUnit);
        }
        try {
            k kVar = new k(sdk.pendo.io.t6.a.a(runnable));
            kVar.a(((ScheduledExecutorService) this.d).scheduleAtFixedRate(kVar, j, j2, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e2) {
            sdk.pendo.io.t6.a.b(e2);
            return sdk.pendo.io.e6.c.INSTANCE;
        }
    }
}
