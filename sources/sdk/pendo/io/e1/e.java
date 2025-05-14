package sdk.pendo.io.e1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.Key;
import sdk.pendo.io.k1.j;

/* loaded from: classes6.dex */
public class e extends sdk.pendo.io.h1.c {
    private byte[] k;
    private String l = "UTF-8";
    private String m;
    private Boolean n;

    public e() {
        if (Boolean.getBoolean("external.sdk.pendo.io.jose4j.jws.default-allow-none")) {
            return;
        }
        a(sdk.pendo.io.a1.c.d);
    }

    private f b(boolean z) {
        String c = c();
        if (c == null) {
            throw new sdk.pendo.io.k1.e("Signature algorithm header (alg) not set.");
        }
        if (z) {
            b().a(c);
        }
        return sdk.pendo.io.a1.e.b().e().a(c);
    }

    private byte[] o() {
        if (!r()) {
            return j.a(sdk.pendo.io.h1.a.a(e(), m()));
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(j.a(e()));
            byteArrayOutputStream.write(46);
            byteArrayOutputStream.write(this.k);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            throw new sdk.pendo.io.k1.g("This should never happen from a ByteArrayOutputStream", e);
        }
    }

    private String p() {
        return j.a(this.k, this.l);
    }

    @Override // sdk.pendo.io.h1.c
    protected void a(String[] strArr) {
        if (strArr.length != 3) {
            throw new sdk.pendo.io.k1.g("A JWS Compact Serialization must have exactly 3 parts separated by period ('.') characters");
        }
        d(strArr[0]);
        if (r()) {
            f(strArr[1]);
        } else {
            e(strArr[1]);
        }
        b(this.f1155a.a(strArr[2]));
    }

    @Override // sdk.pendo.io.h1.c
    protected boolean c(String str) {
        return "b64".equals(str);
    }

    public void e(String str) {
        this.m = str;
        this.k = this.f1155a.a(str);
    }

    public void f(String str) {
        this.k = j.a(str, this.l);
        this.m = null;
    }

    @Override // sdk.pendo.io.h1.c
    protected void k() {
        this.n = null;
    }

    public f l() {
        return b(true);
    }

    public String m() {
        String str = this.m;
        return str != null ? str : this.f1155a.a(this.k);
    }

    protected byte[] n() {
        return g();
    }

    public String q() {
        return p();
    }

    protected boolean r() {
        Object b = this.b.b("b64");
        return (b == null || !(b instanceof Boolean) || ((Boolean) b).booleanValue()) ? false : true;
    }

    public boolean s() {
        f l = l();
        Key h = h();
        if (j()) {
            l.a(h);
        }
        if (this.n == null) {
            a();
            this.n = Boolean.valueOf(l.a(n(), h, o(), i()));
        }
        return this.n.booleanValue();
    }

    protected void b(byte[] bArr) {
        a(bArr);
    }
}
