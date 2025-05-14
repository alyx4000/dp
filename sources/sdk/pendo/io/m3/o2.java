package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class o2 extends j0 {
    o2(int i, int i2, int i3, g gVar) {
        super(i, i2, i3, gVar);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        a0 j = this.f0.b().j();
        boolean o = o();
        if (z) {
            int i = this.s;
            if (o || j.h()) {
                i |= 32;
            }
            yVar.a(true, i, this.A);
        }
        if (o) {
            yVar.d(j.a(true));
        }
        j.a(yVar.c(), o);
    }

    @Override // sdk.pendo.io.m3.j0
    d0 c(a0 a0Var) {
        return new k2(a0Var);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return o() || this.f0.b().j().h();
    }

    @Override // sdk.pendo.io.m3.j0, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    public o2(boolean z, int i, g gVar) {
        super(z, i, gVar);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        a0 j = this.f0.b().j();
        boolean o = o();
        int a2 = j.a(o);
        if (o) {
            a2 += y.a(a2);
        }
        return a2 + (z ? y.b(this.A) : 0);
    }
}
