package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import external.sdk.pendo.io.gson.internal.Excluder;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.k0.d;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.c;
import sdk.pendo.io.m0.h;
import sdk.pendo.io.m0.j;

/* loaded from: classes2.dex */
public final class ReflectiveTypeAdapterFactory implements u {
    private final Excluder A;
    private final c f;
    private final JsonAdapterAnnotationTypeAdapterFactory f0;
    private final d s;

    public static final class Adapter<T> extends TypeAdapter<T> {

        /* renamed from: a, reason: collision with root package name */
        private final h<T> f736a;
        private final Map<String, b> b;

        Adapter(h<T> hVar, Map<String, b> map) {
            this.f736a = hVar;
            this.b = map;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public T a(sdk.pendo.io.r0.a aVar) {
            if (aVar.D() == sdk.pendo.io.r0.b.NULL) {
                aVar.A();
                return null;
            }
            T a2 = this.f736a.a();
            try {
                aVar.b();
                while (aVar.s()) {
                    b bVar = this.b.get(aVar.z());
                    if (bVar != null && bVar.c) {
                        bVar.a(aVar, a2);
                    }
                    aVar.J();
                }
                aVar.p();
                return a2;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new q(e2);
            }
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.r0.c cVar, T t) {
            if (t == null) {
                cVar.s();
                return;
            }
            cVar.m();
            try {
                for (b bVar : this.b.values()) {
                    if (bVar.a(t)) {
                        cVar.b(bVar.f737a);
                        bVar.a(cVar, t);
                    }
                }
                cVar.o();
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    class a extends b {
        final /* synthetic */ Field d;
        final /* synthetic */ boolean e;
        final /* synthetic */ TypeAdapter f;
        final /* synthetic */ Gson g;
        final /* synthetic */ sdk.pendo.io.q0.a h;
        final /* synthetic */ boolean i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, Field field, boolean z3, TypeAdapter typeAdapter, Gson gson, sdk.pendo.io.q0.a aVar, boolean z4) {
            super(str, z, z2);
            this.d = field;
            this.e = z3;
            this.f = typeAdapter;
            this.g = gson;
            this.h = aVar;
            this.i = z4;
        }

        @Override // external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void a(sdk.pendo.io.r0.a aVar, Object obj) {
            Object a2 = this.f.a(aVar);
            if (a2 == null && this.i) {
                return;
            }
            this.d.set(obj, a2);
        }

        @Override // external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        void a(sdk.pendo.io.r0.c cVar, Object obj) {
            (this.e ? this.f : new TypeAdapterRuntimeTypeWrapper(this.g, this.f, this.h.b())).a(cVar, this.d.get(obj));
        }

        @Override // external.sdk.pendo.io.gson.internal.bind.ReflectiveTypeAdapterFactory.b
        public boolean a(Object obj) {
            return this.b && this.d.get(obj) != obj;
        }
    }

    static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        final String f737a;
        final boolean b;
        final boolean c;

        protected b(String str, boolean z, boolean z2) {
            this.f737a = str;
            this.b = z;
            this.c = z2;
        }

        abstract void a(sdk.pendo.io.r0.a aVar, Object obj);

        abstract void a(sdk.pendo.io.r0.c cVar, Object obj);

        abstract boolean a(Object obj);
    }

    public ReflectiveTypeAdapterFactory(c cVar, d dVar, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        this.f = cVar;
        this.s = dVar;
        this.A = excluder;
        this.f0 = jsonAdapterAnnotationTypeAdapterFactory;
    }

    @Override // sdk.pendo.io.k0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
        Class<? super T> a2 = aVar.a();
        if (Object.class.isAssignableFrom(a2)) {
            return new Adapter(this.f.a(aVar), a(gson, (sdk.pendo.io.q0.a<?>) aVar, (Class<?>) a2));
        }
        return null;
    }

    private b a(Gson gson, Field field, String str, sdk.pendo.io.q0.a<?> aVar, boolean z, boolean z2) {
        boolean a2 = j.a((Type) aVar.a());
        sdk.pendo.io.l0.b bVar = (sdk.pendo.io.l0.b) field.getAnnotation(sdk.pendo.io.l0.b.class);
        TypeAdapter<?> a3 = bVar != null ? this.f0.a(this.f, gson, aVar, bVar) : null;
        boolean z3 = a3 != null;
        if (a3 == null) {
            a3 = gson.a(aVar);
        }
        return new a(str, z, z2, field, z3, a3, gson, aVar, a2);
    }

    public boolean a(Field field, boolean z) {
        return a(field, z, this.A);
    }

    static boolean a(Field field, boolean z, Excluder excluder) {
        return (excluder.a(field.getType(), z) || excluder.a(field, z)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7 */
    private Map<String, b> a(Gson gson, sdk.pendo.io.q0.a<?> aVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type b2 = aVar.b();
        sdk.pendo.io.q0.a<?> aVar2 = aVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean a2 = a(field, true);
                boolean a3 = a(field, z);
                if (a2 || a3) {
                    sdk.pendo.io.p0.a.a(field);
                    Type a4 = sdk.pendo.io.m0.b.a(aVar2.b(), cls2, field.getGenericType());
                    List<String> a5 = a(field);
                    int size = a5.size();
                    b bVar = null;
                    ?? r2 = z;
                    while (r2 < size) {
                        String str = a5.get(r2);
                        boolean z2 = r2 != 0 ? z : a2;
                        int i2 = r2;
                        b bVar2 = bVar;
                        int i3 = size;
                        List<String> list = a5;
                        Field field2 = field;
                        bVar = bVar2 == null ? (b) linkedHashMap.put(str, a(gson, field, str, sdk.pendo.io.q0.a.a(a4), z2, a3)) : bVar2;
                        a2 = z2;
                        a5 = list;
                        size = i3;
                        field = field2;
                        z = false;
                        r2 = i2 + 1;
                    }
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        throw new IllegalArgumentException(b2 + " declares multiple JSON fields named " + bVar3.f737a);
                    }
                }
                i++;
                z = false;
            }
            aVar2 = sdk.pendo.io.q0.a.a(sdk.pendo.io.m0.b.a(aVar2.b(), cls2, cls2.getGenericSuperclass()));
            cls2 = aVar2.a();
        }
        return linkedHashMap;
    }

    private List<String> a(Field field) {
        sdk.pendo.io.l0.c cVar = (sdk.pendo.io.l0.c) field.getAnnotation(sdk.pendo.io.l0.c.class);
        if (cVar == null) {
            return Collections.singletonList(this.s.a(field));
        }
        String value = cVar.value();
        String[] alternate = cVar.alternate();
        if (alternate.length == 0) {
            return Collections.singletonList(value);
        }
        ArrayList arrayList = new ArrayList(alternate.length + 1);
        arrayList.add(value);
        for (String str : alternate) {
            arrayList.add(str);
        }
        return arrayList;
    }
}
