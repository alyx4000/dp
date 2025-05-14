package sdk.pendo.io.i0;

import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* loaded from: classes6.dex */
public final class d extends InputStream {
    private static final Queue<d> A = k.a(0);
    private InputStream f;
    private IOException s;

    d() {
    }

    public IOException a() {
        return this.s;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f.available();
    }

    public void b() {
        this.s = null;
        this.f = null;
        Queue<d> queue = A;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f.markSupported();
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f.read();
        } catch (IOException e) {
            this.s = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f.skip(j);
        } catch (IOException e) {
            this.s = e;
            throw e;
        }
    }

    public static d a(InputStream inputStream) {
        d poll;
        Queue<d> queue = A;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new d();
        }
        poll.b(inputStream);
        return poll;
    }

    void b(InputStream inputStream) {
        this.f = inputStream;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f.read(bArr);
        } catch (IOException e) {
            this.s = e;
            throw e;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f.read(bArr, i, i2);
        } catch (IOException e) {
            this.s = e;
            throw e;
        }
    }
}
