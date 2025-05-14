package sdk.pendo.io.e5;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import okio.Utf8;
import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final short[] f1031a = new short[128];
    private static final byte[] b;

    static {
        byte[] bArr = new byte[112];
        b = bArr;
        byte[] bArr2 = new byte[128];
        a(bArr2, 0, 15, (byte) 1);
        a(bArr2, 16, 31, (byte) 2);
        a(bArr2, 32, 63, (byte) 3);
        a(bArr2, 64, 65, (byte) 0);
        a(bArr2, 66, 95, (byte) 4);
        a(bArr2, 96, 96, (byte) 5);
        a(bArr2, 97, 108, (byte) 6);
        a(bArr2, 109, 109, (byte) 7);
        a(bArr2, 110, 111, (byte) 6);
        a(bArr2, 112, 112, (byte) 8);
        a(bArr2, 113, 115, (byte) 9);
        a(bArr2, 116, 116, (byte) 10);
        a(bArr2, 117, 127, (byte) 0);
        a(bArr, 0, 111, (byte) -2);
        a(bArr, 8, 11, (byte) -1);
        a(bArr, 24, 27, (byte) 0);
        a(bArr, 40, 43, (byte) 16);
        a(bArr, 58, 59, (byte) 0);
        a(bArr, 72, 73, (byte) 0);
        a(bArr, 89, 91, (byte) 16);
        a(bArr, 104, 104, (byte) 16);
        byte[] bArr3 = {0, 0, 0, 0, BuiltinOptions.SequenceRNNOptions, 15, 15, 15, 7, 7, 7};
        byte[] bArr4 = {-2, -2, -2, -2, 0, BuiltinOptions.SliceOptions, 16, BuiltinOptions.UnpackOptions, BuiltinOptions.UniqueOptions, BuiltinOptions.StridedSliceOptions, BuiltinOptions.NonMaxSuppressionV5Options};
        for (int i = 0; i < 128; i++) {
            byte b2 = bArr2[i];
            f1031a[i] = (short) (bArr4[b2] | ((bArr3[b2] & i) << 8));
        }
    }

    private static void a(byte[] bArr, int i, int i2, byte b2) {
        while (i <= i2) {
            bArr[i] = b2;
            i++;
        }
    }

    public static int a(byte[] bArr, int i, int i2, char[] cArr) {
        int i3 = i2 + i;
        int i4 = 0;
        while (i < i3) {
            int i5 = i + 1;
            byte b2 = bArr[i];
            if (b2 < 0) {
                short s = f1031a[b2 & ByteCompanionObject.MAX_VALUE];
                int i6 = s >>> 8;
                byte b3 = (byte) s;
                while (b3 >= 0) {
                    if (i5 >= bArr.length) {
                        return -1;
                    }
                    int i7 = i5 + 1;
                    byte b4 = bArr[i5];
                    i6 = (i6 << 6) | (b4 & 63);
                    b3 = b[b3 + ((b4 & UByte.MAX_VALUE) >>> 4)];
                    i5 = i7;
                }
                if (b3 == -2) {
                    return -1;
                }
                if (i6 <= 65535) {
                    if (i4 >= cArr.length) {
                        return -1;
                    }
                    cArr[i4] = (char) i6;
                    i4++;
                } else {
                    if (i4 >= cArr.length - 1) {
                        return -1;
                    }
                    int i8 = i4 + 1;
                    cArr[i4] = (char) ((i6 >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
                    i4 = i8 + 1;
                    cArr[i8] = (char) ((i6 & 1023) | Utf8.LOG_SURROGATE_HEADER);
                }
                i = i5;
            } else {
                if (i4 >= cArr.length) {
                    return -1;
                }
                cArr[i4] = (char) b2;
                i = i5;
                i4++;
            }
        }
        return i4;
    }

    public static int a(byte[] bArr, char[] cArr) {
        return a(bArr, 0, bArr.length, cArr);
    }
}
