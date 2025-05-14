package com.extole.android.sdk.impl.http;

import com.extole.android.sdk.RestException;
import com.extole.android.sdk.impl.ResponseEntity;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: Endpoints.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002J\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0011\u001a\u00020\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/extole/android/sdk/impl/http/Endpoints;", "", "accessToken", "", "headers", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getAccessToken", "()Ljava/lang/String;", "getHeaders", "()Ljava/util/Map;", "createHttpRequest", "Lcom/extole/android/sdk/impl/http/HttpRequest;", "baseUrl", "requestMethod", "handleException", "Lcom/extole/android/sdk/RestException;", "httpRequest", "handleResponse", "Lcom/extole/android/sdk/impl/ResponseEntity;", "Lorg/json/JSONObject;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Endpoints {
    private final String accessToken;
    private final Map<String, String> headers;

    public Endpoints(String str, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.accessToken = str;
        this.headers = headers;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public /* synthetic */ Endpoints(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final ResponseEntity<JSONObject> handleResponse(HttpRequest httpRequest) {
        Intrinsics.checkNotNullParameter(httpRequest, "httpRequest");
        if (httpRequest.ok() || httpRequest.created() || httpRequest.noContent()) {
            JSONObject jSONObject = new JSONObject(httpRequest.body());
            Map<String, List<String>> headers = httpRequest.headers();
            Intrinsics.checkNotNullExpressionValue(headers, "httpRequest.headers()");
            return new ResponseEntity<>(jSONObject, headers, httpRequest.code());
        }
        throw handleException(httpRequest);
    }

    public final HttpRequest createHttpRequest(String baseUrl, String requestMethod) {
        Intrinsics.checkNotNullParameter(baseUrl, "baseUrl");
        Intrinsics.checkNotNullParameter(requestMethod, "requestMethod");
        HttpRequest headers = new HttpRequest(baseUrl, requestMethod).authorization(this.accessToken).acceptJson().contentType("application/json").headers(this.headers);
        Intrinsics.checkNotNullExpressionValue(headers, "HttpRequest(baseUrl, req…        .headers(headers)");
        return headers;
    }

    private final RestException handleException(HttpRequest httpRequest) {
        JSONObject jSONObject = new JSONObject(httpRequest.body());
        String string = jSONObject.getString("unique_id");
        Intrinsics.checkNotNullExpressionValue(string, "responseBody.getString(\"unique_id\")");
        String string2 = jSONObject.getString("http_status_code");
        Intrinsics.checkNotNullExpressionValue(string2, "responseBody.getString(\"http_status_code\")");
        String string3 = jSONObject.getString(ApiConstant.KEY_CODE);
        Intrinsics.checkNotNullExpressionValue(string3, "responseBody.getString(\"code\")");
        String string4 = jSONObject.getString("message");
        Intrinsics.checkNotNullExpressionValue(string4, "responseBody.getString(\"message\")");
        JSONObject jSONObject2 = jSONObject.getJSONObject("parameters");
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "responseBody.getJSONObject(\"parameters\")");
        return new RestException(string, string2, string3, string4, JSONObjectExtensionKt.toMap(jSONObject2));
    }
}
