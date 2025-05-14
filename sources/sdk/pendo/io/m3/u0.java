package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class u0 extends c {
    private final int f0;
    private final c[] t0;

    public u0(byte[] bArr, int i) {
        this(bArr, i, 1000);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        if (!h()) {
            byte[] bArr = this.f;
            f2.a(yVar, z, bArr, 0, bArr.length);
            return;
        }
        yVar.b(z, 35);
        yVar.c(128);
        c[] cVarArr = this.t0;
        if (cVarArr != null) {
            yVar.a((a0[]) cVarArr);
        } else {
            byte[] bArr2 = this.f;
            if (bArr2.length >= 2) {
                byte b = bArr2[0];
                int length = bArr2.length;
                int i = length - 1;
                int i2 = this.f0 - 1;
                while (i > i2) {
                    f2.a(yVar, true, (byte) 0, this.f, length - i, i2);
                    i -= i2;
                }
                f2.a(yVar, true, b, this.f, length - i, i);
            }
        }
        yVar.c(0);
        yVar.c(0);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return this.t0 != null || this.f.length > this.f0;
    }

    public u0(byte[] bArr, int i, int i2) {
        super(bArr, i);
        this.t0 = null;
        this.f0 = i2;
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        if (!h()) {
            return f2.a(z, this.f.length);
        }
        int i = z ? 4 : 3;
        if (this.t0 == null) {
            byte[] bArr = this.f;
            if (bArr.length < 2) {
                return i;
            }
            int length = bArr.length - 2;
            int i2 = this.f0;
            int i3 = length / (i2 - 1);
            return i + (f2.a(true, i2) * i3) + f2.a(true, this.f.length - (i3 * (this.f0 - 1)));
        }
        int i4 = 0;
        while (true) {
            c[] cVarArr = this.t0;
            if (i4 >= cVarArr.length) {
                return i;
            }
            i += cVarArr[i4].a(true);
            i4++;
        }
    }

    public u0(c[] cVarArr) {
        this(cVarArr, 1000);
    }

    static byte[] a(c[] cVarArr) {
        int length = cVarArr.length;
        if (length == 0) {
            return new byte[]{0};
        }
        if (length == 1) {
            return cVarArr[0].f;
        }
        int i = length - 1;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr = cVarArr[i3].f;
            if (bArr[0] != 0) {
                throw new IllegalArgumentException("only the last nested bitstring can have padding");
            }
            i2 += bArr.length - 1;
        }
        byte[] bArr2 = cVarArr[i].f;
        byte b = bArr2[0];
        byte[] bArr3 = new byte[i2 + bArr2.length];
        bArr3[0] = b;
        int i4 = 1;
        for (c cVar : cVarArr) {
            byte[] bArr4 = cVar.f;
            int length2 = bArr4.length - 1;
            System.arraycopy(bArr4, 1, bArr3, i4, length2);
            i4 += length2;
        }
        return bArr3;
    }

    public u0(c[] cVarArr, int i) {
        super(a(cVarArr), false);
        this.t0 = cVarArr;
        this.f0 = i;
    }
}
