package external.sdk.pendo.io.gson.internal.bind;

import external.sdk.pendo.io.gson.Gson;
import external.sdk.pendo.io.gson.TypeAdapter;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import sdk.pendo.io.k0.u;
import sdk.pendo.io.m0.b;
import sdk.pendo.io.m0.c;
import sdk.pendo.io.m0.h;

/* loaded from: classes2.dex */
public final class CollectionTypeAdapterFactory implements u {
    private final c f;

    public CollectionTypeAdapterFactory(c cVar) {
        this.f = cVar;
    }

    @Override // sdk.pendo.io.k0.u
    public <T> TypeAdapter<T> a(Gson gson, sdk.pendo.io.q0.a<T> aVar) {
        Type b = aVar.b();
        Class<? super T> a2 = aVar.a();
        if (!Collection.class.isAssignableFrom(a2)) {
            return null;
        }
        Type a3 = b.a(b, (Class<?>) a2);
        return new Adapter(gson, a3, gson.a(sdk.pendo.io.q0.a.a(a3)), this.f.a(aVar));
    }

    private static final class Adapter<E> extends TypeAdapter<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final TypeAdapter<E> f727a;
        private final h<? extends Collection<E>> b;

        public Adapter(Gson gson, Type type, TypeAdapter<E> typeAdapter, h<? extends Collection<E>> hVar) {
            this.f727a = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
            this.b = hVar;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Collection<E> a(sdk.pendo.io.r0.a aVar) {
            if (aVar.D() == sdk.pendo.io.r0.b.NULL) {
                aVar.A();
                return null;
            }
            Collection<E> a2 = this.b.a();
            aVar.a();
            while (aVar.s()) {
                a2.add(this.f727a.a(aVar));
            }
            aVar.o();
            return a2;
        }

        @Override // external.sdk.pendo.io.gson.TypeAdapter
        public void a(sdk.pendo.io.r0.c cVar, Collection<E> collection) {
            if (collection == null) {
                cVar.s();
                return;
            }
            cVar.e();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f727a.a(cVar, it.next());
            }
            cVar.n();
        }
    }
}
