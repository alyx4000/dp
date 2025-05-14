package sdk.pendo.io.g9;

import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.iterable.iterableapi.IterableConstants;
import external.sdk.pendo.io.gson.JsonParser;
import io.sentry.clientreport.DiscardedEvent;
import io.sentry.protocol.Device;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.analytics.data.IdentifyData;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.e9.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepContentModel;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.utilities.script.PendoNativeBridge;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static JSONObject f1125a;

    private static JSONObject a(sdk.pendo.io.c8.c cVar, d.b bVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event", cVar.b());
            jSONObject2.put("device_time", System.currentTimeMillis());
            if (bVar != null) {
                jSONObject2.put(DiscardedEvent.JsonKeys.REASON, bVar.b());
            }
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
        return jSONObject2;
    }

    public static void b() {
        if (sdk.pendo.io.y8.a.d().h()) {
            PendoLogger.d("Device is in Capture/Test/Preview mode, no need to send AppSessionStart", new Object[0]);
            sdk.pendo.io.p8.c.f1504a.c(true);
        } else {
            sdk.pendo.io.c8.f.e().d().onNext(new sdk.pendo.io.c8.e().a(System.currentTimeMillis()).b(sdk.pendo.io.c8.c.APP_SESSION_START.b()).d(PendoInternal.D()).a(PendoInternal.k()).c(PendoNativeBridge.getOrientation()).a());
        }
    }

    public static void c() {
        if (sdk.pendo.io.y8.a.d().h()) {
            PendoLogger.d("Device is in Capture/Test/Preview mode, no need to send Identify event", new Object[0]);
            return;
        }
        try {
            IdentifyData identifyData = PendoInternal.y().getIdentifyData();
            if (identifyData == null) {
                return;
            }
            sdk.pendo.io.c8.f.e().d().onNext(new JSONObject(identifyData.b()));
        } catch (Exception e) {
            PendoLogger.d(e, "Error creating identify data", new Object[0]);
        }
    }

    public static void d() {
        sdk.pendo.io.c8.f.e().d().onNext(new sdk.pendo.io.c8.e().b("pauseEmissionsEvent").a());
    }

    private static synchronized JSONObject a() {
        JSONObject jSONObject;
        synchronized (d.class) {
            if (f1125a == null) {
                JSONObject jSONObject2 = new JSONObject();
                f1125a = jSONObject2;
                try {
                    jSONObject2.put("SDK", Build.VERSION.RELEASE);
                    f1125a.put("OsSdkVersion", String.valueOf(Build.VERSION.SDK_INT));
                    f1125a.put("Brand", Build.BRAND);
                    f1125a.put("Manufacturer", Build.MANUFACTURER);
                    f1125a.put(ExifInterface.TAG_MODEL, Build.MODEL);
                    f1125a.put("Board", Build.BOARD);
                    f1125a.put("Bootloader", Build.BOOTLOADER);
                    f1125a.put("DeviceProductName", Build.PRODUCT);
                    f1125a.put("IndustrialDesignName", Build.DEVICE);
                } catch (JSONException unused) {
                    f1125a = null;
                }
            }
            jSONObject = f1125a;
        }
        return jSONObject;
    }

    public static void b(String str, String str2) {
        StepContentModel stepContentModel;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            GuideModel guide = GuidesManager.INSTANCE.getGuide(str);
            if (guide != null && (stepContentModel = guide.getStepContentModel(0)) != null) {
                jSONObject2.put(VisualGuideBase.GUIDE_STEP_ID_PARAMETER_NAME, stepContentModel.getGuideStepId());
            }
            jSONObject2.put(Device.JsonKeys.ORIENTATION, g.g());
            jSONObject2.put("language", g0.a());
            jSONObject2.put("guideId", str);
            jSONObject2.put(PendoCommandAction.PendoCommandGlobalAction.SendPendoGenericAnalyticsConsts.DISMISSED_REASON, d.a.APP_TERMINATION.b());
            jSONObject.put("props", jSONObject2);
            jSONObject.put("guideId", str).put("version", i0.a()).put(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION, str2).put("type", sdk.pendo.io.c8.c.GUIDE_DISMISSED.b());
        } catch (JSONException e) {
            PendoLogger.e(e, "Can't generate additional info json", new Object[0]);
        }
        sdk.pendo.io.c8.f.f().a(sdk.pendo.io.c8.c.GUIDE_DISMISSED.b(), jSONObject, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(String str, String str2, GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        long d = z.d();
        if (d <= 0) {
            d = System.currentTimeMillis();
        }
        sdk.pendo.io.c8.f.e().d().onNext(new sdk.pendo.io.c8.e().a(d).b(sdk.pendo.io.c8.c.APP_SESSION_END.b()).d(str).a(str2).c(PendoNativeBridge.getOrientation()).a());
        sdk.pendo.io.p8.c.f1504a.c(true);
    }

    public static void b(JSONObject jSONObject) {
        sdk.pendo.io.e9.a.f1035a.a(jSONObject, (JSONObject) null);
    }

    public static String a(String str) {
        return TextUtils.isEmpty(str) ? "" : str.replace("\\u0000", "");
    }

    public static String b(String str) {
        boolean z;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String a2 = a(str);
        if (!a2.startsWith("}|{")) {
            int indexOf = a2.indexOf("}|{");
            if (indexOf == -1) {
                return "";
            }
            a2 = a2.substring(indexOf);
        }
        String str2 = a2;
        if (str2.length() <= 3) {
            return "";
        }
        int lastIndexOf = str2.lastIndexOf("}|{");
        if (str2.endsWith("}")) {
            try {
                z = JsonParser.a(str2.substring(lastIndexOf + 3)).j();
            } catch (sdk.pendo.io.k0.q e) {
                PendoLogger.w(e, "Cannot parse trailing object", new Object[0]);
            }
            return (lastIndexOf == 0 || z) ? a(str2, 3, lastIndexOf, "}|{", ",", z) : "";
        }
        z = false;
        if (lastIndexOf == 0) {
        }
    }

    public static void a(b.c cVar, long j, long j2) {
        sdk.pendo.io.c8.c cVar2;
        if (sdk.pendo.io.e9.a.f1035a.c()) {
            sdk.pendo.io.c8.e c = new sdk.pendo.io.c8.e().a(System.currentTimeMillis()).d(PendoInternal.D()).a(PendoInternal.k()).c(PendoNativeBridge.getOrientation());
            if (cVar == b.c.IN_BACKGROUND) {
                z.a(j2, j);
                cVar2 = sdk.pendo.io.c8.c.APP_IN_BACKGROUND;
            } else {
                z.a();
                cVar2 = sdk.pendo.io.c8.c.APP_IN_FOREGROUND;
            }
            c.b(cVar2.b());
            sdk.pendo.io.c8.f.e().d().onNext(c.a());
        }
    }

    public static void a(final String str, final String str2) {
        if (sdk.pendo.io.y8.a.d().h() || str == null) {
            return;
        }
        sdk.pendo.io.network.interfaces.a.c().a(sdk.pendo.io.v6.a.d()).f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.g9.d$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                d.a(str, str2, (GetAuthToken.GetAuthTokenResponse) obj);
            }
        }, "Observer for sending app session ended"));
    }

    public static void a(d.b bVar, String str, Object... objArr) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorMessage", str);
            if (objArr != null && objArr.length > 0) {
                jSONObject.put("errorInfo", objArr[0].toString());
            }
            a(bVar, jSONObject);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    public static void a(d.b bVar, JSONObject jSONObject) {
        sdk.pendo.io.p8.a.d().b(a(sdk.pendo.io.c8.c.SDK_ERROR, bVar, jSONObject).toString());
    }

    public static void a(String str, List<String> list) {
        JSONObject jSONObject = new JSONObject();
        try {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if (i != list.size() - 1) {
                    sb.append(",");
                }
            }
            jSONObject.put("guideId", str);
            jSONObject.put("device_time", System.currentTimeMillis());
            jSONObject.put(DiscardedEvent.JsonKeys.REASON, d.b.ERROR_REASON_IMAGE);
            jSONObject.put("sourcesList", sb.toString());
            sdk.pendo.io.p8.a.d().b(jSONObject.toString());
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(Throwable th, String str) {
        a(th, str, (String) null);
    }

    public static void a(Throwable th, String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            String message = th.getMessage();
            if (m0.a(th)) {
                String sb = ((str2 == null || str2.equals(message)) ? (str == null || str.equals(message)) ? new StringBuilder().append("Stacktrace message = '").append(message) : new StringBuilder().append(str).append(" = 'Stacktrace message = '").append(message) : new StringBuilder().append("Dev log = '").append(str2).append("', Stacktrace message = '").append(message)).append("'.").toString();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("errorInfo", str);
                }
                JSONObject a2 = a();
                if (a2 != null) {
                    jSONObject.put("device_info", a2);
                }
                jSONObject.put("exceptionType", th.getClass().getCanonicalName());
                jSONObject.put("errorMessage", sb);
                jSONObject.put("stackTrace", m0.a(th.getStackTrace()));
                JSONObject a3 = a(sdk.pendo.io.c8.c.SDK_EXCEPTION, (d.b) null, jSONObject);
                if ("PossibleCrash_androidX".equals(str2)) {
                    sdk.pendo.io.i8.a.a(PendoInternal.m(), a3.toString());
                } else {
                    sdk.pendo.io.p8.a.d().b(a3.toString());
                }
            }
        } catch (Exception e) {
            PendoLogger.d("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(sdk.pendo.io.c8.h hVar, sdk.pendo.io.c8.c cVar, String str) {
        JSONObject a2;
        hVar.a(cVar.b(), null, str);
        if (cVar == sdk.pendo.io.c8.c.GUIDE_DISMISSED && (a2 = hVar.a()) != null && a2.has("guideId")) {
            try {
                z.g(a2.getString("guideId"));
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public static void a(sdk.pendo.io.c8.h hVar, long j, String str, String str2, JSONObject jSONObject) {
        sdk.pendo.io.c8.d b = hVar.b();
        if (b == null || !GuidesActionsManager.getInstance().wasGuideFullyDisplayedAfterAnimation(b.c())) {
            return;
        }
        GuidesActionsManager.getInstance().removeGuideFullyDisplayedAfterAnimation(b.c());
        b.a(j);
        b.a(str);
        hVar.a(sdk.pendo.io.c8.c.GUIDE_DISMISSED.b(), jSONObject, str2);
        z.g(String.valueOf(b.c()));
    }

    public static void a(sdk.pendo.io.c8.h hVar, d.b bVar, JSONObject jSONObject) {
        sdk.pendo.io.c8.d b = hVar.b();
        if (b != null) {
            b.a(bVar);
        } else {
            PendoLogger.w("Generics analytics is null!", new Object[0]);
        }
        hVar.a(sdk.pendo.io.c8.c.GUIDE_NOT_DISPLAYED.b(), jSONObject, null);
    }

    public static void a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("signedData", str);
            jSONObject.put("source", str2);
            jSONObject.put("exceptionMessage", str3);
            a(d.EnumC0097d.INVALID_SIGNATURE, jSONObject);
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(d.c cVar, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errorMessage", str);
            JSONObject a2 = a(sdk.pendo.io.c8.c.SDK_ERROR, (d.b) null, jSONObject);
            a2.put(DiscardedEvent.JsonKeys.REASON, cVar.b());
            sdk.pendo.io.p8.a.d().b(a2.toString());
        } catch (JSONException e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(d.EnumC0097d enumC0097d, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("event", sdk.pendo.io.c8.c.SECURITY_EXCEPTION.b());
            jSONObject2.put("device_time", System.currentTimeMillis());
            if (enumC0097d != null) {
                jSONObject2.put(DiscardedEvent.JsonKeys.REASON, enumC0097d.b());
            }
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, jSONObject.get(next));
                }
            }
        } catch (Exception e) {
            PendoLogger.e("Error while generating / sending error event: " + e.getMessage(), new Object[0]);
        }
        sdk.pendo.io.p8.a.d().b(jSONObject2.toString());
    }

    public static String a(String str, int i, int i2, String str2, String str3, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return (z ? str.substring(i) : str.substring(i, i2)).replace(str2, str3);
    }

    public static void a(JSONObject jSONObject) {
        sdk.pendo.io.e9.a.f1035a.a((JSONObject) null, jSONObject);
    }
}
