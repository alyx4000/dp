package org.tensorflow.lite.schema;

/* loaded from: classes6.dex */
public class BidirectionalSequenceLSTMOptionsT {
    private byte fusedActivationFunction = 0;
    private float cellClip = 0.0f;
    private float projClip = 0.0f;
    private boolean mergeOutputs = false;
    private boolean timeMajor = true;
    private boolean asymmetricQuantizeInputs = false;

    public byte getFusedActivationFunction() {
        return this.fusedActivationFunction;
    }

    public void setFusedActivationFunction(byte b) {
        this.fusedActivationFunction = b;
    }

    public float getCellClip() {
        return this.cellClip;
    }

    public void setCellClip(float f) {
        this.cellClip = f;
    }

    public float getProjClip() {
        return this.projClip;
    }

    public void setProjClip(float f) {
        this.projClip = f;
    }

    public boolean getMergeOutputs() {
        return this.mergeOutputs;
    }

    public void setMergeOutputs(boolean z) {
        this.mergeOutputs = z;
    }

    public boolean getTimeMajor() {
        return this.timeMajor;
    }

    public void setTimeMajor(boolean z) {
        this.timeMajor = z;
    }

    public boolean getAsymmetricQuantizeInputs() {
        return this.asymmetricQuantizeInputs;
    }

    public void setAsymmetricQuantizeInputs(boolean z) {
        this.asymmetricQuantizeInputs = z;
    }
}
