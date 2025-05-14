package com.socure.idplus.device.callback;

import com.socure.idplus.device.error.SigmaDeviceError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¨\u0006\n"}, d2 = {"Lcom/socure/idplus/device/callback/SessionTokenCallback;", "", "onComplete", "", "sessionToken", "", "onError", "errorType", "Lcom/socure/idplus/device/error/SigmaDeviceError;", "errorMessage", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface SessionTokenCallback {
    void onComplete(String sessionToken);

    void onError(SigmaDeviceError errorType, String errorMessage);
}
