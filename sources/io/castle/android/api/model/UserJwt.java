package io.castle.android.api.model;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class UserJwt {

    @SerializedName("jwt")
    private final String jwt;

    public UserJwt(String str) {
        this.jwt = str;
    }
}
