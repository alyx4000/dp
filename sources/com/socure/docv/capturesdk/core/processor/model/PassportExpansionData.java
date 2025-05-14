package com.socure.docv.capturesdk.core.processor.model;

import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/PassportExpansionData;", "", "paddedSquaredBitmapRes", "Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "paddedScaledDownBitmapRes", "processedBitmapRes", "originalBitmapRes", "cropViewDimension", "Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;", "(Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;)V", "getCropViewDimension", "()Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;", "getOriginalBitmapRes", "()Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "getPaddedScaledDownBitmapRes", "getPaddedSquaredBitmapRes", "getProcessedBitmapRes", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PassportExpansionData {
    private final ViewDimensions cropViewDimension;
    private final Dimension originalBitmapRes;
    private final Dimension paddedScaledDownBitmapRes;
    private final Dimension paddedSquaredBitmapRes;
    private final Dimension processedBitmapRes;

    public PassportExpansionData(Dimension paddedSquaredBitmapRes, Dimension paddedScaledDownBitmapRes, Dimension processedBitmapRes, Dimension originalBitmapRes, ViewDimensions cropViewDimension) {
        Intrinsics.checkNotNullParameter(paddedSquaredBitmapRes, "paddedSquaredBitmapRes");
        Intrinsics.checkNotNullParameter(paddedScaledDownBitmapRes, "paddedScaledDownBitmapRes");
        Intrinsics.checkNotNullParameter(processedBitmapRes, "processedBitmapRes");
        Intrinsics.checkNotNullParameter(originalBitmapRes, "originalBitmapRes");
        Intrinsics.checkNotNullParameter(cropViewDimension, "cropViewDimension");
        this.paddedSquaredBitmapRes = paddedSquaredBitmapRes;
        this.paddedScaledDownBitmapRes = paddedScaledDownBitmapRes;
        this.processedBitmapRes = processedBitmapRes;
        this.originalBitmapRes = originalBitmapRes;
        this.cropViewDimension = cropViewDimension;
    }

    public static /* synthetic */ PassportExpansionData copy$default(PassportExpansionData passportExpansionData, Dimension dimension, Dimension dimension2, Dimension dimension3, Dimension dimension4, ViewDimensions viewDimensions, int i, Object obj) {
        if ((i & 1) != 0) {
            dimension = passportExpansionData.paddedSquaredBitmapRes;
        }
        if ((i & 2) != 0) {
            dimension2 = passportExpansionData.paddedScaledDownBitmapRes;
        }
        Dimension dimension5 = dimension2;
        if ((i & 4) != 0) {
            dimension3 = passportExpansionData.processedBitmapRes;
        }
        Dimension dimension6 = dimension3;
        if ((i & 8) != 0) {
            dimension4 = passportExpansionData.originalBitmapRes;
        }
        Dimension dimension7 = dimension4;
        if ((i & 16) != 0) {
            viewDimensions = passportExpansionData.cropViewDimension;
        }
        return passportExpansionData.copy(dimension, dimension5, dimension6, dimension7, viewDimensions);
    }

    /* renamed from: component1, reason: from getter */
    public final Dimension getPaddedSquaredBitmapRes() {
        return this.paddedSquaredBitmapRes;
    }

    /* renamed from: component2, reason: from getter */
    public final Dimension getPaddedScaledDownBitmapRes() {
        return this.paddedScaledDownBitmapRes;
    }

    /* renamed from: component3, reason: from getter */
    public final Dimension getProcessedBitmapRes() {
        return this.processedBitmapRes;
    }

    /* renamed from: component4, reason: from getter */
    public final Dimension getOriginalBitmapRes() {
        return this.originalBitmapRes;
    }

    /* renamed from: component5, reason: from getter */
    public final ViewDimensions getCropViewDimension() {
        return this.cropViewDimension;
    }

    public final PassportExpansionData copy(Dimension paddedSquaredBitmapRes, Dimension paddedScaledDownBitmapRes, Dimension processedBitmapRes, Dimension originalBitmapRes, ViewDimensions cropViewDimension) {
        Intrinsics.checkNotNullParameter(paddedSquaredBitmapRes, "paddedSquaredBitmapRes");
        Intrinsics.checkNotNullParameter(paddedScaledDownBitmapRes, "paddedScaledDownBitmapRes");
        Intrinsics.checkNotNullParameter(processedBitmapRes, "processedBitmapRes");
        Intrinsics.checkNotNullParameter(originalBitmapRes, "originalBitmapRes");
        Intrinsics.checkNotNullParameter(cropViewDimension, "cropViewDimension");
        return new PassportExpansionData(paddedSquaredBitmapRes, paddedScaledDownBitmapRes, processedBitmapRes, originalBitmapRes, cropViewDimension);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PassportExpansionData)) {
            return false;
        }
        PassportExpansionData passportExpansionData = (PassportExpansionData) other;
        return Intrinsics.areEqual(this.paddedSquaredBitmapRes, passportExpansionData.paddedSquaredBitmapRes) && Intrinsics.areEqual(this.paddedScaledDownBitmapRes, passportExpansionData.paddedScaledDownBitmapRes) && Intrinsics.areEqual(this.processedBitmapRes, passportExpansionData.processedBitmapRes) && Intrinsics.areEqual(this.originalBitmapRes, passportExpansionData.originalBitmapRes) && Intrinsics.areEqual(this.cropViewDimension, passportExpansionData.cropViewDimension);
    }

    public final ViewDimensions getCropViewDimension() {
        return this.cropViewDimension;
    }

    public final Dimension getOriginalBitmapRes() {
        return this.originalBitmapRes;
    }

    public final Dimension getPaddedScaledDownBitmapRes() {
        return this.paddedScaledDownBitmapRes;
    }

    public final Dimension getPaddedSquaredBitmapRes() {
        return this.paddedSquaredBitmapRes;
    }

    public final Dimension getProcessedBitmapRes() {
        return this.processedBitmapRes;
    }

    public int hashCode() {
        return this.cropViewDimension.hashCode() + ((this.originalBitmapRes.hashCode() + ((this.processedBitmapRes.hashCode() + ((this.paddedScaledDownBitmapRes.hashCode() + (this.paddedSquaredBitmapRes.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "PassportExpansionData(paddedSquaredBitmapRes=" + this.paddedSquaredBitmapRes + ", paddedScaledDownBitmapRes=" + this.paddedScaledDownBitmapRes + ", processedBitmapRes=" + this.processedBitmapRes + ", originalBitmapRes=" + this.originalBitmapRes + ", cropViewDimension=" + this.cropViewDimension + ")";
    }
}
