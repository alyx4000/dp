package sdk.pendo.io.c8;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.c8.h;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private final String f965a;
    private long b;
    private final JSONObject c;
    private d d;
    private JSONObject e;
    private String f;

    public g(JSONObject jSONObject, h.a aVar) {
        this.b = -1L;
        this.e = jSONObject;
        this.f965a = aVar.b();
        this.c = aVar.c();
        this.f = aVar.a();
        this.b = aVar.d();
    }

    public JSONObject a() {
        Iterator<String> keys;
        Iterator<String> keys2;
        JSONObject jSONObject = new JSONObject();
        try {
            String str = this.f965a;
            if (str != null) {
                str.equals(c.TRACK_EVENT.b());
            }
            jSONObject.put("device_time", this.b);
            JSONObject jSONObject2 = this.e;
            if (jSONObject2 != null && jSONObject2.toString().contains(ActivationManager.SCREEN_DATA_KEY)) {
                jSONObject.put("retroactiveScreenId", PendoInternal.x().o());
            }
            d dVar = this.d;
            if (dVar != null) {
                dVar.a(jSONObject, this.f965a);
            }
            JSONObject jSONObject3 = this.e;
            if (jSONObject3 != null && (keys2 = jSONObject3.keys()) != null) {
                while (keys2.hasNext()) {
                    String next = keys2.next();
                    jSONObject.put(next, this.e.get(next));
                }
            }
            JSONObject jSONObject4 = this.c;
            if (jSONObject4 != null && (keys = jSONObject4.keys()) != null) {
                while (keys.hasNext()) {
                    String next2 = keys.next();
                    jSONObject.put(next2, this.c.get(next2));
                }
            }
            if (!TextUtils.isEmpty(this.f)) {
                jSONObject.put(PendoCommandAction.PendoCommandGlobalAction.PendoInfoConsts.EXTERNAL_ENDPOINT_URL, this.f);
            }
            return jSONObject;
        } catch (JSONException e) {
            PendoLogger.e(e.getMessage(), new Object[0]);
            return null;
        }
    }

    public g(d dVar, h.a aVar) {
        this.b = -1L;
        this.d = dVar;
        this.f965a = aVar.b();
        this.c = aVar.c();
        this.f = aVar.a();
        this.b = aVar.d();
    }
}
