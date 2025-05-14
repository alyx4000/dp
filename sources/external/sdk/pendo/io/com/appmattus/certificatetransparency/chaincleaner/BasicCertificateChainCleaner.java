package external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner;

import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\nH\u0002J\u0014\u0010\u0011\u001a\u00020\u0012*\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0002R0\u0010\u0005\u001a$\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u0007\u0012\u0012\u0012\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\n0\n0\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/BasicCertificateChainCleaner;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/chaincleaner/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "(Ljavax/net/ssl/X509TrustManager;)V", "subjectToCaCerts", "", "Ljavax/security/auth/x500/X500Principal;", "kotlin.jvm.PlatformType", "", "Ljava/security/cert/X509Certificate;", "clean", "chain", "hostname", "", "findTrustedCertByIssuerAndSignature", "cert", "isSignedBy", "", "signingCert", "Companion", "certificatetransparency"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class BasicCertificateChainCleaner implements CertificateChainCleaner {
    private static final int MAX_SIGNERS = 9;
    private final Map<X500Principal, List<X509Certificate>> subjectToCaCerts;

    public BasicCertificateChainCleaner(X509TrustManager trustManager) {
        Intrinsics.checkNotNullParameter(trustManager, "trustManager");
        X509Certificate[] acceptedIssuers = trustManager.getAcceptedIssuers();
        Intrinsics.checkNotNullExpressionValue(acceptedIssuers, "trustManager.acceptedIssuers");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (X509Certificate x509Certificate : acceptedIssuers) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Object obj = linkedHashMap.get(subjectX500Principal);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(subjectX500Principal, obj);
            }
            ((List) obj).add(x509Certificate);
        }
        this.subjectToCaCerts = linkedHashMap;
    }

    private final X509Certificate findTrustedCertByIssuerAndSignature(X509Certificate cert) {
        List<X509Certificate> list = this.subjectToCaCerts.get(cert.getIssuerX500Principal());
        Object obj = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            X509Certificate it2 = (X509Certificate) next;
            Intrinsics.checkNotNullExpressionValue(it2, "it");
            if (isSignedBy(cert, it2)) {
                obj = next;
                break;
            }
        }
        return (X509Certificate) obj;
    }

    private final boolean isSignedBy(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!Intrinsics.areEqual(x509Certificate.getIssuerX500Principal(), x509Certificate2.getSubjectX500Principal())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // external.sdk.pendo.io.com.appmattus.certificatetransparency.chaincleaner.CertificateChainCleaner
    public List<X509Certificate> clean(List<? extends X509Certificate> chain, String hostname) {
        Object obj;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        if (chain.isEmpty()) {
            throw new SSLPeerUnverifiedException("Certificate chain is empty");
        }
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object removeFirst = arrayDeque.removeFirst();
        Intrinsics.checkNotNullExpressionValue(removeFirst, "queue.removeFirst()");
        arrayList.add(removeFirst);
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) CollectionsKt.last((List) arrayList);
            X509Certificate findTrustedCertByIssuerAndSignature = findTrustedCertByIssuerAndSignature(x509Certificate);
            if (findTrustedCertByIssuerAndSignature != null) {
                if (arrayList.size() > 1 || !Intrinsics.areEqual(x509Certificate, findTrustedCertByIssuerAndSignature)) {
                    arrayList.add(findTrustedCertByIssuerAndSignature);
                }
                if (isSignedBy(findTrustedCertByIssuerAndSignature, findTrustedCertByIssuerAndSignature)) {
                    return arrayList;
                }
                z = true;
            } else {
                Iterator it = arrayDeque.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    X509Certificate signingCert = (X509Certificate) obj;
                    Intrinsics.checkNotNullExpressionValue(signingCert, "signingCert");
                    if (isSignedBy(x509Certificate, signingCert)) {
                        break;
                    }
                }
                X509Certificate x509Certificate2 = (X509Certificate) obj;
                if (x509Certificate2 == null) {
                    if (z) {
                        return arrayList;
                    }
                    throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
                }
                arrayDeque.remove(x509Certificate2);
                arrayList.add(x509Certificate2);
            }
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }
}
