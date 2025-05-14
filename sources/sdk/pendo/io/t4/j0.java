package sdk.pendo.io.t4;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

/* loaded from: classes6.dex */
class j0 extends PKIXCertPathChecker {
    private final sdk.pendo.io.s4.a A;
    private final boolean f;
    private X509Certificate f0;
    private final sdk.pendo.io.p4.b s;
    private static final Map<String, String> t0 = c();
    private static final Set<String> u0 = d();
    private static final byte[] v0 = {5, 0};
    private static final String w0 = a0.a("SHA256withRSAandMGF1", "RSASSA-PSS");
    private static final String x0 = a0.a("SHA384withRSAandMGF1", "RSASSA-PSS");
    private static final String y0 = a0.a("SHA512withRSAandMGF1", "RSASSA-PSS");
    private static final String z0 = a0.a("SHA256withRSAandMGF1", "RSA");
    private static final String A0 = a0.a("SHA384withRSAandMGF1", "RSA");
    private static final String B0 = a0.a("SHA512withRSAandMGF1", "RSA");

    j0(boolean z, sdk.pendo.io.p4.b bVar, sdk.pendo.io.s4.a aVar) {
        if (bVar == null) {
            throw new NullPointerException("'helper' cannot be null");
        }
        if (aVar == null) {
            throw new NullPointerException("'algorithmConstraints' cannot be null");
        }
        this.f = z;
        this.s = bVar;
        this.A = aVar;
        this.f0 = null;
    }

    static void a(sdk.pendo.io.p4.b bVar, sdk.pendo.io.s4.a aVar, X509Certificate[] x509CertificateArr, sdk.pendo.io.e4.f fVar, int i) {
        X509Certificate x509Certificate = x509CertificateArr[x509CertificateArr.length - 1];
        if (x509CertificateArr.length > 1) {
            a(bVar, aVar, x509CertificateArr[x509CertificateArr.length - 2], x509Certificate);
        }
        a(bVar, aVar, x509CertificateArr[0], fVar, i);
    }

    static Set<sdk.pendo.io.s4.b> b(int i) {
        return i != 2 ? i != 4 ? a0.i : a0.g : a0.h;
    }

    private static Map<String, String> c() {
        HashMap hashMap = new HashMap(4);
        hashMap.put(sdk.pendo.io.t3.a.d.l(), EdDSAParameterSpec.Ed25519);
        hashMap.put(sdk.pendo.io.t3.a.e.l(), EdDSAParameterSpec.Ed448);
        hashMap.put(sdk.pendo.io.x3.a.j.l(), "SHA1withDSA");
        hashMap.put(sdk.pendo.io.f4.h.Y.l(), "SHA1withDSA");
        return Collections.unmodifiableMap(hashMap);
    }

    private static Set<String> d() {
        HashSet hashSet = new HashSet();
        hashSet.add(sdk.pendo.io.x3.a.j.l());
        hashSet.add(sdk.pendo.io.f4.h.Y.l());
        hashSet.add(sdk.pendo.io.y3.a.k.l());
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void check(Certificate certificate) {
        check(certificate, Collections.emptySet());
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public Set<String> getSupportedExtensions() {
        return null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public void init(boolean z) {
        if (z) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        this.f0 = null;
    }

    @Override // java.security.cert.PKIXCertPathChecker, java.security.cert.CertPathChecker
    public boolean isForwardCheckingSupported() {
        return false;
    }

    static void a(boolean z, sdk.pendo.io.p4.b bVar, sdk.pendo.io.s4.a aVar, Set<X509Certificate> set, X509Certificate[] x509CertificateArr, sdk.pendo.io.e4.f fVar, int i) {
        int length = x509CertificateArr.length;
        while (length > 0 && set.contains(x509CertificateArr[length - 1])) {
            length--;
        }
        if (length < x509CertificateArr.length) {
            X509Certificate x509Certificate = x509CertificateArr[length];
            if (length > 0) {
                a(bVar, aVar, x509CertificateArr[length - 1], x509Certificate);
            }
        } else {
            a(bVar, aVar, x509CertificateArr[length - 1]);
        }
        j0 j0Var = new j0(z, bVar, aVar);
        j0Var.init(false);
        for (int i2 = length - 1; i2 >= 0; i2--) {
            j0Var.check(x509CertificateArr[i2], Collections.emptySet());
        }
        a(bVar, aVar, x509CertificateArr[0], fVar, i);
    }

    @Override // java.security.cert.PKIXCertPathChecker
    public void check(Certificate certificate, Collection<String> collection) {
        if (!(certificate instanceof X509Certificate)) {
            throw new CertPathValidatorException("checker can only be used for X.509 certificates");
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (this.f && !a(x509Certificate.getPublicKey())) {
            throw new CertPathValidatorException("non-FIPS public key found");
        }
        X509Certificate x509Certificate2 = this.f0;
        if (x509Certificate2 != null) {
            a(this.s, this.A, x509Certificate, x509Certificate2);
        }
        this.f0 = x509Certificate;
    }

    private static void a(sdk.pendo.io.p4.b bVar, sdk.pendo.io.s4.a aVar, X509Certificate x509Certificate, sdk.pendo.io.e4.f fVar, int i) {
        if (fVar != null && !a(x509Certificate, fVar)) {
            throw new CertPathValidatorException("Certificate doesn't support '" + a(fVar) + "' ExtendedKeyUsage");
        }
        if (i >= 0) {
            if (!a(x509Certificate, i)) {
                throw new CertPathValidatorException("Certificate doesn't support '" + a(i) + "' KeyUsage");
            }
            if (!aVar.permits(b(i), x509Certificate.getPublicKey())) {
                throw new CertPathValidatorException("Public key not permitted for '" + a(i) + "' KeyUsage");
            }
        }
    }

    private static void a(sdk.pendo.io.p4.b bVar, sdk.pendo.io.s4.a aVar, X509Certificate x509Certificate) {
        String a2 = a(x509Certificate, (X509Certificate) null);
        if (!a0.a(a2)) {
            throw new CertPathValidatorException("Signature algorithm could not be determined");
        }
        if (!aVar.permits(a0.i, a2, a(bVar, x509Certificate))) {
            throw new CertPathValidatorException("Signature algorithm '" + a2 + "' not permitted with given parameters");
        }
    }

    private static void a(sdk.pendo.io.p4.b bVar, sdk.pendo.io.s4.a aVar, X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        String a2 = a(x509Certificate, x509Certificate2);
        if (!a0.a(a2)) {
            throw new CertPathValidatorException("Signature algorithm could not be determined");
        }
        if (!aVar.permits(a0.i, a2, x509Certificate2.getPublicKey(), a(bVar, x509Certificate))) {
            throw new CertPathValidatorException("Signature algorithm '" + a2 + "' not permitted with given parameters and issuer public key");
        }
    }

    static String a(sdk.pendo.io.e4.f fVar) {
        return sdk.pendo.io.e4.f.t0.equals(fVar) ? "clientAuth" : sdk.pendo.io.e4.f.f0.equals(fVar) ? "serverAuth" : "(" + fVar + ")";
    }

    static String a(int i) {
        return i != 0 ? i != 2 ? i != 4 ? "(" + i + ")" : "keyAgreement" : "keyEncipherment" : "digitalSignature";
    }

    static String a(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        sdk.pendo.io.m3.v h;
        String sigAlgOID = x509Certificate.getSigAlgOID();
        String str = t0.get(sigAlgOID);
        if (str != null) {
            return str;
        }
        if (!sdk.pendo.io.y3.a.k.l().equals(sigAlgOID)) {
            return x509Certificate.getSigAlgName();
        }
        sdk.pendo.io.y3.c a2 = sdk.pendo.io.y3.c.a(x509Certificate.getSigAlgParams());
        if (a2 != null && (h = a2.h().h()) != null) {
            if (x509Certificate2 != null) {
                x509Certificate = x509Certificate2;
            }
            try {
                sdk.pendo.io.b5.g gVar = new sdk.pendo.io.b5.g((sdk.pendo.io.b5.h) null, x509Certificate);
                if (sdk.pendo.io.v3.b.c.b(h)) {
                    if (gVar.d((short) 9)) {
                        return w0;
                    }
                    if (gVar.d((short) 4)) {
                        return z0;
                    }
                } else if (sdk.pendo.io.v3.b.d.b(h)) {
                    if (gVar.d((short) 10)) {
                        return x0;
                    }
                    if (gVar.d((short) 5)) {
                        return A0;
                    }
                } else if (sdk.pendo.io.v3.b.e.b(h)) {
                    if (gVar.d((short) 11)) {
                        return y0;
                    }
                    if (gVar.d((short) 6)) {
                        return B0;
                    }
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    static AlgorithmParameters a(sdk.pendo.io.p4.b bVar, X509Certificate x509Certificate) {
        byte[] sigAlgParams = x509Certificate.getSigAlgParams();
        if (sigAlgParams == null) {
            return null;
        }
        String sigAlgOID = x509Certificate.getSigAlgOID();
        if (u0.contains(sigAlgOID) && sdk.pendo.io.d5.a.a(v0, sigAlgParams)) {
            return null;
        }
        try {
            AlgorithmParameters e = bVar.e(sigAlgOID);
            try {
                e.init(sigAlgParams);
                return e;
            } catch (Exception e2) {
                throw new CertPathValidatorException(e2);
            }
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    static boolean a(PublicKey publicKey) {
        try {
            sdk.pendo.io.e4.a h = sdk.pendo.io.e4.g.a(publicKey.getEncoded()).h();
            if (!sdk.pendo.io.f4.h.l.b(h.h())) {
                return true;
            }
            sdk.pendo.io.m3.g i = h.i();
            if (i != null) {
                return i.b() instanceof sdk.pendo.io.m3.v;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    static boolean a(PublicKey publicKey, boolean[] zArr, int i, sdk.pendo.io.s4.a aVar) {
        return a(zArr, i) && aVar.permits(b(i), publicKey);
    }

    static boolean a(X509Certificate x509Certificate, sdk.pendo.io.e4.f fVar) {
        try {
            return a(x509Certificate.getExtendedKeyUsage(), fVar);
        } catch (CertificateParsingException unused) {
            return false;
        }
    }

    static boolean a(List<String> list, sdk.pendo.io.e4.f fVar) {
        return list == null || list.contains(fVar.h()) || list.contains(sdk.pendo.io.e4.f.A.h());
    }

    static boolean a(X509Certificate x509Certificate, int i) {
        return a(x509Certificate.getKeyUsage(), i);
    }

    static boolean a(boolean[] zArr, int i) {
        return zArr == null || (zArr.length > i && zArr[i]);
    }
}
