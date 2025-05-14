package sdk.pendo.io.x8;

import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.y8.a;

/* loaded from: classes4.dex */
public final class l implements a.InterfaceC0197a {
    @Override // sdk.pendo.io.m7.a.InterfaceC0197a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got Connected", new Object[0]);
        sdk.pendo.io.z8.b.a("dummySocketEvent", new JSONObject());
        sdk.pendo.io.y8.a.d();
        sdk.pendo.io.y8.a.b(Boolean.TRUE);
        sdk.pendo.io.y8.a.d().a(a.d.EVENT_SOCKET_CONNECTED, objArr);
    }
}
