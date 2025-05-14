package sdk.pendo.io.z4;

import org.tensorflow.lite.schema.BuiltinOptions;
import sdk.pendo.io.y4.h2;
import sdk.pendo.io.y4.i0;
import sdk.pendo.io.y4.l3;
import sdk.pendo.io.y4.m0;
import sdk.pendo.io.y4.t0;

/* loaded from: classes4.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f1884a = {BuiltinOptions.GeluOptions, BuiltinOptions.HashtableFindOptions, BuiltinOptions.BucketizeOptions, BuiltinOptions.TransposeConvOptions, BuiltinOptions.TileOptions, BuiltinOptions.StridedSliceOptions};

    public static int a(short s) {
        switch (s) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            default:
                throw new IllegalArgumentException("specified HashAlgorithm invalid: " + i0.c(s));
        }
    }

    public static int b(int i) {
        if (i == 0 || i == 1) {
            throw new IllegalArgumentException("legacy PRF not a valid algorithm");
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i == 7) {
                            return 7;
                        }
                        throw new IllegalArgumentException("unknown PRFAlgorithm: " + t0.b(i));
                    }
                }
            }
            return 5;
        }
        return 4;
    }

    public static int c(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 7:
                return 64;
            case 5:
            case 6:
                return 128;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int d(int i) {
        switch (i) {
            case 1:
                return 16;
            case 2:
                return 20;
            case 3:
                return 28;
            case 4:
            case 7:
                return 32;
            case 5:
                return 48;
            case 6:
                return 64;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int a(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                if (i == 3) {
                    return 4;
                }
                if (i == 4) {
                    return 5;
                }
                if (i == 5) {
                    return 6;
                }
                throw new IllegalArgumentException("specified MACAlgorithm not an HMAC: " + m0.b(i));
            }
        }
        return i2;
    }

    public static b0 a(b0 b0Var, int i, String str, byte[] bArr, int i2) {
        int length = str.length();
        if (length < 1) {
            throw new h2((short) 80);
        }
        int length2 = bArr.length;
        byte[] bArr2 = f1884a;
        int length3 = bArr2.length + length;
        int i3 = length3 + 1 + 2;
        byte[] bArr3 = new byte[length2 + 1 + i3];
        l3.a(i2);
        l3.a(i2, bArr3, 0);
        l3.c(length3);
        l3.c(length3, bArr3, 2);
        System.arraycopy(bArr2, 0, bArr3, 3, bArr2.length);
        int length4 = bArr2.length + 1 + 2;
        for (int i4 = 0; i4 < length; i4++) {
            bArr3[length4 + i4] = (byte) str.charAt(i4);
        }
        l3.a(bArr, bArr3, i3);
        return b0Var.a(i, bArr3, i2);
    }
}
