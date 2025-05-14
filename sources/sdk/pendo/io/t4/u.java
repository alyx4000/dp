package sdk.pendo.io.t4;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;

/* loaded from: classes6.dex */
final class u extends sdk.pendo.io.r4.j {

    /* renamed from: a, reason: collision with root package name */
    final X509ExtendedKeyManager f1615a;

    u(X509ExtendedKeyManager x509ExtendedKeyManager) {
        this.f1615a = x509ExtendedKeyManager;
    }

    @Override // sdk.pendo.io.r4.j
    protected sdk.pendo.io.r4.l a(String str, String str2) {
        return n1.a(this.f1615a, str, str2);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        return this.f1615a.chooseClientAlias(strArr, principalArr, socket);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return this.f1615a.chooseEngineClientAlias(strArr, principalArr, sSLEngine);
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        return this.f1615a.chooseEngineServerAlias(str, principalArr, sSLEngine);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return this.f1615a.chooseServerAlias(str, principalArr, socket);
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        return this.f1615a.getCertificateChain(str);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return this.f1615a.getClientAliases(str, principalArr);
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        return this.f1615a.getPrivateKey(str);
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return this.f1615a.getServerAliases(str, principalArr);
    }

    @Override // sdk.pendo.io.r4.j
    protected sdk.pendo.io.r4.l a(boolean z, String str, String str2, Socket socket) {
        return n1.a(this.f1615a, z, str, str2, x1.a(socket));
    }

    @Override // sdk.pendo.io.r4.j
    protected sdk.pendo.io.r4.l a(boolean z, String str, String str2, SSLEngine sSLEngine) {
        return n1.a(this.f1615a, z, str, str2, x1.a(sSLEngine));
    }
}
