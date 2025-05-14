package com.socure.idplus.device.internal.sigmaDeviceConfig.model;

import com.google.gson.annotations.SerializedName;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Device;", "", "host", "", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsDevice;", "(Ljava/lang/String;Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsDevice;)V", "getFlags", "()Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsDevice;", "setFlags", "(Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsDevice;)V", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Device {

    @SerializedName(NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY)
    private FlagsDevice flags;

    @SerializedName("host")
    private String host;

    public Device(String host, FlagsDevice flags) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(flags, "flags");
        this.host = host;
        this.flags = flags;
    }

    public static /* synthetic */ Device copy$default(Device device, String str, FlagsDevice flagsDevice, int i, Object obj) {
        if ((i & 1) != 0) {
            str = device.host;
        }
        if ((i & 2) != 0) {
            flagsDevice = device.flags;
        }
        return device.copy(str, flagsDevice);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component2, reason: from getter */
    public final FlagsDevice getFlags() {
        return this.flags;
    }

    public final Device copy(String host, FlagsDevice flags) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(flags, "flags");
        return new Device(host, flags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Device)) {
            return false;
        }
        Device device = (Device) other;
        return Intrinsics.areEqual(this.host, device.host) && Intrinsics.areEqual(this.flags, device.flags);
    }

    public final FlagsDevice getFlags() {
        return this.flags;
    }

    public final String getHost() {
        return this.host;
    }

    public int hashCode() {
        return this.flags.hashCode() + (this.host.hashCode() * 31);
    }

    public final void setFlags(FlagsDevice flagsDevice) {
        Intrinsics.checkNotNullParameter(flagsDevice, "<set-?>");
        this.flags = flagsDevice;
    }

    public final void setHost(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.host = str;
    }

    public String toString() {
        return "Device(host=" + this.host + ", flags=" + this.flags + ")";
    }

    public /* synthetic */ Device(String str, FlagsDevice flagsDevice, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? new FlagsDevice(false, 1, null) : flagsDevice);
    }
}
