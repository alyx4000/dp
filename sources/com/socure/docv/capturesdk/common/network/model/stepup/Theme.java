package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Theme;", "", "primary", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Primary;", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/Primary;)V", "getPrimary", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/Primary;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Theme {
    private final Primary primary;

    public Theme(Primary primary) {
        Intrinsics.checkNotNullParameter(primary, "primary");
        this.primary = primary;
    }

    public static /* synthetic */ Theme copy$default(Theme theme, Primary primary, int i, Object obj) {
        if ((i & 1) != 0) {
            primary = theme.primary;
        }
        return theme.copy(primary);
    }

    /* renamed from: component1, reason: from getter */
    public final Primary getPrimary() {
        return this.primary;
    }

    public final Theme copy(Primary primary) {
        Intrinsics.checkNotNullParameter(primary, "primary");
        return new Theme(primary);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Theme) && Intrinsics.areEqual(this.primary, ((Theme) other).primary);
    }

    public final Primary getPrimary() {
        return this.primary;
    }

    public int hashCode() {
        return this.primary.hashCode();
    }

    public String toString() {
        return "Theme(primary=" + this.primary + ")";
    }
}
