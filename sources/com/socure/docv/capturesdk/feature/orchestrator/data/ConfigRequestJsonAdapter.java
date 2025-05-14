package com.socure.docv.capturesdk.feature.orchestrator.data;

import com.socure.docv.capturesdk.api.Keys;
import com.socure.docv.capturesdk.common.network.model.stepup.a;
import com.socure.docv.capturesdk.common.network.model.stepup.b;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableFlowRequestAdapter", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/FlowRequest;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConfigRequestJsonAdapter extends JsonAdapter<ConfigRequest> {
    private volatile Constructor<ConfigRequest> constructorRef;
    private final JsonAdapter<FlowRequest> nullableFlowRequestAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public ConfigRequestJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(Keys.KEY_FLOW, "language");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"flow\", \"language\")");
        this.options = of;
        this.nullableFlowRequestAdapter = a.a(moshi, FlowRequest.class, Keys.KEY_FLOW, "moshi.adapter(FlowReques…java, emptySet(), \"flow\")");
        this.nullableStringAdapter = a.a(moshi, String.class, "language", "moshi.adapter(String::cl…  emptySet(), \"language\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public ConfigRequest fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        FlowRequest flowRequest = null;
        String str = null;
        int i = -1;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                flowRequest = this.nullableFlowRequestAdapter.fromJson(reader);
                i &= -2;
            } else if (selectName == 1) {
                str = this.nullableStringAdapter.fromJson(reader);
                i &= -3;
            }
        }
        reader.endObject();
        if (i == -4) {
            return new ConfigRequest(flowRequest, str);
        }
        Constructor<ConfigRequest> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = ConfigRequest.class.getDeclaredConstructor(FlowRequest.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "ConfigRequest::class.jav…his.constructorRef = it }");
        }
        ConfigRequest newInstance = constructor.newInstance(flowRequest, str, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, ConfigRequest value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name(Keys.KEY_FLOW);
        this.nullableFlowRequestAdapter.toJson(writer, (JsonWriter) value_.getFlow());
        writer.name("language");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getLanguage());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(35), "GeneratedJsonAdapter(", "ConfigRequest", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
