package sdk.pendo.io.f4;

import java.util.Hashtable;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static sdk.pendo.io.f4.e f1078a = new k();
    static sdk.pendo.io.f4.e b = new p();
    static sdk.pendo.io.f4.e c = new q();
    static sdk.pendo.io.f4.e d = new r();
    static sdk.pendo.io.f4.e e = new s();
    static sdk.pendo.io.f4.e f = new t();
    static sdk.pendo.io.f4.e g = new u();
    static sdk.pendo.io.f4.e h = new v();
    static sdk.pendo.io.f4.e i = new w();
    static sdk.pendo.io.f4.e j = new a();
    static sdk.pendo.io.f4.e k = new C0135b();
    static sdk.pendo.io.f4.e l = new c();
    static sdk.pendo.io.f4.e m = new d();
    static sdk.pendo.io.f4.e n = new e();
    static sdk.pendo.io.f4.e o = new f();
    static sdk.pendo.io.f4.e p = new g();
    static sdk.pendo.io.f4.e q = new h();
    static sdk.pendo.io.f4.e r = new i();
    static sdk.pendo.io.f4.e s = new j();
    static sdk.pendo.io.f4.e t = new l();
    static sdk.pendo.io.f4.e u = new m();
    static sdk.pendo.io.f4.e v = new n();
    static sdk.pendo.io.f4.e w = new o();
    static final Hashtable x = new Hashtable();
    static final Hashtable y = new Hashtable();
    static final Hashtable z = new Hashtable();

    static class a extends sdk.pendo.io.f4.e {
        a() {
        }
    }

    /* renamed from: sdk.pendo.io.f4.b$b, reason: collision with other inner class name */
    static class C0135b extends sdk.pendo.io.f4.e {
        C0135b() {
        }
    }

    static class c extends sdk.pendo.io.f4.e {
        c() {
        }
    }

    static class d extends sdk.pendo.io.f4.e {
        d() {
        }
    }

    static class e extends sdk.pendo.io.f4.e {
        e() {
        }
    }

    static class f extends sdk.pendo.io.f4.e {
        f() {
        }
    }

    static class g extends sdk.pendo.io.f4.e {
        g() {
        }
    }

    static class h extends sdk.pendo.io.f4.e {
        h() {
        }
    }

    static class i extends sdk.pendo.io.f4.e {
        i() {
        }
    }

    static class j extends sdk.pendo.io.f4.e {
        j() {
        }
    }

    static class k extends sdk.pendo.io.f4.e {
        k() {
        }
    }

    static class l extends sdk.pendo.io.f4.e {
        l() {
        }
    }

    static class m extends sdk.pendo.io.f4.e {
        m() {
        }
    }

    static class n extends sdk.pendo.io.f4.e {
        n() {
        }
    }

    static class o extends sdk.pendo.io.f4.e {
        o() {
        }
    }

    static class p extends sdk.pendo.io.f4.e {
        p() {
        }
    }

    static class q extends sdk.pendo.io.f4.e {
        q() {
        }
    }

    static class r extends sdk.pendo.io.f4.e {
        r() {
        }
    }

    static class s extends sdk.pendo.io.f4.e {
        s() {
        }
    }

    static class t extends sdk.pendo.io.f4.e {
        t() {
        }
    }

    static class u extends sdk.pendo.io.f4.e {
        u() {
        }
    }

    static class v extends sdk.pendo.io.f4.e {
        v() {
        }
    }

    static class w extends sdk.pendo.io.f4.e {
        w() {
        }
    }

    static {
        a("prime192v1", sdk.pendo.io.f4.h.Q, f1078a);
        a("prime192v2", sdk.pendo.io.f4.h.R, b);
        a("prime192v3", sdk.pendo.io.f4.h.S, c);
        a("prime239v1", sdk.pendo.io.f4.h.T, d);
        a("prime239v2", sdk.pendo.io.f4.h.U, e);
        a("prime239v3", sdk.pendo.io.f4.h.V, f);
        a("prime256v1", sdk.pendo.io.f4.h.W, g);
        a("c2pnb163v1", sdk.pendo.io.f4.h.u, h);
        a("c2pnb163v2", sdk.pendo.io.f4.h.v, i);
        a("c2pnb163v3", sdk.pendo.io.f4.h.w, j);
        a("c2pnb176w1", sdk.pendo.io.f4.h.x, k);
        a("c2tnb191v1", sdk.pendo.io.f4.h.y, l);
        a("c2tnb191v2", sdk.pendo.io.f4.h.z, m);
        a("c2tnb191v3", sdk.pendo.io.f4.h.B, n);
        a("c2pnb208w1", sdk.pendo.io.f4.h.E, o);
        a("c2tnb239v1", sdk.pendo.io.f4.h.F, p);
        a("c2tnb239v2", sdk.pendo.io.f4.h.G, q);
        a("c2tnb239v3", sdk.pendo.io.f4.h.H, r);
        a("c2pnb272w1", sdk.pendo.io.f4.h.K, s);
        a("c2pnb304w1", sdk.pendo.io.f4.h.L, t);
        a("c2tnb359v1", sdk.pendo.io.f4.h.M, u);
        a("c2pnb368w1", sdk.pendo.io.f4.h.N, v);
        a("c2tnb431r1", sdk.pendo.io.f4.h.O, w);
    }

    static void a(String str, sdk.pendo.io.m3.v vVar, sdk.pendo.io.f4.e eVar) {
        x.put(str, vVar);
        z.put(vVar, str);
        y.put(vVar, eVar);
    }

    public static sdk.pendo.io.m3.v a(String str) {
        return (sdk.pendo.io.m3.v) x.get(sdk.pendo.io.d5.i.b(str));
    }
}
