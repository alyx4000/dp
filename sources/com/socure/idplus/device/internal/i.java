package com.socure.idplus.device.internal;

import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class i extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f564a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(o oVar) {
        super(1);
        this.f564a = oVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceSessionModel sessionData = (SigmaDeviceSessionModel) obj;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        this.f564a.invoke(sessionData);
        return Unit.INSTANCE;
    }
}
