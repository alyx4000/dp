package com.socure.idplus.device.internal;

import android.os.Handler;
import android.os.Message;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class e extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.socure.idplus.device.internal.behavior.manager.g f560a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(com.socure.idplus.device.internal.behavior.manager.g gVar) {
        super(1);
        this.f560a = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceSessionModel sessionData = (SigmaDeviceSessionModel) obj;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        com.socure.idplus.device.internal.behavior.manager.g gVar = this.f560a;
        String sessionToken = sessionData.getSessionToken();
        gVar.getClass();
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        if (gVar.d != com.socure.idplus.device.internal.behavior.a.f549a) {
            com.socure.idplus.device.internal.common.utils.a.a("DeviceBehaviorManager", "Setting session token");
            com.socure.idplus.device.internal.thread.c cVar = (com.socure.idplus.device.internal.thread.c) gVar.b;
            cVar.getClass();
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = sessionToken;
            Handler handler = cVar.f615a;
            if (handler != null) {
                handler.sendMessage(obtain);
            }
        }
        return Unit.INSTANCE;
    }
}
