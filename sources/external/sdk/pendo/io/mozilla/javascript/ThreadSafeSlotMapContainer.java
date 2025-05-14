package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import java.util.Iterator;
import java.util.concurrent.locks.StampedLock;

/* loaded from: classes2.dex */
class ThreadSafeSlotMapContainer extends SlotMapContainer {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final StampedLock lock;

    ThreadSafeSlotMapContainer(int i) {
        super(i);
        this.lock = new StampedLock();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer, external.sdk.pendo.io.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        long writeLock = this.lock.writeLock();
        try {
            checkMapSize();
            this.map.addSlot(slot);
        } finally {
            this.lock.unlockWrite(writeLock);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer
    protected void checkMapSize() {
        super.checkMapSize();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer
    public int dirtySize() {
        return this.map.size();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer, external.sdk.pendo.io.mozilla.javascript.SlotMap
    public ScriptableObject.Slot get(Object obj, int i, ScriptableObject.SlotAccess slotAccess) {
        long writeLock = this.lock.writeLock();
        try {
            if (slotAccess != ScriptableObject.SlotAccess.QUERY) {
                checkMapSize();
            }
            return this.map.get(obj, i, slotAccess);
        } finally {
            this.lock.unlockWrite(writeLock);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer, external.sdk.pendo.io.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        long tryOptimisticRead = this.lock.tryOptimisticRead();
        boolean isEmpty = this.map.isEmpty();
        if (this.lock.validate(tryOptimisticRead)) {
            return isEmpty;
        }
        long readLock = this.lock.readLock();
        try {
            return this.map.isEmpty();
        } finally {
            this.lock.unlockRead(readLock);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer, java.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return this.map.iterator();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer, external.sdk.pendo.io.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i) {
        long tryOptimisticRead = this.lock.tryOptimisticRead();
        ScriptableObject.Slot query = this.map.query(obj, i);
        if (this.lock.validate(tryOptimisticRead)) {
            return query;
        }
        long readLock = this.lock.readLock();
        try {
            return this.map.query(obj, i);
        } finally {
            this.lock.unlockRead(readLock);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer
    public long readLock() {
        return this.lock.readLock();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer, external.sdk.pendo.io.mozilla.javascript.SlotMap
    public void remove(Object obj, int i) {
        long writeLock = this.lock.writeLock();
        try {
            this.map.remove(obj, i);
        } finally {
            this.lock.unlockWrite(writeLock);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer, external.sdk.pendo.io.mozilla.javascript.SlotMap
    public int size() {
        long tryOptimisticRead = this.lock.tryOptimisticRead();
        int size = this.map.size();
        if (this.lock.validate(tryOptimisticRead)) {
            return size;
        }
        long readLock = this.lock.readLock();
        try {
            return this.map.size();
        } finally {
            this.lock.unlockRead(readLock);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMapContainer
    public void unlockRead(long j) {
        this.lock.unlockRead(j);
    }
}
