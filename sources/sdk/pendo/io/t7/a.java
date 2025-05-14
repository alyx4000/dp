package sdk.pendo.io.t7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f1631a = Logger.getLogger(a.class.getName());

    /* renamed from: sdk.pendo.io.t7.a$a, reason: collision with other inner class name */
    public static class C0240a {

        /* renamed from: a, reason: collision with root package name */
        public c f1632a;
        public byte[][] b;
    }

    private static Object a(Object obj, List<byte[]> list) {
        Logger logger;
        Level level;
        if (obj == null) {
            return null;
        }
        String str = "An error occured while putting data to JSONObject";
        try {
            if (obj instanceof byte[]) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("_placeholder", true);
                jSONObject.put("num", list.size());
                list.add((byte[]) obj);
                return jSONObject;
            }
            if (!(obj instanceof JSONArray)) {
                if (!(obj instanceof JSONObject)) {
                    return obj;
                }
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = (JSONObject) obj;
                Iterator<String> keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.put(next, a(jSONObject3.get(next), list));
                }
                return jSONObject2;
            }
            JSONArray jSONArray = new JSONArray();
            JSONArray jSONArray2 = (JSONArray) obj;
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, a(jSONArray2.get(i), list));
                } catch (JSONException e) {
                    e = e;
                    logger = f1631a;
                    level = Level.WARNING;
                    str = "An error occured while putting packet data to JSONObject";
                    logger.log(level, str, (Throwable) e);
                    return null;
                }
            }
            return jSONArray;
        } catch (JSONException e2) {
            e = e2;
            logger = f1631a;
            level = Level.WARNING;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [org.json.JSONObject] */
    private static Object a(Object obj, byte[][] bArr) {
        Logger logger;
        Level level;
        String str;
        if (obj instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) obj;
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    jSONArray.put(i, a(jSONArray.get(i), bArr));
                } catch (JSONException e) {
                    e = e;
                    logger = f1631a;
                    level = Level.WARNING;
                    str = "An error occured while putting packet data to JSONObject";
                }
            }
            return jSONArray;
        }
        if (obj instanceof JSONObject) {
            obj = (JSONObject) obj;
            if (obj.optBoolean("_placeholder")) {
                int optInt = obj.optInt("num", -1);
                if (optInt < 0 || optInt >= bArr.length) {
                    return null;
                }
                return bArr[optInt];
            }
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    obj.put(next, a(obj.get(next), bArr));
                } catch (JSONException e2) {
                    e = e2;
                    logger = f1631a;
                    level = Level.WARNING;
                    str = "An error occured while putting data to JSONObject";
                }
            }
        }
        return obj;
        logger.log(level, str, (Throwable) e);
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    public static C0240a a(c cVar) {
        ArrayList arrayList = new ArrayList();
        cVar.d = a(cVar.d, arrayList);
        cVar.e = arrayList.size();
        C0240a c0240a = new C0240a();
        c0240a.f1632a = cVar;
        c0240a.b = (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
        return c0240a;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    public static c a(c cVar, byte[][] bArr) {
        cVar.d = a(cVar.d, bArr);
        cVar.e = -1;
        return cVar;
    }
}
