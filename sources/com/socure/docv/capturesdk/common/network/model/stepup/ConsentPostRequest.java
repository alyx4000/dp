package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentPostRequest;", "", "consent", "", "version", "", "language", "selection", "", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Selection;", "(ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getConsent", "()Z", "getLanguage", "()Ljava/lang/String;", "getSelection", "()Ljava/util/List;", "getVersion", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConsentPostRequest {
    private final boolean consent;
    private final String language;
    private final List<Selection> selection;
    private final String version;

    public ConsentPostRequest(boolean z, String version, String language, List<Selection> selection) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(selection, "selection");
        this.consent = z;
        this.version = version;
        this.language = language;
        this.selection = selection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsentPostRequest copy$default(ConsentPostRequest consentPostRequest, boolean z, String str, String str2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = consentPostRequest.consent;
        }
        if ((i & 2) != 0) {
            str = consentPostRequest.version;
        }
        if ((i & 4) != 0) {
            str2 = consentPostRequest.language;
        }
        if ((i & 8) != 0) {
            list = consentPostRequest.selection;
        }
        return consentPostRequest.copy(z, str, str2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getConsent() {
        return this.consent;
    }

    /* renamed from: component2, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component3, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    public final List<Selection> component4() {
        return this.selection;
    }

    public final ConsentPostRequest copy(boolean consent, String version, String language, List<Selection> selection) {
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(selection, "selection");
        return new ConsentPostRequest(consent, version, language, selection);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConsentPostRequest)) {
            return false;
        }
        ConsentPostRequest consentPostRequest = (ConsentPostRequest) other;
        return this.consent == consentPostRequest.consent && Intrinsics.areEqual(this.version, consentPostRequest.version) && Intrinsics.areEqual(this.language, consentPostRequest.language) && Intrinsics.areEqual(this.selection, consentPostRequest.selection);
    }

    public final boolean getConsent() {
        return this.consent;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final List<Selection> getSelection() {
        return this.selection;
    }

    public final String getVersion() {
        return this.version;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public int hashCode() {
        boolean z = this.consent;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        return this.selection.hashCode() + com.socure.docv.capturesdk.common.analytics.model.a.a(this.language, com.socure.docv.capturesdk.common.analytics.model.a.a(this.version, r0 * 31, 31), 31);
    }

    public String toString() {
        return "ConsentPostRequest(consent=" + this.consent + ", version=" + this.version + ", language=" + this.language + ", selection=" + this.selection + ")";
    }
}
