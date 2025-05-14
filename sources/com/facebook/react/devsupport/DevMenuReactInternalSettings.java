package com.facebook.react.devsupport;

import android.content.Context;
import android.content.SharedPreferences;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.devsupport.DevInternalSettings;
import expo.modules.devmenu.react.DevMenuPackagerConnectionSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuReactInternalSettings.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u001c\u0010\u0016\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000eH\u0014J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000eH\u0014J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u000eH\u0014J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000eH\u0014J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/facebook/react/devsupport/DevMenuReactInternalSettings;", "Lcom/facebook/react/devsupport/DevInternalSettings;", "serverIp", "", "application", "Landroid/content/Context;", "(Ljava/lang/String;Landroid/content/Context;)V", "packagerConnectionSettings", "Lexpo/modules/devmenu/react/DevMenuPackagerConnectionSettings;", "addMenuItem", "", "title", "getPackagerConnectionSettings", "isAnimationFpsDebugEnabled", "", "isElementInspectorEnabled", "isFpsDebugEnabled", "isHotModuleReplacementEnabled", "isJSDevModeEnabled", "isJSMinifyEnabled", "isRemoteJSDebugEnabled", "isStartSamplingProfilerOnInit", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", DatabaseConstants.KEY_FIELD, "setElementInspectorEnabled", "enabled", "setFpsDebugEnabled", "setHotModuleReplacementEnabled", "setJSDevModeEnabled", "value", "setRemoteJSDebugEnabled", "remoteJSDebugEnabled", "expo-dev-menu_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuReactInternalSettings extends DevInternalSettings {
    private final DevMenuPackagerConnectionSettings packagerConnectionSettings;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0() {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void addMenuItem(String title) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isAnimationFpsDebugEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isElementInspectorEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isFpsDebugEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected boolean isHotModuleReplacementEnabled() {
        return true;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSDevModeEnabled() {
        return true;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isJSMinifyEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isRemoteJSDebugEnabled() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public boolean isStartSamplingProfilerOnInit() {
        return false;
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setElementInspectorEnabled(boolean enabled) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setFpsDebugEnabled(boolean enabled) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setHotModuleReplacementEnabled(boolean enabled) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings
    protected void setJSDevModeEnabled(boolean value) {
    }

    @Override // com.facebook.react.devsupport.DevInternalSettings, com.facebook.react.modules.debug.interfaces.DeveloperSettings
    public void setRemoteJSDebugEnabled(boolean remoteJSDebugEnabled) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevMenuReactInternalSettings(String serverIp, Context application) {
        super(application, new DevInternalSettings.Listener() { // from class: com.facebook.react.devsupport.DevMenuReactInternalSettings$$ExternalSyntheticLambda0
            @Override // com.facebook.react.devsupport.DevInternalSettings.Listener
            public final void onInternalSettingsChanged() {
                DevMenuReactInternalSettings._init_$lambda$0();
            }
        });
        Intrinsics.checkNotNullParameter(serverIp, "serverIp");
        Intrinsics.checkNotNullParameter(application, "application");
        this.packagerConnectionSettings = new DevMenuPackagerConnectionSettings(serverIp, application);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.devsupport.DevInternalSettings
    public DevMenuPackagerConnectionSettings getPackagerConnectionSettings() {
        return this.packagerConnectionSettings;
    }
}
