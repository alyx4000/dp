package sdk.pendo.io.d9;

import android.app.Activity;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.activities.PendoGateActivity;
import sdk.pendo.io.activities.PendoGuideVisualActivity;
import sdk.pendo.io.d6.g;
import sdk.pendo.io.e9.b;
import sdk.pendo.io.g9.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.listener.FloatingListenerButton;
import sdk.pendo.io.x5.j;

/* loaded from: classes6.dex */
public final class a {
    private static final Object f = new Object();
    private static final Long g = 10L;

    /* renamed from: a, reason: collision with root package name */
    private sdk.pendo.io.b6.b f994a;
    private sdk.pendo.io.b6.b b;
    private sdk.pendo.io.b6.b c;
    private sdk.pendo.io.b6.b d;
    private j<Boolean> e;

    /* renamed from: sdk.pendo.io.d9.a$a, reason: collision with other inner class name */
    class C0114a implements g<Boolean, Boolean, Boolean, Boolean, Boolean> {
        C0114a() {
        }

        @Override // sdk.pendo.io.d6.g
        public Boolean a(Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4) {
            return Boolean.valueOf(bool.booleanValue() || bool2.booleanValue() || bool3.booleanValue() || bool4.booleanValue());
        }
    }

    class b implements sdk.pendo.io.d6.b<sdk.pendo.io.f7.a, Boolean, Boolean> {
        b() {
        }

        @Override // sdk.pendo.io.d6.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(sdk.pendo.io.f7.a aVar, Boolean bool) {
            return bool;
        }
    }

    private static class c implements sdk.pendo.io.d6.e<Object> {
        private c() {
        }

        @Override // sdk.pendo.io.d6.e
        public void accept(Object obj) {
            Activity f = sdk.pendo.io.n8.c.g().f();
            if (f == null || (f instanceof PendoGuideVisualActivity)) {
                return;
            }
            PendoInternal.x().onActivityPaused(f);
            FloatingListenerButton.Builder.removeActiveInstances();
        }
    }

    private static class d implements sdk.pendo.io.d6.e<Boolean> {
        private d() {
        }

        @Override // sdk.pendo.io.d6.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Boolean bool) {
            Activity f = sdk.pendo.io.n8.c.g().f();
            if (f == null) {
                PendoLogger.d("InsertActivityOnResumeAndEventsManagerInitedAction received null activity", new Object[0]);
                return;
            }
            if (!bool.booleanValue()) {
                PendoLogger.d("Events manager is not initiated and we got a 'onResume' event.", new Object[0]);
                return;
            }
            if ((f instanceof PendoGateActivity) || (f instanceof PendoGuideVisualActivity)) {
                PendoLogger.i(f.getClass().getSimpleName() + " started.", new Object[0]);
            } else if (sdk.pendo.io.p8.a.d().f()) {
                PendoInternal.x().onActivityResumed(f);
            }
        }
    }

    private static class e implements sdk.pendo.io.d6.e<Object> {
        private e() {
        }

        @Override // sdk.pendo.io.d6.e
        public void accept(Object obj) {
            Activity f = sdk.pendo.io.n8.c.g().f();
            if (f == null || l.a(f.getLocalClassName())) {
                return;
            }
            FloatingListenerButton.Builder.removeActiveInstances();
            if (sdk.pendo.io.z8.b.c() == null || sdk.pendo.io.y8.a.d().n()) {
                return;
            }
            new FloatingListenerButton.Builder().create();
        }
    }

    private static class f implements sdk.pendo.io.d6.e<Object> {
        private b.c A;
        private final sdk.pendo.io.t2.b f;
        private final AtomicBoolean f0;
        private long s;

        private f() {
            this.f = new sdk.pendo.io.t2.b();
            this.s = System.currentTimeMillis();
            this.A = b.c.IN_FOREGROUND;
            this.f0 = new AtomicBoolean(true);
        }

        @Override // sdk.pendo.io.d6.e
        public void accept(Object obj) {
            synchronized (a.f) {
                b.c d = sdk.pendo.io.e9.b.e().d();
                b.c cVar = b.c.IN_FOREGROUND;
                if (d == cVar && this.f0.getAndSet(false)) {
                    sdk.pendo.io.g9.d.b();
                    sdk.pendo.io.g9.d.c();
                    sdk.pendo.io.g9.d.a(cVar, 0L, this.s);
                    if (this.f.e()) {
                        this.f.g();
                    }
                    if (!this.f.d()) {
                        this.f.h();
                    }
                    this.s = System.currentTimeMillis();
                    return;
                }
                if (d != this.A) {
                    this.A = d;
                    long c = this.f.c();
                    this.f.g();
                    sdk.pendo.io.g9.d.a(d, c, this.s);
                    if (this.f.e()) {
                        this.f.g();
                    }
                    if (!this.f.d()) {
                        this.f.h();
                    }
                    this.s = System.currentTimeMillis();
                    int z = PendoInternal.z();
                    if (d == cVar && z > 0 && TimeUnit.MILLISECONDS.toSeconds(c) > z) {
                        PendoInternal.N();
                        if (this.f.e()) {
                            this.f.g();
                        }
                        if (!this.f.d()) {
                            this.f.h();
                        }
                        this.s = System.currentTimeMillis();
                    }
                }
            }
        }
    }

    public a(j<sdk.pendo.io.f7.a> jVar, j<sdk.pendo.io.f7.a> jVar2) {
        j<Boolean> j = sdk.pendo.io.y8.a.j();
        j<Boolean> m = sdk.pendo.io.y8.a.m();
        j<Boolean> q = sdk.pendo.io.y8.a.q();
        ActivationManager activationManager = ActivationManager.INSTANCE;
        j a2 = j.a(j, m, q, activationManager.isInitedObservable(), new C0114a());
        long longValue = g.longValue();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        j<Boolean> a3 = a2.a(longValue, timeUnit);
        this.e = a3;
        this.b = (sdk.pendo.io.b6.b) j.a(jVar, a3, new b()).a(sdk.pendo.io.v6.a.b()).c((j) sdk.pendo.io.d9.c.a(new d(), "PendoApplicationObservers onResumeObservable and ActivationManagerInitedObservable observer"));
        this.c = (sdk.pendo.io.b6.b) jVar2.c((j<sdk.pendo.io.f7.a>) sdk.pendo.io.d9.c.a(new c(), "PendoApplicationObservers activityOnPauseObservable"));
        this.d = (sdk.pendo.io.b6.b) j.a(jVar, sdk.pendo.io.y8.a.l(), sdk.pendo.io.y8.a.m(), sdk.pendo.io.y8.a.j(), sdk.pendo.io.y8.a.s(), sdk.pendo.io.y8.a.k(), activationManager.isInitedObservable()).c(500L, timeUnit).c((j) sdk.pendo.io.d9.c.a(new e(), "PendoApplicationObservers merged activityOnResume, isInPairedMode, isInTestMode, isInCaptureMode, isSocketConnected, isActivationManagerInited observer"));
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(Object obj) {
        return ActivationManager.INSTANCE.isInited();
    }

    public void a() {
        sdk.pendo.io.b6.b bVar = this.f994a;
        if (bVar != null && !bVar.a()) {
            this.f994a.dispose();
        }
        this.f994a = (sdk.pendo.io.b6.b) j.a(sdk.pendo.io.e9.b.e().c(), ActivationManager.INSTANCE.isInitedObservable()).a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.d9.a$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean a2;
                a2 = a.a(obj);
                return a2;
            }
        }).c((j) sdk.pendo.io.d9.c.a(new f(), "PendoApplicationObservers ActivationManagerInited and getAppFlowChanges observer"));
    }
}
