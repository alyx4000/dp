package sdk.pendo.io.t4;

import java.security.cert.CertPathBuilder;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.X509Certificate;
import java.util.Map;

/* loaded from: classes6.dex */
abstract class h0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f1584a;

    static {
        Class<?> cls;
        try {
            cls = r1.a("java.security.cert.PKIXRevocationChecker");
        } catch (Exception unused) {
            cls = null;
        }
        f1584a = cls;
    }

    static void a(CertPathBuilder certPathBuilder, PKIXBuilderParameters pKIXBuilderParameters, Map<X509Certificate, byte[]> map) {
        if (f1584a != null) {
            c0.a(certPathBuilder, pKIXBuilderParameters, map);
        }
    }
}
