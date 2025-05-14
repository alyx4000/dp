package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class z1 extends j0 {
    z1(int i, int i2, int i3, g gVar) {
        super(i, i2, i3, gVar);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        a0 i = this.f0.b().i();
        boolean o = o();
        if (z) {
            int i2 = this.s;
            if (o || i.h()) {
                i2 |= 32;
            }
            yVar.a(true, i2, this.A);
        }
        if (o) {
            yVar.d(i.a(true));
        }
        i.a(yVar.b(), o);
    }

    @Override // sdk.pendo.io.m3.j0
    d0 c(a0 a0Var) {
        return new w1(a0Var);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return o() || this.f0.b().i().h();
    }

    @Override // sdk.pendo.io.m3.j0, sdk.pendo.io.m3.a0
    a0 i() {
        return this;
    }

    @Override // sdk.pendo.io.m3.j0, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    public z1(boolean z, int i, g gVar) {
        super(z, i, gVar);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        a0 i = this.f0.b().i();
        boolean o = o();
        int a2 = i.a(o);
        if (o) {
            a2 += y.a(a2);
        }
        return a2 + (z ? y.b(this.A) : 0);
    }
}
