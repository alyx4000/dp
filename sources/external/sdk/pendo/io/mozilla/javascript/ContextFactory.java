package external.sdk.pendo.io.mozilla.javascript;

import external.sdk.pendo.io.mozilla.javascript.xml.XMLLib;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes2.dex */
public class ContextFactory {
    private static ContextFactory global = new ContextFactory();
    private static volatile boolean hasCustomGlobal;
    private ClassLoader applicationClassLoader;
    private boolean disabledListening;
    private volatile Object listeners;
    private final Object listenersLock = new Object();
    private volatile boolean sealed;

    public interface GlobalSetter {
        ContextFactory getContextFactoryGlobal();

        void setContextFactoryGlobal(ContextFactory contextFactory);
    }

    public interface Listener {
        void contextCreated(Context context);

        void contextReleased(Context context);
    }

    public static ContextFactory getGlobal() {
        return global;
    }

    public static synchronized GlobalSetter getGlobalSetter() {
        GlobalSetter globalSetter;
        synchronized (ContextFactory.class) {
            if (hasCustomGlobal) {
                throw new IllegalStateException();
            }
            hasCustomGlobal = true;
            globalSetter = new GlobalSetter() { // from class: external.sdk.pendo.io.mozilla.javascript.ContextFactory.1GlobalSetterImpl
                @Override // external.sdk.pendo.io.mozilla.javascript.ContextFactory.GlobalSetter
                public ContextFactory getContextFactoryGlobal() {
                    return ContextFactory.global;
                }

                @Override // external.sdk.pendo.io.mozilla.javascript.ContextFactory.GlobalSetter
                public void setContextFactoryGlobal(ContextFactory contextFactory) {
                    if (contextFactory == null) {
                        contextFactory = new ContextFactory();
                    }
                    ContextFactory unused = ContextFactory.global = contextFactory;
                }
            };
        }
        return globalSetter;
    }

    public static boolean hasExplicitGlobal() {
        return hasCustomGlobal;
    }

    public static synchronized void initGlobal(ContextFactory contextFactory) {
        synchronized (ContextFactory.class) {
            if (contextFactory == null) {
                throw new IllegalArgumentException();
            }
            if (hasCustomGlobal) {
                throw new IllegalStateException();
            }
            hasCustomGlobal = true;
            global = contextFactory;
        }
    }

    private static boolean isDom3Present() {
        Class<?> classOrNull = Kit.classOrNull("org.w3c.dom.Node");
        if (classOrNull == null) {
            return false;
        }
        try {
            classOrNull.getMethod("getUserData", String.class);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public final void addListener(Listener listener) {
        checkNotSealed();
        synchronized (this.listenersLock) {
            if (this.disabledListening) {
                throw new IllegalStateException();
            }
            this.listeners = Kit.addListener(this.listeners, listener);
        }
    }

    public final <T> T call(ContextAction<T> contextAction) {
        return (T) Context.call(this, contextAction);
    }

    protected final void checkNotSealed() {
        if (this.sealed) {
            throw new IllegalStateException();
        }
    }

    protected GeneratedClassLoader createClassLoader(final ClassLoader classLoader) {
        return (GeneratedClassLoader) AccessController.doPrivileged(new PrivilegedAction<DefiningClassLoader>() { // from class: external.sdk.pendo.io.mozilla.javascript.ContextFactory.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // java.security.PrivilegedAction
            public DefiningClassLoader run() {
                return new DefiningClassLoader(classLoader);
            }
        });
    }

    final void disableContextListening() {
        checkNotSealed();
        synchronized (this.listenersLock) {
            this.disabledListening = true;
            this.listeners = null;
        }
    }

    protected Object doTopCall(Callable callable, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        Object call = callable.call(context, scriptable, scriptable2, objArr);
        return call instanceof ConsString ? call.toString() : call;
    }

    @Deprecated
    public final Context enter() {
        return enterContext(null);
    }

    public Context enterContext() {
        return enterContext(null);
    }

    @Deprecated
    public final void exit() {
        Context.exit();
    }

    public final ClassLoader getApplicationClassLoader() {
        return this.applicationClassLoader;
    }

    protected XMLLib.Factory getE4xImplementationFactory() {
        if (isDom3Present()) {
            return XMLLib.Factory.create("external.sdk.pendo.io.mozilla.javascript.xmlimpl.XMLLibImpl");
        }
        return null;
    }

    protected boolean hasFeature(Context context, int i) {
        switch (i) {
            case 1:
                int languageVersion = context.getLanguageVersion();
                return languageVersion == 100 || languageVersion == 110 || languageVersion == 120;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return context.getLanguageVersion() == 120;
            case 5:
                return true;
            case 6:
                int languageVersion2 = context.getLanguageVersion();
                return languageVersion2 == 0 || languageVersion2 >= 160;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
                return false;
            case 14:
                return true;
            case 15:
                return context.getLanguageVersion() <= 170;
            case 16:
                return context.getLanguageVersion() >= 200;
            case 17:
            case 18:
            case 19:
                return false;
            case 20:
                return true;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }

    public final void initApplicationClassLoader(ClassLoader classLoader) {
        if (classLoader == null) {
            throw new IllegalArgumentException("loader is null");
        }
        if (!Kit.testIfCanLoadRhinoClasses(classLoader)) {
            throw new IllegalArgumentException("Loader can not resolve Rhino classes");
        }
        if (this.applicationClassLoader != null) {
            throw new IllegalStateException("applicationClassLoader can only be set once");
        }
        checkNotSealed();
        this.applicationClassLoader = classLoader;
    }

    public final boolean isSealed() {
        return this.sealed;
    }

    protected Context makeContext() {
        return new Context(this);
    }

    protected void observeInstructionCount(Context context, int i) {
    }

    protected void onContextCreated(Context context) {
        Object obj = this.listeners;
        int i = 0;
        while (true) {
            Listener listener = (Listener) Kit.getListener(obj, i);
            if (listener == null) {
                return;
            }
            listener.contextCreated(context);
            i++;
        }
    }

    protected void onContextReleased(Context context) {
        Object obj = this.listeners;
        int i = 0;
        while (true) {
            Listener listener = (Listener) Kit.getListener(obj, i);
            if (listener == null) {
                return;
            }
            listener.contextReleased(context);
            i++;
        }
    }

    public final void removeListener(Listener listener) {
        checkNotSealed();
        synchronized (this.listenersLock) {
            if (this.disabledListening) {
                throw new IllegalStateException();
            }
            this.listeners = Kit.removeListener(this.listeners, listener);
        }
    }

    public final void seal() {
        checkNotSealed();
        this.sealed = true;
    }

    public final Context enterContext(Context context) {
        return Context.enter(context, this);
    }
}
