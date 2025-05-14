package com.socure.docv.capturesdk.common.network.model.stepup;

import com.socure.docv.capturesdk.feature.orchestrator.data.ConfigRequest;
import com.socure.docv.capturesdk.feature.orchestrator.data.EmptyDataClass;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/StartSessionRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/StartSessionRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "configRequestAdapter", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/ConfigRequest;", "constructorRef", "Ljava/lang/reflect/Constructor;", "emptyDataClassAdapter", "Lcom/socure/docv/capturesdk/feature/orchestrator/data/EmptyDataClass;", "intAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartSessionRequestJsonAdapter extends JsonAdapter<StartSessionRequest> {
    private final JsonAdapter<ConfigRequest> configRequestAdapter;
    private volatile Constructor<StartSessionRequest> constructorRef;
    private final JsonAdapter<EmptyDataClass> emptyDataClassAdapter;
    private final JsonAdapter<Integer> intAdapter;
    private final JsonReader.Options options;

    public StartSessionRequestJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("data", "verificationLevel", "config");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"data\", \"verificationLevel\",\n      \"config\")");
        this.options = of;
        this.emptyDataClassAdapter = a.a(moshi, EmptyDataClass.class, "data", "moshi.adapter(EmptyDataC…java, emptySet(), \"data\")");
        this.intAdapter = a.a(moshi, Integer.TYPE, "verificationLevel", "moshi.adapter(Int::class…     \"verificationLevel\")");
        this.configRequestAdapter = a.a(moshi, ConfigRequest.class, "config", "moshi.adapter(ConfigRequ…va, emptySet(), \"config\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public StartSessionRequest fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        Integer num = 0;
        reader.beginObject();
        int i = -1;
        EmptyDataClass emptyDataClass = null;
        ConfigRequest configRequest = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                emptyDataClass = this.emptyDataClassAdapter.fromJson(reader);
                if (emptyDataClass == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("data_", "data", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"data_\",\n…          \"data\", reader)");
                    throw unexpectedNull;
                }
                i &= -2;
            } else if (selectName == 1) {
                num = this.intAdapter.fromJson(reader);
                if (num == null) {
                    JsonDataException unexpectedNull2 = Util.unexpectedNull("verificationLevel", "verificationLevel", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"verifica…rificationLevel\", reader)");
                    throw unexpectedNull2;
                }
                i &= -3;
            } else if (selectName == 2 && (configRequest = this.configRequestAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull3 = Util.unexpectedNull("config", "config", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"config\",…        \"config\", reader)");
                throw unexpectedNull3;
            }
        }
        reader.endObject();
        if (i == -4) {
            if (emptyDataClass == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.feature.orchestrator.data.EmptyDataClass");
            }
            int intValue = num.intValue();
            if (configRequest != null) {
                return new StartSessionRequest(emptyDataClass, intValue, configRequest);
            }
            JsonDataException missingProperty = Util.missingProperty("config", "config", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"config\", \"config\", reader)");
            throw missingProperty;
        }
        Constructor<StartSessionRequest> constructor = this.constructorRef;
        if (constructor == null) {
            Class cls = Integer.TYPE;
            constructor = StartSessionRequest.class.getDeclaredConstructor(EmptyDataClass.class, cls, ConfigRequest.class, cls, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "StartSessionRequest::cla…his.constructorRef = it }");
        }
        Object[] objArr = new Object[5];
        objArr[0] = emptyDataClass;
        objArr[1] = num;
        if (configRequest == null) {
            JsonDataException missingProperty2 = Util.missingProperty("config", "config", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"config\", \"config\", reader)");
            throw missingProperty2;
        }
        objArr[2] = configRequest;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = null;
        StartSessionRequest newInstance = constructor.newInstance(objArr);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, StartSessionRequest value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("data");
        this.emptyDataClassAdapter.toJson(writer, (JsonWriter) value_.getData());
        writer.name("verificationLevel");
        this.intAdapter.toJson(writer, (JsonWriter) Integer.valueOf(value_.getVerificationLevel()));
        writer.name("config");
        this.configRequestAdapter.toJson(writer, (JsonWriter) value_.getConfig());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(41), "GeneratedJsonAdapter(", "StartSessionRequest", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
