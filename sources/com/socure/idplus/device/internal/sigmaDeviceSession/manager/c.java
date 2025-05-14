package com.socure.idplus.device.internal.sigmaDeviceSession.manager;

import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.socure.idplus.device.internal.sharedPrefs.a f607a;
    public final /* synthetic */ Function1 b;
    public final /* synthetic */ Function2 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.socure.idplus.device.internal.sharedPrefs.a aVar, a aVar2, b bVar) {
        super(1);
        this.f607a = aVar;
        this.b = aVar2;
        this.c = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceSessionModel session = (SigmaDeviceSessionModel) obj;
        Intrinsics.checkNotNullParameter(session, "model");
        if (session.validateData()) {
            this.f607a.a();
            com.socure.idplus.device.internal.sharedPrefs.a aVar = this.f607a;
            aVar.getClass();
            Intrinsics.checkNotNullParameter(session, "session");
            aVar.b.putString("socure_customer_session", aVar.c.toJson(session));
            aVar.b.commit();
            this.b.invoke(session);
        } else {
            this.c.invoke(SigmaDeviceError.DataFetchError, "Unable to create session");
        }
        return Unit.INSTANCE;
    }
}
