package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadResultJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadResult;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadResultJsonAdapter extends JsonAdapter<UploadResult> {
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public UploadResultJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("referenceId", "uuid", "error", "errorCode");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"referenceId\", \"uuid\"…rror\",\n      \"errorCode\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, "referenceId", "moshi.adapter(String::cl…t(),\n      \"referenceId\")");
        this.nullableStringAdapter = a.a(moshi, String.class, "error", "moshi.adapter(String::cl…     emptySet(), \"error\")");
        this.nullableIntAdapter = a.a(moshi, Integer.class, "errorCode", "moshi.adapter(Int::class… emptySet(), \"errorCode\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public UploadResult fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String str = null;
        String str2 = null;
        String str3 = null;
        Integer num = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("referenceId", "referenceId", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"referenc…\", \"referenceId\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("uuid", "uuid", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"uuid\", \"uuid\",\n            reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str3 = this.nullableStringAdapter.fromJson(reader);
            } else if (selectName == 3) {
                num = this.nullableIntAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (str == null) {
            JsonDataException missingProperty = Util.missingProperty("referenceId", "referenceId", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"referen…eId\",\n            reader)");
            throw missingProperty;
        }
        if (str2 != null) {
            return new UploadResult(str, str2, str3, num);
        }
        JsonDataException missingProperty2 = Util.missingProperty("uuid", "uuid", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"uuid\", \"uuid\", reader)");
        throw missingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, UploadResult value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("referenceId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getReferenceId());
        writer.name("uuid");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getUuid());
        writer.name("error");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getError());
        writer.name("errorCode");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) value_.getErrorCode());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(34), "GeneratedJsonAdapter(", "UploadResult", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
