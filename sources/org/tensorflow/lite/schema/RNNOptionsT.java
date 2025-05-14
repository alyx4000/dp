package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class RNNOptionsT {
    private byte fusedActivationFunction = 0;
    private boolean asymmetricQuantizeInputs = false;

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }

    public boolean getAsymmetricQuantizeInputs() {
        return this.asymmetricQuantizeInputs;
    }

    public void setAsymmetricQuantizeInputs(boolean z) {
        this.asymmetricQuantizeInputs = z;
    }
}
