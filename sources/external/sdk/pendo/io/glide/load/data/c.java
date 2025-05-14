package external.sdk.pendo.io.glide.load.data;

import external.sdk.pendo.io.glide.load.data.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sdk.pendo.io.i0.j;

/* loaded from: classes2.dex */
public class c {
    private static final b.a<?> b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, b.a<?>> f637a = new HashMap();

    class a implements b.a<Object> {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public external.sdk.pendo.io.glide.load.data.b<Object> build(Object obj) {
            return new b(obj);
        }

        @Override // external.sdk.pendo.io.glide.load.data.b.a
        public Class<Object> getDataClass() {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    private static final class b implements external.sdk.pendo.io.glide.load.data.b<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f638a;

        b(Object obj) {
            this.f638a = obj;
        }

        @Override // external.sdk.pendo.io.glide.load.data.b
        public void cleanup() {
        }

        @Override // external.sdk.pendo.io.glide.load.data.b
        public Object rewindAndGet() {
            return this.f638a;
        }
    }

    public synchronized <T> external.sdk.pendo.io.glide.load.data.b<T> a(T t) {
        b.a<?> aVar;
        j.a(t);
        aVar = this.f637a.get(t.getClass());
        if (aVar == null) {
            Iterator<b.a<?>> it = this.f637a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b.a<?> next = it.next();
                if (next.getDataClass().isAssignableFrom(t.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = b;
        }
        return (external.sdk.pendo.io.glide.load.data.b<T>) aVar.build(t);
    }

    public synchronized void a(b.a<?> aVar) {
        this.f637a.put(aVar.getDataClass(), aVar);
    }
}
