package sdk.pendo.io.f2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes6.dex */
public class d<T> extends k<T> {
    final ParameterizedType c;
    final Class<?> d;
    final Class<?> e;
    final sdk.pendo.io.z1.d<?> f;
    final Type g;
    final Class<?> h;
    k<?> i;

    public d(j jVar, ParameterizedType parameterizedType) {
        super(jVar);
        this.c = parameterizedType;
        Class cls = (Class) parameterizedType.getRawType();
        this.d = cls;
        this.e = cls.isInterface() ? sdk.pendo.io.b2.a.class : cls;
        this.f = sdk.pendo.io.z1.d.a(this.e, sdk.pendo.io.b2.h.f883a);
        Type type = parameterizedType.getActualTypeArguments()[0];
        this.g = type;
        this.h = (Class) (type instanceof Class ? type : ((ParameterizedType) type).getRawType());
    }

    @Override // sdk.pendo.io.f2.k
    public void a(Object obj, Object obj2) {
        ((List) obj).add(sdk.pendo.io.b2.h.a(obj2, this.h));
    }

    @Override // sdk.pendo.io.f2.k
    public k<?> b(String str) {
        if (this.i == null) {
            this.i = this.f1073a.a(this.c.getActualTypeArguments()[0]);
        }
        return this.i;
    }

    @Override // sdk.pendo.io.f2.k
    public Object a() {
        return this.f.c();
    }

    @Override // sdk.pendo.io.f2.k
    public k<?> a(String str) {
        if (this.i == null) {
            this.i = this.f1073a.a(this.c.getActualTypeArguments()[0]);
        }
        return this.i;
    }
}
