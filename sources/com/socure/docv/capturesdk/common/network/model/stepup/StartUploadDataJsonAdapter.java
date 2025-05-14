package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadDataJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartUploadData;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "listOfTrackingPropertyAdapter", "", "Lcom/socure/docv/capturesdk/common/network/model/stepup/TrackingProperty;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartUploadDataJsonAdapter extends JsonAdapter<StartUploadData> {
    private volatile Constructor<StartUploadData> constructorRef;
    private final JsonAdapter<List<TrackingProperty>> listOfTrackingPropertyAdapter;
    private final JsonReader.Options options;

    public StartUploadDataJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("trackingProperties");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"trackingProperties\")");
        this.options = of;
        JsonAdapter<List<TrackingProperty>> adapter = moshi.adapter(Types.newParameterizedType(List.class, TrackingProperty.class), SetsKt.emptySet(), "trackingProperties");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…(), \"trackingProperties\")");
        this.listOfTrackingPropertyAdapter = adapter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public StartUploadData fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        List<TrackingProperty> list = null;
        int i = -1;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                list = this.listOfTrackingPropertyAdapter.fromJson(reader);
                if (list == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("trackingProperties", "trackingProperties", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"tracking…ckingProperties\", reader)");
                    throw unexpectedNull;
                }
                i &= -2;
            } else {
                continue;
            }
        }
        reader.endObject();
        if (i == -2) {
            if (list != null) {
                return new StartUploadData(list);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<com.socure.docv.capturesdk.common.network.model.stepup.TrackingProperty>");
        }
        Constructor<StartUploadData> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = StartUploadData.class.getDeclaredConstructor(List.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "StartUploadData::class.j…his.constructorRef = it }");
        }
        StartUploadData newInstance = constructor.newInstance(list, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, StartUploadData value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("trackingProperties");
        this.listOfTrackingPropertyAdapter.toJson(writer, (JsonWriter) value_.getTrackingProperties());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(37), "GeneratedJsonAdapter(", "StartUploadData", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
