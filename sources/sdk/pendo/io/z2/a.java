package sdk.pendo.io.z2;

import com.extole.android.sdk.impl.http.HttpRequest;
import io.sentry.protocol.Response;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.w2.a0;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.w2.r;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.w;
import sdk.pendo.io.z2.b;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"Lsdk/pendo/io/z2/a;", "Lsdk/pendo/io/w2/w;", "Lsdk/pendo/io/w2/w$a;", "chain", "Lsdk/pendo/io/w2/d0;", "a", "Lsdk/pendo/io/w2/c;", "cache", "<init>", "(Lokhttp3/Cache;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class a implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u0004\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/z2/a$a;", "", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "a", "Lsdk/pendo/io/w2/u;", "cachedHeaders", "networkHeaders", "", "fieldName", "", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.z2.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(String fieldName) {
            return (StringsKt.equals("Connection", fieldName, true) || StringsKt.equals("Keep-Alive", fieldName, true) || StringsKt.equals("Proxy-Authenticate", fieldName, true) || StringsKt.equals("Proxy-Authorization", fieldName, true) || StringsKt.equals("TE", fieldName, true) || StringsKt.equals("Trailers", fieldName, true) || StringsKt.equals("Transfer-Encoding", fieldName, true) || StringsKt.equals("Upgrade", fieldName, true)) ? false : true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final u a(u cachedHeaders, u networkHeaders) {
            u.a aVar = new u.a();
            int size = cachedHeaders.size();
            for (int i = 0; i < size; i++) {
                String a2 = cachedHeaders.a(i);
                String b = cachedHeaders.b(i);
                if ((!StringsKt.equals("Warning", a2, true) || !StringsKt.startsWith$default(b, "1", false, 2, (Object) null)) && (a(a2) || !b(a2) || networkHeaders.a(a2) == null)) {
                    aVar.b(a2, b);
                }
            }
            int size2 = networkHeaders.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String a3 = networkHeaders.a(i2);
                if (!a(a3) && b(a3)) {
                    aVar.b(a3, networkHeaders.b(i2));
                }
            }
            return aVar.a();
        }

        private final boolean a(String fieldName) {
            return StringsKt.equals(HttpRequest.HEADER_CONTENT_LENGTH, fieldName, true) || StringsKt.equals(HttpRequest.HEADER_CONTENT_ENCODING, fieldName, true) || StringsKt.equals(HttpRequest.HEADER_CONTENT_TYPE, fieldName, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final d0 a(d0 response) {
            return (response != null ? response.b() : null) != null ? response.v().a((e0) null).a() : response;
        }
    }

    public a(c cVar) {
    }

    @Override // sdk.pendo.io.w2.w
    public d0 a(w.a chain) {
        r rVar;
        Intrinsics.checkNotNullParameter(chain, "chain");
        e call = chain.call();
        b b = new b.C0279b(System.currentTimeMillis(), chain.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String(), null).b();
        b0 networkRequest = b.getNetworkRequest();
        d0 cacheResponse = b.getCacheResponse();
        sdk.pendo.io.b3.e eVar = call instanceof sdk.pendo.io.b3.e ? (sdk.pendo.io.b3.e) call : null;
        if (eVar == null || (rVar = eVar.getEventListener()) == null) {
            rVar = r.b;
        }
        if (networkRequest == null && cacheResponse == null) {
            d0 a2 = new d0.a().a(chain.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String()).a(a0.HTTP_1_1).a(HttpServletResponse.SC_GATEWAY_TIMEOUT).a("Unsatisfiable Request (only-if-cached)").a(sdk.pendo.io.x2.b.c).b(-1L).a(System.currentTimeMillis()).a();
            rVar.d(call, a2);
            return a2;
        }
        if (networkRequest == null) {
            Intrinsics.checkNotNull(cacheResponse);
            d0 a3 = cacheResponse.v().a(INSTANCE.a(cacheResponse)).a();
            rVar.b(call, a3);
            return a3;
        }
        if (cacheResponse != null) {
            rVar.a(call, cacheResponse);
        }
        d0 a4 = chain.a(networkRequest);
        if (cacheResponse != null) {
            if (a4 != null && a4.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() == 304) {
                d0.a v = cacheResponse.v();
                Companion companion = INSTANCE;
                v.a(companion.a(cacheResponse.getHeaders(), a4.getHeaders())).b(a4.getSentRequestAtMillis()).a(a4.getReceivedResponseAtMillis()).a(companion.a(cacheResponse)).c(companion.a(a4)).a();
                e0 b2 = a4.b();
                Intrinsics.checkNotNull(b2);
                b2.close();
                Intrinsics.checkNotNull(null);
                throw null;
            }
            e0 b3 = cacheResponse.b();
            if (b3 != null) {
                sdk.pendo.io.x2.b.a(b3);
            }
        }
        Intrinsics.checkNotNull(a4);
        d0.a v2 = a4.v();
        Companion companion2 = INSTANCE;
        return v2.a(companion2.a(cacheResponse)).c(companion2.a(a4)).a();
    }
}
