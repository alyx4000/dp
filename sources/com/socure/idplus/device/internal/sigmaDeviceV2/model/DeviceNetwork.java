package com.socure.idplus.device.internal.sigmaDeviceV2.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/DeviceNetwork;", "", "vpnStatus", "", "(Z)V", "getVpnStatus", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceNetwork {

    @SerializedName("vpnStatus")
    private final boolean vpnStatus;

    public DeviceNetwork(boolean z) {
        this.vpnStatus = z;
    }

    public static /* synthetic */ DeviceNetwork copy$default(DeviceNetwork deviceNetwork, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = deviceNetwork.vpnStatus;
        }
        return deviceNetwork.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getVpnStatus() {
        return this.vpnStatus;
    }

    public final DeviceNetwork copy(boolean vpnStatus) {
        return new DeviceNetwork(vpnStatus);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeviceNetwork) && this.vpnStatus == ((DeviceNetwork) other).vpnStatus;
    }

    public final boolean getVpnStatus() {
        return this.vpnStatus;
    }

    public int hashCode() {
        return Boolean.hashCode(this.vpnStatus);
    }

    public String toString() {
        return "DeviceNetwork(vpnStatus=" + this.vpnStatus + ")";
    }
}
