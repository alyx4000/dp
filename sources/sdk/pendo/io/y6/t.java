package sdk.pendo.io.y6;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
abstract class t<T> {
    t() {
    }

    static <T> t<T> a(s sVar, Method method) {
        q a2 = q.a(sVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (w.c(genericReturnType)) {
            throw w.a(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return i.a(sVar, method, a2);
        }
        throw w.a(method, "Service methods cannot return void.", new Object[0]);
    }

    @Nullable
    abstract T a(Object[] objArr);
}
