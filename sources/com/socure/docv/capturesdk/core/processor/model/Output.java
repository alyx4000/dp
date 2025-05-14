package com.socure.docv.capturesdk.core.processor.model;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010&\u001a\u00020\tHÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003JO\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020\t2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020-HÖ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/Output;", "", "finalBitmap", "Landroid/graphics/Bitmap;", "captureType", "Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "captureMetadata", "Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;", "finalStatus", "", "metrics", "", "Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "debugBitmap", "(Landroid/graphics/Bitmap;Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;ZLjava/util/List;Landroid/graphics/Bitmap;)V", "getCaptureMetadata", "()Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;", "setCaptureMetadata", "(Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;)V", "getCaptureType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "setCaptureType", "(Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;)V", "getDebugBitmap", "()Landroid/graphics/Bitmap;", "setDebugBitmap", "(Landroid/graphics/Bitmap;)V", "getFinalBitmap", "setFinalBitmap", "getFinalStatus", "()Z", "setFinalStatus", "(Z)V", "getMetrics", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Output {
    private CaptureMetadata captureMetadata;
    private CaptureType captureType;
    private Bitmap debugBitmap;
    private Bitmap finalBitmap;
    private boolean finalStatus;
    private final List<DetectionMetric> metrics;

    public Output(Bitmap finalBitmap, CaptureType captureType, CaptureMetadata captureMetadata, boolean z, List<DetectionMetric> metrics, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(finalBitmap, "finalBitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.finalBitmap = finalBitmap;
        this.captureType = captureType;
        this.captureMetadata = captureMetadata;
        this.finalStatus = z;
        this.metrics = metrics;
        this.debugBitmap = bitmap;
    }

    public /* synthetic */ Output(Bitmap bitmap, CaptureType captureType, CaptureMetadata captureMetadata, boolean z, List list, Bitmap bitmap2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap, captureType, (i & 4) != 0 ? null : captureMetadata, (i & 8) != 0 ? false : z, (i & 16) != 0 ? new ArrayList() : list, (i & 32) != 0 ? null : bitmap2);
    }

    public static /* synthetic */ Output copy$default(Output output, Bitmap bitmap, CaptureType captureType, CaptureMetadata captureMetadata, boolean z, List list, Bitmap bitmap2, int i, Object obj) {
        if ((i & 1) != 0) {
            bitmap = output.finalBitmap;
        }
        if ((i & 2) != 0) {
            captureType = output.captureType;
        }
        CaptureType captureType2 = captureType;
        if ((i & 4) != 0) {
            captureMetadata = output.captureMetadata;
        }
        CaptureMetadata captureMetadata2 = captureMetadata;
        if ((i & 8) != 0) {
            z = output.finalStatus;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            list = output.metrics;
        }
        List list2 = list;
        if ((i & 32) != 0) {
            bitmap2 = output.debugBitmap;
        }
        return output.copy(bitmap, captureType2, captureMetadata2, z2, list2, bitmap2);
    }

    /* renamed from: component1, reason: from getter */
    public final Bitmap getFinalBitmap() {
        return this.finalBitmap;
    }

    /* renamed from: component2, reason: from getter */
    public final CaptureType getCaptureType() {
        return this.captureType;
    }

    /* renamed from: component3, reason: from getter */
    public final CaptureMetadata getCaptureMetadata() {
        return this.captureMetadata;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getFinalStatus() {
        return this.finalStatus;
    }

    public final List<DetectionMetric> component5() {
        return this.metrics;
    }

    /* renamed from: component6, reason: from getter */
    public final Bitmap getDebugBitmap() {
        return this.debugBitmap;
    }

    public final Output copy(Bitmap finalBitmap, CaptureType captureType, CaptureMetadata captureMetadata, boolean finalStatus, List<DetectionMetric> metrics, Bitmap debugBitmap) {
        Intrinsics.checkNotNullParameter(finalBitmap, "finalBitmap");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return new Output(finalBitmap, captureType, captureMetadata, finalStatus, metrics, debugBitmap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Output)) {
            return false;
        }
        Output output = (Output) other;
        return Intrinsics.areEqual(this.finalBitmap, output.finalBitmap) && this.captureType == output.captureType && Intrinsics.areEqual(this.captureMetadata, output.captureMetadata) && this.finalStatus == output.finalStatus && Intrinsics.areEqual(this.metrics, output.metrics) && Intrinsics.areEqual(this.debugBitmap, output.debugBitmap);
    }

    public final CaptureMetadata getCaptureMetadata() {
        return this.captureMetadata;
    }

    public final CaptureType getCaptureType() {
        return this.captureType;
    }

    public final Bitmap getDebugBitmap() {
        return this.debugBitmap;
    }

    public final Bitmap getFinalBitmap() {
        return this.finalBitmap;
    }

    public final boolean getFinalStatus() {
        return this.finalStatus;
    }

    public final List<DetectionMetric> getMetrics() {
        return this.metrics;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = (this.captureType.hashCode() + (this.finalBitmap.hashCode() * 31)) * 31;
        CaptureMetadata captureMetadata = this.captureMetadata;
        int hashCode2 = (hashCode + (captureMetadata == null ? 0 : captureMetadata.hashCode())) * 31;
        boolean z = this.finalStatus;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode3 = (this.metrics.hashCode() + ((hashCode2 + i) * 31)) * 31;
        Bitmap bitmap = this.debugBitmap;
        return hashCode3 + (bitmap != null ? bitmap.hashCode() : 0);
    }

    public final void setCaptureMetadata(CaptureMetadata captureMetadata) {
        this.captureMetadata = captureMetadata;
    }

    public final void setCaptureType(CaptureType captureType) {
        Intrinsics.checkNotNullParameter(captureType, "<set-?>");
        this.captureType = captureType;
    }

    public final void setDebugBitmap(Bitmap bitmap) {
        this.debugBitmap = bitmap;
    }

    public final void setFinalBitmap(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<set-?>");
        this.finalBitmap = bitmap;
    }

    public final void setFinalStatus(boolean z) {
        this.finalStatus = z;
    }

    public String toString() {
        return "Output(finalBitmap=" + this.finalBitmap + ", captureType=" + this.captureType + ", captureMetadata=" + this.captureMetadata + ", finalStatus=" + this.finalStatus + ", metrics=" + this.metrics + ", debugBitmap=" + this.debugBitmap + ")";
    }
}
