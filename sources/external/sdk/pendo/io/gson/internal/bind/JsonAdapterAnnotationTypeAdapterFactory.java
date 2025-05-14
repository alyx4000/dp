package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import sdk.pendo.io.k0.h;
import sdk.pendo.io.k0.p;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.l0.b;
import sdk.pendo.io.m0.c;

/* loaded from: classes2.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements u {
    private final c f;

    public JsonAdapterAnnotationTypeAdapterFactory(c cVar) {
        this.f = cVar;
    }

    @Override // sdk.pendo.io.k0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
        b bVar = (b) aVar.a().getAnnotation(b.class);
        if (bVar == null) {
            return null;
        }
        return (TypeAdapter<T>) a(this.f, gson, aVar, bVar);
    }

    TypeAdapter<?> a(c cVar, Gson gson, sdk.pendo.io.q0.a<?> aVar, b bVar) {
        TypeAdapter<?> treeTypeAdapter;
        Object a2 = cVar.a(sdk.pendo.io.q0.a.a((Class) bVar.value())).a();
        if (a2 instanceof TypeAdapter) {
            treeTypeAdapter = (TypeAdapter) a2;
        } else if (a2 instanceof u) {
            treeTypeAdapter = ((u) a2).a(gson, aVar);
        } else {
            boolean z = a2 instanceof p;
            if (!z && !(a2 instanceof h)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + a2.getClass().getName() + " as a @JsonAdapter for " + aVar.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            treeTypeAdapter = new TreeTypeAdapter<>(z ? (p) a2 : null, a2 instanceof h ? (h) a2 : null, gson, aVar, null);
        }
        return (treeTypeAdapter == null || !bVar.nullSafe()) ? treeTypeAdapter : treeTypeAdapter.a();
    }
}
