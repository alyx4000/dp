package com.facebook.react;

import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import expo.modules.updates.loader.EmbeddedLoader;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ReactNativeHost {
    private final Application mApplication;
    private ReactInstanceManager mReactInstanceManager;

    protected String getBundleAssetName() {
        return EmbeddedLoader.BARE_BUNDLE_FILENAME;
    }

    protected DevLoadingViewManager getDevLoadingViewManager() {
        return null;
    }

    protected DevSupportManagerFactory getDevSupportManagerFactory() {
        return null;
    }

    protected String getJSBundleFile() {
        return null;
    }

    protected JSEngineResolutionAlgorithm getJSEngineResolutionAlgorithm() {
        return null;
    }

    protected JSIModulePackage getJSIModulePackage() {
        return null;
    }

    protected String getJSMainModuleName() {
        return "index.android";
    }

    protected JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    public boolean getLazyViewManagersEnabled() {
        return false;
    }

    protected abstract List<ReactPackage> getPackages();

    protected ReactPackageTurboModuleManagerDelegate.Builder getReactPackageTurboModuleManagerDelegateBuilder() {
        return null;
    }

    protected RedBoxHandler getRedBoxHandler() {
        return null;
    }

    public boolean getShouldRequireActivity() {
        return true;
    }

    public abstract boolean getUseDeveloperSupport();

    protected ReactNativeHost(Application application) {
        this.mApplication = application;
    }

    public ReactInstanceManager getReactInstanceManager() {
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.INIT_REACT_RUNTIME_START);
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
            this.mReactInstanceManager = createReactInstanceManager();
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
        }
        return this.mReactInstanceManager;
    }

    public boolean hasInstance() {
        return this.mReactInstanceManager != null;
    }

    public void clear() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            reactInstanceManager.destroy();
            this.mReactInstanceManager = null;
        }
    }

    protected ReactInstanceManager createReactInstanceManager() {
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        ReactInstanceManagerBuilder jSEngineResolutionAlgorithm = ReactInstanceManager.builder().setApplication(this.mApplication).setJSMainModulePath(getJSMainModuleName()).setUseDeveloperSupport(getUseDeveloperSupport()).setDevSupportManagerFactory(getDevSupportManagerFactory()).setDevLoadingViewManager(getDevLoadingViewManager()).setRequireActivity(getShouldRequireActivity()).setSurfaceDelegateFactory(getSurfaceDelegateFactory()).setLazyViewManagersEnabled(getLazyViewManagersEnabled()).setRedBoxHandler(getRedBoxHandler()).setJavaScriptExecutorFactory(getJavaScriptExecutorFactory()).setJSIModulesPackage(getJSIModulePackage()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE).setReactPackageTurboModuleManagerDelegateBuilder(getReactPackageTurboModuleManagerDelegateBuilder()).setJSEngineResolutionAlgorithm(getJSEngineResolutionAlgorithm());
        Iterator<ReactPackage> it = getPackages().iterator();
        while (it.hasNext()) {
            jSEngineResolutionAlgorithm.addPackage(it.next());
        }
        String jSBundleFile = getJSBundleFile();
        if (jSBundleFile != null) {
            jSEngineResolutionAlgorithm.setJSBundleFile(jSBundleFile);
        } else {
            jSEngineResolutionAlgorithm.setBundleAssetName((String) Assertions.assertNotNull(getBundleAssetName()));
        }
        ReactInstanceManager build = jSEngineResolutionAlgorithm.build();
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        return build;
    }

    protected final Application getApplication() {
        return this.mApplication;
    }

    public SurfaceDelegateFactory getSurfaceDelegateFactory() {
        return new SurfaceDelegateFactory() { // from class: com.facebook.react.ReactNativeHost.1
            @Override // com.facebook.react.common.SurfaceDelegateFactory
            public SurfaceDelegate createSurfaceDelegate(String str) {
                return null;
            }
        };
    }
}
