package com.facebook.react.devsupport;

import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevLauncherInternalSettings.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/devsupport/DevLauncherInternalSettingsWrapper;", "", "devSettings", "Lcom/facebook/react/devsupport/DevInternalSettings;", "(Lcom/facebook/react/devsupport/DevInternalSettings;)V", "value", "", "isRemoteJSDebugEnabled", "()Z", "setRemoteJSDebugEnabled", "(Z)V", "isStartSamplingProfilerOnInit", "packagerConnectionSettings", "Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;", "getPackagerConnectionSettings", "()Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;", "expo-dev-launcher_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevLauncherInternalSettingsWrapper {
    private final DevInternalSettings devSettings;
    private final boolean isStartSamplingProfilerOnInit;
    private final PackagerConnectionSettings packagerConnectionSettings;

    public DevLauncherInternalSettingsWrapper(DevInternalSettings devSettings) {
        Intrinsics.checkNotNullParameter(devSettings, "devSettings");
        this.devSettings = devSettings;
        this.isStartSamplingProfilerOnInit = devSettings.isStartSamplingProfilerOnInit();
        PackagerConnectionSettings packagerConnectionSettings = devSettings.getPackagerConnectionSettings();
        Intrinsics.checkNotNullExpressionValue(packagerConnectionSettings, "devSettings.packagerConnectionSettings");
        this.packagerConnectionSettings = packagerConnectionSettings;
    }

    /* renamed from: isStartSamplingProfilerOnInit, reason: from getter */
    public final boolean getIsStartSamplingProfilerOnInit() {
        return this.isStartSamplingProfilerOnInit;
    }

    public final boolean isRemoteJSDebugEnabled() {
        return this.devSettings.isRemoteJSDebugEnabled();
    }

    public final void setRemoteJSDebugEnabled(boolean z) {
        this.devSettings.setRemoteJSDebugEnabled(z);
    }

    public final PackagerConnectionSettings getPackagerConnectionSettings() {
        return this.packagerConnectionSettings;
    }
}
