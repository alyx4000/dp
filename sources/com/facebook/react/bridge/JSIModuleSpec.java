package com.facebook.react.bridge;

import com.facebook.react.bridge.JSIModule;

/* loaded from: classes3.dex */
public interface JSIModuleSpec<T extends JSIModule> {
    JSIModuleProvider<T> getJSIModuleProvider();

    JSIModuleType getJSIModuleType();
}
