package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class x1 extends e0 {
    private int f0;

    public x1() {
        this.f0 = -1;
    }

    private static boolean b(boolean z) {
        if (z) {
            return z;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    private int l() {
        if (this.f0 < 0) {
            int length = this.f.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f[i2].b().i().a(true);
            }
            this.f0 = i;
        }
        return this.f0;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.b(z, 49);
        u1 b = yVar.b();
        int length = this.f.length;
        int i = 0;
        if (this.f0 >= 0 || length > 16) {
            yVar.d(l());
            while (i < length) {
                this.f[i].b().i().a((y) b, true);
                i++;
            }
            return;
        }
        a0[] a0VarArr = new a0[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            a0 i4 = this.f[i3].b().i();
            a0VarArr[i3] = i4;
            i2 += i4.a(true);
        }
        this.f0 = i2;
        yVar.d(i2);
        while (i < length) {
            a0VarArr[i].a((y) b, true);
            i++;
        }
    }

    @Override // sdk.pendo.io.m3.e0, sdk.pendo.io.m3.a0
    a0 i() {
        return this.s ? this : super.i();
    }

    @Override // sdk.pendo.io.m3.e0, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    x1(boolean z, g[] gVarArr) {
        super(b(z), gVarArr);
        this.f0 = -1;
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, l());
    }
}
