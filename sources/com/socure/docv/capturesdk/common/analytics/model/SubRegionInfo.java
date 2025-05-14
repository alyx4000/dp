package com.socure.docv.capturesdk.common.analytics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ>\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/SubRegionInfo;", "", "topRegion", "", "bottomRegion", "leftRegion", "rightRegion", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getBottomRegion", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLeftRegion", "getRightRegion", "getTopRegion", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/socure/docv/capturesdk/common/analytics/model/SubRegionInfo;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SubRegionInfo {
    private final Boolean bottomRegion;
    private final Boolean leftRegion;
    private final Boolean rightRegion;
    private final Boolean topRegion;

    public SubRegionInfo() {
        this(null, null, null, null, 15, null);
    }

    public SubRegionInfo(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
        this.topRegion = bool;
        this.bottomRegion = bool2;
        this.leftRegion = bool3;
        this.rightRegion = bool4;
    }

    public /* synthetic */ SubRegionInfo(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : bool4);
    }

    public static /* synthetic */ SubRegionInfo copy$default(SubRegionInfo subRegionInfo, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = subRegionInfo.topRegion;
        }
        if ((i & 2) != 0) {
            bool2 = subRegionInfo.bottomRegion;
        }
        if ((i & 4) != 0) {
            bool3 = subRegionInfo.leftRegion;
        }
        if ((i & 8) != 0) {
            bool4 = subRegionInfo.rightRegion;
        }
        return subRegionInfo.copy(bool, bool2, bool3, bool4);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getTopRegion() {
        return this.topRegion;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getBottomRegion() {
        return this.bottomRegion;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getLeftRegion() {
        return this.leftRegion;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getRightRegion() {
        return this.rightRegion;
    }

    public final SubRegionInfo copy(Boolean topRegion, Boolean bottomRegion, Boolean leftRegion, Boolean rightRegion) {
        return new SubRegionInfo(topRegion, bottomRegion, leftRegion, rightRegion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubRegionInfo)) {
            return false;
        }
        SubRegionInfo subRegionInfo = (SubRegionInfo) other;
        return Intrinsics.areEqual(this.topRegion, subRegionInfo.topRegion) && Intrinsics.areEqual(this.bottomRegion, subRegionInfo.bottomRegion) && Intrinsics.areEqual(this.leftRegion, subRegionInfo.leftRegion) && Intrinsics.areEqual(this.rightRegion, subRegionInfo.rightRegion);
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
        Boolean bool = this.topRegion;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.bottomRegion;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.leftRegion;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Boolean bool4 = this.rightRegion;
        return hashCode3 + (bool4 != null ? bool4.hashCode() : 0);
    }

    public String toString() {
        return "SubRegionInfo(topRegion=" + this.topRegion + ", bottomRegion=" + this.bottomRegion + ", leftRegion=" + this.leftRegion + ", rightRegion=" + this.rightRegion + ")";
    }
}
