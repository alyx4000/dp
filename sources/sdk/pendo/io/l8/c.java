package sdk.pendo.io.l8;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.g9.r;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0003J\u0018\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0002H\u0014¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/l8/c;", "Lsdk/pendo/io/k8/a;", "Lorg/json/JSONObject;", "info", "", "c", "Landroid/view/Display;", "display", "displayJSON", "a", "Landroid/util/DisplayMetrics;", "dm", "", "json", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class c extends sdk.pendo.io.k8.a {
    private final int a(DisplayMetrics dm, Display display) {
        display.getRealMetrics(dm);
        return dm.heightPixels;
    }

    private final void c(JSONObject info) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context a2 = a();
        Intrinsics.checkNotNull(a2);
        Object systemService = a2.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics.checkNotNull(defaultDisplay);
        int a3 = a(displayMetrics, defaultDisplay);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.densityDpi;
        double d = i2;
        double sqrt = Math.sqrt(Math.pow(i / d, 2.0d) + Math.pow(a3 / d, 2.0d));
        JSONObject jSONObject = new JSONObject();
        r.a(jSONObject, "width", Integer.valueOf(i));
        r.a(jSONObject, "height", Integer.valueOf(a3));
        r.a(jSONObject, "density", Integer.valueOf(i2));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(sqrt)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        Double valueOf = Double.valueOf(format);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        r.a(jSONObject, "size", valueOf);
        a(defaultDisplay, jSONObject);
        r.a(jSONObject, "refresh_rate", Double.valueOf(defaultDisplay.getRefreshRate()));
        r.a(info, "display", jSONObject);
    }

    @Override // sdk.pendo.io.k8.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        c(json);
    }

    private final void a(Display display, JSONObject displayJSON) {
        JSONArray jSONArray = new JSONArray();
        float[] supportedRefreshRates = display.getSupportedRefreshRates();
        Intrinsics.checkNotNull(supportedRefreshRates);
        for (float f : supportedRefreshRates) {
            r.a(jSONArray, Double.valueOf(f));
        }
        r.a(displayJSON, "supported_refresh_rates", jSONArray);
    }
}
