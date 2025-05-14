package sdk.pendo.io.y5;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.b6.b;

/* loaded from: classes4.dex */
public abstract class a implements b {
    private final AtomicBoolean f = new AtomicBoolean();

    /* renamed from: sdk.pendo.io.y5.a$a, reason: collision with other inner class name */
    class RunnableC0272a implements Runnable {
        RunnableC0272a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.b();
        }
    }

    public static void c() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
        }
    }

    @Override // sdk.pendo.io.b6.b
    public final boolean a() {
        return this.f.get();
    }

    protected abstract void b();

    @Override // sdk.pendo.io.b6.b
    public final void dispose() {
        if (this.f.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b();
            } else {
                sdk.pendo.io.a6.a.a().a(new RunnableC0272a());
            }
        }
    }
}
