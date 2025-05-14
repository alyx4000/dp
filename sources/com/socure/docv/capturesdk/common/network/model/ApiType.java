package com.socure.docv.capturesdk.common.network.model;

import com.socure.docv.capturesdk.common.utils.ApiConstant;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/socure/docv/capturesdk/common/network/model/ApiType;", "", "endpoint", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEndpoint", "()Ljava/lang/String;", "START", "START_UPLOAD", "CONFIG", "FLOW", "FETCH_CONSENT", "IMAGE_UPLOAD", "UPLOAD_STATUS", "UPLOAD_END", "POST_CONSENT", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum ApiType {
    START(ApiConstant.STEP_UP_START_URL),
    START_UPLOAD(ApiConstant.STEP_UP_START_UPLOAD_URL),
    CONFIG(ApiConstant.STEP_UP_CONFIG_URL),
    FLOW(ApiConstant.STEP_UP_FLOW_URL),
    FETCH_CONSENT(ApiConstant.GET_CONSENT_URL),
    IMAGE_UPLOAD(ApiConstant.UPLOAD_URL),
    UPLOAD_STATUS(ApiConstant.UPDATE_STATUS_URL),
    UPLOAD_END(ApiConstant.END_UPLOAD_URL),
    POST_CONSENT(ApiConstant.POST_CONSENT_URL);

    private final String endpoint;

    ApiType(String str) {
        this.endpoint = str;
    }

    public final String getEndpoint() {
        return this.endpoint;
    }
}
