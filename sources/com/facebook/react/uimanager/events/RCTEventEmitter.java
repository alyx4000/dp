package com.facebook.react.uimanager.events;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;

@Deprecated
/* loaded from: classes3.dex */
public interface RCTEventEmitter extends JavaScriptModule {
    @Deprecated
    void receiveEvent(int i, String str, WritableMap writableMap);

    void receiveTouches(String str, WritableArray writableArray, WritableArray writableArray2);
}
