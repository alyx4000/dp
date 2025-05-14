package sdk.pendo.io.utilities.script;

import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.g9.d;

/* loaded from: classes3.dex */
final class JavascriptSandboxImpl implements ScriptSandbox {
    private static volatile JavascriptSandboxImpl INSTANCE;

    private JavascriptSandboxImpl() {
    }

    public static synchronized JavascriptSandboxImpl getInstance() {
        JavascriptSandboxImpl javascriptSandboxImpl;
        synchronized (JavascriptSandboxImpl.class) {
            if (INSTANCE == null) {
                INSTANCE = new JavascriptSandboxImpl();
            }
            javascriptSandboxImpl = INSTANCE;
        }
        return javascriptSandboxImpl;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowClassAccess(Class<?> cls) {
        if (cls.equals(PendoInternal.m().getClass()) || cls.equals(PendoInternal.class.getClassLoader().getClass())) {
            return true;
        }
        String canonicalName = cls.getCanonicalName();
        if (canonicalName.startsWith("sdk.pendo.io.") || canonicalName.startsWith("external.sdk.pendo.io.") || canonicalName.startsWith("java.") || canonicalName.startsWith("org.json.")) {
            return true;
        }
        d.a(d.c.JS_ERROR, "Trying to access an unauthorized class: '" + canonicalName + "'");
        return false;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowFieldAccess(Class<?> cls, Object obj, String str) {
        return true;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowMethodAccess(Class<?> cls, Object obj, String str) {
        return true;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowStaticFieldAccess(Class<?> cls, String str) {
        return true;
    }

    @Override // sdk.pendo.io.utilities.script.ScriptSandbox
    public boolean allowStaticMethodAccess(Class<?> cls, String str) {
        return true;
    }
}
