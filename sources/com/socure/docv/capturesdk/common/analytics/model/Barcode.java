package com.socure.docv.capturesdk.common.analytics.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J2\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/Barcode;", "", "barcodeDetected", "", "barcodeImage", "Lcom/socure/docv/capturesdk/common/analytics/model/BarcodeImage;", "regionData", "Lcom/socure/docv/capturesdk/common/analytics/model/RegionData;", "(Ljava/lang/Boolean;Lcom/socure/docv/capturesdk/common/analytics/model/BarcodeImage;Lcom/socure/docv/capturesdk/common/analytics/model/RegionData;)V", "getBarcodeDetected", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBarcodeImage", "()Lcom/socure/docv/capturesdk/common/analytics/model/BarcodeImage;", "getRegionData", "()Lcom/socure/docv/capturesdk/common/analytics/model/RegionData;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Lcom/socure/docv/capturesdk/common/analytics/model/BarcodeImage;Lcom/socure/docv/capturesdk/common/analytics/model/RegionData;)Lcom/socure/docv/capturesdk/common/analytics/model/Barcode;", "equals", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Barcode {
    private final Boolean barcodeDetected;
    private final BarcodeImage barcodeImage;
    private final RegionData regionData;

    public Barcode() {
        this(null, null, null, 7, null);
    }

    public Barcode(Boolean bool, BarcodeImage barcodeImage, RegionData regionData) {
        this.barcodeDetected = bool;
        this.barcodeImage = barcodeImage;
        this.regionData = regionData;
    }

    public /* synthetic */ Barcode(Boolean bool, BarcodeImage barcodeImage, RegionData regionData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : barcodeImage, (i & 4) != 0 ? null : regionData);
    }

    public static /* synthetic */ Barcode copy$default(Barcode barcode, Boolean bool, BarcodeImage barcodeImage, RegionData regionData, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = barcode.barcodeDetected;
        }
        if ((i & 2) != 0) {
            barcodeImage = barcode.barcodeImage;
        }
        if ((i & 4) != 0) {
            regionData = barcode.regionData;
        }
        return barcode.copy(bool, barcodeImage, regionData);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getBarcodeDetected() {
        return this.barcodeDetected;
    }

    /* renamed from: component2, reason: from getter */
    public final BarcodeImage getBarcodeImage() {
        return this.barcodeImage;
    }

    /* renamed from: component3, reason: from getter */
    public final RegionData getRegionData() {
        return this.regionData;
    }

    public final Barcode copy(Boolean barcodeDetected, BarcodeImage barcodeImage, RegionData regionData) {
        return new Barcode(barcodeDetected, barcodeImage, regionData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Barcode)) {
            return false;
        }
        Barcode barcode = (Barcode) other;
        return Intrinsics.areEqual(this.barcodeDetected, barcode.barcodeDetected) && Intrinsics.areEqual(this.barcodeImage, barcode.barcodeImage) && Intrinsics.areEqual(this.regionData, barcode.regionData);
    }

    public final Boolean getBarcodeDetected() {
        return this.barcodeDetected;
    }

    public final BarcodeImage getBarcodeImage() {
        return this.barcodeImage;
    }

    public final RegionData getRegionData() {
        return this.regionData;
    }

    public int hashCode() {
        Boolean bool = this.barcodeDetected;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        BarcodeImage barcodeImage = this.barcodeImage;
        int hashCode2 = (hashCode + (barcodeImage == null ? 0 : barcodeImage.hashCode())) * 31;
        RegionData regionData = this.regionData;
        return hashCode2 + (regionData != null ? regionData.hashCode() : 0);
    }

    public String toString() {
        return "Barcode(barcodeDetected=" + this.barcodeDetected + ", barcodeImage=" + this.barcodeImage + ", regionData=" + this.regionData + ")";
    }
}
