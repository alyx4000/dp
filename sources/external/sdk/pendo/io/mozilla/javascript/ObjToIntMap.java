package external.sdk.pendo.io.mozilla.javascript;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ObjToIntMap implements Serializable {
    private static final int A = -1640531527;
    private static final Object DELETED = new Object();
    private static final boolean check = false;
    private static final long serialVersionUID = -1542220580748809402L;
    private int keyCount;
    private transient Object[] keys;
    private transient int occupiedCount;
    private int power;
    private transient int[] values;

    public static class Iterator {
        private int cursor;
        private Object[] keys;
        ObjToIntMap master;
        private int remaining;
        private int[] values;

        Iterator(ObjToIntMap objToIntMap) {
            this.master = objToIntMap;
        }

        public boolean done() {
            return this.remaining < 0;
        }

        public Object getKey() {
            Object obj = this.keys[this.cursor];
            if (obj == UniqueTag.NULL_VALUE) {
                return null;
            }
            return obj;
        }

        public int getValue() {
            return this.values[this.cursor];
        }

        final void init(Object[] objArr, int[] iArr, int i) {
            this.keys = objArr;
            this.values = iArr;
            this.cursor = -1;
            this.remaining = i;
        }

        public void next() {
            if (this.remaining == -1) {
                Kit.codeBug();
            }
            if (this.remaining == 0) {
                this.remaining = -1;
                this.cursor = -1;
                return;
            }
            while (true) {
                int i = this.cursor + 1;
                this.cursor = i;
                Object obj = this.keys[i];
                if (obj != null && obj != ObjToIntMap.DELETED) {
                    this.remaining--;
                    return;
                }
            }
        }

        public void setValue(int i) {
            this.values[this.cursor] = i;
        }

        public void start() {
            this.master.initIterator(this);
            next();
        }
    }

    public ObjToIntMap() {
        this(4);
    }

    private int ensureIndex(Object obj) {
        int i;
        int hashCode = obj.hashCode();
        Object[] objArr = this.keys;
        if (objArr != null) {
            int i2 = A * hashCode;
            int i3 = this.power;
            int i4 = i2 >>> (32 - i3);
            Object obj2 = objArr[i4];
            if (obj2 != null) {
                int i5 = 1 << i3;
                if (obj2 != obj && (this.values[i5 + i4] != hashCode || !obj2.equals(obj))) {
                    r3 = obj2 == DELETED ? i4 : -1;
                    int i6 = i5 - 1;
                    int tableLookupStep = tableLookupStep(i2, i6, this.power);
                    while (true) {
                        i4 = (i4 + tableLookupStep) & i6;
                        Object obj3 = this.keys[i4];
                        if (obj3 != null) {
                            if (obj3 == obj || (this.values[i5 + i4] == hashCode && obj3.equals(obj))) {
                                break;
                            }
                            if (obj3 == DELETED && r3 < 0) {
                                r3 = i4;
                            }
                        } else {
                            break;
                        }
                    }
                }
                return i4;
            }
            r3 = r3;
            i = i4;
        } else {
            i = -1;
        }
        if (r3 < 0) {
            if (this.keys != null) {
                int i7 = this.occupiedCount;
                if (i7 * 4 < (1 << this.power) * 3) {
                    this.occupiedCount = i7 + 1;
                    r3 = i;
                }
            }
            rehashTable();
            return insertNewKey(obj, hashCode);
        }
        this.keys[r3] = obj;
        this.values[(1 << this.power) + r3] = hashCode;
        this.keyCount++;
        return r3;
    }

    private int findIndex(Object obj) {
        if (this.keys == null) {
            return -1;
        }
        int hashCode = obj.hashCode();
        int i = A * hashCode;
        int i2 = this.power;
        int i3 = i >>> (32 - i2);
        Object obj2 = this.keys[i3];
        if (obj2 == null) {
            return -1;
        }
        int i4 = 1 << i2;
        if (obj2 != obj && (this.values[i4 + i3] != hashCode || !obj2.equals(obj))) {
            int i5 = i4 - 1;
            int tableLookupStep = tableLookupStep(i, i5, this.power);
            while (true) {
                i3 = (i3 + tableLookupStep) & i5;
                Object obj3 = this.keys[i3];
                if (obj3 != null) {
                    if (obj3 == obj || (this.values[i4 + i3] == hashCode && obj3.equals(obj))) {
                        break;
                    }
                } else {
                    return -1;
                }
            }
        }
        return i3;
    }

    private int insertNewKey(Object obj, int i) {
        int i2 = A * i;
        int i3 = this.power;
        int i4 = i2 >>> (32 - i3);
        int i5 = 1 << i3;
        if (this.keys[i4] != null) {
            int i6 = i5 - 1;
            int tableLookupStep = tableLookupStep(i2, i6, i3);
            do {
                i4 = (i4 + tableLookupStep) & i6;
            } while (this.keys[i4] != null);
        }
        this.keys[i4] = obj;
        this.values[i5 + i4] = i;
        this.occupiedCount++;
        this.keyCount++;
        return i4;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int i = this.keyCount;
        if (i != 0) {
            this.keyCount = 0;
            int i2 = 1 << this.power;
            this.keys = new Object[i2];
            this.values = new int[i2 * 2];
            for (int i3 = 0; i3 != i; i3++) {
                Object readObject = objectInputStream.readObject();
                this.values[insertNewKey(readObject, readObject.hashCode())] = objectInputStream.readInt();
            }
        }
    }

    private void rehashTable() {
        Object[] objArr = this.keys;
        if (objArr == null) {
            int i = 1 << this.power;
            this.keys = new Object[i];
            this.values = new int[i * 2];
            return;
        }
        int i2 = this.keyCount;
        if (i2 * 2 >= this.occupiedCount) {
            this.power++;
        }
        int i3 = 1 << this.power;
        int[] iArr = this.values;
        int length = objArr.length;
        this.keys = new Object[i3];
        this.values = new int[i3 * 2];
        int i4 = 0;
        this.keyCount = 0;
        this.occupiedCount = 0;
        while (i2 != 0) {
            Object obj = objArr[i4];
            if (obj != null && obj != DELETED) {
                this.values[insertNewKey(obj, iArr[length + i4])] = iArr[i4];
                i2--;
            }
            i4++;
        }
    }

    private static int tableLookupStep(int i, int i2, int i3) {
        int i4 = 32 - (i3 * 2);
        if (i4 >= 0) {
            i >>>= i4;
        } else {
            i2 >>>= -i4;
        }
        return (i & i2) | 1;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int i = this.keyCount;
        int i2 = 0;
        while (i != 0) {
            Object obj = this.keys[i2];
            if (obj != null && obj != DELETED) {
                i--;
                objectOutputStream.writeObject(obj);
                objectOutputStream.writeInt(this.values[i2]);
            }
            i2++;
        }
    }

    public void clear() {
        int length = this.keys.length;
        while (length != 0) {
            length--;
            this.keys[length] = null;
        }
        this.keyCount = 0;
        this.occupiedCount = 0;
    }

    public int get(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        return findIndex >= 0 ? this.values[findIndex] : i;
    }

    public int getExisting(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        if (findIndex >= 0) {
            return this.values[findIndex];
        }
        Kit.codeBug();
        return 0;
    }

    public void getKeys(Object[] objArr, int i) {
        int i2 = this.keyCount;
        int i3 = 0;
        while (i2 != 0) {
            Object obj = this.keys[i3];
            if (obj != null && obj != DELETED) {
                if (obj == UniqueTag.NULL_VALUE) {
                    obj = null;
                }
                objArr[i] = obj;
                i++;
                i2--;
            }
            i3++;
        }
    }

    public boolean has(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        return findIndex(obj) >= 0;
    }

    final void initIterator(Iterator iterator) {
        iterator.init(this.keys, this.values, this.keyCount);
    }

    public Object intern(Object obj) {
        boolean z;
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
            z = true;
        } else {
            z = false;
        }
        int ensureIndex = ensureIndex(obj);
        this.values[ensureIndex] = 0;
        if (z) {
            return null;
        }
        return this.keys[ensureIndex];
    }

    public boolean isEmpty() {
        return this.keyCount == 0;
    }

    public Iterator newIterator() {
        return new Iterator(this);
    }

    public void put(Object obj, int i) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        this.values[ensureIndex(obj)] = i;
    }

    public void remove(Object obj) {
        if (obj == null) {
            obj = UniqueTag.NULL_VALUE;
        }
        int findIndex = findIndex(obj);
        if (findIndex >= 0) {
            this.keys[findIndex] = DELETED;
            this.keyCount--;
        }
    }

    public int size() {
        return this.keyCount;
    }

    public ObjToIntMap(int i) {
        if (i < 0) {
            Kit.codeBug();
        }
        int i2 = 2;
        while ((1 << i2) < (i * 4) / 3) {
            i2++;
        }
        this.power = i2;
    }

    public Object[] getKeys() {
        Object[] objArr = new Object[this.keyCount];
        getKeys(objArr, 0);
        return objArr;
    }
}
