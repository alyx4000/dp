package com.socure.idplus.device.internal.sigmaDeviceConfig.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsDevice;", "", "enableFullPrecisionLocation", "", "(Z)V", "getEnableFullPrecisionLocation", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FlagsDevice {

    @SerializedName("enableFullPrecisionLocation")
    private final boolean enableFullPrecisionLocation;

    public FlagsDevice() {
        this(false, 1, null);
    }

    public static /* synthetic */ FlagsDevice copy$default(FlagsDevice flagsDevice, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = flagsDevice.enableFullPrecisionLocation;
        }
        return flagsDevice.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getEnableFullPrecisionLocation() {
        return this.enableFullPrecisionLocation;
    }

    public final FlagsDevice copy(boolean enableFullPrecisionLocation) {
        return new FlagsDevice(enableFullPrecisionLocation);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof FlagsDevice) && this.enableFullPrecisionLocation == ((FlagsDevice) other).enableFullPrecisionLocation;
    }

    public final boolean getEnableFullPrecisionLocation() {
        return this.enableFullPrecisionLocation;
    }

    public int hashCode() {
        return Boolean.hashCode(this.enableFullPrecisionLocation);
    }

    public String toString() {
        return "FlagsDevice(enableFullPrecisionLocation=" + this.enableFullPrecisionLocation + ")";
    }

    public FlagsDevice(boolean z) {
        this.enableFullPrecisionLocation = z;
    }

    public /* synthetic */ FlagsDevice(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z);
    }
}
