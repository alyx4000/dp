package sdk.pendo.io;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import external.sdk.pendo.io.gson.Gson;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesConfigurationManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.PendoCommandAction;
import sdk.pendo.io.actions.PendoCommandDispatcher;
import sdk.pendo.io.actions.PendoCommandEventType;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuideBase;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.analytics.data.AnonDataForIdentifyEvent;
import sdk.pendo.io.e9.c;
import sdk.pendo.io.e9.d;
import sdk.pendo.io.f9.f;
import sdk.pendo.io.f9.l;
import sdk.pendo.io.g9.i0;
import sdk.pendo.io.g9.j0;
import sdk.pendo.io.g9.m0;
import sdk.pendo.io.g9.o;
import sdk.pendo.io.g9.o0;
import sdk.pendo.io.g9.p;
import sdk.pendo.io.g9.y;
import sdk.pendo.io.g9.z;
import sdk.pendo.io.i8.e;
import sdk.pendo.io.i8.j;
import sdk.pendo.io.i8.k;
import sdk.pendo.io.j9.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.AppKeyData;
import sdk.pendo.io.models.InitModel;
import sdk.pendo.io.models.JWTSessionData;
import sdk.pendo.io.models.MetadataModel;
import sdk.pendo.io.models.SessionData;
import sdk.pendo.io.network.interfaces.a;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.p8.d;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.x5.g;

/* loaded from: classes6.dex */
public final class PendoInternal {

    /* renamed from: a, reason: collision with root package name */
    public static Context f809a;
    public static SessionData b;
    public static AnonDataForIdentifyEvent c;
    public static JWTSessionData d;
    public static PendoPhasesCallbackInterface e;
    public static Boolean f;
    private static b g;
    private static Application h;
    private static String i;
    private static Long j;
    private static sdk.pendo.io.w6.b<Boolean> k;
    public static final Gson l;
    private static final AtomicBoolean m;
    public static final AtomicBoolean n;
    private static Application o;
    private static boolean p;
    private static boolean q;
    private static String r;
    private static String s;
    private static volatile boolean t;
    private static int u;
    private static final sdk.pendo.io.w6.a<Boolean> v;
    private static d w;
    private static f x;
    private static c y;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f810a;

        static {
            int[] iArr = new int[a.EnumC0213a.values().length];
            f810a = iArr;
            try {
                iArr[a.EnumC0213a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f810a[a.EnumC0213a.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static class b extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        Pendo.PendoOptions f811a;

        public b(Pendo.PendoOptions pendoOptions) {
            this.f811a = pendoOptions;
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
        
            sdk.pendo.io.PendoInternal.a(r2.f811a);
            sdk.pendo.io.PendoInternal.h.unregisterReceiver(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
        
            return;
         */
        @Override // android.content.BroadcastReceiver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onReceive(android.content.Context r3, android.content.Intent r4) {
            /*
                r2 = this;
                android.app.Application r4 = sdk.pendo.io.PendoInternal.m3018$$Nest$sfgeth()     // Catch: java.lang.Exception -> L50
                if (r4 != 0) goto L7
                return
            L7:
                r4 = 1
                java.lang.String r0 = "keyguard"
                if (r3 == 0) goto L24
                java.lang.Object r1 = r3.getSystemService(r0)     // Catch: java.lang.Exception -> L50
                android.app.KeyguardManager r1 = (android.app.KeyguardManager) r1     // Catch: java.lang.Exception -> L50
                android.content.Context r1 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L50
                if (r1 == 0) goto L24
                android.content.Context r3 = r3.getApplicationContext()     // Catch: java.lang.Exception -> L50
                boolean r3 = androidx.core.os.UserManagerCompat.isUserUnlocked(r3)     // Catch: java.lang.Exception -> L50
                if (r3 == 0) goto L24
                r3 = r4
                goto L25
            L24:
                r3 = 0
            L25:
                if (r3 != 0) goto L40
                android.app.Application r1 = sdk.pendo.io.PendoInternal.m3018$$Nest$sfgeth()     // Catch: java.lang.Exception -> L50
                android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Exception -> L50
                if (r1 == 0) goto L40
                java.lang.Object r0 = r1.getSystemService(r0)     // Catch: java.lang.Exception -> L50
                android.app.KeyguardManager r0 = (android.app.KeyguardManager) r0     // Catch: java.lang.Exception -> L50
                if (r0 == 0) goto L41
                boolean r0 = r0.inKeyguardRestrictedInputMode()     // Catch: java.lang.Exception -> L50
                if (r0 != 0) goto L40
                goto L41
            L40:
                r4 = r3
            L41:
                if (r4 == 0) goto L5a
                sdk.pendo.io.Pendo$PendoOptions r3 = r2.f811a     // Catch: java.lang.Exception -> L50
                sdk.pendo.io.PendoInternal.m3019$$Nest$sma(r3)     // Catch: java.lang.Exception -> L50
                android.app.Application r3 = sdk.pendo.io.PendoInternal.m3018$$Nest$sfgeth()     // Catch: java.lang.Exception -> L50
                r3.unregisterReceiver(r2)     // Catch: java.lang.Exception -> L50
                goto L5a
            L50:
                r3 = move-exception
                java.lang.String r3 = r3.getMessage()
                java.lang.String r4 = "PendoInternal"
                android.util.Log.e(r4, r3)
            L5a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.PendoInternal.b.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        f = bool;
        g = null;
        h = null;
        i = null;
        j = 0L;
        k = sdk.pendo.io.w6.b.n();
        l = new external.sdk.pendo.io.gson.a().a(PendoCommandAction.class, new PendoCommandAction.PendoCommandActionDeserializer()).a(PendoCommandEventType.class, new PendoCommandEventType.PendoCommandEventTypeDeserializer()).a();
        m = new AtomicBoolean(false);
        n = new AtomicBoolean(false);
        p = false;
        q = false;
        r = null;
        s = null;
        t = false;
        u = -1;
        v = sdk.pendo.io.w6.a.b(bool);
        w = sdk.pendo.io.p8.c.f1504a;
    }

    public PendoInternal(Pendo.PendoOptions pendoOptions) {
        try {
            f();
            T();
            d(i);
            y.c(s);
            sdk.pendo.io.network.interfaces.a.a(r);
            h();
            O();
            sdk.pendo.io.c8.f.e();
            F();
            sdk.pendo.io.s0.d.b(new sdk.pendo.io.j8.a());
            PendoCommandDispatcher.getInstance().init();
            sdk.pendo.io.m8.a.b();
            x.start();
            sdk.pendo.io.e9.a.f1035a.d();
            a();
            ActivationManager.INSTANCE.start();
            V();
            G();
            PendoLogger.d("Running with AndroidX app", new Object[0]);
        } catch (Exception e2) {
            PendoLogger.e("PendoInternal constructor catch: " + e2.getMessage(), e2);
        }
    }

    public static String A() {
        SessionData sessionData = b;
        if (sessionData instanceof JWTSessionData) {
            return ((JWTSessionData) sessionData).getSigningKeyName();
        }
        return null;
    }

    public static synchronized Map<String, Object> B() {
        synchronized (PendoInternal.class) {
            SessionData sessionData = b;
            if (sessionData == null) {
                return null;
            }
            return sessionData.getVisitorData();
        }
    }

    public static synchronized Map<String, Map<String, Object>> C() {
        synchronized (PendoInternal.class) {
            SessionData sessionData = b;
            if (sessionData == null) {
                return null;
            }
            return sessionData.getVisitorExternalData();
        }
    }

    public static String D() {
        SessionData sessionData = b;
        return sessionData == null ? "" : sessionData.getVisitorId();
    }

    public static void E() {
        c(z.i());
        b(z.f());
        c(z.g(), z.h());
        sdk.pendo.io.g9.d.a(x().n());
        sdk.pendo.io.g9.d.a(v(), s());
        sdk.pendo.io.c8.f.e().c();
        d.Companion companion = sdk.pendo.io.e9.d.INSTANCE;
        companion.a();
        companion.d();
    }

    public static void F() {
        if (d == null) {
            sdk.pendo.io.c8.b.f().b();
        } else {
            S();
            sdk.pendo.io.c8.f.e().c();
        }
    }

    private static void G() {
        sdk.pendo.io.i8.a.c(m());
    }

    private static void H() {
        new e(new j());
    }

    public static synchronized boolean I() {
        boolean z;
        synchronized (PendoInternal.class) {
            z = t;
        }
        return z;
    }

    public static boolean J() {
        if (!n.get()) {
            Log.e("APICallIgnored", "Make sure Pendo's Setup API has been called");
            return true;
        }
        if (sdk.pendo.io.t8.a.d()) {
            PendoLogger.d("PendoInternal", "SendingTrackEventForbidden since killSwitch is on");
            return true;
        }
        if (M() || U()) {
            return false;
        }
        PendoLogger.d("PendoInternal", "SendingTrackEventForbidden since session is not active and start session has not been called and we're not in preview/test mode");
        return true;
    }

    public static boolean K() {
        return b != null;
    }

    public static boolean L() {
        SessionData sessionData = b;
        return sessionData != null && sessionData.getIsJwtModeOn();
    }

    public static boolean M() {
        return p;
    }

    public static void N() {
        SessionData sessionData = b;
        if (sessionData == null) {
            return;
        }
        a(sessionData);
    }

    public static void O() {
        if (e == null || f.booleanValue()) {
            return;
        }
        f = Boolean.TRUE;
        sdk.pendo.io.network.interfaces.a.i().a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda7
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                PendoInternal.a((a.EnumC0213a) obj);
            }
        });
    }

    static void P() {
        w.b(false);
        w.a(false);
    }

    static synchronized void Q() {
        synchronized (PendoInternal.class) {
            if (a(false, "resumeGuides")) {
                return;
            }
            PendoLogger.d("Resuming guide showing.", new Object[0]);
            m.set(false);
        }
    }

    public static void R() {
        if (!U()) {
            PendoLogger.w("APICallIgnored", "screenContentChanged() - Session is not active and we're not in test/preview/capture mode . Will not execute screenContentChanged()");
            return;
        }
        try {
            x().k();
        } catch (Exception e2) {
            PendoLogger.w(e2, "PendoInternal.screenContentChanged() - an exception has been thrown during activityStateChange()", new Object[0]);
        }
    }

    public static void S() {
        if (Boolean.TRUE.equals(Boolean.valueOf(!q().booleanValue()))) {
            sdk.pendo.io.g9.d.a(v(), s());
        }
    }

    public static void T() {
        StringBuilder sb;
        String sb2;
        if (n.get()) {
            if (PendoLogger.forest().isEmpty() || (!(I() && (PendoLogger.forest().get(0) instanceof sdk.pendo.io.logging.a)) && (I() || !(PendoLogger.forest().get(0) instanceof sdk.pendo.io.logging.c)))) {
                PendoLogger.uprootAll();
                PendoLogger.plant(I() ? new sdk.pendo.io.logging.a() : new sdk.pendo.io.logging.c());
                if (sdk.pendo.io.k9.a.INSTANCE.a().a(f809a)) {
                    PendoLogger.plant(new sdk.pendo.io.logging.b("PNDQaLogs.txt", f809a.getExternalFilesDir(null), new b.e()));
                }
                sdk.pendo.io.network.interfaces.a.a(t);
                sb = new StringBuilder("Debug logging ");
            } else {
                sb = new StringBuilder("setLogTree() - Tree already exist = ");
            }
            sb2 = sb.append(t).append(".").toString();
        } else {
            sb2 = "setLogTree() - called before setup";
        }
        Log.d("PendoInternal", sb2);
    }

    public static synchronized boolean U() {
        boolean z;
        synchronized (PendoInternal.class) {
            if (!p()) {
                z = sdk.pendo.io.y8.a.d().h();
            }
        }
        return z;
    }

    private void V() {
        if (sdk.pendo.io.z8.b.c() == null) {
            sdk.pendo.io.p8.a.d().e(true);
        } else {
            PendoLogger.d("session token is not null", new Object[0]);
            sdk.pendo.io.z8.b.a(false, true);
        }
    }

    public static synchronized boolean b() {
        boolean z;
        synchronized (PendoInternal.class) {
            z = m.get();
        }
        return z;
    }

    public static synchronized void c() {
        synchronized (PendoInternal.class) {
            c = AnonDataForIdentifyEvent.a(b);
            b = null;
            z.b();
            sdk.pendo.io.e9.a.f1035a.a().clearAndUpdateGlobalEventProperties(null);
        }
    }

    public static void d() {
        d = null;
        if (b == null) {
            z.b();
        }
    }

    static synchronized void e() {
        synchronized (PendoInternal.class) {
            if (a(false, VisualGuideBase.DISMISS_VISIBLE_GUIDES)) {
                return;
            }
            PendoLogger.d("Dismissing visible guides.", new Object[0]);
            if (GuidesActionsManager.isInited()) {
                GuidesActionsManager.getInstance().dismissVisibleGuides();
            }
        }
    }

    public static void f() {
        t = t || i0.b(m());
    }

    public static void g() {
        if (a(false, "endSession")) {
            return;
        }
        try {
            try {
                c(false);
                c(z.i());
                b(z.f());
                c(z.g(), z.h());
                if (sdk.pendo.io.t8.a.d()) {
                    sdk.pendo.io.c8.b.f().a();
                } else {
                    sdk.pendo.io.g9.d.a(x().n());
                    sdk.pendo.io.g9.d.a(v(), s());
                    sdk.pendo.io.g9.d.d();
                    sdk.pendo.io.c8.f.e().c();
                }
                k.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda8
                    @Override // sdk.pendo.io.d6.j
                    public final boolean test(Object obj) {
                        boolean booleanValue;
                        booleanValue = ((Boolean) obj).booleanValue();
                        return booleanValue;
                    }
                }).f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda9
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        PendoInternal.b((Boolean) obj);
                    }
                }, "in endSession"));
            } catch (Exception e2) {
                PendoLogger.e(e2, "End Session catch" + e2.getMessage(), new Object[0]);
            }
            sdk.pendo.io.e9.d.INSTANCE.a();
            GuidesManager.INSTANCE.clear();
            GuidesConfigurationManager.INSTANCE.clear();
            ActivationManager.INSTANCE.clear();
            z.a(true);
            VisualGuidesManager.getInstance().clearAllVisualGuides();
            StepSeenManager.getInstance().reset();
            P();
            c();
        } finally {
            sdk.pendo.io.e9.d.INSTANCE.a();
        }
    }

    public static void h() {
        c(z.g(), z.h());
        c(z.i());
        b(z.f());
    }

    public static synchronized Map<String, Object> i() {
        synchronized (PendoInternal.class) {
            SessionData sessionData = b;
            if (sessionData == null) {
                return null;
            }
            return sessionData.getAccountData();
        }
    }

    public static synchronized Map<String, Map<String, Object>> j() {
        synchronized (PendoInternal.class) {
            SessionData sessionData = b;
            if (sessionData == null) {
                return null;
            }
            return sessionData.getAccountExternalData();
        }
    }

    public static String k() {
        SessionData sessionData = b;
        return sessionData == null ? "" : sessionData.getAccountId();
    }

    public static Application l() {
        return o;
    }

    public static Context m() {
        return f809a;
    }

    public static String n() {
        if (n.get()) {
            return AndroidUtils.g();
        }
        PendoLogger.w("APICallIgnored", "getDeviceId API ignored. Make sure Pendo's Setup API has been called");
        return null;
    }

    public static sdk.pendo.io.w6.b<Boolean> o() {
        return k;
    }

    public static synchronized boolean p() {
        boolean z;
        synchronized (PendoInternal.class) {
            if (q) {
                z = sdk.pendo.io.t8.a.d() ? false : true;
            }
        }
        return z;
    }

    public static Boolean q() {
        return v.o();
    }

    public static String r() {
        SessionData sessionData = b;
        if (sessionData instanceof JWTSessionData) {
            return ((JWTSessionData) sessionData).getJwt();
        }
        return null;
    }

    public static String s() {
        JWTSessionData jWTSessionData = d;
        if (jWTSessionData == null) {
            return null;
        }
        return jWTSessionData.getAccountId();
    }

    public static String t() {
        JWTSessionData jWTSessionData = d;
        if (jWTSessionData == null) {
            return null;
        }
        return jWTSessionData.getJwt();
    }

    public static JWTSessionData u() {
        return d;
    }

    public static String v() {
        JWTSessionData jWTSessionData = d;
        if (jWTSessionData == null) {
            return null;
        }
        return jWTSessionData.getVisitorId();
    }

    public static c w() {
        return y;
    }

    public static f x() {
        return x;
    }

    public static SessionData y() {
        return b;
    }

    public static int z() {
        return u;
    }

    void a() {
        sdk.pendo.io.p8.a.d().a(sdk.pendo.io.e9.a.f1035a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(String str, String str2, Map<String, Object> map, Map<String, Object> map2, boolean z) {
        if (j0.a(str)) {
            str = SessionData.retrieveAnonymousVisitorID(AndroidUtils.isGeneratedDeviceIdAfterAppInstall, AndroidUtils.g());
        } else {
            SessionData.generateAndStoreNewAnonymousVisitorID();
        }
        String str3 = str;
        GuidesManager.cancelCurrentGuide(true);
        if (c == null) {
            c = AnonDataForIdentifyEvent.a(b);
        }
        SessionData sessionData = new SessionData(str2, str3, map, map2, false, c);
        c = null;
        a(sessionData, z);
    }

    static void b(final String str, final String str2, final Map<String, Object> map, final Map<String, Object> map2, boolean z) {
        g<Boolean> a2;
        sdk.pendo.io.d6.e eVar;
        String str3;
        if (z) {
            a2 = sdk.pendo.io.network.interfaces.a.c().f();
            eVar = new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    PendoInternal.a(str, str2, (Map<String, Object>) map, (Map<String, Object>) map2, false);
                }
            };
            str3 = "Pendo startSession access token observer";
        } else {
            a2 = ActivationManager.INSTANCE.isInitedObservable().a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda1
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean booleanValue;
                    booleanValue = ((Boolean) obj).booleanValue();
                    return booleanValue;
                }
            }).f().a(sdk.pendo.io.v6.a.b());
            eVar = new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda2
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    PendoInternal.a(str, str2, (Map<String, Object>) map, (Map<String, Object>) map2, true);
                }
            };
            str3 = "Pendo startSession init completed observer";
        }
        a2.a(sdk.pendo.io.d9.b.a(eVar, str3));
    }

    public static boolean e(String str, String str2) {
        if (b == null) {
            return false;
        }
        if ((str == null || str.isEmpty()) && b.isAnonymous() && str2.equals(b.getAccountId())) {
            return true;
        }
        return j0.a(b.getVisitorId(), str) && j0.a(b.getAccountId(), str2);
    }

    public static void f(String str, String str2) {
        if (a(true, "startSession")) {
            return;
        }
        if (!a(str, str2)) {
            PendoLogger.w("Could not start the new session. Please verify that the session's JWT is valid and that the signing keyName is correct, or start a non-JWT session using startSession(String visitorId, String accountId, Map<String,Object> visitorData, Map<String,Object> accountData) API call", new Object[0]);
            return;
        }
        JWTSessionData a2 = o.f.a(str, str2, 3);
        if (a2 == null || !g(a2.getVisitorId(), a2.getAccountId())) {
            PendoLogger.w("Could not start the new session. Please verify that the session's JWT is valid and that the signing keyName is correct, or start a non-JWT session using startSession(String visitorId, String accountId, Map<String,Object> visitorData, Map<String,Object> accountData) API call", new Object[0]);
            return;
        }
        GuidesManager.cancelCurrentGuide(true);
        m.set(false);
        a(a2);
    }

    static boolean g(String str, String str2) {
        if (e(str, str2)) {
            PendoLogger.d("Pendo switchVisitor ignored - same visitorId and accountId are currently used. Please use setVisitorData and setAccountData to update visitor and account metadata.", new Object[0]);
            return false;
        }
        ActivationManager.INSTANCE.getTrackEventsBeforeSessionStart().clear();
        d(true);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j.longValue();
        if (elapsedRealtime < 5000) {
            PendoLogger.d("Your last switchVisitor was " + (elapsedRealtime / 1000.0d) + " seconds ago, please check if this is the desired behaviour.", new Object[0]);
        }
        j = Long.valueOf(SystemClock.elapsedRealtime());
        return true;
    }

    public static String a(String str) {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int length = stackTrace.length;
            for (StackTraceElement stackTraceElement : stackTrace) {
                String className = stackTraceElement.getClassName();
                if (className != null && className.equalsIgnoreCase("sdk.pendo.io.Pendo")) {
                    return stackTraceElement.getMethodName();
                }
            }
            return str;
        } catch (Exception unused) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Boolean bool) {
        PendoLogger.d("------ endSession - pausing analytics: --- " + bool, new Object[0]);
        sdk.pendo.io.c8.f.e().a(true);
        k.onNext(Boolean.FALSE);
    }

    private static void c(SessionData sessionData) {
        boolean z = false;
        boolean z2 = (sessionData.getVisitorData() == null || sessionData.getVisitorData().isEmpty()) ? false : true;
        if (sessionData.getAccountData() != null && !sessionData.getAccountData().isEmpty()) {
            z = true;
        }
        if (!z2) {
            w.b(true);
        }
        if (!z) {
            w.a(true);
        }
        w.a(sessionData, true);
    }

    public static void d(boolean z) {
        p = z;
    }

    public static void e(SessionData sessionData) {
        if (b != null) {
            sdk.pendo.io.e9.a aVar = sdk.pendo.io.e9.a.f1035a;
            synchronized (aVar.a()) {
                b.setAndMergeAccountData(sessionData.removeDuplicatesAndTransformKeys().getAccountData());
                aVar.a().updateAccountGlobalEventProperties(b.getAccountData());
            }
        }
    }

    public static void f(SessionData sessionData) {
        if (b != null) {
            sdk.pendo.io.e9.a aVar = sdk.pendo.io.e9.a.f1035a;
            synchronized (aVar.a()) {
                b.setAndMergeVisitorData(sessionData.removeDuplicatesAndTransformKeys().getVisitorData());
                aVar.a().updateVisitorGlobalEventProperties(b.getVisitorData());
            }
        }
    }

    static void a(final SessionData sessionData) {
        g<Boolean> a2;
        sdk.pendo.io.d6.e eVar;
        String str;
        if (y() == null) {
            a2 = sdk.pendo.io.network.interfaces.a.c().f();
            eVar = new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda4
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    PendoInternal.a(SessionData.this, false);
                }
            };
            str = "Pendo switch visitor access token observer";
        } else {
            a2 = ActivationManager.INSTANCE.isInitedObservable().a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda5
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean booleanValue;
                    booleanValue = ((Boolean) obj).booleanValue();
                    return booleanValue;
                }
            }).f().a(sdk.pendo.io.v6.a.b());
            eVar = new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda6
                @Override // sdk.pendo.io.d6.e
                public final void accept(Object obj) {
                    PendoInternal.a(SessionData.this, true);
                }
            };
            str = "Pendo switch visitor init completed observer";
        }
        a2.a(sdk.pendo.io.d9.b.a(eVar, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(Pendo.PendoOptions pendoOptions) {
        new PendoInternal(pendoOptions);
    }

    public static synchronized void c(boolean z) {
        synchronized (PendoInternal.class) {
            q = z;
        }
    }

    static synchronized void d(String str, String str2) {
        synchronized (PendoInternal.class) {
            a(str, str2, 1);
        }
    }

    public static void a(SessionData sessionData, boolean z) {
        try {
            Log.i("PendoInternal", "SDK SwitchVisitor occurred");
            PendoLogger.d("Visitor Switched: visitorID = " + sessionData.getVisitorId() + ", accountID = " + sessionData.getAccountId() + ", visitorData= " + sessionData.getVisitorData() + ", accountData = " + sessionData.getAccountData(), new Object[0]);
            c(false);
            ActivationManager.INSTANCE.setIsInitedObservable(false);
            sdk.pendo.io.c8.f.e().a(false);
            if (GuidesActionsManager.isInited()) {
                GuidesActionsManager.getInstance().dismissVisibleGuides();
            }
            P();
            if (z) {
                E();
            }
            b(sessionData);
            sdk.pendo.io.n8.c.g().k();
            sdk.pendo.io.p8.a.d().e(true);
            z.p();
            z.l();
            sdk.pendo.io.g9.d.b(x().n());
            sdk.pendo.io.c8.f.e().c();
            v.onNext(Boolean.TRUE);
        } catch (Exception e2) {
            PendoLogger.e(e2, "handleSwitchVisitor catch" + e2.getMessage(), new Object[0]);
        }
    }

    private static synchronized void b(SessionData sessionData) {
        synchronized (PendoInternal.class) {
            d(sessionData);
            b.persistData();
            c(sessionData);
        }
    }

    private static void c(Pendo.PendoOptions pendoOptions) {
        String environment = pendoOptions.getEnvironment();
        if (environment == null || environment.trim().isEmpty()) {
            return;
        }
        Log.i("PendoInternal", "Using override environment: " + environment);
        JsonWebTokenValidator.INSTANCE.setEnvironment(environment);
        try {
            JsonWebTokenValidator.Environment valueOf = JsonWebTokenValidator.Environment.valueOf(environment.toUpperCase());
            if (valueOf == JsonWebTokenValidator.Environment.DEV || valueOf == JsonWebTokenValidator.Environment.STAGING) {
                y.d();
            }
        } catch (Exception unused) {
            Log.d("PendoInternal", "Invalid environment: " + environment);
        }
    }

    private static void d(SessionData sessionData) {
        sdk.pendo.io.e9.a aVar = sdk.pendo.io.e9.a.f1035a;
        synchronized (aVar.a()) {
            b = sessionData.removeDuplicatesAndTransformKeys();
            aVar.a().clearAndUpdateGlobalEventProperties(b);
        }
    }

    public static void a(MetadataModel metadataModel) {
        if (b == null) {
            return;
        }
        if (metadataModel == null) {
            Log.d("PendoInternal", "Received null metadata");
            return;
        }
        Map<String, Map<String, Object>> visitorMetaData = metadataModel.getVisitorMetaData();
        Map<String, Map<String, Object>> accountMetaData = metadataModel.getAccountMetaData();
        if (visitorMetaData != null && !visitorMetaData.isEmpty()) {
            b.setVisitorExternalData(visitorMetaData);
        }
        if (accountMetaData == null || accountMetaData.isEmpty()) {
            return;
        }
        b.setAccountExternalData(accountMetaData);
    }

    static synchronized void b(String str, String str2) {
        synchronized (PendoInternal.class) {
            a(str, str2, 2);
        }
    }

    public static void c(String str, String str2) {
        if (d == null) {
            d = new JWTSessionData();
        }
        d.setJwt(str);
        d.setSigningKeyName(str2);
    }

    static void d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new sdk.pendo.io.i8.g("Your app key is not valid.");
        }
        try {
            AppKeyData appKeyData = (AppKeyData) l.a(JsonWebTokenValidator.INSTANCE.validate(str), AppKeyData.class);
            if (appKeyData == null) {
                throw new sdk.pendo.io.i8.g("Your app key is not valid.");
            }
            r = appKeyData.getKey();
            s = appKeyData.getDataCenter();
        } catch (Exception unused) {
            throw new sdk.pendo.io.i8.g("Your app key is not valid.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void a(final Pendo.PendoOptions pendoOptions) {
        synchronized (PendoInternal.class) {
            H();
            c(pendoOptions);
            if (sdk.pendo.io.t8.a.d()) {
                Log.e("PendoInternal", "Pendo SDK kill switch is on");
            } else {
                o = h;
                h = null;
                new Thread(new Runnable() { // from class: sdk.pendo.io.PendoInternal$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        PendoInternal.b(Pendo.PendoOptions.this);
                    }
                }).start();
            }
        }
    }

    static synchronized void b(boolean z) {
        synchronized (PendoInternal.class) {
            t = z;
            T();
        }
    }

    public static void c(String str) {
        if (d == null) {
            d = new JWTSessionData();
        }
        if (d.getJwt() == null && j0.a(str)) {
            str = SessionData.retrieveAnonymousVisitorID(false, AndroidUtils.g());
        }
        if (d.getJwt() != null && str == null) {
            str = "";
        }
        d.setVisitorId(str);
    }

    private static boolean a(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getApplicationContext().getSystemService("keyguard");
        return keyguardManager == null || !keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static void b(String str) {
        if (d == null) {
            d = new JWTSessionData();
        }
        if (str == null) {
            str = "";
        }
        d.setAccountId(str);
    }

    static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : true;
    }

    static synchronized void b(Map<String, Object> map) {
        synchronized (PendoInternal.class) {
            SessionData sessionData = b;
            if (sessionData == null) {
                return;
            }
            boolean z = false;
            if (sessionData.getIsJwtModeOn()) {
                PendoLogger.d("Pendo setVisitorData ignored - JWT mode api", new Object[0]);
                return;
            }
            if (map != null && !map.isEmpty()) {
                z = true;
            }
            if (z) {
                SessionData sessionData2 = new SessionData();
                sessionData2.setVisitorData(map);
                w.a(sessionData2);
                f(sessionData2);
            } else {
                w.b(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a.EnumC0213a enumC0213a) {
        if (e != null) {
            int i2 = a.f810a[enumC0213a.ordinal()];
            if (i2 == 1) {
                e.onInitComplete();
            } else if (i2 != 2) {
                PendoLogger.e("PendoInternal", "Unhandled event type emitted by InitObservable with value: " + enumC0213a);
            } else {
                e.onInitFailed();
            }
        }
    }

    static synchronized void a(boolean z) {
        synchronized (PendoInternal.class) {
            if (a(false, "pauseGuides")) {
                return;
            }
            PendoLogger.d("Pausing guide showing.", new Object[0]);
            if (z) {
                e();
            }
            m.set(true);
        }
    }

    private static void a(String str, String str2, int i2) {
        SessionData sessionData = b;
        if (sessionData == null) {
            return;
        }
        if (!sessionData.getIsJwtModeOn()) {
            PendoLogger.d("Pendo set visitor or account data for Jwt ignored - check JWT mode api", new Object[0]);
            return;
        }
        if (!a(str, str2)) {
            PendoLogger.d("Pendo jwt/signingKeyName is invalid", new Object[0]);
            return;
        }
        JWTSessionData a2 = o.f.a(str, str2, i2);
        if (a2 != null) {
            w.a(a2);
        }
    }

    static boolean a(View view) {
        if (!U()) {
            PendoLogger.w("APICallIgnored", "Pendo.sendClickAnalytic API - session must be active");
            return false;
        }
        if (view == null) {
            PendoLogger.w("PendoInternal", "Pendo.sendClickAnalytic API - view must not be null");
            return false;
        }
        if (!view.isClickable()) {
            PendoLogger.w("PendoInternal", "Pendo.sendClickAnalytic API - view must first be set as clickable. Please refer to the Pendo documentation");
            return false;
        }
        if (sdk.pendo.io.p9.a.b(view)) {
            PendoLogger.d("PendoInternal", "Pendo.sendClickAnalytic API - Pendo is already recognizing onTouchEvent, ignoring API");
            return true;
        }
        try {
            JSONObject b2 = o0.f1142a.b(view);
            sdk.pendo.io.e9.a.f1035a.a(b2, true);
            ActivationManager.INSTANCE.handleClick(b2, new WeakReference<>(view));
            return true;
        } catch (JSONException e2) {
            PendoLogger.w(e2, e2.getMessage(), "Could not send RAClick event for " + view);
            return false;
        }
    }

    static synchronized void a(Map<String, Object> map) {
        synchronized (PendoInternal.class) {
            SessionData sessionData = b;
            if (sessionData == null) {
                return;
            }
            boolean z = false;
            if (sessionData.getIsJwtModeOn()) {
                PendoLogger.d("Pendo setAccountData ignored - JWT mode api", new Object[0]);
                return;
            }
            if (map != null && !map.isEmpty()) {
                z = true;
            }
            if (z) {
                SessionData sessionData2 = new SessionData();
                sessionData2.setAccountData(map);
                w.a(sessionData2);
                e(sessionData2);
            } else {
                w.a(true);
            }
        }
    }

    static void a(Context context, String str, Pendo.PendoOptions pendoOptions, PendoPhasesCallbackInterface pendoPhasesCallbackInterface) {
        if (n.getAndSet(true)) {
            Log.e("PendoInternal", m().getString(R.string.pnd_err_already_init));
            return;
        }
        sdk.pendo.io.e9.d.INSTANCE.d();
        try {
            if (context == null) {
                throw new k("Context can't be null, Pendo.setup failed.");
            }
            Application a2 = AndroidUtils.a(context);
            h = a2;
            if (a2 == null) {
                throw new k("Failed to extract the Application class. \"context.getApplicationContext()\" should not return null, please call Pendo.setup() in the onCreate method");
            }
            Context applicationContext = context.getApplicationContext();
            f809a = applicationContext;
            sdk.pendo.io.network.interfaces.a.a(applicationContext);
            i = str;
            e = pendoPhasesCallbackInterface;
            if (pendoOptions == null) {
                pendoOptions = new Pendo.PendoOptions();
            }
            sdk.pendo.io.k9.a.INSTANCE.a().a(pendoOptions.getEnvironment());
            PlatformStateManager platformStateManager = PlatformStateManager.INSTANCE;
            platformStateManager.extractFrameworkDataFromPendoOptions(pendoOptions);
            sdk.pendo.io.network.interfaces.a.a(platformStateManager.getFrameworkAsString(), platformStateManager.getFrameworkTypeAsString(), platformStateManager.getFrameworkVersion());
            f a3 = new l(platformStateManager).a(platformStateManager.getFramework(), pendoOptions);
            x = a3;
            y = (c) a3;
            sdk.pendo.io.p8.a.c(pendoOptions.isIncludeAllGuidesContent());
            sdk.pendo.io.p8.a.d(pendoOptions.isImportInitModelFromLocalFile());
            if (AndroidUtils.d() == null) {
                throw new Exception(m().getString(R.string.pnd_empty_host_app_version_name));
            }
            sdk.pendo.io.n8.a a4 = sdk.pendo.io.n8.a.a(pendoOptions);
            Activity a5 = sdk.pendo.io.g9.c.a(context);
            if (a5 != null) {
                a4.a(a5, true);
            }
            h.registerActivityLifecycleCallbacks(a4);
            if (a(f809a)) {
                a(pendoOptions);
                return;
            }
            g = new b(pendoOptions);
            h.registerReceiver(g, new IntentFilter("android.intent.action.USER_PRESENT"));
        } catch (Exception e2) {
            n.set(false);
            Log.e("PendoInternal", e2.getMessage(), e2);
            PendoPhasesCallbackInterface pendoPhasesCallbackInterface2 = e;
            if (pendoPhasesCallbackInterface2 != null) {
                pendoPhasesCallbackInterface2.onInitFailed();
            }
        }
    }

    public static boolean a(boolean z, String str) {
        if (!n.get()) {
            Log.e("APICallIgnored", a(str) + " API ignored. Make sure Pendo's Setup API has been called");
            return true;
        }
        if (sdk.pendo.io.y8.a.d().h()) {
            PendoLogger.w("APICallIgnored", a(str) + " API ignored. SDK is in capture/test/preview mode");
            return true;
        }
        if (z || M() || p()) {
            return false;
        }
        PendoLogger.w("APICallIgnored", a(str) + " API ignored. Make sure Pendo's StartSession API has been called");
        return true;
    }

    static void a(String str, String str2, Map<String, Object> map, Map<String, Object> map2) {
        if (a(true, "startSession")) {
            return;
        }
        if (j0.a(str2)) {
            str2 = "";
        }
        if (g(str, str2)) {
            m.set(false);
            b(str, str2, map, map2, y() == null);
        }
    }

    public static void a(InitModel initModel) {
        if (initModel == null || initModel.getInitConfiguration() == null) {
            PendoLogger.d("Init model configuration is null in storeSessionTimeout. Response from server is 200.", new Object[0]);
        } else {
            u = initModel.getInitConfiguration().getSessionTimeout();
        }
    }

    static void a(String str, Map<String, Object> map) {
        if (J() || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put("event", str);
            jSONObject.put("type", "track");
            p.a((Map<String, ? extends Object>) map, jSONObject2);
            jSONObject.put("properties", jSONObject2);
        } catch (JSONException e2) {
            String a2 = m0.a(map);
            PendoLogger.e(e2, e2.getMessage(), "Could not send track event");
            PendoLogger.d(e2, e2.getMessage(), "EventName: " + str + "properties: " + a2);
        }
        sdk.pendo.io.e9.a.f1035a.a(jSONObject);
        ActivationManager.INSTANCE.handleTrack(jSONObject);
    }
}
