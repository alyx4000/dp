package sdk.pendo.io.d0;

import androidx.collection.ArrayMap;
import external.sdk.pendo.io.glide.load.engine.h;
import external.sdk.pendo.io.glide.load.engine.p;
import external.sdk.pendo.io.glide.load.resource.transcode.UnitTranscoder;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;
import sdk.pendo.io.i0.i;

/* loaded from: classes6.dex */
public class c {
    private static final p<?, ?, ?> c = new p<>(Object.class, Object.class, Object.class, Collections.singletonList(new h(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), null)), null);

    /* renamed from: a, reason: collision with root package name */
    private final ArrayMap<i, p<?, ?, ?>> f976a = new ArrayMap<>();
    private final AtomicReference<i> b = new AtomicReference<>();

    private i b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        i andSet = this.b.getAndSet(null);
        if (andSet == null) {
            andSet = new i();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public <Data, TResource, Transcode> p<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        p<Data, TResource, Transcode> pVar;
        i b = b(cls, cls2, cls3);
        synchronized (this.f976a) {
            pVar = (p) this.f976a.get(b);
        }
        this.b.set(b);
        return pVar;
    }

    public boolean a(p<?, ?, ?> pVar) {
        return c.equals(pVar);
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, p<?, ?, ?> pVar) {
        synchronized (this.f976a) {
            ArrayMap<i, p<?, ?, ?>> arrayMap = this.f976a;
            i iVar = new i(cls, cls2, cls3);
            if (pVar == null) {
                pVar = c;
            }
            arrayMap.put(iVar, pVar);
        }
    }
}
