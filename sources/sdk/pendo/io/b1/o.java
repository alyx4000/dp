package sdk.pendo.io.b1;

import java.security.Key;

/* loaded from: classes6.dex */
public class o extends sdk.pendo.io.h1.c {
    private byte[] m;
    byte[] n;
    byte[] o;
    byte[] p;
    private sdk.pendo.io.a1.g r;
    private sdk.pendo.io.u0.b k = new sdk.pendo.io.u0.b();
    private String l = "UTF-8";
    private sdk.pendo.io.a1.c q = sdk.pendo.io.a1.c.c;

    private void a(g gVar, i iVar, byte[] bArr) {
        int b = iVar.b();
        if (bArr.length != b) {
            throw new sdk.pendo.io.k1.f(sdk.pendo.io.k1.a.a(bArr) + " bit content encryption key is not the correct size for the " + gVar.c() + " content encryption algorithm (" + sdk.pendo.io.k1.a.a(b) + ").");
        }
    }

    private sdk.pendo.io.a1.g l() {
        p r = r();
        Key h = h();
        if (j()) {
            r.a(h, n());
        }
        return r.a(h, this.b, i());
    }

    private void m() {
        p r = r();
        g n = n();
        i b = n.b();
        a();
        sdk.pendo.io.a1.g gVar = this.r;
        if (gVar == null) {
            gVar = l();
        }
        Key a2 = r.a(gVar, p(), b, f(), i());
        k kVar = new k(this.o, this.p, g());
        byte[] o = o();
        byte[] encoded = a2.getEncoded();
        a(n, b, encoded);
        c(a(f(), n.a(kVar, o, encoded, f(), i())));
    }

    p b(boolean z) {
        String c = c();
        if (c == null) {
            throw new sdk.pendo.io.k1.e("Encryption key management algorithm header (alg) not set.");
        }
        if (z) {
            b().a(c);
        }
        return sdk.pendo.io.a1.e.b().d().a(c);
    }

    public void c(byte[] bArr) {
        this.m = bArr;
    }

    public void e(String str) {
        b(this.k.a(str));
    }

    public g n() {
        String q = q();
        if (q == null) {
            throw new sdk.pendo.io.k1.e("Content encryption header (enc) not set.");
        }
        this.q.a(q);
        return sdk.pendo.io.a1.e.b().c().a(q);
    }

    byte[] o() {
        return sdk.pendo.io.k1.j.a(e());
    }

    public byte[] p() {
        return this.n;
    }

    public String q() {
        return b("enc");
    }

    public p r() {
        return b(true);
    }

    public String s() {
        return u();
    }

    public byte[] t() {
        if (this.m == null) {
            m();
        }
        return this.m;
    }

    public String u() {
        return sdk.pendo.io.k1.j.a(t(), this.l);
    }

    byte[] a(sdk.pendo.io.h1.b bVar, byte[] bArr) {
        String c = bVar.c("zip");
        return c != null ? sdk.pendo.io.a1.e.b().a().a(c).a(bArr) : bArr;
    }

    public void b(sdk.pendo.io.a1.c cVar) {
        this.q = cVar;
    }

    @Override // sdk.pendo.io.h1.c
    protected void a(String[] strArr) {
        if (strArr.length != 5) {
            throw new sdk.pendo.io.k1.g("A JWE Compact Serialization must have exactly 5 parts separated by period ('.') characters");
        }
        d(strArr[0]);
        this.n = this.k.a(strArr[1]);
        e(strArr[2]);
        String str = strArr[3];
        a(str, "Encoded JWE Ciphertext");
        this.p = this.k.a(str);
        String str2 = strArr[4];
        a(str2, "Encoded JWE Authentication Tag");
        a(this.k.a(str2));
    }

    public void b(byte[] bArr) {
        this.o = bArr;
    }
}
