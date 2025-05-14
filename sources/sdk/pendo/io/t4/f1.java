package sdk.pendo.io.t4;

import java.net.Socket;
import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLSocket;

/* loaded from: classes6.dex */
class f1 extends e1 {
    protected f1(e eVar, Socket socket, String str, int i, boolean z) {
        super(eVar, socket, str, i, z);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized BiFunction<SSLSocket, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return c0.a((sdk.pendo.io.r4.a) this.z0.p());
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setHandshakeApplicationProtocolSelector(BiFunction<SSLSocket, List<String>, String> biFunction) {
        this.z0.b(c0.a((BiFunction) biFunction));
    }
}
