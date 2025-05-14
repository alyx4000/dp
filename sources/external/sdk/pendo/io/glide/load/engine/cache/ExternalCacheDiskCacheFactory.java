package external.sdk.pendo.io.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
/* loaded from: classes2.dex */
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    class a implements DiskLruCacheFactory.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f660a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.f660a = context;
            this.b = str;
        }

        @Override // external.sdk.pendo.io.glide.load.engine.cache.DiskLruCacheFactory.c
        public File a() {
            File externalCacheDir = this.f660a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, DiskCache.Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i) {
        super(new a(context, str), i);
    }
}
