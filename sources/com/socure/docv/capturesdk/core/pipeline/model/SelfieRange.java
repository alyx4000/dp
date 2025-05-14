package com.socure.docv.capturesdk.core.pipeline.model;

import com.socure.docv.capturesdk.common.network.model.stepup.MinMax;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/socure/docv/capturesdk/core/pipeline/model/SelfieRange;", "", "type", "Lcom/socure/docv/capturesdk/core/pipeline/model/SelfieRangeType;", "minMax", "Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;", "(Lcom/socure/docv/capturesdk/core/pipeline/model/SelfieRangeType;Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;)V", "getMinMax", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;", "getType", "()Lcom/socure/docv/capturesdk/core/pipeline/model/SelfieRangeType;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SelfieRange {
    private final MinMax minMax;
    private final SelfieRangeType type;

    public SelfieRange(SelfieRangeType type, MinMax minMax) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        this.type = type;
        this.minMax = minMax;
    }

    public static /* synthetic */ SelfieRange copy$default(SelfieRange selfieRange, SelfieRangeType selfieRangeType, MinMax minMax, int i, Object obj) {
        if ((i & 1) != 0) {
            selfieRangeType = selfieRange.type;
        }
        if ((i & 2) != 0) {
            minMax = selfieRange.minMax;
        }
        return selfieRange.copy(selfieRangeType, minMax);
    }

    /* renamed from: component1, reason: from getter */
    public final SelfieRangeType getType() {
        return this.type;
    }

    /* renamed from: component2, reason: from getter */
    public final MinMax getMinMax() {
        return this.minMax;
    }

    public final SelfieRange copy(SelfieRangeType type, MinMax minMax) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(minMax, "minMax");
        return new SelfieRange(type, minMax);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelfieRange)) {
            return false;
        }
        SelfieRange selfieRange = (SelfieRange) other;
        return this.type == selfieRange.type && Intrinsics.areEqual(this.minMax, selfieRange.minMax);
    }

    public final MinMax getMinMax() {
        return this.minMax;
    }

    public final SelfieRangeType getType() {
        return this.type;
    }

    public int hashCode() {
        return this.minMax.hashCode() + (this.type.hashCode() * 31);
    }

    public String toString() {
        return "SelfieRange(type=" + this.type + ", minMax=" + this.minMax + ")";
    }
}
