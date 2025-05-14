package com.socure.idplus.device.internal;

import android.content.Context;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class k extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f576a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ SigmaDeviceConfigResponse c;
    public final /* synthetic */ Function2 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(t tVar, Context context, SigmaDeviceConfigResponse sigmaDeviceConfigResponse, Function2 function2) {
        super(1);
        this.f576a = tVar;
        this.b = context;
        this.c = sigmaDeviceConfigResponse;
        this.d = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceSessionModel sessionData = (SigmaDeviceSessionModel) obj;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        t tVar = this.f576a;
        tVar.g.a(this.b, tVar.l.a(this.c), sessionData.getSessionToken(), this.d);
        return Unit.INSTANCE;
    }
}
