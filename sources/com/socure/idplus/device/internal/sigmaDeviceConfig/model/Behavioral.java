package com.socure.idplus.device.internal.sigmaDeviceConfig.model;

import com.google.gson.annotations.SerializedName;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006#"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/Behavioral;", "", NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY, "Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsBehavior;", "host", "", "sessionDuration", "", "sampleRate", "", "bundleGenerationInterval", "(Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsBehavior;Ljava/lang/String;JFJ)V", "getBundleGenerationInterval", "()J", "getFlags", "()Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsBehavior;", "setFlags", "(Lcom/socure/idplus/device/internal/sigmaDeviceConfig/model/FlagsBehavior;)V", "getHost", "()Ljava/lang/String;", "getSampleRate", "()F", "getSessionDuration", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Behavioral {

    @SerializedName("bundleGenerationInterval")
    private final long bundleGenerationInterval;

    @SerializedName(NotificationsChannelSerializer.AUDIO_ATTRIBUTES_FLAGS_KEY)
    private FlagsBehavior flags;

    @SerializedName("host")
    private final String host;

    @SerializedName("sampleRate")
    private final float sampleRate;

    @SerializedName("sessionDuration")
    private final long sessionDuration;

    public Behavioral(FlagsBehavior flags, String host, long j, float f, long j2) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(host, "host");
        this.flags = flags;
        this.host = host;
        this.sessionDuration = j;
        this.sampleRate = f;
        this.bundleGenerationInterval = j2;
    }

    public static /* synthetic */ Behavioral copy$default(Behavioral behavioral, FlagsBehavior flagsBehavior, String str, long j, float f, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            flagsBehavior = behavioral.flags;
        }
        if ((i & 2) != 0) {
            str = behavioral.host;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            j = behavioral.sessionDuration;
        }
        long j3 = j;
        if ((i & 8) != 0) {
            f = behavioral.sampleRate;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            j2 = behavioral.bundleGenerationInterval;
        }
        return behavioral.copy(flagsBehavior, str2, j3, f2, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final FlagsBehavior getFlags() {
        return this.flags;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    /* renamed from: component4, reason: from getter */
    public final float getSampleRate() {
        return this.sampleRate;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBundleGenerationInterval() {
        return this.bundleGenerationInterval;
    }

    public final Behavioral copy(FlagsBehavior flags, String host, long sessionDuration, float sampleRate, long bundleGenerationInterval) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(host, "host");
        return new Behavioral(flags, host, sessionDuration, sampleRate, bundleGenerationInterval);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Behavioral)) {
            return false;
        }
        Behavioral behavioral = (Behavioral) other;
        return Intrinsics.areEqual(this.flags, behavioral.flags) && Intrinsics.areEqual(this.host, behavioral.host) && this.sessionDuration == behavioral.sessionDuration && Float.compare(this.sampleRate, behavioral.sampleRate) == 0 && this.bundleGenerationInterval == behavioral.bundleGenerationInterval;
    }

    public final long getBundleGenerationInterval() {
        return this.bundleGenerationInterval;
    }

    public final FlagsBehavior getFlags() {
        return this.flags;
    }

    public final String getHost() {
        return this.host;
    }

    public final float getSampleRate() {
        return this.sampleRate;
    }

    public final long getSessionDuration() {
        return this.sessionDuration;
    }

    public int hashCode() {
        return Long.hashCode(this.bundleGenerationInterval) + ((Float.hashCode(this.sampleRate) + ((Long.hashCode(this.sessionDuration) + ((this.host.hashCode() + (this.flags.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public final void setFlags(FlagsBehavior flagsBehavior) {
        Intrinsics.checkNotNullParameter(flagsBehavior, "<set-?>");
        this.flags = flagsBehavior;
    }

    public String toString() {
        return "Behavioral(flags=" + this.flags + ", host=" + this.host + ", sessionDuration=" + this.sessionDuration + ", sampleRate=" + this.sampleRate + ", bundleGenerationInterval=" + this.bundleGenerationInterval + ")";
    }

    public /* synthetic */ Behavioral(FlagsBehavior flagsBehavior, String str, long j, float f, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new FlagsBehavior(false, 1, null) : flagsBehavior, str, j, f, j2);
    }
}
