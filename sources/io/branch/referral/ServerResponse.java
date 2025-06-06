package io.branch.referral;

import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ServerResponse {
    private String message_;
    private Object post_;
    private String requestId_;
    private int statusCode_;
    private String tag_;

    public ServerResponse(String str, int i, String str2, String str3) {
        this.tag_ = str;
        this.statusCode_ = i;
        this.requestId_ = str2;
        this.message_ = str3;
    }

    public String getTag() {
        return this.tag_;
    }

    public int getStatusCode() {
        return this.statusCode_;
    }

    public void setPost(Object obj) {
        this.post_ = obj;
    }

    public JSONObject getObject() {
        Object obj = this.post_;
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        return new JSONObject();
    }

    public JSONArray getArray() {
        Object obj = this.post_;
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        return null;
    }

    public String getFailReason() {
        try {
            JSONObject object = getObject();
            if (object == null || !object.has("error") || !object.getJSONObject("error").has("message")) {
                return "";
            }
            String string = object.getJSONObject("error").getString("message");
            return (string == null || string.trim().length() <= 0) ? string : string + ".";
        } catch (Exception e) {
            BranchLogger.d(e.getMessage());
            return "";
        }
    }

    public String getMessage() {
        return this.message_;
    }
}
