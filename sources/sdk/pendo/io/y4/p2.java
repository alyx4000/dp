package sdk.pendo.io.y4;

import java.io.OutputStream;

/* loaded from: classes4.dex */
class p2 extends OutputStream {
    private final w2 f;

    p2(w2 w2Var) {
        this.f = w2Var;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.d();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f.g(bArr, i, i2);
    }
}
