package com.socure.docv.capturesdk.core.external.ml.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u001d\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u000f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0003\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/RegionWisePair;", "", "lines", "", "", "optimalPoint", "(Ljava/util/List;Ljava/util/List;)V", "getLines", "()Ljava/util/List;", "setLines", "(Ljava/util/List;)V", "getOptimalPoint", "setOptimalPoint", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RegionWisePair {
    private List<List<List<Double>>> lines;
    private List<Double> optimalPoint;

    public RegionWisePair(List<List<List<Double>>> list, List<Double> list2) {
        this.lines = list;
        this.optimalPoint = list2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RegionWisePair copy$default(RegionWisePair regionWisePair, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = regionWisePair.lines;
        }
        if ((i & 2) != 0) {
            list2 = regionWisePair.optimalPoint;
        }
        return regionWisePair.copy(list, list2);
    }

    public final List<List<List<Double>>> component1() {
        return this.lines;
    }

    public final List<Double> component2() {
        return this.optimalPoint;
    }

    public final RegionWisePair copy(List<List<List<Double>>> lines, List<Double> optimalPoint) {
        return new RegionWisePair(lines, optimalPoint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegionWisePair)) {
            return false;
        }
        RegionWisePair regionWisePair = (RegionWisePair) other;
        return Intrinsics.areEqual(this.lines, regionWisePair.lines) && Intrinsics.areEqual(this.optimalPoint, regionWisePair.optimalPoint);
    }

    public final List<List<List<Double>>> getLines() {
        return this.lines;
    }

    public final List<Double> getOptimalPoint() {
        return this.optimalPoint;
    }

    public int hashCode() {
        List<List<List<Double>>> list = this.lines;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Double> list2 = this.optimalPoint;
        return hashCode + (list2 != null ? list2.hashCode() : 0);
    }

    public final void setLines(List<List<List<Double>>> list) {
        this.lines = list;
    }

    public final void setOptimalPoint(List<Double> list) {
        this.optimalPoint = list;
    }

    public String toString() {
        return "RegionWisePair(lines=" + this.lines + ", optimalPoint=" + this.optimalPoint + ")";
    }
}
