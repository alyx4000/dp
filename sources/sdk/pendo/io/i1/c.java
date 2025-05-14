package sdk.pendo.io.i1;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPrivateKeySpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;

/* loaded from: classes6.dex */
public class c extends g {
    public c() {
        this(null, null);
    }

    @Override // sdk.pendo.io.i1.g
    String a() {
        return "EC";
    }

    @Override // sdk.pendo.io.i1.g
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    public c(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    public ECPrivateKey a(BigInteger bigInteger, ECParameterSpec eCParameterSpec) {
        try {
            return (ECPrivateKey) b().generatePrivate(new ECPrivateKeySpec(bigInteger, eCParameterSpec));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.k1.g("Invalid key spec: " + e, e);
        }
    }

    public ECPublicKey a(BigInteger bigInteger, BigInteger bigInteger2, ECParameterSpec eCParameterSpec) {
        try {
            return (ECPublicKey) b().generatePublic(new ECPublicKeySpec(new ECPoint(bigInteger, bigInteger2), eCParameterSpec));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.k1.g("Invalid key spec: " + e, e);
        }
    }
}
