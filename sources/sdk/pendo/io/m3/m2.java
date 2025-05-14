package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class m2 extends e0 {
    private int f0;

    public m2() {
        this.f0 = -1;
    }

    private int l() {
        if (this.f0 < 0) {
            int length = this.f.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f[i2].b().j().a(true);
            }
            this.f0 = i;
        }
        return this.f0;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.b(z, 49);
        j2 c = yVar.c();
        int length = this.f.length;
        int i = 0;
        if (this.f0 >= 0 || length > 16) {
            yVar.d(l());
            while (i < length) {
                c.a(this.f[i].b(), true);
                i++;
            }
            return;
        }
        a0[] a0VarArr = new a0[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            a0 j = this.f[i3].b().j();
            a0VarArr[i3] = j;
            i2 += j.a(true);
        }
        this.f0 = i2;
        yVar.d(i2);
        while (i < length) {
            c.a(a0VarArr[i], true);
            i++;
        }
    }

    @Override // sdk.pendo.io.m3.e0, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    public m2(h hVar) {
        super(hVar, false);
        this.f0 = -1;
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, l());
    }

    m2(boolean z, g[] gVarArr) {
        super(z, gVarArr);
        this.f0 = -1;
    }
}
