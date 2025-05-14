package sdk.pendo.io.f2;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class i extends k<sdk.pendo.io.b2.c> {
    protected i(j jVar) {
        super(jVar);
    }

    @Override // sdk.pendo.io.f2.k
    public void a(Object obj, Object obj2) {
        ((sdk.pendo.io.b2.a) obj).add(obj2);
    }

    @Override // sdk.pendo.io.f2.k
    public Object b() {
        return new LinkedHashMap();
    }

    @Override // sdk.pendo.io.f2.k
    public Object a() {
        return new sdk.pendo.io.b2.a();
    }

    @Override // sdk.pendo.io.f2.k
    public k<sdk.pendo.io.b2.c> b(String str) {
        return this.f1073a.c;
    }

    @Override // sdk.pendo.io.f2.k
    public void a(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // sdk.pendo.io.f2.k
    public k<sdk.pendo.io.b2.c> a(String str) {
        return this.f1073a.c;
    }
}
