package com.iterable.iterableapi;

import org.json.JSONObject;

/* loaded from: classes5.dex */
public class RNIterableInternal {
    private static String TAG = "RNIterableInternal";

    public static String getEmail() {
        return IterableApi.getInstance().getEmail();
    }

    public static String getUserId() {
        return IterableApi.getInstance().getUserId();
    }

    public static JSONObject getInAppMessageJson(IterableInAppMessage iterableInAppMessage) {
        return iterableInAppMessage.toJSONObject();
    }

    public static IterableInAppMessage getMessageById(String str) {
        return IterableApi.getInstance().getInAppManager().getMessageById(str);
    }

    public static void trackPushOpenWithCampaignId(Integer num, Integer num2, String str, JSONObject jSONObject) {
        IterableApi.getInstance().trackPushOpen(num.intValue(), num2.intValue(), str, jSONObject);
    }

    public static void setAttributionInfo(IterableAttributionInfo iterableAttributionInfo) {
        IterableApi.getInstance().setAttributionInfo(iterableAttributionInfo);
    }
}
