package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/ButtonJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Button;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "options", "Lcom/squareup/moshi/JsonReader$Options;", "primaryButtonAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/PrimaryButton;", "secondaryAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Secondary;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ButtonJsonAdapter extends JsonAdapter<Button> {
    private final JsonReader.Options options;
    private final JsonAdapter<PrimaryButton> primaryButtonAdapter;
    private final JsonAdapter<Secondary> secondaryAdapter;

    public ButtonJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("primary", "secondary");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"primary\", \"secondary\")");
        this.options = of;
        this.primaryButtonAdapter = a.a(moshi, PrimaryButton.class, "primary", "moshi.adapter(PrimaryBut…a, emptySet(), \"primary\")");
        this.secondaryAdapter = a.a(moshi, Secondary.class, "secondary", "moshi.adapter(Secondary:… emptySet(), \"secondary\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public Button fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        PrimaryButton primaryButton = null;
        Secondary secondary = null;
        while (reader.hasNext()) {
            int selectName = reader.selectName(this.options);
            if (selectName == -1) {
                reader.skipName();
                reader.skipValue();
            } else if (selectName == 0) {
                primaryButton = this.primaryButtonAdapter.fromJson(reader);
                if (primaryButton == null) {
                    JsonDataException unexpectedNull = Util.unexpectedNull("primary", "primary", reader);
                    Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"primary\"…       \"primary\", reader)");
                    throw unexpectedNull;
                }
            } else if (selectName == 1 && (secondary = this.secondaryAdapter.fromJson(reader)) == null) {
                JsonDataException unexpectedNull2 = Util.unexpectedNull("secondary", "secondary", reader);
                Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"secondar…     \"secondary\", reader)");
                throw unexpectedNull2;
            }
        }
        reader.endObject();
        if (primaryButton == null) {
            JsonDataException missingProperty = Util.missingProperty("primary", "primary", reader);
            Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"primary\", \"primary\", reader)");
            throw missingProperty;
        }
        if (secondary != null) {
            return new Button(primaryButton, secondary);
        }
        JsonDataException missingProperty2 = Util.missingProperty("secondary", "secondary", reader);
        Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"secondary\", \"secondary\", reader)");
        throw missingProperty2;
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, Button value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("primary");
        this.primaryButtonAdapter.toJson(writer, (JsonWriter) value_.getPrimary());
        writer.name("secondary");
        this.secondaryAdapter.toJson(writer, (JsonWriter) value_.getSecondary());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(28), "GeneratedJsonAdapter(", "Button", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
