package com.socure.idplus.device.internal.sigmaDeviceSession.manager;

import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class a extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f605a;
    public final /* synthetic */ Function1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, Function1 function1) {
        super(1);
        this.f605a = eVar;
        this.b = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceSessionModel it = (SigmaDeviceSessionModel) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        e eVar = this.f605a;
        eVar.b = false;
        eVar.d = it.getSessionToken();
        e eVar2 = this.f605a;
        String sessionToken = it.getSessionToken();
        Iterator it2 = eVar2.c.iterator();
        while (it2.hasNext()) {
            SessionTokenCallback sessionTokenCallback = (SessionTokenCallback) it2.next();
            if (sessionToken != null) {
                sessionTokenCallback.onComplete(sessionToken);
            } else {
                sessionTokenCallback.onError(SigmaDeviceError.DataFetchError, "Unable to fetch session");
            }
        }
        eVar2.c.clear();
        this.b.invoke(it);
        return Unit.INSTANCE;
    }
}
