package sdk.pendo.io.h4;

import kotlin.UByte;
import org.tensorflow.lite.schema.BuiltinOptions;
import sdk.pendo.io.d5.f;

/* loaded from: classes6.dex */
public class c extends a {
    static final int[] n = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private int m;

    public c() {
        this.l = new int[64];
        reset();
    }

    private static int a(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    private static int a(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    private static int b(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    private static int b(int i, int i2, int i3) {
        return ((i ^ i2) & i3) | (i & i2);
    }

    private static int c(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    private static int d(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    @Override // sdk.pendo.io.g4.c
    public String a() {
        return "SHA-256";
    }

    @Override // sdk.pendo.io.g4.c
    public int b() {
        return 32;
    }

    @Override // sdk.pendo.io.h4.a, sdk.pendo.io.g4.c
    public void reset() {
        super.reset();
        this.d = 1779033703;
        this.e = -1150833019;
        this.f = 1013904242;
        this.g = -1521486534;
        this.h = 1359893119;
        this.i = -1694144372;
        this.j = 528734635;
        this.k = 1541459225;
        this.m = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.l;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public c(c cVar) {
        super(cVar);
        this.l = new int[64];
        a(cVar);
    }

    @Override // sdk.pendo.io.h4.a
    protected void d() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.l;
            int d = d(iArr[i - 2]);
            int[] iArr2 = this.l;
            iArr[i] = d + iArr2[i - 7] + c(iArr2[i - 15]) + this.l[i - 16];
        }
        int i2 = this.d;
        int i3 = this.e;
        int i4 = this.f;
        int i5 = this.g;
        int i6 = this.h;
        int i7 = this.i;
        int i8 = this.j;
        int i9 = this.k;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int b = b(i6) + a(i6, i7, i8);
            int[] iArr3 = n;
            int i12 = i9 + b + iArr3[i10] + this.l[i10];
            int i13 = i5 + i12;
            int a2 = i12 + a(i2) + b(i2, i3, i4);
            int i14 = i10 + 1;
            int b2 = i8 + b(i13) + a(i13, i6, i7) + iArr3[i14] + this.l[i14];
            int i15 = i4 + b2;
            int a3 = b2 + a(a2) + b(a2, i2, i3);
            int i16 = i14 + 1;
            int b3 = i7 + b(i15) + a(i15, i13, i6) + iArr3[i16] + this.l[i16];
            int i17 = i3 + b3;
            int a4 = b3 + a(a3) + b(a3, a2, i2);
            int i18 = i16 + 1;
            int b4 = i6 + b(i17) + a(i17, i15, i13) + iArr3[i18] + this.l[i18];
            int i19 = i2 + b4;
            int a5 = b4 + a(a4) + b(a4, a3, a2);
            int i20 = i18 + 1;
            int b5 = i13 + b(i19) + a(i19, i17, i15) + iArr3[i20] + this.l[i20];
            i9 = a2 + b5;
            i5 = b5 + a(a5) + b(a5, a4, a3);
            int i21 = i20 + 1;
            int b6 = i15 + b(i9) + a(i9, i19, i17) + iArr3[i21] + this.l[i21];
            i8 = a3 + b6;
            i4 = b6 + a(i5) + b(i5, a5, a4);
            int i22 = i21 + 1;
            int b7 = i17 + b(i8) + a(i8, i9, i19) + iArr3[i22] + this.l[i22];
            i7 = a4 + b7;
            i3 = b7 + a(i4) + b(i4, i5, a5);
            int i23 = i22 + 1;
            int b8 = i19 + b(i7) + a(i7, i8, i9) + iArr3[i23] + this.l[i23];
            i6 = a5 + b8;
            i2 = b8 + a(i3) + b(i3, i4, i5);
            i10 = i23 + 1;
        }
        this.d += i2;
        this.e += i3;
        this.f += i4;
        this.g += i5;
        this.h += i6;
        this.i += i7;
        this.j += i8;
        this.k += i9;
        this.m = 0;
        for (int i24 = 0; i24 < 16; i24++) {
            this.l[i24] = 0;
        }
    }

    private void a(c cVar) {
        super.a((a) cVar);
        this.d = cVar.d;
        this.e = cVar.e;
        this.f = cVar.f;
        this.g = cVar.g;
        this.h = cVar.h;
        this.i = cVar.i;
        this.j = cVar.j;
        this.k = cVar.k;
        int[] iArr = cVar.l;
        System.arraycopy(iArr, 0, this.l, 0, iArr.length);
        this.m = cVar.m;
    }

    @Override // sdk.pendo.io.g4.c
    public int a(byte[] bArr, int i) {
        c();
        f.a(this.d, bArr, i);
        f.a(this.e, bArr, i + 4);
        f.a(this.f, bArr, i + 8);
        f.a(this.g, bArr, i + 12);
        f.a(this.h, bArr, i + 16);
        f.a(this.i, bArr, i + 20);
        f.a(this.j, bArr, i + 24);
        f.a(this.k, bArr, i + 28);
        reset();
        return 32;
    }

    @Override // sdk.pendo.io.h4.a
    protected void b(byte[] bArr, int i) {
        int i2 = bArr[i] << BuiltinOptions.BatchToSpaceNDOptions;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & UByte.MAX_VALUE) << 16);
        int i5 = i3 + 1;
        int i6 = (bArr[i5 + 1] & UByte.MAX_VALUE) | i4 | ((bArr[i5] & UByte.MAX_VALUE) << 8);
        int[] iArr = this.l;
        int i7 = this.m;
        iArr[i7] = i6;
        int i8 = i7 + 1;
        this.m = i8;
        if (i8 == 16) {
            d();
        }
    }

    @Override // sdk.pendo.io.h4.a
    protected void a(long j) {
        if (this.m > 14) {
            d();
        }
        int[] iArr = this.l;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & (-1));
    }
}
