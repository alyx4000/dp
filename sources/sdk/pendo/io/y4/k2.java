package sdk.pendo.io.y4;

import java.io.InputStream;
import kotlin.UByte;

/* loaded from: classes4.dex */
class k2 extends InputStream {
    private final w2 f;

    k2(w2 w2Var) {
        this.f = w2Var;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f.a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.d();
    }

    @Override // java.io.InputStream
    public int read() {
        byte[] bArr = new byte[1];
        if (read(bArr, 0, 1) <= 0) {
            return -1;
        }
        return bArr[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.f.c(bArr, i, i2);
    }
}
