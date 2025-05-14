package sdk.pendo.io.m3;

import java.io.IOException;

/* loaded from: classes6.dex */
public abstract class j0 extends a0 implements r2 {
    final int A;
    final int f;
    final g f0;
    final int s;

    j0(int i, int i2, int i3, g gVar) {
        if (gVar == null) {
            throw new NullPointerException("'obj' cannot be null");
        }
        if (i2 == 0 || (i2 & 192) != i2) {
            throw new IllegalArgumentException("invalid tag class: " + i2);
        }
        this.f = gVar instanceof f ? 1 : i;
        this.s = i2;
        this.A = i3;
        this.f0 = gVar;
    }

    static a0 b(int i, int i2, h hVar) {
        d1 d1Var = hVar.b() == 1 ? new d1(3, i, i2, hVar.a(0)) : new d1(4, i, i2, w0.a(hVar));
        return i != 64 ? d1Var : new s0(d1Var);
    }

    @Override // sdk.pendo.io.m3.a0
    final boolean a(a0 a0Var) {
        if (!(a0Var instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) a0Var;
        if (this.A != j0Var.A || this.s != j0Var.s) {
            return false;
        }
        if (this.f != j0Var.f && o() != j0Var.o()) {
            return false;
        }
        a0 b = this.f0.b();
        a0 b2 = j0Var.f0.b();
        if (b == b2) {
            return true;
        }
        if (o()) {
            return b.a(b2);
        }
        try {
            return sdk.pendo.io.d5.a.a(g(), j0Var.g());
        } catch (IOException unused) {
            return false;
        }
    }

    abstract d0 c(a0 a0Var);

    @Override // sdk.pendo.io.m3.r2
    public final a0 e() {
        return this;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return (((this.s * 7919) ^ this.A) ^ (o() ? 15 : 240)) ^ this.f0.b().hashCode();
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        return new z1(this.f, this.s, this.A, this.f0);
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        return new o2(this.f, this.s, this.A, this.f0);
    }

    public t k() {
        if (!o()) {
            throw new IllegalStateException("object implicit - explicit expected.");
        }
        g gVar = this.f0;
        return gVar instanceof t ? (t) gVar : gVar.b();
    }

    public a0 l() {
        if (128 == m()) {
            return this.f0.b();
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public int m() {
        return this.s;
    }

    public int n() {
        return this.A;
    }

    public boolean o() {
        int i = this.f;
        return i == 1 || i == 3;
    }

    public String toString() {
        return p0.a(this.s, this.A) + this.f0;
    }

    protected j0(boolean z, int i, int i2, g gVar) {
        this(z ? 1 : 2, i, i2, gVar);
    }

    static a0 a(int i, int i2, h hVar) {
        o2 o2Var = hVar.b() == 1 ? new o2(3, i, i2, hVar.a(0)) : new o2(4, i, i2, i2.a(hVar));
        return i != 64 ? o2Var : new e2(o2Var);
    }

    protected j0(boolean z, int i, g gVar) {
        this(z, 128, i, gVar);
    }

    static a0 a(int i, int i2, byte[] bArr) {
        o2 o2Var = new o2(4, i, i2, new s1(bArr));
        return i != 64 ? o2Var : new e2(o2Var);
    }

    a0 a(boolean z, o0 o0Var) {
        if (z) {
            if (o()) {
                return o0Var.a(this.f0.b());
            }
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        if (1 == this.f) {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
        a0 b = this.f0.b();
        int i = this.f;
        return i != 3 ? i != 4 ? o0Var.a(b) : b instanceof d0 ? o0Var.a((d0) b) : o0Var.a((s1) b) : o0Var.a(c(b));
    }
}
