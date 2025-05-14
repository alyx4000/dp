package com.socure.docv.capturesdk.core.processor.model;

import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J8\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;", "", "captureType", "Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "resolution", "Lcom/socure/docv/capturesdk/core/processor/model/Resolution;", "captureIndex", "", "originalSize", "(Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;Lcom/socure/docv/capturesdk/core/processor/model/Resolution;ILjava/lang/Integer;)V", "getCaptureIndex", "()I", "setCaptureIndex", "(I)V", "getCaptureType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "setCaptureType", "(Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;)V", "getOriginalSize", "()Ljava/lang/Integer;", "setOriginalSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getResolution", "()Lcom/socure/docv/capturesdk/core/processor/model/Resolution;", "setResolution", "(Lcom/socure/docv/capturesdk/core/processor/model/Resolution;)V", "component1", "component2", "component3", "component4", "copy", "(Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;Lcom/socure/docv/capturesdk/core/processor/model/Resolution;ILjava/lang/Integer;)Lcom/socure/docv/capturesdk/core/processor/model/CaptureMetadata;", "equals", "", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CaptureMetadata {
    private int captureIndex;
    private CaptureType captureType;
    private Integer originalSize;
    private Resolution resolution;

    public CaptureMetadata(CaptureType captureType, Resolution resolution, int i, Integer num) {
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        this.captureType = captureType;
        this.resolution = resolution;
        this.captureIndex = i;
        this.originalSize = num;
    }

    public /* synthetic */ CaptureMetadata(CaptureType captureType, Resolution resolution, int i, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(captureType, resolution, i, (i2 & 8) != 0 ? null : num);
    }

    public static /* synthetic */ CaptureMetadata copy$default(CaptureMetadata captureMetadata, CaptureType captureType, Resolution resolution, int i, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            captureType = captureMetadata.captureType;
        }
        if ((i2 & 2) != 0) {
            resolution = captureMetadata.resolution;
        }
        if ((i2 & 4) != 0) {
            i = captureMetadata.captureIndex;
        }
        if ((i2 & 8) != 0) {
            num = captureMetadata.originalSize;
        }
        return captureMetadata.copy(captureType, resolution, i, num);
    }

    /* renamed from: component1, reason: from getter */
    public final CaptureType getCaptureType() {
        return this.captureType;
    }

    /* renamed from: component2, reason: from getter */
    public final Resolution getResolution() {
        return this.resolution;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCaptureIndex() {
        return this.captureIndex;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getOriginalSize() {
        return this.originalSize;
    }

    public final CaptureMetadata copy(CaptureType captureType, Resolution resolution, int captureIndex, Integer originalSize) {
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(resolution, "resolution");
        return new CaptureMetadata(captureType, resolution, captureIndex, originalSize);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CaptureMetadata)) {
            return false;
        }
        CaptureMetadata captureMetadata = (CaptureMetadata) other;
        return this.captureType == captureMetadata.captureType && Intrinsics.areEqual(this.resolution, captureMetadata.resolution) && this.captureIndex == captureMetadata.captureIndex && Intrinsics.areEqual(this.originalSize, captureMetadata.originalSize);
    }

    public final int getCaptureIndex() {
        return this.captureIndex;
    }

    public final CaptureType getCaptureType() {
        return this.captureType;
    }

    public final Integer getOriginalSize() {
        return this.originalSize;
    }

    public final Resolution getResolution() {
        return this.resolution;
    }

    public int hashCode() {
        int hashCode = (Integer.hashCode(this.captureIndex) + ((this.resolution.hashCode() + (this.captureType.hashCode() * 31)) * 31)) * 31;
        Integer num = this.originalSize;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public final void setCaptureIndex(int i) {
        this.captureIndex = i;
    }

    public final void setCaptureType(CaptureType captureType) {
        Intrinsics.checkNotNullParameter(captureType, "<set-?>");
        this.captureType = captureType;
    }

    public final void setOriginalSize(Integer num) {
        this.originalSize = num;
    }

    public final void setResolution(Resolution resolution) {
        Intrinsics.checkNotNullParameter(resolution, "<set-?>");
        this.resolution = resolution;
    }

    public String toString() {
        return "CaptureMetadata(captureType=" + this.captureType + ", resolution=" + this.resolution + ", captureIndex=" + this.captureIndex + ", originalSize=" + this.originalSize + ")";
    }
}
