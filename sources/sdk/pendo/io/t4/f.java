package sdk.pendo.io.t4;

import java.security.KeyManagementException;
import java.security.SecureRandom;
import java.util.logging.Logger;
import javax.net.ssl.KeyManager;
import javax.net.ssl.TrustManager;

/* loaded from: classes6.dex */
class f extends p0 {
    private static final Logger t = Logger.getLogger(f.class.getName());

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final Exception f1574a;
        private static final KeyManager[] b;
        private static final TrustManager[] c;

        /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
        static {
            /*
                r0 = 0
                javax.net.ssl.TrustManager[] r1 = sdk.pendo.io.t4.p0.e()     // Catch: java.lang.Exception -> L8
                r2 = r1
                r1 = r0
                goto L15
            L8:
                r1 = move-exception
                java.util.logging.Logger r2 = sdk.pendo.io.t4.f.i()
                java.util.logging.Level r3 = java.util.logging.Level.WARNING
                java.lang.String r4 = "Failed to load default trust managers"
                r2.log(r3, r4, r1)
                r2 = r0
            L15:
                if (r1 != 0) goto L28
                javax.net.ssl.KeyManager[] r3 = sdk.pendo.io.t4.p0.d()     // Catch: java.lang.Exception -> L1c
                goto L29
            L1c:
                r1 = move-exception
                java.util.logging.Logger r3 = sdk.pendo.io.t4.f.i()
                java.util.logging.Level r4 = java.util.logging.Level.WARNING
                java.lang.String r5 = "Failed to load default key managers"
                r3.log(r4, r5, r1)
            L28:
                r3 = r0
            L29:
                if (r1 == 0) goto L31
                java.lang.Exception r1 = sdk.pendo.io.t4.f.a(r1)
                r3 = r0
                goto L32
            L31:
                r0 = r2
            L32:
                sdk.pendo.io.t4.f.a.f1574a = r1
                sdk.pendo.io.t4.f.a.b = r3
                sdk.pendo.io.t4.f.a.c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.f.a.<clinit>():void");
        }
    }

    f(boolean z, sdk.pendo.io.b5.i iVar) {
        super(z, iVar, null);
        if (a.f1574a != null) {
            throw new KeyManagementException("Default key/trust managers unavailable", a.f1574a);
        }
        super.engineInit(a.b, a.c, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Exception b(Exception exc) {
        return new KeyManagementException(exc.getMessage());
    }

    @Override // sdk.pendo.io.t4.p0, javax.net.ssl.SSLContextSpi
    protected void engineInit(KeyManager[] keyManagerArr, TrustManager[] trustManagerArr, SecureRandom secureRandom) {
        throw new KeyManagementException("Default SSLContext is initialized automatically");
    }
}
