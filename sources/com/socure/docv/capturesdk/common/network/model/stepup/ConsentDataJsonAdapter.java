package com.socure.docv.capturesdk.common.network.model.stepup;

import com.amplitude.reactnative.DatabaseConstants;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentDataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentData;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConsentDataJsonAdapter extends JsonAdapter<ConsentData> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsentDataJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(DatabaseConstants.KEY_FIELD, "eventId", "consent", "consentTimestamp", "consentExpiryTimestamp", "expiry", ApiConstant.CONSENT_ID);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"key\", \"eventId\", \"co…\", \"expiry\", \"consentId\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, DatabaseConstants.KEY_FIELD, "moshi.adapter(String::cl… emptySet(),\n      \"key\")");
        this.booleanAdapter = a.a(moshi, Boolean.TYPE, "consent", "moshi.adapter(Boolean::c…tySet(),\n      \"consent\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsentData fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        Boolean bool2 = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        while (true) {
            String str6 = str5;
            if (!reader.hasNext()) {
                reader.endObject();
                if (str == null) {
                    JsonDataException missingProperty = Util.missingProperty(DatabaseConstants.KEY_FIELD, DatabaseConstants.KEY_FIELD, reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"key\", \"key\", reader)");
                    throw missingProperty;
                }
                if (str2 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("eventId", "eventId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"eventId\", \"eventId\", reader)");
                    throw missingProperty2;
                }
                if (bool == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("consent", "consent", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"consent\", \"consent\", reader)");
                    throw missingProperty3;
                }
                boolean booleanValue = bool.booleanValue();
                if (str3 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("consentTimestamp", "consentTimestamp", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"consent…onsentTimestamp\", reader)");
                    throw missingProperty4;
                }
                if (str4 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("consentExpiryTimestamp", "consentExpiryTimestamp", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"consent…ExpiryTimestamp\", reader)");
                    throw missingProperty5;
                }
                if (bool2 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("expiry", "expiry", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"expiry\", \"expiry\", reader)");
                    throw missingProperty6;
                }
                boolean booleanValue2 = bool2.booleanValue();
                if (str6 != null) {
                    return new ConsentData(str, str2, booleanValue, str3, str4, booleanValue2, str6);
                }
                JsonDataException missingProperty7 = Util.missingProperty(ApiConstant.CONSENT_ID, ApiConstant.CONSENT_ID, reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"consentId\", \"consentId\", reader)");
                throw missingProperty7;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull(DatabaseConstants.KEY_FIELD, DatabaseConstants.KEY_FIELD, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"key\", \"key\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("eventId", "eventId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"eventId\"…       \"eventId\", reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    bool = this.booleanAdapter.fromJson(reader);
                    if (bool == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("consent", "consent", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"consent\"…       \"consent\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("consentTimestamp", "consentTimestamp", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"consentT…onsentTimestamp\", reader)");
                        throw unexpectedNull4;
                    }
                    break;
                case 4:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("consentExpiryTimestamp", "consentExpiryTimestamp", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"consentE…ExpiryTimestamp\", reader)");
                        throw unexpectedNull5;
                    }
                    break;
                case 5:
                    bool2 = this.booleanAdapter.fromJson(reader);
                    if (bool2 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("expiry", "expiry", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"expiry\",…        \"expiry\", reader)");
                        throw unexpectedNull6;
                    }
                    break;
                case 6:
                    str5 = this.stringAdapter.fromJson(reader);
                    if (str5 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull(ApiConstant.CONSENT_ID, ApiConstant.CONSENT_ID, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"consentI…     \"consentId\", reader)");
                        throw unexpectedNull7;
                    }
                    continue;
            }
            str5 = str6;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsentData value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name(DatabaseConstants.KEY_FIELD);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getKey());
        writer.name("eventId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getEventId());
        writer.name("consent");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(value_.getConsent()));
        writer.name("consentTimestamp");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getConsentTimestamp());
        writer.name("consentExpiryTimestamp");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getConsentExpiryTimestamp());
        writer.name("expiry");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(value_.getExpiry()));
        writer.name(ApiConstant.CONSENT_ID);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getConsentId());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(33), "GeneratedJsonAdapter(", "ConsentData", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
