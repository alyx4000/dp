package sdk.pendo.io.x8;

import java.util.Arrays;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.m7.a;

/* loaded from: classes4.dex */
public final class n implements a.InterfaceC0197a {
    @Override // sdk.pendo.io.m7.a.InterfaceC0197a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got terminate: " + (objArr != null ? Arrays.toString(objArr) : "args is null"), new Object[0]);
        sdk.pendo.io.u8.a.f1643a.f();
    }
}
