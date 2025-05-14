package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public class f2 extends c {
    f2(byte[] bArr, boolean z) {
        super(bArr, z);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.a(z, 3, this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.c, sdk.pendo.io.m3.a0
    a0 j() {
        return this;
    }

    static void a(y yVar, boolean z, byte b, byte[] bArr, int i, int i2) {
        yVar.a(z, 3, b, bArr, i, i2);
    }

    static void a(y yVar, boolean z, byte[] bArr, int i, int i2) {
        yVar.a(z, 3, bArr, i, i2);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return y.a(z, this.f.length);
    }

    static int a(boolean z, int i) {
        return y.a(z, i);
    }
}
