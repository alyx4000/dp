package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006!"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Data;", "", "isInternal", "", "eventId", "", "accountId", "", "referenceId", "environment", "config", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartConfig;", "(ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/socure/docv/capturesdk/common/network/model/stepup/StartConfig;)V", "getAccountId", "()I", "getConfig", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/StartConfig;", "getEnvironment", "()Ljava/lang/String;", "getEventId", "()Z", "getReferenceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Data {
    private final int accountId;
    private final StartConfig config;
    private final String environment;
    private final String eventId;
    private final boolean isInternal;
    private final String referenceId;

    public Data(boolean z, String eventId, int i, String referenceId, String environment, StartConfig config) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(referenceId, "referenceId");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(config, "config");
        this.isInternal = z;
        this.eventId = eventId;
        this.accountId = i;
        this.referenceId = referenceId;
        this.environment = environment;
        this.config = config;
    }

    public static /* synthetic */ Data copy$default(Data data, boolean z, String str, int i, String str2, String str3, StartConfig startConfig, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = data.isInternal;
        }
        if ((i2 & 2) != 0) {
            str = data.eventId;
        }
        String str4 = str;
        if ((i2 & 4) != 0) {
            i = data.accountId;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            str2 = data.referenceId;
        }
        String str5 = str2;
        if ((i2 & 16) != 0) {
            str3 = data.environment;
        }
        String str6 = str3;
        if ((i2 & 32) != 0) {
            startConfig = data.config;
        }
        return data.copy(z, str4, i3, str5, str6, startConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsInternal() {
        return this.isInternal;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getAccountId() {
        return this.accountId;
    }

    /* renamed from: component4, reason: from getter */
    public final String getReferenceId() {
        return this.referenceId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getEnvironment() {
        return this.environment;
    }

    /* renamed from: component6, reason: from getter */
    public final StartConfig getConfig() {
        return this.config;
    }

    public final Data copy(boolean isInternal, String eventId, int accountId, String referenceId, String environment, StartConfig config) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        Intrinsics.checkNotNullParameter(referenceId, "referenceId");
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(config, "config");
        return new Data(isInternal, eventId, accountId, referenceId, environment, config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Data)) {
            return false;
        }
        Data data = (Data) other;
        return this.isInternal == data.isInternal && Intrinsics.areEqual(this.eventId, data.eventId) && this.accountId == data.accountId && Intrinsics.areEqual(this.referenceId, data.referenceId) && Intrinsics.areEqual(this.environment, data.environment) && Intrinsics.areEqual(this.config, data.config);
    }

    public final int getAccountId() {
        return this.accountId;
    }

    public final StartConfig getConfig() {
        return this.config;
    }

    public final String getEnvironment() {
        return this.environment;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getReferenceId() {
        return this.referenceId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    public int hashCode() {
        boolean z = this.isInternal;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return this.config.hashCode() + com.socure.docv.capturesdk.common.analytics.model.a.a(this.environment, com.socure.docv.capturesdk.common.analytics.model.a.a(this.referenceId, (Integer.hashCode(this.accountId) + com.socure.docv.capturesdk.common.analytics.model.a.a(this.eventId, r0 * 31, 31)) * 31, 31), 31);
    }

    public final boolean isInternal() {
        return this.isInternal;
    }

    public String toString() {
        return "Data(isInternal=" + this.isInternal + ", eventId=" + this.eventId + ", accountId=" + this.accountId + ", referenceId=" + this.referenceId + ", environment=" + this.environment + ", config=" + this.config + ")";
    }
}
