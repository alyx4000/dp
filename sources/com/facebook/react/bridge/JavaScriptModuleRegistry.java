package com.facebook.react.bridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class JavaScriptModuleRegistry {
    private final HashMap<Class<? extends JavaScriptModule>, JavaScriptModule> mModuleInstances = new HashMap<>();

    public synchronized <T extends JavaScriptModule> T getJavaScriptModule(CatalystInstance catalystInstance, Class<T> cls) {
        T t = (T) this.mModuleInstances.get(cls);
        if (t != null) {
            return t;
        }
        T t2 = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new JavaScriptModuleInvocationHandler(catalystInstance, cls));
        this.mModuleInstances.put(cls, t2);
        return t2;
    }

    private static class JavaScriptModuleInvocationHandler implements InvocationHandler {
        private final CatalystInstance mCatalystInstance;
        private final Class<? extends JavaScriptModule> mModuleInterface;
        private String mName;

        public JavaScriptModuleInvocationHandler(CatalystInstance catalystInstance, Class<? extends JavaScriptModule> cls) {
            this.mCatalystInstance = catalystInstance;
            this.mModuleInterface = cls;
        }

        private String getJSModuleName() {
            if (this.mName == null) {
                this.mName = JavaScriptModuleRegistry.getJSModuleName(this.mModuleInterface);
            }
            return this.mName;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            this.mCatalystInstance.callFunction(getJSModuleName(), method.getName(), objArr != null ? Arguments.fromJavaArgs(objArr) : new WritableNativeArray());
            return null;
        }
    }

    public static String getJSModuleName(Class<? extends JavaScriptModule> cls) {
        String simpleName = cls.getSimpleName();
        int lastIndexOf = simpleName.lastIndexOf(36);
        return lastIndexOf != -1 ? simpleName.substring(lastIndexOf + 1) : simpleName;
    }
}
