package com.socure.idplus.device.internal;

import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class r extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SessionTokenCallback f586a;
    public final /* synthetic */ SigmaDeviceSessionModel b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(SessionTokenCallback sessionTokenCallback, SigmaDeviceSessionModel sigmaDeviceSessionModel) {
        super(0);
        this.f586a = sessionTokenCallback;
        this.b = sigmaDeviceSessionModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f586a.onComplete(this.b.getSessionToken());
        return Unit.INSTANCE;
    }
}
