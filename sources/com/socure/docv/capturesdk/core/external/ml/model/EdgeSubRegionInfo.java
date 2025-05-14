package com.socure.docv.capturesdk.core.external.ml.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u000b¨\u0006\u001f"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeSubRegionInfo;", "", "leftRegion", "", "topRegion", "rightRegion", "bottomRegion", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBottomRegion", "()Ljava/lang/Boolean;", "setBottomRegion", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getLeftRegion", "setLeftRegion", "getRightRegion", "setRightRegion", "getTopRegion", "setTopRegion", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeSubRegionInfo;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EdgeSubRegionInfo {
    private Boolean bottomRegion;
    private Boolean leftRegion;
    private Boolean rightRegion;
    private Boolean topRegion;

    public EdgeSubRegionInfo(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.leftRegion = bool;
        this.topRegion = bool2;
        this.rightRegion = bool3;
        this.bottomRegion = bool4;
    }

    public static /* synthetic */ EdgeSubRegionInfo copy$default(EdgeSubRegionInfo edgeSubRegionInfo, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = edgeSubRegionInfo.leftRegion;
        }
        if ((i & 2) != 0) {
            bool2 = edgeSubRegionInfo.topRegion;
        }
        if ((i & 4) != 0) {
            bool3 = edgeSubRegionInfo.rightRegion;
        }
        if ((i & 8) != 0) {
            bool4 = edgeSubRegionInfo.bottomRegion;
        }
        return edgeSubRegionInfo.copy(bool, bool2, bool3, bool4);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getLeftRegion() {
        return this.leftRegion;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getTopRegion() {
        return this.topRegion;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getRightRegion() {
        return this.rightRegion;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getBottomRegion() {
        return this.bottomRegion;
    }

    public final EdgeSubRegionInfo copy(Boolean leftRegion, Boolean topRegion, Boolean rightRegion, Boolean bottomRegion) {
        return new EdgeSubRegionInfo(leftRegion, topRegion, rightRegion, bottomRegion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EdgeSubRegionInfo)) {
            return false;
        }
        EdgeSubRegionInfo edgeSubRegionInfo = (EdgeSubRegionInfo) other;
        return Intrinsics.areEqual(this.leftRegion, edgeSubRegionInfo.leftRegion) && Intrinsics.areEqual(this.topRegion, edgeSubRegionInfo.topRegion) && Intrinsics.areEqual(this.rightRegion, edgeSubRegionInfo.rightRegion) && Intrinsics.areEqual(this.bottomRegion, edgeSubRegionInfo.bottomRegion);
    }

    public final Boolean getBottomRegion() {
        return this.bottomRegion;
    }

    public final Boolean getLeftRegion() {
        return this.leftRegion;
    }

    public final Boolean getRightRegion() {
        return this.rightRegion;
    }

    public final Boolean getTopRegion() {
        return this.topRegion;
    }

    public int hashCode() {
        Boolean bool = this.leftRegion;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.topRegion;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.rightRegion;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.bottomRegion;
        return hashCode3 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public final void setBottomRegion(Boolean bool) {
        this.bottomRegion = bool;
    }

    public final void setLeftRegion(Boolean bool) {
        this.leftRegion = bool;
    }

    public final void setRightRegion(Boolean bool) {
        this.rightRegion = bool;
    }

    public final void setTopRegion(Boolean bool) {
        this.topRegion = bool;
    }

    public String toString() {
        return "EdgeSubRegionInfo(leftRegion=" + this.leftRegion + ", topRegion=" + this.topRegion + ", rightRegion=" + this.rightRegion + ", bottomRegion=" + this.bottomRegion + ")";
    }
}
