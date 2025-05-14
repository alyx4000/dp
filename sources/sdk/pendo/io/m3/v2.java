package sdk.pendo.io.m3;

import java.io.InputStream;

/* loaded from: classes6.dex */
abstract class v2 extends InputStream {
    protected final InputStream f;
    private int s;

    v2(InputStream inputStream, int i) {
        this.f = inputStream;
        this.s = i;
    }

    int a() {
        return this.s;
    }

    protected void a(boolean z) {
        InputStream inputStream = this.f;
        if (inputStream instanceof s2) {
            ((s2) inputStream).b(z);
        }
    }
}
