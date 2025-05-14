package com.socure.idplus.device.internal.thread;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import com.socure.idplus.device.internal.behavior.model.FocusChangeEvent;
import com.socure.idplus.device.internal.behavior.model.InputChangeEvent;
import com.socure.idplus.device.internal.behavior.model.KeyPressEvent;
import com.socure.idplus.device.internal.behavior.model.PointerEvent;
import com.socure.idplus.device.internal.behavior.model.SessionData;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c extends HandlerThread implements Handler.Callback, b {

    /* renamed from: a, reason: collision with root package name */
    public Handler f615a;
    public a b;

    public c() {
        super("SocureThread");
    }

    public final void a(com.socure.idplus.device.internal.behavior.manager.b handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.b = handler;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        a aVar = this.b;
        if (aVar != null) {
            int i = msg.what;
            Object obj = msg.obj;
            com.socure.idplus.device.internal.behavior.manager.b bVar = (com.socure.idplus.device.internal.behavior.manager.b) aVar;
            switch (i) {
                case 1:
                    if (obj instanceof String) {
                        String str = (String) obj;
                        bVar.d = str;
                        Iterator it = bVar.g.iterator();
                        while (it.hasNext()) {
                            bVar.a(str, (SessionData) it.next());
                        }
                        bVar.g.clear();
                        return true;
                    }
                    break;
                case 2:
                    Log.d("BehaviorSessionManager", "handleStopCapture");
                    Handler handler = ((c) bVar.b).f615a;
                    if (handler != null) {
                        handler.removeMessages(3);
                    }
                    Handler handler2 = ((c) bVar.b).f615a;
                    if (handler2 != null) {
                        handler2.removeMessages(2);
                    }
                    if (bVar.d != null) {
                        bVar.b();
                        return true;
                    }
                    bVar.g.clear();
                    bVar.h.clear();
                    bVar.i.clear();
                    bVar.j.clear();
                    bVar.k.clear();
                    return true;
                case 3:
                    bVar.b();
                    bVar.a();
                    return true;
                case 4:
                    if (obj instanceof KeyPressEvent) {
                        bVar.a((KeyPressEvent) obj);
                        return true;
                    }
                    break;
                case 5:
                    if (obj instanceof PointerEvent) {
                        bVar.a((PointerEvent) obj);
                        return true;
                    }
                    break;
                case 6:
                    if (obj instanceof FocusChangeEvent) {
                        bVar.a((FocusChangeEvent) obj);
                        return true;
                    }
                    break;
                case 7:
                    Handler handler3 = ((c) bVar.b).f615a;
                    if (handler3 != null) {
                        handler3.removeMessages(3);
                    }
                    bVar.b();
                    return true;
                case 8:
                    bVar.a();
                    return true;
                case 9:
                    if (obj instanceof InputChangeEvent) {
                        bVar.a((InputChangeEvent) obj);
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    @Override // java.lang.Thread
    public final void start() {
        super.start();
        this.f615a = new Handler(getLooper(), this);
    }

    public final void a() {
        quitSafely();
        this.f615a = null;
    }
}
