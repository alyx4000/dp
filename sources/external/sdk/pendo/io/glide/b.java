package external.sdk.pendo.io.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import external.sdk.pendo.io.glide.a;
import external.sdk.pendo.io.glide.load.engine.Engine;
import external.sdk.pendo.io.glide.request.RequestOptions;
import external.sdk.pendo.io.glide.request.target.ViewTarget;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class b extends ContextWrapper {
    static final d<?, ?> k = new GenericTransitionOptions();

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.u.a f625a;
    private final Registry b;
    private final sdk.pendo.io.f0.b c;
    private final a.InterfaceC0052a d;
    private final List<sdk.pendo.io.e0.b<Object>> e;
    private final Map<Class<?>, d<?, ?>> f;
    private final Engine g;
    private final c h;
    private final int i;
    private RequestOptions j;

    public b(Context context, sdk.pendo.io.u.a aVar, Registry registry, sdk.pendo.io.f0.b bVar, a.InterfaceC0052a interfaceC0052a, Map<Class<?>, d<?, ?>> map, List<sdk.pendo.io.e0.b<Object>> list, Engine engine, c cVar, int i) {
        super(context.getApplicationContext());
        this.f625a = aVar;
        this.b = registry;
        this.c = bVar;
        this.d = interfaceC0052a;
        this.e = list;
        this.f = map;
        this.g = engine;
        this.h = cVar;
        this.i = i;
    }

    public <X> ViewTarget<ImageView, X> a(ImageView imageView, Class<X> cls) {
        return this.c.a(imageView, cls);
    }

    public List<sdk.pendo.io.e0.b<Object>> b() {
        return this.e;
    }

    public synchronized RequestOptions c() {
        if (this.j == null) {
            this.j = this.d.build().lock();
        }
        return this.j;
    }

    public Engine d() {
        return this.g;
    }

    public c e() {
        return this.h;
    }

    public int f() {
        return this.i;
    }

    public Registry g() {
        return this.b;
    }

    public sdk.pendo.io.u.a a() {
        return this.f625a;
    }

    public <T> d<?, T> a(Class<T> cls) {
        d<?, T> dVar = (d) this.f.get(cls);
        if (dVar == null) {
            for (Map.Entry<Class<?>, d<?, ?>> entry : this.f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    dVar = (d) entry.getValue();
                }
            }
        }
        return dVar == null ? (d<?, T>) k : dVar;
    }
}
