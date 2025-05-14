package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentComponentJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ConsentComponent;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableBooleanAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "stringAdapter", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConsentComponentJsonAdapter extends JsonAdapter<ConsentComponent> {
    private volatile Constructor<ConsentComponent> constructorRef;
    private final JsonAdapter<Boolean> nullableBooleanAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<String> stringAdapter;

    public ConsentComponentJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("id", "mandatory", "type", "content", "selected");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"id\", \"mandatory\", \"t…   \"content\", \"selected\")");
        this.options = of;
        this.nullableStringAdapter = a.a(moshi, String.class, "id", "moshi.adapter(String::cl…,\n      emptySet(), \"id\")");
        this.nullableBooleanAdapter = a.a(moshi, Boolean.class, "mandatory", "moshi.adapter(Boolean::c… emptySet(), \"mandatory\")");
        this.stringAdapter = a.a(moshi, String.class, "type", "moshi.adapter(String::cl…emptySet(),\n      \"type\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConsentComponent fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i = -1;
        String str = null;
        Boolean bool = null;
        String str2 = null;
        String str3 = null;
        Boolean bool2 = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(reader);
                i &= -2;
            } else if (selectName == 1) {
                bool = this.nullableBooleanAdapter.fromJson(reader);
            } else if (selectName == 2) {
                str2 = this.stringAdapter.fromJson(reader);
                if (str2 == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("type", "type", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"type\", \"type\",\n            reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 3) {
                str3 = this.stringAdapter.fromJson(reader);
                if (str3 == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("content", "content", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"content\"…       \"content\", reader)");
                    throw unexpectedNull2;
                }
            } else if (selectName == 4) {
                bool2 = this.nullableBooleanAdapter.fromJson(reader);
            }
        }
        reader.endObject();
        if (i == -2) {
            if (str2 == null) {
                JsonDataException missingProperty = Util.missingProperty("type", "type", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"type\", \"type\", reader)");
                throw missingProperty;
            }
            if (str3 != null) {
                return new ConsentComponent(str, bool, str2, str3, bool2);
            }
            JsonDataException missingProperty2 = Util.missingProperty("content", "content", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"content\", \"content\", reader)");
            throw missingProperty2;
        }
        Constructor<ConsentComponent> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ConsentComponent.class.getDeclaredConstructor(String.class, Boolean.class, String.class, String.class, Boolean.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "ConsentComponent::class.…his.constructorRef = it }");
        }
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = bool;
        if (str2 == null) {
            JsonDataException missingProperty3 = Util.missingProperty("type", "type", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"type\", \"type\", reader)");
            throw missingProperty3;
        }
        objArr[2] = str2;
        if (str3 == null) {
            JsonDataException missingProperty4 = Util.missingProperty("content", "content", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"content\", \"content\", reader)");
            throw missingProperty4;
        }
        objArr[3] = str3;
        objArr[4] = bool2;
        objArr[5] = Integer.valueOf(i);
        objArr[6] = null;
        ConsentComponent newInstance = constructor.newInstance(objArr);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConsentComponent value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("id");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getId());
        writer.name("mandatory");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) value_.getMandatory());
        writer.name("type");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getType());
        writer.name("content");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getContent());
        writer.name("selected");
        this.nullableBooleanAdapter.toJson(writer, (JsonWriter) value_.getSelected());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(38), "GeneratedJsonAdapter(", "ConsentComponent", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
