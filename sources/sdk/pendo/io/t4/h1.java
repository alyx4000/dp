package sdk.pendo.io.t4;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes6.dex */
class h1 extends sdk.pendo.io.y4.p1 {
    private static final boolean S = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.client.acceptRenegotiation", false);
    private final Closeable R;

    h1(InputStream inputStream, OutputStream outputStream, Closeable closeable) {
        super(inputStream, outputStream);
        this.R = closeable;
    }

    @Override // sdk.pendo.io.y4.w2
    protected void e() {
        this.R.close();
    }

    @Override // sdk.pendo.io.y4.w2
    protected int n() {
        return S ? 2 : 0;
    }
}
