package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class d1 extends j0 {
    d1(int i, int i2, int i3, g gVar) {
        super(i, i2, i3, gVar);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        a0 b = this.f0.b();
        boolean o = o();
        if (z) {
            int i = this.s;
            if (o || b.h()) {
                i |= 32;
            }
            yVar.a(true, i, this.A);
        }
        if (!o) {
            b.a(yVar, false);
            return;
        }
        yVar.c(128);
        b.a(yVar, true);
        yVar.c(0);
        yVar.c(0);
    }

    @Override // sdk.pendo.io.m3.j0
    d0 c(a0 a0Var) {
        return new z0(a0Var);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return o() || this.f0.b().h();
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        a0 b = this.f0.b();
        boolean o = o();
        int a2 = b.a(o);
        if (o) {
            a2 += 3;
        }
        return a2 + (z ? y.b(this.A) : 0);
    }
}
