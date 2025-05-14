package sdk.pendo.io.n7;

import io.sentry.Session;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f1424a;
    public String[] b;
    public long c;
    public long d;

    b(String str) {
        this(new JSONObject(str));
    }

    b(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("upgrades");
        int length = jSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = jSONArray.getString(i);
        }
        this.f1424a = jSONObject.getString(Session.JsonKeys.SID);
        this.b = strArr;
        this.c = jSONObject.getLong("pingInterval");
        this.d = jSONObject.getLong("pingTimeout");
    }
}
