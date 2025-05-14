package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class FullyConnectedOptionsT {
    private byte fusedActivationFunction = 0;
    private byte weightsFormat = 0;
    private boolean keepNumDims = false;
    private boolean asymmetricQuantizeInputs = false;

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }

    public byte getWeightsFormat() {
        return this.weightsFormat;
    }

    public void setWeightsFormat(byte b) {
        this.weightsFormat = b;
    }

    public boolean getKeepNumDims() {
        return this.keepNumDims;
    }

    public void setKeepNumDims(boolean z) {
        this.keepNumDims = z;
    }

    public boolean getAsymmetricQuantizeInputs() {
        return this.asymmetricQuantizeInputs;
    }

    public void setAsymmetricQuantizeInputs(boolean z) {
        this.asymmetricQuantizeInputs = z;
    }
}
