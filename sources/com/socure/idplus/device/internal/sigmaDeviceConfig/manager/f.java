package com.socure.idplus.device.internal.sigmaDeviceConfig.manager;

import android.content.Context;
import android.os.Handler;
import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.idplus.device.internal.thread.b f595a;
    public SigmaDeviceConfigResponse b;
    public final com.socure.idplus.device.internal.sigmaDeviceConfig.dataHandler.b c;

    public f(com.socure.idplus.device.internal.thread.b socureThread) {
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
        this.f595a = socureThread;
        this.c = new com.socure.idplus.device.internal.sigmaDeviceConfig.dataHandler.b();
    }

    public final void a(Context context, com.socure.idplus.device.internal.api.a api, String sdkKey, final Function1 success, Function2 error) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(api, "api");
        Intrinsics.checkNotNullParameter(sdkKey, "sdkKey");
        Intrinsics.checkNotNullParameter(success, "success");
        Intrinsics.checkNotNullParameter(error, "error");
        final SigmaDeviceConfigResponse sigmaDeviceConfigResponse = this.b;
        if (sigmaDeviceConfigResponse != null) {
            com.socure.idplus.device.internal.thread.b bVar = this.f595a;
            Runnable runnable = new Runnable() { // from class: com.socure.idplus.device.internal.sigmaDeviceConfig.manager.f$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    f.a(Function1.this, sigmaDeviceConfigResponse);
                }
            };
            com.socure.idplus.device.internal.thread.c cVar = (com.socure.idplus.device.internal.thread.c) bVar;
            cVar.getClass();
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Handler handler = cVar.f615a;
            if (handler != null) {
                handler.post(runnable);
                return;
            }
            return;
        }
        com.socure.idplus.device.internal.thread.b socureThread = this.f595a;
        d onSuccess = new d(api, this, sdkKey, success, error);
        e onError = new e(error);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError, "onError");
        try {
            com.socure.idplus.device.internal.common.utils.a.a(context, socureThread, 1, onSuccess, onError);
        } catch (Exception unused) {
            onError.invoke(SigmaDeviceError.NetworkConnectionError, "Network not available");
        }
    }

    public static final void a(Function1 success, SigmaDeviceConfigResponse sigmaDeviceConfigResponse) {
        Intrinsics.checkNotNullParameter(success, "$success");
        success.invoke(sigmaDeviceConfigResponse);
    }
}
