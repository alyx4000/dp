package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class SequenceRNNOptionsT {
    private boolean timeMajor = false;
    private byte fusedActivationFunction = 0;
    private boolean asymmetricQuantizeInputs = false;

    public boolean getTimeMajor() {
        return this.timeMajor;
    }

    public void setTimeMajor(boolean z) {
        this.timeMajor = z;
    }

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
