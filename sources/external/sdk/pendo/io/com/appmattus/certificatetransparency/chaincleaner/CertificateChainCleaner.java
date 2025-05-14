package external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner;

import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bJ$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;", "", "clean", "", "Ljava/security/cert/X509Certificate;", "chain", "hostname", "", "Companion", "certificatetransparency"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CertificateChainCleaner {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner$Companion;", "", "()V", "androidCertificateChainCleanerFactory", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "getAndroidCertificateChainCleanerFactory", "()Lcom/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "androidCertificateChainCleanerFactory$delegate", "Lkotlin/Lazy;", "get", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "certificatetransparency"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* renamed from: androidCertificateChainCleanerFactory$delegate, reason: from kotlin metadata */
        private static final Lazy<CertificateChainCleanerFactory> androidCertificateChainCleanerFactory = LazyKt.lazy(new Function0<CertificateChainCleanerFactory>() { // from class: external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner.CertificateChainCleaner$Companion$androidCertificateChainCleanerFactory$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CertificateChainCleanerFactory invoke() {
                try {
                    Object newInstance = Class.forName("external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner.AndroidCertificateChainCleaner$Factory").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (newInstance != null) {
                        return (CertificateChainCleanerFactory) newInstance;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type com.appmattus.certificatetransparency.chaincleaner.CertificateChainCleanerFactory");
                } catch (Exception unused) {
                    return null;
                }
            }
        });

        private Companion() {
        }

        private final CertificateChainCleanerFactory getAndroidCertificateChainCleanerFactory() {
            return androidCertificateChainCleanerFactory.getValue();
        }

        public final CertificateChainCleaner get(X509TrustManager trustManager) {
            CertificateChainCleaner certificateChainCleaner;
            Intrinsics.checkNotNullParameter(trustManager, "trustManager");
            CertificateChainCleanerFactory androidCertificateChainCleanerFactory2 = getAndroidCertificateChainCleanerFactory();
            return (androidCertificateChainCleanerFactory2 == null || (certificateChainCleaner = androidCertificateChainCleanerFactory2.get(trustManager)) == null) ? new BasicCertificateChainCleaner(trustManager) : certificateChainCleaner;
        }
    }

    List<X509Certificate> clean(List<? extends X509Certificate> chain, String hostname);
}
