package sdk.pendo.io.h4;

import kotlin.jvm.internal.ByteCompanionObject;
import sdk.pendo.io.d5.f;

/* loaded from: classes6.dex */
public abstract class b implements sdk.pendo.io.g4.c {
    static final long[] o = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    private long c;
    private long d;
    protected long e;
    protected long f;
    protected long g;
    protected long h;
    protected long i;
    protected long j;
    protected long k;
    protected long l;
    private int n;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f1158a = new byte[8];
    private long[] m = new long[80];
    private int b = 0;

    protected b() {
        reset();
    }

    private long a(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    private long a(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    private long b(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    private long b(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    private long c(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    private long d(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    protected void e() {
        c();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.m;
            long b = b(jArr[i - 2]);
            long[] jArr2 = this.m;
            jArr[i] = b + jArr2[i - 7] + a(jArr2[i - 15]) + this.m[i - 16];
        }
        long j = this.e;
        long j2 = this.f;
        long j3 = this.g;
        long j4 = this.h;
        long j5 = this.i;
        long j6 = this.j;
        long j7 = this.k;
        long j8 = j6;
        long j9 = j4;
        int i2 = 0;
        long j10 = j2;
        long j11 = j3;
        long j12 = j5;
        int i3 = 0;
        long j13 = this.l;
        long j14 = j;
        long j15 = j7;
        while (i3 < 10) {
            long j16 = j12;
            long d = d(j12) + a(j12, j8, j15);
            long[] jArr3 = o;
            int i4 = i2 + 1;
            long j17 = j13 + d + jArr3[i2] + this.m[i2];
            long j18 = j9 + j17;
            long c = j17 + c(j14) + b(j14, j10, j11);
            int i5 = i4 + 1;
            long d2 = j15 + d(j18) + a(j18, j16, j8) + jArr3[i4] + this.m[i4];
            long j19 = j11 + d2;
            long c2 = d2 + c(c) + b(c, j14, j10);
            int i6 = i5 + 1;
            long d3 = j8 + d(j19) + a(j19, j18, j16) + jArr3[i5] + this.m[i5];
            long j20 = j10 + d3;
            long c3 = d3 + c(c2) + b(c2, c, j14);
            int i7 = i6 + 1;
            long d4 = j16 + d(j20) + a(j20, j19, j18) + jArr3[i6] + this.m[i6];
            long j21 = j14 + d4;
            long c4 = d4 + c(c3) + b(c3, c2, c);
            int i8 = i7 + 1;
            long d5 = j18 + d(j21) + a(j21, j20, j19) + jArr3[i7] + this.m[i7];
            long j22 = c + d5;
            long c5 = d5 + c(c4) + b(c4, c3, c2);
            int i9 = i8 + 1;
            long d6 = j19 + d(j22) + a(j22, j21, j20) + jArr3[i8] + this.m[i8];
            long j23 = c2 + d6;
            long c6 = d6 + c(c5) + b(c5, c4, c3);
            j15 = j23;
            int i10 = i9 + 1;
            long d7 = j20 + d(j23) + a(j23, j22, j21) + jArr3[i9] + this.m[i9];
            long j24 = c3 + d7;
            j8 = j24;
            j10 = d7 + c(c6) + b(c6, c5, c4);
            long d8 = j21 + d(j24) + a(j24, j15, j22) + jArr3[i10] + this.m[i10];
            long c7 = d8 + c(j10) + b(j10, c6, c5);
            i3++;
            j12 = c4 + d8;
            j11 = c6;
            j13 = j22;
            j9 = c5;
            i2 = i10 + 1;
            j14 = c7;
        }
        this.e += j14;
        this.f += j10;
        this.g += j11;
        this.h += j9;
        this.i += j12;
        this.j += j8;
        this.k += j15;
        this.l += j13;
        this.n = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.m[i11] = 0;
        }
    }

    @Override // sdk.pendo.io.g4.c
    public void reset() {
        this.c = 0L;
        this.d = 0L;
        int i = 0;
        this.b = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f1158a;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.n = 0;
        while (true) {
            long[] jArr = this.m;
            if (i == jArr.length) {
                return;
            }
            jArr[i] = 0;
            i++;
        }
    }

    private void c() {
        long j = this.c;
        if (j > 2305843009213693951L) {
            this.d += j >>> 61;
            this.c = j & 2305843009213693951L;
        }
    }

    public void d() {
        c();
        long j = this.c << 3;
        long j2 = this.d;
        byte b = ByteCompanionObject.MIN_VALUE;
        while (true) {
            a(b);
            if (this.b == 0) {
                a(j, j2);
                e();
                return;
            }
            b = 0;
        }
    }

    protected void a(long j, long j2) {
        if (this.n > 14) {
            e();
        }
        long[] jArr = this.m;
        jArr[14] = j2;
        jArr[15] = j;
    }

    protected void b(byte[] bArr, int i) {
        this.m[this.n] = f.b(bArr, i);
        int i2 = this.n + 1;
        this.n = i2;
        if (i2 == 16) {
            e();
        }
    }

    @Override // sdk.pendo.io.g4.c
    public void a(byte b) {
        byte[] bArr = this.f1158a;
        int i = this.b;
        int i2 = i + 1;
        this.b = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            b(bArr, 0);
            this.b = 0;
        }
        this.c++;
    }

    @Override // sdk.pendo.io.g4.c
    public void b(byte[] bArr, int i, int i2) {
        while (this.b != 0 && i2 > 0) {
            a(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > this.f1158a.length) {
            b(bArr, i);
            byte[] bArr2 = this.f1158a;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.c += bArr2.length;
        }
        while (i2 > 0) {
            a(bArr[i]);
            i++;
            i2--;
        }
    }
}
