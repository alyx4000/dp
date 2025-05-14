package com.socure.docv.capturesdk.core.processor.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0006\u0010\r\u001a\u00020\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0006\u0010\u0019\u001a\u00020\u000eJ\u0006\u0010\u001a\u001a\u00020\u000eJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/Quadrilateral;", "", "topLeft", "Lcom/socure/docv/capturesdk/core/processor/model/Point;", "topRight", "bottomRight", "bottomLeft", "(Lcom/socure/docv/capturesdk/core/processor/model/Point;Lcom/socure/docv/capturesdk/core/processor/model/Point;Lcom/socure/docv/capturesdk/core/processor/model/Point;Lcom/socure/docv/capturesdk/core/processor/model/Point;)V", "getBottomLeft", "()Lcom/socure/docv/capturesdk/core/processor/model/Point;", "getBottomRight", "getTopLeft", "getTopRight", "bottomEdge", "Lcom/socure/docv/capturesdk/core/processor/model/Line;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "leftEdge", "rightEdge", "toString", "", "topEdge", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Quadrilateral {
    private final Point bottomLeft;
    private final Point bottomRight;
    private final Point topLeft;
    private final Point topRight;

    public Quadrilateral(Point topLeft, Point topRight, Point bottomRight, Point bottomLeft) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
    }

    public static /* synthetic */ Quadrilateral copy$default(Quadrilateral quadrilateral, Point point, Point point2, Point point3, Point point4, int i, Object obj) {
        if ((i & 1) != 0) {
            point = quadrilateral.topLeft;
        }
        if ((i & 2) != 0) {
            point2 = quadrilateral.topRight;
        }
        if ((i & 4) != 0) {
            point3 = quadrilateral.bottomRight;
        }
        if ((i & 8) != 0) {
            point4 = quadrilateral.bottomLeft;
        }
        return quadrilateral.copy(point, point2, point3, point4);
    }

    public final Line bottomEdge() {
        return new Line(this.bottomLeft, this.bottomRight);
    }

    /* renamed from: component1, reason: from getter */
    public final Point getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: component2, reason: from getter */
    public final Point getTopRight() {
        return this.topRight;
    }

    /* renamed from: component3, reason: from getter */
    public final Point getBottomRight() {
        return this.bottomRight;
    }

    /* renamed from: component4, reason: from getter */
    public final Point getBottomLeft() {
        return this.bottomLeft;
    }

    public final Quadrilateral copy(Point topLeft, Point topRight, Point bottomRight, Point bottomLeft) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        return new Quadrilateral(topLeft, topRight, bottomRight, bottomLeft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Quadrilateral)) {
            return false;
        }
        Quadrilateral quadrilateral = (Quadrilateral) other;
        return Intrinsics.areEqual(this.topLeft, quadrilateral.topLeft) && Intrinsics.areEqual(this.topRight, quadrilateral.topRight) && Intrinsics.areEqual(this.bottomRight, quadrilateral.bottomRight) && Intrinsics.areEqual(this.bottomLeft, quadrilateral.bottomLeft);
    }

    public final Point getBottomLeft() {
        return this.bottomLeft;
    }

    public final Point getBottomRight() {
        return this.bottomRight;
    }

    public final Point getTopLeft() {
        return this.topLeft;
    }

    public final Point getTopRight() {
        return this.topRight;
    }

    public int hashCode() {
        return this.bottomLeft.hashCode() + ((this.bottomRight.hashCode() + ((this.topRight.hashCode() + (this.topLeft.hashCode() * 31)) * 31)) * 31);
    }

    public final Line leftEdge() {
        return new Line(this.topLeft, this.bottomLeft);
    }

    public final Line rightEdge() {
        return new Line(this.topRight, this.bottomRight);
    }

    public String toString() {
        return "Quadrilateral(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ")";
    }

    public final Line topEdge() {
        return new Line(this.topLeft, this.topRight);
    }
}
