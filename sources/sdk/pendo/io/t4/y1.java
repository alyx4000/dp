package sdk.pendo.io.t4;

import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

/* loaded from: classes6.dex */
abstract class y1 {
    static sdk.pendo.io.r4.j a(sdk.pendo.io.p4.b bVar, X509KeyManager x509KeyManager) {
        return x509KeyManager instanceof sdk.pendo.io.r4.j ? (sdk.pendo.io.r4.j) x509KeyManager : x509KeyManager instanceof X509ExtendedKeyManager ? new u((X509ExtendedKeyManager) x509KeyManager) : new t(x509KeyManager);
    }
}
