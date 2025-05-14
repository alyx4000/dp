package external.sdk.pendo.io.mozilla.javascript;

import java.math.BigInteger;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes2.dex */
class DToA {
    private static final int Bias = 1023;
    private static final int Bletch = 16;
    private static final int Bndry_mask = 1048575;
    static final int DTOSTR_EXPONENTIAL = 3;
    static final int DTOSTR_FIXED = 2;
    static final int DTOSTR_PRECISION = 4;
    static final int DTOSTR_STANDARD = 0;
    static final int DTOSTR_STANDARD_EXPONENTIAL = 1;
    private static final int Exp_11 = 1072693248;
    private static final int Exp_mask = 2146435072;
    private static final int Exp_mask_shifted = 2047;
    private static final int Exp_msk1 = 1048576;
    private static final long Exp_msk1L = 4503599627370496L;
    private static final int Exp_shift = 20;
    private static final int Exp_shift1 = 20;
    private static final int Exp_shiftL = 52;
    private static final int Frac_mask = 1048575;
    private static final int Frac_mask1 = 1048575;
    private static final long Frac_maskL = 4503599627370495L;
    private static final int Int_max = 14;
    private static final int Log2P = 1;
    private static final int P = 53;
    private static final int Quick_max = 14;
    private static final int Sign_bit = Integer.MIN_VALUE;
    private static final int Ten_pmax = 22;
    private static final int n_bigtens = 5;
    private static final double[] tens = {1.0d, 10.0d, 100.0d, 1000.0d, 10000.0d, 100000.0d, 1000000.0d, 1.0E7d, 1.0E8d, 1.0E9d, 1.0E10d, 1.0E11d, 1.0E12d, 1.0E13d, 1.0E14d, 1.0E15d, 1.0E16d, 1.0E17d, 1.0E18d, 1.0E19d, 1.0E20d, 1.0E21d, 1.0E22d};
    private static final double[] bigtens = {1.0E16d, 1.0E32d, 1.0E64d, 1.0E128d, 1.0E256d};
    private static final int[] dtoaModes = {0, 0, 3, 2, 2};

    DToA() {
    }

    private static char BASEDIGIT(int i) {
        return (char) (i >= 10 ? i + 87 : i + 48);
    }

    /* JADX WARN: Code restructure failed: missing block: B:174:0x0453, code lost:
    
        if (r5 != 0) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0609, code lost:
    
        if (r45 == false) goto L373;
     */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e6  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x049f  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x04b1  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04d2  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x04d8  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x04e0  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0654 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0631  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x04cb  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x045f  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x0422  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static int JS_dtoa(double r42, int r44, boolean r45, int r46, boolean[] r47, java.lang.StringBuilder r48) {
        /*
            Method dump skipped, instructions count: 1663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.DToA.JS_dtoa(double, int, boolean, int, boolean[], java.lang.StringBuilder):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0115, code lost:
    
        if (r7 > 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0121, code lost:
    
        if (r9 > 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0130, code lost:
    
        if (r6.compareTo(r3) > 0) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0142 A[LOOP:0: B:40:0x00d9->B:53:0x0142, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x013d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static java.lang.String JS_dtobasestr(int r11, double r12) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.DToA.JS_dtobasestr(int, double):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0045, code lost:
    
        if (r1 <= r13) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void JS_dtostr(java.lang.StringBuilder r11, int r12, int r13, double r14) {
        /*
            Method dump skipped, instructions count: 202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.DToA.JS_dtostr(java.lang.StringBuilder, int, int, double):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.math.BigInteger d2b(double r8, int[] r10, int[] r11) {
        /*
            long r8 = java.lang.Double.doubleToLongBits(r8)
            r0 = 32
            long r1 = r8 >>> r0
            int r1 = (int) r1
            int r8 = (int) r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r9 = r9 & r1
            r2 = 2147483647(0x7fffffff, float:NaN)
            r1 = r1 & r2
            int r1 = r1 >>> 20
            if (r1 == 0) goto L19
            r2 = 1048576(0x100000, float:1.469368E-39)
            r9 = r9 | r2
        L19:
            r2 = 1
            r3 = 4
            r4 = 0
            if (r8 == 0) goto L3d
            r5 = 8
            byte[] r5 = new byte[r5]
            int r6 = lo0bits(r8)
            int r8 = r8 >>> r6
            if (r6 == 0) goto L33
            int r7 = 32 - r6
            int r7 = r9 << r7
            r8 = r8 | r7
            stuffBits(r5, r3, r8)
            int r9 = r9 >> r6
            goto L36
        L33:
            stuffBits(r5, r3, r8)
        L36:
            stuffBits(r5, r4, r9)
            if (r9 == 0) goto L49
            r8 = 2
            goto L4a
        L3d:
            byte[] r5 = new byte[r3]
            int r8 = lo0bits(r9)
            int r9 = r9 >>> r8
            stuffBits(r5, r4, r9)
            int r6 = r8 + 32
        L49:
            r8 = r2
        L4a:
            if (r1 == 0) goto L58
            int r1 = r1 + (-1023)
            int r1 = r1 + (-52)
            int r1 = r1 + r6
            r10[r4] = r1
            int r8 = 53 - r6
            r11[r4] = r8
            goto L68
        L58:
            int r1 = r1 + (-1023)
            int r1 = r1 + (-52)
            int r1 = r1 + r2
            int r1 = r1 + r6
            r10[r4] = r1
            int r8 = r8 * r0
            int r9 = hi0bits(r9)
            int r8 = r8 - r9
            r11[r4] = r8
        L68:
            java.math.BigInteger r8 = new java.math.BigInteger
            r8.<init>(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.DToA.d2b(double, int[], int[]):java.math.BigInteger");
    }

    private static int hi0bits(int i) {
        int i2;
        if (((-65536) & i) == 0) {
            i <<= 16;
            i2 = 16;
        } else {
            i2 = 0;
        }
        if (((-16777216) & i) == 0) {
            i2 += 8;
            i <<= 8;
        }
        if (((-268435456) & i) == 0) {
            i2 += 4;
            i <<= 4;
        }
        if (((-1073741824) & i) == 0) {
            i2 += 2;
            i <<= 2;
        }
        if ((Integer.MIN_VALUE & i) == 0) {
            i2++;
            if ((i & 1073741824) == 0) {
                return 32;
            }
        }
        return i2;
    }

    private static int lo0bits(int i) {
        int i2 = 0;
        if ((i & 7) != 0) {
            if ((i & 1) != 0) {
                return 0;
            }
            return (i & 2) != 0 ? 1 : 2;
        }
        if ((65535 & i) == 0) {
            i >>>= 16;
            i2 = 16;
        }
        if ((i & 255) == 0) {
            i2 += 8;
            i >>>= 8;
        }
        if ((i & 15) == 0) {
            i2 += 4;
            i >>>= 4;
        }
        if ((i & 3) == 0) {
            i2 += 2;
            i >>>= 2;
        }
        if ((i & 1) == 0) {
            i2++;
            if (((i >>> 1) & 1) == 0) {
                return 32;
            }
        }
        return i2;
    }

    static BigInteger pow5mult(BigInteger bigInteger, int i) {
        return bigInteger.multiply(BigInteger.valueOf(5L).pow(i));
    }

    static boolean roundOff(StringBuilder sb) {
        int length = sb.length();
        while (length != 0) {
            length--;
            char charAt = sb.charAt(length);
            if (charAt != '9') {
                sb.setCharAt(length, (char) (charAt + 1));
                sb.setLength(length + 1);
                return false;
            }
        }
        sb.setLength(0);
        return true;
    }

    static double setWord0(double d, int i) {
        return Double.longBitsToDouble((Double.doubleToLongBits(d) & BodyPartID.bodyIdMax) | (i << 32));
    }

    private static void stripTrailingZeroes(StringBuilder sb) {
        int i;
        int length = sb.length();
        while (true) {
            i = length - 1;
            if (length <= 0 || sb.charAt(i) != '0') {
                break;
            } else {
                length = i;
            }
        }
        sb.setLength(i + 1);
    }

    private static void stuffBits(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    static int word0(double d) {
        return (int) (Double.doubleToLongBits(d) >> 32);
    }

    static int word1(double d) {
        return (int) Double.doubleToLongBits(d);
    }
}
