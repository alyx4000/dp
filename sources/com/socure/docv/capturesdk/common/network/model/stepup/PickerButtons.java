package com.socure.docv.capturesdk.common.network.model.stepup;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/PickerButtons;", "", ApiConstant.DOCUMENT_TYPE_LICENSE, "Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", ApiConstant.DOCUMENT_TYPE_PASSPORT, "(Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;)V", "getLicense", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", "getPassport", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class PickerButtons {
    private final Label license;
    private final Label passport;

    public PickerButtons(Label license, Label passport) {
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(passport, "passport");
        this.license = license;
        this.passport = passport;
    }

    public static /* synthetic */ PickerButtons copy$default(PickerButtons pickerButtons, Label label, Label label2, int i, Object obj) {
        if ((i & 1) != 0) {
            label = pickerButtons.license;
        }
        if ((i & 2) != 0) {
            label2 = pickerButtons.passport;
        }
        return pickerButtons.copy(label, label2);
    }

    /* renamed from: component1, reason: from getter */
    public final Label getLicense() {
        return this.license;
    }

    /* renamed from: component2, reason: from getter */
    public final Label getPassport() {
        return this.passport;
    }

    public final PickerButtons copy(Label license, Label passport) {
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(passport, "passport");
        return new PickerButtons(license, passport);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PickerButtons)) {
            return false;
        }
        PickerButtons pickerButtons = (PickerButtons) other;
        return Intrinsics.areEqual(this.license, pickerButtons.license) && Intrinsics.areEqual(this.passport, pickerButtons.passport);
    }

    public final Label getLicense() {
        return this.license;
    }

    public final Label getPassport() {
        return this.passport;
    }

    public int hashCode() {
        return this.passport.hashCode() + (this.license.hashCode() * 31);
    }

    public String toString() {
        return "PickerButtons(license=" + this.license + ", passport=" + this.passport + ")";
    }
}
