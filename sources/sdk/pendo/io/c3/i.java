package sdk.pendo.io.c3;

import io.sentry.SentryBaseEvent;
import java.net.Proxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.v;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/c3/i;", "", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "Ljava/net/Proxy$Type;", "proxyType", "", "b", "", "a", "Lsdk/pendo/io/w2/v;", "url", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f951a = new i();

    private i() {
    }

    private final boolean b(b0 request, Proxy.Type proxyType) {
        return !request.f() && proxyType == Proxy.Type.HTTP;
    }

    public final String a(b0 request, Proxy.Type proxyType) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(proxyType, "proxyType");
        StringBuilder sb = new StringBuilder();
        sb.append(request.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String());
        sb.append(' ');
        i iVar = f951a;
        boolean b = iVar.b(request, proxyType);
        v i = request.i();
        if (b) {
            sb.append(i);
        } else {
            sb.append(iVar.a(i));
        }
        sb.append(" HTTP/1.1");
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String a(v url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String d = url.d();
        String f = url.f();
        return f != null ? d + '?' + f : d;
    }
}
