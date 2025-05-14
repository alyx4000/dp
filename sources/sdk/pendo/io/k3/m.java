package sdk.pendo.io.k3;

import androidx.exifinterface.media.ExifInterface;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001eB\u0019\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0016\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nJ\b\u0010\t\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006 "}, d2 = {"Lsdk/pendo/io/k3/m;", "Lsdk/pendo/io/k3/a0;", "", "b", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "d", "", "a", "Lsdk/pendo/io/k3/b0;", "close", "Lsdk/pendo/io/k3/f;", "f", "Lsdk/pendo/io/k3/f;", "source", "Ljava/util/zip/Inflater;", "s", "Ljava/util/zip/Inflater;", "inflater", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "I", "bufferBytesHeldByInflater", "f0", "Z", "closed", "<init>", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class m implements a0 {

    /* renamed from: A, reason: from kotlin metadata */
    private int bufferBytesHeldByInflater;

    /* renamed from: f, reason: from kotlin metadata */
    private final f source;

    /* renamed from: f0, reason: from kotlin metadata */
    private boolean closed;

    /* renamed from: s, reason: from kotlin metadata */
    private final Inflater inflater;

    public m(f source, Inflater inflater) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.source = source;
        this.inflater = inflater;
    }

    private final void b() {
        int i = this.bufferBytesHeldByInflater;
        if (i == 0) {
            return;
        }
        int remaining = i - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    public final boolean a() {
        if (!this.inflater.needsInput()) {
            return false;
        }
        if (this.source.i()) {
            return true;
        }
        v vVar = this.source.c().head;
        Intrinsics.checkNotNull(vVar);
        int i = vVar.limit;
        int i2 = vVar.pos;
        int i3 = i - i2;
        this.bufferBytesHeldByInflater = i3;
        this.inflater.setInput(vVar.data, i2, i3);
        return false;
    }

    @Override // sdk.pendo.io.k3.a0
    public long c(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        do {
            long d = d(sink, byteCount);
            if (d > 0) {
                return d;
            }
            if (this.inflater.finished() || this.inflater.needsDictionary()) {
                return -1L;
            }
        } while (!this.source.i());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    public final long d(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        try {
            v b = sink.b(1);
            int min = (int) Math.min(byteCount, 8192 - b.limit);
            a();
            int inflate = this.inflater.inflate(b.data, b.limit, min);
            b();
            if (inflate > 0) {
                b.limit += inflate;
                long j = inflate;
                sink.j(sink.getSize() + j);
                return j;
            }
            if (b.pos == b.limit) {
                sink.head = b.b();
                w.a(b);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m(a0 source, Inflater inflater) {
        this(o.a(source), inflater);
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
    }

    @Override // sdk.pendo.io.k3.a0
    /* renamed from: d */
    public b0 getTimeout() {
        return this.source.getTimeout();
    }
}
