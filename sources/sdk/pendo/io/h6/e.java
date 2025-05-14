package sdk.pendo.io.h6;

/* loaded from: classes6.dex */
public final class e<T> extends d<T> {
    @Override // sdk.pendo.io.x5.o
    public void onError(Throwable th) {
        if (this.f == null) {
            this.s = th;
        }
        countDown();
    }

    @Override // sdk.pendo.io.x5.o
    public void onNext(T t) {
        if (this.f == null) {
            this.f = t;
            this.A.dispose();
            countDown();
        }
    }
}
