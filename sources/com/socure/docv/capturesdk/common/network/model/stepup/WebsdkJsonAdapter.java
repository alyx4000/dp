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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u001a\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010!\u001a\u00020\fH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/WebsdkJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Websdk;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "enableSelfieAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/EnableSelfie;", "listOfStringAdapter", "", "", "manualCaptureTimeoutAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ManualCaptureTimeout;", "maxSubmitCountAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/MaxSubmitCount;", "minMaxAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/MinMax;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "persistCaptureStateAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/PersistCaptureState;", "showCameraPrimingAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ShowCameraPriming;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WebsdkJsonAdapter extends JsonAdapter<Websdk> {
    private volatile Constructor<Websdk> constructorRef;
    private final JsonAdapter<EnableSelfie> enableSelfieAdapter;
    private final JsonAdapter<List<String>> listOfStringAdapter;
    private final JsonAdapter<ManualCaptureTimeout> manualCaptureTimeoutAdapter;
    private final JsonAdapter<MaxSubmitCount> maxSubmitCountAdapter;
    private final JsonAdapter<MinMax> minMaxAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<PersistCaptureState> persistCaptureStateAdapter;
    private final JsonAdapter<ShowCameraPriming> showCameraPrimingAdapter;

    public WebsdkJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("enableSelfie", "manualCaptureTimeout", "documentTypes", "ivsMaxSubmitCount", "showCameraPriming", "selfiePitch", "selfieRoll", "selfieYaw", "persistCaptureState");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"enableSelfie\",\n     …\", \"persistCaptureState\")");
        this.options = of;
        this.enableSelfieAdapter = a.a(moshi, EnableSelfie.class, "enableSelfie", "moshi.adapter(EnableSelf…ptySet(), \"enableSelfie\")");
        this.manualCaptureTimeoutAdapter = a.a(moshi, ManualCaptureTimeout.class, "manualCaptureTimeout", "moshi.adapter(ManualCapt…, \"manualCaptureTimeout\")");
        JsonAdapter<List<String>> adapter = moshi.adapter(Types.newParameterizedType(List.class, String.class), SetsKt.emptySet(), "documentTypes");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(Types.newP…),\n      \"documentTypes\")");
        this.listOfStringAdapter = adapter;
        this.maxSubmitCountAdapter = a.a(moshi, MaxSubmitCount.class, "ivsMaxSubmitCount", "moshi.adapter(MaxSubmitC…t(), \"ivsMaxSubmitCount\")");
        this.showCameraPrimingAdapter = a.a(moshi, ShowCameraPriming.class, "showCameraPriming", "moshi.adapter(ShowCamera…t(), \"showCameraPriming\")");
        this.minMaxAdapter = a.a(moshi, MinMax.class, "selfiePitch", "moshi.adapter(MinMax::cl…t(),\n      \"selfiePitch\")");
        this.persistCaptureStateAdapter = a.a(moshi, PersistCaptureState.class, "persistCaptureState", "moshi.adapter(PersistCap…), \"persistCaptureState\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Websdk fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        int i = -1;
        EnableSelfie enableSelfie = null;
        ManualCaptureTimeout manualCaptureTimeout = null;
        List<String> list = null;
        MaxSubmitCount maxSubmitCount = null;
        ShowCameraPriming showCameraPriming = null;
        MinMax minMax = null;
        MinMax minMax2 = null;
        MinMax minMax3 = null;
        PersistCaptureState persistCaptureState = null;
        while (reader.hasNext()) {
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    enableSelfie = this.enableSelfieAdapter.fromJson(reader);
                    if (enableSelfie == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("enableSelfie", "enableSelfie", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"enableSe…, \"enableSelfie\", reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    manualCaptureTimeout = this.manualCaptureTimeoutAdapter.fromJson(reader);
                    if (manualCaptureTimeout == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("manualCaptureTimeout", "manualCaptureTimeout", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"manualCa…lCaptureTimeout\", reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    list = this.listOfStringAdapter.fromJson(reader);
                    if (list == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("documentTypes", "documentTypes", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"document… \"documentTypes\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    maxSubmitCount = this.maxSubmitCountAdapter.fromJson(reader);
                    if (maxSubmitCount == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("ivsMaxSubmitCount", "ivsMaxSubmitCount", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"ivsMaxSu…sMaxSubmitCount\", reader)");
                        throw unexpectedNull4;
                    }
                    i &= -9;
                    break;
                case 4:
                    showCameraPriming = this.showCameraPrimingAdapter.fromJson(reader);
                    if (showCameraPriming == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("showCameraPriming", "showCameraPriming", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"showCame…owCameraPriming\", reader)");
                        throw unexpectedNull5;
                    }
                    i &= -17;
                    break;
                case 5:
                    minMax = this.minMaxAdapter.fromJson(reader);
                    if (minMax == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("selfiePitch", "selfiePitch", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"selfiePi…   \"selfiePitch\", reader)");
                        throw unexpectedNull6;
                    }
                    i &= -33;
                    break;
                case 6:
                    minMax2 = this.minMaxAdapter.fromJson(reader);
                    if (minMax2 == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull("selfieRoll", "selfieRoll", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"selfieRo…    \"selfieRoll\", reader)");
                        throw unexpectedNull7;
                    }
                    i &= -65;
                    break;
                case 7:
                    minMax3 = this.minMaxAdapter.fromJson(reader);
                    if (minMax3 == null) {
                        JsonDataException unexpectedNull8 = Util.unexpectedNull("selfieYaw", "selfieYaw", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull8, "unexpectedNull(\"selfieYa…     \"selfieYaw\", reader)");
                        throw unexpectedNull8;
                    }
                    i &= -129;
                    break;
                case 8:
                    persistCaptureState = this.persistCaptureStateAdapter.fromJson(reader);
                    if (persistCaptureState == null) {
                        JsonDataException unexpectedNull9 = Util.unexpectedNull("persistCaptureState", "persistCaptureState", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull9, "unexpectedNull(\"persistC…istCaptureState\", reader)");
                        throw unexpectedNull9;
                    }
                    i &= -257;
                    break;
            }
        }
        reader.endObject();
        if (i == -505) {
            if (enableSelfie == null) {
                JsonDataException missingProperty = Util.missingProperty("enableSelfie", "enableSelfie", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"enableS…e\",\n              reader)");
                throw missingProperty;
            }
            if (manualCaptureTimeout == null) {
                JsonDataException missingProperty2 = Util.missingProperty("manualCaptureTimeout", "manualCaptureTimeout", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"manualC…lCaptureTimeout\", reader)");
                throw missingProperty2;
            }
            if (list == null) {
                JsonDataException missingProperty3 = Util.missingProperty("documentTypes", "documentTypes", reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"documen… \"documentTypes\", reader)");
                throw missingProperty3;
            }
            if (maxSubmitCount == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.MaxSubmitCount");
            }
            if (showCameraPriming == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.ShowCameraPriming");
            }
            if (minMax == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.MinMax");
            }
            if (minMax2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.MinMax");
            }
            if (minMax3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.MinMax");
            }
            if (persistCaptureState != null) {
                return new Websdk(enableSelfie, manualCaptureTimeout, list, maxSubmitCount, showCameraPriming, minMax, minMax2, minMax3, persistCaptureState);
            }
            throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.common.network.model.stepup.PersistCaptureState");
        }
        Constructor<Websdk> constructor = this.constructorRef;
        int i2 = 11;
        if (constructor == null) {
            constructor = Websdk.class.getDeclaredConstructor(EnableSelfie.class, ManualCaptureTimeout.class, List.class, MaxSubmitCount.class, ShowCameraPriming.class, MinMax.class, MinMax.class, MinMax.class, PersistCaptureState.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "Websdk::class.java.getDe…his.constructorRef = it }");
            i2 = 11;
        }
        Object[] objArr = new Object[i2];
        if (enableSelfie == null) {
            JsonDataException missingProperty4 = Util.missingProperty("enableSelfie", "enableSelfie", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"enableS…, \"enableSelfie\", reader)");
            throw missingProperty4;
        }
        objArr[0] = enableSelfie;
        if (manualCaptureTimeout == null) {
            JsonDataException missingProperty5 = Util.missingProperty("manualCaptureTimeout", "manualCaptureTimeout", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"manualC…lCaptureTimeout\", reader)");
            throw missingProperty5;
        }
        objArr[1] = manualCaptureTimeout;
        if (list == null) {
            JsonDataException missingProperty6 = Util.missingProperty("documentTypes", "documentTypes", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"documen… \"documentTypes\", reader)");
            throw missingProperty6;
        }
        objArr[2] = list;
        objArr[3] = maxSubmitCount;
        objArr[4] = showCameraPriming;
        objArr[5] = minMax;
        objArr[6] = minMax2;
        objArr[7] = minMax3;
        objArr[8] = persistCaptureState;
        objArr[9] = Integer.valueOf(i);
        objArr[10] = null;
        Websdk newInstance = constructor.newInstance(objArr);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Websdk value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("enableSelfie");
        this.enableSelfieAdapter.toJson(writer, (JsonWriter) value_.getEnableSelfie());
        writer.name("manualCaptureTimeout");
        this.manualCaptureTimeoutAdapter.toJson(writer, (JsonWriter) value_.getManualCaptureTimeout());
        writer.name("documentTypes");
        this.listOfStringAdapter.toJson(writer, (JsonWriter) value_.getDocumentTypes());
        writer.name("ivsMaxSubmitCount");
        this.maxSubmitCountAdapter.toJson(writer, (JsonWriter) value_.getIvsMaxSubmitCount());
        writer.name("showCameraPriming");
        this.showCameraPrimingAdapter.toJson(writer, (JsonWriter) value_.getShowCameraPriming());
        writer.name("selfiePitch");
        this.minMaxAdapter.toJson(writer, (JsonWriter) value_.getSelfiePitch());
        writer.name("selfieRoll");
        this.minMaxAdapter.toJson(writer, (JsonWriter) value_.getSelfieRoll());
        writer.name("selfieYaw");
        this.minMaxAdapter.toJson(writer, (JsonWriter) value_.getSelfieYaw());
        writer.name("persistCaptureState");
        this.persistCaptureStateAdapter.toJson(writer, (JsonWriter) value_.getPersistCaptureState());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(28), "GeneratedJsonAdapter(", "Websdk", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
