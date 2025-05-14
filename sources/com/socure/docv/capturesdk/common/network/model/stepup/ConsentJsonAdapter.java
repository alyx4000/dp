package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Consent;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "listOfConsentComponentAdapter", "", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentComponent;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConsentJsonAdapter extends JsonAdapter<Consent> {
    private final JsonAdapter<List<ConsentComponent>> listOfConsentComponentAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsentJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("version", "language", "title", "agree_btn_label", "decline_btn_label", "mandatory_field_warning_msg", "mandatory_field_warning_close_label", "components");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"version\", \"language\"…ose_label\", \"components\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, "version", "moshi.adapter(String::cl…tySet(),\n      \"version\")");
        JsonAdapter<List<ConsentComponent>> adapter = moshi.adapter(Types.newParameterizedType(List.class, ConsentComponent.class), SetsKt.emptySet(), "components");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…emptySet(), \"components\")");
        this.listOfConsentComponentAdapter = adapter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Consent fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        List<ConsentComponent> list = null;
        while (true) {
            List<ConsentComponent> list2 = list;
            String str8 = str7;
            String str9 = str6;
            String str10 = str5;
            String str11 = str4;
            String str12 = str3;
            String str13 = str2;
            if (!reader.hasNext()) {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("version", "version", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"version\", \"version\", reader)");
                    throw missingProperty;
                }
                if (str13 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("language", "language", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"language\", \"language\", reader)");
                    throw missingProperty2;
                }
                if (str12 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("title", "title", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"title\", \"title\", reader)");
                    throw missingProperty3;
                }
                if (str11 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("btnLabelAgree", "agree_btn_label", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"btnLabe…agree_btn_label\", reader)");
                    throw missingProperty4;
                }
                if (str10 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("btnLabelDecline", "decline_btn_label", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"btnLabe…cline_btn_label\", reader)");
                    throw missingProperty5;
                }
                if (str9 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("warningMsg", "mandatory_field_warning_msg", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"warning…eld_warning_msg\", reader)");
                    throw missingProperty6;
                }
                if (str8 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty("warningBtnLabel", "mandatory_field_warning_close_label", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"warning…ing_close_label\", reader)");
                    throw missingProperty7;
                }
                if (list2 != null) {
                    return new Consent(str, str13, str12, str11, str10, str9, str8, list2);
                }
                JsonDataException missingProperty8 = Util.missingProperty("components", "components", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"compone…s\", \"components\", reader)");
                throw missingProperty8;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    list = list2;
                    str7 = str8;
                    str6 = str9;
                    str5 = str10;
                    str4 = str11;
                    str3 = str12;
                    str2 = str13;
                case 0:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("version", "version", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"version\"…       \"version\", reader)");
                        throw unexpectedNull;
                    }
                    list = list2;
                    str7 = str8;
                    str6 = str9;
                    str5 = str10;
                    str4 = str11;
                    str3 = str12;
                    str2 = str13;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("language", "language", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"language…      \"language\", reader)");
                        throw unexpectedNull2;
                    }
                    list = list2;
                    str7 = str8;
                    str6 = str9;
                    str5 = str10;
                    str4 = str11;
                    str3 = str12;
                case 2:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("title", "title", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"title\", …tle\",\n            reader)");
                        throw unexpectedNull3;
                    }
                    list = list2;
                    str7 = str8;
                    str6 = str9;
                    str5 = str10;
                    str4 = str11;
                    str2 = str13;
                case 3:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("btnLabelAgree", "agree_btn_label", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"btnLabel…agree_btn_label\", reader)");
                        throw unexpectedNull4;
                    }
                    list = list2;
                    str7 = str8;
                    str6 = str9;
                    str5 = str10;
                    str3 = str12;
                    str2 = str13;
                case 4:
                    str5 = this.stringAdapter.fromJson(reader);
                    if (str5 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("btnLabelDecline", "decline_btn_label", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"btnLabel…cline_btn_label\", reader)");
                        throw unexpectedNull5;
                    }
                    list = list2;
                    str7 = str8;
                    str6 = str9;
                    str4 = str11;
                    str3 = str12;
                    str2 = str13;
                case 5:
                    str6 = this.stringAdapter.fromJson(reader);
                    if (str6 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("warningMsg", "mandatory_field_warning_msg", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"warningM…eld_warning_msg\", reader)");
                        throw unexpectedNull6;
                    }
                    list = list2;
                    str7 = str8;
                    str5 = str10;
                    str4 = str11;
                    str3 = str12;
                    str2 = str13;
                case 6:
                    str7 = this.stringAdapter.fromJson(reader);
                    if (str7 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("warningBtnLabel", "mandatory_field_warning_close_label", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"warningB…bel\",\n            reader)");
                        throw unexpectedNull7;
                    }
                    list = list2;
                    str6 = str9;
                    str5 = str10;
                    str4 = str11;
                    str3 = str12;
                    str2 = str13;
                case 7:
                    list = this.listOfConsentComponentAdapter.fromJson(reader);
                    if (list == null) {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("components", "components", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"components\", \"components\", reader)");
                        throw unexpectedNull8;
                    }
                    str7 = str8;
                    str6 = str9;
                    str5 = str10;
                    str4 = str11;
                    str3 = str12;
                    str2 = str13;
                default:
                    list = list2;
                    str7 = str8;
                    str6 = str9;
                    str5 = str10;
                    str4 = str11;
                    str3 = str12;
                    str2 = str13;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Consent value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("version");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getVersion());
        writer.name("language");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getLanguage());
        writer.name("title");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getTitle());
        writer.name("agree_btn_label");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBtnLabelAgree());
        writer.name("decline_btn_label");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBtnLabelDecline());
        writer.name("mandatory_field_warning_msg");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getWarningMsg());
        writer.name("mandatory_field_warning_close_label");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getWarningBtnLabel());
        writer.name("components");
        this.listOfConsentComponentAdapter.toJson(writer, (JsonWriter) value_.getComponents());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(29), "GeneratedJsonAdapter(", "Consent", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
