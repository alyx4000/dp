package com.socure.docv.capturesdk.common.network.model.stepup;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\"\u001a\u00020#H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ScreensJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Screens;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "backCaptureAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/BackCapture;", "backIdAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/BackId;", "commonAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Common;", "frontCaptureAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/FrontCapture;", "frontIdAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/FrontId;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "passportAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Passport;", "pickerAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Picker;", "selfieAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Selfie;", "selfieCaptureAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieCapture;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ScreensJsonAdapter extends JsonAdapter<Screens> {
    private final JsonAdapter<BackCapture> backCaptureAdapter;
    private final JsonAdapter<BackId> backIdAdapter;
    private final JsonAdapter<Common> commonAdapter;
    private final JsonAdapter<FrontCapture> frontCaptureAdapter;
    private final JsonAdapter<FrontId> frontIdAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<Passport> passportAdapter;
    private final JsonAdapter<Picker> pickerAdapter;
    private final JsonAdapter<Selfie> selfieAdapter;
    private final JsonAdapter<SelfieCapture> selfieCaptureAdapter;

    public ScreensJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("picker", "frontId", "frontCapture", "backId", "backCapture", "selfie", "selfieCapture", ApiConstant.DOCUMENT_TYPE_PASSPORT, "common");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"picker\", \"frontId\",\n…e\", \"passport\", \"common\")");
        this.options = of;
        this.pickerAdapter = a.a(moshi, Picker.class, "picker", "moshi.adapter(Picker::cl…ptySet(),\n      \"picker\")");
        this.frontIdAdapter = a.a(moshi, FrontId.class, "frontId", "moshi.adapter(FrontId::c…tySet(),\n      \"frontId\")");
        this.frontCaptureAdapter = a.a(moshi, FrontCapture.class, "frontCapture", "moshi.adapter(FrontCaptu…ptySet(), \"frontCapture\")");
        this.backIdAdapter = a.a(moshi, BackId.class, "backId", "moshi.adapter(BackId::cl…ptySet(),\n      \"backId\")");
        this.backCaptureAdapter = a.a(moshi, BackCapture.class, "backCapture", "moshi.adapter(BackCaptur…mptySet(), \"backCapture\")");
        this.selfieAdapter = a.a(moshi, Selfie.class, "selfie", "moshi.adapter(Selfie::cl…ptySet(),\n      \"selfie\")");
        this.selfieCaptureAdapter = a.a(moshi, SelfieCapture.class, "selfieCapture", "moshi.adapter(SelfieCapt…tySet(), \"selfieCapture\")");
        this.passportAdapter = a.a(moshi, Passport.class, ApiConstant.DOCUMENT_TYPE_PASSPORT, "moshi.adapter(Passport::…  emptySet(), \"passport\")");
        this.commonAdapter = a.a(moshi, Common.class, "common", "moshi.adapter(Common::cl…ptySet(),\n      \"common\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Screens fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Picker picker = null;
        FrontId frontId = null;
        FrontCapture frontCapture = null;
        BackId backId = null;
        BackCapture backCapture = null;
        Selfie selfie = null;
        SelfieCapture selfieCapture = null;
        Passport passport = null;
        Common common = null;
        while (true) {
            Common common2 = common;
            Passport passport2 = passport;
            SelfieCapture selfieCapture2 = selfieCapture;
            Selfie selfie2 = selfie;
            BackCapture backCapture2 = backCapture;
            if (!reader.hasNext()) {
                reader.endObject();
                if (picker == null) {
                    JsonDataException missingProperty = Util.missingProperty("picker", "picker", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"picker\", \"picker\", reader)");
                    throw missingProperty;
                }
                if (frontId == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("frontId", "frontId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"frontId\", \"frontId\", reader)");
                    throw missingProperty2;
                }
                if (frontCapture == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("frontCapture", "frontCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"frontCa…ure\",\n            reader)");
                    throw missingProperty3;
                }
                if (backId == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("backId", "backId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"backId\", \"backId\", reader)");
                    throw missingProperty4;
                }
                if (backCapture2 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("backCapture", "backCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"backCap…ure\",\n            reader)");
                    throw missingProperty5;
                }
                if (selfie2 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("selfie", "selfie", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"selfie\", \"selfie\", reader)");
                    throw missingProperty6;
                }
                if (selfieCapture2 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("selfieCapture", "selfieCapture", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"selfieC… \"selfieCapture\", reader)");
                    throw missingProperty7;
                }
                if (passport2 == null) {
                    JsonDataException missingProperty8 = Util.missingProperty(ApiConstant.DOCUMENT_TYPE_PASSPORT, ApiConstant.DOCUMENT_TYPE_PASSPORT, reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"passport\", \"passport\", reader)");
                    throw missingProperty8;
                }
                if (common2 != null) {
                    return new Screens(picker, frontId, frontCapture, backId, backCapture2, selfie2, selfieCapture2, passport2, common2);
                }
                JsonDataException missingProperty9 = Util.missingProperty("common", "common", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty9, "missingProperty(\"common\", \"common\", reader)");
                throw missingProperty9;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                case 0:
                    picker = this.pickerAdapter.fromJson(reader);
                    if (picker == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("picker", "picker", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"picker\",…        \"picker\", reader)");
                        throw unexpectedNull;
                    }
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                case 1:
                    frontId = this.frontIdAdapter.fromJson(reader);
                    if (frontId == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("frontId", "frontId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"frontId\"…       \"frontId\", reader)");
                        throw unexpectedNull2;
                    }
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                case 2:
                    frontCapture = this.frontCaptureAdapter.fromJson(reader);
                    if (frontCapture == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("frontCapture", "frontCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"frontCap…, \"frontCapture\", reader)");
                        throw unexpectedNull3;
                    }
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                case 3:
                    backId = this.backIdAdapter.fromJson(reader);
                    if (backId == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("backId", "backId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"backId\",…        \"backId\", reader)");
                        throw unexpectedNull4;
                    }
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                case 4:
                    backCapture = this.backCaptureAdapter.fromJson(reader);
                    if (backCapture == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("backCapture", "backCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"backCapt…\", \"backCapture\", reader)");
                        throw unexpectedNull5;
                    }
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                case 5:
                    selfie = this.selfieAdapter.fromJson(reader);
                    if (selfie == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("selfie", "selfie", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"selfie\",…        \"selfie\", reader)");
                        throw unexpectedNull6;
                    }
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    backCapture = backCapture2;
                case 6:
                    selfieCapture = this.selfieCaptureAdapter.fromJson(reader);
                    if (selfieCapture == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("selfieCapture", "selfieCapture", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"selfieCa… \"selfieCapture\", reader)");
                        throw unexpectedNull7;
                    }
                    common = common2;
                    passport = passport2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                case 7:
                    passport = this.passportAdapter.fromJson(reader);
                    if (passport == null) {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull(ApiConstant.DOCUMENT_TYPE_PASSPORT, ApiConstant.DOCUMENT_TYPE_PASSPORT, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"passport…      \"passport\", reader)");
                        throw unexpectedNull8;
                    }
                    common = common2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                case 8:
                    common = this.commonAdapter.fromJson(reader);
                    if (common == null) {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("common", "common", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"common\",…        \"common\", reader)");
                        throw unexpectedNull9;
                    }
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
                default:
                    common = common2;
                    passport = passport2;
                    selfieCapture = selfieCapture2;
                    selfie = selfie2;
                    backCapture = backCapture2;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Screens value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("picker");
        this.pickerAdapter.toJson(writer, (JsonWriter) value_.getPicker());
        writer.name("frontId");
        this.frontIdAdapter.toJson(writer, (JsonWriter) value_.getFrontId());
        writer.name("frontCapture");
        this.frontCaptureAdapter.toJson(writer, (JsonWriter) value_.getFrontCapture());
        writer.name("backId");
        this.backIdAdapter.toJson(writer, (JsonWriter) value_.getBackId());
        writer.name("backCapture");
        this.backCaptureAdapter.toJson(writer, (JsonWriter) value_.getBackCapture());
        writer.name("selfie");
        this.selfieAdapter.toJson(writer, (JsonWriter) value_.getSelfie());
        writer.name("selfieCapture");
        this.selfieCaptureAdapter.toJson(writer, (JsonWriter) value_.getSelfieCapture());
        writer.name(ApiConstant.DOCUMENT_TYPE_PASSPORT);
        this.passportAdapter.toJson(writer, (JsonWriter) value_.getPassport());
        writer.name("common");
        this.commonAdapter.toJson(writer, (JsonWriter) value_.getCommon());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(29), "GeneratedJsonAdapter(", "Screens", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
