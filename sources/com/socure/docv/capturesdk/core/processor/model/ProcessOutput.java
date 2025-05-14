package com.socure.docv.capturesdk.core.processor.model;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/ProcessOutput;", "Lcom/socure/docv/capturesdk/core/processor/model/IResult;", "metric", "Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "bitmap", "Landroid/graphics/Bitmap;", "debugBitmap", "(Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V", "getBitmap", "()Landroid/graphics/Bitmap;", "getDebugBitmap", "getMetric", "()Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ProcessOutput implements IResult {
    private final Bitmap bitmap;
    private final Bitmap debugBitmap;
    private final DetectionMetric metric;

    public ProcessOutput(DetectionMetric metric, Bitmap bitmap, Bitmap bitmap2) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        this.metric = metric;
        this.bitmap = bitmap;
        this.debugBitmap = bitmap2;
    }

    public /* synthetic */ ProcessOutput(DetectionMetric detectionMetric, Bitmap bitmap, Bitmap bitmap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(detectionMetric, (i & 2) != 0 ? null : bitmap, (i & 4) != 0 ? null : bitmap2);
    }

    public static /* synthetic */ ProcessOutput copy$default(ProcessOutput processOutput, DetectionMetric detectionMetric, Bitmap bitmap, Bitmap bitmap2, int i, Object obj) {
        if ((i & 1) != 0) {
            detectionMetric = processOutput.getMetric();
        }
        if ((i & 2) != 0) {
            bitmap = processOutput.bitmap;
        }
        if ((i & 4) != 0) {
            bitmap2 = processOutput.debugBitmap;
        }
        return processOutput.copy(detectionMetric, bitmap, bitmap2);
    }

    public final DetectionMetric component1() {
        return getMetric();
    }

    /* renamed from: component2, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* renamed from: component3, reason: from getter */
    public final Bitmap getDebugBitmap() {
        return this.debugBitmap;
    }

    public final ProcessOutput copy(DetectionMetric metric, Bitmap bitmap, Bitmap debugBitmap) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        return new ProcessOutput(metric, bitmap, debugBitmap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessOutput)) {
            return false;
        }
        ProcessOutput processOutput = (ProcessOutput) other;
        return Intrinsics.areEqual(getMetric(), processOutput.getMetric()) && Intrinsics.areEqual(this.bitmap, processOutput.bitmap) && Intrinsics.areEqual(this.debugBitmap, processOutput.debugBitmap);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Bitmap getDebugBitmap() {
        return this.debugBitmap;
    }

    @Override // com.socure.docv.capturesdk.core.processor.model.IResult
    public DetectionMetric getMetric() {
        return this.metric;
    }

    public int hashCode() {
        int hashCode = getMetric().hashCode() * 31;
        Bitmap bitmap = this.bitmap;
        int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
        Bitmap bitmap2 = this.debugBitmap;
        return hashCode2 + (bitmap2 != null ? bitmap2.hashCode() : 0);
    }

    public String toString() {
        return "ProcessOutput(metric=" + getMetric() + ", bitmap=" + this.bitmap + ", debugBitmap=" + this.debugBitmap + ")";
    }
}
