package sdk.pendo.io.e3;

import io.sentry.SentryBaseEvent;
import io.sentry.protocol.Response;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Header;
import sdk.pendo.io.k3.y;
import sdk.pendo.io.w2.a0;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ,2\u00020\u0001:\u0001\u0007B'\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u0015\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b*\u0010+J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0016R\u001a\u0010\u0015\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006-"}, d2 = {"Lsdk/pendo/io/e3/g;", "Lsdk/pendo/io/c3/d;", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "", "contentLength", "Lsdk/pendo/io/k3/y;", "a", "", "b", "", "expectContinue", "Lsdk/pendo/io/w2/d0$a;", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "Lsdk/pendo/io/k3/a0;", "cancel", "Lsdk/pendo/io/b3/f;", "Lsdk/pendo/io/b3/f;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "connection", "Lsdk/pendo/io/c3/g;", "Lsdk/pendo/io/c3/g;", "chain", "Lsdk/pendo/io/e3/f;", "c", "Lsdk/pendo/io/e3/f;", "http2Connection", "Lsdk/pendo/io/e3/i;", "d", "Lsdk/pendo/io/e3/i;", "stream", "Lsdk/pendo/io/w2/a0;", "e", "Lsdk/pendo/io/w2/a0;", "protocol", "f", "Z", "canceled", "Lsdk/pendo/io/w2/z;", "client", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "g", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class g implements sdk.pendo.io.c3.d {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<String> h = sdk.pendo.io.x2.b.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    private static final List<String> i = sdk.pendo.io.x2.b.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.b3.f connection;

    /* renamed from: b, reason: from kotlin metadata */
    private final sdk.pendo.io.c3.g chain;

    /* renamed from: c, reason: from kotlin metadata */
    private final f http2Connection;

    /* renamed from: d, reason: from kotlin metadata */
    private volatile i stream;

    /* renamed from: e, reason: from kotlin metadata */
    private final a0 protocol;

    /* renamed from: f, reason: from kotlin metadata */
    private volatile boolean canceled;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0014\u0010\u0015\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000eR\u0014\u0010\u0016\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u0014\u0010\u0018\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u000e¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/e3/g$a;", "", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "", "Lsdk/pendo/io/e3/c;", "a", "Lsdk/pendo/io/w2/u;", "headerBlock", "Lsdk/pendo/io/w2/a0;", "protocol", "Lsdk/pendo/io/w2/d0$a;", "", "CONNECTION", "Ljava/lang/String;", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "Ljava/util/List;", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.e3.g$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<c> a(b0 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            u headers = request.getHeaders();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new c(c.g, request.getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String()));
            arrayList.add(new c(c.h, sdk.pendo.io.c3.i.f951a.a(request.i())));
            String a2 = request.a("Host");
            if (a2 != null) {
                arrayList.add(new c(c.j, a2));
            }
            arrayList.add(new c(c.i, request.i().getScheme()));
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String a3 = headers.a(i);
                Locale US = Locale.US;
                Intrinsics.checkNotNullExpressionValue(US, "US");
                String lowerCase = a3.toLowerCase(US);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                if (!g.h.contains(lowerCase) || (Intrinsics.areEqual(lowerCase, "te") && Intrinsics.areEqual(headers.b(i), "trailers"))) {
                    arrayList.add(new c(lowerCase, headers.b(i)));
                }
            }
            return arrayList;
        }

        public final d0.a a(u headerBlock, a0 protocol) {
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            u.a aVar = new u.a();
            int size = headerBlock.size();
            sdk.pendo.io.c3.k kVar = null;
            for (int i = 0; i < size; i++) {
                String a2 = headerBlock.a(i);
                String b = headerBlock.b(i);
                if (Intrinsics.areEqual(a2, Header.RESPONSE_STATUS_UTF8)) {
                    kVar = sdk.pendo.io.c3.k.INSTANCE.a("HTTP/1.1 " + b);
                } else if (!g.i.contains(a2)) {
                    aVar.b(a2, b);
                }
            }
            if (kVar != null) {
                return new d0.a().a(protocol).a(kVar.com.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String).a(kVar.message).a(aVar.a());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public g(z client, sdk.pendo.io.b3.f connection, sdk.pendo.io.c3.g chain, f http2Connection) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(http2Connection, "http2Connection");
        this.connection = connection;
        this.chain = chain;
        this.http2Connection = http2Connection;
        List<a0> A = client.A();
        a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
        this.protocol = A.contains(a0Var) ? a0Var : a0.HTTP_2;
    }

    @Override // sdk.pendo.io.c3.d
    public y a(b0 request, long contentLength) {
        Intrinsics.checkNotNullParameter(request, "request");
        i iVar = this.stream;
        Intrinsics.checkNotNull(iVar);
        return iVar.j();
    }

    @Override // sdk.pendo.io.c3.d
    public void b() {
        this.http2Connection.flush();
    }

    @Override // sdk.pendo.io.c3.d
    /* renamed from: c, reason: from getter */
    public sdk.pendo.io.b3.f getConnection() {
        return this.connection;
    }

    @Override // sdk.pendo.io.c3.d
    public void cancel() {
        this.canceled = true;
        i iVar = this.stream;
        if (iVar != null) {
            iVar.a(b.CANCEL);
        }
    }

    @Override // sdk.pendo.io.c3.d
    public void a() {
        i iVar = this.stream;
        Intrinsics.checkNotNull(iVar);
        iVar.j().close();
    }

    @Override // sdk.pendo.io.c3.d
    public long b(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        if (sdk.pendo.io.c3.e.b(response)) {
            return sdk.pendo.io.x2.b.a(response);
        }
        return 0L;
    }

    @Override // sdk.pendo.io.c3.d
    public sdk.pendo.io.k3.a0 a(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        i iVar = this.stream;
        Intrinsics.checkNotNull(iVar);
        return iVar.getSource();
    }

    @Override // sdk.pendo.io.c3.d
    public d0.a a(boolean expectContinue) {
        i iVar = this.stream;
        if (iVar == null) {
            throw new IOException("stream wasn't created");
        }
        d0.a a2 = INSTANCE.a(iVar.s(), this.protocol);
        if (expectContinue && a2.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() == 100) {
            return null;
        }
        return a2;
    }

    @Override // sdk.pendo.io.c3.d
    public void a(b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        if (this.stream != null) {
            return;
        }
        this.stream = this.http2Connection.a(INSTANCE.a(request), request.getBody() != null);
        if (this.canceled) {
            i iVar = this.stream;
            Intrinsics.checkNotNull(iVar);
            iVar.a(b.CANCEL);
            throw new IOException("Canceled");
        }
        i iVar2 = this.stream;
        Intrinsics.checkNotNull(iVar2);
        sdk.pendo.io.k3.b0 r = iVar2.r();
        long readTimeoutMillis = this.chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        r.a(readTimeoutMillis, timeUnit);
        i iVar3 = this.stream;
        Intrinsics.checkNotNull(iVar3);
        iVar3.u().a(this.chain.getWriteTimeoutMillis(), timeUnit);
    }
}
