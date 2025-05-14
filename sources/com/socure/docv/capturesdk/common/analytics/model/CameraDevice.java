package com.socure.docv.capturesdk.common.analytics.model;

import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003JA\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/CameraDevice;", "", "settings", "Lcom/socure/docv/capturesdk/common/analytics/model/Settings;", "capabilities", "Lcom/socure/docv/capturesdk/common/analytics/model/Capabilities;", "label", "", IterableConstants.DEVICE_ID, "modelID", "(Lcom/socure/docv/capturesdk/common/analytics/model/Settings;Lcom/socure/docv/capturesdk/common/analytics/model/Capabilities;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCapabilities", "()Lcom/socure/docv/capturesdk/common/analytics/model/Capabilities;", "setCapabilities", "(Lcom/socure/docv/capturesdk/common/analytics/model/Capabilities;)V", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "getLabel", "setLabel", "getModelID", "setModelID", "getSettings", "()Lcom/socure/docv/capturesdk/common/analytics/model/Settings;", "setSettings", "(Lcom/socure/docv/capturesdk/common/analytics/model/Settings;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CameraDevice {
    private Capabilities capabilities;
    private String deviceId;
    private String label;
    private String modelID;
    private Settings settings;

    public CameraDevice(Settings settings, Capabilities capabilities, String label, String str, String str2) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(label, "label");
        this.settings = settings;
        this.capabilities = capabilities;
        this.label = label;
        this.deviceId = str;
        this.modelID = str2;
    }

    public /* synthetic */ CameraDevice(Settings settings, Capabilities capabilities, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : settings, capabilities, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3);
    }

    public static /* synthetic */ CameraDevice copy$default(CameraDevice cameraDevice, Settings settings, Capabilities capabilities, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            settings = cameraDevice.settings;
        }
        if ((i & 2) != 0) {
            capabilities = cameraDevice.capabilities;
        }
        Capabilities capabilities2 = capabilities;
        if ((i & 4) != 0) {
            str = cameraDevice.label;
        }
        String str4 = str;
        if ((i & 8) != 0) {
            str2 = cameraDevice.deviceId;
        }
        String str5 = str2;
        if ((i & 16) != 0) {
            str3 = cameraDevice.modelID;
        }
        return cameraDevice.copy(settings, capabilities2, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final Settings getSettings() {
        return this.settings;
    }

    /* renamed from: component2, reason: from getter */
    public final Capabilities getCapabilities() {
        return this.capabilities;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getModelID() {
        return this.modelID;
    }

    public final CameraDevice copy(Settings settings, Capabilities capabilities, String label, String deviceId, String modelID) {
        Intrinsics.checkNotNullParameter(capabilities, "capabilities");
        Intrinsics.checkNotNullParameter(label, "label");
        return new CameraDevice(settings, capabilities, label, deviceId, modelID);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CameraDevice)) {
            return false;
        }
        CameraDevice cameraDevice = (CameraDevice) other;
        return Intrinsics.areEqual(this.settings, cameraDevice.settings) && Intrinsics.areEqual(this.capabilities, cameraDevice.capabilities) && Intrinsics.areEqual(this.label, cameraDevice.label) && Intrinsics.areEqual(this.deviceId, cameraDevice.deviceId) && Intrinsics.areEqual(this.modelID, cameraDevice.modelID);
    }

    public final Capabilities getCapabilities() {
        return this.capabilities;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getModelID() {
        return this.modelID;
    }

    public final Settings getSettings() {
        return this.settings;
    }

    public int hashCode() {
        Settings settings = this.settings;
        int a2 = a.a(this.label, (this.capabilities.hashCode() + ((settings == null ? 0 : settings.hashCode()) * 31)) * 31, 31);
        String str = this.deviceId;
        int hashCode = (a2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.modelID;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setCapabilities(Capabilities capabilities) {
        Intrinsics.checkNotNullParameter(capabilities, "<set-?>");
        this.capabilities = capabilities;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void setLabel(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.label = str;
    }

    public final void setModelID(String str) {
        this.modelID = str;
    }

    public final void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String toString() {
        return "CameraDevice(settings=" + this.settings + ", capabilities=" + this.capabilities + ", label=" + this.label + ", deviceId=" + this.deviceId + ", modelID=" + this.modelID + ")";
    }
}
