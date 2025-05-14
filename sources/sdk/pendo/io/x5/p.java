package sdk.pendo.io.x5;

import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    static boolean f1749a = Boolean.getBoolean("rx2.scheduler.use-nanotime");
    static final long b = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class a implements sdk.pendo.io.b6.b, Runnable {
        Thread A;
        final Runnable f;
        final c s;

        a(Runnable runnable, c cVar) {
            this.f = runnable;
            this.s = cVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.s.a();
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            if (this.A == Thread.currentThread()) {
                c cVar = this.s;
                if (cVar instanceof sdk.pendo.io.n6.h) {
                    ((sdk.pendo.io.n6.h) cVar).b();
                    return;
                }
            }
            this.s.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.A = Thread.currentThread();
            try {
                this.f.run();
            } finally {
                dispose();
                this.A = null;
            }
        }
    }

    static final class b implements sdk.pendo.io.b6.b, Runnable {
        volatile boolean A;
        final Runnable f;
        final c s;

        b(Runnable runnable, c cVar) {
            this.f = runnable;
            this.s = cVar;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.A;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.A = true;
            this.s.dispose();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.A) {
                return;
            }
            try {
                this.f.run();
            } catch (Throwable th) {
                sdk.pendo.io.c6.b.b(th);
                this.s.dispose();
                throw sdk.pendo.io.q6.g.a(th);
            }
        }
    }

    public static abstract class c implements sdk.pendo.io.b6.b {

        final class a implements Runnable {
            final long A;
            final Runnable f;
            long f0;
            final sdk.pendo.io.e6.f s;
            long t0;
            long u0;

            a(long j, Runnable runnable, long j2, sdk.pendo.io.e6.f fVar, long j3) {
                this.f = runnable;
                this.s = fVar;
                this.A = j3;
                this.t0 = j2;
                this.u0 = j;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j;
                this.f.run();
                if (this.s.a()) {
                    return;
                }
                c cVar = c.this;
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                long a2 = cVar.a(timeUnit);
                long j2 = p.b;
                long j3 = a2 + j2;
                long j4 = this.t0;
                if (j3 >= j4) {
                    long j5 = this.A;
                    if (a2 < j4 + j5 + j2) {
                        long j6 = this.u0;
                        long j7 = this.f0 + 1;
                        this.f0 = j7;
                        j = j6 + (j7 * j5);
                        this.t0 = a2;
                        this.s.a(c.this.a(this, j - a2, timeUnit));
                    }
                }
                long j8 = this.A;
                long j9 = a2 + j8;
                long j10 = this.f0 + 1;
                this.f0 = j10;
                this.u0 = j9 - (j8 * j10);
                j = j9;
                this.t0 = a2;
                this.s.a(c.this.a(this, j - a2, timeUnit));
            }
        }

        public long a(TimeUnit timeUnit) {
            return p.a(timeUnit);
        }

        public abstract sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit);

        public sdk.pendo.io.b6.b a(Runnable runnable) {
            return a(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public sdk.pendo.io.b6.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            sdk.pendo.io.e6.f fVar = new sdk.pendo.io.e6.f();
            sdk.pendo.io.e6.f fVar2 = new sdk.pendo.io.e6.f(fVar);
            Runnable a2 = sdk.pendo.io.t6.a.a(runnable);
            long nanos = timeUnit.toNanos(j2);
            long a3 = a(TimeUnit.NANOSECONDS);
            sdk.pendo.io.b6.b a4 = a(new a(a3 + timeUnit.toNanos(j), a2, a3, fVar2, nanos), j, timeUnit);
            if (a4 == sdk.pendo.io.e6.c.INSTANCE) {
                return a4;
            }
            fVar.a(a4);
            return fVar2;
        }
    }

    static long a(TimeUnit timeUnit) {
        long nanoTime;
        TimeUnit timeUnit2;
        if (f1749a) {
            nanoTime = System.nanoTime();
            timeUnit2 = TimeUnit.NANOSECONDS;
        } else {
            nanoTime = System.currentTimeMillis();
            timeUnit2 = TimeUnit.MILLISECONDS;
        }
        return timeUnit.convert(nanoTime, timeUnit2);
    }

    public abstract c a();

    public sdk.pendo.io.b6.b a(Runnable runnable) {
        return a(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(sdk.pendo.io.t6.a.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }

    public sdk.pendo.io.b6.b a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(sdk.pendo.io.t6.a.a(runnable), a2);
        sdk.pendo.io.b6.b a3 = a2.a(bVar, j, j2, timeUnit);
        return a3 == sdk.pendo.io.e6.c.INSTANCE ? a3 : bVar;
    }
}
