package sdk.pendo.io.y4;

/* loaded from: classes4.dex */
public class t implements sdk.pendo.io.z4.t {

    /* renamed from: a, reason: collision with root package name */
    protected r1 f1802a;
    protected sdk.pendo.io.z4.h b;
    protected sdk.pendo.io.z4.t c;
    protected sdk.pendo.io.z4.t d;

    public t(t tVar) {
        this.f1802a = tVar.f1802a;
        this.b = tVar.b;
        this.c = tVar.c.d();
        this.d = tVar.d.d();
    }

    @Override // sdk.pendo.io.z4.t
    public void b(byte[] bArr, int i, int i2) {
        this.c.b(bArr, i, i2);
        this.d.b(bArr, i, i2);
    }

    @Override // sdk.pendo.io.z4.t
    public byte[] c() {
        r1 r1Var = this.f1802a;
        if (r1Var != null && l3.b(r1Var)) {
            z0.a(this.f1802a, this.c, this.d);
        }
        return sdk.pendo.io.d5.a.c(this.c.c(), this.d.c());
    }

    @Override // sdk.pendo.io.z4.t
    public sdk.pendo.io.z4.t d() {
        return new t(this);
    }

    @Override // sdk.pendo.io.z4.t
    public void reset() {
        this.c.reset();
        this.d.reset();
    }

    t(r1 r1Var, sdk.pendo.io.z4.t tVar, sdk.pendo.io.z4.t tVar2) {
        this.f1802a = r1Var;
        this.b = r1Var.b();
        this.c = tVar;
        this.d = tVar2;
    }

    public t(sdk.pendo.io.z4.h hVar) {
        this.b = hVar;
        this.c = hVar.d(1);
        this.d = hVar.d(2);
    }
}
