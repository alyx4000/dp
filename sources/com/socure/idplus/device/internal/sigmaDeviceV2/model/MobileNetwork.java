package com.socure.idplus.device.internal.sigmaDeviceV2.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceV2/model/MobileNetwork;", "", "carrierName", "", "isoCountryCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getCarrierName", "()Ljava/lang/String;", "getIsoCountryCode", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MobileNetwork {

    @SerializedName("carrierName")
    private final String carrierName;

    @SerializedName("isoCountryCode")
    private final String isoCountryCode;

    public MobileNetwork(String carrierName, String isoCountryCode) {
        Intrinsics.checkNotNullParameter(carrierName, "carrierName");
        Intrinsics.checkNotNullParameter(isoCountryCode, "isoCountryCode");
        this.carrierName = carrierName;
        this.isoCountryCode = isoCountryCode;
    }

    public static /* synthetic */ MobileNetwork copy$default(MobileNetwork mobileNetwork, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mobileNetwork.carrierName;
        }
        if ((i & 2) != 0) {
            str2 = mobileNetwork.isoCountryCode;
        }
        return mobileNetwork.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCarrierName() {
        return this.carrierName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getIsoCountryCode() {
        return this.isoCountryCode;
    }

    public final MobileNetwork copy(String carrierName, String isoCountryCode) {
        Intrinsics.checkNotNullParameter(carrierName, "carrierName");
        Intrinsics.checkNotNullParameter(isoCountryCode, "isoCountryCode");
        return new MobileNetwork(carrierName, isoCountryCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MobileNetwork)) {
            return false;
        }
        MobileNetwork mobileNetwork = (MobileNetwork) other;
        return Intrinsics.areEqual(this.carrierName, mobileNetwork.carrierName) && Intrinsics.areEqual(this.isoCountryCode, mobileNetwork.isoCountryCode);
    }

    public final String getCarrierName() {
        return this.carrierName;
    }

    public final String getIsoCountryCode() {
        return this.isoCountryCode;
    }

    public int hashCode() {
        return this.isoCountryCode.hashCode() + (this.carrierName.hashCode() * 31);
    }

    public String toString() {
        return "MobileNetwork(carrierName=" + this.carrierName + ", isoCountryCode=" + this.isoCountryCode + ")";
    }
}
