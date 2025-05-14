package sdk.pendo.io.n6;

/* loaded from: classes6.dex */
public final class k extends a implements Runnable {
    public k(Runnable runnable) {
        super(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.s = Thread.currentThread();
        try {
            this.f.run();
            this.s = null;
        } catch (Throwable th) {
            this.s = null;
            lazySet(a.A);
            sdk.pendo.io.t6.a.b(th);
        }
    }
}
