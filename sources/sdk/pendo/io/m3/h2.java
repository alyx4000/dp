package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class h2 extends k {
    public h2(h hVar) {
        this(i2.a(hVar));
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
            hVar.a(a0Var.j());
        }
        int i = this.f0;
        hVar.a(new o2(i == 0, i, this.t0));
        return new k2(hVar);
    }

    public h2(v vVar, q qVar, a0 a0Var, int i, a0 a0Var2) {
        super(vVar, qVar, a0Var, i, a0Var2);
    }

    public h2(k2 k2Var) {
        super(k2Var);
    }
}
