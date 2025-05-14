package com.socure.docv.capturesdk.common.network.model.stepup;

import com.facebook.react.uimanager.ViewProps;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/PrimaryButtonJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/PrimaryButton;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrimaryButtonJsonAdapter extends JsonAdapter<PrimaryButton> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public PrimaryButtonJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("color", "backgroundColor", ViewProps.FONT_SIZE, ViewProps.FONT_WEIGHT, "borderRadius", ViewProps.BORDER_COLOR, ViewProps.BORDER_WIDTH, "shadow", "width");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"color\", \"backgroundC…idth\", \"shadow\", \"width\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, "color", "moshi.adapter(String::cl…mptySet(),\n      \"color\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public PrimaryButton fromJson(JsonReader reader) {
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
        while (true) {
            String str10 = str9;
            String str11 = str8;
            String str12 = str7;
            String str13 = str6;
            String str14 = str5;
            if (!reader.hasNext()) {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty("color", "color", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"color\", \"color\", reader)");
                    throw missingProperty;
                }
                if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("backgroundColor", "backgroundColor", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"backgro…backgroundColor\", reader)");
                    throw missingProperty2;
                }
                if (str3 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty(ViewProps.FONT_SIZE, ViewProps.FONT_SIZE, reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"fontSize\", \"fontSize\", reader)");
                    throw missingProperty3;
                }
                if (str4 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty(ViewProps.FONT_WEIGHT, ViewProps.FONT_WEIGHT, reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"fontWei…t\", \"fontWeight\", reader)");
                    throw missingProperty4;
                }
                if (str14 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("borderRadius", "borderRadius", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"borderR…ius\",\n            reader)");
                    throw missingProperty5;
                }
                if (str13 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty(ViewProps.BORDER_COLOR, ViewProps.BORDER_COLOR, reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"borderC…lor\",\n            reader)");
                    throw missingProperty6;
                }
                if (str12 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty(ViewProps.BORDER_WIDTH, ViewProps.BORDER_WIDTH, reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"borderW…dth\",\n            reader)");
                    throw missingProperty7;
                }
                if (str11 == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("shadow", "shadow", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"shadow\", \"shadow\", reader)");
                    throw missingProperty8;
                }
                if (str10 != null) {
                    return new PrimaryButton(str, str2, str3, str4, str14, str13, str12, str11, str10);
                }
                JsonDataException missingProperty9 = Util.missingProperty("width", "width", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty9, "missingProperty(\"width\", \"width\", reader)");
                throw missingProperty9;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                case 0:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("color", "color", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"color\", …lor\",\n            reader)");
                        throw unexpectedNull;
                    }
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("backgroundColor", "backgroundColor", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"backgrou…backgroundColor\", reader)");
                        throw unexpectedNull2;
                    }
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                case 2:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull(ViewProps.FONT_SIZE, ViewProps.FONT_SIZE, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"fontSize…      \"fontSize\", reader)");
                        throw unexpectedNull3;
                    }
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                case 3:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull(ViewProps.FONT_WEIGHT, ViewProps.FONT_WEIGHT, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"fontWeig…    \"fontWeight\", reader)");
                        throw unexpectedNull4;
                    }
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                case 4:
                    str5 = this.stringAdapter.fromJson(reader);
                    if (str5 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("borderRadius", "borderRadius", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"borderRa…, \"borderRadius\", reader)");
                        throw unexpectedNull5;
                    }
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                case 5:
                    str6 = this.stringAdapter.fromJson(reader);
                    if (str6 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull(ViewProps.BORDER_COLOR, ViewProps.BORDER_COLOR, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"borderCo…\", \"borderColor\", reader)");
                        throw unexpectedNull6;
                    }
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str5 = str14;
                case 6:
                    str7 = this.stringAdapter.fromJson(reader);
                    if (str7 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull(ViewProps.BORDER_WIDTH, ViewProps.BORDER_WIDTH, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"borderWi…\", \"borderWidth\", reader)");
                        throw unexpectedNull7;
                    }
                    str9 = str10;
                    str8 = str11;
                    str6 = str13;
                    str5 = str14;
                case 7:
                    str8 = this.stringAdapter.fromJson(reader);
                    if (str8 == null) {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("shadow", "shadow", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"shadow\",…        \"shadow\", reader)");
                        throw unexpectedNull8;
                    }
                    str9 = str10;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                case 8:
                    str9 = this.stringAdapter.fromJson(reader);
                    if (str9 == null) {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("width", "width", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"width\", …dth\",\n            reader)");
                        throw unexpectedNull9;
                    }
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                default:
                    str9 = str10;
                    str8 = str11;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, PrimaryButton value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("color");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getColor());
        writer.name("backgroundColor");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBackgroundColor());
        writer.name(ViewProps.FONT_SIZE);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFontSize());
        writer.name(ViewProps.FONT_WEIGHT);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFontWeight());
        writer.name("borderRadius");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBorderRadius());
        writer.name(ViewProps.BORDER_COLOR);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBorderColor());
        writer.name(ViewProps.BORDER_WIDTH);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBorderWidth());
        writer.name("shadow");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getShadow());
        writer.name("width");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getWidth());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(35), "GeneratedJsonAdapter(", "PrimaryButton", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
