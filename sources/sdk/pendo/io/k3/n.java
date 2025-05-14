package sdk.pendo.io.k3;

import io.sentry.ProfilingTraceData;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/k3/n;", "Lsdk/pendo/io/k3/a0;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "", "close", "Lsdk/pendo/io/k3/b0;", "d", "", "toString", "Ljava/io/InputStream;", "f", "Ljava/io/InputStream;", "input", "s", "Lsdk/pendo/io/k3/b0;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "<init>", "(Ljava/io/InputStream;Lokio/Timeout;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
class n implements a0 {

    /* renamed from: f, reason: from kotlin metadata */
    private final InputStream input;

    /* renamed from: s, reason: from kotlin metadata */
    private final b0 timeout;

    public n(InputStream input, b0 timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.input = input;
        this.timeout = timeout;
    }

    @Override // sdk.pendo.io.k3.a0
    public long c(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (byteCount == 0) {
            return 0L;
        }
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        try {
            this.timeout.e();
            v b = sink.b(1);
            int read = this.input.read(b.data, b.limit, (int) Math.min(byteCount, 8192 - b.limit));
            if (read != -1) {
                b.limit += read;
                long j = read;
                sink.j(sink.getSize() + j);
                return j;
            }
            if (b.pos != b.limit) {
                return -1L;
            }
            sink.head = b.b();
            w.a(b);
            return -1L;
        } catch (AssertionError e) {
            if (o.a(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }

    @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    @Override // sdk.pendo.io.k3.a0
    /* renamed from: d, reason: from getter */
    public b0 getTimeout() {
        return this.timeout;
    }

    public String toString() {
        return "source(" + this.input + ')';
    }
}
