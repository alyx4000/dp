package sdk.pendo.io.c3;

import io.sentry.SentryBaseEvent;
import io.sentry.protocol.Response;
import kotlin.Metadata;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.y;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\u0007\u001a\u00020\bH&J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0010\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\bH&R\u0014\u0010\u0014\u001a\u00020\u00118&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/c3/d;", "", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "", "contentLength", "Lsdk/pendo/io/k3/y;", "a", "", "b", "", "expectContinue", "Lsdk/pendo/io/w2/d0$a;", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "Lsdk/pendo/io/k3/a0;", "cancel", "Lsdk/pendo/io/b3/f;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public interface d {
    a0 a(d0 response);

    y a(b0 request, long contentLength);

    d0.a a(boolean expectContinue);

    void a();

    void a(b0 request);

    long b(d0 response);

    void b();

    /* renamed from: c */
    sdk.pendo.io.b3.f getConnection();

    void cancel();
}
