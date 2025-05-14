package com.reactnativegooglesignin;

import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.UnsupportedApiCallException;

/* loaded from: classes5.dex */
public class ErrorDto {
    private String code;
    private String message;

    public ErrorDto(Exception exc, String str) {
        String localizedMessage = exc.getLocalizedMessage() != null ? exc.getLocalizedMessage() : exc.getMessage();
        if (exc instanceof ApiException) {
            int statusCode = ((ApiException) exc).getStatusCode();
            String replaceFirst = localizedMessage != null && localizedMessage.length() > 10 ? localizedMessage.replaceFirst(statusCode + ": ", "") : GoogleSignInStatusCodes.getStatusCodeString(statusCode);
            this.code = String.valueOf(statusCode);
            this.message = replaceFirst;
            return;
        }
        if (exc instanceof UnsupportedApiCallException) {
            this.code = str;
            this.message = localizedMessage + " Make sure you have the latest version of Google Play Services installed.";
        } else {
            this.code = str;
            this.message = localizedMessage;
        }
    }

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
