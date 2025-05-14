package com.socure.idplus.device.internal;

import android.content.Context;
import com.socure.idplus.device.SigmaDeviceOptions;
import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.context.SigmaDeviceContext;
import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import com.socure.idplus.device.internal.sigmaDeviceSession.model.SigmaDeviceSessionModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class o extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f582a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ SigmaDeviceConfigResponse c;
    public final /* synthetic */ SigmaDeviceContext d;
    public final /* synthetic */ SessionTokenCallback e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(t tVar, Context context, SigmaDeviceConfigResponse sigmaDeviceConfigResponse, SigmaDeviceContext sigmaDeviceContext, SessionTokenCallback sessionTokenCallback) {
        super(1);
        this.f582a = tVar;
        this.b = context;
        this.c = sigmaDeviceConfigResponse;
        this.d = sigmaDeviceContext;
        this.e = sessionTokenCallback;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceSessionModel sessionData = (SigmaDeviceSessionModel) obj;
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        t tVar = this.f582a;
        Context context = this.b;
        SigmaDeviceConfigResponse sigmaDeviceConfigResponse = this.c;
        SigmaDeviceContext sigmaDeviceContext = this.d;
        SigmaDeviceOptions options = tVar.b;
        SessionTokenCallback sessionTokenCallback = this.e;
        com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f fVar = tVar.g;
        g onSuccess = new g(context, options, sessionTokenCallback, sigmaDeviceContext, tVar, sigmaDeviceConfigResponse, sessionData);
        h onError = new h(tVar, sessionTokenCallback);
        fVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        com.socure.idplus.device.internal.sigmaDeviceLocation.monitor.a aVar = fVar.c;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!options.getOmitLocationData()) {
            com.socure.idplus.device.internal.permission.b bVar = com.socure.idplus.device.internal.permission.b.f584a;
            if (com.socure.idplus.device.internal.permission.a.a(context)) {
                com.socure.idplus.device.internal.thread.b socureThread = fVar.f602a;
                com.socure.idplus.device.internal.sigmaDeviceLocation.manager.b onSuccess2 = new com.socure.idplus.device.internal.sigmaDeviceLocation.manager.b(fVar, context, onSuccess);
                com.socure.idplus.device.internal.sigmaDeviceLocation.manager.c onError2 = new com.socure.idplus.device.internal.sigmaDeviceLocation.manager.c(onError);
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(socureThread, "socureThread");
                Intrinsics.checkNotNullParameter(onSuccess2, "onSuccess");
                Intrinsics.checkNotNullParameter(onError2, "onError");
                try {
                    com.socure.idplus.device.internal.common.utils.a.a(context, socureThread, 1, onSuccess2, onError2);
                } catch (Exception unused) {
                    onError2.invoke(SigmaDeviceError.NetworkConnectionError, "Network not available");
                }
                return Unit.INSTANCE;
            }
            aVar.f603a = true;
        }
        onSuccess.invoke(null);
        return Unit.INSTANCE;
    }
}
