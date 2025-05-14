package com.socure.idplus.device.internal;

import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class q extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f585a;
    public final /* synthetic */ SessionTokenCallback b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(t tVar, SessionTokenCallback sessionTokenCallback) {
        super(2);
        this.f585a = tVar;
        this.b = sessionTokenCallback;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError sigmaDeviceError = (SigmaDeviceError) obj;
        String socureSigmaDeviceErrorMessage = (String) obj2;
        Intrinsics.checkNotNullParameter(sigmaDeviceError, "sigmaDeviceError");
        Intrinsics.checkNotNullParameter(socureSigmaDeviceErrorMessage, "socureSigmaDeviceErrorMessage");
        t.a(this.f585a, sigmaDeviceError, socureSigmaDeviceErrorMessage, this.b);
        return Unit.INSTANCE;
    }
}
