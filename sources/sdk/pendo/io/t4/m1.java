package sdk.pendo.io.t4;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.cert.CertPathParameters;
import java.security.cert.Certificate;
import java.security.cert.PKIXParameters;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.CertPathTrustManagerParameters;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactorySpi;
import org.bouncycastle.jcajce.provider.keystore.util.AdaptingKeyStoreSpi;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
class m1 extends TrustManagerFactorySpi {
    private static final Logger d = Logger.getLogger(m1.class.getName());
    private static final boolean e = i0.a(AdaptingKeyStoreSpi.COMPAT_OVERRIDE, false);

    /* renamed from: a, reason: collision with root package name */
    protected final boolean f1590a;
    protected final sdk.pendo.io.p4.b b;
    protected q1 c;

    m1(boolean z, sdk.pendo.io.p4.b bVar) {
        this.f1590a = z;
        this.b = bVar;
    }

    private static void a(Set<TrustAnchor> set, Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            set.add(new TrustAnchor((X509Certificate) certificate, null));
        }
    }

    private static String b(String str) {
        String e2 = i0.e("javax.net.ssl.trustStoreType");
        return e2 == null ? str : e2;
    }

    @Override // javax.net.ssl.TrustManagerFactorySpi
    protected TrustManager[] engineGetTrustManagers() {
        q1 q1Var = this.c;
        if (q1Var != null) {
            return new TrustManager[]{q1Var.b()};
        }
        throw new IllegalStateException("TrustManagerFactory not initialized");
    }

    @Override // javax.net.ssl.TrustManagerFactorySpi
    protected void engineInit(KeyStore keyStore) {
        if (keyStore == null) {
            try {
                keyStore = a();
            } catch (Error e2) {
                d.log(Level.WARNING, "Skipped default trust store", (Throwable) e2);
                throw e2;
            } catch (SecurityException e3) {
                d.log(Level.WARNING, "Skipped default trust store", (Throwable) e3);
            } catch (RuntimeException e4) {
                d.log(Level.WARNING, "Skipped default trust store", (Throwable) e4);
                throw e4;
            } catch (Exception e5) {
                d.log(Level.WARNING, "Skipped default trust store", (Throwable) e5);
                throw new KeyStoreException("Failed to load default trust store", e5);
            }
        }
        try {
            this.c = new q1(this.f1590a, this.b, a(keyStore));
        } catch (InvalidAlgorithmParameterException e6) {
            throw new KeyStoreException("Failed to create trust manager", e6);
        }
    }

    private static KeyStore a(String str) {
        String b = b(str);
        String e2 = i0.e("javax.net.ssl.trustStoreProvider");
        return l3.b(e2) ? KeyStore.getInstance(b) : KeyStore.getInstance(b, e2);
    }

    @Override // javax.net.ssl.TrustManagerFactorySpi
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) {
        if (!(managerFactoryParameters instanceof CertPathTrustManagerParameters)) {
            if (managerFactoryParameters != null) {
                throw new InvalidAlgorithmParameterException("unknown spec: " + managerFactoryParameters.getClass().getName());
            }
            throw new InvalidAlgorithmParameterException("spec cannot be null");
        }
        CertPathParameters parameters = ((CertPathTrustManagerParameters) managerFactoryParameters).getParameters();
        if (!(parameters instanceof PKIXParameters)) {
            throw new InvalidAlgorithmParameterException("parameters must inherit from PKIXParameters");
        }
        this.c = new q1(this.f1590a, this.b, (PKIXParameters) parameters);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(1:46)(1:5)|6|(6:(9:(1:9)(2:35|(2:37|(1:(1:40))(2:41|(2:(1:44)|11))))|12|(1:14)(1:34)|15|(1:17)(1:32)|18|19|(1:21)|22)|18|19|(0)|22|(2:(1:26)|(0)))|45|12|(0)(0)|15|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(6:(9:(1:9)(2:35|(2:37|(1:(1:40))(2:41|(2:(1:44)|11))))|12|(1:14)(1:34)|15|(1:17)(1:32)|18|19|(1:21)|22)|18|19|(0)|22|(2:(1:26)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0030, code lost:
    
        if (new java.io.File(r3).exists() != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d0, code lost:
    
        r1 = java.security.KeyStore.getInstance("BCFKS");
        r1.load(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00df, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a3 A[Catch: all -> 0x00df, TRY_ENTER, TryCatch #2 {all -> 0x00df, blocks: (B:17:0x00a3, B:32:0x00ac), top: B:15:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00ac A[Catch: all -> 0x00df, TRY_LEAVE, TryCatch #2 {all -> 0x00df, blocks: (B:17:0x00a3, B:32:0x00ac), top: B:15:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.security.KeyStore a() {
        /*
            java.lang.String r0 = "Initializing default trust store from path: "
            java.lang.String r1 = java.security.KeyStore.getDefaultType()
            boolean r2 = sdk.pendo.io.t4.m1.e
            if (r2 == 0) goto L14
            java.lang.String r2 = "pkcs12"
            boolean r2 = r2.equalsIgnoreCase(r1)
            if (r2 == 0) goto L14
            r2 = 1
            goto L15
        L14:
            r2 = 0
        L15:
            java.lang.String r3 = "javax.net.ssl.trustStore"
            java.lang.String r3 = sdk.pendo.io.t4.i0.e(r3)
            java.lang.String r4 = "NONE"
            boolean r4 = r4.equals(r3)
            r5 = 0
            if (r4 == 0) goto L25
            goto L8e
        L25:
            if (r3 == 0) goto L33
            java.io.File r2 = new java.io.File
            r2.<init>(r3)
            boolean r2 = r2.exists()
            if (r2 == 0) goto L8e
            goto L8c
        L33:
            java.lang.String r3 = "java.home"
            java.lang.String r3 = sdk.pendo.io.t4.i0.e(r3)
            if (r3 == 0) goto L8e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r4 = r4.append(r3)
            java.lang.String r6 = java.io.File.separator
            java.lang.String r7 = "/lib/security/jssecacerts"
            java.lang.String r8 = "/"
            java.lang.String r7 = r7.replace(r8, r6)
            java.lang.StringBuilder r4 = r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.io.File r7 = new java.io.File
            r7.<init>(r4)
            boolean r7 = r7.exists()
            java.lang.String r9 = "jks"
            if (r7 == 0) goto L67
            if (r2 == 0) goto L8f
            r1 = r9
            goto L8f
        L67:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = "/lib/security/cacerts"
            java.lang.String r4 = r4.replace(r8, r6)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.io.File r4 = new java.io.File
            r4.<init>(r3)
            boolean r4 = r4.exists()
            if (r4 == 0) goto L8e
            if (r2 == 0) goto L8c
            r1 = r9
        L8c:
            r4 = r3
            goto L8f
        L8e:
            r4 = r5
        L8f:
            java.security.KeyStore r1 = a(r1)
            java.lang.String r2 = "javax.net.ssl.trustStorePassword"
            java.lang.String r2 = sdk.pendo.io.t4.i0.b(r2)
            if (r2 == 0) goto La0
            char[] r2 = r2.toCharArray()
            goto La1
        La0:
            r2 = r5
        La1:
            if (r4 != 0) goto Lac
            java.util.logging.Logger r0 = sdk.pendo.io.t4.m1.d     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r3 = "Initializing default trust store as empty"
            r0.config(r3)     // Catch: java.lang.Throwable -> Ldf
            r0 = r5
            goto Lc8
        Lac:
            java.util.logging.Logger r3 = sdk.pendo.io.t4.m1.d     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldf
            r6.<init>(r0)     // Catch: java.lang.Throwable -> Ldf
            java.lang.StringBuilder r0 = r6.append(r4)     // Catch: java.lang.Throwable -> Ldf
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Ldf
            r3.config(r0)     // Catch: java.lang.Throwable -> Ldf
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> Ldf
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> Ldf
            r3.<init>(r4)     // Catch: java.lang.Throwable -> Ldf
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Ldf
        Lc8:
            r1.load(r0, r2)     // Catch: java.lang.Throwable -> Lcc java.lang.NullPointerException -> Ld0
            goto Ld9
        Lcc:
            r1 = move-exception
            r5 = r0
            r0 = r1
            goto Le0
        Ld0:
            java.lang.String r1 = "BCFKS"
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch: java.lang.Throwable -> Lcc
            r1.load(r5, r5)     // Catch: java.lang.Throwable -> Lcc
        Ld9:
            if (r0 == 0) goto Lde
            r0.close()
        Lde:
            return r1
        Ldf:
            r0 = move-exception
        Le0:
            if (r5 == 0) goto Le5
            r5.close()
        Le5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.m1.a():java.security.KeyStore");
    }

    private static Set<TrustAnchor> a(KeyStore keyStore) {
        Certificate certificate;
        Certificate[] certificateChain;
        if (keyStore == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        Enumeration<String> aliases = keyStore.aliases();
        while (aliases.hasMoreElements()) {
            String nextElement = aliases.nextElement();
            if (keyStore.isCertificateEntry(nextElement)) {
                certificate = keyStore.getCertificate(nextElement);
            } else if (keyStore.isKeyEntry(nextElement) && (certificateChain = keyStore.getCertificateChain(nextElement)) != null && certificateChain.length > 0) {
                certificate = certificateChain[0];
            }
            a(hashSet, certificate);
        }
        return hashSet;
    }
}
