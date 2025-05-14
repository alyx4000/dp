package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import java.lang.reflect.Constructor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0016\u001a\u00020\u000bH\u0016R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndRequestJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadEndRequest;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "constructorRef", "Ljava/lang/reflect/Constructor;", "nullableExtractedStepUpDataAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "nullableStringAdapter", "", "options", "Lcom/squareup/moshi/JsonReader$Options;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UploadEndRequestJsonAdapter extends JsonAdapter<UploadEndRequest> {
    private volatile Constructor<UploadEndRequest> constructorRef;
    private final JsonAdapter<ExtractedStepUpData> nullableExtractedStepUpDataAdapter;
    private final JsonAdapter<String> nullableStringAdapter;
    private final JsonReader.Options options;

    public UploadEndRequestJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("documentsReferenceId", "documentInfo", "documentsUuid", "documentVerificationToken");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"documentsReferenceId…cumentVerificationToken\")");
        this.options = of;
        this.nullableStringAdapter = a.a(moshi, String.class, "documentsReferenceId", "moshi.adapter(String::cl…, \"documentsReferenceId\")");
        this.nullableExtractedStepUpDataAdapter = a.a(moshi, ExtractedStepUpData.class, "documentInfo", "moshi.adapter(ExtractedS…ptySet(), \"documentInfo\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public UploadEndRequest fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        String str = null;
        ExtractedStepUpData extractedStepUpData = null;
        String str2 = null;
        String str3 = null;
        int i = -1;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                str = this.nullableStringAdapter.fromJson(reader);
                i &= -2;
            } else if (selectName == 1) {
                extractedStepUpData = this.nullableExtractedStepUpDataAdapter.fromJson(reader);
                i &= -3;
            } else if (selectName == 2) {
                str2 = this.nullableStringAdapter.fromJson(reader);
                i &= -5;
            } else if (selectName == 3) {
                str3 = this.nullableStringAdapter.fromJson(reader);
                i &= -9;
            }
        }
        reader.endObject();
        if (i == -16) {
            return new UploadEndRequest(str, extractedStepUpData, str2, str3);
        }
        Constructor<UploadEndRequest> constructor = this.constructorRef;
        if (constructor == null) {
            constructor = UploadEndRequest.class.getDeclaredConstructor(String.class, ExtractedStepUpData.class, String.class, String.class, Integer.TYPE, Util.DEFAULT_CONSTRUCTOR_MARKER);
            this.constructorRef = constructor;
            Intrinsics.checkNotNullExpressionValue(constructor, "UploadEndRequest::class.…his.constructorRef = it }");
        }
        UploadEndRequest newInstance = constructor.newInstance(str, extractedStepUpData, str2, str3, Integer.valueOf(i), null);
        Intrinsics.checkNotNullExpressionValue(newInstance, "localConstructor.newInst…torMarker */ null\n      )");
        return newInstance;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, UploadEndRequest value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("documentsReferenceId");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getDocumentsReferenceId());
        writer.name("documentInfo");
        this.nullableExtractedStepUpDataAdapter.toJson(writer, (JsonWriter) value_.getDocumentInfo());
        writer.name("documentsUuid");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getDocumentsUuid());
        writer.name("documentVerificationToken");
        this.nullableStringAdapter.toJson(writer, (JsonWriter) value_.getDocumentVerificationToken());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(38), "GeneratedJsonAdapter(", "UploadEndRequest", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
