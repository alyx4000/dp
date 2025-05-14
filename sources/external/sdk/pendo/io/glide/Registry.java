package external.sdk.pendo.io.glide;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.ImageHeaderParser;
import external.sdk.pendo.io.glide.load.ResourceEncoder;
import external.sdk.pendo.io.glide.load.data.b;
import external.sdk.pendo.io.glide.load.engine.h;
import external.sdk.pendo.io.glide.load.engine.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import sdk.pendo.io.d0.e;
import sdk.pendo.io.d0.f;
import sdk.pendo.io.q.i;

/* loaded from: classes2.dex */
public class Registry {

    /* renamed from: a, reason: collision with root package name */
    private final external.sdk.pendo.io.glide.load.model.c f621a;
    private final sdk.pendo.io.d0.a b;
    private final e c;
    private final f d;
    private final external.sdk.pendo.io.glide.load.data.c e;
    private final sdk.pendo.io.b0.b f;
    private final sdk.pendo.io.d0.b g;
    private final sdk.pendo.io.d0.d h = new sdk.pendo.io.d0.d();
    private final sdk.pendo.io.d0.c i = new sdk.pendo.io.d0.c();
    private final Pools.Pool<List<Throwable>> j;

    public static final class NoImageHeaderParserException extends a {
        public NoImageHeaderParserException() {
            super("Failed to find image header parser.");
        }
    }

    public static class NoModelLoaderAvailableException extends a {
        public NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }

        public NoModelLoaderAvailableException(Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> NoModelLoaderAvailableException(M m, List<external.sdk.pendo.io.glide.load.model.b<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }
    }

    public static class NoResultEncoderAvailableException extends a {
        public NoResultEncoderAvailableException(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class NoSourceEncoderAvailableException extends a {
        public NoSourceEncoderAvailableException(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public Registry() {
        Pools.Pool<List<Throwable>> b = sdk.pendo.io.j0.a.b();
        this.j = b;
        this.f621a = new external.sdk.pendo.io.glide.load.model.c(b);
        this.b = new sdk.pendo.io.d0.a();
        this.c = new e();
        this.d = new f();
        this.e = new external.sdk.pendo.io.glide.load.data.c();
        this.f = new sdk.pendo.io.b0.b();
        this.g = new sdk.pendo.io.d0.b();
        a(Arrays.asList("Gif", com.bumptech.glide.Registry.BUCKET_BITMAP, com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE));
    }

    public <TResource> Registry a(Class<TResource> cls, ResourceEncoder<TResource> resourceEncoder) {
        this.d.a(cls, resourceEncoder);
        return this;
    }

    public <Data, TResource, Transcode> p<Data, TResource, Transcode> b(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        p<Data, TResource, Transcode> a2 = this.i.a(cls, cls2, cls3);
        if (this.i.a(a2)) {
            return null;
        }
        if (a2 == null) {
            List<h<Data, TResource, Transcode>> a3 = a(cls, cls2, cls3);
            a2 = a3.isEmpty() ? null : new p<>(cls, cls2, cls3, a3, this.j);
            this.i.a(cls, cls2, cls3, a2);
        }
        return a2;
    }

    public <Model, TResource, Transcode> List<Class<?>> c(Class<Model> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        List<Class<?>> a2 = this.h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            Iterator<Class<?>> it = this.f621a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.c.b(it.next(), cls2)) {
                    if (!this.f.b(cls4, cls3).isEmpty() && !a2.contains(cls4)) {
                        a2.add(cls4);
                    }
                }
            }
            this.h.a(cls, cls2, cls3, Collections.unmodifiableList(a2));
        }
        return a2;
    }

    public <Data, TResource> Registry a(Class<Data> cls, Class<TResource> cls2, i<Data, TResource> iVar) {
        a("legacy_append", cls, cls2, iVar);
        return this;
    }

    public <X> external.sdk.pendo.io.glide.load.data.b<X> b(X x) {
        return this.e.a((external.sdk.pendo.io.glide.load.data.c) x);
    }

    public <X> sdk.pendo.io.q.d<X> c(X x) {
        sdk.pendo.io.q.d<X> a2 = this.b.a(x.getClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoSourceEncoderAvailableException(x.getClass());
    }

    public <Model, Data> Registry a(Class<Model> cls, Class<Data> cls2, sdk.pendo.io.x.d<Model, Data> dVar) {
        this.f621a.a(cls, cls2, dVar);
        return this;
    }

    public boolean b(sdk.pendo.io.t.c<?> cVar) {
        return this.d.a(cVar.getResourceClass()) != null;
    }

    public <Data> Registry a(Class<Data> cls, sdk.pendo.io.q.d<Data> dVar) {
        this.b.a(cls, dVar);
        return this;
    }

    public <Data, TResource> Registry a(String str, Class<Data> cls, Class<TResource> cls2, i<Data, TResource> iVar) {
        this.c.a(str, iVar, cls, cls2);
        return this;
    }

    private <Data, TResource, Transcode> List<h<Data, TResource, Transcode>> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.b(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new h(cls, cls4, cls5, this.c.a(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.g.a();
        if (a2.isEmpty()) {
            throw new NoImageHeaderParserException();
        }
        return a2;
    }

    public <Model> List<external.sdk.pendo.io.glide.load.model.b<Model, ?>> a(Model model) {
        return this.f621a.b((external.sdk.pendo.io.glide.load.model.c) model);
    }

    public <X> ResourceEncoder<X> a(sdk.pendo.io.t.c<X> cVar) {
        ResourceEncoder<X> a2 = this.d.a(cVar.getResourceClass());
        if (a2 != null) {
            return a2;
        }
        throw new NoResultEncoderAvailableException(cVar.getResourceClass());
    }

    public Registry a(ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public Registry a(b.a<?> aVar) {
        this.e.a(aVar);
        return this;
    }

    public <TResource, Transcode> Registry a(Class<TResource> cls, Class<Transcode> cls2, sdk.pendo.io.b0.a<TResource, Transcode> aVar) {
        this.f.a(cls, cls2, aVar);
        return this;
    }

    public final Registry a(List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add("legacy_prepend_all");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add("legacy_append");
        this.c.a(arrayList);
        return this;
    }
}
