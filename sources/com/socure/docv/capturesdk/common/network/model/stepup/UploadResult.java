package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000eJ:\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadResult;", "", "referenceId", "", "uuid", "error", "errorCode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getError", "()Ljava/lang/String;", "setError", "(Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/Integer;", "setErrorCode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getReferenceId", "getUuid", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadResult;", "equals", "", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadResult {
    private String error;
    private Integer errorCode;
    private final String referenceId;
    private final String uuid;

    public UploadResult(String referenceId, String uuid, String str, Integer num) {
        Intrinsics.checkNotNullParameter(referenceId, "referenceId");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.referenceId = referenceId;
        this.uuid = uuid;
        this.error = str;
        this.errorCode = num;
    }

    public static /* synthetic */ UploadResult copy$default(UploadResult uploadResult, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadResult.referenceId;
        }
        if ((i & 2) != 0) {
            str2 = uploadResult.uuid;
        }
        if ((i & 4) != 0) {
            str3 = uploadResult.error;
        }
        if ((i & 8) != 0) {
            num = uploadResult.errorCode;
        }
        return uploadResult.copy(str, str2, str3, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReferenceId() {
        return this.referenceId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getUuid() {
        return this.uuid;
    }

    /* renamed from: component3, reason: from getter */
    public final String getError() {
        return this.error;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final UploadResult copy(String referenceId, String uuid, String error, Integer errorCode) {
        Intrinsics.checkNotNullParameter(referenceId, "referenceId");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        return new UploadResult(referenceId, uuid, error, errorCode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadResult)) {
            return false;
        }
        UploadResult uploadResult = (UploadResult) other;
        return Intrinsics.areEqual(this.referenceId, uploadResult.referenceId) && Intrinsics.areEqual(this.uuid, uploadResult.uuid) && Intrinsics.areEqual(this.error, uploadResult.error) && Intrinsics.areEqual(this.errorCode, uploadResult.errorCode);
    }

    public final String getError() {
        return this.error;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int a2 = com.socure.docv.capturesdk.common.analytics.model.a.a(this.uuid, this.referenceId.hashCode() * 31, 31);
        String str = this.error;
        int hashCode = (a2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.errorCode;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final void setErrorCode(Integer num) {
        this.errorCode = num;
    }

    public String toString() {
        return "UploadResult(referenceId=" + this.referenceId + ", uuid=" + this.uuid + ", error=" + this.error + ", errorCode=" + this.errorCode + ")";
    }
}
