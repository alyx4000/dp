package com.socure.idplus.device.internal.behavior.model;

import com.amplitude.reactnative.AndroidContextProvider;
import com.google.gson.annotations.SerializedName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@kotlin.Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/socure/idplus/device/internal/behavior/model/Metadata;", "", "osVersion", "", "socureSdkVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getOsVersion", "()Ljava/lang/String;", "getSocureSdkVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Metadata {

    @SerializedName("osVersion")
    private final String osVersion;

    @SerializedName("socureSdkVersion")
    private final String socureSdkVersion;

    public Metadata() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ Metadata copy$default(Metadata metadata, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = metadata.osVersion;
        }
        if ((i & 2) != 0) {
            str2 = metadata.socureSdkVersion;
        }
        return metadata.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOsVersion() {
        return this.osVersion;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSocureSdkVersion() {
        return this.socureSdkVersion;
    }

    public final Metadata copy(String osVersion, String socureSdkVersion) {
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(socureSdkVersion, "socureSdkVersion");
        return new Metadata(osVersion, socureSdkVersion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Metadata)) {
            return false;
        }
        Metadata metadata = (Metadata) other;
        return Intrinsics.areEqual(this.osVersion, metadata.osVersion) && Intrinsics.areEqual(this.socureSdkVersion, metadata.socureSdkVersion);
    }

    public final String getOsVersion() {
        return this.osVersion;
    }

    public final String getSocureSdkVersion() {
        return this.socureSdkVersion;
    }

    public int hashCode() {
        return this.socureSdkVersion.hashCode() + (this.osVersion.hashCode() * 31);
    }

    public String toString() {
        return "Metadata(osVersion=" + this.osVersion + ", socureSdkVersion=" + this.socureSdkVersion + ")";
    }

    public Metadata(String osVersion, String socureSdkVersion) {
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(socureSdkVersion, "socureSdkVersion");
        this.osVersion = osVersion;
        this.socureSdkVersion = socureSdkVersion;
    }

    public /* synthetic */ Metadata(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AndroidContextProvider.OS_NAME : str, (i & 2) != 0 ? "4.1.0" : str2);
    }
}
