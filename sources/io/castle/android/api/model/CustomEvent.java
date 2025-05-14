package io.castle.android.api.model;

import com.google.gson.annotations.SerializedName;
import io.castle.android.Castle;
import io.castle.android.CastleLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class CustomEvent extends Event {

    @SerializedName("properties")
    Map<String, Object> properties;

    public CustomEvent(String str) {
        this(str, new HashMap());
    }

    public CustomEvent(String str, Map<String, Object> map) {
        super(str);
        this.type = Event.EVENT_TYPE_CUSTOM;
        if (!propertiesContainValidData(map)) {
            CastleLogger.e("Properties dictionary contains invalid data. Supported types are: String, Integer, Float, Double, Map & Null");
        } else {
            this.properties = map;
        }
    }

    @Override // io.castle.android.api.model.Event
    public String encode() {
        return Castle.encodeEvent(this);
    }

    public static boolean propertiesContainValidData(Map<String, Object> map) {
        if (map == null) {
            return false;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next().getValue();
            if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && value != null) {
                CastleLogger.e("Properties map contains invalid data.");
                return false;
            }
        }
        return true;
    }
}
