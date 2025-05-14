package com.quantummetric.reactnative;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

/* loaded from: classes5.dex */
public class QuantumViewManager extends ViewGroupManager<QuantumView> {
    public static final String NAME = "QuantumComponent";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public QuantumView createViewInstance(ThemedReactContext themedReactContext) {
        return new QuantumView(themedReactContext);
    }

    @ReactProp(name = "privacy")
    public void setPrivacy(QuantumView quantumView, String str) {
        quantumView.setPrivacy(str);
    }

    @ReactProp(name = "metadata")
    public void setMetadata(QuantumView quantumView, ReadableMap readableMap) {
        quantumView.setMetadata(readableMap);
    }
}
