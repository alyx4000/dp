package sdk.pendo.io.n3;

import java.util.Hashtable;
import sdk.pendo.io.d5.i;
import sdk.pendo.io.f4.e;
import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static e f1418a = new C0205a();
    static final Hashtable b = new Hashtable();
    static final Hashtable c = new Hashtable();
    static final Hashtable d = new Hashtable();

    /* renamed from: sdk.pendo.io.n3.a$a, reason: collision with other inner class name */
    static class C0205a extends e {
        C0205a() {
        }
    }

    static {
        a("FRP256v1", b.f1419a, f1418a);
    }

    static void a(String str, v vVar, e eVar) {
        b.put(i.b(str), vVar);
        d.put(vVar, str);
        c.put(vVar, eVar);
    }

    public static v a(String str) {
        return (v) b.get(i.b(str));
    }
}
