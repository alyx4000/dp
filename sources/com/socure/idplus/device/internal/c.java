package com.socure.idplus.device.internal;

import android.content.Context;
import com.socure.idplus.device.callback.SigmaDeviceCallback;
import com.socure.idplus.device.context.SigmaDeviceContext;
import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SigmaDeviceCallback f558a;
    public final /* synthetic */ t b;
    public final /* synthetic */ Context c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SigmaDeviceCallback sigmaDeviceCallback, t tVar, Context context) {
        super(1);
        this.f558a = sigmaDeviceCallback;
        this.b = tVar;
        this.c = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        SigmaDeviceConfigResponse sigmaConfigResponse = (SigmaDeviceConfigResponse) obj;
        Intrinsics.checkNotNullParameter(sigmaConfigResponse, "sigmaConfigResponse");
        if (this.f558a != null) {
            t tVar = this.b;
            SigmaDeviceContext.Default sigmaDeviceContext = new SigmaDeviceContext.Default();
            b sessionTokenCallback = new b(this.f558a);
            tVar.getClass();
            Intrinsics.checkNotNullParameter(sigmaDeviceContext, "sigmaDeviceContext");
            Intrinsics.checkNotNullParameter(sessionTokenCallback, "sessionTokenCallback");
            WeakReference weakReference = tVar.f;
            Context context = weakReference != null ? (Context) weakReference.get() : null;
            if (context == null) {
                sessionTokenCallback.onError(SigmaDeviceError.ContextFetchError, "cannot perform fingerprint on a destroyed context");
            } else {
                tVar.d.a(context, tVar.l.a(), tVar.f614a, new p(tVar, sessionTokenCallback, context, sigmaDeviceContext), new q(tVar, sessionTokenCallback));
            }
        }
        this.b.a(this.c, sigmaConfigResponse);
        return Unit.INSTANCE;
    }
}
