package com.socure.docv.capturesdk.common.analytics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\t\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxDouble;", "", "min", "", "max", "(Ljava/lang/Double;Ljava/lang/Double;)V", "getMax", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getMin", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Double;)Lcom/socure/docv/capturesdk/common/analytics/model/MinMaxDouble;", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MinMaxDouble {
    private final Double max;
    private final Double min;

    public MinMaxDouble() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public MinMaxDouble(Double d, Double d2) {
        this.min = d;
        this.max = d2;
    }

    public /* synthetic */ MinMaxDouble(Double d, Double d2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : d2);
    }

    public static /* synthetic */ MinMaxDouble copy$default(MinMaxDouble minMaxDouble, Double d, Double d2, int i, Object obj) {
        if ((i & 1) != 0) {
            d = minMaxDouble.min;
        }
        if ((i & 2) != 0) {
            d2 = minMaxDouble.max;
        }
        return minMaxDouble.copy(d, d2);
    }

    /* renamed from: component1, reason: from getter */
    public final Double getMin() {
        return this.min;
    }

    /* renamed from: component2, reason: from getter */
    public final Double getMax() {
        return this.max;
    }

    public final MinMaxDouble copy(Double min, Double max) {
        return new MinMaxDouble(min, max);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MinMaxDouble)) {
            return false;
        }
        MinMaxDouble minMaxDouble = (MinMaxDouble) other;
        return Intrinsics.areEqual((Object) this.min, (Object) minMaxDouble.min) && Intrinsics.areEqual((Object) this.max, (Object) minMaxDouble.max);
    }

    public final Double getMax() {
        return this.max;
    }

    public final Double getMin() {
        return this.min;
    }

    public int hashCode() {
        Double d = this.min;
        int hashCode = (d == null ? 0 : d.hashCode()) * 31;
        Double d2 = this.max;
        return hashCode + (d2 != null ? d2.hashCode() : 0);
    }

    public String toString() {
        return "MinMaxDouble(min=" + this.min + ", max=" + this.max + ")";
    }
}
