package sdk.pendo.io.t4;

import java.net.Socket;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLSocket;

/* loaded from: classes6.dex */
class x1 {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.r4.h f1626a;
    private final sdk.pendo.io.r4.b b;

    private x1(sdk.pendo.io.r4.h hVar, sdk.pendo.io.r4.b bVar) {
        this.f1626a = hVar;
        this.b = bVar;
    }

    static x1 a(Socket socket) {
        SSLSocket sSLSocket;
        sdk.pendo.io.r4.h b;
        if ((socket instanceof SSLSocket) && socket.isConnected() && (b = v1.b((sSLSocket = (SSLSocket) socket))) != null) {
            return new x1(b, v1.a(sSLSocket));
        }
        return null;
    }

    sdk.pendo.io.r4.h b() {
        return this.f1626a;
    }

    List<byte[]> c() {
        sdk.pendo.io.r4.b bVar = this.b;
        return bVar == null ? Collections.emptyList() : bVar.f();
    }

    static x1 a(SSLEngine sSLEngine) {
        sdk.pendo.io.r4.h b;
        if (sSLEngine == null || (b = s1.b(sSLEngine)) == null) {
            return null;
        }
        return new x1(b, s1.a(sSLEngine));
    }

    static sdk.pendo.io.s4.a a(x1 x1Var, boolean z) {
        return x1Var == null ? k0.h : x1Var.a(z);
    }

    sdk.pendo.io.s4.a a(boolean z) {
        sdk.pendo.io.s4.a a2 = this.f1626a.a();
        k0 k0Var = k0.h;
        if (k0Var == a2) {
            a2 = null;
        }
        sdk.pendo.io.r4.b bVar = this.b;
        if (bVar != null && a0.c(bVar.getProtocol())) {
            String[] d = z ? this.b.d() : this.b.b();
            if (d != null) {
                return new k0(a2, d, true);
            }
        }
        return a2 == null ? k0Var : new k0(a2, true);
    }

    sdk.pendo.io.r4.b a() {
        return this.b;
    }

    static List<byte[]> a(x1 x1Var) {
        return x1Var == null ? Collections.emptyList() : x1Var.c();
    }
}
