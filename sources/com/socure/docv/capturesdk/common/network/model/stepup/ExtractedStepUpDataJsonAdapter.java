package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import io.sentry.SentryLockReason;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpDataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableAddressAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Address;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExtractedStepUpDataJsonAdapter extends JsonAdapter<ExtractedStepUpData> {
    private volatile Constructor<ExtractedStepUpData> constructorRef;
    private final JsonAdapter<Address> nullableAddressAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ExtractedStepUpDataJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("issueDate", SentryLockReason.JsonKeys.ADDRESS, "parsedAddress", "type", "firstName", "surName", "dob", "expirationDate", "documentNumber", "fullName");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"issueDate\", \"address…umber\",\n      \"fullName\")");
        this.options = of;
        this.nullableStringAdapter = a.a(moshi, String.class, "issueDate", "moshi.adapter(String::cl… emptySet(), \"issueDate\")");
        this.nullableAddressAdapter = a.a(moshi, Address.class, "parsedAddress", "moshi.adapter(Address::c…tySet(), \"parsedAddress\")");
        this.stringAdapter = a.a(moshi, String.class, "type", "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ExtractedStepUpData fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i = -1;
        String str = null;
        String str2 = null;
        Address address = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    str = this.nullableStringAdapter.fromJson(reader);
                    i &= -2;
                    break;
                case 1:
                    str2 = this.nullableStringAdapter.fromJson(reader);
                    i &= -3;
                    break;
                case 2:
                    address = this.nullableAddressAdapter.fromJson(reader);
                    i &= -5;
                    break;
                case 3:
                    str3 = this.stringAdapter.fromJson(reader);
                    if (str3 == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\", \"type\",\n            reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 4:
                    str4 = this.nullableStringAdapter.fromJson(reader);
                    i &= -17;
                    break;
                case 5:
                    str5 = this.nullableStringAdapter.fromJson(reader);
                    i &= -33;
                    break;
                case 6:
                    str6 = this.nullableStringAdapter.fromJson(reader);
                    i &= -65;
                    break;
                case 7:
                    str7 = this.nullableStringAdapter.fromJson(reader);
                    i &= -129;
                    break;
                case 8:
                    str8 = this.nullableStringAdapter.fromJson(reader);
                    i &= -257;
                    break;
                case 9:
                    str9 = this.nullableStringAdapter.fromJson(reader);
                    i &= -513;
                    break;
            }
        }
        reader.endObject();
        if (i == -1016) {
            if (str3 != null) {
                return new ExtractedStepUpData(str, str2, address, str3, str4, str5, str6, str7, str8, str9);
            }
            JsonDataException missingProperty = Util.missingProperty("type", "type", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty;
        }
        Constructor<ExtractedStepUpData> constructor = this.constructorRef;
        int i2 = 12;
        if (constructor == null) {
            constructor = ExtractedStepUpData.class.getDeclaredConstructor(String.class, String.class, Address.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "ExtractedStepUpData::cla…his.constructorRef = it }");
            i2 = 12;
        }
        Object[] objArr = new Object[i2];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = address;
        if (str3 == null) {
            JsonDataException missingProperty2 = Util.missingProperty("type", "type", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty2;
        }
        objArr[3] = str3;
        objArr[4] = str4;
        objArr[5] = str5;
        objArr[6] = str6;
        objArr[7] = str7;
        objArr[8] = str8;
        objArr[9] = str9;
        objArr[10] = Integer.valueOf(i);
        objArr[11] = null;
        ExtractedStepUpData newInstance = constructor.newInstance(objArr);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ExtractedStepUpData value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("issueDate");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getIssueDate());
        writer.name(SentryLockReason.JsonKeys.ADDRESS);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getAddress());
        writer.name("parsedAddress");
        this.nullableAddressAdapter.toJson(writer, (JsonWriter) value_.getParsedAddress());
        writer.name("type");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getType());
        writer.name("firstName");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getFirstName());
        writer.name("surName");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getSurName());
        writer.name("dob");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getDob());
        writer.name("expirationDate");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getExpirationDate());
        writer.name("documentNumber");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getDocumentNumber());
        writer.name("fullName");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getFullName());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(41), "GeneratedJsonAdapter(", "ExtractedStepUpData", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
