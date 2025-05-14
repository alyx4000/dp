package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class z extends IllegalStateException {
    private Throwable f;

    public z(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f;
    }

    public z(String str, Throwable th) {
        super(str);
        this.f = th;
    }
}
