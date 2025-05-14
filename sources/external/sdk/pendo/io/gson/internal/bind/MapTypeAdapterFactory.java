package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import sdk.pendo.io.k0.i;
import sdk.pendo.io.k0.n;
import sdk.pendo.io.k0.q;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.b;
import sdk.pendo.io.m0.c;
import sdk.pendo.io.m0.e;
import sdk.pendo.io.m0.h;
import sdk.pendo.io.m0.k;

/* loaded from: classes2.dex */
public final class MapTypeAdapterFactory implements u {
    private final c f;
    final boolean s;

    public MapTypeAdapterFactory(c cVar, boolean z) {
        this.f = cVar;
        this.s = z;
    }

    @Override // sdk.pendo.io.k0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
        Type b = aVar.b();
        if (!Map.class.isAssignableFrom(aVar.a())) {
            return null;
        }
        Type[] b2 = b.b(b, b.e(b));
        return new Adapter(gson, b2[0], a(gson, b2[0]), b2[1], gson.a(sdk.pendo.io.q0.a.a(b2[1])), this.f.a(aVar));
    }

    private TypeAdapter<?> a(Gson gson, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? TypeAdapters.f : gson.a(sdk.pendo.io.q0.a.a(type));
    }

    private final class Adapter<K, V> extends TypeAdapter<Map<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private final TypeAdapter<K> f731a;
        private final TypeAdapter<V> b;
        private final h<? extends Map<K, V>> c;

        public Adapter(Gson gson, Type type, TypeAdapter<K> typeAdapter, Type type2, TypeAdapter<V> typeAdapter2, h<? extends Map<K, V>> hVar) {
            this.f731a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
            this.c = hVar;
        }

        private String a(i iVar) {
            if (!iVar.k()) {
                if (iVar.i()) {
                    return "null";
                }
                throw new AssertionError();
            }
            n f = iVar.f();
            if (f.p()) {
                return String.valueOf(f.n());
            }
            if (f.o()) {
                return Boolean.toString(f.a());
            }
            if (f.q()) {
                return f.g();
            }
            throw new AssertionError();
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map<K, V> a(sdk.pendo.io.r0.a aVar) {
            sdk.pendo.io.r0.b D = aVar.D();
            if (D == sdk.pendo.io.r0.b.NULL) {
                aVar.A();
                return null;
            }
            Map<K, V> a2 = this.c.a();
            if (D == sdk.pendo.io.r0.b.BEGIN_ARRAY) {
                aVar.a();
                while (aVar.s()) {
                    aVar.a();
                    K a3 = this.f731a.a(aVar);
                    if (a2.put(a3, this.b.a(aVar)) != null) {
                        throw new q("duplicate key: " + a3);
                    }
                    aVar.o();
                }
                aVar.o();
            } else {
                aVar.b();
                while (aVar.s()) {
                    e.f1372a.a(aVar);
                    K a4 = this.f731a.a(aVar);
                    if (a2.put(a4, this.b.a(aVar)) != null) {
                        throw new q("duplicate key: " + a4);
                    }
                }
                aVar.p();
            }
            return a2;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.r0.c cVar, Map<K, V> map) {
            if (map == null) {
                cVar.s();
                return;
            }
            if (!MapTypeAdapterFactory.this.s) {
                cVar.m();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    cVar.b(String.valueOf(entry.getKey()));
                    this.b.a(cVar, entry.getValue());
                }
                cVar.o();
                return;
            }
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            int i = 0;
            boolean z = false;
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                i a2 = this.f731a.a((TypeAdapter<K>) entry2.getKey());
                arrayList.add(a2);
                arrayList2.add(entry2.getValue());
                z |= a2.h() || a2.j();
            }
            if (!z) {
                cVar.m();
                int size = arrayList.size();
                while (i < size) {
                    cVar.b(a((i) arrayList.get(i)));
                    this.b.a(cVar, arrayList2.get(i));
                    i++;
                }
                cVar.o();
                return;
            }
            cVar.e();
            int size2 = arrayList.size();
            while (i < size2) {
                cVar.e();
                k.a((i) arrayList.get(i), cVar);
                this.b.a(cVar, arrayList2.get(i));
                cVar.n();
                i++;
            }
            cVar.n();
        }
    }
}
