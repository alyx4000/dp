package sdk.pendo.io.d0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final List<C0108a<?>> f973a = new ArrayList();

    /* renamed from: sdk.pendo.io.d0.a$a, reason: collision with other inner class name */
    private static final class C0108a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f974a;
        final sdk.pendo.io.q.d<T> b;

        C0108a(Class<T> cls, sdk.pendo.io.q.d<T> dVar) {
            this.f974a = cls;
            this.b = dVar;
        }

        boolean a(Class<?> cls) {
            return this.f974a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> void a(Class<T> cls, sdk.pendo.io.q.d<T> dVar) {
        this.f973a.add(new C0108a<>(cls, dVar));
    }

    public synchronized <T> sdk.pendo.io.q.d<T> a(Class<T> cls) {
        for (C0108a<?> c0108a : this.f973a) {
            if (c0108a.a(cls)) {
                return (sdk.pendo.io.q.d<T>) c0108a.b;
            }
        }
        return null;
    }
}
