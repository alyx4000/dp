package com.socure.docv.capturesdk.common.analytics.model;

import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJJ\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000e¨\u0006 "}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/RegionData;", "", ViewHierarchyNode.JsonKeys.X, "", "width", ViewHierarchyNode.JsonKeys.Y, "angle", "", "height", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;)V", "getAngle", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWidth", "getX", "getY", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;)Lcom/socure/docv/capturesdk/common/analytics/model/RegionData;", "equals", "", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class RegionData {
    private final Double angle;
    private final Integer height;
    private final Integer width;
    private final Integer x;
    private final Integer y;

    public RegionData() {
        this(null, null, null, null, null, 31, null);
    }

    public RegionData(Integer num, Integer num2, Integer num3, Double d, Integer num4) {
        this.x = num;
        this.width = num2;
        this.y = num3;
        this.angle = d;
        this.height = num4;
    }

    public /* synthetic */ RegionData(Integer num, Integer num2, Integer num3, Double d, Integer num4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : num3, (i & 8) != 0 ? null : d, (i & 16) != 0 ? null : num4);
    }

    public static /* synthetic */ RegionData copy$default(RegionData regionData, Integer num, Integer num2, Integer num3, Double d, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            num = regionData.x;
        }
        if ((i & 2) != 0) {
            num2 = regionData.width;
        }
        Integer num5 = num2;
        if ((i & 4) != 0) {
            num3 = regionData.y;
        }
        Integer num6 = num3;
        if ((i & 8) != 0) {
            d = regionData.angle;
        }
        Double d2 = d;
        if ((i & 16) != 0) {
            num4 = regionData.height;
        }
        return regionData.copy(num, num5, num6, d2, num4);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getY() {
        return this.y;
    }

    /* renamed from: component4, reason: from getter */
    public final Double getAngle() {
        return this.angle;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    public final RegionData copy(Integer x, Integer width, Integer y, Double angle, Integer height) {
        return new RegionData(x, width, y, angle, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegionData)) {
            return false;
        }
        RegionData regionData = (RegionData) other;
        return Intrinsics.areEqual(this.x, regionData.x) && Intrinsics.areEqual(this.width, regionData.width) && Intrinsics.areEqual(this.y, regionData.y) && Intrinsics.areEqual((Object) this.angle, (Object) regionData.angle) && Intrinsics.areEqual(this.height, regionData.height);
    }

    public final Double getAngle() {
        return this.angle;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public final Integer getX() {
        return this.x;
    }

    public final Integer getY() {
        return this.y;
    }

    public int hashCode() {
        Integer num = this.x;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.width;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.y;
        int hashCode3 = (hashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Double d = this.angle;
        int hashCode4 = (hashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num4 = this.height;
        return hashCode4 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "RegionData(x=" + this.x + ", width=" + this.width + ", y=" + this.y + ", angle=" + this.angle + ", height=" + this.height + ")";
    }
}
