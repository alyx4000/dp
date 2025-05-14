package external.sdk.pendo.io.glide.load.engine.cache;

import android.util.Log;
import external.sdk.pendo.io.glide.load.engine.cache.a;
import java.io.File;
import java.io.IOException;
import sdk.pendo.io.p.a;
import sdk.pendo.io.q.f;

/* loaded from: classes2.dex */
public class DiskLruCacheWrapper implements a {
    private static final int APP_VERSION = 1;
    private static final String TAG = "DiskLruCacheWrapper";
    private static final int VALUE_COUNT = 1;
    private static DiskLruCacheWrapper wrapper;
    private final File directory;
    private sdk.pendo.io.p.a diskLruCache;
    private final long maxSize;
    private final b writeLocker = new b();
    private final sdk.pendo.io.v.b safeKeyGenerator = new sdk.pendo.io.v.b();

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j) {
        this.directory = file;
        this.maxSize = j;
    }

    public static a create(File file, long j) {
        return new DiskLruCacheWrapper(file, j);
    }

    @Deprecated
    public static synchronized a get(File file, long j) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            if (wrapper == null) {
                wrapper = new DiskLruCacheWrapper(file, j);
            }
            diskLruCacheWrapper = wrapper;
        }
        return diskLruCacheWrapper;
    }

    private synchronized sdk.pendo.io.p.a getDiskCache() {
        if (this.diskLruCache == null) {
            this.diskLruCache = sdk.pendo.io.p.a.a(this.directory, 1, 1, this.maxSize);
        }
        return this.diskLruCache;
    }

    private synchronized void resetDiskCache() {
        this.diskLruCache = null;
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public synchronized void clear() {
        try {
            try {
                getDiskCache().b();
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to clear disk cache or disk cache cleared externally", e);
                }
            }
        } finally {
            resetDiskCache();
        }
    }

    public void delete(f fVar) {
        try {
            getDiskCache().e(this.safeKeyGenerator.b(fVar));
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to delete from disk cache", e);
            }
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public void put(f fVar, a.b bVar) {
        String b = this.safeKeyGenerator.b(fVar);
        this.writeLocker.a(b);
        try {
            if (Log.isLoggable(TAG, 2)) {
                Log.v(TAG, "Put: Obtained: " + b + " for for Key: " + fVar);
            }
            try {
                sdk.pendo.io.p.a diskCache = getDiskCache();
                if (diskCache.c(b) == null) {
                    a.c b2 = diskCache.b(b);
                    if (b2 == null) {
                        throw new IllegalStateException("Had two simultaneous puts for: " + b);
                    }
                    try {
                        if (bVar.a(b2.a(0))) {
                            b2.c();
                        }
                        b2.b();
                    } catch (Throwable th) {
                        b2.b();
                        throw th;
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.writeLocker.b(b);
        }
    }

    @Override // external.sdk.pendo.io.glide.load.engine.cache.a
    public File get(f fVar) {
        String b = this.safeKeyGenerator.b(fVar);
        if (Log.isLoggable(TAG, 2)) {
            Log.v(TAG, "Get: Obtained: " + b + " for for Key: " + fVar);
        }
        try {
            a.e c = getDiskCache().c(b);
            if (c != null) {
                return c.a(0);
            }
        } catch (IOException e) {
            if (Log.isLoggable(TAG, 5)) {
                Log.w(TAG, "Unable to get from disk cache", e);
            }
        }
        return null;
    }
}
