package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UpdateStatusRequest;", "", "eventType", "", "data", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "(Ljava/lang/String;Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;)V", "getData", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "getEventType", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UpdateStatusRequest {
    private final ExtractedStepUpData data;
    private final String eventType;

    public UpdateStatusRequest(String eventType, ExtractedStepUpData extractedStepUpData) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        this.eventType = eventType;
        this.data = extractedStepUpData;
    }

    public /* synthetic */ UpdateStatusRequest(String str, ExtractedStepUpData extractedStepUpData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : extractedStepUpData);
    }

    public static /* synthetic */ UpdateStatusRequest copy$default(UpdateStatusRequest updateStatusRequest, String str, ExtractedStepUpData extractedStepUpData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = updateStatusRequest.eventType;
        }
        if ((i & 2) != 0) {
            extractedStepUpData = updateStatusRequest.data;
        }
        return updateStatusRequest.copy(str, extractedStepUpData);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventType() {
        return this.eventType;
    }

    /* renamed from: component2, reason: from getter */
    public final ExtractedStepUpData getData() {
        return this.data;
    }

    public final UpdateStatusRequest copy(String eventType, ExtractedStepUpData data) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        return new UpdateStatusRequest(eventType, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UpdateStatusRequest)) {
            return false;
        }
        UpdateStatusRequest updateStatusRequest = (UpdateStatusRequest) other;
        return Intrinsics.areEqual(this.eventType, updateStatusRequest.eventType) && Intrinsics.areEqual(this.data, updateStatusRequest.data);
    }

    public final ExtractedStepUpData getData() {
        return this.data;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        int hashCode = this.eventType.hashCode() * 31;
        ExtractedStepUpData extractedStepUpData = this.data;
        return hashCode + (extractedStepUpData == null ? 0 : extractedStepUpData.hashCode());
    }

    public String toString() {
        return "UpdateStatusRequest(eventType=" + this.eventType + ", data=" + this.data + ")";
    }
}
