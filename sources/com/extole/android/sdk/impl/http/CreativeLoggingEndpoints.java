package com.extole.android.sdk.impl.http;

import android.net.Uri;
import com.extole.android.sdk.impl.ResponseEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: CreativeLoggingEndpoints.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/extole/android/sdk/impl/http/CreativeLoggingEndpoints;", "", "programDomain", "", "accessToken", "(Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "baseUrl", "endpoints", "Lcom/extole/android/sdk/impl/http/Endpoints;", "getProgramDomain", "create", "Lcom/extole/android/sdk/impl/ResponseEntity;", "Lorg/json/JSONObject;", "level", "message", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CreativeLoggingEndpoints {
    private final String accessToken;
    private final String baseUrl;
    private final Endpoints endpoints;
    private final String programDomain;

    public CreativeLoggingEndpoints(String programDomain, String str) {
        Intrinsics.checkNotNullParameter(programDomain, "programDomain");
        this.programDomain = programDomain;
        this.accessToken = str;
        this.endpoints = new Endpoints(str, null, 2, null);
        String uri = new Uri.Builder().scheme("https").authority(programDomain).appendEncodedPath("api/v4/debug/logs").build().toString();
        Intrinsics.checkNotNullExpressionValue(uri, "Builder().scheme(\"https\"…      .build().toString()");
        this.baseUrl = uri;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final String getProgramDomain() {
        return this.programDomain;
    }

    public final ResponseEntity<JSONObject> create(String level, String message) {
        Intrinsics.checkNotNullParameter(level, "level");
        Intrinsics.checkNotNullParameter(message, "message");
        JSONObject jSONObject = new JSONObject();
        HttpRequest createHttpRequest = this.endpoints.createHttpRequest(this.baseUrl, "POST");
        jSONObject.put("level", level);
        jSONObject.put("message", message);
        HttpRequest response = createHttpRequest.send(jSONObject.toString());
        Endpoints endpoints = this.endpoints;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        return endpoints.handleResponse(response);
    }
}
