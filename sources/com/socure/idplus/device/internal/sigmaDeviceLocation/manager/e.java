package com.socure.idplus.device.internal.sigmaDeviceLocation.manager;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class e extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f601a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Function2 function2) {
        super(1);
        this.f601a = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        com.socure.idplus.device.internal.network.a it = (com.socure.idplus.device.internal.network.a) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f601a.invoke(SigmaDeviceError.DataUploadError, "Could not post the location");
        return Unit.INSTANCE;
    }
}
