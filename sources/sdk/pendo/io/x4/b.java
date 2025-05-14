package sdk.pendo.io.x4;

import java.math.BigInteger;
import sdk.pendo.io.d5.f;

/* loaded from: classes4.dex */
public abstract class b {
    public static int[] a(int i) {
        return new int[i];
    }

    public static BigInteger b(int i, int[] iArr) {
        byte[] bArr = new byte[i << 2];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            if (i3 != 0) {
                f.a(i3, bArr, ((i - 1) - i2) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    public static int a(int i, int[] iArr, int i2) {
        int i3 = i2 ^ iArr[0];
        for (int i4 = 1; i4 < i; i4++) {
            i3 |= iArr[i4];
        }
        return (((i3 >>> 1) | (i3 & 1)) - 1) >> 31;
    }

    public static int a(int i, int[] iArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 |= iArr[i3];
        }
        return (((i2 >>> 1) | (i2 & 1)) - 1) >> 31;
    }

    public static int[] a(int i, BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > i) {
            throw new IllegalArgumentException();
        }
        int i2 = (i + 31) >> 5;
        int[] a2 = a(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            a2[i3] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
        }
        return a2;
    }
}
