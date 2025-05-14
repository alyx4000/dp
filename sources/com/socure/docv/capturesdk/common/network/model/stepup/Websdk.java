package com.socure.docv.capturesdk.common.network.model.stepup;

import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\u000eHÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003J\t\u0010,\u001a\u00020\u0012HÆ\u0003Ji\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\bHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Websdk;", "", "enableSelfie", "Lcom/socure/docv/capturesdk/common/network/model/stepup/EnableSelfie;", "manualCaptureTimeout", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ManualCaptureTimeout;", "documentTypes", "", "", "ivsMaxSubmitCount", "Lcom/socure/docv/capturesdk/common/network/model/stepup/MaxSubmitCount;", "showCameraPriming", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ShowCameraPriming;", "selfiePitch", "Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;", "selfieRoll", "selfieYaw", "persistCaptureState", "Lcom/socure/docv/capturesdk/common/network/model/stepup/PersistCaptureState;", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/EnableSelfie;Lcom/socure/docv/capturesdk/common/network/model/stepup/ManualCaptureTimeout;Ljava/util/List;Lcom/socure/docv/capturesdk/common/network/model/stepup/MaxSubmitCount;Lcom/socure/docv/capturesdk/common/network/model/stepup/ShowCameraPriming;Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;Lcom/socure/docv/capturesdk/common/network/model/stepup/PersistCaptureState;)V", "getDocumentTypes", "()Ljava/util/List;", "getEnableSelfie", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/EnableSelfie;", "getIvsMaxSubmitCount", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/MaxSubmitCount;", "getManualCaptureTimeout", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/ManualCaptureTimeout;", "getPersistCaptureState", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/PersistCaptureState;", "getSelfiePitch", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;", "getSelfieRoll", "getSelfieYaw", "getShowCameraPriming", "()Lcom/socure/docv/capturesdk/common/network/model/stepup/ShowCameraPriming;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Websdk {
    private final List<String> documentTypes;
    private final EnableSelfie enableSelfie;
    private final MaxSubmitCount ivsMaxSubmitCount;
    private final ManualCaptureTimeout manualCaptureTimeout;
    private final PersistCaptureState persistCaptureState;
    private final MinMax selfiePitch;
    private final MinMax selfieRoll;
    private final MinMax selfieYaw;
    private final ShowCameraPriming showCameraPriming;

    public Websdk(EnableSelfie enableSelfie, ManualCaptureTimeout manualCaptureTimeout, List<String> documentTypes, MaxSubmitCount ivsMaxSubmitCount, ShowCameraPriming showCameraPriming, MinMax selfiePitch, MinMax selfieRoll, MinMax selfieYaw, PersistCaptureState persistCaptureState) {
        Intrinsics.checkNotNullParameter(enableSelfie, "enableSelfie");
        Intrinsics.checkNotNullParameter(manualCaptureTimeout, "manualCaptureTimeout");
        Intrinsics.checkNotNullParameter(documentTypes, "documentTypes");
        Intrinsics.checkNotNullParameter(ivsMaxSubmitCount, "ivsMaxSubmitCount");
        Intrinsics.checkNotNullParameter(showCameraPriming, "showCameraPriming");
        Intrinsics.checkNotNullParameter(selfiePitch, "selfiePitch");
        Intrinsics.checkNotNullParameter(selfieRoll, "selfieRoll");
        Intrinsics.checkNotNullParameter(selfieYaw, "selfieYaw");
        Intrinsics.checkNotNullParameter(persistCaptureState, "persistCaptureState");
        this.enableSelfie = enableSelfie;
        this.manualCaptureTimeout = manualCaptureTimeout;
        this.documentTypes = documentTypes;
        this.ivsMaxSubmitCount = ivsMaxSubmitCount;
        this.showCameraPriming = showCameraPriming;
        this.selfiePitch = selfiePitch;
        this.selfieRoll = selfieRoll;
        this.selfieYaw = selfieYaw;
        this.persistCaptureState = persistCaptureState;
    }

    public /* synthetic */ Websdk(EnableSelfie enableSelfie, ManualCaptureTimeout manualCaptureTimeout, List list, MaxSubmitCount maxSubmitCount, ShowCameraPriming showCameraPriming, MinMax minMax, MinMax minMax2, MinMax minMax3, PersistCaptureState persistCaptureState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(enableSelfie, manualCaptureTimeout, list, (i & 8) != 0 ? new MaxSubmitCount(3) : maxSubmitCount, (i & 16) != 0 ? new ShowCameraPriming(false) : showCameraPriming, (i & 32) != 0 ? UtilsKt.getDefaultSelfieAngleMinMax() : minMax, (i & 64) != 0 ? UtilsKt.getDefaultSelfieAngleMinMax() : minMax2, (i & 128) != 0 ? UtilsKt.getDefaultSelfieAngleMinMax() : minMax3, (i & 256) != 0 ? new PersistCaptureState(false) : persistCaptureState);
    }

    /* renamed from: component1, reason: from getter */
    public final EnableSelfie getEnableSelfie() {
        return this.enableSelfie;
    }

    /* renamed from: component2, reason: from getter */
    public final ManualCaptureTimeout getManualCaptureTimeout() {
        return this.manualCaptureTimeout;
    }

    public final List<String> component3() {
        return this.documentTypes;
    }

    /* renamed from: component4, reason: from getter */
    public final MaxSubmitCount getIvsMaxSubmitCount() {
        return this.ivsMaxSubmitCount;
    }

    /* renamed from: component5, reason: from getter */
    public final ShowCameraPriming getShowCameraPriming() {
        return this.showCameraPriming;
    }

    /* renamed from: component6, reason: from getter */
    public final MinMax getSelfiePitch() {
        return this.selfiePitch;
    }

    /* renamed from: component7, reason: from getter */
    public final MinMax getSelfieRoll() {
        return this.selfieRoll;
    }

    /* renamed from: component8, reason: from getter */
    public final MinMax getSelfieYaw() {
        return this.selfieYaw;
    }

    /* renamed from: component9, reason: from getter */
    public final PersistCaptureState getPersistCaptureState() {
        return this.persistCaptureState;
    }

    public final Websdk copy(EnableSelfie enableSelfie, ManualCaptureTimeout manualCaptureTimeout, List<String> documentTypes, MaxSubmitCount ivsMaxSubmitCount, ShowCameraPriming showCameraPriming, MinMax selfiePitch, MinMax selfieRoll, MinMax selfieYaw, PersistCaptureState persistCaptureState) {
        Intrinsics.checkNotNullParameter(enableSelfie, "enableSelfie");
        Intrinsics.checkNotNullParameter(manualCaptureTimeout, "manualCaptureTimeout");
        Intrinsics.checkNotNullParameter(documentTypes, "documentTypes");
        Intrinsics.checkNotNullParameter(ivsMaxSubmitCount, "ivsMaxSubmitCount");
        Intrinsics.checkNotNullParameter(showCameraPriming, "showCameraPriming");
        Intrinsics.checkNotNullParameter(selfiePitch, "selfiePitch");
        Intrinsics.checkNotNullParameter(selfieRoll, "selfieRoll");
        Intrinsics.checkNotNullParameter(selfieYaw, "selfieYaw");
        Intrinsics.checkNotNullParameter(persistCaptureState, "persistCaptureState");
        return new Websdk(enableSelfie, manualCaptureTimeout, documentTypes, ivsMaxSubmitCount, showCameraPriming, selfiePitch, selfieRoll, selfieYaw, persistCaptureState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Websdk)) {
            return false;
        }
        Websdk websdk = (Websdk) other;
        return Intrinsics.areEqual(this.enableSelfie, websdk.enableSelfie) && Intrinsics.areEqual(this.manualCaptureTimeout, websdk.manualCaptureTimeout) && Intrinsics.areEqual(this.documentTypes, websdk.documentTypes) && Intrinsics.areEqual(this.ivsMaxSubmitCount, websdk.ivsMaxSubmitCount) && Intrinsics.areEqual(this.showCameraPriming, websdk.showCameraPriming) && Intrinsics.areEqual(this.selfiePitch, websdk.selfiePitch) && Intrinsics.areEqual(this.selfieRoll, websdk.selfieRoll) && Intrinsics.areEqual(this.selfieYaw, websdk.selfieYaw) && Intrinsics.areEqual(this.persistCaptureState, websdk.persistCaptureState);
    }

    public final List<String> getDocumentTypes() {
        return this.documentTypes;
    }

    public final EnableSelfie getEnableSelfie() {
        return this.enableSelfie;
    }

    public final MaxSubmitCount getIvsMaxSubmitCount() {
        return this.ivsMaxSubmitCount;
    }

    public final ManualCaptureTimeout getManualCaptureTimeout() {
        return this.manualCaptureTimeout;
    }

    public final PersistCaptureState getPersistCaptureState() {
        return this.persistCaptureState;
    }

    public final MinMax getSelfiePitch() {
        return this.selfiePitch;
    }

    public final MinMax getSelfieRoll() {
        return this.selfieRoll;
    }

    public final MinMax getSelfieYaw() {
        return this.selfieYaw;
    }

    public final ShowCameraPriming getShowCameraPriming() {
        return this.showCameraPriming;
    }

    public int hashCode() {
        return this.persistCaptureState.hashCode() + ((this.selfieYaw.hashCode() + ((this.selfieRoll.hashCode() + ((this.selfiePitch.hashCode() + ((this.showCameraPriming.hashCode() + ((this.ivsMaxSubmitCount.hashCode() + ((this.documentTypes.hashCode() + ((this.manualCaptureTimeout.hashCode() + (this.enableSelfie.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        return "Websdk(enableSelfie=" + this.enableSelfie + ", manualCaptureTimeout=" + this.manualCaptureTimeout + ", documentTypes=" + this.documentTypes + ", ivsMaxSubmitCount=" + this.ivsMaxSubmitCount + ", showCameraPriming=" + this.showCameraPriming + ", selfiePitch=" + this.selfiePitch + ", selfieRoll=" + this.selfieRoll + ", selfieYaw=" + this.selfieYaw + ", persistCaptureState=" + this.persistCaptureState + ")";
    }
}
