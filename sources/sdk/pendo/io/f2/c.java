package sdk.pendo.io.f2;

import java.util.List;

/* loaded from: classes6.dex */
public class c<T> extends k<T> {
    final Class<?> c;
    final Class<?> d;
    final sdk.pendo.io.z1.d<?> e;

    public c(j jVar, Class<?> cls) {
        super(jVar);
        this.c = cls;
        if (cls.isInterface()) {
            this.d = sdk.pendo.io.b2.a.class;
        } else {
            this.d = cls;
        }
        this.e = sdk.pendo.io.z1.d.a(this.d, sdk.pendo.io.b2.h.f883a);
    }

    @Override // sdk.pendo.io.f2.k
    public void a(Object obj, Object obj2) {
        ((List) obj).add(obj2);
    }

    @Override // sdk.pendo.io.f2.k
    public k<?> b(String str) {
        return this.f1073a.b;
    }

    @Override // sdk.pendo.io.f2.k
    public Object a() {
        return this.e.c();
    }

    @Override // sdk.pendo.io.f2.k
    public k<?> a(String str) {
        return this.f1073a.b;
    }
}
