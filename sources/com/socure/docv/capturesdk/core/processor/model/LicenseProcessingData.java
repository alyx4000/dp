package com.socure.docv.capturesdk.core.processor.model;

import android.graphics.Bitmap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/LicenseProcessingData;", "", "paddedSquaredBitmap", "Landroid/graphics/Bitmap;", "paddedScaledDownBitmap", "iddModelOutputRaw", "Lkotlin/Pair;", "", "modelOutputList", "", "", "originalBitmap", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;Lkotlin/Pair;Ljava/util/List;Landroid/graphics/Bitmap;)V", "getIddModelOutputRaw", "()Lkotlin/Pair;", "getModelOutputList", "()Ljava/util/List;", "getOriginalBitmap", "()Landroid/graphics/Bitmap;", "getPaddedScaledDownBitmap", "getPaddedSquaredBitmap", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LicenseProcessingData {
    private final Pair<float[], float[]> iddModelOutputRaw;
    private final List<Float> modelOutputList;
    private final Bitmap originalBitmap;
    private final Bitmap paddedScaledDownBitmap;
    private final Bitmap paddedSquaredBitmap;

    public LicenseProcessingData(Bitmap paddedSquaredBitmap, Bitmap paddedScaledDownBitmap, Pair<float[], float[]> pair, List<Float> modelOutputList, Bitmap originalBitmap) {
        Intrinsics.checkNotNullParameter(paddedSquaredBitmap, "paddedSquaredBitmap");
        Intrinsics.checkNotNullParameter(paddedScaledDownBitmap, "paddedScaledDownBitmap");
        Intrinsics.checkNotNullParameter(modelOutputList, "modelOutputList");
        Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
        this.paddedSquaredBitmap = paddedSquaredBitmap;
        this.paddedScaledDownBitmap = paddedScaledDownBitmap;
        this.iddModelOutputRaw = pair;
        this.modelOutputList = modelOutputList;
        this.originalBitmap = originalBitmap;
    }

    public static /* synthetic */ LicenseProcessingData copy$default(LicenseProcessingData licenseProcessingData, Bitmap bitmap, Bitmap bitmap2, Pair pair, List list, Bitmap bitmap3, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = licenseProcessingData.paddedSquaredBitmap;
        }
        if ((i & 2) != 0) {
            bitmap2 = licenseProcessingData.paddedScaledDownBitmap;
        }
        Bitmap bitmap4 = bitmap2;
        if ((i & 4) != 0) {
            pair = licenseProcessingData.iddModelOutputRaw;
        }
        Pair pair2 = pair;
        if ((i & 8) != 0) {
            list = licenseProcessingData.modelOutputList;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            bitmap3 = licenseProcessingData.originalBitmap;
        }
        return licenseProcessingData.copy(bitmap, bitmap4, pair2, list2, bitmap3);
    }

    /* renamed from: component1, reason: from getter */
    public final Bitmap getPaddedSquaredBitmap() {
        return this.paddedSquaredBitmap;
    }

    /* renamed from: component2, reason: from getter */
    public final Bitmap getPaddedScaledDownBitmap() {
        return this.paddedScaledDownBitmap;
    }

    public final Pair<float[], float[]> component3() {
        return this.iddModelOutputRaw;
    }

    public final List<Float> component4() {
        return this.modelOutputList;
    }

    /* renamed from: component5, reason: from getter */
    public final Bitmap getOriginalBitmap() {
        return this.originalBitmap;
    }

    public final LicenseProcessingData copy(Bitmap paddedSquaredBitmap, Bitmap paddedScaledDownBitmap, Pair<float[], float[]> iddModelOutputRaw, List<Float> modelOutputList, Bitmap originalBitmap) {
        Intrinsics.checkNotNullParameter(paddedSquaredBitmap, "paddedSquaredBitmap");
        Intrinsics.checkNotNullParameter(paddedScaledDownBitmap, "paddedScaledDownBitmap");
        Intrinsics.checkNotNullParameter(modelOutputList, "modelOutputList");
        Intrinsics.checkNotNullParameter(originalBitmap, "originalBitmap");
        return new LicenseProcessingData(paddedSquaredBitmap, paddedScaledDownBitmap, iddModelOutputRaw, modelOutputList, originalBitmap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LicenseProcessingData)) {
            return false;
        }
        LicenseProcessingData licenseProcessingData = (LicenseProcessingData) other;
        return Intrinsics.areEqual(this.paddedSquaredBitmap, licenseProcessingData.paddedSquaredBitmap) && Intrinsics.areEqual(this.paddedScaledDownBitmap, licenseProcessingData.paddedScaledDownBitmap) && Intrinsics.areEqual(this.iddModelOutputRaw, licenseProcessingData.iddModelOutputRaw) && Intrinsics.areEqual(this.modelOutputList, licenseProcessingData.modelOutputList) && Intrinsics.areEqual(this.originalBitmap, licenseProcessingData.originalBitmap);
    }

    public final Pair<float[], float[]> getIddModelOutputRaw() {
        return this.iddModelOutputRaw;
    }

    public final List<Float> getModelOutputList() {
        return this.modelOutputList;
    }

    public final Bitmap getOriginalBitmap() {
        return this.originalBitmap;
    }

    public final Bitmap getPaddedScaledDownBitmap() {
        return this.paddedScaledDownBitmap;
    }

    public final Bitmap getPaddedSquaredBitmap() {
        return this.paddedSquaredBitmap;
    }

    public int hashCode() {
        int hashCode = (this.paddedScaledDownBitmap.hashCode() + (this.paddedSquaredBitmap.hashCode() * 31)) * 31;
        Pair<float[], float[]> pair = this.iddModelOutputRaw;
        return this.originalBitmap.hashCode() + ((this.modelOutputList.hashCode() + ((hashCode + (pair == null ? 0 : pair.hashCode())) * 31)) * 31);
    }

    public String toString() {
        return "LicenseProcessingData(paddedSquaredBitmap=" + this.paddedSquaredBitmap + ", paddedScaledDownBitmap=" + this.paddedScaledDownBitmap + ", iddModelOutputRaw=" + this.iddModelOutputRaw + ", modelOutputList=" + this.modelOutputList + ", originalBitmap=" + this.originalBitmap + ")";
    }
}
