package external.sdk.pendo.io.glide.load.model;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final e f684a;
    private final a b;

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0063a<?>> f685a = new HashMap();

        /* renamed from: external.sdk.pendo.io.glide.load.model.c$a$a, reason: collision with other inner class name */
        private static class C0063a<Model> {

            /* renamed from: a, reason: collision with root package name */
            final List<b<Model, ?>> f686a;

            public C0063a(List<b<Model, ?>> list) {
                this.f686a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f685a.clear();
        }

        public <Model> List<b<Model, ?>> a(Class<Model> cls) {
            C0063a<?> c0063a = this.f685a.get(cls);
            if (c0063a == null) {
                return null;
            }
            return (List<b<Model, ?>>) c0063a.f686a;
        }

        public <Model> void a(Class<Model> cls, List<b<Model, ?>> list) {
            if (this.f685a.put(cls, new C0063a<>(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public c(Pools.Pool<List<Throwable>> pool) {
        this(new e(pool));
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, sdk.pendo.io.x.d<? extends Model, ? extends Data> dVar) {
        this.f684a.a(cls, cls2, dVar);
        this.b.a();
    }

    public <A> List<b<A, ?>> b(A a2) {
        List<b<A, ?>> b = b((Class) a(a2));
        if (b.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2);
        }
        int size = b.size();
        List<b<A, ?>> emptyList = Collections.emptyList();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            b<A, ?> bVar = b.get(i);
            if (bVar.handles(a2)) {
                if (z) {
                    emptyList = new ArrayList<>(size - i);
                    z = false;
                }
                emptyList.add(bVar);
            }
        }
        if (emptyList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a2, b);
        }
        return emptyList;
    }

    private c(e eVar) {
        this.b = new a();
        this.f684a = eVar;
    }

    private static <A> Class<A> a(A a2) {
        return (Class<A>) a2.getClass();
    }

    private synchronized <A> List<b<A, ?>> b(Class<A> cls) {
        List<b<A, ?>> a2;
        a2 = this.b.a(cls);
        if (a2 == null) {
            a2 = Collections.unmodifiableList(this.f684a.a(cls));
            this.b.a(cls, a2);
        }
        return a2;
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f684a.b(cls);
    }
}
