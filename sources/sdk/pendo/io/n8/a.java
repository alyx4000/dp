package sdk.pendo.io.n8;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.g9.f;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f1441a;
    private static final AtomicInteger b = new AtomicInteger(0);
    private static final AtomicBoolean c = new AtomicBoolean(false);
    private static volatile Boolean d = Boolean.FALSE;

    private a() {
    }

    private void a(Activity activity) {
        AtomicInteger atomicInteger = b;
        atomicInteger.decrementAndGet();
        if (!d.booleanValue() || atomicInteger.get() != 0 || activity == null || activity.isChangingConfigurations()) {
            return;
        }
        sdk.pendo.io.e9.b.e().a();
        PendoInternal.g();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        PendoLogger.i("onActivityCreated " + activity.getLocalClassName(), new Object[0]);
        if (activity.getLocalClassName().contains("PendoGateActivity")) {
            sdk.pendo.io.z8.b.a(true);
        }
        c g = c.g();
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.CREATE;
        g.c(aVar);
        b.a().a(activity, aVar);
        a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        PendoLogger.i("onActivityDestroyed " + activity.getLocalClassName(), new Object[0]);
        c.g().a(activity.getLocalClassName());
        c g = c.g();
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.DESTROY;
        g.c(aVar);
        b.a().a(activity, aVar);
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        PendoLogger.i("onActivityPaused " + activity.getLocalClassName(), new Object[0]);
        c g = c.g();
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.PAUSE;
        g.c(aVar);
        c.g().b(activity);
        sdk.pendo.io.e9.b.e().a(activity.getClass().getName());
        b.a().a(activity, aVar);
        f.c(activity.getApplicationContext());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        a(activity, false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        PendoLogger.i(activity.getLocalClassName(), new Object[0]);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        PendoLogger.i("onActivityStarted " + activity.getLocalClassName(), new Object[0]);
        sdk.pendo.io.e9.b.e().b();
        c g = c.g();
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.START;
        g.c(aVar);
        b.a().a(activity, aVar);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        PendoLogger.i("onActivityStopped " + activity.getLocalClassName(), new Object[0]);
        c g = c.g();
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.STOP;
        g.c(aVar);
        b.a().a(activity, aVar);
    }

    public static synchronized a a(Pendo.PendoOptions pendoOptions) {
        a aVar;
        synchronized (a.class) {
            if (f1441a == null) {
                f1441a = new a();
                d = Boolean.valueOf(pendoOptions.getEnableAutoSessionEndDetection());
            }
            aVar = f1441a;
        }
        return aVar;
    }

    private void a() {
        b.incrementAndGet();
    }

    public void a(Activity activity, boolean z) {
        PendoLogger.i("onActivityResumed " + activity.getLocalClassName(), new Object[0]);
        Activity f = c.g().f();
        AtomicBoolean atomicBoolean = c;
        if (atomicBoolean.getAndSet(false) && f != null && f == activity) {
            return;
        }
        c.g().a(activity);
        c g = c.g();
        sdk.pendo.io.f7.a aVar = sdk.pendo.io.f7.a.RESUME;
        g.c(aVar);
        b.a().a(activity, aVar);
        f.b(activity.getApplicationContext());
        atomicBoolean.set(z);
    }
}
