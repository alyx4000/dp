package io.branch.rnbranch;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class AgingHash<KeyType, ValueType> {
    private HashMap<KeyType, AgingItem<ValueType>> mHash = new HashMap<>();
    private long mTtlMillis;

    public AgingHash(long j) {
        this.mTtlMillis = j;
    }

    public long getTtlMillis() {
        return this.mTtlMillis;
    }

    public void put(KeyType keytype, ValueType valuetype) {
        ageItems();
        this.mHash.put(keytype, new AgingItem<>(valuetype));
    }

    public ValueType get(KeyType keytype) {
        AgingItem<ValueType> agingItem = this.mHash.get(keytype);
        if (agingItem == null) {
            return null;
        }
        return agingItem.get();
    }

    public void remove(KeyType keytype) {
        this.mHash.remove(keytype);
    }

    private void ageItems() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<KeyType, AgingItem<ValueType>>> it = this.mHash.entrySet().iterator();
        while (it.hasNext()) {
            if (currentTimeMillis - it.next().getValue().getAccessTime() >= this.mTtlMillis) {
                it.remove();
            }
        }
    }
}
