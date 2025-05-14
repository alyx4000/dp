package external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner;

import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleanerFactory;", "", "get", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "certificatetransparency"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface CertificateChainCleanerFactory {
    CertificateChainCleaner get(X509TrustManager trustManager);
}
