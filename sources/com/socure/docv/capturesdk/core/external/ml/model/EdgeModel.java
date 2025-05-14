package com.socure.docv.capturesdk.core.external.ml.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.socure.core.Mat;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b'\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0014\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0017\u0010.\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\fHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003Jn\u00100\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u00101J\u0013\u00102\u001a\u00020\u00032\b\u00103\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00104\u001a\u000205HÖ\u0001J\t\u00106\u001a\u000207HÖ\u0001R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R(\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00068"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeModel;", "", "edgeDetectedAllSides", "", "edgeDetectedThreeSides", "regionWiseLines", "Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeReferenceLines;", "subRegionInfo", "Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeSubRegionInfo;", "croppedImage", "Lorg/socure/core/Mat;", "intersectionPoints", "", "", "debugImage", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeReferenceLines;Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeSubRegionInfo;Lorg/socure/core/Mat;Ljava/util/List;Lorg/socure/core/Mat;)V", "getCroppedImage", "()Lorg/socure/core/Mat;", "setCroppedImage", "(Lorg/socure/core/Mat;)V", "getDebugImage", "setDebugImage", "getEdgeDetectedAllSides", "()Ljava/lang/Boolean;", "setEdgeDetectedAllSides", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEdgeDetectedThreeSides", "setEdgeDetectedThreeSides", "getIntersectionPoints", "()Ljava/util/List;", "setIntersectionPoints", "(Ljava/util/List;)V", "getRegionWiseLines", "()Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeReferenceLines;", "setRegionWiseLines", "(Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeReferenceLines;)V", "getSubRegionInfo", "()Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeSubRegionInfo;", "setSubRegionInfo", "(Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeSubRegionInfo;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeReferenceLines;Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeSubRegionInfo;Lorg/socure/core/Mat;Ljava/util/List;Lorg/socure/core/Mat;)Lcom/socure/docv/capturesdk/core/external/ml/model/EdgeModel;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EdgeModel {
    private Mat croppedImage;
    private Mat debugImage;
    private Boolean edgeDetectedAllSides;
    private Boolean edgeDetectedThreeSides;
    private List<List<Double>> intersectionPoints;
    private EdgeReferenceLines regionWiseLines;
    private EdgeSubRegionInfo subRegionInfo;

    public EdgeModel(Boolean bool, Boolean bool2, EdgeReferenceLines edgeReferenceLines, EdgeSubRegionInfo edgeSubRegionInfo, Mat mat, List<List<Double>> list, Mat mat2) {
        this.edgeDetectedAllSides = bool;
        this.edgeDetectedThreeSides = bool2;
        this.regionWiseLines = edgeReferenceLines;
        this.subRegionInfo = edgeSubRegionInfo;
        this.croppedImage = mat;
        this.intersectionPoints = list;
        this.debugImage = mat2;
    }

    public /* synthetic */ EdgeModel(Boolean bool, Boolean bool2, EdgeReferenceLines edgeReferenceLines, EdgeSubRegionInfo edgeSubRegionInfo, Mat mat, List list, Mat mat2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, bool2, edgeReferenceLines, edgeSubRegionInfo, mat, list, (i & 64) != 0 ? null : mat2);
    }

    public static /* synthetic */ EdgeModel copy$default(EdgeModel edgeModel, Boolean bool, Boolean bool2, EdgeReferenceLines edgeReferenceLines, EdgeSubRegionInfo edgeSubRegionInfo, Mat mat, List list, Mat mat2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = edgeModel.edgeDetectedAllSides;
        }
        if ((i & 2) != 0) {
            bool2 = edgeModel.edgeDetectedThreeSides;
        }
        Boolean bool3 = bool2;
        if ((i & 4) != 0) {
            edgeReferenceLines = edgeModel.regionWiseLines;
        }
        EdgeReferenceLines edgeReferenceLines2 = edgeReferenceLines;
        if ((i & 8) != 0) {
            edgeSubRegionInfo = edgeModel.subRegionInfo;
        }
        EdgeSubRegionInfo edgeSubRegionInfo2 = edgeSubRegionInfo;
        if ((i & 16) != 0) {
            mat = edgeModel.croppedImage;
        }
        Mat mat3 = mat;
        if ((i & 32) != 0) {
            list = edgeModel.intersectionPoints;
        }
        List list2 = list;
        if ((i & 64) != 0) {
            mat2 = edgeModel.debugImage;
        }
        return edgeModel.copy(bool, bool3, edgeReferenceLines2, edgeSubRegionInfo2, mat3, list2, mat2);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getEdgeDetectedAllSides() {
        return this.edgeDetectedAllSides;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getEdgeDetectedThreeSides() {
        return this.edgeDetectedThreeSides;
    }

    /* renamed from: component3, reason: from getter */
    public final EdgeReferenceLines getRegionWiseLines() {
        return this.regionWiseLines;
    }

    /* renamed from: component4, reason: from getter */
    public final EdgeSubRegionInfo getSubRegionInfo() {
        return this.subRegionInfo;
    }

    /* renamed from: component5, reason: from getter */
    public final Mat getCroppedImage() {
        return this.croppedImage;
    }

    public final List<List<Double>> component6() {
        return this.intersectionPoints;
    }

    /* renamed from: component7, reason: from getter */
    public final Mat getDebugImage() {
        return this.debugImage;
    }

    public final EdgeModel copy(Boolean edgeDetectedAllSides, Boolean edgeDetectedThreeSides, EdgeReferenceLines regionWiseLines, EdgeSubRegionInfo subRegionInfo, Mat croppedImage, List<List<Double>> intersectionPoints, Mat debugImage) {
        return new EdgeModel(edgeDetectedAllSides, edgeDetectedThreeSides, regionWiseLines, subRegionInfo, croppedImage, intersectionPoints, debugImage);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EdgeModel)) {
            return false;
        }
        EdgeModel edgeModel = (EdgeModel) other;
        return Intrinsics.areEqual(this.edgeDetectedAllSides, edgeModel.edgeDetectedAllSides) && Intrinsics.areEqual(this.edgeDetectedThreeSides, edgeModel.edgeDetectedThreeSides) && Intrinsics.areEqual(this.regionWiseLines, edgeModel.regionWiseLines) && Intrinsics.areEqual(this.subRegionInfo, edgeModel.subRegionInfo) && Intrinsics.areEqual(this.croppedImage, edgeModel.croppedImage) && Intrinsics.areEqual(this.intersectionPoints, edgeModel.intersectionPoints) && Intrinsics.areEqual(this.debugImage, edgeModel.debugImage);
    }

    public final Mat getCroppedImage() {
        return this.croppedImage;
    }

    public final Mat getDebugImage() {
        return this.debugImage;
    }

    public final Boolean getEdgeDetectedAllSides() {
        return this.edgeDetectedAllSides;
    }

    public final Boolean getEdgeDetectedThreeSides() {
        return this.edgeDetectedThreeSides;
    }

    public final List<List<Double>> getIntersectionPoints() {
        return this.intersectionPoints;
    }

    public final EdgeReferenceLines getRegionWiseLines() {
        return this.regionWiseLines;
    }

    public final EdgeSubRegionInfo getSubRegionInfo() {
        return this.subRegionInfo;
    }

    public int hashCode() {
        Boolean bool = this.edgeDetectedAllSides;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.edgeDetectedThreeSides;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        EdgeReferenceLines edgeReferenceLines = this.regionWiseLines;
        int hashCode3 = (hashCode2 + (edgeReferenceLines == null ? 0 : edgeReferenceLines.hashCode())) * 31;
        EdgeSubRegionInfo edgeSubRegionInfo = this.subRegionInfo;
        int hashCode4 = (hashCode3 + (edgeSubRegionInfo == null ? 0 : edgeSubRegionInfo.hashCode())) * 31;
        Mat mat = this.croppedImage;
        int hashCode5 = (hashCode4 + (mat == null ? 0 : mat.hashCode())) * 31;
        List<List<Double>> list = this.intersectionPoints;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Mat mat2 = this.debugImage;
        return hashCode6 + (mat2 != null ? mat2.hashCode() : 0);
    }

    public final void setCroppedImage(Mat mat) {
        this.croppedImage = mat;
    }

    public final void setDebugImage(Mat mat) {
        this.debugImage = mat;
    }

    public final void setEdgeDetectedAllSides(Boolean bool) {
        this.edgeDetectedAllSides = bool;
    }

    public final void setEdgeDetectedThreeSides(Boolean bool) {
        this.edgeDetectedThreeSides = bool;
    }

    public final void setIntersectionPoints(List<List<Double>> list) {
        this.intersectionPoints = list;
    }

    public final void setRegionWiseLines(EdgeReferenceLines edgeReferenceLines) {
        this.regionWiseLines = edgeReferenceLines;
    }

    public final void setSubRegionInfo(EdgeSubRegionInfo edgeSubRegionInfo) {
        this.subRegionInfo = edgeSubRegionInfo;
    }

    public String toString() {
        return "EdgeModel(edgeDetectedAllSides=" + this.edgeDetectedAllSides + ", edgeDetectedThreeSides=" + this.edgeDetectedThreeSides + ", regionWiseLines=" + this.regionWiseLines + ", subRegionInfo=" + this.subRegionInfo + ", croppedImage=" + this.croppedImage + ", intersectionPoints=" + this.intersectionPoints + ", debugImage=" + this.debugImage + ")";
    }
}
