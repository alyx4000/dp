package com.socure.idplus.device.internal.sigmaDeviceConfig.manager;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class e extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f594a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Function2 function2) {
        super(2);
        this.f594a = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError socureSigmaDeviceError = (SigmaDeviceError) obj;
        String socureSigmaDeviceErrorMessage = (String) obj2;
        Intrinsics.checkNotNullParameter(socureSigmaDeviceError, "socureSigmaDeviceError");
        Intrinsics.checkNotNullParameter(socureSigmaDeviceErrorMessage, "socureSigmaDeviceErrorMessage");
        this.f594a.invoke(socureSigmaDeviceError, socureSigmaDeviceErrorMessage);
        return Unit.INSTANCE;
    }
}
