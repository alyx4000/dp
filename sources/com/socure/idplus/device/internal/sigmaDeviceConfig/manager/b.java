package com.socure.idplus.device.internal.sigmaDeviceConfig.manager;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f591a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Function2 function2) {
        super(1);
        this.f591a = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        com.socure.idplus.device.internal.network.a networkError = (com.socure.idplus.device.internal.network.a) obj;
        Intrinsics.checkNotNullParameter(networkError, "networkError");
        Function2 function2 = this.f591a;
        SigmaDeviceError sigmaDeviceError = SigmaDeviceError.DataFetchError;
        Integer num = networkError.f580a;
        function2.invoke(sigmaDeviceError, (num != null && num.intValue() == 401) ? "Unable to authorize the request" : "Unable to fetch the config");
        return Unit.INSTANCE;
    }
}
