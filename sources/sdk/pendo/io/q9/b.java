package sdk.pendo.io.q9;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.views.custom.PendoBackCapture;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016R&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0014\u001a\n \u0011*\u0004\u0018\u00010\u00100\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lsdk/pendo/io/q9/b;", "Landroid/view/ViewTreeObserver$OnGlobalFocusChangeListener;", "Landroid/view/View;", "oldFocus", "newFocus", "", "onGlobalFocusChanged", "Ljava/lang/ref/WeakReference;", "Lsdk/pendo/io/views/custom/PendoBackCapture;", "a", "Ljava/lang/ref/WeakReference;", "getPendoBackCaptureReference", "()Ljava/lang/ref/WeakReference;", "getPendoBackCaptureReference$annotations", "()V", "pendoBackCaptureReference", "", "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "TAG", "pendoBackCapture", "<init>", "(Lsdk/pendo/io/views/custom/PendoBackCapture;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<PendoBackCapture> pendoBackCaptureReference;

    /* renamed from: b, reason: from kotlin metadata */
    private final String TAG;

    public b(PendoBackCapture pendoBackCapture) {
        Intrinsics.checkNotNullParameter(pendoBackCapture, "pendoBackCapture");
        this.pendoBackCaptureReference = new WeakReference<>(pendoBackCapture);
        this.TAG = "b";
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public void onGlobalFocusChanged(View oldFocus, View newFocus) {
        if (oldFocus != null) {
            sdk.pendo.io.p9.a.c(oldFocus);
        }
        PendoLogger.d(this.TAG + " oldFocus: " + oldFocus + " newFocus: " + newFocus, new Object[0]);
        sdk.pendo.io.p9.a.a(newFocus, this.pendoBackCaptureReference.get());
    }
}
