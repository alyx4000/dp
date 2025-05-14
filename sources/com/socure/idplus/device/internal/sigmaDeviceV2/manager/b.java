package com.socure.idplus.device.internal.sigmaDeviceV2.manager;

import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.s;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f612a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(s sVar) {
        super(1);
        this.f612a = sVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        com.socure.idplus.device.internal.network.a it = (com.socure.idplus.device.internal.network.a) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f612a.invoke(SigmaDeviceError.DataUploadError, "Unable to upload device data");
        return Unit.INSTANCE;
    }
}
