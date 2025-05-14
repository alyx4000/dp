package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public abstract class a extends j0 {
    final j0 t0;

    a(j0 j0Var) {
        super(j0Var.f, a(j0Var.s), j0Var.A, j0Var.f0);
        this.t0 = j0Var;
    }

    private static int a(int i) {
        if (64 == i) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    @Override // sdk.pendo.io.m3.j0
    d0 c(a0 a0Var) {
        return this.t0.c(a0Var);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return this.t0.h();
    }

    @Override // sdk.pendo.io.m3.j0, sdk.pendo.io.m3.a0
    a0 i() {
        return new h1((j0) this.t0.i());
    }

    @Override // sdk.pendo.io.m3.j0, sdk.pendo.io.m3.a0
    a0 j() {
        return new e2((j0) this.t0.j());
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        this.t0.a(yVar, z);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return this.t0.a(z);
    }
}
