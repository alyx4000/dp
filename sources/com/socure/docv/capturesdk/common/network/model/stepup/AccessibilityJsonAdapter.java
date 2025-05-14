package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/AccessibilityJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Accessibility;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AccessibilityJsonAdapter extends JsonAdapter<Accessibility> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public AccessibilityJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("holdPhoneFront", "alignFaceFrame", "movePhoneRight", "movePhoneLeft", "movePhoneUp", "movePhoneDown", "noCardDetected", "noPassportDetected", "idLookingGood", "faceIsSmall", "movePhoneFrontLowEndDevice", "focusCameraId", "flipIdBarcode", "focusCameraPassport", "movePhoneFront", "frontBackTryPhotoManually", "passportTryPhotoManually", "validatingImage", "idealFace", "initialisingSdk", "processingConsent", "manualBtnContDes", "closeBtnContDes", "helpBtnContDes", "backBtnContDes", "selectCheckBox", "unselectCheckBox");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"holdPhoneFront\",\n   …Box\", \"unselectCheckBox\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, "holdPhoneFront", "moshi.adapter(String::cl…,\n      \"holdPhoneFront\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Accessibility fromJson(JsonReader reader) {
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
        while (true) {
            String str28 = str12;
            String str29 = str11;
            String str30 = str10;
            String str31 = str9;
            String str32 = str8;
            String str33 = str7;
            String str34 = str6;
            String str35 = str5;
            String str36 = str4;
            String str37 = str3;
            String str38 = str2;
            String str39 = str;
            if (!reader.hasNext()) {
                reader.endObject();
                if (str39 == null) {
                    JsonDataException missingProperty = Util.missingProperty("holdPhoneFront", "holdPhoneFront", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"holdPho…\"holdPhoneFront\", reader)");
                    throw missingProperty;
                }
                if (str38 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("alignFaceFrame", "alignFaceFrame", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"alignFa…\"alignFaceFrame\", reader)");
                    throw missingProperty2;
                }
                if (str37 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("movePhoneRight", "movePhoneRight", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"movePho…\"movePhoneRight\", reader)");
                    throw missingProperty3;
                }
                if (str36 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("movePhoneLeft", "movePhoneLeft", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"movePho… \"movePhoneLeft\", reader)");
                    throw missingProperty4;
                }
                if (str35 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("movePhoneUp", "movePhoneUp", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"movePho…eUp\",\n            reader)");
                    throw missingProperty5;
                }
                if (str34 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("movePhoneDown", "movePhoneDown", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"movePho… \"movePhoneDown\", reader)");
                    throw missingProperty6;
                }
                if (str33 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("noCardDetected", "noCardDetected", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"noCardD…\"noCardDetected\", reader)");
                    throw missingProperty7;
                }
                if (str32 == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("noPassportDetected", "noPassportDetected", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"noPassp…assportDetected\", reader)");
                    throw missingProperty8;
                }
                if (str31 == null) {
                    JsonDataException missingProperty9 = Util.missingProperty("idLookingGood", "idLookingGood", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty9, "missingProperty(\"idLooki… \"idLookingGood\", reader)");
                    throw missingProperty9;
                }
                if (str30 == null) {
                    JsonDataException missingProperty10 = Util.missingProperty("faceIsSmall", "faceIsSmall", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty10, "missingProperty(\"faceIsS…all\",\n            reader)");
                    throw missingProperty10;
                }
                if (str29 == null) {
                    JsonDataException missingProperty11 = Util.missingProperty("movePhoneFrontLowEndDevice", "movePhoneFrontLowEndDevice", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty11, "missingProperty(\"movePho…ice\",\n            reader)");
                    throw missingProperty11;
                }
                if (str28 == null) {
                    JsonDataException missingProperty12 = Util.missingProperty("focusCameraId", "focusCameraId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty12, "missingProperty(\"focusCa… \"focusCameraId\", reader)");
                    throw missingProperty12;
                }
                if (str13 == null) {
                    JsonDataException missingProperty13 = Util.missingProperty("flipIdBarcode", "flipIdBarcode", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty13, "missingProperty(\"flipIdB… \"flipIdBarcode\", reader)");
                    throw missingProperty13;
                }
                if (str14 == null) {
                    JsonDataException missingProperty14 = Util.missingProperty("focusCameraPassport", "focusCameraPassport", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty14, "missingProperty(\"focusCa…sCameraPassport\", reader)");
                    throw missingProperty14;
                }
                if (str15 == null) {
                    JsonDataException missingProperty15 = Util.missingProperty("movePhoneFront", "movePhoneFront", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty15, "missingProperty(\"movePho…\"movePhoneFront\", reader)");
                    throw missingProperty15;
                }
                if (str16 == null) {
                    JsonDataException missingProperty16 = Util.missingProperty("frontBackTryPhotoManually", "frontBackTryPhotoManually", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty16, "missingProperty(\"frontBa…lly\",\n            reader)");
                    throw missingProperty16;
                }
                if (str17 == null) {
                    JsonDataException missingProperty17 = Util.missingProperty("passportTryPhotoManually", "passportTryPhotoManually", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty17, "missingProperty(\"passpor…lly\",\n            reader)");
                    throw missingProperty17;
                }
                if (str18 == null) {
                    JsonDataException missingProperty18 = Util.missingProperty("validatingImage", "validatingImage", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty18, "missingProperty(\"validat…validatingImage\", reader)");
                    throw missingProperty18;
                }
                if (str19 == null) {
                    JsonDataException missingProperty19 = Util.missingProperty("idealFace", "idealFace", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty19, "missingProperty(\"idealFace\", \"idealFace\", reader)");
                    throw missingProperty19;
                }
                if (str20 == null) {
                    JsonDataException missingProperty20 = Util.missingProperty("initialisingSdk", "initialisingSdk", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty20, "missingProperty(\"initial…initialisingSdk\", reader)");
                    throw missingProperty20;
                }
                if (str21 == null) {
                    JsonDataException missingProperty21 = Util.missingProperty("processingConsent", "processingConsent", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty21, "missingProperty(\"process…ocessingConsent\", reader)");
                    throw missingProperty21;
                }
                if (str22 == null) {
                    JsonDataException missingProperty22 = Util.missingProperty("manualBtnContDes", "manualBtnContDes", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty22, "missingProperty(\"manualB…anualBtnContDes\", reader)");
                    throw missingProperty22;
                }
                if (str23 == null) {
                    JsonDataException missingProperty23 = Util.missingProperty("closeBtnContDes", "closeBtnContDes", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty23, "missingProperty(\"closeBt…closeBtnContDes\", reader)");
                    throw missingProperty23;
                }
                if (str24 == null) {
                    JsonDataException missingProperty24 = Util.missingProperty("helpBtnContDes", "helpBtnContDes", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty24, "missingProperty(\"helpBtn…\"helpBtnContDes\", reader)");
                    throw missingProperty24;
                }
                if (str25 == null) {
                    JsonDataException missingProperty25 = Util.missingProperty("backBtnContDes", "backBtnContDes", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty25, "missingProperty(\"backBtn…\"backBtnContDes\", reader)");
                    throw missingProperty25;
                }
                if (str26 == null) {
                    JsonDataException missingProperty26 = Util.missingProperty("selectCheckBox", "selectCheckBox", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty26, "missingProperty(\"selectC…\"selectCheckBox\", reader)");
                    throw missingProperty26;
                }
                if (str27 != null) {
                    return new Accessibility(str39, str38, str37, str36, str35, str34, str33, str32, str31, str30, str29, str28, str13, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, str25, str26, str27);
                }
                JsonDataException missingProperty27 = Util.missingProperty("unselectCheckBox", "unselectCheckBox", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty27, "missingProperty(\"unselec…nselectCheckBox\", reader)");
                throw missingProperty27;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 0:
                    String fromJson = this.stringAdapter.fromJson(reader);
                    if (fromJson == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("holdPhoneFront", "holdPhoneFront", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"holdPhon…\"holdPhoneFront\", reader)");
                        throw unexpectedNull;
                    }
                    str = fromJson;
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("alignFaceFrame", "alignFaceFrame", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"alignFac…\"alignFaceFrame\", reader)");
                        throw unexpectedNull2;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str = str39;
                case 2:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("movePhoneRight", "movePhoneRight", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"movePhon…\"movePhoneRight\", reader)");
                        throw unexpectedNull3;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str2 = str38;
                    str = str39;
                case 3:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("movePhoneLeft", "movePhoneLeft", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"movePhon… \"movePhoneLeft\", reader)");
                        throw unexpectedNull4;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 4:
                    str5 = this.stringAdapter.fromJson(reader);
                    if (str5 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("movePhoneUp", "movePhoneUp", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"movePhon…\", \"movePhoneUp\", reader)");
                        throw unexpectedNull5;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 5:
                    str6 = this.stringAdapter.fromJson(reader);
                    if (str6 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("movePhoneDown", "movePhoneDown", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"movePhon… \"movePhoneDown\", reader)");
                        throw unexpectedNull6;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 6:
                    str7 = this.stringAdapter.fromJson(reader);
                    if (str7 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("noCardDetected", "noCardDetected", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"noCardDe…\"noCardDetected\", reader)");
                        throw unexpectedNull7;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 7:
                    str8 = this.stringAdapter.fromJson(reader);
                    if (str8 == null) {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("noPassportDetected", "noPassportDetected", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"noPasspo…assportDetected\", reader)");
                        throw unexpectedNull8;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 8:
                    str9 = this.stringAdapter.fromJson(reader);
                    if (str9 == null) {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("idLookingGood", "idLookingGood", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"idLookin… \"idLookingGood\", reader)");
                        throw unexpectedNull9;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 9:
                    str10 = this.stringAdapter.fromJson(reader);
                    if (str10 == null) {
                        JsonDataException unexpectedNull10 = Util.unexpectedNull("faceIsSmall", "faceIsSmall", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull10, "unexpectedNull(\"faceIsSm…\", \"faceIsSmall\", reader)");
                        throw unexpectedNull10;
                    }
                    str12 = str28;
                    str11 = str29;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 10:
                    str11 = this.stringAdapter.fromJson(reader);
                    if (str11 == null) {
                        JsonDataException unexpectedNull11 = Util.unexpectedNull("movePhoneFrontLowEndDevice", "movePhoneFrontLowEndDevice", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull11, "unexpectedNull(\"movePhon…ice\",\n            reader)");
                        throw unexpectedNull11;
                    }
                    str12 = str28;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 11:
                    str12 = this.stringAdapter.fromJson(reader);
                    if (str12 == null) {
                        JsonDataException unexpectedNull12 = Util.unexpectedNull("focusCameraId", "focusCameraId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull12, "unexpectedNull(\"focusCam… \"focusCameraId\", reader)");
                        throw unexpectedNull12;
                    }
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 12:
                    str13 = this.stringAdapter.fromJson(reader);
                    if (str13 == null) {
                        JsonDataException unexpectedNull13 = Util.unexpectedNull("flipIdBarcode", "flipIdBarcode", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull13, "unexpectedNull(\"flipIdBa… \"flipIdBarcode\", reader)");
                        throw unexpectedNull13;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 13:
                    str14 = this.stringAdapter.fromJson(reader);
                    if (str14 == null) {
                        JsonDataException unexpectedNull14 = Util.unexpectedNull("focusCameraPassport", "focusCameraPassport", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull14, "unexpectedNull(\"focusCam…sCameraPassport\", reader)");
                        throw unexpectedNull14;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 14:
                    str15 = this.stringAdapter.fromJson(reader);
                    if (str15 == null) {
                        JsonDataException unexpectedNull15 = Util.unexpectedNull("movePhoneFront", "movePhoneFront", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull15, "unexpectedNull(\"movePhon…\"movePhoneFront\", reader)");
                        throw unexpectedNull15;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 15:
                    str16 = this.stringAdapter.fromJson(reader);
                    if (str16 == null) {
                        JsonDataException unexpectedNull16 = Util.unexpectedNull("frontBackTryPhotoManually", "frontBackTryPhotoManually", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull16, "unexpectedNull(\"frontBac…lly\",\n            reader)");
                        throw unexpectedNull16;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 16:
                    str17 = this.stringAdapter.fromJson(reader);
                    if (str17 == null) {
                        JsonDataException unexpectedNull17 = Util.unexpectedNull("passportTryPhotoManually", "passportTryPhotoManually", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull17, "unexpectedNull(\"passport…lly\",\n            reader)");
                        throw unexpectedNull17;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 17:
                    str18 = this.stringAdapter.fromJson(reader);
                    if (str18 == null) {
                        JsonDataException unexpectedNull18 = Util.unexpectedNull("validatingImage", "validatingImage", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull18, "unexpectedNull(\"validati…validatingImage\", reader)");
                        throw unexpectedNull18;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 18:
                    str19 = this.stringAdapter.fromJson(reader);
                    if (str19 == null) {
                        JsonDataException unexpectedNull19 = Util.unexpectedNull("idealFace", "idealFace", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull19, "unexpectedNull(\"idealFac…     \"idealFace\", reader)");
                        throw unexpectedNull19;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 19:
                    str20 = this.stringAdapter.fromJson(reader);
                    if (str20 == null) {
                        JsonDataException unexpectedNull20 = Util.unexpectedNull("initialisingSdk", "initialisingSdk", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull20, "unexpectedNull(\"initiali…initialisingSdk\", reader)");
                        throw unexpectedNull20;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 20:
                    str21 = this.stringAdapter.fromJson(reader);
                    if (str21 == null) {
                        JsonDataException unexpectedNull21 = Util.unexpectedNull("processingConsent", "processingConsent", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull21, "unexpectedNull(\"processi…ocessingConsent\", reader)");
                        throw unexpectedNull21;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 21:
                    str22 = this.stringAdapter.fromJson(reader);
                    if (str22 == null) {
                        JsonDataException unexpectedNull22 = Util.unexpectedNull("manualBtnContDes", "manualBtnContDes", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull22, "unexpectedNull(\"manualBt…anualBtnContDes\", reader)");
                        throw unexpectedNull22;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 22:
                    str23 = this.stringAdapter.fromJson(reader);
                    if (str23 == null) {
                        JsonDataException unexpectedNull23 = Util.unexpectedNull("closeBtnContDes", "closeBtnContDes", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull23, "unexpectedNull(\"closeBtn…closeBtnContDes\", reader)");
                        throw unexpectedNull23;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 23:
                    str24 = this.stringAdapter.fromJson(reader);
                    if (str24 == null) {
                        JsonDataException unexpectedNull24 = Util.unexpectedNull("helpBtnContDes", "helpBtnContDes", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull24, "unexpectedNull(\"helpBtnC…\"helpBtnContDes\", reader)");
                        throw unexpectedNull24;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 24:
                    str25 = this.stringAdapter.fromJson(reader);
                    if (str25 == null) {
                        JsonDataException unexpectedNull25 = Util.unexpectedNull("backBtnContDes", "backBtnContDes", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull25, "unexpectedNull(\"backBtnC…\"backBtnContDes\", reader)");
                        throw unexpectedNull25;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 25:
                    str26 = this.stringAdapter.fromJson(reader);
                    if (str26 == null) {
                        JsonDataException unexpectedNull26 = Util.unexpectedNull("selectCheckBox", "selectCheckBox", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull26, "unexpectedNull(\"selectCh…\"selectCheckBox\", reader)");
                        throw unexpectedNull26;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                case 26:
                    str27 = this.stringAdapter.fromJson(reader);
                    if (str27 == null) {
                        JsonDataException unexpectedNull27 = Util.unexpectedNull("unselectCheckBox", "unselectCheckBox", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull27, "unexpectedNull(\"unselect…nselectCheckBox\", reader)");
                        throw unexpectedNull27;
                    }
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
                default:
                    str12 = str28;
                    str11 = str29;
                    str10 = str30;
                    str9 = str31;
                    str8 = str32;
                    str7 = str33;
                    str6 = str34;
                    str5 = str35;
                    str4 = str36;
                    str3 = str37;
                    str2 = str38;
                    str = str39;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Accessibility value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("holdPhoneFront");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getHoldPhoneFront());
        writer.name("alignFaceFrame");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getAlignFaceFrame());
        writer.name("movePhoneRight");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneRight());
        writer.name("movePhoneLeft");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneLeft());
        writer.name("movePhoneUp");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneUp());
        writer.name("movePhoneDown");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneDown());
        writer.name("noCardDetected");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getNoCardDetected());
        writer.name("noPassportDetected");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getNoPassportDetected());
        writer.name("idLookingGood");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getIdLookingGood());
        writer.name("faceIsSmall");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFaceIsSmall());
        writer.name("movePhoneFrontLowEndDevice");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneFrontLowEndDevice());
        writer.name("focusCameraId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFocusCameraId());
        writer.name("flipIdBarcode");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFlipIdBarcode());
        writer.name("focusCameraPassport");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFocusCameraPassport());
        writer.name("movePhoneFront");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getMovePhoneFront());
        writer.name("frontBackTryPhotoManually");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFrontBackTryPhotoManually());
        writer.name("passportTryPhotoManually");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPassportTryPhotoManually());
        writer.name("validatingImage");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getValidatingImage());
        writer.name("idealFace");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getIdealFace());
        writer.name("initialisingSdk");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getInitialisingSdk());
        writer.name("processingConsent");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getProcessingConsent());
        writer.name("manualBtnContDes");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getManualBtnContDes());
        writer.name("closeBtnContDes");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getCloseBtnContDes());
        writer.name("helpBtnContDes");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getHelpBtnContDes());
        writer.name("backBtnContDes");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBackBtnContDes());
        writer.name("selectCheckBox");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getSelectCheckBox());
        writer.name("unselectCheckBox");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getUnselectCheckBox());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(35), "GeneratedJsonAdapter(", "Accessibility", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
