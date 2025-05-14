package sdk.pendo.io.e7;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.p;
import sdk.pendo.io.x5.q;
import sdk.pendo.io.y6.c;
import sdk.pendo.io.y6.r;
import sdk.pendo.io.y6.s;

/* loaded from: classes6.dex */
public final class g extends c.a {

    /* renamed from: a, reason: collision with root package name */
    private final p f1034a;
    private final boolean b;

    private g(p pVar, boolean z) {
        this.f1034a = pVar;
        this.b = z;
    }

    public static g a() {
        return new g(null, false);
    }

    @Override // sdk.pendo.io.y6.c.a
    public sdk.pendo.io.y6.c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        Type type2;
        boolean z;
        boolean z2;
        Class<?> a2 = c.a.a(type);
        if (a2 == sdk.pendo.io.x5.b.class) {
            return new f(Void.class, this.f1034a, this.b, false, true, false, false, false, true);
        }
        boolean z3 = a2 == sdk.pendo.io.x5.d.class;
        boolean z4 = a2 == q.class;
        boolean z5 = a2 == sdk.pendo.io.x5.g.class;
        if (a2 != j.class && !z3 && !z4 && !z5) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z3 ? !z4 ? z5 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type a3 = c.a.a(0, (ParameterizedType) type);
        Class<?> a4 = c.a.a(a3);
        if (a4 == r.class) {
            if (!(a3 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            type2 = c.a.a(0, (ParameterizedType) a3);
            z2 = false;
            z = false;
        } else if (a4 != d.class) {
            type2 = a3;
            z = true;
            z2 = false;
        } else {
            if (!(a3 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            type2 = c.a.a(0, (ParameterizedType) a3);
            z2 = true;
            z = false;
        }
        return new f(type2, this.f1034a, this.b, z2, z, z3, z4, z5, false);
    }
}
