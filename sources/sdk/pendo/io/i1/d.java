package sdk.pendo.io.i1;

import java.security.Key;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.interfaces.EdECPrivateKey;
import java.security.interfaces.EdECPublicKey;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPrivateKeySpec;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.jcajce.spec.EdDSAParameterSpec;

/* loaded from: classes6.dex */
public class d extends i {
    public d(String str, SecureRandom secureRandom) {
        super(str, secureRandom);
    }

    @Override // sdk.pendo.io.i1.g
    String a() {
        return "EDDSA";
    }

    @Override // sdk.pendo.io.i1.i
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public EdECPrivateKey a(byte[] bArr, String str) {
        try {
            return (EdECPrivateKey) b().generatePrivate(new EdECPrivateKeySpec(a(str), bArr));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.k1.g("Invalid key spec: " + e, e);
        }
    }

    @Override // sdk.pendo.io.i1.i
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public EdECPublicKey b(byte[] bArr, String str) {
        byte[] bArr2 = (byte[]) bArr.clone();
        byte b = bArr2[bArr2.length - 1];
        int length = bArr2.length - 1;
        bArr2[length] = (byte) (bArr2[length] & ByteCompanionObject.MAX_VALUE);
        try {
            return (EdECPublicKey) b().generatePublic(new EdECPublicKeySpec(a(str), new EdECPoint((b & ByteCompanionObject.MIN_VALUE) != 0, b.a(sdk.pendo.io.k1.a.d(bArr2)))));
        } catch (InvalidKeySpecException e) {
            throw new sdk.pendo.io.k1.g("Invalid key spec: " + e, e);
        }
    }

    @Override // sdk.pendo.io.i1.i
    public byte[] a(PrivateKey privateKey) {
        return ((EdECPrivateKey) privateKey).getBytes().orElse(sdk.pendo.io.k1.a.f1251a);
    }

    @Override // sdk.pendo.io.i1.i
    public byte[] a(Key key) {
        EdECPublicKey edECPublicKey = (EdECPublicKey) key;
        EdECPoint point = edECPublicKey.getPoint();
        byte[] d = sdk.pendo.io.k1.a.d(point.getY().toByteArray());
        int i = edECPublicKey.getParams().getName().equals(EdDSAParameterSpec.Ed25519) ? 32 : 57;
        if (d.length != i) {
            d = Arrays.copyOf(d, i);
        }
        byte b = point.isXOdd() ? ByteCompanionObject.MIN_VALUE : (byte) 0;
        int length = d.length - 1;
        d[length] = (byte) (b | d[length]);
        return d;
    }
}
