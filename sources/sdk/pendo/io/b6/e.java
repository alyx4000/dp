package sdk.pendo.io.b6;

/* loaded from: classes6.dex */
final class e extends d<Runnable> {
    e(Runnable runnable) {
        super(runnable);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        return "RunnableDisposable(disposed=" + a() + ", " + get() + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.b6.d
    public void a(Runnable runnable) {
        runnable.run();
    }
}
