package sdk.pendo.io.d5;

import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public abstract class f {
    public static int a(byte[] bArr, int i) {
        int i2 = bArr[i] << BuiltinOptions.BatchToSpaceNDOptions;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i5 = i3 + 1;
        return (bArr[i5 + 1] & UByte.MAX_VALUE) | i4 | ((bArr[i5] & UByte.MAX_VALUE) << 8);
    }

    public static long b(byte[] bArr, int i) {
        int a2 = a(bArr, i);
        return (a(bArr, i + 4) & BodyPartID.bodyIdMax) | ((a2 & BodyPartID.bodyIdMax) << 32);
    }

    public static int c(byte[] bArr, int i) {
        int i2 = bArr[i] & UByte.MAX_VALUE;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 8);
        int i5 = i3 + 1;
        return (bArr[i5 + 1] << BuiltinOptions.BatchToSpaceNDOptions) | i4 | ((bArr[i5] & UByte.MAX_VALUE) << 16);
    }

    public static void a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    public static void b(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    public static void a(long j, byte[] bArr, int i) {
        a((int) (j >>> 32), bArr, i);
        a((int) (j & BodyPartID.bodyIdMax), bArr, i + 4);
    }

    public static void b(long j, byte[] bArr, int i) {
        b((int) (BodyPartID.bodyIdMax & j), bArr, i);
        b((int) (j >>> 32), bArr, i + 4);
    }
}
