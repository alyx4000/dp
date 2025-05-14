package external.sdk.pendo.io.mozilla.javascript.v8dtoa;

import org.bouncycastle.asn1.cmc.BodyPartID;

/* loaded from: classes2.dex */
public class FastDtoa {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int kFastDtoaMaximalLength = 17;
    static final int kTen4 = 10000;
    static final int kTen5 = 100000;
    static final int kTen6 = 1000000;
    static final int kTen7 = 10000000;
    static final int kTen8 = 100000000;
    static final int kTen9 = 1000000000;
    static final int maximal_target_exponent = -32;
    static final int minimal_target_exponent = -60;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0040, code lost:
    
        if (10 <= r5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0045, code lost:
    
        if (1 <= r5) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static long biggestPowerTen(int r5, int r6) {
        /*
            r0 = 1
            r1 = 0
            switch(r6) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L45;
                case 3: goto L45;
                case 4: goto L3e;
                case 5: goto L3e;
                case 6: goto L3e;
                case 7: goto L38;
                case 8: goto L38;
                case 9: goto L38;
                case 10: goto L32;
                case 11: goto L32;
                case 12: goto L32;
                case 13: goto L32;
                case 14: goto L2c;
                case 15: goto L2c;
                case 16: goto L2c;
                case 17: goto L25;
                case 18: goto L25;
                case 19: goto L25;
                case 20: goto L1e;
                case 21: goto L1e;
                case 22: goto L1e;
                case 23: goto L1e;
                case 24: goto L17;
                case 25: goto L17;
                case 26: goto L17;
                case 27: goto Lf;
                case 28: goto Lf;
                case 29: goto Lf;
                case 30: goto L7;
                case 31: goto L7;
                case 32: goto L7;
                default: goto L5;
            }
        L5:
            r0 = r1
            goto L4c
        L7:
            r6 = 1000000000(0x3b9aca00, float:0.0047237873)
            if (r6 > r5) goto Lf
            r0 = 9
            goto L42
        Lf:
            r6 = 100000000(0x5f5e100, float:2.3122341E-35)
            if (r6 > r5) goto L17
            r0 = 8
            goto L42
        L17:
            r6 = 10000000(0x989680, float:1.4012985E-38)
            if (r6 > r5) goto L1e
            r0 = 7
            goto L42
        L1e:
            r6 = 1000000(0xf4240, float:1.401298E-39)
            if (r6 > r5) goto L25
            r0 = 6
            goto L42
        L25:
            r6 = 100000(0x186a0, float:1.4013E-40)
            if (r6 > r5) goto L2c
            r0 = 5
            goto L42
        L2c:
            r6 = 10000(0x2710, float:1.4013E-41)
            if (r6 > r5) goto L32
            r0 = 4
            goto L42
        L32:
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r6 > r5) goto L38
            r0 = 3
            goto L42
        L38:
            r6 = 100
            if (r6 > r5) goto L3e
            r0 = 2
            goto L42
        L3e:
            r6 = 10
            if (r6 > r5) goto L45
        L42:
            r1 = r0
            r0 = r6
            goto L4c
        L45:
            if (r0 > r5) goto L48
            goto L4c
        L48:
            r0 = -1
            r4 = r1
            r1 = r0
            r0 = r4
        L4c:
            long r5 = (long) r0
            r0 = 32
            long r5 = r5 << r0
            long r0 = (long) r1
            r2 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r0 = r0 & r2
            long r5 = r5 | r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.v8dtoa.FastDtoa.biggestPowerTen(int, int):long");
    }

    static boolean digitGen(DiyFp diyFp, DiyFp diyFp2, DiyFp diyFp3, FastDtoaBuilder fastDtoaBuilder, int i) {
        FastDtoaBuilder fastDtoaBuilder2;
        long f;
        long f2;
        long j;
        long f3;
        long j2;
        DiyFp diyFp4 = new DiyFp(diyFp.f() - 1, diyFp.e());
        DiyFp diyFp5 = new DiyFp(diyFp3.f() + 1, diyFp3.e());
        DiyFp minus = DiyFp.minus(diyFp5, diyFp4);
        DiyFp diyFp6 = new DiyFp(1 << (-diyFp2.e()), diyFp2.e());
        int f4 = (int) ((diyFp5.f() >>> (-diyFp6.e())) & BodyPartID.bodyIdMax);
        long f5 = diyFp5.f() & (diyFp6.f() - 1);
        long biggestPowerTen = biggestPowerTen(f4, 64 - (-diyFp6.e()));
        int i2 = (int) ((biggestPowerTen >>> 32) & BodyPartID.bodyIdMax);
        int i3 = ((int) (biggestPowerTen & BodyPartID.bodyIdMax)) + 1;
        while (true) {
            if (i3 > 0) {
                fastDtoaBuilder.append((char) ((f4 / i2) + 48));
                f4 %= i2;
                i3--;
                long j3 = (f4 << (-diyFp6.e())) + f5;
                if (j3 < minus.f()) {
                    fastDtoaBuilder.point = (fastDtoaBuilder.end - i) + i3;
                    long f6 = DiyFp.minus(diyFp5, diyFp2).f();
                    long f7 = minus.f();
                    long j4 = i2 << (-diyFp6.e());
                    fastDtoaBuilder2 = fastDtoaBuilder;
                    f = f6;
                    f2 = f7;
                    j = j3;
                    f3 = j4;
                    j2 = 1;
                    break;
                }
                i2 /= 10;
            } else {
                long j5 = 1;
                do {
                    long j6 = f5 * 5;
                    j5 *= 5;
                    minus.setF(minus.f() * 5);
                    minus.setE(minus.e() + 1);
                    diyFp6.setF(diyFp6.f() >>> 1);
                    diyFp6.setE(diyFp6.e() + 1);
                    fastDtoaBuilder.append((char) (((int) ((j6 >>> (-diyFp6.e())) & BodyPartID.bodyIdMax)) + 48));
                    f5 = j6 & (diyFp6.f() - 1);
                    i3--;
                } while (f5 >= minus.f());
                fastDtoaBuilder.point = (fastDtoaBuilder.end - i) + i3;
                fastDtoaBuilder2 = fastDtoaBuilder;
                f = DiyFp.minus(diyFp5, diyFp2).f() * j5;
                f2 = minus.f();
                j = f5;
                f3 = diyFp6.f();
                j2 = j5;
            }
        }
        return roundWeed(fastDtoaBuilder2, f, f2, j, f3, j2);
    }

    public static boolean dtoa(double d, FastDtoaBuilder fastDtoaBuilder) {
        return grisu3(d, fastDtoaBuilder);
    }

    static boolean grisu3(double d, FastDtoaBuilder fastDtoaBuilder) {
        long doubleToLongBits = Double.doubleToLongBits(d);
        DiyFp asNormalizedDiyFp = DoubleHelper.asNormalizedDiyFp(doubleToLongBits);
        DiyFp diyFp = new DiyFp();
        DiyFp diyFp2 = new DiyFp();
        DoubleHelper.normalizedBoundaries(doubleToLongBits, diyFp, diyFp2);
        DiyFp diyFp3 = new DiyFp();
        int cachedPower = CachedPowers.getCachedPower(asNormalizedDiyFp.e() + 64, minimal_target_exponent, maximal_target_exponent, diyFp3);
        return digitGen(DiyFp.times(diyFp, diyFp3), DiyFp.times(asNormalizedDiyFp, diyFp3), DiyFp.times(diyFp2, diyFp3), fastDtoaBuilder, cachedPower);
    }

    public static String numberToString(double d) {
        FastDtoaBuilder fastDtoaBuilder = new FastDtoaBuilder();
        if (numberToString(d, fastDtoaBuilder)) {
            return fastDtoaBuilder.format();
        }
        return null;
    }

    static boolean roundWeed(FastDtoaBuilder fastDtoaBuilder, long j, long j2, long j3, long j4, long j5) {
        long j6 = j - j5;
        long j7 = j + j5;
        long j8 = j3;
        while (j8 < j6 && j2 - j8 >= j4) {
            long j9 = j8 + j4;
            if (j9 >= j6 && j6 - j8 < j9 - j6) {
                break;
            }
            fastDtoaBuilder.decreaseLast();
            j8 = j9;
        }
        if (j8 < j7 && j2 - j8 >= j4) {
            long j10 = j8 + j4;
            if (j10 < j7 || j7 - j8 > j10 - j7) {
                return false;
            }
        }
        return 2 * j5 <= j8 && j8 <= j2 - (4 * j5);
    }

    private static boolean uint64_lte(long j, long j2) {
        if (j == j2) {
            return true;
        }
        return (((j > 0L ? 1 : (j == 0L ? 0 : -1)) < 0) ^ ((j > j2 ? 1 : (j == j2 ? 0 : -1)) < 0)) ^ ((j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) < 0);
    }

    public static boolean numberToString(double d, FastDtoaBuilder fastDtoaBuilder) {
        fastDtoaBuilder.reset();
        if (d < 0.0d) {
            fastDtoaBuilder.append('-');
            d = -d;
        }
        return dtoa(d, fastDtoaBuilder);
    }
}
