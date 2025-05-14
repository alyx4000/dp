package sdk.pendo.io.y;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

/* loaded from: classes4.dex */
public class a extends FilterInputStream {
    private int A;
    private volatile byte[] f;
    private int f0;
    private int s;
    private int t0;
    private final sdk.pendo.io.u.a u0;

    /* renamed from: sdk.pendo.io.y.a$a, reason: collision with other inner class name */
    static class C0268a extends IOException {
        C0268a(String str) {
            super(str);
        }
    }

    public a(InputStream inputStream, sdk.pendo.io.u.a aVar) {
        this(inputStream, aVar, 65536);
    }

    private int a(InputStream inputStream, byte[] bArr) {
        int i = this.f0;
        if (i != -1) {
            int i2 = this.t0 - i;
            int i3 = this.A;
            if (i2 < i3) {
                if (i == 0 && i3 > bArr.length && this.s == bArr.length) {
                    int length = bArr.length * 2;
                    if (length <= i3) {
                        i3 = length;
                    }
                    byte[] bArr2 = (byte[]) this.u0.get(i3, byte[].class);
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    this.f = bArr2;
                    this.u0.put(bArr);
                    bArr = bArr2;
                } else if (i > 0) {
                    System.arraycopy(bArr, i, bArr, 0, bArr.length - i);
                }
                int i4 = this.t0 - this.f0;
                this.t0 = i4;
                this.f0 = 0;
                this.s = 0;
                int read = inputStream.read(bArr, i4, bArr.length - i4);
                int i5 = this.t0;
                if (read > 0) {
                    i5 += read;
                }
                this.s = i5;
                return read;
            }
        }
        int read2 = inputStream.read(bArr);
        if (read2 > 0) {
            this.f0 = -1;
            this.t0 = 0;
            this.s = read2;
        }
        return read2;
    }

    private static IOException e() {
        throw new IOException("BufferedInputStream is closed");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() {
        InputStream inputStream;
        inputStream = ((FilterInputStream) this).in;
        if (this.f == null || inputStream == null) {
            throw e();
        }
        return (this.s - this.t0) + inputStream.available();
    }

    public synchronized void b() {
        if (this.f != null) {
            this.u0.put(this.f);
            this.f = null;
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f != null) {
            this.u0.put(this.f);
            this.f = null;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        ((FilterInputStream) this).in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        this.A = Math.max(this.A, i);
        this.f0 = this.t0;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() {
        byte[] bArr = this.f;
        InputStream inputStream = ((FilterInputStream) this).in;
        if (bArr == null || inputStream == null) {
            throw e();
        }
        if (this.t0 >= this.s && a(inputStream, bArr) == -1) {
            return -1;
        }
        if (bArr != this.f && (bArr = this.f) == null) {
            throw e();
        }
        int i = this.s;
        int i2 = this.t0;
        if (i - i2 <= 0) {
            return -1;
        }
        this.t0 = i2 + 1;
        return bArr[i2] & UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        if (this.f == null) {
            throw new IOException("Stream is closed");
        }
        int i = this.f0;
        if (-1 == i) {
            throw new C0268a("Mark has been invalidated, pos: " + this.t0 + " markLimit: " + this.A);
        }
        this.t0 = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        if (j < 1) {
            return 0L;
        }
        byte[] bArr = this.f;
        if (bArr == null) {
            throw e();
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw e();
        }
        int i = this.s;
        int i2 = this.t0;
        if (i - i2 >= j) {
            this.t0 = (int) (i2 + j);
            return j;
        }
        long j2 = i - i2;
        this.t0 = i;
        if (this.f0 == -1 || j > this.A) {
            long skip = inputStream.skip(j - j2);
            if (skip > 0) {
                this.f0 = -1;
            }
            return j2 + skip;
        }
        if (a(inputStream, bArr) == -1) {
            return j2;
        }
        int i3 = this.s;
        int i4 = this.t0;
        if (i3 - i4 >= j - j2) {
            this.t0 = (int) ((i4 + j) - j2);
            return j;
        }
        long j3 = (j2 + i3) - i4;
        this.t0 = i3;
        return j3;
    }

    a(InputStream inputStream, sdk.pendo.io.u.a aVar, int i) {
        super(inputStream);
        this.f0 = -1;
        this.u0 = aVar;
        this.f = (byte[]) aVar.get(i, byte[].class);
    }

    public synchronized void a() {
        this.A = this.f.length;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        byte[] bArr2 = this.f;
        if (bArr2 == null) {
            throw e();
        }
        if (i2 == 0) {
            return 0;
        }
        InputStream inputStream = ((FilterInputStream) this).in;
        if (inputStream == null) {
            throw e();
        }
        int i5 = this.t0;
        int i6 = this.s;
        if (i5 < i6) {
            int i7 = i6 - i5;
            if (i7 >= i2) {
                i7 = i2;
            }
            System.arraycopy(bArr2, i5, bArr, i, i7);
            this.t0 += i7;
            if (i7 == i2 || inputStream.available() == 0) {
                return i7;
            }
            i += i7;
            i3 = i2 - i7;
        } else {
            i3 = i2;
        }
        while (true) {
            if (this.f0 == -1 && i3 >= bArr2.length) {
                i4 = inputStream.read(bArr, i, i3);
                if (i4 == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
            } else {
                if (a(inputStream, bArr2) == -1) {
                    return i3 != i2 ? i2 - i3 : -1;
                }
                if (bArr2 != this.f && (bArr2 = this.f) == null) {
                    throw e();
                }
                int i8 = this.s;
                int i9 = this.t0;
                i4 = i8 - i9;
                if (i4 >= i3) {
                    i4 = i3;
                }
                System.arraycopy(bArr2, i9, bArr, i, i4);
                this.t0 += i4;
            }
            i3 -= i4;
            if (i3 == 0) {
                return i2;
            }
            if (inputStream.available() == 0) {
                return i2 - i3;
            }
            i += i4;
        }
    }
}
