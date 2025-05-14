package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class AddOptionsT {
    private byte fusedActivationFunction = 0;
    private boolean potScaleInt16 = true;

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }

    public boolean getPotScaleInt16() {
        return this.potScaleInt16;
    }

    public void setPotScaleInt16(boolean z) {
        this.potScaleInt16 = z;
    }
}
