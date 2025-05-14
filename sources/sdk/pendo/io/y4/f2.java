package sdk.pendo.io.y4;

import java.io.IOException;

/* loaded from: classes4.dex */
public class f2 extends IOException {
    protected Throwable f;

    public f2(String str) {
        this(str, null);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f;
    }

    public f2(String str, Throwable th) {
        super(str);
        this.f = th;
    }
}
