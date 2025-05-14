package external.sdk.pendo.io.glide.load.engine.cache;

import external.sdk.pendo.io.glide.load.engine.cache.a;
import java.io.File;

/* loaded from: classes2.dex */
public class DiskLruCacheFactory implements a.InterfaceC0059a {
    private final c cacheDirectoryGetter;
    private final long diskCacheSize;

    class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f658a;

        a(String str) {
            this.f658a = str;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            return new File(this.f658a);
        }
    }

    class b implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f659a;
        final /* synthetic */ String b;

        b(String str, String str2) {
            this.f659a = str;
            this.b = str2;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            return new File(this.f659a, this.b);
        }
    }

    public interface c {
        File a();
    }

    public DiskLruCacheFactory(c cVar, long j) {
        this.diskCacheSize = j;
        this.cacheDirectoryGetter = cVar;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a.InterfaceC0059a
    public external.sdk.pendo.io.glide.load.engine.cache.a build() {
        File a2 = this.cacheDirectoryGetter.a();
        if (a2 == null) {
            return null;
        }
        if (a2.isDirectory() || a2.mkdirs()) {
            return DiskLruCacheWrapper.create(a2, this.diskCacheSize);
        }
        return null;
    }

    public DiskLruCacheFactory(String str, long j) {
        this(new a(str), j);
    }

    public DiskLruCacheFactory(String str, String str2, long j) {
        this(new b(str, str2), j);
    }
}
