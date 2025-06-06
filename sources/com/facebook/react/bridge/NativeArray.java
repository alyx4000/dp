package com.facebook.react.bridge;

import com.facebook.jni.HybridData;

/* loaded from: classes3.dex */
public abstract class NativeArray implements NativeArrayInterface {
    private HybridData mHybridData;

    @Override // com.facebook.react.bridge.NativeArrayInterface
    public native String toString();

    static {
        ReactBridge.staticInit();
    }

    protected NativeArray(HybridData hybridData) {
        this.mHybridData = hybridData;
    }
}
