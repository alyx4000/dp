package external.sdk.pendo.io.mozilla.javascript;

import com.iterable.iterableapi.IterableConstants;
import java.io.ObjectInputStream;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class NativeWeakMap extends IdScriptableObject {
    private static final int Id_constructor = 1;
    private static final int Id_delete = 2;
    private static final int Id_get = 3;
    private static final int Id_has = 4;
    private static final int Id_set = 5;
    private static final int MAX_PROTOTYPE_ID = 6;
    private static final int SymbolId_toStringTag = 6;
    private static final long serialVersionUID = 8670434366883930453L;
    private boolean instanceOfWeakMap = false;
    private transient WeakHashMap<Scriptable, Object> map = new WeakHashMap<>();
    private static final Object MAP_TAG = "WeakMap";
    private static final Object NULL_VALUE = new Object();

    static void init(Scriptable scriptable, boolean z) {
        new NativeWeakMap().exportAsJSClass(6, scriptable, z);
    }

    private Object js_delete(Object obj) {
        if (ScriptRuntime.isObject(obj)) {
            return Boolean.valueOf(this.map.remove(obj) != null);
        }
        return Boolean.FALSE;
    }

    private Object js_get(Object obj) {
        Object obj2;
        if (ScriptRuntime.isObject(obj) && (obj2 = this.map.get(obj)) != null) {
            if (obj2 == NULL_VALUE) {
                return null;
            }
            return obj2;
        }
        return Undefined.instance;
    }

    private Object js_has(Object obj) {
        return !ScriptRuntime.isObject(obj) ? Boolean.FALSE : Boolean.valueOf(this.map.containsKey(obj));
    }

    private Object js_set(Object obj, Object obj2) {
        if (!ScriptRuntime.isObject(obj)) {
            throw ScriptRuntime.typeError1("msg.arg.not.object", ScriptRuntime.typeof(obj));
        }
        if (obj2 == null) {
            obj2 = NULL_VALUE;
        }
        this.map.put((Scriptable) obj, obj2);
        return this;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        this.map = new WeakHashMap<>();
    }

    private static NativeWeakMap realThis(Scriptable scriptable, IdFunctionObject idFunctionObject) {
        if (scriptable == null) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        try {
            NativeWeakMap nativeWeakMap = (NativeWeakMap) scriptable;
            if (nativeWeakMap.instanceOfWeakMap) {
                return nativeWeakMap;
            }
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        } catch (ClassCastException unused) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(MAP_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            if (scriptable2 != null) {
                throw ScriptRuntime.typeError1("msg.no.new", "WeakMap");
            }
            NativeWeakMap nativeWeakMap = new NativeWeakMap();
            nativeWeakMap.instanceOfWeakMap = true;
            if (objArr.length > 0) {
                NativeMap.loadFromIterable(context, scriptable, nativeWeakMap, objArr[0]);
            }
            return nativeWeakMap;
        }
        if (methodId == 2) {
            return realThis(scriptable2, idFunctionObject).js_delete(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (methodId == 3) {
            return realThis(scriptable2, idFunctionObject).js_get(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (methodId == 4) {
            return realThis(scriptable2, idFunctionObject).js_has(objArr.length > 0 ? objArr[0] : Undefined.instance);
        }
        if (methodId == 5) {
            return realThis(scriptable2, idFunctionObject).js_set(objArr.length > 0 ? objArr[0] : Undefined.instance, objArr.length > 1 ? objArr[1] : Undefined.instance);
        }
        throw new IllegalArgumentException("WeakMap.prototype has no method: " + idFunctionObject.getFunctionName());
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(Symbol symbol) {
        return SymbolKey.TO_STRING_TAG.equals(symbol) ? 6 : 0;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return "WeakMap";
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        int i2;
        String str;
        String str2;
        if (i == 6) {
            initPrototypeValue(6, SymbolKey.TO_STRING_TAG, getClassName(), 3);
            return;
        }
        if (i != 1) {
            if (i == 2) {
                str2 = IterableConstants.ITERABLE_IN_APP_ACTION_DELETE;
            } else if (i == 3) {
                str2 = "get";
            } else if (i == 4) {
                str2 = "has";
            } else {
                if (i != 5) {
                    throw new IllegalArgumentException(String.valueOf(i));
                }
                str = "set";
                i2 = 2;
            }
            str = str2;
            i2 = 1;
        } else {
            i2 = 0;
            str = "constructor";
        }
        initPrototypeMethod(MAP_TAG, i, str, (String) null, i2);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected int findPrototypeId(String str) {
        String str2;
        int length = str.length();
        int i = 1;
        if (length != 3) {
            if (length == 6) {
                str2 = IterableConstants.ITERABLE_IN_APP_ACTION_DELETE;
                i = 2;
            } else if (length == 11) {
                str2 = "constructor";
            }
            if (str2 != null || str2 == str || str2.equals(str)) {
                return i;
            }
            return 0;
        }
        char charAt = str.charAt(0);
        if (charAt == 'g') {
            if (str.charAt(2) == 't' && str.charAt(1) == 'e') {
                return 3;
            }
        } else if (charAt == 'h') {
            if (str.charAt(2) == 's' && str.charAt(1) == 'a') {
                return 4;
            }
        } else if (charAt == 's' && str.charAt(2) == 't' && str.charAt(1) == 'e') {
            return 5;
        }
        str2 = null;
        i = 0;
        if (str2 != null) {
        }
        return i;
    }
}
