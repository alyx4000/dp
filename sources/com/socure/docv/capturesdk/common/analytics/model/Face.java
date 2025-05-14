package com.socure.docv.capturesdk.common.analytics.model;

import io.sentry.protocol.Geo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u001aJ>\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\tHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006("}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Face;", "", Geo.JsonKeys.REGION, "", "faceDetected", "", "confidence", "", "rotatingAngle", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)V", "getConfidence", "()Ljava/lang/Double;", "setConfidence", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getFaceDetected", "()Ljava/lang/Boolean;", "setFaceDetected", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getRegion", "()Ljava/lang/String;", "setRegion", "(Ljava/lang/String;)V", "getRotatingAngle", "()Ljava/lang/Integer;", "setRotatingAngle", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;)Lcom/socure/docv/capturesdk/common/analytics/model/Face;", "equals", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Face {
    private Double confidence;
    private Boolean faceDetected;
    private String region;
    private Integer rotatingAngle;

    public Face() {
        this(null, null, null, null, 15, null);
    }

    public Face(String str, Boolean bool, Double d, Integer num) {
        this.region = str;
        this.faceDetected = bool;
        this.confidence = d;
        this.rotatingAngle = num;
    }

    public /* synthetic */ Face(String str, Boolean bool, Double d, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : d, (i & 8) != 0 ? null : num);
    }

    public static /* synthetic */ Face copy$default(Face face, String str, Boolean bool, Double d, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = face.region;
        }
        if ((i & 2) != 0) {
            bool = face.faceDetected;
        }
        if ((i & 4) != 0) {
            d = face.confidence;
        }
        if ((i & 8) != 0) {
            num = face.rotatingAngle;
        }
        return face.copy(str, bool, d, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRegion() {
        return this.region;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getFaceDetected() {
        return this.faceDetected;
    }

    /* renamed from: component3, reason: from getter */
    public final Double getConfidence() {
        return this.confidence;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getRotatingAngle() {
        return this.rotatingAngle;
    }

    public final Face copy(String region, Boolean faceDetected, Double confidence, Integer rotatingAngle) {
        return new Face(region, faceDetected, confidence, rotatingAngle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Face)) {
            return false;
        }
        Face face = (Face) other;
        return Intrinsics.areEqual(this.region, face.region) && Intrinsics.areEqual(this.faceDetected, face.faceDetected) && Intrinsics.areEqual((Object) this.confidence, (Object) face.confidence) && Intrinsics.areEqual(this.rotatingAngle, face.rotatingAngle);
    }

    public final Double getConfidence() {
        return this.confidence;
    }

    public final Boolean getFaceDetected() {
        return this.faceDetected;
    }

    public final String getRegion() {
        return this.region;
    }

    public final Integer getRotatingAngle() {
        return this.rotatingAngle;
    }

    public int hashCode() {
        String str = this.region;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.faceDetected;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Double d = this.confidence;
        int hashCode3 = (hashCode2 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.rotatingAngle;
        return hashCode3 + (num != null ? num.hashCode() : 0);
    }

    public final void setConfidence(Double d) {
        this.confidence = d;
    }

    public final void setFaceDetected(Boolean bool) {
        this.faceDetected = bool;
    }

    public final void setRegion(String str) {
        this.region = str;
    }

    public final void setRotatingAngle(Integer num) {
        this.rotatingAngle = num;
    }

    public String toString() {
        return "Face(region=" + this.region + ", faceDetected=" + this.faceDetected + ", confidence=" + this.confidence + ", rotatingAngle=" + this.rotatingAngle + ")";
    }
}
