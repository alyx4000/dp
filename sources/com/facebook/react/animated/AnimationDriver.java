package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
abstract class AnimationDriver {
    ValueAnimatedNode mAnimatedValue;
    Callback mEndCallback;
    boolean mHasFinished = false;
    int mId;

    public abstract void runAnimationStep(long j);

    AnimationDriver() {
    }

    public void resetConfig(ReadableMap readableMap) {
        throw new JSApplicationCausedNativeException("Animation config for " + getClass().getSimpleName() + " cannot be reset");
    }
}
