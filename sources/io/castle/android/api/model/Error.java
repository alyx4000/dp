package io.castle.android.api.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class Error {

    @SerializedName("message")
    String message;

    @SerializedName("type")
    String type;

    public String getMessage() {
        return this.message;
    }

    public String getType() {
        return this.type;
    }

    public String toString() {
        return this.type + " " + this.message;
    }
}
