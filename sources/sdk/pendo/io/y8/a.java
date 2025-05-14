package sdk.pendo.io.y8;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.GuidesActionsManager;
import sdk.pendo.io.actions.GuidesManager;
import sdk.pendo.io.actions.StepSeenManager;
import sdk.pendo.io.actions.VisualGuidesManager;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GuideModel;
import sdk.pendo.io.models.StepGuideModel;
import sdk.pendo.io.network.responses.validators.JsonWebTokenValidator;
import sdk.pendo.io.network.socketio.configuration.TestModeDetails;
import sdk.pendo.io.views.listener.FloatingListenerButton;
import sdk.pendo.io.x7.d;
import sdk.pendo.io.x7.h;
import sdk.pendo.io.x7.i;
import sdk.pendo.io.x7.j;

/* loaded from: classes4.dex */
public final class a {
    private static volatile a f;
    private static final Object g = new Object();
    private static sdk.pendo.io.w6.a<Boolean> h;
    private static sdk.pendo.io.w6.a<Boolean> i;
    private static sdk.pendo.io.w6.a<Boolean> j;
    private static sdk.pendo.io.w6.a<Boolean> k;
    private static sdk.pendo.io.w6.a<Boolean> l;
    private static sdk.pendo.io.w6.a<Boolean> m;

    /* renamed from: a, reason: collision with root package name */
    private e f1861a;
    private sdk.pendo.io.x7.b<e> b;
    private Handler c = new Handler(Looper.getMainLooper());
    private Runnable d = null;
    private StepGuideModel e;

    /* renamed from: sdk.pendo.io.y8.a$a, reason: collision with other inner class name */
    class RunnableC0277a implements Runnable {
        RunnableC0277a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            PendoLogger.d("StateFSM - showing capture fail dialog", new Object[0]);
            sdk.pendo.io.z8.a.a();
        }
    }

    class b implements sdk.pendo.io.y7.a<i> {
        b() {
        }

        private void b(i iVar) {
            Runnable runnable;
            try {
                a aVar = a.this;
                Handler handler = aVar.c;
                if (handler != null && (runnable = aVar.d) != null) {
                    handler.removeCallbacks(runnable);
                }
                sdk.pendo.io.h8.b progressDialog = FloatingListenerButton.getProgressDialog();
                if (progressDialog == null || progressDialog.getDialog() == null || !progressDialog.getDialog().isShowing() || iVar.a().equals(d.EVENT_CAPTURE_MODE_SCREEN_RECEIVED) || iVar.a().equals(d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED)) {
                    return;
                }
                PendoLogger.d("StateFSM - dismissing dialog", new Object[0]);
                FloatingListenerButton.clearDialogFragment();
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), a.a(iVar));
            }
        }

        @Override // sdk.pendo.io.y7.a
        public void a(i iVar) {
            try {
                if (iVar.a().equals(d.EVENT_CAPTURE_MODE_EXIT)) {
                    a.this.v();
                }
                a.h.onNext(Boolean.FALSE);
                b(iVar);
                PendoLogger.d("StateFSM - Leaving capture mode.", new Object[0]);
            } catch (Exception e) {
                PendoLogger.e(e, e.getMessage(), a.a(iVar));
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                GuidesManager.INSTANCE.showPreview();
            } catch (Exception e) {
                sdk.pendo.io.g9.d.a(d.b.ERROR_REASON_RUN_PREVIEW_GUIDE, e.getMessage(), new Object[0]);
            }
            a.this.a(d.EVENT_PREVIEW_DISPLAYED, new Object[0]);
        }
    }

    public enum d implements sdk.pendo.io.x7.c {
        EVENT_SOCKET_CONNECTED,
        EVENT_SOCKET_DISCONNECTED,
        EVENT_PAIR_MODE_UPDATE,
        EVENT_CAPTURE_MODE_ENTER,
        EVENT_CAPTURE_MODE_EXIT,
        EVENT_CAPTURE_MODE_SCREEN_CAPTURED,
        EVENT_CAPTURE_MODE_SCREEN_RECEIVED,
        EVENT_PREVIEW_ON_DEVICE,
        EVENT_PREVIEW_DISPLAYED,
        EVENT_TEST_MODE_ENTER,
        EVENT_TEST_MODE_EXIT,
        EVENT_RESET_STATE,
        EVENT_DEBUG_MODE_ENTER,
        EVENT_DEBUG_MODE_EXIT
    }

    private static class e extends i {
        private Object x0;

        private e() {
        }
    }

    public static final class f implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public enum g implements h {
        STATE_NOT_PAIRED,
        STATE_PAIRED,
        STATE_CAPTURE_MODE,
        STATE_PREVIEW,
        STATE_TEST_MODE,
        STATE_DEBUG_MODE
    }

    static {
        Boolean bool = Boolean.FALSE;
        h = sdk.pendo.io.w6.a.b(bool);
        i = sdk.pendo.io.w6.a.b(bool);
        j = sdk.pendo.io.w6.a.b(bool);
        k = sdk.pendo.io.w6.a.n();
        l = sdk.pendo.io.w6.a.b(bool);
        m = sdk.pendo.io.w6.a.b(bool);
    }

    private a() {
        f();
    }

    private void a() {
        this.b.a(g.STATE_NOT_PAIRED, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.b(iVar);
            }
        });
        this.b.a(g.STATE_PAIRED, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.c(iVar);
            }
        });
        sdk.pendo.io.x7.b<e> bVar = this.b;
        g gVar = g.STATE_CAPTURE_MODE;
        bVar.a(gVar, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda5
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.this.e(iVar);
            }
        });
        this.b.b(gVar, new b());
        sdk.pendo.io.x7.b<e> bVar2 = this.b;
        g gVar2 = g.STATE_PREVIEW;
        bVar2.a(gVar2, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda6
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.this.f(iVar);
            }
        });
        this.b.b(gVar2, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda7
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.g(iVar);
            }
        });
        sdk.pendo.io.x7.b<e> bVar3 = this.b;
        g gVar3 = g.STATE_DEBUG_MODE;
        bVar3.a(gVar3, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda8
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.h(iVar);
            }
        });
        this.b.b(gVar3, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda9
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.i(iVar);
            }
        });
        sdk.pendo.io.x7.b<e> bVar4 = this.b;
        g gVar4 = g.STATE_TEST_MODE;
        bVar4.a(gVar4, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda10
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.this.j(iVar);
            }
        });
        this.b.b(gVar4, new sdk.pendo.io.y7.a() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.y7.a
            public final void a(i iVar) {
                a.this.d(iVar);
            }
        });
    }

    private void b() {
        if (this.b != null) {
            return;
        }
        sdk.pendo.io.x7.d a2 = sdk.pendo.io.x7.d.a(g.STATE_NOT_PAIRED);
        d.a a3 = sdk.pendo.io.x7.d.a(d.EVENT_SOCKET_CONNECTED);
        g gVar = g.STATE_PAIRED;
        j a4 = a3.a(gVar);
        d.a a5 = sdk.pendo.io.x7.d.a(d.EVENT_CAPTURE_MODE_ENTER);
        g gVar2 = g.STATE_CAPTURE_MODE;
        j a6 = a5.a(gVar2);
        d dVar = d.EVENT_PAIR_MODE_UPDATE;
        d dVar2 = d.EVENT_RESET_STATE;
        j[] jVarArr = {sdk.pendo.io.x7.d.a(d.EVENT_CAPTURE_MODE_EXIT).a(gVar), sdk.pendo.io.x7.d.a(dVar).a(gVar2), sdk.pendo.io.x7.d.a(d.EVENT_SOCKET_DISCONNECTED).a(gVar), sdk.pendo.io.x7.d.a(dVar2).a(gVar), sdk.pendo.io.x7.d.a(d.EVENT_CAPTURE_MODE_SCREEN_RECEIVED).a(gVar2), sdk.pendo.io.x7.d.a(d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED).a(gVar2)};
        d.a a7 = sdk.pendo.io.x7.d.a(d.EVENT_PREVIEW_ON_DEVICE);
        g gVar3 = g.STATE_PREVIEW;
        j a8 = a7.a(gVar3);
        j[] jVarArr2 = {sdk.pendo.io.x7.d.a(d.EVENT_PREVIEW_DISPLAYED).a(gVar)};
        d.a a9 = sdk.pendo.io.x7.d.a(d.EVENT_TEST_MODE_ENTER);
        g gVar4 = g.STATE_TEST_MODE;
        this.b = a2.a(a4.a(a6.a(jVarArr), a8.a(jVarArr2), sdk.pendo.io.x7.d.a(dVar).a(gVar3), a9.a(gVar4).a(sdk.pendo.io.x7.d.a(d.EVENT_TEST_MODE_EXIT).a(gVar), sdk.pendo.io.x7.d.a(dVar2).a(gVar)), sdk.pendo.io.x7.d.a(d.EVENT_DEBUG_MODE_ENTER).a(g.STATE_DEBUG_MODE).a(sdk.pendo.io.x7.d.a(d.EVENT_DEBUG_MODE_EXIT).a(gVar)), sdk.pendo.io.x7.d.a(dVar).a(gVar4), sdk.pendo.io.x7.d.a(dVar).a(gVar))).a(new f());
    }

    public static a d() {
        a aVar = f;
        if (aVar == null) {
            synchronized (g) {
                aVar = f;
                if (aVar == null) {
                    aVar = new a();
                    f = aVar;
                }
            }
        }
        return aVar;
    }

    private void f() {
        b();
        a();
        e eVar = new e();
        this.f1861a = eVar;
        eVar.a(g.STATE_NOT_PAIRED);
        this.b.a(true, (boolean) this.f1861a);
    }

    public static synchronized sdk.pendo.io.x5.j<Boolean> j() {
        sdk.pendo.io.w6.a<Boolean> aVar;
        synchronized (a.class) {
            aVar = h;
        }
        return aVar;
    }

    public static synchronized sdk.pendo.io.x5.j<Boolean> k() {
        sdk.pendo.io.w6.a<Boolean> aVar;
        synchronized (a.class) {
            aVar = l;
        }
        return aVar;
    }

    public static synchronized sdk.pendo.io.x5.j<Boolean> l() {
        sdk.pendo.io.w6.a<Boolean> aVar;
        synchronized (a.class) {
            aVar = i;
        }
        return aVar;
    }

    public static synchronized sdk.pendo.io.x5.j<Boolean> m() {
        sdk.pendo.io.w6.a<Boolean> aVar;
        synchronized (a.class) {
            aVar = j;
        }
        return aVar;
    }

    public static synchronized sdk.pendo.io.x5.j<Boolean> q() {
        sdk.pendo.io.w6.a<Boolean> aVar;
        synchronized (a.class) {
            aVar = m;
        }
        return aVar;
    }

    public static synchronized Boolean r() {
        Boolean valueOf;
        synchronized (a.class) {
            valueOf = Boolean.valueOf(k.q() && k.o().booleanValue());
        }
        return valueOf;
    }

    public static synchronized sdk.pendo.io.x5.j<Boolean> s() {
        sdk.pendo.io.w6.a<Boolean> aVar;
        synchronized (a.class) {
            aVar = k;
        }
        return aVar;
    }

    private synchronized void u() {
        sdk.pendo.io.w6.a<Boolean> aVar = i;
        Boolean bool = Boolean.FALSE;
        aVar.onNext(bool);
        h.onNext(bool);
        j.onNext(bool);
        l.onNext(bool);
        m.onNext(bool);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v() {
        if (g() || t()) {
            if (VisualGuidesManager.getInstance().isAnyGuideShowing()) {
                GuidesActionsManager.getInstance().dismissVisibleGuides();
            }
            StepSeenManager.getInstance().reset();
            GuidesManager.INSTANCE.activateSessionGuides();
        }
    }

    public h c() {
        return this.f1861a.b();
    }

    public GuideModel e() {
        GuideModel guideFactory = GuideModel.guideFactory(this.e);
        guideFactory.setReady();
        return guideFactory;
    }

    public boolean g() {
        return this.f1861a.b().equals(g.STATE_CAPTURE_MODE);
    }

    public boolean h() {
        return g() || t() || p();
    }

    public boolean i() {
        return this.f1861a.b().equals(g.STATE_DEBUG_MODE);
    }

    public boolean n() {
        return this.f1861a.b().equals(g.STATE_NOT_PAIRED);
    }

    public boolean o() {
        return this.f1861a.b().equals(g.STATE_PAIRED);
    }

    public boolean p() {
        return this.f1861a.b().equals(g.STATE_PREVIEW);
    }

    public boolean t() {
        return this.f1861a.b().equals(g.STATE_TEST_MODE);
    }

    public synchronized void w() {
        v();
        u();
        this.f1861a.a(g.STATE_NOT_PAIRED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(@Nullable i iVar) {
        StringBuilder sb = new StringBuilder();
        if (iVar != null) {
            sdk.pendo.io.x7.c a2 = iVar.a();
            if (a2 != null) {
                sb.append("lastEvent: ").append(a2.name()).append("\n");
            }
            h b2 = iVar.b();
            if (b2 != null) {
                sb.append("state: ").append(b2.name());
            }
        }
        return sb.toString();
    }

    private void b(e eVar) {
        Object obj = eVar.x0;
        if (obj == null) {
            return;
        }
        String obj2 = obj.toString();
        PendoLogger.d("StateFSM - Got json from socket: " + obj2, new Object[0]);
        if (TextUtils.isEmpty(obj2)) {
            return;
        }
        TestModeDetails testModeDetails = (TestModeDetails) PendoInternal.l.a(obj2, TestModeDetails.class);
        if (!a(testModeDetails)) {
            PendoLogger.i("init model is null", new Object[0]);
            return;
        }
        GuidesManager.INSTANCE.activateNonSessionGuide(testModeDetails.data);
        if (GuidesActionsManager.isInited()) {
            return;
        }
        GuidesActionsManager.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(i iVar) {
        try {
            PendoLogger.d("StateFSM - Entered Paired mode", new Object[0]);
            if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                PendoLogger.d("StateFSM - last event was update pair mode", new Object[0]);
            } else if (d.EVENT_TEST_MODE_EXIT.equals(iVar.a())) {
                PendoLogger.d("StateFSM - last event was test mode exit...", new Object[0]);
            } else {
                PendoLogger.d("StateFSM - Mobile is now paired", new Object[0]);
                i.onNext(Boolean.TRUE);
            }
        } catch (Exception e2) {
            PendoLogger.e(e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(i iVar) {
        try {
            v();
            j.onNext(Boolean.FALSE);
            PendoLogger.d("StateFSM - Leaving test mode mode.", new Object[0]);
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), a(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(i iVar) {
        Runnable runnable;
        try {
            PendoLogger.d("StateFSM - Entered capture mode.", new Object[0]);
            if (d.EVENT_CAPTURE_MODE_SCREEN_CAPTURED.equals(iVar.a())) {
                PendoLogger.d("StateFSM - last event was screen captured.", new Object[0]);
                RunnableC0277a runnableC0277a = new RunnableC0277a();
                this.d = runnableC0277a;
                this.c.postDelayed(runnableC0277a, 20000L);
                return;
            }
            if (!d.EVENT_CAPTURE_MODE_SCREEN_RECEIVED.equals(iVar.a())) {
                if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                    a((e) iVar);
                    return;
                } else {
                    GuidesManager.INSTANCE.activateNonSessionGuide(null);
                    h.onNext(Boolean.TRUE);
                    return;
                }
            }
            PendoLogger.d("StateFSM - last event was screen received.", new Object[0]);
            Handler handler = this.c;
            if (handler != null && (runnable = this.d) != null) {
                handler.removeCallbacks(runnable);
            }
            sdk.pendo.io.z8.a.b();
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), a(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(i iVar) {
        try {
            if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                a((e) iVar);
                return;
            }
            GuidesManager.INSTANCE.activateNonSessionGuide(null);
            m.onNext(Boolean.TRUE);
            PendoLogger.d("StateFSM - UI requests preview on device.", new Object[0]);
            c((e) iVar);
        } catch (Exception e2) {
            PendoLogger.e(e2, e2.getMessage(), a(iVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(i iVar) {
        PendoLogger.d("StateFSM - exiting STATE_PREVIEW", new Object[0]);
        GuidesManager.INSTANCE.activateSessionGuides();
        m.onNext(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(i iVar) {
        PendoLogger.d("StateFSM - In Debug Mode.", new Object[0]);
        l.onNext(Boolean.TRUE);
        sdk.pendo.io.p8.a.d().e(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(i iVar) {
        PendoLogger.d("StateFSM - Leaving Debug Mode.", new Object[0]);
        l.onNext(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(final i iVar) {
        try {
            PendoLogger.d("StateFSM - Mobile in test mode.", new Object[0]);
            if (d.EVENT_PAIR_MODE_UPDATE.equals(iVar.a())) {
                a((e) iVar);
                return;
            }
            if (VisualGuidesManager.getInstance().isAnyGuideShowing()) {
                GuidesActionsManager.getInstance().dismissVisibleGuides();
            }
            j.onNext(Boolean.TRUE);
            try {
                VisualGuidesManager.getInstance().getIsFullScreenGuideShowingObservable().a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda0
                    @Override // sdk.pendo.io.d6.j
                    public final boolean test(Object obj) {
                        boolean a2;
                        a2 = a.a((Boolean) obj);
                        return a2;
                    }
                }).f().a(sdk.pendo.io.d9.b.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.y8.a$$ExternalSyntheticLambda2
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        a.this.a(iVar, (Boolean) obj);
                    }
                }, "SocketEventFSM full screen guide showing observer"));
            } catch (Exception e2) {
                sdk.pendo.io.g9.d.a(d.b.ERROR_REASON_ENTER_TEST_MODE, e2.getMessage(), new Object[0]);
            }
        } catch (Exception e3) {
            PendoLogger.e(e3, e3.getMessage(), a(iVar));
        }
    }

    public static JSONObject a(JSONObject jSONObject) {
        String optString = jSONObject.optString("data");
        try {
            String validate = JsonWebTokenValidator.INSTANCE.validate(optString);
            if (validate == null) {
                throw new external.sdk.pendo.io.jose4j.jwt.consumer.c("Socket cannot validate data = '" + optString + "'.", null, null);
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.toString());
            jSONObject2.put("data", new JSONObject(validate));
            return jSONObject2;
        } catch (JSONException e2) {
            PendoLogger.e(e2, e2.getMessage(), new Object[0]);
            throw new external.sdk.pendo.io.jose4j.jwt.consumer.c("Something went wrong, response = '" + jSONObject + "'.", null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(i iVar) {
        PendoLogger.d("StateFSM - Mobile not paired", new Object[0]);
        i.onNext(Boolean.FALSE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0049 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(sdk.pendo.io.y8.a.e r5) {
        /*
            r4 = this;
            sdk.pendo.io.n8.c r0 = sdk.pendo.io.n8.c.g()
            android.app.Activity r0 = r0.f()
            if (r0 != 0) goto L21
            r5 = 0
            java.lang.Object[] r0 = new java.lang.Object[r5]
            java.lang.String r1 = "Activity is null! Not displaying preview."
            sdk.pendo.io.logging.PendoLogger.e(r1, r0)
            sdk.pendo.io.c8.d$b r0 = sdk.pendo.io.c8.d.b.ERROR_REASON_RUN_PREVIEW_GUIDE
            java.lang.Object[] r2 = new java.lang.Object[r5]
            sdk.pendo.io.g9.d.a(r0, r1, r2)
            sdk.pendo.io.y8.a$d r0 = sdk.pendo.io.y8.a.d.EVENT_PREVIEW_DISPLAYED
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r4.a(r0, r5)
            return
        L21:
            java.lang.Object r1 = sdk.pendo.io.y8.a.e.m3244$$Nest$fgetx0(r5)
            boolean r2 = r1 instanceof org.json.JSONObject
            if (r2 == 0) goto L46
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch: org.json.JSONException -> L36
            java.lang.String r2 = "data"
            java.lang.Object r1 = r1.get(r2)     // Catch: org.json.JSONException -> L36
            java.lang.String r5 = r1.toString()     // Catch: org.json.JSONException -> L36
            goto L47
        L36:
            r1 = move-exception
            java.lang.String r2 = r1.getMessage()
            java.lang.String r5 = a(r5)
            java.lang.Object[] r5 = new java.lang.Object[]{r5}
            sdk.pendo.io.logging.PendoLogger.e(r1, r2, r5)
        L46:
            r5 = 0
        L47:
            if (r5 != 0) goto L4a
            return
        L4a:
            external.sdk.pendo.io.gson.Gson r1 = sdk.pendo.io.PendoInternal.l
            java.lang.Class<sdk.pendo.io.models.StepGuideModel> r2 = sdk.pendo.io.models.StepGuideModel.class
            java.lang.Object r5 = r1.a(r5, r2)
            sdk.pendo.io.models.StepGuideModel r5 = (sdk.pendo.io.models.StepGuideModel) r5
            r4.e = r5
            boolean r5 = sdk.pendo.io.actions.GuidesActionsManager.isInited()
            if (r5 != 0) goto L5f
            sdk.pendo.io.actions.GuidesActionsManager.init()
        L5f:
            sdk.pendo.io.models.GuideModel r5 = new sdk.pendo.io.models.GuideModel
            sdk.pendo.io.models.StepGuideModel r1 = r4.e
            r5.<init>(r1)
            java.util.List r5 = r5.getImages()
            sdk.pendo.io.actions.GuidePreparationManagerInterface r1 = sdk.pendo.io.actions.GuidePreparationManager.getInstance()
            int r2 = r5.size()
            java.lang.String r3 = "PREVIEW_GUIDE_STEP_ID"
            r1.prepareGuideImages(r2, r3)
            sdk.pendo.io.actions.GuidePreparationManagerInterface r1 = sdk.pendo.io.actions.GuidePreparationManager.getInstance()
            r1.fetchImages(r3, r5)
            sdk.pendo.io.y8.a$c r5 = new sdk.pendo.io.y8.a$c
            r5.<init>()
            r0.runOnUiThread(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y8.a.c(sdk.pendo.io.y8.a$e):void");
    }

    private void a(e eVar) {
        String obj = eVar.x0.toString();
        if (TextUtils.isEmpty(obj)) {
            return;
        }
    }

    public static synchronized void b(Boolean bool) {
        synchronized (a.class) {
            k.onNext(bool);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Boolean bool) {
        return !bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(i iVar, Boolean bool) {
        b((e) iVar);
    }

    public boolean a(sdk.pendo.io.x7.c cVar, Object... objArr) {
        boolean a2;
        synchronized (g) {
            PendoLogger.i("Flow: " + this.b.toString() + " Current: " + c() + " Event: " + cVar.name(), new Object[0]);
            e eVar = this.f1861a;
            eVar.x0 = null;
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) obj;
                    try {
                        eVar.x0 = a(jSONObject);
                    } catch (external.sdk.pendo.io.jose4j.jwt.consumer.c unused) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null || optJSONObject.length() != 0) {
                            PendoLogger.e("JWT is not valid data = '" + optJSONObject + "'.", new Object[0]);
                        } else {
                            this.f1861a.x0 = jSONObject;
                        }
                    } catch (Exception unused2) {
                        PendoLogger.i("Invalid event: " + cVar.name() + " message: '" + objArr[0] + "'.", new Object[0]);
                    }
                }
            }
            a2 = this.b.a(cVar, (sdk.pendo.io.x7.c) this.f1861a);
        }
        return a2;
    }

    private boolean a(TestModeDetails testModeDetails) {
        return (testModeDetails == null || testModeDetails.data == null) ? false : true;
    }
}
