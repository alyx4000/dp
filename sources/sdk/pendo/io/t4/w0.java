package sdk.pendo.io.t4;

import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLPermission;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.net.ssl.SSLSessionContext;
import javax.security.auth.x500.X500Principal;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
abstract class w0 extends sdk.pendo.io.r4.b {

    /* renamed from: a, reason: collision with root package name */
    protected final Map<String, Object> f1620a = Collections.synchronizedMap(new HashMap());
    protected final AtomicReference<x0> b;
    protected final boolean c;
    protected final sdk.pendo.io.b5.h d;
    protected final String e;
    protected final int f;
    protected final long g;
    protected final SSLSession h;
    protected final AtomicLong i;

    w0(x0 x0Var, String str, int i) {
        this.b = new AtomicReference<>(x0Var);
        this.c = x0Var == null ? false : x0Var.b().h();
        this.d = x0Var == null ? null : x0Var.a();
        this.e = str;
        this.f = i;
        long currentTimeMillis = System.currentTimeMillis();
        this.g = currentTimeMillis;
        this.h = u1.a((sdk.pendo.io.r4.b) this);
        this.i = new AtomicLong(currentTimeMillis);
    }

    void a(long j) {
        long j2 = this.i.get();
        if (j > j2) {
            this.i.compareAndSet(j2, j);
        }
    }

    protected void b(String str, Object obj) {
        if (obj instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) obj).valueUnbound(new SSLSessionBindingEvent(this, str));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w0) {
            return sdk.pendo.io.d5.a.a(j(), ((w0) obj).j());
        }
        return false;
    }

    @Override // sdk.pendo.io.r4.b
    public boolean g() {
        return this.c;
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        return 16384;
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        return p0.a(h());
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        return this.g;
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        byte[] j = j();
        return l3.g(j) ? l3.e : (byte[]) j.clone();
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        return this.i.get();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        X509Certificate[] b;
        sdk.pendo.io.b5.h hVar = this.d;
        if (hVar == null || (b = a0.b(hVar, k())) == null || b.length <= 0) {
            return null;
        }
        return b;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        sdk.pendo.io.b5.h hVar = this.d;
        if (hVar != null) {
            return a0.a(hVar, k());
        }
        return null;
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        sdk.pendo.io.y4.v0 m = m();
        if (m == null || !l3.d(m)) {
            return 18443;
        }
        return l3.e(m) ? 16911 : 17413;
    }

    @Override // javax.net.ssl.SSLSession
    public javax.security.cert.X509Certificate[] getPeerCertificateChain() {
        return g0.a(this);
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getPeerCertificates() {
        X509Certificate[] b;
        sdk.pendo.io.b5.h hVar = this.d;
        if (hVar == null || (b = a0.b(hVar, l())) == null || b.length <= 0) {
            throw new SSLPeerUnverifiedException("No peer identity established");
        }
        return b;
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        return this.e;
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        return this.f;
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() {
        X500Principal a2;
        sdk.pendo.io.b5.h hVar = this.d;
        if (hVar == null || (a2 = a0.a(hVar, l())) == null) {
            throw new SSLPeerUnverifiedException("No peer identity established");
        }
        return a2;
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        return p0.a(m());
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new SSLPermission("getSSLSessionContext"));
        }
        return this.b.get();
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        return this.f1620a.get(str);
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        String[] strArr;
        synchronized (this.f1620a) {
            strArr = (String[]) this.f1620a.keySet().toArray(new String[this.f1620a.size()]);
        }
        return strArr;
    }

    protected abstract int h();

    public int hashCode() {
        return sdk.pendo.io.d5.a.b(j());
    }

    SSLSession i() {
        return this.h;
    }

    @Override // javax.net.ssl.SSLSession
    public final void invalidate() {
        a(true);
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        if (this.b.get() == null) {
            return false;
        }
        return !l3.g(j());
    }

    protected abstract byte[] j();

    protected abstract sdk.pendo.io.y4.l k();

    protected abstract sdk.pendo.io.y4.l l();

    protected abstract sdk.pendo.io.y4.v0 m();

    protected abstract void n();

    final void o() {
        a(false);
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        b(str, this.f1620a.put(str, obj));
        a(str, obj);
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        b(str, this.f1620a.remove(str));
    }

    public String toString() {
        return "Session(" + getCreationTime() + "|" + getCipherSuite() + ")";
    }

    private void a(boolean z) {
        if (z) {
            x0 andSet = this.b.getAndSet(null);
            if (andSet != null) {
                andSet.c(j());
            }
        } else {
            this.b.set(null);
        }
        n();
    }

    protected void a(String str, Object obj) {
        if (obj instanceof SSLSessionBindingListener) {
            ((SSLSessionBindingListener) obj).valueBound(new SSLSessionBindingEvent(this, str));
        }
    }
}
