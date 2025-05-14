package sdk.pendo.io.d0;

import external.sdk.pendo.io.glide.load.ResourceEncoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final List<a<?>> f980a = new ArrayList();

    private static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f981a;
        final ResourceEncoder<T> b;

        a(Class<T> cls, ResourceEncoder<T> resourceEncoder) {
            this.f981a = cls;
            this.b = resourceEncoder;
        }

        boolean a(Class<?> cls) {
            return this.f981a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, ResourceEncoder<Z> resourceEncoder) {
        this.f980a.add(new a<>(cls, resourceEncoder));
    }

    public synchronized <Z> ResourceEncoder<Z> a(Class<Z> cls) {
        int size = this.f980a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.f980a.get(i);
            if (aVar.a(cls)) {
                return (ResourceEncoder<Z>) aVar.b;
            }
        }
        return null;
    }
}
