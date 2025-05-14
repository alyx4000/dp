package sdk.pendo.io.t4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import kotlin.UByte;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.w2;

/* loaded from: classes6.dex */
class b1 extends a1 implements i1 {
    private static final Logger F0 = Logger.getLogger(b1.class.getName());
    protected boolean A0;
    protected w2 B0;
    protected j1 C0;
    protected o0 D0;
    protected y0 E0;
    protected final a t0;
    protected final b u0;
    protected final e v0;
    protected final s0 w0;
    protected String x0;
    protected String y0;
    protected boolean z0;

    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            int a2;
            synchronized (b1.this) {
                w2 w2Var = b1.this.B0;
                a2 = w2Var == null ? 0 : w2Var.a();
            }
            return a2;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            b1.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            byte[] bArr = new byte[1];
            if (read(bArr, 0, 1) <= 0) {
                return -1;
            }
            return bArr[0] & UByte.MAX_VALUE;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (i2 < 1) {
                return 0;
            }
            b1.this.a(true);
            return b1.this.B0.c(bArr, i, i2);
        }
    }

    class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            b1.this.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (i2 > 0) {
                b1.this.a(true);
                b1.this.B0.g(bArr, i, i2);
            }
        }
    }

    protected b1(e eVar) {
        this.t0 = new a();
        this.u0 = new b();
        this.x0 = null;
        this.y0 = null;
        this.z0 = true;
        this.A0 = true;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.v0 = eVar;
        this.w0 = eVar.b().b(this.A0);
    }

    @Override // sdk.pendo.io.t4.i1
    public sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr) {
        return b().e().b(strArr, (Principal[]) a0.a(principalArr), this);
    }

    @Override // sdk.pendo.io.t4.i1
    public sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr) {
        return b().e().a(strArr, (Principal[]) a0.a(principalArr), this);
    }

    @Override // sdk.pendo.io.t4.i1
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        try {
            this.v0.f().a((X509Certificate[]) x509CertificateArr.clone(), str, this);
        } catch (CertificateException e) {
            throw new h2((short) 46, (Throwable) e);
        }
    }

    @Override // sdk.pendo.io.t4.i1
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        try {
            this.v0.f().b((X509Certificate[]) x509CertificateArr.clone(), str, this);
        } catch (CertificateException e) {
            throw new h2((short) 46, (Throwable) e);
        }
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        w2 w2Var = this.B0;
        if (w2Var == null) {
            m();
        } else {
            w2Var.d();
        }
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress, int i) {
        if (!(socketAddress instanceof InetSocketAddress)) {
            throw new SocketException("Only InetSocketAddress is supported.");
        }
        super.connect(socketAddress, i);
        q();
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized String e() {
        return this.y0;
    }

    protected void finalize() {
        try {
            try {
                try {
                    close();
                } finally {
                    super.finalize();
                }
            } catch (IOException unused) {
            }
        } catch (IOException unused2) {
            super.close();
        }
    }

    @Override // javax.net.ssl.SSLSocket, sdk.pendo.io.r4.i
    public synchronized String getApplicationProtocol() {
        o0 o0Var;
        o0Var = this.D0;
        return o0Var == null ? null : o0Var.a();
    }

    @Override // javax.net.ssl.SSLSocket, sdk.pendo.io.t4.i1
    public synchronized boolean getEnableSessionCreation() {
        return this.z0;
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getEnabledCipherSuites() {
        return this.w0.e();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getEnabledProtocols() {
        return this.w0.k();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String getHandshakeApplicationProtocol() {
        y0 y0Var;
        y0Var = this.E0;
        return y0Var == null ? null : y0Var.p();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized SSLSession getHandshakeSession() {
        y0 y0Var;
        y0Var = this.E0;
        return y0Var == null ? null : y0Var.i();
    }

    @Override // java.net.Socket
    public InputStream getInputStream() {
        return this.t0;
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized boolean getNeedClientAuth() {
        return this.w0.j();
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() {
        return this.u0;
    }

    @Override // sdk.pendo.io.r4.i
    public synchronized sdk.pendo.io.r4.h getParameters() {
        return t1.a(this.w0);
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized String getPeerHost() {
        return this.x0;
    }

    @Override // sdk.pendo.io.t4.i1
    public int getPeerPort() {
        return getPort();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized SSLParameters getSSLParameters() {
        return t1.b(this.w0);
    }

    @Override // javax.net.ssl.SSLSocket
    public SSLSession getSession() {
        return p().i();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getSupportedCipherSuites() {
        return this.v0.b().f();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getSupportedProtocols() {
        return this.v0.b().g();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized boolean getUseClientMode() {
        return this.A0;
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized boolean getWantClientAuth() {
        return this.w0.r();
    }

    public synchronized sdk.pendo.io.r4.f o() {
        try {
            a(false);
        } catch (IOException e) {
            F0.log(Level.FINE, "Failed to establish connection", (Throwable) e);
        }
        return this.D0;
    }

    synchronized v0 p() {
        o0 o0Var;
        o();
        o0Var = this.D0;
        return o0Var == null ? v0.m : o0Var.b();
    }

    synchronized void q() {
        if (a0.a(this.x0)) {
            this.y0 = this.x0;
            return;
        }
        InetAddress inetAddress = getInetAddress();
        if (inetAddress == null) {
            return;
        }
        boolean z = this.A0;
        if (!z || !a1.A) {
            this.x0 = (z && a1.f0) ? inetAddress.getHostName() : inetAddress.getHostAddress();
            this.y0 = null;
        } else {
            String hostName = inetAddress.getHostName();
            this.x0 = hostName;
            this.y0 = hostName;
        }
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setEnableSessionCreation(boolean z) {
        this.z0 = z;
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setEnabledCipherSuites(String[] strArr) {
        this.w0.b(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setEnabledProtocols(String[] strArr) {
        this.w0.d(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setNeedClientAuth(boolean z) {
        this.w0.a(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setSSLParameters(SSLParameters sSLParameters) {
        t1.a(this.w0, sSLParameters);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setUseClientMode(boolean z) {
        if (this.B0 != null) {
            throw new IllegalArgumentException("Mode cannot be changed after the initial handshake has begun");
        }
        if (this.A0 != z) {
            this.v0.b().a(this.w0, z);
            this.A0 = z;
        }
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setWantClientAuth(boolean z) {
        this.w0.c(z);
    }

    @Override // java.net.Socket
    public void shutdownInput() {
        throw new UnsupportedOperationException("shutdownInput() not supported in TLS");
    }

    @Override // java.net.Socket
    public void shutdownOutput() {
        throw new UnsupportedOperationException("shutdownOutput() not supported in TLS");
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void startHandshake() {
        b(true);
    }

    protected b1(e eVar, String str, int i) {
        this.t0 = new a();
        this.u0 = new b();
        this.x0 = null;
        this.y0 = null;
        this.z0 = true;
        this.A0 = true;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.v0 = eVar;
        this.w0 = eVar.b().b(this.A0);
        this.x0 = str;
        b(str, i);
    }

    @Override // sdk.pendo.io.r4.i
    public synchronized sdk.pendo.io.r4.b a() {
        return this.E0;
    }

    @Override // sdk.pendo.io.t4.i1
    public e b() {
        return this.v0;
    }

    protected b1(e eVar, String str, int i, InetAddress inetAddress, int i2) {
        this.t0 = new a();
        this.u0 = new b();
        this.x0 = null;
        this.y0 = null;
        this.z0 = true;
        this.A0 = true;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.v0 = eVar;
        this.w0 = eVar.b().b(this.A0);
        this.x0 = str;
        b(inetAddress, i2);
        b(str, i);
    }

    synchronized void a(boolean z) {
        w2 w2Var = this.B0;
        if (w2Var == null || w2Var.u()) {
            b(z);
        }
    }

    protected void b(boolean z) {
        w2 w2Var = this.B0;
        if (w2Var != null) {
            if (!w2Var.u()) {
                throw new UnsupportedOperationException("Renegotiation not supported");
            }
            this.B0.e(z);
            this.B0.B();
            return;
        }
        InputStream inputStream = super.getInputStream();
        OutputStream outputStream = super.getOutputStream();
        if (this.A0) {
            h1 h1Var = new h1(inputStream, outputStream, this.f);
            h1Var.e(z);
            this.B0 = h1Var;
            g1 g1Var = new g1(this, this.w0);
            this.C0 = g1Var;
            h1Var.a(g1Var);
            return;
        }
        l1 l1Var = new l1(inputStream, outputStream, this.f);
        l1Var.e(z);
        this.B0 = l1Var;
        k1 k1Var = new k1(this, this.w0);
        this.C0 = k1Var;
        l1Var.a(k1Var);
    }

    protected b1(e eVar, InetAddress inetAddress, int i) {
        this.t0 = new a();
        this.u0 = new b();
        this.x0 = null;
        this.y0 = null;
        this.z0 = true;
        this.A0 = true;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.v0 = eVar;
        this.w0 = eVar.b().b(this.A0);
        c(inetAddress, i);
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized void a(o0 o0Var) {
        y0 y0Var = this.E0;
        if (y0Var != null) {
            if (!y0Var.isValid()) {
                o0Var.b().invalidate();
            }
            this.E0.q().a();
        }
        this.E0 = null;
        this.D0 = o0Var;
        a(o0Var.b().h);
    }

    protected b1(e eVar, InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        this.t0 = new a();
        this.u0 = new b();
        this.x0 = null;
        this.y0 = null;
        this.z0 = true;
        this.A0 = true;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.v0 = eVar;
        this.w0 = eVar.b().b(this.A0);
        b(inetAddress2, i2);
        c(inetAddress, i);
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized void a(x0 x0Var, sdk.pendo.io.y4.a1 a1Var, y yVar, v0 v0Var) {
        String peerHost = getPeerHost();
        int peerPort = getPeerPort();
        if (v0Var != null) {
            this.E0 = new z0(x0Var, peerHost, peerPort, a1Var, yVar, v0Var.q(), v0Var.p());
        } else {
            this.E0 = new y0(x0Var, peerHost, peerPort, a1Var, yVar);
        }
    }

    b1(e eVar, boolean z, boolean z2, s0 s0Var) {
        this.t0 = new a();
        this.u0 = new b();
        this.x0 = null;
        this.y0 = null;
        this.B0 = null;
        this.C0 = null;
        this.D0 = null;
        this.E0 = null;
        this.v0 = eVar;
        this.z0 = z;
        this.A0 = z2;
        this.w0 = s0Var;
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized String a(List<String> list) {
        return this.w0.p().a(this, list);
    }

    @Override // sdk.pendo.io.r4.i
    public synchronized void a(sdk.pendo.io.r4.h hVar) {
        t1.a(this.w0, hVar);
    }
}
