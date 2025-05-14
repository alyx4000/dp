package sdk.pendo.io.y4;

import java.io.InputStream;
import kotlin.UByte;

/* loaded from: classes4.dex */
public class j extends InputStream {
    private i f = new i();

    public void a(byte[] bArr, int i, int i2) {
        this.f.a(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f.a();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f.a() == 0) {
            return -1;
        }
        return this.f.a(1, 0)[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        int min = Math.min((int) j, this.f.a());
        this.f.c(min);
        return min;
    }

    public int a(byte[] bArr) {
        int min = Math.min(this.f.a(), bArr.length);
        this.f.a(bArr, 0, min, 0);
        return min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int min = Math.min(this.f.a(), i2);
        this.f.b(bArr, i, min, 0);
        return min;
    }
}
