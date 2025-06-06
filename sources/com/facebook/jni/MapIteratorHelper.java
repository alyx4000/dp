package com.facebook.jni;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public class MapIteratorHelper {
    private final Iterator<Map.Entry> mIterator;

    @Nullable
    private Object mKey;

    @Nullable
    private Object mValue;

    public MapIteratorHelper(Map map) {
        this.mIterator = map.entrySet().iterator();
    }

    boolean hasNext() {
        if (this.mIterator.hasNext()) {
            Map.Entry next = this.mIterator.next();
            this.mKey = next.getKey();
            this.mValue = next.getValue();
            return true;
        }
        this.mKey = null;
        this.mValue = null;
        return false;
    }
}
