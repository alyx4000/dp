package com.socure.idplus.device.internal.sigmaDeviceLocation.manager;

import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f599a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(h hVar) {
        super(2);
        this.f599a = hVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError socureError = (SigmaDeviceError) obj;
        String socureErrorMessage = (String) obj2;
        Intrinsics.checkNotNullParameter(socureError, "socureError");
        Intrinsics.checkNotNullParameter(socureErrorMessage, "socureErrorMessage");
        this.f599a.invoke(socureError, socureErrorMessage);
        return Unit.INSTANCE;
    }
}
