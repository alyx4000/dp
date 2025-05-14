package sdk.pendo.io.f5;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes6.dex */
public class b extends InputStream {
    private final InputStream f;
    private final OutputStream s;

    public b(InputStream inputStream, OutputStream outputStream) {
        this.f = inputStream;
        this.s = outputStream;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
        this.s.close();
    }

    @Override // java.io.InputStream
    public int read() {
        int read = this.f.read();
        if (read >= 0) {
            this.s.write(read);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int read = this.f.read(bArr, i, i2);
        if (read > 0) {
            this.s.write(bArr, i, read);
        }
        return read;
    }
}
