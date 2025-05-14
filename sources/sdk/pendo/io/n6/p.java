package sdk.pendo.io.n6;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
public final class p extends sdk.pendo.io.x5.p {
    private static final p c = new p();

    static final class a implements Runnable {
        private final long A;
        private final Runnable f;
        private final c s;

        a(Runnable runnable, c cVar, long j) {
            this.f = runnable;
            this.s = cVar;
            this.A = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.s.f0) {
                return;
            }
            long a2 = this.s.a(TimeUnit.MILLISECONDS);
            long j = this.A;
            if (j > a2) {
                try {
                    Thread.sleep(j - a2);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    sdk.pendo.io.t6.a.b(e);
                    return;
                }
            }
            if (this.s.f0) {
                return;
            }
            this.f.run();
        }
    }

    static final class b implements Comparable<b> {
        final int A;
        final Runnable f;
        volatile boolean f0;
        final long s;

        b(Runnable runnable, Long l, int i) {
            this.f = runnable;
            this.s = l.longValue();
            this.A = i;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int a2 = sdk.pendo.io.f6.b.a(this.s, bVar.s);
            return a2 == 0 ? sdk.pendo.io.f6.b.a(this.A, bVar.A) : a2;
        }
    }

    static final class c extends p.c {
        volatile boolean f0;
        final PriorityBlockingQueue<b> f = new PriorityBlockingQueue<>();
        private final AtomicInteger s = new AtomicInteger();
        final AtomicInteger A = new AtomicInteger();

        final class a implements Runnable {
            final b f;

            a(b bVar) {
                this.f = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f.f0 = true;
                c.this.f.remove(this.f);
            }
        }

        c() {
        }

        sdk.pendo.io.b6.b a(Runnable runnable, long j) {
            if (this.f0) {
                return sdk.pendo.io.e6.c.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.A.incrementAndGet());
            this.f.add(bVar);
            if (this.s.getAndIncrement() != 0) {
                return sdk.pendo.io.b6.c.a(new a(bVar));
            }
            int i = 1;
            while (!this.f0) {
                b poll = this.f.poll();
                if (poll == null) {
                    i = this.s.addAndGet(-i);
                    if (i == 0) {
                        return sdk.pendo.io.e6.c.INSTANCE;
                    }
                } else if (!poll.f0) {
                    poll.f.run();
                }
            }
            this.f.clear();
            return sdk.pendo.io.e6.c.INSTANCE;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.f0 = true;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.f0;
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }
    }

    p() {
    }

    public static p b() {
        return c;
    }

    @Override // sdk.pendo.io.x5.p
    public p.c a() {
        return new c();
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable) {
        sdk.pendo.io.t6.a.a(runnable).run();
        return sdk.pendo.io.e6.c.INSTANCE;
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            sdk.pendo.io.t6.a.a(runnable).run();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            sdk.pendo.io.t6.a.b(e);
        }
        return sdk.pendo.io.e6.c.INSTANCE;
    }
}
