package com.socure.idplus.device.internal;

import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.callback.SigmaDeviceCallback;
import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b implements SessionTokenCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SigmaDeviceCallback f548a;

    public b(SigmaDeviceCallback sigmaDeviceCallback) {
        this.f548a = sigmaDeviceCallback;
    }

    @Override // com.socure.idplus.device.callback.SessionTokenCallback
    public final void onComplete(String sessionToken) {
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        this.f548a.onSessionCreated(sessionToken);
    }

    @Override // com.socure.idplus.device.callback.SessionTokenCallback
    public final void onError(SigmaDeviceError errorType, String str) {
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        this.f548a.onError(errorType, str);
    }
}
