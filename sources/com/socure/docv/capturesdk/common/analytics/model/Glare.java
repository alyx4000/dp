package com.socure.docv.capturesdk.common.analytics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b<\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bõ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010>\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010D\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010E\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010I\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010J\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010K\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u0010M\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010/J\u0010\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJþ\u0001\u0010O\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u00020\u00032\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0007HÖ\u0001J\t\u0010T\u001a\u00020UHÖ\u0001R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b#\u0010 R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b$\u0010 R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0004\u0010\u001c\"\u0004\b'\u0010(R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0002\u0010\u001c\"\u0004\b)\u0010(R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b*\u0010\u001cR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b+\u0010 R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001cR\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b5\u0010/\"\u0004\b6\u00101R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b7\u0010\u001cR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b8\u0010 R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b9\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010!\u001a\u0004\b:\u0010 ¨\u0006V"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Glare;", "", "isGlare", "", "isContourGlare", "leftTop", "centerValue", "", "maxGlarePercentage", "", "centerBottomValue", "center", "maxPerimeterRatio", "leftBottom", "centerBottom", "leftBottomValue", "rightTopValue", "centerTop", "rightBottomValue", "percentage", "rightBottom", "leftTopValue", "centerTopValue", "glareRegions", "Lcom/socure/docv/capturesdk/common/analytics/model/GlareRegions;", "rightTop", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/socure/docv/capturesdk/common/analytics/model/GlareRegions;Ljava/lang/Boolean;)V", "getCenter", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCenterBottom", "getCenterBottomValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCenterTop", "getCenterTopValue", "getCenterValue", "getGlareRegions", "()Lcom/socure/docv/capturesdk/common/analytics/model/GlareRegions;", "setContourGlare", "(Ljava/lang/Boolean;)V", "setGlare", "getLeftBottom", "getLeftBottomValue", "getLeftTop", "getLeftTopValue", "getMaxGlarePercentage", "()Ljava/lang/Double;", "setMaxGlarePercentage", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getMaxPerimeterRatio", "setMaxPerimeterRatio", "getPercentage", "setPercentage", "getRightBottom", "getRightBottomValue", "getRightTop", "getRightTopValue", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/socure/docv/capturesdk/common/analytics/model/GlareRegions;Ljava/lang/Boolean;)Lcom/socure/docv/capturesdk/common/analytics/model/Glare;", "equals", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Glare {
    private final Boolean center;
    private final Boolean centerBottom;
    private final Integer centerBottomValue;
    private final Boolean centerTop;
    private final Integer centerTopValue;
    private final Integer centerValue;
    private final GlareRegions glareRegions;
    private Boolean isContourGlare;
    private Boolean isGlare;
    private final Boolean leftBottom;
    private final Integer leftBottomValue;
    private final Boolean leftTop;
    private final Integer leftTopValue;
    private Double maxGlarePercentage;
    private Double maxPerimeterRatio;
    private Double percentage;
    private final Boolean rightBottom;
    private final Integer rightBottomValue;
    private final Boolean rightTop;
    private final Integer rightTopValue;

    public Glare() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1048575, null);
    }

    public Glare(Boolean bool, Boolean bool2, Boolean bool3, Integer num, Double d, Integer num2, Boolean bool4, Double d2, Boolean bool5, Boolean bool6, Integer num3, Integer num4, Boolean bool7, Integer num5, Double d3, Boolean bool8, Integer num6, Integer num7, GlareRegions glareRegions, Boolean bool9) {
        this.isGlare = bool;
        this.isContourGlare = bool2;
        this.leftTop = bool3;
        this.centerValue = num;
        this.maxGlarePercentage = d;
        this.centerBottomValue = num2;
        this.center = bool4;
        this.maxPerimeterRatio = d2;
        this.leftBottom = bool5;
        this.centerBottom = bool6;
        this.leftBottomValue = num3;
        this.rightTopValue = num4;
        this.centerTop = bool7;
        this.rightBottomValue = num5;
        this.percentage = d3;
        this.rightBottom = bool8;
        this.leftTopValue = num6;
        this.centerTopValue = num7;
        this.glareRegions = glareRegions;
        this.rightTop = bool9;
    }

    public /* synthetic */ Glare(Boolean bool, Boolean bool2, Boolean bool3, Integer num, Double d, Integer num2, Boolean bool4, Double d2, Boolean bool5, Boolean bool6, Integer num3, Integer num4, Boolean bool7, Integer num5, Double d3, Boolean bool8, Integer num6, Integer num7, GlareRegions glareRegions, Boolean bool9, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : bool3, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : d, (i & 32) != 0 ? null : num2, (i & 64) != 0 ? null : bool4, (i & 128) != 0 ? null : d2, (i & 256) != 0 ? null : bool5, (i & 512) != 0 ? null : bool6, (i & 1024) != 0 ? null : num3, (i & 2048) != 0 ? null : num4, (i & 4096) != 0 ? null : bool7, (i & 8192) != 0 ? null : num5, (i & 16384) != 0 ? null : d3, (i & 32768) != 0 ? null : bool8, (i & 65536) != 0 ? null : num6, (i & 131072) != 0 ? null : num7, (i & 262144) != 0 ? null : glareRegions, (i & 524288) != 0 ? null : bool9);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsGlare() {
        return this.isGlare;
    }

    /* renamed from: component10, reason: from getter */
    public final Boolean getCenterBottom() {
        return this.centerBottom;
    }

    /* renamed from: component11, reason: from getter */
    public final Integer getLeftBottomValue() {
        return this.leftBottomValue;
    }

    /* renamed from: component12, reason: from getter */
    public final Integer getRightTopValue() {
        return this.rightTopValue;
    }

    /* renamed from: component13, reason: from getter */
    public final Boolean getCenterTop() {
        return this.centerTop;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getRightBottomValue() {
        return this.rightBottomValue;
    }

    /* renamed from: component15, reason: from getter */
    public final Double getPercentage() {
        return this.percentage;
    }

    /* renamed from: component16, reason: from getter */
    public final Boolean getRightBottom() {
        return this.rightBottom;
    }

    /* renamed from: component17, reason: from getter */
    public final Integer getLeftTopValue() {
        return this.leftTopValue;
    }

    /* renamed from: component18, reason: from getter */
    public final Integer getCenterTopValue() {
        return this.centerTopValue;
    }

    /* renamed from: component19, reason: from getter */
    public final GlareRegions getGlareRegions() {
        return this.glareRegions;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsContourGlare() {
        return this.isContourGlare;
    }

    /* renamed from: component20, reason: from getter */
    public final Boolean getRightTop() {
        return this.rightTop;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getLeftTop() {
        return this.leftTop;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getCenterValue() {
        return this.centerValue;
    }

    /* renamed from: component5, reason: from getter */
    public final Double getMaxGlarePercentage() {
        return this.maxGlarePercentage;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getCenterBottomValue() {
        return this.centerBottomValue;
    }

    /* renamed from: component7, reason: from getter */
    public final Boolean getCenter() {
        return this.center;
    }

    /* renamed from: component8, reason: from getter */
    public final Double getMaxPerimeterRatio() {
        return this.maxPerimeterRatio;
    }

    /* renamed from: component9, reason: from getter */
    public final Boolean getLeftBottom() {
        return this.leftBottom;
    }

    public final Glare copy(Boolean isGlare, Boolean isContourGlare, Boolean leftTop, Integer centerValue, Double maxGlarePercentage, Integer centerBottomValue, Boolean center, Double maxPerimeterRatio, Boolean leftBottom, Boolean centerBottom, Integer leftBottomValue, Integer rightTopValue, Boolean centerTop, Integer rightBottomValue, Double percentage, Boolean rightBottom, Integer leftTopValue, Integer centerTopValue, GlareRegions glareRegions, Boolean rightTop) {
        return new Glare(isGlare, isContourGlare, leftTop, centerValue, maxGlarePercentage, centerBottomValue, center, maxPerimeterRatio, leftBottom, centerBottom, leftBottomValue, rightTopValue, centerTop, rightBottomValue, percentage, rightBottom, leftTopValue, centerTopValue, glareRegions, rightTop);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Glare)) {
            return false;
        }
        Glare glare = (Glare) other;
        return Intrinsics.areEqual(this.isGlare, glare.isGlare) && Intrinsics.areEqual(this.isContourGlare, glare.isContourGlare) && Intrinsics.areEqual(this.leftTop, glare.leftTop) && Intrinsics.areEqual(this.centerValue, glare.centerValue) && Intrinsics.areEqual((Object) this.maxGlarePercentage, (Object) glare.maxGlarePercentage) && Intrinsics.areEqual(this.centerBottomValue, glare.centerBottomValue) && Intrinsics.areEqual(this.center, glare.center) && Intrinsics.areEqual((Object) this.maxPerimeterRatio, (Object) glare.maxPerimeterRatio) && Intrinsics.areEqual(this.leftBottom, glare.leftBottom) && Intrinsics.areEqual(this.centerBottom, glare.centerBottom) && Intrinsics.areEqual(this.leftBottomValue, glare.leftBottomValue) && Intrinsics.areEqual(this.rightTopValue, glare.rightTopValue) && Intrinsics.areEqual(this.centerTop, glare.centerTop) && Intrinsics.areEqual(this.rightBottomValue, glare.rightBottomValue) && Intrinsics.areEqual((Object) this.percentage, (Object) glare.percentage) && Intrinsics.areEqual(this.rightBottom, glare.rightBottom) && Intrinsics.areEqual(this.leftTopValue, glare.leftTopValue) && Intrinsics.areEqual(this.centerTopValue, glare.centerTopValue) && Intrinsics.areEqual(this.glareRegions, glare.glareRegions) && Intrinsics.areEqual(this.rightTop, glare.rightTop);
    }

    public final Boolean getCenter() {
        return this.center;
    }

    public final Boolean getCenterBottom() {
        return this.centerBottom;
    }

    public final Integer getCenterBottomValue() {
        return this.centerBottomValue;
    }

    public final Boolean getCenterTop() {
        return this.centerTop;
    }

    public final Integer getCenterTopValue() {
        return this.centerTopValue;
    }

    public final Integer getCenterValue() {
        return this.centerValue;
    }

    public final GlareRegions getGlareRegions() {
        return this.glareRegions;
    }

    public final Boolean getLeftBottom() {
        return this.leftBottom;
    }

    public final Integer getLeftBottomValue() {
        return this.leftBottomValue;
    }

    public final Boolean getLeftTop() {
        return this.leftTop;
    }

    public final Integer getLeftTopValue() {
        return this.leftTopValue;
    }

    public final Double getMaxGlarePercentage() {
        return this.maxGlarePercentage;
    }

    public final Double getMaxPerimeterRatio() {
        return this.maxPerimeterRatio;
    }

    public final Double getPercentage() {
        return this.percentage;
    }

    public final Boolean getRightBottom() {
        return this.rightBottom;
    }

    public final Integer getRightBottomValue() {
        return this.rightBottomValue;
    }

    public final Boolean getRightTop() {
        return this.rightTop;
    }

    public final Integer getRightTopValue() {
        return this.rightTopValue;
    }

    public int hashCode() {
        Boolean bool = this.isGlare;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.isContourGlare;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.leftTop;
        int hashCode3 = (hashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Integer num = this.centerValue;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Double d = this.maxGlarePercentage;
        int hashCode5 = (hashCode4 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num2 = this.centerBottomValue;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool4 = this.center;
        int hashCode7 = (hashCode6 + (bool4 == null ? 0 : bool4.hashCode())) * 31;
        Double d2 = this.maxPerimeterRatio;
        int hashCode8 = (hashCode7 + (d2 == null ? 0 : d2.hashCode())) * 31;
        Boolean bool5 = this.leftBottom;
        int hashCode9 = (hashCode8 + (bool5 == null ? 0 : bool5.hashCode())) * 31;
        Boolean bool6 = this.centerBottom;
        int hashCode10 = (hashCode9 + (bool6 == null ? 0 : bool6.hashCode())) * 31;
        Integer num3 = this.leftBottomValue;
        int hashCode11 = (hashCode10 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.rightTopValue;
        int hashCode12 = (hashCode11 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Boolean bool7 = this.centerTop;
        int hashCode13 = (hashCode12 + (bool7 == null ? 0 : bool7.hashCode())) * 31;
        Integer num5 = this.rightBottomValue;
        int hashCode14 = (hashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Double d3 = this.percentage;
        int hashCode15 = (hashCode14 + (d3 == null ? 0 : d3.hashCode())) * 31;
        Boolean bool8 = this.rightBottom;
        int hashCode16 = (hashCode15 + (bool8 == null ? 0 : bool8.hashCode())) * 31;
        Integer num6 = this.leftTopValue;
        int hashCode17 = (hashCode16 + (num6 == null ? 0 : num6.hashCode())) * 31;
        Integer num7 = this.centerTopValue;
        int hashCode18 = (hashCode17 + (num7 == null ? 0 : num7.hashCode())) * 31;
        GlareRegions glareRegions = this.glareRegions;
        int hashCode19 = (hashCode18 + (glareRegions == null ? 0 : glareRegions.hashCode())) * 31;
        Boolean bool9 = this.rightTop;
        return hashCode19 + (bool9 != null ? bool9.hashCode() : 0);
    }

    public final Boolean isContourGlare() {
        return this.isContourGlare;
    }

    public final Boolean isGlare() {
        return this.isGlare;
    }

    public final void setContourGlare(Boolean bool) {
        this.isContourGlare = bool;
    }

    public final void setGlare(Boolean bool) {
        this.isGlare = bool;
    }

    public final void setMaxGlarePercentage(Double d) {
        this.maxGlarePercentage = d;
    }

    public final void setMaxPerimeterRatio(Double d) {
        this.maxPerimeterRatio = d;
    }

    public final void setPercentage(Double d) {
        this.percentage = d;
    }

    public String toString() {
        return "Glare(isGlare=" + this.isGlare + ", isContourGlare=" + this.isContourGlare + ", leftTop=" + this.leftTop + ", centerValue=" + this.centerValue + ", maxGlarePercentage=" + this.maxGlarePercentage + ", centerBottomValue=" + this.centerBottomValue + ", center=" + this.center + ", maxPerimeterRatio=" + this.maxPerimeterRatio + ", leftBottom=" + this.leftBottom + ", centerBottom=" + this.centerBottom + ", leftBottomValue=" + this.leftBottomValue + ", rightTopValue=" + this.rightTopValue + ", centerTop=" + this.centerTop + ", rightBottomValue=" + this.rightBottomValue + ", percentage=" + this.percentage + ", rightBottom=" + this.rightBottom + ", leftTopValue=" + this.leftTopValue + ", centerTopValue=" + this.centerTopValue + ", glareRegions=" + this.glareRegions + ", rightTop=" + this.rightTop + ")";
    }
}
