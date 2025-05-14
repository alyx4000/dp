package sdk.pendo.io.t4;

import java.util.List;
import sdk.pendo.io.y4.j3;

/* loaded from: classes6.dex */
class v0 extends w0 {
    static final v0 m = new v0(null, null, -1, null, new z(null, null));
    protected final j3 j;
    protected final sdk.pendo.io.y4.g1 k;
    protected final z l;

    v0(x0 x0Var, String str, int i, j3 j3Var, z zVar) {
        super(x0Var, str, i);
        this.j = j3Var;
        this.k = j3Var == null ? null : j3Var.c();
        this.l = zVar;
    }

    @Override // sdk.pendo.io.r4.b
    public String[] a() {
        return null;
    }

    @Override // sdk.pendo.io.r4.b
    public String[] c() {
        return null;
    }

    @Override // sdk.pendo.io.r4.b
    public List<sdk.pendo.io.r4.e> e() {
        throw new UnsupportedOperationException();
    }

    @Override // sdk.pendo.io.t4.w0
    protected int h() {
        sdk.pendo.io.y4.g1 g1Var = this.k;
        if (g1Var == null) {
            return 0;
        }
        return g1Var.c();
    }

    @Override // sdk.pendo.io.t4.w0, javax.net.ssl.SSLSession
    public boolean isValid() {
        j3 j3Var;
        return super.isValid() && (j3Var = this.j) != null && j3Var.b();
    }

    @Override // sdk.pendo.io.t4.w0
    protected byte[] j() {
        j3 j3Var = this.j;
        if (j3Var == null) {
            return null;
        }
        return j3Var.a();
    }

    @Override // sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.l k() {
        sdk.pendo.io.y4.g1 g1Var = this.k;
        if (g1Var == null) {
            return null;
        }
        return g1Var.e();
    }

    @Override // sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.l l() {
        sdk.pendo.io.y4.g1 g1Var = this.k;
        if (g1Var == null) {
            return null;
        }
        return g1Var.i();
    }

    @Override // sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.v0 m() {
        sdk.pendo.io.y4.g1 g1Var = this.k;
        if (g1Var == null) {
            return null;
        }
        return g1Var.g();
    }

    @Override // sdk.pendo.io.t4.w0
    protected void n() {
        j3 j3Var = this.j;
        if (j3Var != null) {
            j3Var.invalidate();
        }
    }

    protected z p() {
        return this.l;
    }

    j3 q() {
        return this.j;
    }
}
