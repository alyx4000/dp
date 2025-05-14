package sdk.pendo.io.v3;

import java.util.Hashtable;
import sdk.pendo.io.d5.i;
import sdk.pendo.io.m3.v;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    static final Hashtable f1676a = new Hashtable();
    static final Hashtable b = new Hashtable();

    static {
        a("B-571", sdk.pendo.io.a4.b.F);
        a("B-409", sdk.pendo.io.a4.b.D);
        a("B-283", sdk.pendo.io.a4.b.n);
        a("B-233", sdk.pendo.io.a4.b.t);
        a("B-163", sdk.pendo.io.a4.b.l);
        a("K-571", sdk.pendo.io.a4.b.E);
        a("K-409", sdk.pendo.io.a4.b.C);
        a("K-283", sdk.pendo.io.a4.b.m);
        a("K-233", sdk.pendo.io.a4.b.s);
        a("K-163", sdk.pendo.io.a4.b.b);
        a("P-521", sdk.pendo.io.a4.b.B);
        a("P-384", sdk.pendo.io.a4.b.A);
        a("P-256", sdk.pendo.io.a4.b.H);
        a("P-224", sdk.pendo.io.a4.b.z);
        a("P-192", sdk.pendo.io.a4.b.G);
    }

    static void a(String str, v vVar) {
        f1676a.put(str, vVar);
        b.put(vVar, str);
    }

    public static v a(String str) {
        return (v) f1676a.get(i.d(str));
    }
}
