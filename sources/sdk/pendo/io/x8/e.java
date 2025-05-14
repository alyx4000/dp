package sdk.pendo.io.x8;

import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.y8.a;

/* loaded from: classes4.dex */
public final class e implements a.InterfaceC0197a {
    private void a() {
        JSONObject jSONObject = new JSONObject();
        sdk.pendo.io.z8.b.a(jSONObject, true);
        sdk.pendo.io.z8.b.a(sdk.pendo.io.w8.a.EVENT_DEBUG_MODE_ENTERED.b(), jSONObject);
    }

    @Override // sdk.pendo.io.m7.a.InterfaceC0197a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got: debugModeEnter", new Object[0]);
        sdk.pendo.io.y8.a.d().a(a.d.EVENT_DEBUG_MODE_ENTER, new Object[0]);
        if (sdk.pendo.io.y8.a.d().c().equals(a.g.STATE_DEBUG_MODE)) {
            a();
        }
    }
}
