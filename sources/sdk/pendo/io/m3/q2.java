package sdk.pendo.io.m3;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
class q2 extends v2 {
    private static final byte[] t0 = new byte[0];
    private final int A;
    private int f0;

    q2(InputStream inputStream, int i, int i2) {
        super(inputStream, i2);
        if (i <= 0) {
            if (i < 0) {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
            a(true);
        }
        this.A = i;
        this.f0 = i;
    }

    void a(byte[] bArr) {
        int i = this.f0;
        if (i != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i == 0) {
            return;
        }
        int a2 = a();
        int i2 = this.f0;
        if (i2 >= a2) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f0 + " >= " + a2);
        }
        int a3 = i2 - sdk.pendo.io.f5.a.a(this.f, bArr, 0, bArr.length);
        this.f0 = a3;
        if (a3 != 0) {
            throw new EOFException("DEF length " + this.A + " object truncated by " + this.f0);
        }
        a(true);
    }

    int b() {
        return this.f0;
    }

    byte[] e() {
        if (this.f0 == 0) {
            return t0;
        }
        int a2 = a();
        int i = this.f0;
        if (i >= a2) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f0 + " >= " + a2);
        }
        byte[] bArr = new byte[i];
        int a3 = i - sdk.pendo.io.f5.a.a(this.f, bArr, 0, i);
        this.f0 = a3;
        if (a3 != 0) {
            throw new EOFException("DEF length " + this.A + " object truncated by " + this.f0);
        }
        a(true);
        return bArr;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f0 == 0) {
            return -1;
        }
        int read = this.f.read();
        if (read < 0) {
            throw new EOFException("DEF length " + this.A + " object truncated by " + this.f0);
        }
        int i = this.f0 - 1;
        this.f0 = i;
        if (i == 0) {
            a(true);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int i3 = this.f0;
        if (i3 == 0) {
            return -1;
        }
        int read = this.f.read(bArr, i, Math.min(i2, i3));
        if (read < 0) {
            throw new EOFException("DEF length " + this.A + " object truncated by " + this.f0);
        }
        int i4 = this.f0 - read;
        this.f0 = i4;
        if (i4 == 0) {
            a(true);
        }
        return read;
    }
}
