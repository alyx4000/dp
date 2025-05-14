package com.socure.idplus.device.callback;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/socure/idplus/device/callback/SigmaDeviceCallback;", "", "onError", "", "errorType", "Lcom/socure/idplus/device/error/SigmaDeviceError;", "errorMessage", "", "onSessionCreated", "sessionToken", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SigmaDeviceCallback {
    void onError(SigmaDeviceError errorType, String errorMessage);

    void onSessionCreated(String sessionToken);
}
