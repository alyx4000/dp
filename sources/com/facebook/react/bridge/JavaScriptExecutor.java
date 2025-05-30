package com.facebook.react.bridge;

import com.facebook.jni.HybridData;

/* loaded from: classes3.dex */
public abstract class JavaScriptExecutor {
    private final HybridData mHybridData;

    public abstract String getName();

    protected JavaScriptExecutor(HybridData hybridData) {
        this.mHybridData = hybridData;
    }

    public void close() {
        this.mHybridData.resetNative();
    }
}
