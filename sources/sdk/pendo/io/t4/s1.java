package sdk.pendo.io.t4;

import java.lang.reflect.Method;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

/* loaded from: classes6.dex */
abstract class s1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Method f1612a;
    private static final Method b;
    private static final boolean c;

    static {
        Method[] b2 = r1.b("javax.net.ssl.SSLEngine");
        f1612a = r1.a(b2, "getHandshakeSession");
        b = r1.a(b2, "getSSLParameters");
        c = r1.b(b2, "getApplicationProtocol");
    }

    static SSLEngine a(e eVar) {
        return c ? new r0(eVar) : new q0(eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static sdk.pendo.io.r4.h b(SSLEngine sSLEngine) {
        Method method;
        if (sSLEngine instanceof sdk.pendo.io.r4.g) {
            return ((sdk.pendo.io.r4.g) sSLEngine).getParameters();
        }
        if (sSLEngine == 0 || (method = b) == null) {
            return null;
        }
        SSLParameters sSLParameters = (SSLParameters) r1.a(sSLEngine, method);
        if (sSLParameters != null) {
            return t1.a(sSLParameters);
        }
        throw new RuntimeException("SSLEngine.getSSLParameters returned null");
    }

    static SSLEngine a(e eVar, String str, int i) {
        return c ? new r0(eVar, str, i) : new q0(eVar, str, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static sdk.pendo.io.r4.b a(SSLEngine sSLEngine) {
        Method method;
        SSLSession sSLSession;
        if (sSLEngine instanceof sdk.pendo.io.r4.g) {
            return ((sdk.pendo.io.r4.g) sSLEngine).a();
        }
        if (sSLEngine == 0 || (method = f1612a) == null || (sSLSession = (SSLSession) r1.a(sSLEngine, method)) == null) {
            return null;
        }
        return u1.a(sSLSession);
    }
}
