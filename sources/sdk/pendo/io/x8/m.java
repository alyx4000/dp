package sdk.pendo.io.x8;

import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.m7.a;
import sdk.pendo.io.y8.a;

/* loaded from: classes4.dex */
public final class m implements a.InterfaceC0197a {
    @Override // sdk.pendo.io.m7.a.InterfaceC0197a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got Disconnect", new Object[0]);
        sdk.pendo.io.y8.a.d();
        sdk.pendo.io.y8.a.b(Boolean.FALSE);
        sdk.pendo.io.y8.a.d().a(a.d.EVENT_SOCKET_DISCONNECTED, objArr);
    }
}
