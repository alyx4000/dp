package sdk.pendo.io.c3;

import androidx.core.app.NotificationCompat;
import com.extole.android.sdk.impl.http.HttpRequest;
import io.sentry.protocol.Request;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.f0;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.w;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0018\u0010\n\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0016¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/c3/j;", "Lsdk/pendo/io/w2/w;", "Ljava/io/IOException;", "e", "Lsdk/pendo/io/b3/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/b0;", "userRequest", "", "requestSendStarted", "a", "Lsdk/pendo/io/w2/d0;", "userResponse", "Lsdk/pendo/io/b3/c;", "exchange", "", Request.JsonKeys.METHOD, "", "defaultDelay", "Lsdk/pendo/io/w2/w$a;", "chain", "Lsdk/pendo/io/w2/z;", "Lsdk/pendo/io/w2/z;", "client", "<init>", "(Lokhttp3/OkHttpClient;)V", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class j implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final z client;

    public j(z client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    private final b0 a(d0 userResponse, String method) {
        String a2;
        v d;
        c0 c0Var = null;
        if (!this.client.getFollowRedirects() || (a2 = d0.a(userResponse, "Location", null, 2, null)) == null || (d = userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().i().d(a2)) == null) {
            return null;
        }
        if (!Intrinsics.areEqual(d.getScheme(), userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().i().getScheme()) && !this.client.getFollowSslRedirects()) {
            return null;
        }
        b0.a h = userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().h();
        if (f.a(method)) {
            int i = userResponse.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String();
            f fVar = f.f949a;
            boolean z = fVar.c(method) || i == 308 || i == 307;
            if (fVar.b(method) && i != 308 && i != 307) {
                method = "GET";
            } else if (z) {
                c0Var = userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().getBody();
            }
            h.a(method, c0Var);
            if (!z) {
                h.a("Transfer-Encoding");
                h.a(HttpRequest.HEADER_CONTENT_LENGTH);
                h.a(HttpRequest.HEADER_CONTENT_TYPE);
            }
        }
        if (!sdk.pendo.io.x2.b.a(userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().i(), d)) {
            h.a("Authorization");
        }
        return h.a(d).a();
    }

    private final b0 a(d0 userResponse, sdk.pendo.io.b3.c exchange) {
        sdk.pendo.io.b3.f connection;
        f0 route = (exchange == null || (connection = exchange.getConnection()) == null) ? null : connection.getRoute();
        int i = userResponse.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String();
        String str = userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String();
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.client.getAuthenticator().a(route, userResponse);
            }
            if (i == 421) {
                c0 body = userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().getBody();
                if ((body != null && body.d()) || exchange == null || !exchange.j()) {
                    return null;
                }
                exchange.getConnection().l();
                return userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String();
            }
            if (i == 503) {
                d0 priorResponse = userResponse.getPriorResponse();
                if ((priorResponse == null || priorResponse.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() != 503) && a(userResponse, Integer.MAX_VALUE) == 0) {
                    return userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String();
                }
                return null;
            }
            if (i == 407) {
                Intrinsics.checkNotNull(route);
                if (route.getProxy().type() == Proxy.Type.HTTP) {
                    return this.client.getProxyAuthenticator().a(route, userResponse);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i == 408) {
                if (!this.client.getRetryOnConnectionFailure()) {
                    return null;
                }
                c0 body2 = userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().getBody();
                if (body2 != null && body2.d()) {
                    return null;
                }
                d0 priorResponse2 = userResponse.getPriorResponse();
                if ((priorResponse2 == null || priorResponse2.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() != 408) && a(userResponse, 0) <= 0) {
                    return userResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String();
                }
                return null;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case HttpServletResponse.SC_SEE_OTHER /* 303 */:
                    break;
                default:
                    return null;
            }
        }
        return a(userResponse, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        if (r7 == null) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
    
        r0 = r0.v().d(r7.v().a((sdk.pendo.io.w2.e0) null).a()).a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0040, code lost:
    
        r7 = r0;
        r0 = r1.getInterceptorScopedExchange();
        r6 = a(r7, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0049, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
    
        r0 = r6.getBody();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005e, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (r0.d() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        r1.a(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        return r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006a, code lost:
    
        r0 = r7.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
    
        if (r0 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0070, code lost:
    
        sdk.pendo.io.x2.b.a(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0073, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0077, code lost:
    
        if (r8 > 20) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        throw new java.net.ProtocolException("Too many follow-up requests: " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004b, code lost:
    
        if (r0 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0051, code lost:
    
        if (r0.getIsDuplex() == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
    
        r1.p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0056, code lost:
    
        r1.a(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0059, code lost:
    
        return r7;
     */
    @Override // sdk.pendo.io.w2.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public sdk.pendo.io.w2.d0 a(sdk.pendo.io.w2.w.a r11) {
        /*
            r10 = this;
            java.lang.String r0 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            sdk.pendo.io.c3.g r11 = (sdk.pendo.io.c3.g) r11
            sdk.pendo.io.w2.b0 r0 = r11.g()
            sdk.pendo.io.b3.e r1 = r11.getAndroidx.core.app.NotificationCompat.CATEGORY_CALL java.lang.String()
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
            r3 = 0
            r4 = 0
            r5 = 1
            r8 = r3
            r7 = r4
        L18:
            r6 = r5
        L19:
            r1.a(r0, r6)
            boolean r6 = r1.getCanceled()     // Catch: java.lang.Throwable -> Ld2
            if (r6 != 0) goto Lca
            sdk.pendo.io.w2.d0 r0 = r11.a(r0)     // Catch: java.io.IOException -> L97 sdk.pendo.io.b3.i -> Lab java.lang.Throwable -> Ld2
            if (r7 == 0) goto L40
            sdk.pendo.io.w2.d0$a r0 = r0.v()     // Catch: java.lang.Throwable -> Ld2
            sdk.pendo.io.w2.d0$a r6 = r7.v()     // Catch: java.lang.Throwable -> Ld2
            sdk.pendo.io.w2.d0$a r6 = r6.a(r4)     // Catch: java.lang.Throwable -> Ld2
            sdk.pendo.io.w2.d0 r6 = r6.a()     // Catch: java.lang.Throwable -> Ld2
            sdk.pendo.io.w2.d0$a r0 = r0.d(r6)     // Catch: java.lang.Throwable -> Ld2
            sdk.pendo.io.w2.d0 r0 = r0.a()     // Catch: java.lang.Throwable -> Ld2
        L40:
            r7 = r0
            sdk.pendo.io.b3.c r0 = r1.getInterceptorScopedExchange()     // Catch: java.lang.Throwable -> Ld2
            sdk.pendo.io.w2.b0 r6 = r10.a(r7, r0)     // Catch: java.lang.Throwable -> Ld2
            if (r6 != 0) goto L5a
            if (r0 == 0) goto L56
            boolean r11 = r0.getIsDuplex()     // Catch: java.lang.Throwable -> Ld2
            if (r11 == 0) goto L56
            r1.p()     // Catch: java.lang.Throwable -> Ld2
        L56:
            r1.a(r3)
            return r7
        L5a:
            sdk.pendo.io.w2.c0 r0 = r6.getBody()     // Catch: java.lang.Throwable -> Ld2
            if (r0 == 0) goto L6a
            boolean r0 = r0.d()     // Catch: java.lang.Throwable -> Ld2
            if (r0 == 0) goto L6a
            r1.a(r3)
            return r7
        L6a:
            sdk.pendo.io.w2.e0 r0 = r7.b()     // Catch: java.lang.Throwable -> Ld2
            if (r0 == 0) goto L73
            sdk.pendo.io.x2.b.a(r0)     // Catch: java.lang.Throwable -> Ld2
        L73:
            int r8 = r8 + 1
            r0 = 20
            if (r8 > r0) goto L7e
            r1.a(r5)
            r0 = r6
            goto L18
        L7e:
            java.net.ProtocolException r11 = new java.net.ProtocolException     // Catch: java.lang.Throwable -> Ld2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld2
            r0.<init>()     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r2 = "Too many follow-up requests: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Throwable -> Ld2
            java.lang.StringBuilder r0 = r0.append(r8)     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ld2
            r11.<init>(r0)     // Catch: java.lang.Throwable -> Ld2
            throw r11     // Catch: java.lang.Throwable -> Ld2
        L97:
            r6 = move-exception
            boolean r9 = r6 instanceof sdk.pendo.io.e3.a     // Catch: java.lang.Throwable -> Ld2
            r9 = r9 ^ r5
            boolean r9 = r10.a(r6, r1, r0, r9)     // Catch: java.lang.Throwable -> Ld2
            if (r9 == 0) goto La6
        La1:
            java.util.List r2 = kotlin.collections.CollectionsKt.plus(r2, r6)     // Catch: java.lang.Throwable -> Ld2
            goto Lbb
        La6:
            java.lang.Throwable r11 = sdk.pendo.io.x2.b.a(r6, r2)     // Catch: java.lang.Throwable -> Ld2
            throw r11     // Catch: java.lang.Throwable -> Ld2
        Lab:
            r6 = move-exception
            java.io.IOException r9 = r6.getLastConnectException()     // Catch: java.lang.Throwable -> Ld2
            boolean r9 = r10.a(r9, r1, r0, r3)     // Catch: java.lang.Throwable -> Ld2
            if (r9 == 0) goto Lc1
            java.io.IOException r6 = r6.getFirstConnectException()     // Catch: java.lang.Throwable -> Ld2
            goto La1
        Lbb:
            r1.a(r5)
            r6 = r3
            goto L19
        Lc1:
            java.io.IOException r11 = r6.getFirstConnectException()     // Catch: java.lang.Throwable -> Ld2
            java.lang.Throwable r11 = sdk.pendo.io.x2.b.a(r11, r2)     // Catch: java.lang.Throwable -> Ld2
            throw r11     // Catch: java.lang.Throwable -> Ld2
        Lca:
            java.io.IOException r11 = new java.io.IOException     // Catch: java.lang.Throwable -> Ld2
            java.lang.String r0 = "Canceled"
            r11.<init>(r0)     // Catch: java.lang.Throwable -> Ld2
            throw r11     // Catch: java.lang.Throwable -> Ld2
        Ld2:
            r11 = move-exception
            r1.a(r5)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.c3.j.a(sdk.pendo.io.w2.w$a):sdk.pendo.io.w2.d0");
    }

    private final boolean a(IOException e, boolean requestSendStarted) {
        if (e instanceof ProtocolException) {
            return false;
        }
        return e instanceof InterruptedIOException ? (e instanceof SocketTimeoutException) && !requestSendStarted : (((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) || (e instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private final boolean a(IOException e, sdk.pendo.io.b3.e call, b0 userRequest, boolean requestSendStarted) {
        if (this.client.getRetryOnConnectionFailure()) {
            return !(requestSendStarted && a(e, userRequest)) && a(e, requestSendStarted) && call.o();
        }
        return false;
    }

    private final boolean a(IOException e, b0 userRequest) {
        c0 body = userRequest.getBody();
        return (body != null && body.d()) || (e instanceof FileNotFoundException);
    }

    private final int a(d0 userResponse, int defaultDelay) {
        String a2 = d0.a(userResponse, "Retry-After", null, 2, null);
        if (a2 == null) {
            return defaultDelay;
        }
        if (!new Regex("\\d+").matches(a2)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(a2);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }
}
