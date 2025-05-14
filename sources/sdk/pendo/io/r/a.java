package sdk.pendo.io.r;

import java.io.OutputStream;

/* loaded from: classes6.dex */
public final class a extends OutputStream {
    private sdk.pendo.io.u.a A;
    private final OutputStream f;
    private int f0;
    private byte[] s;

    public a(OutputStream outputStream, sdk.pendo.io.u.a aVar) {
        this(outputStream, aVar, 65536);
    }

    private void a() {
        int i = this.f0;
        if (i > 0) {
            this.f.write(this.s, 0, i);
            this.f0 = 0;
        }
    }

    private void b() {
        if (this.f0 == this.s.length) {
            a();
        }
    }

    private void e() {
        byte[] bArr = this.s;
        if (bArr != null) {
            this.A.put(bArr);
            this.s = null;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            flush();
            this.f.close();
            e();
        } catch (Throwable th) {
            this.f.close();
            throw th;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        a();
        this.f.flush();
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        byte[] bArr = this.s;
        int i2 = this.f0;
        this.f0 = i2 + 1;
        bArr[i2] = (byte) i;
        b();
    }

    a(OutputStream outputStream, sdk.pendo.io.u.a aVar, int i) {
        this.f = outputStream;
        this.A = aVar;
        this.s = (byte[]) aVar.get(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            int i6 = this.f0;
            if (i6 == 0 && i4 >= this.s.length) {
                this.f.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.s.length - i6);
            System.arraycopy(bArr, i5, this.s, this.f0, min);
            this.f0 += min;
            i3 += min;
            b();
        } while (i3 < i2);
    }
}
