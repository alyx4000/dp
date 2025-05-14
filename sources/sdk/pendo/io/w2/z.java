package sdk.pendo.io.w2;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.dynamite.descriptors.com.google.mlkit.dynamite.barcode.ModuleDescriptor;
import io.sentry.ProfilingTraceData;
import io.sentry.SentryBaseEvent;
import io.sentry.protocol.ViewHierarchyNode;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.h0;
import sdk.pendo.io.w2.r;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u0000 \u009a\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0003\t\u009b\u0001B\u0014\b\u0000\u0012\u0007\u0010\u0096\u0001\u001a\u00020\r¢\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001B\u000b\b\u0016¢\u0006\u0006\b\u0097\u0001\u0010\u0099\u0001J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0017\u0010\u0012\u001a\u00020\u000f8G¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00148G¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198G¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198G¢\u0006\f\n\u0004\b \u0010\u001c\u001a\u0004\b!\u0010\u001eR\u0017\u0010&\u001a\u00020#8G¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010-\u001a\u00020(8G¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0017\u00101\u001a\u00020.8G¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00105\u001a\u00020(8G¢\u0006\f\n\u0004\b3\u0010*\u001a\u0004\b4\u0010,R\u0017\u00107\u001a\u00020(8G¢\u0006\f\n\u0004\b6\u0010*\u001a\u0004\b\u0015\u0010,R\u0017\u0010;\u001a\u0002088G¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u0017\u0010@\u001a\u00020=8G¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0019\u0010G\u001a\u0004\u0018\u00010B8G¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0017\u0010M\u001a\u00020H8G¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u0017\u0010O\u001a\u00020.8G¢\u0006\f\n\u0004\bN\u00100\u001a\u0004\bO\u00102R\u0017\u0010U\u001a\u00020P8G¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR\u0016\u0010Y\u001a\u0004\u0018\u00010V8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0019\u0010_\u001a\u0004\u0018\u00010Z8G¢\u0006\f\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^R\u001d\u0010c\u001a\b\u0012\u0004\u0012\u00020`0\u00198G¢\u0006\f\n\u0004\ba\u0010\u001c\u001a\u0004\bb\u0010\u001eR\u001d\u0010f\u001a\b\u0012\u0004\u0012\u00020d0\u00198G¢\u0006\f\n\u0004\be\u0010\u001c\u001a\u0004\b\u001b\u0010\u001eR\u0017\u0010l\u001a\u00020g8G¢\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0017\u0010p\u001a\u00020m8G¢\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u0019\u0010u\u001a\u0004\u0018\u00010r8G¢\u0006\f\n\u0004\bs\u0010t\u001a\u0004\bu\u0010vR\u0017\u0010{\u001a\u00020w8G¢\u0006\f\n\u0004\bx\u0010\u0005\u001a\u0004\by\u0010zR\u0017\u0010~\u001a\u00020w8G¢\u0006\f\n\u0004\b|\u0010\u0005\u001a\u0004\b}\u0010zR\u0019\u0010\u0081\u0001\u001a\u00020w8G¢\u0006\r\n\u0004\b\u007f\u0010\u0005\u001a\u0005\b\u0080\u0001\u0010zR\u001a\u0010\u0084\u0001\u001a\u00020w8G¢\u0006\u000e\n\u0005\b\u0082\u0001\u0010\u0005\u001a\u0005\b\u0083\u0001\u0010zR\u001a\u0010\u0087\u0001\u001a\u00020w8G¢\u0006\u000e\n\u0005\b\u0085\u0001\u0010\u0005\u001a\u0005\b\u0086\u0001\u0010zR\u001d\u0010\u008c\u0001\u001a\u00030\u0088\u00018G¢\u0006\u0010\n\u0006\b\u0089\u0001\u0010\u0083\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001d\u0010\u0092\u0001\u001a\u00030\u008d\u00018\u0006¢\u0006\u0010\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0014\u0010\u0095\u0001\u001a\u00020V8G¢\u0006\b\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001¨\u0006\u009c\u0001"}, d2 = {"Lsdk/pendo/io/w2/z;", "", "Lsdk/pendo/io/w2/e$a;", "Lsdk/pendo/io/w2/h0$a;", "", "I", "Lsdk/pendo/io/w2/b0;", SentryBaseEvent.JsonKeys.REQUEST, "Lsdk/pendo/io/w2/e;", "a", "Lsdk/pendo/io/w2/i0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/w2/h0;", "Lsdk/pendo/io/w2/z$a;", ViewHierarchyNode.JsonKeys.Y, "Lsdk/pendo/io/w2/p;", "f", "Lsdk/pendo/io/w2/p;", "dispatcher", "()Lokhttp3/Dispatcher;", "Lsdk/pendo/io/w2/k;", "s", "Lsdk/pendo/io/w2/k;", "connectionPool", "()Lokhttp3/ConnectionPool;", "", "Lsdk/pendo/io/w2/w;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/List;", "v", "()Ljava/util/List;", "interceptors", "f0", ViewHierarchyNode.JsonKeys.X, "networkInterceptors", "Lsdk/pendo/io/w2/r$c;", "t0", "Lsdk/pendo/io/w2/r$c;", "eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "", "u0", "Z", "F", "()Z", "retryOnConnectionFailure", "Lsdk/pendo/io/w2/b;", "v0", "Lsdk/pendo/io/w2/b;", "authenticator", "()Lokhttp3/Authenticator;", "w0", "r", "followRedirects", "x0", "followSslRedirects", "Lsdk/pendo/io/w2/n;", "y0", "Lsdk/pendo/io/w2/n;", "cookieJar", "()Lokhttp3/CookieJar;", "Lsdk/pendo/io/w2/q;", "z0", "Lsdk/pendo/io/w2/q;", "dns", "()Lokhttp3/Dns;", "Ljava/net/Proxy;", "A0", "Ljava/net/Proxy;", "B", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "B0", "Ljava/net/ProxySelector;", "D", "()Ljava/net/ProxySelector;", "proxySelector", "C0", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "D0", "Ljavax/net/SocketFactory;", "G", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "E0", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", "F0", "Ljavax/net/ssl/X509TrustManager;", "K", "()Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Lsdk/pendo/io/w2/l;", "G0", "m", "connectionSpecs", "Lsdk/pendo/io/w2/a0;", "H0", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "I0", "Ljavax/net/ssl/HostnameVerifier;", "u", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lsdk/pendo/io/w2/g;", "J0", "Lsdk/pendo/io/w2/g;", "certificatePinner", "()Lokhttp3/CertificatePinner;", "Lsdk/pendo/io/i3/c;", "K0", "Lsdk/pendo/io/i3/c;", "certificateChainCleaner", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "", "L0", "h", "()I", "callTimeoutMillis", "M0", "k", "connectTimeoutMillis", "N0", ExifInterface.LONGITUDE_EAST, "readTimeoutMillis", "O0", "J", "writeTimeoutMillis", "P0", "z", "pingIntervalMillis", "", "Q0", "w", "()J", "minWebSocketMessageToCompress", "Lsdk/pendo/io/b3/h;", "R0", "Lsdk/pendo/io/b3/h;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "H", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "()V", "S0", "b", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public class z implements Cloneable, e.a, h0.a {

    /* renamed from: S0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final List<a0> T0 = sdk.pendo.io.x2.b.a(a0.HTTP_2, a0.HTTP_1_1);
    private static final List<l> U0 = sdk.pendo.io.x2.b.a(l.i, l.k);

    /* renamed from: A, reason: from kotlin metadata */
    private final List<w> interceptors;

    /* renamed from: A0, reason: from kotlin metadata */
    private final Proxy proxy;

    /* renamed from: B0, reason: from kotlin metadata */
    private final ProxySelector proxySelector;

    /* renamed from: C0, reason: from kotlin metadata */
    private final b proxyAuthenticator;

    /* renamed from: D0, reason: from kotlin metadata */
    private final SocketFactory socketFactory;

    /* renamed from: E0, reason: from kotlin metadata */
    private final SSLSocketFactory sslSocketFactoryOrNull;

    /* renamed from: F0, reason: from kotlin metadata */
    private final X509TrustManager x509TrustManager;

    /* renamed from: G0, reason: from kotlin metadata */
    private final List<l> connectionSpecs;

    /* renamed from: H0, reason: from kotlin metadata */
    private final List<a0> protocols;

    /* renamed from: I0, reason: from kotlin metadata */
    private final HostnameVerifier hostnameVerifier;

    /* renamed from: J0, reason: from kotlin metadata */
    private final g certificatePinner;

    /* renamed from: K0, reason: from kotlin metadata */
    private final sdk.pendo.io.i3.c certificateChainCleaner;

    /* renamed from: L0, reason: from kotlin metadata */
    private final int callTimeoutMillis;

    /* renamed from: M0, reason: from kotlin metadata */
    private final int connectTimeoutMillis;

    /* renamed from: N0, reason: from kotlin metadata */
    private final int readTimeoutMillis;

    /* renamed from: O0, reason: from kotlin metadata */
    private final int writeTimeoutMillis;

    /* renamed from: P0, reason: from kotlin metadata */
    private final int pingIntervalMillis;

    /* renamed from: Q0, reason: from kotlin metadata */
    private final long minWebSocketMessageToCompress;

    /* renamed from: R0, reason: from kotlin metadata */
    private final sdk.pendo.io.b3.h routeDatabase;

    /* renamed from: f, reason: from kotlin metadata */
    private final p dispatcher;

    /* renamed from: f0, reason: from kotlin metadata */
    private final List<w> networkInterceptors;

    /* renamed from: s, reason: from kotlin metadata */
    private final k connectionPool;

    /* renamed from: t0, reason: from kotlin metadata */
    private final r.c eventListenerFactory;

    /* renamed from: u0, reason: from kotlin metadata */
    private final boolean retryOnConnectionFailure;

    /* renamed from: v0, reason: from kotlin metadata */
    private final b authenticator;

    /* renamed from: w0, reason: from kotlin metadata */
    private final boolean followRedirects;

    /* renamed from: x0, reason: from kotlin metadata */
    private final boolean followSslRedirects;

    /* renamed from: y0, reason: from kotlin metadata */
    private final n cookieJar;

    /* renamed from: z0, reason: from kotlin metadata */
    private final q dns;

    @Metadata(d1 = {"\u0000Ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0014\b\u0010\u0012\u0007\u0010¾\u0001\u001a\u00020\u0016¢\u0006\u0006\b¿\u0001\u0010À\u0001B\t¢\u0006\u0006\b¿\u0001\u0010Á\u0001J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u0004\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0014\u0010\u0004\u001a\u00020\u00002\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0004\u001a\u00020\u0016R\"\u0010\u001d\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0015\u0010&\u001a\u0004\b'\u0010(R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\"\u00104\u001a\u00020-8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010<\u001a\u0002058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b6\u00107\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\"\u0010D\u001a\u00020=8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010H\u001a\u0002058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bE\u00107\u001a\u0004\bF\u00109\"\u0004\bG\u0010;R\"\u0010L\u001a\u0002058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bI\u00107\u001a\u0004\bJ\u00109\"\u0004\bK\u0010;R\"\u0010T\u001a\u00020M8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\\\u001a\u00020U8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010d\u001a\u0004\u0018\u00010]8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR$\u0010l\u001a\u0004\u0018\u00010e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\"\u0010o\u001a\u00020=8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010?\u001a\u0004\bm\u0010A\"\u0004\bn\u0010CR\"\u0010v\u001a\u00020p8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bJ\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR$\u0010}\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bw\u0010x\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b'\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R-\u0010\u0088\u0001\u001a\t\u0012\u0005\u0012\u00030\u0084\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\b\u0085\u0001\u0010&\u001a\u0004\bI\u0010(\"\u0006\b\u0086\u0001\u0010\u0087\u0001R+\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\b+\u0010&\u001a\u0005\b\u0089\u0001\u0010(\"\u0006\b\u008a\u0001\u0010\u0087\u0001R)\u0010\u0091\u0001\u001a\u00030\u008b\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b\u008c\u0001\u0010\u008d\u0001\u001a\u0005\bw\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001R*\u0010\u0098\u0001\u001a\u00030\u0092\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u0093\u0001\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001\"\u0006\b\u0096\u0001\u0010\u0097\u0001R+\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b`\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R)\u0010¦\u0001\u001a\u00030 \u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0006\b¡\u0001\u0010¢\u0001\u001a\u0005\b*\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001R(\u0010¨\u0001\u001a\u00030 \u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\bh\u0010¢\u0001\u001a\u0005\b>\u0010£\u0001\"\u0006\b§\u0001\u0010¥\u0001R*\u0010«\u0001\u001a\u00030 \u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b©\u0001\u0010¢\u0001\u001a\u0006\b©\u0001\u0010£\u0001\"\u0006\bª\u0001\u0010¥\u0001R)\u0010®\u0001\u001a\u00030 \u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\b8\u0010¢\u0001\u001a\u0006\b¬\u0001\u0010£\u0001\"\u0006\b\u00ad\u0001\u0010¥\u0001R*\u0010±\u0001\u001a\u00030 \u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¯\u0001\u0010¢\u0001\u001a\u0006\b\u008c\u0001\u0010£\u0001\"\u0006\b°\u0001\u0010¥\u0001R(\u0010¶\u0001\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\br\u0010²\u0001\u001a\u0006\b\u0085\u0001\u0010³\u0001\"\u0006\b´\u0001\u0010µ\u0001R+\u0010½\u0001\u001a\u0005\u0018\u00010·\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\by\u0010¸\u0001\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001¨\u0006Â\u0001"}, d2 = {"Lsdk/pendo/io/w2/z$a;", "", "Lsdk/pendo/io/w2/w;", "interceptor", "a", "b", "Lsdk/pendo/io/w2/r;", "eventListener", "Lsdk/pendo/io/w2/c;", "cache", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "", "Lsdk/pendo/io/w2/a0;", "protocols", "", ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, "Ljava/util/concurrent/TimeUnit;", "unit", "c", "Lsdk/pendo/io/w2/z;", "Lsdk/pendo/io/w2/p;", "Lsdk/pendo/io/w2/p;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "dispatcher", "Lsdk/pendo/io/w2/k;", "Lsdk/pendo/io/w2/k;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "connectionPool", "", "Ljava/util/List;", "q", "()Ljava/util/List;", "interceptors", "d", "s", "networkInterceptors", "Lsdk/pendo/io/w2/r$c;", "e", "Lsdk/pendo/io/w2/r$c;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "eventListenerFactory", "", "f", "Z", "z", "()Z", "setRetryOnConnectionFailure$okhttp", "(Z)V", "retryOnConnectionFailure", "Lsdk/pendo/io/w2/b;", "g", "Lsdk/pendo/io/w2/b;", "getAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "authenticator", "h", "n", "setFollowRedirects$okhttp", "followRedirects", ContextChain.TAG_INFRA, "o", "setFollowSslRedirects$okhttp", "followSslRedirects", "Lsdk/pendo/io/w2/n;", "j", "Lsdk/pendo/io/w2/n;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "cookieJar", "Lsdk/pendo/io/w2/q;", "k", "Lsdk/pendo/io/w2/q;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "dns", "Ljava/net/Proxy;", "l", "Ljava/net/Proxy;", "v", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "proxy", "Ljava/net/ProxySelector;", "m", "Ljava/net/ProxySelector;", ViewHierarchyNode.JsonKeys.X, "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "proxySelector", "getProxyAuthenticator$okhttp", "setProxyAuthenticator$okhttp", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "Ljavax/net/SocketFactory;", "B", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "socketFactory", ContextChain.TAG_PRODUCT, "Ljavax/net/ssl/SSLSocketFactory;", "C", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/X509TrustManager;", ExifInterface.LONGITUDE_EAST, "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "x509TrustManagerOrNull", "Lsdk/pendo/io/w2/l;", "r", "setConnectionSpecs$okhttp", "(Ljava/util/List;)V", "connectionSpecs", "u", "setProtocols$okhttp", "Ljavax/net/ssl/HostnameVerifier;", "t", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "hostnameVerifier", "Lsdk/pendo/io/w2/g;", "Lsdk/pendo/io/w2/g;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "certificatePinner", "Lsdk/pendo/io/i3/c;", "Lsdk/pendo/io/i3/c;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "certificateChainCleaner", "", "w", "I", "()I", "setCallTimeout$okhttp", "(I)V", "callTimeout", "setConnectTimeout$okhttp", "connectTimeout", ViewHierarchyNode.JsonKeys.Y, "setReadTimeout$okhttp", "readTimeout", "D", "setWriteTimeout$okhttp", "writeTimeout", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setPingInterval$okhttp", "pingInterval", "J", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "minWebSocketMessageToCompress", "Lsdk/pendo/io/b3/h;", "Lsdk/pendo/io/b3/h;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "routeDatabase", "okHttpClient", "<init>", "(Lokhttp3/OkHttpClient;)V", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* renamed from: A, reason: from kotlin metadata */
        private int pingInterval;

        /* renamed from: B, reason: from kotlin metadata */
        private long minWebSocketMessageToCompress;

        /* renamed from: C, reason: from kotlin metadata */
        private sdk.pendo.io.b3.h routeDatabase;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private p dispatcher;

        /* renamed from: b, reason: from kotlin metadata */
        private k connectionPool;

        /* renamed from: c, reason: from kotlin metadata */
        private final List<w> interceptors;

        /* renamed from: d, reason: from kotlin metadata */
        private final List<w> networkInterceptors;

        /* renamed from: e, reason: from kotlin metadata */
        private r.c eventListenerFactory;

        /* renamed from: f, reason: from kotlin metadata */
        private boolean retryOnConnectionFailure;

        /* renamed from: g, reason: from kotlin metadata */
        private b authenticator;

        /* renamed from: h, reason: from kotlin metadata */
        private boolean followRedirects;

        /* renamed from: i, reason: from kotlin metadata */
        private boolean followSslRedirects;

        /* renamed from: j, reason: from kotlin metadata */
        private n cookieJar;

        /* renamed from: k, reason: from kotlin metadata */
        private q dns;

        /* renamed from: l, reason: from kotlin metadata */
        private Proxy proxy;

        /* renamed from: m, reason: from kotlin metadata */
        private ProxySelector proxySelector;

        /* renamed from: n, reason: from kotlin metadata */
        private b proxyAuthenticator;

        /* renamed from: o, reason: from kotlin metadata */
        private SocketFactory socketFactory;

        /* renamed from: p, reason: from kotlin metadata */
        private SSLSocketFactory sslSocketFactoryOrNull;

        /* renamed from: q, reason: from kotlin metadata */
        private X509TrustManager x509TrustManagerOrNull;

        /* renamed from: r, reason: from kotlin metadata */
        private List<l> connectionSpecs;

        /* renamed from: s, reason: from kotlin metadata */
        private List<? extends a0> protocols;

        /* renamed from: t, reason: from kotlin metadata */
        private HostnameVerifier hostnameVerifier;

        /* renamed from: u, reason: from kotlin metadata */
        private g certificatePinner;

        /* renamed from: v, reason: from kotlin metadata */
        private sdk.pendo.io.i3.c certificateChainCleaner;

        /* renamed from: w, reason: from kotlin metadata */
        private int callTimeout;

        /* renamed from: x, reason: from kotlin metadata */
        private int connectTimeout;

        /* renamed from: y, reason: from kotlin metadata */
        private int readTimeout;

        /* renamed from: z, reason: from kotlin metadata */
        private int writeTimeout;

        public a() {
            this.dispatcher = new p();
            this.connectionPool = new k();
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.eventListenerFactory = sdk.pendo.io.x2.b.a(r.b);
            this.retryOnConnectionFailure = true;
            b bVar = b.b;
            this.authenticator = bVar;
            this.followRedirects = true;
            this.followSslRedirects = true;
            this.cookieJar = n.b;
            this.dns = q.b;
            this.proxyAuthenticator = bVar;
            SocketFactory socketFactory = SocketFactory.getDefault();
            Intrinsics.checkNotNullExpressionValue(socketFactory, "getDefault()");
            this.socketFactory = socketFactory;
            Companion companion = z.INSTANCE;
            this.connectionSpecs = companion.a();
            this.protocols = companion.b();
            this.hostnameVerifier = sdk.pendo.io.i3.d.f1203a;
            this.certificatePinner = g.d;
            this.connectTimeout = ModuleDescriptor.MODULE_VERSION;
            this.readTimeout = ModuleDescriptor.MODULE_VERSION;
            this.writeTimeout = ModuleDescriptor.MODULE_VERSION;
            this.minWebSocketMessageToCompress = 1024L;
        }

        /* renamed from: A, reason: from getter */
        public final sdk.pendo.io.b3.h getRouteDatabase() {
            return this.routeDatabase;
        }

        /* renamed from: B, reason: from getter */
        public final SocketFactory getSocketFactory() {
            return this.socketFactory;
        }

        /* renamed from: C, reason: from getter */
        public final SSLSocketFactory getSslSocketFactoryOrNull() {
            return this.sslSocketFactoryOrNull;
        }

        /* renamed from: D, reason: from getter */
        public final int getWriteTimeout() {
            return this.writeTimeout;
        }

        /* renamed from: E, reason: from getter */
        public final X509TrustManager getX509TrustManagerOrNull() {
            return this.x509TrustManagerOrNull;
        }

        public final a a(c cache) {
            return this;
        }

        public final a a(w interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final a b(w interceptor) {
            Intrinsics.checkNotNullParameter(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public final c c() {
            return null;
        }

        /* renamed from: d, reason: from getter */
        public final int getCallTimeout() {
            return this.callTimeout;
        }

        /* renamed from: e, reason: from getter */
        public final sdk.pendo.io.i3.c getCertificateChainCleaner() {
            return this.certificateChainCleaner;
        }

        /* renamed from: f, reason: from getter */
        public final g getCertificatePinner() {
            return this.certificatePinner;
        }

        /* renamed from: g, reason: from getter */
        public final int getConnectTimeout() {
            return this.connectTimeout;
        }

        /* renamed from: h, reason: from getter */
        public final k getConnectionPool() {
            return this.connectionPool;
        }

        public final List<l> i() {
            return this.connectionSpecs;
        }

        /* renamed from: j, reason: from getter */
        public final n getCookieJar() {
            return this.cookieJar;
        }

        /* renamed from: k, reason: from getter */
        public final p getDispatcher() {
            return this.dispatcher;
        }

        /* renamed from: l, reason: from getter */
        public final q getDns() {
            return this.dns;
        }

        /* renamed from: m, reason: from getter */
        public final r.c getEventListenerFactory() {
            return this.eventListenerFactory;
        }

        /* renamed from: n, reason: from getter */
        public final boolean getFollowRedirects() {
            return this.followRedirects;
        }

        /* renamed from: o, reason: from getter */
        public final boolean getFollowSslRedirects() {
            return this.followSslRedirects;
        }

        /* renamed from: p, reason: from getter */
        public final HostnameVerifier getHostnameVerifier() {
            return this.hostnameVerifier;
        }

        public final List<w> q() {
            return this.interceptors;
        }

        /* renamed from: r, reason: from getter */
        public final long getMinWebSocketMessageToCompress() {
            return this.minWebSocketMessageToCompress;
        }

        public final List<w> s() {
            return this.networkInterceptors;
        }

        /* renamed from: t, reason: from getter */
        public final int getPingInterval() {
            return this.pingInterval;
        }

        public final List<a0> u() {
            return this.protocols;
        }

        /* renamed from: v, reason: from getter */
        public final Proxy getProxy() {
            return this.proxy;
        }

        /* renamed from: w, reason: from getter */
        public final b getProxyAuthenticator() {
            return this.proxyAuthenticator;
        }

        /* renamed from: x, reason: from getter */
        public final ProxySelector getProxySelector() {
            return this.proxySelector;
        }

        /* renamed from: y, reason: from getter */
        public final int getReadTimeout() {
            return this.readTimeout;
        }

        /* renamed from: z, reason: from getter */
        public final boolean getRetryOnConnectionFailure() {
            return this.retryOnConnectionFailure;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(z okHttpClient) {
            this();
            Intrinsics.checkNotNullParameter(okHttpClient, "okHttpClient");
            this.dispatcher = okHttpClient.getDispatcher();
            this.connectionPool = okHttpClient.getConnectionPool();
            CollectionsKt.addAll(this.interceptors, okHttpClient.v());
            CollectionsKt.addAll(this.networkInterceptors, okHttpClient.x());
            this.eventListenerFactory = okHttpClient.getEventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.getRetryOnConnectionFailure();
            this.authenticator = okHttpClient.getAuthenticator();
            this.followRedirects = okHttpClient.getFollowRedirects();
            this.followSslRedirects = okHttpClient.getFollowSslRedirects();
            this.cookieJar = okHttpClient.getCookieJar();
            okHttpClient.g();
            this.dns = okHttpClient.getDns();
            this.proxy = okHttpClient.getProxy();
            this.proxySelector = okHttpClient.getProxySelector();
            this.proxyAuthenticator = okHttpClient.getProxyAuthenticator();
            this.socketFactory = okHttpClient.getSocketFactory();
            this.sslSocketFactoryOrNull = okHttpClient.sslSocketFactoryOrNull;
            this.x509TrustManagerOrNull = okHttpClient.getX509TrustManager();
            this.connectionSpecs = okHttpClient.m();
            this.protocols = okHttpClient.A();
            this.hostnameVerifier = okHttpClient.getHostnameVerifier();
            this.certificatePinner = okHttpClient.getCertificatePinner();
            this.certificateChainCleaner = okHttpClient.getCertificateChainCleaner();
            this.callTimeout = okHttpClient.getCallTimeoutMillis();
            this.connectTimeout = okHttpClient.getConnectTimeoutMillis();
            this.readTimeout = okHttpClient.getReadTimeoutMillis();
            this.writeTimeout = okHttpClient.getWriteTimeoutMillis();
            this.pingInterval = okHttpClient.getPingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.getMinWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }

        public final z a() {
            return new z(this);
        }

        /* renamed from: b, reason: from getter */
        public final b getAuthenticator() {
            return this.authenticator;
        }

        public final a c(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.writeTimeout = sdk.pendo.io.x2.b.a(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, timeout, unit);
            return this;
        }

        public final a b(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.readTimeout = sdk.pendo.io.x2.b.a(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, timeout, unit);
            return this;
        }

        public final a a(long timeout, TimeUnit unit) {
            Intrinsics.checkNotNullParameter(unit, "unit");
            this.connectTimeout = sdk.pendo.io.x2.b.a(ProfilingTraceData.TRUNCATION_REASON_TIMEOUT, timeout, unit);
            return this;
        }

        public final a a(r eventListener) {
            Intrinsics.checkNotNullParameter(eventListener, "eventListener");
            this.eventListenerFactory = sdk.pendo.io.x2.b.a(eventListener);
            return this;
        }

        public final a a(List<? extends a0> protocols) {
            Intrinsics.checkNotNullParameter(protocols, "protocols");
            List mutableList = CollectionsKt.toMutableList((Collection) protocols);
            a0 a0Var = a0.H2_PRIOR_KNOWLEDGE;
            if (!(mutableList.contains(a0Var) || mutableList.contains(a0.HTTP_1_1))) {
                throw new IllegalArgumentException(("protocols must contain h2_prior_knowledge or http/1.1: " + mutableList).toString());
            }
            if (!(!mutableList.contains(a0Var) || mutableList.size() <= 1)) {
                throw new IllegalArgumentException(("protocols containing h2_prior_knowledge cannot use other protocols: " + mutableList).toString());
            }
            if (!(!mutableList.contains(a0.HTTP_1_0))) {
                throw new IllegalArgumentException(("protocols must not contain http/1.0: " + mutableList).toString());
            }
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
            if (!(!mutableList.contains(null))) {
                throw new IllegalArgumentException("protocols must not contain null".toString());
            }
            mutableList.remove(a0.SPDY_3);
            if (!Intrinsics.areEqual(mutableList, this.protocols)) {
                this.routeDatabase = null;
            }
            List<? extends a0> unmodifiableList = Collections.unmodifiableList(mutableList);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(protocolsCopy)");
            this.protocols = unmodifiableList;
            return this;
        }

        public final a a(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager) {
            Intrinsics.checkNotNullParameter(sslSocketFactory, "sslSocketFactory");
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            if (!Intrinsics.areEqual(sslSocketFactory, this.sslSocketFactoryOrNull) || !Intrinsics.areEqual(trustManager, this.x509TrustManagerOrNull)) {
                this.routeDatabase = null;
            }
            this.sslSocketFactoryOrNull = sslSocketFactory;
            this.certificateChainCleaner = sdk.pendo.io.i3.c.INSTANCE.a(trustManager);
            this.x509TrustManagerOrNull = trustManager;
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007¨\u0006\r"}, d2 = {"Lsdk/pendo/io/w2/z$b;", "", "", "Lsdk/pendo/io/w2/a0;", "DEFAULT_PROTOCOLS", "Ljava/util/List;", "b", "()Ljava/util/List;", "Lsdk/pendo/io/w2/l;", "DEFAULT_CONNECTION_SPECS", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
    /* renamed from: sdk.pendo.io.w2.z$b, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<l> a() {
            return z.U0;
        }

        public final List<a0> b() {
            return z.T0;
        }
    }

    public z() {
        this(new a());
    }

    private final void I() {
        boolean z;
        Intrinsics.checkNotNull(this.interceptors, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null interceptor: " + this.interceptors).toString());
        }
        Intrinsics.checkNotNull(this.networkInterceptors, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>");
        if (!(!r0.contains(null))) {
            throw new IllegalStateException(("Null network interceptor: " + this.networkInterceptors).toString());
        }
        List<l> list = this.connectionSpecs;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((l) it.next()).getIsTls()) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (!z) {
            if (this.sslSocketFactoryOrNull == null) {
                throw new IllegalStateException("sslSocketFactory == null".toString());
            }
            if (this.certificateChainCleaner == null) {
                throw new IllegalStateException("certificateChainCleaner == null".toString());
            }
            if (this.x509TrustManager == null) {
                throw new IllegalStateException("x509TrustManager == null".toString());
            }
            return;
        }
        if (!(this.sslSocketFactoryOrNull == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.certificateChainCleaner == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!(this.x509TrustManager == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!Intrinsics.areEqual(this.certificatePinner, g.d)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final List<a0> A() {
        return this.protocols;
    }

    /* renamed from: B, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* renamed from: C, reason: from getter */
    public final b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: D, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    /* renamed from: E, reason: from getter */
    public final int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    /* renamed from: F, reason: from getter */
    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    /* renamed from: G, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory H() {
        SSLSocketFactory sSLSocketFactory = this.sslSocketFactoryOrNull;
        if (sSLSocketFactory != null) {
            return sSLSocketFactory;
        }
        throw new IllegalStateException("CLEARTEXT-only client");
    }

    /* renamed from: J, reason: from getter */
    public final int getWriteTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    /* renamed from: K, reason: from getter */
    public final X509TrustManager getX509TrustManager() {
        return this.x509TrustManager;
    }

    public Object clone() {
        return super.clone();
    }

    /* renamed from: f, reason: from getter */
    public final b getAuthenticator() {
        return this.authenticator;
    }

    public final c g() {
        return null;
    }

    /* renamed from: h, reason: from getter */
    public final int getCallTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    /* renamed from: i, reason: from getter */
    public final sdk.pendo.io.i3.c getCertificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    /* renamed from: j, reason: from getter */
    public final g getCertificatePinner() {
        return this.certificatePinner;
    }

    /* renamed from: k, reason: from getter */
    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    /* renamed from: l, reason: from getter */
    public final k getConnectionPool() {
        return this.connectionPool;
    }

    public final List<l> m() {
        return this.connectionSpecs;
    }

    /* renamed from: n, reason: from getter */
    public final n getCookieJar() {
        return this.cookieJar;
    }

    /* renamed from: o, reason: from getter */
    public final p getDispatcher() {
        return this.dispatcher;
    }

    /* renamed from: p, reason: from getter */
    public final q getDns() {
        return this.dns;
    }

    /* renamed from: q, reason: from getter */
    public final r.c getEventListenerFactory() {
        return this.eventListenerFactory;
    }

    /* renamed from: r, reason: from getter */
    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    /* renamed from: s, reason: from getter */
    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    /* renamed from: t, reason: from getter */
    public final sdk.pendo.io.b3.h getRouteDatabase() {
        return this.routeDatabase;
    }

    /* renamed from: u, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<w> v() {
        return this.interceptors;
    }

    /* renamed from: w, reason: from getter */
    public final long getMinWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<w> x() {
        return this.networkInterceptors;
    }

    public a y() {
        return new a(this);
    }

    /* renamed from: z, reason: from getter */
    public final int getPingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x006c, code lost:
    
        if (r0 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public z(sdk.pendo.io.w2.z.a r4) {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.w2.z.<init>(sdk.pendo.io.w2.z$a):void");
    }

    @Override // sdk.pendo.io.w2.e.a
    public e a(b0 request) {
        Intrinsics.checkNotNullParameter(request, "request");
        return new sdk.pendo.io.b3.e(this, request, false);
    }

    @Override // sdk.pendo.io.w2.h0.a
    public h0 a(b0 request, i0 listener) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(listener, "listener");
        sdk.pendo.io.j3.d dVar = new sdk.pendo.io.j3.d(sdk.pendo.io.a3.e.i, request, listener, new Random(), this.pingIntervalMillis, null, this.minWebSocketMessageToCompress);
        dVar.a(this);
        return dVar;
    }
}
