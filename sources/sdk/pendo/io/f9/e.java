package sdk.pendo.io.f9;

import android.app.Activity;
import java.util.ArrayList;
import kotlin.Metadata;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.listeners.views.PendoDrawerListener;
import sdk.pendo.io.sdk.react.PlatformStateManager;
import sdk.pendo.io.sdk.xamarin.XamarinBridge;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&JL\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J.\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&JV\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0006\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u000eH&¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/f9/e;", "", "Lsdk/pendo/io/sdk/react/PlatformStateManager;", "platformStateManager", "", "currentScreenId", "a", "Ljava/util/ArrayList;", "Lsdk/pendo/io/f9/d;", "fragmentsInfoList", "Landroid/app/Activity;", "activity", "Lsdk/pendo/io/g9/q0$b;", "rootViewData", "", "isOldScreenIdFormat", "isIgnoreDynamicFragmentsInScrollView", "Lsdk/pendo/io/listeners/views/PendoDrawerListener;", "drawerListener", "Lsdk/pendo/io/sdk/xamarin/XamarinBridge;", Pendo.PendoOptions.XAMARIN_BRIDGE, "synchronizedScan", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public interface e {
    String a(String currentScreenId, q0.b rootViewData, XamarinBridge xamarinBridge, PendoDrawerListener drawerListener);

    String a(ArrayList<d> fragmentsInfoList, Activity activity, q0.b rootViewData, boolean isOldScreenIdFormat, String currentScreenId, XamarinBridge xamarinBridge, boolean isIgnoreDynamicFragmentsInScrollView, PendoDrawerListener drawerListener);

    String a(ArrayList<d> fragmentsInfoList, Activity activity, q0.b rootViewData, boolean isOldScreenIdFormat, String currentScreenId, boolean isIgnoreDynamicFragmentsInScrollView, PendoDrawerListener drawerListener);

    String a(PlatformStateManager platformStateManager, String currentScreenId);

    void a(boolean synchronizedScan);
}
