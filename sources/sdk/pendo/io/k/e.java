package sdk.pendo.io.k;

import external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner.CertificateChainCleanerFactory;
import io.sentry.SentryEvent;
import java.security.cert.Certificate;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.b.e;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.t;
import sdk.pendo.io.w2.w;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B}\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Lsdk/pendo/io/k/e;", "Lsdk/pendo/io/w2/w;", "Lsdk/pendo/io/k/d;", "Lsdk/pendo/io/w2/w$a;", "chain", "Lsdk/pendo/io/w2/d0;", "a", "", "g", "Z", "failOnError", "Lsdk/pendo/io/b/b;", "h", "Lsdk/pendo/io/b/b;", SentryEvent.JsonKeys.LOGGER, "", "Lsdk/pendo/io/l/b;", "includeHosts", "excludeHosts", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "certificateChainCleanerFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lsdk/pendo/io/m/c;", "logListService", "Lsdk/pendo/io/d/a;", "Lsdk/pendo/io/m/b;", "logListDataSource", "Lsdk/pendo/io/b/c;", "policy", "Lsdk/pendo/io/c/a;", "diskCache", "<init>", "(Ljava/util/Set;Ljava/util/Set;Lcom/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;Ljavax/net/ssl/X509TrustManager;Lcom/appmattus/certificatetransparency/loglist/LogListService;Lcom/appmattus/certificatetransparency/datasource/DataSource;Lcom/appmattus/certificatetransparency/CTPolicy;Lcom/appmattus/certificatetransparency/cache/DiskCache;ZLcom/appmattus/certificatetransparency/CTLogger;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class e extends d implements w {

    /* renamed from: g, reason: from kotlin metadata */
    private final boolean failOnError;

    /* renamed from: h, reason: from kotlin metadata */
    private final sdk.pendo.io.b.b logger;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Set<sdk.pendo.io.l.b> includeHosts, Set<sdk.pendo.io.l.b> excludeHosts, CertificateChainCleanerFactory certificateChainCleanerFactory, X509TrustManager x509TrustManager, sdk.pendo.io.m.c cVar, sdk.pendo.io.d.a<sdk.pendo.io.m.b> aVar, sdk.pendo.io.b.c cVar2, sdk.pendo.io.c.a aVar2, boolean z, sdk.pendo.io.b.b bVar) {
        super(includeHosts, excludeHosts, certificateChainCleanerFactory, x509TrustManager, cVar, aVar, cVar2, aVar2);
        Intrinsics.checkNotNullParameter(includeHosts, "includeHosts");
        Intrinsics.checkNotNullParameter(excludeHosts, "excludeHosts");
        this.failOnError = z;
        this.logger = bVar;
    }

    @Override // sdk.pendo.io.w2.w
    public d0 a(w.a chain) {
        List<Certificate> emptyList;
        Intrinsics.checkNotNullParameter(chain, "chain");
        String host = chain.getRequest().i().getHost();
        sdk.pendo.io.w2.j b = chain.b();
        if (b == null) {
            throw new IllegalStateException("No connection found. Verify interceptor is added using addNetworkInterceptor");
        }
        t handshake = b.getHandshake();
        if (handshake == null || (emptyList = handshake.c()) == null) {
            emptyList = CollectionsKt.emptyList();
        }
        sdk.pendo.io.b.e a2 = b.c() instanceof SSLSocket ? a(host, emptyList) : new e.c.b(host);
        sdk.pendo.io.b.b bVar = this.logger;
        if (bVar != null) {
            bVar.a(host, a2);
        }
        if ((a2 instanceof e.b) && this.failOnError) {
            throw new SSLPeerUnverifiedException("Certificate transparency failed");
        }
        return chain.a(chain.getRequest());
    }
}
