package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/FrontCapture;", "", "header", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", "keepSteadyText", "errorMessageSecondaryText", "manualCapturePrimaryText", "manualCaptureSecondaryText", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;)V", "getErrorMessageSecondaryText", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", "getHeader", "getKeepSteadyText", "getManualCapturePrimaryText", "getManualCaptureSecondaryText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FrontCapture {
    private final Label errorMessageSecondaryText;
    private final Label header;
    private final Label keepSteadyText;
    private final Label manualCapturePrimaryText;
    private final Label manualCaptureSecondaryText;

    public FrontCapture(Label header, Label keepSteadyText, Label errorMessageSecondaryText, Label manualCapturePrimaryText, Label manualCaptureSecondaryText) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(keepSteadyText, "keepSteadyText");
        Intrinsics.checkNotNullParameter(errorMessageSecondaryText, "errorMessageSecondaryText");
        Intrinsics.checkNotNullParameter(manualCapturePrimaryText, "manualCapturePrimaryText");
        Intrinsics.checkNotNullParameter(manualCaptureSecondaryText, "manualCaptureSecondaryText");
        this.header = header;
        this.keepSteadyText = keepSteadyText;
        this.errorMessageSecondaryText = errorMessageSecondaryText;
        this.manualCapturePrimaryText = manualCapturePrimaryText;
        this.manualCaptureSecondaryText = manualCaptureSecondaryText;
    }

    public static /* synthetic */ FrontCapture copy$default(FrontCapture frontCapture, Label label, Label label2, Label label3, Label label4, Label label5, int i, Object obj) {
        if ((i & 1) != 0) {
            label = frontCapture.header;
        }
        if ((i & 2) != 0) {
            label2 = frontCapture.keepSteadyText;
        }
        Label label6 = label2;
        if ((i & 4) != 0) {
            label3 = frontCapture.errorMessageSecondaryText;
        }
        Label label7 = label3;
        if ((i & 8) != 0) {
            label4 = frontCapture.manualCapturePrimaryText;
        }
        Label label8 = label4;
        if ((i & 16) != 0) {
            label5 = frontCapture.manualCaptureSecondaryText;
        }
        return frontCapture.copy(label, label6, label7, label8, label5);
    }

    /* renamed from: component1, reason: from getter */
    public final Label getHeader() {
        return this.header;
    }

    /* renamed from: component2, reason: from getter */
    public final Label getKeepSteadyText() {
        return this.keepSteadyText;
    }

    /* renamed from: component3, reason: from getter */
    public final Label getErrorMessageSecondaryText() {
        return this.errorMessageSecondaryText;
    }

    /* renamed from: component4, reason: from getter */
    public final Label getManualCapturePrimaryText() {
        return this.manualCapturePrimaryText;
    }

    /* renamed from: component5, reason: from getter */
    public final Label getManualCaptureSecondaryText() {
        return this.manualCaptureSecondaryText;
    }

    public final FrontCapture copy(Label header, Label keepSteadyText, Label errorMessageSecondaryText, Label manualCapturePrimaryText, Label manualCaptureSecondaryText) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(keepSteadyText, "keepSteadyText");
        Intrinsics.checkNotNullParameter(errorMessageSecondaryText, "errorMessageSecondaryText");
        Intrinsics.checkNotNullParameter(manualCapturePrimaryText, "manualCapturePrimaryText");
        Intrinsics.checkNotNullParameter(manualCaptureSecondaryText, "manualCaptureSecondaryText");
        return new FrontCapture(header, keepSteadyText, errorMessageSecondaryText, manualCapturePrimaryText, manualCaptureSecondaryText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FrontCapture)) {
            return false;
        }
        FrontCapture frontCapture = (FrontCapture) other;
        return Intrinsics.areEqual(this.header, frontCapture.header) && Intrinsics.areEqual(this.keepSteadyText, frontCapture.keepSteadyText) && Intrinsics.areEqual(this.errorMessageSecondaryText, frontCapture.errorMessageSecondaryText) && Intrinsics.areEqual(this.manualCapturePrimaryText, frontCapture.manualCapturePrimaryText) && Intrinsics.areEqual(this.manualCaptureSecondaryText, frontCapture.manualCaptureSecondaryText);
    }

    public final Label getErrorMessageSecondaryText() {
        return this.errorMessageSecondaryText;
    }

    public final Label getHeader() {
        return this.header;
    }

    public final Label getKeepSteadyText() {
        return this.keepSteadyText;
    }

    public final Label getManualCapturePrimaryText() {
        return this.manualCapturePrimaryText;
    }

    public final Label getManualCaptureSecondaryText() {
        return this.manualCaptureSecondaryText;
    }

    public int hashCode() {
        return this.manualCaptureSecondaryText.hashCode() + ((this.manualCapturePrimaryText.hashCode() + ((this.errorMessageSecondaryText.hashCode() + ((this.keepSteadyText.hashCode() + (this.header.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "FrontCapture(header=" + this.header + ", keepSteadyText=" + this.keepSteadyText + ", errorMessageSecondaryText=" + this.errorMessageSecondaryText + ", manualCapturePrimaryText=" + this.manualCapturePrimaryText + ", manualCaptureSecondaryText=" + this.manualCaptureSecondaryText + ")";
    }
}
