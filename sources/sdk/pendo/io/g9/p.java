package sdk.pendo.io.g9;

import com.amplitude.reactnative.DatabaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a&\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007\u001a\u001e\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0018\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n\u001a$\u0010\u0004\u001a\u00020\u00112\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u000f\u001a\n\u0010\u0004\u001a\u00020\u0012*\u00020\u0012¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/k0/l;", "jsonObject", "", DatabaseConstants.KEY_FIELD, "a", "defaultVal", "", "Lsdk/pendo/io/k0/f;", "b", "jsonArray", "", "index", "", "", "properties", "Lorg/json/JSONObject;", "propertiesJSON", "", "Lorg/json/JSONArray;", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class p {
    public static final String a(sdk.pendo.io.k0.l jsonObject, String key) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        String a2 = a(jsonObject, key, null, 4, null);
        if (a2 != null) {
            return a2;
        }
        throw new n("Json Exception. Key: " + key + "doesn't exist.");
    }

    public static final sdk.pendo.io.k0.f b(sdk.pendo.io.k0.l jsonObject, String key) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return jsonObject.b(key);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String c(sdk.pendo.io.k0.l jsonObject, String key) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        return a(jsonObject, key, null, 4, null);
    }

    public static final void a(Map<String, ? extends Object> map, JSONObject propertiesJSON) {
        Intrinsics.checkNotNullParameter(propertiesJSON, "propertiesJSON");
        if (map != null) {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                propertiesJSON.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static final boolean a(sdk.pendo.io.k0.l jsonObject, String key, boolean z) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return jsonObject.a(key).a();
        } catch (Exception unused) {
            return z;
        }
    }

    public static final sdk.pendo.io.k0.l a(sdk.pendo.io.k0.f jsonArray, int i) {
        Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
        try {
            return jsonArray.a(i).e();
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String a(sdk.pendo.io.k0.l jsonObject, String key, String str) {
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            return jsonObject.a(key).g();
        } catch (Exception unused) {
            return str;
        }
    }

    public static /* synthetic */ String a(sdk.pendo.io.k0.l lVar, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = null;
        }
        return a(lVar, str, str2);
    }

    public static final synchronized JSONArray a(JSONArray jSONArray) {
        synchronized (p.class) {
            Intrinsics.checkNotNullParameter(jSONArray, "<this>");
            int i = 0;
            for (int length = jSONArray.length() - 1; length > i; length--) {
                Object obj = jSONArray.get(i);
                jSONArray.put(i, jSONArray.get(length));
                jSONArray.put(length, obj);
                i++;
            }
        }
        return jSONArray;
    }
}
