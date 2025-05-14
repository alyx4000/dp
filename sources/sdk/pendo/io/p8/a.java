package sdk.pendo.io.p8;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import external.sdk.pendo.io.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.g9.e0;
import sdk.pendo.io.g9.i0;
import sdk.pendo.io.g9.y;
import sdk.pendo.io.k8.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.models.InitModelImporter;
import sdk.pendo.io.models.JWTSessionData;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.models.networkReponses.RegisterDeviceResponse;
import sdk.pendo.io.network.interfaces.AnalyticsData;
import sdk.pendo.io.network.interfaces.ErrorData;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.network.interfaces.Init;
import sdk.pendo.io.network.interfaces.RegisterDevice;
import sdk.pendo.io.network.interfaces.SetupProcess;
import sdk.pendo.io.network.interfaces.a;
import sdk.pendo.io.network.responses.converters.gson.PendoGsonRequestBodyConverter;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.p8.a;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.w2.c0;
import sdk.pendo.io.x5.j;
import sdk.pendo.io.x5.m;
import sdk.pendo.io.x5.n;
import sdk.pendo.io.y6.r;
import sdk.pendo.io.y6.s;

/* loaded from: classes6.dex */
public final class a {
    private static int f = 0;
    private static boolean g = false;
    private static final AtomicBoolean h = new AtomicBoolean(true);
    private static volatile a i;

    /* renamed from: a, reason: collision with root package name */
    private int f1503a = 0;
    private volatile AtomicBoolean b = new AtomicBoolean(true);
    private volatile AtomicBoolean c = new AtomicBoolean(false);
    private List<sdk.pendo.io.p8.b> d = new ArrayList();
    private sdk.pendo.io.b6.b e;

    /* renamed from: sdk.pendo.io.p8.a$a, reason: collision with other inner class name */
    class C0227a implements sdk.pendo.io.d6.e<Boolean> {
        C0227a() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            if (sdk.pendo.io.z8.b.c() != null) {
                PendoLogger.d("session token is not null, ", new Object[0]);
                sdk.pendo.io.z8.b.a(true, true);
            } else {
                a.this.e(false);
            }
            a.this.e.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b extends sdk.pendo.io.s8.a {
        private final JSONObject f;

        b(JSONObject jSONObject) {
            this.f = jSONObject;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            c0 a2 = sdk.pendo.io.g9.a.f1122a.a(this.f.toString());
            s d = sdk.pendo.io.network.interfaces.a.d();
            if (d == null) {
                PendoLogger.w("Cannot create retrofit.", new Object[0]);
                return;
            }
            r b = a.this.b(((SetupProcess) d.a(SetupProcess.class)).sendDebugData(a2));
            if (b.d()) {
                PendoLogger.i("Sent, status code: " + b.b(), new Object[0]);
                return;
            }
            if (b.b() == 451) {
                sdk.pendo.io.t8.a.a(b.c());
            } else if (b.b() != 401) {
                PendoLogger.d("Failed to send: status code = " + b.b() + " error: " + b, new Object[0]);
            } else if (a.this.b()) {
                a.this.a(this.f);
            }
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            try {
                sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.p8.a$b$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        a.b.this.a((GetAuthToken.GetAuthTokenResponse) obj);
                    }
                }, "BackendApiManager DebugDataResultAction access token observer"));
            } catch (Exception e) {
                PendoLogger.w(e, "Exception in executing DebugDataResultAction with: %s", this.f.toString());
            }
        }
    }

    protected class c extends sdk.pendo.io.s8.a {
        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Boolean bool) {
            a.EnumC0213a enumC0213a;
            if (a.this.c()) {
                PendoLogger.v("Execute init from backend successful", new Object[0]);
                enumC0213a = a.EnumC0213a.SUCCESS;
            } else {
                PendoLogger.v("Execute init from backend failed", new Object[0]);
                enumC0213a = a.EnumC0213a.FAILED;
            }
            sdk.pendo.io.network.interfaces.a.a(enumC0213a);
        }

        @Override // sdk.pendo.io.s8.a
        public void execute() {
            try {
                if (!PendoInternal.K()) {
                    a.this.b();
                } else if (a.this.b()) {
                    sdk.pendo.io.p8.c cVar = sdk.pendo.io.p8.c.f1504a;
                    j.a(cVar.a().a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.p8.a$c$$ExternalSyntheticLambda0
                        @Override // sdk.pendo.io.d6.j
                        public final boolean test(Object obj) {
                            boolean booleanValue;
                            booleanValue = ((Boolean) obj).booleanValue();
                            return booleanValue;
                        }
                    }), cVar.b().a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.p8.a$c$$ExternalSyntheticLambda1
                        @Override // sdk.pendo.io.d6.j
                        public final boolean test(Object obj) {
                            boolean booleanValue;
                            booleanValue = ((Boolean) obj).booleanValue();
                            return booleanValue;
                        }
                    }), cVar.c().a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.p8.a$c$$ExternalSyntheticLambda2
                        @Override // sdk.pendo.io.d6.j
                        public final boolean test(Object obj) {
                            boolean booleanValue;
                            booleanValue = ((Boolean) obj).booleanValue();
                            return booleanValue;
                        }
                    }), new sdk.pendo.io.d6.f() { // from class: sdk.pendo.io.p8.a$c$$ExternalSyntheticLambda3
                        @Override // sdk.pendo.io.d6.f
                        public final Object a(Object obj, Object obj2, Object obj3) {
                            Boolean a2;
                            a2 = a.c.a((Boolean) obj, (Boolean) obj2, (Boolean) obj3);
                            return a2;
                        }
                    }).f().a(sdk.pendo.io.v6.a.b()).a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.p8.a$c$$ExternalSyntheticLambda4
                        @Override // sdk.pendo.io.d6.e
                        public final void accept(Object obj) {
                            a.c.this.d((Boolean) obj);
                        }
                    }, "BackendApiManager FullBackendInitAction account data sent, user data sent, finished init actions, pending analytics sent observer"));
                }
            } catch (Exception e) {
                PendoLogger.w(e, "Exception in executing FullBackendInitAction: ", new Object[0]);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean a(Boolean bool, Boolean bool2, Boolean bool3) {
            return Boolean.valueOf(bool.booleanValue() && bool2.booleanValue() && bool3.booleanValue());
        }
    }

    protected class d extends sdk.pendo.io.s8.a {
        protected d() {
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            a.this.b();
        }
    }

    public class e extends sdk.pendo.io.s8.a {
        private String A;
        private String f;
        private boolean s;

        e(String str, boolean z, String str2) {
            this.f = str;
            this.s = z;
            this.A = str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            a.this.a(this.f, false, this.A);
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            try {
                String str = this.f;
                if (str == null || str.isEmpty()) {
                    return;
                }
                s d = sdk.pendo.io.network.interfaces.a.d();
                if (d == null) {
                    PendoLogger.e("Analytics retrofit instantiation failed at SendAnalyticsAction", new Object[0]);
                    sdk.pendo.io.c8.b.f().a(false);
                    return;
                }
                if (TextUtils.isEmpty(this.A)) {
                    this.A = "v2/devices/analyticsData";
                }
                if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b())) {
                    PendoLogger.d("accessToken is empty!", new Object[0]);
                    sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.p8.a$e$$ExternalSyntheticLambda0
                        @Override // sdk.pendo.io.d6.e
                        public final void accept(Object obj) {
                            a.e.this.a((GetAuthToken.GetAuthTokenResponse) obj);
                        }
                    }, "BackendApiManager SendAnalyticsAction access token observer"));
                    return;
                }
                AnalyticsData analyticsData = (AnalyticsData) d.a(AnalyticsData.class);
                sdk.pendo.io.g9.a aVar = sdk.pendo.io.g9.a.f1122a;
                r b = a.this.b(analyticsData.send(this.A, aVar.a("[" + this.f + "]")));
                if (b.d()) {
                    sdk.pendo.io.c8.b.f().a(true);
                    return;
                }
                PendoLogger.d("Failed sending analytics: code = '" + b.b() + "' error: '" + b.c() + "'.", new Object[0]);
                if (b.b() == 451) {
                    if (sdk.pendo.io.t8.a.a(b.c())) {
                        return;
                    } else {
                        PendoLogger.d("Received invalid KillSwitch response. Moving to backoff.. ", new Object[0]);
                    }
                } else if (b.b() == 500) {
                    PendoLogger.d("POST Setup response is not successful (500), Moving to backoff.. ", new Object[0]);
                } else if (this.s && (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b()) || b.b() == 401)) {
                    String str2 = "";
                    try {
                        str2 = JsonWebTokenValidator.INSTANCE.validate(aVar.a(b.c()));
                        if (a.this.b()) {
                            a.this.a(this.f, false, this.A);
                            return;
                        }
                        return;
                    } catch (external.sdk.pendo.io.jose4j.jwt.consumer.c e) {
                        sdk.pendo.io.g9.d.a(str2, "Analytics", e.getMessage());
                        return;
                    } catch (IOException e2) {
                        PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
                        return;
                    }
                }
                sdk.pendo.io.c8.b.f().a(false);
            } catch (Exception e3) {
                PendoLogger.w(e3, "Exception in executing SendAnalyticsAction", new Object[0]);
            }
        }
    }

    public class f extends sdk.pendo.io.s8.a {
        private final JWTSessionData A;
        private final String f;
        private String f0;
        private final boolean s;

        f(JWTSessionData jWTSessionData, String str, boolean z, String str2) {
            this.f = str;
            this.s = z;
            this.f0 = str2;
            this.A = jWTSessionData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            a.this.a(this.A, this.f, false, this.f0);
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            try {
                if (TextUtils.isEmpty(this.f)) {
                    return;
                }
                s d = sdk.pendo.io.network.interfaces.a.d();
                if (d == null) {
                    PendoLogger.e("Analytics retrofit instantiation failed at SendAnalyticsForPreviousVisitorAction", new Object[0]);
                    return;
                }
                if (TextUtils.isEmpty(this.f0)) {
                    this.f0 = "v2/devices/analyticsData";
                }
                if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b())) {
                    PendoLogger.d("accessToken is empty!", new Object[0]);
                    sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.p8.a$f$$ExternalSyntheticLambda0
                        @Override // sdk.pendo.io.d6.e
                        public final void accept(Object obj) {
                            a.f.this.a((GetAuthToken.GetAuthTokenResponse) obj);
                        }
                    }, "SendAnalyticsForPreviousVisitorAction BackendApiManager access token observer"));
                    return;
                }
                AnalyticsData analyticsData = (AnalyticsData) d.a(AnalyticsData.class);
                sdk.pendo.io.g9.a aVar = sdk.pendo.io.g9.a.f1122a;
                r b = a.this.b(analyticsData.send(this.f0, aVar.a("[" + this.f + "]"), this.A.getJwt(), this.A.getSigningKeyName()));
                if (b.d()) {
                    return;
                }
                PendoLogger.d("SendAnalyticsForPreviousVisitorAction Failed sending analytics: code = '" + b.b() + "' error: '" + b.c() + "'.", new Object[0]);
                if (b.b() == 451) {
                    if (sdk.pendo.io.t8.a.a(b.c())) {
                        return;
                    }
                    PendoLogger.d("SendAnalyticsForPreviousVisitorAction Received invalid KillSwitch response.", new Object[0]);
                    return;
                }
                if (this.s) {
                    if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b()) || b.b() == 401) {
                        String str = "";
                        try {
                            try {
                                str = JsonWebTokenValidator.INSTANCE.validate(aVar.a(b.c()));
                                if (a.this.b()) {
                                    a.this.a(this.A, this.f, false, this.f0);
                                }
                            } catch (IOException e) {
                                PendoLogger.e("SendAnalyticsForPreviousVisitorAction", e, e.getMessage());
                            }
                        } catch (external.sdk.pendo.io.jose4j.jwt.consumer.c e2) {
                            sdk.pendo.io.g9.d.a(str, "Analytics", e2.getMessage());
                        }
                    }
                }
            } catch (Exception e3) {
                PendoLogger.w(e3, "Exception in executing SendAnalyticsAction", new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class g extends sdk.pendo.io.s8.a {
        private String f;

        g(String str) {
            this.f = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            a.this.a(this.f);
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            if (TextUtils.isEmpty(sdk.pendo.io.network.interfaces.a.b())) {
                sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.p8.a$g$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        a.g.this.a((GetAuthToken.GetAuthTokenResponse) obj);
                    }
                }, "BackendApiManager SendErrorReportAction access token observer"));
            } else {
                a.this.a(this.f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class h extends sdk.pendo.io.s8.a {
        private final boolean A;
        private final c0 f;
        private SessionData f0;
        private final boolean s;

        h(SessionData sessionData, c0 c0Var, boolean z, boolean z2) {
            this.f = c0Var;
            this.s = z;
            this.A = z2;
            this.f0 = sessionData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
            s.b q = sdk.pendo.io.network.interfaces.a.q();
            if (q == null) {
                PendoLogger.w("Cannot create a retrofit builder.", new Object[0]);
                return;
            }
            r b = a.this.b(((SetupProcess) q.a().a(SetupProcess.class)).send(this.f));
            if (b.d()) {
                PendoLogger.i("BE setup has been sent and finished - status code: " + b.b(), new Object[0]);
                if (this.s) {
                    sdk.pendo.io.p8.c.f1504a.a(true);
                }
                if (this.A) {
                    sdk.pendo.io.p8.c.f1504a.b(true);
                }
                a();
                PendoInternal.c(true);
                ActivationManager.INSTANCE.setIsInitedObservable(true);
                return;
            }
            if (b.b() == 451) {
                if (sdk.pendo.io.t8.a.a(b.c())) {
                    return;
                }
                PendoLogger.d("Received invalid KillSwitch response. Will carry on.. ", new Object[0]);
                a.this.h();
                return;
            }
            if (b.b() == 401) {
                if (a.this.b()) {
                    a.this.a(this.f0, this.f, this.s, this.A);
                }
            } else if (b.b() == 403) {
                PendoLogger.d("Start session failure. Confirm the signing key name passed is the name of the key used to sign the token.", new Object[0]);
                PendoInternal.g();
            } else {
                if (b.b() == 406) {
                    PendoLogger.d("Updating session info failed. JWT verification failed. Confirm the signing key name passed is the name of the key used to sign the token.\nThe session will continue without changes to the visitor or account data", new Object[0]);
                    return;
                }
                PendoLogger.d("POST Setup response is not successful (network error), will proceed to init, nonetheless..", new Object[0]);
                a.this.h();
                PendoLogger.d("Failed to send: status code = " + b.b() + " error: " + b, new Object[0]);
            }
        }

        @Override // sdk.pendo.io.s8.a
        protected void execute() {
            try {
                sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.p8.a$h$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        a.h.this.a((GetAuthToken.GetAuthTokenResponse) obj);
                    }
                }, "BackendApiManager SendSetupResultAction access token observer"));
            } catch (Exception e) {
                PendoLogger.w(e, "Exception in executing SendSetupResultAction", new Object[0]);
            }
        }

        private void a() {
            if (PendoInternal.L()) {
                boolean equals = PendoInternal.D().equals("");
                boolean equals2 = PendoInternal.D().equals(this.f0.getVisitorId());
                boolean equals3 = PendoInternal.k().equals(this.f0.getAccountId());
                if (this.A && (equals || equals2)) {
                    PendoInternal.f(this.f0);
                }
                if (this.s) {
                    if (equals || equals3) {
                        PendoInternal.e(this.f0);
                    }
                }
            }
        }
    }

    private a() {
        PendoLogger.d("CTOR backendapimanager", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> r<T> b(j<r<T>> jVar) {
        return jVar.d(new sdk.pendo.io.d6.h() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.h
            public final Object apply(Object obj) {
                r a2;
                a2 = a.a((Throwable) obj);
                return a2;
            }
        }).b(sdk.pendo.io.v6.a.b()).b();
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            if (i == null) {
                i = new a();
            }
            aVar = i;
        }
        return aVar;
    }

    private <T> n<r<T>, r<T>> e() {
        return new n() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda6
            @Override // sdk.pendo.io.x5.n
            public final m a(j jVar) {
                m c2;
                c2 = a.c(jVar);
                return c2;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        sdk.pendo.io.p8.c cVar = sdk.pendo.io.p8.c.f1504a;
        cVar.a(true);
        cVar.b(true);
    }

    private void j() {
        if (h.getAndSet(false)) {
            e0.a(new c());
        } else {
            PendoLogger.d("Test - Tried to init again.", new Object[0]);
        }
    }

    public void a(sdk.pendo.io.p8.b bVar) {
        this.d.add(bVar);
    }

    protected boolean c() {
        PendoLogger.i("Initializing SDK against the backend.", new Object[0]);
        try {
            s n = sdk.pendo.io.network.interfaces.a.n();
            if (n == null) {
                return false;
            }
            Init init = (Init) n.a(Init.class);
            if (init != null) {
                return b(a(init.initSdk(f)));
            }
            return false;
        } catch (Exception e2) {
            PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
            return false;
        }
    }

    public boolean f() {
        return this.b.get();
    }

    public void i() {
        e0.a(new d());
    }

    private boolean c(r<GetAuthToken.GetAuthTokenResponse> rVar) {
        try {
            GetAuthToken.GetAuthTokenResponse getAuthTokenResponse = (GetAuthToken.GetAuthTokenResponse) new Gson().a(JsonWebTokenValidator.INSTANCE.validate(sdk.pendo.io.g9.a.f1122a.a(rVar.c())), GetAuthToken.GetAuthTokenResponse.class);
            if (getAuthTokenResponse == null) {
                PendoLogger.w("BackendAPIManagerError redirecting, redirectionToken is null", new Object[0]);
                return false;
            }
            if (getAuthTokenResponse.getRedirectionDatacenter() != null) {
                y.a(getAuthTokenResponse.getRedirectionDatacenter(), true);
            } else if (getAuthTokenResponse.getRedirectionHost() != null) {
                y.b(getAuthTokenResponse.getRedirectionHost(), true);
            } else {
                PendoLogger.w("BackendAPIManagerhandleRedirection, Error redirecting, both datacenter and host are null", new Object[0]);
            }
            sdk.pendo.io.network.interfaces.a.a();
            sdk.pendo.io.network.interfaces.a.a(Boolean.TRUE);
            sdk.pendo.io.network.interfaces.a.a(getAuthTokenResponse.getRedirectionKey());
            return true;
        } catch (Exception e2) {
            PendoLogger.e(e2, "BackendAPIManagerError redirecting, " + e2.getMessage(), new Object[0]);
            return false;
        }
    }

    private boolean d(r<RegisterDeviceResponse> rVar) {
        boolean d2 = rVar.d();
        if (d2) {
            PendoLogger.d("Registered the device, got id: " + rVar.a().getId(), new Object[0]);
            b(true);
            return b();
        }
        if (rVar.b() == 451) {
            d2 = sdk.pendo.io.t8.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda7
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    boolean a2;
                    a2 = a.this.a();
                    return a2;
                }
            });
        }
        if (!d2) {
            a(false);
            b(false);
        }
        return d2;
    }

    protected <T> r<T> a(j<r<T>> jVar) {
        return (r) jVar.a(e()).b();
    }

    protected boolean b() {
        boolean z = false;
        try {
            PendoLogger.i("Init against the backend.", new Object[0]);
            s m = sdk.pendo.io.network.interfaces.a.m();
            if (m != null) {
                z = a(a(((GetAuthToken) m.a(GetAuthToken.class)).getAccessTokenSigned()));
            }
        } catch (Exception e2) {
            PendoLogger.w(e2, "exception in executeGetAuthToken", new Object[0]);
        }
        if (!z) {
            sdk.pendo.io.network.interfaces.a.a(a.EnumC0213a.FAILED);
        }
        return z;
    }

    public void e(boolean z) {
        if (z) {
            h.set(true);
        }
        if (sdk.pendo.io.g9.f.a()) {
            j();
        } else {
            this.e = sdk.pendo.io.g9.f.a(new C0227a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        JSONObject jSONObject = new JSONObject();
        if (PendoInternal.m() == null) {
            PendoLogger.e("Application context is null.", new Object[0]);
            return false;
        }
        b.Companion companion = sdk.pendo.io.k8.b.INSTANCE;
        companion.b().a(jSONObject);
        try {
            c0 a2 = sdk.pendo.io.g9.a.f1122a.a(jSONObject.getJSONObject(companion.a()).toString());
            s p = sdk.pendo.io.network.interfaces.a.p();
            if (p == null) {
                return false;
            }
            return d(a(((RegisterDevice) p.a(RegisterDevice.class)).registerDevice(a2)));
        } catch (Exception e2) {
            PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ m c(j jVar) {
        return jVar.e(new sdk.pendo.io.c9.a(3, 3000)).d(new sdk.pendo.io.d6.h() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.d6.h
            public final Object apply(Object obj) {
                r b2;
                b2 = a.b((Throwable) obj);
                return b2;
            }
        }).b(sdk.pendo.io.v6.a.b());
    }

    public static void d(boolean z) {
        g = z;
    }

    protected boolean b(r<InitModel> rVar) {
        boolean d2 = rVar.d();
        if (!d2) {
            return rVar.b() == 451 ? sdk.pendo.io.t8.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda3
                @Override // java.util.function.BooleanSupplier
                public final boolean getAsBoolean() {
                    return a.this.c();
                }
            }) : (rVar.b() == 401 && b()) ? c() : d2;
        }
        InitModel a2 = rVar.a();
        if (g) {
            a2 = new InitModelImporter().getInitModelFromJSONAssetFile();
        }
        if (a2 == null) {
            PendoLogger.e("handleInitResponse: body is null", new Object[0]);
        } else {
            if (!PendoInternal.a(false, "startSession")) {
                PendoInternal.a(a2);
                a2.init();
                return d2;
            }
            PendoLogger.w("BackendAPIManager", "startSession API was not properly called - please exit test/preview/capture mode and start the app again.");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        try {
            if (f()) {
                s d2 = sdk.pendo.io.network.interfaces.a.d();
                if (d2 == null) {
                    PendoLogger.d("Cannot get analytics retrofit.", new Object[0]);
                    return;
                }
                ErrorData errorData = (ErrorData) d2.a(ErrorData.class);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                a(a(errorData.send(sdk.pendo.io.g9.a.f1122a.a(str))), str);
            }
        } catch (Exception e2) {
            PendoLogger.w(e2, "Exception in executing executeErrorReport with: %s", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r b(Throwable th) {
        return r.a(InputDeviceCompat.SOURCE_DPAD, sdk.pendo.io.w2.e0.a("{error: \"Server is not available?\"}", PendoGsonRequestBodyConverter.JSON_MEDIA_TYPE));
    }

    public static void c(boolean z) {
        f = z ? 1 : 0;
    }

    void a(r<sdk.pendo.io.w2.e0> rVar, String str) {
        if (rVar == null) {
            PendoLogger.d("Response is null. Cannot send error.", new Object[0]);
        } else {
            if (rVar.d()) {
                sdk.pendo.io.i8.a.a(PendoInternal.m());
                return;
            }
            if (rVar.b() == 451) {
                sdk.pendo.io.t8.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda1
                    @Override // java.util.function.BooleanSupplier
                    public final boolean getAsBoolean() {
                        boolean g2;
                        g2 = a.g();
                        return g2;
                    }
                });
            }
            PendoLogger.d("Cannot send error! status = " + rVar.b() + " error: ", new Object[0]);
        }
    }

    public void b(final String str) {
        if (sdk.pendo.io.t8.a.d() || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            sdk.pendo.io.network.interfaces.a.c().f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda4
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    a.this.a(str, (GetAuthToken.GetAuthTokenResponse) obj);
                }
            }, "BackendApiManager sendErrorReport access token observer"));
        } catch (Exception e2) {
            PendoLogger.w(e2, "Cannot get access token, not sending '" + str + "'.", new Object[0]);
        }
    }

    private void b(boolean z) {
        this.c.set(z);
    }

    protected boolean a(r<GetAuthToken.GetAuthTokenResponse> rVar) {
        boolean a2;
        boolean z = false;
        if (rVar == null) {
            a(false);
            b(false);
            return false;
        }
        if (rVar.b() == 301) {
            int i2 = this.f1503a + 1;
            this.f1503a = i2;
            if (i2 > 3) {
                PendoLogger.e("BackendAPIManagerhandleGetAccessTokenResponse tried executing more than 3redirections.", new Object[0]);
                return false;
            }
            if (c(rVar)) {
                return b();
            }
            return false;
        }
        this.f1503a = 0;
        GetAuthToken.GetAuthTokenResponse a3 = rVar.a();
        if (!rVar.d() || a3 == null) {
            try {
                int b2 = rVar.b();
                if (b2 == 451) {
                    a2 = sdk.pendo.io.t8.a.a().a(rVar.c(), new BooleanSupplier() { // from class: sdk.pendo.io.p8.a$$ExternalSyntheticLambda2
                        @Override // java.util.function.BooleanSupplier
                        public final boolean getAsBoolean() {
                            return a.this.b();
                        }
                    });
                } else if (b2 == 500) {
                    PendoLogger.d("Error code: " + b2, new Object[0]);
                } else if (b2 == 401) {
                    a2 = a();
                }
                z = a2;
            } catch (Exception e2) {
                PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
            }
        } else {
            String str = a3.accessToken;
            SessionData.INSTANCE.onGetAccessTokenResponseReceived(a3);
            sdk.pendo.io.network.interfaces.a.a(a3);
            a(rVar.a());
            z = !TextUtils.isEmpty(str);
            Log.i("BackendAPIManager", "Pendo Mobile SDK was successfully integrated and connected to the server. App version identified: '" + AndroidUtils.d() + "', SDK version identified: '" + i0.a() + "'.");
        }
        a(z);
        b(z);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ r a(Throwable th) {
        return r.a(InputDeviceCompat.SOURCE_DPAD, sdk.pendo.io.w2.e0.a(PendoGsonRequestBodyConverter.JSON_MEDIA_TYPE, "{error: \"Server is not available?\"}"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        e0.a(new g(str));
    }

    private void a(GetAuthToken.GetAuthTokenResponse getAuthTokenResponse) {
        try {
            Iterator<sdk.pendo.io.p8.b> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onGetAccessTokenResponseReceived(getAuthTokenResponse);
            }
        } catch (Exception e2) {
            PendoLogger.i(e2, "error in notifyGetAccessTokenResponseListeners: ", new Object[0]);
        }
    }

    public void a(String str, boolean z, String str2) {
        if (sdk.pendo.io.t8.a.d()) {
            return;
        }
        e0.a(new e(str, z, str2));
    }

    public void a(JWTSessionData jWTSessionData, String str, boolean z, String str2) {
        if (sdk.pendo.io.t8.a.d()) {
            return;
        }
        e0.a(new f(jWTSessionData, str, z, str2));
    }

    public void a(JSONObject jSONObject) {
        if (sdk.pendo.io.t8.a.d()) {
            return;
        }
        e0.a(new b(jSONObject));
    }

    public void a(SessionData sessionData, JSONObject jSONObject, boolean z, boolean z2) {
        if (sdk.pendo.io.t8.a.d()) {
            return;
        }
        try {
            jSONObject.put("device_time", System.currentTimeMillis());
        } catch (JSONException e2) {
            PendoLogger.e("BackendAPIManager", e2, e2.getMessage());
        }
        a(sessionData, sdk.pendo.io.g9.a.f1122a.a(jSONObject.toString()), z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(SessionData sessionData, c0 c0Var, boolean z, boolean z2) {
        if (sdk.pendo.io.t8.a.d()) {
            return;
        }
        e0.a(new h(sessionData, c0Var, z, z2));
    }

    private void a(boolean z) {
        this.b.set(z);
    }
}
