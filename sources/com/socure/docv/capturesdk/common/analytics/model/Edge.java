package com.socure.docv.capturesdk.common.analytics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Edge;", "", "regionWiseLines", "Lcom/socure/docv/capturesdk/common/analytics/model/RegionWiseLines;", "subRegionInfo", "Lcom/socure/docv/capturesdk/common/analytics/model/SubRegionInfo;", "edgeDetectedAllSides", "", "edgeDetectedThreeSides", "(Lcom/socure/docv/capturesdk/common/analytics/model/RegionWiseLines;Lcom/socure/docv/capturesdk/common/analytics/model/SubRegionInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEdgeDetectedAllSides", "()Ljava/lang/Boolean;", "setEdgeDetectedAllSides", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEdgeDetectedThreeSides", "setEdgeDetectedThreeSides", "getRegionWiseLines", "()Lcom/socure/docv/capturesdk/common/analytics/model/RegionWiseLines;", "setRegionWiseLines", "(Lcom/socure/docv/capturesdk/common/analytics/model/RegionWiseLines;)V", "getSubRegionInfo", "()Lcom/socure/docv/capturesdk/common/analytics/model/SubRegionInfo;", "setSubRegionInfo", "(Lcom/socure/docv/capturesdk/common/analytics/model/SubRegionInfo;)V", "component1", "component2", "component3", "component4", "copy", "(Lcom/socure/docv/capturesdk/common/analytics/model/RegionWiseLines;Lcom/socure/docv/capturesdk/common/analytics/model/SubRegionInfo;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/socure/docv/capturesdk/common/analytics/model/Edge;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Edge {
    private Boolean edgeDetectedAllSides;
    private Boolean edgeDetectedThreeSides;
    private RegionWiseLines regionWiseLines;
    private SubRegionInfo subRegionInfo;

    public Edge() {
        this(null, null, null, null, 15, null);
    }

    public Edge(RegionWiseLines regionWiseLines, SubRegionInfo subRegionInfo, Boolean bool, Boolean bool2) {
        this.regionWiseLines = regionWiseLines;
        this.subRegionInfo = subRegionInfo;
        this.edgeDetectedAllSides = bool;
        this.edgeDetectedThreeSides = bool2;
    }

    public /* synthetic */ Edge(RegionWiseLines regionWiseLines, SubRegionInfo subRegionInfo, Boolean bool, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : regionWiseLines, (i & 2) != 0 ? null : subRegionInfo, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : bool2);
    }

    public static /* synthetic */ Edge copy$default(Edge edge, RegionWiseLines regionWiseLines, SubRegionInfo subRegionInfo, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            regionWiseLines = edge.regionWiseLines;
        }
        if ((i & 2) != 0) {
            subRegionInfo = edge.subRegionInfo;
        }
        if ((i & 4) != 0) {
            bool = edge.edgeDetectedAllSides;
        }
        if ((i & 8) != 0) {
            bool2 = edge.edgeDetectedThreeSides;
        }
        return edge.copy(regionWiseLines, subRegionInfo, bool, bool2);
    }

    /* renamed from: component1, reason: from getter */
    public final RegionWiseLines getRegionWiseLines() {
        return this.regionWiseLines;
    }

    /* renamed from: component2, reason: from getter */
    public final SubRegionInfo getSubRegionInfo() {
        return this.subRegionInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getEdgeDetectedAllSides() {
        return this.edgeDetectedAllSides;
    }

    /* renamed from: component4, reason: from getter */
    public final Boolean getEdgeDetectedThreeSides() {
        return this.edgeDetectedThreeSides;
    }

    public final Edge copy(RegionWiseLines regionWiseLines, SubRegionInfo subRegionInfo, Boolean edgeDetectedAllSides, Boolean edgeDetectedThreeSides) {
        return new Edge(regionWiseLines, subRegionInfo, edgeDetectedAllSides, edgeDetectedThreeSides);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Edge)) {
            return false;
        }
        Edge edge = (Edge) other;
        return Intrinsics.areEqual(this.regionWiseLines, edge.regionWiseLines) && Intrinsics.areEqual(this.subRegionInfo, edge.subRegionInfo) && Intrinsics.areEqual(this.edgeDetectedAllSides, edge.edgeDetectedAllSides) && Intrinsics.areEqual(this.edgeDetectedThreeSides, edge.edgeDetectedThreeSides);
    }

    public final Boolean getEdgeDetectedAllSides() {
        return this.edgeDetectedAllSides;
    }

    public final Boolean getEdgeDetectedThreeSides() {
        return this.edgeDetectedThreeSides;
    }

    public final RegionWiseLines getRegionWiseLines() {
        return this.regionWiseLines;
    }

    public final SubRegionInfo getSubRegionInfo() {
        return this.subRegionInfo;
    }

    public int hashCode() {
        RegionWiseLines regionWiseLines = this.regionWiseLines;
        int hashCode = (regionWiseLines == null ? 0 : regionWiseLines.hashCode()) * 31;
        SubRegionInfo subRegionInfo = this.subRegionInfo;
        int hashCode2 = (hashCode + (subRegionInfo == null ? 0 : subRegionInfo.hashCode())) * 31;
        Boolean bool = this.edgeDetectedAllSides;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.edgeDetectedThreeSides;
        return hashCode3 + (bool2 != null ? bool2.hashCode() : 0);
    }

    public final void setEdgeDetectedAllSides(Boolean bool) {
        this.edgeDetectedAllSides = bool;
    }

    public final void setEdgeDetectedThreeSides(Boolean bool) {
        this.edgeDetectedThreeSides = bool;
    }

    public final void setRegionWiseLines(RegionWiseLines regionWiseLines) {
        this.regionWiseLines = regionWiseLines;
    }

    public final void setSubRegionInfo(SubRegionInfo subRegionInfo) {
        this.subRegionInfo = subRegionInfo;
    }

    public String toString() {
        return "Edge(regionWiseLines=" + this.regionWiseLines + ", subRegionInfo=" + this.subRegionInfo + ", edgeDetectedAllSides=" + this.edgeDetectedAllSides + ", edgeDetectedThreeSides=" + this.edgeDetectedThreeSides + ")";
    }
}
