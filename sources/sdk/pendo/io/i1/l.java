package sdk.pendo.io.i1;

import java.math.BigInteger;
import java.security.Key;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.XECPrivateKey;
import java.security.interfaces.XECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.NamedParameterSpec;
import java.security.spec.XECPrivateKeySpec;
import java.security.spec.XECPublicKeySpec;
import java.util.Arrays;
import org.bouncycastle.jcajce.spec.XDHParameterSpec;

/* loaded from: classes6.dex */
public class l extends i {
    private static final BigInteger c = new BigInteger("57896044618658097711785492504343953926634992332820282019728792003956564819949");
    private static final BigInteger d = new BigInteger("726838724295606890549323807888004534353641360687318060281490199180612328166730772686396383698676545930088884461843637361053498018365439");

    public l(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    public static boolean b(Key key) {
        try {
            return key instanceof XECPrivateKey;
        } catch (NoClassDefFoundError unused) {
            return false;
        }
    }

    @Override // sdk.pendo.io.i1.g
    String a() {
        return "XDH";
    }

    @Override // sdk.pendo.io.i1.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public XECPrivateKey a(byte[] bArr, String str) {
        try {
            return (XECPrivateKey) b().generatePrivate(new XECPrivateKeySpec(a(str), bArr));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.k1.g("Invalid key spec: " + e, e);
        }
    }

    @Override // sdk.pendo.io.i1.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public XECPublicKey b(byte[] bArr, String str) {
        NamedParameterSpec a2 = a(str);
        byte[] d2 = sdk.pendo.io.k1.a.d(bArr);
        int i = (XDHParameterSpec.X25519.equals(str) ? 255 : 448) % 8;
        if (i != 0) {
            d2[0] = (byte) (((1 << i) - 1) & d2[0]);
        }
        try {
            return (XECPublicKey) b().generatePublic(new XECPublicKeySpec(a2, new BigInteger(1, d2)));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.k1.g("Invalid key spec: " + e, e);
        }
    }

    @Override // sdk.pendo.io.i1.i
    public byte[] a(PrivateKey privateKey) {
        return ((XECPrivateKey) privateKey).getScalar().orElse(sdk.pendo.io.k1.a.f1251a);
    }

    @Override // sdk.pendo.io.i1.i
    public byte[] a(Key key) {
        XECPublicKey xECPublicKey = (XECPublicKey) key;
        BigInteger u = xECPublicKey.getU();
        boolean equals = XDHParameterSpec.X25519.equals(((NamedParameterSpec) xECPublicKey.getParams()).getName());
        byte[] d2 = sdk.pendo.io.k1.a.d(u.mod(equals ? c : d).toByteArray());
        int i = equals ? 32 : 57;
        return d2.length != i ? Arrays.copyOf(d2, i) : d2;
    }
}
