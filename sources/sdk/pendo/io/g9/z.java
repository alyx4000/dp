package sdk.pendo.io.g9;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.e9.b;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f1149a = new Object();
    private static final Object b = new Object();
    private static final Object c = new Object();
    private static final Object d = new Object();
    private static final Object e = new Object();
    private static int f;
    private static sdk.pendo.io.w6.a<Boolean> g;
    private static AtomicBoolean h;
    private static sdk.pendo.io.x5.j<Long> i;
    private static sdk.pendo.io.b6.b j;
    private static sdk.pendo.io.w6.a<Boolean> k;
    private static long l;

    class a implements sdk.pendo.io.d6.e<b.c> {

        /* renamed from: sdk.pendo.io.g9.z$a$a, reason: collision with other inner class name */
        class C0148a implements sdk.pendo.io.d6.e<Long> {
            C0148a() {
            }

            @Override // sdk.pendo.io.d6.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Long l) {
                z.k();
            }
        }

        a() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(b.c cVar) {
            if (!cVar.equals(b.c.IN_BACKGROUND)) {
                if (cVar.equals(b.c.IN_FOREGROUND) && z.j == null) {
                    z.j = (sdk.pendo.io.b6.b) z.i.c((sdk.pendo.io.x5.j) sdk.pendo.io.d9.c.a(new C0148a(), "PersistenceUtils handle session duration storage observer"));
                    z.h.set(false);
                    return;
                }
                return;
            }
            z.h.set(true);
            sdk.pendo.io.b6.b bVar = z.j;
            if (bVar != null) {
                bVar.dispose();
                z.j = null;
            }
        }
    }

    class b implements sdk.pendo.io.d6.j<Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Boolean bool) {
            return bool.booleanValue();
        }
    }

    class c implements sdk.pendo.io.d6.e<Boolean> {
        c() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            z.j();
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        g = sdk.pendo.io.w6.a.b(bool);
        h = new AtomicBoolean(false);
        i = null;
        j = null;
        k = sdk.pendo.io.w6.a.b(bool);
        l = c();
    }

    public static void a() {
        l = 0L;
    }

    public static void b() {
        f(null);
        d(null);
        a((String) null, (String) null);
    }

    private static long c() {
        return c(e());
    }

    public static long d() {
        return l;
    }

    public static String e() {
        return a("pendo_app_in_background_time_analytics");
    }

    public static String f() {
        synchronized (e) {
            SharedPreferences a2 = b0.a("persisted_visitor_account");
            if (a2 == null) {
                return null;
            }
            return a2.getString("persisted_account_id", null);
        }
    }

    public static String g() {
        SharedPreferences a2 = b0.a("persisted_jwt");
        if (a2 != null) {
            return a2.getString("persisted_jwt_key", null);
        }
        return null;
    }

    public static String h() {
        SharedPreferences a2 = b0.a("persisted_jwt");
        if (a2 != null) {
            return a2.getString("persisted_jwt_signingkeyname_key", null);
        }
        return null;
    }

    public static String i() {
        synchronized (e) {
            SharedPreferences a2 = b0.a("persisted_visitor_account");
            if (a2 == null) {
                return null;
            }
            return a2.getString("persisted_visitor_id", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void j() {
        i = v.a(h, 1000L, TimeUnit.MILLISECONDS);
        sdk.pendo.io.e9.b.e().c().a(sdk.pendo.io.d9.c.a(new a(), "PersistenceUtils appflowChanges observer"));
    }

    public static void k() {
        String str;
        synchronized (c) {
            Set<String> b2 = b0.b("persisted_insert_app_session_analytics", "app_session_duration");
            HashSet<String> hashSet = new HashSet();
            if (b2 != null) {
                hashSet.addAll(b2);
                for (String str2 : hashSet) {
                    if (str2.startsWith("app_session_duration")) {
                        int parseInt = Integer.parseInt(str2.split(":")[1]);
                        hashSet.remove(str2);
                        hashSet.add("app_session_duration:" + (parseInt + 1));
                        str = "persisted_insert_app_session_analytics";
                    }
                }
            } else {
                hashSet.add("app_session_duration:0");
                str = "persisted_insert_app_session_analytics";
            }
            b0.a(str, "app_session_duration", (Set<String>) hashSet, true);
        }
    }

    public static void l() {
        m();
        n();
    }

    public static void m() {
        synchronized (b) {
            SharedPreferences a2 = b0.a("persisted_insert_dismissed_analytics");
            if (a2 != null) {
                for (Map.Entry<String, ?> entry : a2.getAll().entrySet()) {
                    String str = null;
                    String str2 = null;
                    for (String str3 : (Set) entry.getValue()) {
                        if (str3.startsWith(NotificationsChannelSerializer.GROUP_ID_KEY)) {
                            str = str3.split(":")[1];
                        } else if (str3.startsWith(IterableConstants.ITERABLE_INBOX_IMP_DISPLAY_DURATION)) {
                            str2 = str3.split(":")[1];
                        }
                    }
                    if (str != null && str2 != null) {
                        d.b(entry.getKey(), str2);
                        g(entry.getKey());
                    }
                }
            }
        }
    }

    public static void n() {
        g.a(new b()).f().a(sdk.pendo.io.d9.b.a(new c(), "PersistenceUtils persistAppSessionDuration cleared app session duration observer"));
    }

    public static void o() {
        synchronized (d) {
            b0.a("persisted_time_analytics", "analytics_app_in_background_counter");
            b0.a("persisted_time_analytics", "pendo_app_in_background_time_analytics");
            a();
        }
    }

    public static void p() {
        synchronized (f1149a) {
            for (int i2 = 0; i2 < f; i2++) {
                b0.a("persisted_insert_analytics", Integer.toString(i2));
            }
            f = 0;
        }
    }

    public static String a(String str) {
        Map<String, ?> all;
        synchronized (d) {
            String str2 = null;
            if (str == null) {
                return null;
            }
            SharedPreferences a2 = b0.a("persisted_time_analytics");
            if (a2 != null && (all = a2.getAll()) != null && all.containsKey(str)) {
                Object obj = all.get(str);
                if (obj instanceof String) {
                    str2 = (String) obj;
                }
            }
            return str2;
        }
    }

    public static String b(String str) {
        synchronized (e) {
            SharedPreferences a2 = b0.a("persisted_visitor_account");
            if (a2 == null) {
                return str;
            }
            return a2.getString("persisted_anonymous_visitor_id", str);
        }
    }

    private static long c(String str) {
        if (str == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.getLong("time") + jSONObject.getLong("duration");
        } catch (JSONException e2) {
            PendoLogger.e("PersistenceUtils getTimestampFromInterval", e2, e2.getMessage());
            return 0L;
        }
    }

    public static void d(String str) {
        synchronized (e) {
            if (str != null) {
                b0.a("persisted_visitor_account", "persisted_account_id", str, true);
            } else {
                b0.a("persisted_visitor_account", "persisted_account_id");
            }
        }
    }

    public static void e(String str) {
        synchronized (e) {
            if (str != null) {
                b0.a("persisted_visitor_account", "persisted_anonymous_visitor_id", str, true);
            }
        }
    }

    public static void f(String str) {
        synchronized (e) {
            if (str != null) {
                b0.a("persisted_visitor_account", "persisted_visitor_id", str, true);
            } else {
                b0.a("persisted_visitor_account", "persisted_visitor_id");
            }
        }
    }

    public static void g(String str) {
        synchronized (b) {
            b0.a("persisted_insert_dismissed_analytics", str);
        }
    }

    public static void a(long j2, long j3) {
        synchronized (d) {
            a(j2, j3, "pendo_app_in_background_time_analytics");
            a(j2 + j3);
            k.onNext(Boolean.TRUE);
        }
    }

    public static void a(String str, long j2) {
        synchronized (b) {
            HashSet hashSet = new HashSet();
            hashSet.add("displayDuration:" + j2);
            b0.a("persisted_insert_dismissed_analytics", str, (Set<String>) hashSet, false);
        }
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            b0.a("persisted_jwt", "persisted_jwt_key");
            b0.a("persisted_jwt", "persisted_jwt_signingkeyname_key");
        } else {
            b0.a("persisted_jwt", "persisted_jwt_key", str, true);
            b0.a("persisted_jwt", "persisted_jwt_signingkeyname_key", str2, true);
        }
    }

    public static void a(long j2, long j3, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("time", j2);
            jSONObject.put("duration", j3);
        } catch (JSONException e2) {
            PendoLogger.e("PersistenceUtils persistTimeInterval", e2, e2.getMessage());
        }
        b0.a("persisted_time_analytics", str, jSONObject.toString(), true);
    }

    private static void a(long j2) {
        l = j2;
    }

    public static void a(boolean z) {
        h.set(z);
    }
}
