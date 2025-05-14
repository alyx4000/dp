package expo.modules;

import android.app.Application;
import androidx.collection.ArrayMap;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleSpec;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: ReactNativeHostWrapperBase.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0014J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\nH\u0014J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013J\u001d\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$2\u0006\u0010%\u001a\u00020\nH\u0000¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0004\u001a\u00020\u0001X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006)"}, d2 = {"Lexpo/modules/ReactNativeHostWrapperBase;", "Lcom/facebook/react/ReactNativeHost;", "application", "Landroid/app/Application;", "host", "(Landroid/app/Application;Lcom/facebook/react/ReactNativeHost;)V", "getHost", "()Lcom/facebook/react/ReactNativeHost;", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "reactNativeHostHandlers", "", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "kotlin.jvm.PlatformType", "getReactNativeHostHandlers$expo_release", "()Ljava/util/List;", "createReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getBundleAssetName", "getJSBundleFile", "getJSIModulePackage", "Lcom/facebook/react/bridge/JSIModulePackage;", "getJSMainModuleName", "getJavaScriptExecutorFactory", "Lcom/facebook/react/bridge/JavaScriptExecutorFactory;", "getPackages", "", "Lcom/facebook/react/ReactPackage;", "getUseDeveloperSupport", "", "injectHostReactInstanceManager", "", "reactInstanceManager", "invokeDelegateMethod", ExifInterface.GPS_DIRECTION_TRUE, "name", "invokeDelegateMethod$expo_release", "(Ljava/lang/String;)Ljava/lang/Object;", "JSIModuleContainerPackage", "expo_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ReactNativeHostWrapperBase extends ReactNativeHost {
    private final ReactNativeHost host;
    private final ArrayMap<String, Method> methodMap;
    private final List<ReactNativeHostHandler> reactNativeHostHandlers;

    protected final ReactNativeHost getHost() {
        return this.host;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactNativeHostWrapperBase(Application application, ReactNativeHost host) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(host, "host");
        this.host = host;
        List<Package> packageList = ExpoModulesPackage.INSTANCE.getPackageList();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = packageList.iterator();
        while (it.hasNext()) {
            List<? extends ReactNativeHostHandler> createReactNativeHostHandlers = ((Package) it.next()).createReactNativeHostHandlers(application);
            Intrinsics.checkNotNullExpressionValue(createReactNativeHostHandlers, "it.createReactNativeHostHandlers(application)");
            CollectionsKt.addAll(arrayList, createReactNativeHostHandlers);
        }
        this.reactNativeHostHandlers = arrayList;
        this.methodMap = new ArrayMap<>();
    }

    public final List<ReactNativeHostHandler> getReactNativeHostHandlers$expo_release() {
        return this.reactNativeHostHandlers;
    }

    @Override // com.facebook.react.ReactNativeHost
    protected ReactInstanceManager createReactInstanceManager() {
        final boolean useDeveloperSupport = getUseDeveloperSupport();
        Iterator<T> it = this.reactNativeHostHandlers.iterator();
        while (it.hasNext()) {
            ((ReactNativeHostHandler) it.next()).onWillCreateReactInstanceManager(useDeveloperSupport);
        }
        ReactInstanceManager result = (ReactInstanceManager) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new Function1<ReactNativeHostHandler, ReactInstanceManager>() { // from class: expo.modules.ReactNativeHostWrapperBase$createReactInstanceManager$result$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ReactInstanceManager invoke(ReactNativeHostHandler reactNativeHostHandler) {
                return reactNativeHostHandler.createReactInstanceManager(useDeveloperSupport);
            }
        }));
        if (result == null) {
            result = super.createReactInstanceManager();
        }
        Iterator<T> it2 = this.reactNativeHostHandlers.iterator();
        while (it2.hasNext()) {
            ((ReactNativeHostHandler) it2.next()).onDidCreateReactInstanceManager(result, useDeveloperSupport);
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        injectHostReactInstanceManager(result);
        return result;
    }

    @Override // com.facebook.react.ReactNativeHost
    protected JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        JavaScriptExecutorFactory javaScriptExecutorFactory = (JavaScriptExecutorFactory) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new Function1<ReactNativeHostHandler, JavaScriptExecutorFactory>() { // from class: expo.modules.ReactNativeHostWrapperBase$getJavaScriptExecutorFactory$1
            @Override // kotlin.jvm.functions.Function1
            public final JavaScriptExecutorFactory invoke(ReactNativeHostHandler reactNativeHostHandler) {
                return reactNativeHostHandler.getJavaScriptExecutorFactory();
            }
        }));
        return javaScriptExecutorFactory == null ? (JavaScriptExecutorFactory) invokeDelegateMethod$expo_release("getJavaScriptExecutorFactory") : javaScriptExecutorFactory;
    }

    @Override // com.facebook.react.ReactNativeHost
    protected JSIModulePackage getJSIModulePackage() {
        return new JSIModuleContainerPackage((JSIModulePackage) invokeDelegateMethod$expo_release("getJSIModulePackage"));
    }

    @Override // com.facebook.react.ReactNativeHost
    protected String getJSMainModuleName() {
        return (String) invokeDelegateMethod$expo_release("getJSMainModuleName");
    }

    @Override // com.facebook.react.ReactNativeHost
    protected String getJSBundleFile() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new Function1<ReactNativeHostHandler, String>() { // from class: expo.modules.ReactNativeHostWrapperBase$getJSBundleFile$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ReactNativeHostHandler reactNativeHostHandler) {
                return reactNativeHostHandler.getJSBundleFile(ReactNativeHostWrapperBase.this.getUseDeveloperSupport());
            }
        }));
        return str == null ? (String) invokeDelegateMethod$expo_release("getJSBundleFile") : str;
    }

    @Override // com.facebook.react.ReactNativeHost
    protected String getBundleAssetName() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new Function1<ReactNativeHostHandler, String>() { // from class: expo.modules.ReactNativeHostWrapperBase$getBundleAssetName$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(ReactNativeHostHandler reactNativeHostHandler) {
                return reactNativeHostHandler.getBundleAssetName(ReactNativeHostWrapperBase.this.getUseDeveloperSupport());
            }
        }));
        return str == null ? (String) invokeDelegateMethod$expo_release("getBundleAssetName") : str;
    }

    @Override // com.facebook.react.ReactNativeHost
    public boolean getUseDeveloperSupport() {
        Boolean bool = (Boolean) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new Function1<ReactNativeHostHandler, Boolean>() { // from class: expo.modules.ReactNativeHostWrapperBase$getUseDeveloperSupport$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(ReactNativeHostHandler reactNativeHostHandler) {
                return reactNativeHostHandler.getUseDeveloperSupport();
            }
        }));
        return bool == null ? this.host.getUseDeveloperSupport() : bool.booleanValue();
    }

    @Override // com.facebook.react.ReactNativeHost
    protected List<ReactPackage> getPackages() {
        return (List) invokeDelegateMethod$expo_release("getPackages");
    }

    /* compiled from: ReactNativeHostWrapperBase.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0003J$\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lexpo/modules/ReactNativeHostWrapperBase$JSIModuleContainerPackage;", "Lcom/facebook/react/bridge/JSIModulePackage;", "userJSIModulePackage", "(Lexpo/modules/ReactNativeHostWrapperBase;Lcom/facebook/react/bridge/JSIModulePackage;)V", "getJSIModules", "", "Lcom/facebook/react/bridge/JSIModuleSpec;", "Lcom/facebook/react/bridge/JSIModule;", "reactApplicationContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "jsContext", "Lcom/facebook/react/bridge/JavaScriptContextHolder;", "expo_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class JSIModuleContainerPackage implements JSIModulePackage {
        private final JSIModulePackage userJSIModulePackage;

        public JSIModuleContainerPackage(JSIModulePackage jSIModulePackage) {
            this.userJSIModulePackage = jSIModulePackage;
        }

        @Override // com.facebook.react.bridge.JSIModulePackage
        public List<JSIModuleSpec<JSIModule>> getJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder jsContext) {
            List<JSIModuleSpec> jSIModules;
            List<JSIModuleSpec<JSIModule>> list;
            Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
            Intrinsics.checkNotNullParameter(jsContext, "jsContext");
            List<ReactNativeHostHandler> reactNativeHostHandlers$expo_release = ReactNativeHostWrapperBase.this.getReactNativeHostHandlers$expo_release();
            ReactNativeHostWrapperBase reactNativeHostWrapperBase = ReactNativeHostWrapperBase.this;
            Iterator<T> it = reactNativeHostHandlers$expo_release.iterator();
            while (it.hasNext()) {
                ((ReactNativeHostHandler) it.next()).onRegisterJSIModules(reactApplicationContext, jsContext, reactNativeHostWrapperBase.getUseDeveloperSupport());
            }
            JSIModulePackage jSIModulePackage = this.userJSIModulePackage;
            return (jSIModulePackage == null || (jSIModules = jSIModulePackage.getJSIModules(reactApplicationContext, jsContext)) == null || (list = CollectionsKt.toList(jSIModules)) == null) ? CollectionsKt.emptyList() : list;
        }
    }

    public final <T> T invokeDelegateMethod$expo_release(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Method method = this.methodMap.get(name);
        if (method == null) {
            method = ReactNativeHost.class.getDeclaredMethod(name, new Class[0]);
            method.setAccessible(true);
            this.methodMap.put(name, method);
        }
        Intrinsics.checkNotNull(method);
        return (T) method.invoke(this.host, new Object[0]);
    }

    public final void injectHostReactInstanceManager(ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        Field declaredField = ReactNativeHost.class.getDeclaredField("mReactInstanceManager");
        declaredField.setAccessible(true);
        declaredField.set(this.host, reactInstanceManager);
    }
}
