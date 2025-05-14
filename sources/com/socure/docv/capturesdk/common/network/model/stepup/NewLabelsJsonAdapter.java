package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabelsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class NewLabelsJsonAdapter extends JsonAdapter<NewLabels> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public NewLabelsJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("adjustLighting", "alignFaceBox", "alignFaceFrame", "backCapture", "backSideCaptured", "backToScanning", "captureSuccess", "alignDocumentId", "alignDocumentPassport", "ensureIdFocus", "ensurePassportFocus", "faceMustBeVisible", "flipIdBarcode", "flipYourId", "focusCameraId", "focusCameraPassport", "frontCapture", "frontSideCaptured", "greatNowCapture", "holdDevice", "holdPhoneOverId", "holdPhoneOverPassport", "isAllInfoVisible", "isAllInfoVisibleBarcode", "isAllInfoVisiblePassport", "isYourFaceInFrame", "lookDirectly", "makeSureBarcode", "moveCloser", "movePhoneFront", "openPassport", "passportCapture", "passportCaptured", "placeFlatAndHoldId", "placeFlatAndHoldPassport", "placeIdFlat", "retake", "selfieCapture", "selfieCaptured", "toGetStarted", "invalidImage", "submitImageForValidation", "validatingImage", "imageValidated", "processing", "success", "cameraPermissionMsg", "cameraPermissionTitle", "cameraPermissionButton", "backPressWarningMsg", "previewDocSubmit", "previewSelfieSubmit", "faceTooClose", "pleaseWait", "movePhoneBack", "idTooClose", "passportTooClose", "faceNotParallel", "docSelectSubText", "docIdSubText", "docPassportSubText", "docReady", "docCameraPermission");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"adjustLighting\", \"al…\", \"docCameraPermission\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, "adjustLighting", "moshi.adapter(String::cl…,\n      \"adjustLighting\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public NewLabels fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        String str11 = null;
        String str12 = null;
        String str13 = null;
        String str14 = null;
        String str15 = null;
        String str16 = null;
        String str17 = null;
        String str18 = null;
        String str19 = null;
        String str20 = null;
        String str21 = null;
        String str22 = null;
        String str23 = null;
        String str24 = null;
        String str25 = null;
        String str26 = null;
        String str27 = null;
        String str28 = null;
        String str29 = null;
        String str30 = null;
        String str31 = null;
        String str32 = null;
        String str33 = null;
        String str34 = null;
        String str35 = null;
        String str36 = null;
        String str37 = null;
        String str38 = null;
        String str39 = null;
        String str40 = null;
        String str41 = null;
        String str42 = null;
        String str43 = null;
        String str44 = null;
        String str45 = null;
        String str46 = null;
        String str47 = null;
        String str48 = null;
        String str49 = null;
        String str50 = null;
        String str51 = null;
        String str52 = null;
        String str53 = null;
        String str54 = null;
        String str55 = null;
        String str56 = null;
        String str57 = null;
        String str58 = null;
        String str59 = null;
        String str60 = null;
        String str61 = null;
        String str62 = null;
        String str63 = null;
        while (true) {
            String str64 = str12;
            String str65 = str11;
            String str66 = str10;
            String str67 = str9;
            String str68 = str8;
            String str69 = str7;
            String str70 = str6;
            String str71 = str5;
            String str72 = str4;
            String str73 = str3;
            String str74 = str2;
            String str75 = str;
            if (!reader.hasNext()) {
                reader.endObject();
                if (str75 == null) {
                    JsonDataException missingProperty = Util.missingProperty("adjustLighting", "adjustLighting", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"adjustL…\"adjustLighting\", reader)");
                    throw missingProperty;
                }
                if (str74 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("alignFaceBox", "alignFaceBox", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"alignFa…Box\",\n            reader)");
                    throw missingProperty2;
                }
                if (str73 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("alignFaceFrame", "alignFaceFrame", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"alignFa…\"alignFaceFrame\", reader)");
                    throw missingProperty3;
                }
                if (str72 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("backCapture", "backCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"backCap…ure\",\n            reader)");
                    throw missingProperty4;
                }
                if (str71 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("backSideCaptured", "backSideCaptured", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"backSid…ackSideCaptured\", reader)");
                    throw missingProperty5;
                }
                if (str70 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("backToScanning", "backToScanning", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"backToS…\"backToScanning\", reader)");
                    throw missingProperty6;
                }
                if (str69 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("captureSuccess", "captureSuccess", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"capture…\"captureSuccess\", reader)");
                    throw missingProperty7;
                }
                if (str68 == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("alignDocumentId", "alignDocumentId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"alignDo…alignDocumentId\", reader)");
                    throw missingProperty8;
                }
                if (str67 == null) {
                    JsonDataException missingProperty9 = Util.missingProperty("alignDocumentPassport", "alignDocumentPassport", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty9, "missingProperty(\"alignDo…ocumentPassport\", reader)");
                    throw missingProperty9;
                }
                if (str66 == null) {
                    JsonDataException missingProperty10 = Util.missingProperty("ensureIdFocus", "ensureIdFocus", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty10, "missingProperty(\"ensureI… \"ensureIdFocus\", reader)");
                    throw missingProperty10;
                }
                if (str65 == null) {
                    JsonDataException missingProperty11 = Util.missingProperty("ensurePassportFocus", "ensurePassportFocus", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty11, "missingProperty(\"ensureP…rePassportFocus\", reader)");
                    throw missingProperty11;
                }
                if (str64 == null) {
                    JsonDataException missingProperty12 = Util.missingProperty("faceMustBeVisible", "faceMustBeVisible", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty12, "missingProperty(\"faceMus…ceMustBeVisible\", reader)");
                    throw missingProperty12;
                }
                if (str13 == null) {
                    JsonDataException missingProperty13 = Util.missingProperty("flipIdBarcode", "flipIdBarcode", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty13, "missingProperty(\"flipIdB… \"flipIdBarcode\", reader)");
                    throw missingProperty13;
                }
                if (str14 == null) {
                    JsonDataException missingProperty14 = Util.missingProperty("flipYourId", "flipYourId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty14, "missingProperty(\"flipYou…d\", \"flipYourId\", reader)");
                    throw missingProperty14;
                }
                if (str15 == null) {
                    JsonDataException missingProperty15 = Util.missingProperty("focusCameraId", "focusCameraId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty15, "missingProperty(\"focusCa… \"focusCameraId\", reader)");
                    throw missingProperty15;
                }
                if (str16 == null) {
                    JsonDataException missingProperty16 = Util.missingProperty("focusCameraPassport", "focusCameraPassport", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty16, "missingProperty(\"focusCa…sCameraPassport\", reader)");
                    throw missingProperty16;
                }
                if (str17 == null) {
                    JsonDataException missingProperty17 = Util.missingProperty("frontCapture", "frontCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty17, "missingProperty(\"frontCa…ure\",\n            reader)");
                    throw missingProperty17;
                }
                if (str18 == null) {
                    JsonDataException missingProperty18 = Util.missingProperty("frontSideCaptured", "frontSideCaptured", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty18, "missingProperty(\"frontSi…ontSideCaptured\", reader)");
                    throw missingProperty18;
                }
                if (str19 == null) {
                    JsonDataException missingProperty19 = Util.missingProperty("greatNowCapture", "greatNowCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty19, "missingProperty(\"greatNo…greatNowCapture\", reader)");
                    throw missingProperty19;
                }
                if (str20 == null) {
                    JsonDataException missingProperty20 = Util.missingProperty("holdDevice", "holdDevice", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty20, "missingProperty(\"holdDev…e\", \"holdDevice\", reader)");
                    throw missingProperty20;
                }
                if (str21 == null) {
                    JsonDataException missingProperty21 = Util.missingProperty("holdPhoneOverId", "holdPhoneOverId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty21, "missingProperty(\"holdPho…holdPhoneOverId\", reader)");
                    throw missingProperty21;
                }
                if (str22 == null) {
                    JsonDataException missingProperty22 = Util.missingProperty("holdPhoneOverPassport", "holdPhoneOverPassport", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty22, "missingProperty(\"holdPho…oneOverPassport\", reader)");
                    throw missingProperty22;
                }
                if (str23 == null) {
                    JsonDataException missingProperty23 = Util.missingProperty("isAllInfoVisible", "isAllInfoVisible", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty23, "missingProperty(\"isAllIn…sAllInfoVisible\", reader)");
                    throw missingProperty23;
                }
                if (str24 == null) {
                    JsonDataException missingProperty24 = Util.missingProperty("isAllInfoVisibleBarcode", "isAllInfoVisibleBarcode", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty24, "missingProperty(\"isAllIn…ode\",\n            reader)");
                    throw missingProperty24;
                }
                if (str25 == null) {
                    JsonDataException missingProperty25 = Util.missingProperty("isAllInfoVisiblePassport", "isAllInfoVisiblePassport", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty25, "missingProperty(\"isAllIn…ort\",\n            reader)");
                    throw missingProperty25;
                }
                if (str26 == null) {
                    JsonDataException missingProperty26 = Util.missingProperty("isYourFaceInFrame", "isYourFaceInFrame", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty26, "missingProperty(\"isYourF…YourFaceInFrame\", reader)");
                    throw missingProperty26;
                }
                if (str27 == null) {
                    JsonDataException missingProperty27 = Util.missingProperty("lookDirectly", "lookDirectly", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty27, "missingProperty(\"lookDir…tly\",\n            reader)");
                    throw missingProperty27;
                }
                if (str28 == null) {
                    JsonDataException missingProperty28 = Util.missingProperty("makeSureBarcode", "makeSureBarcode", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty28, "missingProperty(\"makeSur…makeSureBarcode\", reader)");
                    throw missingProperty28;
                }
                if (str29 == null) {
                    JsonDataException missingProperty29 = Util.missingProperty("moveCloser", "moveCloser", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty29, "missingProperty(\"moveClo…r\", \"moveCloser\", reader)");
                    throw missingProperty29;
                }
                if (str30 == null) {
                    JsonDataException missingProperty30 = Util.missingProperty("movePhoneFront", "movePhoneFront", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty30, "missingProperty(\"movePho…\"movePhoneFront\", reader)");
                    throw missingProperty30;
                }
                if (str31 == null) {
                    JsonDataException missingProperty31 = Util.missingProperty("openPassport", "openPassport", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty31, "missingProperty(\"openPas…ort\",\n            reader)");
                    throw missingProperty31;
                }
                if (str32 == null) {
                    JsonDataException missingProperty32 = Util.missingProperty("passportCapture", "passportCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty32, "missingProperty(\"passpor…passportCapture\", reader)");
                    throw missingProperty32;
                }
                if (str33 == null) {
                    JsonDataException missingProperty33 = Util.missingProperty("passportCaptured", "passportCaptured", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty33, "missingProperty(\"passpor…assportCaptured\", reader)");
                    throw missingProperty33;
                }
                if (str34 == null) {
                    JsonDataException missingProperty34 = Util.missingProperty("placeFlatAndHoldId", "placeFlatAndHoldId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty34, "missingProperty(\"placeFl…ceFlatAndHoldId\", reader)");
                    throw missingProperty34;
                }
                if (str35 == null) {
                    JsonDataException missingProperty35 = Util.missingProperty("placeFlatAndHoldPassport", "placeFlatAndHoldPassport", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty35, "missingProperty(\"placeFl…ort\",\n            reader)");
                    throw missingProperty35;
                }
                if (str36 == null) {
                    JsonDataException missingProperty36 = Util.missingProperty("placeIdFlat", "placeIdFlat", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty36, "missingProperty(\"placeId…lat\",\n            reader)");
                    throw missingProperty36;
                }
                if (str37 == null) {
                    JsonDataException missingProperty37 = Util.missingProperty("retake", "retake", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty37, "missingProperty(\"retake\", \"retake\", reader)");
                    throw missingProperty37;
                }
                if (str38 == null) {
                    JsonDataException missingProperty38 = Util.missingProperty("selfieCapture", "selfieCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty38, "missingProperty(\"selfieC… \"selfieCapture\", reader)");
                    throw missingProperty38;
                }
                if (str39 == null) {
                    JsonDataException missingProperty39 = Util.missingProperty("selfieCaptured", "selfieCaptured", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty39, "missingProperty(\"selfieC…\"selfieCaptured\", reader)");
                    throw missingProperty39;
                }
                if (str40 == null) {
                    JsonDataException missingProperty40 = Util.missingProperty("toGetStarted", "toGetStarted", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty40, "missingProperty(\"toGetSt…ted\",\n            reader)");
                    throw missingProperty40;
                }
                if (str41 == null) {
                    JsonDataException missingProperty41 = Util.missingProperty("invalidImage", "invalidImage", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty41, "missingProperty(\"invalid…age\",\n            reader)");
                    throw missingProperty41;
                }
                if (str42 == null) {
                    JsonDataException missingProperty42 = Util.missingProperty("submitImageForValidation", "submitImageForValidation", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty42, "missingProperty(\"submitI…ion\",\n            reader)");
                    throw missingProperty42;
                }
                if (str43 == null) {
                    JsonDataException missingProperty43 = Util.missingProperty("validatingImage", "validatingImage", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty43, "missingProperty(\"validat…validatingImage\", reader)");
                    throw missingProperty43;
                }
                if (str44 == null) {
                    JsonDataException missingProperty44 = Util.missingProperty("imageValidated", "imageValidated", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty44, "missingProperty(\"imageVa…\"imageValidated\", reader)");
                    throw missingProperty44;
                }
                if (str45 == null) {
                    JsonDataException missingProperty45 = Util.missingProperty("processing", "processing", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty45, "missingProperty(\"process…g\", \"processing\", reader)");
                    throw missingProperty45;
                }
                if (str46 == null) {
                    JsonDataException missingProperty46 = Util.missingProperty("success", "success", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty46, "missingProperty(\"success\", \"success\", reader)");
                    throw missingProperty46;
                }
                if (str47 == null) {
                    JsonDataException missingProperty47 = Util.missingProperty("cameraPermissionMsg", "cameraPermissionMsg", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty47, "missingProperty(\"cameraP…raPermissionMsg\", reader)");
                    throw missingProperty47;
                }
                if (str48 == null) {
                    JsonDataException missingProperty48 = Util.missingProperty("cameraPermissionTitle", "cameraPermissionTitle", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty48, "missingProperty(\"cameraP…PermissionTitle\", reader)");
                    throw missingProperty48;
                }
                if (str49 == null) {
                    JsonDataException missingProperty49 = Util.missingProperty("cameraPermissionButton", "cameraPermissionButton", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty49, "missingProperty(\"cameraP…ermissionButton\", reader)");
                    throw missingProperty49;
                }
                if (str50 == null) {
                    JsonDataException missingProperty50 = Util.missingProperty("backPressWarningMsg", "backPressWarningMsg", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty50, "missingProperty(\"backPre…PressWarningMsg\", reader)");
                    throw missingProperty50;
                }
                if (str51 == null) {
                    JsonDataException missingProperty51 = Util.missingProperty("previewDocSubmit", "previewDocSubmit", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty51, "missingProperty(\"preview…reviewDocSubmit\", reader)");
                    throw missingProperty51;
                }
                if (str52 == null) {
                    JsonDataException missingProperty52 = Util.missingProperty("previewSelfieSubmit", "previewSelfieSubmit", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty52, "missingProperty(\"preview…iewSelfieSubmit\", reader)");
                    throw missingProperty52;
                }
                if (str53 == null) {
                    JsonDataException missingProperty53 = Util.missingProperty("faceTooClose", "faceTooClose", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty53, "missingProperty(\"faceToo…ose\",\n            reader)");
                    throw missingProperty53;
                }
                if (str54 == null) {
                    JsonDataException missingProperty54 = Util.missingProperty("pleaseWait", "pleaseWait", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty54, "missingProperty(\"pleaseW…t\", \"pleaseWait\", reader)");
                    throw missingProperty54;
                }
                if (str55 == null) {
                    JsonDataException missingProperty55 = Util.missingProperty("movePhoneBack", "movePhoneBack", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty55, "missingProperty(\"movePho… \"movePhoneBack\", reader)");
                    throw missingProperty55;
                }
                if (str56 == null) {
                    JsonDataException missingProperty56 = Util.missingProperty("idTooClose", "idTooClose", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty56, "missingProperty(\"idTooCl…e\", \"idTooClose\", reader)");
                    throw missingProperty56;
                }
                if (str57 == null) {
                    JsonDataException missingProperty57 = Util.missingProperty("passportTooClose", "passportTooClose", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty57, "missingProperty(\"passpor…assportTooClose\", reader)");
                    throw missingProperty57;
                }
                if (str58 == null) {
                    JsonDataException missingProperty58 = Util.missingProperty("faceNotParallel", "faceNotParallel", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty58, "missingProperty(\"faceNot…faceNotParallel\", reader)");
                    throw missingProperty58;
                }
                if (str59 == null) {
                    JsonDataException missingProperty59 = Util.missingProperty("docSelectSubText", "docSelectSubText", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty59, "missingProperty(\"docSele…ocSelectSubText\", reader)");
                    throw missingProperty59;
                }
                if (str60 == null) {
                    JsonDataException missingProperty60 = Util.missingProperty("docIdSubText", "docIdSubText", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty60, "missingProperty(\"docIdSu…ext\",\n            reader)");
                    throw missingProperty60;
                }
                if (str61 == null) {
                    JsonDataException missingProperty61 = Util.missingProperty("docPassportSubText", "docPassportSubText", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty61, "missingProperty(\"docPass…PassportSubText\", reader)");
                    throw missingProperty61;
                }
                if (str62 == null) {
                    JsonDataException missingProperty62 = Util.missingProperty("docReady", "docReady", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty62, "missingProperty(\"docReady\", \"docReady\", reader)");
                    throw missingProperty62;
                }
                if (str63 != null) {
                    return new NewLabels(str75, str74, str73, str72, str71, str70, str69, str68, str67, str66, str65, str64, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, str30, str31, str32, str33, str34, str35, str36, str37, str38, str39, str40, str41, str42, str43, str44, str45, str46, str47, str48, str49, str50, str51, str52, str53, str54, str55, str56, str57, str58, str59, str60, str61, str62, str63);
                }
                JsonDataException missingProperty63 = Util.missingProperty("docCameraPermission", "docCameraPermission", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty63, "missingProperty(\"docCame…ameraPermission\", reader)");
                throw missingProperty63;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 0:
                    String fromJson = this.stringAdapter.fromJson(reader);
                    if (fromJson == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("adjustLighting", "adjustLighting", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"adjustLi…\"adjustLighting\", reader)");
                        throw unexpectedNull;
                    }
                    str = fromJson;
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("alignFaceBox", "alignFaceBox", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"alignFac…, \"alignFaceBox\", reader)");
                        throw unexpectedNull2;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str = str75;
                case 2:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("alignFaceFrame", "alignFaceFrame", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"alignFac…\"alignFaceFrame\", reader)");
                        throw unexpectedNull3;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str2 = str74;
                    str = str75;
                case 3:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("backCapture", "backCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"backCapt…\", \"backCapture\", reader)");
                        throw unexpectedNull4;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 4:
                    str5 = this.stringAdapter.fromJson(reader);
                    if (str5 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("backSideCaptured", "backSideCaptured", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"backSide…ackSideCaptured\", reader)");
                        throw unexpectedNull5;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 5:
                    str6 = this.stringAdapter.fromJson(reader);
                    if (str6 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("backToScanning", "backToScanning", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"backToSc…\"backToScanning\", reader)");
                        throw unexpectedNull6;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 6:
                    str7 = this.stringAdapter.fromJson(reader);
                    if (str7 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("captureSuccess", "captureSuccess", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"captureS…\"captureSuccess\", reader)");
                        throw unexpectedNull7;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 7:
                    str8 = this.stringAdapter.fromJson(reader);
                    if (str8 == null) {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("alignDocumentId", "alignDocumentId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"alignDoc…alignDocumentId\", reader)");
                        throw unexpectedNull8;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 8:
                    str9 = this.stringAdapter.fromJson(reader);
                    if (str9 == null) {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("alignDocumentPassport", "alignDocumentPassport", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"alignDoc…ocumentPassport\", reader)");
                        throw unexpectedNull9;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 9:
                    str10 = this.stringAdapter.fromJson(reader);
                    if (str10 == null) {
                        JsonDataException unexpectedNull10 = Util.unexpectedNull("ensureIdFocus", "ensureIdFocus", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull10, "unexpectedNull(\"ensureId… \"ensureIdFocus\", reader)");
                        throw unexpectedNull10;
                    }
                    str12 = str64;
                    str11 = str65;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 10:
                    str11 = this.stringAdapter.fromJson(reader);
                    if (str11 == null) {
                        JsonDataException unexpectedNull11 = Util.unexpectedNull("ensurePassportFocus", "ensurePassportFocus", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull11, "unexpectedNull(\"ensurePa…rePassportFocus\", reader)");
                        throw unexpectedNull11;
                    }
                    str12 = str64;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 11:
                    str12 = this.stringAdapter.fromJson(reader);
                    if (str12 == null) {
                        JsonDataException unexpectedNull12 = Util.unexpectedNull("faceMustBeVisible", "faceMustBeVisible", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull12, "unexpectedNull(\"faceMust…ceMustBeVisible\", reader)");
                        throw unexpectedNull12;
                    }
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 12:
                    str13 = this.stringAdapter.fromJson(reader);
                    if (str13 == null) {
                        JsonDataException unexpectedNull13 = Util.unexpectedNull("flipIdBarcode", "flipIdBarcode", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull13, "unexpectedNull(\"flipIdBa… \"flipIdBarcode\", reader)");
                        throw unexpectedNull13;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 13:
                    str14 = this.stringAdapter.fromJson(reader);
                    if (str14 == null) {
                        JsonDataException unexpectedNull14 = Util.unexpectedNull("flipYourId", "flipYourId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull14, "unexpectedNull(\"flipYour…    \"flipYourId\", reader)");
                        throw unexpectedNull14;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 14:
                    str15 = this.stringAdapter.fromJson(reader);
                    if (str15 == null) {
                        JsonDataException unexpectedNull15 = Util.unexpectedNull("focusCameraId", "focusCameraId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull15, "unexpectedNull(\"focusCam… \"focusCameraId\", reader)");
                        throw unexpectedNull15;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 15:
                    str16 = this.stringAdapter.fromJson(reader);
                    if (str16 == null) {
                        JsonDataException unexpectedNull16 = Util.unexpectedNull("focusCameraPassport", "focusCameraPassport", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull16, "unexpectedNull(\"focusCam…sCameraPassport\", reader)");
                        throw unexpectedNull16;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 16:
                    str17 = this.stringAdapter.fromJson(reader);
                    if (str17 == null) {
                        JsonDataException unexpectedNull17 = Util.unexpectedNull("frontCapture", "frontCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull17, "unexpectedNull(\"frontCap…, \"frontCapture\", reader)");
                        throw unexpectedNull17;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 17:
                    str18 = this.stringAdapter.fromJson(reader);
                    if (str18 == null) {
                        JsonDataException unexpectedNull18 = Util.unexpectedNull("frontSideCaptured", "frontSideCaptured", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull18, "unexpectedNull(\"frontSid…ontSideCaptured\", reader)");
                        throw unexpectedNull18;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 18:
                    str19 = this.stringAdapter.fromJson(reader);
                    if (str19 == null) {
                        JsonDataException unexpectedNull19 = Util.unexpectedNull("greatNowCapture", "greatNowCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull19, "unexpectedNull(\"greatNow…greatNowCapture\", reader)");
                        throw unexpectedNull19;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 19:
                    str20 = this.stringAdapter.fromJson(reader);
                    if (str20 == null) {
                        JsonDataException unexpectedNull20 = Util.unexpectedNull("holdDevice", "holdDevice", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull20, "unexpectedNull(\"holdDevi…    \"holdDevice\", reader)");
                        throw unexpectedNull20;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 20:
                    str21 = this.stringAdapter.fromJson(reader);
                    if (str21 == null) {
                        JsonDataException unexpectedNull21 = Util.unexpectedNull("holdPhoneOverId", "holdPhoneOverId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull21, "unexpectedNull(\"holdPhon…holdPhoneOverId\", reader)");
                        throw unexpectedNull21;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 21:
                    str22 = this.stringAdapter.fromJson(reader);
                    if (str22 == null) {
                        JsonDataException unexpectedNull22 = Util.unexpectedNull("holdPhoneOverPassport", "holdPhoneOverPassport", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull22, "unexpectedNull(\"holdPhon…oneOverPassport\", reader)");
                        throw unexpectedNull22;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 22:
                    str23 = this.stringAdapter.fromJson(reader);
                    if (str23 == null) {
                        JsonDataException unexpectedNull23 = Util.unexpectedNull("isAllInfoVisible", "isAllInfoVisible", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull23, "unexpectedNull(\"isAllInf…sAllInfoVisible\", reader)");
                        throw unexpectedNull23;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 23:
                    str24 = this.stringAdapter.fromJson(reader);
                    if (str24 == null) {
                        JsonDataException unexpectedNull24 = Util.unexpectedNull("isAllInfoVisibleBarcode", "isAllInfoVisibleBarcode", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull24, "unexpectedNull(\"isAllInf…oVisibleBarcode\", reader)");
                        throw unexpectedNull24;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 24:
                    str25 = this.stringAdapter.fromJson(reader);
                    if (str25 == null) {
                        JsonDataException unexpectedNull25 = Util.unexpectedNull("isAllInfoVisiblePassport", "isAllInfoVisiblePassport", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull25, "unexpectedNull(\"isAllInf…ort\",\n            reader)");
                        throw unexpectedNull25;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 25:
                    str26 = this.stringAdapter.fromJson(reader);
                    if (str26 == null) {
                        JsonDataException unexpectedNull26 = Util.unexpectedNull("isYourFaceInFrame", "isYourFaceInFrame", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull26, "unexpectedNull(\"isYourFa…YourFaceInFrame\", reader)");
                        throw unexpectedNull26;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 26:
                    str27 = this.stringAdapter.fromJson(reader);
                    if (str27 == null) {
                        JsonDataException unexpectedNull27 = Util.unexpectedNull("lookDirectly", "lookDirectly", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull27, "unexpectedNull(\"lookDire…, \"lookDirectly\", reader)");
                        throw unexpectedNull27;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 27:
                    str28 = this.stringAdapter.fromJson(reader);
                    if (str28 == null) {
                        JsonDataException unexpectedNull28 = Util.unexpectedNull("makeSureBarcode", "makeSureBarcode", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull28, "unexpectedNull(\"makeSure…makeSureBarcode\", reader)");
                        throw unexpectedNull28;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 28:
                    str29 = this.stringAdapter.fromJson(reader);
                    if (str29 == null) {
                        JsonDataException unexpectedNull29 = Util.unexpectedNull("moveCloser", "moveCloser", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull29, "unexpectedNull(\"moveClos…    \"moveCloser\", reader)");
                        throw unexpectedNull29;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 29:
                    str30 = this.stringAdapter.fromJson(reader);
                    if (str30 == null) {
                        JsonDataException unexpectedNull30 = Util.unexpectedNull("movePhoneFront", "movePhoneFront", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull30, "unexpectedNull(\"movePhon…\"movePhoneFront\", reader)");
                        throw unexpectedNull30;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 30:
                    str31 = this.stringAdapter.fromJson(reader);
                    if (str31 == null) {
                        JsonDataException unexpectedNull31 = Util.unexpectedNull("openPassport", "openPassport", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull31, "unexpectedNull(\"openPass…, \"openPassport\", reader)");
                        throw unexpectedNull31;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 31:
                    str32 = this.stringAdapter.fromJson(reader);
                    if (str32 == null) {
                        JsonDataException unexpectedNull32 = Util.unexpectedNull("passportCapture", "passportCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull32, "unexpectedNull(\"passport…passportCapture\", reader)");
                        throw unexpectedNull32;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 32:
                    str33 = this.stringAdapter.fromJson(reader);
                    if (str33 == null) {
                        JsonDataException unexpectedNull33 = Util.unexpectedNull("passportCaptured", "passportCaptured", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull33, "unexpectedNull(\"passport…assportCaptured\", reader)");
                        throw unexpectedNull33;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 33:
                    str34 = this.stringAdapter.fromJson(reader);
                    if (str34 == null) {
                        JsonDataException unexpectedNull34 = Util.unexpectedNull("placeFlatAndHoldId", "placeFlatAndHoldId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull34, "unexpectedNull(\"placeFla…ceFlatAndHoldId\", reader)");
                        throw unexpectedNull34;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 34:
                    str35 = this.stringAdapter.fromJson(reader);
                    if (str35 == null) {
                        JsonDataException unexpectedNull35 = Util.unexpectedNull("placeFlatAndHoldPassport", "placeFlatAndHoldPassport", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull35, "unexpectedNull(\"placeFla…ort\",\n            reader)");
                        throw unexpectedNull35;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 35:
                    str36 = this.stringAdapter.fromJson(reader);
                    if (str36 == null) {
                        JsonDataException unexpectedNull36 = Util.unexpectedNull("placeIdFlat", "placeIdFlat", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull36, "unexpectedNull(\"placeIdF…\", \"placeIdFlat\", reader)");
                        throw unexpectedNull36;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 36:
                    str37 = this.stringAdapter.fromJson(reader);
                    if (str37 == null) {
                        JsonDataException unexpectedNull37 = Util.unexpectedNull("retake", "retake", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull37, "unexpectedNull(\"retake\",…        \"retake\", reader)");
                        throw unexpectedNull37;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 37:
                    str38 = this.stringAdapter.fromJson(reader);
                    if (str38 == null) {
                        JsonDataException unexpectedNull38 = Util.unexpectedNull("selfieCapture", "selfieCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull38, "unexpectedNull(\"selfieCa… \"selfieCapture\", reader)");
                        throw unexpectedNull38;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 38:
                    str39 = this.stringAdapter.fromJson(reader);
                    if (str39 == null) {
                        JsonDataException unexpectedNull39 = Util.unexpectedNull("selfieCaptured", "selfieCaptured", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull39, "unexpectedNull(\"selfieCa…\"selfieCaptured\", reader)");
                        throw unexpectedNull39;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 39:
                    str40 = this.stringAdapter.fromJson(reader);
                    if (str40 == null) {
                        JsonDataException unexpectedNull40 = Util.unexpectedNull("toGetStarted", "toGetStarted", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull40, "unexpectedNull(\"toGetSta…, \"toGetStarted\", reader)");
                        throw unexpectedNull40;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 40:
                    str41 = this.stringAdapter.fromJson(reader);
                    if (str41 == null) {
                        JsonDataException unexpectedNull41 = Util.unexpectedNull("invalidImage", "invalidImage", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull41, "unexpectedNull(\"invalidI…, \"invalidImage\", reader)");
                        throw unexpectedNull41;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 41:
                    str42 = this.stringAdapter.fromJson(reader);
                    if (str42 == null) {
                        JsonDataException unexpectedNull42 = Util.unexpectedNull("submitImageForValidation", "submitImageForValidation", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull42, "unexpectedNull(\"submitIm…ion\",\n            reader)");
                        throw unexpectedNull42;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 42:
                    str43 = this.stringAdapter.fromJson(reader);
                    if (str43 == null) {
                        JsonDataException unexpectedNull43 = Util.unexpectedNull("validatingImage", "validatingImage", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull43, "unexpectedNull(\"validati…validatingImage\", reader)");
                        throw unexpectedNull43;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 43:
                    str44 = this.stringAdapter.fromJson(reader);
                    if (str44 == null) {
                        JsonDataException unexpectedNull44 = Util.unexpectedNull("imageValidated", "imageValidated", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull44, "unexpectedNull(\"imageVal…\"imageValidated\", reader)");
                        throw unexpectedNull44;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 44:
                    str45 = this.stringAdapter.fromJson(reader);
                    if (str45 == null) {
                        JsonDataException unexpectedNull45 = Util.unexpectedNull("processing", "processing", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull45, "unexpectedNull(\"processi…    \"processing\", reader)");
                        throw unexpectedNull45;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 45:
                    str46 = this.stringAdapter.fromJson(reader);
                    if (str46 == null) {
                        JsonDataException unexpectedNull46 = Util.unexpectedNull("success", "success", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull46, "unexpectedNull(\"success\"…       \"success\", reader)");
                        throw unexpectedNull46;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 46:
                    str47 = this.stringAdapter.fromJson(reader);
                    if (str47 == null) {
                        JsonDataException unexpectedNull47 = Util.unexpectedNull("cameraPermissionMsg", "cameraPermissionMsg", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull47, "unexpectedNull(\"cameraPe…raPermissionMsg\", reader)");
                        throw unexpectedNull47;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 47:
                    str48 = this.stringAdapter.fromJson(reader);
                    if (str48 == null) {
                        JsonDataException unexpectedNull48 = Util.unexpectedNull("cameraPermissionTitle", "cameraPermissionTitle", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull48, "unexpectedNull(\"cameraPe…PermissionTitle\", reader)");
                        throw unexpectedNull48;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 48:
                    str49 = this.stringAdapter.fromJson(reader);
                    if (str49 == null) {
                        JsonDataException unexpectedNull49 = Util.unexpectedNull("cameraPermissionButton", "cameraPermissionButton", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull49, "unexpectedNull(\"cameraPe…ermissionButton\", reader)");
                        throw unexpectedNull49;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 49:
                    str50 = this.stringAdapter.fromJson(reader);
                    if (str50 == null) {
                        JsonDataException unexpectedNull50 = Util.unexpectedNull("backPressWarningMsg", "backPressWarningMsg", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull50, "unexpectedNull(\"backPres…PressWarningMsg\", reader)");
                        throw unexpectedNull50;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 50:
                    str51 = this.stringAdapter.fromJson(reader);
                    if (str51 == null) {
                        JsonDataException unexpectedNull51 = Util.unexpectedNull("previewDocSubmit", "previewDocSubmit", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull51, "unexpectedNull(\"previewD…reviewDocSubmit\", reader)");
                        throw unexpectedNull51;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 51:
                    str52 = this.stringAdapter.fromJson(reader);
                    if (str52 == null) {
                        JsonDataException unexpectedNull52 = Util.unexpectedNull("previewSelfieSubmit", "previewSelfieSubmit", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull52, "unexpectedNull(\"previewS…iewSelfieSubmit\", reader)");
                        throw unexpectedNull52;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 52:
                    str53 = this.stringAdapter.fromJson(reader);
                    if (str53 == null) {
                        JsonDataException unexpectedNull53 = Util.unexpectedNull("faceTooClose", "faceTooClose", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull53, "unexpectedNull(\"faceTooC…, \"faceTooClose\", reader)");
                        throw unexpectedNull53;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 53:
                    str54 = this.stringAdapter.fromJson(reader);
                    if (str54 == null) {
                        JsonDataException unexpectedNull54 = Util.unexpectedNull("pleaseWait", "pleaseWait", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull54, "unexpectedNull(\"pleaseWa…    \"pleaseWait\", reader)");
                        throw unexpectedNull54;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 54:
                    str55 = this.stringAdapter.fromJson(reader);
                    if (str55 == null) {
                        JsonDataException unexpectedNull55 = Util.unexpectedNull("movePhoneBack", "movePhoneBack", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull55, "unexpectedNull(\"movePhon… \"movePhoneBack\", reader)");
                        throw unexpectedNull55;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 55:
                    str56 = this.stringAdapter.fromJson(reader);
                    if (str56 == null) {
                        JsonDataException unexpectedNull56 = Util.unexpectedNull("idTooClose", "idTooClose", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull56, "unexpectedNull(\"idTooClo…    \"idTooClose\", reader)");
                        throw unexpectedNull56;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 56:
                    str57 = this.stringAdapter.fromJson(reader);
                    if (str57 == null) {
                        JsonDataException unexpectedNull57 = Util.unexpectedNull("passportTooClose", "passportTooClose", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull57, "unexpectedNull(\"passport…assportTooClose\", reader)");
                        throw unexpectedNull57;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 57:
                    str58 = this.stringAdapter.fromJson(reader);
                    if (str58 == null) {
                        JsonDataException unexpectedNull58 = Util.unexpectedNull("faceNotParallel", "faceNotParallel", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull58, "unexpectedNull(\"faceNotP…faceNotParallel\", reader)");
                        throw unexpectedNull58;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 58:
                    str59 = this.stringAdapter.fromJson(reader);
                    if (str59 == null) {
                        JsonDataException unexpectedNull59 = Util.unexpectedNull("docSelectSubText", "docSelectSubText", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull59, "unexpectedNull(\"docSelec…ocSelectSubText\", reader)");
                        throw unexpectedNull59;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 59:
                    str60 = this.stringAdapter.fromJson(reader);
                    if (str60 == null) {
                        JsonDataException unexpectedNull60 = Util.unexpectedNull("docIdSubText", "docIdSubText", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull60, "unexpectedNull(\"docIdSub…, \"docIdSubText\", reader)");
                        throw unexpectedNull60;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 60:
                    str61 = this.stringAdapter.fromJson(reader);
                    if (str61 == null) {
                        JsonDataException unexpectedNull61 = Util.unexpectedNull("docPassportSubText", "docPassportSubText", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull61, "unexpectedNull(\"docPassp…PassportSubText\", reader)");
                        throw unexpectedNull61;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 61:
                    str62 = this.stringAdapter.fromJson(reader);
                    if (str62 == null) {
                        JsonDataException unexpectedNull62 = Util.unexpectedNull("docReady", "docReady", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull62, "unexpectedNull(\"docReady…      \"docReady\", reader)");
                        throw unexpectedNull62;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                case 62:
                    str63 = this.stringAdapter.fromJson(reader);
                    if (str63 == null) {
                        JsonDataException unexpectedNull63 = Util.unexpectedNull("docCameraPermission", "docCameraPermission", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull63, "unexpectedNull(\"docCamer…ameraPermission\", reader)");
                        throw unexpectedNull63;
                    }
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
                default:
                    str12 = str64;
                    str11 = str65;
                    str10 = str66;
                    str9 = str67;
                    str8 = str68;
                    str7 = str69;
                    str6 = str70;
                    str5 = str71;
                    str4 = str72;
                    str3 = str73;
                    str2 = str74;
                    str = str75;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, NewLabels value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("adjustLighting");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getAdjustLighting());
        writer.name("alignFaceBox");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getAlignFaceBox());
        writer.name("alignFaceFrame");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getAlignFaceFrame());
        writer.name("backCapture");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBackCapture());
        writer.name("backSideCaptured");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBackSideCaptured());
        writer.name("backToScanning");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBackToScanning());
        writer.name("captureSuccess");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getCaptureSuccess());
        writer.name("alignDocumentId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getAlignDocumentId());
        writer.name("alignDocumentPassport");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getAlignDocumentPassport());
        writer.name("ensureIdFocus");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getEnsureIdFocus());
        writer.name("ensurePassportFocus");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getEnsurePassportFocus());
        writer.name("faceMustBeVisible");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFaceMustBeVisible());
        writer.name("flipIdBarcode");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFlipIdBarcode());
        writer.name("flipYourId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFlipYourId());
        writer.name("focusCameraId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFocusCameraId());
        writer.name("focusCameraPassport");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFocusCameraPassport());
        writer.name("frontCapture");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFrontCapture());
        writer.name("frontSideCaptured");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFrontSideCaptured());
        writer.name("greatNowCapture");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getGreatNowCapture());
        writer.name("holdDevice");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getHoldDevice());
        writer.name("holdPhoneOverId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getHoldPhoneOverId());
        writer.name("holdPhoneOverPassport");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getHoldPhoneOverPassport());
        writer.name("isAllInfoVisible");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.isAllInfoVisible());
        writer.name("isAllInfoVisibleBarcode");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.isAllInfoVisibleBarcode());
        writer.name("isAllInfoVisiblePassport");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.isAllInfoVisiblePassport());
        writer.name("isYourFaceInFrame");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.isYourFaceInFrame());
        writer.name("lookDirectly");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getLookDirectly());
        writer.name("makeSureBarcode");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMakeSureBarcode());
        writer.name("moveCloser");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMoveCloser());
        writer.name("movePhoneFront");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneFront());
        writer.name("openPassport");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getOpenPassport());
        writer.name("passportCapture");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPassportCapture());
        writer.name("passportCaptured");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPassportCaptured());
        writer.name("placeFlatAndHoldId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPlaceFlatAndHoldId());
        writer.name("placeFlatAndHoldPassport");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPlaceFlatAndHoldPassport());
        writer.name("placeIdFlat");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPlaceIdFlat());
        writer.name("retake");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getRetake());
        writer.name("selfieCapture");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getSelfieCapture());
        writer.name("selfieCaptured");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getSelfieCaptured());
        writer.name("toGetStarted");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getToGetStarted());
        writer.name("invalidImage");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getInvalidImage());
        writer.name("submitImageForValidation");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getSubmitImageForValidation());
        writer.name("validatingImage");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getValidatingImage());
        writer.name("imageValidated");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getImageValidated());
        writer.name("processing");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getProcessing());
        writer.name("success");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getSuccess());
        writer.name("cameraPermissionMsg");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getCameraPermissionMsg());
        writer.name("cameraPermissionTitle");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getCameraPermissionTitle());
        writer.name("cameraPermissionButton");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getCameraPermissionButton());
        writer.name("backPressWarningMsg");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBackPressWarningMsg());
        writer.name("previewDocSubmit");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPreviewDocSubmit());
        writer.name("previewSelfieSubmit");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPreviewSelfieSubmit());
        writer.name("faceTooClose");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFaceTooClose());
        writer.name("pleaseWait");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPleaseWait());
        writer.name("movePhoneBack");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneBack());
        writer.name("idTooClose");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getIdTooClose());
        writer.name("passportTooClose");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPassportTooClose());
        writer.name("faceNotParallel");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFaceNotParallel());
        writer.name("docSelectSubText");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getDocSelectSubText());
        writer.name("docIdSubText");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getDocIdSubText());
        writer.name("docPassportSubText");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getDocPassportSubText());
        writer.name("docReady");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getDocReady());
        writer.name("docCameraPermission");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getDocCameraPermission());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(31), "GeneratedJsonAdapter(", "NewLabels", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
