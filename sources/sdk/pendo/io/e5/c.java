package sdk.pendo.io.e5;

/* loaded from: classes6.dex */
public class c extends IllegalStateException {
    private Throwable f;

    c(String str, Throwable th) {
        super(str);
        this.f = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f;
    }
}
