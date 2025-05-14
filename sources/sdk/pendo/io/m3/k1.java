package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class k1 extends k {
    public k1(v vVar, q qVar, a0 a0Var, int i, a0 a0Var2) {
        super(vVar, qVar, a0Var, i, a0Var2);
    }

    @Override // sdk.pendo.io.m3.k, sdk.pendo.io.m3.a0
    a0 i() {
        return this;
    }

    @Override // sdk.pendo.io.m3.k, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    @Override // sdk.pendo.io.m3.k
    d0 k() {
        h hVar = new h(4);
        v vVar = this.f;
        if (vVar != null) {
            hVar.a(vVar);
        }
        q qVar = this.s;
        if (qVar != null) {
            hVar.a(qVar);
        }
        a0 a0Var = this.A;
        if (a0Var != null) {
            hVar.a(a0Var.i());
        }
        int i = this.f0;
        hVar.a(new z1(i == 0, i, this.t0));
        return new w1(hVar);
    }

    public k1(w1 w1Var) {
        super(w1Var);
    }
}
