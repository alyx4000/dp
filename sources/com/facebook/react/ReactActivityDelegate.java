package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.modules.core.PermissionListener;

/* loaded from: classes3.dex */
public class ReactActivityDelegate {
    private final Activity mActivity;
    private final String mMainComponentName;
    private PermissionListener mPermissionListener;
    private Callback mPermissionsCallback;
    private ReactDelegate mReactDelegate;

    protected Bundle getLaunchOptions() {
        return null;
    }

    protected boolean isFabricEnabled() {
        return false;
    }

    @Deprecated
    public ReactActivityDelegate(Activity activity, String str) {
        this.mActivity = activity;
        this.mMainComponentName = str;
    }

    public ReactActivityDelegate(ReactActivity reactActivity, String str) {
        this.mActivity = reactActivity;
        this.mMainComponentName = str;
    }

    protected Bundle composeLaunchOptions() {
        Bundle launchOptions = getLaunchOptions();
        if (isFabricEnabled()) {
            if (launchOptions == null) {
                launchOptions = new Bundle();
            }
            launchOptions.putBoolean("concurrentRoot", true);
        }
        return launchOptions;
    }

    protected ReactRootView createRootView() {
        return new ReactRootView(getContext());
    }

    protected ReactRootView createRootView(Bundle bundle) {
        return new ReactRootView(getContext());
    }

    protected ReactNativeHost getReactNativeHost() {
        return ((ReactApplication) getPlainActivity().getApplication()).getReactNativeHost();
    }

    public ReactHost getReactHost() {
        return ((ReactApplication) getPlainActivity().getApplication()).getReactHost();
    }

    public ReactInstanceManager getReactInstanceManager() {
        return this.mReactDelegate.getReactInstanceManager();
    }

    public String getMainComponentName() {
        return this.mMainComponentName;
    }

    protected void onCreate(Bundle bundle) {
        String mainComponentName = getMainComponentName();
        final Bundle composeLaunchOptions = composeLaunchOptions();
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactDelegate = new ReactDelegate(getPlainActivity(), getReactHost(), mainComponentName, composeLaunchOptions);
        } else {
            this.mReactDelegate = new ReactDelegate(getPlainActivity(), getReactNativeHost(), mainComponentName, composeLaunchOptions) { // from class: com.facebook.react.ReactActivityDelegate.1
                @Override // com.facebook.react.ReactDelegate
                protected ReactRootView createRootView() {
                    return ReactActivityDelegate.this.createRootView(composeLaunchOptions);
                }
            };
        }
        if (mainComponentName != null) {
            loadApp(mainComponentName);
        }
    }

    protected void loadApp(String str) {
        this.mReactDelegate.loadApp(str);
        getPlainActivity().setContentView(this.mReactDelegate.getReactRootView());
    }

    protected void onPause() {
        this.mReactDelegate.onHostPause();
    }

    protected void onResume() {
        this.mReactDelegate.onHostResume();
        Callback callback = this.mPermissionsCallback;
        if (callback != null) {
            callback.invoke(new Object[0]);
            this.mPermissionsCallback = null;
        }
    }

    protected void onDestroy() {
        this.mReactDelegate.onHostDestroy();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.mReactDelegate.onActivityResult(i, i2, intent, true);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (ReactFeatureFlags.enableBridgelessArchitecture || !getReactNativeHost().hasInstance() || !getReactNativeHost().getUseDeveloperSupport() || i != 90) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.mReactDelegate.shouldShowDevMenuOrReload(i, keyEvent);
    }

    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        if (ReactFeatureFlags.enableBridgelessArchitecture || !getReactNativeHost().hasInstance() || !getReactNativeHost().getUseDeveloperSupport() || i != 90) {
            return false;
        }
        getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
        return true;
    }

    public boolean onBackPressed() {
        return this.mReactDelegate.onBackPressed();
    }

    public boolean onNewIntent(Intent intent) {
        if (ReactFeatureFlags.enableBridgelessArchitecture || !getReactNativeHost().hasInstance()) {
            return false;
        }
        getReactNativeHost().getReactInstanceManager().onNewIntent(intent);
        return true;
    }

    public void onWindowFocusChanged(boolean z) {
        if (ReactFeatureFlags.enableBridgelessArchitecture || !getReactNativeHost().hasInstance()) {
            return;
        }
        getReactNativeHost().getReactInstanceManager().onWindowFocusChange(z);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (ReactFeatureFlags.enableBridgelessArchitecture || !getReactNativeHost().hasInstance()) {
            return;
        }
        getReactInstanceManager().onConfigurationChanged(getContext(), configuration);
    }

    public void requestPermissions(String[] strArr, int i, PermissionListener permissionListener) {
        this.mPermissionListener = permissionListener;
        getPlainActivity().requestPermissions(strArr, i);
    }

    public void onRequestPermissionsResult(final int i, final String[] strArr, final int[] iArr) {
        this.mPermissionsCallback = new Callback() { // from class: com.facebook.react.ReactActivityDelegate.2
            @Override // com.facebook.react.bridge.Callback
            public void invoke(Object... objArr) {
                if (ReactActivityDelegate.this.mPermissionListener == null || !ReactActivityDelegate.this.mPermissionListener.onRequestPermissionsResult(i, strArr, iArr)) {
                    return;
                }
                ReactActivityDelegate.this.mPermissionListener = null;
            }
        };
    }

    protected Context getContext() {
        return (Context) Assertions.assertNotNull(this.mActivity);
    }

    protected Activity getPlainActivity() {
        return (Activity) getContext();
    }
}
