package sdk.pendo.io.u3;

import java.util.Hashtable;
import sdk.pendo.io.d5.i;
import sdk.pendo.io.f4.e;
import sdk.pendo.io.m3.v;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static e f1639a = new C0243a();
    static e b = new b();
    static final Hashtable c = new Hashtable();
    static final Hashtable d = new Hashtable();
    static final Hashtable e = new Hashtable();

    /* renamed from: sdk.pendo.io.u3.a$a, reason: collision with other inner class name */
    static class C0243a extends e {
        C0243a() {
        }
    }

    static class b extends e {
        b() {
        }
    }

    static {
        a("wapip192v1", sdk.pendo.io.u3.b.J, b);
        a("sm2p256v1", sdk.pendo.io.u3.b.F, f1639a);
    }

    static void a(String str, v vVar, e eVar) {
        c.put(i.b(str), vVar);
        e.put(vVar, str);
        d.put(vVar, eVar);
    }

    public static v a(String str) {
        return (v) c.get(i.b(str));
    }
}
