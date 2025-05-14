package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class h<DataType, ResourceType, Transcode> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<DataType> f672a;
    private final List<? extends sdk.pendo.io.q.i<DataType, ResourceType>> b;
    private final sdk.pendo.io.b0.a<ResourceType, Transcode> c;
    private final Pools.Pool<List<Throwable>> d;
    private final String e;

    interface a<ResourceType> {
        sdk.pendo.io.t.c<ResourceType> a(sdk.pendo.io.t.c<ResourceType> cVar);
    }

    public h(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends sdk.pendo.io.q.i<DataType, ResourceType>> list, sdk.pendo.io.b0.a<ResourceType, Transcode> aVar, Pools.Pool<List<Throwable>> pool) {
        this.f672a = cls;
        this.b = list;
        this.c = aVar;
        this.d = pool;
        this.e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public sdk.pendo.io.t.c<Transcode> a(external.sdk.pendo.io.glide.load.data.b<DataType> bVar, int i, int i2, Options options, a<ResourceType> aVar) {
        return this.c.transcode(aVar.a(a(bVar, i, i2, options)), options);
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.f672a + ", decoders=" + this.b + ", transcoder=" + this.c + '}';
    }

    private sdk.pendo.io.t.c<ResourceType> a(external.sdk.pendo.io.glide.load.data.b<DataType> bVar, int i, int i2, Options options) {
        List<Throwable> list = (List) sdk.pendo.io.i0.j.a(this.d.acquire());
        try {
            return a(bVar, i, i2, options, list);
        } finally {
            this.d.release(list);
        }
    }

    private sdk.pendo.io.t.c<ResourceType> a(external.sdk.pendo.io.glide.load.data.b<DataType> bVar, int i, int i2, Options options, List<Throwable> list) {
        int size = this.b.size();
        sdk.pendo.io.t.c<ResourceType> cVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            sdk.pendo.io.q.i<DataType, ResourceType> iVar = this.b.get(i3);
            try {
                if (iVar.handles(bVar.rewindAndGet(), options)) {
                    cVar = iVar.decode(bVar.rewindAndGet(), i, i2, options);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + iVar, e);
                }
                list.add(e);
            }
            if (cVar != null) {
                break;
            }
        }
        if (cVar != null) {
            return cVar;
        }
        throw new n(this.e, new ArrayList(list));
    }
}
