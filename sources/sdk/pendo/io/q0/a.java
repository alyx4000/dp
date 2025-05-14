package sdk.pendo.io.q0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import sdk.pendo.io.m0.b;

/* loaded from: classes6.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    final Class<? super T> f1508a;
    final Type b;
    final int c;

    protected a() {
        Type b = b(getClass());
        this.b = b;
        this.f1508a = (Class<? super T>) b.e(b);
        this.c = b.hashCode();
    }

    public static <T> a<T> a(Class<T> cls) {
        return new a<>(cls);
    }

    static Type b(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return b.b(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && b.a(this.b, ((a) obj).b);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        return b.h(this.b);
    }

    a(Type type) {
        Type b = b.b((Type) sdk.pendo.io.m0.a.a(type));
        this.b = b;
        this.f1508a = (Class<? super T>) b.e(b);
        this.c = b.hashCode();
    }

    public static a<?> a(Type type) {
        return new a<>(type);
    }

    public final Type b() {
        return this.b;
    }

    public final Class<? super T> a() {
        return this.f1508a;
    }
}
