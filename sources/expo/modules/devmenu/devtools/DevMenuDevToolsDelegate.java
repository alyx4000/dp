package expo.modules.devmenu.devtools;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.DevMenuInternalSettingsWrapper;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import expo.interfaces.devmenu.DevMenuManagerInterface;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: DevMenuDevToolsDelegate.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0017\u0010!\u001a\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0#H\u0082\bJ\u0006\u0010$\u001a\u00020\u001cJ\u000e\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010&\u001a\u00020\u001cR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lexpo/modules/devmenu/devtools/DevMenuDevToolsDelegate;", "", "manager", "Lexpo/interfaces/devmenu/DevMenuManagerInterface;", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "(Lexpo/interfaces/devmenu/DevMenuManagerInterface;Lcom/facebook/react/ReactInstanceManager;)V", "_reactContext", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactContext;", "_reactDevManager", "Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "kotlin.jvm.PlatformType", "devInternalSettings", "Lcom/facebook/react/devsupport/DevMenuInternalSettingsWrapper;", "getDevInternalSettings$expo_dev_menu_release", "()Lcom/facebook/react/devsupport/DevMenuInternalSettingsWrapper;", "devSettings", "Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;", "getDevSettings", "()Lcom/facebook/react/modules/debug/interfaces/DeveloperSettings;", "reactContext", "getReactContext", "()Lcom/facebook/react/bridge/ReactContext;", "reactDevManager", "getReactDevManager", "()Lcom/facebook/react/devsupport/interfaces/DevSupportManager;", "openJSInspector", "", "reload", "requestOverlaysPermission", "context", "Landroid/content/Context;", "runWithDevSupportEnabled", "action", "Lkotlin/Function0;", "toggleElementInspector", "togglePerformanceMonitor", "toggleRemoteDebugging", "expo-dev-menu_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuDevToolsDelegate {
    private final WeakReference<ReactContext> _reactContext;
    private final WeakReference<DevSupportManager> _reactDevManager;
    private final DevMenuManagerInterface manager;

    public DevMenuDevToolsDelegate(DevMenuManagerInterface manager, ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        this.manager = manager;
        this._reactDevManager = new WeakReference<>(reactInstanceManager.getDevSupportManager());
        this._reactContext = new WeakReference<>(reactInstanceManager.getCurrentReactContext());
    }

    public final DevSupportManager getReactDevManager() {
        return this._reactDevManager.get();
    }

    public final DeveloperSettings getDevSettings() {
        DevSupportManager reactDevManager = getReactDevManager();
        if (reactDevManager != null) {
            return reactDevManager.getDevSettings();
        }
        return null;
    }

    public final DevMenuInternalSettingsWrapper getDevInternalSettings$expo_dev_menu_release() {
        DeveloperSettings devSettings = getDevSettings();
        if (devSettings != null && Intrinsics.areEqual(devSettings.getClass().getCanonicalName(), "com.facebook.react.devsupport.DevLauncherInternalSettings")) {
            return new DevMenuInternalSettingsWrapper(devSettings);
        }
        return null;
    }

    public final ReactContext getReactContext() {
        return this._reactContext.get();
    }

    public final void reload() {
        final DevSupportManager reactDevManager = getReactDevManager();
        if (reactDevManager == null) {
            return;
        }
        this.manager.closeMenu();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: expo.modules.devmenu.devtools.DevMenuDevToolsDelegate$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                DevMenuDevToolsDelegate.reload$lambda$0(DevSupportManager.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reload$lambda$0(DevSupportManager reactDevManager) {
        Intrinsics.checkNotNullParameter(reactDevManager, "$reactDevManager");
        reactDevManager.handleReloadJS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void toggleRemoteDebugging$lambda$3$lambda$2(DeveloperSettings devSettings, DevSupportManager reactDevManager) {
        Intrinsics.checkNotNullParameter(devSettings, "$devSettings");
        Intrinsics.checkNotNullParameter(reactDevManager, "$reactDevManager");
        devSettings.setRemoteJSDebugEnabled(!devSettings.isRemoteJSDebugEnabled());
        reactDevManager.handleReloadJS();
    }

    public final void togglePerformanceMonitor(Context context) {
        DeveloperSettings devSettings;
        Intrinsics.checkNotNullParameter(context, "context");
        DevSupportManager reactDevManager = getReactDevManager();
        if (reactDevManager == null || (devSettings = getDevSettings()) == null) {
            return;
        }
        requestOverlaysPermission(context);
        DevSupportManager reactDevManager2 = getReactDevManager();
        if (reactDevManager2 == null) {
            return;
        }
        boolean devSupportEnabled = reactDevManager2.getDevSupportEnabled();
        reactDevManager2.setDevSupportEnabled(true);
        reactDevManager.setFpsDebugEnabled(!devSettings.isFpsDebugEnabled());
        reactDevManager2.setDevSupportEnabled(devSupportEnabled);
    }

    private final void runWithDevSupportEnabled(Function0<Unit> action) {
        DevSupportManager reactDevManager = getReactDevManager();
        if (reactDevManager == null) {
            return;
        }
        boolean devSupportEnabled = reactDevManager.getDevSupportEnabled();
        reactDevManager.setDevSupportEnabled(true);
        action.invoke();
        reactDevManager.setDevSupportEnabled(devSupportEnabled);
    }

    private final void requestOverlaysPermission(Context context) {
        if (Settings.canDrawOverlays(context)) {
            return;
        }
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse("package:" + context.getApplicationContext().getPackageName()));
        intent.setFlags(268435456);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    public final void toggleElementInspector() {
        DevSupportManager reactDevManager = getReactDevManager();
        if (reactDevManager == null) {
            return;
        }
        boolean devSupportEnabled = reactDevManager.getDevSupportEnabled();
        reactDevManager.setDevSupportEnabled(true);
        DevSupportManager reactDevManager2 = getReactDevManager();
        if (reactDevManager2 != null) {
            reactDevManager2.toggleElementInspector();
        }
        reactDevManager.setDevSupportEnabled(devSupportEnabled);
    }

    public final void toggleRemoteDebugging() {
        final DeveloperSettings devSettings;
        DevSupportManager reactDevManager = getReactDevManager();
        if (reactDevManager == null) {
            return;
        }
        boolean devSupportEnabled = reactDevManager.getDevSupportEnabled();
        reactDevManager.setDevSupportEnabled(true);
        final DevSupportManager reactDevManager2 = getReactDevManager();
        if (reactDevManager2 == null || (devSettings = getDevSettings()) == null) {
            return;
        }
        this.manager.closeMenu();
        UiThreadUtil.runOnUiThread(new Runnable() { // from class: expo.modules.devmenu.devtools.DevMenuDevToolsDelegate$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DevMenuDevToolsDelegate.toggleRemoteDebugging$lambda$3$lambda$2(DeveloperSettings.this, reactDevManager2);
            }
        });
        reactDevManager.setDevSupportEnabled(devSupportEnabled);
    }

    public final void openJSInspector() {
        ReactContext reactContext;
        DevSupportManager reactDevManager = getReactDevManager();
        if (reactDevManager == null) {
            return;
        }
        boolean devSupportEnabled = reactDevManager.getDevSupportEnabled();
        reactDevManager.setDevSupportEnabled(true);
        DevMenuInternalSettingsWrapper devInternalSettings$expo_dev_menu_release = getDevInternalSettings$expo_dev_menu_release();
        if (devInternalSettings$expo_dev_menu_release == null || (reactContext = getReactContext()) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.manager.getCoroutineScope(), null, null, new DevMenuDevToolsDelegate$openJSInspector$1$1("http://" + devInternalSettings$expo_dev_menu_release.getPackagerConnectionSettings().getServerIp(), reactContext, null), 3, null);
        reactDevManager.setDevSupportEnabled(devSupportEnabled);
    }
}
