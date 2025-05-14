package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadResponse;", "", "status", "", "data", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadData;", "(Ljava/lang/String;Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadData;)V", "getData", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadData;", "getStatus", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartUploadResponse {
    private final StartUploadData data;
    private final String status;

    public StartUploadResponse(String status, StartUploadData data) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(data, "data");
        this.status = status;
        this.data = data;
    }

    public static /* synthetic */ StartUploadResponse copy$default(StartUploadResponse startUploadResponse, String str, StartUploadData startUploadData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = startUploadResponse.status;
        }
        if ((i & 2) != 0) {
            startUploadData = startUploadResponse.data;
        }
        return startUploadResponse.copy(str, startUploadData);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final StartUploadData getData() {
        return this.data;
    }

    public final StartUploadResponse copy(String status, StartUploadData data) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(data, "data");
        return new StartUploadResponse(status, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartUploadResponse)) {
            return false;
        }
        StartUploadResponse startUploadResponse = (StartUploadResponse) other;
        return Intrinsics.areEqual(this.status, startUploadResponse.status) && Intrinsics.areEqual(this.data, startUploadResponse.data);
    }

    public final StartUploadData getData() {
        return this.data;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.data.hashCode() + (this.status.hashCode() * 31);
    }

    public String toString() {
        return "StartUploadResponse(status=" + this.status + ", data=" + this.data + ")";
    }
}
