package sdk.pendo.io.g9;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0007"}, d2 = {"Lorg/json/JSONObject;", "", "name", "", "value", "a", "Lorg/json/JSONArray;", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class r {
    public static final JSONArray a(JSONArray jSONArray, Object value) {
        Intrinsics.checkNotNullParameter(jSONArray, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            if (value instanceof Boolean) {
                jSONArray.put(((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                jSONArray.put(((Number) value).doubleValue());
            } else if (value instanceof Integer) {
                jSONArray.put(((Number) value).intValue());
            } else if (value instanceof Long) {
                jSONArray.put(((Number) value).longValue());
            } else {
                jSONArray.put(value);
            }
        } catch (JSONException e) {
            PendoLogger.e(e);
        }
        return jSONArray;
    }

    public static final JSONObject a(JSONObject jSONObject, String name, Object value) {
        Intrinsics.checkNotNullParameter(jSONObject, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            if (value instanceof Boolean) {
                jSONObject.put(name, ((Boolean) value).booleanValue());
            } else if (value instanceof Double) {
                jSONObject.put(name, ((Number) value).doubleValue());
            } else if (value instanceof Integer) {
                jSONObject.put(name, ((Number) value).intValue());
            } else if (value instanceof Long) {
                jSONObject.put(name, ((Number) value).longValue());
            } else {
                jSONObject.put(name, value);
            }
        } catch (JSONException e) {
            PendoLogger.e(e);
        }
        return jSONObject;
    }
}
