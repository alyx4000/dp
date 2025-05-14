package sdk.pendo.io.f8;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes6.dex */
public final class a<K, V> extends AbstractMap<K, V> {
    private HashMap<K, a<K, V>.C0138a<V>> f;
    private ReferenceQueue<V> s;

    /* renamed from: sdk.pendo.io.f8.a$a, reason: collision with other inner class name */
    private class C0138a<T> extends WeakReference<T> {

        /* renamed from: a, reason: collision with root package name */
        private final K f1088a;

        private C0138a(K k, T t, ReferenceQueue<T> referenceQueue) {
            super(t, referenceQueue);
            this.f1088a = k;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public K a() {
            return this.f1088a;
        }
    }

    public a() {
        this(16);
    }

    private V a(a<K, V>.C0138a<V> c0138a) {
        if (c0138a == null) {
            return null;
        }
        return c0138a.get();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        a();
        return this.f.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        a();
        Iterator<Map.Entry<K, a<K, V>.C0138a<V>>> it = this.f.entrySet().iterator();
        while (it.hasNext()) {
            if (obj == a(it.next().getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        a();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry<K, a<K, V>.C0138a<V>> entry : this.f.entrySet()) {
            linkedHashSet.add(new AbstractMap.SimpleEntry(entry.getKey(), a(entry.getValue())));
        }
        return linkedHashSet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        a();
        return a(this.f.get(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        a();
        return this.f.keySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        a();
        return a(this.f.put(k, new C0138a<>(k, v, this.s)));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return a(this.f.remove(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        a();
        return this.f.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        a();
        ArrayList arrayList = new ArrayList();
        Iterator<a<K, V>.C0138a<V>> it = this.f.values().iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    public a(int i) {
        this.f = new HashMap<>(i);
        this.s = new ReferenceQueue<>();
    }

    private void a() {
        while (true) {
            C0138a c0138a = (C0138a) this.s.poll();
            if (c0138a == null) {
                return;
            } else {
                this.f.remove(c0138a.a());
            }
        }
    }
}
