package com.socure.docv.capturesdk.core.processor.model;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.network.model.stepup.SelfieMetrics;
import com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010,J\u000b\u0010>\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010?\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u0010@\u001a\u00020\fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0084\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\u00052\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020IHÖ\u0001J\t\u0010J\u001a\u00020KHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109¨\u0006L"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "", "detectionType", "Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;", "checkPassed", "", "outputMeasure", "", "error", "", "regionList", "", "", "expansionPercentage", "modelInputImage", "Landroid/graphics/Bitmap;", "detectionCallback", "Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;", "selfieMetrics", "Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;", "processedBitmapDimension", "Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "(Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;ZLjava/lang/Double;Ljava/lang/Throwable;Ljava/util/List;FLandroid/graphics/Bitmap;Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;)V", "getCheckPassed", "()Z", "setCheckPassed", "(Z)V", "getDetectionCallback", "()Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;", "setDetectionCallback", "(Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;)V", "getDetectionType", "()Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;", "getError", "()Ljava/lang/Throwable;", "setError", "(Ljava/lang/Throwable;)V", "getExpansionPercentage", "()F", "getModelInputImage", "()Landroid/graphics/Bitmap;", "setModelInputImage", "(Landroid/graphics/Bitmap;)V", "getOutputMeasure", "()Ljava/lang/Double;", "setOutputMeasure", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getProcessedBitmapDimension", "()Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;", "setProcessedBitmapDimension", "(Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;)V", "getRegionList", "()Ljava/util/List;", "getSelfieMetrics", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;", "setSelfieMetrics", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;)V", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;ZLjava/lang/Double;Ljava/lang/Throwable;Ljava/util/List;FLandroid/graphics/Bitmap;Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;Lcom/socure/docv/capturesdk/feature/scanner/data/Dimension;)Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DetectionMetric {
    private boolean checkPassed;
    private DetectionCallback detectionCallback;
    private final DetectionType detectionType;
    private Throwable error;
    private final float expansionPercentage;
    private Bitmap modelInputImage;
    private Double outputMeasure;
    private Dimension processedBitmapDimension;
    private final List<Float> regionList;
    private SelfieMetrics selfieMetrics;

    public DetectionMetric(DetectionType detectionType, boolean z, Double d, Throwable th, List<Float> regionList, float f, Bitmap bitmap, DetectionCallback detectionCallback, SelfieMetrics selfieMetrics, Dimension dimension) {
        Intrinsics.checkNotNullParameter(detectionType, "detectionType");
        Intrinsics.checkNotNullParameter(regionList, "regionList");
        this.detectionType = detectionType;
        this.checkPassed = z;
        this.outputMeasure = d;
        this.error = th;
        this.regionList = regionList;
        this.expansionPercentage = f;
        this.modelInputImage = bitmap;
        this.detectionCallback = detectionCallback;
        this.selfieMetrics = selfieMetrics;
        this.processedBitmapDimension = dimension;
    }

    public /* synthetic */ DetectionMetric(DetectionType detectionType, boolean z, Double d, Throwable th, List list, float f, Bitmap bitmap, DetectionCallback detectionCallback, SelfieMetrics selfieMetrics, Dimension dimension, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(detectionType, z, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : th, (i & 16) != 0 ? new ArrayList() : list, (i & 32) != 0 ? 0.0f : f, (i & 64) != 0 ? null : bitmap, (i & 128) != 0 ? null : detectionCallback, (i & 256) != 0 ? null : selfieMetrics, (i & 512) != 0 ? null : dimension);
    }

    /* renamed from: component1, reason: from getter */
    public final DetectionType getDetectionType() {
        return this.detectionType;
    }

    /* renamed from: component10, reason: from getter */
    public final Dimension getProcessedBitmapDimension() {
        return this.processedBitmapDimension;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCheckPassed() {
        return this.checkPassed;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getOutputMeasure() {
        return this.outputMeasure;
    }

    /* renamed from: component4, reason: from getter */
    public final Throwable getError() {
        return this.error;
    }

    public final List<Float> component5() {
        return this.regionList;
    }

    /* renamed from: component6, reason: from getter */
    public final float getExpansionPercentage() {
        return this.expansionPercentage;
    }

    /* renamed from: component7, reason: from getter */
    public final Bitmap getModelInputImage() {
        return this.modelInputImage;
    }

    /* renamed from: component8, reason: from getter */
    public final DetectionCallback getDetectionCallback() {
        return this.detectionCallback;
    }

    /* renamed from: component9, reason: from getter */
    public final SelfieMetrics getSelfieMetrics() {
        return this.selfieMetrics;
    }

    public final DetectionMetric copy(DetectionType detectionType, boolean checkPassed, Double outputMeasure, Throwable error, List<Float> regionList, float expansionPercentage, Bitmap modelInputImage, DetectionCallback detectionCallback, SelfieMetrics selfieMetrics, Dimension processedBitmapDimension) {
        Intrinsics.checkNotNullParameter(detectionType, "detectionType");
        Intrinsics.checkNotNullParameter(regionList, "regionList");
        return new DetectionMetric(detectionType, checkPassed, outputMeasure, error, regionList, expansionPercentage, modelInputImage, detectionCallback, selfieMetrics, processedBitmapDimension);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DetectionMetric)) {
            return false;
        }
        DetectionMetric detectionMetric = (DetectionMetric) other;
        return this.detectionType == detectionMetric.detectionType && this.checkPassed == detectionMetric.checkPassed && Intrinsics.areEqual((Object) this.outputMeasure, (Object) detectionMetric.outputMeasure) && Intrinsics.areEqual(this.error, detectionMetric.error) && Intrinsics.areEqual(this.regionList, detectionMetric.regionList) && Intrinsics.areEqual((Object) Float.valueOf(this.expansionPercentage), (Object) Float.valueOf(detectionMetric.expansionPercentage)) && Intrinsics.areEqual(this.modelInputImage, detectionMetric.modelInputImage) && this.detectionCallback == detectionMetric.detectionCallback && Intrinsics.areEqual(this.selfieMetrics, detectionMetric.selfieMetrics) && Intrinsics.areEqual(this.processedBitmapDimension, detectionMetric.processedBitmapDimension);
    }

    public final boolean getCheckPassed() {
        return this.checkPassed;
    }

    public final DetectionCallback getDetectionCallback() {
        return this.detectionCallback;
    }

    public final DetectionType getDetectionType() {
        return this.detectionType;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final float getExpansionPercentage() {
        return this.expansionPercentage;
    }

    public final Bitmap getModelInputImage() {
        return this.modelInputImage;
    }

    public final Double getOutputMeasure() {
        return this.outputMeasure;
    }

    public final Dimension getProcessedBitmapDimension() {
        return this.processedBitmapDimension;
    }

    public final List<Float> getRegionList() {
        return this.regionList;
    }

    public final SelfieMetrics getSelfieMetrics() {
        return this.selfieMetrics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.detectionType.hashCode() * 31;
        boolean z = this.checkPassed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        Double d = this.outputMeasure;
        int hashCode2 = (i2 + (d == null ? 0 : d.hashCode())) * 31;
        Throwable th = this.error;
        int hashCode3 = (Float.hashCode(this.expansionPercentage) + ((this.regionList.hashCode() + ((hashCode2 + (th == null ? 0 : th.hashCode())) * 31)) * 31)) * 31;
        Bitmap bitmap = this.modelInputImage;
        int hashCode4 = (hashCode3 + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        DetectionCallback detectionCallback = this.detectionCallback;
        int hashCode5 = (hashCode4 + (detectionCallback == null ? 0 : detectionCallback.hashCode())) * 31;
        SelfieMetrics selfieMetrics = this.selfieMetrics;
        int hashCode6 = (hashCode5 + (selfieMetrics == null ? 0 : selfieMetrics.hashCode())) * 31;
        Dimension dimension = this.processedBitmapDimension;
        return hashCode6 + (dimension != null ? dimension.hashCode() : 0);
    }

    public final void setCheckPassed(boolean z) {
        this.checkPassed = z;
    }

    public final void setDetectionCallback(DetectionCallback detectionCallback) {
        this.detectionCallback = detectionCallback;
    }

    public final void setError(Throwable th) {
        this.error = th;
    }

    public final void setModelInputImage(Bitmap bitmap) {
        this.modelInputImage = bitmap;
    }

    public final void setOutputMeasure(Double d) {
        this.outputMeasure = d;
    }

    public final void setProcessedBitmapDimension(Dimension dimension) {
        this.processedBitmapDimension = dimension;
    }

    public final void setSelfieMetrics(SelfieMetrics selfieMetrics) {
        this.selfieMetrics = selfieMetrics;
    }

    public String toString() {
        return "DetectionMetric(detectionType=" + this.detectionType + ", checkPassed=" + this.checkPassed + ", outputMeasure=" + this.outputMeasure + ", error=" + this.error + ", regionList=" + this.regionList + ", expansionPercentage=" + this.expansionPercentage + ", modelInputImage=" + this.modelInputImage + ", detectionCallback=" + this.detectionCallback + ", selfieMetrics=" + this.selfieMetrics + ", processedBitmapDimension=" + this.processedBitmapDimension + ")";
    }
}
