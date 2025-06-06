package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ManualCaptureTimeoutJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ManualCaptureTimeout;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ManualCaptureTimeoutJsonAdapter extends JsonAdapter<ManualCaptureTimeout> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;

    public ManualCaptureTimeoutJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("value");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"value\")");
        this.options = of;
        this.intAdapter = a.a(moshi, Integer.TYPE, "value", "moshi.adapter(Int::class…ava, emptySet(), \"value\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ManualCaptureTimeout fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Integer num = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0 && (num = this.intAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull = Util.unexpectedNull("value__", "value", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"value__\"…lue\",\n            reader)");
                throw unexpectedNull;
            }
        }
        reader.endObject();
        if (num != null) {
            return new ManualCaptureTimeout(num.intValue());
        }
        JsonDataException missingProperty = Util.missingProperty("value__", "value", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"value__\", \"value\", reader)");
        throw missingProperty;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ManualCaptureTimeout value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("value");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(value_.getValue()));
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(42), "GeneratedJsonAdapter(", "ManualCaptureTimeout", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
