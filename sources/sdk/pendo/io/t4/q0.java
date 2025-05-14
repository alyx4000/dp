package sdk.pendo.io.t4;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.i3;
import sdk.pendo.io.y4.w2;

/* loaded from: classes6.dex */
class q0 extends SSLEngine implements sdk.pendo.io.r4.g, i1 {
    private static final Logger C0 = Logger.getLogger(q0.class.getName());
    static final /* synthetic */ boolean D0 = true;
    protected boolean A;
    protected y0 A0;
    protected SSLException B0;
    protected final e f;
    protected boolean f0;
    protected final s0 s;
    protected boolean t0;
    protected boolean u0;
    protected boolean v0;
    protected SSLEngineResult.HandshakeStatus w0;
    protected w2 x0;
    protected j1 y0;
    protected o0 z0;

    protected q0(e eVar) {
        this(eVar, null, -1);
    }

    @Override // sdk.pendo.io.t4.i1
    public sdk.pendo.io.r4.l a(String[] strArr, Principal[] principalArr) {
        return b().e().b(strArr, (Principal[]) a0.a(principalArr), this);
    }

    @Override // sdk.pendo.io.t4.i1
    public sdk.pendo.io.r4.l b(String[] strArr, Principal[] principalArr) {
        return b().e().a(strArr, (Principal[]) a0.a(principalArr), this);
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void beginHandshake() {
        SSLEngineResult.HandshakeStatus handshakeStatus;
        if (!this.t0) {
            throw new IllegalStateException("Client/Server mode must be set before the handshake can begin");
        }
        if (this.u0) {
            throw new SSLException("Connection is already closed");
        }
        if (this.v0) {
            throw new UnsupportedOperationException("Renegotiation not supported");
        }
        this.v0 = true;
        try {
            if (this.f0) {
                sdk.pendo.io.y4.p1 p1Var = new sdk.pendo.io.y4.p1();
                this.x0 = p1Var;
                g1 g1Var = new g1(this, this.s);
                this.y0 = g1Var;
                p1Var.a(g1Var);
                handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_WRAP;
            } else {
                i3 i3Var = new i3();
                this.x0 = i3Var;
                k1 k1Var = new k1(this, this.s);
                this.y0 = k1Var;
                i3Var.a(k1Var);
                handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
            }
            this.w0 = handshakeStatus;
        } catch (SSLException e) {
            throw e;
        } catch (IOException e2) {
            throw new SSLException(e2);
        }
    }

    v0 c() {
        o0 o0Var = this.z0;
        return o0Var == null ? v0.m : o0Var.b();
    }

    @Override // sdk.pendo.io.t4.i1
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        try {
            this.f.f().a((X509Certificate[]) x509CertificateArr.clone(), str, this);
        } catch (CertificateException e) {
            throw new h2((short) 46, (Throwable) e);
        }
    }

    @Override // sdk.pendo.io.t4.i1
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        try {
            this.f.f().b((X509Certificate[]) x509CertificateArr.clone(), str, this);
        } catch (CertificateException e) {
            throw new h2((short) 46, (Throwable) e);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void closeInbound() {
        if (!this.u0) {
            w2 w2Var = this.x0;
            if (w2Var == null) {
                this.u0 = true;
            } else {
                try {
                    w2Var.f();
                } catch (IOException e) {
                    throw new SSLException(e);
                }
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void closeOutbound() {
        if (!this.u0) {
            w2 w2Var = this.x0;
            if (w2Var == null) {
                this.u0 = true;
            } else {
                try {
                    w2Var.d();
                } catch (IOException e) {
                    C0.log(Level.WARNING, "Failed to close outbound", (Throwable) e);
                }
            }
        }
    }

    @Override // sdk.pendo.io.t4.i1
    public String e() {
        return super.getPeerHost();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized String getApplicationProtocol() {
        o0 o0Var;
        o0Var = this.z0;
        return o0Var == null ? null : o0Var.a();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized Runnable getDelegatedTask() {
        return null;
    }

    @Override // javax.net.ssl.SSLEngine, sdk.pendo.io.t4.i1
    public synchronized boolean getEnableSessionCreation() {
        return this.A;
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized String[] getEnabledCipherSuites() {
        return this.s.e();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized String[] getEnabledProtocols() {
        return this.s.k();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized String getHandshakeApplicationProtocol() {
        y0 y0Var;
        y0Var = this.A0;
        return y0Var == null ? null : y0Var.p();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized SSLSession getHandshakeSession() {
        y0 y0Var;
        y0Var = this.A0;
        return y0Var == null ? null : y0Var.i();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.w0;
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized boolean getNeedClientAuth() {
        return this.s.j();
    }

    @Override // sdk.pendo.io.r4.g
    public synchronized sdk.pendo.io.r4.h getParameters() {
        return t1.a(this.s);
    }

    @Override // javax.net.ssl.SSLEngine, sdk.pendo.io.t4.i1
    public String getPeerHost() {
        return super.getPeerHost();
    }

    @Override // javax.net.ssl.SSLEngine, sdk.pendo.io.t4.i1
    public int getPeerPort() {
        return super.getPeerPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized SSLParameters getSSLParameters() {
        return t1.b(this.s);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return c().i();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized String[] getSupportedCipherSuites() {
        return this.f.b().f();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized String[] getSupportedProtocols() {
        return this.f.b().g();
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized boolean getUseClientMode() {
        return this.f0;
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized boolean getWantClientAuth() {
        return this.s.r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
    
        if (r0.t() != false) goto L11;
     */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isInboundDone() {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.u0     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L12
            sdk.pendo.io.y4.w2 r0 = r1.x0     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L10
            boolean r0 = r0.t()     // Catch: java.lang.Throwable -> L15
            if (r0 == 0) goto L10
            goto L12
        L10:
            r0 = 0
            goto L13
        L12:
            r0 = 1
        L13:
            monitor-exit(r1)
            return r0
        L15:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.q0.isInboundDone():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if (r2.x0.j() < 1) goto L13;
     */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isOutboundDone() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.u0     // Catch: java.lang.Throwable -> L1c
            r1 = 1
            if (r0 != 0) goto L1a
            sdk.pendo.io.y4.w2 r0 = r2.x0     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L19
            boolean r0 = r0.t()     // Catch: java.lang.Throwable -> L1c
            if (r0 == 0) goto L19
            sdk.pendo.io.y4.w2 r0 = r2.x0     // Catch: java.lang.Throwable -> L1c
            int r0 = r0.j()     // Catch: java.lang.Throwable -> L1c
            if (r0 >= r1) goto L19
            goto L1a
        L19:
            r1 = 0
        L1a:
            monitor-exit(r2)
            return r1
        L1c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.q0.isOutboundDone():boolean");
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setEnableSessionCreation(boolean z) {
        this.A = z;
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setEnabledCipherSuites(String[] strArr) {
        this.s.b(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setEnabledProtocols(String[] strArr) {
        this.s.d(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setNeedClientAuth(boolean z) {
        this.s.a(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setSSLParameters(SSLParameters sSLParameters) {
        t1.a(this.s, sSLParameters);
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setUseClientMode(boolean z) {
        if (this.v0) {
            throw new IllegalArgumentException("Client/Server mode cannot be changed after the handshake has begun");
        }
        if (this.f0 != z) {
            this.f.b().a(this.s, z);
            this.f0 = z;
        }
        this.t0 = true;
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized void setWantClientAuth(boolean z) {
        this.s.c(z);
    }

    @Override // javax.net.ssl.SSLEngine
    public synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i, int i2) {
        int i3;
        SSLEngineResult.Status status;
        SSLEngineResult.Status status2;
        if (!this.v0) {
            beginHandshake();
        }
        SSLEngineResult.Status status3 = SSLEngineResult.Status.OK;
        int i4 = 0;
        if (this.x0.t()) {
            status2 = SSLEngineResult.Status.CLOSED;
            i3 = 0;
        } else {
            try {
                sdk.pendo.io.y4.x0 a2 = a(byteBuffer);
                if (a2 != null && byteBuffer.remaining() >= a2.b()) {
                    if (b(byteBufferArr, i, i2, a2.a())) {
                        status = SSLEngineResult.Status.BUFFER_OVERFLOW;
                        status3 = status;
                        i3 = 0;
                        status2 = status3;
                    } else {
                        int b = a2.b();
                        byte[] bArr = new byte[b];
                        byteBuffer.get(bArr);
                        this.x0.a(bArr, 0, b);
                        int i5 = b + 0;
                        try {
                            int i6 = this.x0.i();
                            i3 = 0;
                            for (int i7 = 0; i7 < i2 && i6 > 0; i7++) {
                                try {
                                    ByteBuffer byteBuffer2 = byteBufferArr[i + i7];
                                    int min = Math.min(byteBuffer2.remaining(), i6);
                                    if (min > 0) {
                                        byte[] bArr2 = new byte[min];
                                        int d = this.x0.d(bArr2, 0, min);
                                        if (!D0 && d != min) {
                                            throw new AssertionError();
                                        }
                                        byteBuffer2.put(bArr2);
                                        i3 += min;
                                        i6 -= min;
                                    }
                                } catch (IOException e) {
                                    e = e;
                                    i4 = i5;
                                    if (this.w0 != SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                                        throw new SSLException(e);
                                    }
                                    if (this.B0 == null) {
                                        this.B0 = new SSLException(e);
                                    }
                                    this.w0 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
                                    return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i4, i3);
                                }
                            }
                            if (i6 != 0) {
                                throw new h2((short) 22);
                            }
                            i4 = i5;
                            status2 = status3;
                        } catch (IOException e2) {
                            e = e2;
                            i3 = 0;
                        }
                    }
                }
                status = SSLEngineResult.Status.BUFFER_UNDERFLOW;
                status3 = status;
                i3 = 0;
                status2 = status3;
            } catch (IOException e3) {
                e = e3;
                i3 = 0;
            }
        }
        SSLEngineResult.HandshakeStatus handshakeStatus = this.w0;
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
            if (this.x0.j() > 0) {
                handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_WRAP;
            } else if (this.y0.o()) {
                this.w0 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                handshakeStatus = SSLEngineResult.HandshakeStatus.FINISHED;
            } else if (this.x0.t()) {
                handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            }
            this.w0 = handshakeStatus;
        }
        return new SSLEngineResult(status2, handshakeStatus, i4, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0081 A[Catch: all -> 0x00db, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:8:0x000c, B:10:0x0015, B:12:0x001d, B:13:0x0020, B:16:0x0029, B:18:0x0035, B:20:0x0049, B:21:0x004c, B:24:0x0054, B:26:0x0064, B:28:0x0068, B:31:0x006b, B:32:0x0079, B:34:0x0081, B:36:0x008b, B:40:0x009a, B:41:0x009f, B:43:0x00a0, B:44:0x00a6, B:45:0x00a8, B:49:0x00b1, B:51:0x00b9, B:52:0x00c0, B:54:0x00c8, B:55:0x00ca, B:56:0x00cd, B:57:0x00d0, B:62:0x0072, B:63:0x0077, B:66:0x00d8, B:67:0x00da), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9 A[Catch: all -> 0x00db, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:8:0x000c, B:10:0x0015, B:12:0x001d, B:13:0x0020, B:16:0x0029, B:18:0x0035, B:20:0x0049, B:21:0x004c, B:24:0x0054, B:26:0x0064, B:28:0x0068, B:31:0x006b, B:32:0x0079, B:34:0x0081, B:36:0x008b, B:40:0x009a, B:41:0x009f, B:43:0x00a0, B:44:0x00a6, B:45:0x00a8, B:49:0x00b1, B:51:0x00b9, B:52:0x00c0, B:54:0x00c8, B:55:0x00ca, B:56:0x00cd, B:57:0x00d0, B:62:0x0072, B:63:0x0077, B:66:0x00d8, B:67:0x00da), top: B:2:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c0 A[Catch: all -> 0x00db, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x0009, B:8:0x000c, B:10:0x0015, B:12:0x001d, B:13:0x0020, B:16:0x0029, B:18:0x0035, B:20:0x0049, B:21:0x004c, B:24:0x0054, B:26:0x0064, B:28:0x0068, B:31:0x006b, B:32:0x0079, B:34:0x0081, B:36:0x008b, B:40:0x009a, B:41:0x009f, B:43:0x00a0, B:44:0x00a6, B:45:0x00a8, B:49:0x00b1, B:51:0x00b9, B:52:0x00c0, B:54:0x00c8, B:55:0x00ca, B:56:0x00cd, B:57:0x00d0, B:62:0x0072, B:63:0x0077, B:66:0x00d8, B:67:0x00da), top: B:2:0x0001, inners: #0 }] */
    @Override // javax.net.ssl.SSLEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized javax.net.ssl.SSLEngineResult wrap(java.nio.ByteBuffer[] r10, int r11, int r12, java.nio.ByteBuffer r13) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.t4.q0.wrap(java.nio.ByteBuffer[], int, int, java.nio.ByteBuffer):javax.net.ssl.SSLEngineResult");
    }

    protected q0(e eVar, String str, int i) {
        super(str, i);
        this.A = true;
        this.f0 = true;
        this.t0 = false;
        this.u0 = false;
        this.v0 = false;
        this.w0 = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        this.x0 = null;
        this.y0 = null;
        this.z0 = null;
        this.A0 = null;
        this.B0 = null;
        this.f = eVar;
        this.s = eVar.b().b(this.f0);
    }

    @Override // sdk.pendo.io.r4.g
    public synchronized sdk.pendo.io.r4.b a() {
        return this.A0;
    }

    @Override // sdk.pendo.io.t4.i1
    public e b() {
        return this.f;
    }

    private sdk.pendo.io.y4.x0 a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 5) {
            return null;
        }
        byte[] bArr = new byte[5];
        int position = byteBuffer.position();
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return this.x0.b(bArr);
    }

    private boolean b(ByteBuffer[] byteBufferArr, int i, int i2, int i3) {
        return a(byteBufferArr, i, i2, i3) < i3;
    }

    private int a(ByteBuffer[] byteBufferArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int remaining = byteBufferArr[i + i5].remaining();
            if (remaining >= i3 - i4) {
                return i3;
            }
            i4 += remaining;
        }
        return i4;
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized void a(o0 o0Var) {
        y0 y0Var = this.A0;
        if (y0Var != null) {
            if (!y0Var.isValid()) {
                o0Var.b().invalidate();
            }
            this.A0.q().a();
        }
        this.A0 = null;
        this.z0 = o0Var;
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized void a(x0 x0Var, sdk.pendo.io.y4.a1 a1Var, y yVar, v0 v0Var) {
        String peerHost = getPeerHost();
        int peerPort = getPeerPort();
        if (v0Var != null) {
            this.A0 = new z0(x0Var, peerHost, peerPort, a1Var, yVar, v0Var.q(), v0Var.p());
        } else {
            this.A0 = new y0(x0Var, peerHost, peerPort, a1Var, yVar);
        }
    }

    @Override // sdk.pendo.io.t4.i1
    public synchronized String a(List<String> list) {
        return this.s.h().a(this, list);
    }
}
