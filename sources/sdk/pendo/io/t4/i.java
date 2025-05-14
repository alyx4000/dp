package sdk.pendo.io.t4;

import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;

/* loaded from: classes6.dex */
final class i extends sdk.pendo.io.r4.k {

    /* renamed from: a, reason: collision with root package name */
    static final sdk.pendo.io.r4.k f1585a = new i();

    private i() {
    }

    @Override // sdk.pendo.io.r4.k
    public void a(X509Certificate[] x509CertificateArr, String str, Socket socket) {
        throw new CertificateException("No X509TrustManager implementation available");
    }

    @Override // sdk.pendo.io.r4.k
    public void b(X509Certificate[] x509CertificateArr, String str, Socket socket) {
        throw new CertificateException("No X509TrustManager implementation available");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("No X509TrustManager implementation available");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        throw new CertificateException("No X509TrustManager implementation available");
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return a0.k;
    }

    @Override // sdk.pendo.io.r4.k
    public void a(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) {
        throw new CertificateException("No X509TrustManager implementation available");
    }

    @Override // sdk.pendo.io.r4.k
    public void b(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) {
        throw new CertificateException("No X509TrustManager implementation available");
    }
}
