package com.socure.docv.capturesdk.core.external.ml.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003JQ\u0010\u0017\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/IntersectionPair;", "", "topLeft", "", "", "topRight", "bottomLeft", "bottomRight", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBottomLeft", "()Ljava/util/List;", "setBottomLeft", "(Ljava/util/List;)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class IntersectionPair {
    private List<String> bottomLeft;
    private List<String> bottomRight;
    private List<String> topLeft;
    private List<String> topRight;

    public IntersectionPair(List<String> list, List<String> list2, List<String> list3, List<String> list4) {
        this.topLeft = list;
        this.topRight = list2;
        this.bottomLeft = list3;
        this.bottomRight = list4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntersectionPair copy$default(IntersectionPair intersectionPair, List list, List list2, List list3, List list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = intersectionPair.topLeft;
        }
        if ((i & 2) != 0) {
            list2 = intersectionPair.topRight;
        }
        if ((i & 4) != 0) {
            list3 = intersectionPair.bottomLeft;
        }
        if ((i & 8) != 0) {
            list4 = intersectionPair.bottomRight;
        }
        return intersectionPair.copy(list, list2, list3, list4);
    }

    public final List<String> component1() {
        return this.topLeft;
    }

    public final List<String> component2() {
        return this.topRight;
    }

    public final List<String> component3() {
        return this.bottomLeft;
    }

    public final List<String> component4() {
        return this.bottomRight;
    }

    public final IntersectionPair copy(List<String> topLeft, List<String> topRight, List<String> bottomLeft, List<String> bottomRight) {
        return new IntersectionPair(topLeft, topRight, bottomLeft, bottomRight);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IntersectionPair)) {
            return false;
        }
        IntersectionPair intersectionPair = (IntersectionPair) other;
        return Intrinsics.areEqual(this.topLeft, intersectionPair.topLeft) && Intrinsics.areEqual(this.topRight, intersectionPair.topRight) && Intrinsics.areEqual(this.bottomLeft, intersectionPair.bottomLeft) && Intrinsics.areEqual(this.bottomRight, intersectionPair.bottomRight);
    }

    public final List<String> getBottomLeft() {
        return this.bottomLeft;
    }

    public final List<String> getBottomRight() {
        return this.bottomRight;
    }

    public final List<String> getTopLeft() {
        return this.topLeft;
    }

    public final List<String> getTopRight() {
        return this.topRight;
    }

    public int hashCode() {
        List<String> list = this.topLeft;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<String> list2 = this.topRight;
        int hashCode2 = (hashCode + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.bottomLeft;
        int hashCode3 = (hashCode2 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.bottomRight;
        return hashCode3 + (list4 != null ? list4.hashCode() : 0);
    }

    public final void setBottomLeft(List<String> list) {
        this.bottomLeft = list;
    }

    public final void setBottomRight(List<String> list) {
        this.bottomRight = list;
    }

    public final void setTopLeft(List<String> list) {
        this.topLeft = list;
    }

    public final void setTopRight(List<String> list) {
        this.topRight = list;
    }

    public String toString() {
        return "IntersectionPair(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomLeft=" + this.bottomLeft + ", bottomRight=" + this.bottomRight + ")";
    }
}
