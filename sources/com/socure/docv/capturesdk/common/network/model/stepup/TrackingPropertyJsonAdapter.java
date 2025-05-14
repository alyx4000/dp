package com.socure.docv.capturesdk.common.network.model.stepup;

import com.amplitude.reactnative.DatabaseConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/TrackingPropertyJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/TrackingProperty;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TrackingPropertyJsonAdapter extends JsonAdapter<TrackingProperty> {
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public TrackingPropertyJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(DatabaseConstants.KEY_FIELD, "value");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"key\", \"value\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, DatabaseConstants.KEY_FIELD, "moshi.adapter(String::cl… emptySet(),\n      \"key\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public TrackingProperty fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull(DatabaseConstants.KEY_FIELD, DatabaseConstants.KEY_FIELD, reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"key\", \"key\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (str2 = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("value__", "value", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"value__\"…         \"value\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty(DatabaseConstants.KEY_FIELD, DatabaseConstants.KEY_FIELD, reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"key\", \"key\", reader)");
            throw missingProperty;
        }
        if (str2 != null) {
            return new TrackingProperty(str, str2);
        }
        JsonDataException missingProperty2 = Util.missingProperty("value__", "value", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"value__\", \"value\", reader)");
        throw missingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, TrackingProperty value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name(DatabaseConstants.KEY_FIELD);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getKey());
        writer.name("value");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getValue());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(38), "GeneratedJsonAdapter(", "TrackingProperty", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
