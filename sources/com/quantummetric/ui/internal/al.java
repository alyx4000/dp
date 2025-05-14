package com.quantummetric.ui.internal;

import com.quantummetric.ui.QuantumMetric;
import com.socure.docv.capturesdk.api.Keys;
import io.sentry.protocol.App;
import java.lang.Thread;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
final class al implements Thread.UncaughtExceptionHandler {
    private static al t;

    /* renamed from: a, reason: collision with root package name */
    Thread.UncaughtExceptionHandler f51a;
    a b;
    boolean e;
    boolean f;
    List<String> h;
    o<String> i;
    boolean j;
    private boolean s;
    boolean c = true;
    boolean d = true;
    int g = 30;
    private final String k = "user_id";
    private final String l = Keys.KEY_SESSION_ID;
    private final String m = "qm_version";
    private final String n = App.JsonKeys.APP_VERSION;
    private final String o = "QM";
    private final String p = "offline";
    private final String q = "trace";
    private final String r = "desc";

    static class a {

        /* renamed from: a, reason: collision with root package name */
        String f52a;
        String b;
        String c;
        String d;
        boolean e;
        boolean f;

        a() {
        }
    }

    class b<T> implements o<T> {
        b() {
        }

        @Override // com.quantummetric.ui.internal.o
        public final void a(T t) {
            al.a(al.this);
        }
    }

    private al() {
        try {
            JSONObject jSONObject = new JSONObject();
            if (QuantumMetric.b != null) {
                bu buVar = QuantumMetric.b;
                bu buVar2 = buVar;
                String g = de.g(aa.b(buVar.d));
                if (!de.b(g)) {
                    jSONObject = new JSONObject(g);
                }
            }
            a aVar = new a();
            aVar.f52a = jSONObject.optString("user_id");
            aVar.b = jSONObject.optString(Keys.KEY_SESSION_ID);
            aVar.c = jSONObject.optString("qm_version");
            aVar.d = jSONObject.optString(App.JsonKeys.APP_VERSION);
            aVar.e = jSONObject.optBoolean("QM");
            aVar.f = jSONObject.optBoolean("offline");
            this.b = aVar;
        } catch (Exception unused) {
        }
    }

    static al a() {
        if (t == null) {
            t = new al();
        }
        return t;
    }

    static /* synthetic */ boolean a(al alVar) {
        alVar.s = true;
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:7|(13:9|(3:12|(2:14|15)(1:16)|10)|17|18|(1:20)|21|22|23|(1:25)|26|(1:28)|30|(4:(4:35|(1:37)(1:38)|32|33)|42|39|40))(0)|53|(0)|21|22|23|(0)|26|(0)|30|(0)) */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006e A[Catch: all -> 0x0124, TryCatch #1 {all -> 0x0124, blocks: (B:3:0x0003, B:5:0x0007, B:7:0x000f, B:9:0x0050, B:10:0x0056, B:12:0x005c, B:20:0x006e, B:21:0x0081, B:23:0x00a5, B:25:0x00e6, B:26:0x00eb, B:28:0x00f1, B:30:0x00f8), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e6 A[Catch: Exception -> 0x00f8, all -> 0x0124, TryCatch #1 {all -> 0x0124, blocks: (B:3:0x0003, B:5:0x0007, B:7:0x000f, B:9:0x0050, B:10:0x0056, B:12:0x005c, B:20:0x006e, B:21:0x0081, B:23:0x00a5, B:25:0x00e6, B:26:0x00eb, B:28:0x00f1, B:30:0x00f8), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f1 A[Catch: Exception -> 0x00f8, all -> 0x0124, TRY_LEAVE, TryCatch #1 {all -> 0x0124, blocks: (B:3:0x0003, B:5:0x0007, B:7:0x000f, B:9:0x0050, B:10:0x0056, B:12:0x005c, B:20:0x006e, B:21:0x0081, B:23:0x00a5, B:25:0x00e6, B:26:0x00eb, B:28:0x00f1, B:30:0x00f8), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fc A[EXC_TOP_SPLITTER, LOOP:1: B:32:0x00fc->B:37:0x0106, LOOP_START, PHI: r1
  0x00fc: PHI (r1v3 int) = (r1v0 int), (r1v7 int) binds: [B:31:0x00fa, B:37:0x0106] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void uncaughtException(java.lang.Thread r11, java.lang.Throwable r12) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.quantummetric.ui.internal.al.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
    }
}
