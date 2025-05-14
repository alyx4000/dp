package sdk.pendo.io.a6;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import sdk.pendo.io.b6.c;
import sdk.pendo.io.x5.p;

/* loaded from: classes6.dex */
final class b extends p {
    private final Handler c;
    private final boolean d;

    private static final class a extends p.c {
        private volatile boolean A;
        private final Handler f;
        private final boolean s;

        a(Handler handler, boolean z) {
            this.f = handler;
            this.s = z;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.A;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.A = true;
            this.f.removeCallbacksAndMessages(this);
        }

        @Override // sdk.pendo.io.x5.p.c
        public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.A) {
                return c.a();
            }
            RunnableC0081b runnableC0081b = new RunnableC0081b(this.f, sdk.pendo.io.t6.a.a(runnable));
            Message obtain = Message.obtain(this.f, runnableC0081b);
            obtain.obj = this;
            if (this.s) {
                obtain.setAsynchronous(true);
            }
            this.f.sendMessageDelayed(obtain, timeUnit.toMillis(j));
            if (!this.A) {
                return runnableC0081b;
            }
            this.f.removeCallbacks(runnableC0081b);
            return c.a();
        }
    }

    /* renamed from: sdk.pendo.io.a6.b$b, reason: collision with other inner class name */
    private static final class RunnableC0081b implements Runnable, sdk.pendo.io.b6.b {
        private volatile boolean A;
        private final Handler f;
        private final Runnable s;

        RunnableC0081b(Handler handler, Runnable runnable) {
            this.f = handler;
            this.s = runnable;
        }

        @Override // sdk.pendo.io.b6.b
        public boolean a() {
            return this.A;
        }

        @Override // sdk.pendo.io.b6.b
        public void dispose() {
            this.f.removeCallbacks(this);
            this.A = true;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.s.run();
            } catch (Throwable th) {
                sdk.pendo.io.t6.a.b(th);
            }
        }
    }

    b(Handler handler, boolean z) {
        this.c = handler;
        this.d = z;
    }

    @Override // sdk.pendo.io.x5.p
    public p.c a() {
        return new a(this.c, this.d);
    }

    @Override // sdk.pendo.io.x5.p
    public sdk.pendo.io.b6.b a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0081b runnableC0081b = new RunnableC0081b(this.c, sdk.pendo.io.t6.a.a(runnable));
        Message obtain = Message.obtain(this.c, runnableC0081b);
        if (this.d) {
            obtain.setAsynchronous(true);
        }
        this.c.sendMessageDelayed(obtain, timeUnit.toMillis(j));
        return runnableC0081b;
    }
}
