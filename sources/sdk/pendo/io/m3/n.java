package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public abstract class n extends a0 implements g0 {
    static final o0 s = new a(n.class, 25);
    final byte[] f;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return n.b(s1Var.k());
        }
    }

    n(byte[] bArr, boolean z) {
        if (bArr == null) {
            throw new NullPointerException("'contents' cannot be null");
        }
        this.f = z ? sdk.pendo.io.d5.a.a(bArr) : bArr;
    }

    static n b(byte[] bArr) {
        return new o1(bArr, false);
    }

    @Override // sdk.pendo.io.m3.a0
    final boolean a(a0 a0Var) {
        if (a0Var instanceof n) {
            return sdk.pendo.io.d5.a.a(this.f, ((n) a0Var).f);
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

    @Override // sdk.pendo.io.m3.a0
    final void a(y yVar, boolean z) {
        yVar.a(z, 25, this.f);
    }

    @Override // sdk.pendo.io.m3.a0
    final int a(boolean z) {
        return y.a(z, this.f.length);
    }
}
