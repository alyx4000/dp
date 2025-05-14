package com.iterable.iterableapi;

import com.iterable.iterableapi.IterableHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableRequestTask.java */
/* loaded from: classes5.dex */
class IterableApiRequest {
    static final String GET = "GET";
    static final String POST = "POST";
    private static final String TAG = "IterableApiRequest";
    final String apiKey;
    final String authToken;
    final String baseUrl;
    IterableHelper.FailureHandler failureCallback;
    final JSONObject json;
    IterableHelper.IterableActionHandler legacyCallback;
    private ProcessorType processorType;
    final String requestType;
    final String resourcePath;
    IterableHelper.SuccessHandler successCallback;

    /* compiled from: IterableRequestTask.java */
    enum ProcessorType {
        ONLINE { // from class: com.iterable.iterableapi.IterableApiRequest.ProcessorType.1
            @Override // java.lang.Enum
            public String toString() {
                return "Online";
            }
        },
        OFFLINE { // from class: com.iterable.iterableapi.IterableApiRequest.ProcessorType.2
            @Override // java.lang.Enum
            public String toString() {
                return "Offline";
            }
        }
    }

    public ProcessorType getProcessorType() {
        return this.processorType;
    }

    void setProcessorType(ProcessorType processorType) {
        this.processorType = processorType;
    }

    IterableApiRequest(String str, String str2, String str3, JSONObject jSONObject, String str4, String str5, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        this.processorType = ProcessorType.ONLINE;
        this.apiKey = str;
        this.baseUrl = str2;
        this.resourcePath = str3;
        this.json = jSONObject;
        this.requestType = str4;
        this.authToken = str5;
        this.successCallback = successHandler;
        this.failureCallback = failureHandler;
    }

    IterableApiRequest(String str, String str2, JSONObject jSONObject, String str3, String str4, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        this.processorType = ProcessorType.ONLINE;
        this.apiKey = str;
        this.baseUrl = null;
        this.resourcePath = str2;
        this.json = jSONObject;
        this.requestType = str3;
        this.authToken = str4;
        this.successCallback = successHandler;
        this.failureCallback = failureHandler;
    }

    IterableApiRequest(String str, String str2, JSONObject jSONObject, String str3, String str4, IterableHelper.IterableActionHandler iterableActionHandler) {
        this.processorType = ProcessorType.ONLINE;
        this.apiKey = str;
        this.baseUrl = null;
        this.resourcePath = str2;
        this.json = jSONObject;
        this.requestType = str3;
        this.authToken = str4;
        this.legacyCallback = iterableActionHandler;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("apiKey", this.apiKey);
        jSONObject.put("resourcePath", this.resourcePath);
        jSONObject.put("authToken", this.authToken);
        jSONObject.put("requestType", this.requestType);
        jSONObject.put("data", this.json);
        return jSONObject;
    }

    static IterableApiRequest fromJSON(JSONObject jSONObject, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler) {
        try {
            return new IterableApiRequest(jSONObject.getString("apiKey"), jSONObject.getString("resourcePath"), jSONObject.getJSONObject("data"), jSONObject.getString("requestType"), jSONObject.has("authToken") ? jSONObject.getString("authToken") : "", successHandler, failureHandler);
        } catch (JSONException unused) {
            IterableLogger.e(TAG, "Failed to create Iterable request from JSON");
            return null;
        }
    }
}
