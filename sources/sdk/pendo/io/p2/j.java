package sdk.pendo.io.p2;

/* loaded from: classes6.dex */
public class j {
    private static volatile k d = k.J0;

    /* renamed from: a, reason: collision with root package name */
    private final StringBuffer f1495a;
    private final Object b;
    private final k c;

    public j(Object obj, k kVar) {
        this(obj, kVar, null);
    }

    public static k b() {
        return d;
    }

    public j a(String str, Object obj) {
        this.c.a(this.f1495a, str, obj, (Boolean) null);
        return this;
    }

    public Object c() {
        return this.b;
    }

    public StringBuffer d() {
        return this.f1495a;
    }

    public k e() {
        return this.c;
    }

    public String toString() {
        if (c() == null) {
            d().append(e().g());
        } else {
            this.c.b(d(), c());
        }
        return d().toString();
    }

    public j(Object obj, k kVar, StringBuffer stringBuffer) {
        kVar = kVar == null ? b() : kVar;
        stringBuffer = stringBuffer == null ? new StringBuffer(512) : stringBuffer;
        this.f1495a = stringBuffer;
        this.c = kVar;
        this.b = obj;
        kVar.d(stringBuffer, obj);
    }

    public String a() {
        return toString();
    }
}
