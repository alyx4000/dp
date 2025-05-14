package com.socure.idplus.device;

import android.app.Application;
import android.content.Context;
import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.callback.SigmaDeviceCallback;
import com.socure.idplus.device.context.SigmaDeviceContext;
import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.p;
import com.socure.idplus.device.internal.q;
import com.socure.idplus.device.internal.sigmaDeviceSession.manager.e;
import com.socure.idplus.device.internal.t;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f¨\u0006\u0013"}, d2 = {"Lcom/socure/idplus/device/SigmaDevice;", "", "Landroid/content/Context;", "context", "", "sdkKey", "Lcom/socure/idplus/device/SigmaDeviceOptions;", "sigmaDeviceOptions", "Lcom/socure/idplus/device/callback/SigmaDeviceCallback;", "sigmaDeviceCallback", "", "initializeSDK", "Lcom/socure/idplus/device/callback/SessionTokenCallback;", "sessionTokenCallback", "getSessionToken", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "sigmaDeviceContext", "processDevice", "com/socure/idplus/device/a", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes5.dex */
public final class SigmaDevice {
    public static final SigmaDevice INSTANCE = new SigmaDevice();

    /* renamed from: a, reason: collision with root package name */
    public static boolean f544a;
    public static String b;
    public static SigmaDeviceOptions c;
    public static com.socure.idplus.device.internal.a d;
    public static a e;

    public static /* synthetic */ void initializeSDK$default(SigmaDevice sigmaDevice, Context context, String str, SigmaDeviceOptions sigmaDeviceOptions, SigmaDeviceCallback sigmaDeviceCallback, int i, Object obj) {
        if ((i & 4) != 0) {
            sigmaDeviceOptions = null;
        }
        sigmaDevice.initializeSDK(context, str, sigmaDeviceOptions, sigmaDeviceCallback);
    }

    public static /* synthetic */ void processDevice$default(SigmaDevice sigmaDevice, SigmaDeviceContext sigmaDeviceContext, SessionTokenCallback sessionTokenCallback, int i, Object obj) {
        if ((i & 1) != 0) {
            sigmaDeviceContext = new SigmaDeviceContext.Other("unknown");
        }
        sigmaDevice.processDevice(sigmaDeviceContext, sessionTokenCallback);
    }

    public final void getSessionToken(SessionTokenCallback sessionTokenCallback) {
        Intrinsics.checkNotNullParameter(sessionTokenCallback, "sessionTokenCallback");
        if (!f544a) {
            throw new IllegalStateException("getSessionToken() cannot be called without initializeSDK()".toString());
        }
        com.socure.idplus.device.internal.a aVar = d;
        if (aVar != null) {
            Intrinsics.checkNotNullParameter(sessionTokenCallback, "sessionTokenCallback");
            e eVar = ((t) aVar).h;
            eVar.getClass();
            Intrinsics.checkNotNullParameter(sessionTokenCallback, "sessionTokenCallback");
            if (eVar.b) {
                eVar.c.add(sessionTokenCallback);
                return;
            }
            String str = eVar.d;
            if (str != null) {
                sessionTokenCallback.onComplete(str);
            } else {
                sessionTokenCallback.onError(SigmaDeviceError.DataFetchError, "Unable to fetch session");
            }
        }
    }

    public final void initializeSDK(Context context, String sdkKey, SigmaDeviceOptions sigmaDeviceOptions, SigmaDeviceCallback sigmaDeviceCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkKey, "sdkKey");
        Intrinsics.checkNotNullParameter(sigmaDeviceCallback, "sigmaDeviceCallback");
        if (!(!StringsKt.isBlank(sdkKey))) {
            throw new IllegalArgumentException("The SDK key must not be blank.".toString());
        }
        if (f544a) {
            return;
        }
        f544a = true;
        b = sdkKey;
        SigmaDeviceOptions sigmaDeviceOptions2 = sigmaDeviceOptions == null ? new SigmaDeviceOptions(false, null, false, 7, null) : sigmaDeviceOptions;
        c = sigmaDeviceOptions2;
        d = new t(context, sdkKey, sigmaDeviceOptions2, sigmaDeviceCallback, 112);
        e = new a();
        Context applicationContext = context.getApplicationContext();
        a aVar = null;
        Application application = applicationContext instanceof Application ? (Application) applicationContext : null;
        if (application != null) {
            a aVar2 = e;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleCallbacks");
            } else {
                aVar = aVar2;
            }
            application.registerActivityLifecycleCallbacks(aVar);
        }
    }

    public final void processDevice(SigmaDeviceContext sigmaDeviceContext, SessionTokenCallback sessionTokenCallback) {
        Intrinsics.checkNotNullParameter(sigmaDeviceContext, "sigmaDeviceContext");
        Intrinsics.checkNotNullParameter(sessionTokenCallback, "sessionTokenCallback");
        if (!f544a) {
            throw new IllegalStateException("processDevice() cannot be called without initializeSDK()".toString());
        }
        com.socure.idplus.device.internal.a aVar = d;
        if (aVar != null) {
            t tVar = (t) aVar;
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
    }
}
