package external.sdk.pendo.io.glide.load.engine.cache;

import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public interface c {

    public interface a {
        void onResourceRemoved(sdk.pendo.io.t.c<?> cVar);
    }

    void clearMemory();

    sdk.pendo.io.t.c<?> put(f fVar, sdk.pendo.io.t.c<?> cVar);

    sdk.pendo.io.t.c<?> remove(f fVar);

    void setResourceRemovedListener(a aVar);

    void trimMemory(int i);
}
