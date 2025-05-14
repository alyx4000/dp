package com.socure.docv.capturesdk.common.analytics.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005\u0012 \b\u0002\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005¢\u0006\u0002\u0010\tJ!\u0010\u0014\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J!\u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J!\u0010\u0016\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J!\u0010\u0017\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0003J\u0091\u0001\u0010\u0018\u001a\u00020\u00002 \b\u0002\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052 \b\u0002\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u00052 \b\u0002\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R2\u0010\u0006\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR2\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR2\u0010\b\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR2\u0010\u0002\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006 "}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/RegionWiseLines;", "", "topRegion", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "bottomRegion", "leftRegion", "rightRegion", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "getBottomRegion", "()Ljava/util/ArrayList;", "setBottomRegion", "(Ljava/util/ArrayList;)V", "getLeftRegion", "setLeftRegion", "getRightRegion", "setRightRegion", "getTopRegion", "setTopRegion", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RegionWiseLines {
    private ArrayList<Double> bottomRegion;
    private ArrayList<Double> leftRegion;
    private ArrayList<Double> rightRegion;
    private ArrayList<Double> topRegion;

    public RegionWiseLines() {
        this(null, null, null, null, 15, null);
    }

    public RegionWiseLines(ArrayList<Double> arrayList, ArrayList<Double> arrayList2, ArrayList<Double> arrayList3, ArrayList<Double> arrayList4) {
        this.topRegion = arrayList;
        this.bottomRegion = arrayList2;
        this.leftRegion = arrayList3;
        this.rightRegion = arrayList4;
    }

    public /* synthetic */ RegionWiseLines(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : arrayList, (i & 2) != 0 ? null : arrayList2, (i & 4) != 0 ? null : arrayList3, (i & 8) != 0 ? null : arrayList4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegionWiseLines copy$default(RegionWiseLines regionWiseLines, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = regionWiseLines.topRegion;
        }
        if ((i & 2) != 0) {
            arrayList2 = regionWiseLines.bottomRegion;
        }
        if ((i & 4) != 0) {
            arrayList3 = regionWiseLines.leftRegion;
        }
        if ((i & 8) != 0) {
            arrayList4 = regionWiseLines.rightRegion;
        }
        return regionWiseLines.copy(arrayList, arrayList2, arrayList3, arrayList4);
    }

    public final ArrayList<Double> component1() {
        return this.topRegion;
    }

    public final ArrayList<Double> component2() {
        return this.bottomRegion;
    }

    public final ArrayList<Double> component3() {
        return this.leftRegion;
    }

    public final ArrayList<Double> component4() {
        return this.rightRegion;
    }

    public final RegionWiseLines copy(ArrayList<Double> topRegion, ArrayList<Double> bottomRegion, ArrayList<Double> leftRegion, ArrayList<Double> rightRegion) {
        return new RegionWiseLines(topRegion, bottomRegion, leftRegion, rightRegion);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegionWiseLines)) {
            return false;
        }
        RegionWiseLines regionWiseLines = (RegionWiseLines) other;
        return Intrinsics.areEqual(this.topRegion, regionWiseLines.topRegion) && Intrinsics.areEqual(this.bottomRegion, regionWiseLines.bottomRegion) && Intrinsics.areEqual(this.leftRegion, regionWiseLines.leftRegion) && Intrinsics.areEqual(this.rightRegion, regionWiseLines.rightRegion);
    }

    public final ArrayList<Double> getBottomRegion() {
        return this.bottomRegion;
    }

    public final ArrayList<Double> getLeftRegion() {
        return this.leftRegion;
    }

    public final ArrayList<Double> getRightRegion() {
        return this.rightRegion;
    }

    public final ArrayList<Double> getTopRegion() {
        return this.topRegion;
    }

    public int hashCode() {
        ArrayList<Double> arrayList = this.topRegion;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        ArrayList<Double> arrayList2 = this.bottomRegion;
        int hashCode2 = (hashCode + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<Double> arrayList3 = this.leftRegion;
        int hashCode3 = (hashCode2 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        ArrayList<Double> arrayList4 = this.rightRegion;
        return hashCode3 + (arrayList4 != null ? arrayList4.hashCode() : 0);
    }

    public final void setBottomRegion(ArrayList<Double> arrayList) {
        this.bottomRegion = arrayList;
    }

    public final void setLeftRegion(ArrayList<Double> arrayList) {
        this.leftRegion = arrayList;
    }

    public final void setRightRegion(ArrayList<Double> arrayList) {
        this.rightRegion = arrayList;
    }

    public final void setTopRegion(ArrayList<Double> arrayList) {
        this.topRegion = arrayList;
    }

    public String toString() {
        return "RegionWiseLines(topRegion=" + this.topRegion + ", bottomRegion=" + this.bottomRegion + ", leftRegion=" + this.leftRegion + ", rightRegion=" + this.rightRegion + ")";
    }
}
