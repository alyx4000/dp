package sdk.pendo.io.t4;

import java.lang.reflect.Constructor;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes6.dex */
abstract class z1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f1629a;
    private static final Constructor<? extends X509TrustManager> b;
    private static final Constructor<? extends sdk.pendo.io.r4.k> c;

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.String r0 = "javax.net.ssl.X509ExtendedTrustManager"
            r1 = 0
            java.lang.Class r2 = sdk.pendo.io.t4.r1.a(r0)     // Catch: java.lang.Exception -> L8
            goto L9
        L8:
            r2 = r1
        L9:
            sdk.pendo.io.t4.z1.f1629a = r2
            r2 = 0
            r3 = 1
            java.lang.reflect.Method[] r0 = sdk.pendo.io.t4.r1.b(r0)     // Catch: java.lang.Exception -> L20
            if (r0 == 0) goto L20
            java.lang.String r0 = "external.sdk.pendo.io.org.bouncycastle.jsse.provider.ExportX509TrustManager_7"
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L20
            java.lang.Class<sdk.pendo.io.r4.k> r5 = sdk.pendo.io.r4.k.class
            r4[r2] = r5     // Catch: java.lang.Exception -> L20
            java.lang.reflect.Constructor r0 = sdk.pendo.io.t4.r1.a(r0, r4)     // Catch: java.lang.Exception -> L20
            goto L21
        L20:
            r0 = r1
        L21:
            sdk.pendo.io.t4.z1.b = r0
            java.lang.Class<?> r0 = sdk.pendo.io.t4.z1.f1629a
            if (r0 == 0) goto L31
            java.lang.String r4 = "external.sdk.pendo.io.org.bouncycastle.jsse.provider.ImportX509TrustManager_7"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L31
            r3[r2] = r0     // Catch: java.lang.Exception -> L31
            java.lang.reflect.Constructor r1 = sdk.pendo.io.t4.r1.a(r4, r3)     // Catch: java.lang.Exception -> L31
        L31:
            sdk.pendo.io.t4.z1.c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.z1.<clinit>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static X509TrustManager a(sdk.pendo.io.r4.k kVar) {
        if (kVar instanceof v) {
            return ((v) kVar).unwrap();
        }
        Constructor<? extends X509TrustManager> constructor = b;
        if (constructor != null) {
            try {
                return constructor.newInstance(kVar);
            } catch (Exception unused) {
            }
        }
        return new n(kVar);
    }

    static sdk.pendo.io.r4.k a(boolean z, sdk.pendo.io.p4.b bVar, X509TrustManager x509TrustManager) {
        if (x509TrustManager instanceof sdk.pendo.io.r4.k) {
            return (sdk.pendo.io.r4.k) x509TrustManager;
        }
        if (x509TrustManager instanceof m) {
            return ((m) x509TrustManager).unwrap();
        }
        Constructor<? extends sdk.pendo.io.r4.k> constructor = c;
        if (constructor != null && f1629a.isInstance(x509TrustManager)) {
            try {
                return constructor.newInstance(x509TrustManager);
            } catch (Exception unused) {
            }
        }
        return new w(z, bVar, x509TrustManager);
    }
}
