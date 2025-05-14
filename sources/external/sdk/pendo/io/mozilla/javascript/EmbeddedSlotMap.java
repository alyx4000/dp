package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class EmbeddedSlotMap implements SlotMap {
    private static final int INITIAL_SLOT_SIZE = 4;
    private int count;
    private ScriptableObject.Slot firstAdded;
    private ScriptableObject.Slot lastAdded;
    private ScriptableObject.Slot[] slots;

    /* renamed from: external.sdk.pendo.io.mozilla.javascript.EmbeddedSlotMap$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess;

        static {
            int[] iArr = new int[ScriptableObject.SlotAccess.values().length];
            $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess = iArr;
            try {
                iArr[ScriptableObject.SlotAccess.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.MODIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.MODIFY_CONST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess[ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static final class Iter implements Iterator<ScriptableObject.Slot> {
        private ScriptableObject.Slot next;

        Iter(ScriptableObject.Slot slot) {
            this.next = slot;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public ScriptableObject.Slot next() {
            ScriptableObject.Slot slot = this.next;
            if (slot == null) {
                throw new NoSuchElementException();
            }
            this.next = slot.orderedNext;
            return slot;
        }
    }

    private static void addKnownAbsentSlot(ScriptableObject.Slot[] slotArr, ScriptableObject.Slot slot) {
        int slotIndex = getSlotIndex(slotArr.length, slot.indexOrHash);
        ScriptableObject.Slot slot2 = slotArr[slotIndex];
        slotArr[slotIndex] = slot;
        slot.next = slot2;
    }

    private static void copyTable(ScriptableObject.Slot[] slotArr, ScriptableObject.Slot[] slotArr2) {
        for (ScriptableObject.Slot slot : slotArr) {
            while (slot != null) {
                ScriptableObject.Slot slot2 = slot.next;
                slot.next = null;
                addKnownAbsentSlot(slotArr2, slot);
                slot = slot2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0036, code lost:
    
        if (r8 != external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x003a, code lost:
    
        if ((r0 instanceof external.sdk.pendo.io.mozilla.javascript.ScriptableObject.GetterSlot) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x003c, code lost:
    
        r8 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject.GetterSlot(r6, r7, r0.getAttributes());
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0057, code lost:
    
        r8.value = r0.value;
        r8.next = r0.next;
        r6 = r5.firstAdded;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0061, code lost:
    
        if (r0 != r6) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0063, code lost:
    
        r5.firstAdded = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0072, code lost:
    
        r8.orderedNext = r0.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
    
        if (r0 != r5.lastAdded) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
    
        r5.lastAdded = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
    
        if (r2 != r0) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x007e, code lost:
    
        r5.slots[r9] = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0085, code lost:
    
        return r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
    
        r2.next = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0066, code lost:
    
        if (r6 == null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0068, code lost:
    
        r7 = r6.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006a, code lost:
    
        if (r7 == r0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006c, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x006e, code lost:
    
        if (r6 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0070, code lost:
    
        r6.orderedNext = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0048, code lost:
    
        if (r8 != external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x004c, code lost:
    
        if ((r0 instanceof external.sdk.pendo.io.mozilla.javascript.ScriptableObject.GetterSlot) == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x004e, code lost:
    
        r8 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot(r6, r7, r0.getAttributes());
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0088, code lost:
    
        if (r8 != external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_CONST) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x008a, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot createSlot(java.lang.Object r6, int r7, external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess r8, external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot r9) {
        /*
            r5 = this;
            int r0 = r5.count
            r1 = 4
            if (r0 != 0) goto Lb
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r9 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot[r1]
            r5.slots = r9
            goto L8d
        Lb:
            if (r9 == 0) goto L8d
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r9 = r5.slots
            int r9 = r9.length
            int r9 = getSlotIndex(r9, r7)
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r0 = r5.slots
            r0 = r0[r9]
            r2 = r0
        L19:
            if (r0 == 0) goto L32
            int r3 = r0.indexOrHash
            if (r3 != r7) goto L2c
            java.lang.Object r3 = r0.name
            if (r3 == r6) goto L32
            if (r6 == 0) goto L2c
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L2c
            goto L32
        L2c:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r2 = r0.next
            r4 = r2
            r2 = r0
            r0 = r4
            goto L19
        L32:
            if (r0 == 0) goto L8d
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess r1 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER
            if (r8 != r1) goto L46
            boolean r1 = r0 instanceof external.sdk.pendo.io.mozilla.javascript.ScriptableObject.GetterSlot
            if (r1 != 0) goto L46
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$GetterSlot r8 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject$GetterSlot
            int r1 = r0.getAttributes()
            r8.<init>(r6, r7, r1)
            goto L57
        L46:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess r1 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.CONVERT_ACCESSOR_TO_DATA
            if (r8 != r1) goto L86
            boolean r1 = r0 instanceof external.sdk.pendo.io.mozilla.javascript.ScriptableObject.GetterSlot
            if (r1 == 0) goto L86
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r8 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot
            int r1 = r0.getAttributes()
            r8.<init>(r6, r7, r1)
        L57:
            java.lang.Object r6 = r0.value
            r8.value = r6
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r6 = r0.next
            r8.next = r6
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r6 = r5.firstAdded
            if (r0 != r6) goto L66
            r5.firstAdded = r8
            goto L72
        L66:
            if (r6 == 0) goto L6e
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r7 = r6.orderedNext
            if (r7 == r0) goto L6e
            r6 = r7
            goto L66
        L6e:
            if (r6 == 0) goto L72
            r6.orderedNext = r8
        L72:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r6 = r0.orderedNext
            r8.orderedNext = r6
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r6 = r5.lastAdded
            if (r0 != r6) goto L7c
            r5.lastAdded = r8
        L7c:
            if (r2 != r0) goto L83
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r6 = r5.slots
            r6[r9] = r8
            goto L85
        L83:
            r2.next = r8
        L85:
            return r8
        L86:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess r6 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_CONST
            if (r8 != r6) goto L8c
            r6 = 0
            return r6
        L8c:
            return r0
        L8d:
            int r9 = r5.count
            int r9 = r9 + 1
            int r9 = r9 * r1
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r0 = r5.slots
            int r1 = r0.length
            int r1 = r1 * 3
            if (r9 <= r1) goto La3
            int r9 = r0.length
            int r9 = r9 * 2
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r9 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot[r9]
            copyTable(r0, r9)
            r5.slots = r9
        La3:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess r9 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_GETTER_SETTER
            r0 = 0
            if (r8 != r9) goto Lae
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$GetterSlot r9 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject$GetterSlot
            r9.<init>(r6, r7, r0)
            goto Lb3
        Lae:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r9 = new external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot
            r9.<init>(r6, r7, r0)
        Lb3:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess r6 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.MODIFY_CONST
            if (r8 != r6) goto Lbc
            r6 = 13
            r9.setAttributes(r6)
        Lbc:
            r5.insertNewSlot(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.EmbeddedSlotMap.createSlot(java.lang.Object, int, external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess, external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot):external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot");
    }

    private static int getSlotIndex(int i, int i2) {
        return (i - 1) & i2;
    }

    private void insertNewSlot(ScriptableObject.Slot slot) {
        this.count++;
        ScriptableObject.Slot slot2 = this.lastAdded;
        if (slot2 != null) {
            slot2.orderedNext = slot;
        }
        if (this.firstAdded == null) {
            this.firstAdded = slot;
        }
        this.lastAdded = slot;
        addKnownAbsentSlot(this.slots, slot);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public void addSlot(ScriptableObject.Slot slot) {
        if (this.slots == null) {
            this.slots = new ScriptableObject.Slot[4];
        }
        insertNewSlot(slot);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0056, code lost:
    
        if (r1 != null) goto L39;
     */
    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public external.sdk.pendo.io.mozilla.javascript.ScriptableObject.Slot get(java.lang.Object r4, int r5, external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess r6) {
        /*
            r3 = this;
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r0 = r3.slots
            r1 = 0
            if (r0 != 0) goto La
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess r0 = external.sdk.pendo.io.mozilla.javascript.ScriptableObject.SlotAccess.QUERY
            if (r6 != r0) goto La
            return r1
        La:
            if (r4 == 0) goto L10
            int r5 = r4.hashCode()
        L10:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r0 = r3.slots
            if (r0 == 0) goto L59
            int r0 = r0.length
            int r0 = getSlotIndex(r0, r5)
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r1 = r3.slots
            r0 = r1[r0]
            r1 = r0
        L1e:
            if (r1 == 0) goto L34
            java.lang.Object r0 = r1.name
            int r2 = r1.indexOrHash
            if (r5 != r2) goto L31
            if (r0 == r4) goto L34
            if (r4 == 0) goto L31
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L31
            goto L34
        L31:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r1 = r1.next
            goto L1e
        L34:
            int[] r0 = external.sdk.pendo.io.mozilla.javascript.EmbeddedSlotMap.AnonymousClass1.$SwitchMap$org$mozilla$javascript$ScriptableObject$SlotAccess
            int r2 = r6.ordinal()
            r0 = r0[r2]
            r2 = 1
            if (r0 == r2) goto L58
            r2 = 2
            if (r0 == r2) goto L56
            r2 = 3
            if (r0 == r2) goto L56
            r2 = 4
            if (r0 == r2) goto L51
            r2 = 5
            if (r0 == r2) goto L4c
            goto L59
        L4c:
            boolean r0 = r1 instanceof external.sdk.pendo.io.mozilla.javascript.ScriptableObject.GetterSlot
            if (r0 != 0) goto L59
            return r1
        L51:
            boolean r0 = r1 instanceof external.sdk.pendo.io.mozilla.javascript.ScriptableObject.GetterSlot
            if (r0 == 0) goto L59
            return r1
        L56:
            if (r1 == 0) goto L59
        L58:
            return r1
        L59:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r4 = r3.createSlot(r4, r5, r6, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.EmbeddedSlotMap.get(java.lang.Object, int, external.sdk.pendo.io.mozilla.javascript.ScriptableObject$SlotAccess):external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<ScriptableObject.Slot> iterator() {
        return new Iter(this.firstAdded);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public ScriptableObject.Slot query(Object obj, int i) {
        if (this.slots == null) {
            return null;
        }
        if (obj != null) {
            i = obj.hashCode();
        }
        for (ScriptableObject.Slot slot = this.slots[getSlotIndex(this.slots.length, i)]; slot != null; slot = slot.next) {
            Object obj2 = slot.name;
            if (i == slot.indexOrHash && (obj2 == obj || (obj != null && obj.equals(obj2)))) {
                return slot;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if ((r1.getAttributes() & 4) == 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (external.sdk.pendo.io.mozilla.javascript.Context.getContext().isStrictMode() != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004a, code lost:
    
        throw external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.typeError1("msg.delete.property.with.configurable.false", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r5.count--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0051, code lost:
    
        if (r2 != r1) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
    
        r5.slots[r0] = r1.next;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005e, code lost:
    
        r6 = r5.firstAdded;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0060, code lost:
    
        if (r1 != r6) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        r5.firstAdded = r1.orderedNext;
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
    
        if (r1 != r5.lastAdded) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
    
        r5.lastAdded = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        r7 = r6.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
    
        if (r7 == r1) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
    
        r6 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x006e, code lost:
    
        r6.orderedNext = r1.orderedNext;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005a, code lost:
    
        r2.next = r1.next;
     */
    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void remove(java.lang.Object r6, int r7) {
        /*
            r5 = this;
            if (r6 == 0) goto L6
            int r7 = r6.hashCode()
        L6:
            int r0 = r5.count
            if (r0 == 0) goto L78
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r0 = r5.slots
            int r0 = r0.length
            int r0 = getSlotIndex(r0, r7)
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r1 = r5.slots
            r1 = r1[r0]
            r2 = r1
        L16:
            if (r1 == 0) goto L2f
            int r3 = r1.indexOrHash
            if (r3 != r7) goto L29
            java.lang.Object r3 = r1.name
            if (r3 == r6) goto L2f
            if (r6 == 0) goto L29
            boolean r3 = r6.equals(r3)
            if (r3 == 0) goto L29
            goto L2f
        L29:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r2 = r1.next
            r4 = r2
            r2 = r1
            r1 = r4
            goto L16
        L2f:
            if (r1 == 0) goto L78
            int r7 = r1.getAttributes()
            r7 = r7 & 4
            if (r7 == 0) goto L4b
            external.sdk.pendo.io.mozilla.javascript.Context r7 = external.sdk.pendo.io.mozilla.javascript.Context.getContext()
            boolean r7 = r7.isStrictMode()
            if (r7 != 0) goto L44
            return
        L44:
            java.lang.String r7 = "msg.delete.property.with.configurable.false"
            external.sdk.pendo.io.mozilla.javascript.EcmaError r6 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.typeError1(r7, r6)
            throw r6
        L4b:
            int r6 = r5.count
            int r6 = r6 + (-1)
            r5.count = r6
            if (r2 != r1) goto L5a
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot[] r6 = r5.slots
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r7 = r1.next
            r6[r0] = r7
            goto L5e
        L5a:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r6 = r1.next
            r2.next = r6
        L5e:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r6 = r5.firstAdded
            if (r1 != r6) goto L68
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r6 = r1.orderedNext
            r5.firstAdded = r6
            r6 = 0
            goto L72
        L68:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r7 = r6.orderedNext
            if (r7 == r1) goto L6e
            r6 = r7
            goto L68
        L6e:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r7 = r1.orderedNext
            r6.orderedNext = r7
        L72:
            external.sdk.pendo.io.mozilla.javascript.ScriptableObject$Slot r7 = r5.lastAdded
            if (r1 != r7) goto L78
            r5.lastAdded = r6
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.EmbeddedSlotMap.remove(java.lang.Object, int):void");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.SlotMap
    public int size() {
        return this.count;
    }
}
