package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import kotlin.UByte;
import kotlin.UShort;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes2.dex */
public class ByteIo {
    private static short doReadInt16(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = bArr[i] & UByte.MAX_VALUE;
            i3 = (bArr[i + 1] & UByte.MAX_VALUE) << 8;
        } else {
            i2 = (bArr[i] & UByte.MAX_VALUE) << 8;
            i3 = bArr[i + 1] & UByte.MAX_VALUE;
        }
        return (short) (i3 | i2);
    }

    private static void doWriteInt16(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            bArr[i] = (byte) (i2 & 255);
            bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
        } else {
            bArr[i] = (byte) ((i2 >>> 8) & 255);
            bArr[i + 1] = (byte) (i2 & 255);
        }
    }

    public static Float readFloat32(byte[] bArr, int i, boolean z) {
        return Float.valueOf(Float.intBitsToFloat((int) readUint32Primitive(bArr, i, z)));
    }

    public static Double readFloat64(byte[] bArr, int i, boolean z) {
        return Double.valueOf(Double.longBitsToDouble(readUint64Primitive(bArr, i, z)));
    }

    public static Short readInt16(byte[] bArr, int i, boolean z) {
        return Short.valueOf(doReadInt16(bArr, i, z));
    }

    public static Integer readInt32(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
            i3 = (bArr[i + 3] & UByte.MAX_VALUE) << 24;
        } else {
            i2 = ((bArr[i] & UByte.MAX_VALUE) << 24) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
            i3 = bArr[i + 3] & UByte.MAX_VALUE;
        }
        return Integer.valueOf(i3 | i2);
    }

    public static Byte readInt8(byte[] bArr, int i) {
        return Byte.valueOf(bArr[i]);
    }

    public static Integer readUint16(byte[] bArr, int i, boolean z) {
        return Integer.valueOf(doReadInt16(bArr, i, z) & UShort.MAX_VALUE);
    }

    public static Object readUint32(byte[] bArr, int i, boolean z) {
        return Long.valueOf(readUint32Primitive(bArr, i, z));
    }

    public static long readUint32Primitive(byte[] bArr, int i, boolean z) {
        long j;
        long j2;
        if (z) {
            j = ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8);
            j2 = (bArr[i + 3] & 255) << 24;
        } else {
            j = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24) | ((bArr[i + 2] & 255) << 8);
            j2 = bArr[i + 3] & 255;
        }
        return (j2 | j) & BodyPartID.bodyIdMax;
    }

    public static long readUint64Primitive(byte[] bArr, int i, boolean z) {
        long j;
        long j2;
        if (z) {
            j = ((bArr[i + 2] & 255) << 16) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
            j2 = (bArr[i + 7] & 255) << 56;
        } else {
            j = ((bArr[i + 1] & 255) << 48) | ((bArr[i] & 255) << 56) | ((bArr[i + 2] & 255) << 40) | ((bArr[i + 3] & 255) << 32) | ((bArr[i + 4] & 255) << 24) | ((bArr[i + 5] & 255) << 16) | ((bArr[i + 6] & 255) << 8);
            j2 = (bArr[i + 7] & 255) << 0;
        }
        return j2 | j;
    }

    public static Integer readUint8(byte[] bArr, int i) {
        return Integer.valueOf(bArr[i] & UByte.MAX_VALUE);
    }

    public static void writeFloat32(byte[] bArr, int i, double d, boolean z) {
        writeUint32(bArr, i, Float.floatToIntBits((float) d), z);
    }

    public static void writeFloat64(byte[] bArr, int i, double d, boolean z) {
        writeUint64(bArr, i, Double.doubleToLongBits(d), z);
    }

    public static void writeInt16(byte[] bArr, int i, int i2, boolean z) {
        doWriteInt16(bArr, i, i2, z);
    }

    public static void writeInt32(byte[] bArr, int i, int i2, boolean z) {
        if (z) {
            bArr[i] = (byte) (i2 & 255);
            bArr[i + 1] = (byte) ((i2 >>> 8) & 255);
            bArr[i + 2] = (byte) ((i2 >>> 16) & 255);
            bArr[i + 3] = (byte) ((i2 >>> 24) & 255);
            return;
        }
        bArr[i] = (byte) ((i2 >>> 24) & 255);
        bArr[i + 1] = (byte) ((i2 >>> 16) & 255);
        bArr[i + 2] = (byte) ((i2 >>> 8) & 255);
        bArr[i + 3] = (byte) (i2 & 255);
    }

    public static void writeInt8(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) i2;
    }

    public static void writeUint16(byte[] bArr, int i, int i2, boolean z) {
        doWriteInt16(bArr, i, i2 & 65535, z);
    }

    public static void writeUint32(byte[] bArr, int i, long j, boolean z) {
        if (z) {
            bArr[i] = (byte) (j & 255);
            bArr[i + 1] = (byte) ((j >>> 8) & 255);
            bArr[i + 2] = (byte) ((j >>> 16) & 255);
            bArr[i + 3] = (byte) ((j >>> 24) & 255);
            return;
        }
        bArr[i] = (byte) ((j >>> 24) & 255);
        bArr[i + 1] = (byte) ((j >>> 16) & 255);
        bArr[i + 2] = (byte) ((j >>> 8) & 255);
        bArr[i + 3] = (byte) (j & 255);
    }

    public static void writeUint64(byte[] bArr, int i, long j, boolean z) {
        if (z) {
            bArr[i] = (byte) (j & 255);
            bArr[i + 1] = (byte) ((j >>> 8) & 255);
            bArr[i + 2] = (byte) ((j >>> 16) & 255);
            bArr[i + 3] = (byte) ((j >>> 24) & 255);
            bArr[i + 4] = (byte) ((j >>> 32) & 255);
            bArr[i + 5] = (byte) ((j >>> 40) & 255);
            bArr[i + 6] = (byte) ((j >>> 48) & 255);
            bArr[i + 7] = (byte) ((j >>> 56) & 255);
            return;
        }
        bArr[i] = (byte) ((j >>> 56) & 255);
        bArr[i + 1] = (byte) ((j >>> 48) & 255);
        bArr[i + 2] = (byte) ((j >>> 40) & 255);
        bArr[i + 3] = (byte) ((j >>> 32) & 255);
        bArr[i + 4] = (byte) ((j >>> 24) & 255);
        bArr[i + 5] = (byte) ((j >>> 16) & 255);
        bArr[i + 6] = (byte) ((j >>> 8) & 255);
        bArr[i + 7] = (byte) (j & 255);
    }

    public static void writeUint8(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
    }
}
