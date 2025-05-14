package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/BackCaptureJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/BackCapture;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "labelAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Label;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BackCaptureJsonAdapter extends JsonAdapter<BackCapture> {
    private final JsonAdapter<Label> labelAdapter;
    private final JsonReader.Options options;

    public BackCaptureJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("header", "keepSteadyText", "darkErrorSecondary", "manualCapturePrimaryText", "manualCaptureSecondaryText");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"header\", \"keepSteady…ualCaptureSecondaryText\")");
        this.options = of;
        this.labelAdapter = a.a(moshi, Label.class, "header", "moshi.adapter(Label::cla…ptySet(),\n      \"header\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public BackCapture fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Label label = null;
        Label label2 = null;
        Label label3 = null;
        Label label4 = null;
        Label label5 = null;
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
            } else if (selectName == 1) {
                label2 = this.labelAdapter.fromJson(reader);
                if (label2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("keepSteadyText", "keepSteadyText", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"keepStea…\"keepSteadyText\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                label3 = this.labelAdapter.fromJson(reader);
                if (label3 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("darkErrorSecondary", "darkErrorSecondary", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"darkErro…kErrorSecondary\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3) {
                label4 = this.labelAdapter.fromJson(reader);
                if (label4 == null) {
                    JsonDataException unexpectedNull4 = Util.unexpectedNull("manualCapturePrimaryText", "manualCapturePrimaryText", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"manualCa…ext\",\n            reader)");
                    throw unexpectedNull4;
                }
            } else if (selectName == 4 && (label5 = this.labelAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull5 = Util.unexpectedNull("manualCaptureSecondaryText", "manualCaptureSecondaryText", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"manualCa…ext\",\n            reader)");
                throw unexpectedNull5;
            }
        }
        reader.endObject();
        if (label == null) {
            JsonDataException missingProperty = Util.missingProperty("header_", "header", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"header_\", \"header\", reader)");
            throw missingProperty;
        }
        if (label2 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("keepSteadyText", "keepSteadyText", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"keepSte…\"keepSteadyText\", reader)");
            throw missingProperty2;
        }
        if (label3 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("darkErrorSecondary", "darkErrorSecondary", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"darkErr…kErrorSecondary\", reader)");
            throw missingProperty3;
        }
        if (label4 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("manualCapturePrimaryText", "manualCapturePrimaryText", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"manualC…ext\",\n            reader)");
            throw missingProperty4;
        }
        if (label5 != null) {
            return new BackCapture(label, label2, label3, label4, label5);
        }
        JsonDataException missingProperty5 = Util.missingProperty("manualCaptureSecondaryText", "manualCaptureSecondaryText", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"manualC…ext\",\n            reader)");
        throw missingProperty5;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, BackCapture value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("header");
        this.labelAdapter.toJson(writer, (JsonWriter) value_.getHeader());
        writer.name("keepSteadyText");
        this.labelAdapter.toJson(writer, (JsonWriter) value_.getKeepSteadyText());
        writer.name("darkErrorSecondary");
        this.labelAdapter.toJson(writer, (JsonWriter) value_.getDarkErrorSecondary());
        writer.name("manualCapturePrimaryText");
        this.labelAdapter.toJson(writer, (JsonWriter) value_.getManualCapturePrimaryText());
        writer.name("manualCaptureSecondaryText");
        this.labelAdapter.toJson(writer, (JsonWriter) value_.getManualCaptureSecondaryText());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(33), "GeneratedJsonAdapter(", "BackCapture", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
