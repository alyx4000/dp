package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class k2 extends d0 {
    private int A;

    public k2() {
        this.A = -1;
    }

    private int s() {
        if (this.A < 0) {
            int length = this.f.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f[i2].b().j().a(true);
            }
            this.A = i;
        }
        return this.A;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.b(z, 48);
        j2 c = yVar.c();
        int length = this.f.length;
        int i = 0;
        if (this.A >= 0 || length > 16) {
            yVar.d(s());
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
        this.A = i2;
        yVar.d(i2);
        while (i < length) {
            c.a(a0VarArr[i], true);
            i++;
        }
    }

    @Override // sdk.pendo.io.m3.d0, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    @Override // sdk.pendo.io.m3.d0
    c n() {
        return new f2(u0.a(k()), false);
    }

    @Override // sdk.pendo.io.m3.d0
    k o() {
        return new h2(this);
    }

    @Override // sdk.pendo.io.m3.d0
    w p() {
        return new s1(x0.a(l()));
    }

    @Override // sdk.pendo.io.m3.d0
    e0 q() {
        return new m2(false, r());
    }

    public k2(g gVar) {
        super(gVar);
        this.A = -1;
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, s());
    }

    public k2(h hVar) {
        super(hVar);
        this.A = -1;
    }

    k2(g[] gVarArr, boolean z) {
        super(gVarArr, z);
        this.A = -1;
    }
}
