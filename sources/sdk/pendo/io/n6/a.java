package sdk.pendo.io.n6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
abstract class a extends AtomicReference<Future<?>> implements sdk.pendo.io.b6.b {
    protected static final FutureTask<Void> A;
    protected static final FutureTask<Void> f0;
    protected final Runnable f;
    protected Thread s;

    static {
        Runnable runnable = sdk.pendo.io.f6.a.b;
        A = new FutureTask<>(runnable, null);
        f0 = new FutureTask<>(runnable, null);
    }

    a(Runnable runnable) {
        this.f = runnable;
    }

    @Override // sdk.pendo.io.b6.b
    public final boolean a() {
        Future<?> future = get();
        return future == A || future == f0;
    }

    @Override // sdk.pendo.io.b6.b
    public final void dispose() {
        FutureTask<Void> futureTask;
        Future<?> future = get();
        if (future == A || future == (futureTask = f0) || !PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.s != Thread.currentThread());
    }

    public final void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = get();
            if (future2 == A) {
                return;
            }
            if (future2 == f0) {
                future.cancel(this.s != Thread.currentThread());
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this, future2, future));
    }
}
