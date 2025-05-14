package sdk.pendo.io.v8;

import android.graphics.Bitmap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.x8.g;
import sdk.pendo.io.y8.a;
import sdk.pendo.io.z8.b;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: sdk.pendo.io.v8.a$a, reason: collision with other inner class name */
    class C0253a extends g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f1692a;
        final /* synthetic */ JSONArray b;
        final /* synthetic */ Bitmap c;

        C0253a(JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap) {
            this.f1692a = jSONObject;
            this.b = jSONArray;
            this.c = bitmap;
        }

        @Override // sdk.pendo.io.m7.a.InterfaceC0197a
        public void call(Object... objArr) {
            try {
                b.a(sdk.pendo.io.w8.a.EVENT_SCREEN_CAPTURED, this.f1692a, this.b, this.c, null);
                sdk.pendo.io.y8.a.d().a(a.d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED, new Object[0]);
            } catch (JSONException e) {
                PendoLogger.e(e, e.getMessage(), new Object[0]);
            }
        }
    }

    public static void a(JSONObject jSONObject, JSONArray jSONArray, Bitmap bitmap) {
        sdk.pendo.io.u8.a aVar = sdk.pendo.io.u8.a.f1643a;
        sdk.pendo.io.w8.a aVar2 = sdk.pendo.io.w8.a.EVENT_READY_TO_RECEIVE_SCREEN;
        aVar.a(aVar2.b());
        b.a(sdk.pendo.io.w8.a.EVENT_PREPARE_TO_RECEIVE_SCREEN.b(), new JSONObject());
        aVar.a(aVar2.b(), new C0253a(jSONObject, jSONArray, bitmap));
    }
}
