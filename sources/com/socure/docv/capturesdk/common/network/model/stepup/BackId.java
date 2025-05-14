package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/BackId;", "", "header", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;)V", "getHeader", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BackId {
    private final Label header;

    public BackId(Label header) {
        Intrinsics.checkNotNullParameter(header, "header");
        this.header = header;
    }

    public static /* synthetic */ BackId copy$default(BackId backId, Label label, int i, Object obj) {
        if ((i & 1) != 0) {
            label = backId.header;
        }
        return backId.copy(label);
    }

    /* renamed from: component1, reason: from getter */
    public final Label getHeader() {
        return this.header;
    }

    public final BackId copy(Label header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return new BackId(header);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BackId) && Intrinsics.areEqual(this.header, ((BackId) other).header);
    }

    public final Label getHeader() {
        return this.header;
    }

    public int hashCode() {
        return this.header.hashCode();
    }

    public String toString() {
        return "BackId(header=" + this.header + ")";
    }
}
