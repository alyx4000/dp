package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/FlowResponse;", "", "data", "Lcom/socure/docv/capturesdk/common/network/model/stepup/FlowData;", "status", "", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/FlowData;Ljava/lang/String;)V", "getData", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/FlowData;", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FlowResponse {
    private final FlowData data;
    private final String status;

    public FlowResponse(FlowData data, String status) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(status, "status");
        this.data = data;
        this.status = status;
    }

    public static /* synthetic */ FlowResponse copy$default(FlowResponse flowResponse, FlowData flowData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            flowData = flowResponse.data;
        }
        if ((i & 2) != 0) {
            str = flowResponse.status;
        }
        return flowResponse.copy(flowData, str);
    }

    /* renamed from: component1, reason: from getter */
    public final FlowData getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final FlowResponse copy(FlowData data, String status) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(status, "status");
        return new FlowResponse(data, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FlowResponse)) {
            return false;
        }
        FlowResponse flowResponse = (FlowResponse) other;
        return Intrinsics.areEqual(this.data, flowResponse.data) && Intrinsics.areEqual(this.status, flowResponse.status);
    }

    public final FlowData getData() {
        return this.data;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode() + (this.data.hashCode() * 31);
    }

    public String toString() {
        return "FlowResponse(data=" + this.data + ", status=" + this.status + ")";
    }
}
