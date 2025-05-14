package sdk.pendo.io.b5;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import sdk.pendo.io.y4.h2;

/* loaded from: classes6.dex */
public class p0 implements sdk.pendo.io.z4.p {

    /* renamed from: a, reason: collision with root package name */
    protected final h f922a;
    protected final sdk.pendo.io.z4.o b;
    protected final ECParameterSpec c;
    protected final sdk.pendo.io.v4.c d;

    public p0(h hVar, sdk.pendo.io.z4.o oVar) {
        ECParameterSpec b;
        int a2 = oVar.a();
        if (!sdk.pendo.io.y4.p0.o(a2) || (b = b.b(hVar, sdk.pendo.io.y4.p0.b(a2))) == null) {
            throw new IllegalArgumentException("NamedGroup not supported: " + sdk.pendo.io.y4.p0.g(a2));
        }
        this.f922a = hVar;
        this.b = oVar;
        this.c = b;
        this.d = b.a(b.getCurve(), b.getOrder(), b.getCofactor());
    }

    public r0 a(PrivateKey privateKey, PublicKey publicKey) {
        try {
            return this.f922a.d(this.f922a.a("ECDH", privateKey, publicKey, "TlsPremasterSecret"));
        } catch (GeneralSecurityException e) {
            throw new sdk.pendo.io.z4.i("cannot calculate secret", e);
        }
    }

    public PublicKey b(byte[] bArr) {
        try {
            sdk.pendo.io.v4.e o = a(bArr).o();
            return this.f922a.g().i("EC").generatePublic(new ECPublicKeySpec(new ECPoint(o.b().l(), o.c().l()), this.c));
        } catch (Exception e) {
            throw new h2((short) 47, (Throwable) e);
        }
    }

    @Override // sdk.pendo.io.z4.p
    public sdk.pendo.io.z4.e a() {
        return new o0(this);
    }

    public KeyPair b() {
        try {
            KeyPairGenerator a2 = this.f922a.g().a("EC");
            a2.initialize(this.c, this.f922a.h());
            return a2.generateKeyPair();
        } catch (GeneralSecurityException e) {
            throw c.b("unable to create key pair: " + e.getMessage(), e);
        }
    }

    public sdk.pendo.io.v4.e a(byte[] bArr) {
        return this.d.a(bArr);
    }

    public byte[] a(sdk.pendo.io.v4.e eVar) {
        return eVar.a(false);
    }

    public byte[] a(PublicKey publicKey) {
        if (publicKey instanceof sdk.pendo.io.q4.a) {
            return a(((sdk.pendo.io.q4.a) publicKey).f());
        }
        if (!(publicKey instanceof ECPublicKey)) {
            return sdk.pendo.io.e4.g.a(publicKey.getEncoded()).i().k();
        }
        ECPoint w = ((ECPublicKey) publicKey).getW();
        return a(this.d.a(w.getAffineX(), w.getAffineY()));
    }
}
