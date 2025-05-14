package com.iterable.iterableapi;

import io.sentry.clientreport.DiscardedEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class CommerceItem {
    public final String[] categories;
    public final JSONObject dataFields;
    public final String description;
    public final String id;
    public final String imageUrl;
    public final String name;
    public final double price;
    public final int quantity;
    public final String sku;
    public final String url;

    public CommerceItem(String str, String str2, double d, int i) {
        this(str, str2, d, i, null, null, null, null, null, null);
    }

    public CommerceItem(String str, String str2, double d, int i, String str3, String str4, String str5, String str6, String[] strArr, JSONObject jSONObject) {
        this.id = str;
        this.name = str2;
        this.price = d;
        this.quantity = i;
        this.sku = str3;
        this.description = str4;
        this.url = str5;
        this.imageUrl = str6;
        this.categories = strArr;
        this.dataFields = jSONObject;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.id);
        jSONObject.put("name", this.name);
        jSONObject.put("price", this.price);
        jSONObject.put(DiscardedEvent.JsonKeys.QUANTITY, this.quantity);
        jSONObject.putOpt("sku", this.sku);
        jSONObject.putOpt("description", this.description);
        jSONObject.putOpt("url", this.url);
        jSONObject.putOpt("imageUrl", this.imageUrl);
        jSONObject.putOpt(IterableConstants.KEY_DATA_FIELDS, this.dataFields);
        if (this.categories != null) {
            JSONArray jSONArray = new JSONArray();
            for (String str : this.categories) {
                jSONArray.put(str);
            }
            jSONObject.put("categories", jSONArray);
        }
        return jSONObject;
    }
}
