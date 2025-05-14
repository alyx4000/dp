package sdk.pendo.io.w2;

import com.facebook.common.callercontext.ContextChain;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.v;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010A\u001a\u00020\n\u0012\u0006\u0010B\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001c\u0012\b\u0010$\u001a\u0004\u0018\u00010!\u0012\u0006\u0010)\u001a\u00020&\u0012\b\u0010/\u001a\u0004\u0018\u00010+\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020:09\u0012\f\u0010@\u001a\b\u0012\u0004\u0012\u00020>09\u0012\u0006\u00104\u001a\u000200¢\u0006\u0004\bC\u0010DJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000b\u001a\u00020\nH\u0016R\u0017\u0010\u000e\u001a\u00020\f8\u0007¢\u0006\f\n\u0004\b\b\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00108\u0007¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0007¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010 \u001a\u0004\u0018\u00010\u001c8\u0007¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR\u0019\u0010$\u001a\u0004\u0018\u00010!8\u0007¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010)\u001a\u00020&8\u0007¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010/\u001a\u0004\u0018\u00010+8\u0007¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b'\u0010.R\u0017\u00104\u001a\u0002008\u0007¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b1\u00103R\u0017\u00107\u001a\u0002058G¢\u0006\f\n\u0004\b\u0013\u00106\u001a\u0004\b7\u00108R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020:098G¢\u0006\f\n\u0004\b\u0019\u0010;\u001a\u0004\b\"\u0010<R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020>098G¢\u0006\f\n\u0004\b?\u0010;\u001a\u0004\b\u0011\u0010<¨\u0006E"}, d2 = {"Lsdk/pendo/io/w2/a;", "", "other", "", "equals", "", "hashCode", "that", "a", "(Lsdk/pendo/io/w2/a;)Z", "", "toString", "Lsdk/pendo/io/w2/q;", "Lsdk/pendo/io/w2/q;", "dns", "()Lokhttp3/Dns;", "Ljavax/net/SocketFactory;", "b", "Ljavax/net/SocketFactory;", ContextChain.TAG_INFRA, "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "c", "Ljavax/net/ssl/SSLSocketFactory;", "j", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "d", "Ljavax/net/ssl/HostnameVerifier;", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lsdk/pendo/io/w2/g;", "e", "Lsdk/pendo/io/w2/g;", "certificatePinner", "()Lokhttp3/CertificatePinner;", "Lsdk/pendo/io/w2/b;", "f", "Lsdk/pendo/io/w2/b;", "proxyAuthenticator", "()Lokhttp3/Authenticator;", "Ljava/net/Proxy;", "g", "Ljava/net/Proxy;", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "h", "Ljava/net/ProxySelector;", "()Ljava/net/ProxySelector;", "proxySelector", "Lsdk/pendo/io/w2/v;", "Lsdk/pendo/io/w2/v;", "url", "()Lokhttp3/HttpUrl;", "", "Lsdk/pendo/io/w2/a0;", "Ljava/util/List;", "()Ljava/util/List;", "protocols", "Lsdk/pendo/io/w2/l;", "k", "connectionSpecs", "uriHost", "uriPort", "<init>", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final q dns;

    /* renamed from: b, reason: from kotlin metadata */
    private final SocketFactory socketFactory;

    /* renamed from: c, reason: from kotlin metadata */
    private final SSLSocketFactory sslSocketFactory;

    /* renamed from: d, reason: from kotlin metadata */
    private final HostnameVerifier hostnameVerifier;

    /* renamed from: e, reason: from kotlin metadata */
    private final g certificatePinner;

    /* renamed from: f, reason: from kotlin metadata */
    private final b proxyAuthenticator;

    /* renamed from: g, reason: from kotlin metadata */
    private final Proxy proxy;

    /* renamed from: h, reason: from kotlin metadata */
    private final ProxySelector proxySelector;

    /* renamed from: i, reason: from kotlin metadata */
    private final v url;

    /* renamed from: j, reason: from kotlin metadata */
    private final List<a0> protocols;

    /* renamed from: k, reason: from kotlin metadata */
    private final List<l> connectionSpecs;

    public a(String uriHost, int i, q dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, g gVar, b proxyAuthenticator, Proxy proxy, List<? extends a0> protocols, List<l> connectionSpecs, ProxySelector proxySelector) {
        Intrinsics.checkNotNullParameter(uriHost, "uriHost");
        Intrinsics.checkNotNullParameter(dns, "dns");
        Intrinsics.checkNotNullParameter(socketFactory, "socketFactory");
        Intrinsics.checkNotNullParameter(proxyAuthenticator, "proxyAuthenticator");
        Intrinsics.checkNotNullParameter(protocols, "protocols");
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        Intrinsics.checkNotNullParameter(proxySelector, "proxySelector");
        this.dns = dns;
        this.socketFactory = socketFactory;
        this.sslSocketFactory = sSLSocketFactory;
        this.hostnameVerifier = hostnameVerifier;
        this.certificatePinner = gVar;
        this.proxyAuthenticator = proxyAuthenticator;
        this.proxy = proxy;
        this.proxySelector = proxySelector;
        this.url = new v.a().g(sSLSocketFactory != null ? "https" : "http").c(uriHost).a(i).a();
        this.protocols = sdk.pendo.io.x2.b.b(protocols);
        this.connectionSpecs = sdk.pendo.io.x2.b.b(connectionSpecs);
    }

    /* renamed from: a, reason: from getter */
    public final g getCertificatePinner() {
        return this.certificatePinner;
    }

    public final List<l> b() {
        return this.connectionSpecs;
    }

    /* renamed from: c, reason: from getter */
    public final q getDns() {
        return this.dns;
    }

    /* renamed from: d, reason: from getter */
    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<a0> e() {
        return this.protocols;
    }

    public boolean equals(Object other) {
        if (other instanceof a) {
            a aVar = (a) other;
            if (Intrinsics.areEqual(this.url, aVar.url) && a(aVar)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final Proxy getProxy() {
        return this.proxy;
    }

    /* renamed from: g, reason: from getter */
    public final b getProxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    /* renamed from: h, reason: from getter */
    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public int hashCode() {
        return ((((((((((((((((((this.url.hashCode() + 527) * 31) + this.dns.hashCode()) * 31) + this.proxyAuthenticator.hashCode()) * 31) + this.protocols.hashCode()) * 31) + this.connectionSpecs.hashCode()) * 31) + this.proxySelector.hashCode()) * 31) + Objects.hashCode(this.proxy)) * 31) + Objects.hashCode(this.sslSocketFactory)) * 31) + Objects.hashCode(this.hostnameVerifier)) * 31) + Objects.hashCode(this.certificatePinner);
    }

    /* renamed from: i, reason: from getter */
    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* renamed from: j, reason: from getter */
    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    /* renamed from: k, reason: from getter */
    public final v getUrl() {
        return this.url;
    }

    public String toString() {
        StringBuilder sb;
        Object obj;
        StringBuilder append = new StringBuilder("Address{").append(this.url.getHost()).append(':').append(this.url.getPort()).append(", ");
        if (this.proxy != null) {
            sb = new StringBuilder("proxy=");
            obj = this.proxy;
        } else {
            sb = new StringBuilder("proxySelector=");
            obj = this.proxySelector;
        }
        return append.append(sb.append(obj).toString()).append('}').toString();
    }

    public final boolean a(a that) {
        Intrinsics.checkNotNullParameter(that, "that");
        return Intrinsics.areEqual(this.dns, that.dns) && Intrinsics.areEqual(this.proxyAuthenticator, that.proxyAuthenticator) && Intrinsics.areEqual(this.protocols, that.protocols) && Intrinsics.areEqual(this.connectionSpecs, that.connectionSpecs) && Intrinsics.areEqual(this.proxySelector, that.proxySelector) && Intrinsics.areEqual(this.proxy, that.proxy) && Intrinsics.areEqual(this.sslSocketFactory, that.sslSocketFactory) && Intrinsics.areEqual(this.hostnameVerifier, that.hostnameVerifier) && Intrinsics.areEqual(this.certificatePinner, that.certificatePinner) && this.url.getPort() == that.url.getPort();
    }
}
