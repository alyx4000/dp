package external.sdk.pendo.io.mozilla.javascript.typedarrays;

import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.IdFunctionObject;
import external.sdk.pendo.io.mozilla.javascript.IdScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.ScriptRuntime;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.Undefined;

/* loaded from: classes2.dex */
public class NativeDataView extends NativeArrayBufferView {
    public static final String CLASS_NAME = "DataView";
    private static final int Id_constructor = 1;
    private static final int Id_getFloat32 = 8;
    private static final int Id_getFloat64 = 9;
    private static final int Id_getInt16 = 4;
    private static final int Id_getInt32 = 6;
    private static final int Id_getInt8 = 2;
    private static final int Id_getUint16 = 5;
    private static final int Id_getUint32 = 7;
    private static final int Id_getUint8 = 3;
    private static final int Id_setFloat32 = 16;
    private static final int Id_setFloat64 = 17;
    private static final int Id_setInt16 = 12;
    private static final int Id_setInt32 = 14;
    private static final int Id_setInt8 = 10;
    private static final int Id_setUint16 = 13;
    private static final int Id_setUint32 = 15;
    private static final int Id_setUint8 = 11;
    private static final int MAX_PROTOTYPE_ID = 17;
    private static final long serialVersionUID = 1427967607557438968L;

    public NativeDataView() {
    }

    public NativeDataView(NativeArrayBuffer nativeArrayBuffer, int i, int i2) {
        super(nativeArrayBuffer, i, i2);
    }

    private static int determinePos(Object[] objArr) {
        if (!NativeArrayBufferView.isArg(objArr, 0)) {
            return 0;
        }
        double number = ScriptRuntime.toNumber(objArr[0]);
        if (Double.isInfinite(number)) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        return ScriptRuntime.toInt32(number);
    }

    public static void init(Context context, Scriptable scriptable, boolean z) {
        new NativeDataView().exportAsJSClass(17, scriptable, z);
    }

    private static NativeDataView js_constructor(Object[] objArr) {
        int length;
        int i = 0;
        if (NativeArrayBufferView.isArg(objArr, 0)) {
            Object obj = objArr[0];
            if (obj instanceof NativeArrayBuffer) {
                NativeArrayBuffer nativeArrayBuffer = (NativeArrayBuffer) obj;
                if (NativeArrayBufferView.isArg(objArr, 1)) {
                    double number = ScriptRuntime.toNumber(objArr[1]);
                    if (Double.isInfinite(number)) {
                        throw ScriptRuntime.rangeError("offset out of range");
                    }
                    i = ScriptRuntime.toInt32(number);
                }
                if (NativeArrayBufferView.isArg(objArr, 2)) {
                    double number2 = ScriptRuntime.toNumber(objArr[2]);
                    if (Double.isInfinite(number2)) {
                        throw ScriptRuntime.rangeError("offset out of range");
                    }
                    length = ScriptRuntime.toInt32(number2);
                } else {
                    length = nativeArrayBuffer.getLength() - i;
                }
                if (length < 0) {
                    throw ScriptRuntime.rangeError("length out of range");
                }
                if (i < 0 || i + length > nativeArrayBuffer.getLength()) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                return new NativeDataView(nativeArrayBuffer, i, length);
            }
        }
        throw ScriptRuntime.constructError("TypeError", "Missing parameters");
    }

    private Object js_getFloat(int i, Object[] objArr) {
        int determinePos = determinePos(objArr);
        rangeCheck(determinePos, i);
        boolean z = NativeArrayBufferView.isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1]);
        if (i == 4) {
            return ByteIo.readFloat32(this.arrayBuffer.buffer, this.offset + determinePos, z);
        }
        if (i == 8) {
            return ByteIo.readFloat64(this.arrayBuffer.buffer, this.offset + determinePos, z);
        }
        throw new AssertionError();
    }

    private Object js_getInt(int i, boolean z, Object[] objArr) {
        int determinePos = determinePos(objArr);
        rangeCheck(determinePos, i);
        boolean z2 = NativeArrayBufferView.isArg(objArr, 1) && i > 1 && ScriptRuntime.toBoolean(objArr[1]);
        if (i == 1) {
            byte[] bArr = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt8(bArr, this.offset + determinePos) : ByteIo.readUint8(bArr, this.offset + determinePos);
        }
        if (i == 2) {
            byte[] bArr2 = this.arrayBuffer.buffer;
            return z ? ByteIo.readInt16(bArr2, this.offset + determinePos, z2) : ByteIo.readUint16(bArr2, this.offset + determinePos, z2);
        }
        if (i != 4) {
            throw new AssertionError();
        }
        byte[] bArr3 = this.arrayBuffer.buffer;
        return z ? ByteIo.readInt32(bArr3, this.offset + determinePos, z2) : ByteIo.readUint32(bArr3, this.offset + determinePos, z2);
    }

    private void js_setFloat(int i, Object[] objArr) {
        int determinePos = determinePos(objArr);
        if (determinePos < 0) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        boolean z = NativeArrayBufferView.isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2]);
        double number = objArr.length > 1 ? ScriptRuntime.toNumber(objArr[1]) : Double.NaN;
        if (determinePos + i > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        if (i == 4) {
            ByteIo.writeFloat32(this.arrayBuffer.buffer, this.offset + determinePos, number, z);
        } else {
            if (i != 8) {
                throw new AssertionError();
            }
            ByteIo.writeFloat64(this.arrayBuffer.buffer, this.offset + determinePos, number, z);
        }
    }

    private void js_setInt(int i, boolean z, Object[] objArr) {
        int determinePos = determinePos(objArr);
        if (determinePos < 0) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        boolean z2 = NativeArrayBufferView.isArg(objArr, 2) && i > 1 && ScriptRuntime.toBoolean(objArr[2]);
        Object obj = ScriptRuntime.zeroObj;
        if (objArr.length > 1) {
            obj = objArr[1];
        }
        if (i == 1) {
            if (z) {
                int int8 = Conversions.toInt8(obj);
                if (i + determinePos > this.byteLength) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                ByteIo.writeInt8(this.arrayBuffer.buffer, this.offset + determinePos, int8);
                return;
            }
            int uint8 = Conversions.toUint8(obj);
            if (i + determinePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeUint8(this.arrayBuffer.buffer, this.offset + determinePos, uint8);
            return;
        }
        if (i == 2) {
            if (z) {
                int int16 = Conversions.toInt16(obj);
                if (i + determinePos > this.byteLength) {
                    throw ScriptRuntime.rangeError("offset out of range");
                }
                ByteIo.writeInt16(this.arrayBuffer.buffer, this.offset + determinePos, int16, z2);
                return;
            }
            int uint16 = Conversions.toUint16(obj);
            if (i + determinePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeUint16(this.arrayBuffer.buffer, this.offset + determinePos, uint16, z2);
            return;
        }
        if (i != 4) {
            throw new AssertionError();
        }
        if (z) {
            int int32 = Conversions.toInt32(obj);
            if (i + determinePos > this.byteLength) {
                throw ScriptRuntime.rangeError("offset out of range");
            }
            ByteIo.writeInt32(this.arrayBuffer.buffer, this.offset + determinePos, int32, z2);
            return;
        }
        long uint32 = Conversions.toUint32(obj);
        if (i + determinePos > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
        ByteIo.writeUint32(this.arrayBuffer.buffer, this.offset + determinePos, uint32, z2);
    }

    private void rangeCheck(int i, int i2) {
        if (i < 0 || i + i2 > this.byteLength) {
            throw ScriptRuntime.rangeError("offset out of range");
        }
    }

    private static NativeDataView realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable instanceof NativeDataView) {
            return (NativeDataView) scriptable;
        }
        throw IdScriptableObject.incompatibleCallError(idFunctionObject);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(getClassName())) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        switch (methodId) {
            case 1:
                return js_constructor(objArr);
            case 2:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, true, objArr);
            case 3:
                return realThis(scriptable2, idFunctionObject).js_getInt(1, false, objArr);
            case 4:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, true, objArr);
            case 5:
                return realThis(scriptable2, idFunctionObject).js_getInt(2, false, objArr);
            case 6:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, true, objArr);
            case 7:
                return realThis(scriptable2, idFunctionObject).js_getInt(4, false, objArr);
            case 8:
                return realThis(scriptable2, idFunctionObject).js_getFloat(4, objArr);
            case 9:
                return realThis(scriptable2, idFunctionObject).js_getFloat(8, objArr);
            case 10:
                realThis(scriptable2, idFunctionObject).js_setInt(1, true, objArr);
                return Undefined.instance;
            case 11:
                realThis(scriptable2, idFunctionObject).js_setInt(1, false, objArr);
                return Undefined.instance;
            case 12:
                realThis(scriptable2, idFunctionObject).js_setInt(2, true, objArr);
                return Undefined.instance;
            case 13:
                realThis(scriptable2, idFunctionObject).js_setInt(2, false, objArr);
                return Undefined.instance;
            case 14:
                realThis(scriptable2, idFunctionObject).js_setInt(4, true, objArr);
                return Undefined.instance;
            case 15:
                realThis(scriptable2, idFunctionObject).js_setInt(4, false, objArr);
                return Undefined.instance;
            case 16:
                realThis(scriptable2, idFunctionObject).js_setFloat(4, objArr);
                return Undefined.instance;
            case 17:
                realThis(scriptable2, idFunctionObject).js_setFloat(8, objArr);
                return Undefined.instance;
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int i = 8;
        switch (str.length()) {
            case 7:
                char charAt = str.charAt(0);
                if (charAt != 'g') {
                    if (charAt == 's') {
                        str2 = "setInt8";
                        i = 10;
                        break;
                    }
                    str2 = null;
                    i = 0;
                    break;
                } else {
                    str2 = "getInt8";
                    i = 2;
                    break;
                }
            case 8:
                i = 6;
                char charAt2 = str.charAt(6);
                if (charAt2 == '1') {
                    char charAt3 = str.charAt(0);
                    if (charAt3 != 'g') {
                        if (charAt3 == 's') {
                            str2 = "setInt16";
                            i = 12;
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        str2 = "getInt16";
                        i = 4;
                        break;
                    }
                } else if (charAt2 == '3') {
                    char charAt4 = str.charAt(0);
                    if (charAt4 == 'g') {
                        str2 = "getInt32";
                        break;
                    } else {
                        if (charAt4 == 's') {
                            str2 = "setInt32";
                            i = 14;
                            break;
                        }
                        str2 = null;
                        i = 0;
                    }
                } else {
                    if (charAt2 == 't') {
                        char charAt5 = str.charAt(0);
                        if (charAt5 != 'g') {
                            if (charAt5 == 's') {
                                str2 = "setUint8";
                                i = 11;
                                break;
                            }
                        } else {
                            str2 = "getUint8";
                            i = 3;
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 9:
                char charAt6 = str.charAt(0);
                if (charAt6 == 'g') {
                    char charAt7 = str.charAt(8);
                    if (charAt7 != '2') {
                        if (charAt7 == '6') {
                            str2 = "getUint16";
                            i = 5;
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        str2 = "getUint32";
                        i = 7;
                        break;
                    }
                } else {
                    if (charAt6 == 's') {
                        char charAt8 = str.charAt(8);
                        if (charAt8 != '2') {
                            if (charAt8 == '6') {
                                str2 = "setUint16";
                                i = 13;
                                break;
                            }
                        } else {
                            str2 = "setUint32";
                            i = 15;
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 10:
                char charAt9 = str.charAt(0);
                if (charAt9 == 'g') {
                    char charAt10 = str.charAt(9);
                    if (charAt10 != '2') {
                        if (charAt10 == '4') {
                            str2 = "getFloat64";
                            i = 9;
                            break;
                        }
                        str2 = null;
                        i = 0;
                        break;
                    } else {
                        str2 = "getFloat32";
                        break;
                    }
                } else {
                    if (charAt9 == 's') {
                        char charAt11 = str.charAt(9);
                        if (charAt11 != '2') {
                            if (charAt11 == '4') {
                                str2 = "setFloat64";
                                i = 17;
                                break;
                            }
                        } else {
                            str2 = "setFloat32";
                            i = 16;
                            break;
                        }
                    }
                    str2 = null;
                    i = 0;
                }
            case 11:
                str2 = "constructor";
                i = 1;
                break;
            default:
                str2 = null;
                i = 0;
                break;
        }
        if (str2 == null || str2 == str || str2.equals(str)) {
            return i;
        }
        return 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 2;
        switch (i) {
            case 1:
                i2 = 3;
                str = "constructor";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 2:
                str2 = "getInt8";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 3:
                str2 = "getUint8";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 4:
                str2 = "getInt16";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 5:
                str2 = "getUint16";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 6:
                str2 = "getInt32";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 7:
                str2 = "getUint32";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 8:
                str2 = "getFloat32";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 9:
                str2 = "getFloat64";
                str = str2;
                i2 = 1;
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 10:
                str = "setInt8";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 11:
                str = "setUint8";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 12:
                str = "setInt16";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 13:
                str = "setUint16";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 14:
                str = "setInt32";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 15:
                str = "setUint32";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 16:
                str = "setFloat32";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            case 17:
                str = "setFloat64";
                initPrototypeMethod(getClassName(), i, str, i2);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }
}
