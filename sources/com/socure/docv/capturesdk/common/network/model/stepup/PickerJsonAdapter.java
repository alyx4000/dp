package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/PickerJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Picker;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "labelAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "pickerButtonsAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/PickerButtons;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PickerJsonAdapter extends JsonAdapter<Picker> {
    private final JsonAdapter<Label> labelAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<PickerButtons> pickerButtonsAdapter;

    public PickerJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("header", "button");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"header\", \"button\")");
        this.options = of;
        this.labelAdapter = a.a(moshi, Label.class, "header", "moshi.adapter(Label::cla…ptySet(),\n      \"header\")");
        this.pickerButtonsAdapter = a.a(moshi, PickerButtons.class, "button", "moshi.adapter(PickerButt…va, emptySet(), \"button\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Picker fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Label label = null;
        PickerButtons pickerButtons = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                label = this.labelAdapter.fromJson(reader);
                if (label == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("header_", "header", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"header_\"…        \"header\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (pickerButtons = this.pickerButtonsAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("button", "button", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"button\",…        \"button\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (label == null) {
            JsonDataException missingProperty = Util.missingProperty("header_", "header", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"header_\", \"header\", reader)");
            throw missingProperty;
        }
        if (pickerButtons != null) {
            return new Picker(label, pickerButtons);
        }
        JsonDataException missingProperty2 = Util.missingProperty("button", "button", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"button\", \"button\", reader)");
        throw missingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Picker value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("header");
        this.labelAdapter.toJson(writer, (JsonWriter) value_.getHeader());
        writer.name("button");
        this.pickerButtonsAdapter.toJson(writer, (JsonWriter) value_.getButton());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(28), "GeneratedJsonAdapter(", "Picker", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
