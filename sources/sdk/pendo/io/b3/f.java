package sdk.pendo.io.b3;

import androidx.core.app.NotificationCompat;
import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.perf.FirebasePerformance;
import io.sentry.SentryLockReason;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import okhttp3.internal.connection.RealConnection;
import sdk.pendo.io.e3.f;
import sdk.pendo.io.e3.m;
import sdk.pendo.io.j3.d;
import sdk.pendo.io.k3.o;
import sdk.pendo.io.w2.a0;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.f0;
import sdk.pendo.io.w2.l;
import sdk.pendo.io.w2.r;
import sdk.pendo.io.w2.t;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.z;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\n\u0018\u0000 |2\u00020\u00012\u00020\u0002:\u0001\fB\u0017\u0012\u0006\u0010G\u001a\u00020C\u0012\u0006\u0010I\u001a\u00020\u0016¢\u0006\u0004\bz\u0010{J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J*\u0010\f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0016\u0010\f\u001a\u00020\u00182\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002J\u0010\u0010\f\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\f\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u000f\u0010\u001b\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\u001e\u0010\u001cJ>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ'\u0010\f\u001a\u00020\u00182\u0006\u0010!\u001a\u00020 2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0000¢\u0006\u0004\b\f\u0010#J\u001f\u0010\f\u001a\u00020(2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0000¢\u0006\u0004\b\f\u0010)J\u0017\u0010\f\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\b\f\u0010-J\b\u0010.\u001a\u00020\u0016H\u0016J\u0006\u0010/\u001a\u00020\u000bJ\b\u00101\u001a\u000200H\u0016J\u000e\u0010\f\u001a\u00020\u00182\u0006\u00102\u001a\u00020\u0018J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u00104\u001a\u000203H\u0016J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u000207H\u0016J\n\u00109\u001a\u0004\u0018\u00010\u0019H\u0016J'\u0010\f\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020$2\u0006\u0010:\u001a\u00020\u00162\u0006\u0010<\u001a\u00020;H\u0000¢\u0006\u0004\b\f\u0010=J!\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020>2\b\u0010\u0014\u001a\u0004\u0018\u00010;H\u0000¢\u0006\u0004\b\f\u0010?J\b\u0010\f\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020AH\u0016R\u0017\u0010G\u001a\u00020C8\u0006¢\u0006\f\n\u0004\b1\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010HR\u0018\u0010K\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010JR\u0018\u0010M\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010JR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010U\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010WR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\"\u0010`\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010]\u001a\u0004\bP\u0010^\"\u0004\b9\u0010_R\u0016\u0010a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010]R\"\u0010f\u001a\u00020\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010b\u001a\u0004\bS\u0010c\"\u0004\bd\u0010eR\u0016\u0010h\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010bR\u0016\u0010j\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010bR\u0016\u0010l\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010bR#\u0010r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0n0m8\u0006¢\u0006\f\n\u0004\bo\u0010p\u001a\u0004\bL\u0010qR\"\u0010x\u001a\u00020s8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bN\u0010v\"\u0004\b\f\u0010wR\u0014\u0010y\u001a\u00020\u00188@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010^¨\u0006}"}, d2 = {"Lsdk/pendo/io/b3/f;", "Lsdk/pendo/io/e3/f$c;", "Lsdk/pendo/io/w2/j;", "", "connectTimeout", "readTimeout", "writeTimeout", "Lsdk/pendo/io/w2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/r;", "eventListener", "", "a", "Lsdk/pendo/io/b3/b;", "connectionSpecSelector", "pingIntervalMillis", "Lsdk/pendo/io/w2/b0;", "tunnelRequest", "Lsdk/pendo/io/w2/v;", "url", "e", "", "Lsdk/pendo/io/w2/f0;", "candidates", "", "Lsdk/pendo/io/w2/t;", "handshake", "m", "()V", "l", "j", "connectionRetryEnabled", "Lsdk/pendo/io/w2/a;", SentryLockReason.JsonKeys.ADDRESS, "routes", "(Lsdk/pendo/io/w2/a;Ljava/util/List;)Z", "Lsdk/pendo/io/w2/z;", "client", "Lsdk/pendo/io/c3/g;", "chain", "Lsdk/pendo/io/c3/d;", "(Lsdk/pendo/io/w2/z;Lsdk/pendo/io/c3/g;)Lsdk/pendo/io/c3/d;", "Lsdk/pendo/io/b3/c;", "exchange", "Lsdk/pendo/io/j3/d$d;", "(Lsdk/pendo/io/b3/c;)Lsdk/pendo/io/j3/d$d;", "n", "d", "Ljava/net/Socket;", "c", "doExtensiveChecks", "Lsdk/pendo/io/e3/i;", "stream", "Lsdk/pendo/io/e3/f;", "connection", "Lsdk/pendo/io/e3/m;", "settings", "b", "failedRoute", "Ljava/io/IOException;", "failure", "(Lsdk/pendo/io/w2/z;Lsdk/pendo/io/w2/f0;Ljava/io/IOException;)V", "Lsdk/pendo/io/b3/e;", "(Lsdk/pendo/io/b3/e;Ljava/io/IOException;)V", "Lsdk/pendo/io/w2/a0;", "", "toString", "Lsdk/pendo/io/b3/g;", "Lsdk/pendo/io/b3/g;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lsdk/pendo/io/w2/f0;", "route", "Ljava/net/Socket;", "rawSocket", "f", "socket", "g", "Lsdk/pendo/io/w2/t;", "h", "Lsdk/pendo/io/w2/a0;", "protocol", ContextChain.TAG_INFRA, "Lsdk/pendo/io/e3/f;", "http2Connection", "Lsdk/pendo/io/k3/f;", "Lsdk/pendo/io/k3/f;", "source", "Lsdk/pendo/io/k3/e;", "k", "Lsdk/pendo/io/k3/e;", "sink", "Z", "()Z", "(Z)V", "noNewExchanges", "noCoalescedConnections", "I", "()I", "setRouteFailureCount$okhttp", "(I)V", "routeFailureCount", "o", "successCount", ContextChain.TAG_PRODUCT, "refusedStreamCount", "q", "allocationLimit", "", "Ljava/lang/ref/Reference;", "r", "Ljava/util/List;", "()Ljava/util/List;", "calls", "", "s", "J", "()J", "(J)V", "idleAtNs", "isMultiplexed", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "t", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class f extends f.c implements sdk.pendo.io.w2.j {

    /* renamed from: c, reason: from kotlin metadata */
    private final g connectionPool;

    /* renamed from: d, reason: from kotlin metadata */
    private final f0 route;

    /* renamed from: e, reason: from kotlin metadata */
    private Socket rawSocket;

    /* renamed from: f, reason: from kotlin metadata */
    private Socket socket;

    /* renamed from: g, reason: from kotlin metadata */
    private t handshake;

    /* renamed from: h, reason: from kotlin metadata */
    private a0 protocol;

    /* renamed from: i, reason: from kotlin metadata */
    private sdk.pendo.io.e3.f http2Connection;

    /* renamed from: j, reason: from kotlin metadata */
    private sdk.pendo.io.k3.f source;

    /* renamed from: k, reason: from kotlin metadata */
    private sdk.pendo.io.k3.e sink;

    /* renamed from: l, reason: from kotlin metadata */
    private boolean noNewExchanges;

    /* renamed from: m, reason: from kotlin metadata */
    private boolean noCoalescedConnections;

    /* renamed from: n, reason: from kotlin metadata */
    private int routeFailureCount;

    /* renamed from: o, reason: from kotlin metadata */
    private int successCount;

    /* renamed from: p, reason: from kotlin metadata */
    private int refusedStreamCount;

    /* renamed from: q, reason: from kotlin metadata */
    private int allocationLimit;

    /* renamed from: r, reason: from kotlin metadata */
    private final List<Reference<sdk.pendo.io.b3.e>> calls;

    /* renamed from: s, reason: from kotlin metadata */
    private long idleAtNs;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f891a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            try {
                iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Proxy.Type.HTTP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f891a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/Certificate;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class c extends Lambda implements Function0<List<? extends Certificate>> {
        final /* synthetic */ sdk.pendo.io.w2.a A;
        final /* synthetic */ sdk.pendo.io.w2.g f;
        final /* synthetic */ t s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(sdk.pendo.io.w2.g gVar, t tVar, sdk.pendo.io.w2.a aVar) {
            super(0);
            this.f = gVar;
            this.s = tVar;
            this.A = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Certificate> invoke() {
            sdk.pendo.io.i3.c certificateChainCleaner = this.f.getCertificateChainCleaner();
            Intrinsics.checkNotNull(certificateChainCleaner);
            return certificateChainCleaner.a(this.s.c(), this.A.getUrl().getHost());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/security/cert/X509Certificate;", "a", "()Ljava/util/List;"}, k = 3, mv = {1, 8, 0})
    static final class d extends Lambda implements Function0<List<? extends X509Certificate>> {
        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<X509Certificate> invoke() {
            t tVar = f.this.handshake;
            Intrinsics.checkNotNull(tVar);
            List<Certificate> c = tVar.c();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(c, 10));
            for (Certificate certificate : c) {
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0004"}, d2 = {"sdk/pendo/io/b3/f$e", "Lsdk/pendo/io/j3/d$d;", "", "close", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class e extends d.AbstractC0159d {
        final /* synthetic */ sdk.pendo.io.b3.c f0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(sdk.pendo.io.k3.f fVar, sdk.pendo.io.k3.e eVar, sdk.pendo.io.b3.c cVar) {
            super(true, fVar, eVar);
            this.f0 = cVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f0.a(-1L, true, true, null);
        }
    }

    public f(g connectionPool, f0 route) {
        Intrinsics.checkNotNullParameter(connectionPool, "connectionPool");
        Intrinsics.checkNotNullParameter(route, "route");
        this.connectionPool = connectionPool;
        this.route = route;
        this.allocationLimit = 1;
        this.calls = new ArrayList();
        this.idleAtNs = Long.MAX_VALUE;
    }

    private final b0 e() {
        b0 a2 = new b0.a().a(this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl()).a(FirebasePerformance.HttpMethod.CONNECT, (c0) null).b("Host", sdk.pendo.io.x2.b.a(this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl(), true)).b("Proxy-Connection", "Keep-Alive").b("User-Agent", "okhttp/4.12.0").a();
        b0 a3 = this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getProxyAuthenticator().a(this.route, new d0.a().a(a2).a(a0.HTTP_1_1).a(HttpServletResponse.SC_PROXY_AUTHENTICATION_REQUIRED).a("Preemptive Authenticate").a(sdk.pendo.io.x2.b.c).b(-1L).a(-1L).b("Proxy-Authenticate", "OkHttp-Preemptive").a());
        return a3 == null ? a2 : a3;
    }

    @Override // sdk.pendo.io.w2.j
    /* renamed from: b, reason: from getter */
    public t getHandshake() {
        return this.handshake;
    }

    @Override // sdk.pendo.io.w2.j
    public Socket c() {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        return socket;
    }

    public final void d() {
        Socket socket = this.rawSocket;
        if (socket != null) {
            sdk.pendo.io.x2.b.a(socket);
        }
    }

    public final List<Reference<sdk.pendo.io.b3.e>> f() {
        return this.calls;
    }

    /* renamed from: g, reason: from getter */
    public final long getIdleAtNs() {
        return this.idleAtNs;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    /* renamed from: i, reason: from getter */
    public final int getRouteFailureCount() {
        return this.routeFailureCount;
    }

    public final synchronized void j() {
        this.successCount++;
    }

    public final boolean k() {
        return this.http2Connection != null;
    }

    public final synchronized void l() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void m() {
        this.noNewExchanges = true;
    }

    /* renamed from: n, reason: from getter */
    public f0 getRoute() {
        return this.route;
    }

    public String toString() {
        Object obj;
        StringBuilder append = new StringBuilder("Connection{").append(this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl().getHost()).append(':').append(this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl().getPort()).append(", proxy=").append(this.route.getProxy()).append(" hostAddress=").append(this.route.getSocketAddress()).append(" cipherSuite=");
        t tVar = this.handshake;
        if (tVar == null || (obj = tVar.getCipherSuite()) == null) {
            obj = "none";
        }
        return append.append(obj).append(" protocol=").append(this.protocol).append('}').toString();
    }

    private final boolean a(v url, t handshake) {
        List<Certificate> c2 = handshake.c();
        if (!c2.isEmpty()) {
            sdk.pendo.io.i3.d dVar = sdk.pendo.io.i3.d.f1203a;
            String host = url.getHost();
            Certificate certificate = c2.get(0);
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (dVar.a(host, (X509Certificate) certificate)) {
                return true;
            }
        }
        return false;
    }

    public final void b(boolean z) {
        this.noNewExchanges = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x014b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(int r17, int r18, int r19, int r20, boolean r21, sdk.pendo.io.w2.e r22, sdk.pendo.io.w2.r r23) {
        /*
            Method dump skipped, instructions count: 357
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b3.f.a(int, int, int, int, boolean, sdk.pendo.io.w2.e, sdk.pendo.io.w2.r):void");
    }

    public final void a(z client, f0 failedRoute, IOException failure) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(failedRoute, "failedRoute");
        Intrinsics.checkNotNullParameter(failure, "failure");
        if (failedRoute.getProxy().type() != Proxy.Type.DIRECT) {
            sdk.pendo.io.w2.a aVar = failedRoute.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String();
            aVar.getProxySelector().connectFailed(aVar.getUrl().p(), failedRoute.getProxy().address(), failure);
        }
        client.getRouteDatabase().b(failedRoute);
    }

    private final void a(int connectTimeout, int readTimeout, sdk.pendo.io.w2.e call, r eventListener) {
        Socket createSocket;
        Proxy proxy = this.route.getProxy();
        sdk.pendo.io.w2.a aVar = this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String();
        Proxy.Type type = proxy.type();
        int i = type == null ? -1 : b.f891a[type.ordinal()];
        if (i == 1 || i == 2) {
            createSocket = aVar.getSocketFactory().createSocket();
            Intrinsics.checkNotNull(createSocket);
        } else {
            createSocket = new Socket(proxy);
        }
        this.rawSocket = createSocket;
        eventListener.a(call, this.route.getSocketAddress(), proxy);
        createSocket.setSoTimeout(readTimeout);
        try {
            sdk.pendo.io.f3.h.INSTANCE.d().a(createSocket, this.route.getSocketAddress(), connectTimeout);
            try {
                this.source = o.a(o.b(createSocket));
                this.sink = o.a(o.a(createSocket));
            } catch (NullPointerException e2) {
                if (Intrinsics.areEqual(e2.getMessage(), "throw with null exception")) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.route.getSocketAddress());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private final void a(sdk.pendo.io.b3.b connectionSpecSelector) {
        SSLSocket sSLSocket;
        sdk.pendo.io.w2.a aVar = this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String();
        SSLSocketFactory sslSocketFactory = aVar.getSslSocketFactory();
        SSLSocket sSLSocket2 = null;
        try {
            Intrinsics.checkNotNull(sslSocketFactory);
            Socket createSocket = sslSocketFactory.createSocket(this.rawSocket, aVar.getUrl().getHost(), aVar.getUrl().getPort(), true);
            Intrinsics.checkNotNull(createSocket, "null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            sSLSocket = (SSLSocket) createSocket;
        } catch (Throwable th) {
            th = th;
        }
        try {
            l a2 = connectionSpecSelector.a(sSLSocket);
            if (a2.getSupportsTlsExtensions()) {
                sdk.pendo.io.f3.h.INSTANCE.d().a(sSLSocket, aVar.getUrl().getHost(), aVar.e());
            }
            sSLSocket.startHandshake();
            SSLSession sslSocketSession = sSLSocket.getSession();
            t.Companion companion = t.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(sslSocketSession, "sslSocketSession");
            t a3 = companion.a(sslSocketSession);
            HostnameVerifier hostnameVerifier = aVar.getHostnameVerifier();
            Intrinsics.checkNotNull(hostnameVerifier);
            if (!hostnameVerifier.verify(aVar.getUrl().getHost(), sslSocketSession)) {
                List<Certificate> c2 = a3.c();
                if (!(!c2.isEmpty())) {
                    throw new SSLPeerUnverifiedException("Hostname " + aVar.getUrl().getHost() + " not verified (no certificates)");
                }
                Certificate certificate = c2.get(0);
                Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                X509Certificate x509Certificate = (X509Certificate) certificate;
                throw new SSLPeerUnverifiedException(StringsKt.trimMargin$default("\n              |Hostname " + aVar.getUrl().getHost() + " not verified:\n              |    certificate: " + sdk.pendo.io.w2.g.INSTANCE.a((Certificate) x509Certificate) + "\n              |    DN: " + x509Certificate.getSubjectDN().getName() + "\n              |    subjectAltNames: " + sdk.pendo.io.i3.d.f1203a.a(x509Certificate) + "\n              ", null, 1, null));
            }
            sdk.pendo.io.w2.g certificatePinner = aVar.getCertificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            this.handshake = new t(a3.getTlsVersion(), a3.getCipherSuite(), a3.b(), new c(certificatePinner, a3, aVar));
            certificatePinner.a(aVar.getUrl().getHost(), new d());
            String b2 = a2.getSupportsTlsExtensions() ? sdk.pendo.io.f3.h.INSTANCE.d().b(sSLSocket) : null;
            this.socket = sSLSocket;
            this.source = o.a(o.b(sSLSocket));
            this.sink = o.a(o.a(sSLSocket));
            this.protocol = b2 != null ? a0.INSTANCE.a(b2) : a0.HTTP_1_1;
            sdk.pendo.io.f3.h.INSTANCE.d().a(sSLSocket);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                sdk.pendo.io.f3.h.INSTANCE.d().a(sSLSocket2);
            }
            if (sSLSocket2 != null) {
                sdk.pendo.io.x2.b.a((Socket) sSLSocket2);
            }
            throw th;
        }
    }

    private final void a(int connectTimeout, int readTimeout, int writeTimeout, sdk.pendo.io.w2.e call, r eventListener) {
        b0 e2 = e();
        v i = e2.i();
        for (int i2 = 0; i2 < 21; i2++) {
            a(connectTimeout, readTimeout, call, eventListener);
            e2 = a(readTimeout, writeTimeout, e2, i);
            if (e2 == null) {
                return;
            }
            Socket socket = this.rawSocket;
            if (socket != null) {
                sdk.pendo.io.x2.b.a(socket);
            }
            this.rawSocket = null;
            this.sink = null;
            this.source = null;
            eventListener.a(call, this.route.getSocketAddress(), this.route.getProxy(), null);
        }
    }

    private final b0 a(int readTimeout, int writeTimeout, b0 tunnelRequest, v url) {
        String str = "CONNECT " + sdk.pendo.io.x2.b.a(url, true) + " HTTP/1.1";
        while (true) {
            sdk.pendo.io.k3.f fVar = this.source;
            Intrinsics.checkNotNull(fVar);
            sdk.pendo.io.k3.e eVar = this.sink;
            Intrinsics.checkNotNull(eVar);
            sdk.pendo.io.d3.b bVar = new sdk.pendo.io.d3.b(null, this, fVar, eVar);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            fVar.getTimeout().a(readTimeout, timeUnit);
            eVar.getTimeout().a(writeTimeout, timeUnit);
            bVar.a(tunnelRequest.getHeaders(), str);
            bVar.a();
            d0.a a2 = bVar.a(false);
            Intrinsics.checkNotNull(a2);
            d0 a3 = a2.a(tunnelRequest).a();
            bVar.d(a3);
            int i = a3.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String();
            if (i == 200) {
                if (fVar.getBufferField().i() && eVar.getBufferField().i()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (i != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + a3.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String());
            }
            b0 a4 = this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getProxyAuthenticator().a(this.route, a3);
            if (a4 == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if (StringsKt.equals("close", d0.a(a3, "Connection", null, 2, null), true)) {
                return a4;
            }
            tunnelRequest = a4;
        }
    }

    private final void a(sdk.pendo.io.b3.b connectionSpecSelector, int pingIntervalMillis, sdk.pendo.io.w2.e call, r eventListener) {
        if (this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getSslSocketFactory() != null) {
            eventListener.h(call);
            a(connectionSpecSelector);
            eventListener.a(call, this.handshake);
            if (this.protocol == a0.HTTP_2) {
                a(pingIntervalMillis);
                return;
            }
            return;
        }
        List<a0> e2 = this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().e();
        a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
        if (!e2.contains(a0Var)) {
            this.socket = this.rawSocket;
            this.protocol = a0.HTTP_1_1;
        } else {
            this.socket = this.rawSocket;
            this.protocol = a0Var;
            a(pingIntervalMillis);
        }
    }

    public final boolean a(sdk.pendo.io.w2.a address, List<f0> routes) {
        Intrinsics.checkNotNullParameter(address, "address");
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().a(address)) {
            return false;
        }
        if (Intrinsics.areEqual(address.getUrl().getHost(), getRoute().getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl().getHost())) {
            return true;
        }
        if (this.http2Connection == null || routes == null || !a(routes) || address.getHostnameVerifier() != sdk.pendo.io.i3.d.f1203a || !a(address.getUrl())) {
            return false;
        }
        try {
            sdk.pendo.io.w2.g certificatePinner = address.getCertificatePinner();
            Intrinsics.checkNotNull(certificatePinner);
            String host = address.getUrl().getHost();
            t handshake = getHandshake();
            Intrinsics.checkNotNull(handshake);
            certificatePinner.a(host, handshake.c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public final boolean a(boolean doExtensiveChecks) {
        long j;
        if (sdk.pendo.io.x2.b.h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
        }
        long nanoTime = System.nanoTime();
        Socket socket = this.rawSocket;
        Intrinsics.checkNotNull(socket);
        Socket socket2 = this.socket;
        Intrinsics.checkNotNull(socket2);
        sdk.pendo.io.k3.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        sdk.pendo.io.e3.f fVar2 = this.http2Connection;
        if (fVar2 != null) {
            return fVar2.h(nanoTime);
        }
        synchronized (this) {
            j = nanoTime - this.idleAtNs;
        }
        if (j < RealConnection.IDLE_CONNECTION_HEALTHY_NS || !doExtensiveChecks) {
            return true;
        }
        return sdk.pendo.io.x2.b.a(socket2, fVar);
    }

    public final sdk.pendo.io.c3.d a(z client, sdk.pendo.io.c3.g chain) {
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(chain, "chain");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        sdk.pendo.io.k3.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        sdk.pendo.io.k3.e eVar = this.sink;
        Intrinsics.checkNotNull(eVar);
        sdk.pendo.io.e3.f fVar2 = this.http2Connection;
        if (fVar2 != null) {
            return new sdk.pendo.io.e3.g(client, this, chain, fVar2);
        }
        socket.setSoTimeout(chain.i());
        sdk.pendo.io.k3.b0 timeout = fVar.getTimeout();
        long readTimeoutMillis = chain.getReadTimeoutMillis();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        timeout.a(readTimeoutMillis, timeUnit);
        eVar.getTimeout().a(chain.getWriteTimeoutMillis(), timeUnit);
        return new sdk.pendo.io.d3.b(client, this, fVar, eVar);
    }

    public final d.AbstractC0159d a(sdk.pendo.io.b3.c exchange) {
        Intrinsics.checkNotNullParameter(exchange, "exchange");
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        sdk.pendo.io.k3.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        sdk.pendo.io.k3.e eVar = this.sink;
        Intrinsics.checkNotNull(eVar);
        socket.setSoTimeout(0);
        m();
        return new e(fVar, eVar, exchange);
    }

    @Override // sdk.pendo.io.e3.f.c
    public synchronized void a(sdk.pendo.io.e3.f connection, m settings) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.allocationLimit = settings.c();
    }

    @Override // sdk.pendo.io.e3.f.c
    public void a(sdk.pendo.io.e3.i stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        stream.a(sdk.pendo.io.e3.b.REFUSED_STREAM, (IOException) null);
    }

    @Override // sdk.pendo.io.w2.j
    public a0 a() {
        a0 a0Var = this.protocol;
        Intrinsics.checkNotNull(a0Var);
        return a0Var;
    }

    private final boolean a(List<f0> candidates) {
        if ((candidates instanceof Collection) && candidates.isEmpty()) {
            return false;
        }
        for (f0 f0Var : candidates) {
            if (f0Var.getProxy().type() == Proxy.Type.DIRECT && this.route.getProxy().type() == Proxy.Type.DIRECT && Intrinsics.areEqual(this.route.getSocketAddress(), f0Var.getSocketAddress())) {
                return true;
            }
        }
        return false;
    }

    public final void a(long j) {
        this.idleAtNs = j;
    }

    private final void a(int pingIntervalMillis) {
        Socket socket = this.socket;
        Intrinsics.checkNotNull(socket);
        sdk.pendo.io.k3.f fVar = this.source;
        Intrinsics.checkNotNull(fVar);
        sdk.pendo.io.k3.e eVar = this.sink;
        Intrinsics.checkNotNull(eVar);
        socket.setSoTimeout(0);
        sdk.pendo.io.e3.f a2 = new f.a(true, sdk.pendo.io.a3.e.i).a(socket, this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl().getHost(), fVar, eVar).a(this).a(pingIntervalMillis).a();
        this.http2Connection = a2;
        this.allocationLimit = sdk.pendo.io.e3.f.INSTANCE.a().c();
        sdk.pendo.io.e3.f.a(a2, false, null, 3, null);
    }

    private final boolean a(v url) {
        t tVar;
        if (sdk.pendo.io.x2.b.h && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        }
        v url2 = this.route.getIo.sentry.SentryLockReason.JsonKeys.ADDRESS java.lang.String().getUrl();
        if (url.getPort() != url2.getPort()) {
            return false;
        }
        if (Intrinsics.areEqual(url.getHost(), url2.getHost())) {
            return true;
        }
        if (this.noCoalescedConnections || (tVar = this.handshake) == null) {
            return false;
        }
        Intrinsics.checkNotNull(tVar);
        return a(url, tVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0023, code lost:
    
        if (r3.getCanceled() != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(sdk.pendo.io.b3.e r3, java.io.IOException r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = "call"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Throwable -> L4d
            boolean r0 = r4 instanceof sdk.pendo.io.e3.n     // Catch: java.lang.Throwable -> L4d
            r1 = 1
            if (r0 == 0) goto L2d
            sdk.pendo.io.e3.n r4 = (sdk.pendo.io.e3.n) r4     // Catch: java.lang.Throwable -> L4d
            sdk.pendo.io.e3.b r4 = r4.errorCode     // Catch: java.lang.Throwable -> L4d
            sdk.pendo.io.e3.b r0 = sdk.pendo.io.e3.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L4d
            if (r4 != r0) goto L1b
            int r3 = r2.refusedStreamCount     // Catch: java.lang.Throwable -> L4d
            int r3 = r3 + r1
            r2.refusedStreamCount = r3     // Catch: java.lang.Throwable -> L4d
            if (r3 <= r1) goto L4b
            goto L25
        L1b:
            sdk.pendo.io.e3.b r0 = sdk.pendo.io.e3.b.CANCEL     // Catch: java.lang.Throwable -> L4d
            if (r4 != r0) goto L25
            boolean r3 = r3.getCanceled()     // Catch: java.lang.Throwable -> L4d
            if (r3 != 0) goto L4b
        L25:
            r2.noNewExchanges = r1     // Catch: java.lang.Throwable -> L4d
            int r3 = r2.routeFailureCount     // Catch: java.lang.Throwable -> L4d
        L29:
            int r3 = r3 + r1
            r2.routeFailureCount = r3     // Catch: java.lang.Throwable -> L4d
            goto L4b
        L2d:
            boolean r0 = r2.k()     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L37
            boolean r0 = r4 instanceof sdk.pendo.io.e3.a     // Catch: java.lang.Throwable -> L4d
            if (r0 == 0) goto L4b
        L37:
            r2.noNewExchanges = r1     // Catch: java.lang.Throwable -> L4d
            int r0 = r2.successCount     // Catch: java.lang.Throwable -> L4d
            if (r0 != 0) goto L4b
            if (r4 == 0) goto L48
            sdk.pendo.io.w2.z r3 = r3.getClient()     // Catch: java.lang.Throwable -> L4d
            sdk.pendo.io.w2.f0 r0 = r2.route     // Catch: java.lang.Throwable -> L4d
            r2.a(r3, r0, r4)     // Catch: java.lang.Throwable -> L4d
        L48:
            int r3 = r2.routeFailureCount     // Catch: java.lang.Throwable -> L4d
            goto L29
        L4b:
            monitor-exit(r2)
            return
        L4d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b3.f.a(sdk.pendo.io.b3.e, java.io.IOException):void");
    }
}
