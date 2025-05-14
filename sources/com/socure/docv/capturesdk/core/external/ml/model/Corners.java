package com.socure.docv.capturesdk.core.external.ml.model;

import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B%\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\""}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/Corners;", "", "()V", "floatArray", "", "([F)V", "topLeft", "Lcom/socure/docv/capturesdk/core/external/ml/model/CornerPoint;", "topRight", "bottomRight", "bottomLeft", "(Lcom/socure/docv/capturesdk/core/external/ml/model/CornerPoint;Lcom/socure/docv/capturesdk/core/external/ml/model/CornerPoint;Lcom/socure/docv/capturesdk/core/external/ml/model/CornerPoint;Lcom/socure/docv/capturesdk/core/external/ml/model/CornerPoint;)V", "getBottomLeft", "()Lcom/socure/docv/capturesdk/core/external/ml/model/CornerPoint;", "setBottomLeft", "(Lcom/socure/docv/capturesdk/core/external/ml/model/CornerPoint;)V", "getBottomRight", "setBottomRight", "getTopLeft", "setTopLeft", "getTopRight", "setTopRight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Corners {
    private CornerPoint bottomLeft;
    private CornerPoint bottomRight;
    private CornerPoint topLeft;
    private CornerPoint topRight;

    public Corners() {
        this(new CornerPoint(null, 0.0f, 3, null), new CornerPoint(null, 0.0f, 3, null), new CornerPoint(null, 0.0f, 3, null), new CornerPoint(null, 0.0f, 3, null));
    }

    public Corners(CornerPoint topLeft, CornerPoint topRight, CornerPoint bottomRight, CornerPoint bottomLeft) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
        this.bottomLeft = bottomLeft;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Corners(float[] floatArray) {
        this();
        Intrinsics.checkNotNullParameter(floatArray, "floatArray");
        this.topLeft.setConfidence(floatArray[2]);
        if (this.topLeft.getConfidence() >= 0.9f) {
            this.topLeft.setCorner(CollectionsKt.mutableListOf(Double.valueOf(floatArray[0]), Double.valueOf(floatArray[1])));
        }
        this.topRight.setConfidence(floatArray[5]);
        if (this.topRight.getConfidence() >= 0.9f) {
            this.topRight.setCorner(CollectionsKt.mutableListOf(Double.valueOf(floatArray[3]), Double.valueOf(floatArray[4])));
        }
        this.bottomRight.setConfidence(floatArray[8]);
        if (this.bottomRight.getConfidence() >= 0.9f) {
            this.bottomRight.setCorner(CollectionsKt.mutableListOf(Double.valueOf(floatArray[6]), Double.valueOf(floatArray[7])));
        }
        this.bottomLeft.setConfidence(floatArray[11]);
        if (this.bottomLeft.getConfidence() >= 0.9f) {
            this.bottomLeft.setCorner(CollectionsKt.mutableListOf(Double.valueOf(floatArray[9]), Double.valueOf(floatArray[10])));
        }
    }

    public static /* synthetic */ Corners copy$default(Corners corners, CornerPoint cornerPoint, CornerPoint cornerPoint2, CornerPoint cornerPoint3, CornerPoint cornerPoint4, int i, Object obj) {
        if ((i & 1) != 0) {
            cornerPoint = corners.topLeft;
        }
        if ((i & 2) != 0) {
            cornerPoint2 = corners.topRight;
        }
        if ((i & 4) != 0) {
            cornerPoint3 = corners.bottomRight;
        }
        if ((i & 8) != 0) {
            cornerPoint4 = corners.bottomLeft;
        }
        return corners.copy(cornerPoint, cornerPoint2, cornerPoint3, cornerPoint4);
    }

    /* renamed from: component1, reason: from getter */
    public final CornerPoint getTopLeft() {
        return this.topLeft;
    }

    /* renamed from: component2, reason: from getter */
    public final CornerPoint getTopRight() {
        return this.topRight;
    }

    /* renamed from: component3, reason: from getter */
    public final CornerPoint getBottomRight() {
        return this.bottomRight;
    }

    /* renamed from: component4, reason: from getter */
    public final CornerPoint getBottomLeft() {
        return this.bottomLeft;
    }

    public final Corners copy(CornerPoint topLeft, CornerPoint topRight, CornerPoint bottomRight, CornerPoint bottomLeft) {
        Intrinsics.checkNotNullParameter(topLeft, "topLeft");
        Intrinsics.checkNotNullParameter(topRight, "topRight");
        Intrinsics.checkNotNullParameter(bottomRight, "bottomRight");
        Intrinsics.checkNotNullParameter(bottomLeft, "bottomLeft");
        return new Corners(topLeft, topRight, bottomRight, bottomLeft);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Corners)) {
            return false;
        }
        Corners corners = (Corners) other;
        return Intrinsics.areEqual(this.topLeft, corners.topLeft) && Intrinsics.areEqual(this.topRight, corners.topRight) && Intrinsics.areEqual(this.bottomRight, corners.bottomRight) && Intrinsics.areEqual(this.bottomLeft, corners.bottomLeft);
    }

    public final CornerPoint getBottomLeft() {
        return this.bottomLeft;
    }

    public final CornerPoint getBottomRight() {
        return this.bottomRight;
    }

    public final CornerPoint getTopLeft() {
        return this.topLeft;
    }

    public final CornerPoint getTopRight() {
        return this.topRight;
    }

    public int hashCode() {
        return this.bottomLeft.hashCode() + ((this.bottomRight.hashCode() + ((this.topRight.hashCode() + (this.topLeft.hashCode() * 31)) * 31)) * 31);
    }

    public final void setBottomLeft(CornerPoint cornerPoint) {
        Intrinsics.checkNotNullParameter(cornerPoint, "<set-?>");
        this.bottomLeft = cornerPoint;
    }

    public final void setBottomRight(CornerPoint cornerPoint) {
        Intrinsics.checkNotNullParameter(cornerPoint, "<set-?>");
        this.bottomRight = cornerPoint;
    }

    public final void setTopLeft(CornerPoint cornerPoint) {
        Intrinsics.checkNotNullParameter(cornerPoint, "<set-?>");
        this.topLeft = cornerPoint;
    }

    public final void setTopRight(CornerPoint cornerPoint) {
        Intrinsics.checkNotNullParameter(cornerPoint, "<set-?>");
        this.topRight = cornerPoint;
    }

    public String toString() {
        return "Corners(topLeft=" + this.topLeft + ", topRight=" + this.topRight + ", bottomRight=" + this.bottomRight + ", bottomLeft=" + this.bottomLeft + ")";
    }
}
