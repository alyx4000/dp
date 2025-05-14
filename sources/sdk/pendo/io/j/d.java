package sdk.pendo.io.j;

import androidx.exifinterface.media.ExifInterface;
import com.iterable.iterableapi.IterableConstants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u0014\u0010\r\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0010¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/j/d;", "Ljava/io/InputStream;", "", "size", "", "a", IterableConstants.ITERABLE_IN_APP_READ, "", "b", DebugKt.DEBUG_PROPERTY_VALUE_OFF, "len", "f", "Ljava/io/InputStream;", "original", "", "s", "J", "maxSize", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, IterableConstants.KEY_TOTAL, "<init>", "(Ljava/io/InputStream;J)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class d extends InputStream {

    /* renamed from: A, reason: from kotlin metadata */
    private long total;

    /* renamed from: f, reason: from kotlin metadata */
    private final InputStream original;

    /* renamed from: s, reason: from kotlin metadata */
    private final long maxSize;

    public d(InputStream original, long j) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.original = original;
        this.maxSize = j;
    }

    private final void a(int size) {
        long j = this.total + size;
        this.total = j;
        if (j > this.maxSize) {
            throw new IOException("InputStream exceeded maximum size " + this.maxSize + " bytes");
        }
    }

    @Override // java.io.InputStream
    public int read() {
        int read = this.original.read();
        if (read >= 0) {
            a(1);
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        return read(b, 0, b.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) {
        Intrinsics.checkNotNullParameter(b, "b");
        int read = this.original.read(b, off, len);
        if (read >= 0) {
            a(read);
        }
        return read;
    }
}
