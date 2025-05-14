package sdk.pendo.io.b5;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.PublicKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import javax.crypto.interfaces.DHPublicKey;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.j1;
import sdk.pendo.io.y4.l3;

/* loaded from: classes6.dex */
public class g implements sdk.pendo.io.z4.f {

    /* renamed from: a, reason: collision with root package name */
    protected final h f905a;
    protected final X509Certificate b;
    protected DHPublicKey c;
    protected ECPublicKey d;
    protected PublicKey e;

    public g(h hVar, X509Certificate x509Certificate) {
        this.c = null;
        this.d = null;
        this.e = null;
        this.f905a = hVar;
        this.b = x509Certificate;
    }

    public static g a(h hVar, sdk.pendo.io.z4.f fVar) {
        return fVar instanceof g ? (g) fVar : new g(hVar, fVar.getEncoded());
    }

    @Override // sdk.pendo.io.z4.f
    public sdk.pendo.io.z4.f0 b(int i) {
        e(0);
        if (i != 513) {
            if (i != 515) {
                if (i != 1025) {
                    if (i != 1027) {
                        if (i != 1281) {
                            if (i != 1283) {
                                if (i != 1537) {
                                    if (i != 1539) {
                                        switch (i) {
                                            case 2052:
                                            case 2053:
                                            case 2054:
                                                p();
                                                return new a0(this.f905a, i(), i);
                                            case 2055:
                                                return new s(this.f905a, g());
                                            case 2056:
                                                return new u(this.f905a, h());
                                            case 2057:
                                            case 2058:
                                            case 2059:
                                                e(j1.e(i));
                                                return new a0(this.f905a, i(), i);
                                            default:
                                                switch (i) {
                                                    case 2074:
                                                    case 2075:
                                                    case 2076:
                                                        break;
                                                    default:
                                                        throw new h2((short) 46);
                                                }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return new o(this.f905a, f(), i);
        }
        o();
        return new c0(this.f905a, i());
    }

    @Override // sdk.pendo.io.z4.f
    public sdk.pendo.io.z4.f c(int i) {
        if (i == 1) {
            e(4);
            this.c = d();
            return this;
        }
        if (i != 2) {
            throw new h2((short) 46);
        }
        e(4);
        this.d = f();
        return this;
    }

    DHPublicKey d() {
        try {
            return (DHPublicKey) j();
        } catch (ClassCastException e) {
            throw new h2((short) 46, (Throwable) e);
        }
    }

    DSAPublicKey e() {
        try {
            return (DSAPublicKey) j();
        } catch (ClassCastException e) {
            throw new h2((short) 46, (Throwable) e);
        }
    }

    ECPublicKey f() {
        try {
            return (ECPublicKey) j();
        } catch (ClassCastException e) {
            throw new h2((short) 46, (Throwable) e);
        }
    }

    PublicKey g() {
        PublicKey j = j();
        if (EdDSAParameterSpec.Ed25519.equals(j.getAlgorithm())) {
            return j;
        }
        throw new h2((short) 46);
    }

    @Override // sdk.pendo.io.z4.f
    public byte[] getEncoded() {
        try {
            return this.b.getEncoded();
        } catch (CertificateEncodingException e) {
            throw new sdk.pendo.io.z4.i("unable to encode certificate: " + e.getMessage(), e);
        }
    }

    PublicKey h() {
        PublicKey j = j();
        if (EdDSAParameterSpec.Ed448.equals(j.getAlgorithm())) {
            return j;
        }
        throw new h2((short) 46);
    }

    PublicKey i() {
        return j();
    }

    protected PublicKey j() {
        try {
            return this.b.getPublicKey();
        } catch (RuntimeException e) {
            throw new h2((short) 42, (Throwable) e);
        }
    }

    protected sdk.pendo.io.e4.g k() {
        return sdk.pendo.io.e4.g.a(j().getEncoded());
    }

    public X509Certificate l() {
        return this.b;
    }

    protected boolean m() {
        return sdk.pendo.io.a5.c.a(k().h());
    }

    protected boolean n() {
        return sdk.pendo.io.a5.c.b(k().h());
    }

    protected void o() {
        if (!m()) {
            throw new h2((short) 46);
        }
    }

    protected void p() {
        if (!n()) {
            throw new h2((short) 46);
        }
    }

    public g(h hVar, byte[] bArr) {
        this(hVar, a(hVar.g(), bArr));
    }

    @Override // sdk.pendo.io.z4.f
    public sdk.pendo.io.z4.r a(int i) {
        e(2);
        if (i != 3) {
            throw new h2((short) 46);
        }
        PublicKey i2 = i();
        this.e = i2;
        return new y(this.f905a, i2);
    }

    @Override // sdk.pendo.io.z4.f
    public short b() {
        PublicKey j = j();
        if (!d(0)) {
            return (short) -1;
        }
        if (j instanceof RSAPublicKey) {
            return (short) 1;
        }
        if (j instanceof DSAPublicKey) {
            return (short) 2;
        }
        return j instanceof ECPublicKey ? (short) 3 : (short) -1;
    }

    @Override // sdk.pendo.io.z4.f
    public sdk.pendo.io.m3.g c() {
        byte[] sigAlgParams = this.b.getSigAlgParams();
        if (sigAlgParams == null) {
            return null;
        }
        sdk.pendo.io.m3.a0 h = l3.h(sigAlgParams);
        l3.a(h, sigAlgParams);
        return h;
    }

    protected boolean d(int i) {
        boolean[] keyUsage = this.b.getKeyUsage();
        return keyUsage == null || (keyUsage.length > i && keyUsage[i]);
    }

    protected void e(int i) {
        if (!d(i)) {
            throw new h2((short) 46);
        }
    }

    @Override // sdk.pendo.io.z4.f
    public sdk.pendo.io.z4.f0 a(short s) {
        switch (s) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                return b(j1.a((short) 8, s));
            default:
                e(0);
                if (s == 1) {
                    o();
                    return new c0(this.f905a, i());
                }
                if (s == 2) {
                    return new k(this.f905a, e());
                }
                if (s == 3) {
                    return new q(this.f905a, f());
                }
                throw new h2((short) 46);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean b(short r4) {
        /*
            r3 = this;
            java.security.PublicKey r0 = r3.j()
            r1 = 1
            r2 = 0
            switch(r4) {
                case 1: goto L3c;
                case 2: goto L39;
                case 3: goto L49;
                case 4: goto L2c;
                case 5: goto L2c;
                case 6: goto L2c;
                case 7: goto L25;
                case 8: goto L1a;
                case 9: goto Ld;
                case 10: goto Ld;
                case 11: goto Ld;
                default: goto L9;
            }
        L9:
            switch(r4) {
                case 26: goto L49;
                case 27: goto L49;
                case 28: goto L49;
                default: goto Lc;
            }
        Lc:
            return r2
        Ld:
            boolean r4 = r3.c(r4)
            if (r4 == 0) goto L18
            boolean r4 = r0 instanceof java.security.interfaces.RSAPublicKey
            if (r4 == 0) goto L18
            goto L19
        L18:
            r1 = r2
        L19:
            return r1
        L1a:
            java.lang.String r4 = r0.getAlgorithm()
            java.lang.String r0 = "Ed448"
        L20:
            boolean r4 = r0.equals(r4)
            return r4
        L25:
            java.lang.String r4 = r0.getAlgorithm()
            java.lang.String r0 = "Ed25519"
            goto L20
        L2c:
            boolean r4 = r3.n()
            if (r4 == 0) goto L37
            boolean r4 = r0 instanceof java.security.interfaces.RSAPublicKey
            if (r4 == 0) goto L37
            goto L38
        L37:
            r1 = r2
        L38:
            return r1
        L39:
            boolean r4 = r0 instanceof java.security.interfaces.DSAPublicKey
            return r4
        L3c:
            boolean r4 = r3.m()
            if (r4 == 0) goto L47
            boolean r4 = r0 instanceof java.security.interfaces.RSAPublicKey
            if (r4 == 0) goto L47
            goto L48
        L47:
            r1 = r2
        L48:
            return r1
        L49:
            boolean r4 = r0 instanceof java.security.interfaces.ECPublicKey
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.b5.g.b(short):boolean");
    }

    protected boolean c(short s) {
        return sdk.pendo.io.a5.c.a(s, k().h());
    }

    public boolean d(short s) {
        return b(s);
    }

    protected void e(short s) {
        if (!c(s)) {
            throw new h2((short) 46);
        }
    }

    @Override // sdk.pendo.io.z4.f
    public byte[] a(sdk.pendo.io.m3.v vVar) {
        byte[] extensionValue = this.b.getExtensionValue(vVar.l());
        if (extensionValue == null) {
            return null;
        }
        return ((sdk.pendo.io.m3.w) sdk.pendo.io.m3.a0.a(extensionValue)).k();
    }

    @Override // sdk.pendo.io.z4.f
    public String a() {
        return this.b.getSigAlgOID();
    }

    public static X509Certificate a(sdk.pendo.io.p4.b bVar, byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sdk.pendo.io.e4.b.a(l3.h(bArr)).a(ASN1Encoding.DER));
            X509Certificate x509Certificate = (X509Certificate) bVar.c("X.509").generateCertificate(byteArrayInputStream);
            if (byteArrayInputStream.available() == 0) {
                return x509Certificate;
            }
            throw new IOException("Extra data detected in stream");
        } catch (GeneralSecurityException e) {
            throw new sdk.pendo.io.z4.i("unable to decode certificate", e);
        }
    }
}
