package com.socure.idplus.device.internal.sigmaDeviceConfig.manager;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f593a;
    public final /* synthetic */ com.socure.idplus.device.internal.api.a b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Function2 d;
    public final /* synthetic */ Function1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.socure.idplus.device.internal.api.a aVar, f fVar, String str, Function1 function1, Function2 function2) {
        super(0);
        this.f593a = fVar;
        this.b = aVar;
        this.c = str;
        this.d = function2;
        this.e = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        f fVar = this.f593a;
        com.socure.idplus.device.internal.api.a api = this.b;
        String sdkKey = this.c;
        c cVar = new c(fVar, this.e);
        Function2 function2 = this.d;
        com.socure.idplus.device.internal.sigmaDeviceConfig.dataHandler.b bVar = fVar.c;
        a onSuccess = new a(cVar);
        b onError = new b(function2);
        bVar.getClass();
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(sdkKey, "sdkKey");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        com.socure.idplus.device.internal.network.c.a(new com.socure.idplus.device.internal.sigmaDeviceConfig.dataHandler.a(api, com.socure.idplus.device.internal.common.utils.a.a(sdkKey)), onSuccess, onError);
        return Unit.INSTANCE;
    }
}
