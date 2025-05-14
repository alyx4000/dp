package sdk.pendo.io.t4;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* loaded from: classes6.dex */
final class s extends sdk.pendo.io.r4.b implements r {

    /* renamed from: a, reason: collision with root package name */
    final SSLSession f1610a;

    s(SSLSession sSLSession) {
        this.f1610a = sSLSession;
    }

    @Override // sdk.pendo.io.r4.b
    public String[] a() {
        return null;
    }

    @Override // sdk.pendo.io.r4.b
    public String[] c() {
        return null;
    }

    @Override // sdk.pendo.io.r4.b
    public List<sdk.pendo.io.r4.e> e() {
        return Collections.emptyList();
    }

    public boolean equals(Object obj) {
        return obj != null && obj.equals(this.f1610a);
    }

    @Override // sdk.pendo.io.r4.b
    public boolean g() {
        SSLSessionContext sessionContext = getSessionContext();
        if (sessionContext instanceof x0) {
            return ((x0) sessionContext).b().h();
        }
        return false;
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        return this.f1610a.getApplicationBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        return this.f1610a.getCipherSuite();
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        return this.f1610a.getCreationTime();
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        return this.f1610a.getId();
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        return this.f1610a.getLastAccessedTime();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        return this.f1610a.getLocalCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        return this.f1610a.getLocalPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        return this.f1610a.getPacketBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificateChain() {
        return g0.a(this);
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getPeerCertificates() {
        return this.f1610a.getPeerCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        return this.f1610a.getPeerHost();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        return this.f1610a.getPeerPort();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() {
        return this.f1610a.getPeerPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        return this.f1610a.getProtocol();
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        return this.f1610a.getSessionContext();
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        return this.f1610a.getValue(str);
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        return this.f1610a.getValueNames();
    }

    public int hashCode() {
        return this.f1610a.hashCode();
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
        this.f1610a.invalidate();
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        return this.f1610a.isValid();
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        this.f1610a.putValue(str, obj);
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        this.f1610a.removeValue(str);
    }

    public String toString() {
        return this.f1610a.toString();
    }

    @Override // sdk.pendo.io.t4.r
    public SSLSession unwrap() {
        return this.f1610a;
    }
}
