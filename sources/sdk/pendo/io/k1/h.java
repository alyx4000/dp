package sdk.pendo.io.k1;

import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class h {
    public static Long a(Map<String, ?> map, String str) {
        Object obj = map.get(str);
        if (obj != null) {
            return Long.valueOf(((Number) obj).longValue());
        }
        return null;
    }

    public static String b(Map<String, Object> map, String str) {
        return (String) map.get(str);
    }

    public static List<String> c(Map<String, Object> map, String str) {
        return (List) map.get(str);
    }

    public static String d(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        try {
            return (String) obj;
        } catch (ClassCastException unused) {
            throw new g("'" + str + "' parameter was " + a(obj) + " type but is required to be a String.");
        }
    }

    public static String a(Object obj) {
        return obj instanceof Number ? "Number" : obj instanceof Boolean ? "Boolean" : obj instanceof List ? "Array" : obj instanceof Map ? "Object" : obj instanceof String ? "String" : "unknown";
    }
}
