package com.facebook.react.fabric;

import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.uimanager.StateWrapper;

/* loaded from: classes3.dex */
public class StateWrapperImpl implements StateWrapper {
    private static final String TAG = "StateWrapperImpl";
    private volatile boolean mDestroyed = false;
    private final HybridData mHybridData = initHybrid();

    private native ReadableNativeMap getStateDataImpl();

    private native ReadableMapBuffer getStateMapBufferDataImpl();

    private static native HybridData initHybrid();

    public native void updateStateImpl(NativeMap nativeMap);

    static {
        FabricSoLoader.staticInit();
    }

    private StateWrapperImpl() {
    }

    @Override // com.facebook.react.uimanager.StateWrapper
    public ReadableMapBuffer getStateDataMapBuffer() {
        if (this.mDestroyed) {
            FLog.e(TAG, "Race between StateWrapperImpl destruction and getState");
            return null;
        }
        return getStateMapBufferDataImpl();
    }

    @Override // com.facebook.react.uimanager.StateWrapper
    public ReadableNativeMap getStateData() {
        if (this.mDestroyed) {
            FLog.e(TAG, "Race between StateWrapperImpl destruction and getState");
            return null;
        }
        return getStateDataImpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.facebook.react.uimanager.StateWrapper
    public void updateState(WritableMap writableMap) {
        if (this.mDestroyed) {
            FLog.e(TAG, "Race between StateWrapperImpl destruction and updateState");
        } else {
            updateStateImpl((NativeMap) writableMap);
        }
    }

    @Override // com.facebook.react.uimanager.StateWrapper
    public void destroyState() {
        if (this.mDestroyed) {
            return;
        }
        this.mDestroyed = true;
        this.mHybridData.resetNative();
    }
}
