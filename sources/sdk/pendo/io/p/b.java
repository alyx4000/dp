package sdk.pendo.io.p;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* loaded from: classes6.dex */
class b implements Closeable {
    private byte[] A;
    private final InputStream f;
    private int f0;
    private final Charset s;
    private int t0;

    class a extends ByteArrayOutputStream {
        a(int i) {
            super(i);
        }

        @Override // java.io.ByteArrayOutputStream
        public String toString() {
            int i = ((ByteArrayOutputStream) this).count;
            if (i > 0) {
                int i2 = i - 1;
                if (((ByteArrayOutputStream) this).buf[i2] == 13) {
                    i = i2;
                }
            }
            try {
                return new String(((ByteArrayOutputStream) this).buf, 0, i, b.this.s.name());
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
    }

    public b(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw null;
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(c.f1483a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f = inputStream;
        this.s = charset;
        this.A = new byte[i];
    }

    public boolean b() {
        return this.t0 == -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f) {
            if (this.A != null) {
                this.A = null;
                this.f.close();
            }
        }
    }

    public String e() {
        int i;
        byte[] bArr;
        int i2;
        synchronized (this.f) {
            if (this.A == null) {
                throw new IOException("LineReader is closed");
            }
            if (this.f0 >= this.t0) {
                a();
            }
            for (int i3 = this.f0; i3 != this.t0; i3++) {
                byte[] bArr2 = this.A;
                if (bArr2[i3] == 10) {
                    int i4 = this.f0;
                    if (i3 != i4) {
                        i2 = i3 - 1;
                        if (bArr2[i2] == 13) {
                            String str = new String(bArr2, i4, i2 - i4, this.s.name());
                            this.f0 = i3 + 1;
                            return str;
                        }
                    }
                    i2 = i3;
                    String str2 = new String(bArr2, i4, i2 - i4, this.s.name());
                    this.f0 = i3 + 1;
                    return str2;
                }
            }
            a aVar = new a((this.t0 - this.f0) + 80);
            loop1: while (true) {
                byte[] bArr3 = this.A;
                int i5 = this.f0;
                aVar.write(bArr3, i5, this.t0 - i5);
                this.t0 = -1;
                a();
                i = this.f0;
                while (i != this.t0) {
                    bArr = this.A;
                    if (bArr[i] == 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            int i6 = this.f0;
            if (i != i6) {
                aVar.write(bArr, i6, i - i6);
            }
            this.f0 = i + 1;
            return aVar.toString();
        }
    }

    public b(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    private void a() {
        InputStream inputStream = this.f;
        byte[] bArr = this.A;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f0 = 0;
        this.t0 = read;
    }
}
