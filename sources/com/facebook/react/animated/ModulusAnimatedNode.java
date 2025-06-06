package com.facebook.react.animated;

import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes3.dex */
class ModulusAnimatedNode extends ValueAnimatedNode {
    private final int mInputNode;
    private final double mModulus;
    private final NativeAnimatedNodesManager mNativeAnimatedNodesManager;

    public ModulusAnimatedNode(ReadableMap readableMap, NativeAnimatedNodesManager nativeAnimatedNodesManager) {
        this.mNativeAnimatedNodesManager = nativeAnimatedNodesManager;
        this.mInputNode = readableMap.getInt("input");
        this.mModulus = readableMap.getDouble("modulus");
    }

    @Override // com.facebook.react.animated.AnimatedNode
    public void update() {
        AnimatedNode nodeById = this.mNativeAnimatedNodesManager.getNodeById(this.mInputNode);
        if (nodeById != null && (nodeById instanceof ValueAnimatedNode)) {
            double value = ((ValueAnimatedNode) nodeById).getValue();
            double d = this.mModulus;
            this.mValue = ((value % d) + d) % d;
            return;
        }
        throw new JSApplicationCausedNativeException("Illegal node ID set as an input for Animated.modulus node");
    }

    @Override // com.facebook.react.animated.ValueAnimatedNode, com.facebook.react.animated.AnimatedNode
    public String prettyPrint() {
        return "NativeAnimatedNodesManager[" + this.mTag + "] inputNode: " + this.mInputNode + " modulus: " + this.mModulus + " super: " + super.prettyPrint();
    }
}
