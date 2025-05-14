package com.iterable.iterableapi;

import org.json.JSONObject;

/* compiled from: IterableRequestTask.java */
/* loaded from: classes5.dex */
class IterableApiResponse {
    final String errorMessage;
    final String responseBody;
    final int responseCode;
    final JSONObject responseJson;
    final boolean success;

    IterableApiResponse(boolean z, int i, String str, JSONObject jSONObject, String str2) {
        this.success = z;
        this.responseCode = i;
        this.responseBody = str;
        this.responseJson = jSONObject;
        this.errorMessage = str2;
    }

    static IterableApiResponse success(int i, String str, JSONObject jSONObject) {
        return new IterableApiResponse(true, i, str, jSONObject, null);
    }

    static IterableApiResponse failure(int i, String str, JSONObject jSONObject, String str2) {
        return new IterableApiResponse(false, i, str, jSONObject, str2);
    }
}
