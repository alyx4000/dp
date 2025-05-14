package com.iterable.iterableapi;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableAttributionInfo {
    public final int campaignId;
    public final String messageId;
    public final int templateId;

    public IterableAttributionInfo(int i, int i2, String str) {
        this.campaignId = i;
        this.templateId = i2;
        this.messageId = str;
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IterableConstants.KEY_CAMPAIGN_ID, this.campaignId);
            jSONObject.put(IterableConstants.KEY_TEMPLATE_ID, this.templateId);
            jSONObject.put(IterableConstants.KEY_MESSAGE_ID, this.messageId);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static IterableAttributionInfo fromJSONObject(JSONObject jSONObject) {
        if (jSONObject != null) {
            return new IterableAttributionInfo(jSONObject.optInt(IterableConstants.KEY_CAMPAIGN_ID), jSONObject.optInt(IterableConstants.KEY_TEMPLATE_ID), jSONObject.optString(IterableConstants.KEY_MESSAGE_ID));
        }
        return null;
    }
}
