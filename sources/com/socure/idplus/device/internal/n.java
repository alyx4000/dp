package com.socure.idplus.device.internal;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class n extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f579a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(t tVar) {
        super(2);
        this.f579a = tVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError error = (SigmaDeviceError) obj;
        String message = (String) obj2;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        com.socure.idplus.device.internal.common.utils.a.a("SocureInternal", message);
        t.a(this.f579a, error, message, null);
        return Unit.INSTANCE;
    }
}
