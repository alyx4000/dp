package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadData;", "", "trackingProperties", "", "Lcom/socure/docv/capturesdk/common/network/model/stepup/TrackingProperty;", "(Ljava/util/List;)V", "getTrackingProperties", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartUploadData {
    private final List<TrackingProperty> trackingProperties;

    public StartUploadData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public StartUploadData(List<TrackingProperty> trackingProperties) {
        Intrinsics.checkNotNullParameter(trackingProperties, "trackingProperties");
        this.trackingProperties = trackingProperties;
    }

    public /* synthetic */ StartUploadData(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StartUploadData copy$default(StartUploadData startUploadData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = startUploadData.trackingProperties;
        }
        return startUploadData.copy(list);
    }

    public final List<TrackingProperty> component1() {
        return this.trackingProperties;
    }

    public final StartUploadData copy(List<TrackingProperty> trackingProperties) {
        Intrinsics.checkNotNullParameter(trackingProperties, "trackingProperties");
        return new StartUploadData(trackingProperties);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof StartUploadData) && Intrinsics.areEqual(this.trackingProperties, ((StartUploadData) other).trackingProperties);
    }

    public final List<TrackingProperty> getTrackingProperties() {
        return this.trackingProperties;
    }

    public int hashCode() {
        return this.trackingProperties.hashCode();
    }

    public String toString() {
        return "StartUploadData(trackingProperties=" + this.trackingProperties + ")";
    }
}
