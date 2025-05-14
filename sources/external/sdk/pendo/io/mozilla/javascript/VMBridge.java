package external.sdk.pendo.io.mozilla.javascript;

import java.lang.reflect.AccessibleObject;

/* loaded from: classes2.dex */
public abstract class VMBridge {
    static final VMBridge instance = makeInstance();

    private static VMBridge makeInstance() {
        VMBridge vMBridge;
        String[] strArr = {"external.sdk.pendo.io.mozilla.javascript.VMBridge_custom", "external.sdk.pendo.io.mozilla.javascript.jdk18.VMBridge_jdk18"};
        for (int i = 0; i != 2; i++) {
            Class<?> classOrNull = Kit.classOrNull(strArr[i]);
            if (classOrNull != null && (vMBridge = (VMBridge) Kit.newInstanceOrNull(classOrNull)) != null) {
                return vMBridge;
            }
        }
        throw new IllegalStateException("Failed to create VMBridge instance");
    }

    protected abstract Context getContext(Object obj);

    protected abstract Object getInterfaceProxyHelper(ContextFactory contextFactory, Class<?>[] clsArr);

    protected abstract Object getThreadContextHelper();

    protected abstract Object newInterfaceProxy(Object obj, ContextFactory contextFactory, InterfaceAdapter interfaceAdapter, Object obj2, Scriptable scriptable);

    protected abstract void setContext(Object obj, Context context);

    protected abstract boolean tryToMakeAccessible(AccessibleObject accessibleObject);
}
