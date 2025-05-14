package sdk.pendo.io.t4;

import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.CertPath;
import java.security.cert.CertPathBuilder;
import java.security.cert.CertPathBuilderException;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreParameters;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.PKIXCertPathBuilderResult;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509TrustManager;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class q1 extends sdk.pendo.io.r4.k {
    private static final Logger f = Logger.getLogger(q1.class.getName());
    private static final boolean g = i0.b("com.sun.net.ssl.checkRevocation", false);
    private static final boolean h = i0.b("external.sdk.pendo.io.org.bouncycastle.jsse.trustManager.checkEKU", true);
    private static final Map<String, Integer> i = a();

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1603a;
    private final sdk.pendo.io.p4.b b;
    private final Set<X509Certificate> c;
    private final PKIXBuilderParameters d;
    private final X509TrustManager e;

    static class a extends X509CertSelector {
        final /* synthetic */ X509Certificate f;
        final /* synthetic */ CertSelector s;

        a(X509Certificate x509Certificate, CertSelector certSelector) {
            this.f = x509Certificate;
            this.s = certSelector;
            setCertificate(x509Certificate);
        }

        @Override // java.security.cert.X509CertSelector, java.security.cert.CertSelector
        public boolean match(Certificate certificate) {
            CertSelector certSelector;
            return super.match(certificate) && ((certSelector = this.s) == null || certSelector.match(certificate));
        }
    }

    q1(boolean z, sdk.pendo.io.p4.b bVar, PKIXParameters pKIXParameters) {
        this.f1603a = z;
        this.b = bVar;
        Set<X509Certificate> a2 = a(pKIXParameters.getTrustAnchors());
        this.c = a2;
        if (a2.isEmpty()) {
            this.d = null;
        } else if (pKIXParameters instanceof PKIXBuilderParameters) {
            this.d = (PKIXBuilderParameters) pKIXParameters;
        } else {
            PKIXBuilderParameters pKIXBuilderParameters = new PKIXBuilderParameters(pKIXParameters.getTrustAnchors(), pKIXParameters.getTargetCertConstraints());
            this.d = pKIXBuilderParameters;
            pKIXBuilderParameters.setAnyPolicyInhibited(pKIXParameters.isAnyPolicyInhibited());
            pKIXBuilderParameters.setCertPathCheckers(pKIXParameters.getCertPathCheckers());
            pKIXBuilderParameters.setCertStores(pKIXParameters.getCertStores());
            pKIXBuilderParameters.setDate(pKIXParameters.getDate());
            pKIXBuilderParameters.setExplicitPolicyRequired(pKIXParameters.isExplicitPolicyRequired());
            pKIXBuilderParameters.setInitialPolicies(pKIXParameters.getInitialPolicies());
            pKIXBuilderParameters.setPolicyMappingInhibited(pKIXParameters.isPolicyMappingInhibited());
            pKIXBuilderParameters.setPolicyQualifiersRejected(pKIXParameters.getPolicyQualifiersRejected());
            pKIXBuilderParameters.setRevocationEnabled(pKIXParameters.isRevocationEnabled());
            pKIXBuilderParameters.setSigProvider(pKIXParameters.getSigProvider());
        }
        this.e = z1.a(this);
    }

    private static void a(Map<String, Integer> map, int i2, int... iArr) {
        for (int i3 : iArr) {
            if (map.put(a0.a(i3), Integer.valueOf(i2)) != null) {
                throw new IllegalStateException("Duplicate keys in server key usages");
            }
        }
    }

    @Override // sdk.pendo.io.r4.k
    public void b(X509Certificate[] x509CertificateArr, String str, Socket socket) {
        a(x509CertificateArr, str, x1.a(socket), true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        a(x509CertificateArr, str, (x1) null, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        a(x509CertificateArr, str, (x1) null, true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        Set<X509Certificate> set = this.c;
        return (X509Certificate[]) set.toArray(new X509Certificate[set.size()]);
    }

    q1(boolean z, sdk.pendo.io.p4.b bVar, Set<TrustAnchor> set) {
        this.f1603a = z;
        this.b = bVar;
        Set<X509Certificate> a2 = a(set);
        this.c = a2;
        if (a2.isEmpty()) {
            this.d = null;
        } else {
            PKIXBuilderParameters pKIXBuilderParameters = new PKIXBuilderParameters(set, (CertSelector) null);
            this.d = pKIXBuilderParameters;
            pKIXBuilderParameters.setRevocationEnabled(g);
        }
        this.e = z1.a(this);
    }

    private static void a(CertPathBuilder certPathBuilder, PKIXBuilderParameters pKIXBuilderParameters, X509Certificate[] x509CertificateArr, List<byte[]> list) {
        HashMap hashMap = new HashMap();
        int min = Math.min(x509CertificateArr.length, list.size());
        for (int i2 = 0; i2 < min; i2++) {
            byte[] bArr = list.get(i2);
            if (bArr != null && bArr.length > 0) {
                X509Certificate x509Certificate = x509CertificateArr[i2];
                if (!hashMap.containsKey(x509Certificate)) {
                    hashMap.put(x509Certificate, bArr);
                }
            }
        }
        if (hashMap.isEmpty()) {
            return;
        }
        try {
            h0.a(certPathBuilder, pKIXBuilderParameters, hashMap);
        } catch (RuntimeException e) {
            f.log(Level.FINE, "Failed to add status responses for revocation checking", (Throwable) e);
        }
    }

    @Override // sdk.pendo.io.r4.k
    public void b(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) {
        a(x509CertificateArr, str, x1.a(sSLEngine), true);
    }

    private X509Certificate[] a(X509Certificate[] x509CertificateArr, sdk.pendo.io.s4.a aVar, List<byte[]> list) {
        CertStore certStore;
        CertPathBuilder certPathBuilder;
        X509Certificate x509Certificate = x509CertificateArr[0];
        if (this.c.contains(x509Certificate)) {
            return new X509Certificate[]{x509Certificate};
        }
        Provider provider = this.b.c("X.509").getProvider();
        CertStoreParameters a2 = a(x509Certificate, x509CertificateArr);
        try {
            certStore = CertStore.getInstance("Collection", a2, provider);
        } catch (GeneralSecurityException unused) {
            certStore = CertStore.getInstance("Collection", a2);
        }
        try {
            certPathBuilder = CertPathBuilder.getInstance("PKIX", provider);
        } catch (NoSuchAlgorithmException unused2) {
            certPathBuilder = CertPathBuilder.getInstance("PKIX");
        }
        PKIXBuilderParameters pKIXBuilderParameters = (PKIXBuilderParameters) this.d.clone();
        pKIXBuilderParameters.addCertPathChecker(new j0(this.f1603a, this.b, aVar));
        pKIXBuilderParameters.addCertStore(certStore);
        pKIXBuilderParameters.setTargetCertConstraints(a(x509Certificate, pKIXBuilderParameters.getTargetCertConstraints()));
        if (!list.isEmpty()) {
            a(certPathBuilder, pKIXBuilderParameters, x509CertificateArr, list);
        }
        PKIXCertPathBuilderResult pKIXCertPathBuilderResult = (PKIXCertPathBuilderResult) certPathBuilder.build(pKIXBuilderParameters);
        return a(pKIXCertPathBuilderResult.getCertPath(), pKIXCertPathBuilderResult.getTrustAnchor());
    }

    X509TrustManager b() {
        return this.e;
    }

    private X509Certificate[] b(X509Certificate[] x509CertificateArr, String str, x1 x1Var, boolean z) {
        try {
            sdk.pendo.io.s4.a a2 = x1.a(x1Var, false);
            X509Certificate[] a3 = a(x509CertificateArr, a2, x1.a(x1Var));
            j0.a(this.b, a2, a3, a(z), a(z, str));
            return a3;
        } catch (CertPathBuilderException e) {
            throw new CertificateException(e.getMessage(), e.getCause());
        } catch (CertificateException e2) {
            throw e2;
        } catch (GeneralSecurityException e3) {
            throw new CertificateException("Unable to construct a valid chain", e3);
        }
    }

    @Override // sdk.pendo.io.r4.k
    public void a(X509Certificate[] x509CertificateArr, String str, Socket socket) {
        a(x509CertificateArr, str, x1.a(socket), false);
    }

    @Override // sdk.pendo.io.r4.k
    public void a(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) {
        a(x509CertificateArr, str, x1.a(sSLEngine), false);
    }

    static void a(String str, X509Certificate x509Certificate, String str2) {
        boolean z;
        String f2 = a0.f(str);
        if (str2.equalsIgnoreCase("HTTPS")) {
            z = true;
        } else {
            if (!str2.equalsIgnoreCase("LDAP") && !str2.equalsIgnoreCase("LDAPS")) {
                throw new CertificateException("Unknown endpoint ID algorithm: " + str2);
            }
            z = false;
        }
        p.a(f2, x509Certificate, z);
    }

    private static void a(X509Certificate x509Certificate, String str, boolean z, sdk.pendo.io.r4.b bVar) {
        sdk.pendo.io.r4.c a2;
        String peerHost = bVar.getPeerHost();
        if (z && (a2 = a0.a(bVar.e())) != null) {
            String c = a2.c();
            if (!c.equalsIgnoreCase(peerHost)) {
                try {
                    a(c, x509Certificate, str);
                    return;
                } catch (CertificateException e) {
                    f.log(Level.FINE, "Server's endpoint ID did not match the SNI host_name: " + c, (Throwable) e);
                }
            }
        }
        a(peerHost, x509Certificate, str);
    }

    static void a(X509Certificate[] x509CertificateArr, x1 x1Var, boolean z) {
        if (x1Var != null) {
            String d = x1Var.b().d();
            if (a0.a(d)) {
                sdk.pendo.io.r4.b a2 = x1Var.a();
                if (a2 == null) {
                    throw new CertificateException("No handshake session");
                }
                a(x509CertificateArr[0], d, z, a2);
            }
        }
    }

    private void a(X509Certificate[] x509CertificateArr, String str, x1 x1Var, boolean z) {
        if (l3.b(x509CertificateArr)) {
            throw new IllegalArgumentException("'chain' must be a chain of at least one certificate");
        }
        if (l3.b(str)) {
            throw new IllegalArgumentException("'authType' must be a non-null, non-empty string");
        }
        if (this.d == null) {
            throw new CertificateException("Unable to build a CertPath: no PKIXBuilderParameters available");
        }
        a(b(x509CertificateArr, str, x1Var, z), x1Var, z);
    }

    private static Map<String, Integer> a() {
        HashMap hashMap = new HashMap();
        a(hashMap, 0, 3, 5, 17, 19, 0);
        a(hashMap, 2, 1);
        a(hashMap, 4, 7, 9, 16, 18);
        return Collections.unmodifiableMap(hashMap);
    }

    private static X509CertSelector a(X509Certificate x509Certificate, CertSelector certSelector) {
        return new a(x509Certificate, certSelector);
    }

    private CertStoreParameters a(X509Certificate x509Certificate, X509Certificate[] x509CertificateArr) {
        ArrayList arrayList = new ArrayList(x509CertificateArr.length);
        arrayList.add(x509Certificate);
        for (int i2 = 1; i2 < x509CertificateArr.length; i2++) {
            if (!this.c.contains(x509CertificateArr[i2])) {
                arrayList.add(x509CertificateArr[i2]);
            }
        }
        return new CollectionCertStoreParameters(Collections.unmodifiableCollection(arrayList));
    }

    static sdk.pendo.io.e4.f a(boolean z) {
        if (h) {
            return z ? sdk.pendo.io.e4.f.f0 : sdk.pendo.io.e4.f.t0;
        }
        return null;
    }

    static int a(boolean z, String str) {
        if (!z) {
            return 0;
        }
        Integer num = i.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new CertificateException("Unsupported server authType: " + str);
    }

    private static X509Certificate a(TrustAnchor trustAnchor) {
        X509Certificate trustedCert = trustAnchor.getTrustedCert();
        if (trustedCert != null) {
            return trustedCert;
        }
        throw new CertificateException("No certificate for TrustAnchor");
    }

    private static Set<X509Certificate> a(Set<TrustAnchor> set) {
        X509Certificate trustedCert;
        HashSet hashSet = new HashSet(set.size());
        for (TrustAnchor trustAnchor : set) {
            if (trustAnchor != null && (trustedCert = trustAnchor.getTrustedCert()) != null) {
                hashSet.add(trustedCert);
            }
        }
        return hashSet;
    }

    private static X509Certificate[] a(CertPath certPath, TrustAnchor trustAnchor) {
        List<? extends Certificate> certificates = certPath.getCertificates();
        int size = certificates.size() + 1;
        X509Certificate[] x509CertificateArr = new X509Certificate[size];
        certificates.toArray(x509CertificateArr);
        x509CertificateArr[size - 1] = a(trustAnchor);
        return x509CertificateArr;
    }
}
