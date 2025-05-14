package sdk.pendo.io.t4;

import java.util.List;
import java.util.function.BiFunction;
import javax.net.ssl.SSLEngine;

/* loaded from: classes6.dex */
class r0 extends q0 {
    protected r0(e eVar) {
        super(eVar);
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized BiFunction<SSLEngine, List<String>, String> getHandshakeApplicationProtocolSelector() {
        return c0.a((sdk.pendo.io.r4.a) this.s.h());
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setHandshakeApplicationProtocolSelector(BiFunction<SSLEngine, List<String>, String> biFunction) {
        this.s.a(c0.a((BiFunction) biFunction));
    }

    protected r0(e eVar, String str, int i) {
        super(eVar, str, i);
    }
}
