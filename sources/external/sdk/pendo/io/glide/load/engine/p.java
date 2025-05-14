package external.sdk.pendo.io.glide.load.engine;

import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.engine.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class p<Data, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<Data> f675a;
    private final Pools.Pool<List<Throwable>> b;
    private final List<? extends h<Data, ResourceType, Transcode>> c;
    private final String d;

    public p(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<h<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.f675a = cls;
        this.b = pool;
        this.c = (List) sdk.pendo.io.i0.j.a(list);
        this.d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public sdk.pendo.io.t.c<Transcode> a(external.sdk.pendo.io.glide.load.data.b<Data> bVar, Options options, int i, int i2, h.a<ResourceType> aVar) {
        List<Throwable> list = (List) sdk.pendo.io.i0.j.a(this.b.acquire());
        try {
            return a(bVar, options, i, i2, aVar, list);
        } finally {
            this.b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.c.toArray()) + '}';
    }

    private sdk.pendo.io.t.c<Transcode> a(external.sdk.pendo.io.glide.load.data.b<Data> bVar, Options options, int i, int i2, h.a<ResourceType> aVar, List<Throwable> list) {
        int size = this.c.size();
        sdk.pendo.io.t.c<Transcode> cVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                cVar = this.c.get(i3).a(bVar, i, i2, options, aVar);
            } catch (n e) {
                list.add(e);
            }
            if (cVar != null) {
                break;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        throw new n(this.d, new ArrayList(list));
    }
}
