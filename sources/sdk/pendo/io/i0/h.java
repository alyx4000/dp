package sdk.pendo.io.i0;

import java.io.FilterInputStream;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class h extends FilterInputStream {
    private int f;

    public h(InputStream inputStream) {
        super(inputStream);
        this.f = Integer.MIN_VALUE;
    }

    private long h(long j) {
        int i = this.f;
        if (i == 0) {
            return -1L;
        }
        if (i != Integer.MIN_VALUE) {
            long j2 = i;
            if (j > j2) {
                return j2;
            }
        }
        return j;
    }

    private void i(long j) {
        int i = this.f;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f = (int) (i - j);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() {
        int i = this.f;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() {
        if (h(1L) == -1) {
            return -1;
        }
        int read = super.read();
        i(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() {
        super.reset();
        this.f = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) {
        long h = h(j);
        if (h == -1) {
            return 0L;
        }
        long skip = super.skip(h);
        i(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        int h = (int) h(i2);
        if (h == -1) {
            return -1;
        }
        int read = super.read(bArr, i, h);
        i(read);
        return read;
    }
}
