package expo.modules.core.interfaces;

import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes3.dex */
public interface ReactNativeHostHandler {
    default ReactInstanceManager createReactInstanceManager(boolean z) {
        return null;
    }

    default String getBundleAssetName(boolean z) {
        return null;
    }

    default Object getDevSupportManagerFactory() {
        return null;
    }

    default String getJSBundleFile(boolean z) {
        return null;
    }

    default JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    default Boolean getUseDeveloperSupport() {
        return null;
    }

    default void onDidCreateReactInstanceManager(ReactInstanceManager reactInstanceManager, boolean z) {
    }

    default void onRegisterJSIModules(ReactApplicationContext reactApplicationContext, JavaScriptContextHolder javaScriptContextHolder, boolean z) {
    }

    default void onWillCreateReactInstanceManager(boolean z) {
    }
}
