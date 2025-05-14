package sdk.pendo.io.z8;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import io.sentry.Session;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.d9.c;
import sdk.pendo.io.g9.g0;
import sdk.pendo.io.g9.j0;
import sdk.pendo.io.g9.y;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.o2.g;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static String f1891a;
    private static final AtomicBoolean b = new AtomicBoolean(false);

    public static void a(JSONObject jSONObject, boolean z) {
        try {
            jSONObject.put(sdk.pendo.io.w8.a.EVENT_SUCCESS, z);
        } catch (JSONException unused) {
        }
    }

    public static void b(JSONObject jSONObject) {
        a(sdk.pendo.io.w8.a.EVENT_DEBUG_MODE_LOG.b(), jSONObject);
    }

    public static String c() {
        return PendoInternal.m().getSharedPreferences("socketInfo", 0).getString("sessionToken=", null);
    }

    public static void d() {
        a((String) null);
    }

    private static void e() {
        sdk.pendo.io.u8.a aVar = sdk.pendo.io.u8.a.f1643a;
        aVar.f();
        aVar.b();
        aVar.c();
    }

    public static void a(JSONObject jSONObject) {
        a(sdk.pendo.io.w8.a.EVENT_DEBUG_MODE_EVENT.b(), jSONObject);
    }

    public static Uri b() {
        return y.f1148a.a();
    }

    private static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("data", jSONObject);
        return jSONObject2;
    }

    public static void a(String str, JSONObject jSONObject) {
        try {
            JSONObject c = c(jSONObject);
            if (!TextUtils.isEmpty(f1891a)) {
                c.put(Session.JsonKeys.SID, f1891a);
            }
            c.put("version", "v2");
            sdk.pendo.io.u8.a.f1643a.a(str, c);
        } catch (JSONException e) {
            PendoLogger.e(e, e.getMessage(), "command: " + str);
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Uri parse = Uri.parse(str);
        if (parse == null) {
            PendoLogger.e("Can't read QR code data", new Object[0]);
            return;
        }
        String queryParameter = parse.getQueryParameter("sessionToken");
        PendoLogger.d("got this sessionId: " + queryParameter, new Object[0]);
        if (!TextUtils.isEmpty(queryParameter)) {
            a(queryParameter);
        }
        String queryParameter2 = parse.getQueryParameter(Session.JsonKeys.SID);
        if (TextUtils.isEmpty(queryParameter2)) {
            return;
        }
        f1891a = queryParameter2;
        PendoLogger.d("got this sid: " + f1891a, new Object[0]);
    }

    public static JSONObject a(JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap, JSONArray jSONArray2) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("deviceName", Build.MANUFACTURER + " - " + Build.MODEL);
        jSONObject2.put("image", g0.a(bitmap));
        jSONObject2.put("image_height", bitmap.getHeight());
        jSONObject2.put("image_width", bitmap.getWidth());
        jSONObject2.put("tree", jSONArray);
        jSONObject2.put(ActivationManager.SCREEN_DATA_KEY, jSONObject);
        if (jSONArray2 != null) {
            jSONObject2.put("verifiedElements", jSONArray2);
            PendoLogger.d("verifiedElements" + jSONArray2, new Object[0]);
        }
        return jSONObject2;
    }

    public static boolean a() {
        return b.getAndSet(false);
    }

    public static void a(boolean z, boolean z2) {
        sdk.pendo.io.p8.a.d().i();
        e eVar = new e() { // from class: sdk.pendo.io.z8.b$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                b.a((GetAuthToken.GetAuthTokenResponse) obj);
            }
        };
        if (z) {
            sdk.pendo.io.network.interfaces.a.c().b(1L).a(c.a(eVar, "SocketIOUtils access token skip first observer"));
        } else {
            sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.d9.b.a(eVar, "SocketIOUtils access token observer"));
        }
    }

    public static boolean a(Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof String) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str) && g.a(str, "Unauthorized. Invalid access token.")) {
                    a(true, false);
                    return true;
                }
                if (!TextUtils.isEmpty(str) && g.a(str, "Unauthorized. Invalid session token")) {
                    d();
                    e();
                    sdk.pendo.io.p8.a.d().e(true);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        if (j0.a(getAuthTokenResponse.accessToken) || a()) {
            return;
        }
        PendoLogger.d("trying to connect to socket...", new Object[0]);
        sdk.pendo.io.u8.a.f1643a.a();
    }

    private static void a(String str) {
        PendoLogger.d("save session token: " + str, new Object[0]);
        SharedPreferences.Editor edit = PendoInternal.m().getSharedPreferences("socketInfo", 0).edit();
        edit.putString("sessionToken=", str);
        edit.apply();
    }

    public static void a(sdk.pendo.io.w8.a aVar, JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap, JSONArray jSONArray2) {
        a(aVar.b(), a(jSONObject, jSONArray, bitmap, jSONArray2));
    }

    public static void a(boolean z) {
        b.set(z);
    }
}
