package sdk.pendo.io.l8;

import android.content.Context;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import sdk.pendo.io.g9.r;
import sdk.pendo.io.l8.b;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lsdk/pendo/io/l8/e;", "Lsdk/pendo/io/k8/a;", "Lorg/json/JSONObject;", "info", "", "c", "Landroid/telephony/TelephonyManager;", "telephony", "a", "json", "b", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class e extends sdk.pendo.io.k8.a {
    private final JSONObject a(TelephonyManager telephony) {
        JSONObject jSONObject = new JSONObject();
        b.c cVar = b.c.f1343a;
        String a2 = cVar.a();
        String simCountryIso = telephony.getSimCountryIso();
        Intrinsics.checkNotNullExpressionValue(simCountryIso, "getSimCountryIso(...)");
        r.a(jSONObject, a2, simCountryIso);
        String b = cVar.b();
        String simOperator = telephony.getSimOperator();
        Intrinsics.checkNotNullExpressionValue(simOperator, "getSimOperator(...)");
        r.a(jSONObject, b, simOperator);
        String c = cVar.c();
        String simOperatorName = telephony.getSimOperatorName();
        Intrinsics.checkNotNullExpressionValue(simOperatorName, "getSimOperatorName(...)");
        r.a(jSONObject, c, simOperatorName);
        return jSONObject;
    }

    private final void c(JSONObject info) {
        String d;
        String str;
        Context a2 = a();
        Intrinsics.checkNotNull(a2);
        Object systemService = a2.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        TelephonyManager telephonyManager = (TelephonyManager) systemService;
        if (telephonyManager.getPhoneType() == 0) {
            d = b.INSTANCE.j();
            str = "Tablet";
        } else {
            r.a(info, b.INSTANCE.j(), "Smartphone");
            if (telephonyManager.getSimState() == 5) {
                r.a(info, b.c.f1343a.d(), a(telephonyManager));
                return;
            } else {
                d = b.c.f1343a.d();
                str = "UNAVAILABLE";
            }
        }
        r.a(info, d, str);
    }

    @Override // sdk.pendo.io.k8.a
    protected void b(JSONObject json) {
        Intrinsics.checkNotNullParameter(json, "json");
        c(json);
    }
}
