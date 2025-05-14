package external.sdk.pendo.io.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes2.dex */
public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {

    class a implements DiskLruCacheFactory.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f661a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.f661a = context;
            this.b = str;
        }

        private File b() {
            File cacheDir = this.f661a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            File externalCacheDir;
            File b = b();
            return ((b == null || !b.exists()) && (externalCacheDir = this.f661a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir : b;
        }
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, 262144000L);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, j);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, String str, long j) {
        super(new a(context, str), j);
    }
}
