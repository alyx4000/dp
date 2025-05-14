package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J9\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndRequest;", "", "documentsReferenceId", "", "documentInfo", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "documentsUuid", "documentVerificationToken", "(Ljava/lang/String;Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;Ljava/lang/String;Ljava/lang/String;)V", "getDocumentInfo", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "setDocumentInfo", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;)V", "getDocumentVerificationToken", "()Ljava/lang/String;", "setDocumentVerificationToken", "(Ljava/lang/String;)V", "getDocumentsReferenceId", "setDocumentsReferenceId", "getDocumentsUuid", "setDocumentsUuid", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadEndRequest {
    private ExtractedStepUpData documentInfo;
    private String documentVerificationToken;
    private String documentsReferenceId;
    private String documentsUuid;

    public UploadEndRequest() {
        this(null, null, null, null, 15, null);
    }

    public UploadEndRequest(String str, ExtractedStepUpData extractedStepUpData, String str2, String str3) {
        this.documentsReferenceId = str;
        this.documentInfo = extractedStepUpData;
        this.documentsUuid = str2;
        this.documentVerificationToken = str3;
    }

    public /* synthetic */ UploadEndRequest(String str, ExtractedStepUpData extractedStepUpData, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : extractedStepUpData, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3);
    }

    public static /* synthetic */ UploadEndRequest copy$default(UploadEndRequest uploadEndRequest, String str, ExtractedStepUpData extractedStepUpData, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadEndRequest.documentsReferenceId;
        }
        if ((i & 2) != 0) {
            extractedStepUpData = uploadEndRequest.documentInfo;
        }
        if ((i & 4) != 0) {
            str2 = uploadEndRequest.documentsUuid;
        }
        if ((i & 8) != 0) {
            str3 = uploadEndRequest.documentVerificationToken;
        }
        return uploadEndRequest.copy(str, extractedStepUpData, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDocumentsReferenceId() {
        return this.documentsReferenceId;
    }

    /* renamed from: component2, reason: from getter */
    public final ExtractedStepUpData getDocumentInfo() {
        return this.documentInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDocumentsUuid() {
        return this.documentsUuid;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDocumentVerificationToken() {
        return this.documentVerificationToken;
    }

    public final UploadEndRequest copy(String documentsReferenceId, ExtractedStepUpData documentInfo, String documentsUuid, String documentVerificationToken) {
        return new UploadEndRequest(documentsReferenceId, documentInfo, documentsUuid, documentVerificationToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadEndRequest)) {
            return false;
        }
        UploadEndRequest uploadEndRequest = (UploadEndRequest) other;
        return Intrinsics.areEqual(this.documentsReferenceId, uploadEndRequest.documentsReferenceId) && Intrinsics.areEqual(this.documentInfo, uploadEndRequest.documentInfo) && Intrinsics.areEqual(this.documentsUuid, uploadEndRequest.documentsUuid) && Intrinsics.areEqual(this.documentVerificationToken, uploadEndRequest.documentVerificationToken);
    }

    public final ExtractedStepUpData getDocumentInfo() {
        return this.documentInfo;
    }

    public final String getDocumentVerificationToken() {
        return this.documentVerificationToken;
    }

    public final String getDocumentsReferenceId() {
        return this.documentsReferenceId;
    }

    public final String getDocumentsUuid() {
        return this.documentsUuid;
    }

    public int hashCode() {
        String str = this.documentsReferenceId;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ExtractedStepUpData extractedStepUpData = this.documentInfo;
        int hashCode2 = (hashCode + (extractedStepUpData == null ? 0 : extractedStepUpData.hashCode())) * 31;
        String str2 = this.documentsUuid;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.documentVerificationToken;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setDocumentInfo(ExtractedStepUpData extractedStepUpData) {
        this.documentInfo = extractedStepUpData;
    }

    public final void setDocumentVerificationToken(String str) {
        this.documentVerificationToken = str;
    }

    public final void setDocumentsReferenceId(String str) {
        this.documentsReferenceId = str;
    }

    public final void setDocumentsUuid(String str) {
        this.documentsUuid = str;
    }

    public String toString() {
        return "UploadEndRequest(documentsReferenceId=" + this.documentsReferenceId + ", documentInfo=" + this.documentInfo + ", documentsUuid=" + this.documentsUuid + ", documentVerificationToken=" + this.documentVerificationToken + ")";
    }
}
