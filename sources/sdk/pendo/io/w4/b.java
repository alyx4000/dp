package sdk.pendo.io.w4;

import java.math.BigInteger;

/* loaded from: classes4.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    static final a f1736a = new g(BigInteger.valueOf(2));
    static final a b = new g(BigInteger.valueOf(3));

    public static f a(int[] iArr) {
        if (iArr[0] != 0) {
            throw new IllegalArgumentException("Irreducible polynomials in GF(2) must have constant term");
        }
        for (int i = 1; i < iArr.length; i++) {
            if (iArr[i] <= iArr[i - 1]) {
                throw new IllegalArgumentException("Polynomial exponents must be monotonically increasing");
            }
        }
        return new d(f1736a, new c(iArr));
    }

    public static a a(BigInteger bigInteger) {
        int bitLength = bigInteger.bitLength();
        if (bigInteger.signum() <= 0 || bitLength < 2) {
            throw new IllegalArgumentException("'characteristic' must be >= 2");
        }
        if (bitLength < 3) {
            int b2 = sdk.pendo.io.d5.b.b(bigInteger);
            if (b2 == 2) {
                return f1736a;
            }
            if (b2 == 3) {
                return b;
            }
        }
        return new g(bigInteger);
    }
}
