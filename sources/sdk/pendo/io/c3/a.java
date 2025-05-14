package sdk.pendo.io.c3;

import com.extole.android.sdk.impl.http.HttpRequest;
import io.sentry.util.HttpUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.k3.l;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.m;
import sdk.pendo.io.w2.n;
import sdk.pendo.io.w2.w;
import sdk.pendo.io.w2.x;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\u000f"}, d2 = {"Lsdk/pendo/io/c3/a;", "Lsdk/pendo/io/w2/w;", "", "Lsdk/pendo/io/w2/m;", "cookies", "", "a", "Lsdk/pendo/io/w2/w$a;", "chain", "Lsdk/pendo/io/w2/d0;", "Lsdk/pendo/io/w2/n;", "Lsdk/pendo/io/w2/n;", "cookieJar", "<init>", "(Lokhttp3/CookieJar;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class a implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final n cookieJar;

    public a(n cookieJar) {
        Intrinsics.checkNotNullParameter(cookieJar, "cookieJar");
        this.cookieJar = cookieJar;
    }

    private final String a(List<m> cookies) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : cookies) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            m mVar = (m) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(mVar.getName()).append('=').append(mVar.getValue());
            i = i2;
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @Override // sdk.pendo.io.w2.w
    public d0 a(w.a chain) {
        e0 b;
        Intrinsics.checkNotNullParameter(chain, "chain");
        b0 b0Var = chain.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String();
        b0.a h = b0Var.h();
        c0 body = b0Var.getBody();
        if (body != null) {
            x xVar = body.getExpo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer.AUDIO_ATTRIBUTES_CONTENT_TYPE_KEY java.lang.String();
            if (xVar != null) {
                h.b(HttpRequest.HEADER_CONTENT_TYPE, xVar.getMediaType());
            }
            long a2 = body.a();
            if (a2 != -1) {
                h.b(HttpRequest.HEADER_CONTENT_LENGTH, String.valueOf(a2));
                h.a("Transfer-Encoding");
            } else {
                h.b("Transfer-Encoding", "chunked");
                h.a(HttpRequest.HEADER_CONTENT_LENGTH);
            }
        }
        boolean z = false;
        if (b0Var.a("Host") == null) {
            h.b("Host", sdk.pendo.io.x2.b.a(b0Var.i(), false, 1, (Object) null));
        }
        if (b0Var.a("Connection") == null) {
            h.b("Connection", "Keep-Alive");
        }
        if (b0Var.a(HttpRequest.HEADER_ACCEPT_ENCODING) == null && b0Var.a("Range") == null) {
            h.b(HttpRequest.HEADER_ACCEPT_ENCODING, HttpRequest.ENCODING_GZIP);
            z = true;
        }
        List<m> a3 = this.cookieJar.a(b0Var.i());
        if (!a3.isEmpty()) {
            h.b(HttpUtils.COOKIE_HEADER_NAME, a(a3));
        }
        if (b0Var.a("User-Agent") == null) {
            h.b("User-Agent", "okhttp/4.12.0");
        }
        d0 a4 = chain.a(h.a());
        e.a(this.cookieJar, b0Var.i(), a4.getHeaders());
        d0.a a5 = a4.v().a(b0Var);
        if (z && StringsKt.equals(HttpRequest.ENCODING_GZIP, d0.a(a4, HttpRequest.HEADER_CONTENT_ENCODING, null, 2, null), true) && e.b(a4) && (b = a4.b()) != null) {
            l lVar = new l(b.getSource());
            a5.a(a4.getHeaders().a().b(HttpRequest.HEADER_CONTENT_ENCODING).b(HttpRequest.HEADER_CONTENT_LENGTH).a());
            a5.a(new h(d0.a(a4, HttpRequest.HEADER_CONTENT_TYPE, null, 2, null), -1L, o.a(lVar)));
        }
        return a5.a();
    }
}
