package com.extole.android.sdk.impl.http;

import android.net.Uri;
import com.extole.android.sdk.impl.ResponseEntity;
import com.iterable.iterableapi.IterableConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* compiled from: ZonesEndpoints.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0014\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/extole/android/sdk/impl/http/ZonesEndpoints;", "", "programDomain", "", "accessToken", "headers", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "getAccessToken", "()Ljava/lang/String;", "baseUrl", "endpoints", "Lcom/extole/android/sdk/impl/http/Endpoints;", "getHeaders", "()Ljava/util/Map;", "getProgramDomain", "render", "Lcom/extole/android/sdk/impl/ResponseEntity;", "Lorg/json/JSONObject;", IterableConstants.KEY_EVENT_NAME, "body", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ZonesEndpoints {
    private final String accessToken;
    private final String baseUrl;
    private final Endpoints endpoints;
    private final Map<String, String> headers;
    private final String programDomain;

    public ZonesEndpoints(String programDomain, String str, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(programDomain, "programDomain");
        Intrinsics.checkNotNullParameter(headers, "headers");
        this.programDomain = programDomain;
        this.accessToken = str;
        this.headers = headers;
        this.endpoints = new Endpoints(str, headers);
        String uri = new Uri.Builder().scheme("https").authority(programDomain).appendEncodedPath("api/v6/zones").build().toString();
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

    public final ResponseEntity<JSONObject> render(String eventName, Map<String, ? extends Object> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        HttpRequest response = this.endpoints.createHttpRequest(Uri.parse(this.baseUrl).buildUpon().build() + IOUtils.DIR_SEPARATOR_UNIX + eventName, "POST").send(new JSONObject(MapsKt.toMutableMap(body)).toString());
        Endpoints endpoints = this.endpoints;
        Intrinsics.checkNotNullExpressionValue(response, "response");
        return endpoints.handleResponse(response);
    }
}
