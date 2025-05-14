package com.iterable.iterableapi;

import android.content.Context;
import com.iterable.iterableapi.IterableHelper;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
class OnlineRequestProcessor implements RequestProcessor {
    private static final String TAG = "OnlineRequestProcessor";

    @Override // com.iterable.iterableapi.RequestProcessor
    public void onLogout(Context context) {
    }

    OnlineRequestProcessor() {
    }

    @Override // com.iterable.iterableapi.RequestProcessor
    public void processGetRequest(String str, String str2, JSONObject jSONObject, String str3, IterableHelper.IterableActionHandler iterableActionHandler) {
        new IterableRequestTask().execute(new IterableApiRequest(str, str2, addCreatedAtToJson(jSONObject), "GET", str3, iterableActionHandler));
    }

    @Override // com.iterable.iterableapi.RequestProcessor
    public void processPostRequest(String str, String str2, JSONObject jSONObject, String str3, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        new IterableRequestTask().execute(new IterableApiRequest(str, str2, addCreatedAtToJson(jSONObject), "POST", str3, successHandler, failureHandler));
    }

    JSONObject addCreatedAtToJson(JSONObject jSONObject) {
        try {
            jSONObject.put("createdAt", new Date().getTime() / 1000);
        } catch (JSONException unused) {
            IterableLogger.e(TAG, "Could not add createdAt timestamp to json object");
        }
        return jSONObject;
    }
}
