package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.Hashtable;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public class Hashtable implements Serializable, Iterable<Entry> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long serialVersionUID = -7151554912419543747L;
    private final HashMap<Object, Entry> map = new HashMap<>();
    private Entry first = null;
    private Entry last = null;

    public static final class Entry implements Serializable {
        private static final long serialVersionUID = 4086572107122965503L;
        protected boolean deleted;
        private final int hashCode;
        protected Object key;
        protected Entry next;
        protected Entry prev;
        protected Object value;

        Entry() {
            this.hashCode = 0;
        }

        Object clear() {
            Object obj = this.value;
            Object obj2 = Undefined.instance;
            this.key = obj2;
            this.value = obj2;
            this.deleted = true;
            return obj;
        }

        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ScriptRuntime.sameZero(this.key, ((Entry) obj).key);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }

        public Object key() {
            return this.key;
        }

        public Object value() {
            return this.value;
        }

        Entry(Object obj, Object obj2) {
            Object obj3;
            if ((obj instanceof Number) && !(obj instanceof Double)) {
                obj3 = Double.valueOf(((Number) obj).doubleValue());
            } else {
                if (!(obj instanceof ConsString)) {
                    this.key = obj;
                    this.hashCode = (this.key == null || obj.equals(ScriptRuntime.negativeZeroObj)) ? 0 : this.key.hashCode();
                    this.value = obj2;
                }
                obj3 = obj.toString();
            }
            this.key = obj3;
            if (this.key == null) {
                this.hashCode = (this.key == null || obj.equals(ScriptRuntime.negativeZeroObj)) ? 0 : this.key.hashCode();
                this.value = obj2;
            }
            this.hashCode = (this.key == null || obj.equals(ScriptRuntime.negativeZeroObj)) ? 0 : this.key.hashCode();
            this.value = obj2;
        }
    }

    private static final class Iter implements Iterator<Entry> {
        private Entry pos;

        Iter(Entry entry) {
            Entry makeDummy = Hashtable.makeDummy();
            makeDummy.next = entry;
            this.pos = makeDummy;
        }

        private void skipDeleted() {
            while (true) {
                Entry entry = this.pos.next;
                if (entry == null || !entry.deleted) {
                    return;
                } else {
                    this.pos = entry;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            skipDeleted();
            Entry entry = this.pos;
            return (entry == null || entry.next == null) ? false : true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Entry next() {
            Entry entry;
            skipDeleted();
            Entry entry2 = this.pos;
            if (entry2 == null || (entry = entry2.next) == null) {
                throw new NoSuchElementException();
            }
            this.pos = entry;
            return entry;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Entry makeDummy() {
        Entry entry = new Entry();
        entry.clear();
        return entry;
    }

    public void clear() {
        iterator().forEachRemaining(new Consumer() { // from class: external.sdk.pendo.io.mozilla.javascript.Hashtable$$ExternalSyntheticLambda0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Hashtable.Entry) obj).clear();
            }
        });
        if (this.first != null) {
            Entry makeDummy = makeDummy();
            this.last.next = makeDummy;
            this.last = makeDummy;
            this.first = makeDummy;
        }
        this.map.clear();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
    
        if (r1 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object delete(java.lang.Object r4) {
        /*
            r3 = this;
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r0 = new external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry
            r1 = 0
            r0.<init>(r4, r1)
            java.util.HashMap<java.lang.Object, external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry> r4 = r3.map
            java.lang.Object r4 = r4.remove(r0)
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r4 = (external.sdk.pendo.io.mozilla.javascript.Hashtable.Entry) r4
            if (r4 != 0) goto L11
            return r1
        L11:
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r0 = r3.first
            if (r4 != r0) goto L2a
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r0 = r3.last
            if (r4 != r0) goto L1f
            r4.clear()
            r4.prev = r1
            goto L3b
        L1f:
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r0 = r4.next
            r3.first = r0
            r0.prev = r1
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r1 = r0.next
            if (r1 == 0) goto L3b
            goto L36
        L2a:
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r0 = r4.prev
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r2 = r4.next
            r0.next = r2
            r4.prev = r1
            external.sdk.pendo.io.mozilla.javascript.Hashtable$Entry r1 = r4.next
            if (r1 == 0) goto L39
        L36:
            r1.prev = r0
            goto L3b
        L39:
            r3.last = r0
        L3b:
            java.lang.Object r4 = r4.clear()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.Hashtable.delete(java.lang.Object):java.lang.Object");
    }

    public Object get(Object obj) {
        Entry entry = this.map.get(new Entry(obj, null));
        if (entry == null) {
            return null;
        }
        return entry.value;
    }

    public boolean has(Object obj) {
        return this.map.containsKey(new Entry(obj, null));
    }

    @Override // java.lang.Iterable
    public Iterator<Entry> iterator() {
        return new Iter(this.first);
    }

    public void put(Object obj, Object obj2) {
        Entry entry = new Entry(obj, obj2);
        Entry putIfAbsent = this.map.putIfAbsent(entry, entry);
        if (putIfAbsent != null) {
            putIfAbsent.value = obj2;
            return;
        }
        if (this.first == null) {
            this.last = entry;
            this.first = entry;
        } else {
            Entry entry2 = this.last;
            entry2.next = entry;
            entry.prev = entry2;
            this.last = entry;
        }
    }

    public int size() {
        return this.map.size();
    }
}
