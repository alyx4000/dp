package com.socure.idplus.device.internal.sigmaDeviceConfig.manager;

import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f590a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(1);
        this.f590a = cVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceConfigResponse config = (SigmaDeviceConfigResponse) obj;
        Intrinsics.checkNotNullParameter(config, "config");
        this.f590a.invoke(config);
        return Unit.INSTANCE;
    }
}
