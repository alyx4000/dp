package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.WriterCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public interface DiskStorage {

    public static class DiskDumpInfo {
        public List<DiskDumpInfoEntry> entries = new ArrayList();
        public Map<String, Integer> typeCounts = new HashMap();
    }

    public interface Entry {
        String getId();

        BinaryResource getResource();

        long getSize();

        long getTimestamp();
    }

    public interface Inserter {
        boolean cleanUp();

        BinaryResource commit(Object obj) throws IOException;

        BinaryResource commit(Object obj, long j) throws IOException;

        void writeData(WriterCallback writerCallback, Object obj) throws IOException;
    }

    void clearAll() throws IOException;

    boolean contains(String str, Object obj) throws IOException;

    DiskDumpInfo getDumpInfo() throws IOException;

    Collection<Entry> getEntries() throws IOException;

    @Nullable
    BinaryResource getResource(String str, Object obj) throws IOException;

    String getStorageName();

    Inserter insert(String str, Object obj) throws IOException;

    boolean isEnabled();

    boolean isExternal();

    void purgeUnexpectedResources();

    long remove(Entry entry) throws IOException;

    long remove(String str) throws IOException;

    boolean touch(String str, Object obj) throws IOException;

    public static class DiskDumpInfoEntry {
        public final String firstBits;
        public final String id;
        public final String path;
        public final float size;
        public final String type;

        protected DiskDumpInfoEntry(String str, String str2, String str3, float f, String str4) {
            this.id = str;
            this.path = str2;
            this.type = str3;
            this.size = f;
            this.firstBits = str4;
        }
    }
}
