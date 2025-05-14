package sdk.pendo.io.m3;

import java.io.OutputStream;

/* loaded from: classes6.dex */
class u1 extends j2 {
    u1(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // sdk.pendo.io.m3.j2, sdk.pendo.io.m3.y
    void a(g[] gVarArr) {
        for (g gVar : gVarArr) {
            gVar.b().i().a((y) this, true);
        }
    }

    @Override // sdk.pendo.io.m3.y
    u1 b() {
        return this;
    }

    @Override // sdk.pendo.io.m3.j2, sdk.pendo.io.m3.y
    void a(a0 a0Var, boolean z) {
        a0Var.i().a(this, z);
    }

    @Override // sdk.pendo.io.m3.j2, sdk.pendo.io.m3.y
    void a(a0[] a0VarArr) {
        for (a0 a0Var : a0VarArr) {
            a0Var.i().a((y) this, true);
        }
    }
}
