package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndResponse;", "", "data", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndData;", "status", "", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndData;Ljava/lang/String;)V", "getData", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndData;", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadEndResponse {
    private final UploadEndData data;
    private final String status;

    public UploadEndResponse(UploadEndData data, String status) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(status, "status");
        this.data = data;
        this.status = status;
    }

    public static /* synthetic */ UploadEndResponse copy$default(UploadEndResponse uploadEndResponse, UploadEndData uploadEndData, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            uploadEndData = uploadEndResponse.data;
        }
        if ((i & 2) != 0) {
            str = uploadEndResponse.status;
        }
        return uploadEndResponse.copy(uploadEndData, str);
    }

    /* renamed from: component1, reason: from getter */
    public final UploadEndData getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    public final UploadEndResponse copy(UploadEndData data, String status) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(status, "status");
        return new UploadEndResponse(data, status);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadEndResponse)) {
            return false;
        }
        UploadEndResponse uploadEndResponse = (UploadEndResponse) other;
        return Intrinsics.areEqual(this.data, uploadEndResponse.data) && Intrinsics.areEqual(this.status, uploadEndResponse.status);
    }

    public final UploadEndData getData() {
        return this.data;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.status.hashCode() + (this.data.hashCode() * 31);
    }

    public String toString() {
        return "UploadEndResponse(data=" + this.data + ", status=" + this.status + ")";
    }
}
