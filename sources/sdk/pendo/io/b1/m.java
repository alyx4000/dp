package sdk.pendo.io.b1;

import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECFieldFp;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import javax.crypto.KeyAgreement;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes6.dex */
public class m extends sdk.pendo.io.a1.f implements p {
    String f;

    public m() {
        this.f = "enc";
        a("ECDH-ES");
        b("ECDH");
        c("EC");
        a(sdk.pendo.io.i1.h.ASYMMETRIC);
    }

    private void a(ECKey eCKey) {
        if ("secp256k1".equals(sdk.pendo.io.i1.e.a(eCKey.getParams().getCurve()))) {
            throw new sdk.pendo.io.k1.f("Use of the secp256k1 curve is not defined for ECDH-ES key agreement with JOSE.");
        }
    }

    @Override // sdk.pendo.io.a1.a
    public boolean d() {
        return new sdk.pendo.io.i1.c().c() && sdk.pendo.io.a1.b.a("KeyAgreement", e());
    }

    public m(String str) {
        this();
        this.f = str;
    }

    private void a(ECPublicKey eCPublicKey, ECPrivateKey eCPrivateKey) {
        EllipticCurve curve = eCPrivateKey.getParams().getCurve();
        ECPoint w = eCPublicKey.getW();
        BigInteger affineX = w.getAffineX();
        BigInteger affineY = w.getAffineY();
        BigInteger a2 = curve.getA();
        BigInteger b = curve.getB();
        BigInteger p = ((ECFieldFp) curve.getField()).getP();
        if (!affineY.pow(2).mod(p).equals(affineX.pow(3).add(a2.multiply(affineX)).add(b).mod(p))) {
            throw new sdk.pendo.io.k1.f("epk is invalid for " + sdk.pendo.io.i1.e.a(curve));
        }
    }

    private KeyAgreement a(PrivateKey privateKey, PublicKey publicKey, sdk.pendo.io.w0.a aVar) {
        KeyAgreement a2 = a(aVar.c().b(), privateKey instanceof ECPrivateKey ? e() : "XDH");
        try {
            a2.init(privateKey);
            a2.doPhase(publicKey, true);
            return a2;
        } catch (InvalidKeyException e) {
            throw new sdk.pendo.io.k1.f("Invalid Key for " + e() + " key agreement - " + e, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [javax.crypto.KeyAgreement] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    private KeyAgreement a(String str, String str2) {
        try {
            str = str == 0 ? KeyAgreement.getInstance(str2) : KeyAgreement.getInstance(str2, str);
            return str;
        } catch (NoSuchAlgorithmException e) {
            throw new sdk.pendo.io.k1.k("No " + str2 + " KeyAgreement available.", e);
        } catch (NoSuchProviderException e2) {
            throw new sdk.pendo.io.k1.g("Cannot get " + str2 + " KeyAgreement with provider " + str, e2);
        }
    }

    private byte[] a(i iVar, sdk.pendo.io.h1.b bVar, byte[] bArr, sdk.pendo.io.w0.a aVar) {
        return new sdk.pendo.io.c1.d(aVar.a().f()).a(bArr, sdk.pendo.io.k1.a.a(iVar.b()), bVar.c(this.f), bVar.c("apu"), bVar.c("apv"));
    }

    @Override // sdk.pendo.io.b1.p
    public Key a(sdk.pendo.io.a1.g gVar, byte[] bArr, i iVar, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        return new SecretKeySpec(a(iVar, bVar, gVar.c().generateSecret(), aVar), iVar.a());
    }

    @Override // sdk.pendo.io.b1.p
    public sdk.pendo.io.a1.g a(Key key, sdk.pendo.io.h1.b bVar, sdk.pendo.io.w0.a aVar) {
        PublicKey j = bVar.a("epk", aVar.a().d()).j();
        PrivateKey privateKey = (PrivateKey) key;
        if (j instanceof ECPublicKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) key;
            a(eCPrivateKey);
            a((ECPublicKey) j, eCPrivateKey);
        }
        return new sdk.pendo.io.a1.g(a(privateKey, j, aVar));
    }

    @Override // sdk.pendo.io.b1.p
    public void a(Key key, g gVar) {
        if (!(key instanceof ECPrivateKey) && !sdk.pendo.io.i1.l.b(key)) {
            throw new sdk.pendo.io.k1.f("Decrypting with ECDH expects ECPrivateKey or XECPrivateKey but was given " + key);
        }
    }
}
