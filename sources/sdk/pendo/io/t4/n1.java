package sdk.pendo.io.t4;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.X509KeyManager;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class n1 implements sdk.pendo.io.r4.l {
    private static final Logger d = Logger.getLogger(n1.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final String f1593a;
    private final PrivateKey b;
    private final X509Certificate[] c;

    n1(String str, PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        this.f1593a = str;
        this.b = privateKey;
        this.c = x509CertificateArr;
    }

    static n1 a(X509KeyManager x509KeyManager, String str, String str2) {
        X509Certificate[] a2;
        PrivateKey b;
        if (x509KeyManager == null) {
            throw new NullPointerException("'x509KeyManager' cannot be null");
        }
        if (str == null || str2 == null || (a2 = a(x509KeyManager, str2)) == null || (b = b(x509KeyManager, str2)) == null) {
            return null;
        }
        return new n1(str, b, a2);
    }

    @Override // sdk.pendo.io.r4.l
    public X509Certificate[] b() {
        return (X509Certificate[]) this.c.clone();
    }

    @Override // sdk.pendo.io.r4.l
    public PrivateKey c() {
        return this.b;
    }

    private static X509Certificate[] a(X509KeyManager x509KeyManager, String str) {
        Logger logger;
        StringBuilder append;
        String str2;
        X509Certificate[] certificateChain = x509KeyManager.getCertificateChain(str);
        if (l3.b(certificateChain)) {
            logger = d;
            append = new StringBuilder("Rejecting alias '").append(str);
            str2 = "': no certificate chain";
        } else {
            X509Certificate[] x509CertificateArr = (X509Certificate[]) certificateChain.clone();
            if (!a0.b(x509CertificateArr)) {
                return x509CertificateArr;
            }
            logger = d;
            append = new StringBuilder("Rejecting alias '").append(str);
            str2 = "': invalid certificate chain";
        }
        logger.finer(append.append(str2).toString());
        return null;
    }

    private static PrivateKey b(X509KeyManager x509KeyManager, String str) {
        PrivateKey privateKey = x509KeyManager.getPrivateKey(str);
        if (privateKey != null) {
            return privateKey;
        }
        d.finer("Rejecting alias '" + str + "': no private key");
        return null;
    }

    @Override // sdk.pendo.io.r4.l
    public String a() {
        return this.f1593a;
    }

    static n1 a(X509KeyManager x509KeyManager, boolean z, String str, String str2, x1 x1Var) {
        X509Certificate[] a2;
        if (x509KeyManager == null) {
            throw new NullPointerException("'x509KeyManager' cannot be null");
        }
        if (str == null || str2 == null || (a2 = a(x509KeyManager, str2)) == null) {
            return null;
        }
        if (o1.a(z, str, a2[0], x1Var)) {
            PrivateKey b = b(x509KeyManager, str2);
            if (b == null) {
                return null;
            }
            return new n1(str, b, a2);
        }
        Logger logger = d;
        if (logger.isLoggable(Level.FINER)) {
            logger.finer("Rejecting alias '" + str2 + "': not suitable for key type '" + str + "'");
        }
        return null;
    }
}
