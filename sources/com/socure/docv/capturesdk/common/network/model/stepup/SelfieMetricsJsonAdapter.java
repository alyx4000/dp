package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetricsJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/SelfieMetrics;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableDoubleAdapter", "", "nullableFloatAdapter", "", "nullableIntAdapter", "", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelfieMetricsJsonAdapter extends JsonAdapter<SelfieMetrics> {
    private volatile Constructor<SelfieMetrics> constructorRef;
    private final JsonAdapter<Double> nullableDoubleAdapter;
    private final JsonAdapter<Float> nullableFloatAdapter;
    private final JsonAdapter<Integer> nullableIntAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public SelfieMetricsJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("pitch", "yaw", "roll", "faceWidth", "faceHeight", "faceRatio", "displayText");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"pitch\", \"yaw\", \"roll…aceRatio\", \"displayText\")");
        this.options = of;
        this.nullableDoubleAdapter = a.a(moshi, Double.class, "pitch", "moshi.adapter(Double::cl…ype, emptySet(), \"pitch\")");
        this.nullableIntAdapter = a.a(moshi, Integer.class, "faceWidth", "moshi.adapter(Int::class… emptySet(), \"faceWidth\")");
        this.nullableFloatAdapter = a.a(moshi, Float.class, "faceRatio", "moshi.adapter(Float::cla… emptySet(), \"faceRatio\")");
        this.nullableStringAdapter = a.a(moshi, String.class, "displayText", "moshi.adapter(String::cl…mptySet(), \"displayText\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public SelfieMetrics fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Double d = null;
        int i = -1;
        Double d2 = null;
        Double d3 = null;
        Integer num = null;
        Integer num2 = null;
        Float f = null;
        String str = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    d = this.nullableDoubleAdapter.fromJson(reader);
                    i &= -2;
                    break;
                case 1:
                    d2 = this.nullableDoubleAdapter.fromJson(reader);
                    i &= -3;
                    break;
                case 2:
                    d3 = this.nullableDoubleAdapter.fromJson(reader);
                    i &= -5;
                    break;
                case 3:
                    num = this.nullableIntAdapter.fromJson(reader);
                    i &= -9;
                    break;
                case 4:
                    num2 = this.nullableIntAdapter.fromJson(reader);
                    i &= -17;
                    break;
                case 5:
                    f = this.nullableFloatAdapter.fromJson(reader);
                    i &= -33;
                    break;
                case 6:
                    str = this.nullableStringAdapter.fromJson(reader);
                    i &= -65;
                    break;
            }
        }
        reader.endObject();
        if (i == -128) {
            return new SelfieMetrics(d, d2, d3, num, num2, f, str);
        }
        Constructor<SelfieMetrics> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = SelfieMetrics.class.getDeclaredConstructor(Double.class, Double.class, Double.class, Integer.class, Integer.class, Float.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "SelfieMetrics::class.jav…his.constructorRef = it }");
        }
        SelfieMetrics newInstance = constructor.newInstance(d, d2, d3, num, num2, f, str, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, SelfieMetrics value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("pitch");
        this.nullableDoubleAdapter.toJson(writer, (JsonWriter) value_.getPitch());
        writer.name("yaw");
        this.nullableDoubleAdapter.toJson(writer, (JsonWriter) value_.getYaw());
        writer.name("roll");
        this.nullableDoubleAdapter.toJson(writer, (JsonWriter) value_.getRoll());
        writer.name("faceWidth");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) value_.getFaceWidth());
        writer.name("faceHeight");
        this.nullableIntAdapter.toJson(writer, (JsonWriter) value_.getFaceHeight());
        writer.name("faceRatio");
        this.nullableFloatAdapter.toJson(writer, (JsonWriter) value_.getFaceRatio());
        writer.name("displayText");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getDisplayText());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(35), "GeneratedJsonAdapter(", "SelfieMetrics", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
