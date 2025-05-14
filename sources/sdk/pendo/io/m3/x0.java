package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class x0 extends w {
    private final int f0;
    private final w[] t0;

    public x0(byte[] bArr) {
        this(bArr, 1000);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        if (!h()) {
            byte[] bArr = this.f;
            s1.a(yVar, z, bArr, 0, bArr.length);
            return;
        }
        yVar.b(z, 36);
        yVar.c(128);
        w[] wVarArr = this.t0;
        if (wVarArr == null) {
            int i = 0;
            while (true) {
                byte[] bArr2 = this.f;
                if (i >= bArr2.length) {
                    break;
                }
                int min = Math.min(bArr2.length - i, this.f0);
                s1.a(yVar, true, this.f, i, min);
                i += min;
            }
        } else {
            yVar.a((a0[]) wVarArr);
        }
        yVar.c(0);
        yVar.c(0);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return this.t0 != null || this.f.length > this.f0;
    }

    public x0(byte[] bArr, int i) {
        this(bArr, null, i);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        if (!h()) {
            return s1.a(z, this.f.length);
        }
        int i = z ? 4 : 3;
        if (this.t0 == null) {
            int length = this.f.length;
            int i2 = this.f0;
            int i3 = length / i2;
            int a2 = i + (s1.a(true, i2) * i3);
            int length2 = this.f.length - (i3 * this.f0);
            return length2 > 0 ? a2 + s1.a(true, length2) : a2;
        }
        int i4 = 0;
        while (true) {
            w[] wVarArr = this.t0;
            if (i4 >= wVarArr.length) {
                return i;
            }
            i += wVarArr[i4].a(true);
            i4++;
        }
    }

    private x0(byte[] bArr, w[] wVarArr, int i) {
        super(bArr);
        this.t0 = wVarArr;
        this.f0 = i;
    }

    static byte[] a(w[] wVarArr) {
        int length = wVarArr.length;
        if (length == 0) {
            return w.A;
        }
        if (length == 1) {
            return wVarArr[0].f;
        }
        int i = 0;
        for (w wVar : wVarArr) {
            i += wVar.f.length;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (w wVar2 : wVarArr) {
            byte[] bArr2 = wVar2.f;
            System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
            i2 += bArr2.length;
        }
        return bArr;
    }

    public x0(w[] wVarArr) {
        this(wVarArr, 1000);
    }

    public x0(w[] wVarArr, int i) {
        this(a(wVarArr), wVarArr, i);
    }
}
