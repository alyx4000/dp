package sdk.pendo.io.d3;

import android.support.v4.media.session.PlaybackStateCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.f;
import sdk.pendo.io.w2.u;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/d3/a;", "", "", "b", "Lsdk/pendo/io/w2/u;", "a", "Lsdk/pendo/io/k3/f;", "Lsdk/pendo/io/k3/f;", "getSource", "()Lokio/BufferedSource;", "source", "", "J", "headerLimit", "<init>", "(Lokio/BufferedSource;)V", "c", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final f source;

    /* renamed from: b, reason: from kotlin metadata */
    private long headerLimit;

    public a(f source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.source = source;
        this.headerLimit = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
    }

    public final u a() {
        u.a aVar = new u.a();
        while (true) {
            String b = b();
            if (b.length() == 0) {
                return aVar.a();
            }
            aVar.a(b);
        }
    }

    public final String b() {
        String e = this.source.e(this.headerLimit);
        this.headerLimit -= e.length();
        return e;
    }
}
