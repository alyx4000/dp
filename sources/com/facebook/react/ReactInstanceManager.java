package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ProxyJavaScriptExecutor;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactCxxErrorHandler;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.turbomodule.core.TurboModuleManager;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class ReactInstanceManager {
    private static final String TAG = "ReactInstanceManager";
    private final Context mApplicationContext;
    private final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    private final JSBundleLoader mBundleLoader;
    private volatile Thread mCreateReactContextThread;
    private Activity mCurrentActivity;
    private volatile ReactContext mCurrentReactContext;
    private DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
    private final DevSupportManager mDevSupportManager;
    private final JSExceptionHandler mJSExceptionHandler;
    private final JSIModulePackage mJSIModulePackage;
    private final String mJSMainModulePath;
    private final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    private volatile LifecycleState mLifecycleState;
    private final MemoryPressureRouter mMemoryPressureRouter;
    private final List<ReactPackage> mPackages;
    private ReactContextInitParams mPendingReactContextInitParams;
    private final boolean mRequireActivity;
    private final ReactPackageTurboModuleManagerDelegate.Builder mTMMDelegateBuilder;
    private final boolean mUseDeveloperSupport;
    private List<ViewManager> mViewManagers;
    private final Set<ReactRoot> mAttachedReactRoots = Collections.synchronizedSet(new HashSet());
    private Collection<String> mViewManagerNames = null;
    private final Object mReactContextLock = new Object();
    private final Collection<com.facebook.react.ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedList(new ArrayList());
    private volatile boolean mHasStartedCreatingInitialContext = false;
    private volatile Boolean mHasStartedDestroying = false;
    private boolean mUseFallbackBundle = true;

    @Deprecated
    public interface ReactInstanceEventListener extends com.facebook.react.ReactInstanceEventListener {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class ReactContextInitParams {
        private final JSBundleLoader mJsBundleLoader;
        private final JavaScriptExecutorFactory mJsExecutorFactory;

        public ReactContextInitParams(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            this.mJsExecutorFactory = (JavaScriptExecutorFactory) Assertions.assertNotNull(javaScriptExecutorFactory);
            this.mJsBundleLoader = (JSBundleLoader) Assertions.assertNotNull(jSBundleLoader);
        }

        public JavaScriptExecutorFactory getJsExecutorFactory() {
            return this.mJsExecutorFactory;
        }

        public JSBundleLoader getJsBundleLoader() {
            return this.mJsBundleLoader;
        }
    }

    public static ReactInstanceManagerBuilder builder() {
        return new ReactInstanceManagerBuilder();
    }

    ReactInstanceManager(Context context, Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, List<ReactPackage> list, boolean z, DevSupportManagerFactory devSupportManagerFactory, boolean z2, NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, JSExceptionHandler jSExceptionHandler, RedBoxHandler redBoxHandler, boolean z3, DevBundleDownloadListener devBundleDownloadListener, int i, int i2, JSIModulePackage jSIModulePackage, Map<String, RequestHandler> map, ReactPackageTurboModuleManagerDelegate.Builder builder, SurfaceDelegateFactory surfaceDelegateFactory, DevLoadingViewManager devLoadingViewManager) {
        FLog.d(TAG, "ReactInstanceManager.ctor()");
        initializeSoLoaderIfNecessary(context);
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(context);
        this.mApplicationContext = context;
        this.mCurrentActivity = activity;
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        this.mBundleLoader = jSBundleLoader;
        this.mJSMainModulePath = str;
        ArrayList arrayList = new ArrayList();
        this.mPackages = arrayList;
        this.mUseDeveloperSupport = z;
        this.mRequireActivity = z2;
        Systrace.beginSection(0L, "ReactInstanceManager.initDevSupportManager");
        DevSupportManager create = devSupportManagerFactory.create(context, createDevHelperInterface(), str, z, redBoxHandler, devBundleDownloadListener, i, map, surfaceDelegateFactory, devLoadingViewManager);
        this.mDevSupportManager = create;
        Systrace.endSection(0L);
        this.mBridgeIdleDebugListener = notThreadSafeBridgeIdleDebugListener;
        this.mLifecycleState = lifecycleState;
        this.mMemoryPressureRouter = new MemoryPressureRouter(context);
        this.mJSExceptionHandler = jSExceptionHandler;
        this.mTMMDelegateBuilder = builder;
        synchronized (arrayList) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Use Split Packages");
            arrayList.add(new CoreModulesPackage(this, new DefaultHardwareBackBtnHandler() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda6
                @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
                public final void invokeDefaultOnBackPressed() {
                    ReactInstanceManager.this.invokeDefaultOnBackPressed();
                }
            }, z3, i2));
            if (z) {
                arrayList.add(new DebugCorePackage());
            }
            arrayList.addAll(list);
        }
        this.mJSIModulePackage = jSIModulePackage;
        ReactChoreographer.initialize();
        if (z) {
            create.startInspector();
        }
        registerCxxErrorHandlerFunc();
    }

    private ReactInstanceDevHelper createDevHelperInterface() {
        return new ReactInstanceDevHelper() { // from class: com.facebook.react.ReactInstanceManager.1
            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
                ReactInstanceManager.this.onReloadWithJSDebugger(factory);
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void onJSBundleLoadedFromServer() {
                ReactInstanceManager.this.onJSBundleLoadedFromServer();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void toggleElementInspector() {
                ReactInstanceManager.this.toggleElementInspector();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public Activity getCurrentActivity() {
                return ReactInstanceManager.this.mCurrentActivity;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
                return ReactInstanceManager.this.getJSExecutorFactory();
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public View createRootView(String str) {
                Activity currentActivity = getCurrentActivity();
                if (currentActivity == null) {
                    return null;
                }
                ReactRootView reactRootView = new ReactRootView(currentActivity);
                reactRootView.setIsFabric(ReactFeatureFlags.enableFabricRenderer);
                reactRootView.startReactApplication(ReactInstanceManager.this, str, null);
                return reactRootView;
            }

            @Override // com.facebook.react.devsupport.ReactInstanceDevHelper
            public void destroyRootView(View view) {
                if (view instanceof ReactRootView) {
                    ((ReactRootView) view).unmountReactApplication();
                }
            }
        };
    }

    public synchronized void setUseFallbackBundle(boolean z) {
        this.mUseFallbackBundle = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JavaScriptExecutorFactory getJSExecutorFactory() {
        return this.mJavaScriptExecutorFactory;
    }

    public DevSupportManager getDevSupportManager() {
        return this.mDevSupportManager;
    }

    public MemoryPressureRouter getMemoryPressureRouter() {
        return this.mMemoryPressureRouter;
    }

    public List<ReactPackage> getPackages() {
        return new ArrayList(this.mPackages);
    }

    public void handleCxxError(Exception exc) {
        this.mDevSupportManager.handleException(exc);
    }

    public void registerCxxErrorHandlerFunc() {
        Method method;
        try {
            method = ReactInstanceManager.class.getMethod("handleCxxError", Exception.class);
        } catch (NoSuchMethodException e) {
            FLog.e("ReactInstanceHolder", "Failed to set cxx error handler function", e);
            method = null;
        }
        ReactCxxErrorHandler.setHandleErrorFunc(this, method);
    }

    static void initializeSoLoaderIfNecessary(Context context) {
        SoLoader.init(context, false);
    }

    public void createReactContextInBackground() {
        FLog.d(TAG, "ReactInstanceManager.createReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        if (this.mHasStartedCreatingInitialContext) {
            return;
        }
        this.mHasStartedCreatingInitialContext = true;
        recreateReactContextInBackgroundInner();
    }

    public void recreateReactContextInBackground() {
        Assertions.assertCondition(this.mHasStartedCreatingInitialContext, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
        recreateReactContextInBackgroundInner();
    }

    private void recreateReactContextInBackgroundInner() {
        FLog.d(TAG, "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: recreateReactContextInBackground");
        UiThreadUtil.assertOnUiThread();
        if (this.mUseDeveloperSupport && this.mJSMainModulePath != null) {
            DeveloperSettings devSettings = this.mDevSupportManager.getDevSettings();
            if (!Systrace.isTracing(0L)) {
                if (this.mBundleLoader == null) {
                    this.mDevSupportManager.handleReloadJS();
                    return;
                } else {
                    this.mDevSupportManager.isPackagerRunning(new AnonymousClass2(devSettings));
                    return;
                }
            }
        }
        recreateReactContextInBackgroundFromBundleLoader();
    }

    /* renamed from: com.facebook.react.ReactInstanceManager$2, reason: invalid class name */
    class AnonymousClass2 implements PackagerStatusCallback {
        final /* synthetic */ DeveloperSettings val$devSettings;

        AnonymousClass2(DeveloperSettings developerSettings) {
            this.val$devSettings = developerSettings;
        }

        @Override // com.facebook.react.devsupport.interfaces.PackagerStatusCallback
        public void onPackagerStatusFetched(final boolean z) {
            final DeveloperSettings developerSettings = this.val$devSettings;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ReactInstanceManager.AnonymousClass2.this.lambda$onPackagerStatusFetched$0(z, developerSettings);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPackagerStatusFetched$0(boolean z, DeveloperSettings developerSettings) {
            if (z) {
                ReactInstanceManager.this.mDevSupportManager.handleReloadJS();
                return;
            }
            if (ReactInstanceManager.this.mDevSupportManager.hasUpToDateJSBundleInCache() && !developerSettings.isRemoteJSDebugEnabled() && !ReactInstanceManager.this.mUseFallbackBundle) {
                ReactInstanceManager.this.onJSBundleLoadedFromServer();
            } else {
                developerSettings.setRemoteJSDebugEnabled(false);
                ReactInstanceManager.this.recreateReactContextInBackgroundFromBundleLoader();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recreateReactContextInBackgroundFromBundleLoader() {
        FLog.d(TAG, "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from BundleLoader");
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, this.mBundleLoader);
    }

    public boolean hasStartedCreatingInitialContext() {
        return this.mHasStartedCreatingInitialContext;
    }

    public void onBackPressed() {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = this.mCurrentReactContext;
        if (reactContext == null) {
            FLog.w(TAG, "Instance detached from instance manager");
            invokeDefaultOnBackPressed();
        } else {
            DeviceEventManagerModule deviceEventManagerModule = (DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class);
            if (deviceEventManagerModule != null) {
                deviceEventManagerModule.emitHardwareBackPressed();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeDefaultOnBackPressed() {
        UiThreadUtil.assertOnUiThread();
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultBackButtonImpl;
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.invokeDefaultOnBackPressed();
        }
    }

    public void onNewIntent(Intent intent) {
        DeviceEventManagerModule deviceEventManagerModule;
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null) {
            FLog.w(TAG, "Instance detached from instance manager");
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && (("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action)) && (deviceEventManagerModule = (DeviceEventManagerModule) currentReactContext.getNativeModule(DeviceEventManagerModule.class)) != null)) {
            deviceEventManagerModule.emitNewIntentReceived(data);
        }
        currentReactContext.onNewIntent(this.mCurrentActivity, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleElementInspector() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && currentReactContext.hasActiveReactInstance()) {
            currentReactContext.emitDeviceEvent("toggleElementInspector");
        } else {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Cannot toggleElementInspector, CatalystInstance not available"));
        }
    }

    @Deprecated
    public void onHostPause() {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = null;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeResumeLifecycleState();
    }

    public void onHostPause(Activity activity) {
        if (this.mRequireActivity) {
            Assertions.assertCondition(this.mCurrentActivity != null);
        }
        Activity activity2 = this.mCurrentActivity;
        if (activity2 != null) {
            Assertions.assertCondition(activity == activity2, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + this.mCurrentActivity.getClass().getSimpleName() + " Paused activity: " + activity.getClass().getSimpleName());
        }
        onHostPause();
    }

    public void onHostResume(Activity activity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.assertOnUiThread();
        this.mDefaultBackButtonImpl = defaultHardwareBackBtnHandler;
        onHostResume(activity);
    }

    public void onHostResume(Activity activity) {
        UiThreadUtil.assertOnUiThread();
        this.mCurrentActivity = activity;
        if (this.mUseDeveloperSupport) {
            if (activity != null) {
                final View decorView = activity.getWindow().getDecorView();
                if (!ViewCompat.isAttachedToWindow(decorView)) {
                    decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.facebook.react.ReactInstanceManager.3
                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewDetachedFromWindow(View view) {
                        }

                        @Override // android.view.View.OnAttachStateChangeListener
                        public void onViewAttachedToWindow(View view) {
                            decorView.removeOnAttachStateChangeListener(this);
                            ReactInstanceManager.this.mDevSupportManager.setDevSupportEnabled(true);
                        }
                    });
                } else {
                    this.mDevSupportManager.setDevSupportEnabled(true);
                }
            } else if (!this.mRequireActivity) {
                this.mDevSupportManager.setDevSupportEnabled(true);
            }
        }
        moveToResumedLifecycleState(false);
    }

    @Deprecated
    public void onHostDestroy() {
        UiThreadUtil.assertOnUiThread();
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
        }
        moveToBeforeCreateLifecycleState();
        this.mCurrentActivity = null;
    }

    public void onHostDestroy(Activity activity) {
        if (activity == this.mCurrentActivity) {
            onHostDestroy();
        }
    }

    private void logOnDestroy() {
        FLog.d(TAG, "ReactInstanceManager.destroy called", (Throwable) new RuntimeException("ReactInstanceManager.destroy called"));
    }

    public void destroy() {
        UiThreadUtil.assertOnUiThread();
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Destroy");
        logOnDestroy();
        if (this.mHasStartedDestroying.booleanValue()) {
            FLog.e(ReactConstants.TAG, "ReactInstanceManager.destroy called: bail out, already destroying");
            return;
        }
        this.mHasStartedDestroying = true;
        if (this.mUseDeveloperSupport) {
            this.mDevSupportManager.setDevSupportEnabled(false);
            this.mDevSupportManager.stopInspector();
        }
        moveToBeforeCreateLifecycleState();
        if (this.mCreateReactContextThread != null) {
            this.mCreateReactContextThread = null;
        }
        this.mMemoryPressureRouter.destroy(this.mApplicationContext);
        synchronized (this.mReactContextLock) {
            if (this.mCurrentReactContext != null) {
                this.mCurrentReactContext.destroy();
                this.mCurrentReactContext = null;
            }
        }
        this.mHasStartedCreatingInitialContext = false;
        this.mCurrentActivity = null;
        ResourceDrawableIdHelper.getInstance().clear();
        this.mHasStartedDestroying = false;
        synchronized (this.mHasStartedDestroying) {
            this.mHasStartedDestroying.notifyAll();
        }
        synchronized (this.mPackages) {
            this.mViewManagerNames = null;
        }
        FLog.d(ReactConstants.TAG, "ReactInstanceManager has been destroyed");
    }

    private synchronized void moveToResumedLifecycleState(boolean z) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null && (z || this.mLifecycleState == LifecycleState.BEFORE_RESUME || this.mLifecycleState == LifecycleState.BEFORE_CREATE)) {
            currentReactContext.onHostResume(this.mCurrentActivity);
        }
        this.mLifecycleState = LifecycleState.RESUMED;
    }

    private synchronized void moveToBeforeResumeLifecycleState() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            if (this.mLifecycleState == LifecycleState.BEFORE_CREATE) {
                currentReactContext.onHostResume(this.mCurrentActivity);
                currentReactContext.onHostPause();
            } else if (this.mLifecycleState == LifecycleState.RESUMED) {
                currentReactContext.onHostPause();
            }
        }
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
    }

    private synchronized void moveToBeforeCreateLifecycleState() {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            if (this.mLifecycleState == LifecycleState.RESUMED) {
                currentReactContext.onHostPause();
                this.mLifecycleState = LifecycleState.BEFORE_RESUME;
            }
            if (this.mLifecycleState == LifecycleState.BEFORE_RESUME) {
                currentReactContext.onHostDestroy();
            }
        }
        this.mLifecycleState = LifecycleState.BEFORE_CREATE;
    }

    private synchronized void moveReactContextToCurrentLifecycleState() {
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            moveToResumedLifecycleState(true);
        }
    }

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onActivityResult(activity, i, i2, intent);
        }
    }

    public void onWindowFocusChange(boolean z) {
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext != null) {
            currentReactContext.onWindowFocusChange(z);
        }
    }

    public void onConfigurationChanged(Context context, Configuration configuration) {
        AppearanceModule appearanceModule;
        UiThreadUtil.assertOnUiThread();
        ReactContext currentReactContext = getCurrentReactContext();
        if (currentReactContext == null || (appearanceModule = (AppearanceModule) currentReactContext.getNativeModule(AppearanceModule.class)) == null) {
            return;
        }
        appearanceModule.onConfigurationChanged(context);
    }

    public void showDevOptionsDialog() {
        UiThreadUtil.assertOnUiThread();
        this.mDevSupportManager.showDevOptionsDialog();
    }

    private void clearReactRoot(ReactRoot reactRoot) {
        UiThreadUtil.assertOnUiThread();
        reactRoot.getState().compareAndSet(1, 0);
        ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
        rootViewGroup.removeAllViews();
        rootViewGroup.setId(-1);
    }

    @Deprecated
    public void attachRootView(ReactRoot reactRoot) {
        UiThreadUtil.assertOnUiThread();
        if (this.mAttachedReactRoots.add(reactRoot)) {
            clearReactRoot(reactRoot);
        } else {
            FLog.e(ReactConstants.TAG, "ReactRoot was attached multiple times");
        }
        ReactContext currentReactContext = getCurrentReactContext();
        if (this.mCreateReactContextThread != null || currentReactContext == null) {
            return;
        }
        attachRootViewToInstance(reactRoot);
    }

    @Deprecated
    public void detachRootView(ReactRoot reactRoot) {
        ReactContext reactContext;
        UiThreadUtil.assertOnUiThread();
        if (this.mAttachedReactRoots.remove(reactRoot) && (reactContext = this.mCurrentReactContext) != null && reactContext.hasActiveReactInstance()) {
            detachRootViewFromInstance(reactRoot, reactContext);
        }
    }

    public List<ViewManager> getOrCreateViewManagers(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        Systrace.beginSection(0L, "createAllViewManagers");
        try {
            if (this.mViewManagers == null) {
                synchronized (this.mPackages) {
                    if (this.mViewManagers == null) {
                        ArrayList arrayList = new ArrayList();
                        Iterator<ReactPackage> it = this.mPackages.iterator();
                        while (it.hasNext()) {
                            arrayList.addAll(it.next().createViewManagers(reactApplicationContext));
                        }
                        this.mViewManagers = arrayList;
                        return arrayList;
                    }
                }
            }
            return this.mViewManagers;
        } finally {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
        }
    }

    public ViewManager createViewManager(String str) {
        ViewManager createViewManager;
        synchronized (this.mReactContextLock) {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) getCurrentReactContext();
            if (reactApplicationContext != null && reactApplicationContext.hasActiveReactInstance()) {
                synchronized (this.mPackages) {
                    for (ReactPackage reactPackage : this.mPackages) {
                        if ((reactPackage instanceof ViewManagerOnDemandReactPackage) && (createViewManager = ((ViewManagerOnDemandReactPackage) reactPackage).createViewManager(reactApplicationContext, str)) != null) {
                            return createViewManager;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public Collection<String> getViewManagerNames() {
        Collection<String> collection;
        Collection<String> viewManagerNames;
        Systrace.beginSection(0L, "ReactInstanceManager.getViewManagerNames");
        try {
            Collection<String> collection2 = this.mViewManagerNames;
            if (collection2 != null) {
                return collection2;
            }
            synchronized (this.mReactContextLock) {
                ReactApplicationContext reactApplicationContext = (ReactApplicationContext) getCurrentReactContext();
                if (reactApplicationContext != null && reactApplicationContext.hasActiveReactInstance()) {
                    synchronized (this.mPackages) {
                        if (this.mViewManagerNames == null) {
                            HashSet hashSet = new HashSet();
                            for (ReactPackage reactPackage : this.mPackages) {
                                SystraceMessage.beginSection(0L, "ReactInstanceManager.getViewManagerName").arg("Package", reactPackage.getClass().getSimpleName()).flush();
                                if ((reactPackage instanceof ViewManagerOnDemandReactPackage) && (viewManagerNames = ((ViewManagerOnDemandReactPackage) reactPackage).getViewManagerNames(reactApplicationContext)) != null) {
                                    hashSet.addAll(viewManagerNames);
                                }
                                Systrace.endSection(0L);
                            }
                            this.mViewManagerNames = hashSet;
                        }
                        collection = this.mViewManagerNames;
                    }
                    return collection;
                }
                FLog.w(ReactConstants.TAG, "Calling getViewManagerNames without active context");
                return Collections.emptyList();
            }
        } finally {
            Systrace.endSection(0L);
        }
    }

    public void addReactInstanceEventListener(com.facebook.react.ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.add(reactInstanceEventListener);
    }

    public void removeReactInstanceEventListener(com.facebook.react.ReactInstanceEventListener reactInstanceEventListener) {
        this.mReactInstanceEventListeners.remove(reactInstanceEventListener);
    }

    @VisibleForTesting
    public ReactContext getCurrentReactContext() {
        ReactContext reactContext;
        synchronized (this.mReactContextLock) {
            reactContext = this.mCurrentReactContext;
        }
        return reactContext;
    }

    public LifecycleState getLifecycleState() {
        return this.mLifecycleState;
    }

    public String getJsExecutorName() {
        return this.mJavaScriptExecutorFactory.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReloadWithJSDebugger(JavaJSExecutor.Factory factory) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.onReloadWithJSDebugger()");
        recreateReactContextInBackground(new ProxyJavaScriptExecutor.Factory(factory), JSBundleLoader.createRemoteDebuggerBundleLoader(this.mDevSupportManager.getJSBundleURLForRemoteDebugging(), this.mDevSupportManager.getSourceUrl()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onJSBundleLoadedFromServer() {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.onJSBundleLoadedFromServer()");
        recreateReactContextInBackground(this.mJavaScriptExecutorFactory, JSBundleLoader.createCachedBundleFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), this.mDevSupportManager.getDownloadedJSBundleFile()));
    }

    private void recreateReactContextInBackground(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.recreateReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        ReactContextInitParams reactContextInitParams = new ReactContextInitParams(javaScriptExecutorFactory, jSBundleLoader);
        if (this.mCreateReactContextThread == null) {
            runCreateReactContextOnNewThread(reactContextInitParams);
        } else {
            this.mPendingReactContextInitParams = reactContextInitParams;
        }
    }

    private void runCreateReactContextOnNewThread(final ReactContextInitParams reactContextInitParams) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_START);
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                if (this.mCurrentReactContext != null) {
                    tearDownReactContext(this.mCurrentReactContext);
                    this.mCurrentReactContext = null;
                }
            }
        }
        this.mCreateReactContextThread = new Thread(null, new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                ReactInstanceManager.this.lambda$runCreateReactContextOnNewThread$2(reactContextInitParams);
            }
        }, "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.mCreateReactContextThread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCreateReactContextOnNewThread$2(ReactContextInitParams reactContextInitParams) {
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_END);
        synchronized (this.mHasStartedDestroying) {
            while (this.mHasStartedDestroying.booleanValue()) {
                try {
                    this.mHasStartedDestroying.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        this.mHasStartedCreatingInitialContext = true;
        try {
            Process.setThreadPriority(-4);
            ReactMarker.logMarker(ReactMarkerConstants.VM_INIT);
            final ReactApplicationContext createReactContext = createReactContext(reactContextInitParams.getJsExecutorFactory().create(), reactContextInitParams.getJsBundleLoader());
            try {
                this.mCreateReactContextThread = null;
                ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START);
                Runnable runnable = new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReactInstanceManager.this.lambda$runCreateReactContextOnNewThread$0();
                    }
                };
                createReactContext.runOnNativeModulesQueueThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReactInstanceManager.this.lambda$runCreateReactContextOnNewThread$1(createReactContext);
                    }
                });
                UiThreadUtil.runOnUiThread(runnable);
            } catch (Exception e) {
                this.mDevSupportManager.handleException(e);
            }
        } catch (Exception e2) {
            this.mHasStartedCreatingInitialContext = false;
            this.mCreateReactContextThread = null;
            this.mDevSupportManager.handleException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCreateReactContextOnNewThread$0() {
        ReactContextInitParams reactContextInitParams = this.mPendingReactContextInitParams;
        if (reactContextInitParams != null) {
            runCreateReactContextOnNewThread(reactContextInitParams);
            this.mPendingReactContextInitParams = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$runCreateReactContextOnNewThread$1(ReactApplicationContext reactApplicationContext) {
        try {
            setupReactContext(reactApplicationContext);
        } catch (Exception e) {
            this.mDevSupportManager.handleException(e);
        }
    }

    private void setupReactContext(final ReactApplicationContext reactApplicationContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.setupReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
        Systrace.beginSection(0L, "setupReactContext");
        synchronized (this.mAttachedReactRoots) {
            synchronized (this.mReactContextLock) {
                this.mCurrentReactContext = (ReactContext) Assertions.assertNotNull(reactApplicationContext);
            }
            CatalystInstance catalystInstance = (CatalystInstance) Assertions.assertNotNull(reactApplicationContext.getCatalystInstance());
            catalystInstance.initialize();
            this.mDevSupportManager.onNewReactContextCreated(reactApplicationContext);
            this.mMemoryPressureRouter.addMemoryPressureListener(catalystInstance);
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
            Iterator<ReactRoot> it = this.mAttachedReactRoots.iterator();
            while (it.hasNext()) {
                attachRootViewToInstance(it.next());
            }
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
        }
        final com.facebook.react.ReactInstanceEventListener[] reactInstanceEventListenerArr = (com.facebook.react.ReactInstanceEventListener[]) this.mReactInstanceEventListeners.toArray(new com.facebook.react.ReactInstanceEventListener[this.mReactInstanceEventListeners.size()]);
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ReactInstanceManager.this.lambda$setupReactContext$3(reactInstanceEventListenerArr, reactApplicationContext);
            }
        });
        reactApplicationContext.runOnJSQueueThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ReactInstanceManager.lambda$setupReactContext$4();
            }
        });
        reactApplicationContext.runOnNativeModulesQueueThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                Process.setThreadPriority(0);
            }
        });
        Systrace.endSection(0L);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_END);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupReactContext$3(com.facebook.react.ReactInstanceEventListener[] reactInstanceEventListenerArr, ReactApplicationContext reactApplicationContext) {
        moveReactContextToCurrentLifecycleState();
        for (com.facebook.react.ReactInstanceEventListener reactInstanceEventListener : reactInstanceEventListenerArr) {
            if (reactInstanceEventListener != null) {
                reactInstanceEventListener.onReactContextInitialized(reactApplicationContext);
            }
        }
    }

    static /* synthetic */ void lambda$setupReactContext$4() {
        Process.setThreadPriority(0);
        ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, "js_default");
    }

    private void attachRootViewToInstance(final ReactRoot reactRoot) {
        WritableMap fromBundle;
        final int addRootView;
        WritableMap fromBundle2;
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.attachRootViewToInstance()");
        if (reactRoot.getState().compareAndSet(0, 1)) {
            Systrace.beginSection(0L, "attachRootViewToInstance");
            UIManager uIManager = UIManagerHelper.getUIManager(this.mCurrentReactContext, reactRoot.getUIManagerType());
            if (uIManager == null) {
                throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
            }
            Bundle appProperties = reactRoot.getAppProperties();
            if (reactRoot.getUIManagerType() == 2) {
                ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
                String jSModuleName = reactRoot.getJSModuleName();
                if (appProperties == null) {
                    fromBundle2 = new WritableNativeMap();
                } else {
                    fromBundle2 = Arguments.fromBundle(appProperties);
                }
                addRootView = uIManager.startSurface(rootViewGroup, jSModuleName, fromBundle2, reactRoot.getWidthMeasureSpec(), reactRoot.getHeightMeasureSpec());
                reactRoot.setShouldLogContentAppeared(true);
            } else {
                ViewGroup rootViewGroup2 = reactRoot.getRootViewGroup();
                if (appProperties == null) {
                    fromBundle = new WritableNativeMap();
                } else {
                    fromBundle = Arguments.fromBundle(appProperties);
                }
                addRootView = uIManager.addRootView(rootViewGroup2, fromBundle, reactRoot.getInitialUITemplate());
                reactRoot.setRootViewTag(addRootView);
                reactRoot.runApplication();
            }
            Systrace.beginAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", addRootView);
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.ReactInstanceManager$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    ReactInstanceManager.lambda$attachRootViewToInstance$6(addRootView, reactRoot);
                }
            });
            Systrace.endSection(0L);
        }
    }

    static /* synthetic */ void lambda$attachRootViewToInstance$6(int i, ReactRoot reactRoot) {
        Systrace.endAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", i);
        reactRoot.onStage(101);
    }

    private void detachRootViewFromInstance(ReactRoot reactRoot, ReactContext reactContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.detachRootViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (reactRoot.getState().compareAndSet(1, 0)) {
            int uIManagerType = reactRoot.getUIManagerType();
            if (uIManagerType == 2) {
                int rootViewTag = reactRoot.getRootViewTag();
                if (rootViewTag != -1) {
                    UIManager uIManager = UIManagerHelper.getUIManager(reactContext, uIManagerType);
                    if (uIManager != null) {
                        uIManager.stopSurface(rootViewTag);
                    } else {
                        FLog.w(ReactConstants.TAG, "Failed to stop surface, UIManager has already gone away");
                    }
                } else {
                    ReactSoftExceptionLogger.logSoftException(TAG, new RuntimeException("detachRootViewFromInstance called with ReactRootView with invalid id"));
                }
            } else {
                ((AppRegistry) reactContext.getCatalystInstance().getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRoot.getRootViewTag());
            }
            clearReactRoot(reactRoot);
        }
    }

    private void tearDownReactContext(ReactContext reactContext) {
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.mLifecycleState == LifecycleState.RESUMED) {
            reactContext.onHostPause();
        }
        synchronized (this.mAttachedReactRoots) {
            Iterator<ReactRoot> it = this.mAttachedReactRoots.iterator();
            while (it.hasNext()) {
                detachRootViewFromInstance(it.next(), reactContext);
            }
        }
        this.mMemoryPressureRouter.removeMemoryPressureListener(reactContext.getCatalystInstance());
        reactContext.destroy();
        this.mDevSupportManager.onReactInstanceDestroyed(reactContext);
    }

    private ReactApplicationContext createReactContext(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        ReactPackageTurboModuleManagerDelegate.Builder builder;
        FLog.d(ReactConstants.TAG, "ReactInstanceManager.createReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
        ReactApplicationContext reactApplicationContext = new ReactApplicationContext(this.mApplicationContext);
        JSExceptionHandler jSExceptionHandler = this.mJSExceptionHandler;
        if (jSExceptionHandler == null) {
            jSExceptionHandler = this.mDevSupportManager;
        }
        reactApplicationContext.setJSExceptionHandler(jSExceptionHandler);
        CatalystInstanceImpl.Builder jSExceptionHandler2 = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(processPackages(reactApplicationContext, this.mPackages, false)).setJSBundleLoader(jSBundleLoader).setJSExceptionHandler(jSExceptionHandler);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
        Systrace.beginSection(0L, "createCatalystInstance");
        try {
            CatalystInstance build = jSExceptionHandler2.build();
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            reactApplicationContext.initializeWithInstance(build);
            if (ReactFeatureFlags.unstable_useRuntimeSchedulerAlways) {
                build.getRuntimeScheduler();
            }
            if (ReactFeatureFlags.useTurboModules && (builder = this.mTMMDelegateBuilder) != null) {
                TurboModuleManager turboModuleManager = new TurboModuleManager(build.getRuntimeExecutor(), builder.setPackages(this.mPackages).setReactApplicationContext(reactApplicationContext).build(), build.getJSCallInvokerHolder(), build.getNativeMethodCallInvokerHolder());
                build.setTurboModuleManager(turboModuleManager);
                Iterator<String> it = turboModuleManager.getEagerInitModuleNames().iterator();
                while (it.hasNext()) {
                    turboModuleManager.getModule(it.next());
                }
            }
            JSIModulePackage jSIModulePackage = this.mJSIModulePackage;
            if (jSIModulePackage != null) {
                build.addJSIModules(jSIModulePackage.getJSIModules(reactApplicationContext, build.getJavaScriptContextHolder()));
            }
            if (ReactFeatureFlags.enableFabricRenderer) {
                build.getJSIModule(JSIModuleType.UIManager);
            }
            NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = this.mBridgeIdleDebugListener;
            if (notThreadSafeBridgeIdleDebugListener != null) {
                build.addBridgeIdleDebugListener(notThreadSafeBridgeIdleDebugListener);
            }
            if (Systrace.isTracing(0L)) {
                build.setGlobalVariable("__RCTProfileIsProfiling", "true");
            }
            ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
            Systrace.beginSection(0L, "runJSBundle");
            build.runJSBundle();
            Systrace.endSection(0L);
            return reactApplicationContext;
        } catch (Throwable th) {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            throw th;
        }
    }

    private NativeModuleRegistry processPackages(ReactApplicationContext reactApplicationContext, List<ReactPackage> list, boolean z) {
        NativeModuleRegistryBuilder nativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(reactApplicationContext, this);
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
        synchronized (this.mPackages) {
            Iterator<ReactPackage> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    ReactPackage next = it.next();
                    if (!z || !this.mPackages.contains(next)) {
                        Systrace.beginSection(0L, "createAndProcessCustomReactPackage");
                        if (z) {
                            try {
                                this.mPackages.add(next);
                            } catch (Throwable th) {
                                Systrace.endSection(0L);
                                throw th;
                            }
                        }
                        processPackage(next, nativeModuleRegistryBuilder);
                        Systrace.endSection(0L);
                    }
                }
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
        Systrace.beginSection(0L, "buildNativeModuleRegistry");
        try {
            return nativeModuleRegistryBuilder.build();
        } finally {
            Systrace.endSection(0L);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
        }
    }

    private void processPackage(ReactPackage reactPackage, NativeModuleRegistryBuilder nativeModuleRegistryBuilder) {
        SystraceMessage.beginSection(0L, "processPackage").arg("className", reactPackage.getClass().getSimpleName()).flush();
        boolean z = reactPackage instanceof ReactPackageLogger;
        if (z) {
            ((ReactPackageLogger) reactPackage).startProcessPackage();
        }
        nativeModuleRegistryBuilder.processPackage(reactPackage);
        if (z) {
            ((ReactPackageLogger) reactPackage).endProcessPackage();
        }
        SystraceMessage.endSection(0L).flush();
    }
}
