package com.socure.docv.capturesdk.common.network.model.stepup;

import com.socure.docv.capturesdk.feature.orchestrator.data.ConfigRequest;
import com.socure.docv.capturesdk.feature.orchestrator.data.EmptyDataClass;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/StartSessionRequest;", "", "data", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/EmptyDataClass;", "verificationLevel", "", "config", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequest;", "(Lcom/socure/docv/capturesdk/feature/orchestrator/data/EmptyDataClass;ILcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequest;)V", "getConfig", "()Lcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequest;", "getData", "()Lcom/socure/docv/capturesdk/feature/orchestrator/data/EmptyDataClass;", "getVerificationLevel", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class StartSessionRequest {
    private final ConfigRequest config;
    private final EmptyDataClass data;
    private final int verificationLevel;

    public StartSessionRequest(EmptyDataClass data, int i, ConfigRequest config) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(config, "config");
        this.data = data;
        this.verificationLevel = i;
        this.config = config;
    }

    public /* synthetic */ StartSessionRequest(EmptyDataClass emptyDataClass, int i, ConfigRequest configRequest, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new EmptyDataClass(null, 1, null) : emptyDataClass, (i2 & 2) != 0 ? 1 : i, configRequest);
    }

    public static /* synthetic */ StartSessionRequest copy$default(StartSessionRequest startSessionRequest, EmptyDataClass emptyDataClass, int i, ConfigRequest configRequest, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            emptyDataClass = startSessionRequest.data;
        }
        if ((i2 & 2) != 0) {
            i = startSessionRequest.verificationLevel;
        }
        if ((i2 & 4) != 0) {
            configRequest = startSessionRequest.config;
        }
        return startSessionRequest.copy(emptyDataClass, i, configRequest);
    }

    /* renamed from: component1, reason: from getter */
    public final EmptyDataClass getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final int getVerificationLevel() {
        return this.verificationLevel;
    }

    /* renamed from: component3, reason: from getter */
    public final ConfigRequest getConfig() {
        return this.config;
    }

    public final StartSessionRequest copy(EmptyDataClass data, int verificationLevel, ConfigRequest config) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(config, "config");
        return new StartSessionRequest(data, verificationLevel, config);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StartSessionRequest)) {
            return false;
        }
        StartSessionRequest startSessionRequest = (StartSessionRequest) other;
        return Intrinsics.areEqual(this.data, startSessionRequest.data) && this.verificationLevel == startSessionRequest.verificationLevel && Intrinsics.areEqual(this.config, startSessionRequest.config);
    }

    public final ConfigRequest getConfig() {
        return this.config;
    }

    public final EmptyDataClass getData() {
        return this.data;
    }

    public final int getVerificationLevel() {
        return this.verificationLevel;
    }

    public int hashCode() {
        return this.config.hashCode() + ((Integer.hashCode(this.verificationLevel) + (this.data.hashCode() * 31)) * 31);
    }

    public String toString() {
        return "StartSessionRequest(data=" + this.data + ", verificationLevel=" + this.verificationLevel + ", config=" + this.config + ")";
    }
}
