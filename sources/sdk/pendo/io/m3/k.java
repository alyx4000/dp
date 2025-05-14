package sdk.pendo.io.m3;

/* loaded from: classes6.dex */
public abstract class k extends a0 {
    static final o0 u0 = new a(k.class, 8);
    a0 A;
    v f;
    int f0;
    q s;
    a0 t0;

    static class a extends o0 {
        a(Class cls, int i) {
            super(cls, i);
        }

        @Override // sdk.pendo.io.m3.o0
        a0 a(d0 d0Var) {
            return d0Var.o();
        }
    }

    k(v vVar, q qVar, a0 a0Var, int i, a0 a0Var2) {
        this.f = vVar;
        this.s = qVar;
        this.A = a0Var;
        this.f0 = a(i);
        this.t0 = a(i, a0Var2);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean a(a0 a0Var) {
        if (this == a0Var) {
            return true;
        }
        if (!(a0Var instanceof k)) {
            return false;
        }
        k kVar = (k) a0Var;
        return sdk.pendo.io.d5.e.a(this.f, kVar.f) && sdk.pendo.io.d5.e.a(this.s, kVar.s) && sdk.pendo.io.d5.e.a(this.A, kVar.A) && this.f0 == kVar.f0 && this.t0.b(kVar.t0);
    }

    @Override // sdk.pendo.io.m3.a0
    boolean h() {
        return true;
    }

    @Override // sdk.pendo.io.m3.a0, sdk.pendo.io.m3.t
    public int hashCode() {
        return (((sdk.pendo.io.d5.e.a(this.f) ^ sdk.pendo.io.d5.e.a(this.s)) ^ sdk.pendo.io.d5.e.a(this.A)) ^ this.f0) ^ this.t0.hashCode();
    }

    @Override // sdk.pendo.io.m3.a0
    a0 i() {
        return new k1(this.f, this.s, this.A, this.f0, this.t0);
    }

    @Override // sdk.pendo.io.m3.a0
    a0 j() {
        return new h2(this.f, this.s, this.A, this.f0, this.t0);
    }

    abstract d0 k();

    k(d0 d0Var) {
        int i = 0;
        a0 a2 = a(d0Var, 0);
        if (a2 instanceof v) {
            this.f = (v) a2;
            a2 = a(d0Var, 1);
            i = 1;
        }
        if (a2 instanceof q) {
            this.s = (q) a2;
            i++;
            a2 = a(d0Var, i);
        }
        if (!(a2 instanceof j0)) {
            this.A = a2;
            i++;
            a2 = a(d0Var, i);
        }
        if (d0Var.size() != i + 1) {
            throw new IllegalArgumentException("input sequence too large");
        }
        if (!(a2 instanceof j0)) {
            throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn't seem to be of type External");
        }
        j0 j0Var = (j0) a2;
        this.f0 = a(j0Var.n());
        this.t0 = a(j0Var);
    }

    private static int a(int i) {
        if (i < 0 || i > 2) {
            throw new IllegalArgumentException("invalid encoding value: " + i);
        }
        return i;
    }

    private static a0 a(int i, a0 a0Var) {
        o0 o0Var;
        if (i == 1) {
            o0Var = w.s;
        } else {
            if (i != 2) {
                return a0Var;
            }
            o0Var = c.s;
        }
        return o0Var.a(a0Var);
    }

    @Override // sdk.pendo.io.m3.a0
    void a(y yVar, boolean z) {
        yVar.b(z, 40);
        k().a(yVar, false);
    }

    @Override // sdk.pendo.io.m3.a0
    int a(boolean z) {
        return k().a(z);
    }

    private static a0 a(j0 j0Var) {
        int m = j0Var.m();
        int n = j0Var.n();
        if (128 != m) {
            throw new IllegalArgumentException("invalid tag: " + p0.a(m, n));
        }
        if (n == 0) {
            return j0Var.k().b();
        }
        if (n == 1) {
            return w.a(j0Var, false);
        }
        if (n == 2) {
            return c.a(j0Var, false);
        }
        throw new IllegalArgumentException("invalid tag: " + p0.a(m, n));
    }

    private static a0 a(d0 d0Var, int i) {
        if (d0Var.size() > i) {
            return d0Var.a(i).b();
        }
        throw new IllegalArgumentException("too few objects in input sequence");
    }
}
