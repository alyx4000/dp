package com.socure.docv.capturesdk.api;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/api/ResponseCode;", "", ApiConstant.KEY_CODE, "", "message", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "SUCCESS", "AUTHORIZATION_FAILURE", "SESSION_INITIATION_FAILURE", "SESSION_EXPIRED", "EMPTY_KEY", "NO_INTERNET", "CAMERA_PERMISSION_DENIED", "UPLOAD_FAILURE", "DOCUMENT_SCAN_CANCEL", "CAMERA_ERROR", "UNKNOWN_ERROR", "CAMERA_MINIMUM_REQ_ERROR", "CONFIG_FLOW_DATA_INVALID", "CONSENT_NOT_GIVEN", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ResponseCode {
    SUCCESS(200, "success"),
    AUTHORIZATION_FAILURE(7011, "Invalid key"),
    SESSION_INITIATION_FAILURE(7021, "Failed to initiate the session"),
    SESSION_EXPIRED(7014, "Session expired"),
    EMPTY_KEY(7101, "Empty key"),
    NO_INTERNET(7103, "No internet connection"),
    CAMERA_PERMISSION_DENIED(7102, "Do not have the required permissions to open the camera"),
    UPLOAD_FAILURE(7022, "Failed to upload the documents"),
    DOCUMENT_SCAN_CANCEL(7104, "Scan canceled by the user"),
    CAMERA_ERROR(7106, "Camera error"),
    UNKNOWN_ERROR(7107, "Unknown error"),
    CAMERA_MINIMUM_REQ_ERROR(7108, "Camera resolution doesn't match the minimum requirement"),
    CONFIG_FLOW_DATA_INVALID(7109, "Invalid config data"),
    CONSENT_NOT_GIVEN(7110, "Consent declined");

    private final int code;
    private final String message;

    ResponseCode(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
