package com.socure.docv.capturesdk.common.analytics.model;

import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.CaptureMetadata;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0017J\u001d\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0003Jh\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001c\b\u0002\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010HÆ\u0001¢\u0006\u0002\u0010&J\u0013\u0010'\u001a\u00020\f2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R%\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000ej\n\u0012\u0004\u0012\u00020\u000f\u0018\u0001`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006-"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/MetricCaptureData;", "", "scanType", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "captureType", "Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "captureMetadata", "Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;", "metrics", "", "Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "extractionDataDetected", "", "faces", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/analytics/model/Face;", "Lkotlin/collections/ArrayList;", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/ArrayList;)V", "getCaptureMetadata", "()Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;", "getCaptureType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "getExtractionDataDetected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFaces", "()Ljava/util/ArrayList;", "getMetrics", "()Ljava/util/List;", "getScanType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/ArrayList;)Lcom/socure/docv/capturesdk/common/analytics/model/MetricCaptureData;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MetricCaptureData {
    private final CaptureMetadata captureMetadata;
    private final CaptureType captureType;
    private final Boolean extractionDataDetected;
    private final ArrayList<Face> faces;
    private final List<DetectionMetric> metrics;
    private final ScanType scanType;

    public MetricCaptureData(ScanType scanType, CaptureType captureType, CaptureMetadata captureMetadata, List<DetectionMetric> metrics, Boolean bool, ArrayList<Face> arrayList) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        this.scanType = scanType;
        this.captureType = captureType;
        this.captureMetadata = captureMetadata;
        this.metrics = metrics;
        this.extractionDataDetected = bool;
        this.faces = arrayList;
    }

    public /* synthetic */ MetricCaptureData(ScanType scanType, CaptureType captureType, CaptureMetadata captureMetadata, List list, Boolean bool, ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(scanType, captureType, (i & 4) != 0 ? null : captureMetadata, (i & 8) != 0 ? new ArrayList() : list, (i & 16) != 0 ? null : bool, (i & 32) != 0 ? null : arrayList);
    }

    public static /* synthetic */ MetricCaptureData copy$default(MetricCaptureData metricCaptureData, ScanType scanType, CaptureType captureType, CaptureMetadata captureMetadata, List list, Boolean bool, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            scanType = metricCaptureData.scanType;
        }
        if ((i & 2) != 0) {
            captureType = metricCaptureData.captureType;
        }
        CaptureType captureType2 = captureType;
        if ((i & 4) != 0) {
            captureMetadata = metricCaptureData.captureMetadata;
        }
        CaptureMetadata captureMetadata2 = captureMetadata;
        if ((i & 8) != 0) {
            list = metricCaptureData.metrics;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            bool = metricCaptureData.extractionDataDetected;
        }
        Boolean bool2 = bool;
        if ((i & 32) != 0) {
            arrayList = metricCaptureData.faces;
        }
        return metricCaptureData.copy(scanType, captureType2, captureMetadata2, list2, bool2, arrayList);
    }

    /* renamed from: component1, reason: from getter */
    public final ScanType getScanType() {
        return this.scanType;
    }

    /* renamed from: component2, reason: from getter */
    public final CaptureType getCaptureType() {
        return this.captureType;
    }

    /* renamed from: component3, reason: from getter */
    public final CaptureMetadata getCaptureMetadata() {
        return this.captureMetadata;
    }

    public final List<DetectionMetric> component4() {
        return this.metrics;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getExtractionDataDetected() {
        return this.extractionDataDetected;
    }

    public final ArrayList<Face> component6() {
        return this.faces;
    }

    public final MetricCaptureData copy(ScanType scanType, CaptureType captureType, CaptureMetadata captureMetadata, List<DetectionMetric> metrics, Boolean extractionDataDetected, ArrayList<Face> faces) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(metrics, "metrics");
        return new MetricCaptureData(scanType, captureType, captureMetadata, metrics, extractionDataDetected, faces);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetricCaptureData)) {
            return false;
        }
        MetricCaptureData metricCaptureData = (MetricCaptureData) other;
        return this.scanType == metricCaptureData.scanType && this.captureType == metricCaptureData.captureType && Intrinsics.areEqual(this.captureMetadata, metricCaptureData.captureMetadata) && Intrinsics.areEqual(this.metrics, metricCaptureData.metrics) && Intrinsics.areEqual(this.extractionDataDetected, metricCaptureData.extractionDataDetected) && Intrinsics.areEqual(this.faces, metricCaptureData.faces);
    }

    public final CaptureMetadata getCaptureMetadata() {
        return this.captureMetadata;
    }

    public final CaptureType getCaptureType() {
        return this.captureType;
    }

    public final Boolean getExtractionDataDetected() {
        return this.extractionDataDetected;
    }

    public final ArrayList<Face> getFaces() {
        return this.faces;
    }

    public final List<DetectionMetric> getMetrics() {
        return this.metrics;
    }

    public final ScanType getScanType() {
        return this.scanType;
    }

    public int hashCode() {
        int hashCode = (this.captureType.hashCode() + (this.scanType.hashCode() * 31)) * 31;
        CaptureMetadata captureMetadata = this.captureMetadata;
        int hashCode2 = (this.metrics.hashCode() + ((hashCode + (captureMetadata == null ? 0 : captureMetadata.hashCode())) * 31)) * 31;
        Boolean bool = this.extractionDataDetected;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        ArrayList<Face> arrayList = this.faces;
        return hashCode3 + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public String toString() {
        return "MetricCaptureData(scanType=" + this.scanType + ", captureType=" + this.captureType + ", captureMetadata=" + this.captureMetadata + ", metrics=" + this.metrics + ", extractionDataDetected=" + this.extractionDataDetected + ", faces=" + this.faces + ")";
    }
}
