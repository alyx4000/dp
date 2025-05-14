package sdk.pendo.io.f5;

import java.io.OutputStream;

/* loaded from: classes6.dex */
public class c extends OutputStream {
    private OutputStream f;
    private OutputStream s;

    public c(OutputStream outputStream, OutputStream outputStream2) {
        this.f = outputStream;
        this.s = outputStream2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
        this.s.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.f.flush();
        this.s.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f.write(i);
        this.s.write(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        this.f.write(bArr);
        this.s.write(bArr);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        this.f.write(bArr, i, i2);
        this.s.write(bArr, i, i2);
    }
}
