package com.socure.docv.capturesdk.common.analytics.model;

import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011JJ\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013¨\u0006%"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Settings;", "", "frameRate", "", "facingMode", "", "width", IterableConstants.DEVICE_ID, "height", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "getFacingMode", "setFacingMode", "getFrameRate", "()Ljava/lang/Integer;", "setFrameRate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getHeight", "setHeight", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/socure/docv/capturesdk/common/analytics/model/Settings;", "equals", "", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Settings {
    private String deviceId;
    private String facingMode;
    private Integer frameRate;
    private Integer height;
    private Integer width;

    public Settings() {
        this(null, null, null, null, null, 31, null);
    }

    public Settings(Integer num, String str, Integer num2, String str2, Integer num3) {
        this.frameRate = num;
        this.facingMode = str;
        this.width = num2;
        this.deviceId = str2;
        this.height = num3;
    }

    public /* synthetic */ Settings(Integer num, String str, Integer num2, String str2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : num3);
    }

    public static /* synthetic */ Settings copy$default(Settings settings, Integer num, String str, Integer num2, String str2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = settings.frameRate;
        }
        if ((i & 2) != 0) {
            str = settings.facingMode;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            num2 = settings.width;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            str2 = settings.deviceId;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            num3 = settings.height;
        }
        return settings.copy(num, str3, num4, str4, num3);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getFrameRate() {
        return this.frameRate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getFacingMode() {
        return this.facingMode;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    public final Settings copy(Integer frameRate, String facingMode, Integer width, String deviceId, Integer height) {
        return new Settings(frameRate, facingMode, width, deviceId, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Settings)) {
            return false;
        }
        Settings settings = (Settings) other;
        return Intrinsics.areEqual(this.frameRate, settings.frameRate) && Intrinsics.areEqual(this.facingMode, settings.facingMode) && Intrinsics.areEqual(this.width, settings.width) && Intrinsics.areEqual(this.deviceId, settings.deviceId) && Intrinsics.areEqual(this.height, settings.height);
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getFacingMode() {
        return this.facingMode;
    }

    public final Integer getFrameRate() {
        return this.frameRate;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        Integer num = this.frameRate;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.facingMode;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.width;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.deviceId;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num3 = this.height;
        return hashCode4 + (num3 != null ? num3.hashCode() : 0);
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void setFacingMode(String str) {
        this.facingMode = str;
    }

    public final void setFrameRate(Integer num) {
        this.frameRate = num;
    }

    public final void setHeight(Integer num) {
        this.height = num;
    }

    public final void setWidth(Integer num) {
        this.width = num;
    }

    public String toString() {
        return "Settings(frameRate=" + this.frameRate + ", facingMode=" + this.facingMode + ", width=" + this.width + ", deviceId=" + this.deviceId + ", height=" + this.height + ")";
    }
}
