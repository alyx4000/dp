package sdk.pendo.io.k3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0010\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/k3/i;", "Lsdk/pendo/io/k3/y;", "Lsdk/pendo/io/k3/d;", "source", "", "byteCount", "", "a", "flush", "Lsdk/pendo/io/k3/b0;", "d", "close", "", "toString", "f", "Lsdk/pendo/io/k3/y;", "delegate", "()Lokio/Sink;", "<init>", "(Lokio/Sink;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public abstract class i implements y {

    /* renamed from: f, reason: from kotlin metadata */
    private final y delegate;

    public i(y delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // sdk.pendo.io.k3.y
    public void a(d source, long byteCount) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.delegate.a(source, byteCount);
    }

    @Override // sdk.pendo.io.k3.y, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // sdk.pendo.io.k3.y
    public b0 d() {
        return this.delegate.d();
    }

    @Override // sdk.pendo.io.k3.y, java.io.Flushable
    public void flush() {
        this.delegate.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
