package io.branch.rnbranch;

/* loaded from: classes2.dex */
public class AgingItem<ValueType> {
    private long mAccessTime = System.currentTimeMillis();
    private ValueType mItem;

    public AgingItem(ValueType valuetype) {
        this.mItem = valuetype;
    }

    public ValueType get() {
        this.mAccessTime = System.currentTimeMillis();
        return this.mItem;
    }

    public long getAccessTime() {
        return this.mAccessTime;
    }
}
