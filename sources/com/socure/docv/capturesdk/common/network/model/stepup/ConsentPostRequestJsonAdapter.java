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

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentPostRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentPostRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "listOfSelectionAdapter", "", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Selection;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConsentPostRequestJsonAdapter extends JsonAdapter<ConsentPostRequest> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<List<Selection>> listOfSelectionAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsentPostRequestJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("consent", "version", "language", "selection");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"consent\", \"version\",…uage\",\n      \"selection\")");
        this.options = of;
        this.booleanAdapter = a.a(moshi, Boolean.TYPE, "consent", "moshi.adapter(Boolean::c…tySet(),\n      \"consent\")");
        this.stringAdapter = a.a(moshi, String.class, "version", "moshi.adapter(String::cl…tySet(),\n      \"version\")");
        JsonAdapter<List<Selection>> adapter = moshi.adapter(Types.newParameterizedType(List.class, Selection.class), SetsKt.emptySet(), "selection");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…Set(),\n      \"selection\")");
        this.listOfSelectionAdapter = adapter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsentPostRequest fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        String str = null;
        String str2 = null;
        List<Selection> list = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                bool = this.booleanAdapter.fromJson(reader);
                if (bool == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("consent", "consent", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"consent\"…       \"consent\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1) {
                str = this.stringAdapter.fromJson(reader);
                if (str == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("version", "version", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"version\"…       \"version\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull3 = Util.unexpectedNull("language", "language", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"language…      \"language\", reader)");
                    throw unexpectedNull3;
                }
            } else if (selectName == 3 && (list = this.listOfSelectionAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull4 = Util.unexpectedNull("selection", "selection", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"selection\", \"selection\", reader)");
                throw unexpectedNull4;
            }
        }
        reader.endObject();
        if (bool == null) {
            JsonDataException missingProperty = Util.missingProperty("consent", "consent", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"consent\", \"consent\", reader)");
            throw missingProperty;
        }
        boolean booleanValue = bool.booleanValue();
        if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("version", "version", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"version\", \"version\", reader)");
            throw missingProperty2;
        }
        if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("language", "language", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"language\", \"language\", reader)");
            throw missingProperty3;
        }
        if (list != null) {
            return new ConsentPostRequest(booleanValue, str, str2, list);
        }
        JsonDataException missingProperty4 = Util.missingProperty("selection", "selection", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"selection\", \"selection\", reader)");
        throw missingProperty4;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsentPostRequest value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("consent");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(value_.getConsent()));
        writer.name("version");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getVersion());
        writer.name("language");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getLanguage());
        writer.name("selection");
        this.listOfSelectionAdapter.toJson(writer, (JsonWriter) value_.getSelection());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(40), "GeneratedJsonAdapter(", "ConsentPostRequest", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
