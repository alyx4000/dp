package sdk.pendo.io.x8;

import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.y8.a;

/* loaded from: classes4.dex */
public final class k extends g {
    @Override // sdk.pendo.io.m7.a.InterfaceC0197a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got: resetState", new Object[0]);
        sdk.pendo.io.y8.a.d().a(a.d.EVENT_RESET_STATE, objArr);
    }
}
