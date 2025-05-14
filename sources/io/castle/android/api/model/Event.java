package io.castle.android.api.model;

import com.google.gson.annotations.SerializedName;
import com.iterable.iterableapi.IterableConstants;
import io.castle.android.Castle;
import io.castle.android.Utils;

/* loaded from: classes2.dex */
public abstract class Event {
    public static final String EVENT_TYPE_CUSTOM = "custom";
    public static final String EVENT_TYPE_SCREEN = "screen";

    @SerializedName("name")
    String name;

    @SerializedName("timestamp")
    String timestamp = Utils.getTimestamp();

    @SerializedName(IterableConstants.KEY_TOKEN)
    String token = Castle.createRequestToken();

    @SerializedName("type")
    String type;

    public Event(String str) {
        this.name = str;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getToken() {
        return this.token;
    }

    public String encode() {
        return Castle.encodeEvent(this);
    }
}
