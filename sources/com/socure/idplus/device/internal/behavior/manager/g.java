package com.socure.idplus.device.internal.behavior.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.Window;
import com.socure.idplus.device.internal.input.h;
import com.socure.idplus.device.internal.input.i;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.Behavioral;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final i f557a;
    public final com.socure.idplus.device.internal.thread.b b;
    public final com.socure.idplus.device.internal.input.manager.a c;
    public com.socure.idplus.device.internal.behavior.a d;
    public final Handler e;

    public g(Context context, Behavioral behavioralConfig, com.socure.idplus.device.internal.api.a behaviorApi, i windowManager, com.socure.idplus.device.internal.thread.b socureThread) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(behavioralConfig, "behavioralConfig");
        Intrinsics.checkNotNullParameter(behaviorApi, "behaviorApi");
        Intrinsics.checkNotNullParameter(windowManager, "windowManager");
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
        this.f557a = windowManager;
        this.b = socureThread;
        this.c = new com.socure.idplus.device.internal.input.manager.a(context, socureThread);
        b bVar = new b(behavioralConfig, behaviorApi, socureThread, new f(this));
        this.d = com.socure.idplus.device.internal.behavior.a.f549a;
        this.e = new Handler(context.getMainLooper());
        ((com.socure.idplus.device.internal.thread.c) socureThread).a(bVar);
        a(behavioralConfig);
    }

    public final void a(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (this.d != com.socure.idplus.device.internal.behavior.a.c) {
            return;
        }
        com.socure.idplus.device.internal.common.utils.a.a("DeviceBehaviorManager", "onWindowAdded " + window);
        this.c.a(window);
    }

    public final void b(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        com.socure.idplus.device.internal.common.utils.a.a("DeviceBehaviorManager", "onWindowRemoved " + window);
        this.c.b(window);
    }

    public final void a(Behavioral behavioral) {
        this.e.postDelayed(new Runnable() { // from class: com.socure.idplus.device.internal.behavior.manager.g$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                g.a(g.this);
            }
        }, behavioral.getSessionDuration());
        this.d = com.socure.idplus.device.internal.behavior.a.c;
        WeakHashMap weakHashMap = this.f557a.f567a;
        ArrayList arrayList = new ArrayList(weakHashMap.size());
        Iterator it = weakHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((Window) ((Map.Entry) it.next()).getKey());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.c.a((Window) it2.next());
        }
        i iVar = this.f557a;
        iVar.getClass();
        Intrinsics.checkNotNullParameter(this, "windowListener");
        iVar.b = this;
    }

    public static final void a(g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    public final void a() {
        if (this.d == com.socure.idplus.device.internal.behavior.a.f549a) {
            return;
        }
        com.socure.idplus.device.internal.common.utils.a.a("DeviceBehaviorManager", "stopCapture");
        this.e.removeCallbacksAndMessages(null);
        com.socure.idplus.device.internal.thread.c cVar = (com.socure.idplus.device.internal.thread.c) this.b;
        cVar.getClass();
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = null;
        Handler handler = cVar.f615a;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
        WeakHashMap weakHashMap = this.f557a.f567a;
        ArrayList arrayList = new ArrayList(weakHashMap.size());
        Iterator it = weakHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((Window) ((Map.Entry) it.next()).getKey());
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            this.c.b((Window) it2.next());
        }
        i iVar = this.f557a;
        iVar.c = false;
        iVar.f567a.clear();
        com.socure.idplus.device.internal.input.manager.a aVar = this.c;
        aVar.getClass();
        com.socure.idplus.device.internal.common.utils.a.a("SocureInputHandler", "Stopping producers");
        aVar.b.c = false;
        aVar.c.c = false;
        aVar.d.c = false;
        aVar.e.c = false;
        Iterator it3 = aVar.g.iterator();
        while (it3.hasNext()) {
            ((com.socure.idplus.device.internal.input.manager.b) it3.next()).b();
        }
        this.d = com.socure.idplus.device.internal.behavior.a.f549a;
    }
}
