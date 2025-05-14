package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\bp\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0001\u0010\b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\t\u001a\u00020\u0003\u0012\b\b\u0001\u0010\n\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\r\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u001d\u001a\u00020\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010W\u001a\u00020\u0003HÆ\u0003J\t\u0010X\u001a\u00020\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u0003HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0003HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\t\u0010d\u001a\u00020\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0003HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0003HÆ\u0003J\t\u0010q\u001a\u00020\u0003HÆ\u0003J\u0097\u0002\u0010r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00032\b\b\u0003\u0010\u0006\u001a\u00020\u00032\b\b\u0003\u0010\u0007\u001a\u00020\u00032\b\b\u0003\u0010\b\u001a\u00020\u00032\b\b\u0003\u0010\t\u001a\u00020\u00032\b\b\u0003\u0010\n\u001a\u00020\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u00032\b\b\u0003\u0010\f\u001a\u00020\u00032\b\b\u0003\u0010\r\u001a\u00020\u00032\b\b\u0003\u0010\u000e\u001a\u00020\u00032\b\b\u0003\u0010\u000f\u001a\u00020\u00032\b\b\u0003\u0010\u0010\u001a\u00020\u00032\b\b\u0003\u0010\u0011\u001a\u00020\u00032\b\b\u0003\u0010\u0012\u001a\u00020\u00032\b\b\u0003\u0010\u0013\u001a\u00020\u00032\b\b\u0003\u0010\u0014\u001a\u00020\u00032\b\b\u0003\u0010\u0015\u001a\u00020\u00032\b\b\u0003\u0010\u0016\u001a\u00020\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00032\b\b\u0003\u0010\u0018\u001a\u00020\u00032\b\b\u0003\u0010\u0019\u001a\u00020\u00032\b\b\u0003\u0010\u001a\u001a\u00020\u00032\b\b\u0003\u0010\u001b\u001a\u00020\u00032\b\b\u0003\u0010\u001c\u001a\u00020\u00032\b\b\u0003\u0010\u001d\u001a\u00020\u0003HÆ\u0001J\u0013\u0010s\u001a\u00020t2\b\u0010u\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010v\u001a\u00020wHÖ\u0001J\t\u0010x\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u001b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R\u001a\u0010\u0019\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\u0010\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010 \"\u0004\b2\u0010\"R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010 \"\u0004\b6\u0010\"R\u001a\u0010\u0015\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\u001a\u0010\u0016\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010 \"\u0004\b:\u0010\"R\u001a\u0010\u0018\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u001a\u0010\u0011\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010 \"\u0004\b@\u0010\"R\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010 \"\u0004\bB\u0010\"R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010 \"\u0004\bD\u0010\"R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010 \"\u0004\bF\u0010\"R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010 \"\u0004\bH\u0010\"R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010 \"\u0004\bJ\u0010\"R\u001a\u0010\n\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010 \"\u0004\bL\u0010\"R\u001a\u0010\u0013\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010 \"\u0004\bN\u0010\"R\u001a\u0010\u0017\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\"R\u001a\u0010\u001c\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010 \"\u0004\bR\u0010\"R\u001a\u0010\u001d\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010 \"\u0004\bT\u0010\"R\u001a\u0010\u0014\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010 \"\u0004\bV\u0010\"¨\u0006y"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/Accessibility;", "", "holdPhoneFront", "", "alignFaceFrame", "movePhoneRight", "movePhoneLeft", "movePhoneUp", "movePhoneDown", "noCardDetected", "noPassportDetected", "idLookingGood", "faceIsSmall", "movePhoneFrontLowEndDevice", "focusCameraId", "flipIdBarcode", "focusCameraPassport", "movePhoneFront", "frontBackTryPhotoManually", "passportTryPhotoManually", "validatingImage", "idealFace", "initialisingSdk", "processingConsent", "manualBtnContDes", "closeBtnContDes", "helpBtnContDes", "backBtnContDes", "selectCheckBox", "unselectCheckBox", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAlignFaceFrame", "()Ljava/lang/String;", "setAlignFaceFrame", "(Ljava/lang/String;)V", "getBackBtnContDes", "setBackBtnContDes", "getCloseBtnContDes", "setCloseBtnContDes", "getFaceIsSmall", "setFaceIsSmall", "getFlipIdBarcode", "setFlipIdBarcode", "getFocusCameraId", "setFocusCameraId", "getFocusCameraPassport", "setFocusCameraPassport", "getFrontBackTryPhotoManually", "setFrontBackTryPhotoManually", "getHelpBtnContDes", "setHelpBtnContDes", "getHoldPhoneFront", "setHoldPhoneFront", "getIdLookingGood", "setIdLookingGood", "getIdealFace", "setIdealFace", "getInitialisingSdk", "setInitialisingSdk", "getManualBtnContDes", "setManualBtnContDes", "getMovePhoneDown", "setMovePhoneDown", "getMovePhoneFront", "setMovePhoneFront", "getMovePhoneFrontLowEndDevice", "setMovePhoneFrontLowEndDevice", "getMovePhoneLeft", "setMovePhoneLeft", "getMovePhoneRight", "setMovePhoneRight", "getMovePhoneUp", "setMovePhoneUp", "getNoCardDetected", "setNoCardDetected", "getNoPassportDetected", "setNoPassportDetected", "getPassportTryPhotoManually", "setPassportTryPhotoManually", "getProcessingConsent", "setProcessingConsent", "getSelectCheckBox", "setSelectCheckBox", "getUnselectCheckBox", "setUnselectCheckBox", "getValidatingImage", "setValidatingImage", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class Accessibility {
    private String alignFaceFrame;
    private String backBtnContDes;
    private String closeBtnContDes;
    private String faceIsSmall;
    private String flipIdBarcode;
    private String focusCameraId;
    private String focusCameraPassport;
    private String frontBackTryPhotoManually;
    private String helpBtnContDes;
    private String holdPhoneFront;
    private String idLookingGood;
    private String idealFace;
    private String initialisingSdk;
    private String manualBtnContDes;
    private String movePhoneDown;
    private String movePhoneFront;
    private String movePhoneFrontLowEndDevice;
    private String movePhoneLeft;
    private String movePhoneRight;
    private String movePhoneUp;
    private String noCardDetected;
    private String noPassportDetected;
    private String passportTryPhotoManually;
    private String processingConsent;
    private String selectCheckBox;
    private String unselectCheckBox;
    private String validatingImage;

    public Accessibility(@Json(name = "holdPhoneFront") String holdPhoneFront, @Json(name = "alignFaceFrame") String alignFaceFrame, @Json(name = "movePhoneRight") String movePhoneRight, @Json(name = "movePhoneLeft") String movePhoneLeft, @Json(name = "movePhoneUp") String movePhoneUp, @Json(name = "movePhoneDown") String movePhoneDown, @Json(name = "noCardDetected") String noCardDetected, @Json(name = "noPassportDetected") String noPassportDetected, @Json(name = "idLookingGood") String idLookingGood, @Json(name = "faceIsSmall") String faceIsSmall, @Json(name = "movePhoneFrontLowEndDevice") String movePhoneFrontLowEndDevice, @Json(name = "focusCameraId") String focusCameraId, @Json(name = "flipIdBarcode") String flipIdBarcode, @Json(name = "focusCameraPassport") String focusCameraPassport, @Json(name = "movePhoneFront") String movePhoneFront, @Json(name = "frontBackTryPhotoManually") String frontBackTryPhotoManually, @Json(name = "passportTryPhotoManually") String passportTryPhotoManually, @Json(name = "validatingImage") String validatingImage, @Json(name = "idealFace") String idealFace, @Json(name = "initialisingSdk") String initialisingSdk, @Json(name = "processingConsent") String processingConsent, @Json(name = "manualBtnContDes") String manualBtnContDes, @Json(name = "closeBtnContDes") String closeBtnContDes, @Json(name = "helpBtnContDes") String helpBtnContDes, @Json(name = "backBtnContDes") String backBtnContDes, @Json(name = "selectCheckBox") String selectCheckBox, @Json(name = "unselectCheckBox") String unselectCheckBox) {
        Intrinsics.checkNotNullParameter(holdPhoneFront, "holdPhoneFront");
        Intrinsics.checkNotNullParameter(alignFaceFrame, "alignFaceFrame");
        Intrinsics.checkNotNullParameter(movePhoneRight, "movePhoneRight");
        Intrinsics.checkNotNullParameter(movePhoneLeft, "movePhoneLeft");
        Intrinsics.checkNotNullParameter(movePhoneUp, "movePhoneUp");
        Intrinsics.checkNotNullParameter(movePhoneDown, "movePhoneDown");
        Intrinsics.checkNotNullParameter(noCardDetected, "noCardDetected");
        Intrinsics.checkNotNullParameter(noPassportDetected, "noPassportDetected");
        Intrinsics.checkNotNullParameter(idLookingGood, "idLookingGood");
        Intrinsics.checkNotNullParameter(faceIsSmall, "faceIsSmall");
        Intrinsics.checkNotNullParameter(movePhoneFrontLowEndDevice, "movePhoneFrontLowEndDevice");
        Intrinsics.checkNotNullParameter(focusCameraId, "focusCameraId");
        Intrinsics.checkNotNullParameter(flipIdBarcode, "flipIdBarcode");
        Intrinsics.checkNotNullParameter(focusCameraPassport, "focusCameraPassport");
        Intrinsics.checkNotNullParameter(movePhoneFront, "movePhoneFront");
        Intrinsics.checkNotNullParameter(frontBackTryPhotoManually, "frontBackTryPhotoManually");
        Intrinsics.checkNotNullParameter(passportTryPhotoManually, "passportTryPhotoManually");
        Intrinsics.checkNotNullParameter(validatingImage, "validatingImage");
        Intrinsics.checkNotNullParameter(idealFace, "idealFace");
        Intrinsics.checkNotNullParameter(initialisingSdk, "initialisingSdk");
        Intrinsics.checkNotNullParameter(processingConsent, "processingConsent");
        Intrinsics.checkNotNullParameter(manualBtnContDes, "manualBtnContDes");
        Intrinsics.checkNotNullParameter(closeBtnContDes, "closeBtnContDes");
        Intrinsics.checkNotNullParameter(helpBtnContDes, "helpBtnContDes");
        Intrinsics.checkNotNullParameter(backBtnContDes, "backBtnContDes");
        Intrinsics.checkNotNullParameter(selectCheckBox, "selectCheckBox");
        Intrinsics.checkNotNullParameter(unselectCheckBox, "unselectCheckBox");
        this.holdPhoneFront = holdPhoneFront;
        this.alignFaceFrame = alignFaceFrame;
        this.movePhoneRight = movePhoneRight;
        this.movePhoneLeft = movePhoneLeft;
        this.movePhoneUp = movePhoneUp;
        this.movePhoneDown = movePhoneDown;
        this.noCardDetected = noCardDetected;
        this.noPassportDetected = noPassportDetected;
        this.idLookingGood = idLookingGood;
        this.faceIsSmall = faceIsSmall;
        this.movePhoneFrontLowEndDevice = movePhoneFrontLowEndDevice;
        this.focusCameraId = focusCameraId;
        this.flipIdBarcode = flipIdBarcode;
        this.focusCameraPassport = focusCameraPassport;
        this.movePhoneFront = movePhoneFront;
        this.frontBackTryPhotoManually = frontBackTryPhotoManually;
        this.passportTryPhotoManually = passportTryPhotoManually;
        this.validatingImage = validatingImage;
        this.idealFace = idealFace;
        this.initialisingSdk = initialisingSdk;
        this.processingConsent = processingConsent;
        this.manualBtnContDes = manualBtnContDes;
        this.closeBtnContDes = closeBtnContDes;
        this.helpBtnContDes = helpBtnContDes;
        this.backBtnContDes = backBtnContDes;
        this.selectCheckBox = selectCheckBox;
        this.unselectCheckBox = unselectCheckBox;
    }

    /* renamed from: component1, reason: from getter */
    public final String getHoldPhoneFront() {
        return this.holdPhoneFront;
    }

    /* renamed from: component10, reason: from getter */
    public final String getFaceIsSmall() {
        return this.faceIsSmall;
    }

    /* renamed from: component11, reason: from getter */
    public final String getMovePhoneFrontLowEndDevice() {
        return this.movePhoneFrontLowEndDevice;
    }

    /* renamed from: component12, reason: from getter */
    public final String getFocusCameraId() {
        return this.focusCameraId;
    }

    /* renamed from: component13, reason: from getter */
    public final String getFlipIdBarcode() {
        return this.flipIdBarcode;
    }

    /* renamed from: component14, reason: from getter */
    public final String getFocusCameraPassport() {
        return this.focusCameraPassport;
    }

    /* renamed from: component15, reason: from getter */
    public final String getMovePhoneFront() {
        return this.movePhoneFront;
    }

    /* renamed from: component16, reason: from getter */
    public final String getFrontBackTryPhotoManually() {
        return this.frontBackTryPhotoManually;
    }

    /* renamed from: component17, reason: from getter */
    public final String getPassportTryPhotoManually() {
        return this.passportTryPhotoManually;
    }

    /* renamed from: component18, reason: from getter */
    public final String getValidatingImage() {
        return this.validatingImage;
    }

    /* renamed from: component19, reason: from getter */
    public final String getIdealFace() {
        return this.idealFace;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAlignFaceFrame() {
        return this.alignFaceFrame;
    }

    /* renamed from: component20, reason: from getter */
    public final String getInitialisingSdk() {
        return this.initialisingSdk;
    }

    /* renamed from: component21, reason: from getter */
    public final String getProcessingConsent() {
        return this.processingConsent;
    }

    /* renamed from: component22, reason: from getter */
    public final String getManualBtnContDes() {
        return this.manualBtnContDes;
    }

    /* renamed from: component23, reason: from getter */
    public final String getCloseBtnContDes() {
        return this.closeBtnContDes;
    }

    /* renamed from: component24, reason: from getter */
    public final String getHelpBtnContDes() {
        return this.helpBtnContDes;
    }

    /* renamed from: component25, reason: from getter */
    public final String getBackBtnContDes() {
        return this.backBtnContDes;
    }

    /* renamed from: component26, reason: from getter */
    public final String getSelectCheckBox() {
        return this.selectCheckBox;
    }

    /* renamed from: component27, reason: from getter */
    public final String getUnselectCheckBox() {
        return this.unselectCheckBox;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMovePhoneRight() {
        return this.movePhoneRight;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMovePhoneLeft() {
        return this.movePhoneLeft;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMovePhoneUp() {
        return this.movePhoneUp;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMovePhoneDown() {
        return this.movePhoneDown;
    }

    /* renamed from: component7, reason: from getter */
    public final String getNoCardDetected() {
        return this.noCardDetected;
    }

    /* renamed from: component8, reason: from getter */
    public final String getNoPassportDetected() {
        return this.noPassportDetected;
    }

    /* renamed from: component9, reason: from getter */
    public final String getIdLookingGood() {
        return this.idLookingGood;
    }

    public final Accessibility copy(@Json(name = "holdPhoneFront") String holdPhoneFront, @Json(name = "alignFaceFrame") String alignFaceFrame, @Json(name = "movePhoneRight") String movePhoneRight, @Json(name = "movePhoneLeft") String movePhoneLeft, @Json(name = "movePhoneUp") String movePhoneUp, @Json(name = "movePhoneDown") String movePhoneDown, @Json(name = "noCardDetected") String noCardDetected, @Json(name = "noPassportDetected") String noPassportDetected, @Json(name = "idLookingGood") String idLookingGood, @Json(name = "faceIsSmall") String faceIsSmall, @Json(name = "movePhoneFrontLowEndDevice") String movePhoneFrontLowEndDevice, @Json(name = "focusCameraId") String focusCameraId, @Json(name = "flipIdBarcode") String flipIdBarcode, @Json(name = "focusCameraPassport") String focusCameraPassport, @Json(name = "movePhoneFront") String movePhoneFront, @Json(name = "frontBackTryPhotoManually") String frontBackTryPhotoManually, @Json(name = "passportTryPhotoManually") String passportTryPhotoManually, @Json(name = "validatingImage") String validatingImage, @Json(name = "idealFace") String idealFace, @Json(name = "initialisingSdk") String initialisingSdk, @Json(name = "processingConsent") String processingConsent, @Json(name = "manualBtnContDes") String manualBtnContDes, @Json(name = "closeBtnContDes") String closeBtnContDes, @Json(name = "helpBtnContDes") String helpBtnContDes, @Json(name = "backBtnContDes") String backBtnContDes, @Json(name = "selectCheckBox") String selectCheckBox, @Json(name = "unselectCheckBox") String unselectCheckBox) {
        Intrinsics.checkNotNullParameter(holdPhoneFront, "holdPhoneFront");
        Intrinsics.checkNotNullParameter(alignFaceFrame, "alignFaceFrame");
        Intrinsics.checkNotNullParameter(movePhoneRight, "movePhoneRight");
        Intrinsics.checkNotNullParameter(movePhoneLeft, "movePhoneLeft");
        Intrinsics.checkNotNullParameter(movePhoneUp, "movePhoneUp");
        Intrinsics.checkNotNullParameter(movePhoneDown, "movePhoneDown");
        Intrinsics.checkNotNullParameter(noCardDetected, "noCardDetected");
        Intrinsics.checkNotNullParameter(noPassportDetected, "noPassportDetected");
        Intrinsics.checkNotNullParameter(idLookingGood, "idLookingGood");
        Intrinsics.checkNotNullParameter(faceIsSmall, "faceIsSmall");
        Intrinsics.checkNotNullParameter(movePhoneFrontLowEndDevice, "movePhoneFrontLowEndDevice");
        Intrinsics.checkNotNullParameter(focusCameraId, "focusCameraId");
        Intrinsics.checkNotNullParameter(flipIdBarcode, "flipIdBarcode");
        Intrinsics.checkNotNullParameter(focusCameraPassport, "focusCameraPassport");
        Intrinsics.checkNotNullParameter(movePhoneFront, "movePhoneFront");
        Intrinsics.checkNotNullParameter(frontBackTryPhotoManually, "frontBackTryPhotoManually");
        Intrinsics.checkNotNullParameter(passportTryPhotoManually, "passportTryPhotoManually");
        Intrinsics.checkNotNullParameter(validatingImage, "validatingImage");
        Intrinsics.checkNotNullParameter(idealFace, "idealFace");
        Intrinsics.checkNotNullParameter(initialisingSdk, "initialisingSdk");
        Intrinsics.checkNotNullParameter(processingConsent, "processingConsent");
        Intrinsics.checkNotNullParameter(manualBtnContDes, "manualBtnContDes");
        Intrinsics.checkNotNullParameter(closeBtnContDes, "closeBtnContDes");
        Intrinsics.checkNotNullParameter(helpBtnContDes, "helpBtnContDes");
        Intrinsics.checkNotNullParameter(backBtnContDes, "backBtnContDes");
        Intrinsics.checkNotNullParameter(selectCheckBox, "selectCheckBox");
        Intrinsics.checkNotNullParameter(unselectCheckBox, "unselectCheckBox");
        return new Accessibility(holdPhoneFront, alignFaceFrame, movePhoneRight, movePhoneLeft, movePhoneUp, movePhoneDown, noCardDetected, noPassportDetected, idLookingGood, faceIsSmall, movePhoneFrontLowEndDevice, focusCameraId, flipIdBarcode, focusCameraPassport, movePhoneFront, frontBackTryPhotoManually, passportTryPhotoManually, validatingImage, idealFace, initialisingSdk, processingConsent, manualBtnContDes, closeBtnContDes, helpBtnContDes, backBtnContDes, selectCheckBox, unselectCheckBox);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Accessibility)) {
            return false;
        }
        Accessibility accessibility = (Accessibility) other;
        return Intrinsics.areEqual(this.holdPhoneFront, accessibility.holdPhoneFront) && Intrinsics.areEqual(this.alignFaceFrame, accessibility.alignFaceFrame) && Intrinsics.areEqual(this.movePhoneRight, accessibility.movePhoneRight) && Intrinsics.areEqual(this.movePhoneLeft, accessibility.movePhoneLeft) && Intrinsics.areEqual(this.movePhoneUp, accessibility.movePhoneUp) && Intrinsics.areEqual(this.movePhoneDown, accessibility.movePhoneDown) && Intrinsics.areEqual(this.noCardDetected, accessibility.noCardDetected) && Intrinsics.areEqual(this.noPassportDetected, accessibility.noPassportDetected) && Intrinsics.areEqual(this.idLookingGood, accessibility.idLookingGood) && Intrinsics.areEqual(this.faceIsSmall, accessibility.faceIsSmall) && Intrinsics.areEqual(this.movePhoneFrontLowEndDevice, accessibility.movePhoneFrontLowEndDevice) && Intrinsics.areEqual(this.focusCameraId, accessibility.focusCameraId) && Intrinsics.areEqual(this.flipIdBarcode, accessibility.flipIdBarcode) && Intrinsics.areEqual(this.focusCameraPassport, accessibility.focusCameraPassport) && Intrinsics.areEqual(this.movePhoneFront, accessibility.movePhoneFront) && Intrinsics.areEqual(this.frontBackTryPhotoManually, accessibility.frontBackTryPhotoManually) && Intrinsics.areEqual(this.passportTryPhotoManually, accessibility.passportTryPhotoManually) && Intrinsics.areEqual(this.validatingImage, accessibility.validatingImage) && Intrinsics.areEqual(this.idealFace, accessibility.idealFace) && Intrinsics.areEqual(this.initialisingSdk, accessibility.initialisingSdk) && Intrinsics.areEqual(this.processingConsent, accessibility.processingConsent) && Intrinsics.areEqual(this.manualBtnContDes, accessibility.manualBtnContDes) && Intrinsics.areEqual(this.closeBtnContDes, accessibility.closeBtnContDes) && Intrinsics.areEqual(this.helpBtnContDes, accessibility.helpBtnContDes) && Intrinsics.areEqual(this.backBtnContDes, accessibility.backBtnContDes) && Intrinsics.areEqual(this.selectCheckBox, accessibility.selectCheckBox) && Intrinsics.areEqual(this.unselectCheckBox, accessibility.unselectCheckBox);
    }

    public final String getAlignFaceFrame() {
        return this.alignFaceFrame;
    }

    public final String getBackBtnContDes() {
        return this.backBtnContDes;
    }

    public final String getCloseBtnContDes() {
        return this.closeBtnContDes;
    }

    public final String getFaceIsSmall() {
        return this.faceIsSmall;
    }

    public final String getFlipIdBarcode() {
        return this.flipIdBarcode;
    }

    public final String getFocusCameraId() {
        return this.focusCameraId;
    }

    public final String getFocusCameraPassport() {
        return this.focusCameraPassport;
    }

    public final String getFrontBackTryPhotoManually() {
        return this.frontBackTryPhotoManually;
    }

    public final String getHelpBtnContDes() {
        return this.helpBtnContDes;
    }

    public final String getHoldPhoneFront() {
        return this.holdPhoneFront;
    }

    public final String getIdLookingGood() {
        return this.idLookingGood;
    }

    public final String getIdealFace() {
        return this.idealFace;
    }

    public final String getInitialisingSdk() {
        return this.initialisingSdk;
    }

    public final String getManualBtnContDes() {
        return this.manualBtnContDes;
    }

    public final String getMovePhoneDown() {
        return this.movePhoneDown;
    }

    public final String getMovePhoneFront() {
        return this.movePhoneFront;
    }

    public final String getMovePhoneFrontLowEndDevice() {
        return this.movePhoneFrontLowEndDevice;
    }

    public final String getMovePhoneLeft() {
        return this.movePhoneLeft;
    }

    public final String getMovePhoneRight() {
        return this.movePhoneRight;
    }

    public final String getMovePhoneUp() {
        return this.movePhoneUp;
    }

    public final String getNoCardDetected() {
        return this.noCardDetected;
    }

    public final String getNoPassportDetected() {
        return this.noPassportDetected;
    }

    public final String getPassportTryPhotoManually() {
        return this.passportTryPhotoManually;
    }

    public final String getProcessingConsent() {
        return this.processingConsent;
    }

    public final String getSelectCheckBox() {
        return this.selectCheckBox;
    }

    public final String getUnselectCheckBox() {
        return this.unselectCheckBox;
    }

    public final String getValidatingImage() {
        return this.validatingImage;
    }

    public int hashCode() {
        return this.unselectCheckBox.hashCode() + com.socure.docv.capturesdk.common.analytics.model.a.a(this.selectCheckBox, com.socure.docv.capturesdk.common.analytics.model.a.a(this.backBtnContDes, com.socure.docv.capturesdk.common.analytics.model.a.a(this.helpBtnContDes, com.socure.docv.capturesdk.common.analytics.model.a.a(this.closeBtnContDes, com.socure.docv.capturesdk.common.analytics.model.a.a(this.manualBtnContDes, com.socure.docv.capturesdk.common.analytics.model.a.a(this.processingConsent, com.socure.docv.capturesdk.common.analytics.model.a.a(this.initialisingSdk, com.socure.docv.capturesdk.common.analytics.model.a.a(this.idealFace, com.socure.docv.capturesdk.common.analytics.model.a.a(this.validatingImage, com.socure.docv.capturesdk.common.analytics.model.a.a(this.passportTryPhotoManually, com.socure.docv.capturesdk.common.analytics.model.a.a(this.frontBackTryPhotoManually, com.socure.docv.capturesdk.common.analytics.model.a.a(this.movePhoneFront, com.socure.docv.capturesdk.common.analytics.model.a.a(this.focusCameraPassport, com.socure.docv.capturesdk.common.analytics.model.a.a(this.flipIdBarcode, com.socure.docv.capturesdk.common.analytics.model.a.a(this.focusCameraId, com.socure.docv.capturesdk.common.analytics.model.a.a(this.movePhoneFrontLowEndDevice, com.socure.docv.capturesdk.common.analytics.model.a.a(this.faceIsSmall, com.socure.docv.capturesdk.common.analytics.model.a.a(this.idLookingGood, com.socure.docv.capturesdk.common.analytics.model.a.a(this.noPassportDetected, com.socure.docv.capturesdk.common.analytics.model.a.a(this.noCardDetected, com.socure.docv.capturesdk.common.analytics.model.a.a(this.movePhoneDown, com.socure.docv.capturesdk.common.analytics.model.a.a(this.movePhoneUp, com.socure.docv.capturesdk.common.analytics.model.a.a(this.movePhoneLeft, com.socure.docv.capturesdk.common.analytics.model.a.a(this.movePhoneRight, com.socure.docv.capturesdk.common.analytics.model.a.a(this.alignFaceFrame, this.holdPhoneFront.hashCode() * 31, 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31), 31);
    }

    public final void setAlignFaceFrame(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.alignFaceFrame = str;
    }

    public final void setBackBtnContDes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.backBtnContDes = str;
    }

    public final void setCloseBtnContDes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.closeBtnContDes = str;
    }

    public final void setFaceIsSmall(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.faceIsSmall = str;
    }

    public final void setFlipIdBarcode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.flipIdBarcode = str;
    }

    public final void setFocusCameraId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.focusCameraId = str;
    }

    public final void setFocusCameraPassport(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.focusCameraPassport = str;
    }

    public final void setFrontBackTryPhotoManually(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.frontBackTryPhotoManually = str;
    }

    public final void setHelpBtnContDes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.helpBtnContDes = str;
    }

    public final void setHoldPhoneFront(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.holdPhoneFront = str;
    }

    public final void setIdLookingGood(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.idLookingGood = str;
    }

    public final void setIdealFace(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.idealFace = str;
    }

    public final void setInitialisingSdk(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.initialisingSdk = str;
    }

    public final void setManualBtnContDes(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.manualBtnContDes = str;
    }

    public final void setMovePhoneDown(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.movePhoneDown = str;
    }

    public final void setMovePhoneFront(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.movePhoneFront = str;
    }

    public final void setMovePhoneFrontLowEndDevice(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.movePhoneFrontLowEndDevice = str;
    }

    public final void setMovePhoneLeft(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.movePhoneLeft = str;
    }

    public final void setMovePhoneRight(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.movePhoneRight = str;
    }

    public final void setMovePhoneUp(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.movePhoneUp = str;
    }

    public final void setNoCardDetected(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noCardDetected = str;
    }

    public final void setNoPassportDetected(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.noPassportDetected = str;
    }

    public final void setPassportTryPhotoManually(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.passportTryPhotoManually = str;
    }

    public final void setProcessingConsent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.processingConsent = str;
    }

    public final void setSelectCheckBox(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.selectCheckBox = str;
    }

    public final void setUnselectCheckBox(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.unselectCheckBox = str;
    }

    public final void setValidatingImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.validatingImage = str;
    }

    public String toString() {
        return "Accessibility(holdPhoneFront=" + this.holdPhoneFront + ", alignFaceFrame=" + this.alignFaceFrame + ", movePhoneRight=" + this.movePhoneRight + ", movePhoneLeft=" + this.movePhoneLeft + ", movePhoneUp=" + this.movePhoneUp + ", movePhoneDown=" + this.movePhoneDown + ", noCardDetected=" + this.noCardDetected + ", noPassportDetected=" + this.noPassportDetected + ", idLookingGood=" + this.idLookingGood + ", faceIsSmall=" + this.faceIsSmall + ", movePhoneFrontLowEndDevice=" + this.movePhoneFrontLowEndDevice + ", focusCameraId=" + this.focusCameraId + ", flipIdBarcode=" + this.flipIdBarcode + ", focusCameraPassport=" + this.focusCameraPassport + ", movePhoneFront=" + this.movePhoneFront + ", frontBackTryPhotoManually=" + this.frontBackTryPhotoManually + ", passportTryPhotoManually=" + this.passportTryPhotoManually + ", validatingImage=" + this.validatingImage + ", idealFace=" + this.idealFace + ", initialisingSdk=" + this.initialisingSdk + ", processingConsent=" + this.processingConsent + ", manualBtnContDes=" + this.manualBtnContDes + ", closeBtnContDes=" + this.closeBtnContDes + ", helpBtnContDes=" + this.helpBtnContDes + ", backBtnContDes=" + this.backBtnContDes + ", selectCheckBox=" + this.selectCheckBox + ", unselectCheckBox=" + this.unselectCheckBox + ")";
    }
}
