package sdk.pendo.io.b2;

/* loaded from: classes6.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static g f884a = g.h;
    public static final sdk.pendo.io.e2.d b = new sdk.pendo.io.e2.d();
    public static final sdk.pendo.io.f2.j c = new sdk.pendo.io.f2.j();

    public static void a(String str, Appendable appendable, g gVar) {
        if (str == null) {
            return;
        }
        gVar.a(str, appendable);
    }

    public static <T> T a(String str, Class<T> cls) {
        try {
            return (T) new sdk.pendo.io.d2.a(sdk.pendo.io.d2.a.c).a(str, c.a((Class) cls));
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Object obj, Appendable appendable, g gVar) {
        if (obj == null) {
            appendable.append("null");
            return;
        }
        Class<?> cls = obj.getClass();
        sdk.pendo.io.e2.d dVar = b;
        sdk.pendo.io.e2.e<Object> a2 = dVar.a(cls);
        if (a2 == null) {
            if (cls.isArray()) {
                a2 = sdk.pendo.io.e2.d.l;
            } else {
                a2 = dVar.b(obj.getClass());
                if (a2 == null) {
                    a2 = sdk.pendo.io.e2.d.j;
                }
            }
            dVar.a(a2, cls);
        }
        a2.a(obj, appendable, gVar);
    }
}
