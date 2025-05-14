package external.sdk.pendo.io.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
class t {

    /* renamed from: a, reason: collision with root package name */
    private boolean f676a;
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((sdk.pendo.io.t.c) message.obj).recycle();
            return true;
        }
    }

    t() {
    }

    synchronized void a(sdk.pendo.io.t.c<?> cVar, boolean z) {
        if (!this.f676a && !z) {
            this.f676a = true;
            cVar.recycle();
            this.f676a = false;
        }
        this.b.obtainMessage(1, cVar).sendToTarget();
    }
}
