package sdk.pendo.io.m3;

import java.io.IOException;

/* loaded from: classes6.dex */
public class j extends IOException {
    private Throwable f;

    j(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f;
    }

    j(String str, Throwable th) {
        super(str);
        this.f = th;
    }
}
