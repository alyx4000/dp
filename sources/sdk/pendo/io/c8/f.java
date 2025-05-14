package sdk.pendo.io.c8;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.d6.j;
import sdk.pendo.io.e9.b;
import sdk.pendo.io.g9.z;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.x5.o;

/* loaded from: classes6.dex */
public final class f {
    private static volatile f g;

    /* renamed from: a, reason: collision with root package name */
    private final sdk.pendo.io.d6.e<List<JSONObject>> f964a = new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.c8.f$$ExternalSyntheticLambda4
        @Override // sdk.pendo.io.d6.e
        public final void accept(Object obj) {
            f.a((List) obj);
        }
    };
    private volatile sdk.pendo.io.w6.b<JSONObject> b = sdk.pendo.io.w6.b.n();
    private sdk.pendo.io.w6.b<Boolean> c = sdk.pendo.io.w6.b.n();
    private volatile boolean d = false;
    private volatile boolean e = false;
    private static AtomicBoolean f = new AtomicBoolean(false);
    private static final Object h = new Object();
    private static boolean i = false;
    private static JSONObject j = null;

    class a implements j<Long> {
        private int f = 0;

        a() {
        }

        @Override // sdk.pendo.io.d6.j
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean test(Long l) {
            if (f.this.e) {
                this.f = 0;
                f.this.e = false;
            }
            this.f++;
            synchronized (f.h) {
                if (this.f != 1) {
                    return false;
                }
                this.f = 0;
                f.this.d = true;
                return true;
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements j<T> {
        private int f = 0;

        b() {
        }

        @Override // sdk.pendo.io.d6.j
        public boolean test(T t) {
            if (f.this.d) {
                this.f = 0;
                f.this.d = false;
            }
            this.f++;
            synchronized (f.h) {
                if (this.f != 3) {
                    return false;
                }
                this.f = 0;
                f.this.e = true;
                return true;
            }
        }
    }

    private f() {
        synchronized (h) {
            g();
        }
    }

    private sdk.pendo.io.x5.j b() {
        return sdk.pendo.io.e9.b.e().c().a(new j() { // from class: sdk.pendo.io.c8.f$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean a2;
                a2 = f.a((b.c) obj);
                return a2;
            }
        });
    }

    public static synchronized f e() {
        f fVar;
        synchronized (f.class) {
            if (g == null) {
                synchronized (h) {
                    if (g == null) {
                        g = new f();
                    }
                }
            }
            fVar = g;
        }
        return fVar;
    }

    public static h f() {
        return new h();
    }

    private void g() {
        synchronized (h) {
            this.b.a(sdk.pendo.io.v6.a.c()).a(new j() { // from class: sdk.pendo.io.c8.f$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean d;
                    d = f.d((JSONObject) obj);
                    return d;
                }
            }).c(a()).a(a(this.b)).a(sdk.pendo.io.v6.a.c()).a(new j() { // from class: sdk.pendo.io.c8.f$$ExternalSyntheticLambda2
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean b2;
                    b2 = f.b((List) obj);
                    return b2;
                }
            }).a(this.f964a, new sdk.pendo.io.a9.a("PendoAnalytics analytics events consumer error consumer"));
        }
    }

    private sdk.pendo.io.x5.j h() {
        return sdk.pendo.io.x5.j.d(1L, TimeUnit.SECONDS).a(new a());
    }

    void a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                if (!b(jSONObject) && jSONObject2 != null) {
                    JSONObject jSONObject3 = jSONObject.has("properties") ? (JSONObject) jSONObject.get("properties") : null;
                    if (jSONObject3 == null) {
                        jSONObject.put("properties", jSONObject2);
                        return;
                    }
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject3.put(next, jSONObject2.get(next));
                    }
                }
            } catch (JSONException e) {
                PendoLogger.e("Failed to addGlobalEventPropertiesIfNeeded, exception: " + e, new Object[0]);
            }
        }
    }

    public void c() {
        this.c.onNext(Boolean.TRUE);
    }

    public synchronized sdk.pendo.io.w6.b<JSONObject> d() {
        return this.b;
    }

    private boolean b(JSONObject jSONObject) {
        return jSONObject != null && c.APP_SESSION_END.b().equals(jSONObject.optString("event"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ JSONObject c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            f(jSONObject2);
            a(jSONObject2);
            a(jSONObject2, sdk.pendo.io.e9.a.f1035a.a().getPropertiesJson());
            return jSONObject2;
        } catch (JSONException e) {
            PendoLogger.e("Failed to adjustAnalyticEventDataIfNeeded, exception: " + e, new Object[0]);
            return jSONObject;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean d(JSONObject jSONObject) {
        if (sdk.pendo.io.y8.a.d().i()) {
            if (jSONObject != null && jSONObject != j) {
                sdk.pendo.io.z8.b.a(jSONObject);
            }
            j = jSONObject;
        }
        return !f.get();
    }

    public static h e(JSONObject jSONObject) {
        return new h(jSONObject);
    }

    void a(JSONObject jSONObject) {
        try {
            String i2 = z.i();
            String f2 = z.f();
            String D = PendoInternal.D();
            String k = PendoInternal.k();
            if (!jSONObject.has("visitorId") && !jSONObject.has("visitor_id")) {
                if (D != null) {
                    jSONObject.put("visitorId", D);
                } else if (i2 != null) {
                    jSONObject.put("visitorId", i2);
                }
            }
            if (jSONObject.has("accountId") || jSONObject.has("account_id")) {
                return;
            }
            if (k != null) {
                jSONObject.put("accountId", k);
            } else if (f2 != null) {
                jSONObject.put("accountId", f2);
            }
        } catch (JSONException e) {
            PendoLogger.e("Failed to addVisitorAndAccountDataIfNeeded, exception: " + e, new Object[0]);
        }
    }

    void f(JSONObject jSONObject) {
        try {
            if (b(jSONObject)) {
                z.o();
            }
        } catch (Exception e) {
            PendoLogger.e("Failed to removeAppSessionEndIntervalAnalyticsIfNeeded, exception: " + e, new Object[0]);
        }
    }

    private sdk.pendo.io.d6.h<JSONObject, JSONObject> a() {
        return new sdk.pendo.io.d6.h() { // from class: sdk.pendo.io.c8.f$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.d6.h
            public final Object apply(Object obj) {
                JSONObject c;
                c = f.this.c((JSONObject) obj);
                return c;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean b(List list) {
        return !list.isEmpty();
    }

    private sdk.pendo.io.x5.j<?> a(sdk.pendo.io.x5.j<?> jVar) {
        return sdk.pendo.io.x5.j.a(h(), b(jVar), b(), this.c);
    }

    private <T> sdk.pendo.io.x5.j<T> b(sdk.pendo.io.x5.j<T> jVar) {
        return jVar.a((j) new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(b.c cVar) {
        boolean equals = cVar.equals(b.c.IN_BACKGROUND);
        i = equals;
        return equals;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list) {
        try {
            sdk.pendo.io.c8.b.f().a((List<JSONObject>) list);
        } catch (Exception e) {
            PendoLogger.e(e, e.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(g gVar) {
        JSONObject a2 = gVar.a();
        if (a2 != null) {
            this.b.onNext(a2);
        }
    }

    public d a(GuideModel guideModel) {
        return new d(guideModel);
    }

    public static h a(d dVar) {
        return new h(dVar);
    }

    public synchronized void a(boolean z) {
        f.set(z);
    }

    public void a(g... gVarArr) {
        sdk.pendo.io.x5.j.a((Object[]) gVarArr).a((o) sdk.pendo.io.d9.c.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.c8.f$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                f.this.a((g) obj);
            }
        }, "PendoAnalytics analytics data publisher bulk observer"));
    }
}
