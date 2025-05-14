package com.socure.docv.capturesdk.core.external.ml.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/socure/docv/capturesdk/core/external/ml/model/ImageRes;", "", "w", "", "h", "(II)V", "getH", "()I", "getW", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ImageRes {
    private final int h;
    private final int w;

    public ImageRes(int i, int i2) {
        this.w = i;
        this.h = i2;
    }

    public static /* synthetic */ ImageRes copy$default(ImageRes imageRes, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = imageRes.w;
        }
        if ((i3 & 2) != 0) {
            i2 = imageRes.h;
        }
        return imageRes.copy(i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getW() {
        return this.w;
    }

    /* renamed from: component2, reason: from getter */
    public final int getH() {
        return this.h;
    }

    public final ImageRes copy(int w, int h) {
        return new ImageRes(w, h);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImageRes)) {
            return false;
        }
        ImageRes imageRes = (ImageRes) other;
        return this.w == imageRes.w && this.h == imageRes.h;
    }

    public final int getH() {
        return this.h;
    }

    public final int getW() {
        return this.w;
    }

    public int hashCode() {
        return Integer.hashCode(this.h) + (Integer.hashCode(this.w) * 31);
    }

    public String toString() {
        return "ImageRes(w=" + this.w + ", h=" + this.h + ")";
    }
}
