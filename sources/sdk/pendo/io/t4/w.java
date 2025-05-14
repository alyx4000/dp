package sdk.pendo.io.t4;

import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509TrustManager;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class w extends sdk.pendo.io.r4.k implements v {

    /* renamed from: a, reason: collision with root package name */
    final boolean f1619a;
    final sdk.pendo.io.p4.b b;
    final X509TrustManager c;

    w(boolean z, sdk.pendo.io.p4.b bVar, X509TrustManager x509TrustManager) {
        this.f1619a = z;
        this.b = bVar;
        this.c = x509TrustManager;
    }

    private void a(X509Certificate[] x509CertificateArr, String str, x1 x1Var, boolean z) {
        b(x509CertificateArr, str, x1Var, z);
        q1.a(x509CertificateArr, x1Var, z);
    }

    private void b(X509Certificate[] x509CertificateArr, String str, x1 x1Var, boolean z) {
        try {
            j0.a(this.f1619a, this.b, x1.a(x1Var, false), a(), x509CertificateArr, q1.a(z), q1.a(z, str));
        } catch (GeneralSecurityException e) {
            throw new CertificateException("Certificates do not conform to algorithm constraints", e);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.c.checkClientTrusted(b(x509CertificateArr), str);
        a(x509CertificateArr, str, null, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        this.c.checkServerTrusted(b(x509CertificateArr), str);
        a(x509CertificateArr, str, null, true);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.c.getAcceptedIssuers();
    }

    @Override // sdk.pendo.io.t4.v
    public X509TrustManager unwrap() {
        return this.c;
    }

    private static X509Certificate[] a(X509Certificate[] x509CertificateArr) {
        if (l3.b(x509CertificateArr)) {
            throw new IllegalArgumentException("'chain' must be a chain of at least one certificate");
        }
        return x509CertificateArr;
    }

    @Override // sdk.pendo.io.r4.k
    public void b(X509Certificate[] x509CertificateArr, String str, Socket socket) {
        this.c.checkServerTrusted(b(x509CertificateArr), str);
        a(x509CertificateArr, str, x1.a(socket), true);
    }

    @Override // sdk.pendo.io.r4.k
    public void a(X509Certificate[] x509CertificateArr, String str, Socket socket) {
        this.c.checkClientTrusted(b(x509CertificateArr), str);
        a(x509CertificateArr, str, x1.a(socket), false);
    }

    @Override // sdk.pendo.io.r4.k
    public void b(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) {
        this.c.checkServerTrusted(b(x509CertificateArr), str);
        a(x509CertificateArr, str, x1.a(sSLEngine), true);
    }

    private static X509Certificate[] b(X509Certificate[] x509CertificateArr) {
        return (X509Certificate[]) a(x509CertificateArr).clone();
    }

    @Override // sdk.pendo.io.r4.k
    public void a(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) {
        this.c.checkClientTrusted(b(x509CertificateArr), str);
        a(x509CertificateArr, str, x1.a(sSLEngine), false);
    }

    private Set<X509Certificate> a() {
        X509Certificate[] acceptedIssuers = getAcceptedIssuers();
        if (l3.b(acceptedIssuers)) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (X509Certificate x509Certificate : acceptedIssuers) {
            if (x509Certificate != null) {
                hashSet.add(x509Certificate);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
