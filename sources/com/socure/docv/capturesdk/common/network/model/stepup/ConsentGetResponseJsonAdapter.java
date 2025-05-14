package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentGetResponseJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentGetResponse;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "consentAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Consent;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConsentGetResponseJsonAdapter extends JsonAdapter<ConsentGetResponse> {
    private final JsonAdapter<Consent> consentAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsentGetResponseJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("data", "status");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"data\", \"status\")");
        this.options = of;
        this.consentAdapter = a.a(moshi, Consent.class, "data", "moshi.adapter(Consent::c…emptySet(),\n      \"data\")");
        this.stringAdapter = a.a(moshi, String.class, "status", "moshi.adapter(String::cl…ptySet(),\n      \"status\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsentGetResponse fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Consent consent = null;
        String str = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                consent = this.consentAdapter.fromJson(reader);
                if (consent == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("data_", "data", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"data_\", …ata\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (str = this.stringAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("status", "status", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"status\",…        \"status\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (consent == null) {
            JsonDataException missingProperty = Util.missingProperty("data_", "data", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"data_\", \"data\", reader)");
            throw missingProperty;
        }
        if (str != null) {
            return new ConsentGetResponse(consent, str);
        }
        JsonDataException missingProperty2 = Util.missingProperty("status", "status", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"status\", \"status\", reader)");
        throw missingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsentGetResponse value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("data");
        this.consentAdapter.toJson(writer, (JsonWriter) value_.getData());
        writer.name("status");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getStatus());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(40), "GeneratedJsonAdapter(", "ConsentGetResponse", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
