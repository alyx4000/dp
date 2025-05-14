package external.sdk.pendo.io.glide.load.engine;

import android.util.Log;
import androidx.core.util.Pools;
import external.sdk.pendo.io.glide.load.Options;
import external.sdk.pendo.io.glide.load.Transformation;
import external.sdk.pendo.io.glide.load.engine.cache.DiskCacheAdapter;
import external.sdk.pendo.io.glide.load.engine.cache.a;
import external.sdk.pendo.io.glide.load.engine.cache.c;
import external.sdk.pendo.io.glide.load.engine.g;
import external.sdk.pendo.io.glide.load.engine.m;
import java.util.Map;
import java.util.concurrent.Executor;
import sdk.pendo.io.j0.a;

/* loaded from: classes2.dex */
public class Engine implements j, c.a, m.a {
    private static final int JOB_POOL_SIZE = 150;
    private static final String TAG = "Engine";
    private static final boolean VERBOSE_IS_LOGGABLE = Log.isLoggable(TAG, 2);
    private final ActiveResources activeResources;
    private final external.sdk.pendo.io.glide.load.engine.cache.c cache;
    private final a decodeJobFactory;
    private final c diskCacheProvider;
    private final b engineJobFactory;
    private final o jobs;
    private final l keyFactory;
    private final t resourceRecycler;

    static class a {

        /* renamed from: a, reason: collision with root package name */
        final g.e f644a;
        final Pools.Pool<g<?>> b = sdk.pendo.io.j0.a.a(150, new C0057a());
        private int c;

        /* renamed from: external.sdk.pendo.io.glide.load.engine.Engine$a$a, reason: collision with other inner class name */
        class C0057a implements a.d<g<?>> {
            C0057a() {
            }

            @Override // sdk.pendo.io.j0.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public g<?> a() {
                a aVar = a.this;
                return new g<>(aVar.f644a, aVar.b);
            }
        }

        a(g.e eVar) {
            this.f644a = eVar;
        }

        <R> g<R> a(external.sdk.pendo.io.glide.b bVar, Object obj, k kVar, sdk.pendo.io.q.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.o.b bVar2, sdk.pendo.io.t.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, g.b<R> bVar3) {
            g gVar = (g) sdk.pendo.io.i0.j.a(this.b.acquire());
            int i3 = this.c;
            this.c = i3 + 1;
            return gVar.a(bVar, obj, kVar, fVar, i, i2, cls, cls2, bVar2, aVar, map, z, z2, z3, options, bVar3, i3);
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        final sdk.pendo.io.w.a f646a;
        final sdk.pendo.io.w.a b;
        final sdk.pendo.io.w.a c;
        final sdk.pendo.io.w.a d;
        final j e;
        final m.a f;
        final Pools.Pool<i<?>> g = sdk.pendo.io.j0.a.a(150, new a());

        class a implements a.d<i<?>> {
            a() {
            }

            @Override // sdk.pendo.io.j0.a.d
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public i<?> a() {
                b bVar = b.this;
                return new i<>(bVar.f646a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        b(sdk.pendo.io.w.a aVar, sdk.pendo.io.w.a aVar2, sdk.pendo.io.w.a aVar3, sdk.pendo.io.w.a aVar4, j jVar, m.a aVar5) {
            this.f646a = aVar;
            this.b = aVar2;
            this.c = aVar3;
            this.d = aVar4;
            this.e = jVar;
            this.f = aVar5;
        }

        <R> i<R> a(sdk.pendo.io.q.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((i) sdk.pendo.io.i0.j.a(this.g.acquire())).a(fVar, z, z2, z3, z4);
        }

        void a() {
            sdk.pendo.io.i0.e.a(this.f646a);
            sdk.pendo.io.i0.e.a(this.b);
            sdk.pendo.io.i0.e.a(this.c);
            sdk.pendo.io.i0.e.a(this.d);
        }
    }

    private static class c implements g.e {

        /* renamed from: a, reason: collision with root package name */
        private final a.InterfaceC0059a f648a;
        private volatile external.sdk.pendo.io.glide.load.engine.cache.a b;

        c(a.InterfaceC0059a interfaceC0059a) {
            this.f648a = interfaceC0059a;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.g.e
        public external.sdk.pendo.io.glide.load.engine.cache.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.f648a.build();
                    }
                    if (this.b == null) {
                        this.b = new DiskCacheAdapter();
                    }
                }
            }
            return this.b;
        }

        synchronized void b() {
            if (this.b == null) {
                return;
            }
            this.b.clear();
        }
    }

    public class d {

        /* renamed from: a, reason: collision with root package name */
        private final i<?> f649a;
        private final sdk.pendo.io.e0.c b;

        d(sdk.pendo.io.e0.c cVar, i<?> iVar) {
            this.b = cVar;
            this.f649a = iVar;
        }

        public void a() {
            synchronized (Engine.this) {
                this.f649a.c(this.b);
            }
        }
    }

    Engine(external.sdk.pendo.io.glide.load.engine.cache.c cVar, a.InterfaceC0059a interfaceC0059a, sdk.pendo.io.w.a aVar, sdk.pendo.io.w.a aVar2, sdk.pendo.io.w.a aVar3, sdk.pendo.io.w.a aVar4, o oVar, l lVar, ActiveResources activeResources, b bVar, a aVar5, t tVar, boolean z) {
        this.cache = cVar;
        c cVar2 = new c(interfaceC0059a);
        this.diskCacheProvider = cVar2;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.activeResources = activeResources2;
        activeResources2.a(this);
        this.keyFactory = lVar == null ? new l() : lVar;
        this.jobs = oVar == null ? new o() : oVar;
        this.engineJobFactory = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.decodeJobFactory = aVar5 == null ? new a(cVar2) : aVar5;
        this.resourceRecycler = tVar == null ? new t() : tVar;
        cVar.setResourceRemovedListener(this);
    }

    private m<?> getEngineResourceFromCache(sdk.pendo.io.q.f fVar) {
        sdk.pendo.io.t.c<?> remove = this.cache.remove(fVar);
        if (remove == null) {
            return null;
        }
        return remove instanceof m ? (m) remove : new m<>(remove, true, true, fVar, this);
    }

    private m<?> loadFromActiveResources(sdk.pendo.io.q.f fVar) {
        m<?> b2 = this.activeResources.b(fVar);
        if (b2 != null) {
            b2.a();
        }
        return b2;
    }

    private m<?> loadFromCache(sdk.pendo.io.q.f fVar) {
        m<?> engineResourceFromCache = getEngineResourceFromCache(fVar);
        if (engineResourceFromCache != null) {
            engineResourceFromCache.a();
            this.activeResources.a(fVar, engineResourceFromCache);
        }
        return engineResourceFromCache;
    }

    private m<?> loadFromMemory(k kVar, boolean z, long j) {
        if (!z) {
            return null;
        }
        m<?> loadFromActiveResources = loadFromActiveResources(kVar);
        if (loadFromActiveResources != null) {
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Loaded resource from active resources", j, kVar);
            }
            return loadFromActiveResources;
        }
        m<?> loadFromCache = loadFromCache(kVar);
        if (loadFromCache == null) {
            return null;
        }
        if (VERBOSE_IS_LOGGABLE) {
            logWithTimeAndKey("Loaded resource from cache", j, kVar);
        }
        return loadFromCache;
    }

    private static void logWithTimeAndKey(String str, long j, sdk.pendo.io.q.f fVar) {
        Log.v(TAG, str + " in " + sdk.pendo.io.i0.f.a(j) + "ms, key: " + fVar);
    }

    private <R> d waitForExistingOrStartNewJob(external.sdk.pendo.io.glide.b bVar, Object obj, sdk.pendo.io.q.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.o.b bVar2, sdk.pendo.io.t.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, sdk.pendo.io.e0.c cVar, Executor executor, k kVar, long j) {
        i<?> a2 = this.jobs.a(kVar, z6);
        if (a2 != null) {
            a2.a(cVar, executor);
            if (VERBOSE_IS_LOGGABLE) {
                logWithTimeAndKey("Added to existing load", j, kVar);
            }
            return new d(cVar, a2);
        }
        i<R> a3 = this.engineJobFactory.a(kVar, z3, z4, z5, z6);
        g<R> a4 = this.decodeJobFactory.a(bVar, obj, kVar, fVar, i, i2, cls, cls2, bVar2, aVar, map, z, z2, z6, options, a3);
        this.jobs.a((sdk.pendo.io.q.f) kVar, (i<?>) a3);
        a3.a(cVar, executor);
        a3.b(a4);
        if (VERBOSE_IS_LOGGABLE) {
            logWithTimeAndKey("Started new load", j, kVar);
        }
        return new d(cVar, a3);
    }

    public void clearDiskCache() {
        this.diskCacheProvider.a().clear();
    }

    public <R> d load(external.sdk.pendo.io.glide.b bVar, Object obj, sdk.pendo.io.q.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, sdk.pendo.io.o.b bVar2, sdk.pendo.io.t.a aVar, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, sdk.pendo.io.e0.c cVar, Executor executor) {
        long a2 = VERBOSE_IS_LOGGABLE ? sdk.pendo.io.i0.f.a() : 0L;
        k a3 = this.keyFactory.a(obj, fVar, i, i2, map, cls, cls2, options);
        synchronized (this) {
            m<?> loadFromMemory = loadFromMemory(a3, z3, a2);
            if (loadFromMemory == null) {
                return waitForExistingOrStartNewJob(bVar, obj, fVar, i, i2, cls, cls2, bVar2, aVar, map, z, z2, options, z3, z4, z5, z6, cVar, executor, a3, a2);
            }
            cVar.onResourceReady(loadFromMemory, sdk.pendo.io.q.a.MEMORY_CACHE, false);
            return null;
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.j
    public synchronized void onEngineJobCancelled(i<?> iVar, sdk.pendo.io.q.f fVar) {
        this.jobs.b(fVar, iVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.j
    public synchronized void onEngineJobComplete(i<?> iVar, sdk.pendo.io.q.f fVar, m<?> mVar) {
        if (mVar != null) {
            if (mVar.c()) {
                this.activeResources.a(fVar, mVar);
            }
        }
        this.jobs.b(fVar, iVar);
    }

    @Override // external.sdk.pendo.io.glide.load.engine.m.a
    public void onResourceReleased(sdk.pendo.io.q.f fVar, m<?> mVar) {
        this.activeResources.a(fVar);
        if (mVar.c()) {
            this.cache.put(fVar, mVar);
        } else {
            this.resourceRecycler.a(mVar, false);
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.c.a
    public void onResourceRemoved(sdk.pendo.io.t.c<?> cVar) {
        this.resourceRecycler.a(cVar, true);
    }

    public void release(sdk.pendo.io.t.c<?> cVar) {
        if (!(cVar instanceof m)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((m) cVar).d();
    }

    public void shutdown() {
        this.engineJobFactory.a();
        this.diskCacheProvider.b();
        this.activeResources.b();
    }

    public Engine(external.sdk.pendo.io.glide.load.engine.cache.c cVar, a.InterfaceC0059a interfaceC0059a, sdk.pendo.io.w.a aVar, sdk.pendo.io.w.a aVar2, sdk.pendo.io.w.a aVar3, sdk.pendo.io.w.a aVar4, boolean z) {
        this(cVar, interfaceC0059a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }
}
