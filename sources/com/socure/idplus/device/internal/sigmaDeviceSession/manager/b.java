package com.socure.idplus.device.internal.sigmaDeviceSession.manager;

import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.error.SigmaDeviceError;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b extends Lambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f606a;
    public final /* synthetic */ Function2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, Function2 function2) {
        super(2);
        this.f606a = eVar;
        this.b = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        SigmaDeviceError sigmaDeviceError = (SigmaDeviceError) obj;
        String message = (String) obj2;
        Intrinsics.checkNotNullParameter(sigmaDeviceError, "sigmaDeviceError");
        Intrinsics.checkNotNullParameter(message, "message");
        e eVar = this.f606a;
        eVar.b = false;
        eVar.d = null;
        Iterator it = eVar.c.iterator();
        while (it.hasNext()) {
            ((SessionTokenCallback) it.next()).onError(SigmaDeviceError.DataFetchError, "Unable to fetch session");
        }
        eVar.c.clear();
        this.b.invoke(sigmaDeviceError, message);
        return Unit.INSTANCE;
    }
}
