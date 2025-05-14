package external.sdk.pendo.io.glide.load.engine.cache;

import external.sdk.pendo.io.glide.load.engine.cache.c;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public class MemoryCacheAdapter implements c {
    private c.a listener;

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public void clearMemory() {
    }

    public long getCurrentSize() {
        return 0L;
    }

    public long getMaxSize() {
        return 0L;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public sdk.pendo.io.t.c<?> put(f fVar, sdk.pendo.io.t.c<?> cVar) {
        if (cVar == null) {
            return null;
        }
        this.listener.onResourceRemoved(cVar);
        return null;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public sdk.pendo.io.t.c<?> remove(f fVar) {
        return null;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public void setResourceRemovedListener(c.a aVar) {
        this.listener = aVar;
    }

    public void setSizeMultiplier(float f) {
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c
    public void trimMemory(int i) {
    }
}
