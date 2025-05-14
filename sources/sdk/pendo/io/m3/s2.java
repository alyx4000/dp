package sdk.pendo.io.m3;

import java.io.EOFException;
import java.io.InputStream;

/* loaded from: classes6.dex */
class s2 extends v2 {
    private int A;
    private int f0;
    private boolean t0;
    private boolean u0;

    s2(InputStream inputStream, int i) {
        super(inputStream, i);
        this.t0 = false;
        this.u0 = true;
        this.A = inputStream.read();
        int read = inputStream.read();
        this.f0 = read;
        if (read < 0) {
            throw new EOFException();
        }
        b();
    }

    private boolean b() {
        if (!this.t0 && this.u0 && this.A == 0 && this.f0 == 0) {
            this.t0 = true;
            a(true);
        }
        return this.t0;
    }

    @Override // java.io.InputStream
    public int read() {
        if (b()) {
            return -1;
        }
        int read = this.f.read();
        if (read < 0) {
            throw new EOFException();
        }
        int i = this.A;
        this.A = this.f0;
        this.f0 = read;
        return i;
    }

    void b(boolean z) {
        this.u0 = z;
        b();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (this.u0 || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this.t0) {
            return -1;
        }
        int read = this.f.read(bArr, i + 2, i2 - 2);
        if (read < 0) {
            throw new EOFException();
        }
        bArr[i] = (byte) this.A;
        bArr[i + 1] = (byte) this.f0;
        this.A = this.f.read();
        int read2 = this.f.read();
        this.f0 = read2;
        if (read2 >= 0) {
            return read + 2;
        }
        throw new EOFException();
    }
}
