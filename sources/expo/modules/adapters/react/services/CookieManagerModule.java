package expo.modules.adapters.react.services;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.network.ForwardingCookieHandler;
import expo.modules.core.interfaces.InternalModule;
import java.net.CookieHandler;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class CookieManagerModule extends ForwardingCookieHandler implements InternalModule, NativeModule {
    private static final String TAG = "CookieManagerModule";

    @Override // com.facebook.react.bridge.NativeModule
    public boolean canOverrideExistingModule() {
        return false;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return null;
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
    }

    @Override // com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
    }

    public CookieManagerModule(ReactContext reactContext) {
        super(reactContext);
    }

    @Override // expo.modules.core.interfaces.InternalModule
    public List<Class> getExportedInterfaces() {
        return Collections.singletonList(CookieHandler.class);
    }
}
