package com.iterable.iterableapi;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableAction {
    public static final String ACTION_TYPE_OPEN_URL = "openUrl";
    private final JSONObject config;
    public String userInput;

    private IterableAction(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.config = jSONObject;
        } else {
            this.config = new JSONObject();
        }
    }

    static IterableAction from(JSONObject jSONObject) {
        if (jSONObject != null) {
            return new IterableAction(jSONObject);
        }
        return null;
    }

    static IterableAction actionOpenUrl(String str) {
        if (str == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", ACTION_TYPE_OPEN_URL);
            jSONObject.put("data", str);
            return new IterableAction(jSONObject);
        } catch (JSONException unused) {
            return null;
        }
    }

    static IterableAction actionCustomAction(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", str);
            return new IterableAction(jSONObject);
        } catch (JSONException unused) {
            return null;
        }
    }

    public String getType() {
        return this.config.optString("type", null);
    }

    public String getData() {
        return this.config.optString("data", null);
    }

    public boolean isOfType(String str) {
        return getType() != null && getType().equals(str);
    }
}
