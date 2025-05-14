package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Primary;", "", "color", "", "backgroundColor", "button", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Button;", "(Ljava/lang/String;Ljava/lang/String;Lcom/socure/docv/capturesdk/common/network/model/stepup/Button;)V", "getBackgroundColor", "()Ljava/lang/String;", "getButton", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/Button;", "getColor", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Primary {
    private final String backgroundColor;
    private final Button button;
    private final String color;

    public Primary(String color, String backgroundColor, Button button) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(button, "button");
        this.color = color;
        this.backgroundColor = backgroundColor;
        this.button = button;
    }

    public static /* synthetic */ Primary copy$default(Primary primary, String str, String str2, Button button, int i, Object obj) {
        if ((i & 1) != 0) {
            str = primary.color;
        }
        if ((i & 2) != 0) {
            str2 = primary.backgroundColor;
        }
        if ((i & 4) != 0) {
            button = primary.button;
        }
        return primary.copy(str, str2, button);
    }

    /* renamed from: component1, reason: from getter */
    public final String getColor() {
        return this.color;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component3, reason: from getter */
    public final Button getButton() {
        return this.button;
    }

    public final Primary copy(String color, String backgroundColor, Button button) {
        Intrinsics.checkNotNullParameter(color, "color");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(button, "button");
        return new Primary(color, backgroundColor, button);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Primary)) {
            return false;
        }
        Primary primary = (Primary) other;
        return Intrinsics.areEqual(this.color, primary.color) && Intrinsics.areEqual(this.backgroundColor, primary.backgroundColor) && Intrinsics.areEqual(this.button, primary.button);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final Button getButton() {
        return this.button;
    }

    public final String getColor() {
        return this.color;
    }

    public int hashCode() {
        return this.button.hashCode() + com.socure.docv.capturesdk.common.analytics.model.a.a(this.backgroundColor, this.color.hashCode() * 31, 31);
    }

    public String toString() {
        return "Primary(color=" + this.color + ", backgroundColor=" + this.backgroundColor + ", button=" + this.button + ")";
    }
}
