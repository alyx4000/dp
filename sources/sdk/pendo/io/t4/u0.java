package sdk.pendo.io.t4;

import java.net.InetAddress;
import java.net.ServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

/* loaded from: classes6.dex */
class u0 extends SSLServerSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    protected final e f1616a;

    u0(e eVar) {
        this.f1616a = eVar;
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket() {
        return new t0(this.f1616a);
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f1616a.b().a(false);
    }

    @Override // javax.net.ssl.SSLServerSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f1616a.b().f();
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i) {
        return new t0(this.f1616a, i);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2) {
        return new t0(this.f1616a, i, i2);
    }

    @Override // javax.net.ServerSocketFactory
    public ServerSocket createServerSocket(int i, int i2, InetAddress inetAddress) {
        return new t0(this.f1616a, i, i2, inetAddress);
    }
}
