package com.socure.idplus.device.internal;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class m extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f578a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(t tVar) {
        super(2);
        this.f578a = tVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError sigmaDeviceError = (SigmaDeviceError) obj;
        String socureSigmaDeviceErrorMessage = (String) obj2;
        Intrinsics.checkNotNullParameter(sigmaDeviceError, "sigmaDeviceError");
        Intrinsics.checkNotNullParameter(socureSigmaDeviceErrorMessage, "socureSigmaDeviceErrorMessage");
        t.a(this.f578a, sigmaDeviceError, socureSigmaDeviceErrorMessage, null);
        return Unit.INSTANCE;
    }
}
