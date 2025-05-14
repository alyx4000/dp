package com.socure.docv.capturesdk.feature.orchestrator.data;

import com.google.gson.annotations.SerializedName;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.api.Keys;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016JJ\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\tHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R \u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000e¨\u0006&"}, d2 = {"Lcom/socure/docv/capturesdk/feature/orchestrator/data/Config;", "", IterableConstants.SOUND_FOLDER_IDENTIFIER, "", Keys.KEY_FLOW, "Lcom/socure/docv/capturesdk/feature/orchestrator/data/Flow;", "language", ApiConstant.DOCUMENT_TYPE, "maxSubmitCount", "", "(Ljava/lang/String;Lcom/socure/docv/capturesdk/feature/orchestrator/data/Flow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDocumentType", "()Ljava/lang/String;", "setDocumentType", "(Ljava/lang/String;)V", "getFlow", "()Lcom/socure/docv/capturesdk/feature/orchestrator/data/Flow;", "setFlow", "(Lcom/socure/docv/capturesdk/feature/orchestrator/data/Flow;)V", "getLanguage", "setLanguage", "getMaxSubmitCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRaw", "setRaw", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/socure/docv/capturesdk/feature/orchestrator/data/Flow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/socure/docv/capturesdk/feature/orchestrator/data/Config;", "equals", "", "other", "hashCode", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Config {

    @SerializedName(Keys.KEY_DOCUMENT_TYPE)
    private String documentType;

    @SerializedName(Keys.KEY_FLOW)
    private Flow flow;

    @SerializedName("language")
    private String language;

    @SerializedName(Keys.KEY_MAX_SUBMIT)
    private final Integer maxSubmitCount;
    private transient String raw;

    public Config() {
        this(null, null, null, null, null, 31, null);
    }

    public Config(String str, Flow flow, String str2, String str3, Integer num) {
        this.raw = str;
        this.flow = flow;
        this.language = str2;
        this.documentType = str3;
        this.maxSubmitCount = num;
    }

    public /* synthetic */ Config(String str, Flow flow, String str2, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : flow, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : num);
    }

    public static /* synthetic */ Config copy$default(Config config, String str, Flow flow, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = config.raw;
        }
        if ((i & 2) != 0) {
            flow = config.flow;
        }
        Flow flow2 = flow;
        if ((i & 4) != 0) {
            str2 = config.language;
        }
        String str4 = str2;
        if ((i & 8) != 0) {
            str3 = config.documentType;
        }
        String str5 = str3;
        if ((i & 16) != 0) {
            num = config.maxSubmitCount;
        }
        return config.copy(str, flow2, str4, str5, num);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRaw() {
        return this.raw;
    }

    /* renamed from: component2, reason: from getter */
    public final Flow getFlow() {
        return this.flow;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDocumentType() {
        return this.documentType;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getMaxSubmitCount() {
        return this.maxSubmitCount;
    }

    public final Config copy(String raw, Flow flow, String language, String documentType, Integer maxSubmitCount) {
        return new Config(raw, flow, language, documentType, maxSubmitCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Config)) {
            return false;
        }
        Config config = (Config) other;
        return Intrinsics.areEqual(this.raw, config.raw) && Intrinsics.areEqual(this.flow, config.flow) && Intrinsics.areEqual(this.language, config.language) && Intrinsics.areEqual(this.documentType, config.documentType) && Intrinsics.areEqual(this.maxSubmitCount, config.maxSubmitCount);
    }

    public final String getDocumentType() {
        return this.documentType;
    }

    public final Flow getFlow() {
        return this.flow;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Integer getMaxSubmitCount() {
        return this.maxSubmitCount;
    }

    public final String getRaw() {
        return this.raw;
    }

    public int hashCode() {
        String str = this.raw;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Flow flow = this.flow;
        int hashCode2 = (hashCode + (flow == null ? 0 : flow.hashCode())) * 31;
        String str2 = this.language;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.documentType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.maxSubmitCount;
        return hashCode4 + (num != null ? num.hashCode() : 0);
    }

    public final void setDocumentType(String str) {
        this.documentType = str;
    }

    public final void setFlow(Flow flow) {
        this.flow = flow;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setRaw(String str) {
        this.raw = str;
    }

    public String toString() {
        return "Config(raw=" + this.raw + ", flow=" + this.flow + ", language=" + this.language + ", documentType=" + this.documentType + ", maxSubmitCount=" + this.maxSubmitCount + ")";
    }
}
