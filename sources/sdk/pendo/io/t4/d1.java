package sdk.pendo.io.t4;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes6.dex */
class d1 extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    protected final e f1571a;

    d1(e eVar) {
        this.f1571a = eVar;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        return v1.a(this.f1571a);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f1571a.b().a(true);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f1571a.b().f();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i) {
        return v1.a(this.f1571a, str, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return v1.a(this.f1571a, str, i, inetAddress, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i) {
        return v1.a(this.f1571a, inetAddress, i);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return v1.a(this.f1571a, inetAddress, i, inetAddress2, i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        return v1.a(this.f1571a, socket, str, i, z);
    }
}
