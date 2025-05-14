package com.socure.docv.capturesdk.core.external.ml.model;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/CropData;", "", "bitmap", "Landroid/graphics/Bitmap;", "edgeData", "Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeModel;", "brightEnough", "", "(Landroid/graphics/Bitmap;Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeModel;Z)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getBrightEnough", "()Z", "getEdgeData", "()Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeModel;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CropData {
    private final Bitmap bitmap;
    private final boolean brightEnough;
    private final EdgeModel edgeData;

    public CropData(Bitmap bitmap, EdgeModel edgeData, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(edgeData, "edgeData");
        this.bitmap = bitmap;
        this.edgeData = edgeData;
        this.brightEnough = z;
    }

    public static /* synthetic */ CropData copy$default(CropData cropData, Bitmap bitmap, EdgeModel edgeModel, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = cropData.bitmap;
        }
        if ((i & 2) != 0) {
            edgeModel = cropData.edgeData;
        }
        if ((i & 4) != 0) {
            z = cropData.brightEnough;
        }
        return cropData.copy(bitmap, edgeModel, z);
    }

    /* renamed from: component1, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: component2, reason: from getter */
    public final EdgeModel getEdgeData() {
        return this.edgeData;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getBrightEnough() {
        return this.brightEnough;
    }

    public final CropData copy(Bitmap bitmap, EdgeModel edgeData, boolean brightEnough) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(edgeData, "edgeData");
        return new CropData(bitmap, edgeData, brightEnough);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CropData)) {
            return false;
        }
        CropData cropData = (CropData) other;
        return Intrinsics.areEqual(this.bitmap, cropData.bitmap) && Intrinsics.areEqual(this.edgeData, cropData.edgeData) && this.brightEnough == cropData.brightEnough;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final boolean getBrightEnough() {
        return this.brightEnough;
    }

    public final EdgeModel getEdgeData() {
        return this.edgeData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.edgeData.hashCode() + (this.bitmap.hashCode() * 31)) * 31;
        boolean z = this.brightEnough;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return hashCode + i;
    }

    public String toString() {
        return "CropData(bitmap=" + this.bitmap + ", edgeData=" + this.edgeData + ", brightEnough=" + this.brightEnough + ")";
    }
}
