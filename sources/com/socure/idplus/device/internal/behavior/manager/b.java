package com.socure.idplus.device.internal.behavior.manager;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.socure.idplus.device.internal.behavior.model.Events;
import com.socure.idplus.device.internal.behavior.model.FocusChangeEvent;
import com.socure.idplus.device.internal.behavior.model.InputChangeEvent;
import com.socure.idplus.device.internal.behavior.model.KeyPressEvent;
import com.socure.idplus.device.internal.behavior.model.PointerEvent;
import com.socure.idplus.device.internal.behavior.model.SessionData;
import com.socure.idplus.device.internal.behavior.model.SessionDataRequest;
import com.socure.idplus.device.internal.sigmaDeviceConfig.model.Behavioral;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b implements com.socure.idplus.device.internal.thread.a {

    /* renamed from: a, reason: collision with root package name */
    public final com.socure.idplus.device.internal.api.a f552a;
    public final com.socure.idplus.device.internal.thread.b b;
    public final Function0 c;
    public String d;
    public int e;
    public final e f;
    public final ArrayList g;
    public final ArrayList h;
    public final ArrayList i;
    public final ArrayList j;
    public final ArrayList k;
    public final long l;

    public b(Behavioral behavioralConfig, com.socure.idplus.device.internal.api.a behaviorApi, com.socure.idplus.device.internal.thread.b socureThread, f stopCaptureCallback) {
        Intrinsics.checkNotNullParameter(behavioralConfig, "behavioralConfig");
        Intrinsics.checkNotNullParameter(behaviorApi, "behaviorApi");
        Intrinsics.checkNotNullParameter(socureThread, "socureThread");
        Intrinsics.checkNotNullParameter(stopCaptureCallback, "stopCaptureCallback");
        this.f552a = behaviorApi;
        this.b = socureThread;
        this.c = stopCaptureCallback;
        this.f = new e();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = behavioralConfig.getBundleGenerationInterval() == 0 ? 1000L : behavioralConfig.getBundleGenerationInterval();
        a();
    }

    public final void b() {
        boolean z;
        List list;
        List list2;
        List list3;
        boolean z2 = true;
        List list4 = null;
        if (!this.h.isEmpty()) {
            List list5 = CollectionsKt.toList(this.h);
            this.h.clear();
            list = list5;
            z = true;
        } else {
            z = false;
            list = null;
        }
        if (!this.i.isEmpty()) {
            List list6 = CollectionsKt.toList(this.i);
            this.i.clear();
            list2 = list6;
            z = true;
        } else {
            list2 = null;
        }
        if (!this.j.isEmpty()) {
            List list7 = CollectionsKt.toList(this.j);
            this.j.clear();
            list3 = list7;
            z = true;
        } else {
            list3 = null;
        }
        if (!this.k.isEmpty()) {
            list4 = CollectionsKt.toList(this.k);
            this.k.clear();
        } else {
            z2 = z;
        }
        if (z2) {
            SessionData sessionData = new SessionData(new Events(list3, list4, list, list2));
            String str = this.d;
            if (str != null) {
                a(str, sessionData);
                return;
            }
            this.g.add(sessionData);
            if (this.g.size() > 5) {
                this.c.invoke();
            }
        }
    }

    public final void a() {
        com.socure.idplus.device.internal.thread.b bVar = this.b;
        long j = this.l;
        com.socure.idplus.device.internal.thread.c cVar = (com.socure.idplus.device.internal.thread.c) bVar;
        cVar.getClass();
        Message obtain = Message.obtain();
        obtain.what = 3;
        obtain.obj = null;
        Handler handler = cVar.f615a;
        if (handler != null) {
            handler.sendMessageDelayed(obtain, j);
        }
    }

    public final void a(FocusChangeEvent focusChangeEvent) {
        String str = "FocusChangeEvent " + focusChangeEvent;
        this.j.add(focusChangeEvent);
    }

    public final void a(InputChangeEvent inputChangeEvent) {
        String str = "InputChangeEvent " + inputChangeEvent;
        this.k.add(inputChangeEvent);
    }

    public final void a(KeyPressEvent keyPressEvent) {
        String str = "KeyPressEvent " + keyPressEvent;
        this.h.add(keyPressEvent);
    }

    public final void a(PointerEvent pointerEvent) {
        String str = "PointerEvent " + pointerEvent;
        this.i.add(pointerEvent);
    }

    public final void a(String sessionToken, SessionData sessionData) {
        this.e++;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        SessionDataRequest sessionDataRequest = new SessionDataRequest(null, null, uuid, this.e, sessionData, 3, null);
        e eVar = this.f;
        com.socure.idplus.device.internal.api.a apiClient = this.f552a;
        a onError = new a(this);
        eVar.getClass();
        Intrinsics.checkNotNullParameter(apiClient, "behaviorApi");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(sessionDataRequest, "sessionDataRequest");
        Intrinsics.checkNotNullParameter(onError, "onError");
        com.socure.idplus.device.internal.behavior.dataHandler.b bVar = eVar.f555a;
        c onSuccess = c.f553a;
        d onError2 = new d(onError);
        bVar.getClass();
        Intrinsics.checkNotNullParameter(sessionDataRequest, "sessionDataRequest");
        Intrinsics.checkNotNullParameter(apiClient, "apiClient");
        Intrinsics.checkNotNullParameter(sessionToken, "sessionToken");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(onError2, "onError");
        Log.d("BehaviorDataHandler", "Data Upload Initiated");
        com.socure.idplus.device.internal.network.c.a(new com.socure.idplus.device.internal.behavior.dataHandler.a(apiClient, com.socure.idplus.device.internal.common.utils.a.a(sessionToken), sessionDataRequest), onSuccess, onError2);
    }
}
