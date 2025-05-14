package sdk.pendo.io.c5;

import java.math.BigInteger;
import org.tensorflow.lite.schema.BuiltinOptions;
import sdk.pendo.io.z4.t;

/* loaded from: classes6.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f955a = {BuiltinOptions.FakeQuantOptions};
    private static BigInteger b = BigInteger.valueOf(0);
    private static BigInteger c = BigInteger.valueOf(1);

    public static BigInteger a(t tVar, BigInteger bigInteger, BigInteger bigInteger2) {
        return b(tVar, bigInteger, bigInteger, bigInteger2);
    }

    private static BigInteger b(t tVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        int bitLength = (bigInteger.bitLength() + 7) / 8;
        byte[] a2 = a(bigInteger2, bitLength);
        byte[] a3 = a(bigInteger3, bitLength);
        tVar.b(a2, 0, a2.length);
        tVar.b(a3, 0, a3.length);
        return new BigInteger(1, tVar.c());
    }

    public static BigInteger a(t tVar, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        return b(tVar, bigInteger, bigInteger2, bigInteger3);
    }

    private static byte[] a(BigInteger bigInteger, int i) {
        byte[] a2 = sdk.pendo.io.d5.b.a(bigInteger);
        if (a2.length >= i) {
            return a2;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(a2, 0, bArr, i - a2.length, a2.length);
        return bArr;
    }

    public static BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger mod = bigInteger2.mod(bigInteger);
        if (mod.equals(b)) {
            throw new IllegalArgumentException("Invalid public value: 0");
        }
        return mod;
    }
}
