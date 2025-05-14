package sdk.pendo.io.m3;

import java.io.OutputStream;

/* loaded from: classes6.dex */
class j2 extends y {
    j2(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // sdk.pendo.io.m3.y
    void a(g[] gVarArr) {
        for (g gVar : gVarArr) {
            gVar.b().j().a((y) this, true);
        }
    }

    @Override // sdk.pendo.io.m3.y
    j2 c() {
        return this;
    }

    @Override // sdk.pendo.io.m3.y
    void a(a0 a0Var, boolean z) {
        a0Var.j().a(this, z);
    }

    @Override // sdk.pendo.io.m3.y
    void a(a0[] a0VarArr) {
        for (a0 a0Var : a0VarArr) {
            a0Var.j().a((y) this, true);
        }
    }
}
