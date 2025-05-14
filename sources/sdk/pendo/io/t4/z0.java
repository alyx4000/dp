package sdk.pendo.io.t4;

import sdk.pendo.io.y4.j3;

/* loaded from: classes6.dex */
class z0 extends y0 {
    protected final j3 l;
    protected final sdk.pendo.io.y4.g1 m;
    protected final z n;

    z0(x0 x0Var, String str, int i, sdk.pendo.io.y4.a1 a1Var, y yVar, j3 j3Var, z zVar) {
        super(x0Var, str, i, a1Var, yVar);
        this.l = j3Var;
        this.m = j3Var.c();
        this.n = zVar;
    }

    @Override // sdk.pendo.io.t4.y0, sdk.pendo.io.t4.w0
    protected int h() {
        return this.m.c();
    }

    @Override // sdk.pendo.io.t4.w0, javax.net.ssl.SSLSession
    public boolean isValid() {
        return super.isValid() && this.l.b();
    }

    @Override // sdk.pendo.io.t4.y0, sdk.pendo.io.t4.w0
    protected byte[] j() {
        return this.l.a();
    }

    @Override // sdk.pendo.io.t4.y0, sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.l k() {
        return this.m.e();
    }

    @Override // sdk.pendo.io.t4.y0, sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.l l() {
        return this.m.i();
    }

    @Override // sdk.pendo.io.t4.y0, sdk.pendo.io.t4.w0
    protected sdk.pendo.io.y4.v0 m() {
        return this.m.g();
    }

    @Override // sdk.pendo.io.t4.y0, sdk.pendo.io.t4.w0
    protected void n() {
        this.l.invalidate();
    }
}
