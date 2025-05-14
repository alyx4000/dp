package sdk.pendo.io.c8;

import org.json.JSONObject;
import sdk.pendo.io.c8.h;

/* loaded from: classes6.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final transient sdk.pendo.io.w6.b<a> f966a;
    private final d b;
    private JSONObject c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f967a;
        private final JSONObject b;
        private final long c = System.currentTimeMillis();
        private final String d;

        public a(String str, JSONObject jSONObject, String str2) {
            this.f967a = str;
            this.b = jSONObject;
            this.d = str2;
        }

        protected String a() {
            return this.d;
        }

        protected String b() {
            return this.f967a;
        }

        public JSONObject c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }
    }

    protected h() {
        sdk.pendo.io.w6.b<a> n = sdk.pendo.io.w6.b.n();
        this.f966a = n;
        this.b = null;
        this.c = null;
        n.a(sdk.pendo.io.d9.c.a(a(true), "Tracker trackerInfoPublisher none observer"));
    }

    public void a(String str, JSONObject jSONObject, String str2) {
        a(new a(str, jSONObject, str2));
    }

    public d b() {
        return this.b;
    }

    protected h(JSONObject jSONObject) {
        sdk.pendo.io.w6.b<a> n = sdk.pendo.io.w6.b.n();
        this.f966a = n;
        this.b = null;
        this.c = jSONObject;
        n.a(sdk.pendo.io.d9.c.a(a(false), "Tracker trackerInfoPublisher json analytics data observer"));
    }

    public JSONObject a() {
        return this.c;
    }

    protected h(d dVar) {
        sdk.pendo.io.w6.b<a> n = sdk.pendo.io.w6.b.n();
        this.f966a = n;
        this.b = dVar;
        this.c = null;
        if (dVar != null) {
            dVar.d().setTracker(this);
        }
        n.a(sdk.pendo.io.d9.c.a(a(true), "Tracker trackerInfoPublisher GenericPendoAnalyticsData observer"));
    }

    protected sdk.pendo.io.d6.e<a> a(final boolean z) {
        return new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.c8.h$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                h.this.a(z, (h.a) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, a aVar) {
        f.e().a(z ? new g(this.b, aVar) : new g(this.c, aVar));
    }

    public void a(a aVar) {
        this.f966a.onNext(aVar);
    }

    public void a(JSONObject jSONObject) {
        this.c = jSONObject;
    }
}
