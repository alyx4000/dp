package com.facebook.react.defaults;

import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSEngineInstance;
import com.facebook.react.runtime.ReactHostDelegate;
import com.facebook.react.runtime.hermes.HermesInstance;
import com.facebook.react.turbomodule.core.TurboModuleManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultReactHostDelegate.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%H\u0016J\u0014\u0010&\u001a\u00020\u00132\n\u0010'\u001a\u00060\u0011j\u0002`\u0012H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006("}, d2 = {"Lcom/facebook/react/defaults/DefaultReactHostDelegate;", "Lcom/facebook/react/runtime/ReactHostDelegate;", "jsMainModulePath", "", "jsBundleLoader", "Lcom/facebook/react/bridge/JSBundleLoader;", "reactPackages", "", "Lcom/facebook/react/ReactPackage;", "jsEngineInstance", "Lcom/facebook/react/runtime/JSEngineInstance;", "bindingsInstaller", "Lcom/facebook/react/runtime/BindingsInstaller;", "reactNativeConfig", "Lcom/facebook/react/fabric/ReactNativeConfig;", "exceptionHandler", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "turboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "(Ljava/lang/String;Lcom/facebook/react/bridge/JSBundleLoader;Ljava/util/List;Lcom/facebook/react/runtime/JSEngineInstance;Lcom/facebook/react/runtime/BindingsInstaller;Lcom/facebook/react/fabric/ReactNativeConfig;Lkotlin/jvm/functions/Function1;Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;)V", "getBindingsInstaller", "()Lcom/facebook/react/runtime/BindingsInstaller;", "getJsBundleLoader", "()Lcom/facebook/react/bridge/JSBundleLoader;", "getJsEngineInstance", "()Lcom/facebook/react/runtime/JSEngineInstance;", "getJsMainModulePath", "()Ljava/lang/String;", "getReactPackages", "()Ljava/util/List;", "getTurboModuleManagerDelegateBuilder", "()Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "getReactNativeConfig", "turboModuleManager", "Lcom/facebook/react/turbomodule/core/TurboModuleManager;", "handleInstanceException", "error", "ReactAndroid_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@UnstableReactNativeAPI
/* loaded from: classes3.dex */
public final class DefaultReactHostDelegate implements ReactHostDelegate {
    private final BindingsInstaller bindingsInstaller;
    private final Function1<Exception, Unit> exceptionHandler;
    private final JSBundleLoader jsBundleLoader;
    private final JSEngineInstance jsEngineInstance;
    private final String jsMainModulePath;
    private final ReactNativeConfig reactNativeConfig;
    private final List<ReactPackage> reactPackages;
    private final ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder;

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultReactHostDelegate(String jsMainModulePath, JSBundleLoader jsBundleLoader, List<? extends ReactPackage> reactPackages, JSEngineInstance jsEngineInstance, BindingsInstaller bindingsInstaller, ReactNativeConfig reactNativeConfig, Function1<? super Exception, Unit> exceptionHandler, ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder) {
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter(jsBundleLoader, "jsBundleLoader");
        Intrinsics.checkNotNullParameter(reactPackages, "reactPackages");
        Intrinsics.checkNotNullParameter(jsEngineInstance, "jsEngineInstance");
        Intrinsics.checkNotNullParameter(bindingsInstaller, "bindingsInstaller");
        Intrinsics.checkNotNullParameter(reactNativeConfig, "reactNativeConfig");
        Intrinsics.checkNotNullParameter(exceptionHandler, "exceptionHandler");
        Intrinsics.checkNotNullParameter(turboModuleManagerDelegateBuilder, "turboModuleManagerDelegateBuilder");
        this.jsMainModulePath = jsMainModulePath;
        this.jsBundleLoader = jsBundleLoader;
        this.reactPackages = reactPackages;
        this.jsEngineInstance = jsEngineInstance;
        this.bindingsInstaller = bindingsInstaller;
        this.reactNativeConfig = reactNativeConfig;
        this.exceptionHandler = exceptionHandler;
        this.turboModuleManagerDelegateBuilder = turboModuleManagerDelegateBuilder;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public String getJsMainModulePath() {
        return this.jsMainModulePath;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public JSBundleLoader getJsBundleLoader() {
        return this.jsBundleLoader;
    }

    public /* synthetic */ DefaultReactHostDelegate(String str, JSBundleLoader jSBundleLoader, List list, JSEngineInstance jSEngineInstance, BindingsInstaller bindingsInstaller, ReactNativeConfig reactNativeConfig, Function1 function1, ReactPackageTurboModuleManagerDelegate.Builder builder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, jSBundleLoader, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? new HermesInstance() : jSEngineInstance, (i & 16) != 0 ? new DefaultBindingsInstaller() : bindingsInstaller, (i & 32) != 0 ? ReactNativeConfig.DEFAULT_CONFIG : reactNativeConfig, (i & 64) != 0 ? new Function1<Exception, Unit>() { // from class: com.facebook.react.defaults.DefaultReactHostDelegate.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }
        } : function1, builder);
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public List<ReactPackage> getReactPackages() {
        return this.reactPackages;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public JSEngineInstance getJsEngineInstance() {
        return this.jsEngineInstance;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public BindingsInstaller getBindingsInstaller() {
        return this.bindingsInstaller;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public ReactPackageTurboModuleManagerDelegate.Builder getTurboModuleManagerDelegateBuilder() {
        return this.turboModuleManagerDelegateBuilder;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public ReactNativeConfig getReactNativeConfig(TurboModuleManager turboModuleManager) {
        Intrinsics.checkNotNullParameter(turboModuleManager, "turboModuleManager");
        return this.reactNativeConfig;
    }

    @Override // com.facebook.react.runtime.ReactHostDelegate
    public void handleInstanceException(Exception error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.exceptionHandler.invoke(error);
    }
}
