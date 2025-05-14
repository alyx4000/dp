package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Gson f740a;
    private final TypeAdapter<T> b;
    private final Type c;

    TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f740a = gson;
        this.b = typeAdapter;
        this.c = type;
    }

    private Type a(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public T a(sdk.pendo.io.r0.a aVar) {
        return this.b.a(aVar);
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, T t) {
        TypeAdapter<T> typeAdapter = this.b;
        Type a2 = a(this.c, t);
        if (a2 != this.c) {
            typeAdapter = this.f740a.a(sdk.pendo.io.q0.a.a(a2));
            if (typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter2 = this.b;
                if (!(typeAdapter2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapter = typeAdapter2;
                }
            }
        }
        typeAdapter.a(cVar, t);
    }
}
