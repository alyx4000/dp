package com.socure.docv.capturesdk.common.network.model.stepup;

import com.iterable.iterableapi.IterableConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b,\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\r\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0010HÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\rHÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\u009f\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0003HÆ\u0001J\u0013\u00108\u001a\u00020\u000b2\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\rHÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0011\u0010\u0012\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0019¨\u0006<"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndData;", "", "eventId", "", "verificationLevel", "publicAccountId", "publicApiKey", "flowVersion", "flowName", IterableConstants.KEY_TOKEN, "isInternal", "", "accountId", "", "createdAt", "environment", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndEnvironment;", "expired", "id", "publicId", "updatedAt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndEnvironment;ZILjava/lang/String;Ljava/lang/String;)V", "getAccountId", "()I", "getCreatedAt", "()Ljava/lang/String;", "getEnvironment", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndEnvironment;", "getEventId", "getExpired", "()Z", "getFlowName", "getFlowVersion", "getId", "getPublicAccountId", "getPublicApiKey", "getPublicId", "getToken", "getUpdatedAt", "getVerificationLevel", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UploadEndData {
    private final int accountId;
    private final String createdAt;
    private final UploadEndEnvironment environment;
    private final String eventId;
    private final boolean expired;
    private final String flowName;
    private final String flowVersion;
    private final int id;
    private final boolean isInternal;
    private final String publicAccountId;
    private final String publicApiKey;
    private final String publicId;
    private final String token;
    private final String updatedAt;
    private final String verificationLevel;

    public UploadEndData(String eventId, String verificationLevel, String publicAccountId, String publicApiKey, String flowVersion, String flowName, String token, boolean z, int i, String createdAt, UploadEndEnvironment environment, boolean z2, int i2, String publicId, String updatedAt) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(verificationLevel, "verificationLevel");
        Intrinsics.checkNotNullParameter(publicAccountId, "publicAccountId");
        Intrinsics.checkNotNullParameter(publicApiKey, "publicApiKey");
        Intrinsics.checkNotNullParameter(flowVersion, "flowVersion");
        Intrinsics.checkNotNullParameter(flowName, "flowName");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(publicId, "publicId");
        Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
        this.eventId = eventId;
        this.verificationLevel = verificationLevel;
        this.publicAccountId = publicAccountId;
        this.publicApiKey = publicApiKey;
        this.flowVersion = flowVersion;
        this.flowName = flowName;
        this.token = token;
        this.isInternal = z;
        this.accountId = i;
        this.createdAt = createdAt;
        this.environment = environment;
        this.expired = z2;
        this.id = i2;
        this.publicId = publicId;
        this.updatedAt = updatedAt;
    }

    /* renamed from: component1, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* renamed from: component10, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component11, reason: from getter */
    public final UploadEndEnvironment getEnvironment() {
        return this.environment;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getExpired() {
        return this.expired;
    }

    /* renamed from: component13, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component14, reason: from getter */
    public final String getPublicId() {
        return this.publicId;
    }

    /* renamed from: component15, reason: from getter */
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVerificationLevel() {
        return this.verificationLevel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPublicAccountId() {
        return this.publicAccountId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPublicApiKey() {
        return this.publicApiKey;
    }

    /* renamed from: component5, reason: from getter */
    public final String getFlowVersion() {
        return this.flowVersion;
    }

    /* renamed from: component6, reason: from getter */
    public final String getFlowName() {
        return this.flowName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsInternal() {
        return this.isInternal;
    }

    /* renamed from: component9, reason: from getter */
    public final int getAccountId() {
        return this.accountId;
    }

    public final UploadEndData copy(String eventId, String verificationLevel, String publicAccountId, String publicApiKey, String flowVersion, String flowName, String token, boolean isInternal, int accountId, String createdAt, UploadEndEnvironment environment, boolean expired, int id, String publicId, String updatedAt) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(verificationLevel, "verificationLevel");
        Intrinsics.checkNotNullParameter(publicAccountId, "publicAccountId");
        Intrinsics.checkNotNullParameter(publicApiKey, "publicApiKey");
        Intrinsics.checkNotNullParameter(flowVersion, "flowVersion");
        Intrinsics.checkNotNullParameter(flowName, "flowName");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(createdAt, "createdAt");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(publicId, "publicId");
        Intrinsics.checkNotNullParameter(updatedAt, "updatedAt");
        return new UploadEndData(eventId, verificationLevel, publicAccountId, publicApiKey, flowVersion, flowName, token, isInternal, accountId, createdAt, environment, expired, id, publicId, updatedAt);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UploadEndData)) {
            return false;
        }
        UploadEndData uploadEndData = (UploadEndData) other;
        return Intrinsics.areEqual(this.eventId, uploadEndData.eventId) && Intrinsics.areEqual(this.verificationLevel, uploadEndData.verificationLevel) && Intrinsics.areEqual(this.publicAccountId, uploadEndData.publicAccountId) && Intrinsics.areEqual(this.publicApiKey, uploadEndData.publicApiKey) && Intrinsics.areEqual(this.flowVersion, uploadEndData.flowVersion) && Intrinsics.areEqual(this.flowName, uploadEndData.flowName) && Intrinsics.areEqual(this.token, uploadEndData.token) && this.isInternal == uploadEndData.isInternal && this.accountId == uploadEndData.accountId && Intrinsics.areEqual(this.createdAt, uploadEndData.createdAt) && Intrinsics.areEqual(this.environment, uploadEndData.environment) && this.expired == uploadEndData.expired && this.id == uploadEndData.id && Intrinsics.areEqual(this.publicId, uploadEndData.publicId) && Intrinsics.areEqual(this.updatedAt, uploadEndData.updatedAt);
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final UploadEndEnvironment getEnvironment() {
        return this.environment;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final boolean getExpired() {
        return this.expired;
    }

    public final String getFlowName() {
        return this.flowName;
    }

    public final String getFlowVersion() {
        return this.flowVersion;
    }

    public final int getId() {
        return this.id;
    }

    public final String getPublicAccountId() {
        return this.publicAccountId;
    }

    public final String getPublicApiKey() {
        return this.publicApiKey;
    }

    public final String getPublicId() {
        return this.publicId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final String getVerificationLevel() {
        return this.verificationLevel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int a2 = com.socure.docv.capturesdk.common.analytics.model.a.a(this.token, com.socure.docv.capturesdk.common.analytics.model.a.a(this.flowName, com.socure.docv.capturesdk.common.analytics.model.a.a(this.flowVersion, com.socure.docv.capturesdk.common.analytics.model.a.a(this.publicApiKey, com.socure.docv.capturesdk.common.analytics.model.a.a(this.publicAccountId, com.socure.docv.capturesdk.common.analytics.model.a.a(this.verificationLevel, this.eventId.hashCode() * 31, 31), 31), 31), 31), 31), 31);
        boolean z = this.isInternal;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int hashCode = (this.environment.hashCode() + com.socure.docv.capturesdk.common.analytics.model.a.a(this.createdAt, (Integer.hashCode(this.accountId) + ((a2 + i) * 31)) * 31, 31)) * 31;
        boolean z2 = this.expired;
        return this.updatedAt.hashCode() + com.socure.docv.capturesdk.common.analytics.model.a.a(this.publicId, (Integer.hashCode(this.id) + ((hashCode + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31, 31);
    }

    public final boolean isInternal() {
        return this.isInternal;
    }

    public String toString() {
        return "UploadEndData(eventId=" + this.eventId + ", verificationLevel=" + this.verificationLevel + ", publicAccountId=" + this.publicAccountId + ", publicApiKey=" + this.publicApiKey + ", flowVersion=" + this.flowVersion + ", flowName=" + this.flowName + ", token=" + this.token + ", isInternal=" + this.isInternal + ", accountId=" + this.accountId + ", createdAt=" + this.createdAt + ", environment=" + this.environment + ", expired=" + this.expired + ", id=" + this.id + ", publicId=" + this.publicId + ", updatedAt=" + this.updatedAt + ")";
    }
}
