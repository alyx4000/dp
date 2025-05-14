package sdk.pendo.io.sdk.xamarin;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/sdk/xamarin/XamarinFlyoutPageListener;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "createPendoDrawerListenerIfNeeded", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "onDrawerClosed", "", "onDrawerOpen", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class XamarinFlyoutPageListener {
    private final String TAG = "XamarinFlyoutPageListener";

    private final PendoDrawerListener createPendoDrawerListenerIfNeeded() {
        WeakReference<PendoDrawerListener> e = PendoInternal.x().e();
        PendoDrawerListener pendoDrawerListener = e != null ? e.get() : null;
        if (pendoDrawerListener != null) {
            return pendoDrawerListener;
        }
        PendoLogger.d(this.TAG + " createPendoDrawerListenerIfNeeded -> pendoDrawerListener is null, creating a new one.", new Object[0]);
        PendoDrawerListener pendoDrawerListener2 = new PendoDrawerListener(null);
        PendoInternal.x().a(new WeakReference<>(pendoDrawerListener2));
        return pendoDrawerListener2;
    }

    public final void onDrawerClosed() {
        createPendoDrawerListenerIfNeeded().setIsDrawerOpened(false);
    }

    public final void onDrawerOpen() {
        createPendoDrawerListenerIfNeeded().setIsDrawerOpened(true);
    }
}
