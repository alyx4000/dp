package sdk.pendo.io.i0;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class g<T, Y> {
    private final Map<T, a<Y>> cache = new LinkedHashMap(100, 0.75f, true);
    private long currentSize;
    private final long initialMaxSize;
    private long maxSize;

    static final class a<Y> {

        /* renamed from: a, reason: collision with root package name */
        final Y f1175a;
        final int b;

        a(Y y, int i) {
            this.f1175a = y;
            this.b = i;
        }
    }

    public g(long j) {
        this.initialMaxSize = j;
        this.maxSize = j;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0L);
    }

    public synchronized boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    public synchronized Y get(T t) {
        a<Y> aVar;
        aVar = this.cache.get(t);
        return aVar != null ? aVar.f1175a : null;
    }

    protected synchronized int getCount() {
        return this.cache.size();
    }

    public synchronized long getCurrentSize() {
        return this.currentSize;
    }

    public synchronized long getMaxSize() {
        return this.maxSize;
    }

    protected int getSize(Y y) {
        return 1;
    }

    protected void onItemEvicted(T t, Y y) {
    }

    public synchronized Y put(T t, Y y) {
        int size = getSize(y);
        long j = size;
        if (j >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        if (y != null) {
            this.currentSize += j;
        }
        a<Y> put = this.cache.put(t, y == null ? null : new a<>(y, size));
        if (put != null) {
            this.currentSize -= put.b;
            if (!put.f1175a.equals(y)) {
                onItemEvicted(t, put.f1175a);
            }
        }
        evict();
        return put != null ? put.f1175a : null;
    }

    public synchronized Y remove(T t) {
        a<Y> remove = this.cache.remove(t);
        if (remove == null) {
            return null;
        }
        this.currentSize -= remove.b;
        return remove.f1175a;
    }

    public synchronized void setSizeMultiplier(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f);
        evict();
    }

    protected synchronized void trimToSize(long j) {
        while (this.currentSize > j) {
            Iterator<Map.Entry<T, a<Y>>> it = this.cache.entrySet().iterator();
            Map.Entry<T, a<Y>> next = it.next();
            a<Y> value = next.getValue();
            this.currentSize -= value.b;
            T key = next.getKey();
            it.remove();
            onItemEvicted(key, value.f1175a);
        }
    }
}
