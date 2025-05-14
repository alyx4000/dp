package com.reactnativegooglesignin;

import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.common.SignInButton;
import expo.modules.devlauncher.launcher.manifest.DevLauncherUserInterface;
import java.util.Map;

/* loaded from: classes5.dex */
public class RNGoogleSigninButtonViewManager extends SimpleViewManager<SignInButton> implements RNGoogleSigninButtonManagerInterface<SignInButton> {
    public static final String MODULE_NAME = "RNGoogleSigninButton";
    private static final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.reactnativegooglesignin.RNGoogleSigninButtonViewManager$$ExternalSyntheticLambda0
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RNGoogleSigninButtonViewManager.lambda$static$0(view);
        }
    };
    private final ViewManagerDelegate<SignInButton> mDelegate = new RNGoogleSigninButtonManagerDelegate(this);

    @Override // com.facebook.react.uimanager.ViewManager
    protected ViewManagerDelegate<SignInButton> getDelegate() {
        return null;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return MODULE_NAME;
    }

    static /* synthetic */ void lambda$static$0(View view) {
        ReactContext reactContext = (ReactContext) view.getContext();
        int id = view.getId();
        UIManagerHelper.getEventDispatcherForReactTag(reactContext, id).dispatchEvent(new SigninButtonEvent(UIManagerHelper.getSurfaceId(reactContext), id));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put(SigninButtonEvent.EVENT_NAME, MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onPress"))).build();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public SignInButton createViewInstance(ThemedReactContext themedReactContext) {
        return new SignInButton(themedReactContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(ThemedReactContext themedReactContext, SignInButton signInButton) {
        signInButton.setOnClickListener(mOnClickListener);
    }

    @Override // com.reactnativegooglesignin.RNGoogleSigninButtonManagerInterfaceCopy
    @ReactProp(name = "size")
    public void setSize(SignInButton signInButton, int i) {
        signInButton.setSize(i);
    }

    @Override // com.reactnativegooglesignin.RNGoogleSigninButtonManagerInterfaceCopy
    @ReactProp(name = "disabled")
    public void setDisabled(SignInButton signInButton, boolean z) {
        signInButton.setEnabled(!z);
    }

    @Override // com.reactnativegooglesignin.RNGoogleSigninButtonManagerInterfaceCopy
    @ReactProp(name = "color")
    public void setColor(SignInButton signInButton, String str) {
        if (str == null) {
            signInButton.setColorScheme(2);
        } else {
            signInButton.setColorScheme(!DevLauncherUserInterface.DARK.equals(str) ? 1 : 0);
        }
    }
}
