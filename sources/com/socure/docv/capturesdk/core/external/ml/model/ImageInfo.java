package com.socure.docv.capturesdk.core.external.ml.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/ImageInfo;", "", "imageType", "", "imageRes", "Lcom/socure/docv/capturesdk/core/external/ml/model/ImageRes;", "error", "(Ljava/lang/String;Lcom/socure/docv/capturesdk/core/external/ml/model/ImageRes;Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "getImageRes", "()Lcom/socure/docv/capturesdk/core/external/ml/model/ImageRes;", "getImageType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageInfo {
    private final String error;
    private final ImageRes imageRes;
    private final String imageType;

    public ImageInfo(String imageType, ImageRes imageRes, String str) {
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        this.imageType = imageType;
        this.imageRes = imageRes;
        this.error = str;
    }

    public /* synthetic */ ImageInfo(String str, ImageRes imageRes, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, imageRes, (i & 4) != 0 ? null : str2);
    }

    public static /* synthetic */ ImageInfo copy$default(ImageInfo imageInfo, String str, ImageRes imageRes, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = imageInfo.imageType;
        }
        if ((i & 2) != 0) {
            imageRes = imageInfo.imageRes;
        }
        if ((i & 4) != 0) {
            str2 = imageInfo.error;
        }
        return imageInfo.copy(str, imageRes, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getImageType() {
        return this.imageType;
    }

    /* renamed from: component2, reason: from getter */
    public final ImageRes getImageRes() {
        return this.imageRes;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final ImageInfo copy(String imageType, ImageRes imageRes, String error) {
        Intrinsics.checkNotNullParameter(imageType, "imageType");
        return new ImageInfo(imageType, imageRes, error);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageInfo)) {
            return false;
        }
        ImageInfo imageInfo = (ImageInfo) other;
        return Intrinsics.areEqual(this.imageType, imageInfo.imageType) && Intrinsics.areEqual(this.imageRes, imageInfo.imageRes) && Intrinsics.areEqual(this.error, imageInfo.error);
    }

    public final String getError() {
        return this.error;
    }

    public final ImageRes getImageRes() {
        return this.imageRes;
    }

    public final String getImageType() {
        return this.imageType;
    }

    public int hashCode() {
        int hashCode = this.imageType.hashCode() * 31;
        ImageRes imageRes = this.imageRes;
        int hashCode2 = (hashCode + (imageRes == null ? 0 : imageRes.hashCode())) * 31;
        String str = this.error;
        return hashCode2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ImageInfo(imageType=" + this.imageType + ", imageRes=" + this.imageRes + ", error=" + this.error + ")";
    }
}
