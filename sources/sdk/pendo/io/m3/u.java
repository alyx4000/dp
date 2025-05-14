package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public final class u extends a0 {
    static final o0 s = new a(u.class, 7);
    private final n f;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(d0 d0Var) {
            return new u((n) n.s.a(d0Var));
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(s1 s1Var) {
            return new u((n) n.s.a(s1Var));
        }
    }

    public u(n nVar) {
        if (nVar == null) {
            throw new NullPointerException("'baseGraphicString' cannot be null");
        }
        this.f = nVar;
    }

    static u b(byte[] bArr) {
        return new u(n.b(bArr));
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (a0Var instanceof u) {
            return this.f.a(((u) a0Var).f);
        }
        return false;
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return false;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return ~this.f.hashCode();
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        n nVar = (n) this.f.i();
        return nVar == this.f ? this : new u(nVar);
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        n nVar = (n) this.f.j();
        return nVar == this.f ? this : new u(nVar);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.b(z, 7);
        this.f.a(yVar, false);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return this.f.a(z);
    }
}
