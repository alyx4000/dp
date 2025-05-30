package com.facebook.react.uimanager;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.soloader.SoLoader;

/* loaded from: classes3.dex */
public class UIConstantsProviderManager {
    private final HybridData mHybridData;

    private native HybridData initHybrid(RuntimeExecutor runtimeExecutor, Object obj);

    private native void installJSIBindings();

    static {
        staticInit();
    }

    public UIConstantsProviderManager(RuntimeExecutor runtimeExecutor, Object obj) {
        this.mHybridData = initHybrid(runtimeExecutor, obj);
        installJSIBindings();
    }

    private static void staticInit() {
        SoLoader.loadLibrary("uimanagerjni");
    }
}
