package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/PrimaryJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Primary;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "buttonAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Button;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PrimaryJsonAdapter extends JsonAdapter<Primary> {
    private final JsonAdapter<Button> buttonAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public PrimaryJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("color", "backgroundColor", "button");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"color\", \"backgroundColor\",\n      \"button\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, "color", "moshi.adapter(String::cl…mptySet(),\n      \"color\")");
        this.buttonAdapter = a.a(moshi, Button.class, "button", "moshi.adapter(Button::cl…ptySet(),\n      \"button\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Primary fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        Button button = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("color", "color", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"color\", …lor\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("backgroundColor", "backgroundColor", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"backgrou…backgroundColor\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2 && (button = this.buttonAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("button", "button", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"button\",…        \"button\", reader)");
                throw unexpectedNull3;
            }
        }
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
        if (button != null) {
            return new Primary(str, str2, button);
        }
        JsonDataException missingProperty3 = Util.missingProperty("button", "button", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"button\", \"button\", reader)");
        throw missingProperty3;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Primary value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("color");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getColor());
        writer.name("backgroundColor");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getBackgroundColor());
        writer.name("button");
        this.buttonAdapter.toJson(writer, (JsonWriter) value_.getButton());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(29), "GeneratedJsonAdapter(", "Primary", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
