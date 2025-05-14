package sdk.pendo.io.t4;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509KeyManager;

/* loaded from: classes6.dex */
final class t extends sdk.pendo.io.r4.j {

    /* renamed from: a, reason: collision with root package name */
    final X509KeyManager f1613a;

    t(X509KeyManager x509KeyManager) {
        this.f1613a = x509KeyManager;
    }

    @Override // sdk.pendo.io.r4.j
    protected sdk.pendo.io.r4.l a(String str, String str2) {
        return n1.a(this.f1613a, str, str2);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        return this.f1613a.chooseClientAlias(strArr, principalArr, socket);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return this.f1613a.chooseServerAlias(str, principalArr, socket);
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        return this.f1613a.getCertificateChain(str);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return this.f1613a.getClientAliases(str, principalArr);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        return this.f1613a.getPrivateKey(str);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return this.f1613a.getServerAliases(str, principalArr);
    }

    @Override // sdk.pendo.io.r4.j
    protected sdk.pendo.io.r4.l a(boolean z, String str, String str2, Socket socket) {
        return n1.a(this.f1613a, z, str, str2, x1.a(socket));
    }
}
