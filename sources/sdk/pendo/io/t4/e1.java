package sdk.pendo.io.t4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
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
class e1 extends a1 implements i1 {
    private static final Logger I0 = Logger.getLogger(e1.class.getName());
    protected String A0;
    protected final e v0;
    protected final Socket w0;
    protected final boolean y0;
    protected final s0 z0;
    protected final a t0 = new a();
    protected final b u0 = new b();
    protected String B0 = null;
    protected boolean C0 = true;
    protected w2 E0 = null;
    protected j1 F0 = null;
    protected o0 G0 = null;
    protected y0 H0 = null;
    protected final InputStream x0 = null;
    protected boolean D0 = true;

    class a extends InputStream {
        a() {
        }

        @Override // java.io.InputStream
        public int available() {
            int a2;
            synchronized (e1.this) {
                w2 w2Var = e1.this.E0;
                a2 = w2Var == null ? 0 : w2Var.a();
            }
            return a2;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            e1.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            e1.this.a(true);
            byte[] bArr = new byte[1];
            if (e1.this.E0.c(bArr, 0, 1) < 0) {
                return -1;
            }
            return bArr[0] & UByte.MAX_VALUE;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (i2 < 1) {
                return 0;
            }
            e1.this.a(true);
            return e1.this.E0.c(bArr, i, i2);
        }
    }

    class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            e1.this.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (i2 > 0) {
                e1.this.a(true);
                e1.this.E0.g(bArr, i, i2);
            }
        }
    }

    protected e1(e eVar, Socket socket, String str, int i, boolean z) {
        this.A0 = null;
        this.v0 = eVar;
        this.w0 = a(socket);
        this.A0 = str;
        this.y0 = z;
        this.z0 = eVar.b().b(this.D0);
        q();
    }

    private static Socket a(Socket socket) {
        if (socket == null) {
            throw new NullPointerException("'s' cannot be null");
        }
        if (socket.isConnected()) {
            return socket;
        }
        throw new SocketException("'s' is not a connected socket");
    }

    @Override // sdk.pendo.io.t4.i1
    public sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr) {
        return b().e().a(strArr, (Principal[]) a0.a(principalArr), this);
    }

    @Override // java.net.Socket
    public void bind(SocketAddress socketAddress) {
        throw new SocketException("Wrapped socket should already be bound");
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
        w2 w2Var = this.E0;
        if (w2Var == null) {
            m();
        } else {
            w2Var.d();
        }
    }

    @Override // java.net.Socket
    public void connect(SocketAddress socketAddress, int i) {
        throw new SocketException("Wrapped socket should already be connected");
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized String e() {
        return this.B0;
    }

    protected void finalize() {
        try {
            close();
        } catch (IOException unused) {
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
        super.finalize();
    }

    @Override // javax.net.ssl.SSLSocket, sdk.pendo.io.r4.i
    public synchronized String getApplicationProtocol() {
        o0 o0Var;
        o0Var = this.G0;
        return o0Var == null ? null : o0Var.a();
    }

    @Override // java.net.Socket
    public SocketChannel getChannel() {
        return this.w0.getChannel();
    }

    @Override // javax.net.ssl.SSLSocket, sdk.pendo.io.t4.i1
    public synchronized boolean getEnableSessionCreation() {
        return this.C0;
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getEnabledCipherSuites() {
        return this.z0.e();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getEnabledProtocols() {
        return this.z0.k();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String getHandshakeApplicationProtocol() {
        y0 y0Var;
        y0Var = this.H0;
        return y0Var == null ? null : y0Var.p();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized SSLSession getHandshakeSession() {
        y0 y0Var;
        y0Var = this.H0;
        return y0Var == null ? null : y0Var.i();
    }

    @Override // java.net.Socket
    public InetAddress getInetAddress() {
        return this.w0.getInetAddress();
    }

    @Override // java.net.Socket
    public InputStream getInputStream() {
        return this.t0;
    }

    @Override // java.net.Socket
    public boolean getKeepAlive() {
        return this.w0.getKeepAlive();
    }

    @Override // java.net.Socket
    public InetAddress getLocalAddress() {
        return this.w0.getLocalAddress();
    }

    @Override // java.net.Socket
    public int getLocalPort() {
        return this.w0.getLocalPort();
    }

    @Override // java.net.Socket
    public SocketAddress getLocalSocketAddress() {
        return this.w0.getLocalSocketAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized boolean getNeedClientAuth() {
        return this.z0.j();
    }

    @Override // java.net.Socket
    public OutputStream getOutputStream() {
        return this.u0;
    }

    @Override // sdk.pendo.io.r4.i
    public synchronized sdk.pendo.io.r4.h getParameters() {
        return t1.a(this.z0);
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized String getPeerHost() {
        return this.A0;
    }

    @Override // sdk.pendo.io.t4.i1
    public int getPeerPort() {
        return getPort();
    }

    @Override // java.net.Socket
    public int getPort() {
        return this.w0.getPort();
    }

    @Override // java.net.Socket
    public int getReceiveBufferSize() {
        return this.w0.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public SocketAddress getRemoteSocketAddress() {
        return this.w0.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public boolean getReuseAddress() {
        return this.w0.getReuseAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized SSLParameters getSSLParameters() {
        return t1.b(this.z0);
    }

    @Override // java.net.Socket
    public int getSendBufferSize() {
        return this.w0.getSendBufferSize();
    }

    @Override // javax.net.ssl.SSLSocket
    public SSLSession getSession() {
        return p().i();
    }

    @Override // java.net.Socket
    public int getSoLinger() {
        return this.w0.getSoLinger();
    }

    @Override // java.net.Socket
    public int getSoTimeout() {
        return this.w0.getSoTimeout();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getSupportedCipherSuites() {
        return this.v0.b().f();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized String[] getSupportedProtocols() {
        return this.v0.b().g();
    }

    @Override // java.net.Socket
    public boolean getTcpNoDelay() {
        return this.w0.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public int getTrafficClass() {
        return this.w0.getTrafficClass();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized boolean getUseClientMode() {
        return this.D0;
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized boolean getWantClientAuth() {
        return this.z0.r();
    }

    @Override // java.net.Socket
    public boolean isBound() {
        return this.w0.isBound();
    }

    @Override // java.net.Socket
    public synchronized boolean isClosed() {
        boolean z;
        w2 w2Var = this.E0;
        if (w2Var != null) {
            z = w2Var.t();
        }
        return z;
    }

    @Override // java.net.Socket
    public boolean isConnected() {
        return this.w0.isConnected();
    }

    @Override // java.net.Socket
    public boolean isInputShutdown() {
        return this.w0.isInputShutdown();
    }

    @Override // java.net.Socket
    public boolean isOutputShutdown() {
        return this.w0.isOutputShutdown();
    }

    @Override // sdk.pendo.io.t4.a1
    protected void m() {
        if (this.y0) {
            this.w0.close();
        }
    }

    public synchronized sdk.pendo.io.r4.f o() {
        try {
            a(false);
        } catch (Exception e) {
            I0.log(Level.FINE, "Failed to establish connection", (Throwable) e);
        }
        return this.G0;
    }

    synchronized v0 p() {
        o0 o0Var;
        o();
        o0Var = this.G0;
        return o0Var == null ? v0.m : o0Var.b();
    }

    synchronized void q() {
        if (a0.a(this.A0)) {
            this.B0 = this.A0;
            return;
        }
        InetAddress inetAddress = getInetAddress();
        if (inetAddress == null) {
            return;
        }
        boolean z = this.D0;
        if (!z || !a1.A) {
            this.A0 = (z && a1.f0) ? inetAddress.getHostName() : inetAddress.getHostAddress();
            this.B0 = null;
        } else {
            String hostName = inetAddress.getHostName();
            this.A0 = hostName;
            this.B0 = hostName;
        }
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setEnableSessionCreation(boolean z) {
        this.C0 = z;
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setEnabledCipherSuites(String[] strArr) {
        this.z0.b(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setEnabledProtocols(String[] strArr) {
        this.z0.d(strArr);
    }

    @Override // java.net.Socket
    public void setKeepAlive(boolean z) {
        this.w0.setKeepAlive(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setNeedClientAuth(boolean z) {
        this.z0.a(z);
    }

    @Override // java.net.Socket
    public void setPerformancePreferences(int i, int i2, int i3) {
        this.w0.setPerformancePreferences(i, i2, i3);
    }

    @Override // java.net.Socket
    public void setReceiveBufferSize(int i) {
        this.w0.setReceiveBufferSize(i);
    }

    @Override // java.net.Socket
    public void setReuseAddress(boolean z) {
        this.w0.setReuseAddress(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setSSLParameters(SSLParameters sSLParameters) {
        t1.a(this.z0, sSLParameters);
    }

    @Override // java.net.Socket
    public void setSendBufferSize(int i) {
        this.w0.setSendBufferSize(i);
    }

    @Override // java.net.Socket
    public void setSoLinger(boolean z, int i) {
        this.w0.setSoLinger(z, i);
    }

    @Override // java.net.Socket
    public void setSoTimeout(int i) {
        this.w0.setSoTimeout(i);
    }

    @Override // java.net.Socket
    public void setTcpNoDelay(boolean z) {
        this.w0.setTcpNoDelay(z);
    }

    @Override // java.net.Socket
    public void setTrafficClass(int i) {
        this.w0.setTrafficClass(i);
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setUseClientMode(boolean z) {
        if (this.E0 != null) {
            throw new IllegalArgumentException("Mode cannot be changed after the initial handshake has begun");
        }
        if (this.D0 != z) {
            this.v0.b().a(this.z0, z);
            this.D0 = z;
        }
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void setWantClientAuth(boolean z) {
        this.z0.c(z);
    }

    @Override // java.net.Socket
    public void shutdownInput() {
        this.w0.shutdownInput();
    }

    @Override // java.net.Socket
    public void shutdownOutput() {
        this.w0.shutdownOutput();
    }

    @Override // javax.net.ssl.SSLSocket
    public synchronized void startHandshake() {
        b(true);
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public String toString() {
        return this.w0.toString();
    }

    @Override // sdk.pendo.io.t4.i1
    public sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr) {
        return b().e().b(strArr, (Principal[]) a0.a(principalArr), this);
    }

    @Override // sdk.pendo.io.t4.i1
    public e b() {
        return this.v0;
    }

    @Override // sdk.pendo.io.r4.i
    public synchronized sdk.pendo.io.r4.b a() {
        return this.H0;
    }

    protected void b(boolean z) {
        w2 w2Var = this.E0;
        if (w2Var != null) {
            if (!w2Var.u()) {
                throw new UnsupportedOperationException("Renegotiation not supported");
            }
            this.E0.e(z);
            this.E0.B();
            return;
        }
        InputStream inputStream = this.w0.getInputStream();
        if (this.x0 != null) {
            inputStream = new SequenceInputStream(this.x0, inputStream);
        }
        OutputStream outputStream = this.w0.getOutputStream();
        if (this.D0) {
            h1 h1Var = new h1(inputStream, outputStream, this.f);
            h1Var.e(z);
            this.E0 = h1Var;
            g1 g1Var = new g1(this, this.z0);
            this.F0 = g1Var;
            h1Var.a(g1Var);
            return;
        }
        l1 l1Var = new l1(inputStream, outputStream, this.f);
        l1Var.e(z);
        this.E0 = l1Var;
        k1 k1Var = new k1(this, this.z0);
        this.F0 = k1Var;
        l1Var.a(k1Var);
    }

    synchronized void a(boolean z) {
        w2 w2Var = this.E0;
        if (w2Var == null || w2Var.u()) {
            b(z);
        }
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized void a(o0 o0Var) {
        y0 y0Var = this.H0;
        if (y0Var != null) {
            if (!y0Var.isValid()) {
                o0Var.b().invalidate();
            }
            this.H0.q().a();
        }
        this.H0 = null;
        this.G0 = o0Var;
        a(o0Var.b().h);
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized void a(x0 x0Var, sdk.pendo.io.y4.a1 a1Var, y yVar, v0 v0Var) {
        String peerHost = getPeerHost();
        int peerPort = getPeerPort();
        if (v0Var != null) {
            this.H0 = new z0(x0Var, peerHost, peerPort, a1Var, yVar, v0Var.q(), v0Var.p());
        } else {
            this.H0 = new y0(x0Var, peerHost, peerPort, a1Var, yVar);
        }
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized String a(List<String> list) {
        return this.z0.p().a(this, list);
    }

    @Override // sdk.pendo.io.r4.i
    public synchronized void a(sdk.pendo.io.r4.h hVar) {
        t1.a(this.z0, hVar);
    }
}
