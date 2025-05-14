package sdk.pendo.io.t4;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;

/* loaded from: classes6.dex */
abstract class t1 {

    /* renamed from: a, reason: collision with root package name */
    private static final Method f1614a;
    private static final Method b;
    private static final Method c;
    private static final Method d;
    private static final Method e;
    private static final Method f;
    private static final Method g;
    private static final Method h;
    private static final Method i;
    private static final Method j;
    private static final Method k;
    private static final Method l;
    private static final Method m;
    private static final Method n;

    static {
        Method[] b2 = r1.b("javax.net.ssl.SSLParameters");
        f1614a = r1.a(b2, "getAlgorithmConstraints");
        b = r1.a(b2, "setAlgorithmConstraints");
        c = r1.a(b2, "getApplicationProtocols");
        d = r1.a(b2, "setApplicationProtocols");
        e = r1.a(b2, "getEndpointIdentificationAlgorithm");
        f = r1.a(b2, "setEndpointIdentificationAlgorithm");
        g = r1.a(b2, "getServerNames");
        h = r1.a(b2, "setServerNames");
        i = r1.a(b2, "getSNIMatchers");
        j = r1.a(b2, "setSNIMatchers");
        k = r1.a(b2, "getUseCipherSuitesOrder");
        l = r1.a(b2, "setUseCipherSuitesOrder");
        m = r1.a(b2, "getMaximumPacketSize");
        n = r1.a(b2, "setMaximumPacketSize");
    }

    private static Object a(Object obj, Method method) {
        return r1.a(obj, method);
    }

    static SSLParameters b(s0 s0Var) {
        String[] d2;
        Collection<sdk.pendo.io.r4.d> m2;
        List<sdk.pendo.io.r4.e> n2;
        SSLParameters sSLParameters = new SSLParameters(s0Var.e(), s0Var.k());
        if (s0Var.j()) {
            sSLParameters.setNeedClientAuth(true);
        } else if (s0Var.r()) {
            sSLParameters.setWantClientAuth(true);
        } else {
            sSLParameters.setWantClientAuth(false);
        }
        Method method = b;
        if (method != null) {
            a(sSLParameters, method, b0.b(s0Var.c()));
        }
        Method method2 = f;
        if (method2 != null) {
            a(sSLParameters, method2, s0Var.g());
        }
        Method method3 = l;
        if (method3 != null) {
            a(sSLParameters, method3, Boolean.valueOf(s0Var.q()));
        }
        Method method4 = h;
        if (method4 != null && (n2 = s0Var.n()) != null) {
            a(sSLParameters, method4, c0.d(n2));
        }
        Method method5 = j;
        if (method5 != null && (m2 = s0Var.m()) != null) {
            a(sSLParameters, method5, c0.b(m2));
        }
        Method method6 = d;
        if (method6 != null && (d2 = s0Var.d()) != null) {
            a(sSLParameters, method6, d2);
        }
        Method method7 = n;
        if (method7 != null) {
            a(sSLParameters, method7, Integer.valueOf(s0Var.i()));
        }
        return sSLParameters;
    }

    static sdk.pendo.io.r4.h a(s0 s0Var) {
        sdk.pendo.io.r4.h hVar = new sdk.pendo.io.r4.h(s0Var.e(), s0Var.k());
        if (s0Var.j()) {
            hVar.a(true);
        } else if (s0Var.r()) {
            hVar.c(true);
        } else {
            hVar.c(false);
        }
        hVar.a(s0Var.c());
        hVar.a(s0Var.g());
        hVar.b(s0Var.q());
        hVar.a(s0Var.n());
        hVar.b(s0Var.m());
        hVar.a(s0Var.d());
        hVar.a(s0Var.i());
        return hVar;
    }

    static sdk.pendo.io.r4.h a(SSLParameters sSLParameters) {
        String[] strArr;
        Object a2;
        Object a3;
        String str;
        Object a4;
        sdk.pendo.io.r4.h hVar = new sdk.pendo.io.r4.h(sSLParameters.getCipherSuites(), sSLParameters.getProtocols());
        if (sSLParameters.getNeedClientAuth()) {
            hVar.a(true);
        } else if (sSLParameters.getWantClientAuth()) {
            hVar.c(true);
        } else {
            hVar.c(false);
        }
        Method method = f1614a;
        if (method != null && (a4 = a(sSLParameters, method)) != null) {
            hVar.a(b0.a(a4));
        }
        Method method2 = e;
        if (method2 != null && (str = (String) a(sSLParameters, method2)) != null) {
            hVar.a(str);
        }
        Method method3 = k;
        if (method3 != null) {
            hVar.b(((Boolean) a(sSLParameters, method3)).booleanValue());
        }
        Method method4 = g;
        if (method4 != null && (a3 = a(sSLParameters, method4)) != null) {
            hVar.a(c0.c(a3));
        }
        Method method5 = i;
        if (method5 != null && (a2 = a(sSLParameters, method5)) != null) {
            hVar.b(c0.b(a2));
        }
        Method method6 = c;
        if (method6 != null && (strArr = (String[]) a(sSLParameters, method6)) != null) {
            hVar.a(strArr);
        }
        Method method7 = m;
        if (method7 != null) {
            hVar.a(((Integer) a(sSLParameters, method7)).intValue());
        }
        return hVar;
    }

    private static void a(Object obj, Method method, Object obj2) {
        r1.a(obj, method, obj2);
    }

    static void a(s0 s0Var, sdk.pendo.io.r4.h hVar) {
        String[] c2 = hVar.c();
        if (c2 != null) {
            s0Var.b(c2);
        }
        String[] g2 = hVar.g();
        if (g2 != null) {
            s0Var.d(g2);
        }
        if (hVar.f()) {
            s0Var.a(true);
        } else if (hVar.k()) {
            s0Var.c(true);
        } else {
            s0Var.c(false);
        }
        sdk.pendo.io.s4.a a2 = hVar.a();
        if (a2 != null) {
            s0Var.a(a2);
        }
        String d2 = hVar.d();
        if (d2 != null) {
            s0Var.a(d2);
        }
        s0Var.b(hVar.j());
        List<sdk.pendo.io.r4.e> i2 = hVar.i();
        if (i2 != null) {
            s0Var.a(i2);
        }
        Collection<sdk.pendo.io.r4.d> h2 = hVar.h();
        if (h2 != null) {
            s0Var.b(h2);
        }
        String[] b2 = hVar.b();
        if (b2 != null) {
            s0Var.a(b2);
        }
        s0Var.a(hVar.e());
    }

    static void a(s0 s0Var, SSLParameters sSLParameters) {
        String[] strArr;
        Object a2;
        Object a3;
        String str;
        Object a4;
        String[] cipherSuites = sSLParameters.getCipherSuites();
        if (cipherSuites != null) {
            s0Var.b(cipherSuites);
        }
        String[] protocols = sSLParameters.getProtocols();
        if (protocols != null) {
            s0Var.d(protocols);
        }
        if (sSLParameters.getNeedClientAuth()) {
            s0Var.a(true);
        } else if (sSLParameters.getWantClientAuth()) {
            s0Var.c(true);
        } else {
            s0Var.c(false);
        }
        Method method = f1614a;
        if (method != null && (a4 = a(sSLParameters, method)) != null) {
            s0Var.a(b0.a(a4));
        }
        Method method2 = e;
        if (method2 != null && (str = (String) a(sSLParameters, method2)) != null) {
            s0Var.a(str);
        }
        Method method3 = k;
        if (method3 != null) {
            s0Var.b(((Boolean) a(sSLParameters, method3)).booleanValue());
        }
        Method method4 = g;
        if (method4 != null && (a3 = a(sSLParameters, method4)) != null) {
            s0Var.a(c0.c(a3));
        }
        Method method5 = i;
        if (method5 != null && (a2 = a(sSLParameters, method5)) != null) {
            s0Var.b(c0.b(a2));
        }
        Method method6 = c;
        if (method6 != null && (strArr = (String[]) a(sSLParameters, method6)) != null) {
            s0Var.a(strArr);
        }
        Method method7 = m;
        if (method7 != null) {
            s0Var.a(((Integer) a(sSLParameters, method7)).intValue());
        }
    }
}
