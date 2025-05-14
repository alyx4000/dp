package sdk.pendo.io.t4;

import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* loaded from: classes6.dex */
abstract class v1 {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f1618a = new AtomicInteger();
    private static final Method b;
    private static final Method c;
    private static final boolean d;

    static {
        Method[] b2 = r1.b("javax.net.ssl.SSLSocket");
        b = r1.a(b2, "getHandshakeSession");
        c = r1.a(b2, "getSSLParameters");
        d = r1.b(b2, "getApplicationProtocol");
    }

    static b1 a(e eVar) {
        return d ? new c1(eVar) : new b1(eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static sdk.pendo.io.r4.h b(SSLSocket sSLSocket) {
        Method method;
        if (sSLSocket instanceof sdk.pendo.io.r4.i) {
            return ((sdk.pendo.io.r4.i) sSLSocket).getParameters();
        }
        if (sSLSocket == 0 || (method = c) == null) {
            return null;
        }
        SSLParameters sSLParameters = (SSLParameters) r1.a(sSLSocket, method);
        if (sSLParameters != null) {
            return t1.a(sSLParameters);
        }
        throw new RuntimeException("SSLSocket.getSSLParameters returned null");
    }

    static b1 a(e eVar, String str, int i) {
        return d ? new c1(eVar, str, i) : new b1(eVar, str, i);
    }

    static b1 a(e eVar, String str, int i, InetAddress inetAddress, int i2) {
        return d ? new c1(eVar, str, i, inetAddress, i2) : new b1(eVar, str, i, inetAddress, i2);
    }

    static b1 a(e eVar, InetAddress inetAddress, int i) {
        return d ? new c1(eVar, inetAddress, i) : new b1(eVar, inetAddress, i);
    }

    static b1 a(e eVar, InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return d ? new c1(eVar, inetAddress, i, inetAddress2, i2) : new b1(eVar, inetAddress, i, inetAddress2, i2);
    }

    static b1 a(e eVar, boolean z, boolean z2, s0 s0Var) {
        return d ? new c1(eVar, z, z2, s0Var) : new b1(eVar, z, z2, s0Var);
    }

    static e1 a(e eVar, Socket socket, String str, int i, boolean z) {
        return d ? new f1(eVar, socket, str, i, z) : new e1(eVar, socket, str, i, z);
    }

    static void a(Runnable runnable) {
        new Thread(runnable, "BCJSSE-HandshakeCompleted-" + (f1618a.getAndIncrement() & Integer.MAX_VALUE)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    static sdk.pendo.io.r4.b a(SSLSocket sSLSocket) {
        Method method;
        SSLSession sSLSession;
        if (sSLSocket instanceof sdk.pendo.io.r4.i) {
            return ((sdk.pendo.io.r4.i) sSLSocket).a();
        }
        if (sSLSocket == 0 || (method = b) == null || (sSLSession = (SSLSession) r1.a(sSLSocket, method)) == null) {
            return null;
        }
        return u1.a(sSLSession);
    }
}
