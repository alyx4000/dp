package sdk.pendo.io.models;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lsdk/pendo/io/models/InitModelImporter;", "", "()V", "applicationAssetFileName", "", "getInitModelFromJSONAssetFile", "Lsdk/pendo/io/models/InitModel;", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InitModelImporter {
    private final String applicationAssetFileName = "initModel.json";

    public final InitModel getInitModelFromJSONAssetFile() {
        try {
            InputStream open = PendoInternal.m().getAssets().open(this.applicationAssetFileName);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            return (InitModel) PendoInternal.l.a((Reader) new InputStreamReader(open, Charsets.UTF_8), InitModel.class);
        } catch (Exception e) {
            PendoLogger.w(e, "InitModelImporter failed to transform the application asset file to Init Model instance", new Object[0]);
            return null;
        }
    }
}
