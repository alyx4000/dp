package sdk.pendo.io.f2;

import java.util.Map;

/* loaded from: classes6.dex */
public class e<T> extends k<T> {
    final Class<?> c;
    final Class<?> d;
    final sdk.pendo.io.z1.d<?> e;

    public e(j jVar, Class<?> cls) {
        super(jVar);
        this.c = cls;
        if (cls.isInterface()) {
            this.d = sdk.pendo.io.b2.d.class;
        } else {
            this.d = cls;
        }
        this.e = sdk.pendo.io.z1.d.a(this.d, sdk.pendo.io.b2.h.f883a);
    }

    @Override // sdk.pendo.io.f2.k
    public void a(Object obj, String str, Object obj2) {
        ((Map) obj).put(str, obj2);
    }

    @Override // sdk.pendo.io.f2.k
    public Object b() {
        return this.e.c();
    }

    @Override // sdk.pendo.io.f2.k
    public k<?> a(String str) {
        return this.f1073a.b;
    }

    @Override // sdk.pendo.io.f2.k
    public k<?> b(String str) {
        return this.f1073a.b;
    }
}
