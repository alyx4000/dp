package sdk.pendo.io.utilities.script;

import external.sdk.pendo.io.mozilla.javascript.BaseFunction;
import external.sdk.pendo.io.mozilla.javascript.Context;
import external.sdk.pendo.io.mozilla.javascript.NativeJavaClass;
import external.sdk.pendo.io.mozilla.javascript.NativeJavaObject;
import external.sdk.pendo.io.mozilla.javascript.Scriptable;
import external.sdk.pendo.io.mozilla.javascript.ScriptableObject;
import external.sdk.pendo.io.mozilla.javascript.WrapFactory;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes3.dex */
class JavascriptSandboxWrapFactory extends WrapFactory {
    private final Set<Class<?>> mReplacedClasses = new HashSet();
    private final ScriptSandbox mShutter;

    JavascriptSandboxWrapFactory(ScriptSandbox scriptSandbox) {
        this.mShutter = scriptSandbox;
    }

    private Class<?> ensureReplacedClass(Scriptable scriptable, Object obj, Class<?> cls) {
        if (cls == null && obj != null) {
            cls = obj.getClass();
        }
        if (cls != null && !cls.isPrimitive() && !cls.getName().startsWith("java.") && this.mReplacedClasses.add(cls)) {
            replaceJavaNativeClass(cls, scriptable);
        }
        return cls;
    }

    private void replaceJavaNativeClass(final Class<?> cls, Scriptable scriptable) {
        Object jsToJava = Context.jsToJava(ScriptableObject.getProperty(scriptable, "Packages"), Object.class);
        String[] split = cls.getName().split("\\.");
        int length = split.length;
        Object obj = null;
        int i = 0;
        while (i < length) {
            Object property = ScriptableObject.getProperty((Scriptable) jsToJava, split[i]);
            i++;
            obj = jsToJava;
            jsToJava = property;
        }
        NativeJavaClass nativeJavaClass = new NativeJavaClass(scriptable, cls) { // from class: sdk.pendo.io.utilities.script.JavascriptSandboxWrapFactory.2
            @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaClass, external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
            public Object get(String str, Scriptable scriptable2) {
                Object obj2 = super.get(str, scriptable2);
                if (obj2 instanceof BaseFunction) {
                    if (!JavascriptSandboxWrapFactory.this.mShutter.allowStaticMethodAccess(cls, str)) {
                        return Scriptable.NOT_FOUND;
                    }
                } else if (!JavascriptSandboxWrapFactory.this.mShutter.allowStaticFieldAccess(cls, str)) {
                    return Scriptable.NOT_FOUND;
                }
                return obj2;
            }
        };
        if (obj == null) {
            PendoLogger.d("Holder is null, bailing out.", new Object[0]);
        } else {
            ScriptableObject.putProperty((Scriptable) obj, cls.getSimpleName(), nativeJavaClass);
            ScriptableObject.putProperty(scriptable, cls.getSimpleName(), nativeJavaClass);
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.WrapFactory
    public Object wrap(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        ensureReplacedClass(scriptable, obj, cls);
        return super.wrap(context, scriptable, obj, cls);
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.WrapFactory
    public Scriptable wrapAsJavaObject(Context context, Scriptable scriptable, Object obj, Class<?> cls) {
        final Class<?> ensureReplacedClass = ensureReplacedClass(scriptable, obj, cls);
        return new NativeJavaObject(scriptable, obj, cls) { // from class: sdk.pendo.io.utilities.script.JavascriptSandboxWrapFactory.1
            private final Map<String, Boolean> mInstanceMethodToAllowed = new HashMap();

            @Override // external.sdk.pendo.io.mozilla.javascript.NativeJavaObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
            public Object get(String str, Scriptable scriptable2) {
                Object obj2 = super.get(str, scriptable2);
                if (obj2 instanceof BaseFunction) {
                    String str2 = ensureReplacedClass.getName() + "." + str;
                    Boolean bool = this.mInstanceMethodToAllowed.get(str2);
                    if (bool == null) {
                        bool = Boolean.valueOf(JavascriptSandboxWrapFactory.this.mShutter.allowMethodAccess(ensureReplacedClass, this.javaObject, str));
                        this.mInstanceMethodToAllowed.put(str2, bool);
                    }
                    if (!bool.booleanValue()) {
                        return Scriptable.NOT_FOUND;
                    }
                } else if (!JavascriptSandboxWrapFactory.this.mShutter.allowFieldAccess(ensureReplacedClass, this.javaObject, str)) {
                    return Scriptable.NOT_FOUND;
                }
                return obj2;
            }
        };
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.WrapFactory
    public Scriptable wrapNewObject(Context context, Scriptable scriptable, Object obj) {
        ensureReplacedClass(scriptable, obj, null);
        return super.wrapNewObject(context, scriptable, obj);
    }
}
