package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import sdk.pendo.io.y4.s0;

/* loaded from: classes4.dex */
public class p1 extends w2 {
    protected m1 I;
    o1 J;
    protected Hashtable K;
    s0.a L;
    protected s M;
    protected l2 N;
    protected l1 O;
    protected o P;
    protected n Q;

    public p1() {
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
    }

    protected void H() {
        l3.a(this.J, this.P, this.N, this.O, this.w, this.x);
    }

    protected void I() {
        Hashtable c = this.M.c();
        c.remove(g2.f);
        c.remove(g2.g);
        c.remove(g2.l);
        c.remove(g2.q);
        byte[] bArr = this.u;
        if (bArr != null) {
            g2.a(c, bArr);
            this.u = null;
        }
        s0.a aVar = this.L;
        if (aVar != null) {
            s0.a a2 = l3.a(this.J, aVar, c);
            this.L = a2;
            if (a2 == null) {
                this.I.a((q2) null);
            }
        }
        int i = this.v;
        if (i < 0) {
            throw new h2((short) 80);
        }
        this.K = l3.a(this.J, c, i);
        this.d.b(true);
        F();
        K();
    }

    protected void J() {
        v0[] f;
        v0 a2;
        v0 c;
        byte[] bArr;
        v0 v0Var;
        g1 g1Var;
        g1 g1Var2;
        a1 d = this.J.d();
        if (d.O()) {
            a2 = this.J.j();
            f = a2.i();
            c = a2;
        } else {
            f = this.I.f();
            v0 v0Var2 = v0.c;
            if (v0.a(f, v0Var2)) {
                this.d.a(v0Var2);
            } else {
                this.d.a(v0.d);
            }
            a2 = v0.a(f);
            c = v0.c(f);
            if (!v0.g(c)) {
                throw new h2((short) 80);
            }
            this.J.a(c);
        }
        this.J.a(f);
        v0 v0Var3 = v0.f;
        boolean e = v0Var3.e(a2);
        boolean d2 = v0.g.d(c);
        a(e ? this.I.A() : null);
        this.I.b(this.r);
        byte[] a3 = l3.a(this.r);
        boolean g = this.I.g();
        int[] r = this.I.r();
        if (a3.length > 0 && (g1Var2 = this.s) != null && (!sdk.pendo.io.d5.a.b(r, g1Var2.c()) || this.s.d() != 0)) {
            a3 = l3.e;
        }
        Hashtable f2 = g2.f(this.I.J());
        this.w = f2;
        if (d2) {
            g2.a(f2, f);
            if (a3.length < 1) {
                a3 = this.J.k().a(32);
            }
            bArr = a3;
            v0Var = v0Var3;
        } else {
            bArr = a3;
            v0Var = c;
        }
        this.J.b(v0Var);
        d.J = g2.s(this.w);
        if (l3.b(c)) {
            l3.a(d, this.w);
        }
        d.M = g2.x(this.w);
        this.L = l3.a(this.J, this.I, this.w, r);
        this.K = l3.a(this.J, this.I, this.w);
        if (l3.a(f) && (this.I.d() || ((g1Var = this.s) != null && g1Var.k()))) {
            g2.b(this.w);
        } else if (!d2 && this.I.i()) {
            throw new h2((short) 80);
        }
        d.u = w2.a(!d2 && this.I.w(), this.J);
        if (!d.O()) {
            boolean z = l3.a(this.w, w2.G) == null;
            boolean z2 = !sdk.pendo.io.d5.a.b(r, 255);
            if (z && z2) {
                r = sdk.pendo.io.d5.a.a(r, 255);
            }
        } else {
            if (!d.P()) {
                throw new h2((short) 80);
            }
            this.w.put(w2.G, w2.a(this.J.e().p()));
        }
        int[] a4 = (!g || sdk.pendo.io.d5.a.b(r, 22016)) ? r : sdk.pendo.io.d5.a.a(r, 22016);
        s0.a aVar = this.L;
        this.M = new s(v0Var, d.f(), bArr, null, a4, this.w, aVar != null ? aVar.d : 0);
        K();
    }

    protected void K() {
        g0 g0Var = new g0((short) 1);
        this.M.a(this.J, g0Var);
        g0Var.a(this.g, this.M.a());
        if (this.L != null) {
            s0.a(g0Var, this.J.b(), this.g, this.L);
        }
        g0Var.a(this, this.g, this.M.a());
    }

    protected void L() {
        g0 g0Var = new g0((short) 16);
        this.N.a(g0Var);
        g0Var.a(this);
    }

    protected void M() {
        this.Q = null;
    }

    protected void N() {
        if (!this.A) {
            throw new h2((short) 10);
        }
        this.O = l3.a((n1) this.J);
    }

    @Override // sdk.pendo.io.y4.w2
    protected void a(boolean z) {
        super.a(z);
        J();
        this.y = (short) 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b(short r8, sdk.pendo.io.y4.f0 r9) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.p1.b(short, sdk.pendo.io.y4.f0):void");
    }

    @Override // sdk.pendo.io.y4.w2
    protected void c() {
        super.c();
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
    }

    protected void g(ByteArrayInputStream byteArrayInputStream) {
        byte[] b = l3.b(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        Hashtable a2 = w2.a(8, b);
        this.x = a2;
        Enumeration keys = a2.keys();
        while (keys.hasMoreElements()) {
            if (l3.a(this.w, (Integer) keys.nextElement()) == null) {
                throw new h2((short) 110);
            }
        }
        a1 d = this.J.d();
        v0 s = d.s();
        d.G = g2.h(this.x);
        d.H = true;
        Hashtable hashtable = this.w;
        Hashtable hashtable2 = this.x;
        if (this.z) {
            if (d.e() != this.s.c() || this.s.d() != 0 || !s.b(this.s.g())) {
                throw new h2((short) 47);
            }
            hashtable2 = this.s.l();
            hashtable = null;
        }
        d.f = a(hashtable, hashtable2, (short) 47);
        d.C = false;
        d.F = false;
        d.U = this.w.containsKey(g2.x) ? 1 : 0;
        this.C = false;
        if (hashtable != null) {
            this.I.c(this.x);
        }
        a(d.r());
    }

    protected void h(ByteArrayInputStream byteArrayInputStream) {
        if (!s()) {
            throw new h2((short) 10);
        }
        l3.f(byteArrayInputStream);
        l3.f(byteArrayInputStream);
        l3.c(byteArrayInputStream);
        l3.b(byteArrayInputStream);
        l3.b(byteArrayInputStream);
        w2.a(byteArrayInputStream);
    }

    protected void i(ByteArrayInputStream byteArrayInputStream) {
        if (this.A) {
            throw new h2((short) 10);
        }
        this.O = l3.a(this.J, this.I, byteArrayInputStream);
        H();
    }

    protected void j(ByteArrayInputStream byteArrayInputStream) {
        l x = this.J.d().x();
        if (x == null || x.d()) {
            throw new h2((short) 80);
        }
        d0 a2 = d0.a(this.J, byteArrayInputStream);
        w2.a(byteArrayInputStream);
        l3.a(this.J, a2, this.g);
    }

    @Override // sdk.pendo.io.y4.w2
    protected r1 k() {
        return this.J;
    }

    @Override // sdk.pendo.io.y4.w2
    b l() {
        return this.J;
    }

    @Override // sdk.pendo.io.y4.w2
    protected v2 m() {
        return this.I;
    }

    protected b1 n(ByteArrayInputStream byteArrayInputStream) {
        return b1.a(byteArrayInputStream);
    }

    public p1(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
    }

    public void a(m1 m1Var) {
        if (m1Var == null) {
            throw new IllegalArgumentException("'tlsClient' cannot be null");
        }
        if (this.I != null) {
            throw new IllegalStateException("'connect' can only be called once");
        }
        this.I = m1Var;
        o1 o1Var = new o1(m1Var.b());
        this.J = o1Var;
        m1Var.a(o1Var);
        m1Var.a(this);
        a(false);
        if (this.D) {
            b();
        }
    }

    protected void b(Vector vector) {
        this.I.c(vector);
        this.y = (short) 6;
        this.N = l3.a(this.J, this.I);
    }

    protected void k(ByteArrayInputStream byteArrayInputStream) {
        b(byteArrayInputStream);
    }

    protected void l(ByteArrayInputStream byteArrayInputStream) {
        if (this.O == null) {
            throw new h2((short) 40);
        }
        n a2 = n.a(this.J, byteArrayInputStream);
        w2.a(byteArrayInputStream);
        this.Q = l3.a(a2, this.N);
    }

    protected void m(ByteArrayInputStream byteArrayInputStream) {
        q0 a2 = q0.a(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        this.I.a(a2);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b3  */
    @Override // sdk.pendo.io.y4.w2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void a(short r12, sdk.pendo.io.y4.f0 r13) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.p1.a(short, sdk.pendo.io.y4.f0):void");
    }

    protected void b(b1 b1Var, boolean z) {
        l3.b(this.J, l3.b(this.g), this.d);
        if (!z) {
            this.d.b(true);
            F();
        }
        this.d.b();
        this.d.a(false);
    }

    protected void a(b1 b1Var) {
        v0 v0Var = v0.f;
        this.d.a(v0Var);
        a1 d = this.J.d();
        if (d.O()) {
            throw new h2((short) 80);
        }
        v0 e = b1Var.e();
        byte[] d2 = b1Var.d();
        int a2 = b1Var.a();
        if (!v0Var.b(e) || !sdk.pendo.io.d5.a.a(this.M.e(), d2) || !l3.a(this.M.b(), a2)) {
            throw new h2((short) 47);
        }
        Hashtable b = b1Var.b();
        if (b == null) {
            throw new h2((short) 47);
        }
        l3.a(b, 6, (short) 47);
        Enumeration keys = b.keys();
        while (keys.hasMoreElements()) {
            Integer num = (Integer) keys.nextElement();
            if (44 != num.intValue() && l3.a(this.w, num) == null) {
                throw new h2((short) 110);
            }
        }
        v0 A = g2.A(b);
        if (A == null) {
            throw new h2((short) 109);
        }
        if (!v0.g.d(A) || !v0.a(this.J.c(), A) || !l3.a(a2, A)) {
            throw new h2((short) 47);
        }
        s0.a aVar = this.L;
        if (aVar != null && !sdk.pendo.io.d5.a.b(aVar.b, (short) 1)) {
            this.L = null;
            this.I.a((q2) null);
        }
        int l = g2.l(b);
        if (!l3.a(A, d.j(), this.K, l)) {
            throw new h2((short) 47);
        }
        byte[] j = g2.j(b);
        d.T = A;
        l3.b(this.J, this.I);
        this.z = false;
        byte[] bArr = l3.e;
        d.x = bArr;
        this.I.b(bArr);
        l3.b(d, a2);
        this.I.a(a2);
        this.K = null;
        this.u = j;
        this.v = l;
    }

    protected void b(b1 b1Var) {
        j3 j3Var;
        Hashtable b = b1Var.b();
        v0 e = b1Var.e();
        v0 A = g2.A(b);
        if (A != null) {
            if (!v0.f.b(e) || !v0.g.d(A)) {
                throw new h2((short) 47);
            }
            e = A;
        }
        a1 d = this.J.d();
        if (d.O()) {
            if (!e.b(d.s())) {
                throw new h2((short) 47);
            }
        } else {
            if (!v0.a(this.J.c(), e)) {
                throw new h2((short) 70);
            }
            v0 v0Var = v0.f;
            if (!e.f(v0Var)) {
                v0Var = e;
            }
            this.d.a(v0Var);
            d.T = e;
        }
        l3.b(this.J, this.I);
        if (v0.g.d(e)) {
            a(b1Var, false);
            return;
        }
        int[] b2 = this.M.b();
        this.M = null;
        this.u = null;
        this.v = -1;
        d.v = b1Var.c();
        if (!this.J.j().b(e)) {
            l3.a(e, d.A());
        }
        byte[] d2 = b1Var.d();
        d.x = d2;
        this.I.b(d2);
        this.z = d2.length > 0 && (j3Var = this.r) != null && sdk.pendo.io.d5.a.a(d2, j3Var.a());
        int a2 = b1Var.a();
        if (!l3.a(b2, a2) || !l3.a(a2, d.s())) {
            throw new h2((short) 47);
        }
        l3.b(d, a2);
        this.I.a(a2);
        this.x = b;
        if (b != null) {
            Enumeration keys = b.keys();
            while (keys.hasMoreElements()) {
                Integer num = (Integer) keys.nextElement();
                if (!num.equals(w2.G) && l3.a(this.w, num) == null) {
                    throw new h2((short) 110);
                }
            }
        }
        byte[] a3 = l3.a(this.x, w2.G);
        if (d.O()) {
            if (!d.P()) {
                throw new h2((short) 80);
            }
            if (a3 == null) {
                throw new h2((short) 40);
            }
            a1 e2 = this.J.e();
            if (!sdk.pendo.io.d5.a.d(a3, w2.a(l3.b(e2.p(), e2.y())))) {
                throw new h2((short) 40);
            }
        } else if (a3 == null) {
            d.c = false;
        } else {
            d.c = true;
            if (!sdk.pendo.io.d5.a.d(a3, w2.a(l3.e))) {
                throw new h2((short) 40);
            }
        }
        this.I.b(d.P());
        boolean D = g2.D(this.x);
        if (D) {
            if (e.g() || (!this.z && !this.I.d())) {
                throw new h2((short) 40);
            }
        } else if (this.I.i() || (this.z && !this.I.x())) {
            throw new h2((short) 40);
        }
        d.D = D;
        d.G = g2.h(this.x);
        d.H = true;
        Hashtable hashtable = this.w;
        Hashtable hashtable2 = this.x;
        if (this.z) {
            if (d.e() != this.s.c() || this.s.d() != 0 || !e.b(this.s.g())) {
                throw new h2((short) 47);
            }
            hashtable2 = this.s.l();
            hashtable = null;
        }
        if (hashtable2 != null && !hashtable2.isEmpty()) {
            boolean C = g2.C(hashtable2);
            if (C && !l3.n(d.e())) {
                throw new h2((short) 47);
            }
            d.C = C;
            d.f = a(hashtable, hashtable2, (short) 47);
            d.F = g2.F(hashtable2);
            if (!this.z) {
                if (l3.a(hashtable2, g2.y, (short) 47)) {
                    d.U = 2;
                } else if (l3.a(hashtable2, g2.x, (short) 47)) {
                    d.U = 1;
                }
                this.C = l3.a(hashtable2, w2.H, (short) 47);
            }
        }
        if (hashtable != null) {
            this.I.c(hashtable2);
        }
        a(d.r());
        if (this.z) {
            d.r = this.t;
            this.d.a(l3.a((r1) this.J));
        } else {
            r();
            this.r = l3.a(d.F(), (g1) null);
        }
    }

    protected void a(b1 b1Var, boolean z) {
        sdk.pendo.io.z4.b0 b0Var;
        q2 q2Var;
        sdk.pendo.io.z4.b0 b;
        a1 d = this.J.d();
        v0 e = b1Var.e();
        byte[] d2 = b1Var.d();
        int a2 = b1Var.a();
        if (!v0.f.b(e) || !sdk.pendo.io.d5.a.a(this.M.e(), d2)) {
            throw new h2((short) 47);
        }
        Hashtable b2 = b1Var.b();
        if (b2 == null) {
            throw new h2((short) 47);
        }
        l3.a(b2, 2, (short) 47);
        if (z) {
            v0 A = g2.A(b2);
            if (A == null) {
                throw new h2((short) 109);
            }
            if (!d.s().b(A) || d.e() != a2) {
                throw new h2((short) 47);
            }
        } else {
            if (!l3.a(this.M.b(), a2) || !l3.a(a2, d.s())) {
                throw new h2((short) 47);
            }
            this.z = false;
            byte[] bArr = l3.e;
            d.x = bArr;
            this.I.b(bArr);
            l3.b(d, a2);
            this.I.a(a2);
        }
        this.M = null;
        d.v = b1Var.c();
        d.c = false;
        d.D = true;
        d.U = this.w.containsKey(g2.x) ? 1 : 0;
        int r = g2.r(b2);
        if (r >= 0) {
            s0.a aVar = this.L;
            if (aVar != null) {
                q2[] q2VarArr = aVar.f1800a;
                if (r < q2VarArr.length) {
                    q2Var = q2VarArr[r];
                    if (q2Var.a() != d.t()) {
                        throw new h2((short) 47);
                    }
                    b0Var = this.L.c[r];
                    this.A = true;
                }
            }
            throw new h2((short) 47);
        }
        b0Var = null;
        q2Var = null;
        this.I.a(q2Var);
        k0 m = g2.m(b2);
        if (m == null) {
            if (z || b0Var == null || !sdk.pendo.io.d5.a.b(this.L.b, (short) 0)) {
                throw new h2((short) 47);
            }
            b = null;
        } else {
            if (b0Var != null && !sdk.pendo.io.d5.a.b(this.L.b, (short) 1)) {
                throw new h2((short) 47);
            }
            sdk.pendo.io.z4.e eVar = (sdk.pendo.io.z4.e) this.K.get(sdk.pendo.io.d5.d.b(m.b()));
            if (eVar == null) {
                throw new h2((short) 47);
            }
            eVar.a(m.a());
            b = eVar.b();
        }
        this.K = null;
        this.L = null;
        l3.a(this.J, b0Var, b);
        r();
        this.r = l3.a(d.F(), (g1) null);
    }

    protected void b(d0 d0Var) {
        g0 g0Var = new g0((short) 15);
        d0Var.a(g0Var);
        g0Var.a(this);
    }

    protected void a(ByteArrayInputStream byteArrayInputStream, boolean z) {
        if (z) {
            throw new h2((short) 80);
        }
        if (this.A) {
            throw new h2((short) 10);
        }
        n a2 = n.a(this.J, byteArrayInputStream);
        w2.a(byteArrayInputStream);
        if (!a2.a(l3.e)) {
            throw new h2((short) 47);
        }
        this.Q = a2;
        l3.a(this.J.d(), a2);
    }
}
