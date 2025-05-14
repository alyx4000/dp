package com.socure.idplus.device;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.socure.idplus.device.internal.t;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final WeakHashMap f546a = new WeakHashMap();
    public int b;
    public boolean c;
    public boolean d;

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        com.socure.idplus.device.internal.a aVar;
        String str;
        String str2;
        SigmaDeviceOptions sigmaDeviceOptions;
        SigmaDeviceOptions sigmaDeviceOptions2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.socure.idplus.device.internal.common.utils.a.a("SocureLifecycleCallbacks", "onActivityCreated " + activity);
        if (this.b <= 0) {
            aVar = SigmaDevice.d;
            if (aVar == null) {
                this.b = 0;
                this.c = false;
                this.d = false;
                this.f546a.clear();
                str = SigmaDevice.b;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sdkKey");
                    str2 = null;
                } else {
                    str2 = str;
                }
                sigmaDeviceOptions = SigmaDevice.c;
                if (sigmaDeviceOptions == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("options");
                    sigmaDeviceOptions2 = null;
                } else {
                    sigmaDeviceOptions2 = sigmaDeviceOptions;
                }
                SigmaDevice.d = new t(activity, str2, sigmaDeviceOptions2, null, 120);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        com.socure.idplus.device.internal.a aVar;
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.socure.idplus.device.internal.common.utils.a.a("SocureLifecycleCallbacks", "onActivityDestroyed " + activity);
        if (this.b <= 0) {
            this.b = 0;
            this.c = false;
            this.d = false;
            this.f546a.clear();
            aVar = SigmaDevice.d;
            if (aVar != null) {
                ((t) aVar).b();
            }
            SigmaDevice.d = null;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        com.socure.idplus.device.internal.a aVar;
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.socure.idplus.device.internal.common.utils.a.a("SocureLifecycleCallbacks", "onActivityPaused " + activity);
        aVar = SigmaDevice.d;
        if (aVar != null) {
            ((t) aVar).a(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        com.socure.idplus.device.internal.a aVar;
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.socure.idplus.device.internal.common.utils.a.a("SocureLifecycleCallbacks", "onActivityResumed " + activity);
        aVar = SigmaDevice.d;
        if (aVar != null) {
            ((t) aVar).b(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        com.socure.idplus.device.internal.common.utils.a.a("SocureLifecycleCallbacks", "onActivitySaveInstanceState " + activity);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r0 = com.socure.idplus.device.SigmaDevice.d;
     */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityStarted(android.app.Activity r3) {
        /*
            r2 = this;
            java.lang.String r0 = "activity"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "onActivityStarted "
            r0.<init>(r1)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "SocureLifecycleCallbacks"
            com.socure.idplus.device.internal.common.utils.a.a(r1, r0)
            java.util.WeakHashMap r0 = r2.f546a
            boolean r0 = r0.containsKey(r3)
            if (r0 != 0) goto L53
            java.util.WeakHashMap r0 = r2.f546a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r0.put(r3, r1)
            boolean r0 = r2.d
            r1 = 1
            if (r0 != 0) goto L32
            int r0 = r2.b
            int r0 = r0 + r1
            r2.b = r0
        L32:
            int r0 = r2.b
            if (r0 != r1) goto L45
            boolean r0 = r2.c
            if (r0 == 0) goto L45
            com.socure.idplus.device.internal.a r0 = com.socure.idplus.device.SigmaDevice.access$getSocureInternal$p()
            if (r0 == 0) goto L45
            com.socure.idplus.device.internal.t r0 = (com.socure.idplus.device.internal.t) r0
            r0.c()
        L45:
            r0 = 0
            r2.c = r0
            com.socure.idplus.device.internal.a r0 = com.socure.idplus.device.SigmaDevice.access$getSocureInternal$p()
            if (r0 == 0) goto L53
            com.socure.idplus.device.internal.t r0 = (com.socure.idplus.device.internal.t) r0
            r0.c(r3)
        L53:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.idplus.device.a.onActivityStarted(android.app.Activity):void");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        com.socure.idplus.device.internal.a aVar;
        com.socure.idplus.device.internal.a aVar2;
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.socure.idplus.device.internal.common.utils.a.a("SocureLifecycleCallbacks", "onActivityStopped " + activity);
        if (this.f546a.containsKey(activity)) {
            this.d = activity.isChangingConfigurations();
            this.f546a.remove(activity);
            if (!this.d) {
                this.b--;
            }
            aVar = SigmaDevice.d;
            if (aVar != null) {
                ((t) aVar).d(activity);
            }
            if (this.b <= 0) {
                aVar2 = SigmaDevice.d;
                if (aVar2 != null) {
                    ((t) aVar2).a();
                }
                this.c = true;
            }
        }
    }
}
