package com.swmansion.reanimated.layoutReanimation;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.soloader.SoLoader;
import com.swmansion.reanimated.ReanimatedModule;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes5.dex */
public class LayoutAnimations {
    private final WeakReference<ReactApplicationContext> mContext;
    private WeakReference<AnimationsManager> mWeakAnimationsManager = new WeakReference<>(null);
    private final HybridData mHybridData = initHybrid();

    public static class Types {
        static final int ENTERING = 1;
        static final int EXITING = 2;
        static final int LAYOUT = 3;
        static final int SHARED_ELEMENT_TRANSITION = 4;
        static final int SHARED_ELEMENT_TRANSITION_PROGRESS = 5;
    }

    private native HybridData initHybrid();

    public native void cancelAnimationForTag(int i);

    public native void checkDuplicateSharedTag(int i, int i2);

    public native void clearAnimationConfigForTag(int i);

    public native int findPrecedingViewTagForTransition(int i);

    public native boolean hasAnimationForTag(int i, int i2);

    public native boolean isLayoutAnimationEnabled();

    public native boolean shouldAnimateExiting(int i, boolean z);

    public native void startAnimationForTag(int i, int i2, Map<String, String> map);

    static {
        SoLoader.loadLibrary("reanimated");
    }

    public LayoutAnimations(ReactApplicationContext reactApplicationContext) {
        this.mContext = new WeakReference<>(reactApplicationContext);
    }

    private void endLayoutAnimation(int i, boolean z) {
        AnimationsManager animationsManager = getAnimationsManager();
        if (animationsManager == null) {
            return;
        }
        animationsManager.endLayoutAnimation(i, z);
    }

    private void progressLayoutAnimation(int i, Map<String, Object> map, boolean z) {
        AnimationsManager animationsManager = getAnimationsManager();
        if (animationsManager == null) {
            return;
        }
        animationsManager.progressLayoutAnimation(i, map, z);
    }

    private AnimationsManager getAnimationsManager() {
        if (this.mWeakAnimationsManager.get() != null) {
            return this.mWeakAnimationsManager.get();
        }
        ReactApplicationContext reactApplicationContext = this.mContext.get();
        if (reactApplicationContext == null) {
            return null;
        }
        AnimationsManager animationsManager = ((ReanimatedModule) reactApplicationContext.getNativeModule(ReanimatedModule.class)).getNodesManager().getAnimationsManager();
        this.mWeakAnimationsManager = new WeakReference<>(animationsManager);
        return animationsManager;
    }
}
