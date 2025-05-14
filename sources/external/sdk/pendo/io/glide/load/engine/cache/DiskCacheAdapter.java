package external.sdk.pendo.io.glide.load.engine.cache;

import external.sdk.pendo.io.glide.load.engine.cache.a;
import java.io.File;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public class DiskCacheAdapter implements a {

    public static final class Factory implements a.InterfaceC0059a {
        @Override // external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0059a
        public a build() {
            return new DiskCacheAdapter();
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public void clear() {
    }

    public void delete(f fVar) {
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public File get(f fVar) {
        return null;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public void put(f fVar, a.b bVar) {
    }
}
