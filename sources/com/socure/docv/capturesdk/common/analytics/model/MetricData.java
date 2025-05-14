package com.socure.docv.capturesdk.common.analytics.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003J;\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\tHÖ\u0001R*\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Lcom/socure/docv/capturesdk/common/analytics/model/MetricData;", "", "documents", "Lcom/socure/docv/capturesdk/common/analytics/model/Documents;", "devices", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/analytics/model/CameraDevice;", "Lkotlin/collections/ArrayList;", "userAgent", "", "(Lcom/socure/docv/capturesdk/common/analytics/model/Documents;Ljava/util/ArrayList;Ljava/lang/String;)V", "getDevices", "()Ljava/util/ArrayList;", "setDevices", "(Ljava/util/ArrayList;)V", "getDocuments", "()Lcom/socure/docv/capturesdk/common/analytics/model/Documents;", "setDocuments", "(Lcom/socure/docv/capturesdk/common/analytics/model/Documents;)V", "getUserAgent", "()Ljava/lang/String;", "setUserAgent", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class MetricData {
    private ArrayList<CameraDevice> devices;
    private Documents documents;
    private String userAgent;

    public MetricData() {
        this(null, null, null, 7, null);
    }

    public MetricData(Documents documents, ArrayList<CameraDevice> devices, String str) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        this.documents = documents;
        this.devices = devices;
        this.userAgent = str;
    }

    public /* synthetic */ MetricData(Documents documents, ArrayList arrayList, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : documents, (i & 2) != 0 ? new ArrayList() : arrayList, (i & 4) != 0 ? null : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MetricData copy$default(MetricData metricData, Documents documents, ArrayList arrayList, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            documents = metricData.documents;
        }
        if ((i & 2) != 0) {
            arrayList = metricData.devices;
        }
        if ((i & 4) != 0) {
            str = metricData.userAgent;
        }
        return metricData.copy(documents, arrayList, str);
    }

    /* renamed from: component1, reason: from getter */
    public final Documents getDocuments() {
        return this.documents;
    }

    public final ArrayList<CameraDevice> component2() {
        return this.devices;
    }

    /* renamed from: component3, reason: from getter */
    public final String getUserAgent() {
        return this.userAgent;
    }

    public final MetricData copy(Documents documents, ArrayList<CameraDevice> devices, String userAgent) {
        Intrinsics.checkNotNullParameter(devices, "devices");
        return new MetricData(documents, devices, userAgent);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MetricData)) {
            return false;
        }
        MetricData metricData = (MetricData) other;
        return Intrinsics.areEqual(this.documents, metricData.documents) && Intrinsics.areEqual(this.devices, metricData.devices) && Intrinsics.areEqual(this.userAgent, metricData.userAgent);
    }

    public final ArrayList<CameraDevice> getDevices() {
        return this.devices;
    }

    public final Documents getDocuments() {
        return this.documents;
    }

    public final String getUserAgent() {
        return this.userAgent;
    }

    public int hashCode() {
        Documents documents = this.documents;
        int hashCode = (this.devices.hashCode() + ((documents == null ? 0 : documents.hashCode()) * 31)) * 31;
        String str = this.userAgent;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setDevices(ArrayList<CameraDevice> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.devices = arrayList;
    }

    public final void setDocuments(Documents documents) {
        this.documents = documents;
    }

    public final void setUserAgent(String str) {
        this.userAgent = str;
    }

    public String toString() {
        return "MetricData(documents=" + this.documents + ", devices=" + this.devices + ", userAgent=" + this.userAgent + ")";
    }
}
