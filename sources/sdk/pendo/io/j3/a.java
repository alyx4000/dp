package sdk.pendo.io.j3;

import androidx.exifinterface.media.ExifInterface;
import java.io.Closeable;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.d;
import sdk.pendo.io.k3.y;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\f\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/j3/a;", "Ljava/io/Closeable;", "Lsdk/pendo/io/k3/d;", "Lsdk/pendo/io/k3/g;", "suffix", "", "a", "buffer", "", "close", "f", "Z", "noContextTakeover", "s", "Lsdk/pendo/io/k3/d;", "deflatedBytes", "Ljava/util/zip/Deflater;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/zip/Deflater;", "deflater", "Lsdk/pendo/io/k3/h;", "f0", "Lsdk/pendo/io/k3/h;", "deflaterSink", "<init>", "(Z)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class a implements Closeable {

    /* renamed from: A, reason: from kotlin metadata */
    private final Deflater deflater;

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean noContextTakeover;

    /* renamed from: f0, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.h deflaterSink;

    /* renamed from: s, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.d deflatedBytes;

    public a(boolean z) {
        this.noContextTakeover = z;
        sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
        this.deflatedBytes = dVar;
        Deflater deflater = new Deflater(-1, true);
        this.deflater = deflater;
        this.deflaterSink = new sdk.pendo.io.k3.h((y) dVar, deflater);
    }

    public final void a(sdk.pendo.io.k3.d buffer) {
        sdk.pendo.io.k3.g gVar;
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!(this.deflatedBytes.getSize() == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (this.noContextTakeover) {
            this.deflater.reset();
        }
        this.deflaterSink.a(buffer, buffer.getSize());
        this.deflaterSink.flush();
        sdk.pendo.io.k3.d dVar = this.deflatedBytes;
        gVar = b.f1219a;
        if (a(dVar, gVar)) {
            long size = this.deflatedBytes.getSize() - 4;
            d.a a2 = sdk.pendo.io.k3.d.a(this.deflatedBytes, (d.a) null, 1, (Object) null);
            try {
                a2.h(size);
                CloseableKt.closeFinally(a2, null);
            } finally {
            }
        } else {
            this.deflatedBytes.writeByte(0);
        }
        sdk.pendo.io.k3.d dVar2 = this.deflatedBytes;
        buffer.a(dVar2, dVar2.getSize());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.deflaterSink.close();
    }

    private final boolean a(sdk.pendo.io.k3.d dVar, sdk.pendo.io.k3.g gVar) {
        return dVar.a(dVar.getSize() - gVar.l(), gVar);
    }
}
