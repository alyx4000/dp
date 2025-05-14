package com.socure.idplus.device.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import com.socure.idplus.device.SigmaDeviceOptions;
import com.socure.idplus.device.callback.SessionTokenCallback;
import com.socure.idplus.device.callback.SigmaDeviceCallback;
import com.socure.idplus.device.error.SigmaDeviceError;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.Behavioral;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.SigmaDeviceConfigResponse;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
public final class t implements a {

    /* renamed from: a, reason: collision with root package name */
    public final String f614a;
    public final SigmaDeviceOptions b;
    public final com.socure.idplus.device.internal.thread.b c;
    public final com.socure.idplus.device.internal.sigmaDeviceConfig.manager.f d;
    public final com.socure.idplus.device.internal.input.i e;
    public final WeakReference f;
    public final com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f g;
    public final com.socure.idplus.device.internal.sigmaDeviceSession.manager.e h;
    public com.socure.idplus.device.internal.behavior.manager.g i;
    public final com.socure.idplus.device.internal.sigmaDeviceV2.manager.c j;
    public final com.socure.idplus.device.internal.sharedPrefs.a k;
    public final com.socure.idplus.device.internal.api.b l;
    public final com.socure.idplus.device.internal.utils.d m;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ t(android.content.Context r11, java.lang.String r12, com.socure.idplus.device.SigmaDeviceOptions r13, com.socure.idplus.device.callback.SigmaDeviceCallback r14, int r15) {
        /*
            r10 = this;
            r0 = r15 & 8
            r1 = 0
            if (r0 == 0) goto L7
            r6 = r1
            goto L8
        L7:
            r6 = r14
        L8:
            r14 = r15 & 16
            if (r14 == 0) goto L13
            com.socure.idplus.device.internal.thread.c r14 = new com.socure.idplus.device.internal.thread.c
            r14.<init>()
            r7 = r14
            goto L14
        L13:
            r7 = r1
        L14:
            r14 = r15 & 32
            if (r14 == 0) goto L1f
            com.socure.idplus.device.internal.sigmaDeviceConfig.manager.f r14 = new com.socure.idplus.device.internal.sigmaDeviceConfig.manager.f
            r14.<init>(r7)
            r8 = r14
            goto L20
        L1f:
            r8 = r1
        L20:
            r14 = r15 & 64
            if (r14 == 0) goto L29
            com.socure.idplus.device.internal.input.i r1 = new com.socure.idplus.device.internal.input.i
            r1.<init>()
        L29:
            r9 = r1
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.idplus.device.internal.t.<init>(android.content.Context, java.lang.String, com.socure.idplus.device.SigmaDeviceOptions, com.socure.idplus.device.callback.SigmaDeviceCallback, int):void");
    }

    public static final void a(t tVar, SigmaDeviceError sigmaDeviceError, String str, SessionTokenCallback sessionTokenCallback) {
        tVar.getClass();
        com.socure.idplus.device.internal.common.utils.a.a("SocureInternal", str);
        if (sessionTokenCallback != null) {
            sessionTokenCallback.onError(sigmaDeviceError, str);
        }
    }

    public final void b(Activity context) {
        Intrinsics.checkNotNullParameter(context, "activity");
        com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f fVar = this.g;
        fVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        com.socure.idplus.device.internal.sigmaDeviceLocation.monitor.a aVar = fVar.c;
        aVar.getClass();
        Intrinsics.checkNotNullParameter(context, "context");
        if (aVar.f603a) {
            com.socure.idplus.device.internal.permission.b bVar = com.socure.idplus.device.internal.permission.b.f584a;
            if (com.socure.idplus.device.internal.permission.a.a(context)) {
                aVar.f603a = false;
                this.d.a(context, this.l.a(), this.f614a, new l(this, new n(this), context), new m(this));
            }
        }
        this.m.a(context);
    }

    public final void c(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        if (window != null) {
            com.socure.idplus.device.internal.input.i iVar = this.e;
            iVar.getClass();
            Intrinsics.checkNotNullParameter(window, "window");
            if (iVar.c && !iVar.f567a.containsKey(window)) {
                iVar.f567a.put(window, Boolean.TRUE);
                com.socure.idplus.device.internal.input.h hVar = iVar.b;
                if (hVar != null) {
                    ((com.socure.idplus.device.internal.behavior.manager.g) hVar).a(window);
                }
            }
        }
    }

    public final void d(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        if (window != null) {
            com.socure.idplus.device.internal.input.i iVar = this.e;
            iVar.getClass();
            Intrinsics.checkNotNullParameter(window, "window");
            if (iVar.c && iVar.f567a.containsKey(window)) {
                iVar.f567a.remove(window);
                com.socure.idplus.device.internal.input.h hVar = iVar.b;
                if (hVar != null) {
                    ((com.socure.idplus.device.internal.behavior.manager.g) hVar).b(window);
                }
            }
        }
    }

    public t(Context context, String sdkKey, SigmaDeviceOptions sigmaDeviceOptions, SigmaDeviceCallback sigmaDeviceCallback, com.socure.idplus.device.internal.thread.b socureThread, com.socure.idplus.device.internal.sigmaDeviceConfig.manager.f configManager, com.socure.idplus.device.internal.input.i windowManager) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sdkKey, "sdkKey");
        Intrinsics.checkNotNullParameter(sigmaDeviceOptions, "sigmaDeviceOptions");
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        this.f614a = sdkKey;
        this.b = sigmaDeviceOptions;
        this.c = socureThread;
        this.d = configManager;
        this.e = windowManager;
        this.g = new com.socure.idplus.device.internal.sigmaDeviceLocation.manager.f(socureThread);
        this.h = new com.socure.idplus.device.internal.sigmaDeviceSession.manager.e();
        this.j = new com.socure.idplus.device.internal.sigmaDeviceV2.manager.c();
        this.k = new com.socure.idplus.device.internal.sharedPrefs.a(context);
        com.socure.idplus.device.internal.api.b bVar = new com.socure.idplus.device.internal.api.b(sigmaDeviceOptions.getUseSocureGov());
        this.l = bVar;
        this.m = new com.socure.idplus.device.internal.utils.d();
        this.f = new WeakReference(context);
        ((com.socure.idplus.device.internal.thread.c) socureThread).start();
        configManager.a(context, bVar.a(), sdkKey, new c(sigmaDeviceCallback, this, context), new d(this));
    }

    public final void a(Context context, SigmaDeviceConfigResponse config) {
        float random = RangesKt.random(new IntRange(0, 100), Random.INSTANCE) / 100.0f;
        if (!config.isBehaviorEnabled() || random > config.getBehavioral().getSampleRate()) {
            com.socure.idplus.device.internal.input.i iVar = this.e;
            iVar.c = false;
            iVar.f567a.clear();
            return;
        }
        Behavioral behavioral = config.getBehavioral();
        com.socure.idplus.device.internal.api.b bVar = this.l;
        bVar.getClass();
        Intrinsics.checkNotNullParameter(config, "config");
        com.socure.idplus.device.internal.api.a aVar = bVar.d;
        if (aVar == null) {
            aVar = com.socure.idplus.device.internal.api.b.a(config.getBehavioral().getHost());
            bVar.d = aVar;
        }
        com.socure.idplus.device.internal.behavior.manager.g gVar = new com.socure.idplus.device.internal.behavior.manager.g(context, behavioral, aVar, this.e, this.c);
        this.i = gVar;
        this.h.a(this.k, this.l.a(config), this.f614a, new e(gVar), new f(gVar, this));
    }

    public final void c() {
        com.socure.idplus.device.internal.common.utils.a.a("SocureInternal", "onForeground()");
        com.socure.idplus.device.internal.behavior.manager.g gVar = this.i;
        if (gVar == null || gVar.d == com.socure.idplus.device.internal.behavior.a.f549a) {
            return;
        }
        com.socure.idplus.device.internal.common.utils.a.a("DeviceBehaviorManager", "onForeground");
        gVar.d = com.socure.idplus.device.internal.behavior.a.c;
        gVar.c.b();
        com.socure.idplus.device.internal.thread.c cVar = (com.socure.idplus.device.internal.thread.c) gVar.b;
        cVar.getClass();
        Message obtain = Message.obtain();
        obtain.what = 8;
        obtain.obj = null;
        Handler handler = cVar.f615a;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public final void a(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void b() {
        com.socure.idplus.device.internal.common.utils.a.a("SocureInternal", "onDestroy()");
        com.socure.idplus.device.internal.sigmaDeviceSession.manager.e eVar = this.h;
        eVar.d = null;
        eVar.c.clear();
        eVar.b = false;
        com.socure.idplus.device.internal.behavior.manager.g gVar = this.i;
        if (gVar != null) {
            gVar.a();
        }
        ((com.socure.idplus.device.internal.thread.c) this.c).a();
        com.socure.idplus.device.internal.api.b bVar = this.l;
        bVar.b = null;
        bVar.c = null;
        bVar.d = null;
    }

    public final void a() {
        com.socure.idplus.device.internal.common.utils.a.a("SocureInternal", "onBackground()");
        com.socure.idplus.device.internal.behavior.manager.g gVar = this.i;
        if (gVar == null || gVar.d == com.socure.idplus.device.internal.behavior.a.f549a) {
            return;
        }
        com.socure.idplus.device.internal.common.utils.a.a("DeviceBehaviorManager", "onBackground");
        com.socure.idplus.device.internal.input.manager.a aVar = gVar.c;
        aVar.getClass();
        com.socure.idplus.device.internal.common.utils.a.a("SocureInputHandler", "Stopping producers");
        aVar.b.c = false;
        aVar.c.c = false;
        aVar.d.c = false;
        aVar.e.c = false;
        com.socure.idplus.device.internal.thread.c cVar = (com.socure.idplus.device.internal.thread.c) gVar.b;
        cVar.getClass();
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = null;
        Handler handler = cVar.f615a;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
        gVar.d = com.socure.idplus.device.internal.behavior.a.b;
    }
}
