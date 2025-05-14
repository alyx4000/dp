package sdk.pendo.io.c8;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.core.util.Pair;
import com.google.logging.type.LogSeverity;
import external.sdk.pendo.io.gson.Gson;
import java.util.List;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.c8.a;
import sdk.pendo.io.g9.b0;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.AnalyticsConfigurationModel;
import sdk.pendo.io.models.JWTSessionData;

/* loaded from: classes6.dex */
public class b {
    private static final Object l = new Object();
    private static volatile b m;

    /* renamed from: a, reason: collision with root package name */
    public a f961a;
    public a b;
    private sdk.pendo.io.b6.b g;
    private int i;
    private int j;
    private sdk.pendo.io.k0.f k;
    private int c = 0;
    private int d = 0;
    private boolean e = false;
    private boolean f = false;
    private int h = 10485760;

    private b() {
        h();
        i();
        this.f961a = new a("TemporaryAnalyticEventsBuffer", 5, 5, -1.0f, 0.8f, new a.d() { // from class: sdk.pendo.io.c8.b$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.c8.a.d
            public final void a(boolean z) {
                b.this.b(z);
            }
        });
        this.b = new a("MainAnalyticEventsBuffer", this.i, this.j, this.h, 0.8f, new a.d() { // from class: sdk.pendo.io.c8.b$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.c8.a.d
            public final void a(boolean z) {
                b.this.c(z);
            }
        });
    }

    private String c() {
        String str = "";
        if (this.f961a.i() > 0) {
            str = "" + this.f961a.l();
            this.f961a.b();
        }
        if (this.b.i() <= 0) {
            return str;
        }
        String str2 = str + this.b.l();
        this.b.b();
        return str2;
    }

    public static b f() {
        if (m == null) {
            synchronized (l) {
                if (m == null) {
                    m = new b();
                }
            }
        }
        return m;
    }

    private void h() {
        try {
            SharedPreferences a2 = b0.a("IMMEDIATE_EVENTS_PARAMS");
            String string = a2 != null ? a2.getString("IMMEDIATE_EVENTS_LIST", "['guideDismissed', 'guideSnoozed', 'AppSessionEnd', 'AppInBackground']") : "";
            this.k = (sdk.pendo.io.k0.f) ((string == null || string.isEmpty()) ? new Gson().a("['guideDismissed', 'guideSnoozed', 'AppSessionEnd', 'AppInBackground']", sdk.pendo.io.k0.f.class) : new Gson().a(string, sdk.pendo.io.k0.f.class));
        } catch (Exception e) {
            PendoLogger.e(e);
        }
    }

    private void i() {
        SharedPreferences a2 = b0.a("MAIN_BUFFER_PARAMS");
        if (a2 != null) {
            this.i = a2.getInt("BUFFER_TIMEOUT", 30);
            this.j = a2.getInt("BUFFER_QUEUE_SIZE", 15);
            this.h = a2.getInt("BUFFER_MAX_STORAGE", 10485760);
        } else {
            this.i = 30;
            this.j = 15;
            this.h = 10485760;
        }
    }

    private void j() {
        if (!sdk.pendo.io.g9.f.a()) {
            if (this.e) {
                d(false);
            }
            if (this.g == null) {
                this.g = sdk.pendo.io.g9.f.a((sdk.pendo.io.d6.e<Boolean>) new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.c8.b$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        b.this.a((Boolean) obj);
                    }
                });
            }
            this.b.j();
            return;
        }
        String h = this.b.h();
        if (h.isEmpty()) {
            a(true);
            return;
        }
        if (h.length() > 3) {
            h = sdk.pendo.io.g9.d.b(h);
        }
        sdk.pendo.io.p8.a.d().a(h, true, null);
    }

    private void k() {
        this.e = true;
        int i = this.d + 1;
        this.d = i;
        if (i >= 10) {
            d(false);
            return;
        }
        int i2 = this.c;
        this.c = i2 == 0 ? 30 : i2 * 2;
        if (this.f || this.c > 600) {
            this.c = LogSeverity.CRITICAL_VALUE;
        }
        this.b.a(this.c);
    }

    public void a() {
        this.f961a.d();
        this.b.d();
    }

    public void b() {
        a aVar;
        if (this.f961a.i() > 0) {
            aVar = this.f961a;
        } else {
            if (this.b.i() <= 0) {
                sdk.pendo.io.p8.c.f1504a.c(true);
                return;
            }
            aVar = this.b;
        }
        aVar.b(true);
    }

    public int d() {
        return this.i;
    }

    public int e() {
        return this.j;
    }

    public float g() {
        return this.h / 1048576.0f;
    }

    private boolean b(JSONObject jSONObject) {
        return jSONObject.optString("event").equals("pauseEmissionsEvent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(boolean z) {
        j();
    }

    private void d(boolean z) {
        this.f = !z;
        this.e = false;
        this.c = 0;
        this.d = 0;
        if (z) {
            return;
        }
        this.b.n();
    }

    public void a(boolean z) {
        sdk.pendo.io.p8.c.f1504a.c(true);
        if (!z) {
            k();
        } else {
            d(true);
            this.b.d(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(boolean z) {
        a(this.f961a, this.b, z);
    }

    public synchronized void a(List<JSONObject> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                String str = "";
                StringBuilder sb = new StringBuilder();
                boolean z = false;
                boolean z2 = false;
                for (JSONObject jSONObject : list) {
                    if (jSONObject != null) {
                        if (b(jSONObject)) {
                            z = true;
                        } else {
                            String jSONObject2 = jSONObject.toString();
                            PendoLogger.i("AnalyticEventsManager-> handle analytic event: " + jSONObject2, new Object[0]);
                            sb.append("}|{");
                            sb.append(jSONObject2);
                            if (!z2 || !str.equals("previous_visitor_end_session_analytics")) {
                                Pair<Boolean, String> a2 = a(jSONObject);
                                if (a2.first.booleanValue() && !z2) {
                                    z2 = true;
                                }
                                if (str.isEmpty() && a2.second.equals("previous_visitor_end_session_analytics")) {
                                    str = "previous_visitor_end_session_analytics";
                                }
                            }
                        }
                    }
                }
                if (z) {
                    PendoInternal.o().onNext(Boolean.TRUE);
                }
                if (z2 && str.equals("previous_visitor_end_session_analytics")) {
                    if (!TextUtils.isEmpty(PendoInternal.t())) {
                        b(sb.toString());
                        return;
                    }
                    PendoInternal.d();
                }
                this.f961a.b(sb.toString(), list.size(), z2);
            }
        }
    }

    private void b(String str) {
        if (PendoInternal.u() == null) {
            return;
        }
        String str2 = c() + str;
        if (str2.isEmpty()) {
            return;
        }
        if (str2.length() > 3) {
            str2 = sdk.pendo.io.g9.d.b(str2);
        }
        JWTSessionData copy = PendoInternal.u().copy();
        PendoInternal.d();
        sdk.pendo.io.p8.a.d().a(copy, str2, true, (String) null);
    }

    public Pair<Boolean, String> a(JSONObject jSONObject) {
        boolean z = false;
        String str = "";
        if (this.k != null) {
            boolean z2 = false;
            for (int i = 0; i < this.k.size(); i++) {
                try {
                    String g = this.k.a(i).g();
                    if (a(g, jSONObject)) {
                        z2 = true;
                    }
                    if (a(g)) {
                        str = "previous_visitor_end_session_analytics";
                    }
                } catch (Exception e) {
                    PendoLogger.d("AnalyticEventsManager isShouldFlush " + e.getMessage(), new Object[0]);
                }
            }
            z = z2;
        }
        return new Pair<>(Boolean.valueOf(z), str);
    }

    private boolean a(String str) {
        return str.equals(c.APP_SESSION_END.b());
    }

    public void b(AnalyticsConfigurationModel analyticsConfigurationModel) {
        synchronized (l) {
            if (a(analyticsConfigurationModel.getBufferDuration(), analyticsConfigurationModel.getBufferQueueSize(), analyticsConfigurationModel.getMaxStoragesizeMB())) {
                this.b.a(this.i, this.j, this.h);
            }
        }
    }

    private boolean a(String str, JSONObject jSONObject) {
        return str.equals(jSONObject.optString("event")) || str.equals(jSONObject.optString("type"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        sdk.pendo.io.b6.b bVar = this.g;
        if (bVar != null) {
            bVar.dispose();
            this.g = null;
        }
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(0L);
        }
    }

    private void a(a aVar, a aVar2, boolean z) {
        aVar2.b(aVar.h(), aVar.g(), z);
        aVar.d(false);
    }

    public synchronized void a(AnalyticsConfigurationModel analyticsConfigurationModel) {
        if (analyticsConfigurationModel != null) {
            sdk.pendo.io.k0.f immediateEventsArray = analyticsConfigurationModel.getImmediateEventsArray();
            if (immediateEventsArray != null && !immediateEventsArray.toString().equals(this.k.toString())) {
                this.k = immediateEventsArray;
                b0.a("IMMEDIATE_EVENTS_PARAMS", "IMMEDIATE_EVENTS_LIST", immediateEventsArray.toString(), true);
            }
        }
    }

    private boolean a(int i, int i2, float f) {
        boolean z;
        if (i > 300) {
            i = 300;
        }
        if (i2 > 1000) {
            i2 = 1000;
        }
        if (f > 100.0f) {
            f = 100.0f;
        }
        if (i <= 0 || this.i == i) {
            z = false;
        } else {
            this.i = i;
            b0.a("MAIN_BUFFER_PARAMS", "BUFFER_TIMEOUT", i);
            z = true;
        }
        if (i2 > 0 && this.j != i2) {
            this.j = i2;
            b0.a("MAIN_BUFFER_PARAMS", "BUFFER_QUEUE_SIZE", i2);
            z = true;
        }
        if (f <= 0.0f || this.h == ((int) f) * 1048576) {
            return z;
        }
        int i3 = (int) (f * 1048576.0f);
        this.h = i3;
        b0.a("MAIN_BUFFER_PARAMS", "BUFFER_MAX_STORAGE", i3);
        return true;
    }
}
