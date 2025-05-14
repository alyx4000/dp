package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public abstract class b0 extends a0 implements g0 {
    static final o0 s = new a(b0.class, 19);
    final byte[] f;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return b0.b(s1Var.k());
        }
    }

    b0(byte[] bArr, boolean z) {
        this.f = z ? sdk.pendo.io.d5.a.a(bArr) : bArr;
    }

    static b0 b(byte[] bArr) {
        return new v1(bArr, false);
    }

    @Override // sdk.pendo.io.m3.a0
    final boolean a(a0 a0Var) {
        if (a0Var instanceof b0) {
            return sdk.pendo.io.d5.a.a(this.f, ((b0) a0Var).f);
        }
        return false;
    }

    @Override // sdk.pendo.io.m3.g0
    public final String c() {
        return sdk.pendo.io.d5.i.b(this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    final boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public final int hashCode() {
        return sdk.pendo.io.d5.a.b(this.f);
    }

    public String toString() {
        return c();
    }

    @Override // sdk.pendo.io.m3.a0
    final void a(y yVar, boolean z) {
        yVar.a(z, 19, this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    final int a(boolean z) {
        return y.a(z, this.f.length);
    }
}
