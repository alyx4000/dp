package com.socure.docv.capturesdk.feature.scanner.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001J\b\u0010 \u001a\u00020!H\u0016R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000b¨\u0006\""}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/GuidingBox;", "", "width", "", "height", "leftTopX", "leftTopY", "parentDimension", "Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "(IIIILcom/socure/docv/capturesdk/feature/scanner/data/Dimension;)V", "getHeight", "()I", "setHeight", "(I)V", "getLeftTopX", "getLeftTopY", "setLeftTopY", "getParentDimension", "()Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "setParentDimension", "(Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;)V", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GuidingBox {
    private int height;
    private final int leftTopX;
    private int leftTopY;
    private Dimension parentDimension;
    private final int width;

    public GuidingBox(int i, int i2, int i3, int i4, Dimension parentDimension) {
        Intrinsics.checkNotNullParameter(parentDimension, "parentDimension");
        this.width = i;
        this.height = i2;
        this.leftTopX = i3;
        this.leftTopY = i4;
        this.parentDimension = parentDimension;
    }

    public static /* synthetic */ GuidingBox copy$default(GuidingBox guidingBox, int i, int i2, int i3, int i4, Dimension dimension, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = guidingBox.width;
        }
        if ((i5 & 2) != 0) {
            i2 = guidingBox.height;
        }
        int i6 = i2;
        if ((i5 & 4) != 0) {
            i3 = guidingBox.leftTopX;
        }
        int i7 = i3;
        if ((i5 & 8) != 0) {
            i4 = guidingBox.leftTopY;
        }
        int i8 = i4;
        if ((i5 & 16) != 0) {
            dimension = guidingBox.parentDimension;
        }
        return guidingBox.copy(i, i6, i7, i8, dimension);
    }

    /* renamed from: component1, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: component2, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: component3, reason: from getter */
    public final int getLeftTopX() {
        return this.leftTopX;
    }

    /* renamed from: component4, reason: from getter */
    public final int getLeftTopY() {
        return this.leftTopY;
    }

    /* renamed from: component5, reason: from getter */
    public final Dimension getParentDimension() {
        return this.parentDimension;
    }

    public final GuidingBox copy(int width, int height, int leftTopX, int leftTopY, Dimension parentDimension) {
        Intrinsics.checkNotNullParameter(parentDimension, "parentDimension");
        return new GuidingBox(width, height, leftTopX, leftTopY, parentDimension);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuidingBox)) {
            return false;
        }
        GuidingBox guidingBox = (GuidingBox) other;
        return this.width == guidingBox.width && this.height == guidingBox.height && this.leftTopX == guidingBox.leftTopX && this.leftTopY == guidingBox.leftTopY && Intrinsics.areEqual(this.parentDimension, guidingBox.parentDimension);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLeftTopX() {
        return this.leftTopX;
    }

    public final int getLeftTopY() {
        return this.leftTopY;
    }

    public final Dimension getParentDimension() {
        return this.parentDimension;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return this.parentDimension.hashCode() + ((Integer.hashCode(this.leftTopY) + ((Integer.hashCode(this.leftTopX) + ((Integer.hashCode(this.height) + (Integer.hashCode(this.width) * 31)) * 31)) * 31)) * 31);
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setLeftTopY(int i) {
        this.leftTopY = i;
    }

    public final void setParentDimension(Dimension dimension) {
        Intrinsics.checkNotNullParameter(dimension, "<set-?>");
        this.parentDimension = dimension;
    }

    public String toString() {
        return "GuidingBox(width=" + this.width + ", height=" + this.height + ", leftTopX=" + this.leftTopX + ", leftTopY=" + this.leftTopY + ", parentDimension=" + this.parentDimension + ")";
    }
}
