package com.socure.docv.capturesdk.common.network.model.stepup;

import com.iterable.iterableapi.IterableConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadStatusDataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadStatusData;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "booleanAdapter", "", "environmentAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Environment;", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadStatusDataJsonAdapter extends JsonAdapter<UploadStatusData> {
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Environment> environmentAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public UploadStatusDataJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("eventId", "verificationLevel", "publicAccountId", "publicApiKey", "flowVersion", "flowName", IterableConstants.KEY_TOKEN, "isInternal", "accountId", "createdAt", "environment", "expired", "id", "publicId", "updatedAt");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"eventId\", \"verificat… \"publicId\", \"updatedAt\")");
        this.options = of;
        this.stringAdapter = a.a(moshi, String.class, "eventId", "moshi.adapter(String::cl…tySet(),\n      \"eventId\")");
        this.booleanAdapter = a.a(moshi, Boolean.TYPE, "isInternal", "moshi.adapter(Boolean::c…et(),\n      \"isInternal\")");
        this.intAdapter = a.a(moshi, Integer.TYPE, "accountId", "moshi.adapter(Int::class… emptySet(), \"accountId\")");
        this.environmentAdapter = a.a(moshi, Environment.class, "environment", "moshi.adapter(Environmen…mptySet(), \"environment\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public UploadStatusData fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        Integer num = null;
        String str = null;
        Boolean bool2 = null;
        Integer num2 = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        Environment environment = null;
        String str9 = null;
        String str10 = null;
        while (true) {
            Integer num3 = num2;
            Boolean bool3 = bool2;
            Environment environment2 = environment;
            String str11 = str8;
            Integer num4 = num;
            Boolean bool4 = bool;
            String str12 = str7;
            String str13 = str6;
            String str14 = str5;
            String str15 = str4;
            String str16 = str3;
            String str17 = str2;
            String str18 = str;
            if (!reader.hasNext()) {
                reader.endObject();
                if (str18 == null) {
                    JsonDataException missingProperty = Util.missingProperty("eventId", "eventId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"eventId\", \"eventId\", reader)");
                    throw missingProperty;
                }
                if (str17 == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("verificationLevel", "verificationLevel", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"verific…rificationLevel\", reader)");
                    throw missingProperty2;
                }
                if (str16 == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("publicAccountId", "publicAccountId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"publicA…publicAccountId\", reader)");
                    throw missingProperty3;
                }
                if (str15 == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("publicApiKey", "publicApiKey", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"publicA…Key\",\n            reader)");
                    throw missingProperty4;
                }
                if (str14 == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("flowVersion", "flowVersion", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"flowVer…ion\",\n            reader)");
                    throw missingProperty5;
                }
                if (str13 == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("flowName", "flowName", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"flowName\", \"flowName\", reader)");
                    throw missingProperty6;
                }
                if (str12 == null) {
                    JsonDataException missingProperty7 = Util.missingProperty(IterableConstants.KEY_TOKEN, IterableConstants.KEY_TOKEN, reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"token\", \"token\", reader)");
                    throw missingProperty7;
                }
                if (bool4 == null) {
                    JsonDataException missingProperty8 = Util.missingProperty("isInternal", "isInternal", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty8, "missingProperty(\"isInter…l\", \"isInternal\", reader)");
                    throw missingProperty8;
                }
                boolean booleanValue = bool4.booleanValue();
                if (num4 == null) {
                    JsonDataException missingProperty9 = Util.missingProperty("accountId", "accountId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty9, "missingProperty(\"accountId\", \"accountId\", reader)");
                    throw missingProperty9;
                }
                int intValue = num4.intValue();
                if (str11 == null) {
                    JsonDataException missingProperty10 = Util.missingProperty("createdAt", "createdAt", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty10, "missingProperty(\"createdAt\", \"createdAt\", reader)");
                    throw missingProperty10;
                }
                if (environment2 == null) {
                    JsonDataException missingProperty11 = Util.missingProperty("environment", "environment", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty11, "missingProperty(\"environ…ent\",\n            reader)");
                    throw missingProperty11;
                }
                if (bool3 == null) {
                    JsonDataException missingProperty12 = Util.missingProperty("expired", "expired", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty12, "missingProperty(\"expired\", \"expired\", reader)");
                    throw missingProperty12;
                }
                boolean booleanValue2 = bool3.booleanValue();
                if (num3 == null) {
                    JsonDataException missingProperty13 = Util.missingProperty("id", "id", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty13, "missingProperty(\"id\", \"id\", reader)");
                    throw missingProperty13;
                }
                int intValue2 = num3.intValue();
                if (str9 == null) {
                    JsonDataException missingProperty14 = Util.missingProperty("publicId", "publicId", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty14, "missingProperty(\"publicId\", \"publicId\", reader)");
                    throw missingProperty14;
                }
                if (str10 != null) {
                    return new UploadStatusData(str18, str17, str16, str15, str14, str13, str12, booleanValue, intValue, str11, environment2, booleanValue2, intValue2, str9, str10);
                }
                JsonDataException missingProperty15 = Util.missingProperty("updatedAt", "updatedAt", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty15, "missingProperty(\"updatedAt\", \"updatedAt\", reader)");
                throw missingProperty15;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 0:
                    String fromJson = this.stringAdapter.fromJson(reader);
                    if (fromJson == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("eventId", "eventId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"eventId\"…       \"eventId\", reader)");
                        throw unexpectedNull;
                    }
                    str = fromJson;
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                case 1:
                    str2 = this.stringAdapter.fromJson(reader);
                    if (str2 == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("verificationLevel", "verificationLevel", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"verifica…rificationLevel\", reader)");
                        throw unexpectedNull2;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str = str18;
                case 2:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("publicAccountId", "publicAccountId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"publicAc…publicAccountId\", reader)");
                        throw unexpectedNull3;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str2 = str17;
                    str = str18;
                case 3:
                    str4 = this.stringAdapter.fromJson(reader);
                    if (str4 == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("publicApiKey", "publicApiKey", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"publicAp…, \"publicApiKey\", reader)");
                        throw unexpectedNull4;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 4:
                    str5 = this.stringAdapter.fromJson(reader);
                    if (str5 == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("flowVersion", "flowVersion", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"flowVers…\", \"flowVersion\", reader)");
                        throw unexpectedNull5;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 5:
                    str6 = this.stringAdapter.fromJson(reader);
                    if (str6 == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("flowName", "flowName", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"flowName…      \"flowName\", reader)");
                        throw unexpectedNull6;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 6:
                    str7 = this.stringAdapter.fromJson(reader);
                    if (str7 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull(IterableConstants.KEY_TOKEN, IterableConstants.KEY_TOKEN, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"token\", …ken\",\n            reader)");
                        throw unexpectedNull7;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 7:
                    bool = this.booleanAdapter.fromJson(reader);
                    if (bool == null) {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("isInternal", "isInternal", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"isIntern…    \"isInternal\", reader)");
                        throw unexpectedNull8;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 8:
                    num = this.intAdapter.fromJson(reader);
                    if (num == null) {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("accountId", "accountId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"accountI…     \"accountId\", reader)");
                        throw unexpectedNull9;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 9:
                    str8 = this.stringAdapter.fromJson(reader);
                    if (str8 == null) {
                        JsonDataException unexpectedNull10 = Util.unexpectedNull("createdAt", "createdAt", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull10, "unexpectedNull(\"createdA…     \"createdAt\", reader)");
                        throw unexpectedNull10;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 10:
                    environment = this.environmentAdapter.fromJson(reader);
                    if (environment == null) {
                        JsonDataException unexpectedNull11 = Util.unexpectedNull("environment", "environment", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull11, "unexpectedNull(\"environm…\", \"environment\", reader)");
                        throw unexpectedNull11;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 11:
                    bool2 = this.booleanAdapter.fromJson(reader);
                    if (bool2 == null) {
                        JsonDataException unexpectedNull12 = Util.unexpectedNull("expired", "expired", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull12, "unexpectedNull(\"expired\"…       \"expired\", reader)");
                        throw unexpectedNull12;
                    }
                    num2 = num3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 12:
                    num2 = this.intAdapter.fromJson(reader);
                    if (num2 == null) {
                        JsonDataException unexpectedNull13 = Util.unexpectedNull("id", "id", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull13, "unexpectedNull(\"id\", \"id\", reader)");
                        throw unexpectedNull13;
                    }
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 13:
                    str9 = this.stringAdapter.fromJson(reader);
                    if (str9 == null) {
                        JsonDataException unexpectedNull14 = Util.unexpectedNull("publicId", "publicId", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull14, "unexpectedNull(\"publicId…      \"publicId\", reader)");
                        throw unexpectedNull14;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                case 14:
                    str10 = this.stringAdapter.fromJson(reader);
                    if (str10 == null) {
                        JsonDataException unexpectedNull15 = Util.unexpectedNull("updatedAt", "updatedAt", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull15, "unexpectedNull(\"updatedA…     \"updatedAt\", reader)");
                        throw unexpectedNull15;
                    }
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
                default:
                    num2 = num3;
                    bool2 = bool3;
                    environment = environment2;
                    str8 = str11;
                    num = num4;
                    bool = bool4;
                    str7 = str12;
                    str6 = str13;
                    str5 = str14;
                    str4 = str15;
                    str3 = str16;
                    str2 = str17;
                    str = str18;
            }
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, UploadStatusData value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("eventId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getEventId());
        writer.name("verificationLevel");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getVerificationLevel());
        writer.name("publicAccountId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPublicAccountId());
        writer.name("publicApiKey");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPublicApiKey());
        writer.name("flowVersion");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFlowVersion());
        writer.name("flowName");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getFlowName());
        writer.name(IterableConstants.KEY_TOKEN);
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getToken());
        writer.name("isInternal");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(value_.isInternal()));
        writer.name("accountId");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(value_.getAccountId()));
        writer.name("createdAt");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getCreatedAt());
        writer.name("environment");
        this.environmentAdapter.toJson(writer, (JsonWriter) value_.getEnvironment());
        writer.name("expired");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(value_.getExpired()));
        writer.name("id");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(value_.getId()));
        writer.name("publicId");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getPublicId());
        writer.name("updatedAt");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getUpdatedAt());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(38), "GeneratedJsonAdapter(", "UploadStatusData", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
