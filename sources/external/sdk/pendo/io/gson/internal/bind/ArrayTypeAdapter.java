package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.b;
import sdk.pendo.io.r0.c;

/* loaded from: classes2.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final u c = new u() { // from class: external.sdk.pendo.io.gson.internal.bind.ArrayTypeAdapter.1
        @Override // sdk.pendo.io.k0.u
        public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
            Type b = aVar.b();
            if (!(b instanceof GenericArrayType) && (!(b instanceof Class) || !((Class) b).isArray())) {
                return null;
            }
            Type d = b.d(b);
            return new ArrayTypeAdapter(gson, gson.a(sdk.pendo.io.q0.a.a(d)), b.e(d));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final Class<E> f726a;
    private final TypeAdapter<E> b;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f726a = cls;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public Object a(sdk.pendo.io.r0.a aVar) {
        if (aVar.D() == sdk.pendo.io.r0.b.NULL) {
            aVar.A();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.s()) {
            arrayList.add(this.b.a(aVar));
        }
        aVar.o();
        int size = arrayList.size();
        Object newInstance = Array.newInstance((Class<?>) this.f726a, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // external.sdk.pendo.io.gson.TypeAdapter
    public void a(c cVar, Object obj) {
        if (obj == null) {
            cVar.s();
            return;
        }
        cVar.e();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.b.a(cVar, Array.get(obj, i));
        }
        cVar.n();
    }
}
