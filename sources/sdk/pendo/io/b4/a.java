package sdk.pendo.io.b4;

import java.util.Hashtable;
import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static sdk.pendo.io.f4.e f896a = new f();
    static sdk.pendo.io.f4.e b = new g();
    static sdk.pendo.io.f4.e c = new h();
    static sdk.pendo.io.f4.e d = new i();
    static sdk.pendo.io.f4.e e = new j();
    static sdk.pendo.io.f4.e f = new k();
    static sdk.pendo.io.f4.e g = new l();
    static sdk.pendo.io.f4.e h = new m();
    static sdk.pendo.io.f4.e i = new n();
    static sdk.pendo.io.f4.e j = new C0091a();
    static sdk.pendo.io.f4.e k = new b();
    static sdk.pendo.io.f4.e l = new c();
    static sdk.pendo.io.f4.e m = new d();
    static sdk.pendo.io.f4.e n = new e();
    static final Hashtable o = new Hashtable();
    static final Hashtable p = new Hashtable();
    static final Hashtable q = new Hashtable();

    /* renamed from: sdk.pendo.io.b4.a$a, reason: collision with other inner class name */
    static class C0091a extends sdk.pendo.io.f4.e {
        C0091a() {
        }
    }

    static class b extends sdk.pendo.io.f4.e {
        b() {
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

    static {
        a("brainpoolP160r1", sdk.pendo.io.b4.b.o, f896a);
        a("brainpoolP160t1", sdk.pendo.io.b4.b.p, b);
        a("brainpoolP192r1", sdk.pendo.io.b4.b.q, c);
        a("brainpoolP192t1", sdk.pendo.io.b4.b.r, d);
        a("brainpoolP224r1", sdk.pendo.io.b4.b.s, e);
        a("brainpoolP224t1", sdk.pendo.io.b4.b.t, f);
        a("brainpoolP256r1", sdk.pendo.io.b4.b.u, g);
        a("brainpoolP256t1", sdk.pendo.io.b4.b.v, h);
        a("brainpoolP320r1", sdk.pendo.io.b4.b.w, i);
        a("brainpoolP320t1", sdk.pendo.io.b4.b.x, j);
        a("brainpoolP384r1", sdk.pendo.io.b4.b.y, k);
        a("brainpoolP384t1", sdk.pendo.io.b4.b.z, l);
        a("brainpoolP512r1", sdk.pendo.io.b4.b.A, m);
        a("brainpoolP512t1", sdk.pendo.io.b4.b.B, n);
    }

    static void a(String str, v vVar, sdk.pendo.io.f4.e eVar) {
        o.put(sdk.pendo.io.d5.i.b(str), vVar);
        q.put(vVar, str);
        p.put(vVar, eVar);
    }

    public static v a(String str) {
        return (v) o.get(sdk.pendo.io.d5.i.b(str));
    }
}
