package sdk.pendo.io.t4;

import java.lang.reflect.Constructor;
import javax.net.ssl.SSLSession;

/* loaded from: classes6.dex */
abstract class u1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f1617a;
    private static final Constructor<? extends SSLSession> b;
    private static final Constructor<? extends sdk.pendo.io.r4.b> c;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            java.lang.String r0 = "getRequestedServerNames"
            java.lang.String r1 = "javax.net.ssl.ExtendedSSLSession"
            r2 = 0
            java.lang.Class r3 = sdk.pendo.io.t4.r1.a(r1)     // Catch: java.lang.Exception -> La
            goto Lb
        La:
            r3 = r2
        Lb:
            sdk.pendo.io.t4.u1.f1617a = r3
            r3 = 0
            r4 = 1
            java.lang.reflect.Method[] r5 = sdk.pendo.io.t4.r1.b(r1)     // Catch: java.lang.Exception -> L2b
            if (r5 == 0) goto L2b
            boolean r5 = sdk.pendo.io.t4.r1.b(r5, r0)     // Catch: java.lang.Exception -> L2b
            if (r5 == 0) goto L1e
            java.lang.String r5 = "external.sdk.pendo.io.org.bouncycastle.jsse.provider.ExportSSLSession_8"
            goto L20
        L1e:
            java.lang.String r5 = "external.sdk.pendo.io.org.bouncycastle.jsse.provider.ExportSSLSession_7"
        L20:
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L2b
            java.lang.Class<sdk.pendo.io.r4.b> r7 = sdk.pendo.io.r4.b.class
            r6[r3] = r7     // Catch: java.lang.Exception -> L2b
            java.lang.reflect.Constructor r5 = sdk.pendo.io.t4.r1.a(r5, r6)     // Catch: java.lang.Exception -> L2b
            goto L2c
        L2b:
            r5 = r2
        L2c:
            sdk.pendo.io.t4.u1.b = r5
            java.lang.Class<?> r5 = sdk.pendo.io.t4.u1.f1617a
            if (r5 == 0) goto L4b
            java.lang.reflect.Method[] r1 = sdk.pendo.io.t4.r1.b(r1)     // Catch: java.lang.Exception -> L4b
            if (r1 == 0) goto L4b
            boolean r0 = sdk.pendo.io.t4.r1.b(r1, r0)     // Catch: java.lang.Exception -> L4b
            if (r0 == 0) goto L41
            java.lang.String r0 = "external.sdk.pendo.io.org.bouncycastle.jsse.provider.ImportSSLSession_8"
            goto L43
        L41:
            java.lang.String r0 = "external.sdk.pendo.io.org.bouncycastle.jsse.provider.ImportSSLSession_7"
        L43:
            java.lang.Class[] r1 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L4b
            r1[r3] = r5     // Catch: java.lang.Exception -> L4b
            java.lang.reflect.Constructor r2 = sdk.pendo.io.t4.r1.a(r0, r1)     // Catch: java.lang.Exception -> L4b
        L4b:
            sdk.pendo.io.t4.u1.c = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.u1.<clinit>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    static SSLSession a(sdk.pendo.io.r4.b bVar) {
        if (bVar instanceof r) {
            return ((r) bVar).unwrap();
        }
        Constructor<? extends SSLSession> constructor = b;
        if (constructor != null) {
            try {
                return constructor.newInstance(bVar);
            } catch (Exception unused) {
            }
        }
        return new l(bVar);
    }

    static sdk.pendo.io.r4.b a(SSLSession sSLSession) {
        if (sSLSession instanceof sdk.pendo.io.r4.b) {
            return (sdk.pendo.io.r4.b) sSLSession;
        }
        if (sSLSession instanceof k) {
            return ((k) sSLSession).unwrap();
        }
        Constructor<? extends sdk.pendo.io.r4.b> constructor = c;
        if (constructor != null && f1617a.isInstance(sSLSession)) {
            try {
                return constructor.newInstance(sSLSession);
            } catch (Exception unused) {
            }
        }
        return new s(sSLSession);
    }
}
