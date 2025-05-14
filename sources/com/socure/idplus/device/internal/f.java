package com.socure.idplus.device.internal;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class f extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.socure.idplus.device.internal.behavior.manager.g f561a;
    public final /* synthetic */ t b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(com.socure.idplus.device.internal.behavior.manager.g gVar, t tVar) {
        super(2);
        this.f561a = gVar;
        this.b = tVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError error = (SigmaDeviceError) obj;
        String message = (String) obj2;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        this.f561a.a();
        t.a(this.b, error, message, null);
        return Unit.INSTANCE;
    }
}
