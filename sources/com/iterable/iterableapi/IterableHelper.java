package com.iterable.iterableapi;

import android.net.Uri;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class IterableHelper {

    public interface FailureHandler {
        void onFailure(String str, JSONObject jSONObject);
    }

    public interface IterableActionHandler {
        void execute(String str);
    }

    public interface IterableUrlCallback {
        void execute(Uri uri);
    }

    public interface SuccessAuthHandler {
        void onSuccess(String str);
    }

    public interface SuccessHandler {
        void onSuccess(JSONObject jSONObject);
    }
}
