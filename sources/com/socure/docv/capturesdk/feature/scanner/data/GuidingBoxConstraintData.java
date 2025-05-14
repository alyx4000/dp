package com.socure.docv.capturesdk.feature.scanner.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000fJ8\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBoxConstraintData;", "", "dimensionRatio", "", "guidingBoxBgId", "", "width", "matchConstraintPercentWidth", "", "(Ljava/lang/String;IILjava/lang/Float;)V", "getDimensionRatio", "()Ljava/lang/String;", "getGuidingBoxBgId", "()I", "getMatchConstraintPercentWidth", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getWidth", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;IILjava/lang/Float;)Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBoxConstraintData;", "equals", "", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GuidingBoxConstraintData {
    private final String dimensionRatio;
    private final int guidingBoxBgId;
    private final Float matchConstraintPercentWidth;
    private final int width;

    public GuidingBoxConstraintData(String dimensionRatio, int i, int i2, Float f) {
        Intrinsics.checkNotNullParameter(dimensionRatio, "dimensionRatio");
        this.dimensionRatio = dimensionRatio;
        this.guidingBoxBgId = i;
        this.width = i2;
        this.matchConstraintPercentWidth = f;
    }

    public /* synthetic */ GuidingBoxConstraintData(String str, int i, int i2, Float f, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i3 & 8) != 0 ? null : f);
    }

    public static /* synthetic */ GuidingBoxConstraintData copy$default(GuidingBoxConstraintData guidingBoxConstraintData, String str, int i, int i2, Float f, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = guidingBoxConstraintData.dimensionRatio;
        }
        if ((i3 & 2) != 0) {
            i = guidingBoxConstraintData.guidingBoxBgId;
        }
        if ((i3 & 4) != 0) {
            i2 = guidingBoxConstraintData.width;
        }
        if ((i3 & 8) != 0) {
            f = guidingBoxConstraintData.matchConstraintPercentWidth;
        }
        return guidingBoxConstraintData.copy(str, i, i2, f);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDimensionRatio() {
        return this.dimensionRatio;
    }

    /* renamed from: component2, reason: from getter */
    public final int getGuidingBoxBgId() {
        return this.guidingBoxBgId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component4, reason: from getter */
    public final Float getMatchConstraintPercentWidth() {
        return this.matchConstraintPercentWidth;
    }

    public final GuidingBoxConstraintData copy(String dimensionRatio, int guidingBoxBgId, int width, Float matchConstraintPercentWidth) {
        Intrinsics.checkNotNullParameter(dimensionRatio, "dimensionRatio");
        return new GuidingBoxConstraintData(dimensionRatio, guidingBoxBgId, width, matchConstraintPercentWidth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuidingBoxConstraintData)) {
            return false;
        }
        GuidingBoxConstraintData guidingBoxConstraintData = (GuidingBoxConstraintData) other;
        return Intrinsics.areEqual(this.dimensionRatio, guidingBoxConstraintData.dimensionRatio) && this.guidingBoxBgId == guidingBoxConstraintData.guidingBoxBgId && this.width == guidingBoxConstraintData.width && Intrinsics.areEqual((Object) this.matchConstraintPercentWidth, (Object) guidingBoxConstraintData.matchConstraintPercentWidth);
    }

    public final String getDimensionRatio() {
        return this.dimensionRatio;
    }

    public final int getGuidingBoxBgId() {
        return this.guidingBoxBgId;
    }

    public final Float getMatchConstraintPercentWidth() {
        return this.matchConstraintPercentWidth;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int hashCode = (Integer.hashCode(this.width) + ((Integer.hashCode(this.guidingBoxBgId) + (this.dimensionRatio.hashCode() * 31)) * 31)) * 31;
        Float f = this.matchConstraintPercentWidth;
        return hashCode + (f == null ? 0 : f.hashCode());
    }

    public String toString() {
        return "GuidingBoxConstraintData(dimensionRatio=" + this.dimensionRatio + ", guidingBoxBgId=" + this.guidingBoxBgId + ", width=" + this.width + ", matchConstraintPercentWidth=" + this.matchConstraintPercentWidth + ")";
    }
}
