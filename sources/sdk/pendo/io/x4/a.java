package sdk.pendo.io.x4;

import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import org.bouncycastle.asn1.cmc.BodyPartID;
import sdk.pendo.io.d5.d;

/* loaded from: classes4.dex */
public abstract class a {
    private static void a(int i, int i2, int[] iArr) {
        int i3 = i - 1;
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + ((iArr[i5] ^ i2) - i2);
            iArr[i5] = 1073741823 & i6;
            i4 = i6 >> 30;
        }
        iArr[i3] = i4 + ((iArr[i3] ^ i2) - i2);
    }

    public static int b(int i) {
        int i2 = (2 - (i * i)) * i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        return i4 * (2 - (i * i4));
    }

    private static void b(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            if (i4 < Math.min(30, i)) {
                j |= (iArr[i2] & BodyPartID.bodyIdMax) << i4;
                i4 += 32;
                i2++;
            }
            iArr2[i3] = ((int) j) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j >>>= 30;
            i4 -= 30;
            i -= 30;
            i3++;
        }
    }

    private static void a(int i, int i2, int[] iArr, int[] iArr2) {
        int i3 = i - 1;
        int i4 = iArr[i3] >> 31;
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i5 + (((iArr[i6] + (iArr2[i6] & i4)) ^ i2) - i2);
            iArr[i6] = 1073741823 & i7;
            i5 = i7 >> 30;
        }
        int i8 = i5 + (((iArr[i3] + (i4 & iArr2[i3])) ^ i2) - i2);
        iArr[i3] = i8;
        int i9 = i8 >> 31;
        int i10 = 0;
        for (int i11 = 0; i11 < i3; i11++) {
            int i12 = i10 + iArr[i11] + (iArr2[i11] & i9);
            iArr[i11] = i12 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            i10 = i12 >> 30;
        }
        iArr[i3] = i10 + iArr[i3] + (i9 & iArr2[i3]);
    }

    private static void a(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = 0;
        long j = 0;
        while (i > 0) {
            while (i4 < Math.min(32, i)) {
                j |= iArr[i2] << i4;
                i4 += 30;
                i2++;
            }
            iArr2[i3] = (int) j;
            j >>>= 32;
            i4 -= 32;
            i -= 32;
            i3++;
        }
    }

    private static int a(int i, int i2, int i3, int[] iArr) {
        int i4 = 1073741824;
        int i5 = 1073741824;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < 30; i8++) {
            int i9 = i >> 31;
            int i10 = -(i3 & 1);
            int i11 = i3 - ((i2 ^ i9) & i10);
            int i12 = i7 - ((i4 ^ i9) & i10);
            int i13 = i5 - ((i6 ^ i9) & i10);
            int i14 = (~i9) & i10;
            i = (i ^ i14) - (i14 - 1);
            i2 += i11 & i14;
            i4 += i12 & i14;
            i6 += i14 & i13;
            i3 = i11 >> 1;
            i7 = i12 >> 1;
            i5 = i13 >> 1;
        }
        iArr[0] = i4;
        iArr[1] = i6;
        iArr[2] = i7;
        iArr[3] = i5;
        return i;
    }

    private static int a(int i) {
        return ((i * 49) + (i < 46 ? 80 : 47)) / 17;
    }

    public static int a(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int a2 = (length << 5) - d.a(iArr[length - 1]);
        int i = (a2 + 29) / 30;
        int[] iArr4 = new int[4];
        int[] iArr5 = new int[i];
        int[] iArr6 = new int[i];
        int[] iArr7 = new int[i];
        int[] iArr8 = new int[i];
        int[] iArr9 = new int[i];
        int i2 = 0;
        iArr6[0] = 1;
        b(a2, iArr2, 0, iArr8, 0);
        b(a2, iArr, 0, iArr9, 0);
        System.arraycopy(iArr9, 0, iArr7, 0, i);
        int b = b(iArr9[0]);
        int i3 = 0;
        int i4 = 0;
        for (int a3 = a(a2); i4 < a3; a3 = a3) {
            int a4 = a(i3, iArr7[i2], iArr8[i2], iArr4);
            a(i, iArr5, iArr6, iArr4, b, iArr9);
            a(i, iArr7, iArr8, iArr4);
            i4 += 30;
            i2 = i2;
            i3 = a4;
        }
        int i5 = i2;
        int i6 = iArr7[i - 1] >> 31;
        a(i, i6, iArr7);
        a(i, i6, iArr5, iArr9);
        a(a2, iArr5, i5, iArr3, i5);
        return b.a(i, iArr7, 1) & b.a(i, iArr8);
    }

    private static void a(int i, int[] iArr, int[] iArr2, int[] iArr3, int i2, int[] iArr4) {
        int i3 = i;
        int i4 = iArr3[0];
        int i5 = iArr3[1];
        int i6 = iArr3[2];
        int i7 = iArr3[3];
        int i8 = i3 - 1;
        int i9 = iArr[i8] >> 31;
        int i10 = iArr2[i8] >> 31;
        int i11 = (i4 & i9) + (i5 & i10);
        int i12 = (i9 & i6) + (i10 & i7);
        int i13 = iArr4[0];
        long j = i4;
        long j2 = iArr[0];
        long j3 = i5;
        long j4 = iArr2[0];
        long j5 = (j * j2) + (j3 * j4);
        long j6 = i6;
        long j7 = i7;
        long j8 = (j2 * j6) + (j4 * j7);
        long j9 = i13;
        long j10 = i11 - (((((int) j5) * i2) + i11) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        int i14 = i8;
        long j11 = i12 - (((((int) j8) * i2) + i12) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        long j12 = (j8 + (j9 * j11)) >> 30;
        long j13 = (j5 + (j9 * j10)) >> 30;
        int i15 = 1;
        while (i15 < i3) {
            int i16 = iArr4[i15];
            long j14 = j12;
            long j15 = iArr[i15];
            int i17 = i15;
            long j16 = iArr2[i15];
            long j17 = j11;
            long j18 = i16;
            long j19 = j13 + (j * j15) + (j3 * j16) + (j18 * j10);
            long j20 = j14 + (j15 * j6) + (j16 * j7) + (j18 * j17);
            int i18 = i17 - 1;
            iArr[i18] = ((int) j19) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j13 = j19 >> 30;
            iArr2[i18] = ((int) j20) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j12 = j20 >> 30;
            i15 = i17 + 1;
            i3 = i;
            i14 = i14;
            j11 = j17;
        }
        int i19 = i14;
        iArr[i19] = (int) j13;
        iArr2[i19] = (int) j12;
    }

    private static void a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int i2 = iArr3[0];
        int i3 = 1;
        int i4 = iArr3[1];
        int i5 = iArr3[2];
        int i6 = iArr3[3];
        long j = i2;
        long j2 = iArr[0];
        long j3 = i4;
        long j4 = iArr2[0];
        long j5 = i5;
        long j6 = i6;
        long j7 = ((j * j2) + (j3 * j4)) >> 30;
        long j8 = ((j2 * j5) + (j4 * j6)) >> 30;
        int i7 = 1;
        while (i7 < i) {
            int i8 = iArr[i7];
            int i9 = iArr2[i7];
            int i10 = i7;
            long j9 = i8;
            long j10 = j * j9;
            long j11 = j;
            long j12 = i9;
            long j13 = j7 + j10 + (j3 * j12);
            long j14 = j8 + (j9 * j5) + (j12 * j6);
            int i11 = i10 - 1;
            iArr[i11] = ((int) j13) & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
            j7 = j13 >> 30;
            iArr2[i11] = 1073741823 & ((int) j14);
            j8 = j14 >> 30;
            i7 = i10 + 1;
            j = j11;
            i3 = 1;
        }
        int i12 = i - i3;
        iArr[i12] = (int) j7;
        iArr2[i12] = (int) j8;
    }
}
