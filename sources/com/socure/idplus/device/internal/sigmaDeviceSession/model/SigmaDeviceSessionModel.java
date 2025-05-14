package com.socure.idplus.device.internal.sigmaDeviceSession.model;

import com.google.gson.annotations.SerializedName;
import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0081\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0012\u001a\u00020\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/socure/idplus/device/internal/sigmaDeviceSession/model/SigmaDeviceSessionModel;", "", IterableConstants.DEVICE_ID, "", "sessionToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getDeviceId", "()Ljava/lang/String;", "getSessionToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "validateData", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SigmaDeviceSessionModel {

    @SerializedName(IterableConstants.DEVICE_ID)
    private final String deviceId;

    @SerializedName("sessionToken")
    private final String sessionToken;

    public SigmaDeviceSessionModel(String deviceId, String sessionToken) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        this.deviceId = deviceId;
        this.sessionToken = sessionToken;
    }

    public static /* synthetic */ SigmaDeviceSessionModel copy$default(SigmaDeviceSessionModel sigmaDeviceSessionModel, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sigmaDeviceSessionModel.deviceId;
        }
        if ((i & 2) != 0) {
            str2 = sigmaDeviceSessionModel.sessionToken;
        }
        return sigmaDeviceSessionModel.copy(str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSessionToken() {
        return this.sessionToken;
    }

    public final SigmaDeviceSessionModel copy(String deviceId, String sessionToken) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        return new SigmaDeviceSessionModel(deviceId, sessionToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SigmaDeviceSessionModel)) {
            return false;
        }
        SigmaDeviceSessionModel sigmaDeviceSessionModel = (SigmaDeviceSessionModel) other;
        return Intrinsics.areEqual(this.deviceId, sigmaDeviceSessionModel.deviceId) && Intrinsics.areEqual(this.sessionToken, sigmaDeviceSessionModel.sessionToken);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        return this.sessionToken.hashCode() + (this.deviceId.hashCode() * 31);
    }

    public String toString() {
        return "SigmaDeviceSessionModel(deviceId=" + this.deviceId + ", sessionToken=" + this.sessionToken + ")";
    }

    public final boolean validateData() {
        return this.deviceId.length() > 0 && this.sessionToken.length() > 0;
    }
}
