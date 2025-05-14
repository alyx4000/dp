package sdk.pendo.io.t4;

import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLServerSocket;

/* loaded from: classes6.dex */
class t0 extends SSLServerSocket {
    protected boolean A;
    protected final e f;
    protected boolean f0;
    protected final s0 s;

    protected t0(e eVar) {
        this.A = true;
        this.f0 = false;
        this.f = eVar;
        this.s = eVar.b().b(this.f0);
    }

    @Override // java.net.ServerSocket
    public synchronized Socket accept() {
        b1 a2;
        a2 = v1.a(this.f, this.A, this.f0, this.s.a());
        implAccept(a2);
        a2.q();
        return a2;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized boolean getEnableSessionCreation() {
        return this.A;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized String[] getEnabledCipherSuites() {
        return this.s.e();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized String[] getEnabledProtocols() {
        return this.s.k();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized boolean getNeedClientAuth() {
        return this.s.j();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized SSLParameters getSSLParameters() {
        return t1.b(this.s);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized String[] getSupportedCipherSuites() {
        return this.f.b().f();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized String[] getSupportedProtocols() {
        return this.f.b().g();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized boolean getUseClientMode() {
        return this.f0;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized boolean getWantClientAuth() {
        return this.s.r();
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized void setEnableSessionCreation(boolean z) {
        this.A = z;
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized void setEnabledCipherSuites(String[] strArr) {
        this.s.b(strArr);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized void setEnabledProtocols(String[] strArr) {
        this.s.d(strArr);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized void setNeedClientAuth(boolean z) {
        this.s.a(z);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized void setSSLParameters(SSLParameters sSLParameters) {
        t1.a(this.s, sSLParameters);
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized void setUseClientMode(boolean z) {
        if (this.f0 != z) {
            this.f.b().a(this.s, z);
            this.f0 = z;
        }
    }

    @Override // javax.net.ssl.SSLServerSocket
    public synchronized void setWantClientAuth(boolean z) {
        this.s.c(z);
    }

    protected t0(e eVar, int i) {
        super(i);
        this.A = true;
        this.f0 = false;
        this.f = eVar;
        this.s = eVar.b().b(this.f0);
    }

    protected t0(e eVar, int i, int i2) {
        super(i, i2);
        this.A = true;
        this.f0 = false;
        this.f = eVar;
        this.s = eVar.b().b(this.f0);
    }

    protected t0(e eVar, int i, int i2, InetAddress inetAddress) {
        super(i, i2, inetAddress);
        this.A = true;
        this.f0 = false;
        this.f = eVar;
        this.s = eVar.b().b(this.f0);
    }
}
