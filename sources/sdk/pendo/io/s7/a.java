package sdk.pendo.io.s7;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class a {
    public static Map<String, String> a(String str) {
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            String[] split = str2.split("=");
            hashMap.put(sdk.pendo.io.q7.a.a(split[0]), split.length > 1 ? sdk.pendo.io.q7.a.a(split[1]) : "");
        }
        return hashMap;
    }

    public static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(sdk.pendo.io.q7.a.b(entry.getKey())).append("=").append(sdk.pendo.io.q7.a.b(entry.getValue()));
        }
        return sb.toString();
    }
}
