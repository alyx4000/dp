package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.common.disk.DiskTrimmable;
import java.io.IOException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface FileCache extends DiskTrimmable {
    void clearAll();

    long clearOldEntries(long j);

    long getCount();

    DiskStorage.DiskDumpInfo getDumpInfo() throws IOException;

    @Nullable
    BinaryResource getResource(CacheKey cacheKey);

    long getSize();

    boolean hasKey(CacheKey cacheKey);

    boolean hasKeySync(CacheKey cacheKey);

    @Nullable
    BinaryResource insert(CacheKey cacheKey, WriterCallback writerCallback) throws IOException;

    boolean isEnabled();

    boolean probe(CacheKey cacheKey);

    void remove(CacheKey cacheKey);
}
