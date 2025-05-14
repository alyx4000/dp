package sdk.pendo.io.w2;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import io.sentry.SentryBaseEvent;
import io.sentry.protocol.Response;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.Closeable;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.u;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B}\b\u0000\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010\u001e\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020\u001f\u0012\b\u0010(\u001a\u0004\u0018\u00010%\u0012\u0006\u0010-\u001a\u00020*\u0012\b\u00101\u001a\u0004\u0018\u00010\u0006\u0012\b\u00105\u001a\u0004\u0018\u00010\u0000\u0012\b\u00108\u001a\u0004\u0018\u00010\u0000\u0012\b\u0010:\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010?\u001a\u00020;\u0012\u0006\u0010B\u001a\u00020;\u0012\b\u0010F\u001a\u0004\u0018\u00010C¢\u0006\u0004\bQ\u0010RJ\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0005\u0010\u0007J\u0006\u0010\t\u001a\u00020\bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0017\u0010\u0013\u001a\u00020\u00108\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0018\u001a\u00020\u00158\u0007¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001e\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0007¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010(\u001a\u0004\u0018\u00010%8\u0007¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u0010-\u001a\u00020*8\u0007¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0019\u00101\u001a\u0004\u0018\u00010\u00068\u0007¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0019\u00105\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0019\u00108\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b7\u00104\u001a\u0004\b8\u00106R\u0019\u0010:\u001a\u0004\u0018\u00010\u00008\u0007¢\u0006\f\n\u0004\b9\u00104\u001a\u0004\b:\u00106R\u0017\u0010?\u001a\u00020;8\u0007¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b\u001a\u0010>R\u0017\u0010B\u001a\u00020;8\u0007¢\u0006\f\n\u0004\b@\u0010=\u001a\u0004\bA\u0010>R\u001c\u0010F\u001a\u0004\u0018\u00010C8\u0001X\u0080\u0004¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010GR\u0018\u0010K\u001a\u0004\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0011\u0010N\u001a\u00020L8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010MR\u0011\u0010O\u001a\u00020H8G¢\u0006\u0006\u001a\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lsdk/pendo/io/w2/d0;", "Ljava/io/Closeable;", "", "name", "defaultValue", "a", "Lsdk/pendo/io/w2/e0;", "()Lsdk/pendo/io/w2/e0;", "Lsdk/pendo/io/w2/d0$a;", "v", "", "Lsdk/pendo/io/w2/h;", "n", "", "close", "toString", "Lsdk/pendo/io/w2/b0;", "f", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "()Lokhttp3/Request;", "Lsdk/pendo/io/w2/a0;", "s", "Lsdk/pendo/io/w2/a0;", "protocol", "()Lokhttp3/Protocol;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/String;", "t", "()Ljava/lang/String;", "message", "", "f0", "I", "o", "()I", ApiConstant.KEY_CODE, "Lsdk/pendo/io/w2/t;", "t0", "Lsdk/pendo/io/w2/t;", "handshake", "()Lokhttp3/Handshake;", "Lsdk/pendo/io/w2/u;", "u0", "Lsdk/pendo/io/w2/u;", "headers", "()Lokhttp3/Headers;", "v0", "Lsdk/pendo/io/w2/e0;", "body", "()Lokhttp3/ResponseBody;", "w0", "Lsdk/pendo/io/w2/d0;", "networkResponse", "()Lokhttp3/Response;", "x0", "cacheResponse", "y0", "priorResponse", "", "z0", "J", "()J", "sentRequestAtMillis", "A0", ViewHierarchyNode.JsonKeys.Y, "receivedResponseAtMillis", "Lsdk/pendo/io/b3/c;", "B0", "Lsdk/pendo/io/b3/c;", "exchange", "()Lokhttp3/internal/connection/Exchange;", "Lsdk/pendo/io/w2/d;", "C0", "Lsdk/pendo/io/w2/d;", "lazyCacheControl", "", "()Z", sdk.pendo.io.w8.a.EVENT_SUCCESS, "cacheControl", "()Lokhttp3/CacheControl;", "<init>", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class d0 implements Closeable {

    /* renamed from: A, reason: from kotlin metadata */
    private final String message;

    /* renamed from: A0, reason: from kotlin metadata */
    private final long receivedResponseAtMillis;

    /* renamed from: B0, reason: from kotlin metadata */
    private final sdk.pendo.io.b3.c exchange;

    /* renamed from: C0, reason: from kotlin metadata */
    private d lazyCacheControl;

    /* renamed from: f, reason: from kotlin metadata */
    private final b0 request;

    /* renamed from: f0, reason: from kotlin metadata */
    private final int code;

    /* renamed from: s, reason: from kotlin metadata */
    private final a0 protocol;

    /* renamed from: t0, reason: from kotlin metadata */
    private final t handshake;

    /* renamed from: u0, reason: from kotlin metadata */
    private final u headers;

    /* renamed from: v0, reason: from kotlin metadata */
    private final e0 body;

    /* renamed from: w0, reason: from kotlin metadata */
    private final d0 networkResponse;

    /* renamed from: x0, reason: from kotlin metadata */
    private final d0 cacheResponse;

    /* renamed from: y0, reason: from kotlin metadata */
    private final d0 priorResponse;

    /* renamed from: z0, reason: from kotlin metadata */
    private final long sentRequestAtMillis;

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b+\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bd\u0010MB\t\b\u0016¢\u0006\u0004\bd\u0010eJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0018\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b\u0007\u0010!J\b\u0010\u0007\u001a\u00020\u0004H\u0016R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010,\u001a\u0004\b\b\u0010-\"\u0004\b.\u0010/R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010\u0014\u001a\u00020;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bN\u0010I\u001a\u0004\bO\u0010K\"\u0004\bP\u0010MR$\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bQ\u0010I\u001a\u0004\bR\u0010K\"\u0004\bS\u0010MR\"\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010\u001e\u001a\u00020\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010W\"\u0004\b\\\u0010YR$\u0010c\u001a\u0004\u0018\u00010\u001f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010b¨\u0006f"}, d2 = {"Lsdk/pendo/io/w2/d0$a;", "", "", "name", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "", "a", "b", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "Lsdk/pendo/io/w2/a0;", "protocol", "", ApiConstant.KEY_CODE, "message", "Lsdk/pendo/io/w2/t;", "handshake", "value", "Lsdk/pendo/io/w2/u;", "headers", "Lsdk/pendo/io/w2/e0;", "body", "networkResponse", "c", "cacheResponse", "priorResponse", "d", "", "sentRequestAtMillis", "receivedResponseAtMillis", "Lsdk/pendo/io/b3/c;", "deferredTrailers", "(Lsdk/pendo/io/b3/c;)V", "Lsdk/pendo/io/w2/b0;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "Lsdk/pendo/io/w2/a0;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "I", "()I", "setCode$okhttp", "(I)V", "Ljava/lang/String;", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "e", "Lsdk/pendo/io/w2/t;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "Lsdk/pendo/io/w2/u$a;", "f", "Lsdk/pendo/io/w2/u$a;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "g", "Lsdk/pendo/io/w2/e0;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "h", "Lsdk/pendo/io/w2/d0;", "getNetworkResponse$okhttp", "()Lokhttp3/Response;", "setNetworkResponse$okhttp", "(Lokhttp3/Response;)V", ContextChain.TAG_INFRA, "getCacheResponse$okhttp", "setCacheResponse$okhttp", "j", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "k", "J", "getSentRequestAtMillis$okhttp", "()J", "setSentRequestAtMillis$okhttp", "(J)V", "l", "getReceivedResponseAtMillis$okhttp", "setReceivedResponseAtMillis$okhttp", "m", "Lsdk/pendo/io/b3/c;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "exchange", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private b0 request;

        /* renamed from: b, reason: from kotlin metadata */
        private a0 protocol;

        /* renamed from: c, reason: from kotlin metadata */
        private int code;

        /* renamed from: d, reason: from kotlin metadata */
        private String message;

        /* renamed from: e, reason: from kotlin metadata */
        private t handshake;

        /* renamed from: f, reason: from kotlin metadata */
        private u.a headers;

        /* renamed from: g, reason: from kotlin metadata */
        private e0 body;

        /* renamed from: h, reason: from kotlin metadata */
        private d0 networkResponse;

        /* renamed from: i, reason: from kotlin metadata */
        private d0 cacheResponse;

        /* renamed from: j, reason: from kotlin metadata */
        private d0 priorResponse;

        /* renamed from: k, reason: from kotlin metadata */
        private long sentRequestAtMillis;

        /* renamed from: l, reason: from kotlin metadata */
        private long receivedResponseAtMillis;

        /* renamed from: m, reason: from kotlin metadata */
        private sdk.pendo.io.b3.c exchange;

        public a() {
            this.code = -1;
            this.headers = new u.a();
        }

        private final void b(d0 response) {
            if (response != null) {
                if (!(response.b() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        public a a(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.a(name, value);
            return this;
        }

        public a c(d0 networkResponse) {
            a("networkResponse", networkResponse);
            this.networkResponse = networkResponse;
            return this;
        }

        public a d(d0 priorResponse) {
            b(priorResponse);
            this.priorResponse = priorResponse;
            return this;
        }

        public a(d0 response) {
            Intrinsics.checkNotNullParameter(response, "response");
            this.code = -1;
            this.request = response.getRequest();
            this.protocol = response.getProtocol();
            this.code = response.getCode();
            this.message = response.getMessage();
            this.handshake = response.getHandshake();
            this.headers = response.getHeaders().a();
            this.body = response.b();
            this.networkResponse = response.getNetworkResponse();
            this.cacheResponse = response.getCacheResponse();
            this.priorResponse = response.getPriorResponse();
            this.sentRequestAtMillis = response.getSentRequestAtMillis();
            this.receivedResponseAtMillis = response.getReceivedResponseAtMillis();
            this.exchange = response.getExchange();
        }

        public a a(e0 body) {
            this.body = body;
            return this;
        }

        /* renamed from: b, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        public d0 a() {
            int i = this.code;
            if (!(i >= 0)) {
                throw new IllegalStateException(("code < 0: " + this.code).toString());
            }
            b0 b0Var = this.request;
            if (b0Var == null) {
                throw new IllegalStateException("request == null".toString());
            }
            a0 a0Var = this.protocol;
            if (a0Var == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.message;
            if (str != null) {
                return new d0(b0Var, a0Var, str, i, this.handshake, this.headers.a(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a b(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            this.headers.c(name, value);
            return this;
        }

        public a a(d0 cacheResponse) {
            a("cacheResponse", cacheResponse);
            this.cacheResponse = cacheResponse;
            return this;
        }

        public a b(long sentRequestAtMillis) {
            this.sentRequestAtMillis = sentRequestAtMillis;
            return this;
        }

        private final void a(String name, d0 response) {
            if (response != null) {
                if (!(response.b() == null)) {
                    throw new IllegalArgumentException((name + ".body != null").toString());
                }
                if (!(response.getNetworkResponse() == null)) {
                    throw new IllegalArgumentException((name + ".networkResponse != null").toString());
                }
                if (!(response.getCacheResponse() == null)) {
                    throw new IllegalArgumentException((name + ".cacheResponse != null").toString());
                }
                if (!(response.getPriorResponse() == null)) {
                    throw new IllegalArgumentException((name + ".priorResponse != null").toString());
                }
            }
        }

        public a a(int code) {
            this.code = code;
            return this;
        }

        public a a(t handshake) {
            this.handshake = handshake;
            return this;
        }

        public a a(u headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.headers = headers.a();
            return this;
        }

        public final void a(sdk.pendo.io.b3.c deferredTrailers) {
            Intrinsics.checkNotNullParameter(deferredTrailers, "deferredTrailers");
            this.exchange = deferredTrailers;
        }

        public a a(String message) {
            Intrinsics.checkNotNullParameter(message, "message");
            this.message = message;
            return this;
        }

        public a a(a0 protocol) {
            Intrinsics.checkNotNullParameter(protocol, "protocol");
            this.protocol = protocol;
            return this;
        }

        public a a(long receivedResponseAtMillis) {
            this.receivedResponseAtMillis = receivedResponseAtMillis;
            return this;
        }

        public a a(b0 request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.request = request;
            return this;
        }
    }

    public d0(b0 request, a0 protocol, String message, int i, t tVar, u headers, e0 e0Var, d0 d0Var, d0 d0Var2, d0 d0Var3, long j, long j2, sdk.pendo.io.b3.c cVar) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.request = request;
        this.protocol = protocol;
        this.message = message;
        this.code = i;
        this.handshake = tVar;
        this.headers = headers;
        this.body = e0Var;
        this.networkResponse = d0Var;
        this.cacheResponse = d0Var2;
        this.priorResponse = d0Var3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = cVar;
    }

    /* renamed from: A, reason: from getter */
    public final long getSentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))
    /* renamed from: a, reason: from getter */
    public final e0 getBody() {
        return this.body;
    }

    public final e0 b() {
        return this.body;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        e0 e0Var = this.body;
        if (e0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        e0Var.close();
    }

    public final d e() {
        d dVar = this.lazyCacheControl;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.INSTANCE.a(this.headers);
        this.lazyCacheControl = a2;
        return a2;
    }

    /* renamed from: m, reason: from getter */
    public final d0 getCacheResponse() {
        return this.cacheResponse;
    }

    public final List<h> n() {
        String str;
        u uVar = this.headers;
        int i = this.code;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                return CollectionsKt.emptyList();
            }
            str = "Proxy-Authenticate";
        }
        return sdk.pendo.io.c3.e.a(uVar, str);
    }

    /* renamed from: o, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: p, reason: from getter */
    public final sdk.pendo.io.b3.c getExchange() {
        return this.exchange;
    }

    /* renamed from: q, reason: from getter */
    public final t getHandshake() {
        return this.handshake;
    }

    /* renamed from: r, reason: from getter */
    public final u getHeaders() {
        return this.headers;
    }

    public final boolean s() {
        int i = this.code;
        return 200 <= i && i < 300;
    }

    /* renamed from: t, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.i() + '}';
    }

    /* renamed from: u, reason: from getter */
    public final d0 getNetworkResponse() {
        return this.networkResponse;
    }

    public final a v() {
        return new a(this);
    }

    /* renamed from: w, reason: from getter */
    public final d0 getPriorResponse() {
        return this.priorResponse;
    }

    /* renamed from: x, reason: from getter */
    public final a0 getProtocol() {
        return this.protocol;
    }

    /* renamed from: y, reason: from getter */
    public final long getReceivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* renamed from: z, reason: from getter */
    public final b0 getRequest() {
        return this.request;
    }

    public final String a(String name, String defaultValue) {
        Intrinsics.checkNotNullParameter(name, "name");
        String a2 = this.headers.a(name);
        return a2 == null ? defaultValue : a2;
    }

    public static /* synthetic */ String a(d0 d0Var, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return d0Var.a(str, str2);
    }
}
