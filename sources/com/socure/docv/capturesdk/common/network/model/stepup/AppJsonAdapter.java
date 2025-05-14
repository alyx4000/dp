package com.socure.docv.capturesdk.common.network.model.stepup;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonDataException;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.internal.Util;
import io.sentry.Session;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/stepup/AppJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/App;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "accessibilityAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Accessibility;", "booleanAdapter", "", "errorsAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Errors;", "newLabelsAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "screensAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Screens;", "stringAdapter", "", "themeAdapter", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Theme;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppJsonAdapter extends JsonAdapter<App> {
    private final JsonAdapter<Accessibility> accessibilityAdapter;
    private final JsonAdapter<Boolean> booleanAdapter;
    private final JsonAdapter<Errors> errorsAdapter;
    private final JsonAdapter<NewLabels> newLabelsAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<Screens> screensAdapter;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<Theme> themeAdapter;

    public AppJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of("theme", "logo", "isLogoCustomized", "screens", "newLabels", "accessibility", Session.JsonKeys.ERRORS);
        Intrinsics.checkNotNullExpressionValue(of, "of(\"theme\", \"logo\",\n    …accessibility\", \"errors\")");
        this.options = of;
        this.themeAdapter = a.a(moshi, Theme.class, "theme", "moshi.adapter(Theme::cla…mptySet(),\n      \"theme\")");
        this.stringAdapter = a.a(moshi, String.class, "logo", "moshi.adapter(String::cl…emptySet(),\n      \"logo\")");
        this.booleanAdapter = a.a(moshi, Boolean.TYPE, "isLogoCustomized", "moshi.adapter(Boolean::c…      \"isLogoCustomized\")");
        this.screensAdapter = a.a(moshi, Screens.class, "screens", "moshi.adapter(Screens::c…tySet(),\n      \"screens\")");
        this.newLabelsAdapter = a.a(moshi, NewLabels.class, "newLabels", "moshi.adapter(NewLabels:… emptySet(), \"newLabels\")");
        this.accessibilityAdapter = a.a(moshi, Accessibility.class, "accessibility", "moshi.adapter(Accessibil…tySet(), \"accessibility\")");
        this.errorsAdapter = a.a(moshi, Errors.class, Session.JsonKeys.ERRORS, "moshi.adapter(Errors::cl…ptySet(),\n      \"errors\")");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.squareup.moshi.JsonAdapter
    public App fromJson(JsonReader reader) {
        Intrinsics.checkNotNullParameter(reader, "reader");
        reader.beginObject();
        Boolean bool = null;
        Theme theme = null;
        String str = null;
        Screens screens = null;
        NewLabels newLabels = null;
        Accessibility accessibility = null;
        Errors errors = null;
        while (true) {
            Errors errors2 = errors;
            if (!reader.hasNext()) {
                reader.endObject();
                if (theme == null) {
                    JsonDataException missingProperty = Util.missingProperty("theme", "theme", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty, "missingProperty(\"theme\", \"theme\", reader)");
                    throw missingProperty;
                }
                if (str == null) {
                    JsonDataException missingProperty2 = Util.missingProperty("logo", "logo", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty2, "missingProperty(\"logo\", \"logo\", reader)");
                    throw missingProperty2;
                }
                if (bool == null) {
                    JsonDataException missingProperty3 = Util.missingProperty("isLogoCustomized", "isLogoCustomized", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty3, "missingProperty(\"isLogoC…sLogoCustomized\", reader)");
                    throw missingProperty3;
                }
                boolean booleanValue = bool.booleanValue();
                if (screens == null) {
                    JsonDataException missingProperty4 = Util.missingProperty("screens", "screens", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty4, "missingProperty(\"screens\", \"screens\", reader)");
                    throw missingProperty4;
                }
                if (newLabels == null) {
                    JsonDataException missingProperty5 = Util.missingProperty("newLabels", "newLabels", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty5, "missingProperty(\"newLabels\", \"newLabels\", reader)");
                    throw missingProperty5;
                }
                if (accessibility == null) {
                    JsonDataException missingProperty6 = Util.missingProperty("accessibility", "accessibility", reader);
                    Intrinsics.checkNotNullExpressionValue(missingProperty6, "missingProperty(\"accessi… \"accessibility\", reader)");
                    throw missingProperty6;
                }
                if (errors2 != null) {
                    return new App(theme, str, booleanValue, screens, newLabels, accessibility, errors2);
                }
                JsonDataException missingProperty7 = Util.missingProperty(Session.JsonKeys.ERRORS, Session.JsonKeys.ERRORS, reader);
                Intrinsics.checkNotNullExpressionValue(missingProperty7, "missingProperty(\"errors\", \"errors\", reader)");
                throw missingProperty7;
            }
            switch (reader.selectName(this.options)) {
                case -1:
                    reader.skipName();
                    reader.skipValue();
                    break;
                case 0:
                    theme = this.themeAdapter.fromJson(reader);
                    if (theme == null) {
                        JsonDataException unexpectedNull = Util.unexpectedNull("theme", "theme", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull, "unexpectedNull(\"theme\", …eme\",\n            reader)");
                        throw unexpectedNull;
                    }
                    break;
                case 1:
                    str = this.stringAdapter.fromJson(reader);
                    if (str == null) {
                        JsonDataException unexpectedNull2 = Util.unexpectedNull("logo", "logo", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull2, "unexpectedNull(\"logo\", \"logo\",\n            reader)");
                        throw unexpectedNull2;
                    }
                    break;
                case 2:
                    bool = this.booleanAdapter.fromJson(reader);
                    if (bool == null) {
                        JsonDataException unexpectedNull3 = Util.unexpectedNull("isLogoCustomized", "isLogoCustomized", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull3, "unexpectedNull(\"isLogoCu…sLogoCustomized\", reader)");
                        throw unexpectedNull3;
                    }
                    break;
                case 3:
                    screens = this.screensAdapter.fromJson(reader);
                    if (screens == null) {
                        JsonDataException unexpectedNull4 = Util.unexpectedNull("screens", "screens", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull4, "unexpectedNull(\"screens\"…       \"screens\", reader)");
                        throw unexpectedNull4;
                    }
                    break;
                case 4:
                    newLabels = this.newLabelsAdapter.fromJson(reader);
                    if (newLabels == null) {
                        JsonDataException unexpectedNull5 = Util.unexpectedNull("newLabels", "newLabels", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull5, "unexpectedNull(\"newLabel…     \"newLabels\", reader)");
                        throw unexpectedNull5;
                    }
                    break;
                case 5:
                    accessibility = this.accessibilityAdapter.fromJson(reader);
                    if (accessibility == null) {
                        JsonDataException unexpectedNull6 = Util.unexpectedNull("accessibility", "accessibility", reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull6, "unexpectedNull(\"accessib… \"accessibility\", reader)");
                        throw unexpectedNull6;
                    }
                    break;
                case 6:
                    errors = this.errorsAdapter.fromJson(reader);
                    if (errors == null) {
                        JsonDataException unexpectedNull7 = Util.unexpectedNull(Session.JsonKeys.ERRORS, Session.JsonKeys.ERRORS, reader);
                        Intrinsics.checkNotNullExpressionValue(unexpectedNull7, "unexpectedNull(\"errors\",…        \"errors\", reader)");
                        throw unexpectedNull7;
                    }
                    continue;
            }
            errors = errors2;
        }
    }

    @Override // com.squareup.moshi.JsonAdapter
    public void toJson(JsonWriter writer, App value_) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        if (value_ == null) {
            throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
        }
        writer.beginObject();
        writer.name("theme");
        this.themeAdapter.toJson(writer, (JsonWriter) value_.getTheme());
        writer.name("logo");
        this.stringAdapter.toJson(writer, (JsonWriter) value_.getLogo());
        writer.name("isLogoCustomized");
        this.booleanAdapter.toJson(writer, (JsonWriter) Boolean.valueOf(value_.isLogoCustomized()));
        writer.name("screens");
        this.screensAdapter.toJson(writer, (JsonWriter) value_.getScreens());
        writer.name("newLabels");
        this.newLabelsAdapter.toJson(writer, (JsonWriter) value_.getNewLabels());
        writer.name("accessibility");
        this.accessibilityAdapter.toJson(writer, (JsonWriter) value_.getAccessibility());
        writer.name(Session.JsonKeys.ERRORS);
        this.errorsAdapter.toJson(writer, (JsonWriter) value_.getErrors());
        writer.endObject();
    }

    public String toString() {
        return b.a(new StringBuilder(25), "GeneratedJsonAdapter(", "App", ')', "StringBuilder(capacity).…builderAction).toString()");
    }
}
