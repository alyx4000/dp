package external.sdk.pendo.io.mozilla.javascript;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public class ObjArray implements Serializable {
    private static final int FIELDS_STORE_SIZE = 5;
    private static final long serialVersionUID = 4174889037736658296L;
    private transient Object[] data;
    private transient Object f0;
    private transient Object f1;
    private transient Object f2;
    private transient Object f3;
    private transient Object f4;
    private boolean sealed;
    private int size;

    private void ensureCapacity(int i) {
        int i2 = i - 5;
        if (i2 <= 0) {
            throw new IllegalArgumentException();
        }
        Object[] objArr = this.data;
        if (objArr == null) {
            if (10 >= i2) {
                i2 = 10;
            }
            this.data = new Object[i2];
            return;
        }
        int length = objArr.length;
        if (length < i2) {
            int i3 = length > 5 ? length * 2 : 10;
            if (i3 >= i2) {
                i2 = i3;
            }
            Object[] objArr2 = new Object[i2];
            int i4 = this.size;
            if (i4 > 5) {
                System.arraycopy(objArr, 0, objArr2, 0, i4 - 5);
            }
            this.data = objArr2;
        }
    }

    private Object getImpl(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? this.data[i - 5] : this.f4 : this.f3 : this.f2 : this.f1 : this.f0;
    }

    private static RuntimeException onEmptyStackTopRead() {
        throw new RuntimeException("Empty stack");
    }

    private static RuntimeException onInvalidIndex(int i, int i2) {
        throw new IndexOutOfBoundsException(i + " ∉ [0, " + i2 + ')');
    }

    private static RuntimeException onSeledMutation() {
        throw new IllegalStateException("Attempt to modify sealed array");
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int i = this.size;
        if (i > 5) {
            this.data = new Object[i - 5];
        }
        for (int i2 = 0; i2 != i; i2++) {
            setImpl(i2, objectInputStream.readObject());
        }
    }

    private void setImpl(int i, Object obj) {
        if (i == 0) {
            this.f0 = obj;
            return;
        }
        if (i == 1) {
            this.f1 = obj;
            return;
        }
        if (i == 2) {
            this.f2 = obj;
            return;
        }
        if (i == 3) {
            this.f3 = obj;
        } else if (i != 4) {
            this.data[i - 5] = obj;
        } else {
            this.f4 = obj;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            objectOutputStream.writeObject(getImpl(i2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0017, code lost:
    
        if (r8 != 4) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void add(int r8, java.lang.Object r9) {
        /*
            r7 = this;
            int r0 = r7.size
            r1 = 1
            if (r8 < 0) goto L6d
            if (r8 > r0) goto L6d
            boolean r2 = r7.sealed
            if (r2 != 0) goto L68
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 5
            if (r8 == 0) goto L1a
            if (r8 == r1) goto L24
            if (r8 == r4) goto L2e
            if (r8 == r3) goto L38
            if (r8 == r2) goto L42
            goto L4d
        L1a:
            if (r0 != 0) goto L1f
            r7.f0 = r9
            goto L64
        L1f:
            java.lang.Object r8 = r7.f0
            r7.f0 = r9
            r9 = r8
        L24:
            if (r0 != r1) goto L29
            r7.f1 = r9
            goto L64
        L29:
            java.lang.Object r8 = r7.f1
            r7.f1 = r9
            r9 = r8
        L2e:
            if (r0 != r4) goto L33
            r7.f2 = r9
            goto L64
        L33:
            java.lang.Object r8 = r7.f2
            r7.f2 = r9
            r9 = r8
        L38:
            if (r0 != r3) goto L3d
            r7.f3 = r9
            goto L64
        L3d:
            java.lang.Object r8 = r7.f3
            r7.f3 = r9
            r9 = r8
        L42:
            if (r0 != r2) goto L47
            r7.f4 = r9
            goto L64
        L47:
            java.lang.Object r8 = r7.f4
            r7.f4 = r9
            r9 = r8
            r8 = r5
        L4d:
            int r2 = r0 + 1
            r7.ensureCapacity(r2)
            if (r8 == r0) goto L5f
            java.lang.Object[] r2 = r7.data
            int r3 = r8 + (-5)
            int r4 = r3 + 1
            int r6 = r0 - r8
            java.lang.System.arraycopy(r2, r3, r2, r4, r6)
        L5f:
            java.lang.Object[] r2 = r7.data
            int r8 = r8 - r5
            r2[r8] = r9
        L64:
            int r0 = r0 + r1
            r7.size = r0
            return
        L68:
            java.lang.RuntimeException r8 = onSeledMutation()
            throw r8
        L6d:
            int r0 = r0 + r1
            java.lang.RuntimeException r8 = onInvalidIndex(r8, r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.ObjArray.add(int, java.lang.Object):void");
    }

    public final void clear() {
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            setImpl(i2, null);
        }
        this.size = 0;
    }

    public final Object get(int i) {
        if (i < 0 || i >= this.size) {
            throw onInvalidIndex(i, this.size);
        }
        return getImpl(i);
    }

    public int indexOf(Object obj) {
        int i = this.size;
        for (int i2 = 0; i2 != i; i2++) {
            Object impl = getImpl(i2);
            if (impl == obj || (impl != null && impl.equals(obj))) {
                return i2;
            }
        }
        return -1;
    }

    public final boolean isEmpty() {
        return this.size == 0;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    public int lastIndexOf(Object obj) {
        int i = this.size;
        while (i != 0) {
            i--;
            Object impl = getImpl(i);
            if (impl == obj || (impl != null && impl.equals(obj))) {
                return i;
            }
        }
        return -1;
    }

    public final Object peek() {
        int i = this.size;
        if (i != 0) {
            return getImpl(i - 1);
        }
        throw onEmptyStackTopRead();
    }

    public final Object pop() {
        Object obj;
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i = this.size - 1;
        if (i == -1) {
            throw onEmptyStackTopRead();
        }
        if (i == 0) {
            obj = this.f0;
            this.f0 = null;
        } else if (i == 1) {
            obj = this.f1;
            this.f1 = null;
        } else if (i == 2) {
            obj = this.f2;
            this.f2 = null;
        } else if (i == 3) {
            obj = this.f3;
            this.f3 = null;
        } else if (i != 4) {
            Object[] objArr = this.data;
            int i2 = i - 5;
            obj = objArr[i2];
            objArr[i2] = null;
        } else {
            obj = this.f4;
            this.f4 = null;
        }
        this.size = i;
        return obj;
    }

    public final void push(Object obj) {
        add(obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0019, code lost:
    
        if (r7 != 4) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void remove(int r7) {
        /*
            r6 = this;
            int r0 = r6.size
            if (r7 < 0) goto L68
            if (r7 >= r0) goto L68
            boolean r1 = r6.sealed
            if (r1 != 0) goto L63
            int r0 = r0 + (-1)
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r7 == 0) goto L1c
            if (r7 == r4) goto L25
            if (r7 == r3) goto L2e
            if (r7 == r2) goto L37
            if (r7 == r1) goto L40
            goto L4d
        L1c:
            if (r0 != 0) goto L21
            r6.f0 = r5
            goto L60
        L21:
            java.lang.Object r7 = r6.f1
            r6.f0 = r7
        L25:
            if (r0 != r4) goto L2a
            r6.f1 = r5
            goto L60
        L2a:
            java.lang.Object r7 = r6.f2
            r6.f1 = r7
        L2e:
            if (r0 != r3) goto L33
            r6.f2 = r5
            goto L60
        L33:
            java.lang.Object r7 = r6.f3
            r6.f2 = r7
        L37:
            if (r0 != r2) goto L3c
            r6.f3 = r5
            goto L60
        L3c:
            java.lang.Object r7 = r6.f4
            r6.f3 = r7
        L40:
            if (r0 != r1) goto L45
            r6.f4 = r5
            goto L60
        L45:
            java.lang.Object[] r7 = r6.data
            r1 = 0
            r7 = r7[r1]
            r6.f4 = r7
            r7 = 5
        L4d:
            if (r7 == r0) goto L5a
            java.lang.Object[] r1 = r6.data
            int r2 = r7 + (-5)
            int r3 = r2 + 1
            int r7 = r0 - r7
            java.lang.System.arraycopy(r1, r3, r1, r2, r7)
        L5a:
            java.lang.Object[] r7 = r6.data
            int r1 = r0 + (-5)
            r7[r1] = r5
        L60:
            r6.size = r0
            return
        L63:
            java.lang.RuntimeException r7 = onSeledMutation()
            throw r7
        L68:
            java.lang.RuntimeException r7 = onInvalidIndex(r7, r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.ObjArray.remove(int):void");
    }

    public final void seal() {
        this.sealed = true;
    }

    public final void set(int i, Object obj) {
        if (i < 0 || i >= this.size) {
            throw onInvalidIndex(i, this.size);
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        setImpl(i, obj);
    }

    public final void setSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i2 = this.size;
        if (i < i2) {
            for (int i3 = i; i3 != i2; i3++) {
                setImpl(i3, null);
            }
        } else if (i > i2 && i > 5) {
            ensureCapacity(i);
        }
        this.size = i;
    }

    public final int size() {
        return this.size;
    }

    public final void toArray(Object[] objArr) {
        toArray(objArr, 0);
    }

    public final void add(Object obj) {
        if (this.sealed) {
            throw onSeledMutation();
        }
        int i = this.size;
        if (i >= 5) {
            ensureCapacity(i + 1);
        }
        this.size = i + 1;
        setImpl(i, obj);
    }

    public final void toArray(Object[] objArr, int i) {
        int i2 = this.size;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                System.arraycopy(this.data, 0, objArr, i + 5, i2 - 5);
                            }
                            objArr[i + 4] = this.f4;
                        }
                        objArr[i + 3] = this.f3;
                    }
                    objArr[i + 2] = this.f2;
                }
                objArr[i + 1] = this.f1;
            }
            objArr[i + 0] = this.f0;
        }
    }

    public final Object[] toArray() {
        Object[] objArr = new Object[this.size];
        toArray(objArr, 0);
        return objArr;
    }
}
