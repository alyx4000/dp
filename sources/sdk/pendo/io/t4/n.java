package sdk.pendo.io.t4;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes6.dex */
class n implements X509TrustManager, m {

    /* renamed from: a, reason: collision with root package name */
    final sdk.pendo.io.r4.k f1591a;

    n(sdk.pendo.io.r4.k kVar) {
        this.f1591a = kVar;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.f1591a.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.f1591a.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.f1591a.getAcceptedIssuers();
    }

    @Override // sdk.pendo.io.t4.m
    public sdk.pendo.io.r4.k unwrap() {
        return this.f1591a;
    }
}
