package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class b1 extends e0 {
    public b1() {
    }

    public b1(h hVar) {
        super(hVar, false);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 49, this.f);
    }

    b1(boolean z, g[] gVarArr) {
        super(z, gVarArr);
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
