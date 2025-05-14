package com.socure.idplus.device.internal;

import android.content.Context;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class l extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f577a;
    public final /* synthetic */ Function2 b;
    public final /* synthetic */ Context c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(t tVar, n nVar, Context context) {
        super(1);
        this.f577a = tVar;
        this.b = nVar;
        this.c = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceConfigResponse config = (SigmaDeviceConfigResponse) obj;
        Intrinsics.checkNotNullParameter(config, "config");
        t tVar = this.f577a;
        com.socure.idplus.device.internal.sigmaDeviceSession.manager.e eVar = tVar.h;
        com.socure.idplus.device.internal.sharedPrefs.a aVar = tVar.k;
        com.socure.idplus.device.internal.api.a a2 = tVar.l.a(config);
        t tVar2 = this.f577a;
        eVar.a(aVar, a2, tVar2.f614a, new k(tVar2, this.c, config, this.b), this.b);
        return Unit.INSTANCE;
    }
}
