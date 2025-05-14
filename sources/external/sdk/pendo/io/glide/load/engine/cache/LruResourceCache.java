package external.sdk.pendo.io.glide.load.engine.cache;

import external.sdk.pendo.io.glide.load.engine.cache.c;
import sdk.pendo.io.i0.g;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public class LruResourceCache extends g<f, sdk.pendo.io.t.c<?>> implements c {
    private c.a listener;

    public LruResourceCache(long j) {
        super(j);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public /* bridge */ /* synthetic */ sdk.pendo.io.t.c put(f fVar, sdk.pendo.io.t.c cVar) {
        return (sdk.pendo.io.t.c) super.put((LruResourceCache) fVar, (f) cVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public /* bridge */ /* synthetic */ sdk.pendo.io.t.c remove(f fVar) {
        return (sdk.pendo.io.t.c) super.remove((LruResourceCache) fVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public void setResourceRemovedListener(c.a aVar) {
        this.listener = aVar;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public void trimMemory(int i) {
        if (i >= 40) {
            clearMemory();
        } else if (i >= 20 || i == 15) {
            trimToSize(getMaxSize() / 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.i0.g
    public int getSize(sdk.pendo.io.t.c<?> cVar) {
        return cVar == null ? super.getSize((LruResourceCache) null) : cVar.getSize();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.i0.g
    public void onItemEvicted(f fVar, sdk.pendo.io.t.c<?> cVar) {
        c.a aVar = this.listener;
        if (aVar == null || cVar == null) {
            return;
        }
        aVar.onResourceRemoved(cVar);
    }
}
