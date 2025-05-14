package sdk.pendo.io.k3;

import io.sentry.ProfilingTraceData;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/k3/s;", "Lsdk/pendo/io/k3/y;", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "", "a", "flush", "close", "Lsdk/pendo/io/k3/b0;", "d", "", "toString", "Ljava/io/OutputStream;", "f", "Ljava/io/OutputStream;", "out", "s", "Lsdk/pendo/io/k3/b0;", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "<init>", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
final class s implements y {

    /* renamed from: f, reason: from kotlin metadata */
    private final OutputStream out;

    /* renamed from: s, reason: from kotlin metadata */
    private final b0 timeout;

    public s(OutputStream out, b0 timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.out = out;
        this.timeout = timeout;
    }

    @Override // sdk.pendo.io.k3.y
    public void a(d source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        b.a(source.getSize(), 0L, byteCount);
        while (byteCount > 0) {
            this.timeout.e();
            v vVar = source.head;
            Intrinsics.checkNotNull(vVar);
            int min = (int) Math.min(byteCount, vVar.limit - vVar.pos);
            this.out.write(vVar.data, vVar.pos, min);
            vVar.pos += min;
            long j = min;
            byteCount -= j;
            source.j(source.getSize() - j);
            if (vVar.pos == vVar.limit) {
                source.head = vVar.b();
                w.a(vVar);
            }
        }
    }

    @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // sdk.pendo.io.k3.y
    /* renamed from: d, reason: from getter */
    public b0 getTimeout() {
        return this.timeout;
    }

    @Override // sdk.pendo.io.k3.y, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    public String toString() {
        return "sink(" + this.out + ')';
    }
}
