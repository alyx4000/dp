package external.sdk.pendo.io.mozilla.javascript;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class WrapFactory {
    private boolean javaPrimitiveWrap = true;

    public final boolean isJavaPrimitiveWrap() {
        return this.javaPrimitiveWrap;
    }

    public final void setJavaPrimitiveWrap(boolean z) {
        Context currentContext = Context.getCurrentContext();
        if (currentContext != null && currentContext.isSealed()) {
            Context.onSealedMutation();
        }
        this.javaPrimitiveWrap = z;
    }

    public Object wrap(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        Object obj2;
        if (obj == null || obj == (obj2 = Undefined.instance) || (obj instanceof Scriptable)) {
            return obj;
        }
        if (cls != null && cls.isPrimitive()) {
            return cls == Void.TYPE ? obj2 : cls == Character.TYPE ? Integer.valueOf(((Character) obj).charValue()) : obj;
        }
        if (!isJavaPrimitiveWrap()) {
            if ((obj instanceof String) || (obj instanceof Boolean) || (obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Double)) {
                return obj;
            }
            if (obj instanceof Character) {
                return String.valueOf(((Character) obj).charValue());
            }
        }
        return obj.getClass().isArray() ? NativeJavaArray.wrap(scriptable, obj) : wrapAsJavaObject(context, scriptable, obj, cls);
    }

    public Scriptable wrapAsJavaObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        return List.class.isAssignableFrom(obj.getClass()) ? new NativeJavaList(scriptable, obj) : Map.class.isAssignableFrom(obj.getClass()) ? new NativeJavaMap(scriptable, obj) : new NativeJavaObject(scriptable, obj, cls);
    }

    public Scriptable wrapJavaClass(Context context, Scriptable scriptable, Class<?> cls) {
        return new NativeJavaClass(scriptable, cls);
    }

    public Scriptable wrapNewObject(Context context, Scriptable scriptable, Object obj) {
        return obj instanceof Scriptable ? (Scriptable) obj : obj.getClass().isArray() ? NativeJavaArray.wrap(scriptable, obj) : wrapAsJavaObject(context, scriptable, obj, null);
    }
}
