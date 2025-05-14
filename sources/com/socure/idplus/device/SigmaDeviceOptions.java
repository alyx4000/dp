package com.socure.idplus.device;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J)\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0019\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/socure/idplus/device/SigmaDeviceOptions;", "", "", "component1", "", "component2", "component3", "omitLocationData", "advertisingID", "useSocureGov", "copy", "toString", "", "hashCode", "other", "equals", "a", "Z", "getOmitLocationData", "()Z", "b", "Ljava/lang/String;", "getAdvertisingID", "()Ljava/lang/String;", "c", "getUseSocureGov", "<init>", "(ZLjava/lang/String;Z)V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final /* data */ class SigmaDeviceOptions {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final boolean omitLocationData;

    /* renamed from: b, reason: from kotlin metadata */
    public final String advertisingID;

    /* renamed from: c, reason: from kotlin metadata */
    public final boolean useSocureGov;

    public SigmaDeviceOptions() {
        this(false, null, false, 7, null);
    }

    public static /* synthetic */ SigmaDeviceOptions copy$default(SigmaDeviceOptions sigmaDeviceOptions, boolean z, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sigmaDeviceOptions.omitLocationData;
        }
        if ((i & 2) != 0) {
            str = sigmaDeviceOptions.advertisingID;
        }
        if ((i & 4) != 0) {
            z2 = sigmaDeviceOptions.useSocureGov;
        }
        return sigmaDeviceOptions.copy(z, str, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOmitLocationData() {
        return this.omitLocationData;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAdvertisingID() {
        return this.advertisingID;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUseSocureGov() {
        return this.useSocureGov;
    }

    public final SigmaDeviceOptions copy(boolean omitLocationData, String advertisingID, boolean useSocureGov) {
        return new SigmaDeviceOptions(omitLocationData, advertisingID, useSocureGov);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SigmaDeviceOptions)) {
            return false;
        }
        SigmaDeviceOptions sigmaDeviceOptions = (SigmaDeviceOptions) other;
        return this.omitLocationData == sigmaDeviceOptions.omitLocationData && Intrinsics.areEqual(this.advertisingID, sigmaDeviceOptions.advertisingID) && this.useSocureGov == sigmaDeviceOptions.useSocureGov;
    }

    public final String getAdvertisingID() {
        return this.advertisingID;
    }

    public final boolean getOmitLocationData() {
        return this.omitLocationData;
    }

    public final boolean getUseSocureGov() {
        return this.useSocureGov;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.omitLocationData) * 31;
        String str = this.advertisingID;
        return Boolean.hashCode(this.useSocureGov) + ((hashCode + (str == null ? 0 : str.hashCode())) * 31);
    }

    public String toString() {
        return "SigmaDeviceOptions(omitLocationData=" + this.omitLocationData + ", advertisingID=" + this.advertisingID + ", useSocureGov=" + this.useSocureGov + ")";
    }

    public SigmaDeviceOptions(boolean z, String str, boolean z2) {
        this.omitLocationData = z;
        this.advertisingID = str;
        this.useSocureGov = z2;
    }

    public /* synthetic */ SigmaDeviceOptions(boolean z, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2);
    }
}
