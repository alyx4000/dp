package com.quantummetric.ui.internal;

import android.net.http.X509TrustManagerExtensions;
import android.util.Base64;
import com.facebook.imagepipeline.producers.HttpUrlConnectionNetworkFetcher;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.quantummetric.ui.QuantumMetric;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes5.dex */
final class as implements Runnable {
    private static X509TrustManagerExtensions h;

    /* renamed from: a, reason: collision with root package name */
    byte[] f66a = null;
    int b = 100;
    private HttpsURLConnection d;
    private o<a> e;
    private boolean f;
    private static Set<String> g = new HashSet();
    static final ExecutorService c = Executors.newFixedThreadPool(4);

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f67a;
        String b = "";

        a() {
        }
    }

    as(String str, o<a> oVar) {
        this.f = false;
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            this.d = httpsURLConnection;
            httpsURLConnection.setReadTimeout(HttpUrlConnectionNetworkFetcher.HTTP_DEFAULT_TIMEOUT);
            if (aa.c && !str.contains("cdn") && !str.contains("crash-reports") && !str.contains("https://rl")) {
                this.f = true;
            }
        } catch (Exception unused) {
        }
        this.e = oVar;
    }

    private static X509TrustManagerExtensions a() {
        X509TrustManager x509TrustManager;
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            int length = trustManagers.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    x509TrustManager = null;
                    break;
                }
                TrustManager trustManager = trustManagers[i];
                if (trustManager instanceof X509TrustManager) {
                    x509TrustManager = (X509TrustManager) trustManager;
                    break;
                }
                i++;
            }
            return new X509TrustManagerExtensions(x509TrustManager);
        } catch (Exception unused) {
            return null;
        }
    }

    private static List<X509Certificate> a(X509TrustManagerExtensions x509TrustManagerExtensions, HttpsURLConnection httpsURLConnection) throws SSLException {
        Certificate[] serverCertificates = httpsURLConnection.getServerCertificates();
        if (serverCertificates == null || serverCertificates.length == 0) {
            throw new SSLException("conn.getServerCertificates() is null");
        }
        try {
            return x509TrustManagerExtensions.checkServerTrusted((X509Certificate[]) Arrays.copyOf(serverCertificates, serverCertificates.length, X509Certificate[].class), "RSA", httpsURLConnection.getURL().getHost());
        } catch (CertificateException e) {
            throw new SSLException(e);
        }
    }

    static void a(Set<String> set) {
        g.addAll(set);
        g.add("TFsSelruVaOEEdPmYHhFHMFWbw04FULvYVb7W+xVW5A=");
    }

    final as a(bf bfVar) {
        if (this.d != null) {
            for (Map.Entry<String, Object> entry : bfVar.entrySet()) {
                this.d.addRequestProperty(entry.getKey(), entry.getValue().toString());
            }
        }
        return this;
    }

    final as a(String str) {
        try {
            this.d.setRequestMethod(str);
        } catch (ProtocolException unused) {
        }
        return this;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = new a();
        try {
            if (this.f) {
                if (h == null) {
                    h = a();
                }
                this.d.connect();
                X509TrustManagerExtensions x509TrustManagerExtensions = h;
                HttpsURLConnection httpsURLConnection = this.d;
                StringBuilder sb = new StringBuilder();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                    for (X509Certificate x509Certificate : a(x509TrustManagerExtensions, httpsURLConnection)) {
                        byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                        messageDigest.update(encoded, 0, encoded.length);
                        String encodeToString = Base64.encodeToString(messageDigest.digest(), 2);
                        sb.append("sha256/").append(encodeToString).append(" : ").append(x509Certificate.getSubjectDN().toString()).append("\n");
                        if (g.contains(encodeToString)) {
                        }
                    }
                    throw new SSLPeerUnverifiedException("SimpleHttpCall: ".concat(String.valueOf(sb)));
                } catch (NoSuchAlgorithmException e) {
                    throw new SSLException(e);
                }
            }
            if (this.f66a != null) {
                this.d.getOutputStream().write(this.f66a);
            }
            aVar.f67a = this.d.getResponseCode();
            if (aVar.f67a == 200) {
                aVar.b = de.a(this.d.getInputStream(), this.b);
            }
        } catch (SSLException e2) {
            QuantumMetric.a("SSL Exception ".concat(String.valueOf(e2)));
        } catch (Exception unused) {
            if (!aa.A) {
                if (bm.f117a == null) {
                    bm.f117a = new bm();
                }
                if (bm.f117a.g) {
                    aa.A = true;
                    QuantumMetric.sendPage();
                }
            }
        }
        o<a> oVar = this.e;
        if (oVar != null) {
            oVar.a(aVar);
        }
    }
}
