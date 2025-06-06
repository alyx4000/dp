package expo.modules.devmenu;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import expo.interfaces.devmenu.DevMenuPreferencesInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DevMenuDefaultPreferences.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u001c"}, d2 = {"Lexpo/modules/devmenu/DevMenuDefaultPreferences;", "Lexpo/interfaces/devmenu/DevMenuPreferencesInterface;", "()V", "<anonymous parameter 0>", "", "isOnboardingFinished", "()Z", "setOnboardingFinished", "(Z)V", "keyCommandsEnabled", "getKeyCommandsEnabled", "setKeyCommandsEnabled", "motionGestureEnabled", "getMotionGestureEnabled", "setMotionGestureEnabled", "showsAtLaunch", "getShowsAtLaunch", "setShowsAtLaunch", "touchGestureEnabled", "getTouchGestureEnabled", "setTouchGestureEnabled", "methodUnavailable", "", "serialize", "Lcom/facebook/react/bridge/WritableMap;", "setPreferences", "settings", "Lcom/facebook/react/bridge/ReadableMap;", "expo-dev-menu_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class DevMenuDefaultPreferences implements DevMenuPreferencesInterface {
    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getKeyCommandsEnabled() {
        return true;
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getMotionGestureEnabled() {
        return true;
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getShowsAtLaunch() {
        return false;
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean getTouchGestureEnabled() {
        return true;
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public boolean isOnboardingFinished() {
        return true;
    }

    private final void methodUnavailable() {
        throw new NoSuchMethodError("You cannot change the default settings. Export `DevMenuSettings` module if you want to change the settings.");
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setMotionGestureEnabled(boolean z) {
        methodUnavailable();
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setTouchGestureEnabled(boolean z) {
        methodUnavailable();
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setKeyCommandsEnabled(boolean z) {
        methodUnavailable();
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setShowsAtLaunch(boolean z) {
        methodUnavailable();
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setOnboardingFinished(boolean z) {
        methodUnavailable();
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public WritableMap serialize() {
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("motionGestureEnabled", getMotionGestureEnabled());
        createMap.putBoolean("touchGestureEnabled", getTouchGestureEnabled());
        createMap.putBoolean("keyCommandsEnabled", getKeyCommandsEnabled());
        createMap.putBoolean("showsAtLaunch", getShowsAtLaunch());
        createMap.putBoolean("isOnboardingFinished", isOnboardingFinished());
        Intrinsics.checkNotNullExpressionValue(createMap, "createMap()\n      .apply…boardingFinished)\n      }");
        return createMap;
    }

    @Override // expo.interfaces.devmenu.DevMenuPreferencesInterface
    public void setPreferences(ReadableMap settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        methodUnavailable();
    }
}
