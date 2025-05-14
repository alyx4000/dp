package com.reactnativegooglesignin;

import com.facebook.react.TurboReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class RNGoogleSigninPackage extends TurboReactPackage {
    @Override // com.facebook.react.TurboReactPackage, com.facebook.react.ReactPackage
    public NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        if (str.equals("RNGoogleSignin")) {
            return new RNGoogleSigninModule(reactApplicationContext);
        }
        if (str.equals(NativeOneTapSignInSpec.NAME)) {
            return new RNOneTapSignInModule(reactApplicationContext);
        }
        return null;
    }

    @Override // com.facebook.react.TurboReactPackage
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        return new ReactModuleInfoProvider() { // from class: com.reactnativegooglesignin.RNGoogleSigninPackage$$ExternalSyntheticLambda0
            @Override // com.facebook.react.module.model.ReactModuleInfoProvider
            public final Map getReactModuleInfos() {
                return RNGoogleSigninPackage.lambda$getReactModuleInfoProvider$0();
            }
        };
    }

    static /* synthetic */ Map lambda$getReactModuleInfoProvider$0() {
        HashMap hashMap = new HashMap();
        hashMap.put("RNGoogleSignin", new ReactModuleInfo("RNGoogleSignin", "RNGoogleSignin", false, false, true, false, false));
        hashMap.put(NativeOneTapSignInSpec.NAME, new ReactModuleInfo(NativeOneTapSignInSpec.NAME, NativeOneTapSignInSpec.NAME, false, false, false, false, false));
        return hashMap;
    }

    @Override // com.facebook.react.TurboReactPackage, com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new RNGoogleSigninButtonViewManager());
    }
}
