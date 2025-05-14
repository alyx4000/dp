package sdk.pendo.io.v1;

import java.util.List;

/* loaded from: classes4.dex */
public abstract class j {
    static final /* synthetic */ boolean e = true;

    /* renamed from: a, reason: collision with root package name */
    private j f1661a;
    private j b;
    private Boolean c = null;
    private Boolean d = null;

    protected abstract String a();

    j a(j jVar) {
        this.b = jVar;
        jVar.f1661a = this;
        return jVar;
    }

    public abstract void a(String str, sdk.pendo.io.o1.h hVar, Object obj, g gVar);

    boolean b() {
        return this.b == null;
    }

    public boolean c() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean e2 = e();
        if (e2 && !b()) {
            e2 = this.b.c();
        }
        this.c = Boolean.valueOf(e2);
        return e2;
    }

    boolean d() {
        return this.f1661a == null;
    }

    public abstract boolean e();

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    boolean f() {
        if (this.d == null) {
            this.d = Boolean.valueOf(d() || (this.f1661a.e() && this.f1661a.f()));
        }
        return this.d.booleanValue();
    }

    j g() {
        if (b()) {
            throw new IllegalStateException("Current path token is a leaf");
        }
        return this.b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        return b() ? a() : a() + g().toString();
    }

    private static Object b(String str, Object obj, g gVar) {
        return gVar.e().a(obj, str);
    }

    protected void a(int i, String str, Object obj, g gVar) {
        String a2 = sdk.pendo.io.o1.i.a(str, "[", String.valueOf(i), "]");
        sdk.pendo.io.o1.h a3 = gVar.d() ? sdk.pendo.io.o1.h.a(obj, i) : sdk.pendo.io.o1.h.s;
        if (i < 0) {
            i += gVar.e().d(obj);
        }
        try {
            Object a4 = gVar.e().a(obj, i);
            if (b()) {
                gVar.a(a2, a3, a4);
            } else {
                g().a(a2, a3, a4, gVar);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    void a(String str, Object obj, g gVar, List<String> list) {
        Object b;
        Object obj2 = null;
        if (list.size() != 1) {
            String str2 = str + "[" + sdk.pendo.io.o1.i.a(", ", "'", list) + "]";
            if (!e && !b()) {
                throw new AssertionError("non-leaf multi props handled elsewhere");
            }
            Object b2 = gVar.e().b();
            for (String str3 : list) {
                if (a(str3, obj, gVar)) {
                    b = b(str3, obj, gVar);
                    if (b == sdk.pendo.io.x1.b.f1745a) {
                        if (gVar.f().contains(sdk.pendo.io.n1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                            b = null;
                        }
                    }
                } else if (gVar.f().contains(sdk.pendo.io.n1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                    b = null;
                } else if (gVar.f().contains(sdk.pendo.io.n1.i.REQUIRE_PROPERTIES)) {
                    throw new sdk.pendo.io.n1.k("Missing property in path " + str2);
                }
                gVar.e().a(b2, str3, b);
            }
            gVar.a(str2, gVar.d() ? sdk.pendo.io.o1.h.a(obj, list) : sdk.pendo.io.o1.h.s, b2);
            return;
        }
        String str4 = list.get(0);
        String a2 = sdk.pendo.io.o1.i.a(str, "['", str4, "']");
        Object b3 = b(str4, obj, gVar);
        if (b3 != sdk.pendo.io.x1.b.f1745a) {
            obj2 = b3;
        } else {
            if (!e && !(this instanceof o)) {
                throw new AssertionError("only PropertyPathToken is supported");
            }
            if (!b()) {
                if (((f() && e()) || gVar.f().contains(sdk.pendo.io.n1.i.REQUIRE_PROPERTIES)) && !gVar.f().contains(sdk.pendo.io.n1.i.SUPPRESS_EXCEPTIONS)) {
                    throw new sdk.pendo.io.n1.k("Missing property in path " + a2);
                }
                return;
            }
            if (!gVar.f().contains(sdk.pendo.io.n1.i.DEFAULT_PATH_LEAF_TO_NULL)) {
                if (!gVar.f().contains(sdk.pendo.io.n1.i.SUPPRESS_EXCEPTIONS) && gVar.f().contains(sdk.pendo.io.n1.i.REQUIRE_PROPERTIES)) {
                    throw new sdk.pendo.io.n1.k("No results for path: " + a2);
                }
                return;
            }
        }
        sdk.pendo.io.o1.h a3 = gVar.d() ? sdk.pendo.io.o1.h.a(obj, str4) : sdk.pendo.io.o1.h.s;
        if (b()) {
            gVar.a(a2, a3, obj2);
        } else {
            g().a(a2, a3, obj2, gVar);
        }
    }

    public void b(j jVar) {
        this.b = jVar;
    }

    private static boolean a(String str, Object obj, g gVar) {
        return gVar.e().c(obj).contains(str);
    }
}
