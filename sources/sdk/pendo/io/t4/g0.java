package sdk.pendo.io.t4;

import java.math.BigInteger;
import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.util.Date;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.security.cert.X509Certificate;

/* loaded from: classes6.dex */
class g0 {

    private static class b extends X509Certificate {

        /* renamed from: a, reason: collision with root package name */
        private final java.security.cert.X509Certificate f1581a;

        private b(java.security.cert.X509Certificate x509Certificate) {
            this.f1581a = x509Certificate;
        }

        @Override // javax.security.cert.X509Certificate
        public void checkValidity() {
            try {
                this.f1581a.checkValidity();
            } catch (CertificateExpiredException e) {
                throw new javax.security.cert.CertificateExpiredException(e.getMessage());
            } catch (CertificateNotYetValidException e2) {
                throw new javax.security.cert.CertificateNotYetValidException(e2.getMessage());
            }
        }

        @Override // javax.security.cert.Certificate
        public byte[] getEncoded() {
            try {
                return this.f1581a.getEncoded();
            } catch (CertificateEncodingException e) {
                throw new javax.security.cert.CertificateEncodingException(e.getMessage());
            }
        }

        @Override // javax.security.cert.X509Certificate
        public Principal getIssuerDN() {
            return this.f1581a.getIssuerX500Principal();
        }

        @Override // javax.security.cert.X509Certificate
        public Date getNotAfter() {
            return this.f1581a.getNotAfter();
        }

        @Override // javax.security.cert.X509Certificate
        public Date getNotBefore() {
            return this.f1581a.getNotBefore();
        }

        @Override // javax.security.cert.Certificate
        public PublicKey getPublicKey() {
            return this.f1581a.getPublicKey();
        }

        @Override // javax.security.cert.X509Certificate
        public BigInteger getSerialNumber() {
            return this.f1581a.getSerialNumber();
        }

        @Override // javax.security.cert.X509Certificate
        public String getSigAlgName() {
            return this.f1581a.getSigAlgName();
        }

        @Override // javax.security.cert.X509Certificate
        public String getSigAlgOID() {
            return this.f1581a.getSigAlgOID();
        }

        @Override // javax.security.cert.X509Certificate
        public byte[] getSigAlgParams() {
            return this.f1581a.getSigAlgParams();
        }

        @Override // javax.security.cert.X509Certificate
        public Principal getSubjectDN() {
            return this.f1581a.getSubjectX500Principal();
        }

        @Override // javax.security.cert.X509Certificate
        public int getVersion() {
            return this.f1581a.getVersion() - 1;
        }

        @Override // javax.security.cert.Certificate
        public String toString() {
            return this.f1581a.toString();
        }

        @Override // javax.security.cert.Certificate
        public void verify(PublicKey publicKey) {
            try {
                this.f1581a.verify(publicKey);
            } catch (CertificateEncodingException e) {
                throw new javax.security.cert.CertificateEncodingException(e.getMessage());
            } catch (CertificateExpiredException e2) {
                throw new javax.security.cert.CertificateExpiredException(e2.getMessage());
            } catch (CertificateNotYetValidException e3) {
                throw new javax.security.cert.CertificateNotYetValidException(e3.getMessage());
            } catch (CertificateParsingException e4) {
                throw new javax.security.cert.CertificateParsingException(e4.getMessage());
            } catch (CertificateException e5) {
                throw new javax.security.cert.CertificateException(e5.getMessage());
            }
        }

        @Override // javax.security.cert.X509Certificate
        public void checkValidity(Date date) {
            try {
                this.f1581a.checkValidity(date);
            } catch (CertificateExpiredException e) {
                throw new javax.security.cert.CertificateExpiredException(e.getMessage());
            } catch (CertificateNotYetValidException e2) {
                throw new javax.security.cert.CertificateNotYetValidException(e2.getMessage());
            }
        }

        @Override // javax.security.cert.Certificate
        public void verify(PublicKey publicKey, String str) {
            try {
                this.f1581a.verify(publicKey, str);
            } catch (CertificateEncodingException e) {
                throw new javax.security.cert.CertificateEncodingException(e.getMessage());
            } catch (CertificateExpiredException e2) {
                throw new javax.security.cert.CertificateExpiredException(e2.getMessage());
            } catch (CertificateNotYetValidException e3) {
                throw new javax.security.cert.CertificateNotYetValidException(e3.getMessage());
            } catch (CertificateParsingException e4) {
                throw new javax.security.cert.CertificateParsingException(e4.getMessage());
            } catch (CertificateException e5) {
                throw new javax.security.cert.CertificateException(e5.getMessage());
            }
        }
    }

    static X509Certificate[] a(sdk.pendo.io.r4.b bVar) {
        boolean g = bVar.g();
        Certificate[] peerCertificates = bVar.getPeerCertificates();
        int length = peerCertificates.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        int i = 0;
        for (Certificate certificate : peerCertificates) {
            try {
                if (certificate instanceof java.security.cert.X509Certificate) {
                    java.security.cert.X509Certificate x509Certificate = (java.security.cert.X509Certificate) certificate;
                    int i2 = i + 1;
                    if (g) {
                        x509CertificateArr[i] = new b(x509Certificate);
                    } else {
                        x509CertificateArr[i] = X509Certificate.getInstance(x509Certificate.getEncoded());
                    }
                    i = i2;
                }
            } catch (Exception e) {
                throw new SSLPeerUnverifiedException(e.getMessage());
            }
        }
        if (i >= length) {
            return x509CertificateArr;
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[i];
        System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, i);
        return x509CertificateArr2;
    }
}
