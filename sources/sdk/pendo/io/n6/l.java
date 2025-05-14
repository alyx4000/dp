package sdk.pendo.io.n6;

import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class l extends a implements Callable<Void> {
    public l(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Void call() {
        this.s = Thread.currentThread();
        try {
            this.f.run();
            return null;
        } finally {
            lazySet(a.A);
            this.s = null;
        }
    }
}
