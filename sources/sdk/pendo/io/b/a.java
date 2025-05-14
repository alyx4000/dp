package sdk.pendo.io.b;

import com.facebook.common.callercontext.ContextChain;
import external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner.CertificateChainCleanerFactory;
import io.sentry.SentryEvent;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.w2.w;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0005J!\u0010\t\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR*\u0010*\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"8F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R.\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010#\u001a\u0004\u0018\u00010\u00028F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00108\u001a\u0004\u0018\u0001012\b\u0010#\u001a\u0004\u0018\u0001018F@FX\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006;"}, d2 = {"Lsdk/pendo/io/b/a;", "", "Lsdk/pendo/io/b/b;", SentryEvent.JsonKeys.LOGGER, "a", "Lsdk/pendo/io/w2/w;", "", "", "pattern", "excludeHost", "([Ljava/lang/String;)Lcom/appmattus/certificatetransparency/CTInterceptorBuilder;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "certificateChainCleanerFactory", "Ljavax/net/ssl/X509TrustManager;", "b", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lsdk/pendo/io/m/c;", "c", "Lsdk/pendo/io/m/c;", "logListService", "Lsdk/pendo/io/d/a;", "Lsdk/pendo/io/m/b;", "d", "Lsdk/pendo/io/d/a;", "logListDataSource", "", "Lsdk/pendo/io/l/b;", "e", "Ljava/util/Set;", "includeHosts", "f", "excludeHosts", "", "<set-?>", "g", "Z", "getFailOnError", "()Z", "setFailOnError", "(Z)V", "failOnError", "h", "Lsdk/pendo/io/b/b;", "getLogger", "()Lcom/appmattus/certificatetransparency/CTLogger;", "setLogger", "(Lcom/appmattus/certificatetransparency/CTLogger;)V", "Lsdk/pendo/io/b/c;", ContextChain.TAG_INFRA, "Lsdk/pendo/io/b/c;", "getPolicy", "()Lcom/appmattus/certificatetransparency/CTPolicy;", "setPolicy", "(Lcom/appmattus/certificatetransparency/CTPolicy;)V", "policy", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private CertificateChainCleanerFactory certificateChainCleanerFactory;

    /* renamed from: b, reason: from kotlin metadata */
    private X509TrustManager trustManager;

    /* renamed from: c, reason: from kotlin metadata */
    private sdk.pendo.io.m.c logListService;

    /* renamed from: d, reason: from kotlin metadata */
    private sdk.pendo.io.d.a<sdk.pendo.io.m.b> logListDataSource;

    /* renamed from: e, reason: from kotlin metadata */
    private final Set<sdk.pendo.io.l.b> includeHosts = new LinkedHashSet();

    /* renamed from: f, reason: from kotlin metadata */
    private final Set<sdk.pendo.io.l.b> excludeHosts = new LinkedHashSet();

    /* renamed from: g, reason: from kotlin metadata */
    private boolean failOnError = true;

    /* renamed from: h, reason: from kotlin metadata */
    private b logger;

    /* renamed from: i, reason: from kotlin metadata */
    private c policy;

    public final w a() {
        return new sdk.pendo.io.k.e(CollectionsKt.toSet(this.includeHosts), CollectionsKt.toSet(this.excludeHosts), this.certificateChainCleanerFactory, this.trustManager, this.logListService, this.logListDataSource, this.policy, null, this.failOnError, this.logger);
    }

    public final a a(b logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        return this;
    }
}
