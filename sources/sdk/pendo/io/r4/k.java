package sdk.pendo.io.r4;

import java.net.Socket;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes6.dex */
public abstract class k implements X509TrustManager {
    public abstract void a(X509Certificate[] x509CertificateArr, String str, Socket socket);

    public abstract void a(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine);

    public abstract void b(X509Certificate[] x509CertificateArr, String str, Socket socket);

    public abstract void b(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine);
}
