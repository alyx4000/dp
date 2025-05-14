package com.extole.android.sdk.impl.http;

import android.net.Uri;
import com.extole.android.sdk.impl.ResponseEntity;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: AuthorizationEndpoints.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003J&\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0018\u0010\u0016\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/extole/android/sdk/impl/http/AuthorizationEndpoints;", "", "programDomain", "", "accessToken", "headers", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAccessToken", "()Ljava/lang/String;", "baseUrl", "endpoints", "Lcom/extole/android/sdk/impl/http/Endpoints;", "getHeaders", "()Ljava/util/Map;", "getProgramDomain", "createToken", "Lcom/extole/android/sdk/impl/ResponseEntity;", "Lorg/json/JSONObject;", "email", "jwt", "getTokenDetails", "queryParams", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AuthorizationEndpoints {
    private final String accessToken;
    private final String baseUrl;
    private final Endpoints endpoints;
    private final Map<String, String> headers;
    private final String programDomain;

    public AuthorizationEndpoints(String programDomain, String str, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(programDomain, "programDomain");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.programDomain = programDomain;
        this.accessToken = str;
        this.headers = headers;
        this.endpoints = new Endpoints(str, headers);
        String uri = new Uri.Builder().scheme("https").authority(programDomain).appendEncodedPath("api/v5/token").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Builder().scheme(\"https\"…      .build().toString()");
        this.baseUrl = uri;
    }

    public final String getProgramDomain() {
        return this.programDomain;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public final ResponseEntity<JSONObject> getTokenDetails(Map<String, ? extends Object> queryParams) {
        String requestUrl = HttpRequest.encode(HttpRequest.append(this.baseUrl, queryParams));
        Endpoints endpoints = this.endpoints;
        Intrinsics.checkNotNullExpressionValue(requestUrl, "requestUrl");
        return this.endpoints.handleResponse(endpoints.createHttpRequest(requestUrl, "GET"));
    }

    public final ResponseEntity<JSONObject> createToken(String email, String jwt) {
        JSONObject jSONObject = new JSONObject();
        HttpRequest createHttpRequest = this.endpoints.createHttpRequest(this.baseUrl, "POST");
        if (email != null) {
            jSONObject.put("email", email);
        }
        if (jwt != null) {
            jSONObject.put("jwt", jwt);
        }
        createHttpRequest.send(jSONObject.toString());
        return this.endpoints.handleResponse(createHttpRequest);
    }
}
