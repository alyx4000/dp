package expo.modules.devmenu.react;

import android.util.Log;
import com.facebook.fbreact.specs.NativeDevMenuSpec;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.modules.devmenu.helpers.DevMenuReflectionExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuShakeDetectorListenerSwapper.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lexpo/modules/devmenu/react/DevMenuShakeDetectorListenerSwapper;", "", "()V", "swapShakeDetectorListener", "", "reactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "newListener", "Lcom/facebook/react/common/ShakeDetector$ShakeListener;", "expo-dev-menu_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuShakeDetectorListenerSwapper {
    public final void swapShakeDetectorListener(ReactInstanceManager reactInstanceManager, ShakeDetector.ShakeListener newListener) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        Intrinsics.checkNotNullParameter(newListener, "newListener");
        try {
            DevSupportManager devSupportManager = (DevSupportManager) DevMenuReflectionExtensionsKt.getPrivateDeclaredFieldValue(ReactInstanceManager.class, "mDevSupportManager", reactInstanceManager);
            if (devSupportManager instanceof DevSupportManagerBase) {
                DevMenuReflectionExtensionsKt.setPrivateDeclaredFieldValue(ShakeDetector.class, "mShakeListener", (ShakeDetector) DevMenuReflectionExtensionsKt.getPrivateDeclaredFieldValue(DevSupportManagerBase.class, "mShakeDetector", devSupportManager), newListener);
            }
        } catch (Exception e) {
            Log.w(NativeDevMenuSpec.NAME, "Couldn't swap shake detector listener: " + e.getMessage(), e);
        }
    }
}
