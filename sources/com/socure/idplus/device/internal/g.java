package com.socure.idplus.device.internal;

import android.content.Context;
import android.location.Location;
import com.socure.idplus.device.SigmaDeviceOptions;
import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.context.SigmaDeviceContext;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import com.socure.idplus.device.internal.sigmaDeviceV2.model.SigmaDeviceV2Model;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class g extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f562a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ SigmaDeviceContext c;
    public final /* synthetic */ SigmaDeviceOptions d;
    public final /* synthetic */ SigmaDeviceConfigResponse e;
    public final /* synthetic */ SigmaDeviceSessionModel f;
    public final /* synthetic */ SessionTokenCallback g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, SigmaDeviceOptions sigmaDeviceOptions, SessionTokenCallback sessionTokenCallback, SigmaDeviceContext sigmaDeviceContext, t tVar, SigmaDeviceConfigResponse sigmaDeviceConfigResponse, SigmaDeviceSessionModel sigmaDeviceSessionModel) {
        super(1);
        this.f562a = tVar;
        this.b = context;
        this.c = sigmaDeviceContext;
        this.d = sigmaDeviceOptions;
        this.e = sigmaDeviceConfigResponse;
        this.f = sigmaDeviceSessionModel;
        this.g = sessionTokenCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        t tVar = this.f562a;
        SigmaDeviceV2Model uploadModel = com.socure.idplus.device.internal.viewModel.deviceV2.a.a(this.b, this.c, this.d, tVar.m.f618a, (Location) obj);
        SigmaDeviceConfigResponse sigmaDeviceConfigResponse = this.e;
        SigmaDeviceSessionModel sessionData = this.f;
        SessionTokenCallback sessionTokenCallback = this.g;
        com.socure.idplus.device.internal.sigmaDeviceV2.manager.c cVar = tVar.j;
        com.socure.idplus.device.internal.api.a api = tVar.l.a(sigmaDeviceConfigResponse);
        r onSuccess = new r(sessionTokenCallback, sessionData);
        s onError = new s(tVar, sessionTokenCallback);
        cVar.getClass();
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(uploadModel, "deviceV2Model");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        com.socure.idplus.device.internal.sigmaDeviceV2.dataHandler.b bVar = cVar.f613a;
        String sessionToken = sessionData.getSessionToken();
        com.socure.idplus.device.internal.sigmaDeviceV2.manager.a onSuccess2 = new com.socure.idplus.device.internal.sigmaDeviceV2.manager.a(onSuccess);
        com.socure.idplus.device.internal.sigmaDeviceV2.manager.b onError2 = new com.socure.idplus.device.internal.sigmaDeviceV2.manager.b(onError);
        bVar.getClass();
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(uploadModel, "uploadModel");
        Intrinsics.checkNotNullParameter(onSuccess2, "onSuccess");
        Intrinsics.checkNotNullParameter(onError2, "onError");
        com.socure.idplus.device.internal.network.c.a(new com.socure.idplus.device.internal.sigmaDeviceV2.dataHandler.a(api, com.socure.idplus.device.internal.common.utils.a.a(sessionToken), uploadModel), onSuccess2, onError2);
        return Unit.INSTANCE;
    }
}
