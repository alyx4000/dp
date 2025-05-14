package sdk.pendo.io.q9;

import android.view.KeyEvent;
import android.view.View;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g9.x;
import sdk.pendo.io.views.custom.PendoBackCapture;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u0016\u0010\f\u001a\u0004\u0018\u00010\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lsdk/pendo/io/q9/a;", "Landroid/view/View$OnKeyListener;", "Landroid/view/View;", "v", "", "keyCode", "Landroid/view/KeyEvent;", "event", "", "onKey", "a", "Landroid/view/View$OnKeyListener;", "originalKeyListener", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/views/custom/PendoBackCapture;", "b", "Ljava/lang/ref/WeakReference;", "pendoBackCaptureRef", "tempOriginalKeyListener", "pendoBackCapture", "<init>", "(Landroid/view/View$OnKeyListener;Lsdk/pendo/io/views/custom/PendoBackCapture;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View.OnKeyListener originalKeyListener;

    /* renamed from: b, reason: from kotlin metadata */
    private final WeakReference<PendoBackCapture> pendoBackCaptureRef;

    public a(View.OnKeyListener onKeyListener, PendoBackCapture pendoBackCapture) {
        this.pendoBackCaptureRef = new WeakReference<>(pendoBackCapture);
        this.originalKeyListener = onKeyListener instanceof a ? null : onKeyListener;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        PendoBackCapture pendoBackCapture;
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.isCanceled()) {
            View.OnKeyListener onKeyListener = this.originalKeyListener;
            if (onKeyListener != null) {
                return onKeyListener.onKey(v, keyCode, event);
            }
            return false;
        }
        if (event.getAction() == 0 && keyCode == 4) {
            event.startTracking();
        }
        if (event.getAction() == 1 && keyCode == 4 && (pendoBackCapture = this.pendoBackCaptureRef.get()) != null) {
            pendoBackCapture.sendBackButtonPressedAnalytic();
        }
        if (keyCode == 24 && sdk.pendo.io.y8.a.d().g()) {
            x.b();
        }
        View.OnKeyListener onKeyListener2 = this.originalKeyListener;
        if (onKeyListener2 != null) {
            return onKeyListener2.onKey(v, keyCode, event);
        }
        return false;
    }
}
