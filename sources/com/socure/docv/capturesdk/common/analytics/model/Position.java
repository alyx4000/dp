package com.socure.docv.capturesdk.common.analytics.model;

import io.sentry.profilemeasurements.ProfileMeasurement;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Position;", "", "isGlare", "", ProfileMeasurement.UNIT_PERCENT, "", "maxGlareBlob", "", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMaxGlareBlob", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;)Lcom/socure/docv/capturesdk/common/analytics/model/Position;", "equals", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Position {
    private final Boolean isGlare;
    private final Double maxGlareBlob;
    private final Integer percent;

    public Position() {
        this(null, null, null, 7, null);
    }

    public Position(Boolean bool, Integer num, Double d) {
        this.isGlare = bool;
        this.percent = num;
        this.maxGlareBlob = d;
    }

    public /* synthetic */ Position(Boolean bool, Integer num, Double d, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : d);
    }

    public static /* synthetic */ Position copy$default(Position position, Boolean bool, Integer num, Double d, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = position.isGlare;
        }
        if ((i & 2) != 0) {
            num = position.percent;
        }
        if ((i & 4) != 0) {
            d = position.maxGlareBlob;
        }
        return position.copy(bool, num, d);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsGlare() {
        return this.isGlare;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getPercent() {
        return this.percent;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getMaxGlareBlob() {
        return this.maxGlareBlob;
    }

    public final Position copy(Boolean isGlare, Integer percent, Double maxGlareBlob) {
        return new Position(isGlare, percent, maxGlareBlob);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Position)) {
            return false;
        }
        Position position = (Position) other;
        return Intrinsics.areEqual(this.isGlare, position.isGlare) && Intrinsics.areEqual(this.percent, position.percent) && Intrinsics.areEqual((Object) this.maxGlareBlob, (Object) position.maxGlareBlob);
    }

    public final Double getMaxGlareBlob() {
        return this.maxGlareBlob;
    }

    public final Integer getPercent() {
        return this.percent;
    }

    public int hashCode() {
        Boolean bool = this.isGlare;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Integer num = this.percent;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Double d = this.maxGlareBlob;
        return hashCode2 + (d != null ? d.hashCode() : 0);
    }

    public final Boolean isGlare() {
        return this.isGlare;
    }

    public String toString() {
        return "Position(isGlare=" + this.isGlare + ", percent=" + this.percent + ", maxGlareBlob=" + this.maxGlareBlob + ")";
    }
}
