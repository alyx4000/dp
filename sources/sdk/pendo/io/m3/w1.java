package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class w1 extends d0 {
    private int A;

    public w1() {
        this.A = -1;
    }

    public static w1 a(d0 d0Var) {
        return (w1) d0Var.i();
    }

    private int s() {
        if (this.A < 0) {
            int length = this.f.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f[i2].b().i().a(true);
            }
            this.A = i;
        }
        return this.A;
    }

    @Override // sdk.pendo.io.m3.d0, sdk.pendo.io.m3.a0
    a0 i() {
        return this;
    }

    @Override // sdk.pendo.io.m3.d0, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    @Override // sdk.pendo.io.m3.d0
    c n() {
        return new j1(u0.a(k()), false);
    }

    @Override // sdk.pendo.io.m3.d0
    k o() {
        return new k1(this);
    }

    @Override // sdk.pendo.io.m3.d0
    w p() {
        return new s1(x0.a(l()));
    }

    @Override // sdk.pendo.io.m3.d0
    e0 q() {
        return new m2(false, r());
    }

    public w1(g gVar) {
        super(gVar);
        this.A = -1;
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.b(z, 48);
        u1 b = yVar.b();
        int length = this.f.length;
        int i = 0;
        if (this.A >= 0 || length > 16) {
            yVar.d(s());
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
        this.A = i2;
        yVar.d(i2);
        while (i < length) {
            a0VarArr[i].a((y) b, true);
            i++;
        }
    }

    public w1(h hVar) {
        super(hVar);
        this.A = -1;
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, s());
    }

    public w1(g[] gVarArr) {
        super(gVarArr);
        this.A = -1;
    }

    w1(g[] gVarArr, boolean z) {
        super(gVarArr, z);
        this.A = -1;
    }
}
