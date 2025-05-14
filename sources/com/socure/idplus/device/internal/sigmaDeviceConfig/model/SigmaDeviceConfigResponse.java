package com.socure.idplus.device.internal.sigmaDeviceConfig.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u0011\u001a\u00020\u000fJ\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u000fJ\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/SigmaDeviceConfigResponse;", "", "behavioral", "Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Behavioral;", "device", "Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Device;", "(Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Behavioral;Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Device;)V", "getBehavioral", "()Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Behavioral;", "getDevice", "()Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Device;", "component1", "component2", "copy", "equals", "", "other", "hasValidResponse", "hashCode", "", "isBehaviorEnabled", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SigmaDeviceConfigResponse {

    @SerializedName("behavioral")
    private final Behavioral behavioral;

    @SerializedName("device")
    private final Device device;

    public SigmaDeviceConfigResponse(Behavioral behavioral, Device device) {
        Intrinsics.checkNotNullParameter(behavioral, "behavioral");
        Intrinsics.checkNotNullParameter(device, "device");
        this.behavioral = behavioral;
        this.device = device;
    }

    public static /* synthetic */ SigmaDeviceConfigResponse copy$default(SigmaDeviceConfigResponse sigmaDeviceConfigResponse, Behavioral behavioral, Device device, int i, Object obj) {
        if ((i & 1) != 0) {
            behavioral = sigmaDeviceConfigResponse.behavioral;
        }
        if ((i & 2) != 0) {
            device = sigmaDeviceConfigResponse.device;
        }
        return sigmaDeviceConfigResponse.copy(behavioral, device);
    }

    /* renamed from: component1, reason: from getter */
    public final Behavioral getBehavioral() {
        return this.behavioral;
    }

    /* renamed from: component2, reason: from getter */
    public final Device getDevice() {
        return this.device;
    }

    public final SigmaDeviceConfigResponse copy(Behavioral behavioral, Device device) {
        Intrinsics.checkNotNullParameter(behavioral, "behavioral");
        Intrinsics.checkNotNullParameter(device, "device");
        return new SigmaDeviceConfigResponse(behavioral, device);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SigmaDeviceConfigResponse)) {
            return false;
        }
        SigmaDeviceConfigResponse sigmaDeviceConfigResponse = (SigmaDeviceConfigResponse) other;
        return Intrinsics.areEqual(this.behavioral, sigmaDeviceConfigResponse.behavioral) && Intrinsics.areEqual(this.device, sigmaDeviceConfigResponse.device);
    }

    public final Behavioral getBehavioral() {
        return this.behavioral;
    }

    public final Device getDevice() {
        return this.device;
    }

    public final boolean hasValidResponse() {
        return (StringsKt.isBlank(this.device.getHost()) ^ true) && (StringsKt.isBlank(this.behavioral.getHost()) ^ true);
    }

    public int hashCode() {
        return this.device.hashCode() + (this.behavioral.hashCode() * 31);
    }

    public final boolean isBehaviorEnabled() {
        return this.behavioral.getFlags().getEnableBehavior();
    }

    public String toString() {
        return "SigmaDeviceConfigResponse(behavioral=" + this.behavioral + ", device=" + this.device + ")";
    }
}
