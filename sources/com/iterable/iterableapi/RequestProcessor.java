package com.iterable.iterableapi;

import android.content.Context;
import com.iterable.iterableapi.IterableHelper;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public interface RequestProcessor {
    void onLogout(Context context);

    void processGetRequest(String str, String str2, JSONObject jSONObject, String str3, IterableHelper.IterableActionHandler iterableActionHandler);

    void processPostRequest(String str, String str2, JSONObject jSONObject, String str3, IterableHelper.SuccessHandler successHandler, IterableHelper.FailureHandler failureHandler);
}
