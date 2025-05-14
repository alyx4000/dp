package com.socure.docv.capturesdk.core.external.ml.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003\u0012\u0018\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003¢\u0006\u0002\u0010\bJ\u001b\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003HÆ\u0003J\u001b\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003HÆ\u0003J\u001b\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003HÆ\u0003J\u001b\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003HÆ\u0003Jy\u0010\u0017\u001a\u00020\u00002\u001a\b\u0002\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u00032\u001a\b\u0002\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u00032\u001a\b\u0002\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R,\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR,\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR,\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR,\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00030\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeReferenceLines;", "", "leftRegion", "", "", "topRegion", "rightRegion", "bottomRegion", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBottomRegion", "()Ljava/util/List;", "setBottomRegion", "(Ljava/util/List;)V", "getLeftRegion", "setLeftRegion", "getRightRegion", "setRightRegion", "getTopRegion", "setTopRegion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EdgeReferenceLines {
    private List<List<List<Double>>> bottomRegion;
    private List<List<List<Double>>> leftRegion;
    private List<List<List<Double>>> rightRegion;
    private List<List<List<Double>>> topRegion;

    public EdgeReferenceLines(List<List<List<Double>>> leftRegion, List<List<List<Double>>> topRegion, List<List<List<Double>>> rightRegion, List<List<List<Double>>> bottomRegion) {
        Intrinsics.checkNotNullParameter(leftRegion, "leftRegion");
        Intrinsics.checkNotNullParameter(topRegion, "topRegion");
        Intrinsics.checkNotNullParameter(rightRegion, "rightRegion");
        Intrinsics.checkNotNullParameter(bottomRegion, "bottomRegion");
        this.leftRegion = leftRegion;
        this.topRegion = topRegion;
        this.rightRegion = rightRegion;
        this.bottomRegion = bottomRegion;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EdgeReferenceLines copy$default(EdgeReferenceLines edgeReferenceLines, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = edgeReferenceLines.leftRegion;
        }
        if ((i & 2) != 0) {
            list2 = edgeReferenceLines.topRegion;
        }
        if ((i & 4) != 0) {
            list3 = edgeReferenceLines.rightRegion;
        }
        if ((i & 8) != 0) {
            list4 = edgeReferenceLines.bottomRegion;
        }
        return edgeReferenceLines.copy(list, list2, list3, list4);
    }

    public final List<List<List<Double>>> component1() {
        return this.leftRegion;
    }

    public final List<List<List<Double>>> component2() {
        return this.topRegion;
    }

    public final List<List<List<Double>>> component3() {
        return this.rightRegion;
    }

    public final List<List<List<Double>>> component4() {
        return this.bottomRegion;
    }

    public final EdgeReferenceLines copy(List<List<List<Double>>> leftRegion, List<List<List<Double>>> topRegion, List<List<List<Double>>> rightRegion, List<List<List<Double>>> bottomRegion) {
        Intrinsics.checkNotNullParameter(leftRegion, "leftRegion");
        Intrinsics.checkNotNullParameter(topRegion, "topRegion");
        Intrinsics.checkNotNullParameter(rightRegion, "rightRegion");
        Intrinsics.checkNotNullParameter(bottomRegion, "bottomRegion");
        return new EdgeReferenceLines(leftRegion, topRegion, rightRegion, bottomRegion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EdgeReferenceLines)) {
            return false;
        }
        EdgeReferenceLines edgeReferenceLines = (EdgeReferenceLines) other;
        return Intrinsics.areEqual(this.leftRegion, edgeReferenceLines.leftRegion) && Intrinsics.areEqual(this.topRegion, edgeReferenceLines.topRegion) && Intrinsics.areEqual(this.rightRegion, edgeReferenceLines.rightRegion) && Intrinsics.areEqual(this.bottomRegion, edgeReferenceLines.bottomRegion);
    }

    public final List<List<List<Double>>> getBottomRegion() {
        return this.bottomRegion;
    }

    public final List<List<List<Double>>> getLeftRegion() {
        return this.leftRegion;
    }

    public final List<List<List<Double>>> getRightRegion() {
        return this.rightRegion;
    }

    public final List<List<List<Double>>> getTopRegion() {
        return this.topRegion;
    }

    public int hashCode() {
        return this.bottomRegion.hashCode() + ((this.rightRegion.hashCode() + ((this.topRegion.hashCode() + (this.leftRegion.hashCode() * 31)) * 31)) * 31);
    }

    public final void setBottomRegion(List<List<List<Double>>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.bottomRegion = list;
    }

    public final void setLeftRegion(List<List<List<Double>>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.leftRegion = list;
    }

    public final void setRightRegion(List<List<List<Double>>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.rightRegion = list;
    }

    public final void setTopRegion(List<List<List<Double>>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.topRegion = list;
    }

    public String toString() {
        return "EdgeReferenceLines(leftRegion=" + this.leftRegion + ", topRegion=" + this.topRegion + ", rightRegion=" + this.rightRegion + ", bottomRegion=" + this.bottomRegion + ")";
    }
}
