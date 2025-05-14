package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.ExternalArrayData;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.NativeArray;
import external.sdk.pendo.io.mozilla.javascript.NativeArrayIterator;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Symbol;
import external.sdk.pendo.io.mozilla.javascript.SymbolKey;
import external.sdk.pendo.io.mozilla.javascript.Undefined;
import external.sdk.pendo.io.mozilla.javascript.Wrapper;
import io.sentry.SentryEnvelopeItemHeader;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public abstract class NativeTypedArrayView<T> extends NativeArrayBufferView implements List<T>, RandomAccess, ExternalArrayData {
    private static final int Id_BYTES_PER_ELEMENT = 5;
    private static final int Id_constructor = 1;
    private static final int Id_get = 3;
    private static final int Id_length = 4;
    private static final int Id_set = 4;
    private static final int Id_subarray = 5;
    private static final int Id_toString = 2;
    private static final int MAX_INSTANCE_ID = 5;
    protected static final int MAX_PROTOTYPE_ID = 6;
    private static final int SymbolId_iterator = 6;
    private static final long serialVersionUID = -4963053773152251274L;
    protected final int length;

    protected NativeTypedArrayView() {
        this.length = 0;
    }

    private NativeTypedArrayView<T> js_constructor(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (NativeArrayBufferView.isArg(objArr, 0) && (obj = objArr[0]) != null) {
            if ((obj instanceof Number) || (obj instanceof String)) {
                int int32 = ScriptRuntime.toInt32(obj);
                return construct(makeArrayBuffer(context, scriptable, int32), 0, int32);
            }
            if (obj instanceof NativeTypedArrayView) {
                NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
                NativeTypedArrayView<T> construct = construct(makeArrayBuffer(context, scriptable, nativeTypedArrayView.length), 0, nativeTypedArrayView.length);
                while (r0 < nativeTypedArrayView.length) {
                    construct.js_set(r0, nativeTypedArrayView.js_get(r0));
                    r0++;
                }
                return construct;
            }
            if (obj instanceof NativeArrayBuffer) {
                NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
                r0 = NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0;
                int int322 = NativeArrayBufferView.isArg(objArr, 2) ? ScriptRuntime.toInt32(objArr[2]) * getBytesPerElement() : nativeArrayBuffer.getLength() - r0;
                if (r0 >= 0) {
                    byte[] bArr = nativeArrayBuffer.buffer;
                    if (r0 <= bArr.length) {
                        if (int322 < 0 || r0 + int322 > bArr.length) {
                            throw ScriptRuntime.rangeError("length out of range");
                        }
                        if (r0 % getBytesPerElement() != 0) {
                            throw ScriptRuntime.rangeError("offset must be a multiple of the byte size");
                        }
                        if (int322 % getBytesPerElement() == 0) {
                            return construct(nativeArrayBuffer, r0, int322 / getBytesPerElement());
                        }
                        throw ScriptRuntime.rangeError("offset and buffer must be a multiple of the byte size");
                    }
                }
                throw ScriptRuntime.rangeError("offset out of range");
            }
            if (!(obj instanceof NativeArray)) {
                if (!ScriptRuntime.isArrayObject(obj)) {
                    throw ScriptRuntime.constructError("Error", "invalid argument");
                }
                Object[] arrayElements = ScriptRuntime.getArrayElements((Scriptable) obj);
                NativeTypedArrayView<T> construct2 = construct(makeArrayBuffer(context, scriptable, arrayElements.length), 0, arrayElements.length);
                while (r0 < arrayElements.length) {
                    construct2.js_set(r0, arrayElements[r0]);
                    r0++;
                }
                return construct2;
            }
            NativeArray nativeArray = (NativeArray) obj;
            NativeTypedArrayView<T> construct3 = construct(makeArrayBuffer(context, scriptable, nativeArray.size()), 0, nativeArray.size());
            while (r0 < nativeArray.size()) {
                Object obj2 = nativeArray.get(r0, nativeArray);
                if (obj2 == Scriptable.NOT_FOUND || obj2 == Undefined.instance) {
                    obj2 = ScriptRuntime.NaNobj;
                } else if (obj2 instanceof Wrapper) {
                    obj2 = ((Wrapper) obj2).unwrap();
                }
                construct3.js_set(r0, obj2);
                r0++;
            }
            return construct3;
        }
        return construct(new NativeArrayBuffer(), 0, 0);
    }

    private Object js_subarray(Context context, Scriptable scriptable, int i, int i2) {
        if (i < 0) {
            i += this.length;
        }
        if (i2 < 0) {
            i2 += this.length;
        }
        int max = Math.max(0, i);
        int max2 = Math.max(0, Math.min(this.length, i2) - max);
        return context.newObject(scriptable, getClassName(), new Object[]{this.arrayBuffer, Integer.valueOf(Math.min(max * getBytesPerElement(), this.arrayBuffer.getLength())), Integer.valueOf(max2)});
    }

    private NativeArrayBuffer makeArrayBuffer(Context context, Scriptable scriptable, int i) {
        return (NativeArrayBuffer) context.newObject(scriptable, NativeArrayBuffer.CLASS_NAME, new Object[]{Double.valueOf(i * getBytesPerElement())});
    }

    private void setRange(NativeArray nativeArray, int i) {
        if (i > this.length) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        if (nativeArray.size() + i > this.length) {
            throw ScriptRuntime.rangeError("offset + length out of range");
        }
        Iterator it = nativeArray.iterator();
        while (it.hasNext()) {
            js_set(i, it.next());
            i++;
        }
    }

    @Override // java.util.List
    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    protected boolean checkIndex(int i) {
        return i < 0 || i >= this.length;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    protected abstract NativeTypedArrayView<T> construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2);

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void delete(int i) {
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            NativeTypedArrayView nativeTypedArrayView = (NativeTypedArrayView) obj;
            if (this.length != nativeTypedArrayView.length) {
                return false;
            }
            for (int i = 0; i < this.length; i++) {
                if (!js_get(i).equals(nativeTypedArrayView.js_get(i))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        switch (methodId) {
            case 1:
                if (scriptable2 == null || context.getLanguageVersion() < 200) {
                    return js_constructor(context, scriptable, objArr);
                }
                throw ScriptRuntime.typeError1("msg.only.from.new", getClassName());
            case 2:
                NativeTypedArrayView<T> realThis = realThis(scriptable2, idFunctionObject);
                int arrayLength = realThis.getArrayLength();
                StringBuilder sb = new StringBuilder();
                if (arrayLength > 0) {
                    sb.append(ScriptRuntime.toString(realThis.js_get(0)));
                }
                for (int i = 1; i < arrayLength; i++) {
                    sb.append(',');
                    sb.append(ScriptRuntime.toString(realThis.js_get(i)));
                }
                return sb.toString();
            case 3:
                if (objArr.length > 0) {
                    return realThis(scriptable2, idFunctionObject).js_get(ScriptRuntime.toInt32(objArr[0]));
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            case 4:
                if (objArr.length > 0) {
                    NativeTypedArrayView<T> realThis2 = realThis(scriptable2, idFunctionObject);
                    Object obj = objArr[0];
                    if (obj instanceof NativeTypedArrayView) {
                        realThis2.setRange((NativeTypedArrayView) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    }
                    if (obj instanceof NativeArray) {
                        realThis2.setRange((NativeArray) objArr[0], NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : 0);
                        return Undefined.instance;
                    }
                    if (obj instanceof Scriptable) {
                        return Undefined.instance;
                    }
                    if (NativeArrayBufferView.isArg(objArr, 2)) {
                        return realThis2.js_set(ScriptRuntime.toInt32(objArr[0]), objArr[1]);
                    }
                }
                throw ScriptRuntime.constructError("Error", "invalid arguments");
            case 5:
                if (objArr.length <= 0) {
                    throw ScriptRuntime.constructError("Error", "invalid arguments");
                }
                NativeTypedArrayView<T> realThis3 = realThis(scriptable2, idFunctionObject);
                return realThis3.js_subarray(context, scriptable, ScriptRuntime.toInt32(objArr[0]), NativeArrayBufferView.isArg(objArr, 1) ? ScriptRuntime.toInt32(objArr[1]) : realThis3.length);
            case 6:
                return new NativeArrayIterator(scriptable, scriptable2, NativeArrayIterator.ARRAY_ITERATOR_TYPE.VALUES);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("BYTES_PER_ELEMENT", ScriptRuntime.wrapInt(getBytesPerElement()), 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findInstanceIdInfo(String str) {
        String str2;
        int i;
        int length = str.length();
        if (length == 6) {
            str2 = SentryEnvelopeItemHeader.JsonKeys.LENGTH;
            i = 4;
        } else if (length == 17) {
            str2 = "BYTES_PER_ELEMENT";
            i = 5;
        } else {
            str2 = null;
            i = 0;
        }
        int i2 = (str2 == null || str2 == str || str2.equals(str)) ? i : 0;
        return i2 == 0 ? super.findInstanceIdInfo(str) : i2 == 5 ? IdScriptableObject.instanceIdInfo(7, i2) : IdScriptableObject.instanceIdInfo(5, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.ITERATOR.equals(symbol) ? 6 : 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object get(int i, Scriptable scriptable) {
        return js_get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ExternalArrayData
    public Object getArrayElement(int i) {
        return js_get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ExternalArrayData
    public int getArrayLength() {
        return this.length;
    }

    public abstract int getBytesPerElement();

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object[] getIds() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = Integer.valueOf(i);
        }
        return objArr;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected String getInstanceIdName(int i) {
        return i != 4 ? i != 5 ? super.getInstanceIdName(i) : "BYTES_PER_ELEMENT" : SentryEnvelopeItemHeader.JsonKeys.LENGTH;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected Object getInstanceIdValue(int i) {
        int i2;
        if (i == 4) {
            i2 = this.length;
        } else {
            if (i != 5) {
                return super.getInstanceIdValue(i);
            }
            i2 = getBytesPerElement();
        }
        return ScriptRuntime.wrapInt(i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeArrayBufferView, external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int getMaxInstanceId() {
        return 5;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public boolean has(int i, Scriptable scriptable) {
        return !checkIndex(i);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.length; i2++) {
            i += js_get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        int i2;
        String str2;
        String str3;
        if (i == 6) {
            initPrototypeMethod(getClassName(), i, SymbolKey.ITERATOR, "[Symbol.iterator]", 0);
            return;
        }
        int i3 = 3;
        if (i == 1) {
            str = "constructor";
        } else {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        str3 = "set";
                    } else {
                        if (i != 5) {
                            throw new IllegalArgumentException(String.valueOf(i));
                        }
                        str3 = "subarray";
                    }
                    str2 = str3;
                    i2 = 2;
                } else {
                    str2 = "get";
                    i2 = 1;
                }
                initPrototypeMethod(getClassName(), i, str2, (String) null, i2);
            }
            i3 = 0;
            str = "toString";
        }
        i2 = i3;
        str2 = str;
        initPrototypeMethod(getClassName(), i, str2, (String) null, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    protected abstract Object js_get(int i);

    protected abstract Object js_set(int i, Object obj);

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        for (int i = this.length - 1; i >= 0; i--) {
            if (obj.equals(js_get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new NativeTypedArrayIterator(this, 0);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public void put(int i, Scriptable scriptable, Object obj) {
        js_set(i, obj);
    }

    protected abstract NativeTypedArrayView<T> realThis(Scriptable scriptable, IdFunctionObject idFunctionObject);

    @Override // java.util.List
    public T remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ExternalArrayData
    public void setArrayElement(int i, Object obj) {
        js_set(i, obj);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, java.util.List, java.util.Collection
    public int size() {
        return this.length;
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            objArr[i] = js_get(i);
        }
        return objArr;
    }

    protected NativeTypedArrayView(NativeArrayBuffer nativeArrayBuffer, int i, int i2, int i3) {
        super(nativeArrayBuffer, i, i3);
        this.length = i2;
    }

    private void setRange(NativeTypedArrayView<T> nativeTypedArrayView, int i) {
        int i2 = this.length;
        if (i >= i2) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        int i3 = nativeTypedArrayView.length;
        if (i3 > i2 - i) {
            throw ScriptRuntime.rangeError("source array too long");
        }
        int i4 = 0;
        if (nativeTypedArrayView.arrayBuffer != this.arrayBuffer) {
            while (i4 < nativeTypedArrayView.length) {
                js_set(i4 + i, nativeTypedArrayView.js_get(i4));
                i4++;
            }
            return;
        }
        Object[] objArr = new Object[i3];
        for (int i5 = 0; i5 < nativeTypedArrayView.length; i5++) {
            objArr[i5] = nativeTypedArrayView.js_get(i5);
        }
        while (i4 < nativeTypedArrayView.length) {
            js_set(i4 + i, objArr[i4]);
            i4++;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0055 A[ADDED_TO_REGION] */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int findPrototypeId(java.lang.String r10) {
        /*
            r9 = this;
            int r0 = r10.length()
            r1 = 115(0x73, float:1.61E-43)
            r2 = 1
            r3 = 116(0x74, float:1.63E-43)
            r4 = 2
            r5 = 0
            r6 = 3
            if (r0 != r6) goto L36
            char r0 = r10.charAt(r5)
            r7 = 103(0x67, float:1.44E-43)
            r8 = 101(0x65, float:1.42E-43)
            if (r0 != r7) goto L26
            char r0 = r10.charAt(r4)
            if (r0 != r3) goto L51
            char r0 = r10.charAt(r2)
            if (r0 != r8) goto L51
            r5 = r6
            goto L5f
        L26:
            if (r0 != r1) goto L51
            char r0 = r10.charAt(r4)
            if (r0 != r3) goto L51
            char r0 = r10.charAt(r2)
            if (r0 != r8) goto L51
            r5 = 4
            goto L5f
        L36:
            r6 = 8
            if (r0 != r6) goto L4a
            char r0 = r10.charAt(r5)
            if (r0 != r1) goto L44
            java.lang.String r0 = "subarray"
            r2 = 5
            goto L53
        L44:
            if (r0 != r3) goto L51
            java.lang.String r0 = "toString"
            r2 = r4
            goto L53
        L4a:
            r1 = 11
            if (r0 != r1) goto L51
            java.lang.String r0 = "constructor"
            goto L53
        L51:
            r0 = 0
            r2 = r5
        L53:
            if (r0 == 0) goto L5e
            if (r0 == r10) goto L5e
            boolean r10 = r0.equals(r10)
            if (r10 != 0) goto L5e
            goto L5f
        L5e:
            r5 = r2
        L5f:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView.findPrototypeId(java.lang.String):int");
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return new NativeTypedArrayIterator(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public <U> U[] toArray(U[] uArr) {
        if (uArr.length < this.length) {
            uArr = (U[]) ((Object[]) Array.newInstance(uArr.getClass().getComponentType(), this.length));
        }
        for (int i = 0; i < this.length; i++) {
            try {
                uArr[i] = js_get(i);
            } catch (ClassCastException unused) {
                throw new ArrayStoreException();
            }
        }
        return uArr;
    }
}
