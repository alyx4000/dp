package sdk.pendo.io.k3;

import androidx.exifinterface.media.ExifInterface;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001dB\u0019\b\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b\u001c\u0010\u001eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u000f\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0005\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lsdk/pendo/io/k3/h;", "Lsdk/pendo/io/k3/y;", "", "syncFlush", "", "a", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "flush", "()V", "close", "Lsdk/pendo/io/k3/b0;", "d", "", "toString", "Lsdk/pendo/io/k3/e;", "f", "Lsdk/pendo/io/k3/e;", "sink", "Ljava/util/zip/Deflater;", "s", "Ljava/util/zip/Deflater;", "deflater", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Z", "closed", "<init>", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class h implements y {

    /* renamed from: A, reason: from kotlin metadata */
    private boolean closed;

    /* renamed from: f, reason: from kotlin metadata */
    private final e sink;

    /* renamed from: s, reason: from kotlin metadata */
    private final Deflater deflater;

    public h(e sink, Deflater deflater) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        this.sink = sink;
        this.deflater = deflater;
    }

    private final void a(boolean syncFlush) {
        v b;
        int deflate;
        d bufferField = this.sink.getBufferField();
        while (true) {
            b = bufferField.b(1);
            if (syncFlush) {
                try {
                    Deflater deflater = this.deflater;
                    byte[] bArr = b.data;
                    int i = b.limit;
                    deflate = deflater.deflate(bArr, i, 8192 - i, 2);
                } catch (NullPointerException e) {
                    throw new IOException("Deflater already closed", e);
                }
            } else {
                Deflater deflater2 = this.deflater;
                byte[] bArr2 = b.data;
                int i2 = b.limit;
                deflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (deflate > 0) {
                b.limit += deflate;
                bufferField.j(bufferField.getSize() + deflate);
                this.sink.j();
            } else if (this.deflater.needsInput()) {
                break;
            }
        }
        if (b.pos == b.limit) {
            bufferField.head = b.b();
            w.a(b);
        }
    }

    @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            a();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.deflater.end();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        try {
            this.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // sdk.pendo.io.k3.y
    /* renamed from: d */
    public b0 getTimeout() {
        return this.sink.getTimeout();
    }

    @Override // sdk.pendo.io.k3.y, java.io.Flushable
    public void flush() {
        a(true);
        this.sink.flush();
    }

    public String toString() {
        return "DeflaterSink(" + this.sink + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(y sink, Deflater deflater) {
        this(o.a(sink), deflater);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
    }

    public final void a() {
        this.deflater.finish();
        a(false);
    }

    @Override // sdk.pendo.io.k3.y
    public void a(d source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        b.a(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            v vVar = source.head;
            Intrinsics.checkNotNull(vVar);
            int min = (int) Math.min(byteCount, vVar.limit - vVar.pos);
            this.deflater.setInput(vVar.data, vVar.pos, min);
            a(false);
            long j = min;
            source.j(source.getSize() - j);
            int i = vVar.pos + min;
            vVar.pos = i;
            if (i == vVar.limit) {
                source.head = vVar.b();
                w.a(vVar);
            }
            byteCount -= j;
        }
    }
}
