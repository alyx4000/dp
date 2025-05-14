package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class SVDFOptionsT {
    private int rank = 0;
    private byte fusedActivationFunction = 0;
    private boolean asymmetricQuantizeInputs = false;

    public int getRank() {
        return this.rank;
    }

    public void setRank(int i) {
        this.rank = i;
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
