package com.socure.idplus.device.internal;

import android.content.Context;
import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.context.SigmaDeviceContext;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class p extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f583a;
    public final /* synthetic */ SessionTokenCallback b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ SigmaDeviceContext d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(t tVar, SessionTokenCallback sessionTokenCallback, Context context, SigmaDeviceContext sigmaDeviceContext) {
        super(1);
        this.f583a = tVar;
        this.b = sessionTokenCallback;
        this.c = context;
        this.d = sigmaDeviceContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceConfigResponse config = (SigmaDeviceConfigResponse) obj;
        Intrinsics.checkNotNullParameter(config, "config");
        t tVar = this.f583a;
        SessionTokenCallback sessionTokenCallback = this.b;
        tVar.h.a(tVar.k, tVar.l.a(config), tVar.f614a, new i(new o(tVar, this.c, config, this.d, sessionTokenCallback)), new j(tVar, sessionTokenCallback));
        return Unit.INSTANCE;
    }
}
