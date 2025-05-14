package sdk.pendo.io.k3;

import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00060\u0001j\u0002`\u0002J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lsdk/pendo/io/k3/a0;", "Ljava/io/Closeable;", "Lexternal/sdk/pendo/io/okio/Closeable;", "Lsdk/pendo/io/k3/d;", "sink", "", "byteCount", "c", "Lsdk/pendo/io/k3/b0;", "d", "", "close", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface a0 extends Closeable {
    long c(d sink, long byteCount);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    b0 d();
}
