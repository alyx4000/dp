package sdk.pendo.io.r3;

import java.util.Hashtable;
import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static sdk.pendo.io.f4.e f1523a = new a();
    static sdk.pendo.io.f4.e b = new C0232b();
    static sdk.pendo.io.f4.e c = new c();
    static sdk.pendo.io.f4.e d = new d();
    static sdk.pendo.io.f4.e e = new e();
    static sdk.pendo.io.f4.e f = new f();
    static sdk.pendo.io.f4.e g = new g();
    static sdk.pendo.io.f4.e h = new h();
    static final Hashtable i = new Hashtable();
    static final Hashtable j = new Hashtable();
    static final Hashtable k = new Hashtable();

    static class a extends sdk.pendo.io.f4.e {
        a() {
        }
    }

    /* renamed from: sdk.pendo.io.r3.b$b, reason: collision with other inner class name */
    static class C0232b extends sdk.pendo.io.f4.e {
        C0232b() {
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

    static {
        a("GostR3410-2001-CryptoPro-A", sdk.pendo.io.r3.a.x, f1523a);
        a("GostR3410-2001-CryptoPro-B", sdk.pendo.io.r3.a.y, b);
        a("GostR3410-2001-CryptoPro-C", sdk.pendo.io.r3.a.z, c);
        a("GostR3410-2001-CryptoPro-XchA", sdk.pendo.io.r3.a.A, f1523a);
        a("GostR3410-2001-CryptoPro-XchB", sdk.pendo.io.r3.a.B, d);
        a("Tc26-Gost-3410-12-256-paramSetA", sdk.pendo.io.z3.a.o, e);
        a("Tc26-Gost-3410-12-512-paramSetA", sdk.pendo.io.z3.a.q, f);
        a("Tc26-Gost-3410-12-512-paramSetB", sdk.pendo.io.z3.a.r, g);
        a("Tc26-Gost-3410-12-512-paramSetC", sdk.pendo.io.z3.a.s, h);
    }

    static void a(String str, v vVar, sdk.pendo.io.f4.e eVar) {
        i.put(str, vVar);
        k.put(vVar, str);
        j.put(vVar, eVar);
    }

    public static v a(String str) {
        return (v) i.get(str);
    }
}
