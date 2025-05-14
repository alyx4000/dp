package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* loaded from: classes2.dex */
public class NativeUint8ClampedArray extends NativeTypedArrayView<Integer> {
    private static final String CLASS_NAME = "Uint8ClampedArray";
    private static final long serialVersionUID = -3349419704390398895L;

    public NativeUint8ClampedArray() {
    }

    public NativeUint8ClampedArray(int i) {
        this(new NativeArrayBuffer(i), 0, i);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeUint8ClampedArray().exportAsJSClass(6, scriptable, z);
    }

    @Override // java.util.List
    public Integer get(int i) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer) js_get(i);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    public int getBytesPerElement() {
        return 1;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_get(int i) {
        return checkIndex(i) ? Undefined.instance : ByteIo.readUint8(this.arrayBuffer.buffer, i + this.offset);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    protected Object js_set(int i, Object obj) {
        if (checkIndex(i)) {
            return Undefined.instance;
        }
        ByteIo.writeUint8(this.arrayBuffer.buffer, i + this.offset, Conversions.toUint8Clamp(obj));
        return null;
    }

    @Override // java.util.List
    public Integer set(int i, Integer num) {
        if (checkIndex(i)) {
            throw new IndexOutOfBoundsException();
        }
        return (Integer) js_set(i, num);
    }

    public NativeUint8ClampedArray(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Integer> construct(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        return new NativeUint8ClampedArray(nativeArrayBuffer, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // external.sdk.pendo.io.mozilla.javascript.typedarrays.NativeTypedArrayView
    public NativeTypedArrayView<Integer> realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeUint8ClampedArray) {
            return (NativeUint8ClampedArray) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }
}
