package com.iterable.iterableapi.ddl;

import com.iterable.iterableapi.IterableConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MatchFpResponse {
    public final int campaignId;
    public final String destinationUrl;
    public final boolean isMatch;
    public final String messageId;
    public final int templateId;

    public MatchFpResponse(boolean z, String str, int i, int i2, String str2) {
        this.isMatch = z;
        this.destinationUrl = str;
        this.campaignId = i;
        this.templateId = i2;
        this.messageId = str2;
    }

    public static MatchFpResponse fromJSONObject(JSONObject jSONObject) throws JSONException {
        return new MatchFpResponse(jSONObject.getBoolean("isMatch"), jSONObject.getString("destinationUrl"), jSONObject.getInt(IterableConstants.KEY_CAMPAIGN_ID), jSONObject.getInt(IterableConstants.KEY_TEMPLATE_ID), jSONObject.getString(IterableConstants.KEY_MESSAGE_ID));
    }
}
