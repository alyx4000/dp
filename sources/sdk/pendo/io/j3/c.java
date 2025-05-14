package sdk.pendo.io.j3;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.m;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/j3/c;", "Ljava/io/Closeable;", "Lsdk/pendo/io/k3/d;", "buffer", "", "a", "close", "", "f", "Z", "noContextTakeover", "s", "Lsdk/pendo/io/k3/d;", "deflatedBytes", "Ljava/util/zip/Inflater;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/zip/Inflater;", "inflater", "Lsdk/pendo/io/k3/m;", "f0", "Lsdk/pendo/io/k3/m;", "inflaterSource", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class c implements Closeable {

    /* renamed from: A, reason: from kotlin metadata */
    private final Inflater inflater;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* renamed from: f0, reason: from kotlin metadata */
    private final m inflaterSource;

    /* renamed from: s, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.d deflatedBytes;

    public c(boolean z) {
        this.noContextTakeover = z;
        sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
        this.deflatedBytes = dVar;
        Inflater inflater = new Inflater(true);
        this.inflater = inflater;
        this.inflaterSource = new m((a0) dVar, inflater);
    }

    public final void a(sdk.pendo.io.k3.d buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!(this.deflatedBytes.getSize() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.inflater.reset();
        }
        this.deflatedBytes.a((a0) buffer);
        this.deflatedBytes.writeInt(65535);
        long bytesRead = this.inflater.getBytesRead() + this.deflatedBytes.getSize();
        do {
            this.inflaterSource.d(buffer, Long.MAX_VALUE);
        } while (this.inflater.getBytesRead() < bytesRead);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inflaterSource.close();
    }
}
