package external.sdk.pendo.io.glide.load.engine.cache;

import java.io.File;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public interface a {

    /* renamed from: external.sdk.pendo.io.glide.load.engine.cache.a$a, reason: collision with other inner class name */
    public interface InterfaceC0059a {
        a build();
    }

    public interface b {
        boolean a(File file);
    }

    void clear();

    File get(f fVar);

    void put(f fVar, b bVar);
}
