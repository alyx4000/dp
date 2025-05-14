package com.quantummetric.ui.internal;

import java.util.Iterator;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class ay {
    private static int a(Object obj) {
        return obj instanceof JSONObject ? a((JSONObject) obj) : obj instanceof JSONArray ? a((JSONArray) obj) : obj.hashCode();
    }

    private static int a(JSONArray jSONArray) {
        int i = 1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            i = (i * 31) + a(jSONArray.opt(i2));
        }
        return i;
    }

    static int a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        int i = 0;
        while (keys.hasNext()) {
            String next = keys.next();
            i += next.hashCode() ^ a(jSONObject.opt(next));
        }
        return i;
    }

    private static boolean a(Object obj, Object obj2) {
        return ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) ? a((JSONObject) obj, (JSONObject) obj2) : ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) ? a((JSONArray) obj, (JSONArray) obj2) : Objects.equals(obj, obj2);
    }

    private static boolean a(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray == null && jSONArray2 == null) {
            return true;
        }
        if (jSONArray == null || jSONArray2 == null || jSONArray.length() != jSONArray2.length()) {
            return false;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            if (!a(jSONArray.opt(i), jSONArray2.opt(i))) {
                return false;
            }
        }
        return true;
    }

    static boolean a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null && jSONObject2 == null) {
            return true;
        }
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length()) {
            return false;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next) || !a(jSONObject.opt(next), jSONObject2.opt(next))) {
                return false;
            }
        }
        return true;
    }
}
