package sdk.pendo.io.o8;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class b {
    private static volatile b d;
    private static final Object e = new Object();

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f1478a = new AtomicBoolean(false);
    private LinkedList<a> b = new LinkedList<>();
    private int c;

    private b() {
        a(60);
    }

    public static b b() {
        b bVar = d;
        if (bVar == null) {
            synchronized (e) {
                bVar = d;
                if (bVar == null) {
                    bVar = new b();
                    d = bVar;
                }
            }
        }
        return bVar;
    }

    public final void a(String str, String str2, String str3) {
        if (sdk.pendo.io.y8.a.d().i()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("level", str2);
                jSONObject.put("data", str);
                jSONObject.put("exception", str3);
                sdk.pendo.io.z8.b.b(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (c()) {
            this.b.add(new a(System.currentTimeMillis() / 1000, str, str3, str2));
        }
    }

    public final boolean c() {
        return this.f1478a.get();
    }

    public int d() {
        return this.c;
    }

    public final JSONArray e() {
        JSONArray jSONArray = new JSONArray();
        ListIterator<a> listIterator = this.b.listIterator();
        while (listIterator.hasNext()) {
            jSONArray.put(listIterator.next().toString());
        }
        return jSONArray;
    }

    public final void a(String str, String str2) {
        if (sdk.pendo.io.y8.a.d().i()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("level", str2);
                jSONObject.put("message", str);
                sdk.pendo.io.z8.b.b(jSONObject);
            } catch (JSONException unused) {
            }
        }
        if (c()) {
            this.b.add(new a(System.currentTimeMillis() / 1000, str, str2));
        }
    }

    public final void a() {
        this.b.clear();
    }

    public final void a(boolean z) {
        this.f1478a.getAndSet(z);
    }

    public void a(int i) {
        this.c = i;
    }
}
