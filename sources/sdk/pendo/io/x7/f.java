package sdk.pendo.io.x7;

import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes4.dex */
public class f implements e {
    @Override // sdk.pendo.io.x7.e
    public void a(String str, Throwable th) {
        PendoLogger.d("ERROR " + b.class.getName() + " " + str, new Object[0]);
    }

    @Override // sdk.pendo.io.x7.e
    public void a(String str, Object... objArr) {
        PendoLogger.i("INFO " + b.class.getName() + " " + String.format(str, objArr), new Object[0]);
    }
}
