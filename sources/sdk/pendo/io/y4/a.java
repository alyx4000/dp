package sdk.pendo.io.y4;

import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes4.dex */
public abstract class a extends e implements m1 {
    protected n1 c;
    protected v0[] d;
    protected int[] e;
    protected Vector f;
    protected Vector g;
    protected Vector h;

    public a(sdk.pendo.io.z4.h hVar) {
        super(hVar);
    }

    @Override // sdk.pendo.io.y4.m1
    public z2 D() {
        return null;
    }

    @Override // sdk.pendo.io.y4.m1
    public Hashtable J() {
        Vector R;
        Hashtable hashtable = new Hashtable();
        boolean z = false;
        boolean z2 = false;
        for (v0 v0Var : f()) {
            if (l3.e(v0Var)) {
                z = true;
            } else {
                z2 = true;
            }
        }
        Vector V = V();
        if (V != null) {
            g2.a(hashtable, V);
        }
        Vector W = W();
        if (W != null) {
            g2.d(hashtable, W);
        }
        p S = S();
        if (S != null) {
            g2.a(hashtable, S);
        }
        if (z && (R = R()) != null) {
            g2.b(hashtable, R);
        }
        if (z2) {
            g2.a(hashtable);
            Vector T = T();
            if (T != null) {
                g2.g(hashtable, T);
            }
            Vector Z = Z();
            if (Z != null) {
                g2.i(hashtable, Z);
            }
        }
        if (l3.b(this.c.j())) {
            Vector X = X();
            if (X != null && !X.isEmpty()) {
                this.g = X;
                g2.f(hashtable, X);
            }
            Vector Y = Y();
            if (Y != null && !Y.isEmpty()) {
                this.h = Y;
                g2.e(hashtable, Y);
            }
        }
        Vector U = U();
        Vector d = d(U);
        if (d != null && !d.isEmpty()) {
            this.f = d;
            g2.h(hashtable, d);
        }
        if (z2 && (U.contains(sdk.pendo.io.d5.d.b(2)) || U.contains(sdk.pendo.io.d5.d.b(3)))) {
            g2.b(hashtable, new short[]{0});
        }
        return hashtable;
    }

    protected abstract Vector R();

    protected abstract p S();

    protected abstract Vector T();

    protected Vector U() {
        Vector c = l3.c(r());
        Vector vector = this.g;
        Vector vector2 = this.h;
        if (vector == null || l3.a(vector, (short) 3) || (vector2 != null && l3.a(vector2, (short) 3))) {
            l3.a(c, 3);
        }
        return c;
    }

    protected abstract Vector V();

    protected abstract Vector W();

    protected abstract Vector X();

    protected abstract Vector Y();

    protected abstract Vector Z();

    public void a(int i) {
    }

    @Override // sdk.pendo.io.y4.m1
    public void a(q0 q0Var) {
    }

    @Override // sdk.pendo.io.y4.m1
    public void a(q2 q2Var) {
    }

    protected boolean a(Integer num, byte[] bArr) {
        int intValue = num.intValue();
        if (intValue == 10) {
            g2.w(bArr);
            return true;
        }
        if (intValue != 11) {
            return false;
        }
        g2.x(bArr);
        return true;
    }

    public void b(j3 j3Var) {
    }

    public void b(v0 v0Var) {
    }

    public void c(Hashtable hashtable) {
        if (hashtable == null) {
            return;
        }
        a1 d = this.c.d();
        if (l3.e(d.s())) {
            return;
        }
        a(hashtable, g2.v);
        a(hashtable, g2.w);
        a(hashtable, g2.z);
        if (b2.b(d.e())) {
            g2.y(hashtable);
        } else {
            a(hashtable, g2.h);
        }
        a(hashtable, g2.o);
    }

    protected abstract Vector d(Vector vector);

    @Override // sdk.pendo.io.y4.m1
    public Vector e() {
        Object elementAt;
        Vector vector = this.f;
        if (vector == null || vector.isEmpty()) {
            return null;
        }
        int i = 29;
        if (!this.f.contains(sdk.pendo.io.d5.d.b(29))) {
            i = 23;
            if (!this.f.contains(sdk.pendo.io.d5.d.b(23))) {
                elementAt = this.f.elementAt(0);
                return l3.a(elementAt);
            }
        }
        elementAt = sdk.pendo.io.d5.d.b(i);
        return l3.a(elementAt);
    }

    @Override // sdk.pendo.io.y4.v2
    public v0[] f() {
        return this.d;
    }

    @Override // sdk.pendo.io.y4.m1
    public boolean g() {
        return false;
    }

    @Override // sdk.pendo.io.y4.m1
    public Vector l() {
        return null;
    }

    @Override // sdk.pendo.io.y4.m1
    public Vector n() {
        return null;
    }

    @Override // sdk.pendo.io.y4.v2
    public int[] r() {
        return this.e;
    }

    @Override // sdk.pendo.io.y4.m1
    public y2 s() {
        return new z();
    }

    @Override // sdk.pendo.io.y4.e, sdk.pendo.io.y4.v2
    public void u() {
        super.u();
        this.f = null;
        this.g = null;
        this.h = null;
    }

    @Override // sdk.pendo.io.y4.m1
    public s2 y() {
        return null;
    }

    protected void a(Hashtable hashtable, Integer num) {
        byte[] a2 = l3.a(hashtable, num);
        if (a2 != null && !a(num, a2)) {
            throw new h2((short) 47);
        }
    }

    @Override // sdk.pendo.io.y4.m1
    public void c(Vector vector) {
        if (vector != null) {
            throw new h2((short) 10);
        }
    }

    @Override // sdk.pendo.io.y4.m1
    public void a(n1 n1Var) {
        this.c = n1Var;
        this.d = Q();
        this.e = P();
    }
}
