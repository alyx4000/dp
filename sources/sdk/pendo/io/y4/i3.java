package sdk.pendo.io.y4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;
import java.util.Vector;
import sdk.pendo.io.y4.l;
import sdk.pendo.io.y4.s0;

/* loaded from: classes4.dex */
public class i3 extends w2 {
    protected d3 I;
    h3 J;
    protected int[] K;
    protected l2 L;
    protected n M;

    public i3() {
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
    }

    protected boolean H() {
        l x;
        if (this.M == null || (x = this.J.d().x()) == null || x.d()) {
            return false;
        }
        l2 l2Var = this.L;
        return l2Var == null || l2Var.g();
    }

    protected void I() {
        g0.a((w2) this, (short) 14, l3.e);
    }

    protected void J() {
        if (this.M != null) {
            throw new h2((short) 10);
        }
    }

    protected void K() {
        if (H()) {
            throw new h2((short) 10);
        }
    }

    public void a(d3 d3Var) {
        if (d3Var == null) {
            throw new IllegalArgumentException("'tlsServer' cannot be null");
        }
        if (this.I != null) {
            throw new IllegalStateException("'accept' can only be called once");
        }
        this.I = d3Var;
        h3 h3Var = new h3(d3Var.b());
        this.J = h3Var;
        d3Var.a(h3Var);
        d3Var.a(this);
        a(false);
        if (this.D) {
            b();
        }
    }

    protected void b(short s, f0 f0Var) {
        if (!x()) {
            throw new h2((short) 80);
        }
        if (this.z) {
            throw new h2((short) 80);
        }
        if (s == 1) {
            short s2 = this.y;
            if (s2 == 0) {
                throw new h2((short) 80);
            }
            if (s2 != 2) {
                throw new h2((short) 10);
            }
            s l = l(f0Var);
            this.y = (short) 3;
            b1 a2 = a(l, f0Var, true);
            a(a2);
            this.y = (short) 4;
            a(a2, true);
            return;
        }
        if (s == 11) {
            if (this.y != 20) {
                throw new h2((short) 10);
            }
            g(f0Var);
            this.y = (short) 15;
            return;
        }
        if (s == 15) {
            if (this.y != 15) {
                throw new h2((short) 10);
            }
            h(f0Var);
            f0Var.a(this.g);
            this.y = (short) 17;
            return;
        }
        if (s != 20) {
            if (s != 24) {
                throw new h2((short) 10);
            }
            f(f0Var);
            return;
        }
        short s3 = this.y;
        if (s3 != 15) {
            if (s3 != 17) {
                if (s3 != 20) {
                    throw new h2((short) 10);
                }
                J();
            }
            i(f0Var);
            this.y = (short) 18;
            this.d.b(false);
            this.d.a(false);
            g();
        }
        K();
        i(f0Var);
        this.y = (short) 18;
        this.d.b(false);
        this.d.a(false);
        g();
    }

    @Override // sdk.pendo.io.y4.w2
    protected void c() {
        super.c();
        this.K = null;
        this.L = null;
        this.M = null;
    }

    protected void f(byte[] bArr) {
        g0.a((w2) this, (short) 12, bArr);
    }

    protected void g(ByteArrayInputStream byteArrayInputStream) {
        if (this.M == null) {
            throw new h2((short) 10);
        }
        l a2 = l.a(new l.a().a(this.I.p()), this.J, byteArrayInputStream, (OutputStream) null);
        w2.a(byteArrayInputStream);
        b(a2);
    }

    protected void h(ByteArrayInputStream byteArrayInputStream) {
        l x = this.J.d().x();
        if (x == null || x.d()) {
            throw new h2((short) 80);
        }
        d0 a2 = d0.a(this.J, byteArrayInputStream);
        w2.a(byteArrayInputStream);
        l3.a(this.J, this.M, a2, this.g);
    }

    protected void i(ByteArrayInputStream byteArrayInputStream) {
        b(byteArrayInputStream);
    }

    protected void j(ByteArrayInputStream byteArrayInputStream) {
        if (this.M == null) {
            throw new h2((short) 10);
        }
        l a2 = l.a(new l.a().a(this.I.p()), this.J, byteArrayInputStream, (OutputStream) null);
        w2.a(byteArrayInputStream);
        b(a2);
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

    public i3(InputStream inputStream, OutputStream outputStream) {
        super(inputStream, outputStream);
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
    }

    protected b1 a(s sVar) {
        if (this.v < 0) {
            throw new h2((short) 80);
        }
        a1 d = this.J.d();
        v0 s = d.s();
        Hashtable hashtable = new Hashtable();
        g2.a(hashtable, s);
        int i = this.v;
        if (i >= 0) {
            g2.a(hashtable, i);
        }
        byte[] bArr = this.u;
        if (bArr != null) {
            g2.a(hashtable, bArr);
        }
        l3.a(hashtable, 6, (short) 80);
        return new b1(sVar.e(), d.e(), hashtable);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0018, code lost:
    
        if (r0 != 14) goto L16;
     */
    @Override // sdk.pendo.io.y4.w2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void b(short r3) {
        /*
            r2 = this;
            r0 = 41
            if (r0 != r3) goto L2b
            sdk.pendo.io.y4.n r0 = r2.M
            if (r0 == 0) goto L2b
            sdk.pendo.io.y4.h3 r0 = r2.J
            boolean r0 = sdk.pendo.io.y4.l3.b(r0)
            if (r0 == 0) goto L2b
            short r0 = r2.y
            r1 = 12
            if (r0 == r1) goto L1b
            r1 = 14
            if (r0 == r1) goto L21
            goto L2b
        L1b:
            sdk.pendo.io.y4.d3 r3 = r2.I
            r0 = 0
            r3.a(r0)
        L21:
            sdk.pendo.io.y4.l r3 = sdk.pendo.io.y4.l.e
            r2.b(r3)
            r3 = 15
            r2.y = r3
            return
        L2b:
            super.b(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.i3.b(short):void");
    }

    protected void k(ByteArrayInputStream byteArrayInputStream) {
        d0 a2 = d0.a(this.J, byteArrayInputStream);
        w2.a(byteArrayInputStream);
        l3.b(this.J, this.M, a2, this.g);
        this.g.a();
    }

    protected s l(ByteArrayInputStream byteArrayInputStream) {
        return s.b(byteArrayInputStream, null);
    }

    protected void m(ByteArrayInputStream byteArrayInputStream) {
        this.L.b(byteArrayInputStream);
        w2.a(byteArrayInputStream);
        boolean b = l3.b(this.J);
        if (b) {
            w2.a(this.J, this.L);
        }
        this.J.d().w = l3.b(this.g);
        if (!b) {
            w2.a(this.J, this.L);
        }
        this.d.a(l3.a((r1) this.J));
        if (H()) {
            return;
        }
        this.g.a();
    }

    protected b1 a(s sVar, f0 f0Var, boolean z) {
        k0 k0Var;
        sdk.pendo.io.z4.e a2;
        a1 d = this.J.d();
        if (d.O()) {
            throw new h2((short) 80);
        }
        byte[] e = sVar.e();
        Hashtable c = sVar.c();
        if (c == null) {
            throw new h2((short) 109);
        }
        v0 s = d.s();
        sdk.pendo.io.z4.h b = this.J.b();
        s0.b a3 = l3.a(this.J, this.I, c, f0Var, this.g, z);
        Vector k = g2.k(c);
        sdk.pendo.io.z4.b0 b0Var = null;
        if (!z) {
            this.w = c;
            d.c = false;
            g2.p(c);
            d.J = g2.s(c);
            l3.a(d, c);
            if (a3 == null && d.h() == null) {
                throw new h2((short) 109);
            }
            this.I.a(c);
            j3 a4 = l3.a(l3.e, (g1) null);
            this.r = a4;
            this.s = null;
            this.t = null;
            d.x = a4.a();
            this.I.a(this.r);
            l3.a((g3) this.J);
            d.v = w2.a(false, (r1) this.J);
            if (!s.b(v0.c(this.I.f()))) {
                l3.b(s, d.A());
            }
            int q = this.I.q();
            if (!l3.a(this.K, q) || !l3.a(q, s)) {
                throw new h2((short) 80);
            }
            l3.b(d, q);
            int[] j = d.j();
            int[] D = d.D();
            k0 a5 = l3.a(b, s, k, j, D);
            if (a5 == null) {
                int a6 = l3.a(b, s, j, D);
                this.v = a6;
                if (a6 < 0) {
                    throw new h2((short) 40);
                }
                this.u = this.J.k().a(16);
                return a(sVar);
            }
            a5.b();
            int i = D[0];
            k0Var = a5;
        } else {
            if (this.v < 0) {
                throw new h2((short) 80);
            }
            if (a3 == null) {
                if (d.h() == null) {
                    throw new h2((short) 109);
                }
            } else if (a3.b.a() != d.t()) {
                throw new h2((short) 47);
            }
            if (!sdk.pendo.io.d5.a.a(this.u, g2.j(c))) {
                throw new h2((short) 47);
            }
            this.u = null;
            k0Var = l3.b(k, this.v);
            if (k0Var == null) {
                throw new h2((short) 47);
            }
        }
        Hashtable hashtable = new Hashtable();
        Hashtable f = g2.f(this.I.k());
        this.I.b(f);
        v0 v0Var = v0.f;
        g2.a(hashtable, s);
        d.D = true;
        d.G = g2.h(f);
        d.H = true;
        if (!f.isEmpty()) {
            d.f = a(c, f, (short) 80);
        }
        d.C = false;
        d.F = false;
        d.U = c.containsKey(g2.x) ? 1 : 0;
        this.C = false;
        if (a3 != null) {
            b0Var = a3.d;
            this.A = true;
            g2.b(hashtable, a3.f1801a);
        }
        int b2 = k0Var.b();
        if (p0.k(b2)) {
            a2 = b.a(new sdk.pendo.io.z4.o(b2)).a();
        } else {
            if (!p0.l(b2)) {
                throw new h2((short) 80);
            }
            a2 = b.a(new sdk.pendo.io.z4.l(b2, true)).a();
        }
        g2.a(hashtable, new k0(b2, a2.a()));
        a2.a(k0Var.a());
        l3.a(this.J, b0Var, a2.b());
        this.x = f;
        a(d.r());
        l3.a(hashtable, 2, (short) 80);
        return new b1(v0Var, d.A(), e, d.e(), hashtable);
    }

    protected void b(l lVar) {
        if (this.M == null) {
            throw new h2((short) 80);
        }
        l3.a(this.J, lVar, this.L, this.I);
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x02f1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected sdk.pendo.io.y4.b1 a(sdk.pendo.io.y4.s r13, sdk.pendo.io.y4.f0 r14) {
        /*
            Method dump skipped, instructions count: 881
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y4.i3.a(sdk.pendo.io.y4.s, sdk.pendo.io.y4.f0):sdk.pendo.io.y4.b1");
    }

    protected void b(Hashtable hashtable) {
        byte[] a2 = w2.a(hashtable);
        g0 g0Var = new g0((short) 8);
        l3.a(a2, (OutputStream) g0Var);
        g0Var.a(this);
    }

    @Override // sdk.pendo.io.y4.w2
    protected void a(short s, f0 f0Var) {
        o c;
        a1 h = this.J.h();
        if (this.y > 1 && l3.e(h.s())) {
            b(s, f0Var);
            return;
        }
        if (!v()) {
            throw new h2((short) 80);
        }
        if (this.z) {
            if (s != 20 || this.y != 20) {
                throw new h2((short) 10);
            }
            c(f0Var);
            this.y = (short) 18;
            g();
            return;
        }
        l lVar = null;
        if (s != 1) {
            if (s == 11) {
                short s2 = this.y;
                if (s2 == 12) {
                    this.I.a((Vector) null);
                } else if (s2 != 14) {
                    throw new h2((short) 10);
                }
                j(f0Var);
                this.y = (short) 15;
                return;
            }
            if (s == 20) {
                short s3 = this.y;
                if (s3 != 16) {
                    if (s3 != 17) {
                        throw new h2((short) 10);
                    }
                } else if (H()) {
                    throw new h2((short) 10);
                }
                c(f0Var);
                f0Var.a(this.g);
                this.y = (short) 18;
                if (this.C) {
                    a(this.I.K());
                    this.y = (short) 19;
                }
                E();
                G();
                this.y = (short) 20;
                g();
                return;
            }
            if (s == 23) {
                if (this.y != 12) {
                    throw new h2((short) 10);
                }
                this.I.a(w2.e(f0Var));
                this.y = (short) 14;
                return;
            }
            if (s == 15) {
                if (this.y != 16) {
                    throw new h2((short) 10);
                }
                if (!H()) {
                    throw new h2((short) 10);
                }
                k(f0Var);
                f0Var.a(this.g);
                this.y = (short) 17;
                return;
            }
            if (s != 16) {
                throw new h2((short) 10);
            }
            short s4 = this.y;
            if (s4 == 12) {
                this.I.a((Vector) null);
            } else if (s4 != 14) {
                if (s4 != 15) {
                    throw new h2((short) 10);
                }
                m(f0Var);
                this.y = (short) 16;
                return;
            }
            if (this.M == null) {
                this.L.c();
            } else {
                if (l3.c(this.J)) {
                    throw new h2((short) 10);
                }
                if (l3.b(this.J)) {
                    throw new h2((short) 10);
                }
                b(l.e);
            }
            m(f0Var);
            this.y = (short) 16;
            return;
        }
        if (s()) {
            if (!q()) {
                return;
            } else {
                this.y = (short) 0;
            }
        }
        short s5 = this.y;
        if (s5 != 0) {
            if (s5 == 21) {
                throw new h2((short) 80);
            }
            throw new h2((short) 10);
        }
        s l = l(f0Var);
        this.y = (short) 1;
        b1 a2 = a(l, f0Var);
        this.g.b();
        if (l3.e(h.s())) {
            this.g.g();
            if (a2.f()) {
                l3.a(this.g);
                a(a2);
                this.y = (short) 2;
                F();
                return;
            }
            a(a2);
            this.y = (short) 4;
            F();
            a(a2, false);
            return;
        }
        f0Var.a(this.g);
        a(a2);
        this.y = (short) 4;
        if (this.z) {
            h.r = this.t;
            this.d.a(l3.a((r1) this.J));
            E();
            G();
            this.y = (short) 20;
            return;
        }
        Vector O = this.I.O();
        if (O != null) {
            a(O);
            this.y = (short) 6;
        }
        this.L = l3.a(this.J, this.I);
        v1 b = l3.b(this.I);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        l2 l2Var = this.L;
        if (b == null) {
            l2Var.e();
        } else {
            l2Var.b(b);
            lVar = b.a();
            a(lVar, byteArrayOutputStream);
            this.y = (short) 7;
        }
        h.A = byteArrayOutputStream.toByteArray();
        if (lVar == null || lVar.d()) {
            h.U = 0;
        }
        if (h.G() > 0 && (c = this.I.c()) != null) {
            a(c);
            this.y = (short) 8;
        }
        byte[] a3 = this.L.a();
        if (a3 != null) {
            f(a3);
            this.y = (short) 10;
        }
        if (b != null) {
            n I = this.I.I();
            this.M = I;
            if (I != null) {
                if (l3.c(this.J) != (this.M.d() != null)) {
                    throw new h2((short) 80);
                }
                n a4 = l3.a(this.M, this.L);
                this.M = a4;
                l3.a(h, a4);
                l3.a(this.g, h.B());
                a(this.M);
                this.y = (short) 11;
            } else if (!this.L.g()) {
                throw new h2((short) 80);
            }
        }
        I();
        this.y = (short) 12;
        l3.b((r1) this.J, this.g, false);
    }

    protected void a(b1 b1Var, boolean z) {
        a1 d = this.J.d();
        l3.b(this.J, l3.b(this.g), this.d);
        this.d.b();
        this.d.a(true);
        b(this.x);
        this.y = (short) 5;
        if (!this.A) {
            n I = this.I.I();
            this.M = I;
            if (I != null) {
                if (!I.a(l3.e)) {
                    throw new h2((short) 80);
                }
                l3.a(d, this.M);
                a(this.M);
                this.y = (short) 11;
            }
            u1 a2 = l3.a(this.I);
            if (a2 == null) {
                throw new h2((short) 80);
            }
            a(a2.a());
            d.A = null;
            this.y = (short) 7;
            a(l3.a(this.J, a2, this.g));
            this.y = (short) 17;
        }
        D();
        this.y = (short) 20;
        l3.a(this.J, l3.b(this.g), this.d);
        this.d.b();
    }

    protected void a(n nVar) {
        g0 g0Var = new g0((short) 13);
        nVar.a(this.J, g0Var);
        g0Var.a(this);
    }

    protected void a(o oVar) {
        g0 g0Var = new g0((short) 22);
        oVar.a((OutputStream) g0Var);
        g0Var.a(this);
    }

    protected void a(q0 q0Var) {
        if (q0Var == null) {
            throw new h2((short) 80);
        }
        g0 g0Var = new g0((short) 4);
        q0Var.a(g0Var);
        g0Var.a(this);
    }

    protected void a(b1 b1Var) {
        g0 g0Var = new g0((short) 2);
        b1Var.a(this.J, g0Var);
        g0Var.a(this);
    }
}
