package com.socure.idplus.device.internal;

import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class j extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f575a;
    public final /* synthetic */ SessionTokenCallback b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(t tVar, SessionTokenCallback sessionTokenCallback) {
        super(2);
        this.f575a = tVar;
        this.b = sessionTokenCallback;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError error = (SigmaDeviceError) obj;
        String message = (String) obj2;
        Intrinsics.checkNotNullParameter(error, "error");
        Intrinsics.checkNotNullParameter(message, "message");
        com.socure.idplus.device.internal.common.utils.a.a("SocureInternal", message);
        t.a(this.f575a, error, message, this.b);
        return Unit.INSTANCE;
    }
}
