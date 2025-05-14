package com.socure.docv.capturesdk.common.analytics.model;

import com.facebook.react.uimanager.ViewProps;
import com.iterable.iterableapi.IterableConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010#\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003Jc\u0010(\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032 \b\u0002\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R2\u0010\u0004\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001d¨\u0006/"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Capabilities;", "", "frameRate", "Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxInt;", "facingMode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "width", ViewProps.ASPECT_RATIO, "Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxDouble;", IterableConstants.DEVICE_ID, "height", "(Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxInt;Ljava/util/ArrayList;Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxInt;Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxDouble;Ljava/lang/String;Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxInt;)V", "getAspectRatio", "()Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxDouble;", "setAspectRatio", "(Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxDouble;)V", "getDeviceId", "()Ljava/lang/String;", "setDeviceId", "(Ljava/lang/String;)V", "getFacingMode", "()Ljava/util/ArrayList;", "setFacingMode", "(Ljava/util/ArrayList;)V", "getFrameRate", "()Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxInt;", "setFrameRate", "(Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxInt;)V", "getHeight", "setHeight", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Capabilities {
    private MinMaxDouble aspectRatio;
    private String deviceId;
    private ArrayList<String> facingMode;
    private MinMaxInt frameRate;
    private MinMaxInt height;
    private MinMaxInt width;

    public Capabilities(MinMaxInt minMaxInt, ArrayList<String> arrayList, MinMaxInt width, MinMaxDouble minMaxDouble, String str, MinMaxInt height) {
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        this.frameRate = minMaxInt;
        this.facingMode = arrayList;
        this.width = width;
        this.aspectRatio = minMaxDouble;
        this.deviceId = str;
        this.height = height;
    }

    public /* synthetic */ Capabilities(MinMaxInt minMaxInt, ArrayList arrayList, MinMaxInt minMaxInt2, MinMaxDouble minMaxDouble, String str, MinMaxInt minMaxInt3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : minMaxInt, (i & 2) != 0 ? null : arrayList, minMaxInt2, (i & 8) != 0 ? null : minMaxDouble, (i & 16) != 0 ? null : str, minMaxInt3);
    }

    public static /* synthetic */ Capabilities copy$default(Capabilities capabilities, MinMaxInt minMaxInt, ArrayList arrayList, MinMaxInt minMaxInt2, MinMaxDouble minMaxDouble, String str, MinMaxInt minMaxInt3, int i, Object obj) {
        if ((i & 1) != 0) {
            minMaxInt = capabilities.frameRate;
        }
        if ((i & 2) != 0) {
            arrayList = capabilities.facingMode;
        }
        ArrayList arrayList2 = arrayList;
        if ((i & 4) != 0) {
            minMaxInt2 = capabilities.width;
        }
        MinMaxInt minMaxInt4 = minMaxInt2;
        if ((i & 8) != 0) {
            minMaxDouble = capabilities.aspectRatio;
        }
        MinMaxDouble minMaxDouble2 = minMaxDouble;
        if ((i & 16) != 0) {
            str = capabilities.deviceId;
        }
        String str2 = str;
        if ((i & 32) != 0) {
            minMaxInt3 = capabilities.height;
        }
        return capabilities.copy(minMaxInt, arrayList2, minMaxInt4, minMaxDouble2, str2, minMaxInt3);
    }

    /* renamed from: component1, reason: from getter */
    public final MinMaxInt getFrameRate() {
        return this.frameRate;
    }

    public final ArrayList<String> component2() {
        return this.facingMode;
    }

    /* renamed from: component3, reason: from getter */
    public final MinMaxInt getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final MinMaxDouble getAspectRatio() {
        return this.aspectRatio;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* renamed from: component6, reason: from getter */
    public final MinMaxInt getHeight() {
        return this.height;
    }

    public final Capabilities copy(MinMaxInt frameRate, ArrayList<String> facingMode, MinMaxInt width, MinMaxDouble aspectRatio, String deviceId, MinMaxInt height) {
        Intrinsics.checkNotNullParameter(width, "width");
        Intrinsics.checkNotNullParameter(height, "height");
        return new Capabilities(frameRate, facingMode, width, aspectRatio, deviceId, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Capabilities)) {
            return false;
        }
        Capabilities capabilities = (Capabilities) other;
        return Intrinsics.areEqual(this.frameRate, capabilities.frameRate) && Intrinsics.areEqual(this.facingMode, capabilities.facingMode) && Intrinsics.areEqual(this.width, capabilities.width) && Intrinsics.areEqual(this.aspectRatio, capabilities.aspectRatio) && Intrinsics.areEqual(this.deviceId, capabilities.deviceId) && Intrinsics.areEqual(this.height, capabilities.height);
    }

    public final MinMaxDouble getAspectRatio() {
        return this.aspectRatio;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final ArrayList<String> getFacingMode() {
        return this.facingMode;
    }

    public final MinMaxInt getFrameRate() {
        return this.frameRate;
    }

    public final MinMaxInt getHeight() {
        return this.height;
    }

    public final MinMaxInt getWidth() {
        return this.width;
    }

    public int hashCode() {
        MinMaxInt minMaxInt = this.frameRate;
        int hashCode = (minMaxInt == null ? 0 : minMaxInt.hashCode()) * 31;
        ArrayList<String> arrayList = this.facingMode;
        int hashCode2 = (this.width.hashCode() + ((hashCode + (arrayList == null ? 0 : arrayList.hashCode())) * 31)) * 31;
        MinMaxDouble minMaxDouble = this.aspectRatio;
        int hashCode3 = (hashCode2 + (minMaxDouble == null ? 0 : minMaxDouble.hashCode())) * 31;
        String str = this.deviceId;
        return this.height.hashCode() + ((hashCode3 + (str != null ? str.hashCode() : 0)) * 31);
    }

    public final void setAspectRatio(MinMaxDouble minMaxDouble) {
        this.aspectRatio = minMaxDouble;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void setFacingMode(ArrayList<String> arrayList) {
        this.facingMode = arrayList;
    }

    public final void setFrameRate(MinMaxInt minMaxInt) {
        this.frameRate = minMaxInt;
    }

    public final void setHeight(MinMaxInt minMaxInt) {
        Intrinsics.checkNotNullParameter(minMaxInt, "<set-?>");
        this.height = minMaxInt;
    }

    public final void setWidth(MinMaxInt minMaxInt) {
        Intrinsics.checkNotNullParameter(minMaxInt, "<set-?>");
        this.width = minMaxInt;
    }

    public String toString() {
        return "Capabilities(frameRate=" + this.frameRate + ", facingMode=" + this.facingMode + ", width=" + this.width + ", aspectRatio=" + this.aspectRatio + ", deviceId=" + this.deviceId + ", height=" + this.height + ")";
    }
}
