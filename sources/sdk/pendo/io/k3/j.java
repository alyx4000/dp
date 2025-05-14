package sdk.pendo.io.k3;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u000f\u001a\u00020\u00018\u0007¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/k3/j;", "Lsdk/pendo/io/k3/a0;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "Lsdk/pendo/io/k3/b0;", "d", "", "close", "", "toString", "f", "Lsdk/pendo/io/k3/a0;", "delegate", "()Lokio/Source;", "<init>", "(Lokio/Source;)V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public abstract class j implements a0 {

    /* renamed from: f, reason: from kotlin metadata */
    private final a0 delegate;

    public j(a0 delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    /* renamed from: a, reason: from getter */
    public final a0 getDelegate() {
        return this.delegate;
    }

    @Override // sdk.pendo.io.k3.a0
    public long c(d sink, long byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return this.delegate.c(sink, byteCount);
    }

    @Override // sdk.pendo.io.k3.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // sdk.pendo.io.k3.a0
    public b0 d() {
        return this.delegate.d();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
