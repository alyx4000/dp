package sdk.pendo.io.q;

import java.io.IOException;

/* loaded from: classes6.dex */
public final class e extends IOException {
    private final int f;

    public e(int i) {
        this("Http request failed", i);
    }

    public e(String str, int i) {
        this(str, i, null);
    }

    public e(String str, int i, Throwable th) {
        super(str + ", status code: " + i, th);
        this.f = i;
    }
}
