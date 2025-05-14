package sdk.pendo.io.m3;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes6.dex */
class u2 extends d0 {
    private byte[] A;

    u2(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'encoded' cannot be null");
        }
        this.A = bArr;
    }

    private synchronized void s() {
        if (this.A != null) {
            p pVar = new p(this.A, true);
            try {
                h e = pVar.e();
                pVar.close();
                this.f = e.c();
                this.A = null;
            } catch (IOException e2) {
                throw new z("malformed ASN.1: " + e2, e2);
            }
        }
    }

    private synchronized byte[] t() {
        return this.A;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        byte[] t = t();
        if (t != null) {
            yVar.a(z, 48, t);
        } else {
            super.j().a(yVar, z);
        }
    }

    @Override // sdk.pendo.io.m3.d0, sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        s();
        return super.hashCode();
    }

    @Override // sdk.pendo.io.m3.d0, sdk.pendo.io.m3.a0
    a0 i() {
        s();
        return super.i();
    }

    @Override // sdk.pendo.io.m3.d0, java.lang.Iterable
    public Iterator<g> iterator() {
        s();
        return super.iterator();
    }

    @Override // sdk.pendo.io.m3.d0, sdk.pendo.io.m3.a0
    a0 j() {
        s();
        return super.j();
    }

    @Override // sdk.pendo.io.m3.d0
    public Enumeration m() {
        byte[] t = t();
        return t != null ? new t2(t) : super.m();
    }

    @Override // sdk.pendo.io.m3.d0
    c n() {
        return ((d0) j()).n();
    }

    @Override // sdk.pendo.io.m3.d0
    k o() {
        return ((d0) j()).o();
    }

    @Override // sdk.pendo.io.m3.d0
    w p() {
        return ((d0) j()).p();
    }

    @Override // sdk.pendo.io.m3.d0
    e0 q() {
        return ((d0) j()).q();
    }

    @Override // sdk.pendo.io.m3.d0
    public int size() {
        s();
        return super.size();
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        byte[] t = t();
        return t != null ? y.a(z, t.length) : super.j().a(z);
    }

    @Override // sdk.pendo.io.m3.d0
    public g a(int i) {
        s();
        return super.a(i);
    }
}
