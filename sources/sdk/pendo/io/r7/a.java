package sdk.pendo.io.r7;

import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f1530a = Logger.getLogger(a.class.getName());

    private a() {
    }

    private static boolean a(Object obj) {
        Logger logger;
        Level level;
        String str;
        if (obj == null) {
            return false;
        }
        if (obj instanceof byte[]) {
            return true;
        }
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    if (a(jSONArray.isNull(i) ? null : jSONArray.get(i))) {
                        return true;
                    }
                } catch (JSONException e) {
                    e = e;
                    logger = f1530a;
                    level = Level.WARNING;
                    str = "An error occured while retrieving data from JSONArray";
                    logger.log(level, str, (Throwable) e);
                    return false;
                }
            }
        } else if (obj instanceof JSONObject) {
            JSONObject jSONObject = (JSONObject) obj;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                try {
                    if (a(jSONObject.get(keys.next()))) {
                        return true;
                    }
                } catch (JSONException e2) {
                    e = e2;
                    logger = f1530a;
                    level = Level.WARNING;
                    str = "An error occured while retrieving data from JSONObject";
                    logger.log(level, str, (Throwable) e);
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean b(Object obj) {
        return a(obj);
    }
}
