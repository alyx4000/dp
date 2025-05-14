package sdk.pendo.io.c3;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.x;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/c3/h;", "Lsdk/pendo/io/w2/e0;", "", "m", "Lsdk/pendo/io/w2/x;", "n", "Lsdk/pendo/io/k3/f;", "o", "", "s", "Ljava/lang/String;", "contentTypeString", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "J", "contentLength", "f0", "Lsdk/pendo/io/k3/f;", "source", "<init>", "(Ljava/lang/String;JLokio/BufferedSource;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class h extends e0 {

    /* renamed from: A, reason: from kotlin metadata */
    private final long contentLength;

    /* renamed from: f0, reason: from kotlin metadata */
    private final sdk.pendo.io.k3.f source;

    /* renamed from: s, reason: from kotlin metadata */
    private final String contentTypeString;

    public h(String str, long j, sdk.pendo.io.k3.f source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.contentTypeString = str;
        this.contentLength = j;
        this.source = source;
    }

    @Override // sdk.pendo.io.w2.e0
    /* renamed from: m, reason: from getter */
    public long getContentLength() {
        return this.contentLength;
    }

    @Override // sdk.pendo.io.w2.e0
    /* renamed from: n */
    public x getS() {
        String str = this.contentTypeString;
        if (str != null) {
            return x.INSTANCE.b(str);
        }
        return null;
    }

    @Override // sdk.pendo.io.w2.e0
    /* renamed from: o, reason: from getter */
    public sdk.pendo.io.k3.f getSource() {
        return this.source;
    }
}
