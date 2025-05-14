package sdk.pendo.io.y4;

import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes4.dex */
public abstract class f extends e implements d3 {
    protected g3 c;
    protected v0[] d;
    protected int[] e;
    protected int[] f;
    protected Hashtable g;
    protected boolean h;
    protected short i;
    protected boolean j;
    protected boolean k;
    protected p l;
    protected Vector m;
    protected Vector n;
    protected int o;
    protected Vector p;
    protected u0 q;
    protected final Hashtable r;

    public f(sdk.pendo.io.z4.h hVar) {
        super(hVar);
        this.r = new Hashtable();
    }

    @Override // sdk.pendo.io.y4.d3
    public t2 E() {
        return null;
    }

    @Override // sdk.pendo.io.y4.d3
    public b3 F() {
        return null;
    }

    @Override // sdk.pendo.io.y4.d3
    public q0 K() {
        return new q0(0L, l3.e);
    }

    @Override // sdk.pendo.io.y4.d3
    public sdk.pendo.io.z4.o L() {
        return b2.a(this.c, d(b2.a(this.o)));
    }

    @Override // sdk.pendo.io.y4.d3
    public Vector O() {
        return null;
    }

    protected abstract boolean R();

    protected boolean S() {
        return true;
    }

    protected abstract boolean T();

    protected boolean U() {
        return false;
    }

    protected abstract boolean V();

    protected abstract int W();

    protected abstract int X();

    protected abstract Vector Y();

    protected abstract boolean Z();

    public v0 a() {
        v0[] f = f();
        for (v0 v0Var : this.c.c()) {
            if (v0.a(f, v0Var)) {
                return v0Var;
            }
        }
        throw new h2((short) 70);
    }

    @Override // sdk.pendo.io.y4.d3
    public void a(v0 v0Var) {
    }

    protected u0 a0() {
        Vector Y = Y();
        if (Y == null || Y.isEmpty()) {
            return null;
        }
        u0 a2 = a(this.p, Y);
        if (a2 != null) {
            return a2;
        }
        throw new h2((short) 120);
    }

    @Override // sdk.pendo.io.y4.d3
    public r2 b(Vector vector) {
        return null;
    }

    protected abstract boolean b0();

    protected abstract int c(int i);

    protected abstract int d(int i);

    @Override // sdk.pendo.io.y4.v2
    public v0[] f() {
        return this.d;
    }

    @Override // sdk.pendo.io.y4.d3
    public sdk.pendo.io.z4.l j() {
        return z1.a(this.c, c(z1.a(this.o)));
    }

    public Hashtable k() {
        Hashtable hashtable;
        Integer num;
        if (!l3.d(this.c)) {
            if (this.h && S() && l3.n(this.o)) {
                g2.a(this.r);
            }
            if (this.j && U()) {
                g2.d(this.r);
            }
            if (this.k && b2.b(this.o)) {
                g2.b(this.r, new short[]{0});
            }
            if (this.m == null || !T()) {
                if (this.l != null && R()) {
                    hashtable = this.r;
                    num = g2.x;
                }
                if (this.n != null && V()) {
                    g2.e(this.r);
                }
            } else {
                hashtable = this.r;
                num = g2.y;
            }
            g2.a(hashtable, num);
            if (this.n != null) {
                g2.e(this.r);
            }
        } else if (this.l != null) {
            R();
        }
        short s = this.i;
        if (s >= 0 && n0.a(s)) {
            g2.a(this.r, this.i);
        }
        return this.r;
    }

    public int q() {
        a1 d = this.c.d();
        v0 s = d.s();
        if (l3.e(s)) {
            int a2 = l3.a(s, this.f, r(), Z());
            if (a2 >= 0 && b(a2)) {
                return a2;
            }
        } else {
            Vector b = l3.b(d.h());
            int W = W();
            int X = X();
            for (int i : l3.a(this.f, r(), Z())) {
                if (a(i, W, X, b) && b(i)) {
                    return i;
                }
            }
        }
        throw new h2((short) 40, "No selectable cipher suite");
    }

    @Override // sdk.pendo.io.y4.v2
    public int[] r() {
        return this.e;
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public void u() {
        super.u();
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = (short) 0;
        this.j = false;
        this.k = false;
        this.l = null;
        this.o = -1;
        this.q = null;
        this.r.clear();
    }

    @Override // sdk.pendo.io.y4.d3
    public void a(g3 g3Var) {
        this.c = g3Var;
        this.d = Q();
        this.e = P();
    }

    @Override // sdk.pendo.io.y4.d3
    public void b(Hashtable hashtable) {
        Vector vector;
        if (!b0() && (vector = this.p) != null && !vector.isEmpty()) {
            this.q = a0();
        }
        u0 u0Var = this.q;
        if (u0Var == null) {
            hashtable.remove(g2.f1779a);
        } else {
            g2.a(hashtable, u0Var);
        }
    }

    protected boolean a(int i, int i2, int i3, Vector vector) {
        return l3.a(i, this.c.a()) && i2 >= b2.a(i) && i3 >= z1.a(i) && l3.a(i, vector);
    }

    protected boolean b(int i) {
        this.o = i;
        return true;
    }

    @Override // sdk.pendo.io.y4.d3
    public void a(boolean z) {
        v0 b;
        if (z) {
            v0[] f = f();
            v0 j = this.c.j();
            if (j.h()) {
                b = v0.c(f);
            } else {
                if (!j.f()) {
                    throw new h2((short) 80);
                }
                b = v0.b(f);
            }
            if (b != null && b.f(j)) {
                throw new h2((short) 86);
            }
        }
    }

    @Override // sdk.pendo.io.y4.d3
    public void a(int[] iArr) {
        this.f = iArr;
    }

    public void a(Hashtable hashtable) {
        Vector vector;
        this.g = hashtable;
        if (hashtable != null) {
            this.p = g2.g(hashtable);
            if (b0() && (vector = this.p) != null && !vector.isEmpty()) {
                this.q = a0();
            }
            this.h = g2.C(hashtable);
            this.j = g2.F(hashtable);
            this.m = g2.w(hashtable);
            this.n = g2.B(hashtable);
            this.k = g2.y(hashtable) != null;
            this.l = g2.v(hashtable);
            short n = g2.n(hashtable);
            this.i = n;
            if (n >= 0 && !n0.a(n)) {
                throw new h2((short) 47);
            }
        }
    }

    @Override // sdk.pendo.io.y4.d3
    public void a(Vector vector) {
        if (vector != null) {
            throw new h2((short) 10);
        }
    }

    protected u0 a(Vector vector, Vector vector2) {
        for (int i = 0; i < vector2.size(); i++) {
            u0 u0Var = (u0) vector2.elementAt(i);
            if (vector.contains(u0Var)) {
                return u0Var;
            }
        }
        return null;
    }
}
