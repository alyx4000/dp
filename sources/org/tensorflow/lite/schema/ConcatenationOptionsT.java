package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class ConcatenationOptionsT {
    private int axis = 0;
    private byte fusedActivationFunction = 0;

    public int getAxis() {
        return this.axis;
    }

    public void setAxis(int i) {
        this.axis = i;
    }

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }
}
