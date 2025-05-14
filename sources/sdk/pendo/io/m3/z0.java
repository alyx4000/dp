package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class z0 extends d0 {
    public z0() {
    }

    public z0(g gVar) {
        super(gVar);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 48, this.f);
    }

    @Override // sdk.pendo.io.m3.d0
    c n() {
        return new u0(k());
    }

    @Override // sdk.pendo.io.m3.d0
    k o() {
        return ((d0) j()).o();
    }

    @Override // sdk.pendo.io.m3.d0
    w p() {
        return new x0(l());
    }

    @Override // sdk.pendo.io.m3.d0
    e0 q() {
        return new b1(false, r());
    }

    public z0(h hVar) {
        super(hVar);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        int i = z ? 4 : 3;
        int length = this.f.length;
        for (int i2 = 0; i2 < length; i2++) {
            i += this.f[i2].b().a(true);
        }
        return i;
    }
}
