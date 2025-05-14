package com.socure.idplus.device.internal.sigmaDeviceSession.manager;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class d extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function2 f608a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(b bVar) {
        super(1);
        this.f608a = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        com.socure.idplus.device.internal.network.a it = (com.socure.idplus.device.internal.network.a) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f608a.invoke(SigmaDeviceError.DataFetchError, "Unable to create session");
        return Unit.INSTANCE;
    }
}
