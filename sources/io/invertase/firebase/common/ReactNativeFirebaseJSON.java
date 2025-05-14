package io.invertase.firebase.common;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ReactNativeFirebaseJSON {
    private static ReactNativeFirebaseJSON sharedInstance = new ReactNativeFirebaseJSON();
    private JSONObject jsonObject;

    public String getRawJSON() {
        return "{\"crashlytics_debug_enabled\":true,\"android_task_executor_maximum_pool_size\":10,\"android_task_executor_keep_alive_seconds\":3,\"google_analytics_adid_collection_enabled\":false,\"analytics_default_allow_ad_personalization_signals\":false}";
    }

    private ReactNativeFirebaseJSON() {
        try {
            this.jsonObject = new JSONObject("{\"crashlytics_debug_enabled\":true,\"android_task_executor_maximum_pool_size\":10,\"android_task_executor_keep_alive_seconds\":3,\"google_analytics_adid_collection_enabled\":false,\"analytics_default_allow_ad_personalization_signals\":false}");
        } catch (JSONException unused) {
        }
    }

    public static ReactNativeFirebaseJSON getSharedInstance() {
        return sharedInstance;
    }

    public boolean contains(String str) {
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.has(str);
    }

    public boolean getBooleanValue(String str, boolean z) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? z : jSONObject.optBoolean(str, z);
    }

    public int getIntValue(String str, int i) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? i : jSONObject.optInt(str, i);
    }

    public long getLongValue(String str, long j) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? j : jSONObject.optLong(str, j);
    }

    public String getStringValue(String str, String str2) {
        JSONObject jSONObject = this.jsonObject;
        return jSONObject == null ? str2 : jSONObject.optString(str, str2);
    }

    public ArrayList<String> getArrayValue(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        JSONObject jSONObject = this.jsonObject;
        if (jSONObject == null) {
            return arrayList;
        }
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray(str);
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.getString(i));
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    public WritableMap getAll() {
        WritableMap createMap = Arguments.createMap();
        JSONArray names = this.jsonObject.names();
        for (int i = 0; i < names.length(); i++) {
            try {
                String string = names.getString(i);
                SharedUtils.mapPutValue(string, this.jsonObject.get(string), createMap);
            } catch (JSONException unused) {
            }
        }
        return createMap;
    }
}
