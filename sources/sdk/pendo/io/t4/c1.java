package sdk.pendo.io.t4;

import java.net.InetAddress;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLSocket;

/* loaded from: classes6.dex */
class c1 extends b1 {
    protected c1(e eVar) {
        super(eVar);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized BiFunction<SSLSocket, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return c0.a((sdk.pendo.io.r4.a) this.w0.p());
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setHandshakeApplicationProtocolSelector(BiFunction<SSLSocket, List<String>, String> biFunction) {
        this.w0.b(c0.a((BiFunction) biFunction));
    }

    protected c1(e eVar, String str, int i) {
        super(eVar, str, i);
    }

    protected c1(e eVar, String str, int i, InetAddress inetAddress, int i2) {
        super(eVar, str, i, inetAddress, i2);
    }

    protected c1(e eVar, InetAddress inetAddress, int i) {
        super(eVar, inetAddress, i);
    }

    protected c1(e eVar, InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        super(eVar, inetAddress, i, inetAddress2, i2);
    }

    c1(e eVar, boolean z, boolean z2, s0 s0Var) {
        super(eVar, z, z2, s0Var);
    }
}
