package sdk.pendo.io.v1;

import java.util.HashMap;
import sdk.pendo.io.n1.l;

/* loaded from: classes4.dex */
public class m implements l.a {
    private static final sdk.pendo.io.h7.a e = sdk.pendo.io.h7.b.a((Class<?>) m.class);

    /* renamed from: a, reason: collision with root package name */
    private final Object f1662a;
    private final Object b;
    private final sdk.pendo.io.n1.a c;
    private final HashMap<sdk.pendo.io.o1.g, Object> d;

    public m(Object obj, Object obj2, sdk.pendo.io.n1.a aVar, HashMap<sdk.pendo.io.o1.g, Object> hashMap) {
        this.f1662a = obj;
        this.b = obj2;
        this.c = aVar;
        this.d = hashMap;
    }

    @Override // sdk.pendo.io.n1.l.a
    public sdk.pendo.io.n1.a a() {
        return this.c;
    }

    @Override // sdk.pendo.io.n1.l.a
    public Object b() {
        return this.b;
    }

    @Override // sdk.pendo.io.n1.l.a
    public Object c() {
        return this.f1662a;
    }

    public HashMap<sdk.pendo.io.o1.g, Object> d() {
        return this.d;
    }

    public Object a(sdk.pendo.io.o1.g gVar) {
        if (!gVar.b()) {
            return gVar.a(this.f1662a, this.b, this.c).getValue();
        }
        if (this.d.containsKey(gVar)) {
            e.a("Using cached result for root path: " + gVar.toString());
            return this.d.get(gVar);
        }
        Object obj = this.b;
        Object value = gVar.a(obj, obj, this.c).getValue();
        this.d.put(gVar, value);
        return value;
    }
}
