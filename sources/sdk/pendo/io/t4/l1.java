package sdk.pendo.io.t4;

import java.io.Closeable;
import java.io.InputStream;
import java.io.OutputStream;
import sdk.pendo.io.y4.i3;

/* loaded from: classes6.dex */
class l1 extends i3 {
    private final Closeable N;

    l1(InputStream inputStream, OutputStream outputStream, Closeable closeable) {
        super(inputStream, outputStream);
        this.N = closeable;
    }

    @Override // sdk.pendo.io.y4.w2
    protected void e() {
        this.N.close();
    }
}
