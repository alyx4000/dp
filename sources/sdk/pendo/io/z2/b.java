package sdk.pendo.io.z2;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.facebook.common.callercontext.ContextChain;
import expo.modules.interfaces.permissions.PermissionsResponse;
import io.sentry.SentryBaseEvent;
import io.sentry.protocol.Response;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.lang3.time.DateUtils;
import sdk.pendo.io.c3.c;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.u;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0002\u0003\tB\u001d\b\u0000\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/z2/b;", "", "Lsdk/pendo/io/w2/b0;", "a", "Lsdk/pendo/io/w2/b0;", "getNetworkRequest", "()Lokhttp3/Request;", "networkRequest", "Lsdk/pendo/io/w2/d0;", "b", "Lsdk/pendo/io/w2/d0;", "getCacheResponse", "()Lokhttp3/Response;", "cacheResponse", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "c", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class b {

    /* renamed from: c, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final b0 networkRequest;

    /* renamed from: b, reason: from kotlin metadata */
    private final d0 cacheResponse;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lsdk/pendo/io/z2/b$a;", "", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.z2.b$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(d0 response, b0 request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            int i = response.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String();
            if (i != 200 && i != 410 && i != 414 && i != 501 && i != 203 && i != 204) {
                if (i != 307) {
                    if (i != 308 && i != 404 && i != 405) {
                        switch (i) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (d0.a(response, HttpRequest.HEADER_EXPIRES, null, 2, null) == null && response.e().getMaxAgeSeconds() == -1 && !response.e().getIsPublic() && !response.e().getIsPrivate()) {
                    return false;
                }
            }
            return (response.e().getNoStore() || request.c().getNoStore()) ? false : true;
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b*\u0010+J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u000b\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\fR\u001a\u0010\n\u001a\u00020\t8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0018R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010\fR\u0016\u0010#\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\fR\u0018\u0010%\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010\u0018R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lsdk/pendo/io/z2/b$b;", "", "", "e", "Lsdk/pendo/io/z2/b;", "c", "", "d", "a", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "b", "J", "nowMillis", "Lsdk/pendo/io/w2/b0;", "getRequest$okhttp", "()Lokhttp3/Request;", "Lsdk/pendo/io/w2/d0;", "Lsdk/pendo/io/w2/d0;", "cacheResponse", "Ljava/util/Date;", "Ljava/util/Date;", "servedDate", "", "Ljava/lang/String;", "servedDateString", "f", "lastModified", "g", "lastModifiedString", "h", PermissionsResponse.EXPIRES_KEY, ContextChain.TAG_INFRA, "sentRequestMillis", "j", "receivedResponseMillis", "k", "etag", "", "l", "I", "ageSeconds", "<init>", "(JLokhttp3/Request;Lokhttp3/Response;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.z2.b$b, reason: collision with other inner class name */
    public static final class C0279b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final long nowMillis;

        /* renamed from: b, reason: from kotlin metadata */
        private final b0 request;

        /* renamed from: c, reason: from kotlin metadata */
        private final d0 cacheResponse;

        /* renamed from: d, reason: from kotlin metadata */
        private Date servedDate;

        /* renamed from: e, reason: from kotlin metadata */
        private String servedDateString;

        /* renamed from: f, reason: from kotlin metadata */
        private Date lastModified;

        /* renamed from: g, reason: from kotlin metadata */
        private String lastModifiedString;

        /* renamed from: h, reason: from kotlin metadata */
        private Date expires;

        /* renamed from: i, reason: from kotlin metadata */
        private long sentRequestMillis;

        /* renamed from: j, reason: from kotlin metadata */
        private long receivedResponseMillis;

        /* renamed from: k, reason: from kotlin metadata */
        private String etag;

        /* renamed from: l, reason: from kotlin metadata */
        private int ageSeconds;

        public C0279b(long j, b0 request, d0 d0Var) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.nowMillis = j;
            this.request = request;
            this.cacheResponse = d0Var;
            this.ageSeconds = -1;
            if (d0Var != null) {
                this.sentRequestMillis = d0Var.getSentRequestAtMillis();
                this.receivedResponseMillis = d0Var.getReceivedResponseAtMillis();
                u headers = d0Var.getHeaders();
                int size = headers.size();
                for (int i = 0; i < size; i++) {
                    String a2 = headers.a(i);
                    String b = headers.b(i);
                    if (StringsKt.equals(a2, HttpRequest.HEADER_DATE, true)) {
                        this.servedDate = c.a(b);
                        this.servedDateString = b;
                    } else if (StringsKt.equals(a2, HttpRequest.HEADER_EXPIRES, true)) {
                        this.expires = c.a(b);
                    } else if (StringsKt.equals(a2, HttpRequest.HEADER_LAST_MODIFIED, true)) {
                        this.lastModified = c.a(b);
                        this.lastModifiedString = b;
                    } else if (StringsKt.equals(a2, HttpRequest.HEADER_ETAG, true)) {
                        this.etag = b;
                    } else if (StringsKt.equals(a2, "Age", true)) {
                        this.ageSeconds = sdk.pendo.io.x2.b.b(b, -1);
                    }
                }
            }
        }

        private final long a() {
            Date date = this.servedDate;
            long max = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i = this.ageSeconds;
            if (i != -1) {
                max = Math.max(max, TimeUnit.SECONDS.toMillis(i));
            }
            long j = this.receivedResponseMillis;
            return max + (j - this.sentRequestMillis) + (this.nowMillis - j);
        }

        private final b c() {
            String str;
            if (this.cacheResponse == null) {
                return new b(this.request, null);
            }
            if ((!this.request.f() || this.cacheResponse.getHandshake() != null) && b.INSTANCE.a(this.cacheResponse, this.request)) {
                d c = this.request.c();
                if (c.getNoCache() || a(this.request)) {
                    return new b(this.request, null);
                }
                d e = this.cacheResponse.e();
                long a2 = a();
                long d = d();
                if (c.getMaxAgeSeconds() != -1) {
                    d = Math.min(d, TimeUnit.SECONDS.toMillis(c.getMaxAgeSeconds()));
                }
                long j = 0;
                long millis = c.getMinFreshSeconds() != -1 ? TimeUnit.SECONDS.toMillis(c.getMinFreshSeconds()) : 0L;
                if (!e.getMustRevalidate() && c.getMaxStaleSeconds() != -1) {
                    j = TimeUnit.SECONDS.toMillis(c.getMaxStaleSeconds());
                }
                if (!e.getNoCache()) {
                    long j2 = millis + a2;
                    if (j2 < j + d) {
                        d0.a v = this.cacheResponse.v();
                        if (j2 >= d) {
                            v.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                        }
                        if (a2 > DateUtils.MILLIS_PER_DAY && e()) {
                            v.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                        }
                        return new b(null, v.a());
                    }
                }
                String str2 = this.etag;
                if (str2 != null) {
                    str = HttpRequest.HEADER_IF_NONE_MATCH;
                } else {
                    if (this.lastModified != null) {
                        str2 = this.lastModifiedString;
                    } else {
                        if (this.servedDate == null) {
                            return new b(this.request, null);
                        }
                        str2 = this.servedDateString;
                    }
                    str = "If-Modified-Since";
                }
                u.a a3 = this.request.getHeaders().a();
                Intrinsics.checkNotNull(str2);
                a3.b(str, str2);
                return new b(this.request.h().a(a3.a()).a(), this.cacheResponse);
            }
            return new b(this.request, null);
        }

        private final long d() {
            d0 d0Var = this.cacheResponse;
            Intrinsics.checkNotNull(d0Var);
            if (d0Var.e().getMaxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.getMaxAgeSeconds());
            }
            Date date = this.expires;
            if (date != null) {
                Date date2 = this.servedDate;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified == null || this.cacheResponse.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().i().m() != null) {
                return 0L;
            }
            Date date3 = this.servedDate;
            long time2 = date3 != null ? date3.getTime() : this.sentRequestMillis;
            Date date4 = this.lastModified;
            Intrinsics.checkNotNull(date4);
            long time3 = time2 - date4.getTime();
            if (time3 > 0) {
                return time3 / 10;
            }
            return 0L;
        }

        private final boolean e() {
            d0 d0Var = this.cacheResponse;
            Intrinsics.checkNotNull(d0Var);
            return d0Var.e().getMaxAgeSeconds() == -1 && this.expires == null;
        }

        public final b b() {
            b c = c();
            return (c.getNetworkRequest() == null || !this.request.c().getOnlyIfCached()) ? c : new b(null, null);
        }

        private final boolean a(b0 request) {
            return (request.a("If-Modified-Since") == null && request.a(HttpRequest.HEADER_IF_NONE_MATCH) == null) ? false : true;
        }
    }

    public b(b0 b0Var, d0 d0Var) {
        this.networkRequest = b0Var;
        this.cacheResponse = d0Var;
    }

    /* renamed from: a, reason: from getter */
    public final d0 getCacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: b, reason: from getter */
    public final b0 getNetworkRequest() {
        return this.networkRequest;
    }
}
