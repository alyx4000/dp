package sdk.pendo.io.l8;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.l8.b;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lsdk/pendo/io/l8/a;", "Lsdk/pendo/io/k8/a;", "Lorg/json/JSONObject;", "info", "", "c", "json", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a extends sdk.pendo.io.k8.a {
    private final void c(JSONObject info) {
        try {
            b.Companion companion = b.INSTANCE;
            info.put(companion.h(), "Android");
            info.put(companion.i(), String.valueOf(Build.VERSION.SDK_INT));
            info.put(companion.b(), Build.BRAND);
            info.put(companion.f(), Build.MANUFACTURER);
            info.put(companion.g(), Build.MODEL);
            info.put(companion.a(), Build.BOARD);
        } catch (JSONException e) {
            PendoLogger.e(e, String.valueOf(e.getMessage()), new Object[0]);
        }
    }

    @Override // sdk.pendo.io.k8.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        c(json);
    }
}
