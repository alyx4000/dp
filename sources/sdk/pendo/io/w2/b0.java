package sdk.pendo.io.w2;

import androidx.exifinterface.media.ExifInterface;
import com.extole.android.sdk.impl.http.HttpRequest;
import io.sentry.SentryBaseEvent;
import io.sentry.protocol.Request;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.w2.u;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004BC\b\u0000\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c\u0012\u0016\u0010%\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0004\b/\u00100J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002J%\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00072\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b¢\u0006\u0004\b\u0004\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\u000f\u0010\u0004\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0004\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0011\u001a\u00020\r8\u0007¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00178\u0007¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R*\u0010%\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00010!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u001d\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0011\u0010,\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b'\u0010+R\u0011\u0010-\u001a\u00020&8G¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00061"}, d2 = {"Lsdk/pendo/io/w2/b0;", "", "", "name", "a", "", "b", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lsdk/pendo/io/w2/b0$a;", "h", "Lsdk/pendo/io/w2/v;", "()Lsdk/pendo/io/w2/v;", "toString", "Lsdk/pendo/io/w2/v;", "url", "()Lokhttp3/HttpUrl;", "Ljava/lang/String;", "g", "()Ljava/lang/String;", Request.JsonKeys.METHOD, "Lsdk/pendo/io/w2/u;", "c", "Lsdk/pendo/io/w2/u;", "headers", "()Lokhttp3/Headers;", "Lsdk/pendo/io/w2/c0;", "d", "Lsdk/pendo/io/w2/c0;", "body", "()Lokhttp3/RequestBody;", "", "e", "Ljava/util/Map;", "()Ljava/util/Map;", "tags", "Lsdk/pendo/io/w2/d;", "f", "Lsdk/pendo/io/w2/d;", "lazyCacheControl", "", "()Z", "isHttps", "cacheControl", "()Lokhttp3/CacheControl;", "<init>", "(Lokhttp3/HttpUrl;Ljava/lang/String;Lokhttp3/Headers;Lokhttp3/RequestBody;Ljava/util/Map;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final v url;

    /* renamed from: b, reason: from kotlin metadata */
    private final String method;

    /* renamed from: c, reason: from kotlin metadata */
    private final u headers;

    /* renamed from: d, reason: from kotlin metadata */
    private final c0 body;

    /* renamed from: e, reason: from kotlin metadata */
    private final Map<Class<?>, Object> tags;

    /* renamed from: f, reason: from kotlin metadata */
    private d lazyCacheControl;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010%\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u00105\u001a\u00020\u0010¢\u0006\u0004\b6\u00107B\t\b\u0016¢\u0006\u0004\b6\u00108J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0018\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0005H\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0004\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0004\u001a\u00020\u0010H\u0016J/\u0010\u0014\u001a\u00020\u0000\"\u0004\b\u0000\u0010\u00112\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00122\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\r\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010\n\u001a\u00020 8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R2\u00104\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0012\u0012\u0004\u0012\u00020\u00010-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u00069"}, d2 = {"Lsdk/pendo/io/w2/b0$a;", "", "Lsdk/pendo/io/w2/v;", "url", "a", "", "b", "name", "value", "Lsdk/pendo/io/w2/u;", "headers", "Lsdk/pendo/io/w2/d;", "cacheControl", Request.JsonKeys.METHOD, "Lsdk/pendo/io/w2/c0;", "body", "Lsdk/pendo/io/w2/b0;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/Class;", "type", ViewHierarchyNode.JsonKeys.TAG, "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Lsdk/pendo/io/w2/v;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "Ljava/lang/String;", "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "Lsdk/pendo/io/w2/u$a;", "c", "Lsdk/pendo/io/w2/u$a;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "d", "Lsdk/pendo/io/w2/c0;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "", "e", "Ljava/util/Map;", "getTags$okhttp", "()Ljava/util/Map;", "setTags$okhttp", "(Ljava/util/Map;)V", "tags", SentryBaseEvent.JsonKeys.REQUEST, "<init>", "(Lokhttp3/Request;)V", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private v url;

        /* renamed from: b, reason: from kotlin metadata */
        private String method;

        /* renamed from: c, reason: from kotlin metadata */
        private u.a headers;

        /* renamed from: d, reason: from kotlin metadata */
        private c0 body;

        /* renamed from: e, reason: from kotlin metadata */
        private Map<Class<?>, Object> tags;

        public a() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new u.a();
        }

        public a a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.a(name, value);
            return this;
        }

        public a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.c(name, value);
            return this;
        }

        public a(b0 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.tags = new LinkedHashMap();
            this.url = request.i();
            this.method = request.getMethod();
            this.body = request.getBody();
            this.tags = request.d().isEmpty() ? new LinkedHashMap<>() : MapsKt.toMutableMap(request.d());
            this.headers = request.getHeaders().a();
        }

        public b0 a() {
            v vVar = this.url;
            if (vVar != null) {
                return new b0(vVar, this.method, this.headers.a(), this.body, sdk.pendo.io.x2.b.a(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a b(String url) {
            StringBuilder sb;
            int i;
            Intrinsics.checkNotNullParameter(url, "url");
            if (!StringsKt.startsWith(url, "ws:", true)) {
                if (StringsKt.startsWith(url, "wss:", true)) {
                    sb = new StringBuilder("https:");
                    i = 4;
                }
                return a(v.INSTANCE.b(url));
            }
            sb = new StringBuilder("http:");
            i = 3;
            String substring = url.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            url = sb.append(substring).toString();
            return a(v.INSTANCE.b(url));
        }

        public a a(d cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            String dVar = cacheControl.toString();
            return dVar.length() == 0 ? a(HttpRequest.HEADER_CACHE_CONTROL) : b(HttpRequest.HEADER_CACHE_CONTROL, dVar);
        }

        public a a(u headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers.a();
            return this;
        }

        public a a(String method, c0 body) {
            Intrinsics.checkNotNullParameter(method, "method");
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (body == null) {
                if (!(true ^ sdk.pendo.io.c3.f.d(method))) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!sdk.pendo.io.c3.f.a(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            this.method = method;
            this.body = body;
            return this;
        }

        public a a(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.headers.b(name);
            return this;
        }

        public <T> a a(Class<? super T> type, T t) {
            Intrinsics.checkNotNullParameter(type, "type");
            if (t == null) {
                this.tags.remove(type);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.tags;
                T cast = type.cast(t);
                Intrinsics.checkNotNull(cast);
                map.put(type, cast);
            }
            return this;
        }

        public a a(v url) {
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            return this;
        }
    }

    public b0(v url, String method, u headers, c0 c0Var, Map<Class<?>, ? extends Object> tags) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.body = c0Var;
        this.tags = tags;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))
    /* renamed from: a, reason: from getter */
    public final v getUrl() {
        return this.url;
    }

    /* renamed from: b, reason: from getter */
    public final c0 getBody() {
        return this.body;
    }

    public final d c() {
        d dVar = this.lazyCacheControl;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.INSTANCE.a(this.headers);
        this.lazyCacheControl = a2;
        return a2;
    }

    public final Map<Class<?>, Object> d() {
        return this.tags;
    }

    /* renamed from: e, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    public final boolean f() {
        return this.url.getIsHttps();
    }

    /* renamed from: g, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public final a h() {
        return new a(this);
    }

    public final v i() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.method);
        sb.append(", url=");
        sb.append(this.url);
        if (this.headers.size() != 0) {
            sb.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String component1 = pair2.component1();
                String component2 = pair2.component2();
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(component1);
                sb.append(':');
                sb.append(component2);
                i = i2;
            }
            sb.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb.append(", tags=");
            sb.append(this.tags);
        }
        sb.append('}');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String a(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.headers.a(name);
    }

    public final List<String> b(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.headers.b(name);
    }

    public final <T> T a(Class<? extends T> type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return type.cast(this.tags.get(type));
    }
}
