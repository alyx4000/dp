package sdk.pendo.io.n1;

/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.o1.g f1413a;

    private g(String str, l[] lVarArr) {
        sdk.pendo.io.o1.i.a(str, "path can not be null", new Object[0]);
        this.f1413a = sdk.pendo.io.v1.i.a(str, lVarArr);
    }

    public static g a(String str, l... lVarArr) {
        sdk.pendo.io.o1.i.a(str, "json can not be null or empty", new Object[0]);
        return new g(str, lVarArr);
    }

    public <T> T a(Object obj, a aVar) {
        i iVar = i.AS_PATH_LIST;
        boolean a2 = aVar.a(iVar);
        i iVar2 = i.ALWAYS_RETURN_LIST;
        boolean a3 = aVar.a(iVar2);
        boolean a4 = aVar.a(i.SUPPRESS_EXCEPTIONS);
        try {
            if (this.f1413a.a()) {
                if (a2 || a3) {
                    throw new h("Options " + iVar + " and " + iVar2 + " are not allowed when using path functions!");
                }
                return (T) this.f1413a.a(obj, obj, aVar).a(true);
            }
            if (a2) {
                return (T) this.f1413a.a(obj, obj, aVar).b();
            }
            T t = (T) this.f1413a.a(obj, obj, aVar).a(false);
            if (!a3 || !this.f1413a.c()) {
                return t;
            }
            T t2 = (T) aVar.f().a();
            aVar.f().a(t2, 0, t);
            return t2;
        } catch (RuntimeException e) {
            if (!a4) {
                throw e;
            }
            if (a2 || a3) {
                return (T) aVar.f().a();
            }
            if (this.f1413a.c()) {
                return null;
            }
            return (T) aVar.f().a();
        }
    }

    public static j a(a aVar) {
        return new sdk.pendo.io.o1.f(aVar);
    }
}
