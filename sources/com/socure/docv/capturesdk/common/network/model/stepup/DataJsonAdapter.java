package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/DataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Data;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "startConfigAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartConfig;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DataJsonAdapter extends JsonAdapter<Data> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<StartConfig> startConfigAdapter;
    private final JsonAdapter<String> stringAdapter;

    public DataJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("isInternal", "eventId", "accountId", "referenceId", "environment", "config");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"isInternal\", \"eventI… \"environment\", \"config\")");
        this.options = of;
        this.booleanAdapter = a.a(moshi, Boolean.TYPE, "isInternal", "moshi.adapter(Boolean::c…et(),\n      \"isInternal\")");
        this.stringAdapter = a.a(moshi, String.class, "eventId", "moshi.adapter(String::cl…tySet(),\n      \"eventId\")");
        this.intAdapter = a.a(moshi, Integer.TYPE, "accountId", "moshi.adapter(Int::class… emptySet(), \"accountId\")");
        this.startConfigAdapter = a.a(moshi, StartConfig.class, "config", "moshi.adapter(StartConfi…    emptySet(), \"config\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Data fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        StartConfig startConfig = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    bool = this.booleanAdapter.fromJson(reader);
                    if (bool == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("isInternal", "isInternal", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"isIntern…    \"isInternal\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("eventId", "eventId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"eventId\"…       \"eventId\", reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    num = this.intAdapter.fromJson(reader);
                    if (num == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("accountId", "accountId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"accountI…     \"accountId\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("referenceId", "referenceId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"referenc…\", \"referenceId\", reader)");
                        throw unexpectedNull4;
                    }
                    break;
                case 4:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("environment", "environment", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"environm…\", \"environment\", reader)");
                        throw unexpectedNull5;
                    }
                    break;
                case 5:
                    startConfig = this.startConfigAdapter.fromJson(reader);
                    if (startConfig == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("config", "config", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"config\",…        \"config\", reader)");
                        throw unexpectedNull6;
                    }
                    break;
            }
        }
        reader.endObject();
        if (bool == null) {
            JsonDataException missingProperty = Util.missingProperty("isInternal", "isInternal", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"isInter…l\", \"isInternal\", reader)");
            throw missingProperty;
        }
        boolean booleanValue = bool.booleanValue();
        if (str == null) {
            JsonDataException missingProperty2 = Util.missingProperty("eventId", "eventId", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"eventId\", \"eventId\", reader)");
            throw missingProperty2;
        }
        if (num == null) {
            JsonDataException missingProperty3 = Util.missingProperty("accountId", "accountId", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"accountId\", \"accountId\", reader)");
            throw missingProperty3;
        }
        int intValue = num.intValue();
        if (str2 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("referenceId", "referenceId", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"referen…eId\",\n            reader)");
            throw missingProperty4;
        }
        if (str3 == null) {
            JsonDataException missingProperty5 = Util.missingProperty("environment", "environment", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"environ…ent\",\n            reader)");
            throw missingProperty5;
        }
        if (startConfig != null) {
            return new Data(booleanValue, str, intValue, str2, str3, startConfig);
        }
        JsonDataException missingProperty6 = Util.missingProperty("config", "config", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"config\", \"config\", reader)");
        throw missingProperty6;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Data value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("isInternal");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(value_.isInternal()));
        writer.name("eventId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getEventId());
        writer.name("accountId");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(value_.getAccountId()));
        writer.name("referenceId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getReferenceId());
        writer.name("environment");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getEnvironment());
        writer.name("config");
        this.startConfigAdapter.toJson(writer, (JsonWriter) value_.getConfig());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(26), "GeneratedJsonAdapter(", "Data", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
