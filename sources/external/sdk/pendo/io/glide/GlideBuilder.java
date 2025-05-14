package external.sdk.pendo.io.glide;

import android.content.Context;
import androidx.collection.ArrayMap;
import external.sdk.pendo.io.glide.a;
import external.sdk.pendo.io.glide.c;
import external.sdk.pendo.io.glide.load.engine.Engine;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.LruArrayPool;
import external.sdk.pendo.io.glide.load.engine.bitmap_recycle.LruBitmapPool;
import external.sdk.pendo.io.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import external.sdk.pendo.io.glide.load.engine.cache.LruResourceCache;
import external.sdk.pendo.io.glide.load.engine.cache.a;
import external.sdk.pendo.io.glide.manager.DefaultConnectivityMonitorFactory;
import external.sdk.pendo.io.glide.request.RequestOptions;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import sdk.pendo.io.c0.k;
import sdk.pendo.io.v.a;

/* loaded from: classes2.dex */
public final class GlideBuilder {
    private Engine c;
    private sdk.pendo.io.u.b d;
    private sdk.pendo.io.u.a e;
    private external.sdk.pendo.io.glide.load.engine.cache.c f;
    private sdk.pendo.io.w.a g;
    private sdk.pendo.io.w.a h;
    private a.InterfaceC0059a i;
    private sdk.pendo.io.v.a j;
    private external.sdk.pendo.io.glide.manager.a k;
    private k.b n;
    private sdk.pendo.io.w.a o;
    private boolean p;
    private List<sdk.pendo.io.e0.b<Object>> q;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, d<?, ?>> f619a = new ArrayMap();
    private final c.a b = new c.a();
    private int l = 4;
    private a.InterfaceC0052a m = new a();

    public static final class LogRequestOrigins {
    }

    public static final class WaitForFramesAfterTrimMemory {
        private WaitForFramesAfterTrimMemory() {
        }
    }

    class a implements a.InterfaceC0052a {
        a() {
        }

        @Override // external.sdk.pendo.io.glide.a.InterfaceC0052a
        public RequestOptions build() {
            return new RequestOptions();
        }
    }

    static final class b {
        b() {
        }
    }

    external.sdk.pendo.io.glide.a a(Context context) {
        if (this.g == null) {
            this.g = sdk.pendo.io.w.a.g();
        }
        if (this.h == null) {
            this.h = sdk.pendo.io.w.a.e();
        }
        if (this.o == null) {
            this.o = sdk.pendo.io.w.a.c();
        }
        if (this.j == null) {
            this.j = new a.C0245a(context).a();
        }
        if (this.k == null) {
            this.k = new DefaultConnectivityMonitorFactory();
        }
        if (this.d == null) {
            int b2 = this.j.b();
            if (b2 > 0) {
                this.d = new LruBitmapPool(b2);
            } else {
                this.d = new BitmapPoolAdapter();
            }
        }
        if (this.e == null) {
            this.e = new LruArrayPool(this.j.a());
        }
        if (this.f == null) {
            this.f = new LruResourceCache(this.j.c());
        }
        if (this.i == null) {
            this.i = new InternalCacheDiskCacheFactory(context);
        }
        if (this.c == null) {
            this.c = new Engine(this.f, this.i, this.h, this.g, sdk.pendo.io.w.a.h(), this.o, this.p);
        }
        List<sdk.pendo.io.e0.b<Object>> list = this.q;
        this.q = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        c a2 = this.b.a();
        return new external.sdk.pendo.io.glide.a(context, this.c, this.f, this.d, this.e, new k(this.n, a2), this.k, this.l, this.m, this.f619a, this.q, a2);
    }

    void a(k.b bVar) {
        this.n = bVar;
    }
}
