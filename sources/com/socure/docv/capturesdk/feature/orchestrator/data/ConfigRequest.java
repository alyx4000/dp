package com.socure.docv.capturesdk.feature.orchestrator.data;

import com.socure.docv.capturesdk.api.Keys;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequest;", "", Keys.KEY_FLOW, "Lcom/socure/docv/capturesdk/feature/orchestrator/data/FlowRequest;", "language", "", "(Lcom/socure/docv/capturesdk/feature/orchestrator/data/FlowRequest;Ljava/lang/String;)V", "getFlow", "()Lcom/socure/docv/capturesdk/feature/orchestrator/data/FlowRequest;", "getLanguage", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfigRequest {
    private final FlowRequest flow;
    private final String language;

    public ConfigRequest() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public ConfigRequest(FlowRequest flowRequest, String str) {
        this.flow = flowRequest;
        this.language = str;
    }

    public /* synthetic */ ConfigRequest(FlowRequest flowRequest, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : flowRequest, (i & 2) != 0 ? null : str);
    }

    public static /* synthetic */ ConfigRequest copy$default(ConfigRequest configRequest, FlowRequest flowRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            flowRequest = configRequest.flow;
        }
        if ((i & 2) != 0) {
            str = configRequest.language;
        }
        return configRequest.copy(flowRequest, str);
    }

    /* renamed from: component1, reason: from getter */
    public final FlowRequest getFlow() {
        return this.flow;
    }

    /* renamed from: component2, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    public final ConfigRequest copy(FlowRequest flow, String language) {
        return new ConfigRequest(flow, language);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigRequest)) {
            return false;
        }
        ConfigRequest configRequest = (ConfigRequest) other;
        return Intrinsics.areEqual(this.flow, configRequest.flow) && Intrinsics.areEqual(this.language, configRequest.language);
    }

    public final FlowRequest getFlow() {
        return this.flow;
    }

    public final String getLanguage() {
        return this.language;
    }

    public int hashCode() {
        FlowRequest flowRequest = this.flow;
        int hashCode = (flowRequest == null ? 0 : flowRequest.hashCode()) * 31;
        String str = this.language;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ConfigRequest(flow=" + this.flow + ", language=" + this.language + ")";
    }
}
