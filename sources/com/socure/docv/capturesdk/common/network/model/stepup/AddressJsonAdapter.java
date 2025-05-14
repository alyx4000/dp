package com.socure.docv.capturesdk.common.network.model.stepup;

import androidx.autofill.HintConstants;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import io.sentry.protocol.Geo;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/AddressJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Address;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AddressJsonAdapter extends JsonAdapter<Address> {
    private volatile Constructor<Address> constructorRef;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public AddressJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("country", "physicalAddress", "physicalAddress2", Geo.JsonKeys.CITY, "state", HintConstants.AUTOFILL_HINT_POSTAL_CODE);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"country\", \"physicalA…\", \"state\", \"postalCode\")");
        this.options = of;
        this.nullableStringAdapter = a.a(moshi, String.class, "country", "moshi.adapter(String::cl…   emptySet(), \"country\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Address fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String str = null;
        int i = -1;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
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
                    str3 = this.nullableStringAdapter.fromJson(reader);
                    i &= -5;
                    break;
                case 3:
                    str4 = this.nullableStringAdapter.fromJson(reader);
                    i &= -9;
                    break;
                case 4:
                    str5 = this.nullableStringAdapter.fromJson(reader);
                    i &= -17;
                    break;
                case 5:
                    str6 = this.nullableStringAdapter.fromJson(reader);
                    i &= -33;
                    break;
            }
        }
        reader.endObject();
        if (i == -64) {
            return new Address(str, str2, str3, str4, str5, str6);
        }
        Constructor<Address> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = Address.class.getDeclaredConstructor(String.class, String.class, String.class, String.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "Address::class.java.getD…his.constructorRef = it }");
        }
        Address newInstance = constructor.newInstance(str, str2, str3, str4, str5, str6, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Address value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("country");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getCountry());
        writer.name("physicalAddress");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getPhysicalAddress());
        writer.name("physicalAddress2");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getPhysicalAddress2());
        writer.name(Geo.JsonKeys.CITY);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getCity());
        writer.name("state");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getState());
        writer.name(HintConstants.AUTOFILL_HINT_POSTAL_CODE);
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getPostalCode());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(29), "GeneratedJsonAdapter(", "Address", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
