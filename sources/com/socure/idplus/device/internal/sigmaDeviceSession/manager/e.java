package com.socure.idplus.device.internal.sigmaDeviceSession.manager;

import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.idplus.device.internal.sigmaDeviceSession.dataHandler.b f609a;
    public boolean b;
    public final ArrayList c;
    public String d;

    public /* synthetic */ e() {
        this(new com.socure.idplus.device.internal.sigmaDeviceSession.dataHandler.b());
    }

    public final void a(com.socure.idplus.device.internal.sharedPrefs.a socureSharedPref, com.socure.idplus.device.internal.api.a api, String sdkKey, Function1 onSuccess, Function2 onError) {
        Intrinsics.checkNotNullParameter(socureSharedPref, "socureSharedPref");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(sdkKey, "sdkKey");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        this.b = true;
        a aVar = new a(this, onSuccess);
        b bVar = new b(this, onError);
        com.socure.idplus.device.internal.sigmaDeviceSession.dataHandler.b bVar2 = this.f609a;
        String string = socureSharedPref.f588a.getString("socure_customer_session", null);
        SigmaDeviceSessionModel session = string != null ? (SigmaDeviceSessionModel) socureSharedPref.c.fromJson(string, SigmaDeviceSessionModel.class) : null;
        if (session == null) {
            String string2 = socureSharedPref.f588a.getString("SocureDeviceRiskUUID", "");
            if (string2 == null) {
                string2 = "";
            }
            session = new SigmaDeviceSessionModel(string2, "");
        }
        c onSuccess2 = new c(socureSharedPref, aVar, bVar);
        d onError2 = new d(bVar);
        bVar2.getClass();
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(sdkKey, "sdkKey");
        Intrinsics.checkNotNullParameter(session, "session");
        Intrinsics.checkNotNullParameter(onSuccess2, "onSuccess");
        Intrinsics.checkNotNullParameter(onError2, "onError");
        com.socure.idplus.device.internal.network.c.a(new com.socure.idplus.device.internal.sigmaDeviceSession.dataHandler.a(api, com.socure.idplus.device.internal.common.utils.a.a(sdkKey), session), onSuccess2, onError2);
    }

    public e(com.socure.idplus.device.internal.sigmaDeviceSession.dataHandler.b sessionDataHandler) {
        Intrinsics.checkNotNullParameter(sessionDataHandler, "sessionDataHandler");
        this.f609a = sessionDataHandler;
        this.c = new ArrayList();
    }
}
