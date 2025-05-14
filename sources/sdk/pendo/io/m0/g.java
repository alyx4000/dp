package sdk.pendo.io.m0;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes6.dex */
public final class g<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> w0 = new a();
    static final /* synthetic */ boolean x0 = true;
    int A;
    Comparator<? super K> f;
    int f0;
    e<K, V> s;
    final e<K, V> t0;
    private g<K, V>.b u0;
    private g<K, V>.c v0;

    class a implements Comparator<Comparable> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    }

    class b extends AbstractSet<Map.Entry<K, V>> {

        class a extends g<K, V>.d<Map.Entry<K, V>> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                return a();
            }
        }

        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && g.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            e<K, V> a2;
            if (!(obj instanceof Map.Entry) || (a2 = g.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            g.this.b(a2, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.A;
        }
    }

    final class c extends AbstractSet<K> {

        class a extends g<K, V>.d<K> {
            a() {
                super();
            }

            @Override // java.util.Iterator
            public K next() {
                return a().u0;
            }
        }

        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return g.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g.this.A;
        }
    }

    private abstract class d<T> implements Iterator<T> {
        int A;
        e<K, V> f;
        e<K, V> s = null;

        d() {
            this.f = g.this.t0.f0;
            this.A = g.this.f0;
        }

        final e<K, V> a() {
            e<K, V> eVar = this.f;
            g gVar = g.this;
            if (eVar == gVar.t0) {
                throw new NoSuchElementException();
            }
            if (gVar.f0 != this.A) {
                throw new ConcurrentModificationException();
            }
            this.f = eVar.f0;
            this.s = eVar;
            return eVar;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f != g.this.t0;
        }

        @Override // java.util.Iterator
        public final void remove() {
            e<K, V> eVar = this.s;
            if (eVar == null) {
                throw new IllegalStateException();
            }
            g.this.b(eVar, true);
            this.s = null;
            this.A = g.this.f0;
        }
    }

    static final class e<K, V> implements Map.Entry<K, V> {
        e<K, V> A;
        e<K, V> f;
        e<K, V> f0;
        e<K, V> s;
        e<K, V> t0;
        final K u0;
        V v0;
        int w0;

        e() {
            this.u0 = null;
            this.t0 = this;
            this.f0 = this;
        }

        public e<K, V> a() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.s; eVar2 != null; eVar2 = eVar2.s) {
                eVar = eVar2;
            }
            return eVar;
        }

        public e<K, V> b() {
            e<K, V> eVar = this;
            for (e<K, V> eVar2 = this.A; eVar2 != null; eVar2 = eVar2.A) {
                eVar = eVar2;
            }
            return eVar;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.u0;
            if (k == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k.equals(entry.getKey())) {
                return false;
            }
            V v = this.v0;
            Object value = entry.getValue();
            if (v == null) {
                if (value != null) {
                    return false;
                }
            } else if (!v.equals(value)) {
                return false;
            }
            return true;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.u0;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.v0;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.u0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.v0;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.v0;
            this.v0 = v;
            return v2;
        }

        public String toString() {
            return this.u0 + "=" + this.v0;
        }

        e(e<K, V> eVar, K k, e<K, V> eVar2, e<K, V> eVar3) {
            this.f = eVar;
            this.u0 = k;
            this.w0 = 1;
            this.f0 = eVar2;
            this.t0 = eVar3;
            eVar3.f0 = this;
            eVar2.t0 = this;
        }
    }

    public g() {
        this(w0);
    }

    private boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    void b(e<K, V> eVar, boolean z) {
        int i;
        if (z) {
            e<K, V> eVar2 = eVar.t0;
            eVar2.f0 = eVar.f0;
            eVar.f0.t0 = eVar2;
        }
        e<K, V> eVar3 = eVar.s;
        e<K, V> eVar4 = eVar.A;
        e<K, V> eVar5 = eVar.f;
        int i2 = 0;
        if (eVar3 == null || eVar4 == null) {
            if (eVar3 != null) {
                a((e) eVar, (e) eVar3);
                eVar.s = null;
            } else if (eVar4 != null) {
                a((e) eVar, (e) eVar4);
                eVar.A = null;
            } else {
                a((e) eVar, (e) null);
            }
            a((e) eVar5, false);
            this.A--;
            this.f0++;
            return;
        }
        e<K, V> b2 = eVar3.w0 > eVar4.w0 ? eVar3.b() : eVar4.a();
        b(b2, false);
        e<K, V> eVar6 = eVar.s;
        if (eVar6 != null) {
            i = eVar6.w0;
            b2.s = eVar6;
            eVar6.f = b2;
            eVar.s = null;
        } else {
            i = 0;
        }
        e<K, V> eVar7 = eVar.A;
        if (eVar7 != null) {
            i2 = eVar7.w0;
            b2.A = eVar7;
            eVar7.f = b2;
            eVar.A = null;
        }
        b2.w0 = Math.max(i, i2) + 1;
        a((e) eVar, (e) b2);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.s = null;
        this.A = 0;
        this.f0++;
        e<K, V> eVar = this.t0;
        eVar.t0 = eVar;
        eVar.f0 = eVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        g<K, V>.b bVar = this.u0;
        if (bVar != null) {
            return bVar;
        }
        g<K, V>.b bVar2 = new b();
        this.u0 = bVar2;
        return bVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            return a2.v0;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        g<K, V>.c cVar = this.v0;
        if (cVar != null) {
            return cVar;
        }
        g<K, V>.c cVar2 = new c();
        this.v0 = cVar2;
        return cVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        e<K, V> a2 = a((g<K, V>) k, true);
        V v2 = a2.v0;
        a2.v0 = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        e<K, V> b2 = b(obj);
        if (b2 != null) {
            return b2.v0;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.A;
    }

    public g(Comparator<? super K> comparator) {
        this.A = 0;
        this.f0 = 0;
        this.t0 = new e<>();
        this.f = comparator == null ? w0 : comparator;
    }

    e<K, V> a(K k, boolean z) {
        int i;
        e<K, V> eVar;
        Comparator<? super K> comparator = this.f;
        e<K, V> eVar2 = this.s;
        if (eVar2 != null) {
            Comparable comparable = comparator == w0 ? (Comparable) k : null;
            while (true) {
                K k2 = eVar2.u0;
                i = comparable != null ? comparable.compareTo(k2) : comparator.compare(k, k2);
                if (i == 0) {
                    return eVar2;
                }
                e<K, V> eVar3 = i < 0 ? eVar2.s : eVar2.A;
                if (eVar3 == null) {
                    break;
                }
                eVar2 = eVar3;
            }
        } else {
            i = 0;
        }
        if (!z) {
            return null;
        }
        e<K, V> eVar4 = this.t0;
        if (eVar2 != null) {
            eVar = new e<>(eVar2, k, eVar4, eVar4.t0);
            if (i < 0) {
                eVar2.s = eVar;
            } else {
                eVar2.A = eVar;
            }
            a((e) eVar2, true);
        } else {
            if (comparator == w0 && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            eVar = new e<>(eVar2, k, eVar4, eVar4.t0);
            this.s = eVar;
        }
        this.A++;
        this.f0++;
        return eVar;
    }

    e<K, V> b(Object obj) {
        e<K, V> a2 = a(obj);
        if (a2 != null) {
            b(a2, true);
        }
        return a2;
    }

    private void b(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.s;
        e<K, V> eVar3 = eVar.A;
        e<K, V> eVar4 = eVar2.s;
        e<K, V> eVar5 = eVar2.A;
        eVar.s = eVar5;
        if (eVar5 != null) {
            eVar5.f = eVar;
        }
        a((e) eVar, (e) eVar2);
        eVar2.A = eVar;
        eVar.f = eVar2;
        int max = Math.max(eVar3 != null ? eVar3.w0 : 0, eVar5 != null ? eVar5.w0 : 0) + 1;
        eVar.w0 = max;
        eVar2.w0 = Math.max(max, eVar4 != null ? eVar4.w0 : 0) + 1;
    }

    e<K, V> a(Map.Entry<?, ?> entry) {
        e<K, V> a2 = a(entry.getKey());
        if (a2 != null && a(a2.v0, entry.getValue())) {
            return a2;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    e<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a((g<K, V>) obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    private void a(e<K, V> eVar, boolean z) {
        while (eVar != null) {
            e<K, V> eVar2 = eVar.s;
            e<K, V> eVar3 = eVar.A;
            int i = eVar2 != null ? eVar2.w0 : 0;
            int i2 = eVar3 != null ? eVar3.w0 : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                e<K, V> eVar4 = eVar3.s;
                e<K, V> eVar5 = eVar3.A;
                int i4 = (eVar4 != null ? eVar4.w0 : 0) - (eVar5 != null ? eVar5.w0 : 0);
                if (i4 != -1 && (i4 != 0 || z)) {
                    if (!x0 && i4 != 1) {
                        throw new AssertionError();
                    }
                    b((e) eVar3);
                }
                a((e) eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                e<K, V> eVar6 = eVar2.s;
                e<K, V> eVar7 = eVar2.A;
                int i5 = (eVar6 != null ? eVar6.w0 : 0) - (eVar7 != null ? eVar7.w0 : 0);
                if (i5 != 1 && (i5 != 0 || z)) {
                    if (!x0 && i5 != -1) {
                        throw new AssertionError();
                    }
                    a((e) eVar2);
                }
                b((e) eVar);
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                eVar.w0 = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!x0 && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                eVar.w0 = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            eVar = eVar.f;
        }
    }

    private void a(e<K, V> eVar, e<K, V> eVar2) {
        e<K, V> eVar3 = eVar.f;
        eVar.f = null;
        if (eVar2 != null) {
            eVar2.f = eVar3;
        }
        if (eVar3 == null) {
            this.s = eVar2;
            return;
        }
        if (eVar3.s == eVar) {
            eVar3.s = eVar2;
        } else {
            if (!x0 && eVar3.A != eVar) {
                throw new AssertionError();
            }
            eVar3.A = eVar2;
        }
    }

    private void a(e<K, V> eVar) {
        e<K, V> eVar2 = eVar.s;
        e<K, V> eVar3 = eVar.A;
        e<K, V> eVar4 = eVar3.s;
        e<K, V> eVar5 = eVar3.A;
        eVar.A = eVar4;
        if (eVar4 != null) {
            eVar4.f = eVar;
        }
        a((e) eVar, (e) eVar3);
        eVar3.s = eVar;
        eVar.f = eVar3;
        int max = Math.max(eVar2 != null ? eVar2.w0 : 0, eVar4 != null ? eVar4.w0 : 0) + 1;
        eVar.w0 = max;
        eVar3.w0 = Math.max(max, eVar5 != null ? eVar5.w0 : 0) + 1;
    }
}
