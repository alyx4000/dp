package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Common;", "", "labels", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Labels;", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/Labels;)V", "getLabels", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/Labels;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Common {
    private final Labels labels;

    public Common(Labels labels) {
        Intrinsics.checkNotNullParameter(labels, "labels");
        this.labels = labels;
    }

    public static /* synthetic */ Common copy$default(Common common, Labels labels, int i, Object obj) {
        if ((i & 1) != 0) {
            labels = common.labels;
        }
        return common.copy(labels);
    }

    /* renamed from: component1, reason: from getter */
    public final Labels getLabels() {
        return this.labels;
    }

    public final Common copy(Labels labels) {
        Intrinsics.checkNotNullParameter(labels, "labels");
        return new Common(labels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Common) && Intrinsics.areEqual(this.labels, ((Common) other).labels);
    }

    public final Labels getLabels() {
        return this.labels;
    }

    public int hashCode() {
        return this.labels.hashCode();
    }

    public String toString() {
        return "Common(labels=" + this.labels + ")";
    }
}
