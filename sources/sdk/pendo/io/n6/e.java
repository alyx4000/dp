package sdk.pendo.io.n6;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes6.dex */
final class e implements Callable<Void>, sdk.pendo.io.b6.b {
    static final FutureTask<Void> u0 = new FutureTask<>(sdk.pendo.io.f6.a.b, null);
    final Runnable f;
    final ExecutorService f0;
    Thread t0;
    final AtomicReference<Future<?>> A = new AtomicReference<>();
    final AtomicReference<Future<?>> s = new AtomicReference<>();

    e(Runnable runnable, ExecutorService executorService) {
        this.f = runnable;
        this.f0 = executorService;
    }

    @Override // sdk.pendo.io.b6.b
    public boolean a() {
        return this.A.get() == u0;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.t0 = Thread.currentThread();
        try {
            this.f.run();
            b(this.f0.submit(this));
            this.t0 = null;
        } catch (Throwable th) {
            this.t0 = null;
            sdk.pendo.io.t6.a.b(th);
        }
        return null;
    }

    @Override // sdk.pendo.io.b6.b
    public void dispose() {
        AtomicReference<Future<?>> atomicReference = this.A;
        FutureTask<Void> futureTask = u0;
        Future<?> andSet = atomicReference.getAndSet(futureTask);
        if (andSet != null && andSet != futureTask) {
            andSet.cancel(this.t0 != Thread.currentThread());
        }
        Future<?> andSet2 = this.s.getAndSet(futureTask);
        if (andSet2 == null || andSet2 == futureTask) {
            return;
        }
        andSet2.cancel(this.t0 != Thread.currentThread());
    }

    void a(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.A.get();
            if (future2 == u0) {
                future.cancel(this.t0 != Thread.currentThread());
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.A, future2, future));
    }

    void b(Future<?> future) {
        Future<?> future2;
        do {
            future2 = this.s.get();
            if (future2 == u0) {
                future.cancel(this.t0 != Thread.currentThread());
                return;
            }
        } while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(this.s, future2, future));
    }
}
