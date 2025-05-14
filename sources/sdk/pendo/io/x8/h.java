package sdk.pendo.io.x8;

import java.util.Arrays;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.m7.a;

/* loaded from: classes4.dex */
public final class h implements a.InterfaceC0197a {
    @Override // sdk.pendo.io.m7.a.InterfaceC0197a
    public void call(Object... objArr) {
        PendoLogger.d("SocketIO device got error: " + (objArr != null ? Arrays.toString(objArr) : ""), new Object[0]);
        Object obj = objArr != null ? objArr[0] : null;
        if (obj != null) {
            sdk.pendo.io.g9.a.f1122a.b(obj.toString());
        }
        sdk.pendo.io.z8.b.a(objArr);
    }
}
