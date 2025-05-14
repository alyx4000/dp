package sdk.pendo.io.i1;

import java.io.ByteArrayInputStream;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

/* loaded from: classes6.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private CertificateFactory f1181a;

    public k() {
        try {
            this.f1181a = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e) {
            throw new IllegalStateException("Couldn't find X.509 CertificateFactory!?!", e);
        }
    }

    public static k b(String str) {
        if (str == null) {
            return new k();
        }
        try {
            return new k(str);
        } catch (NoSuchProviderException e) {
            throw new sdk.pendo.io.k1.g("Provider " + str + " not found when creating X509Util.", e);
        }
    }

    public X509Certificate a(String str) {
        try {
            return (X509Certificate) this.f1181a.generateCertificate(new ByteArrayInputStream(sdk.pendo.io.u0.a.a(str)));
        } catch (CertificateException e) {
            throw new sdk.pendo.io.k1.g("Unable to convert " + str + " value to X509Certificate: " + e, e);
        }
    }

    public k(String str) {
        try {
            this.f1181a = CertificateFactory.getInstance("X.509", str);
        } catch (CertificateException e) {
            throw new IllegalStateException("Couldn't find X.509 CertificateFactory!?!", e);
        }
    }

    public String a(X509Certificate x509Certificate) {
        try {
            return sdk.pendo.io.u0.a.a(x509Certificate.getEncoded());
        } catch (CertificateEncodingException e) {
            throw new IllegalStateException("Unexpected problem getting encoded certificate.", e);
        }
    }
}
